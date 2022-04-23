package com.airbnb.lottie.w;

import com.airbnb.lottie.u.d;
import com.airbnb.lottie.u.k.n;
import com.airbnb.lottie.w.k0.c;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2453a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f2454b = c.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(c cVar, com.airbnb.lottie.d dVar) {
        ArrayList arrayList = new ArrayList();
        cVar.n();
        String str = null;
        double d2 = 0.0d;
        String str2 = null;
        double d3 = 0.0d;
        char c2 = 0;
        while (cVar.r()) {
            int a2 = cVar.a(f2453a);
            if (a2 == 0) {
                c2 = cVar.w().charAt(0);
            } else if (a2 == 1) {
                d2 = cVar.t();
            } else if (a2 == 2) {
                d3 = cVar.t();
            } else if (a2 == 3) {
                str = cVar.w();
            } else if (a2 == 4) {
                str2 = cVar.w();
            } else if (a2 != 5) {
                cVar.y();
                cVar.z();
            } else {
                cVar.n();
                while (cVar.r()) {
                    if (cVar.a(f2454b) != 0) {
                        cVar.y();
                        cVar.z();
                    } else {
                        cVar.m();
                        while (cVar.r()) {
                            arrayList.add((n) g.a(cVar, dVar));
                        }
                        cVar.o();
                    }
                }
                cVar.p();
            }
        }
        cVar.p();
        return new d(arrayList, c2, d2, d3, str, str2);
    }
}
