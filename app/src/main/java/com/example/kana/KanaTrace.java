package com.example.kana;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import android.content.Context;

public class KanaTrace extends View {
    public static int BRUSH_SIZE = 20;
    public static int COLOR = Color.BLACK;
    public static int DEFAULT_BG_COLOR = Color.TRANSPARENT;
    private static final float TOUCH_TOLERANCE = 4;
    private float x, y;
    private Path path;
    private Paint paint;
    private ArrayList<FingerPath> paths = new ArrayList();
    private int currentColor;
    private int backgroundColor = DEFAULT_BG_COLOR;
    private int strokeWidth;
    private MaskFilter mEmboss;
    private MaskFilter mBlur;
    private Bitmap bitmap;
    private Canvas mCanvas;
    private Paint bitmapPaint = new Paint(Paint.DITHER_FLAG);

    public KanaTrace(Context context) {
        this(context, null);
    }

    public KanaTrace(Context context, AttributeSet attr) {
        super(context, attr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(COLOR);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setXfermode(null);
        paint.setAlpha(0xff);

        mEmboss = new EmbossMaskFilter(new float[] {1, 1, 1}, 0.4f, 6, 3.5f);
        mBlur = new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL);
    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);
        mCanvas.save();

        currentColor = COLOR;
        strokeWidth = BRUSH_SIZE;
    }

    public void clear() {
        findViewById(R.id.traceView).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        bitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mCanvas.drawColor(backgroundColor);

        for (FingerPath fp : paths) {
            paint.setColor(fp.color);
            paint.setStrokeWidth(fp.strokeWidth);
            paint.setMaskFilter(null);

            if (fp.emboss)
                paint.setMaskFilter(mEmboss);
            else if (fp.blur)
                paint.setMaskFilter(mBlur);

            mCanvas.drawPath(fp.path, paint);
        }

        canvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
        canvas.restore();
    }

    private void touchStart(float a, float b) {
        path = new Path();
        FingerPath fp = new FingerPath(currentColor, false, false, strokeWidth, path);
        paths.add(fp);

        path.reset();
        path.moveTo(a, b);
        x = a;
        y = b;
    }

    private void touchMove(float a, float b) {
        float dx = Math.abs(a - x);
        float dy = Math.abs(b - y);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            path.quadTo(x, y, (a + x) / 2, (b + y) / 2);
            x = a;
            y = b;
        }
    }

    private void touchUp() {
        path.lineTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float a = event.getX();
        float b = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(a, b);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(a, b);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUp();
                invalidate();
                break;
        }
        return true;
    }
}