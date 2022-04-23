package com.airbnb.lottie.s.c;

import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.s.c.a
    Integer a(a<Integer> aVar, float f) {
        return Integer.valueOf(b(aVar, f));
    }

    int b(a<Integer> aVar, float f) {
        Integer num;
        if (aVar.f2505b == null || aVar.f2506c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c<A> cVar = this.f2244e;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f2508e, aVar.f.floatValue(), aVar.f2505b, aVar.f2506c, f, d(), e())) == null) ? g.a(aVar.f(), aVar.c(), f) : num.intValue();
    }

    public int i() {
        return b(a(), c());
    }
}
