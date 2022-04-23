package com.airbnb.lottie.s.b;

import a.d.d;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.u.k.c;
import com.airbnb.lottie.u.k.e;
import com.airbnb.lottie.u.k.f;

/* loaded from: classes.dex */
public class i extends a {
    private final String o;
    private final boolean p;
    private final d<LinearGradient> q = new d<>();
    private final d<RadialGradient> r = new d<>();
    private final RectF s = new RectF();
    private final f t;
    private final int u;
    private final a<c, c> v;
    private final a<PointF, PointF> w;
    private final a<PointF, PointF> x;
    private p y;

    public i(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar, e eVar) {
        super(fVar, aVar, eVar.a().a(), eVar.f().a(), eVar.h(), eVar.j(), eVar.l(), eVar.g(), eVar.b());
        this.o = eVar.i();
        this.t = eVar.e();
        this.p = eVar.m();
        this.u = (int) (fVar.e().c() / 32.0f);
        this.v = eVar.d().a();
        this.v.a(this);
        aVar.a(this.v);
        this.w = eVar.k().a();
        this.w.a(this);
        aVar.a(this.w);
        this.x = eVar.c().a();
        this.x.a(this);
        aVar.a(this.x);
    }

    private int[] a(int[] iArr) {
        p pVar = this.y;
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
        int round = Math.round(this.w.e() * this.u);
        int round2 = Math.round(this.x.e() * this.u);
        int round3 = Math.round(this.v.e() * this.u);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private LinearGradient d() {
        long c2 = c();
        LinearGradient c3 = this.q.c(c2);
        if (c3 != null) {
            return c3;
        }
        PointF f = this.w.f();
        PointF f2 = this.x.f();
        c f3 = this.v.f();
        int[] a2 = a(f3.a());
        float[] b2 = f3.b();
        RectF rectF = this.s;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + f.x);
        RectF rectF2 = this.s;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + f.y);
        RectF rectF3 = this.s;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + f2.x);
        RectF rectF4 = this.s;
        LinearGradient linearGradient = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + f2.y), a2, b2, Shader.TileMode.CLAMP);
        this.q.c(c2, linearGradient);
        return linearGradient;
    }

    private RadialGradient e() {
        long c2 = c();
        RadialGradient c3 = this.r.c(c2);
        if (c3 != null) {
            return c3;
        }
        PointF f = this.w.f();
        PointF f2 = this.x.f();
        c f3 = this.v.f();
        int[] a2 = a(f3.a());
        float[] b2 = f3.b();
        RectF rectF = this.s;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + f.x);
        RectF rectF2 = this.s;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + f.y);
        RectF rectF3 = this.s;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + f2.x);
        RectF rectF4 = this.s;
        RadialGradient radialGradient = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + f2.y)) - height), a2, b2, Shader.TileMode.CLAMP);
        this.r.c(c2, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.o;
    }

    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.p) {
            a(this.s, matrix, false);
            this.i.setShader(this.t == f.LINEAR ? d() : e());
            super.a(canvas, matrix, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.s.b.a, com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        super.a((i) t, (com.airbnb.lottie.y.c<i>) cVar);
        if (t != k.C) {
            return;
        }
        if (cVar == null) {
            p pVar = this.y;
            if (pVar != null) {
                this.f.b(pVar);
            }
            this.y = null;
            return;
        }
        this.y = new p(cVar);
        this.y.a(this);
        this.f.a(this.y);
    }
}
