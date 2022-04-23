package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.j;
import com.airbnb.lottie.u.k.q;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class p implements a.AbstractC0063a, k, n {

    /* renamed from: c  reason: collision with root package name */
    private final String f2222c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2223d;

    /* renamed from: e  reason: collision with root package name */
    private final f f2224e;
    private final a<?, PointF> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private boolean j;

    /* renamed from: a  reason: collision with root package name */
    private final Path f2220a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f2221b = new RectF();
    private b i = new b();

    public p(f fVar, com.airbnb.lottie.u.l.a aVar, j jVar) {
        this.f2222c = jVar.b();
        this.f2223d = jVar.e();
        this.f2224e = fVar;
        this.f = jVar.c().a();
        this.g = jVar.d().a();
        this.h = jVar.a().a();
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.h);
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
    }

    private void d() {
        this.j = false;
        this.f2224e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2222c;
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        a aVar;
        if (t == k.h) {
            aVar = this.g;
        } else if (t == k.j) {
            aVar = this.f;
        } else if (t == k.i) {
            aVar = this.h;
        } else {
            return;
        }
        aVar.a(cVar);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.g() == q.a.SIMULTANEOUSLY) {
                    this.i.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        d();
    }

    @Override // com.airbnb.lottie.s.b.n
    public Path c() {
        if (this.j) {
            return this.f2220a;
        }
        this.f2220a.reset();
        if (!this.f2223d) {
            PointF f = this.g.f();
            float f2 = f.x / 2.0f;
            float f3 = f.y / 2.0f;
            a<?, Float> aVar = this.h;
            float i = aVar == null ? 0.0f : ((com.airbnb.lottie.s.c.c) aVar).i();
            float min = Math.min(f2, f3);
            if (i > min) {
                i = min;
            }
            PointF f4 = this.f.f();
            this.f2220a.moveTo(f4.x + f2, (f4.y - f3) + i);
            this.f2220a.lineTo(f4.x + f2, (f4.y + f3) - i);
            if (i > 0.0f) {
                RectF rectF = this.f2221b;
                float f5 = f4.x;
                float f6 = i * 2.0f;
                float f7 = f4.y;
                rectF.set((f5 + f2) - f6, (f7 + f3) - f6, f5 + f2, f7 + f3);
                this.f2220a.arcTo(this.f2221b, 0.0f, 90.0f, false);
            }
            this.f2220a.lineTo((f4.x - f2) + i, f4.y + f3);
            if (i > 0.0f) {
                RectF rectF2 = this.f2221b;
                float f8 = f4.x;
                float f9 = f4.y;
                float f10 = i * 2.0f;
                rectF2.set(f8 - f2, (f9 + f3) - f10, (f8 - f2) + f10, f9 + f3);
                this.f2220a.arcTo(this.f2221b, 90.0f, 90.0f, false);
            }
            this.f2220a.lineTo(f4.x - f2, (f4.y - f3) + i);
            if (i > 0.0f) {
                RectF rectF3 = this.f2221b;
                float f11 = f4.x;
                float f12 = f4.y;
                float f13 = i * 2.0f;
                rectF3.set(f11 - f2, f12 - f3, (f11 - f2) + f13, (f12 - f3) + f13);
                this.f2220a.arcTo(this.f2221b, 180.0f, 90.0f, false);
            }
            this.f2220a.lineTo((f4.x + f2) - i, f4.y - f3);
            if (i > 0.0f) {
                RectF rectF4 = this.f2221b;
                float f14 = f4.x;
                float f15 = i * 2.0f;
                float f16 = f4.y;
                rectF4.set((f14 + f2) - f15, f16 - f3, f14 + f2, (f16 - f3) + f15);
                this.f2220a.arcTo(this.f2221b, 270.0f, 90.0f, false);
            }
            this.f2220a.close();
            this.i.a(this.f2220a);
        }
        this.j = true;
        return this.f2220a;
    }
}
