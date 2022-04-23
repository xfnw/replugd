package com.airbnb.lottie.w;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.e;
import com.airbnb.lottie.u.j.i;
import com.airbnb.lottie.u.j.m;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.x.h;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2431a = c.a.a("k", "x", "y");

    public static e a(c cVar, d dVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar.x() == c.b.BEGIN_ARRAY) {
            cVar.m();
            while (cVar.r()) {
                arrayList.add(w.a(cVar, dVar));
            }
            cVar.o();
            r.a(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.y.a(p.d(cVar, h.a())));
        }
        return new e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m<PointF, PointF> b(c cVar, d dVar) {
        cVar.n();
        e eVar = null;
        boolean z = false;
        b bVar = null;
        b bVar2 = null;
        while (cVar.x() != c.b.END_OBJECT) {
            int a2 = cVar.a(f2431a);
            if (a2 == 0) {
                eVar = a(cVar, dVar);
            } else if (a2 != 1) {
                if (a2 != 2) {
                    cVar.y();
                    cVar.z();
                } else if (cVar.x() == c.b.STRING) {
                    cVar.z();
                    z = true;
                } else {
                    bVar2 = d.c(cVar, dVar);
                }
            } else if (cVar.x() == c.b.STRING) {
                cVar.z();
                z = true;
            } else {
                bVar = d.c(cVar, dVar);
            }
        }
        cVar.p();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new i(bVar, bVar2);
    }
}
