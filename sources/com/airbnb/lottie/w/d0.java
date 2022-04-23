package com.airbnb.lottie.w;

import android.graphics.PointF;
import com.airbnb.lottie.u.a;
import com.airbnb.lottie.u.k.l;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.x.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class d0 implements j0<l> {

    /* renamed from: a  reason: collision with root package name */
    public static final d0 f2439a = new d0();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f2440b = c.a.a("c", "v", "i", "o");

    private d0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.j0
    public l a(c cVar, float f) {
        if (cVar.x() == c.b.BEGIN_ARRAY) {
            cVar.m();
        }
        cVar.n();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (cVar.r()) {
            int a2 = cVar.a(f2440b);
            if (a2 == 0) {
                z = cVar.s();
            } else if (a2 == 1) {
                list = p.e(cVar, f);
            } else if (a2 == 2) {
                list2 = p.e(cVar, f);
            } else if (a2 != 3) {
                cVar.y();
                cVar.z();
            } else {
                list3 = p.e(cVar, f);
            }
        }
        cVar.p();
        if (cVar.x() == c.b.END_ARRAY) {
            cVar.o();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new l(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new a(g.a(list.get(i2), list3.get(i2)), g.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new a(g.a(list.get(i3), list3.get(i3)), g.a(pointF3, list2.get(0)), pointF3));
            }
            return new l(pointF, z, arrayList);
        }
    }
}
