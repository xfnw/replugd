package com.airbnb.lottie.w;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.w.k0.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2473a = c.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2474a = new int[c.b.values().length];

        static {
            try {
                f2474a[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2474a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2474a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(c cVar) {
        cVar.m();
        int t = (int) (cVar.t() * 255.0d);
        int t2 = (int) (cVar.t() * 255.0d);
        int t3 = (int) (cVar.t() * 255.0d);
        while (cVar.r()) {
            cVar.z();
        }
        cVar.o();
        return Color.argb(255, t, t2, t3);
    }

    private static PointF a(c cVar, float f) {
        cVar.m();
        float t = (float) cVar.t();
        float t2 = (float) cVar.t();
        while (cVar.x() != c.b.END_ARRAY) {
            cVar.z();
        }
        cVar.o();
        return new PointF(t * f, t2 * f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(c cVar) {
        c.b x = cVar.x();
        int i = a.f2474a[x.ordinal()];
        if (i == 1) {
            return (float) cVar.t();
        }
        if (i == 2) {
            cVar.m();
            float t = (float) cVar.t();
            while (cVar.r()) {
                cVar.z();
            }
            cVar.o();
            return t;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + x);
    }

    private static PointF b(c cVar, float f) {
        float t = (float) cVar.t();
        float t2 = (float) cVar.t();
        while (cVar.r()) {
            cVar.z();
        }
        return new PointF(t * f, t2 * f);
    }

    private static PointF c(c cVar, float f) {
        cVar.n();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (cVar.r()) {
            int a2 = cVar.a(f2473a);
            if (a2 == 0) {
                f2 = b(cVar);
            } else if (a2 != 1) {
                cVar.y();
                cVar.z();
            } else {
                f3 = b(cVar);
            }
        }
        cVar.p();
        return new PointF(f2 * f, f3 * f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF d(c cVar, float f) {
        int i = a.f2474a[cVar.x().ordinal()];
        if (i == 1) {
            return b(cVar, f);
        }
        if (i == 2) {
            return a(cVar, f);
        }
        if (i == 3) {
            return c(cVar, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.x());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> e(c cVar, float f) {
        ArrayList arrayList = new ArrayList();
        cVar.m();
        while (cVar.x() == c.b.BEGIN_ARRAY) {
            cVar.m();
            arrayList.add(d(cVar, f));
            cVar.o();
        }
        cVar.o();
        return arrayList;
    }
}
