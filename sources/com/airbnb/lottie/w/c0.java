package com.airbnb.lottie.w;

import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.y.d;

/* loaded from: classes.dex */
public class c0 implements j0<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f2438a = new c0();

    private c0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.j0
    public d a(c cVar, float f) {
        boolean z = cVar.x() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.m();
        }
        float t = (float) cVar.t();
        float t2 = (float) cVar.t();
        while (cVar.r()) {
            cVar.z();
        }
        if (z) {
            cVar.o();
        }
        return new d((t / 100.0f) * f, (t2 / 100.0f) * f);
    }
}
