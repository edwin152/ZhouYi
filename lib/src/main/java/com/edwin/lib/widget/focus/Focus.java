package com.edwin.lib.widget.focus;

import android.graphics.Color;

import com.edwin.lib.widget.rect.Rect;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public interface Focus extends Rect {
    // 默认焦点框宽度
    int DEFAULT_FOCUS_STROKE_WIDTH = 0;
    // 默认焦点框颜色
    int DEFAULT_FOCUS_STROKE_COLOR = Color.TRANSPARENT;
    // 默认焦点放大比率
    float DEFAULT_FOCUS_SCALE_RATE = 1.0f;
    // 默认是否获取焦点后到view的最顶层
    boolean DEFAULT_FOCUS_FRONT_AFTER_FOCUS = false;
}
