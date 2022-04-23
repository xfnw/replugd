package com.airbnb.lottie.y;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f2511a;

    /* renamed from: b  reason: collision with root package name */
    private float f2512b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f, float f2) {
        this.f2511a = f;
        this.f2512b = f2;
    }

    public float a() {
        return this.f2511a;
    }

    public boolean a(float f, float f2) {
        return this.f2511a == f && this.f2512b == f2;
    }

    public float b() {
        return this.f2512b;
    }

    public void b(float f, float f2) {
        this.f2511a = f;
        this.f2512b = f2;
    }

    public String toString() {
        return a() + "x" + b();
    }
}
