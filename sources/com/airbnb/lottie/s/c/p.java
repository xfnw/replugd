package com.airbnb.lottie.s.c;

import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.c;
import java.util.Collections;

/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {
    private final A l;

    public p(c<A> cVar) {
        this(cVar, null);
    }

    public p(c<A> cVar, A a2) {
        super(Collections.emptyList());
        new b();
        a(cVar);
        this.l = a2;
    }

    @Override // com.airbnb.lottie.s.c.a
    A a(a<K> aVar, float f) {
        return f();
    }

    @Override // com.airbnb.lottie.s.c.a
    float b() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.s.c.a
    public A f() {
        c<A> cVar = this.f2244e;
        A a2 = this.l;
        return cVar.a(0.0f, 0.0f, a2, a2, e(), e(), e());
    }

    @Override // com.airbnb.lottie.s.c.a
    public void g() {
        if (this.f2244e != null) {
            super.g();
        }
    }
}
