package com.ecloud.eshare.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ProgressCircle extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f2976b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f2977c;

    /* renamed from: d  reason: collision with root package name */
    private int f2978d;

    /* renamed from: e  reason: collision with root package name */
    private int f2979e;
    private RectF f;

    public ProgressCircle(Context context) {
        super(context);
        a();
    }

    public ProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f2977c = new Paint(1);
        this.f2977c.setStyle(Paint.Style.STROKE);
        this.f2977c.setStrokeWidth(30.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f2977c.setColor(Integer.MIN_VALUE);
        int i = this.f2979e;
        canvas.drawCircle(i, i, i, this.f2977c);
        this.f2977c.setColor(-1);
        canvas.drawArc(this.f, -90.0f, this.f2976b, false, this.f2977c);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2978d == 0) {
            this.f2978d = getMeasuredWidth();
            int i3 = this.f2978d;
            this.f2979e = i3 / 2;
            this.f = new RectF(0.0f, 0.0f, i3, i3);
        }
    }

    public void setProgress(int i) {
        this.f2976b = (i * 360) / 100;
        postInvalidate();
    }
}
