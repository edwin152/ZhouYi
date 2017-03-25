package com.edwin.zhouyi.view;

/**
 * Copyright 2016 Beijing Xinwei, Inc. All rights reserved.
 * <p>
 * History:
 * ------------------------------------------------------------------------------
 * Date    	    |  Who  		|  What
 * 2017/3/19	| xuxiangyu 	| 	create the file
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.edwin.zhouyi.R;
import com.edwin.zhouyi.presenter.MainPresenter;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public class MainActivity extends BaseActivity<MainPresenter> {
    @Override
    protected MainPresenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toCongenitalGossip(View v) {
        startActivity(new Intent(this, CongenitalGossipActivity.class));
    }

    public void toDivination(View v) {
        startActivity(new Intent(this, DivinationActivity.class));
    }

}
