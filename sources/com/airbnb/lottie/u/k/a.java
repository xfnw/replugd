package com.airbnb.lottie.u.k;

import android.graphics.PointF;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.u.j.f;
import com.airbnb.lottie.u.j.m;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2306a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f2307b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2308c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2309d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2310e;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z, boolean z2) {
        this.f2306a = str;
        this.f2307b = mVar;
        this.f2308c = fVar;
        this.f2309d = z;
        this.f2310e = z2;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar) {
        return new com.airbnb.lottie.s.b.f(fVar, aVar, this);
    }

    public String a() {
        return this.f2306a;
    }

    public m<PointF, PointF> b() {
        return this.f2307b;
    }

    public f c() {
        return this.f2308c;
    }

    public boolean d() {
        return this.f2310e;
    }

    public boolean e() {
        return this.f2309d;
    }
}
