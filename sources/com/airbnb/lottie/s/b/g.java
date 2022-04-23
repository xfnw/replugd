package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.b;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g implements e, a.AbstractC0063a, k {

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.u.l.a f2200c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2201d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2202e;
    private final a<Integer, Integer> g;
    private final a<Integer, Integer> h;
    private a<ColorFilter, ColorFilter> i;
    private final f j;

    /* renamed from: a  reason: collision with root package name */
    private final Path f2198a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f2199b = new com.airbnb.lottie.s.a(1);
    private final List<n> f = new ArrayList();

    public g(f fVar, com.airbnb.lottie.u.l.a aVar, m mVar) {
        this.f2200c = aVar;
        this.f2201d = mVar.c();
        this.f2202e = mVar.e();
        this.j = fVar;
        if (mVar.a() == null || mVar.d() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        this.f2198a.setFillType(mVar.b());
        this.g = mVar.a().a();
        this.g.a(this);
        aVar.a(this.g);
        this.h = mVar.d().a();
        this.h.a(this);
        aVar.a(this.h);
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2201d;
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.f2202e) {
            c.a("FillContent#draw");
            this.f2199b.setColor(((b) this.g).i());
            this.f2199b.setAlpha(com.airbnb.lottie.x.g.a((int) ((((i / 255.0f) * this.h.f().intValue()) / 100.0f) * 255.0f), 0, 255));
            a<ColorFilter, ColorFilter> aVar = this.i;
            if (aVar != null) {
                this.f2199b.setColorFilter(aVar.f());
            }
            this.f2198a.reset();
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                this.f2198a.addPath(this.f.get(i2).c(), matrix);
            }
            canvas.drawPath(this.f2198a, this.f2199b);
            c.b("FillContent#draw");
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2198a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.f2198a.addPath(this.f.get(i).c(), matrix);
        }
        this.f2198a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        com.airbnb.lottie.x.g.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        a<Integer, Integer> aVar;
        if (t == k.f2159a) {
            aVar = this.g;
        } else if (t == k.f2162d) {
            aVar = this.h;
        } else if (t != k.B) {
            return;
        } else {
            if (cVar == null) {
                this.i = null;
                return;
            }
            this.i = new p(cVar);
            this.i.a(this);
            this.f2200c.a(this.i);
            return;
        }
        aVar.a((com.airbnb.lottie.y.c<Integer>) cVar);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof n) {
                this.f.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        this.j.invalidateSelf();
    }
}
