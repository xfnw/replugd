package b.c.b.v.r.g.e;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f1955a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f1956b = a.NUMERIC;

    /* loaded from: classes.dex */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1955a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f1955a += i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.f1955a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f1956b == a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f1956b == a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f1956b = a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f1956b = a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f1956b = a.NUMERIC;
    }
}
