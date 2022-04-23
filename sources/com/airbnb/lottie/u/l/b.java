package com.airbnb.lottie.u.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.l.d;
import com.airbnb.lottie.y.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.airbnb.lottie.u.l.a {
    private com.airbnb.lottie.s.c.a<Float, Float> w;
    private final List<com.airbnb.lottie.u.l.a> x = new ArrayList();
    private final RectF y = new RectF();
    private final RectF z = new RectF();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2407a = new int[d.b.values().length];

        static {
            try {
                f2407a[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2407a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(f fVar, d dVar, List<d> list, com.airbnb.lottie.d dVar2) {
        super(fVar, dVar);
        int i;
        com.airbnb.lottie.u.l.a aVar;
        com.airbnb.lottie.u.j.b s = dVar.s();
        if (s != null) {
            this.w = s.a();
            a(this.w);
            this.w.a(this);
        } else {
            this.w = null;
        }
        a.d.d dVar3 = new a.d.d(dVar2.i().size());
        int size = list.size() - 1;
        com.airbnb.lottie.u.l.a aVar2 = null;
        while (true) {
            if (size >= 0) {
                d dVar4 = list.get(size);
                com.airbnb.lottie.u.l.a a2 = com.airbnb.lottie.u.l.a.a(dVar4, fVar, dVar2);
                if (a2 != null) {
                    dVar3.c(a2.c().b(), a2);
                    if (aVar2 != null) {
                        aVar2.a(a2);
                        aVar2 = null;
                    } else {
                        this.x.add(0, a2);
                        int i2 = a.f2407a[dVar4.f().ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            aVar2 = a2;
                        }
                    }
                }
                size--;
            }
        }
        for (i = 0; i < dVar3.b(); i++) {
            com.airbnb.lottie.u.l.a aVar3 = (com.airbnb.lottie.u.l.a) dVar3.c(dVar3.a(i));
            if (!(aVar3 == null || (aVar = (com.airbnb.lottie.u.l.a) dVar3.c(aVar3.c().h())) == null)) {
                aVar3.b(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.u.l.a
    public void a(float f) {
        super.a(f);
        if (this.w != null) {
            f = (this.w.f().floatValue() * 1000.0f) / this.n.e().c();
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        float p = f - this.o.p();
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).a(p);
        }
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.y.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.x.get(size).a(this.y, this.m, true);
            rectF.union(this.y);
        }
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        super.a((b) t, (c<b>) cVar);
        if (t != k.A) {
            return;
        }
        if (cVar == null) {
            this.w = null;
            return;
        }
        this.w = new p(cVar);
        a(this.w);
    }

    @Override // com.airbnb.lottie.u.l.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.a("CompositionLayer#draw");
        canvas.save();
        this.z.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.z);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            if (!this.z.isEmpty() ? canvas.clipRect(this.z) : true) {
                this.x.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c.b("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.u.l.a
    protected void b(e eVar, int i, List<e> list, e eVar2) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            this.x.get(i2).a(eVar, i, list, eVar2);
        }
    }
}
