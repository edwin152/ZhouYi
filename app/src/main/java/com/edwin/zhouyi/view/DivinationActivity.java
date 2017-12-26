package com.edwin.zhouyi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.edwin.lib.mvp.MVPActivity;
import com.edwin.zhouyi.R;
import com.edwin.zhouyi.presenter.DivinationPresenter;

/**
 * simple describe 占卜
 *
 * @author edwin
 * @since 26/12/2017
 */
public class DivinationActivity extends MVPActivity<DivinationPresenter> {

    private EditText et_1;
    private EditText et_2;
    private EditText et_3;

    @Override
    protected DivinationPresenter newPresenter() {
        return new DivinationPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divination);
        et_1 = findViewById(R.id._1);
        et_2 = findViewById(R.id._2);
        et_3 = findViewById(R.id._3);
    }

    public void divination(View v) {
        String str_1 = et_1.getText().toString();
        String str_2 = et_2.getText().toString();
        String str_3 = et_3.getText().toString();

        if (TextUtils.isEmpty(str_1) || TextUtils.isEmpty(str_2) || TextUtils.isEmpty(str_3)
                || str_1.length() < 3 || str_2.length() < 3 || str_3.length() < 3)
            return;
        int int_1 = Integer.parseInt(str_1);
        int int_2 = Integer.parseInt(str_2);
        int int_3 = Integer.parseInt(str_3);
        if (int_1 / 100 == 0 || int_2 / 100 == 0 || int_3 / 100 == 0)
            return;
        getPresenter().divination(int_1, int_2, int_3);
    }

    public void random1(View v) {
        et_1.setText(String.valueOf(getNum()));
    }

    public void random2(View v) {
        et_2.setText(String.valueOf(getNum()));
    }

    public void random3(View v) {
        et_3.setText(String.valueOf(getNum()));
    }

    private int getNum() {
        long time = System.currentTimeMillis();
        while (true) {
            int num = (int) (time % 1000);
            time = time / 10;
            if (num / 100 != 0)
                return num;
        }
    }
}
