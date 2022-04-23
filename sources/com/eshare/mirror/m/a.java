package com.eshare.mirror.m;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3101a;

    /* renamed from: b  reason: collision with root package name */
    private int f3102b;

    public a(byte[] bArr, int i, int i2, long j, boolean z) {
        this.f3101a = new byte[i];
        this.f3102b = i;
        System.arraycopy(bArr, 0, this.f3101a, 0, i);
    }

    public byte[] a() {
        return this.f3101a;
    }

    public int b() {
        return this.f3102b;
    }
}
