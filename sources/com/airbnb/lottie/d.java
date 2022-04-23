package com.airbnb.lottie;

import android.graphics.Rect;
import com.airbnb.lottie.u.c;
import com.airbnb.lottie.u.h;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<com.airbnb.lottie.u.l.d>> f2107c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, g> f2108d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, c> f2109e;
    private List<h> f;
    private a.d.h<com.airbnb.lottie.u.d> g;
    private a.d.d<com.airbnb.lottie.u.l.d> h;
    private List<com.airbnb.lottie.u.l.d> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;

    /* renamed from: a  reason: collision with root package name */
    private final n f2105a = new n();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f2106b = new HashSet<>();
    private int o = 0;

    public Rect a() {
        return this.j;
    }

    public com.airbnb.lottie.u.l.d a(long j) {
        return this.h.c(j);
    }

    public void a(int i) {
        this.o += i;
    }

    public void a(Rect rect, float f, float f2, float f3, List<com.airbnb.lottie.u.l.d> list, a.d.d<com.airbnb.lottie.u.l.d> dVar, Map<String, List<com.airbnb.lottie.u.l.d>> map, Map<String, g> map2, a.d.h<com.airbnb.lottie.u.d> hVar, Map<String, c> map3, List<h> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = dVar;
        this.f2107c = map;
        this.f2108d = map2;
        this.g = hVar;
        this.f2109e = map3;
        this.f = list2;
    }

    public void a(String str) {
        com.airbnb.lottie.x.d.b(str);
        this.f2106b.add(str);
    }

    public void a(boolean z) {
        this.n = z;
    }

    public a.d.h<com.airbnb.lottie.u.d> b() {
        return this.g;
    }

    public h b(String str) {
        this.f.size();
        for (int i = 0; i < this.f.size(); i++) {
            h hVar = this.f.get(i);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public void b(boolean z) {
        this.f2105a.a(z);
    }

    public float c() {
        return (d() / this.m) * 1000.0f;
    }

    public List<com.airbnb.lottie.u.l.d> c(String str) {
        return this.f2107c.get(str);
    }

    public float d() {
        return this.l - this.k;
    }

    public float e() {
        return this.l;
    }

    public Map<String, c> f() {
        return this.f2109e;
    }

    public float g() {
        return this.m;
    }

    public Map<String, g> h() {
        return this.f2108d;
    }

    public List<com.airbnb.lottie.u.l.d> i() {
        return this.i;
    }

    public int j() {
        return this.o;
    }

    public n k() {
        return this.f2105a;
    }

    public float l() {
        return this.k;
    }

    public boolean m() {
        return this.n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (com.airbnb.lottie.u.l.d dVar : this.i) {
            sb.append(dVar.a("\t"));
        }
        return sb.toString();
    }
}
