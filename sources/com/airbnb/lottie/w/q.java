package com.airbnb.lottie.w;

import a.d.h;
import a.g.l.c0.b;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.d;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.a;
import com.king.zxing.e;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class q {

    /* renamed from: b  reason: collision with root package name */
    private static h<WeakReference<Interpolator>> f2476b;

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f2475a = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    static c.a f2477c = c.a.a("t", "s", e.z, "o", "i", "h", "to", "ti");

    q() {
    }

    private static h<WeakReference<Interpolator>> a() {
        if (f2476b == null) {
            f2476b = new h<>();
        }
        return f2476b;
    }

    private static <T> a<T> a(d dVar, c cVar, float f, j0<T> j0Var) {
        T t;
        cVar.n();
        Interpolator interpolator = null;
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (cVar.r()) {
            switch (cVar.a(f2477c)) {
                case 0:
                    f2 = (float) cVar.t();
                    break;
                case 1:
                    t3 = j0Var.a(cVar, f);
                    break;
                case 2:
                    t2 = j0Var.a(cVar, f);
                    break;
                case 3:
                    pointF = p.d(cVar, f);
                    break;
                case 4:
                    pointF2 = p.d(cVar, f);
                    break;
                case 5:
                    if (cVar.u() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = p.d(cVar, f);
                    break;
                case 7:
                    pointF4 = p.d(cVar, f);
                    break;
                default:
                    cVar.z();
                    break;
            }
        }
        cVar.p();
        if (z) {
            interpolator = f2475a;
            t = t3;
        } else {
            if (pointF == null || pointF2 == null) {
                interpolator = f2475a;
            } else {
                float f3 = -f;
                pointF.x = g.a(pointF.x, f3, f);
                pointF.y = g.a(pointF.y, -100.0f, 100.0f);
                pointF2.x = g.a(pointF2.x, f3, f);
                pointF2.y = g.a(pointF2.y, -100.0f, 100.0f);
                int a2 = com.airbnb.lottie.x.h.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
                WeakReference<Interpolator> a3 = a(a2);
                if (a3 != null) {
                    interpolator = a3.get();
                }
                if (a3 == null || interpolator == null) {
                    interpolator = b.a(pointF.x / f, pointF.y / f, pointF2.x / f, pointF2.y / f);
                    try {
                        a(a2, new WeakReference(interpolator));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            t = t2;
        }
        a<T> aVar = new a<>(dVar, t3, t, interpolator, f2, null);
        aVar.m = pointF3;
        aVar.n = pointF4;
        return aVar;
    }

    private static <T> a<T> a(c cVar, float f, j0<T> j0Var) {
        return new a<>(j0Var.a(cVar, f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> a<T> a(c cVar, d dVar, float f, j0<T> j0Var, boolean z) {
        return z ? a(dVar, cVar, f, j0Var) : a(cVar, f, j0Var);
    }

    private static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> b2;
        synchronized (q.class) {
            b2 = a().b(i);
        }
        return b2;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f2476b.c(i, weakReference);
        }
    }
}
