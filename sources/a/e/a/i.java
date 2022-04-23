package a.e.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i {
    private static int k = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f148a;

    /* renamed from: e  reason: collision with root package name */
    public float f152e;
    a g;

    /* renamed from: b  reason: collision with root package name */
    public int f149b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f150c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f151d = 0;
    float[] f = new float[7];
    b[] h = new b[8];
    int i = 0;
    public int j = 0;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        k++;
    }

    public void a() {
        this.f148a = null;
        this.g = a.UNKNOWN;
        this.f151d = 0;
        this.f149b = -1;
        this.f150c = -1;
        this.f152e = 0.0f;
        this.i = 0;
        this.j = 0;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.i;
            if (i >= i2) {
                b[] bVarArr = this.h;
                if (i2 >= bVarArr.length) {
                    this.h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.h;
                int i3 = this.i;
                bVarArr2[i3] = bVar;
                this.i = i3 + 1;
                return;
            } else if (this.h[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
    }

    public void a(a aVar, String str) {
        this.g = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r1 >= ((r0 - r2) - 1)) goto L_0x001f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        r6 = r5.h;
        r3 = r2 + r1;
        r6[r3] = r6[r3 + 1];
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        r5.i--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(a.e.a.b r6) {
        /*
            r5 = this;
            int r0 = r5.i
            r1 = 0
            r2 = 0
        L_0x0004:
            if (r2 >= r0) goto L_0x0029
            a.e.a.b[] r3 = r5.h
            r3 = r3[r2]
            if (r3 != r6) goto L_0x0026
        L_0x000c:
            int r6 = r0 - r2
            int r6 = r6 + (-1)
            if (r1 >= r6) goto L_0x001f
            a.e.a.b[] r6 = r5.h
            int r3 = r2 + r1
            int r4 = r3 + 1
            r4 = r6[r4]
            r6[r3] = r4
            int r1 = r1 + 1
            goto L_0x000c
        L_0x001f:
            int r6 = r5.i
            int r6 = r6 + (-1)
            r5.i = r6
            return
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.i.b(a.e.a.b):void");
    }

    public final void c(b bVar) {
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            b[] bVarArr = this.h;
            bVarArr[i2].f131d.a(bVarArr[i2], bVar, false);
        }
        this.i = 0;
    }

    public String toString() {
        return "" + this.f148a;
    }
}
