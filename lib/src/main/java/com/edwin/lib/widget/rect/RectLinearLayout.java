package com.edwin.lib.widget.rect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.edwin.lib.R;

/**
 * Copyright (C) 2017 The huimai TV client Project
 * All rights reserved.
 *
 * @author edwin
 * @describe 矩形LinearLayout
 * @since 22/12/2017
 */
@SuppressLint("AppCompatCustomView")
public class RectLinearLayout extends LinearLayout implements Rect {

    private int mRectLeftTopRadius = DEFAULT_RECT_RADIUS;
    private int mRectRightTopRadius = DEFAULT_RECT_RADIUS;
    private int mRectRightBottomRadius = DEFAULT_RECT_RADIUS;
    private int mRectLeftBottomRadius = DEFAULT_RECT_RADIUS;
    private int mRectStrokeWidth = DEFAULT_RECT_STROKE_WIDTH;
    private int mRectStrokeColor = DEFAULT_RECT_STROKE_COLOR;

    private Drawable mBackground;
    private RectDrawable mRectBackground;
    private Paint mStrokePaint;

    public RectLinearLayout(Context context) {
        this(context, null);
    }

    public RectLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("CustomViewStyleable")
    public RectLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Rect);
        int mRectRadius = a.getDimensionPixelSize(R.styleable.Rect_rect_radius, DEFAULT_RECT_RADIUS);
        mRectLeftTopRadius = a.getDimensionPixelSize(R.styleable.Rect_rect_leftTopRadius, mRectRadius);
        mRectRightTopRadius = a.getDimensionPixelSize(R.styleable.Rect_rect_rightTopRadius, mRectRadius);
        mRectRightBottomRadius = a.getDimensionPixelSize(R.styleable.Rect_rect_rightBottomRadius, mRectRadius);
        mRectLeftBottomRadius = a.getDimensionPixelSize(R.styleable.Rect_rect_leftBottomRadius, mRectRadius);
        mRectStrokeWidth = a.getDimensionPixelSize(R.styleable.Rect_rect_strokeWidth, DEFAULT_RECT_STROKE_WIDTH);
        mRectStrokeColor = a.getColor(R.styleable.Rect_rect_strokeColor, DEFAULT_RECT_STROKE_COLOR);
        a.recycle();

        mStrokePaint = RectUtils.initPaint(mRectStrokeColor, mRectStrokeWidth);
    }

    @Override
    @SuppressLint("MissingSuperCall")
    public void draw(Canvas canvas) {
        // 拦截的背景需要先绘制
        if (mBackground != null) {
            if (mRectBackground == null) {
                RectF rectF = new RectF(0
                        , 0
                        , getRight() - getLeft()
                        , getBottom() - getTop());
                mRectBackground = new RectDrawable.Builder(mBackground, rectF)
                        .setRadius(mRectLeftTopRadius
                                , mRectRightTopRadius
                                , mRectRightBottomRadius
                                , mRectLeftBottomRadius)
                        .create();
            }
            mRectBackground.draw(canvas);
        }

        super.draw(canvas);

        // 绘制边框
        RectF rectF = new RectF(0
                , 0
                , getRight() - getLeft()
                , getBottom() - getTop());
        Path path = RectUtils.initPath(rectF
                , mRectLeftTopRadius
                , mRectRightTopRadius
                , mRectRightBottomRadius
                , mRectLeftBottomRadius);
        canvas.drawPath(path, mStrokePaint);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // 释放资源文件
        if (mBackground instanceof RectDrawable) {
            ((RectDrawable) mBackground).recycle();
        }
    }

    @Override
    public void setBackgroundColor(int color) {
        setBackground(new ColorDrawable(color));
    }

    @Override
    public void setBackgroundResource(int resid) {
        setBackground(getContext().getResources().getDrawable(resid));
    }

    @Override
    public void setBackgroundDrawable(Drawable background) {
        setBackground(background);
    }

    @Override
    public Drawable getBackground() {
        return mRectBackground;
    }

    @Override
    public void setBackground(Drawable background) {
        mBackground = background;
        if (mRectBackground != null && !mRectBackground.checkResourceDrawable(background)) {
            mRectBackground.recycle();
            mRectBackground = null;
        }
        super.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void setRectRadius(int mRectRadius) {
        setRectRadius(mRectRadius, mRectRadius, mRectRadius, mRectRadius);
    }

    public void setRectRadius(int leftTop, int rightTop, int rightBottom, int leftBottom) {
        mRectLeftTopRadius = leftTop;
        mRectRightTopRadius = rightTop;
        mRectRightBottomRadius = rightBottom;
        mRectLeftBottomRadius = leftBottom;
    }

    public int getRectLeftTopRadius() {
        return mRectLeftTopRadius;
    }

    public int getRectRightTopRadius() {
        return mRectRightTopRadius;
    }

    public int getRectRightBottomRadius() {
        return mRectRightBottomRadius;
    }

    public int getRectLeftBottomRadius() {
        return mRectLeftBottomRadius;
    }

    public int getRectStrokeWidth() {
        return mRectStrokeWidth;
    }

    public void setRectStrokeWidth(int mRectStrokeWidth) {
        this.mRectStrokeWidth = mRectStrokeWidth;
    }

    public int getRectStrokeColor() {
        return mRectStrokeColor;
    }

    public void setRectStrokeColor(int mRectStrokeColor) {
        this.mRectStrokeColor = mRectStrokeColor;
    }
}