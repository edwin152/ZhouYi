package com.edwin.zhouyi.widget;

/**
 * Copyright 2016 Beijing Xinwei, Inc. All rights reserved.
 * <p>
 * History:
 * ------------------------------------------------------------------------------
 * Date    	    |  Who  		|  What
 * 2017/3/19	| xuxiangyu 	| 	create the file
 */


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.edwin.zhouyi.R;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public class DiagramDoubleDetail extends FrameLayout {

    private DiagramDoubleDescribe ddd_describe;

    public DiagramDoubleDetail(@NonNull Context context) {
        this(context, null);
    }

    public DiagramDoubleDetail(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagramDoubleDetail(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_diagram_double_detail, this);
        ddd_describe = (DiagramDoubleDescribe) findViewById(R.id.describe);

        if (attrs == null)
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DiagramDoubleDescribe);
        String firstText = a.getString(R.styleable.DiagramDoubleDescribe_firstText);
        if (firstText != null)
            setFirstText(firstText);
        String secondText = a.getString(R.styleable.DiagramDoubleDescribe_secondText);
        if (secondText != null)
            setSecondText(secondText);
        String thirdText = a.getString(R.styleable.DiagramDoubleDescribe_thirdText);
        if (thirdText != null)
            setThirdText(thirdText);
        String fourthText = a.getString(R.styleable.DiagramDoubleDescribe_fourthText);
        if (fourthText != null)
            setFourthText(fourthText);
        String fifthText = a.getString(R.styleable.DiagramDoubleDescribe_fifthText);
        if (fifthText != null)
            setFifthText(fifthText);
        String sixthText = a.getString(R.styleable.DiagramDoubleDescribe_sixthText);
        if (sixthText != null)
            setSixthText(sixthText);
        a.recycle();
        a = context.obtainStyledAttributes(attrs, R.styleable.DiagramSingleDescribe);
        int color = a.getColor(R.styleable.DiagramSingleDescribe_textColor, -1);
        if (color != -1)
            setTextColor(color);
        float size = a.getFloat(R.styleable.DiagramSingleDescribe_textSize, -1);
        if (size != -1)
            setTextSize(size);
        a.recycle();
    }

    public void setFirstText(String text) {
        ddd_describe.setFirstText(text);
    }

    public void setFirstText(int resId) {
        ddd_describe.setFirstText(resId);
    }

    public void setSecondText(String text) {
        ddd_describe.setSecondText(text);
    }

    public void setSecondText(int resId) {
        ddd_describe.setSecondText(resId);
    }

    public void setThirdText(String text) {
        ddd_describe.setThirdText(text);
    }

    public void setThirdText(int resId) {
        ddd_describe.setThirdText(resId);
    }

    public void setFourthText(String text) {
        ddd_describe.setFourthText(text);
    }

    public void setFourthText(int resId) {
        ddd_describe.setFourthText(resId);
    }

    public void setFifthText(String text) {
        ddd_describe.setFifthText(text);
    }

    public void setFifthText(int resId) {
        ddd_describe.setFifthText(resId);
    }

    public void setSixthText(String text) {
        ddd_describe.setSixthText(text);
    }

    public void setSixthText(int resId) {
        ddd_describe.setSixthText(resId);
    }

    public void setTextSize(float size) {
        ddd_describe.setTextSize(size);
    }

    public void setTextColor(int color) {
        ddd_describe.setTextColor(color);
    }
}
