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
public class DiagramDoubleDescribe extends FrameLayout {

    private DiagramSingleDescribe dsd_above;
    private DiagramSingleDescribe dsd_below;

    public DiagramDoubleDescribe(@NonNull Context context) {
        this(context, null);
    }

    public DiagramDoubleDescribe(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagramDoubleDescribe(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_diagram_double_describe, this);
        dsd_above = (DiagramSingleDescribe) findViewById(R.id.above);
        dsd_below = (DiagramSingleDescribe) findViewById(R.id.below);

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
        int color = a.getColor(R.styleable.DiagramSingleDescribe_textColor, -1);
        if (color != -1)
            setTextColor(color);
        float size = a.getFloat(R.styleable.DiagramSingleDescribe_textSize, -1);
        if (size != -1)
            setTextSize(size);
        a.recycle();
    }

    public void setFirstText(String text) {
        dsd_below.setBottomText(text);
    }

    public void setFirstText(int resId) {
        dsd_below.setBottomText(resId);
    }

    public void setSecondText(String text) {
        dsd_below.setMiddleText(text);
    }

    public void setSecondText(int resId) {
        dsd_below.setMiddleText(resId);
    }

    public void setThirdText(String text) {
        dsd_below.setTopText(text);
    }

    public void setThirdText(int resId) {
        dsd_below.setTopText(resId);
    }

    public void setFourthText(String text) {
        dsd_above.setBottomText(text);
    }

    public void setFourthText(int resId) {
        dsd_below.setBottomText(resId);
    }

    public void setFifthText(String text) {
        dsd_above.setMiddleText(text);
    }

    public void setFifthText(int resId) {
        dsd_below.setMiddleText(resId);
    }

    public void setSixthText(String text) {
        dsd_above.setTopText(text);
    }

    public void setSixthText(int resId) {
        dsd_below.setTopText(resId);
    }

    public void setTextSize(float size) {
        dsd_above.setTextSize(size);
        dsd_below.setTextSize(size);
    }

    public void setTextColor(int color) {
        dsd_above.setTextColor(color);
        dsd_below.setTextColor(color);
    }
}
