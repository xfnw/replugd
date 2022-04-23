package com.airbnb.lottie.s.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.u.j.l;
import com.airbnb.lottie.y.c;
import com.airbnb.lottie.y.d;
import java.util.Collections;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f2248a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f2249b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f2250c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f2251d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f2252e;
    private a<PointF, PointF> f;
    private a<?, PointF> g;
    private a<d, d> h;
    private a<Float, Float> i;
    private a<Integer, Integer> j;
    private c k;
    private c l;
    private a<?, Float> m;
    private a<?, Float> n;

    public o(l lVar) {
        this.f = lVar.b() == null ? null : lVar.b().a();
        this.g = lVar.e() == null ? null : lVar.e().a();
        this.h = lVar.g() == null ? null : lVar.g().a();
        this.i = lVar.f() == null ? null : lVar.f().a();
        this.k = lVar.h() == null ? null : (c) lVar.h().a();
        if (this.k != null) {
            this.f2249b = new Matrix();
            this.f2250c = new Matrix();
            this.f2251d = new Matrix();
            this.f2252e = new float[9];
        } else {
            this.f2249b = null;
            this.f2250c = null;
            this.f2251d = null;
            this.f2252e = null;
        }
        this.l = lVar.i() == null ? null : (c) lVar.i().a();
        if (lVar.d() != null) {
            this.j = lVar.d().a();
        }
        if (lVar.j() != null) {
            this.m = lVar.j().a();
        } else {
            this.m = null;
        }
        if (lVar.c() != null) {
            this.n = lVar.c().a();
        } else {
            this.n = null;
        }
    }

    private void e() {
        for (int i = 0; i < 9; i++) {
            this.f2252e[i] = 0.0f;
        }
    }

    public Matrix a(float f) {
        a<?, PointF> aVar = this.g;
        PointF pointF = null;
        PointF f2 = aVar == null ? null : aVar.f();
        a<d, d> aVar2 = this.h;
        d f3 = aVar2 == null ? null : aVar2.f();
        this.f2248a.reset();
        if (f2 != null) {
            this.f2248a.preTranslate(f2.x * f, f2.y * f);
        }
        if (f3 != null) {
            double d2 = f;
            this.f2248a.preScale((float) Math.pow(f3.a(), d2), (float) Math.pow(f3.b(), d2));
        }
        a<Float, Float> aVar3 = this.i;
        if (aVar3 != null) {
            float floatValue = aVar3.f().floatValue();
            a<PointF, PointF> aVar4 = this.f;
            if (aVar4 != null) {
                pointF = aVar4.f();
            }
            Matrix matrix = this.f2248a;
            float f4 = floatValue * f;
            float f5 = 0.0f;
            float f6 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f5 = pointF.y;
            }
            matrix.preRotate(f4, f6, f5);
        }
        return this.f2248a;
    }

    public a<?, Float> a() {
        return this.n;
    }

    public void a(a.AbstractC0063a aVar) {
        a<Integer, Integer> aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(aVar);
        }
        a<?, Float> aVar4 = this.n;
        if (aVar4 != null) {
            aVar4.a(aVar);
        }
        a<PointF, PointF> aVar5 = this.f;
        if (aVar5 != null) {
            aVar5.a(aVar);
        }
        a<?, PointF> aVar6 = this.g;
        if (aVar6 != null) {
            aVar6.a(aVar);
        }
        a<d, d> aVar7 = this.h;
        if (aVar7 != null) {
            aVar7.a(aVar);
        }
        a<Float, Float> aVar8 = this.i;
        if (aVar8 != null) {
            aVar8.a(aVar);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(aVar);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(aVar);
        }
    }

    public void a(com.airbnb.lottie.u.l.a aVar) {
        aVar.a(this.j);
        aVar.a(this.m);
        aVar.a(this.n);
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.h);
        aVar.a(this.i);
        aVar.a(this.k);
        aVar.a(this.l);
    }

    public <T> boolean a(T t, c<T> cVar) {
        c cVar2;
        a aVar;
        c cVar3;
        a<?, Float> aVar2;
        if (t == k.f2163e) {
            aVar = this.f;
            if (aVar == null) {
                this.f = new p(cVar, new PointF());
                return true;
            }
        } else if (t == k.f) {
            aVar = this.g;
            if (aVar == null) {
                this.g = new p(cVar, new PointF());
                return true;
            }
        } else if (t == k.k) {
            aVar = this.h;
            if (aVar == null) {
                this.h = new p(cVar, new d());
                return true;
            }
        } else if (t == k.l) {
            aVar = this.i;
            if (aVar == null) {
                this.i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
        } else if (t == k.f2161c) {
            aVar = this.j;
            if (aVar == null) {
                this.j = new p(cVar, 100);
                return true;
            }
        } else {
            if (t != k.y || (aVar2 = this.m) == null) {
                if (t != k.z || (aVar2 = this.n) == null) {
                    if (t == k.m && (cVar3 = this.k) != null) {
                        if (cVar3 == null) {
                            this.k = new c(Collections.singletonList(new com.airbnb.lottie.y.a(Float.valueOf(0.0f))));
                        }
                        aVar = this.k;
                    } else if (t != k.n || (cVar2 = this.l) == null) {
                        return false;
                    } else {
                        if (cVar2 == null) {
                            this.l = new c(Collections.singletonList(new com.airbnb.lottie.y.a(Float.valueOf(0.0f))));
                        }
                        aVar = this.l;
                    }
                } else if (aVar2 == null) {
                    this.n = new p(cVar, 100);
                    return true;
                }
            } else if (aVar2 == null) {
                this.m = new p(cVar, 100);
                return true;
            }
            aVar2.a((c<Float>) cVar);
            return true;
        }
        aVar.a(cVar);
        return true;
    }

    public Matrix b() {
        this.f2248a.reset();
        a<?, PointF> aVar = this.g;
        if (aVar != null) {
            PointF f = aVar.f();
            if (!(f.x == 0.0f && f.y == 0.0f)) {
                this.f2248a.preTranslate(f.x, f.y);
            }
        }
        a<Float, Float> aVar2 = this.i;
        if (aVar2 != null) {
            float floatValue = aVar2 instanceof p ? aVar2.f().floatValue() : ((c) aVar2).i();
            if (floatValue != 0.0f) {
                this.f2248a.preRotate(floatValue);
            }
        }
        if (this.k != null) {
            c cVar = this.l;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.i()) + 90.0f));
            c cVar2 = this.l;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.i()) + 90.0f));
            e();
            float[] fArr = this.f2252e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f2249b.setValues(fArr);
            e();
            float[] fArr2 = this.f2252e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.k.i()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f2250c.setValues(fArr2);
            e();
            float[] fArr3 = this.f2252e;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f2251d.setValues(fArr3);
            this.f2250c.preConcat(this.f2249b);
            this.f2251d.preConcat(this.f2250c);
            this.f2248a.preConcat(this.f2251d);
        }
        a<d, d> aVar3 = this.h;
        if (aVar3 != null) {
            d f3 = aVar3.f();
            if (!(f3.a() == 1.0f && f3.b() == 1.0f)) {
                this.f2248a.preScale(f3.a(), f3.b());
            }
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            PointF f4 = aVar4.f();
            if (!(f4.x == 0.0f && f4.y == 0.0f)) {
                this.f2248a.preTranslate(-f4.x, -f4.y);
            }
        }
        return this.f2248a;
    }

    public void b(float f) {
        a<Integer, Integer> aVar = this.j;
        if (aVar != null) {
            aVar.a(f);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(f);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(f);
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.a(f);
        }
        a<?, PointF> aVar5 = this.g;
        if (aVar5 != null) {
            aVar5.a(f);
        }
        a<d, d> aVar6 = this.h;
        if (aVar6 != null) {
            aVar6.a(f);
        }
        a<Float, Float> aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.a(f);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(f);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(f);
        }
    }

    public a<?, Integer> c() {
        return this.j;
    }

    public a<?, Float> d() {
        return this.m;
    }
}
