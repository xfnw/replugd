package com.airbnb.lottie.u.l;

import com.airbnb.lottie.u.j.j;
import com.airbnb.lottie.u.j.k;
import com.airbnb.lottie.u.j.l;
import com.airbnb.lottie.u.k.g;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.airbnb.lottie.u.k.b> f2408a;

    /* renamed from: b  reason: collision with root package name */
    private final com.airbnb.lottie.d f2409b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2410c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2411d;

    /* renamed from: e  reason: collision with root package name */
    private final a f2412e;
    private final long f;
    private final String g;
    private final List<g> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final com.airbnb.lottie.u.j.b s;
    private final List<com.airbnb.lottie.y.a<Float>> t;
    private final b u;
    private final boolean v;

    /* loaded from: classes.dex */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum b {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public d(List<com.airbnb.lottie.u.k.b> list, com.airbnb.lottie.d dVar, String str, long j, a aVar, long j2, String str2, List<g> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, j jVar, k kVar, List<com.airbnb.lottie.y.a<Float>> list3, b bVar, com.airbnb.lottie.u.j.b bVar2, boolean z) {
        this.f2408a = list;
        this.f2409b = dVar;
        this.f2410c = str;
        this.f2411d = j;
        this.f2412e = aVar;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.d a() {
        return this.f2409b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        d a2 = this.f2409b.a(h());
        if (a2 != null) {
            String str2 = "\t\tParents: ";
            while (true) {
                sb.append(str2);
                sb.append(a2.g());
                a2 = this.f2409b.a(a2.h());
                if (a2 == null) {
                    break;
                }
                str2 = "->";
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (!(o() == 0 || n() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f2408a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.u.k.b bVar : this.f2408a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public long b() {
        return this.f2411d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.y.a<Float>> c() {
        return this.t;
    }

    public a d() {
        return this.f2412e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<g> e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f2410c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.u.k.b> l() {
        return this.f2408a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.n / this.f2409b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j q() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.u.j.b s() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.m;
    }

    public String toString() {
        return a("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }
}
