package com.edwin.zhouyi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.edwin.zhouyi.R;
import com.edwin.zhouyi.enums.Diagram8;
import com.edwin.zhouyi.presenter.SixtyFourPresenter;
import com.edwin.zhouyi.widget.DiagramSingle;

import java.util.List;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class SixtyFourActivity extends BaseActivity<SixtyFourPresenter> {

    private DiagramSingle ds_above;
    private DiagramSingle ds_below;
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
    protected SixtyFourPresenter newPresenter() {
        return new SixtyFourPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_sixty_four);
        ds_above = (DiagramSingle) findViewById(R.id.above);
        ds_below = (DiagramSingle) findViewById(R.id.below);
        tv_mainTitle = (TextView) findViewById(R.id.main_title);
        tv_mainTitleDescribe = (TextView) findViewById(R.id.main_title_describe);
        tv_mainTitleDescribeXiang = (TextView) findViewById(R.id.main_title_describe_xiang);
        tv_firstDescribe = (TextView) findViewById(R.id.first_describe);
        tv_firstDescribeXiang = (TextView) findViewById(R.id.first_describe_xiang);
        tv_secondDescribe = (TextView) findViewById(R.id.second_describe);
        tv_secondDescribeXiang = (TextView) findViewById(R.id.second_describe_xiang);
        tv_thirdDescribe = (TextView) findViewById(R.id.third_describe);
        tv_thirdDescribeXiang = (TextView) findViewById(R.id.third_describe_xiang);
        tv_fourthDescribe = (TextView) findViewById(R.id.fourth_describe);
        tv_fourthDescribeXiang = (TextView) findViewById(R.id.fourth_describe_xiang);
        tv_fifthDescribe = (TextView) findViewById(R.id.fifth_describe);
        tv_fifthDescribeXiang = (TextView) findViewById(R.id.fifth_describe_xiang);
        tv_sixthDescribe = (TextView) findViewById(R.id.sixth_describe);
        tv_sixthDescribeXiang = (TextView) findViewById(R.id.sixth_describe_xiang);
        tv_yao = (TextView) findViewById(R.id.yao);
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

    private Diagram8 parseName(String name) {
        switch (name) {
            case "乾":
                return Diagram8.QIAN;
            case "坤":
                return Diagram8.KUN;
            case "震":
                return Diagram8.ZHEN;
            case "艮":
                return Diagram8.GEN;
            case "坎":
                return Diagram8.KAN;
            case "离":
                return Diagram8.LI;
            case "兑":
                return Diagram8.DUI;
            case "巽":
                return Diagram8.XUN;
            default:
                return Diagram8.QIAN;
        }
    }

}
