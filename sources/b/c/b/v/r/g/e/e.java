package b.c.b.v.r.g.e;

import b.c.b.i;
import b.c.b.r.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: c  reason: collision with root package name */
    private final String f1949c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1950d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2) {
        super(aVar);
        this.f1949c = str2;
        this.f1950d = str;
    }

    private void c(StringBuilder sb, int i) {
        int a2 = a().a(i, 16);
        if (a2 != 38400) {
            sb.append('(');
            sb.append(this.f1949c);
            sb.append(')');
            int i2 = a2 % 32;
            int i3 = a2 / 32;
            int i4 = (i3 % 12) + 1;
            int i5 = i3 / 12;
            if (i5 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i5);
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i2);
        }
    }

    @Override // b.c.b.v.r.g.e.i
    protected int a(int i) {
        return i % 100000;
    }

    @Override // b.c.b.v.r.g.e.i
    protected void b(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f1950d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // b.c.b.v.r.g.e.j
    public String c() {
        if (b().c() == 84) {
            StringBuilder sb = new StringBuilder();
            a(sb, 8);
            b(sb, 48, 20);
            c(sb, 68);
            return sb.toString();
        }
        throw i.a();
    }
}
