package com.airbnb.lottie.s.b;

import a.d.d;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.c;
import com.airbnb.lottie.u.k.f;
import com.airbnb.lottie.x.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class h implements e, a.AbstractC0063a, k {

    /* renamed from: a  reason: collision with root package name */
    private final String f2203a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2204b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.u.l.a f2205c;

    /* renamed from: d  reason: collision with root package name */
    private final d<LinearGradient> f2206d = new d<>();

    /* renamed from: e  reason: collision with root package name */
    private final d<RadialGradient> f2207e = new d<>();
    private final Matrix f = new Matrix();
    private final Path g = new Path();
    private final Paint h = new com.airbnb.lottie.s.a(1);
    private final RectF i = new RectF();
    private final List<n> j = new ArrayList();
    private final f k;
    private final a<c, c> l;
    private final a<Integer, Integer> m;
    private final a<PointF, PointF> n;
    private final a<PointF, PointF> o;
    private a<ColorFilter, ColorFilter> p;
    private p q;
    private final com.airbnb.lottie.f r;
    private final int s;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar, com.airbnb.lottie.u.k.d dVar) {
        this.f2205c = aVar;
        this.f2203a = dVar.e();
        this.f2204b = dVar.h();
        this.r = fVar;
        this.k = dVar.d();
        this.g.setFillType(dVar.b());
        this.s = (int) (fVar.e().c() / 32.0f);
        this.l = dVar.c().a();
        this.l.a(this);
        aVar.a(this.l);
        this.m = dVar.f().a();
        this.m.a(this);
        aVar.a(this.m);
        this.n = dVar.g().a();
        this.n.a(this);
        aVar.a(this.n);
        this.o = dVar.a().a();
        this.o.a(this);
        aVar.a(this.o);
    }

    private int[] a(int[] iArr) {
        p pVar = this.q;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.f();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    private int c() {
        int round = Math.round(this.n.e() * this.s);
        int round2 = Math.round(this.o.e() * this.s);
        int round3 = Math.round(this.l.e() * this.s);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private LinearGradient d() {
        long c2 = c();
        LinearGradient c3 = this.f2206d.c(c2);
        if (c3 != null) {
            return c3;
        }
        PointF f = this.n.f();
        PointF f2 = this.o.f();
        c f3 = this.l.f();
        LinearGradient linearGradient = new LinearGradient(f.x, f.y, f2.x, f2.y, a(f3.a()), f3.b(), Shader.TileMode.CLAMP);
        this.f2206d.c(c2, linearGradient);
        return linearGradient;
    }

    private RadialGradient e() {
        long c2 = c();
        RadialGradient c3 = this.f2207e.c(c2);
        if (c3 != null) {
            return c3;
        }
        PointF f = this.n.f();
        PointF f2 = this.o.f();
        c f3 = this.l.f();
        int[] a2 = a(f3.a());
        float[] b2 = f3.b();
        float f4 = f.x;
        float f5 = f.y;
        float hypot = (float) Math.hypot(f2.x - f4, f2.y - f5);
        RadialGradient radialGradient = new RadialGradient(f4, f5, hypot <= 0.0f ? 0.001f : hypot, a2, b2, Shader.TileMode.CLAMP);
        this.f2207e.c(c2, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2203a;
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.f2204b) {
            com.airbnb.lottie.c.a("GradientFillContent#draw");
            this.g.reset();
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.g.addPath(this.j.get(i2).c(), matrix);
            }
            this.g.computeBounds(this.i, false);
            Shader d2 = this.k == f.LINEAR ? d() : e();
            this.f.set(matrix);
            d2.setLocalMatrix(this.f);
            this.h.setShader(d2);
            a<ColorFilter, ColorFilter> aVar = this.p;
            if (aVar != null) {
                this.h.setColorFilter(aVar.f());
            }
            this.h.setAlpha(g.a((int) ((((i / 255.0f) * this.m.f().intValue()) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.g, this.h);
            com.airbnb.lottie.c.b("GradientFillContent#draw");
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.g.reset();
        for (int i = 0; i < this.j.size(); i++) {
            this.g.addPath(this.j.get(i).c(), matrix);
        }
        this.g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        com.airbnb.lottie.u.l.a aVar;
        a<?, ?> aVar2;
        if (t == k.f2162d) {
            this.m.a((com.airbnb.lottie.y.c<Integer>) cVar);
            return;
        }
        if (t == k.B) {
            if (cVar == null) {
                this.p = null;
                return;
            }
            this.p = new p(cVar);
            this.p.a(this);
            aVar = this.f2205c;
            aVar2 = this.p;
        } else if (t != k.C) {
            return;
        } else {
            if (cVar == null) {
                p pVar = this.q;
                if (pVar != null) {
                    this.f2205c.b(pVar);
                }
                this.q = null;
                return;
            }
            this.q = new p(cVar);
            this.q.a(this);
            aVar = this.f2205c;
            aVar2 = this.q;
        }
        aVar.a(aVar2);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof n) {
                this.j.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        this.r.invalidateSelf();
    }
}
