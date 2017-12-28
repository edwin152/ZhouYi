package com.edwin.zhouyi.cache;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

import com.edwin.zhouyi.enums.Diagram;
import com.edwin.zhouyi.model.HexagramWords;
import com.edwin.zhouyi.model.Words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * simple describe
 *
 * @author edwin
 * @since 27/12/2017
 */
public class HexagramCache {

    private static final String LOG_TAG = HexagramCache.class.getSimpleName();

    private SparseArray<HexagramWords> list;

    public HexagramCache() {
        list = new SparseArray<>(64);
    }

    public synchronized void init(Context context) {
        if (list != null && list.size() == 64) {
            return;
        }
        BufferedReader reader = null;
        try {
            InputStream is = context.getAssets().open("_64");
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            Integer num = 1;
            HexagramWords hexagramWords;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (!line.equals(num.toString())) {
                    continue;
                }
                hexagramWords = new HexagramWords(num);
                Log.d(LOG_TAG, "create new HexagramWords.");
                Log.d(LOG_TAG, num.toString());

                line = reader.readLine();
                hexagramWords.setTitle(line);
                Log.d(LOG_TAG, line);

                line = reader.readLine();
                Diagram upDiagram = Diagram.parse(line.substring(0, 1));
                Diagram downDiagram = Diagram.parse(line.substring(2, 3));
                hexagramWords.setUpDiagram(upDiagram);
                hexagramWords.setDownDiagram(downDiagram);
                Log.d(LOG_TAG, "上" + upDiagram + "下" + downDiagram);

                boolean yang;
                String str;
                String expStr;

                line = reader.readLine();
                str = line.substring(line.indexOf(":") + 1);
                line = reader.readLine();
                expStr = line.substring(3);
                Words main = new Words(Words.NUMBER_NULL, str, expStr);
                hexagramWords.setMain(main);
                Log.d(LOG_TAG, hexagramWords.getTitle() + main.toString());

                line = reader.readLine();
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words first = new Words(Words.NUMBER_FIRST, yang, str, expStr);
                hexagramWords.setFirst(first);
                Log.d(LOG_TAG, first.toString());

                line = reader.readLine();
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words second = new Words(Words.NUMBER_SECOND, yang, str, expStr);
                hexagramWords.setSecond(second);
                Log.d(LOG_TAG, second.toString());

                line = reader.readLine();
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words third = new Words(Words.NUMBER_THIRD, yang, str, expStr);
                hexagramWords.setThird(third);
                Log.d(LOG_TAG, third.toString());

                line = reader.readLine();
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words fourth = new Words(Words.NUMBER_FOURTH, yang, str, expStr);
                hexagramWords.setFourth(fourth);
                Log.d(LOG_TAG, fourth.toString());

                line = reader.readLine();
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words fifth = new Words(Words.NUMBER_FIFTH, yang, str, expStr);
                hexagramWords.setFifth(fifth);
                Log.d(LOG_TAG, fifth.toString());

                line = reader.readLine();
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words sixth = new Words(Words.NUMBER_SIXTH, yang, str, expStr);
                hexagramWords.setSixth(sixth);
                Log.d(LOG_TAG, sixth.toString());

                line = reader.readLine();
                num++;
                if (line == null) {
                    break;
                }
                line = line.trim();
                if (line.equals("\n") || line.equals("\r") || line.equals("")) {
                    continue;
                }
                yang = line.substring(0, 2).contains("九");
                str = line.substring(3);
                line = reader.readLine();
                expStr = line.substring(3);
                Words use = new Words(Words.NUMBER_USE, yang, str, expStr);
                hexagramWords.setUse(use);
                Log.d(LOG_TAG, use.toString());
            }
        } catch (IOException ignore) {
            throw new RuntimeException("file load error.\n" + ignore.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized HexagramWords get(int key) {
        return list.get(key);
    }
}
