package d.f0.f;

import d.a0;
import d.f0.g.g;
import d.t;
import d.v;
import d.y;

/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a  reason: collision with root package name */
    public final v f3443a;

    public a(v vVar) {
        this.f3443a = vVar;
    }

    @Override // d.t
    public a0 a(t.a aVar) {
        g gVar = (g) aVar;
        y b2 = gVar.b();
        g i = gVar.i();
        return gVar.a(b2, i, i.a(this.f3443a, aVar, !b2.e().equals("GET")), i.c());
    }
}
