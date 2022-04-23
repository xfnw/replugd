package com.airbnb.lottie.s.c;

import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.s.c.a
    Integer a(a<Integer> aVar, float f) {
        return Integer.valueOf(b(aVar, f));
    }

    public int b(a<Integer> aVar, float f) {
        Integer num;
        Integer num2 = aVar.f2505b;
        if (num2 == null || aVar.f2506c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = aVar.f2506c.intValue();
        c<A> cVar = this.f2244e;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f2508e, aVar.f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, d(), e())) == null) ? com.airbnb.lottie.x.b.a(g.a(f, 0.0f, 1.0f), intValue, intValue2) : num.intValue();
    }

    public int i() {
        return b(a(), c());
    }
}
