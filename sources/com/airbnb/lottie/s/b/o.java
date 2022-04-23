package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.i;
import com.airbnb.lottie.u.k.q;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class o implements n, a.AbstractC0063a, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f2215b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2216c;

    /* renamed from: d  reason: collision with root package name */
    private final i.a f2217d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2218e;
    private final com.airbnb.lottie.s.c.a<?, Float> f;
    private final com.airbnb.lottie.s.c.a<?, PointF> g;
    private final com.airbnb.lottie.s.c.a<?, Float> h;
    private final com.airbnb.lottie.s.c.a<?, Float> i;
    private final com.airbnb.lottie.s.c.a<?, Float> j;
    private final com.airbnb.lottie.s.c.a<?, Float> k;
    private final com.airbnb.lottie.s.c.a<?, Float> l;
    private boolean n;

    /* renamed from: a  reason: collision with root package name */
    private final Path f2214a = new Path();
    private b m = new b();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2219a = new int[i.a.values().length];

        static {
            try {
                f2219a[i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2219a[i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(f fVar, com.airbnb.lottie.u.l.a aVar, i iVar) {
        com.airbnb.lottie.s.c.a<Float, Float> aVar2;
        this.f2216c = fVar;
        this.f2215b = iVar.c();
        this.f2217d = iVar.i();
        this.f2218e = iVar.j();
        this.f = iVar.f().a();
        this.g = iVar.g().a();
        this.h = iVar.h().a();
        this.j = iVar.d().a();
        this.l = iVar.e().a();
        if (this.f2217d == i.a.STAR) {
            this.i = iVar.a().a();
            aVar2 = iVar.b().a();
        } else {
            aVar2 = null;
            this.i = null;
        }
        this.k = aVar2;
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.h);
        aVar.a(this.j);
        aVar.a(this.l);
        if (this.f2217d == i.a.STAR) {
            aVar.a(this.i);
            aVar.a(this.k);
        }
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
        this.j.a(this);
        this.l.a(this);
        if (this.f2217d == i.a.STAR) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void d() {
        com.airbnb.lottie.s.c.a<?, Float> aVar;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor(this.f.f().floatValue());
        double radians = Math.toRadians((this.h == null ? 0.0d : aVar.f().floatValue()) - 90.0d);
        double d4 = floor;
        Double.isNaN(d4);
        float floatValue = this.l.f().floatValue() / 100.0f;
        float floatValue2 = this.j.f().floatValue();
        double d5 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d5);
        float f = (float) (cos * d5);
        double sin = Math.sin(radians);
        Double.isNaN(d5);
        float f2 = (float) (sin * d5);
        this.f2214a.moveTo(f, f2);
        double d6 = (float) (6.283185307179586d / d4);
        Double.isNaN(d6);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            double cos2 = Math.cos(d7);
            Double.isNaN(d5);
            float f3 = (float) (cos2 * d5);
            double sin2 = Math.sin(d7);
            Double.isNaN(d5);
            float f4 = (float) (d5 * sin2);
            if (floatValue != 0.0f) {
                d5 = d5;
                i = i2;
                d3 = d7;
                double atan2 = (float) (Math.atan2(f2, f) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d2 = d6;
                double atan22 = (float) (Math.atan2(f4, f3) - 1.5707963267948966d);
                float f5 = floatValue2 * floatValue * 0.25f;
                this.f2214a.cubicTo(f - (cos3 * f5), f2 - (((float) Math.sin(atan2)) * f5), f3 + (((float) Math.cos(atan22)) * f5), f4 + (f5 * ((float) Math.sin(atan22))), f3, f4);
            } else {
                d3 = d7;
                d5 = d5;
                d2 = d6;
                i = i2;
                this.f2214a.lineTo(f3, f4);
            }
            Double.isNaN(d2);
            d7 = d3 + d2;
            i2 = i + 1;
            f2 = f4;
            f = f3;
            ceil = ceil;
            d6 = d2;
        }
        PointF f6 = this.g.f();
        this.f2214a.offset(f6.x, f6.y);
        this.f2214a.close();
    }

    private void e() {
        com.airbnb.lottie.s.c.a<?, Float> aVar;
        double d2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        double d3;
        float f6;
        float f7;
        float f8;
        float f9;
        float floatValue = this.f.f().floatValue();
        double radians = Math.toRadians((this.h == null ? 0.0d : aVar.f().floatValue()) - 90.0d);
        double d4 = floatValue;
        Double.isNaN(d4);
        float f10 = (float) (6.283185307179586d / d4);
        float f11 = f10 / 2.0f;
        float f12 = floatValue - ((int) floatValue);
        if (f12 != 0.0f) {
            double d5 = (1.0f - f12) * f11;
            Double.isNaN(d5);
            radians += d5;
        }
        float floatValue2 = this.j.f().floatValue();
        float floatValue3 = this.i.f().floatValue();
        com.airbnb.lottie.s.c.a<?, Float> aVar2 = this.k;
        float floatValue4 = aVar2 != null ? aVar2.f().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.s.c.a<?, Float> aVar3 = this.l;
        float floatValue5 = aVar3 != null ? aVar3.f().floatValue() / 100.0f : 0.0f;
        if (f12 != 0.0f) {
            float f13 = ((floatValue2 - floatValue3) * f12) + floatValue3;
            double d6 = f13;
            double cos = Math.cos(radians);
            Double.isNaN(d6);
            d2 = d4;
            float f14 = (float) (d6 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d6);
            float f15 = (float) (d6 * sin);
            this.f2214a.moveTo(f14, f15);
            double d7 = (f10 * f12) / 2.0f;
            Double.isNaN(d7);
            d3 = radians + d7;
            f3 = f14;
            f = f13;
            f5 = floatValue2;
            f2 = f15;
            f4 = f11;
        } else {
            d2 = d4;
            f5 = floatValue2;
            double d8 = f5;
            double cos2 = Math.cos(radians);
            Double.isNaN(d8);
            f4 = f11;
            f3 = (float) (d8 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d8);
            f2 = (float) (d8 * sin2);
            this.f2214a.moveTo(f3, f2);
            double d9 = f4;
            Double.isNaN(d9);
            d3 = radians + d9;
            f = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i = 0;
        boolean z = false;
        while (true) {
            double d10 = i;
            if (d10 < ceil) {
                float f16 = z ? f5 : floatValue3;
                if (f == 0.0f || d10 != ceil - 2.0d) {
                    f8 = f16;
                    f6 = f4;
                } else {
                    f6 = (f10 * f12) / 2.0f;
                    f8 = f16;
                }
                if (f == 0.0f || d10 != ceil - 1.0d) {
                    f10 = f10;
                    f7 = f5;
                } else {
                    f10 = f10;
                    f7 = f5;
                    f8 = f;
                }
                double d11 = f8;
                double cos3 = Math.cos(d3);
                Double.isNaN(d11);
                float f17 = (float) (d11 * cos3);
                double sin3 = Math.sin(d3);
                Double.isNaN(d11);
                float f18 = (float) (d11 * sin3);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f2214a.lineTo(f17, f18);
                    f2 = f18;
                    f4 = f4;
                    floatValue3 = floatValue3;
                    floatValue4 = floatValue4;
                    floatValue5 = floatValue5;
                    f9 = f6;
                } else {
                    f4 = f4;
                    floatValue3 = floatValue3;
                    floatValue4 = floatValue4;
                    double atan2 = (float) (Math.atan2(f2, f3) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    floatValue5 = floatValue5;
                    f2 = f18;
                    double atan22 = (float) (Math.atan2(f18, f17) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f19 = z ? floatValue4 : floatValue5;
                    float f20 = z ? floatValue5 : floatValue4;
                    float f21 = (z ? floatValue3 : f7) * f19 * 0.47829f;
                    float f22 = cos4 * f21;
                    float f23 = f21 * sin4;
                    float f24 = (z ? f7 : floatValue3) * f20 * 0.47829f;
                    float f25 = cos5 * f24;
                    float f26 = f24 * sin5;
                    if (f12 != 0.0f) {
                        if (i == 0) {
                            f22 *= f12;
                            f23 *= f12;
                        } else if (d10 == ceil - 1.0d) {
                            f25 *= f12;
                            f26 *= f12;
                        }
                    }
                    this.f2214a.cubicTo(f3 - f22, f2 - f23, f17 + f25, f2 + f26, f17, f2);
                    f9 = f6;
                }
                double d12 = f9;
                Double.isNaN(d12);
                d3 += d12;
                z = !z;
                i++;
                f3 = f17;
                f5 = f7;
            } else {
                PointF f27 = this.g.f();
                this.f2214a.offset(f27.x, f27.y);
                this.f2214a.close();
                return;
            }
        }
    }

    private void f() {
        this.n = false;
        this.f2216c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2215b;
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        com.airbnb.lottie.s.c.a aVar;
        com.airbnb.lottie.s.c.a<?, Float> aVar2;
        if (t == k.s) {
            aVar = this.f;
        } else if (t == k.t) {
            aVar = this.h;
        } else if (t == k.j) {
            aVar = this.g;
        } else {
            if (t != k.u || (aVar2 = this.i) == null) {
                if (t == k.v) {
                    aVar = this.j;
                } else if (t != k.w || (aVar2 = this.k) == null) {
                    if (t == k.x) {
                        aVar = this.l;
                    } else {
                        return;
                    }
                }
            }
            aVar2.a((c<Float>) cVar);
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
                    this.m.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        f();
    }

    @Override // com.airbnb.lottie.s.b.n
    public Path c() {
        if (this.n) {
            return this.f2214a;
        }
        this.f2214a.reset();
        if (!this.f2218e) {
            int i = a.f2219a[this.f2217d.ordinal()];
            if (i == 1) {
                e();
            } else if (i == 2) {
                d();
            }
            this.f2214a.close();
            this.m.a(this.f2214a);
        }
        this.n = true;
        return this.f2214a;
    }
}
