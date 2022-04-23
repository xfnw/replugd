package b.c.b.v.r.g.e;

import b.c.b.i;
import b.c.b.r.a;

/* loaded from: classes.dex */
abstract class f extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        super(aVar);
    }

    @Override // b.c.b.v.r.g.e.j
    public String c() {
        if (b().c() == 60) {
            StringBuilder sb = new StringBuilder();
            a(sb, 5);
            b(sb, 45, 15);
            return sb.toString();
        }
        throw i.a();
    }
}
