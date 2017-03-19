package com.edwin.zhouyi.presenter;

/**
 * Copyright 2016 Beijing Xinwei, Inc. All rights reserved.
 * History:
 * ------------------------------------------------------------------------------
 * Date    	    |  Who  		|  What
 * 2017/3/19	| xuxiangyu 	| 	create the file
 */


import android.content.Intent;
import android.os.Handler;

import com.edwin.zhouyi.view.MainActivity;
import com.edwin.zhouyi.view.SplashActivity;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public class SplashPresenter extends BasePresenter {

    private static final long WAIT_TIME = 3000;

    private SplashActivity activity;
    private Handler handler;

    public SplashPresenter(SplashActivity activity) {
        this.activity = activity;
        handler = new Handler();
    }

    public void prepareData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                prepare();
                long endTime = System.currentTimeMillis();
                long time = endTime - startTime;
                if (time < WAIT_TIME) {
                    time = WAIT_TIME - time;
                } else {
                    time = 0;
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        activity.startActivity(new Intent(activity, MainActivity.class));
                    }
                }, time);
            }
        }).start();
    }

    private void prepare() {

    }
}
