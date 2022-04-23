package com.ecloud.eshare.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class CircleBar extends View {

    /* renamed from: b  reason: collision with root package name */
    private Paint f2943b;

    /* renamed from: c  reason: collision with root package name */
    private int f2944c;

    /* renamed from: d  reason: collision with root package name */
    private int f2945d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f2946e;

    public CircleBar(Context context) {
        super(context);
        a();
    }

    public CircleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CircleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f2943b = new Paint(1);
        this.f2943b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2943b.setColor(-3158065);
        int i = this.f2944c;
        canvas.drawCircle(i, i, i, this.f2943b);
        this.f2943b.setColor(-16719803);
        canvas.drawArc(this.f2946e, -90.0f, this.f2945d, true, this.f2943b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f2944c = getWidth() / 2;
        int i3 = this.f2944c;
        this.f2946e = new RectF(0.0f, 0.0f, i3 * 2, i3 * 2);
    }

    public void setProgress(int i) {
        this.f2945d = i;
        postInvalidate();
    }
}
