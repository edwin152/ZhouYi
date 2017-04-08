package com.edwin.zhouyi.enums;

/**
 * <describe>
 * </describe>
 * Created by edwin on 2017/3/25.
 */

public enum Diagram8 {
    //1
    QIAN,
    //2
    DUI,
    //3
    LI,
    //4
    ZHEN,
    //5
    XUN,
    //6
    KAN,
    //7
    GEN,
    //8
    KUN;

    public static Diagram8 parse(Integer i) {
        if (i == null || i >= values().length || i < 0)
            return null;
        return values()[i];
    }
}
