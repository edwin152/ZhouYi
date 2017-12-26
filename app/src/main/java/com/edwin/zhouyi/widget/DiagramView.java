package com.edwin.zhouyi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.edwin.zhouyi.R;
import com.edwin.zhouyi.enums.Diagram;

/**
 * simple describe
 *
 * @author edwin
 * @since 26/12/2017
 */
public class DiagramView extends FrameLayout {

    private ImageView iv_top;
    private ImageView iv_middle;
    private ImageView iv_bottom;

    private Diagram name;

    public DiagramView(@NonNull Context context) {
        this(context, null);
    }

    public DiagramView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagramView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.widget_diagram, this);
        iv_top = findViewById(R.id.top);
        iv_middle = findViewById(R.id.middle);
        iv_bottom = findViewById(R.id.bottom);

        if (attrs == null)
            return;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DiagramView);
        int name = a.getInt(R.styleable.DiagramView_name_single, 0);
        setName(Diagram.parse(name));
        a.recycle();

    }

    public void setName(Diagram name) {
        if (name == null)
            return;
        this.name = name;
        switch (name) {
            case QIAN:
                iv_top.setImageResource(R.drawable.yang);
                iv_middle.setImageResource(R.drawable.yang);
                iv_bottom.setImageResource(R.drawable.yang);
                break;
            case KUN:
                iv_top.setImageResource(R.drawable.yin);
                iv_middle.setImageResource(R.drawable.yin);
                iv_bottom.setImageResource(R.drawable.yin);
                break;
            case ZHEN:
                iv_top.setImageResource(R.drawable.yin);
                iv_middle.setImageResource(R.drawable.yin);
                iv_bottom.setImageResource(R.drawable.yang);
                break;
            case GEN:
                iv_top.setImageResource(R.drawable.yang);
                iv_middle.setImageResource(R.drawable.yin);
                iv_bottom.setImageResource(R.drawable.yin);
                break;
            case LI:
                iv_top.setImageResource(R.drawable.yang);
                iv_middle.setImageResource(R.drawable.yin);
                iv_bottom.setImageResource(R.drawable.yang);
                break;
            case KAN:
                iv_top.setImageResource(R.drawable.yin);
                iv_middle.setImageResource(R.drawable.yang);
                iv_bottom.setImageResource(R.drawable.yin);
                break;
            case DUI:
                iv_top.setImageResource(R.drawable.yin);
                iv_middle.setImageResource(R.drawable.yang);
                iv_bottom.setImageResource(R.drawable.yang);
                break;
            case XUN:
                iv_top.setImageResource(R.drawable.yang);
                iv_middle.setImageResource(R.drawable.yang);
                iv_bottom.setImageResource(R.drawable.yin);
                break;
        }
    }

    public Diagram getName() {
        return name;
    }

}
