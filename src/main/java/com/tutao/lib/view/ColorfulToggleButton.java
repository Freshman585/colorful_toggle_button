package com.tutao.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


import com.tutao.lib.R;

/**
 * Created by Aron on 16/6/3.
 */
public class ColorfulToggleButton extends View {

    //togglebutton显示为圆形
    public final static int CIRCLE = 1;

    //togglebutton显示为方形
    public final static int SQUARE = 2;

    //边框颜色
    private int borderColor = 0xFFB2B2B2;

    //内部颜色
    private int solidColor = 0x00FF00;

    //边框线粗细
    private float borderLine = 1.0f;

    //边框和内部的间距
    private float innerDiffOutter = 1;

    //边框是否显示
    private boolean borderVisible = false;

    //是圆形还是方形
    private int type = CIRCLE;

    private Paint paint;

    //设置内部填充颜色
    public void setSolidColor(int color) {
        solidColor = color;
        invalidate();
    }

    //设置边框颜色
    public void setBorderColor(int color) {
        borderColor = color;
        invalidate();
    }

    //设置方形或圆形
    public void setType(int type) {
        this.type = type;
        invalidate();
    }

    public ColorfulToggleButton(Context context) {
        this(context, null);
    }

    public ColorfulToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorfulToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColorfulToggleButton, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.ColorfulToggleButton_borderColor) {
                borderColor = a.getColor(attr, Color.BLACK);
            } else if (attr == R.styleable.ColorfulToggleButton_solidColor) {
                solidColor = a.getColor(attr, Color.GREEN);
            } else if (attr == R.styleable.ColorfulToggleButton_borderLine) {
                borderLine = a.getDimension(attr, 1);
            } else if (attr == R.styleable.ColorfulToggleButton_innerDiffOutter) {
                innerDiffOutter = a.getDimension(attr, 1);
            } else if (attr == R.styleable.ColorfulToggleButton_type) {
                type = a.getInt(attr, 1);
            }
        }
        a.recycle();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(solidColor);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (type == CIRCLE) {
            drawCircle(canvas);
        } else {
            drawRect(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        int xpos = getMeasuredWidth() / 2;
        int ypos = getMeasuredHeight() / 2;

        int halfW = getMeasuredWidth() / 2;
        int halfH = getMeasuredHeight() / 2;

        if (borderVisible) {
            paint.setColor(borderColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(borderLine);
            canvas.drawCircle(xpos, ypos, halfH - borderLine, paint);
        }
        paint.setColor(solidColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(xpos, ypos, halfH - borderLine - innerDiffOutter, paint);
    }

    private void drawRect(Canvas canvas) {
        int xpos = getMeasuredWidth() / 2;
        int ypos = getMeasuredHeight() / 2;

        int halfW = getMeasuredWidth() / 2;
        int halfH = getMeasuredHeight() / 2;

        if (borderVisible) {
            paint.setColor(borderColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(borderLine);
            canvas.drawRect(borderLine, borderLine, getMeasuredWidth() - borderLine, getMeasuredHeight() - borderLine, paint);
        }
        paint.setColor(solidColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(innerDiffOutter+borderLine, innerDiffOutter+borderLine,
                getMeasuredWidth() - borderLine - innerDiffOutter,
                getMeasuredHeight() - borderLine - innerDiffOutter,
                paint);
    }

    public boolean isBorderVisible() {
        return borderVisible;
    }

    /**
     * 设置边框是否显示
     * */
    public void setBorderVisible(boolean borderVisible) {
        this.borderVisible = borderVisible;
        invalidate();
    }

}
