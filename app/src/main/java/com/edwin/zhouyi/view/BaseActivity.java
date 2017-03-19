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
import android.support.v7.app.AppCompatActivity;

import com.edwin.zhouyi.presenter.BasePresenter;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;

    protected abstract P newPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = newPresenter();
        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        presenter.onNewIntent(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }
}
