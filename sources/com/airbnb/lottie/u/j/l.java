package com.airbnb.lottie.u.j;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.m;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.u.k.b;
import com.airbnb.lottie.u.l.a;

/* loaded from: classes.dex */
public class l implements m, b {

    /* renamed from: a  reason: collision with root package name */
    private final e f2300a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f2301b;

    /* renamed from: c  reason: collision with root package name */
    private final g f2302c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2303d;

    /* renamed from: e  reason: collision with root package name */
    private final d f2304e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, b bVar2, b bVar3, b bVar4, b bVar5) {
        this.f2300a = eVar;
        this.f2301b = mVar;
        this.f2302c = gVar;
        this.f2303d = bVar;
        this.f2304e = dVar;
        this.h = bVar2;
        this.i = bVar3;
        this.f = bVar4;
        this.g = bVar5;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, a aVar) {
        return null;
    }

    public o a() {
        return new o(this);
    }

    public e b() {
        return this.f2300a;
    }

    public b c() {
        return this.i;
    }

    public d d() {
        return this.f2304e;
    }

    public m<PointF, PointF> e() {
        return this.f2301b;
    }

    public b f() {
        return this.f2303d;
    }

    public g g() {
        return this.f2302c;
    }

    public b h() {
        return this.f;
    }

    public b i() {
        return this.g;
    }

    public b j() {
        return this.h;
    }
}
