package com.airbnb.lottie.u;

import a.g.k.d;

/* loaded from: classes.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    T f2291a;

    /* renamed from: b  reason: collision with root package name */
    T f2292b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f2291a = t;
        this.f2292b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return b(dVar.f282a, this.f2291a) && b(dVar.f283b, this.f2292b);
    }

    public int hashCode() {
        T t = this.f2291a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f2292b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f2291a) + " " + String.valueOf(this.f2292b) + "}";
    }
}
