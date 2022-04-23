package b.c.b.v;

import b.c.b.d;
import b.c.b.e;
import b.c.b.f;
import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import b.c.b.r.a;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends k {

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1899e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1900a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1901b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f1902c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f1903d;

    public c() {
        this(false);
    }

    public c(boolean z) {
        this(z, false);
    }

    public c(boolean z, boolean z2) {
        this.f1900a = z;
        this.f1901b = z2;
        this.f1902c = new StringBuilder(20);
        this.f1903d = new int[9];
    }

    private static char a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f1899e;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
                }
                i2++;
            } else if (i == 148) {
                return '*';
            } else {
                throw i.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r1 >= r0) goto L_0x0044;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r3 <= 0) goto L_0x0044;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        r2 = r10[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (r2 <= r5) goto L_0x0041;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
        if ((r2 << 1) < r6) goto L_0x0041;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int[] r10) {
        /*
            int r0 = r10.length
            r1 = 0
            r2 = 0
        L_0x0003:
            r3 = 2147483647(0x7fffffff, float:NaN)
            int r4 = r10.length
            r3 = 0
            r5 = 2147483647(0x7fffffff, float:NaN)
        L_0x000b:
            if (r3 >= r4) goto L_0x0017
            r6 = r10[r3]
            if (r6 >= r5) goto L_0x0014
            if (r6 <= r2) goto L_0x0014
            r5 = r6
        L_0x0014:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0017:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
        L_0x001b:
            if (r2 >= r0) goto L_0x002e
            r7 = r10[r2]
            if (r7 <= r5) goto L_0x002b
            int r8 = r0 + (-1)
            int r8 = r8 - r2
            r9 = 1
            int r8 = r9 << r8
            r4 = r4 | r8
            int r3 = r3 + 1
            int r6 = r6 + r7
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x002e:
            r2 = 3
            r7 = -1
            if (r3 != r2) goto L_0x0045
        L_0x0032:
            if (r1 >= r0) goto L_0x0044
            if (r3 <= 0) goto L_0x0044
            r2 = r10[r1]
            if (r2 <= r5) goto L_0x0041
            int r3 = r3 + (-1)
            int r2 = r2 << 1
            if (r2 < r6) goto L_0x0041
            return r7
        L_0x0041:
            int r1 = r1 + 1
            goto L_0x0032
        L_0x0044:
            return r4
        L_0x0045:
            if (r3 > r2) goto L_0x0048
            return r7
        L_0x0048:
            r2 = r5
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.c.a(int[]):int");
    }

    private static String a(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i2++;
                char charAt2 = charSequence.charAt(i2);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i = charAt2 - ' ';
                                } else if (charAt2 == 'Z') {
                                    charAt = ':';
                                } else {
                                    throw f.a();
                                }
                            }
                            charAt = 0;
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw f.a();
                        } else {
                            i = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i = charAt2 + 16;
                    } else if (charAt2 < 'P' || charAt2 > 'T') {
                        if (charAt2 != 'U') {
                            if (charAt2 == 'V') {
                                charAt = '@';
                            } else if (charAt2 == 'W') {
                                charAt = '`';
                            } else if (charAt2 == 'X' || charAt2 == 'Y' || charAt2 == 'Z') {
                                charAt = 127;
                            } else {
                                throw f.a();
                            }
                        }
                        charAt = 0;
                    } else {
                        i = charAt2 + '+';
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw f.a();
                } else {
                    i = charAt2 - '@';
                }
                charAt = (char) i;
            }
            sb.append(charAt);
            i2++;
        }
        return sb.toString();
    }

    private static int[] a(a aVar, int[] iArr) {
        int c2 = aVar.c();
        int b2 = aVar.b(0);
        int length = iArr.length;
        int i = b2;
        boolean z = false;
        int i2 = 0;
        while (b2 < c2) {
            if (aVar.a(b2) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (a(iArr) == 148 && aVar.a(Math.max(0, i - ((b2 - i) / 2)), i, false)) {
                    return new int[]{i, b2};
                } else {
                    i += iArr[0] + iArr[1];
                    int i3 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i2] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
            b2++;
        }
        throw i.a();
    }

    @Override // b.c.b.v.k
    public m a(int i, a aVar, Map<e, ?> map) {
        int[] a2;
        int[] iArr = this.f1903d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f1902c;
        sb.setLength(0);
        int b2 = aVar.b(a(aVar, iArr)[1]);
        int c2 = aVar.c();
        while (true) {
            k.a(aVar, b2, iArr);
            int a3 = a(iArr);
            if (a3 >= 0) {
                char a4 = a(a3);
                sb.append(a4);
                int i2 = b2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int b3 = aVar.b(i2);
                if (a4 == '*') {
                    sb.setLength(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    int i6 = (b3 - b2) - i4;
                    if (b3 == c2 || (i6 << 1) >= i4) {
                        if (this.f1900a) {
                            int length = sb.length() - 1;
                            int i7 = 0;
                            for (int i8 = 0; i8 < length; i8++) {
                                i7 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f1902c.charAt(i8));
                            }
                            if (sb.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i7 % 43)) {
                                sb.setLength(length);
                            } else {
                                throw d.a();
                            }
                        }
                        if (sb.length() != 0) {
                            float f = i;
                            return new m(this.f1901b ? a(sb) : sb.toString(), null, new o[]{new o((a2[1] + a2[0]) / 2.0f, f), new o(b2 + (i4 / 2.0f), f)}, b.c.b.a.CODE_39);
                        }
                        throw i.a();
                    }
                    throw i.a();
                }
                b2 = b3;
            } else {
                throw i.a();
            }
        }
    }
}
