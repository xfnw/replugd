package com.eshare.mirror;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class PaintView extends View {

    /* renamed from: b  reason: collision with root package name */
    private Paint f3044b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f3045c;

    /* renamed from: d  reason: collision with root package name */
    private Canvas f3046d;

    /* renamed from: e  reason: collision with root package name */
    private Path f3047e;
    private Paint f;
    private int g = 1;
    private int h = 1;
    private float i;
    private float j;

    public PaintView(Context context) {
        super(context);
        a(context);
    }

    public PaintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PaintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f3044b = new Paint(6);
        this.f3044b.setAntiAlias(true);
        this.f3044b.setDither(true);
        this.f3044b.setStyle(Paint.Style.STROKE);
        this.f3044b.setStrokeJoin(Paint.Join.ROUND);
        this.f3044b.setStrokeCap(Paint.Cap.ROUND);
        this.f3044b.setStrokeWidth(6.0f);
        Bitmap bitmap = this.f3045c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f3045c.recycle();
        }
        this.f3045c = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.ARGB_8888);
        this.f3046d = new Canvas(this.f3045c);
        this.f3047e = new Path();
        this.f = new Paint(6);
    }

    private void b(float f, float f2) {
        this.f3047e.reset();
        this.f3047e.moveTo(f, f2);
        this.i = f;
        this.j = f2;
    }

    public void a() {
        Bitmap bitmap = this.f3045c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f3045c.recycle();
        }
        this.f3045c = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.ARGB_8888);
        this.f3046d = new Canvas(this.f3045c);
        this.f3047e.reset();
        invalidate();
    }

    public void a(float f, float f2) {
        float abs = Math.abs(f - this.i);
        float abs2 = Math.abs(f2 - this.j);
        if (abs >= 4.0f || abs2 >= 4.0f) {
            Path path = this.f3047e;
            float f3 = this.i;
            float f4 = this.j;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.i = f;
            this.j = f2;
        }
    }

    public void b() {
        this.f3047e.lineTo(this.i, this.j);
        this.f3046d.drawPath(this.f3047e, this.f3044b);
        this.f3047e.reset();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f3045c, 0.0f, 0.0f, this.f);
        canvas.drawPath(this.f3047e, this.f3044b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i;
        this.h = i2;
        a();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                b();
            } else if (action == 2) {
                a(x, y);
            }
            invalidate();
        } else {
            b(x, y);
        }
        return true;
    }

    public void setColor(int i) {
        this.f3044b.setColor(i);
    }
}
