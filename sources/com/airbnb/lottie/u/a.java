package com.airbnb.lottie.u;

import android.graphics.PointF;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f2263a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f2264b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f2265c;

    public a() {
        this.f2263a = new PointF();
        this.f2264b = new PointF();
        this.f2265c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f2263a = pointF;
        this.f2264b = pointF2;
        this.f2265c = pointF3;
    }

    public PointF a() {
        return this.f2263a;
    }

    public void a(float f, float f2) {
        this.f2263a.set(f, f2);
    }

    public PointF b() {
        return this.f2264b;
    }

    public void b(float f, float f2) {
        this.f2264b.set(f, f2);
    }

    public PointF c() {
        return this.f2265c;
    }

    public void c(float f, float f2) {
        this.f2265c.set(f, f2);
    }
}
