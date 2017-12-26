package com.edwin.lib.cache.disk;

import java.util.concurrent.Executor;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/5/22
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
