package com.edwin.lib.widget.rect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.edwin.lib.R;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
@SuppressWarnings("deprecation")
@SuppressLint("AppCompatCustomView")
public class RectImageView extends ImageView implements Rect {

    private int mRectLeftTopRadius = DEFAULT_RECT_RADIUS;
    private int mRectRightTopRadius = DEFAULT_RECT_RADIUS;
    private int mRectRightBottomRadius = DEFAULT_RECT_RADIUS;
    private int mRectLeftBottomRadius = DEFAULT_RECT_RADIUS;
    private int mRectStrokeWidth = DEFAULT_RECT_STROKE_WIDTH;
    private int mRectStrokeColor = DEFAULT_RECT_STROKE_COLOR;

    private Drawable mDrawable;
    private Drawable mBackground;
    private RectDrawable mRectDrawable;
    private RectDrawable mRectBackground;
    private Paint mStrokePaint;

    public RectImageView(Context context) {
        this(context, null);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("CustomViewStyleable")
    public RectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        // 资源图片最后绘制
        if (mDrawable != null) {
            if (mRectDrawable == null) {
                RectF rectF = new RectF(getPaddingLeft()
                        , getPaddingTop()
                        , getRight() - getLeft() - getPaddingRight()
                        , getBottom() - getTop() - getPaddingBottom());
                mRectDrawable = new RectDrawable.Builder(mDrawable, rectF)
                        .setRadius(mRectLeftTopRadius
                                , mRectRightTopRadius
                                , mRectRightBottomRadius
                                , mRectLeftBottomRadius)
                        .setScaleType(getScaleType())
                        .create();
            }
            mRectDrawable.draw(canvas);
        }

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

//        super.draw(canvas);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // 释放资源文件
        if (mBackground instanceof RectDrawable) {
            ((RectDrawable) mBackground).recycle();
        }
        if (mDrawable instanceof RectDrawable) {
            ((RectDrawable) mDrawable).recycle();
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

    @Override
    public void setImageResource(int resId) {
        setImageDrawable(getContext().getResources().getDrawable(resId));
    }

    @Override
    public void setImageURI(@Nullable Uri uri) {
        if (uri == null) {
            setImageDrawable(null);
        } else {
            setImageDrawable(Drawable.createFromPath(uri.getPath()));
        }
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        mDrawable = drawable;
        if (mRectDrawable != null && !mRectDrawable.checkResourceDrawable(drawable)) {
            mRectDrawable.recycle();
            mRectDrawable = null;
        }
        super.setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setImageIcon(@Nullable Icon icon) {
        if (icon == null) {
            setImageDrawable(null);
        } else {
            setImageDrawable(icon.loadDrawable(getContext()));
        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        setImageDrawable(new BitmapDrawable(getResources(), bm));
    }

    @Override
    public Drawable getDrawable() {
        return mRectDrawable;
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
