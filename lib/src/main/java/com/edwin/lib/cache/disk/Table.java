package com.edwin.lib.cache.disk;

import com.edwin.lib.cache.Cache;

import java.util.List;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public interface Table<K, V> extends Cache {

    long insert(V value);

    boolean insertInTx(List<V> list);

    long insertOrReplace(V value);

    boolean insertOrReplaceInTx(List<V> list);

    long delete(V value);

    long deleteByKey(K key);

    boolean deleteAll();

    long update(V value);

    boolean updateInTx(List<V> list);

    V queryByKey(K key);

    List<V> queryAll();
}
