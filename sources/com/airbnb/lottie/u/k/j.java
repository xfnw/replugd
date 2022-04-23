package com.airbnb.lottie.u.k;

import android.graphics.PointF;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.p;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.f;
import com.airbnb.lottie.u.j.m;
import com.airbnb.lottie.u.l.a;

/* loaded from: classes.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2350a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f2351b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2352c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2353d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2354e;

    public j(String str, m<PointF, PointF> mVar, f fVar, b bVar, boolean z) {
        this.f2350a = str;
        this.f2351b = mVar;
        this.f2352c = fVar;
        this.f2353d = bVar;
        this.f2354e = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(com.airbnb.lottie.f fVar, a aVar) {
        return new p(fVar, aVar, this);
    }

    public b a() {
        return this.f2353d;
    }

    public String b() {
        return this.f2350a;
    }

    public m<PointF, PointF> c() {
        return this.f2351b;
    }

    public f d() {
        return this.f2352c;
    }

    public boolean e() {
        return this.f2354e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f2351b + ", size=" + this.f2352c + '}';
    }
}
