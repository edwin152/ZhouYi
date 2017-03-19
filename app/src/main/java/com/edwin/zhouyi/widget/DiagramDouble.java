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
public class DiagramDouble extends FrameLayout {

    private DiagramSingle ds_above;
    private DiagramSingle ds_below;

    private Name name;

    public DiagramDouble(@NonNull Context context) {
        this(context, null);
    }

    public DiagramDouble(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagramDouble(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_diagram_double, this);
        ds_above = (DiagramSingle) findViewById(R.id.above);
        ds_below = (DiagramSingle) findViewById(R.id.below);

        if (attrs == null)
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DiagramDouble);
        int name = a.getInt(R.styleable.DiagramDouble_name_double, 0);
        setName(Name.parse(name));
        a.recycle();
    }

    public void setName(Name name) {
        this.name = name;
        switch (name) {
            case QIAN:
                ds_above.setName(DiagramSingle.Name.QIAN);
                ds_below.setName(DiagramSingle.Name.QIAN);
                break;
        }
    }

    public Name getName() {
        return name;
    }

    public enum Name {
        QIAN;

        public static Name parse(int i) {
            Name[] names = values();
            if (i >= names.length || i < 0)
                return QIAN;
            return names[i];
        }
    }
}
