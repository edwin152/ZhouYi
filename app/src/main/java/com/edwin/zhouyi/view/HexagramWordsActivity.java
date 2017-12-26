package com.edwin.zhouyi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.edwin.lib.mvp.MVPActivity;
import com.edwin.zhouyi.R;
import com.edwin.zhouyi.enums.Diagram;
import com.edwin.zhouyi.presenter.HexagramWordsPresenter;
import com.edwin.zhouyi.widget.DiagramView;

import java.util.List;

/**
 * simple describe 爻词
 *
 * @author edwin
 * @since 26/12/2017
 */
public class HexagramWordsActivity extends MVPActivity<HexagramWordsPresenter> {

    private DiagramView ds_above;
    private DiagramView ds_below;
    private TextView tv_mainTitle;
    private TextView tv_mainTitleDescribe;
    private TextView tv_mainTitleDescribeXiang;
    private TextView tv_firstDescribe;
    private TextView tv_firstDescribeXiang;
    private TextView tv_secondDescribe;
    private TextView tv_secondDescribeXiang;
    private TextView tv_thirdDescribe;
    private TextView tv_thirdDescribeXiang;
    private TextView tv_fourthDescribe;
    private TextView tv_fourthDescribeXiang;
    private TextView tv_fifthDescribe;
    private TextView tv_fifthDescribeXiang;
    private TextView tv_sixthDescribe;
    private TextView tv_sixthDescribeXiang;
    private TextView tv_yao;

    @Override
    protected HexagramWordsPresenter newPresenter() {
        return new HexagramWordsPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_hexagram_words);
        ds_above = findViewById(R.id.above);
        ds_below = findViewById(R.id.below);
        tv_mainTitle = findViewById(R.id.main_title);
        tv_mainTitleDescribe = findViewById(R.id.main_title_describe);
        tv_mainTitleDescribeXiang = findViewById(R.id.main_title_describe_xiang);
        tv_firstDescribe = findViewById(R.id.first_describe);
        tv_firstDescribeXiang = findViewById(R.id.first_describe_xiang);
        tv_secondDescribe = findViewById(R.id.second_describe);
        tv_secondDescribeXiang = findViewById(R.id.second_describe_xiang);
        tv_thirdDescribe = findViewById(R.id.third_describe);
        tv_thirdDescribeXiang = findViewById(R.id.third_describe_xiang);
        tv_fourthDescribe = findViewById(R.id.fourth_describe);
        tv_fourthDescribeXiang = findViewById(R.id.fourth_describe_xiang);
        tv_fifthDescribe = findViewById(R.id.fifth_describe);
        tv_fifthDescribeXiang = findViewById(R.id.fifth_describe_xiang);
        tv_sixthDescribe = findViewById(R.id.sixth_describe);
        tv_sixthDescribeXiang = findViewById(R.id.sixth_describe_xiang);
        tv_yao = findViewById(R.id.yao);
        super.onCreate(savedInstanceState);
    }

    public void setList(List<String> list) {
        if (list.size() == 0)
            return;
        String below = list.get(2).substring(0, 1);
        String above = list.get(2).substring(2, 3);
        ds_below.setName(parseName(below));
        ds_above.setName(parseName(above));
        tv_mainTitle.setText(list.get(0) + "." + list.get(1) + " " + list.get(2));
        tv_mainTitleDescribe.setText(list.get(3));
        tv_mainTitleDescribeXiang.setText(list.get(4));
        tv_firstDescribe.setText(list.get(5));
        tv_firstDescribeXiang.setText(list.get(6));
        tv_secondDescribe.setText(list.get(7));
        tv_secondDescribeXiang.setText(list.get(8));
        tv_thirdDescribe.setText(list.get(9));
        tv_thirdDescribeXiang.setText(list.get(10));
        tv_fourthDescribe.setText(list.get(11));
        tv_fourthDescribeXiang.setText(list.get(12));
        tv_fifthDescribe.setText(list.get(13));
        tv_fifthDescribeXiang.setText(list.get(14));
        tv_sixthDescribe.setText(list.get(15));
        tv_sixthDescribeXiang.setText(list.get(16));
    }

    public void setYao(Integer num) {
        tv_yao.setText(num.toString());
    }

    private Diagram parseName(String name) {
        switch (name) {
            case "乾":
                return Diagram.QIAN;
            case "坤":
                return Diagram.KUN;
            case "震":
                return Diagram.ZHEN;
            case "艮":
                return Diagram.GEN;
            case "坎":
                return Diagram.KAN;
            case "离":
                return Diagram.LI;
            case "兑":
                return Diagram.DUI;
            case "巽":
                return Diagram.XUN;
            default:
                return Diagram.QIAN;
        }
    }

}
