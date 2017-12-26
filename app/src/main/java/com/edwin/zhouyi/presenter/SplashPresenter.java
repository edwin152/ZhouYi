package com.edwin.zhouyi.presenter;

import android.content.Intent;
import android.os.Handler;

import com.edwin.zhouyi.view.MainActivity;
import com.edwin.zhouyi.view.SplashActivity;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class SplashPresenter extends BasePresenter {

    private static final long WAIT_TIME = 0;

    private SplashActivity activity;
    private Handler handler;

    public SplashPresenter(SplashActivity activity) {
        this.activity = activity;
        handler = new Handler();
    }

    @Override
    public void start() {

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
