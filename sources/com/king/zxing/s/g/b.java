package com.king.zxing.s.g;

import android.hardware.Camera;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f3341a;

    /* renamed from: b  reason: collision with root package name */
    private final Camera f3342b;

    /* renamed from: c  reason: collision with root package name */
    private final a f3343c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3344d;

    public b(int i, Camera camera, a aVar, int i2) {
        this.f3341a = i;
        this.f3342b = camera;
        this.f3343c = aVar;
        this.f3344d = i2;
    }

    public Camera a() {
        return this.f3342b;
    }

    public a b() {
        return this.f3343c;
    }

    public int c() {
        return this.f3344d;
    }

    public String toString() {
        return "Camera #" + this.f3341a + " : " + this.f3343c + ',' + this.f3344d;
    }
}
