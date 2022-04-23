package b.c.b.v.r;

import b.c.b.i;
import b.c.b.v.k;

/* loaded from: classes.dex */
public abstract class a extends k {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1931a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1932b = new int[8];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f1933c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f1934d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    private final int[] f1935e;
    private final int[] f;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        int[] iArr = this.f1932b;
        this.f1935e = new int[iArr.length / 2];
        this.f = new int[iArr.length / 2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int[] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (k.a(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw i.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(int[] iArr) {
        int i;
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + i) + iArr[3]);
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i2 = Integer.MIN_VALUE;
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 > i2) {
                    i2 = i4;
                }
                if (i4 < i3) {
                    i3 = i4;
                }
            }
            if (i2 < i3 * 10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] b() {
        return this.f1932b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] c() {
        return this.f1931a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] e() {
        return this.f1934d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] f() {
        return this.f1935e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] g() {
        return this.f1933c;
    }
}
