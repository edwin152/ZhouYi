package com.edwin.lib.cache;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class ThreadPoolFactory {

    public static Executor newTreadPool() {
        return Executors.newCachedThreadPool();
    }

    public static Executor newSingleTreadPool() {
        return Executors.newSingleThreadExecutor();
    }

    public static Executor newFixThreadPool(int i) {
        if (i <= 0) {
            throw new RuntimeException("i <= 0");
        }
        return Executors.newFixedThreadPool(i);
    }

}
