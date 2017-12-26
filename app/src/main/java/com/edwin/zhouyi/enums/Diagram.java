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
}
