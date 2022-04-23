package com.airbnb.lottie.y;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d f2504a;

    /* renamed from: b  reason: collision with root package name */
    public final T f2505b;

    /* renamed from: c  reason: collision with root package name */
    public T f2506c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f2507d;

    /* renamed from: e  reason: collision with root package name */
    public final float f2508e;
    public Float f;
    private float g;
    private float h;
    private int i;
    private int j;
    private float k;
    private float l;
    public PointF m;
    public PointF n;

    public a(d dVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.g = -3987645.8f;
        this.h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.f2504a = dVar;
        this.f2505b = t;
        this.f2506c = t2;
        this.f2507d = interpolator;
        this.f2508e = f;
        this.f = f2;
    }

    public a(T t) {
        this.g = -3987645.8f;
        this.h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.f2504a = null;
        this.f2505b = t;
        this.f2506c = t;
        this.f2507d = null;
        this.f2508e = Float.MIN_VALUE;
        this.f = Float.valueOf(Float.MAX_VALUE);
    }

    public float a() {
        if (this.f2504a == null) {
            return 1.0f;
        }
        if (this.l == Float.MIN_VALUE) {
            if (this.f == null) {
                this.l = 1.0f;
            } else {
                this.l = d() + ((this.f.floatValue() - this.f2508e) / this.f2504a.d());
            }
        }
        return this.l;
    }

    public boolean a(float f) {
        return f >= d() && f < a();
    }

    public float b() {
        if (this.h == -3987645.8f) {
            this.h = ((Float) this.f2506c).floatValue();
        }
        return this.h;
    }

    public int c() {
        if (this.j == 784923401) {
            this.j = ((Integer) this.f2506c).intValue();
        }
        return this.j;
    }

    public float d() {
        d dVar = this.f2504a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.f2508e - dVar.l()) / this.f2504a.d();
        }
        return this.k;
    }

    public float e() {
        if (this.g == -3987645.8f) {
            this.g = ((Float) this.f2505b).floatValue();
        }
        return this.g;
    }

    public int f() {
        if (this.i == 784923401) {
            this.i = ((Integer) this.f2505b).intValue();
        }
        return this.i;
    }

    public boolean g() {
        return this.f2507d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f2505b + ", endValue=" + this.f2506c + ", startFrame=" + this.f2508e + ", endFrame=" + this.f + ", interpolator=" + this.f2507d + '}';
    }
}
