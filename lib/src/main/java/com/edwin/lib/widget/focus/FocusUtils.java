package com.edwin.lib.widget.focus;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.edwin.lib.widget.rect.RectUtils;

/**
 * Copyright (C) 2017 The huimai TV client Project
 * All rights reserved.
 *
 * @author edwin
 * @describe 焦点工具类
 * @since 22/12/2017
 */
public class FocusUtils extends RectUtils {

    /**
     * 获取放大动画
     *
     * @param scaleRate 放大比率
     * @return 动画
     */
    public static Animation initAnimation(float scaleRate) {
        Animation animation = new ScaleAnimation(1.0f, scaleRate
                , 1.0f, scaleRate
                , Animation.RELATIVE_TO_SELF, 0.5f
                , Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(400);
        animation.setFillAfter(true);
        return animation;
    }
}
