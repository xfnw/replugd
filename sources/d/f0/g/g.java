package d.f0.g;

import d.a0;
import d.e;
import d.f0.f.c;
import d.i;
import d.p;
import d.t;
import d.y;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements t.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<t> f3474a;

    /* renamed from: b  reason: collision with root package name */
    private final d.f0.f.g f3475b;

    /* renamed from: c  reason: collision with root package name */
    private final c f3476c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3477d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3478e;
    private final y f;
    private final e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<t> list, d.f0.f.g gVar, c cVar, c cVar2, int i, y yVar, e eVar, p pVar, int i2, int i3, int i4) {
        this.f3474a = list;
        this.f3477d = cVar2;
        this.f3475b = gVar;
        this.f3476c = cVar;
        this.f3478e = i;
        this.f = yVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // d.t.a
    public int a() {
        return this.k;
    }

    @Override // d.t.a
    public a0 a(y yVar) {
        return a(yVar, this.f3475b, this.f3476c, this.f3477d);
    }

    public a0 a(y yVar, d.f0.f.g gVar, c cVar, c cVar2) {
        if (this.f3478e < this.f3474a.size()) {
            this.l++;
            if (this.f3476c != null && !this.f3477d.a(yVar.g())) {
                throw new IllegalStateException("network interceptor " + this.f3474a.get(this.f3478e - 1) + " must retain the same host and port");
            } else if (this.f3476c == null || this.l <= 1) {
                g gVar2 = new g(this.f3474a, gVar, cVar, cVar2, this.f3478e + 1, yVar, this.g, this.h, this.i, this.j, this.k);
                t tVar = this.f3474a.get(this.f3478e);
                a0 a2 = tVar.a(gVar2);
                if (cVar != null && this.f3478e + 1 < this.f3474a.size() && gVar2.l != 1) {
                    throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                } else if (a2 == null) {
                    throw new NullPointerException("interceptor " + tVar + " returned null");
                } else if (a2.m() != null) {
                    return a2;
                } else {
                    throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f3474a.get(this.f3478e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // d.t.a
    public y b() {
        return this.f;
    }

    @Override // d.t.a
    public int c() {
        return this.i;
    }

    @Override // d.t.a
    public int d() {
        return this.j;
    }

    public e e() {
        return this.g;
    }

    public i f() {
        return this.f3477d;
    }

    public p g() {
        return this.h;
    }

    public c h() {
        return this.f3476c;
    }

    public d.f0.f.g i() {
        return this.f3475b;
    }
}
