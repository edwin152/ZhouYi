package com.edwin.zhouyi.cache;

/**
 * simple describe
 *
 * @author edwin
 * @since 27/12/2017
 */
public class CacheFactory {

    private static HexagramCache hexagramCache;

    public static HexagramCache getHexagramCache() {
        if (hexagramCache == null) {
            hexagramCache = new HexagramCache();
        }
        return hexagramCache;
    }

    public static void reset() {
        hexagramCache = null;
    }

}
