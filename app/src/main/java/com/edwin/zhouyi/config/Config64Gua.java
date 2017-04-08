package com.edwin.zhouyi.config;

import java.util.ArrayList;
import java.util.List;

/**
 * <describe>
 * </describe>
 * Created by edwin on 2017/4/8.
 */

public class Config64Gua {

    public static final int[][] _64 = new int[][]{
            new int[]{1, 43, 14, 34, 9, 5, 26, 11}
            , new int[]{10, 58, 38, 54, 61, 60, 41, 19}
            , new int[]{13, 49, 30, 55, 37, 63, 22, 36}
            , new int[]{25, 17, 21, 51, 42, 3, 27, 24}
            , new int[]{44, 28, 50, 32, 57, 48, 18, 46}
            , new int[]{6, 47, 64, 40, 59, 29, 4, 7}
            , new int[]{33, 31, 56, 62, 53, 39, 52, 15}
            , new int[]{12, 45, 35, 16, 20, 8, 23, 2}
    };

    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list.contains(_64[i][j]))
                    throw new NullPointerException();
                list.add(_64[i][j]);
            }
        }
    }
}
