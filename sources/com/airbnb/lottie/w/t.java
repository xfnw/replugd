package com.airbnb.lottie.w;

import android.graphics.Rect;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g;
import com.airbnb.lottie.u.l.d;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.x.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2482a = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static c.a f2483b = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f2484c = c.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final c.a f2485d = c.a.a("cm", "tm", "dr");

    public static d a(c cVar) {
        c cVar2 = cVar;
        float a2 = h.a();
        a.d.d<com.airbnb.lottie.u.l.d> dVar = new a.d.d<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        a.d.h<com.airbnb.lottie.u.d> hVar = new a.d.h<>();
        d dVar2 = new d();
        cVar.n();
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (cVar.r()) {
            switch (cVar2.a(f2482a)) {
                case 0:
                    i = cVar.u();
                    continue;
                    cVar2 = cVar;
                case 1:
                    i2 = cVar.u();
                    continue;
                    cVar2 = cVar;
                case 2:
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    f = (float) cVar.t();
                    break;
                case 3:
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    f2 = ((float) cVar.t()) - 0.01f;
                    break;
                case 4:
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    f3 = (float) cVar.t();
                    break;
                case 5:
                    String[] split = cVar.w().split("\\.");
                    if (!h.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        dVar2.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    break;
                case 6:
                    a(cVar2, dVar2, arrayList, dVar);
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    break;
                case 7:
                    a(cVar2, dVar2, hashMap, hashMap2);
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    break;
                case 8:
                    a(cVar2, hashMap3);
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    break;
                case 9:
                    a(cVar2, dVar2, hVar);
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    break;
                case 10:
                    a(cVar2, dVar2, arrayList2);
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    break;
                default:
                    hashMap3 = hashMap3;
                    arrayList2 = arrayList2;
                    cVar.y();
                    cVar.z();
                    break;
            }
            cVar2 = cVar;
        }
        dVar2.a(new Rect(0, 0, (int) (i * a2), (int) (i2 * a2)), f, f2, f3, arrayList, dVar, hashMap, hashMap2, hVar, hashMap3, arrayList2);
        return dVar2;
    }

    private static void a(c cVar, d dVar, a.d.h<com.airbnb.lottie.u.d> hVar) {
        cVar.m();
        while (cVar.r()) {
            com.airbnb.lottie.u.d a2 = j.a(cVar, dVar);
            hVar.c(a2.hashCode(), a2);
        }
        cVar.o();
    }

    private static void a(c cVar, d dVar, List<com.airbnb.lottie.u.h> list) {
        cVar.m();
        while (cVar.r()) {
            String str = null;
            cVar.n();
            float f = 0.0f;
            float f2 = 0.0f;
            while (cVar.r()) {
                int a2 = cVar.a(f2485d);
                if (a2 == 0) {
                    str = cVar.w();
                } else if (a2 == 1) {
                    f = (float) cVar.t();
                } else if (a2 != 2) {
                    cVar.y();
                    cVar.z();
                } else {
                    f2 = (float) cVar.t();
                }
            }
            cVar.p();
            list.add(new com.airbnb.lottie.u.h(str, f, f2));
        }
        cVar.o();
    }

    private static void a(c cVar, d dVar, List<com.airbnb.lottie.u.l.d> list, a.d.d<com.airbnb.lottie.u.l.d> dVar2) {
        cVar.m();
        int i = 0;
        while (cVar.r()) {
            com.airbnb.lottie.u.l.d a2 = s.a(cVar, dVar);
            if (a2.d() == d.a.IMAGE) {
                i++;
            }
            list.add(a2);
            dVar2.c(a2.b(), a2);
            if (i > 4) {
                com.airbnb.lottie.x.d.b("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.o();
    }

    private static void a(c cVar, com.airbnb.lottie.d dVar, Map<String, List<com.airbnb.lottie.u.l.d>> map, Map<String, g> map2) {
        cVar.m();
        while (cVar.r()) {
            ArrayList arrayList = new ArrayList();
            a.d.d dVar2 = new a.d.d();
            cVar.n();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (cVar.r()) {
                int a2 = cVar.a(f2483b);
                if (a2 == 0) {
                    str = cVar.w();
                } else if (a2 == 1) {
                    cVar.m();
                    while (cVar.r()) {
                        com.airbnb.lottie.u.l.d a3 = s.a(cVar, dVar);
                        dVar2.c(a3.b(), a3);
                        arrayList.add(a3);
                    }
                    cVar.o();
                } else if (a2 == 2) {
                    i = cVar.u();
                } else if (a2 == 3) {
                    i2 = cVar.u();
                } else if (a2 == 4) {
                    str2 = cVar.w();
                } else if (a2 != 5) {
                    cVar.y();
                    cVar.z();
                } else {
                    str3 = cVar.w();
                }
            }
            cVar.p();
            if (str2 != null) {
                g gVar = new g(i, i2, str, str2, str3);
                map2.put(gVar.d(), gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.o();
    }

    private static void a(c cVar, Map<String, com.airbnb.lottie.u.c> map) {
        cVar.n();
        while (cVar.r()) {
            if (cVar.a(f2484c) != 0) {
                cVar.y();
                cVar.z();
            } else {
                cVar.m();
                while (cVar.r()) {
                    com.airbnb.lottie.u.c a2 = k.a(cVar);
                    map.put(a2.b(), a2);
                }
                cVar.o();
            }
        }
        cVar.p();
    }
}
