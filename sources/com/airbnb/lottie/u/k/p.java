package com.airbnb.lottie.u.k;

import android.graphics.Paint;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.s;
import com.airbnb.lottie.u.j.d;
import java.util.List;

/* loaded from: classes.dex */
public class p implements com.airbnb.lottie.u.k.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2375a;

    /* renamed from: b  reason: collision with root package name */
    private final com.airbnb.lottie.u.j.b f2376b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.airbnb.lottie.u.j.b> f2377c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.u.j.a f2378d;

    /* renamed from: e  reason: collision with root package name */
    private final d f2379e;
    private final com.airbnb.lottie.u.j.b f;
    private final b g;
    private final c h;
    private final float i;
    private final boolean j;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2380a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2381b = new int[c.values().length];

        static {
            try {
                f2381b[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2381b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2381b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2380a = new int[b.values().length];
            try {
                f2380a[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2380a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2380a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i = a.f2380a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i = a.f2381b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, com.airbnb.lottie.u.j.b bVar, List<com.airbnb.lottie.u.j.b> list, com.airbnb.lottie.u.j.a aVar, d dVar, com.airbnb.lottie.u.j.b bVar2, b bVar3, c cVar, float f, boolean z) {
        this.f2375a = str;
        this.f2376b = bVar;
        this.f2377c = list;
        this.f2378d = aVar;
        this.f2379e = dVar;
        this.f = bVar2;
        this.g = bVar3;
        this.h = cVar;
        this.i = f;
        this.j = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public com.airbnb.lottie.s.b.c a(f fVar, com.airbnb.lottie.u.l.a aVar) {
        return new s(fVar, aVar, this);
    }

    public b a() {
        return this.g;
    }

    public com.airbnb.lottie.u.j.a b() {
        return this.f2378d;
    }

    public com.airbnb.lottie.u.j.b c() {
        return this.f2376b;
    }

    public c d() {
        return this.h;
    }

    public List<com.airbnb.lottie.u.j.b> e() {
        return this.f2377c;
    }

    public float f() {
        return this.i;
    }

    public String g() {
        return this.f2375a;
    }

    public d h() {
        return this.f2379e;
    }

    public com.airbnb.lottie.u.j.b i() {
        return this.f;
    }

    public boolean j() {
        return this.j;
    }
}
