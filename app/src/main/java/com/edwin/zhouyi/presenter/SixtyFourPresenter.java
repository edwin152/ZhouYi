package com.edwin.zhouyi.presenter;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.edwin.zhouyi.view.SixtyFourActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <describe>
 * </describe>
 * Created by edwin on 2017/4/6.
 */

public class SixtyFourPresenter extends BasePresenter {

    private SixtyFourActivity activity;

    public SixtyFourPresenter(SixtyFourActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
