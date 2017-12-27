package com.edwin.zhouyi.presenter;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.edwin.lib.mvp.MVPPresenter;
import com.edwin.zhouyi.cache.CacheFactory;
import com.edwin.zhouyi.cache.HexagramCache;
import com.edwin.zhouyi.view.MainActivity;
import com.edwin.zhouyi.view.SplashActivity;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class SplashPresenter extends MVPPresenter {
    private static final String LOG_TAG = SplashPresenter.class.getSimpleName();

    private static final long WAIT_TIME = 0;

    private SplashActivity activity;
    private Handler handler;

    public SplashPresenter(SplashActivity activity) {
        this.activity = activity;
        handler = new Handler();
    }

    @Override
    public void start() {
        prepareData();
    }

    private void prepareData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                prepareInBackground();
                long endTime = System.currentTimeMillis();
                long time = endTime - startTime;
                Log.d(LOG_TAG, "use " + time + "ms to load data.");
                if (time < WAIT_TIME) {
                    time = WAIT_TIME - time;
                } else {
                    time = 0;
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        activity.startActivity(new Intent(activity, MainActivity.class));
                        activity.finish();
                    }
                }, time);
            }
        }).start();
    }

    private void prepareInBackground() {
        HexagramCache cache = CacheFactory.getHexagramCache();
        cache.init();
    }
}
