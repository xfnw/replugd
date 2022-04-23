package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.q;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class f implements n, a.AbstractC0063a, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f2194b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.f f2195c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, PointF> f2196d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, PointF> f2197e;
    private final com.airbnb.lottie.u.k.a f;
    private boolean h;

    /* renamed from: a  reason: collision with root package name */
    private final Path f2193a = new Path();
    private b g = new b();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar, com.airbnb.lottie.u.k.a aVar2) {
        this.f2194b = aVar2.a();
        this.f2195c = fVar;
        this.f2196d = aVar2.c().a();
        this.f2197e = aVar2.b().a();
        this.f = aVar2;
        aVar.a(this.f2196d);
        aVar.a(this.f2197e);
        this.f2196d.a(this);
        this.f2197e.a(this);
    }

    private void d() {
        this.h = false;
        this.f2195c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2194b;
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        a<?, PointF> aVar;
        if (t == k.g) {
            aVar = this.f2196d;
        } else if (t == k.j) {
            aVar = this.f2197e;
        } else {
            return;
        }
        aVar.a((c<PointF>) cVar);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.g() == q.a.SIMULTANEOUSLY) {
                    this.g.a(tVar);
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
        if (this.h) {
            return this.f2193a;
        }
        this.f2193a.reset();
        if (!this.f.d()) {
            PointF f = this.f2196d.f();
            float f2 = f.x / 2.0f;
            float f3 = f.y / 2.0f;
            float f4 = f2 * 0.55228f;
            float f5 = 0.55228f * f3;
            this.f2193a.reset();
            if (this.f.e()) {
                float f6 = -f3;
                this.f2193a.moveTo(0.0f, f6);
                float f7 = 0.0f - f4;
                float f8 = -f2;
                float f9 = 0.0f - f5;
                this.f2193a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
                float f10 = f5 + 0.0f;
                this.f2193a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
                float f11 = f4 + 0.0f;
                this.f2193a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
                this.f2193a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
            } else {
                float f12 = -f3;
                this.f2193a.moveTo(0.0f, f12);
                float f13 = f4 + 0.0f;
                float f14 = 0.0f - f5;
                this.f2193a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
                float f15 = f5 + 0.0f;
                this.f2193a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
                float f16 = 0.0f - f4;
                float f17 = -f2;
                this.f2193a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
                this.f2193a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
            }
            PointF f18 = this.f2197e.f();
            this.f2193a.offset(f18.x, f18.y);
            this.f2193a.close();
            this.g.a(this.f2193a);
        }
        this.h = true;
        return this.f2193a;
    }
}
