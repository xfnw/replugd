package com.airbnb.lottie.u.k;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.o;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.m;

/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2341a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2342b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2343c;

    /* renamed from: d  reason: collision with root package name */
    private final m<PointF, PointF> f2344d;

    /* renamed from: e  reason: collision with root package name */
    private final b f2345e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;
    private final boolean j;

    /* loaded from: classes.dex */
    public enum a {
        STAR(1),
        POLYGON(2);
        

        /* renamed from: b  reason: collision with root package name */
        private final int f2349b;

        a(int i) {
            this.f2349b = i;
        }

        public static a a(int i) {
            a[] values;
            for (a aVar : values()) {
                if (aVar.f2349b == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z) {
        this.f2341a = str;
        this.f2342b = aVar;
        this.f2343c = bVar;
        this.f2344d = mVar;
        this.f2345e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
        this.j = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, com.airbnb.lottie.u.l.a aVar) {
        return new o(fVar, aVar, this);
    }

    public b a() {
        return this.f;
    }

    public b b() {
        return this.h;
    }

    public String c() {
        return this.f2341a;
    }

    public b d() {
        return this.g;
    }

    public b e() {
        return this.i;
    }

    public b f() {
        return this.f2343c;
    }

    public m<PointF, PointF> g() {
        return this.f2344d;
    }

    public b h() {
        return this.f2345e;
    }

    public a i() {
        return this.f2342b;
    }

    public boolean j() {
        return this.j;
    }
}
