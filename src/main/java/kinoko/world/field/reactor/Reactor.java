package kinoko.world.field.reactor;

import kinoko.provider.ItemProvider;
import kinoko.provider.RewardProvider;
import kinoko.provider.item.ItemInfo;
import kinoko.provider.map.ReactorInfo;
import kinoko.provider.reactor.ReactorEvent;
import kinoko.provider.reactor.ReactorTemplate;
import kinoko.provider.reward.Reward;
import kinoko.server.event.EventScheduler;
import kinoko.server.script.ScriptDispatcher;
import kinoko.util.Lockable;
import kinoko.util.Util;
import kinoko.world.GameConstants;
import kinoko.world.field.FieldObjectImpl;
import kinoko.world.field.drop.Drop;
import kinoko.world.field.drop.DropEnterType;
import kinoko.world.field.drop.DropLeaveType;
import kinoko.world.field.drop.DropOwnType;
import kinoko.world.item.Item;
import kinoko.world.user.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Reactor extends FieldObjectImpl implements Lockable<Reactor> {
    private final Lock lock = new ReentrantLock();
    private final ReactorTemplate template;
    private final ReactorInfo reactorInfo;
    private int state;

    public Reactor(ReactorTemplate template, ReactorInfo reactorInfo) {
        this.template = template;
        this.reactorInfo = reactorInfo;
        reset(reactorInfo.getX(), reactorInfo.getY(), 0);
    }

    public int getTemplateId() {
        return template.getId();
    }

    public boolean isNotHitable() {
        return template.isNotHitable();
    }

    public boolean isActivateByTouch() {
        return template.isActivateByTouch();
    }

    public String getAction() {
        return template.getAction();
    }

    public String getName() {
        return reactorInfo.getName();
    }

    public int getReactorTime() {
        return reactorInfo.getReactorTime();
    }

    public boolean isFlip() {
        return reactorInfo.isFlip();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    // HELPER METHODS --------------------------------------------------------------------------------------------------

    public boolean hasAction() {
        return getAction() != null && !getAction().isEmpty();
    }

    public boolean isLastState() {
        return getState() == template.getLastState();
    }

    public boolean tryHit(int skillId) {
        // Resolve reactor event
        final int state = getState();
        final Optional<ReactorEvent> hitEventResult = template.getHitEvent(state, skillId);
        if (hitEventResult.isEmpty()) {
            return false;
        }
        // Advance state
        final ReactorEvent hitEvent = hitEventResult.get();
        setState(hitEvent.getNextState());
        return true;
    }

    public void handleDrop(Drop drop) {
        // Ignore non-item drops
        if (drop.getItem() == null) {
            return;
        }
        // Resolve reactor event
        final int state = getState();
        final Optional<ReactorEvent> dropEventResult = template.getDropEvent(state, drop.getItem().getItemId(), drop.getX(), drop.getY());
        if (dropEventResult.isEmpty()) {
            return;
        }
        final ReactorEvent dropEvent = dropEventResult.get();
        // Check drop is within bounds
        if (!dropEvent.getRect().translate(getX(), getY()).isInsideRect(drop.getX(), drop.getY())) {
            return;
        }
        // Schedule event to consume drop and trigger event
        EventScheduler.addEvent(() -> {
            // Acquire and check state after delay
            try (var lockedReactor = this.acquire()) {
                final Reactor reactor = lockedReactor.get();
                if (reactor.getState() != state) {
                    return;
                }
                // Resolve user for script
                final Optional<User> userResult = reactor.getField().getUserPool().getNearestUser(reactor); // closest user to reactor
                if (userResult.isEmpty()) {
                    return;
                }
                // Try removing drop from field
                if (!reactor.getField().getDropPool().removeDrop(drop, DropLeaveType.TIMEOUT, 0, 0, 0)) {
                    return;
                }
                // Advance state and dispatch reactor script
                reactor.setState(dropEvent.getNextState());
                reactor.getField().getReactorPool().hitReactor(reactor, 0);
                if (reactor.isLastState() && reactor.hasAction()) {
                    ScriptDispatcher.startReactorScript(userResult.get(), reactor, reactor.getAction());
                }
            }
        }, GameConstants.REACTOR_DROP_DELAY, TimeUnit.SECONDS);
    }

    public void dropRewards(User owner) {
        // Create drops from possible rewards
        final Set<Drop> drops = new HashSet<>();
        final Set<Reward> possibleRewards = RewardProvider.getReactorRewards(this);
        for (Reward reward : possibleRewards) {
            // Quest drops
            if (reward.isQuest()) {
                if (!owner.getQuestManager().hasQuestStarted(reward.getQuestId())) {
                    continue;
                }
            }
            // Drop probability
            if (!Util.succeedDouble(reward.getProb())) {
                continue;
            }
            // Create drop
            if (reward.isMoney()) {
                final int money = Util.getRandom(reward.getMin(), reward.getMax());
                if (money <= 0) {
                    continue;
                }
                drops.add(Drop.money(DropOwnType.USEROWN, this, money, owner.getCharacterId()));
            } else {
                final Optional<ItemInfo> itemInfoResult = ItemProvider.getItemInfo(reward.getItemId());
                if (itemInfoResult.isEmpty()) {
                    continue;
                }
                final int quantity = Util.getRandom(reward.getMin(), reward.getMax());
                final Item item = itemInfoResult.get().createItem(owner.getNextItemSn(), quantity);
                drops.add(Drop.item(DropOwnType.USEROWN, this, item, owner.getCharacterId(), reward.getQuestId()));
            }
        }
        // Add drops to field
        getField().getDropPool().addDrops(drops, DropEnterType.CREATE, getX(), getY() - GameConstants.DROP_HEIGHT, 0);
    }

    public void reset(int x, int y, int state) {
        setX(x);
        setY(y);
        setState(state);
    }

    @Override
    public String toString() {
        return String.format("Reactor { %d, oid : %d, action : %s, state : %d }", getTemplateId(), getId(), getAction(), getState());
    }

    @Override
    public void lock() {
        lock.lock();
    }

    @Override
    public void unlock() {
        lock.unlock();
    }

    public static Reactor from(ReactorTemplate template, ReactorInfo reactorInfo) {
        return new Reactor(template, reactorInfo);
    }
}
