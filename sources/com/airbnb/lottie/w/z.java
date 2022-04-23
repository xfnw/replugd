package com.airbnb.lottie.w;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.m;
import com.airbnb.lottie.u.k.i;
import com.airbnb.lottie.w.k0.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2489a = c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(c cVar, d dVar) {
        String str = null;
        i.a aVar = null;
        b bVar = null;
        m<PointF, PointF> mVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        boolean z = false;
        while (cVar.r()) {
            switch (cVar.a(f2489a)) {
                case 0:
                    str = cVar.w();
                    break;
                case 1:
                    aVar = i.a.a(cVar.u());
                    break;
                case 2:
                    bVar = d.a(cVar, dVar, false);
                    break;
                case 3:
                    mVar = a.b(cVar, dVar);
                    break;
                case 4:
                    bVar2 = d.a(cVar, dVar, false);
                    break;
                case 5:
                    bVar4 = d.c(cVar, dVar);
                    break;
                case 6:
                    bVar6 = d.a(cVar, dVar, false);
                    break;
                case 7:
                    bVar3 = d.c(cVar, dVar);
                    break;
                case 8:
                    bVar5 = d.a(cVar, dVar, false);
                    break;
                case 9:
                    z = cVar.s();
                    break;
                default:
                    cVar.y();
                    cVar.z();
                    break;
            }
        }
        return new i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
