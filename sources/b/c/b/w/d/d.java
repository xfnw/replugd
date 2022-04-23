package b.c.b.w.d;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f1991a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1992b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1993c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1994d;

    /* renamed from: e  reason: collision with root package name */
    private int f1995e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i, int i2, int i3, int i4) {
        this.f1991a = i;
        this.f1992b = i2;
        this.f1993c = i3;
        this.f1994d = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1993c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return i != -1 && this.f1993c == (i % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1992b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.f1995e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1995e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1991a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1994d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1992b - this.f1991a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return a(this.f1995e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f1995e = ((this.f1994d / 30) * 3) + (this.f1993c / 3);
    }

    public String toString() {
        return this.f1995e + "|" + this.f1994d;
    }
}
