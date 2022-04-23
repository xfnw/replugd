package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.h;
import com.airbnb.lottie.u.k.o;
import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
class g0 {

    /* renamed from: a  reason: collision with root package name */
    static c.a f2446a = c.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(c cVar, d dVar) {
        int i = 0;
        String str = null;
        h hVar = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2446a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                i = cVar.u();
            } else if (a2 == 2) {
                hVar = d.g(cVar, dVar);
            } else if (a2 != 3) {
                cVar.z();
            } else {
                z = cVar.s();
            }
        }
        return new o(str, i, hVar, z);
    }
}
