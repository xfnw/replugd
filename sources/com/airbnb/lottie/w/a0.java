package com.airbnb.lottie.w;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.f;
import com.airbnb.lottie.u.j.m;
import com.airbnb.lottie.u.k.j;
import com.airbnb.lottie.w.k0.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2432a = c.a.a("nm", "p", "s", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(c cVar, d dVar) {
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        b bVar = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2432a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                mVar = a.b(cVar, dVar);
            } else if (a2 == 2) {
                fVar = d.e(cVar, dVar);
            } else if (a2 == 3) {
                bVar = d.c(cVar, dVar);
            } else if (a2 != 4) {
                cVar.z();
            } else {
                z = cVar.s();
            }
        }
        return new j(str, mVar, fVar, bVar, z);
    }
}
