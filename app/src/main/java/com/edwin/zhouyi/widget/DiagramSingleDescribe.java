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
import android.widget.TextView;

import com.edwin.zhouyi.R;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public class DiagramSingleDescribe extends FrameLayout {

    private TextView tv_top;
    private TextView tv_middle;
    private TextView tv_bottom;

    public DiagramSingleDescribe(@NonNull Context context) {
        this(context, null);
    }

    public DiagramSingleDescribe(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagramSingleDescribe(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_diagram_single_describe, this);
        tv_top = (TextView) findViewById(R.id.top);
        tv_middle = (TextView) findViewById(R.id.middle);
        tv_bottom = (TextView) findViewById(R.id.bottom);

        if (attrs == null)
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DiagramSingleDescribe);
        String topDescribe = a.getString(R.styleable.DiagramSingleDescribe_topDescribe);
        if (topDescribe != null)
            setTopText(topDescribe);
        String middleDescribe = a.getString(R.styleable.DiagramSingleDescribe_middleDescribe);
        if (middleDescribe != null)
            setMiddleText(middleDescribe);
        String bottomDescribe = a.getString(R.styleable.DiagramSingleDescribe_bottomDescribe);
        if (bottomDescribe != null)
            setBottomText(bottomDescribe);
        int color = a.getColor(R.styleable.DiagramSingleDescribe_textColor, -1);
        if (color != -1)
            setTextColor(color);
        float size = a.getFloat(R.styleable.DiagramSingleDescribe_textSize, -1);
        if (size != -1)
            setTextSize(size);
        a.recycle();
    }

    public void setTopText(int resId) {
        tv_top.setText(resId);
    }

    public void setTopText(String text) {
        tv_top.setText(text);
    }

    public void setMiddleText(int resId) {
        tv_middle.setText(resId);
    }

    public void setMiddleText(String text) {
        tv_middle.setText(text);
    }

    public void setBottomText(int resId) {
        tv_bottom.setText(resId);
    }

    public void setBottomText(String text) {
        tv_bottom.setText(text);
    }

    public void setTextSize(float size) {
        tv_top.setTextSize(size);
        tv_middle.setTextSize(size);
        tv_bottom.setTextSize(size);
    }

    public void setTextColor(int color) {
        tv_top.setTextColor(color);
        tv_middle.setTextColor(color);
        tv_bottom.setTextColor(color);
    }
}
