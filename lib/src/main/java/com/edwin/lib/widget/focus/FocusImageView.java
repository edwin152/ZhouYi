package com.edwin.lib.widget.focus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;

import com.edwin.lib.R;
import com.edwin.lib.widget.rect.RectImageView;
import com.edwin.lib.widget.rect.RectUtils;

/**
 * Copyright (C) 2017 The huimai TV client Project
 * All rights reserved.
 *
 * @author edwin
 * @describe 焦点ImageView
 * @since 22/12/2017
 */
public class FocusImageView extends RectImageView implements Focus {

    private int mFocusStrokeWidth = DEFAULT_FOCUS_STROKE_WIDTH;
    private int mFocusStrokeColor = DEFAULT_FOCUS_STROKE_COLOR;
    private float mFocusScaleRate = DEFAULT_FOCUS_SCALE_RATE;
    private boolean mFocusFrontAfterFocus = DEFAULT_FOCUS_FRONT_AFTER_FOCUS;

    private Paint mStrokePaint;
    private Animation mAnimation;

    public FocusImageView(Context context) {
        this(context, null);
    }

    public FocusImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("CustomViewStyleable")
    public FocusImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Focus);
        mFocusStrokeWidth = a.getDimensionPixelSize(R.styleable.Focus_focus_strokeWidth, DEFAULT_FOCUS_STROKE_WIDTH);
        mFocusStrokeColor = a.getColor(R.styleable.Focus_focus_strokeColor, DEFAULT_FOCUS_STROKE_COLOR);
        mFocusScaleRate = a.getFloat(R.styleable.Focus_focus_scaleRate, DEFAULT_FOCUS_SCALE_RATE);
        mFocusFrontAfterFocus = a.getBoolean(R.styleable.Focus_focus_frontAfterFocus, DEFAULT_FOCUS_FRONT_AFTER_FOCUS);
        a.recycle();

        mStrokePaint = FocusUtils.initPaint(mFocusStrokeColor, mFocusStrokeWidth);

        mAnimation = FocusUtils.initAnimation(mFocusScaleRate);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        // 获取焦点后，判断是否focusable，并绘制焦点边框
        if (hasFocus() && isFocusable() || isInEditMode()) {
            RectF rectF = new RectF(0
                    , 0
                    , getRight() - getLeft()
                    , getBottom() - getTop());
            Path path = RectUtils.initPath(rectF
                    , getRectLeftTopRadius()
                    , getRectRightTopRadius()
                    , getRectRightBottomRadius()
                    , getRectLeftBottomRadius());
            canvas.drawPath(path, mStrokePaint);
        }
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

        // 获取焦点后，进行放大动画
        if (gainFocus) {
            startAnimation(mAnimation);
            if (mFocusFrontAfterFocus) {
                bringToFront();
            }
        } else {
            clearAnimation();
        }
    }

    public int getFocusStrokeWidth() {
        return mFocusStrokeWidth;
    }

    public void setFocusStrokeWidth(int focusStrokeWidth) {
        this.mFocusStrokeWidth = mFocusStrokeWidth;
    }

    public int getFocusStrokeColor() {
        return mFocusStrokeColor;
    }

    public void setFocusStrokeColor(int focusStrokeColor) {
        this.mFocusStrokeColor = mFocusStrokeColor;
    }

    public float getFocusScaleRate() {
        return mFocusScaleRate;
    }

    public void setFocusScaleRate(float focusScaleRate) {
        this.mFocusScaleRate = mFocusScaleRate;
    }

    public boolean isFocusFrontAfterFocus() {
        return mFocusFrontAfterFocus;
    }

    public void setFocusFrontAfterFocus(boolean focusFrontAfterFocus) {
        this.mFocusFrontAfterFocus = mFocusFrontAfterFocus;
    }
}
