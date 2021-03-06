package com.edwin.lib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public abstract class MVPActivity<P extends MVPPresenter> extends AppCompatActivity {

    private P presenter;

    public MVPActivity() {
        this.presenter = newPresenter();
    }

    protected abstract P newPresenter();

    protected P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.start();
    }
}
