package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.e;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.u.j.d;
import com.airbnb.lottie.u.k.q;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.x.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements a.AbstractC0063a, k, e {

    /* renamed from: e  reason: collision with root package name */
    private final f f2184e;
    protected final com.airbnb.lottie.u.l.a f;
    private final float[] h;
    private final com.airbnb.lottie.s.c.a<?, Float> j;
    private final com.airbnb.lottie.s.c.a<?, Integer> k;
    private final List<com.airbnb.lottie.s.c.a<?, Float>> l;
    private final com.airbnb.lottie.s.c.a<?, Float> m;
    private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> n;

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f2180a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f2181b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f2182c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f2183d = new RectF();
    private final List<b> g = new ArrayList();
    final Paint i = new com.airbnb.lottie.s.a(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<n> f2185a;

        /* renamed from: b  reason: collision with root package name */
        private final t f2186b;

        private b(t tVar) {
            this.f2185a = new ArrayList();
            this.f2186b = tVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f fVar, com.airbnb.lottie.u.l.a aVar, Paint.Cap cap, Paint.Join join, float f, d dVar, com.airbnb.lottie.u.j.b bVar, List<com.airbnb.lottie.u.j.b> list, com.airbnb.lottie.u.j.b bVar2) {
        this.f2184e = fVar;
        this.f = aVar;
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeCap(cap);
        this.i.setStrokeJoin(join);
        this.i.setStrokeMiter(f);
        this.k = dVar.a();
        this.j = bVar.a();
        this.m = bVar2 == null ? null : bVar2.a();
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        aVar.a(this.k);
        aVar.a(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.a(this.l.get(i2));
        }
        com.airbnb.lottie.s.c.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        com.airbnb.lottie.s.c.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    private void a(Canvas canvas, b bVar, Matrix matrix) {
        float f;
        c.a("StrokeContent#applyTrimPath");
        if (bVar.f2186b == null) {
            c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f2181b.reset();
        for (int size = bVar.f2185a.size() - 1; size >= 0; size--) {
            this.f2181b.addPath(((n) bVar.f2185a.get(size)).c(), matrix);
        }
        this.f2180a.setPath(this.f2181b, false);
        float length = this.f2180a.getLength();
        while (this.f2180a.nextContour()) {
            length += this.f2180a.getLength();
        }
        float floatValue = (bVar.f2186b.e().f().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f2186b.f().f().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f2186b.d().f().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.f2185a.size() - 1; size2 >= 0; size2--) {
            this.f2182c.set(((n) bVar.f2185a.get(size2)).c());
            this.f2182c.transform(matrix);
            this.f2180a.setPath(this.f2182c, false);
            float length2 = this.f2180a.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    f = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f3 = Math.min(f4 / length2, 1.0f);
                    h.a(this.f2182c, f, f3, 0.0f);
                    canvas.drawPath(this.f2182c, this.i);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    f = floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    h.a(this.f2182c, f, f3, 0.0f);
                }
                canvas.drawPath(this.f2182c, this.i);
            }
            f2 += length2;
        }
        c.b("StrokeContent#applyTrimPath");
    }

    private void a(Matrix matrix) {
        c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            c.b("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = h.a(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = this.l.get(i).f().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i] = fArr3[i] * a2;
        }
        com.airbnb.lottie.s.c.a<?, Float> aVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, aVar == null ? 0.0f : aVar.f().floatValue()));
        c.b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        c.a("StrokeContent#draw");
        if (h.b(matrix)) {
            c.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(g.a((int) ((((i / 255.0f) * ((e) this.k).i()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((com.airbnb.lottie.s.c.c) this.j).i() * h.a(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            c.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.i.setColorFilter(aVar.f());
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.f2186b != null) {
                a(canvas, bVar, matrix);
            } else {
                c.a("StrokeContent#buildPath");
                this.f2181b.reset();
                for (int size = bVar.f2185a.size() - 1; size >= 0; size--) {
                    this.f2181b.addPath(((n) bVar.f2185a.get(size)).c(), matrix);
                }
                c.b("StrokeContent#buildPath");
                c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f2181b, this.i);
                c.b("StrokeContent#drawPath");
            }
        }
        c.b("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        c.a("StrokeContent#getBounds");
        this.f2181b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            for (int i2 = 0; i2 < bVar.f2185a.size(); i2++) {
                this.f2181b.addPath(((n) bVar.f2185a.get(i2)).c(), matrix);
            }
        }
        this.f2181b.computeBounds(this.f2183d, false);
        float i3 = ((com.airbnb.lottie.s.c.c) this.j).i();
        RectF rectF2 = this.f2183d;
        float f = i3 / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.f2183d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        c.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.u.f
    public void a(com.airbnb.lottie.u.e eVar, int i, List<com.airbnb.lottie.u.e> list, com.airbnb.lottie.u.e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        com.airbnb.lottie.s.c.a aVar;
        if (t == k.f2162d) {
            aVar = this.k;
        } else if (t == k.o) {
            aVar = this.j;
        } else if (t != k.B) {
            return;
        } else {
            if (cVar == null) {
                this.n = null;
                return;
            }
            this.n = new p(cVar);
            this.n.a(this);
            this.f.a(this.n);
            return;
        }
        aVar.a(cVar);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        t tVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof t) {
                t tVar2 = (t) cVar;
                if (tVar2.g() == q.a.INDIVIDUALLY) {
                    tVar = tVar2;
                }
            }
        }
        if (tVar != null) {
            tVar.a(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof t) {
                t tVar3 = (t) cVar2;
                if (tVar3.g() == q.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(tVar3);
                    tVar3.a(this);
                }
            }
            if (cVar2 instanceof n) {
                if (bVar == null) {
                    bVar = new b(tVar);
                }
                bVar.f2185a.add((n) cVar2);
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        this.f2184e.invalidateSelf();
    }
}
