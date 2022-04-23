package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.k.f;
import com.airbnb.lottie.u.k.p;
import com.airbnb.lottie.w.k0.c;
import com.king.zxing.e;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f2469a = c.a.a("nm", "g", "o", "t", "s", e.z, "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f2470b = c.a.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f2471c = c.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.u.k.e a(c cVar, d dVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        f fVar = null;
        com.airbnb.lottie.u.j.c cVar2 = null;
        com.airbnb.lottie.u.j.d dVar2 = null;
        com.airbnb.lottie.u.j.f fVar2 = null;
        com.airbnb.lottie.u.j.f fVar3 = null;
        b bVar = null;
        p.b bVar2 = null;
        p.c cVar3 = null;
        float f = 0.0f;
        b bVar3 = null;
        boolean z = false;
        while (cVar.r()) {
            switch (cVar.a(f2469a)) {
                case 0:
                    str = cVar.w();
                    break;
                case 1:
                    int i = -1;
                    cVar.n();
                    while (cVar.r()) {
                        int a2 = cVar.a(f2470b);
                        if (a2 == 0) {
                            i = cVar.u();
                        } else if (a2 != 1) {
                            cVar.y();
                            cVar.z();
                        } else {
                            cVar2 = d.a(cVar, dVar, i);
                        }
                        cVar2 = cVar2;
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
                    bVar = d.c(cVar, dVar);
                    break;
                case 7:
                    bVar2 = p.b.values()[cVar.u() - 1];
                    break;
                case 8:
                    cVar3 = p.c.values()[cVar.u() - 1];
                    break;
                case 9:
                    f = (float) cVar.t();
                    break;
                case 10:
                    z = cVar.s();
                    break;
                case 11:
                    cVar.m();
                    while (cVar.r()) {
                        cVar.n();
                        String str2 = null;
                        b bVar4 = null;
                        while (cVar.r()) {
                            int a3 = cVar.a(f2471c);
                            if (a3 != 0) {
                                if (a3 != 1) {
                                    cVar.y();
                                    cVar.z();
                                } else {
                                    bVar4 = d.c(cVar, dVar);
                                }
                                bVar3 = bVar3;
                            } else {
                                str2 = cVar.w();
                            }
                        }
                        cVar.p();
                        if (str2.equals("o")) {
                            bVar3 = bVar4;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                dVar.a(true);
                                arrayList.add(bVar4);
                            }
                            bVar3 = bVar3;
                        }
                    }
                    cVar.o();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar3 = bVar3;
                    break;
                default:
                    cVar.y();
                    cVar.z();
                    break;
            }
        }
        return new com.airbnb.lottie.u.k.e(str, fVar, cVar2, dVar2, fVar2, fVar3, bVar, bVar2, cVar3, f, arrayList, bVar3, z);
    }
}
