package com.edwin.lib.mvp;

import android.app.Fragment;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public abstract class MVPFragment<P extends MVPPresenter> extends Fragment {

    private P presenter;

    public MVPFragment() {
        this.presenter = newPresenter();
    }

    protected abstract P newPresenter();

    protected P getPresenter() {
        return presenter;
    }

}
