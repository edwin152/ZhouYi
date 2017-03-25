package com.edwin.zhouyi.presenter;

import android.widget.Toast;

import com.edwin.zhouyi.view.DivinationActivity;

/**
 * <describe>
 * </describe>
 * Created by edwin on 2017/3/23.
 */

public class DivinationPresenter extends BasePresenter {

    private DivinationActivity activity;

    public DivinationPresenter(DivinationActivity activity) {
        this.activity = activity;
    }

    public void divination(int _1, int _2, int _3) {
        int down = _1 % 8 + 1;
        int up = _2 % 8 + 1;
        int yao = _3 % 6 + 1;
        Toast.makeText(activity, "down : " + down + ", up : " + up + ", yao : " + yao, Toast.LENGTH_LONG).show();
    }

}
