package com.airbnb.lottie.s.c;

import com.airbnb.lottie.u.k.c;
import com.airbnb.lottie.y.a;
import java.util.List;

/* loaded from: classes.dex */
public class d extends f<c> {
    private final c l;

    public d(List<a<c>> list) {
        super(list);
        int i = 0;
        c cVar = list.get(0).f2505b;
        i = cVar != null ? cVar.c() : i;
        this.l = new c(new float[i], new int[i]);
    }

    @Override // com.airbnb.lottie.s.c.a
    c a(a<c> aVar, float f) {
        this.l.a(aVar.f2505b, aVar.f2506c, f);
        return this.l;
    }
}
