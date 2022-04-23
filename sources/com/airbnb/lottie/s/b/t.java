package com.airbnb.lottie.s.b;

import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.u.k.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class t implements c, a.AbstractC0063a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2235a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a.AbstractC0063a> f2236b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final q.a f2237c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, Float> f2238d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Float> f2239e;
    private final a<?, Float> f;

    public t(com.airbnb.lottie.u.l.a aVar, q qVar) {
        qVar.b();
        this.f2235a = qVar.f();
        this.f2237c = qVar.e();
        this.f2238d = qVar.d().a();
        this.f2239e = qVar.a().a();
        this.f = qVar.c().a();
        aVar.a(this.f2238d);
        aVar.a(this.f2239e);
        aVar.a(this.f);
        this.f2238d.a(this);
        this.f2239e.a(this);
        this.f.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.AbstractC0063a aVar) {
        this.f2236b.add(aVar);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        for (int i = 0; i < this.f2236b.size(); i++) {
            this.f2236b.get(i).b();
        }
    }

    public a<?, Float> d() {
        return this.f2239e;
    }

    public a<?, Float> e() {
        return this.f;
    }

    public a<?, Float> f() {
        return this.f2238d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q.a g() {
        return this.f2237c;
    }

    public boolean h() {
        return this.f2235a;
    }
}
