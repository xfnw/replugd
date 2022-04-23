package com.airbnb.lottie.u.k;

import android.graphics.PointF;
import com.airbnb.lottie.u.a;
import com.airbnb.lottie.x.d;
import com.airbnb.lottie.x.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f2360a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f2361b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2362c;

    public l() {
        this.f2360a = new ArrayList();
    }

    public l(PointF pointF, boolean z, List<a> list) {
        this.f2361b = pointF;
        this.f2362c = z;
        this.f2360a = new ArrayList(list);
    }

    private void a(float f, float f2) {
        if (this.f2361b == null) {
            this.f2361b = new PointF();
        }
        this.f2361b.set(f, f2);
    }

    public List<a> a() {
        return this.f2360a;
    }

    public void a(l lVar, l lVar2, float f) {
        if (this.f2361b == null) {
            this.f2361b = new PointF();
        }
        this.f2362c = lVar.c() || lVar2.c();
        if (lVar.a().size() != lVar2.a().size()) {
            d.b("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int min = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.f2360a.size() < min) {
            for (int size = this.f2360a.size(); size < min; size++) {
                this.f2360a.add(new a());
            }
        } else if (this.f2360a.size() > min) {
            for (int size2 = this.f2360a.size() - 1; size2 >= min; size2--) {
                List<a> list = this.f2360a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = lVar.b();
        PointF b3 = lVar2.b();
        a(g.c(b2.x, b3.x, f), g.c(b2.y, b3.y, f));
        for (int size3 = this.f2360a.size() - 1; size3 >= 0; size3--) {
            a aVar = lVar.a().get(size3);
            a aVar2 = lVar2.a().get(size3);
            PointF a2 = aVar.a();
            PointF b4 = aVar.b();
            PointF c2 = aVar.c();
            PointF a3 = aVar2.a();
            PointF b5 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f2360a.get(size3).a(g.c(a2.x, a3.x, f), g.c(a2.y, a3.y, f));
            this.f2360a.get(size3).b(g.c(b4.x, b5.x, f), g.c(b4.y, b5.y, f));
            this.f2360a.get(size3).c(g.c(c2.x, c3.x, f), g.c(c2.y, c3.y, f));
        }
    }

    public PointF b() {
        return this.f2361b;
    }

    public boolean c() {
        return this.f2362c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f2360a.size() + "closed=" + this.f2362c + '}';
    }
}
