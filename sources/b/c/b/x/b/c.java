package b.c.b.x.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
abstract class c extends Enum<c> {

    /* renamed from: b  reason: collision with root package name */
    public static final c f2035b = new a("DATA_MASK_000", 0);

    /* renamed from: c  reason: collision with root package name */
    public static final c f2036c = new c("DATA_MASK_001", 1) { // from class: b.c.b.x.b.c.b
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final c f2037d = new c("DATA_MASK_010", 2) { // from class: b.c.b.x.b.c.c
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return i3 % 3 == 0;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final c f2038e = new c("DATA_MASK_011", 3) { // from class: b.c.b.x.b.c.d
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    };
    public static final c f = new c("DATA_MASK_100", 4) { // from class: b.c.b.x.b.c.e
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    };
    public static final c g = new c("DATA_MASK_101", 5) { // from class: b.c.b.x.b.c.f
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    };
    public static final c h = new c("DATA_MASK_110", 6) { // from class: b.c.b.x.b.c.g
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    };
    public static final c i = new c("DATA_MASK_111", 7) { // from class: b.c.b.x.b.c.h
        @Override // b.c.b.x.b.c
        boolean a(int i2, int i3) {
            return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
        }
    };
    private static final /* synthetic */ c[] j = {f2035b, f2036c, f2037d, f2038e, f, g, h, i};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    static class a extends c {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.c.b.x.b.c
        boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    private c(String str, int i2) {
    }

    /* synthetic */ c(String str, int i2, a aVar) {
        this(str, i2);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) j.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b.c.b.r.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bVar.a(i4, i3);
                }
            }
        }
    }

    abstract boolean a(int i2, int i3);
}
