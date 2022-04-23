package com.airbnb.lottie.u.k;

import android.graphics.Path;
import com.airbnb.lottie.s.b.h;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.c;
import com.airbnb.lottie.u.j.f;
import com.airbnb.lottie.u.l.a;

/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final f f2313a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f2314b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2315c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.u.j.d f2316d;

    /* renamed from: e  reason: collision with root package name */
    private final f f2317e;
    private final f f;
    private final String g;
    private final boolean h;

    public d(String str, f fVar, Path.FillType fillType, c cVar, com.airbnb.lottie.u.j.d dVar, f fVar2, f fVar3, b bVar, b bVar2, boolean z) {
        this.f2313a = fVar;
        this.f2314b = fillType;
        this.f2315c = cVar;
        this.f2316d = dVar;
        this.f2317e = fVar2;
        this.f = fVar3;
        this.g = str;
        this.h = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public com.airbnb.lottie.s.b.c a(com.airbnb.lottie.f fVar, a aVar) {
        return new h(fVar, aVar, this);
    }

    public f a() {
        return this.f;
    }

    public Path.FillType b() {
        return this.f2314b;
    }

    public c c() {
        return this.f2315c;
    }

    public f d() {
        return this.f2313a;
    }

    public String e() {
        return this.g;
    }

    public com.airbnb.lottie.u.j.d f() {
        return this.f2316d;
    }

    public f g() {
        return this.f2317e;
    }

    public boolean h() {
        return this.h;
    }
}
