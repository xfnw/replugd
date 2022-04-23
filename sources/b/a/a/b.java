package b.a.a;

import java.io.PrintStream;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f1601a;

    /* renamed from: b  reason: collision with root package name */
    private int f1602b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f1603c;

    /* renamed from: d  reason: collision with root package name */
    private int f1604d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f1605e;

    protected b() {
    }

    private int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i + i3;
            if (bArr.length <= i5) {
                return i2;
            }
            if (bArr[i5] < 128) {
                i3++;
            }
            if (bArr[i5] < 194) {
                return i2;
            }
            if (bArr[i5] < 224) {
                if ((bArr[i5 + 1] & 192) != 128) {
                    return i2;
                }
                i3 += 2;
            } else if (bArr[i5] < 240) {
                if (!((bArr[i5 + 1] & 192) == 128 && (bArr[i5 + 2] & 192) == 128)) {
                    return i2;
                }
                i3 += 3;
            } else if (bArr[i5] >= 245) {
                continue;
            } else if ((bArr[i5 + 1] & 192) != 128 || (bArr[i5 + 2] & 192) != 128 || (bArr[i5 + 3] & 192) != 128) {
                return i2;
            } else {
                i3 += 4;
            }
        }
        return i3;
    }

    private i a(int i) {
        int i2 = this.f1605e[i];
        byte[] bArr = this.f1603c;
        byte b2 = bArr[i2];
        int i3 = (b2 & 240) >> 4;
        int i4 = b2 & 15;
        int i5 = 0;
        switch (i3) {
            case 0:
                if (i4 == 0) {
                    return null;
                }
                if (i4 == 8) {
                    return new h(false);
                }
                if (i4 == 9) {
                    return new h(true);
                }
                switch (i4) {
                    case 12:
                        throw new UnsupportedOperationException("The given binary property list contains a URL object. Parsing of this object type is not yet implemented.");
                    case 13:
                        throw new UnsupportedOperationException("The given binary property list contains a URL object. Parsing of this object type is not yet implemented.");
                    case 14:
                        throw new UnsupportedOperationException("The given binary property list contains a UUID object. Parsing of this object type is not yet implemented.");
                    default:
                        throw new l("The given binary property list contains an object of unknown type (" + i3 + ")");
                }
            case 1:
                int i6 = i2 + 1;
                return new h(this.f1603c, i6, ((int) Math.pow(2.0d, i4)) + i6, 0);
            case 2:
                int i7 = i2 + 1;
                return new h(this.f1603c, i7, ((int) Math.pow(2.0d, i4)) + i7, 1);
            case 3:
                if (i4 == 3) {
                    return new f(bArr, i2 + 1, i2 + 9);
                }
                throw new l("The given binary property list contains a date object of an unknown type (" + i4 + ")");
            case 4:
                int[] a2 = a(i4, i2);
                int i8 = a2[0];
                int i9 = i2 + a2[1];
                return new e(b(this.f1603c, i9, i8 + i9));
            case 5:
                int[] a3 = a(i4, i2);
                int i10 = a3[0];
                int i11 = i2 + a3[1];
                return new k(this.f1603c, i11, i10 + i11, "ASCII");
            case 6:
                int[] a4 = a(i4, i2);
                int i12 = a4[0];
                int i13 = i2 + a4[1];
                return new k(this.f1603c, i13, (i12 * 2) + i13, "UTF-16BE");
            case 7:
                int[] a5 = a(i4, i2);
                int i14 = a5[1];
                int i15 = i2 + i14;
                return new k(this.f1603c, i15, a(this.f1603c, i15, a5[0]) + i15, "UTF-8");
            case 8:
                int i16 = i2 + 1;
                return new m(String.valueOf(i), b(this.f1603c, i16, i4 + 1 + i16));
            case 9:
            default:
                throw new l("The given binary property list contains an object of unknown type (" + i3 + ")");
            case 10:
                int[] a6 = a(i4, i2);
                int i17 = a6[0];
                int i18 = a6[1];
                d dVar = new d(i17);
                while (i5 < i17) {
                    byte[] bArr2 = this.f1603c;
                    int i19 = i2 + i18;
                    int i20 = this.f1604d;
                    int i21 = i5 + 1;
                    dVar.a(i5, a((int) e(bArr2, (i5 * i20) + i19, i19 + (i20 * i21))));
                    i5 = i21;
                }
                return dVar;
            case 11:
                int[] a7 = a(i4, i2);
                int i22 = a7[0];
                int i23 = a7[1];
                j jVar = new j(true);
                while (i5 < i22) {
                    byte[] bArr3 = this.f1603c;
                    int i24 = i2 + i23;
                    int i25 = this.f1604d;
                    i5++;
                    jVar.a(a((int) e(bArr3, (i5 * i25) + i24, i24 + (i25 * i5))));
                }
                return jVar;
            case 12:
                int[] a8 = a(i4, i2);
                int i26 = a8[0];
                int i27 = a8[1];
                j jVar2 = new j();
                while (i5 < i26) {
                    byte[] bArr4 = this.f1603c;
                    int i28 = i2 + i27;
                    int i29 = this.f1604d;
                    i5++;
                    jVar2.a(a((int) e(bArr4, (i5 * i29) + i28, i28 + (i29 * i5))));
                }
                return jVar2;
            case 13:
                int[] a9 = a(i4, i2);
                int i30 = a9[0];
                int i31 = a9[1];
                g gVar = new g();
                while (i5 < i30) {
                    byte[] bArr5 = this.f1603c;
                    int i32 = i2 + i31;
                    int i33 = this.f1604d;
                    int i34 = i5 + 1;
                    int e2 = (int) e(bArr5, (i5 * i33) + i32, (i33 * i34) + i32);
                    byte[] bArr6 = this.f1603c;
                    int i35 = this.f1604d;
                    i a10 = a(e2);
                    gVar.put(a10.toString(), a((int) e(bArr6, (i30 * i35) + i32 + (i5 * i35), i32 + (i30 * i35) + (i35 * i34))));
                    i5 = i34;
                }
                return gVar;
        }
    }

    private i a(byte[] bArr) {
        this.f1603c = bArr;
        int i = 0;
        String str = new String(b(this.f1603c, 0, 8));
        if (str.startsWith("bplist")) {
            this.f1601a = str.charAt(6) - '0';
            this.f1602b = str.charAt(7) - '0';
            if (this.f1601a <= 0) {
                byte[] bArr2 = this.f1603c;
                byte[] b2 = b(bArr2, bArr2.length - 32, bArr2.length);
                int e2 = (int) e(b2, 6, 7);
                this.f1604d = (int) e(b2, 7, 8);
                int e3 = (int) e(b2, 8, 16);
                int e4 = (int) e(b2, 16, 24);
                int e5 = (int) e(b2, 24, 32);
                this.f1605e = new int[e3];
                while (i < e3) {
                    int i2 = i + 1;
                    this.f1605e[i] = (int) e(this.f1603c, (i * e2) + e5, (i2 * e2) + e5);
                    i = i2;
                }
                return a(e4);
            }
            throw new IllegalArgumentException("Unsupported binary property list format: v" + this.f1601a + "." + this.f1602b + ". Version 1.0 and later are not yet supported.");
        }
        throw new IllegalArgumentException("The given data is no binary property list. Wrong magic bytes: " + str);
    }

    private int[] a(int i, int i2) {
        int i3;
        if (i == 15) {
            byte b2 = this.f1603c[i2 + 1];
            int i4 = (b2 & 240) >> 4;
            if (i4 != 1) {
                PrintStream printStream = System.err;
                printStream.println("BinaryPropertyListParser: Length integer has an unexpected type" + i4 + ". Attempting to parse anyway...");
            }
            int pow = (int) Math.pow(2.0d, b2 & 15);
            i3 = pow + 2;
            if (pow < 3) {
                int i5 = i2 + 2;
                i = (int) e(this.f1603c, i5, pow + i5);
            } else {
                int i6 = i2 + 2;
                i = new BigInteger(b(this.f1603c, i6, pow + i6)).intValue();
            }
        } else {
            i3 = 1;
        }
        return new int[]{i, i3};
    }

    public static i b(byte[] bArr) {
        return new b().a(bArr);
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i, bArr2, 0, i3);
            return bArr2;
        }
        throw new IllegalArgumentException("startIndex (" + i + ") > endIndex (" + i2 + ")");
    }

    public static double c(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 8) {
            return Double.longBitsToDouble(d(bArr, i, i2));
        }
        if (i3 == 4) {
            return Float.intBitsToFloat((int) d(bArr, i, i2));
        }
        throw new IllegalArgumentException("endIndex (" + i2 + ") - startIndex (" + i + ") != 4 or 8");
    }

    public static long d(byte[] bArr, int i, int i2) {
        long j = 0;
        while (i < i2) {
            j = (j << 8) | (bArr[i] & 255);
            i++;
        }
        return j;
    }

    public static long e(byte[] bArr, int i, int i2) {
        long j = 0;
        while (i < i2) {
            j = (j << 8) | (bArr[i] & 255);
            i++;
        }
        return 4294967295L & j;
    }
}
