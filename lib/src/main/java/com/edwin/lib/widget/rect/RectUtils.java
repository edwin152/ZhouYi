package com.edwin.lib.widget.rect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class RectUtils {

    /**
     * 初始化边框画笔
     *
     * @param strokeColor 边框颜色
     * @param strokeWidth 边框宽度
     * @return 画笔
     */
    public static Paint initPaint(int strokeColor, int strokeWidth) {
        Paint strokePaint = new Paint();
        strokePaint.setAntiAlias(true);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(strokeColor);
        strokePaint.setStrokeWidth(strokeWidth);
        return strokePaint;
    }

    /**
     * 初始化矩形path
     *
     * @param rectF             矩形
     * @param leftTopRadius     左上角弧度
     * @param rightTopRadius    右上角弧度
     * @param rightBottomRadius 右下角弧度
     * @param leftBottomRadius  左下角弧度
     * @return path
     */
    public static Path initPath(RectF rectF
            , int leftTopRadius
            , int rightTopRadius
            , int rightBottomRadius
            , int leftBottomRadius) {
        Path path = new Path();
        // 起点
        path.moveTo(rectF.left, rectF.top + leftTopRadius);
        // 左上角弧线
        path.arcTo(rectF.left
                , rectF.top
                , rectF.left + leftTopRadius
                , rectF.top + leftTopRadius
                , 180
                , 90
                , false);
        // 顶部直线
        path.lineTo(rectF.right - rightTopRadius, rectF.top);
        // 右上角弧线
        path.arcTo(rectF.right - rightTopRadius
                , rectF.top
                , rectF.right
                , rectF.top + rightTopRadius
                , 270
                , 90
                , false);
        // 右侧直线
        path.lineTo(rectF.right, rectF.bottom - rightBottomRadius);
        // 右下角弧线
        path.arcTo(rectF.right - rightBottomRadius
                , rectF.bottom - rightBottomRadius
                , rectF.right
                , rectF.bottom
                , 0
                , 90
                , false);
        // 底部直线
        path.lineTo(rectF.left + leftBottomRadius, rectF.bottom);
        // 左下角弧线
        path.arcTo(rectF.left
                , rectF.bottom - leftBottomRadius
                , rectF.left + leftBottomRadius
                , rectF.bottom
                , 90
                , 90
                , false);
        // 左侧直线
        path.lineTo(rectF.left, rectF.top + leftTopRadius);
        path.close();
        return path;
    }

    /**
     * 创建矩形bitmap，适用于bitmap转bitmap
     *
     * @param bitmap    源bitmap
     * @param rectF     矩形
     * @param scaleType 切割类型
     * @return bitmap
     */
    public static Bitmap createBitmap(Bitmap bitmap, RectF rectF, @Nullable ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        double bitmapX = bitmap.getWidth();
        double bitmapY = bitmap.getHeight();
        double rectX = rectF.width();
        double rectY = rectF.height();

        // 根据scale type设置Maxtrix 切割bitmap
        Matrix matrix = new Matrix();
        double scaleX = rectX / bitmapX;
        double scaleY = rectY / bitmapY;
        switch (scaleType) {
            case FIT_XY:
                matrix.postScale((float) scaleX, (float) scaleY);
                return Bitmap.createBitmap(bitmap
                        , 0
                        , 0
                        , (int) bitmapX
                        , (int) bitmapY
                        , matrix
                        , true);
            case CENTER_CROP:
//                if (bitmapX <= rectX && bitmapY <= rectY) {
//                    return bitmap;
//                }
                double scaleCrop = Math.max(scaleX, scaleY);
                matrix.postScale((float) scaleCrop, (float) scaleCrop);
                return Bitmap.createBitmap(bitmap
                        , (int) Math.max(0, (bitmapX * scaleCrop - rectX) / 2 / scaleCrop)
                        , (int) Math.max(0, (bitmapY * scaleCrop - rectY) / 2 / scaleCrop)
                        , (int) Math.min(rectX / scaleCrop, bitmapX)
                        , (int) Math.min(rectY / scaleCrop, bitmapY)
                        , matrix
                        , true);
            case FIT_CENTER:
            default:
                matrix.postScale((float) scaleX, (float) scaleX);
                return Bitmap.createBitmap(bitmap
                        , 0
                        , (int) Math.max(0, (bitmapY * scaleX - rectY) / 2 / scaleX)
                        , (int) bitmapX
                        , (int) Math.min(rectY / scaleX, bitmapY)
                        , matrix
                        , true);
        }
    }

    /**
     * 创建bitmap 适用于ColorDrawable、PaintDrawable等
     *
     * @param drawable 源drawable
     * @param rectF    矩形
     * @return bitmap
     */
    public static Bitmap createBitmap(Drawable drawable, RectF rectF) {
        Bitmap bitmap = Bitmap.createBitmap((int) rectF.width()
                , (int) rectF.height()
                , drawable.getOpacity() != PixelFormat.OPAQUE
                        ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        if (drawable.getIntrinsicWidth() <= 0
                || drawable.getIntrinsicHeight() <= 0) {
            drawable.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
        }
        drawable.draw(canvas);
        return bitmap;
    }
}
