package com.edwin.zhouyi.presenter;

import com.edwin.lib.mvp.MVPPresenter;
import com.edwin.zhouyi.view.MainActivity;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class MainPresenter extends MVPPresenter {

    private MainActivity activity;

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void start() {

    }
}
