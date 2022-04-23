package com.airbnb.lottie.x;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.s.b.k;
import com.airbnb.lottie.u.a;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.l;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f2498a = new PointF();

    public static double a(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float a(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(float f, float f2) {
        return b((int) f, (int) f2);
    }

    private static int a(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int a(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(e eVar, int i, List<e> list, e eVar2, k kVar) {
        if (eVar.a(kVar.a(), i)) {
            list.add(eVar2.a(kVar.a()).a(kVar));
        }
    }

    public static void a(l lVar, Path path) {
        path.reset();
        PointF b2 = lVar.b();
        path.moveTo(b2.x, b2.y);
        f2498a.set(b2.x, b2.y);
        for (int i = 0; i < lVar.a().size(); i++) {
            a aVar = lVar.a().get(i);
            PointF a2 = aVar.a();
            PointF b3 = aVar.b();
            PointF c2 = aVar.c();
            if (!a2.equals(f2498a) || !b3.equals(c2)) {
                path.cubicTo(a2.x, a2.y, b3.x, b3.y, c2.x, c2.y);
            } else {
                path.lineTo(c2.x, c2.y);
            }
            f2498a.set(c2.x, c2.y);
        }
        if (lVar.c()) {
            path.close();
        }
    }

    private static int b(int i, int i2) {
        return i - (i2 * a(i, i2));
    }

    public static boolean b(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float c(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
