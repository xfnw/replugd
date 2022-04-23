package b.c.b.v.r.g.e;

import b.c.b.i;
import b.c.b.r.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        super(aVar);
    }

    @Override // b.c.b.v.r.g.e.j
    public String c() {
        if (b().c() >= 48) {
            StringBuilder sb = new StringBuilder();
            a(sb, 8);
            int a2 = a().a(48, 2);
            sb.append("(392");
            sb.append(a2);
            sb.append(')');
            sb.append(a().a(50, (String) null).b());
            return sb.toString();
        }
        throw i.a();
    }
}
