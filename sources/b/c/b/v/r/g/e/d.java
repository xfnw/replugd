package b.c.b.v.r.g.e;

import b.c.b.i;
import b.c.b.r.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        super(aVar);
    }

    @Override // b.c.b.v.r.g.e.j
    public String c() {
        if (b().c() >= 48) {
            StringBuilder sb = new StringBuilder();
            a(sb, 8);
            int a2 = a().a(48, 2);
            sb.append("(393");
            sb.append(a2);
            sb.append(')');
            int a3 = a().a(50, 10);
            if (a3 / 100 == 0) {
                sb.append('0');
            }
            if (a3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a3);
            sb.append(a().a(60, (String) null).b());
            return sb.toString();
        }
        throw i.a();
    }
}
