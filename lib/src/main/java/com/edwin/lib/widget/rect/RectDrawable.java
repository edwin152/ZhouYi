package com.edwin.lib.widget.rect;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class RectDrawable extends Drawable {

    private Builder mBuilder;

    private RectDrawable(Builder builder) {
        mBuilder = builder;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        mBuilder.mRectF.left = left;
        mBuilder.mRectF.top = top;
        mBuilder.mRectF.right = right;
        mBuilder.mRectF.bottom = bottom;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.drawPath(mBuilder.mPath, mBuilder.mPaint);
        canvas.restore();
    }

    @Override
    public int getIntrinsicWidth() {
        return (int) mBuilder.mRectF.width();
    }

    @Override
    public int getIntrinsicHeight() {
        return (int) mBuilder.mRectF.height();
    }

    @Override
    public void setAlpha(int alpha) {
        mBuilder.mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mBuilder.mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    /**
     * 检测Drawable与源是否相同
     *
     * @param resource 源Drawable
     * @return 是否为同源
     */
    public boolean checkResourceDrawable(Drawable resource) {
        if (resource instanceof ColorDrawable) {
            return false;
        } else if (resource instanceof PaintDrawable) {
            PaintDrawable paintDrawable = (PaintDrawable) resource;
            return paintDrawable.getPaint() != null
                    && mBuilder.mPaint == paintDrawable.getPaint();
        } else if (resource instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) resource;
            return !mBuilder.sourceBitmap.isRecycled()
                    && mBuilder.sourceBitmap == bitmapDrawable.getBitmap();
        } else {
            return mBuilder.sourceDrawable == resource;
        }
    }

    /**
     * 回收资源，可在View detach的时候调用，及时释放View资源，防止内存溢出
     */
    public void recycle() {
        mBuilder.recycle();
    }

    public static class Builder {
        private int mRectLeftTopRadius;
        private int mRectRightTopRadius;
        private int mRectRightBottomRadius;
        private int mRectLeftBottomRadius;
        private boolean isCreatedBitmap;
        private Drawable sourceDrawable;
        private Bitmap sourceBitmap;
        private RectF mRectF;
        private ImageView.ScaleType mScaleType;
        private Bitmap mBitmap;

        private Paint mPaint;
        private Path mPath;

        public Builder(Drawable drawable, RectF rectF) {
            sourceDrawable = drawable;
            mRectF = rectF;
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }

        public Builder setRadius(int leftTopRadius, int rightTopRadius, int rightBottomRadius, int leftBottomRadius) {
            mRectLeftTopRadius = leftTopRadius;
            mRectRightTopRadius = rightTopRadius;
            mRectRightBottomRadius = rightBottomRadius;
            mRectLeftBottomRadius = leftBottomRadius;
            return this;
        }

        public Builder setScaleType(ImageView.ScaleType scaleType) {
            mScaleType = scaleType;
            return this;
        }

        public RectDrawable create() {
            initPaint();
            initPath();
            return new RectDrawable(this);
        }

        private void initPaint() {
            if (sourceDrawable instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) sourceDrawable;
                mPaint.setColor(colorDrawable.getColor());
                mPaint.setAlpha(colorDrawable.getAlpha());
            } else if (sourceDrawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) sourceDrawable;
                if (paintDrawable.getPaint() != null) {
                    mPaint = paintDrawable.getPaint();
                    mPaint.setAntiAlias(true);
                }
            } else if (sourceDrawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) sourceDrawable;
                sourceBitmap = bitmapDrawable.getBitmap();
                mBitmap = RectUtils.createBitmap(sourceBitmap, mRectF, mScaleType);
                isCreatedBitmap = mBitmap != sourceBitmap;
            } else {
                Drawable drawable = sourceDrawable;
                mBitmap = RectUtils.createBitmap(drawable, mRectF);
                isCreatedBitmap = true;
            }

            if (mBitmap != null) {
                mPaint.setShader(new BitmapShader(mBitmap
                        , Shader.TileMode.MIRROR
                        , Shader.TileMode.MIRROR));
            }
        }

        private void initPath() {
//            float rectFWidth = mRectF.width();
//            float rectFHeight = mRectF.height();
//
//            float bitmapWidth = mBitmap.getWidth();
//            float bitmapHeight = mBitmap.getHeight();
//
//            if (bitmapWidth < rectFWidth) {
//                float left = mRectF.left;
//                float right = mRectF.right;
//                float c = rectFWidth - bitmapWidth;
//                mRectF.left = left + c / 2;
//                mRectF.right = right - c / 2;
//            }
//
//            if (bitmapHeight < rectFHeight) {
//                float top = mRectF.top;
//                float bottom = mRectF.bottom;
//                float c = rectFHeight - bitmapHeight;
//                mRectF.top = top + c / 2;
//                mRectF.bottom = bottom - c / 2;
//            }

            mPath = RectUtils.initPath(mRectF
                    , mRectLeftTopRadius
                    , mRectRightTopRadius
                    , mRectRightBottomRadius
                    , mRectLeftBottomRadius);
        }

        private void recycle() {
            if (mBitmap == null || !isCreatedBitmap) {
                return;
            }
            mBitmap.recycle();
        }
    }
}
