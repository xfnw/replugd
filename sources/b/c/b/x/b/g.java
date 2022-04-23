package b.c.b.x.b;

/* loaded from: classes.dex */
final class g {

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f2046c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a  reason: collision with root package name */
    private final f f2047a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f2048b;

    private g(int i) {
        this.f2047a = f.a((i >> 3) & 3);
        this.f2048b = (byte) (i & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a(int i, int i2) {
        g b2 = b(i, i2);
        return b2 != null ? b2 : b(i ^ 21522, i2 ^ 21522);
    }

    private static g b(int i, int i2) {
        int[][] iArr;
        int c2;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr2 : f2046c) {
            int i5 = iArr2[0];
            if (i5 == i || i5 == i2) {
                return new g(iArr2[1]);
            }
            int c3 = c(i, i5);
            if (c3 < i3) {
                i4 = iArr2[1];
                i3 = c3;
            }
            if (i != i2 && (c2 = c(i2, i5)) < i3) {
                i4 = iArr2[1];
                i3 = c2;
            }
        }
        if (i3 <= 3) {
            return new g(i4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte a() {
        return this.f2048b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b() {
        return this.f2047a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2047a == gVar.f2047a && this.f2048b == gVar.f2048b;
    }

    public int hashCode() {
        return (this.f2047a.ordinal() << 3) | this.f2048b;
    }
}
