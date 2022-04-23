package com.airbnb.lottie.s.c;

import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.a;
import java.util.List;

/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.s.c.a
    Float a(a<Float> aVar, float f) {
        return Float.valueOf(b(aVar, f));
    }

    float b(a<Float> aVar, float f) {
        Float f2;
        if (aVar.f2505b == null || aVar.f2506c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.y.c<A> cVar = this.f2244e;
        return (cVar == 0 || (f2 = (Float) cVar.a(aVar.f2508e, aVar.f.floatValue(), aVar.f2505b, aVar.f2506c, f, d(), e())) == null) ? g.c(aVar.e(), aVar.b(), f) : f2.floatValue();
    }

    public float i() {
        return b(a(), c());
    }
}
