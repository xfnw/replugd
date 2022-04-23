package a.g.e;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f213a;

        /* renamed from: b  reason: collision with root package name */
        boolean f214b;

        a() {
        }
    }

    /* renamed from: a.g.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006b {

        /* renamed from: a  reason: collision with root package name */
        public char f215a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f216b;

        C0006b(char c2, float[] fArr) {
            this.f215a = c2;
            this.f216b = fArr;
        }

        C0006b(C0006b bVar) {
            this.f215a = bVar.f215a;
            float[] fArr = bVar.f216b;
            this.f216b = b.a(fArr, 0, fArr.length);
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = ceil;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d6;
            double d22 = d7;
            int i = 0;
            double d23 = d9;
            while (i < ceil) {
                double d24 = d23 + d20;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d26 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d27 = (d13 * sin3) - (d14 * cos3);
                double d28 = (sin3 * d16) + (cos3 * d17);
                double d29 = d24 - d23;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d21 + (d15 * sin4)), (float) (d22 + (d18 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                i++;
                d20 = d20;
                ceil = ceil;
                sin = sin;
                d22 = d26;
                d16 = d16;
                d23 = d24;
                d18 = d28;
                d15 = d27;
                cos = cos;
                d11 = d4;
                d21 = d25;
            }
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = f;
            Double.isNaN(d4);
            double d5 = d4 * cos;
            double d6 = f2;
            Double.isNaN(d6);
            double d7 = f5;
            Double.isNaN(d7);
            double d8 = (d5 + (d6 * sin)) / d7;
            double d9 = -f;
            Double.isNaN(d9);
            Double.isNaN(d6);
            double d10 = f6;
            Double.isNaN(d10);
            double d11 = ((d9 * sin) + (d6 * cos)) / d10;
            double d12 = f3;
            Double.isNaN(d12);
            double d13 = f4;
            Double.isNaN(d13);
            Double.isNaN(d7);
            double d14 = ((d12 * cos) + (d13 * sin)) / d7;
            double d15 = -f3;
            Double.isNaN(d15);
            Double.isNaN(d13);
            Double.isNaN(d10);
            double d16 = ((d15 * sin) + (d13 * cos)) / d10;
            double d17 = d8 - d14;
            double d18 = d11 - d16;
            double d19 = (d8 + d14) / 2.0d;
            double d20 = (d11 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d21);
                float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d22);
            double d23 = d17 * sqrt2;
            double d24 = sqrt2 * d18;
            if (z == z2) {
                d3 = d19 - d24;
                d2 = d20 + d23;
            } else {
                d3 = d19 + d24;
                d2 = d20 - d23;
            }
            double atan2 = Math.atan2(d11 - d2, d8 - d3);
            double atan22 = Math.atan2(d16 - d2, d14 - d3) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d7);
            double d25 = d3 * d7;
            Double.isNaN(d10);
            double d26 = d2 * d10;
            a(path, (d25 * cos) - (d26 * sin), (d25 * sin) + (d26 * cos), d7, d10, d4, d6, radians, atan2, atan22);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            char c4 = c3;
            float f7 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[2];
            float f10 = fArr[3];
            float f11 = fArr[4];
            float f12 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f11, f12);
                    f7 = f11;
                    f9 = f7;
                    f8 = f12;
                    f10 = f8;
                    i = 2;
                    break;
            }
            float f13 = f11;
            float f14 = f12;
            int i3 = 0;
            char c5 = c2;
            while (i3 < fArr2.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i4], fArr2[i5], fArr2[i6], fArr2[i7]);
                        f7 = fArr2[i6];
                        f8 = fArr2[i7];
                        f9 = fArr2[i4];
                        f10 = fArr2[i5];
                    } else if (c4 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path.lineTo(fArr2[i8], f8);
                        f7 = fArr2[i8];
                    } else if (c4 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path.quadTo(fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        f9 = fArr2[i9];
                        f10 = fArr2[i10];
                        f7 = fArr2[i11];
                        f8 = fArr2[i12];
                    } else if (c4 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path.lineTo(f7, fArr2[i13]);
                        f8 = fArr2[i13];
                    } else if (c4 != 'a') {
                        if (c4 != 'c') {
                            if (c4 == 'h') {
                                int i14 = i3 + 0;
                                path.rLineTo(fArr2[i14], 0.0f);
                                f7 += fArr2[i14];
                            } else if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i15 = i3 + 0;
                                    path.rLineTo(0.0f, fArr2[i15]);
                                    f2 = fArr2[i15];
                                } else if (c4 == 'L') {
                                    int i16 = i3 + 0;
                                    int i17 = i3 + 1;
                                    path.lineTo(fArr2[i16], fArr2[i17]);
                                    f7 = fArr2[i16];
                                    f8 = fArr2[i17];
                                } else if (c4 == 'M') {
                                    int i18 = i3 + 0;
                                    f7 = fArr2[i18];
                                    int i19 = i3 + 1;
                                    f8 = fArr2[i19];
                                    if (i3 > 0) {
                                        path.lineTo(fArr2[i18], fArr2[i19]);
                                    } else {
                                        path.moveTo(fArr2[i18], fArr2[i19]);
                                        f14 = f8;
                                        f13 = f7;
                                    }
                                } else if (c4 == 'S') {
                                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        f7 = (f7 * 2.0f) - f9;
                                        f8 = (f8 * 2.0f) - f10;
                                    }
                                    int i20 = i3 + 0;
                                    int i21 = i3 + 1;
                                    int i22 = i3 + 2;
                                    int i23 = i3 + 3;
                                    path.cubicTo(f7, f8, fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                                    f9 = fArr2[i20];
                                    f10 = fArr2[i21];
                                    f7 = fArr2[i22];
                                    f8 = fArr2[i23];
                                } else if (c4 == 'T') {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f7 = (f7 * 2.0f) - f9;
                                        f8 = (f8 * 2.0f) - f10;
                                    }
                                    int i24 = i3 + 0;
                                    int i25 = i3 + 1;
                                    path.quadTo(f7, f8, fArr2[i24], fArr2[i25]);
                                    f7 = fArr2[i24];
                                    f8 = fArr2[i25];
                                    f10 = f8;
                                    f9 = f7;
                                    i2 = i3;
                                } else if (c4 == 'l') {
                                    int i26 = i3 + 0;
                                    int i27 = i3 + 1;
                                    path.rLineTo(fArr2[i26], fArr2[i27]);
                                    f7 += fArr2[i26];
                                    f2 = fArr2[i27];
                                } else if (c4 == 'm') {
                                    int i28 = i3 + 0;
                                    f7 += fArr2[i28];
                                    int i29 = i3 + 1;
                                    f8 += fArr2[i29];
                                    if (i3 > 0) {
                                        path.rLineTo(fArr2[i28], fArr2[i29]);
                                    } else {
                                        path.rMoveTo(fArr2[i28], fArr2[i29]);
                                        f14 = f8;
                                        f13 = f7;
                                    }
                                } else if (c4 == 's') {
                                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        f4 = f7 - f9;
                                        f3 = f8 - f10;
                                    } else {
                                        f4 = 0.0f;
                                        f3 = 0.0f;
                                    }
                                    int i30 = i3 + 0;
                                    int i31 = i3 + 1;
                                    int i32 = i3 + 2;
                                    int i33 = i3 + 3;
                                    path.rCubicTo(f4, f3, fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                    f9 = fArr2[i30] + f7;
                                    f10 = fArr2[i31] + f8;
                                    f7 += fArr2[i32];
                                    f = fArr2[i33];
                                } else if (c4 == 't') {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f5 = f7 - f9;
                                        f6 = f8 - f10;
                                    } else {
                                        f6 = 0.0f;
                                        f5 = 0.0f;
                                    }
                                    int i34 = i3 + 0;
                                    int i35 = i3 + 1;
                                    path.rQuadTo(f5, f6, fArr2[i34], fArr2[i35]);
                                    f9 = f5 + f7;
                                    f10 = f6 + f8;
                                    f7 += fArr2[i34];
                                    f8 += fArr2[i35];
                                }
                                f8 += f2;
                            } else {
                                int i36 = i3 + 0;
                                int i37 = i3 + 1;
                                int i38 = i3 + 2;
                                int i39 = i3 + 3;
                                path.rQuadTo(fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                                f9 = fArr2[i36] + f7;
                                f10 = fArr2[i37] + f8;
                                f7 += fArr2[i38];
                                f = fArr2[i39];
                            }
                            i2 = i3;
                        } else {
                            int i40 = i3 + 2;
                            int i41 = i3 + 3;
                            int i42 = i3 + 4;
                            int i43 = i3 + 5;
                            path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                            f9 = fArr2[i40] + f7;
                            f10 = fArr2[i41] + f8;
                            f7 += fArr2[i42];
                            f = fArr2[i43];
                        }
                        f8 += f;
                        i2 = i3;
                    } else {
                        int i44 = i3 + 5;
                        int i45 = i3 + 6;
                        i2 = i3;
                        a(path, f7, f8, fArr2[i44] + f7, fArr2[i45] + f8, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f7 += fArr2[i44];
                        f8 += fArr2[i45];
                    }
                    i3 = i2 + i;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i2 = i3;
                    int i46 = i2 + 5;
                    int i47 = i2 + 6;
                    a(path, f7, f8, fArr2[i46], fArr2[i47], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f7 = fArr2[i46];
                    f8 = fArr2[i47];
                }
                f10 = f8;
                f9 = f7;
                i3 = i2 + i;
                c5 = c3;
                c4 = c5;
            }
            fArr[0] = f7;
            fArr[1] = f8;
            fArr[2] = f9;
            fArr[3] = f10;
            fArr[4] = f13;
            fArr[5] = f14;
        }

        public static void a(C0006b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                a(path, fArr, c2, bVarArr[i].f215a, bVarArr[i].f216b);
                c2 = bVarArr[i].f215a;
            }
        }

        public void a(C0006b bVar, C0006b bVar2, float f) {
            int i = 0;
            while (true) {
                float[] fArr = bVar.f216b;
                if (i < fArr.length) {
                    this.f216b[i] = (fArr[i] * (1.0f - f)) + (bVar2.f216b[i] * f);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r2 == false) goto L_0x0027;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038 A[LOOP:0: B:3:0x0007->B:21:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r8, int r9, a.g.e.b.a r10) {
        /*
            r0 = 0
            r10.f214b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003b
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0033
            r6 = 69
            if (r5 == r6) goto L_0x0031
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0031
            switch(r5) {
                case 44: goto L_0x0033;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x002f
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0035
        L_0x0027:
            r10.f214b = r7
            goto L_0x0033
        L_0x002a:
            if (r1 == r9) goto L_0x002f
            if (r2 != 0) goto L_0x002f
            goto L_0x0027
        L_0x002f:
            r2 = 0
            goto L_0x0035
        L_0x0031:
            r2 = 1
            goto L_0x0035
        L_0x0033:
            r2 = 0
            r4 = 1
        L_0x0035:
            if (r4 == 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003b:
            r10.f213a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.e.b.a(java.lang.String, int, a.g.e.b$a):void");
    }

    private static void a(ArrayList<C0006b> arrayList, char c2, float[] fArr) {
        arrayList.add(new C0006b(c2, fArr));
    }

    public static boolean a(C0006b[] bVarArr, C0006b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i = 0; i < bVarArr.length; i++) {
            if (!(bVarArr[i].f215a == bVarArr2[i].f215a && bVarArr[i].f216b.length == bVarArr2[i].f216b.length)) {
                return false;
            }
        }
        return true;
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static C0006b[] a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a2 = a(str, i);
            String trim = str.substring(i2, a2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i = a2 + 1;
            i2 = a2;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0006b[]) arrayList.toArray(new C0006b[arrayList.size()]);
    }

    public static C0006b[] a(C0006b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        C0006b[] bVarArr2 = new C0006b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new C0006b(bVarArr[i]);
        }
        return bVarArr2;
    }

    public static Path b(String str) {
        Path path = new Path();
        C0006b[] a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            C0006b.a(a2, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    public static void b(C0006b[] bVarArr, C0006b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].f215a = bVarArr2[i].f215a;
            for (int i2 = 0; i2 < bVarArr2[i].f216b.length; i2++) {
                bVarArr[i].f216b[i2] = bVarArr2[i].f216b[i2];
            }
        }
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                a(str, i, aVar);
                int i3 = aVar.f213a;
                if (i < i3) {
                    i2++;
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                }
                i = aVar.f214b ? i3 : i3 + 1;
            }
            return a(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }
}
