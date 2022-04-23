package com.airbnb.lottie.s.c;

import com.airbnb.lottie.y.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends com.airbnb.lottie.y.a<K>> f2242c;

    /* renamed from: e  reason: collision with root package name */
    protected c<A> f2244e;
    private com.airbnb.lottie.y.a<K> f;
    private com.airbnb.lottie.y.a<K> g;

    /* renamed from: a  reason: collision with root package name */
    final List<AbstractC0063a> f2240a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f2241b = false;

    /* renamed from: d  reason: collision with root package name */
    private float f2243d = 0.0f;
    private float h = -1.0f;
    private A i = null;
    private float j = -1.0f;
    private float k = -1.0f;

    /* renamed from: com.airbnb.lottie.s.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0063a {
        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.y.a<K>> list) {
        this.f2242c = list;
    }

    private float i() {
        if (this.j == -1.0f) {
            this.j = this.f2242c.isEmpty() ? 0.0f : ((com.airbnb.lottie.y.a) this.f2242c.get(0)).d();
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.airbnb.lottie.y.a<K> a() {
        List<? extends com.airbnb.lottie.y.a<K>> list;
        com.airbnb.lottie.y.a<K> aVar = this.f;
        if (aVar != null && aVar.a(this.f2243d)) {
            return this.f;
        }
        com.airbnb.lottie.y.a<K> aVar2 = (com.airbnb.lottie.y.a) this.f2242c.get(list.size() - 1);
        if (this.f2243d < aVar2.d()) {
            for (int size = this.f2242c.size() - 1; size >= 0; size--) {
                aVar2 = (com.airbnb.lottie.y.a) this.f2242c.get(size);
                if (aVar2.a(this.f2243d)) {
                    break;
                }
            }
        }
        this.f = aVar2;
        return aVar2;
    }

    abstract A a(com.airbnb.lottie.y.a<K> aVar, float f);

    public void a(float f) {
        if (!this.f2242c.isEmpty()) {
            com.airbnb.lottie.y.a<K> a2 = a();
            if (f < i()) {
                f = i();
            } else if (f > b()) {
                f = b();
            }
            if (f != this.f2243d) {
                this.f2243d = f;
                com.airbnb.lottie.y.a<K> a3 = a();
                if (a2 != a3 || !a3.g()) {
                    g();
                }
            }
        }
    }

    public void a(AbstractC0063a aVar) {
        this.f2240a.add(aVar);
    }

    public void a(c<A> cVar) {
        c<A> cVar2 = this.f2244e;
        if (cVar2 != null) {
            cVar2.a((a<?, ?>) null);
        }
        this.f2244e = cVar;
        if (cVar != null) {
            cVar.a((a<?, ?>) this);
        }
    }

    float b() {
        float f;
        if (this.k == -1.0f) {
            if (this.f2242c.isEmpty()) {
                f = 1.0f;
            } else {
                List<? extends com.airbnb.lottie.y.a<K>> list = this.f2242c;
                f = ((com.airbnb.lottie.y.a) list.get(list.size() - 1)).a();
            }
            this.k = f;
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float c() {
        com.airbnb.lottie.y.a<K> a2 = a();
        if (a2.g()) {
            return 0.0f;
        }
        return a2.f2507d.getInterpolation(d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        if (this.f2241b) {
            return 0.0f;
        }
        com.airbnb.lottie.y.a<K> a2 = a();
        if (a2.g()) {
            return 0.0f;
        }
        return (this.f2243d - a2.d()) / (a2.a() - a2.d());
    }

    public float e() {
        return this.f2243d;
    }

    public A f() {
        com.airbnb.lottie.y.a<K> a2 = a();
        float c2 = c();
        if (this.f2244e == null && a2 == this.g && this.h == c2) {
            return this.i;
        }
        this.g = a2;
        this.h = c2;
        A a3 = a(a2, c2);
        this.i = a3;
        return a3;
    }

    public void g() {
        for (int i = 0; i < this.f2240a.size(); i++) {
            this.f2240a.get(i).b();
        }
    }

    public void h() {
        this.f2241b = true;
    }
}
