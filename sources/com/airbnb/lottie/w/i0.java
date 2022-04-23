package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.k.q;
import com.airbnb.lottie.w.k0.c;
import com.king.zxing.e;

/* loaded from: classes.dex */
class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2452a = c.a.a("s", e.z, "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q a(c cVar, d dVar) {
        String str = null;
        q.a aVar = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2452a);
            if (a2 == 0) {
                bVar = d.a(cVar, dVar, false);
            } else if (a2 == 1) {
                bVar2 = d.a(cVar, dVar, false);
            } else if (a2 == 2) {
                bVar3 = d.a(cVar, dVar, false);
            } else if (a2 == 3) {
                str = cVar.w();
            } else if (a2 == 4) {
                aVar = q.a.a(cVar.u());
            } else if (a2 != 5) {
                cVar.z();
            } else {
                z = cVar.s();
            }
        }
        return new q(str, aVar, bVar, bVar2, bVar3, z);
    }
}
