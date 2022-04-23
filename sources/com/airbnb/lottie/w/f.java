package com.airbnb.lottie.w;

import android.graphics.Color;
import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
public class f implements j0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f2443a = new f();

    private f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.j0
    public Integer a(c cVar, float f) {
        boolean z = cVar.x() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.m();
        }
        double t = cVar.t();
        double t2 = cVar.t();
        double t3 = cVar.t();
        double t4 = cVar.t();
        if (z) {
            cVar.o();
        }
        if (t <= 1.0d && t2 <= 1.0d && t3 <= 1.0d && t4 <= 1.0d) {
            t *= 255.0d;
            t2 *= 255.0d;
            t3 *= 255.0d;
            t4 *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) t4, (int) t, (int) t2, (int) t3));
    }
}
