package kinoko.world.user.stat;

import kinoko.server.packet.OutPacket;
import kinoko.util.Encodable;
import kinoko.util.Util;
import kinoko.world.GameConstants;
import kinoko.world.job.JobConstants;

import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;

public final class CharacterStat implements Encodable {
    private int id;
    private String name;
    private byte gender;
    private byte skin;
    private int face;
    private int hair;
    private short level; // encoded as unsigned byte
    private short job;
    private short subJob;
    private short baseStr;
    private short baseDex;
    private short baseInt;
    private short baseLuk;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private short ap;
    private ExtendSp sp;
    private int exp;
    private int pop;
    private int posMap;
    private byte portal;
    private long petSn1;
    private long petSn2;
    private long petSn3;
    private byte fatigue;
    private int charismaExp;
    private int insightExp;
    private int willpowerExp;
    private int craftExp;
    private int senseExp;
    private int charmExp;
    private int pvpExp;
    private byte pvpGrade;
    private int pvpPoint;
    private byte pvpLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public byte getSkin() {
        return skin;
    }

    public void setSkin(byte skin) {
        this.skin = skin;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getHair() {
        return hair;
    }

    public void setHair(int hair) {
        this.hair = hair;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public short getJob() {
        return job;
    }

    public void setJob(short job) {
        this.job = job;
    }

    public short getSubJob() {
        return subJob;
    }

    public void setSubJob(short subJob) {
        this.subJob = subJob;
    }

    public short getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(short baseStr) {
        this.baseStr = baseStr;
    }

    public short getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(short baseDex) {
        this.baseDex = baseDex;
    }

    public short getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(short baseInt) {
        this.baseInt = baseInt;
    }

    public short getBaseLuk() {
        return baseLuk;
    }

    public void setBaseLuk(short baseLuk) {
        this.baseLuk = baseLuk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public short getAp() {
        return ap;
    }

    public void setAp(short ap) {
        this.ap = ap;
    }

    public ExtendSp getSp() {
        return sp;
    }

    public void setSp(ExtendSp sp) {
        this.sp = sp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getPosMap() {
        return posMap;
    }

    public void setPosMap(int posMap) {
        this.posMap = posMap;
    }

    public byte getPortal() {
        return portal;
    }

    public void setPortal(byte portal) {
        this.portal = portal;
    }

    public long getPetSn1() {
        return petSn1;
    }

    public void setPetSn1(long petSn1) {
        this.petSn1 = petSn1;
    }

    public long getPetSn2() {
        return petSn2;
    }

    public void setPetSn2(long petSn2) {
        this.petSn2 = petSn2;
    }

    public long getPetSn3() {
        return petSn3;
    }

    public void setPetSn3(long petSn3) {
        this.petSn3 = petSn3;
    }

    public byte getFatigue() {
        return fatigue;
    }

    public void setFatigue(byte fatigue) {
        this.fatigue = fatigue;
    }

    public int getCharismaExp() {
        return charismaExp;
    }

    public void setCharismaExp(int charismaExp) {
        this.charismaExp = charismaExp;
    }

    public int getInsightExp() {
        return insightExp;
    }

    public void setInsightExp(int insightExp) {
        this.insightExp = insightExp;
    }

    public int getWillpowerExp() {
        return willpowerExp;
    }

    public void setWillpowerExp(int willpowerExp) {
        this.willpowerExp = willpowerExp;
    }

    public int getCraftExp() {
        return craftExp;
    }

    public void setCraftExp(int craftExp) {
        this.craftExp = craftExp;
    }

    public int getSenseExp() {
        return senseExp;
    }

    public void setSenseExp(int senseExp) {
        this.senseExp = senseExp;
    }

    public int getCharmExp() {
        return charmExp;
    }

    public void setCharmExp(int charmExp) {
        this.charmExp = charmExp;
    }

    public void setPvpExp(int pvpExp) {
        this.pvpExp = pvpExp;
    }

    public int getPvpExp() {
        return pvpExp;
    }

    public void setPvpGrade(byte pvpGrade) {
        this.pvpGrade = pvpGrade;
    }

    public byte getPvpGrade() {
        return pvpGrade;
    }

    public void setPvpPoint(int pvpPoint) {
        this.pvpPoint = pvpPoint;
    }

    public int getPvpPoint() {
        return pvpPoint;
    }

    public void setPvpLevel(byte pvpLevel) {
        this.pvpLevel = pvpLevel;
    }

    public byte getPvpLevel() {
        return pvpLevel;
    }


    // HELPER METHODS --------------------------------------------------------------------------------------------------

    public boolean isValidAp(Stat stat, int delta) {
        switch (stat) {
            case STR -> {
                final int value = getBaseStr() + delta;
                return value >= GameConstants.STAT_MIN && value <= GameConstants.STAT_MAX;
            }
            case DEX -> {
                final int value = getBaseDex() + delta;
                return value >= GameConstants.STAT_MIN && value <= GameConstants.STAT_MAX;
            }
            case INT -> {
                final int value = getBaseInt() + delta;
                return value >= GameConstants.STAT_MIN && value <= GameConstants.STAT_MAX;
            }
            case LUK -> {
                final int value = getBaseLuk() + delta;
                return value >= GameConstants.STAT_MIN && value <= GameConstants.STAT_MAX;
            }
            case MHP -> {
                final int value = getMaxHp() + (delta * StatConstants.getIncHpByAp(getJob()));
                return value >= StatConstants.getMinHp(getLevel(), getJob()) && value <= GameConstants.HP_MAX;
            }
            case MMP -> {
                final int value = getMaxMp() + (delta * StatConstants.getIncMpByAp(getJob()));
                return value >= StatConstants.getMinMp(getLevel(), getJob()) && value <= GameConstants.MP_MAX;
            }
        }
        return false;
    }

    public Map<Stat, Object> addAp(Stat stat, int totalInt) {
        final Map<Stat, Object> statMap = new EnumMap<>(Stat.class);
        switch (stat) {
            case STR -> {
                setBaseStr((short) Math.min(getBaseStr() + 1, GameConstants.STAT_MAX));
                statMap.put(Stat.STR, getBaseStr());
            }
            case DEX -> {
                setBaseDex((short) Math.min(getBaseDex() + 1, GameConstants.STAT_MAX));
                statMap.put(Stat.DEX, getBaseDex());
            }
            case INT -> {
                setBaseInt((short) Math.min(getBaseInt() + 1, GameConstants.STAT_MAX));
                statMap.put(Stat.INT, getBaseInt());
            }
            case LUK -> {
                setBaseLuk((short) Math.min(getBaseLuk() + 1, GameConstants.STAT_MAX));
                statMap.put(Stat.LUK, getBaseLuk());
            }
            case MHP -> {
                final int incHp = StatConstants.getIncHpByAp(getJob()) + Util.getRandom(StatConstants.INC_HP_VARIANCE);
                setMaxHp(Math.min(getMaxHp() + incHp, GameConstants.HP_MAX));
                statMap.put(Stat.MHP, getMaxHp());
            }
            case MMP -> {
                final int incMp = StatConstants.getIncMpByAp(getJob()) + Util.getRandom(StatConstants.INC_MP_VARIANCE) + (totalInt / 10);
                setMaxMp(Math.min(getMaxMp() + incMp, GameConstants.MP_MAX));
                statMap.put(Stat.MMP, getMaxMp());
            }
        }
        return statMap;
    }

    public Map<Stat, Object> removeAp(Stat stat) {
        final Map<Stat, Object> statMap = new EnumMap<>(Stat.class);
        switch (stat) {
            case STR -> {
                setBaseStr((short) Math.max(getBaseStr() - 1, GameConstants.STAT_MIN));
                statMap.put(Stat.STR, getBaseStr());
            }
            case DEX -> {
                setBaseDex((short) Math.max(getBaseDex() - 1, GameConstants.STAT_MIN));
                statMap.put(Stat.DEX, getBaseDex());
            }
            case INT -> {
                setBaseInt((short) Math.max(getBaseInt() - 1, GameConstants.STAT_MIN));
                statMap.put(Stat.INT, getBaseInt());
            }
            case LUK -> {
                setBaseLuk((short) Math.max(getBaseLuk() - 1, GameConstants.STAT_MIN));
                statMap.put(Stat.LUK, getBaseLuk());
            }
            case MHP -> {
                setMaxHp(Math.max(getMaxHp() - StatConstants.getIncHpByAp(getJob()), StatConstants.getMinHp(getLevel(), getJob())));
                statMap.put(Stat.MHP, getMaxHp());
            }
            case MMP -> {
                setMaxMp(Math.max(getMaxMp() - StatConstants.getIncMpByAp(getJob()), StatConstants.getMinMp(getLevel(), getJob())));
                statMap.put(Stat.MMP, getMaxMp());
            }
        }
        return statMap;
    }

    public Map<Stat, Object> addExp(int delta, int totalInt) {
        final Map<Stat, Object> statMap = new EnumMap<>(Stat.class);
        if (getLevel() >= GameConstants.getLevelMax(job)) {
            return statMap;
        }
        long newExp = ((long) getExp()) + delta;
        while (newExp >= GameConstants.getNextLevelExp(getLevel())) {
            newExp -= GameConstants.getNextLevelExp(getLevel());
            statMap.putAll(levelUp(totalInt));
        }
        setExp((int) newExp);
        statMap.put(Stat.EXP, (int) newExp);
        return statMap;
    }

    public Map<Stat, Object> levelUp(int totalInt) {
        final Map<Stat, Object> statMap = new EnumMap<>(Stat.class);
        if (getLevel() >= GameConstants.getLevelMax(job)) {
            return statMap;
        }
        // Update level
        setLevel((short) (getLevel() + 1));
        statMap.put(Stat.LEVEL, (byte) getLevel());
        // Update max hp
        final int incHp = StatConstants.getIncHp(getJob()) + Util.getRandom(StatConstants.INC_HP_VARIANCE);
        setMaxHp(Math.min(getMaxHp() + incHp, GameConstants.HP_MAX));
        statMap.put(Stat.MHP, getMaxHp());
        // Update max mp
        final int incMp = StatConstants.getIncMp(getJob()) + Util.getRandom(StatConstants.INC_MP_VARIANCE) + (totalInt / 10);
        setMaxMp(Math.min(getMaxMp() + incMp, GameConstants.MP_MAX));
        statMap.put(Stat.MMP, getMaxMp());
        // Update ap (auto distribution for beginners)
        if (JobConstants.isBeginnerJob(getJob()) && getLevel() <= 11) {
            if (getLevel() <= 6) {
                setBaseStr((short) (getBaseStr() + 5));
                statMap.put(Stat.STR, getBaseStr());
            } else {
                setBaseStr((short) (getBaseStr() + 4));
                statMap.put(Stat.STR, getBaseStr());
                setBaseDex((short) (getBaseDex() + 4));
                statMap.put(Stat.DEX, getBaseDex());
            }
        } else {
            setAp((short) (getAp() + StatConstants.getIncAp(getLevel(), getJob())));
            statMap.put(Stat.AP, getAp());
        }
        // Update sp
        if (!JobConstants.isBeginnerJob(getJob())) {
            if (JobConstants.isExtendSpJob(getJob())) {
                final int jobLevel = JobConstants.getExtendSpJobLevel(getJob(), getLevel());
                getSp().addSp(jobLevel, 3);
                statMap.put(Stat.SP, getSp());
            } else {
                getSp().addNonExtendSp(3);
                statMap.put(Stat.SP, (short) getSp().getNonExtendSp());
            }
        }
        return statMap;
    }

    public long getCumulativeExp() {
        long levelExp = 0;
        for (int level = 1; level < getLevel(); level++) {
            levelExp += GameConstants.getNextLevelExp(level);
        }
        return levelExp + getExp();
    }

    @Override
    public void encode(OutPacket outPacket) {
        outPacket.encodeInt(id); // dwCharacterID
        outPacket.encodeString(name, 13); // sCharacterName
        outPacket.encodeByte(gender); // nGender
        outPacket.encodeByte(skin); // nSkin
        outPacket.encodeInt(face); // nFace
        outPacket.encodeInt(hair); // nHair

        // aliPetLockerSN
        outPacket.encodeLong(petSn1);
        outPacket.encodeLong(petSn2);
        outPacket.encodeLong(petSn3);

        outPacket.encodeByte(level); // nLevel
        outPacket.encodeShort(job); // nJob
        outPacket.encodeShort(baseStr); // nSTR
        outPacket.encodeShort(baseDex); // nDEX
        outPacket.encodeShort(baseInt); // nINT
        outPacket.encodeShort(baseLuk); // nLUK
        outPacket.encodeInt(hp); // nHP
        outPacket.encodeInt(maxHp); // nMHP
        outPacket.encodeInt(mp); // nMP
        outPacket.encodeInt(maxMp); // nMMP
        outPacket.encodeShort(ap); // nAP
        if (JobConstants.isExtendSpJob(job)) {
            sp.encode(outPacket);
        } else {
            outPacket.encodeShort((short) sp.getNonExtendSp());
        }

        outPacket.encodeInt(exp); // nEXP
        outPacket.encodeInt(pop); // nPOP
        outPacket.encodeInt(0); // nTempEXP
        outPacket.encodeInt(posMap); // dwPosMap
        outPacket.encodeByte(portal); // nPortal
        outPacket.encodeInt(0); // nPlayTime
        outPacket.encodeShort(subJob); // nSubJob

        outPacket.encodeByte(fatigue); // nFatigue
        outPacket.encodeInt(System.currentTimeMillis()); // nLastFatigueUpdateTime
        outPacket.encodeInt(charismaExp); // nCharismaEXP
        outPacket.encodeInt(insightExp); // nInsightEXP
        outPacket.encodeInt(willpowerExp); // nWillEXP
        outPacket.encodeInt(craftExp); // nCraftEXP
        outPacket.encodeInt(senseExp); // nSenseEXP
        outPacket.encodeInt(charmExp); // nCharmEXP
        outPacket.encodeArray(new byte[0xC]); // DayLimit
        outPacket.encodeInt(pvpExp); // nPvPExp
        outPacket.encodeByte(pvpGrade); // nPvPGrade
        outPacket.encodeInt(pvpPoint); // nPvPPoint
        outPacket.encodeByte(pvpLevel); // nPvPModeLevel
    }
}
