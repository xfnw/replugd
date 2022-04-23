package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.l;
import com.airbnb.lottie.u.k.k;
import com.airbnb.lottie.w.k0.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2435a = c.a.a("nm", "c", "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(c cVar, d dVar) {
        String str = null;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2435a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                bVar = d.a(cVar, dVar, false);
            } else if (a2 == 2) {
                bVar2 = d.a(cVar, dVar, false);
            } else if (a2 == 3) {
                lVar = c.a(cVar, dVar);
            } else if (a2 != 4) {
                cVar.z();
            } else {
                z = cVar.s();
            }
        }
        return new k(str, bVar, bVar2, lVar, z);
    }
}
