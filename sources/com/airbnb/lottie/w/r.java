package com.airbnb.lottie.w;

import com.airbnb.lottie.d;
import com.airbnb.lottie.s.c.h;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.y.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class r {

    /* renamed from: a  reason: collision with root package name */
    static c.a f2478a = c.a.a("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<a<T>> a(c cVar, d dVar, float f, j0<T> j0Var) {
        ArrayList arrayList = new ArrayList();
        if (cVar.x() == c.b.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.n();
        while (cVar.r()) {
            if (cVar.a(f2478a) != 0) {
                cVar.z();
            } else if (cVar.x() == c.b.BEGIN_ARRAY) {
                cVar.m();
                if (cVar.x() == c.b.NUMBER) {
                    arrayList.add(q.a(cVar, dVar, f, j0Var, false));
                } else {
                    while (cVar.r()) {
                        arrayList.add(q.a(cVar, dVar, f, j0Var, true));
                    }
                }
                cVar.o();
            } else {
                arrayList.add(q.a(cVar, dVar, f, j0Var, false));
            }
        }
        cVar.p();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends a<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            a aVar = (a) list.get(i2);
            i2++;
            a aVar2 = (a) list.get(i2);
            aVar.f = Float.valueOf(aVar2.f2508e);
            if (aVar.f2506c == null && (t = aVar2.f2505b) != null) {
                aVar.f2506c = t;
                if (aVar instanceof h) {
                    ((h) aVar).h();
                }
            }
        }
        a aVar3 = (a) list.get(i);
        if ((aVar3.f2505b == null || aVar3.f2506c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
