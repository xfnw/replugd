package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.u.k.b;
import com.airbnb.lottie.u.k.n;
import com.airbnb.lottie.w.k0.c;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2444a = c.a.a("nm", "hd", "it");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(c cVar, d dVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2444a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                z = cVar.s();
            } else if (a2 != 2) {
                cVar.z();
            } else {
                cVar.m();
                while (cVar.r()) {
                    b a3 = g.a(cVar, dVar);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
                cVar.o();
            }
        }
        return new n(str, arrayList, z);
    }
}
