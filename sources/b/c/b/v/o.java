package b.c.b.v;

import b.c.b.l;
import b.c.b.m;
import b.c.b.r.a;

/* loaded from: classes.dex */
final class o {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1923c = {1, 1, 2};

    /* renamed from: a  reason: collision with root package name */
    private final m f1924a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final n f1925b = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(int i, a aVar, int i2) {
        int[] a2 = p.a(aVar, i2, false, f1923c);
        try {
            return this.f1925b.a(i, aVar, a2);
        } catch (l unused) {
            return this.f1924a.a(i, aVar, a2);
        }
    }
}
