package com.airbnb.lottie.u.k;

import android.graphics.Path;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.g;
import com.airbnb.lottie.u.j.a;
import com.airbnb.lottie.u.j.d;

/* loaded from: classes.dex */
public class m implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2363a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f2364b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2365c;

    /* renamed from: d  reason: collision with root package name */
    private final a f2366d;

    /* renamed from: e  reason: collision with root package name */
    private final d f2367e;
    private final boolean f;

    public m(String str, boolean z, Path.FillType fillType, a aVar, d dVar, boolean z2) {
        this.f2365c = str;
        this.f2363a = z;
        this.f2364b = fillType;
        this.f2366d = aVar;
        this.f2367e = dVar;
        this.f = z2;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, com.airbnb.lottie.u.l.a aVar) {
        return new g(fVar, aVar, this);
    }

    public a a() {
        return this.f2366d;
    }

    public Path.FillType b() {
        return this.f2364b;
    }

    public String c() {
        return this.f2365c;
    }

    public d d() {
        return this.f2367e;
    }

    public boolean e() {
        return this.f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f2363a + '}';
    }
}
