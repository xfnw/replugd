package com.airbnb.lottie.w;

import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
class k {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f2455a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.u.c a(c cVar) {
        cVar.n();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (cVar.r()) {
            int a2 = cVar.a(f2455a);
            if (a2 == 0) {
                str = cVar.w();
            } else if (a2 == 1) {
                str2 = cVar.w();
            } else if (a2 == 2) {
                str3 = cVar.w();
            } else if (a2 != 3) {
                cVar.y();
                cVar.z();
            } else {
                f = (float) cVar.t();
            }
        }
        cVar.p();
        return new com.airbnb.lottie.u.c(str, str2, str3, f);
    }
}
