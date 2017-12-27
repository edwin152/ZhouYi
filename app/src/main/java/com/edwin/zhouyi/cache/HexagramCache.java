package com.edwin.zhouyi.cache;

import android.util.SparseArray;

import com.edwin.zhouyi.model.HexagramWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * simple describe
 *
 * @author edwin
 * @since 27/12/2017
 */
public class HexagramCache {

    private SparseArray<HexagramWords> list;

    public HexagramCache() {
        list = new SparseArray<>(64);
    }

    public synchronized boolean init() {
        boolean success;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file:///android_asset/_64"));
            String line;
            for (Integer i = 1; i <= 64; i++) {
                while(true) {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }


                }
            }
            success = true;
        } catch (IOException ignore) {
            success = false;
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public synchronized HexagramWords get(int key) {
        return list.get(key);
    }
}
