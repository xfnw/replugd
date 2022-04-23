package b.c.b.v.r.g.e;

import b.c.b.f;

/* loaded from: classes.dex */
final class p extends q {

    /* renamed from: b  reason: collision with root package name */
    private final int f1965b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1966c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, int i2, int i3) {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw f.a();
        }
        this.f1965b = i2;
        this.f1966c = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1965b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1966c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f1965b == 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f1966c == 10;
    }
}
