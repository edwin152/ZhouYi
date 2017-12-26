package com.edwin.zhouyi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.edwin.lib.mvp.MVPActivity;
import com.edwin.zhouyi.R;
import com.edwin.zhouyi.presenter.MainPresenter;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class MainActivity extends MVPActivity<MainPresenter> {
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
        startActivity(new Intent(this, EarlyEightDiagramActivity.class));
    }

    public void toDivination(View v) {
        startActivity(new Intent(this, DivinationActivity.class));
    }

}
