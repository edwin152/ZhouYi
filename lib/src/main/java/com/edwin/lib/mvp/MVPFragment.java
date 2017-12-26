package com.edwin.lib.mvp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/6/2
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
