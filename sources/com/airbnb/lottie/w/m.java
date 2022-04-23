package com.airbnb.lottie.w;

import android.graphics.Path;
import com.airbnb.lottie.u.k.d;
import com.airbnb.lottie.u.k.f;
import com.airbnb.lottie.w.k0.c;
import com.king.zxing.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2467a = c.a.a("nm", "g", "o", "t", "s", e.z, "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f2468b = c.a.a("p", "k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(c cVar, com.airbnb.lottie.d dVar) {
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        f fVar = null;
        com.airbnb.lottie.u.j.c cVar2 = null;
        com.airbnb.lottie.u.j.d dVar2 = null;
        com.airbnb.lottie.u.j.f fVar2 = null;
        com.airbnb.lottie.u.j.f fVar3 = null;
        boolean z = false;
        while (cVar.r()) {
            switch (cVar.a(f2467a)) {
                case 0:
                    str = cVar.w();
                    break;
                case 1:
                    int i = -1;
                    cVar.n();
                    while (cVar.r()) {
                        int a2 = cVar.a(f2468b);
                        if (a2 == 0) {
                            i = cVar.u();
                        } else if (a2 != 1) {
                            cVar.y();
                            cVar.z();
                        } else {
                            cVar2 = d.a(cVar, dVar, i);
                        }
                    }
                    cVar.p();
                    break;
                case 2:
                    dVar2 = d.d(cVar, dVar);
                    break;
                case 3:
                    fVar = cVar.u() == 1 ? f.LINEAR : f.RADIAL;
                    break;
                case 4:
                    fVar2 = d.e(cVar, dVar);
                    break;
                case 5:
                    fVar3 = d.e(cVar, dVar);
                    break;
                case 6:
                    fillType = cVar.u() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = cVar.s();
                    break;
                default:
                    cVar.y();
                    cVar.z();
                    break;
            }
        }
        return new d(str, fVar, fillType, cVar2, dVar2, fVar2, fVar3, null, null, z);
    }
}
