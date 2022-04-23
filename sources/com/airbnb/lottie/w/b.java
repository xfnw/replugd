package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.a;
import com.airbnb.lottie.u.j.k;
import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2433a = c.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static c.a f2434b = c.a.a("fc", "sc", "sw", "t");

    public static k a(c cVar, d dVar) {
        cVar.n();
        k kVar = null;
        while (cVar.r()) {
            if (cVar.a(f2433a) != 0) {
                cVar.y();
                cVar.z();
            } else {
                kVar = b(cVar, dVar);
            }
        }
        cVar.p();
        return kVar == null ? new k(null, null, null, null) : kVar;
    }

    private static k b(c cVar, d dVar) {
        cVar.n();
        a aVar = null;
        a aVar2 = null;
        com.airbnb.lottie.u.j.b bVar = null;
        com.airbnb.lottie.u.j.b bVar2 = null;
        while (cVar.r()) {
            int a2 = cVar.a(f2434b);
            if (a2 == 0) {
                aVar = d.a(cVar, dVar);
            } else if (a2 == 1) {
                aVar2 = d.a(cVar, dVar);
            } else if (a2 == 2) {
                bVar = d.c(cVar, dVar);
            } else if (a2 != 3) {
                cVar.y();
                cVar.z();
            } else {
                bVar2 = d.c(cVar, dVar);
            }
        }
        cVar.p();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
