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
import android.widget.ImageView;

import com.edwin.zhouyi.R;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public class DiagramSingle extends FrameLayout {

    private ImageView iv_top;
    private ImageView iv_middle;
    private ImageView iv_bottom;

    private Name name;

    public DiagramSingle(@NonNull Context context) {
        this(context, null);
    }

    public DiagramSingle(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagramSingle(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_diagram_single, this);
        iv_top = (ImageView) findViewById(R.id.top);
        iv_middle = (ImageView) findViewById(R.id.middle);
        iv_bottom = (ImageView) findViewById(R.id.bottom);

        if (attrs == null)
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DiagramSingle);
        int name = a.getInt(R.styleable.DiagramSingle_name_single, 0);
        setName(Name.parse(name));
        a.recycle();

    }

    public void setName(Name name) {
        this.name = name;
        switch (name) {
            case QIAN:
                iv_top.setImageResource(R.drawable.yangyao);
                iv_middle.setImageResource(R.drawable.yangyao);
                iv_bottom.setImageResource(R.drawable.yangyao);
                break;
            case KUN:
                iv_top.setImageResource(R.drawable.yinyao);
                iv_middle.setImageResource(R.drawable.yinyao);
                iv_bottom.setImageResource(R.drawable.yinyao);
                break;
            case ZHEN:
                iv_top.setImageResource(R.drawable.yinyao);
                iv_middle.setImageResource(R.drawable.yinyao);
                iv_bottom.setImageResource(R.drawable.yangyao);
                break;
            case GEN:
                iv_top.setImageResource(R.drawable.yangyao);
                iv_middle.setImageResource(R.drawable.yinyao);
                iv_bottom.setImageResource(R.drawable.yinyao);
                break;
            case LI:
                iv_top.setImageResource(R.drawable.yangyao);
                iv_middle.setImageResource(R.drawable.yinyao);
                iv_bottom.setImageResource(R.drawable.yangyao);
                break;
            case KAN:
                iv_top.setImageResource(R.drawable.yinyao);
                iv_middle.setImageResource(R.drawable.yangyao);
                iv_bottom.setImageResource(R.drawable.yinyao);
                break;
            case DUI:
                iv_top.setImageResource(R.drawable.yinyao);
                iv_middle.setImageResource(R.drawable.yangyao);
                iv_bottom.setImageResource(R.drawable.yangyao);
                break;
            case XUN:
                iv_top.setImageResource(R.drawable.yangyao);
                iv_middle.setImageResource(R.drawable.yangyao);
                iv_bottom.setImageResource(R.drawable.yinyao);
                break;
        }
    }

    public Name getName() {
        return name;
    }

    public enum Name {
        QIAN,
        KUN,
        ZHEN,
        GEN,
        LI,
        KAN,
        DUI,
        XUN;

        public static Name parse(int i) {
            Name[] names = values();
            if (i >= names.length || i < 0)
                return QIAN;
            return names[i];
        }
    }
}
