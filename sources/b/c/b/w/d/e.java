package b.c.b.w.d;

import b.c.b.f;
import b.c.b.w.c;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1996a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f1997b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger[] f1998c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1999a = new int[b.values().length];

        static {
            try {
                f1999a[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1999a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1999a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1999a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1999a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1999a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f1998c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        f1998c[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f1998c;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.d.e.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    static int a(int[] iArr, int i, c cVar) {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            cVar.c(Integer.parseInt(a(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int b2 = b(iArr, i2, sb);
            cVar.b(sb.toString());
            int i4 = iArr[b2] == 923 ? b2 + 1 : -1;
            while (b2 < iArr[0]) {
                int i5 = iArr[b2];
                if (i5 == 922) {
                    b2++;
                    cVar.a(true);
                } else if (i5 == 923) {
                    int i6 = b2 + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            b2 = b(iArr, i6 + 1, sb2);
                            cVar.c(sb2.toString());
                            continue;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            b2 = a(iArr, i6 + 1, sb3);
                            cVar.b(Integer.parseInt(sb3.toString()));
                            continue;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            b2 = a(iArr, i6 + 1, sb4);
                            cVar.b(Long.parseLong(sb4.toString()));
                            continue;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            b2 = b(iArr, i6 + 1, sb5);
                            cVar.d(sb5.toString());
                            continue;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            b2 = b(iArr, i6 + 1, sb6);
                            cVar.a(sb6.toString());
                            continue;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            b2 = a(iArr, i6 + 1, sb7);
                            cVar.a(Long.parseLong(sb7.toString()));
                            continue;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            b2 = a(iArr, i6 + 1, sb8);
                            cVar.a(Integer.parseInt(sb8.toString()));
                            continue;
                        default:
                            throw f.a();
                    }
                } else {
                    throw f.a();
                }
            }
            if (i4 != -1) {
                int i7 = b2 - i4;
                if (cVar.a()) {
                    i7--;
                }
                cVar.a(Arrays.copyOfRange(iArr, i4, i7 + i4));
            }
            return b2;
        }
        throw f.a();
    }

    private static int a(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            i++;
            int i3 = iArr[i];
            if (i == iArr[0]) {
                z = true;
            }
            if (i3 < 900) {
                iArr2[i2] = i3;
                i2++;
            } else {
                if (!(i3 == 900 || i3 == 901 || i3 == 928)) {
                    switch (i3) {
                    }
                }
                i--;
                z = true;
            }
            if ((i2 % 15 == 0 || i3 == 902 || z) && i2 > 0) {
                sb.append(a(iArr2, i2));
                i2 = 0;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static b.c.b.r.e a(int[] r6, java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            b.c.b.w.c r3 = new b.c.b.w.c
            r3.<init>()
            r4 = 2
        L_0x0012:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L_0x0068
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L_0x0053
            switch(r2) {
                case 900: goto L_0x0023;
                case 901: goto L_0x004e;
                case 902: goto L_0x0049;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r2) {
                case 922: goto L_0x0044;
                case 923: goto L_0x0044;
                case 924: goto L_0x004e;
                case 925: goto L_0x0041;
                case 926: goto L_0x003e;
                case 927: goto L_0x002d;
                case 928: goto L_0x0028;
                default: goto L_0x0021;
            }
        L_0x0021:
            int r4 = r4 + (-1)
        L_0x0023:
            int r2 = b(r6, r4, r0)
            goto L_0x005b
        L_0x0028:
            int r2 = a(r6, r4, r3)
            goto L_0x005b
        L_0x002d:
            int r2 = r4 + 1
            r1 = r6[r4]
            b.c.b.r.d r1 = b.c.b.r.d.a(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L_0x005b
        L_0x003e:
            int r2 = r4 + 2
            goto L_0x005b
        L_0x0041:
            int r2 = r4 + 1
            goto L_0x005b
        L_0x0044:
            b.c.b.f r6 = b.c.b.f.a()
            throw r6
        L_0x0049:
            int r2 = a(r6, r4, r0)
            goto L_0x005b
        L_0x004e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L_0x005b
        L_0x0053:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L_0x005b:
            int r4 = r6.length
            if (r2 >= r4) goto L_0x0063
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L_0x0012
        L_0x0063:
            b.c.b.f r6 = b.c.b.f.a()
            throw r6
        L_0x0068:
            int r6 = r0.length()
            if (r6 == 0) goto L_0x007c
            b.c.b.r.e r6 = new b.c.b.r.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.a(r3)
            return r6
        L_0x007c:
            b.c.b.f r6 = b.c.b.f.a()
            goto L_0x0082
        L_0x0081:
            throw r6
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.d.e.a(int[], java.lang.String):b.c.b.r.e");
    }

    private static String a(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(f1998c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw f.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r4 != 900) goto L_0x0035;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4 A[PHI: r2 
      PHI: (r2v4 b.c.b.w.d.e$b) = (r2v1 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v12 b.c.b.w.d.e$b) binds: [B:46:0x0093, B:38:0x007f, B:30:0x0069, B:18:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ad A[PHI: r2 
      PHI: (r2v3 b.c.b.w.d.e$b) = (r2v1 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v5 b.c.b.w.d.e$b), (r2v6 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v8 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v9 b.c.b.w.d.e$b), (r2v1 b.c.b.w.d.e$b), (r2v14 b.c.b.w.d.e$b) binds: [B:5:0x001c, B:53:0x00a9, B:50:0x00a1, B:49:0x009e, B:46:0x0093, B:38:0x007f, B:31:0x006d, B:30:0x0069, B:32:0x0070, B:23:0x0055, B:12:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.d.e.a(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int b(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != 913) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            i2++;
                            iArr2[i2] = 900;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i4) {
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        a(iArr2, iArr3, i2, sb);
        return i;
    }
}
