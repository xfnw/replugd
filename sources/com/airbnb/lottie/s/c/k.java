package com.airbnb.lottie.s.c;

import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.c;
import com.airbnb.lottie.y.d;
import java.util.List;

/* loaded from: classes.dex */
public class k extends f<d> {
    private final d l = new d();

    public k(List<a<d>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.s.c.a
    public d a(a<d> aVar, float f) {
        d dVar;
        d dVar2;
        d dVar3 = aVar.f2505b;
        if (dVar3 == null || (dVar = aVar.f2506c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar4 = dVar3;
        d dVar5 = dVar;
        c<A> cVar = this.f2244e;
        if (cVar != 0 && (dVar2 = (d) cVar.a(aVar.f2508e, aVar.f.floatValue(), dVar4, dVar5, f, d(), e())) != null) {
            return dVar2;
        }
        this.l.b(g.c(dVar4.a(), dVar5.a(), f), g.c(dVar4.b(), dVar5.b(), f));
        return this.l;
    }
}
