package com.airbnb.lottie.u.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.q;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.l;
import com.airbnb.lottie.u.l.a;

/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2355a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2356b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2357c;

    /* renamed from: d  reason: collision with root package name */
    private final l f2358d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2359e;

    public k(String str, b bVar, b bVar2, l lVar, boolean z) {
        this.f2355a = str;
        this.f2356b = bVar;
        this.f2357c = bVar2;
        this.f2358d = lVar;
        this.f2359e = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, a aVar) {
        return new q(fVar, aVar, this);
    }

    public b a() {
        return this.f2356b;
    }

    public String b() {
        return this.f2355a;
    }

    public b c() {
        return this.f2357c;
    }

    public l d() {
        return this.f2358d;
    }

    public boolean e() {
        return this.f2359e;
    }
}
