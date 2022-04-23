package com.airbnb.lottie.u.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.t;
import com.airbnb.lottie.u.j.b;

/* loaded from: classes.dex */
public class q implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2390a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2391b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2392c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2393d;

    /* renamed from: e  reason: collision with root package name */
    private final b f2394e;
    private final boolean f;

    /* loaded from: classes.dex */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a a(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public q(String str, a aVar, b bVar, b bVar2, b bVar3, boolean z) {
        this.f2390a = str;
        this.f2391b = aVar;
        this.f2392c = bVar;
        this.f2393d = bVar2;
        this.f2394e = bVar3;
        this.f = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, com.airbnb.lottie.u.l.a aVar) {
        return new t(aVar, this);
    }

    public b a() {
        return this.f2393d;
    }

    public String b() {
        return this.f2390a;
    }

    public b c() {
        return this.f2394e;
    }

    public b d() {
        return this.f2392c;
    }

    public a e() {
        return this.f2391b;
    }

    public boolean f() {
        return this.f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f2392c + ", end: " + this.f2393d + ", offset: " + this.f2394e + "}";
    }
}
