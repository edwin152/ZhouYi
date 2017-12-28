package com.edwin.zhouyi.enums;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public enum Diagram {
    QIAN,
    DUI,
    LI,
    ZHEN,
    XUN,
    KAN,
    GEN,
    KUN;

    public static Diagram parse(Integer i) {
        if (i == null || i >= values().length || i < 0) {
            return null;
        }
        return values()[i];
    }

    public static Diagram parse(String s) {
        if (s == null) {
            return null;
        }
        switch (s) {
            case "乾":
                return QIAN;
            case "兑":
                return DUI;
            case "离":
                return LI;
            case "震":
                return ZHEN;
            case "巽":
                return XUN;
            case "坎":
                return KAN;
            case "艮":
                return GEN;
            case "坤":
                return KUN;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case QIAN:
                return "乾";
            case DUI:
                return "兑";
            case LI:
                return "离";
            case ZHEN:
                return "震";
            case XUN:
                return "巽";
            case KAN:
                return "坎";
            case GEN:
                return "艮";
            case KUN:
                return "坤";
            default:
                return super.toString();
        }
    }
}
