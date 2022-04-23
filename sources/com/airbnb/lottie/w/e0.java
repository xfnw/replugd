package com.airbnb.lottie.w;

import android.graphics.Path;
import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.a;
import com.airbnb.lottie.u.k.m;
import com.airbnb.lottie.w.k0.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2442a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(c cVar, d dVar) {
        String str = null;
        a aVar = null;
        com.airbnb.lottie.u.j.d dVar2 = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2442a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                aVar = d.a(cVar, dVar);
            } else if (a2 == 2) {
                dVar2 = d.d(cVar, dVar);
            } else if (a2 == 3) {
                z = cVar.s();
            } else if (a2 == 4) {
                i = cVar.u();
            } else if (a2 != 5) {
                cVar.y();
                cVar.z();
            } else {
                z2 = cVar.s();
            }
        }
        return new m(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2, z2);
    }
}
