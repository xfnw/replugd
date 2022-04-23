package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f2164a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f2165b;

    public l(V v) {
        this.f2164a = v;
        this.f2165b = null;
    }

    public l(Throwable th) {
        this.f2165b = th;
        this.f2164a = null;
    }

    public Throwable a() {
        return this.f2165b;
    }

    public V b() {
        return this.f2164a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (b() != null && b().equals(lVar.b())) {
            return true;
        }
        if (a() == null || lVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }
}
