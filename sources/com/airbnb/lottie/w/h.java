package com.airbnb.lottie.w;

import com.airbnb.lottie.u.b;
import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
public class h implements j0<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f2447a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f2448b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.j0
    public b a(c cVar, float f) {
        b.a aVar = b.a.CENTER;
        cVar.n();
        String str = null;
        double d2 = 0.0d;
        String str2 = null;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = true;
        while (cVar.r()) {
            switch (cVar.a(f2448b)) {
                case 0:
                    str = cVar.w();
                    break;
                case 1:
                    str2 = cVar.w();
                    break;
                case 2:
                    d2 = cVar.t();
                    break;
                case 3:
                    int u = cVar.u();
                    if (u <= b.a.CENTER.ordinal() && u >= 0) {
                        aVar = b.a.values()[u];
                        break;
                    } else {
                        aVar = b.a.CENTER;
                        break;
                    }
                case 4:
                    i = cVar.u();
                    break;
                case 5:
                    d3 = cVar.t();
                    break;
                case 6:
                    d4 = cVar.t();
                    break;
                case 7:
                    i2 = p.a(cVar);
                    break;
                case 8:
                    i3 = p.a(cVar);
                    break;
                case 9:
                    d5 = cVar.t();
                    break;
                case 10:
                    z = cVar.s();
                    break;
                default:
                    cVar.y();
                    cVar.z();
                    break;
            }
        }
        cVar.p();
        return new b(str, str2, d2, aVar, i, d3, d4, i2, i3, d5, z);
    }
}
