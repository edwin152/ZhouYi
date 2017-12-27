package com.edwin.zhouyi.presenter;

import com.edwin.lib.mvp.MVPPresenter;
import com.edwin.zhouyi.cache.CacheFactory;
import com.edwin.zhouyi.model.HexagramWords;
import com.edwin.zhouyi.view.HexagramWordsActivity;

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
        int startNum = activity.getIntent().getIntExtra("num", -1);
        HexagramWords hexagramWords = CacheFactory.getHexagramCache().get(startNum);
    }

//        Integer startNum = activity.getIntent().getIntExtra("num", -1);

    private int getYao() {
        return activity.getIntent().getIntExtra("yao", -1) + 1;
    }
}
