package b.c.b.v.r.g.e;

import b.c.b.r.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        super(aVar);
    }

    @Override // b.c.b.v.r.g.e.i
    protected int a(int i) {
        return i < 10000 ? i : i - 10000;
    }

    @Override // b.c.b.v.r.g.e.i
    protected void b(StringBuilder sb, int i) {
        sb.append(i < 10000 ? "(3202)" : "(3203)");
    }
}
