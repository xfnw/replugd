package b.c.b.x.c;

import b.c.b.i;
import b.c.b.o;
import b.c.b.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final b.c.b.r.b f2073a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2075c;

    /* renamed from: e  reason: collision with root package name */
    private final p f2077e;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f2074b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final int[] f2076d = new int[5];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements Serializable, Comparator<d> {

        /* renamed from: b  reason: collision with root package name */
        private final float f2078b;

        private b(float f) {
            this.f2078b = f;
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            int compare = Integer.compare(dVar2.c(), dVar.c());
            return compare == 0 ? Float.compare(Math.abs(dVar.d() - this.f2078b), Math.abs(dVar2.d() - this.f2078b)) : compare;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements Serializable, Comparator<d> {

        /* renamed from: b  reason: collision with root package name */
        private final float f2079b;

        private c(float f) {
            this.f2079b = f;
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.d() - this.f2079b), Math.abs(dVar.d() - this.f2079b));
        }
    }

    public e(b.c.b.r.b bVar, p pVar) {
        this.f2073a = bVar;
        this.f2077e = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r2[1] <= r13) goto L_0x003e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r3 < 0) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r0.b(r3, r12) == false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r2[0] > r13) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r2[0] <= r13) goto L_0x0058;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r11 >= r1) goto L_0x0069;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
        if (r0.b(r11, r12) == false) goto L_0x0069;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        if (r11 != r1) goto L_0x006c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r11 >= r1) goto L_0x0081;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r0.b(r11, r12) != false) goto L_0x0081;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
        if (r2[3] >= r13) goto L_0x0081;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        if (r11 == r1) goto L_0x00c5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
        if (r2[3] < r13) goto L_0x0088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
        if (r11 >= r1) goto L_0x009d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        if (r0.b(r11, r12) == false) goto L_0x009d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
        if (r2[4] >= r13) goto L_0x009d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r2[4] < r13) goto L_0x00a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b7, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L_0x00ba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b9, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00be, code lost:
        if (c(r2) == false) goto L_0x00c5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c4, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.x.c.e.a(int, int, int, int):float");
    }

    private static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private int a() {
        if (this.f2074b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f2074b) {
            if (dVar2.c() >= 2) {
                if (dVar == null) {
                    dVar = dVar2;
                } else {
                    this.f2075c = true;
                    return ((int) (Math.abs(dVar.a() - dVar2.a()) - Math.abs(dVar.b() - dVar2.b()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] b2 = b();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.f2073a.b(i2 - i6, i - i6)) {
            b2[2] = b2[2] + 1;
            i6++;
        }
        if (b2[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.f2073a.b(i2 - i6, i - i6)) {
            b2[1] = b2[1] + 1;
            i6++;
        }
        if (b2[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.f2073a.b(i2 - i6, i - i6)) {
            b2[0] = b2[0] + 1;
            i6++;
        }
        if (b2[0] == 0) {
            return false;
        }
        int c2 = this.f2073a.c();
        int e2 = this.f2073a.e();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= c2 || (i5 = i2 + i7) >= e2 || !this.f2073a.b(i5, i8)) {
                break;
            }
            b2[2] = b2[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= c2 || (i4 = i2 + i7) >= e2 || this.f2073a.b(i4, i9)) {
                break;
            }
            b2[3] = b2[3] + 1;
            i7++;
        }
        if (b2[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= c2 || (i3 = i2 + i7) >= e2 || !this.f2073a.b(i3, i10)) {
                break;
            }
            b2[4] = b2[4] + 1;
            i7++;
        }
        if (b2[4] == 0) {
            return false;
        }
        return d(b2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r2[1] <= r13) goto L_0x003e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r3 < 0) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r0.b(r12, r3) == false) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r2[0] > r13) goto L_0x0053;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r2[0] <= r13) goto L_0x0058;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r11 >= r1) goto L_0x0069;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
        if (r0.b(r12, r11) == false) goto L_0x0069;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        if (r11 != r1) goto L_0x006c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r11 >= r1) goto L_0x0081;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r0.b(r12, r11) != false) goto L_0x0081;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
        if (r2[3] >= r13) goto L_0x0081;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        if (r11 == r1) goto L_0x00c7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
        if (r2[3] < r13) goto L_0x0088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
        if (r11 >= r1) goto L_0x009d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        if (r0.b(r12, r11) == false) goto L_0x009d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
        if (r2[4] >= r13) goto L_0x009d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r2[4] < r13) goto L_0x00a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b9, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L_0x00bc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        if (c(r2) == false) goto L_0x00c7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c6, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.x.c.e.b(int, int, int, int):float");
    }

    private int[] b() {
        a(this.f2076d);
        return this.f2076d;
    }

    private boolean c() {
        int size = this.f2074b.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (d dVar : this.f2074b) {
            if (dVar.c() >= 2) {
                i++;
                f2 += dVar.d();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / size;
        for (d dVar2 : this.f2074b) {
            f += Math.abs(dVar2.d() - f3);
        }
        return f <= f2 * 0.05f;
    }

    protected static boolean c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    protected static boolean d(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    private d[] d() {
        float f;
        int size = this.f2074b.size();
        if (size >= 3) {
            float f2 = 0.0f;
            if (size > 3) {
                float f3 = 0.0f;
                float f4 = 0.0f;
                for (d dVar : this.f2074b) {
                    float d2 = dVar.d();
                    f3 += d2;
                    f4 += d2 * d2;
                }
                float f5 = f3 / size;
                float sqrt = (float) Math.sqrt((f4 / f) - (f5 * f5));
                Collections.sort(this.f2074b, new c(f5));
                float max = Math.max(0.2f * f5, sqrt);
                int i = 0;
                while (i < this.f2074b.size() && this.f2074b.size() > 3) {
                    if (Math.abs(this.f2074b.get(i).d() - f5) > max) {
                        this.f2074b.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.f2074b.size() > 3) {
                for (d dVar2 : this.f2074b) {
                    f2 += dVar2.d();
                }
                Collections.sort(this.f2074b, new b(f2 / this.f2074b.size()));
                List<d> list = this.f2074b;
                list.subList(3, list.size()).clear();
            }
            return new d[]{this.f2074b.get(0), this.f2074b.get(1), this.f2074b.get(2)};
        }
        throw i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f a(Map<b.c.b.e, ?> map) {
        boolean z = map != null && map.containsKey(b.c.b.e.TRY_HARDER);
        int c2 = this.f2073a.c();
        int e2 = this.f2073a.e();
        int i = (c2 * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        boolean z2 = false;
        while (i2 < c2 && !z2) {
            a(iArr);
            boolean z3 = z2;
            int i4 = 0;
            int i5 = 0;
            while (i4 < e2) {
                if (this.f2073a.b(i4, i2)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (!c(iArr) || !a(iArr, i2, i4)) {
                    b(iArr);
                    i5 = 3;
                } else {
                    if (this.f2075c) {
                        z3 = c();
                    } else {
                        int a2 = a();
                        if (a2 > iArr[2]) {
                            i2 += (a2 - iArr[2]) - 2;
                            i4 = e2 - 1;
                        }
                    }
                    a(iArr);
                    i5 = 0;
                    i3 = 2;
                }
                i4++;
            }
            if (!c(iArr) || !a(iArr, i2, e2)) {
                i3 = i3;
            } else {
                int i6 = iArr[0];
                if (this.f2075c) {
                    z2 = c();
                    i3 = i6;
                    i2 += i3;
                } else {
                    i3 = i6;
                }
            }
            z2 = z3;
            i2 += i3;
        }
        d[] d2 = d();
        o.a(d2);
        return new f(d2);
    }

    protected final void a(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    protected final boolean a(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i2);
        float b2 = b(i, a2, iArr[2], i3);
        if (!Float.isNaN(b2)) {
            int i4 = (int) b2;
            float a3 = a(a2, i4, iArr[2], i3);
            if (!Float.isNaN(a3) && a(i4, (int) a3)) {
                float f = i3 / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f2074b.size()) {
                        break;
                    }
                    d dVar = this.f2074b.get(i5);
                    if (dVar.a(f, b2, a3)) {
                        this.f2074b.set(i5, dVar.b(b2, a3, f));
                        z = true;
                        break;
                    }
                    i5++;
                }
                if (!z) {
                    d dVar2 = new d(a3, b2, f);
                    this.f2074b.add(dVar2);
                    p pVar = this.f2077e;
                    if (pVar != null) {
                        pVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected final void b(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
