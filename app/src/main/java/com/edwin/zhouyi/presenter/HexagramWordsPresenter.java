package com.edwin.zhouyi.presenter;

import android.content.res.AssetManager;

import com.edwin.lib.mvp.MVPPresenter;
import com.edwin.zhouyi.view.HexagramWordsActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * simple describe 爻词
 *
 * @author edwin
 * @since 26/12/2017
 */
public class HexagramWordsPresenter extends MVPPresenter {

    private HexagramWordsActivity activity;

    public HexagramWordsPresenter(HexagramWordsActivity activity) {
        this.activity = activity;
    }

    @Override
    public void start() {
        List<String> list = getList();
        activity.setList(list);
        int yao = getYao();
        activity.setYao(yao);
    }

    private List<String> getList() {
        Integer startNum = activity.getIntent().getIntExtra("num", -1);
        Integer endNum = startNum + 1;
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        AssetManager manager = activity.getAssets();
        try {
            InputStream stream = manager.open("_64");
            reader = new BufferedReader(new InputStreamReader(stream));
            boolean start = false;
            String msg;
            while ((msg = reader.readLine()) != null) {
                if (msg.equals(startNum.toString()))
                    start = true;
                if (msg.equals(endNum.toString()))
                    break;
                if (start)
                    list.add(msg);
            }
        } catch (IOException ignore) {
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        manager.close();
        return list;

    }

    private int getYao() {
        return activity.getIntent().getIntExtra("yao", -1) + 1;
    }
}
