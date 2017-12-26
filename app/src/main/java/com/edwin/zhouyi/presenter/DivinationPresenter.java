package com.edwin.zhouyi.presenter;

import android.content.Intent;

import com.edwin.lib.mvp.MVPPresenter;
import com.edwin.zhouyi.config.Config64Gua;
import com.edwin.zhouyi.view.DivinationActivity;
import com.edwin.zhouyi.view.HexagramWordsActivity;

/**
 * simple describe 占卜
 *
 * @author edwin
 * @since 26/12/2017
 */
public class DivinationPresenter extends MVPPresenter {

    private DivinationActivity activity;

    public DivinationPresenter(DivinationActivity activity) {
        this.activity = activity;
    }

    @Override
    public void start() {

    }

    public void divination(int _1, int _2, int _3) {
        int down = _1 % 8;
        int up = _2 % 8;
        int yao = _3 % 6;

        int order = Config64Gua._64[down][up];
        activity.startActivity(new Intent(activity, HexagramWordsActivity.class)
                .putExtra("num", order)
                .putExtra("yao", yao));
        System.out.println("down : " + (down + 1) + ", up : " + (up + 1) + ", yao : " + (yao + 1));
    }
}
