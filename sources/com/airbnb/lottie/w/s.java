package com.airbnb.lottie.w;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.u.j.b;
import com.airbnb.lottie.u.j.j;
import com.airbnb.lottie.u.j.k;
import com.airbnb.lottie.u.j.l;
import com.airbnb.lottie.u.l.d;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.x.h;
import com.airbnb.lottie.y.a;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2479a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f2480b = c.a.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f2481c = c.a.a("nm");

    public static d a(com.airbnb.lottie.d dVar) {
        Rect a2 = dVar.a();
        return new d(Collections.emptyList(), dVar, "__container", -1L, d.a.PRE_COMP, -1L, null, Collections.emptyList(), new l(), 0, 0, 0, 0.0f, 0.0f, a2.width(), a2.height(), null, null, Collections.emptyList(), d.b.NONE, null, false);
    }

    public static d a(c cVar, com.airbnb.lottie.d dVar) {
        float f;
        ArrayList arrayList;
        d.b bVar = d.b.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.n();
        Float valueOf = Float.valueOf(1.0f);
        d.a aVar = null;
        Float valueOf2 = Float.valueOf(0.0f);
        String str = "UNSET";
        long j = 0;
        long j2 = -1;
        String str2 = null;
        l lVar = null;
        j jVar = null;
        k kVar = null;
        b bVar2 = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f5 = 0.0f;
        boolean z = false;
        String str3 = null;
        while (cVar.r()) {
            switch (cVar.a(f2479a)) {
                case 0:
                    str = cVar.w();
                    continue;
                case 1:
                    j = cVar.u();
                    continue;
                case 2:
                    str2 = cVar.w();
                    continue;
                case 3:
                    int u = cVar.u();
                    if (u < d.a.UNKNOWN.ordinal()) {
                        aVar = d.a.values()[u];
                        continue;
                    } else {
                        aVar = d.a.UNKNOWN;
                    }
                case 4:
                    j2 = cVar.u();
                    continue;
                case 5:
                    i = (int) (cVar.u() * h.a());
                    continue;
                case 6:
                    i2 = (int) (cVar.u() * h.a());
                    continue;
                case 7:
                    i3 = Color.parseColor(cVar.w());
                    continue;
                case 8:
                    lVar = c.a(cVar, dVar);
                    continue;
                case 9:
                    bVar = d.b.values()[cVar.u()];
                    dVar.a(1);
                    continue;
                case 10:
                    cVar.m();
                    while (cVar.r()) {
                        arrayList2.add(u.a(cVar, dVar));
                    }
                    dVar.a(arrayList2.size());
                    break;
                case 11:
                    cVar.m();
                    while (cVar.r()) {
                        com.airbnb.lottie.u.k.b a2 = g.a(cVar, dVar);
                        if (a2 != null) {
                            arrayList3.add(a2);
                        }
                    }
                    break;
                case 12:
                    cVar.n();
                    while (cVar.r()) {
                        int a3 = cVar.a(f2480b);
                        if (a3 == 0) {
                            jVar = d.b(cVar, dVar);
                        } else if (a3 != 1) {
                            cVar.y();
                            cVar.z();
                        } else {
                            cVar.m();
                            if (cVar.r()) {
                                kVar = b.a(cVar, dVar);
                            }
                            while (cVar.r()) {
                                cVar.z();
                            }
                            cVar.o();
                        }
                    }
                    cVar.p();
                    continue;
                case 13:
                    cVar.m();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.r()) {
                        cVar.n();
                        while (cVar.r()) {
                            if (cVar.a(f2481c) != 0) {
                                cVar.y();
                                cVar.z();
                            } else {
                                arrayList4.add(cVar.w());
                            }
                        }
                        cVar.p();
                    }
                    cVar.o();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    continue;
                case 14:
                    f4 = (float) cVar.t();
                    continue;
                case 15:
                    f5 = (float) cVar.t();
                    continue;
                case 16:
                    i4 = (int) (cVar.u() * h.a());
                    continue;
                case 17:
                    i5 = (int) (cVar.u() * h.a());
                    continue;
                case 18:
                    f2 = (float) cVar.t();
                    continue;
                case 19:
                    f3 = (float) cVar.t();
                    continue;
                case 20:
                    bVar2 = d.a(cVar, dVar, false);
                    continue;
                case 21:
                    str3 = cVar.w();
                    continue;
                case 22:
                    z = cVar.s();
                    continue;
                default:
                    cVar.y();
                    cVar.z();
                    continue;
            }
            cVar.o();
        }
        cVar.p();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList5 = new ArrayList();
        if (f6 > 0.0f) {
            f = f4;
            arrayList = arrayList5;
            arrayList.add(new a(dVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
        } else {
            f = f4;
            arrayList = arrayList5;
        }
        if (f7 <= 0.0f) {
            f7 = dVar.e();
        }
        arrayList.add(new a(dVar, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList.add(new a(dVar, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str3)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new d(arrayList3, dVar, str, j, aVar, j2, str2, arrayList2, lVar, i, i2, i3, f, f5, i4, i5, jVar, kVar, arrayList, bVar, bVar2, z);
    }
}
