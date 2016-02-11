package org.orange.dynamicbaseview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

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
    private boolean isCircle; // 是否为弧形

    public static final int FAST = 1;
    public static final int MEDIUM = 0;
    public static final int SLOW = 2;

    private static final int PARALLAX_FAST = 60;
    private static final int PARALLAX_MEDIUM = 72;
    private static final int PARALLAX_SLOW = 90;

    private int i = 1;

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
        this.arcWidth = typedArray.getFloat(R.styleable.DynamicBaseView_arcWidth, 50);
        this.circleSpeed = typedArray.getInt(R.styleable.DynamicBaseView_circleSpeed, 20);
        this.deviationSpeed = typedArray.getInt(R.styleable.DynamicBaseView_deviationSpeed, 20);
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
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void DrawCircle(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.DynamicBaseBlue));
        paint.setStrokeWidth(5f);
        canvas.drawArc(100, 100, 200, 200, arcL - i * 16, arcWidth, false, paint);
        paint.setColor(getResources().getColor(R.color.DynamicBaseGreen));
        paint.setStrokeWidth(4.5f);
        canvas.drawArc(100 + 10, 100 + 10, 200 - 10, 200 - 10, arcL - i * 17, arcWidth - 10, false, paint);
        paint.setColor(getResources().getColor(R.color.DynamicBaseRed));
        paint.setStrokeWidth(4f);
        canvas.drawArc(100 + 20, 100 + 20, 200 - 20, 200 - 20, arcL - i * 18, arcWidth - 20, false, paint);
        i++;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void DrawPaint(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.DynamicBaseBlue));
        paint.setStrokeWidth(5f);
        canvas.drawArc(100, 100, 200, 200, arcL - i * 16, arcWidth, false, paint);
        paint.setColor(getResources().getColor(R.color.DynamicBaseGreen));
        paint.setStrokeWidth(4.5f);
        canvas.drawArc(100 + 10, 100 + 10, 200 - 10, 200 - 10, arcL - i * 17, arcWidth - 10, false, paint);
        paint.setColor(getResources().getColor(R.color.DynamicBaseRed));
        paint.setStrokeWidth(4f);
        canvas.drawArc(100 + 20, 100 + 20, 200 - 20, 200 - 20, arcL - i * 18, arcWidth - 20, false, paint);
        i++;
    }


}