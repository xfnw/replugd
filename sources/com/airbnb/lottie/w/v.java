package com.airbnb.lottie.w;

import com.airbnb.lottie.u.k.h;
import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
class v {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2486a = c.a.a("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(c cVar) {
        String str = null;
        h.a aVar = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2486a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                aVar = h.a.a(cVar.u());
            } else if (a2 != 2) {
                cVar.y();
                cVar.z();
            } else {
                z = cVar.s();
            }
        }
        return new h(str, aVar, z);
    }
}
