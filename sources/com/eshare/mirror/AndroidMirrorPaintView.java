package com.eshare.mirror;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class AndroidMirrorPaintView extends View {

    /* renamed from: b  reason: collision with root package name */
    private Paint f3032b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f3033c;

    /* renamed from: d  reason: collision with root package name */
    private Canvas f3034d;

    /* renamed from: e  reason: collision with root package name */
    private Path f3035e;
    private Paint f;
    private int g = 1;
    private int h = 1;
    private float i;
    private float j;

    public AndroidMirrorPaintView(Context context) {
        super(context);
        a(context);
    }

    public AndroidMirrorPaintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AndroidMirrorPaintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f3032b = new Paint(6);
        this.f3032b.setAntiAlias(true);
        this.f3032b.setDither(true);
        this.f3032b.setStyle(Paint.Style.STROKE);
        this.f3032b.setStrokeJoin(Paint.Join.ROUND);
        this.f3032b.setStrokeCap(Paint.Cap.ROUND);
        this.f3032b.setStrokeWidth(6.0f);
        Bitmap bitmap = this.f3033c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f3033c.recycle();
        }
        this.f3033c = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.ARGB_8888);
        this.f3034d = new Canvas(this.f3033c);
        this.f3035e = new Path();
        this.f = new Paint(6);
    }

    private void b(float f, float f2) {
        this.f3035e.reset();
        this.f3035e.moveTo(f, f2);
        this.i = f;
        this.j = f2;
    }

    public void a() {
        Bitmap bitmap = this.f3033c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f3033c.recycle();
        }
        this.f3033c = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.ARGB_8888);
        this.f3034d = new Canvas(this.f3033c);
        this.f3035e.reset();
        invalidate();
    }

    public void a(float f, float f2) {
        float abs = Math.abs(f - this.i);
        float abs2 = Math.abs(f2 - this.j);
        if (abs >= 4.0f || abs2 >= 4.0f) {
            Path path = this.f3035e;
            float f3 = this.i;
            float f4 = this.j;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.i = f;
            this.j = f2;
        }
    }

    public void b() {
        this.f3035e.lineTo(this.i, this.j);
        this.f3034d.drawPath(this.f3035e, this.f3032b);
        this.f3035e.reset();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f3033c, 0.0f, 0.0f, this.f);
        canvas.drawPath(this.f3035e, this.f3032b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i;
        this.h = i2;
        a();
    }

    @Override // android.view.View
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
        this.f3032b.setColor(i);
    }
}
