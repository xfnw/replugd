package b.c.b.v.r.g.e;

import b.c.b.r.a;

/* loaded from: classes.dex */
abstract class i extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        super(aVar);
    }

    protected abstract int a(int i);

    protected abstract void b(StringBuilder sb, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(StringBuilder sb, int i, int i2) {
        int a2 = a().a(i, i2);
        b(sb, a2);
        int a3 = a(a2);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (a3 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(a3);
    }
}
