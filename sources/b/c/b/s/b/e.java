package b.c.b.s.b;

import b.c.b.f;

/* loaded from: classes.dex */
public final class e {
    private static final e[] h = h();

    /* renamed from: a  reason: collision with root package name */
    private final int f1873a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1874b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1875c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1876d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1877e;
    private final c f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f1878a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1879b;

        private b(int i, int i2) {
            this.f1878a = i;
            this.f1879b = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f1878a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f1879b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f1880a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f1881b;

        private c(int i, b bVar) {
            this.f1880a = i;
            this.f1881b = new b[]{bVar};
        }

        private c(int i, b bVar, b bVar2) {
            this.f1880a = i;
            this.f1881b = new b[]{bVar, bVar2};
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b[] a() {
            return this.f1881b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f1880a;
        }
    }

    private e(int i, int i2, int i3, int i4, int i5, c cVar) {
        b[] a2;
        this.f1873a = i;
        this.f1874b = i2;
        this.f1875c = i3;
        this.f1876d = i4;
        this.f1877e = i5;
        this.f = cVar;
        int b2 = cVar.b();
        int i6 = 0;
        for (b bVar : cVar.a()) {
            i6 += bVar.a() * (bVar.b() + b2);
        }
        this.g = i6;
    }

    public static e a(int i, int i2) {
        e[] eVarArr;
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (e eVar : h) {
                if (eVar.f1874b == i && eVar.f1875c == i2) {
                    return eVar;
                }
            }
            throw f.a();
        }
        throw f.a();
    }

    private static e[] h() {
        return new e[]{new e(1, 10, 10, 8, 8, new c(5, new b(1, 3))), new e(2, 12, 12, 10, 10, new c(7, new b(1, 5))), new e(3, 14, 14, 12, 12, new c(10, new b(1, 8))), new e(4, 16, 16, 14, 14, new c(12, new b(1, 12))), new e(5, 18, 18, 16, 16, new c(14, new b(1, 18))), new e(6, 20, 20, 18, 18, new c(18, new b(1, 22))), new e(7, 22, 22, 20, 20, new c(20, new b(1, 30))), new e(8, 24, 24, 22, 22, new c(24, new b(1, 36))), new e(9, 26, 26, 24, 24, new c(28, new b(1, 44))), new e(10, 32, 32, 14, 14, new c(36, new b(1, 62))), new e(11, 36, 36, 16, 16, new c(42, new b(1, 86))), new e(12, 40, 40, 18, 18, new c(48, new b(1, 114))), new e(13, 44, 44, 20, 20, new c(56, new b(1, 144))), new e(14, 48, 48, 22, 22, new c(68, new b(1, 174))), new e(15, 52, 52, 24, 24, new c(42, new b(2, 102))), new e(16, 64, 64, 14, 14, new c(56, new b(2, 140))), new e(17, 72, 72, 16, 16, new c(36, new b(4, 92))), new e(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new e(19, 88, 88, 20, 20, new c(56, new b(4, 144))), new e(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new e(21, 104, 104, 24, 24, new c(56, new b(6, 136))), new e(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new e(23, 132, 132, 20, 20, new c(62, new b(8, 163))), new e(24, 144, 144, 22, 22, new c(62, new b(8, 156), new b(2, 155))), new e(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new e(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new e(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new e(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new e(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new e(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public int a() {
        return this.f1877e;
    }

    public int b() {
        return this.f1876d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return this.f;
    }

    public int d() {
        return this.f1875c;
    }

    public int e() {
        return this.f1874b;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.f1873a;
    }

    public String toString() {
        return String.valueOf(this.f1873a);
    }
}
