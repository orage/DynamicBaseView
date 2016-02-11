package org.orange.dynamicbaseview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by orages on 2016/2/11.
 */
public class DynamicBaseLayout extends FrameLayout {
    public DynamicBaseLayout(Context context) {
        this(context, null, 0);
    }

    public DynamicBaseLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicBaseLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
