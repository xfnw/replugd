package com.airbnb.lottie.u.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.r;
import com.airbnb.lottie.u.j.h;
import com.airbnb.lottie.u.l.a;

/* loaded from: classes.dex */
public class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2371a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2372b;

    /* renamed from: c  reason: collision with root package name */
    private final h f2373c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2374d;

    public o(String str, int i, h hVar, boolean z) {
        this.f2371a = str;
        this.f2372b = i;
        this.f2373c = hVar;
        this.f2374d = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, a aVar) {
        return new r(fVar, aVar, this);
    }

    public String a() {
        return this.f2371a;
    }

    public h b() {
        return this.f2373c;
    }

    public boolean c() {
        return this.f2374d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f2371a + ", index=" + this.f2372b + '}';
    }
}
