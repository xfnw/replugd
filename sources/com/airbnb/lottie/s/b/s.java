package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.b;
import com.airbnb.lottie.u.k.p;
import com.airbnb.lottie.u.l.a;
import com.airbnb.lottie.y.c;

/* loaded from: classes.dex */
public class s extends a {
    private final a o;
    private final String p;
    private final boolean q;
    private final com.airbnb.lottie.s.c.a<Integer, Integer> r;
    private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> s;

    public s(f fVar, a aVar, p pVar) {
        super(fVar, aVar, pVar.a().a(), pVar.d().a(), pVar.f(), pVar.h(), pVar.i(), pVar.e(), pVar.c());
        this.o = aVar;
        this.p = pVar.g();
        this.q = pVar.j();
        this.r = pVar.b().a();
        this.r.a(this);
        aVar.a(this.r);
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.p;
    }

    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.q) {
            this.i.setColor(((b) this.r).i());
            com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.i.setColorFilter(aVar.f());
            }
            super.a(canvas, matrix, i);
        }
    }

    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        super.a((s) t, (c<s>) cVar);
        if (t == k.f2160b) {
            this.r.a((c<Integer>) cVar);
        } else if (t != k.B) {
        } else {
            if (cVar == null) {
                this.s = null;
                return;
            }
            this.s = new com.airbnb.lottie.s.c.p(cVar);
            this.s.a(this);
            this.o.a(this.r);
        }
    }
}
