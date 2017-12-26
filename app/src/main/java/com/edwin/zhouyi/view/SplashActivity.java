package com.edwin.zhouyi.view;

/**
 * Copyright 2016 Beijing Xinwei, Inc. All rights reserved.
 * <p>
 * History:
 * ------------------------------------------------------------------------------
 * Date    	    |  Who  		|  What
 * 2017/3/19	| xuxiangyu 	| 	create the file
 */


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.edwin.zhouyi.R;
import com.edwin.zhouyi.presenter.SplashPresenter;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class SplashActivity extends BaseActivity<SplashPresenter> {
    @Override
    protected SplashPresenter newPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getPresenter().prepareData();
    }
}
