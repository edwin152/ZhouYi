package com.edwin.zhouyi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.edwin.zhouyi.R;
import com.edwin.zhouyi.presenter.CongenitalGossipPresenter;

/**
 * <describe>
 * </describe>
 * Created by edwin on 2017/3/25.
 */

public class CongenitalGossipActivity extends BaseActivity<CongenitalGossipPresenter> {

    @Override
    protected CongenitalGossipPresenter newPresenter() {
        return new CongenitalGossipPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congenital_gossip);
    }

    public void qianClick(View v) {
        Toast.makeText(this, "qian", Toast.LENGTH_SHORT).show();
    }

    public void duiClick(View v) {
        Toast.makeText(this, "dui", Toast.LENGTH_SHORT).show();
    }

    public void liClick(View v) {
        Toast.makeText(this, "li", Toast.LENGTH_SHORT).show();
    }

    public void zhenClick(View v) {
        Toast.makeText(this, "zhen", Toast.LENGTH_SHORT).show();
    }

    public void xunClick(View v) {
        Toast.makeText(this, "xun", Toast.LENGTH_SHORT).show();
    }

    public void kanClick(View v) {
        Toast.makeText(this, "kan", Toast.LENGTH_SHORT).show();
    }

    public void genClick(View v) {
        Toast.makeText(this, "gen", Toast.LENGTH_SHORT).show();
    }

    public void kunClick(View v) {
        Toast.makeText(this, "kun", Toast.LENGTH_SHORT).show();
    }
}
