package com.eshare.mirror;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f3059a;

    /* renamed from: b  reason: collision with root package name */
    private long f3060b;

    static {
        new d();
    }

    private d() {
    }

    public static d b(long j) {
        d dVar = new d();
        dVar.a(j);
        return dVar;
    }

    public void a(long j) {
        this.f3059a = j / 1000;
        double d2 = j % 1000;
        Double.isNaN(d2);
        this.f3060b = (long) ((d2 / 1000.0d) * 4.294967296E9d);
    }

    public void a(ByteBuffer byteBuffer, int i) {
        byteBuffer.putInt(i + 4, (int) this.f3059a);
        byteBuffer.putInt(i, (int) this.f3060b);
    }
}
