package com.edwin.lib.cache.disk;

import java.util.concurrent.Executor;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public abstract class AbstractTable<K, V> implements Table<K, V> {

    private Executor threadPool;

    public AbstractTable(Executor threadPool) {
        this.threadPool = threadPool;
    }

    public Executor getThreadPool() {
        return threadPool;
    }
}
