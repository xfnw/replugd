package com.airbnb.lottie.x;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private float f2496a;

    /* renamed from: b  reason: collision with root package name */
    private int f2497b;

    public void a(float f) {
        this.f2496a += f;
        this.f2497b++;
        int i = this.f2497b;
        if (i == Integer.MAX_VALUE) {
            this.f2496a /= 2.0f;
            this.f2497b = i / 2;
        }
    }
}
