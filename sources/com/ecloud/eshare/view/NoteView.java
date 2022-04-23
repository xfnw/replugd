package com.ecloud.eshare.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import b.b.a.f;

/* loaded from: classes.dex */
public class NoteView extends View {

    /* renamed from: b  reason: collision with root package name */
    private Paint f2956b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f2957c;

    /* renamed from: d  reason: collision with root package name */
    private Canvas f2958d;

    /* renamed from: e  reason: collision with root package name */
    private Path f2959e;
    private float j;
    private float k;
    private long l;
    private boolean n;
    private f o;
    private int f = 4;
    private int g = -65536;
    private int h = 1;
    private int i = 1;
    private boolean m = false;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!NoteView.this.n && System.currentTimeMillis() - NoteView.this.l > 1000) {
                NoteView.this.f2959e.reset();
                NoteView.this.f2959e.addCircle(0.0f, 0.0f, 0.0f, Path.Direction.CCW);
                NoteView.this.invalidate();
            }
        }
    }

    public NoteView(Context context) {
        super(context);
        a(context);
    }

    public NoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public NoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(float f, float f2) {
        float abs = Math.abs(f - this.j);
        float abs2 = Math.abs(f2 - this.k);
        if (abs > 0.0f || abs2 > 0.0f) {
            Path path = this.f2959e;
            float f3 = this.j;
            float f4 = this.k;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.j = f;
            this.k = f2;
        }
    }

    private void a(Context context) {
        this.f2956b = new Paint();
        this.f2956b.setAntiAlias(true);
        this.f2956b.setDither(true);
        this.f2956b.setStyle(Paint.Style.STROKE);
        this.f2956b.setStrokeJoin(Paint.Join.ROUND);
        this.f2956b.setStrokeCap(Paint.Cap.ROUND);
        this.f2956b.setStrokeWidth(this.f);
        this.o = b.b.a.a.a(context).c();
        this.f2956b.setColor(this.g);
        Bitmap bitmap = this.f2957c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2957c.recycle();
        }
        this.f2957c = Bitmap.createBitmap(this.h, this.i, Bitmap.Config.ARGB_8888);
        this.f2958d = new Canvas(this.f2957c);
        this.f2958d.drawColor(0);
        this.f2959e = new Path();
    }

    private void b(float f, float f2) {
        this.f2959e.moveTo(f, f2);
        this.j = f;
        this.k = f2;
    }

    private void c(float f, float f2) {
        this.f2959e.lineTo(f, f2);
        this.f2958d.drawPath(this.f2959e, this.f2956b);
        invalidate();
        this.j = 0.0f;
        this.k = 0.0f;
    }

    public void a() {
        Bitmap bitmap = this.f2957c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2957c.recycle();
            this.f2957c = Bitmap.createBitmap(this.h, this.i, Bitmap.Config.ARGB_8888);
            this.f2958d.setBitmap(this.f2957c);
        }
        Path path = this.f2959e;
        if (path != null) {
            path.reset();
            this.f2959e.addCircle(0.0f, 0.0f, 0.0f, Path.Direction.CCW);
        }
        invalidate();
    }

    public void b() {
        Bitmap bitmap = this.f2957c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2957c.recycle();
        }
        this.f2957c = Bitmap.createBitmap(this.h, this.i, Bitmap.Config.ARGB_8888);
        this.f2958d = new Canvas(this.f2957c);
        this.f2959e.reset();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.f2959e, this.f2956b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        this.i = i2;
        b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.o.a(this.g, this.f);
        }
        if (motionEvent.getActionIndex() == 0) {
            this.o.a(motionEvent, getWidth(), getHeight());
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = true;
            b(x, y);
        } else if (action == 1) {
            c(x, y);
            this.l = System.currentTimeMillis();
            this.n = false;
            postDelayed(new a(), 1500L);
        } else if (action == 2) {
            a(x, y);
            invalidate();
        }
        return true;
    }

    public void setAlpha(int i) {
        this.f2956b.setAlpha(i);
    }

    public void setColor(int i) {
        this.f2956b.setColor(i);
    }

    public void setEraser(boolean z) {
        Paint paint;
        float f;
        this.m = z;
        if (this.m) {
            this.f2956b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paint = this.f2956b;
            f = 30.0f;
        } else {
            this.f2956b.setXfermode(null);
            paint = this.f2956b;
            f = this.f;
        }
        paint.setStrokeWidth(f);
    }

    public void setLine(int i) {
        this.f2956b.setStrokeWidth(i);
    }

    public void setPenColor(int i) {
        this.g = i;
        this.f2956b.setColor(i);
    }

    public void setPenSize(int i) {
        this.f = i;
        this.f2956b.setStrokeWidth(i);
    }
}
