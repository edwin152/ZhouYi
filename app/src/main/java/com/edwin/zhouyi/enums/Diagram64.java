package com.edwin.zhouyi.enums;

/**
 * <describe>
 * </describe>
 * Created by edwin on 2017/3/25.
 */

public enum Diagram64 {
    //1
    QIAN,
    //44
    GOU;


    public static Diagram64 parse(Integer i) {
        if (i == null || i >= values().length || i < 0)
            return null;
        return values()[i];
    }

    public static Diagram64 parse(String name) {
        if (name == null)
            return null;
        return valueOf(name);
    }

}
