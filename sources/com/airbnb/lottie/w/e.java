package com.airbnb.lottie.w;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.f;
import com.airbnb.lottie.u.j.m;
import com.airbnb.lottie.u.k.a;
import com.airbnb.lottie.w.k0.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2441a = c.a.a("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(c cVar, d dVar, int i) {
        boolean z = i == 3;
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        boolean z2 = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2441a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                mVar = a.b(cVar, dVar);
            } else if (a2 == 2) {
                fVar = d.e(cVar, dVar);
            } else if (a2 == 3) {
                z2 = cVar.s();
            } else if (a2 != 4) {
                cVar.y();
                cVar.z();
            } else {
                z = cVar.u() == 3;
            }
        }
        return new a(str, mVar, fVar, z, z2);
    }
}
