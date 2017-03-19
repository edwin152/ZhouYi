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
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * simple description
 * detail description
 *
 * @author xuxiangyu create on 2017/3/19
 */
public class DoubleGua extends FrameLayout {
    public DoubleGua(@NonNull Context context) {
        this(context, null);
    }

    public DoubleGua(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DoubleGua(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public enum Name {
        QIAN,
        KUN;

        public static Name parse(int i) {
            Name[] names = values();
            if (i >= names.length || i < 0)
                return QIAN;
            return names[i];
        }
    }
}
