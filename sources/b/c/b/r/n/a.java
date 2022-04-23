package b.c.b.r.n;

/* loaded from: classes.dex */
public final class a {
    public static final a m;
    public static final a n;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1847a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1848b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1849c;

    /* renamed from: d  reason: collision with root package name */
    private final b f1850d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1851e;
    private final int f;
    private final int g;
    public static final a h = new a(4201, 4096, 1);
    public static final a i = new a(1033, 1024, 1);
    public static final a j = new a(67, 64, 1);
    public static final a k = new a(19, 16, 1);
    public static final a l = new a(285, 256, 0);
    public static final a o = j;

    static {
        a aVar = new a(301, 256, 1);
        m = aVar;
        n = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.f = i2;
        this.f1851e = i3;
        this.g = i4;
        this.f1847a = new int[i3];
        this.f1848b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f1847a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f1848b[this.f1847a[i7]] = i7;
        }
        this.f1849c = new b(this, new int[]{0});
        this.f1850d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, int i3) {
        return i2 ^ i3;
    }

    public int a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2) {
        return this.f1847a[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f1849c;
        } else {
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new b(this, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i2) {
        if (i2 != 0) {
            return this.f1847a[(this.f1851e - this.f1848b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f1847a;
        int[] iArr2 = this.f1848b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f1851e - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.f1850d;
    }

    public int c() {
        return this.f1851e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        if (i2 != 0) {
            return this.f1848b[i2];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b d() {
        return this.f1849c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f) + ',' + this.f1851e + ')';
    }
}
