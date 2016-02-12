package org.orange.dynamicbaseview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by orages on 2016/2/10.
 */
public class DynamicBaseView extends View {
    private Paint paint = new Paint();

    private int[] layerColors; // 每层颜色
    private int circleSpeed; // 旋转速度
    private int deviationSpeed; // 速度差值
    private float arcL; // 弧长
    private float arcWidth; // 弧宽
    private float arcSpace; // 弧间距
    private boolean isCircle; // 是否为弧形


    public DynamicBaseView(Context context) {
        this(context, null, 0);
    }

    public DynamicBaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DynamicBaseView);
        this.arcL = typedArray.getFloat(R.styleable.DynamicBaseView_arcL, 10);
        this.arcWidth = typedArray.getFloat(R.styleable.DynamicBaseView_arcWidth, 200);
        this.arcSpace = typedArray.getFloat(R.styleable.DynamicBaseView_arcSpace, 5);
        this.circleSpeed = typedArray.getInt(R.styleable.DynamicBaseView_circleSpeed, 16);
        this.deviationSpeed = typedArray.getInt(R.styleable.DynamicBaseView_deviationSpeed, 1);
        this.isCircle = typedArray.getBoolean(R.styleable.DynamicBaseView_isCircle, true);
        typedArray.recycle();
        init();

    }

    private void init() {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthMeasureSpec = resolveSize(60, widthMeasureSpec);
        heightMeasureSpec = resolveSize(60, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (isCircle) {
            DrawCircle(canvas);
        } else {
            DrawPaint(canvas);
        }
        invalidate();

    }


    public void DrawCircle(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.DynamicBaseBlue));
        paint.setStrokeWidth(3f);
        RectF rectL = new RectF();
        rectL.top = 5;
        rectL.left = 5;
        rectL.right = 55;
        rectL.bottom = 55;
        canvas.drawArc(rectL, arcL - deviationSpeed * circleSpeed, arcWidth, false, paint);
        paint.setColor(getResources().getColor(R.color.DynamicBaseGreen));
        paint.setStrokeWidth(2.5f);
        RectF rectM = new RectF();
        rectM.top = 5 + arcSpace;
        rectM.left = 5 + arcSpace;
        rectM.right = 55 - arcSpace;
        rectM.bottom = 55 - arcSpace;
        canvas.drawArc(rectM, arcL - deviationSpeed * (circleSpeed + 2), arcWidth - arcSpace, false, paint);
        paint.setColor(getResources().getColor(R.color.DynamicBaseRed));
        paint.setStrokeWidth(2f);
        RectF rectS = new RectF();
        rectS.top = 5 + arcSpace * 2;
        rectS.left = 5 + arcSpace * 2;
        rectS.right = 55 - arcSpace * 2;
        rectS.bottom = 55 - arcSpace * 2;
        canvas.drawArc(rectS, arcL - deviationSpeed * (circleSpeed + 4), arcWidth - arcSpace * 2, false, paint);
        deviationSpeed++;
    }

    public void DrawPaint(Canvas canvas) {
        // TODO
    }


}