package b.c.b.w.d.k;

/* loaded from: classes.dex */
public final class b {
    public static final b f = new b(929, 3);

    /* renamed from: a  reason: collision with root package name */
    private final int[] f2014a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f2015b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2016c;

    /* renamed from: d  reason: collision with root package name */
    private final c f2017d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2018e;

    private b(int i, int i2) {
        this.f2018e = i;
        this.f2014a = new int[i];
        this.f2015b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f2014a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f2015b[this.f2014a[i5]] = i5;
        }
        this.f2016c = new c(this, new int[]{0});
        this.f2017d = new c(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return this.f2014a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2) {
        return (i + i2) % this.f2018e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        return this.f2017d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2018e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        if (i != 0) {
            return this.f2014a[(this.f2018e - this.f2015b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2016c;
        } else {
            int[] iArr = new int[i + 1];
            iArr[0] = i2;
            return new c(this, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        if (i != 0) {
            return this.f2015b[i];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f2014a;
        int[] iArr2 = this.f2015b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f2018e - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return this.f2016c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i, int i2) {
        int i3 = this.f2018e;
        return ((i + i3) - i2) % i3;
    }
}
