package b.c.b.q.c;

import b.c.b.f;
import b.c.b.r.n.c;
import b.c.b.r.n.d;
import com.king.zxing.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f1793b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f1794c = {"CTRL_PS", " ", "a", "b", "c", "d", e.z, "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f1795d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f1796e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a  reason: collision with root package name */
    private b.c.b.q.a f1797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.c.b.q.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0056a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1798a = new int[b.values().length];

        static {
            try {
                f1798a[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1798a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1798a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1798a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1798a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static byte a(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? a(zArr, i, 8) : a(zArr, i, length) << (8 - length));
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static b a(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? b.UPPER : b.MIXED : b.LOWER : b.PUNCT : b.DIGIT : b.BINARY;
    }

    private static String a(b bVar, int i) {
        int i2 = C0056a.f1798a[bVar.ordinal()];
        if (i2 == 1) {
            return f1793b[i];
        }
        if (i2 == 2) {
            return f1794c[i];
        }
        if (i2 == 3) {
            return f1795d[i];
        }
        if (i2 == 4) {
            return f1796e[i];
        }
        if (i2 == 5) {
            return f[i];
        }
        throw new IllegalStateException("Bad table");
    }

    static byte[] a(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = a(zArr, i << 3);
        }
        return bArr;
    }

    private boolean[] a(b.c.b.r.b bVar) {
        boolean e2 = this.f1797a.e();
        int d2 = this.f1797a.d();
        int i = (e2 ? 11 : 14) + (d2 << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[a(d2, e2)];
        int i2 = 2;
        if (e2) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < d2) {
            int i10 = ((d2 - i8) << i2) + (e2 ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = bVar.b(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = bVar.b(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = bVar.b(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = bVar.b(iArr[i19], iArr[i16]);
                    i15++;
                    d2 = d2;
                    e2 = e2;
                    i2 = 2;
                }
                i13++;
                i2 = 2;
            }
            i9 += i10 << 3;
            i8++;
            i2 = 2;
        }
        return zArr;
    }

    private boolean[] b(boolean[] zArr) {
        b.c.b.r.n.a aVar;
        int i = 8;
        if (this.f1797a.d() <= 2) {
            i = 6;
            aVar = b.c.b.r.n.a.j;
        } else if (this.f1797a.d() <= 8) {
            aVar = b.c.b.r.n.a.n;
        } else if (this.f1797a.d() <= 22) {
            i = 10;
            aVar = b.c.b.r.n.a.i;
        } else {
            i = 12;
            aVar = b.c.b.r.n.a.h;
        }
        int c2 = this.f1797a.c();
        int length = zArr.length / i;
        if (length >= c2) {
            int length2 = zArr.length % i;
            int[] iArr = new int[length];
            int i2 = 0;
            while (i2 < length) {
                iArr[i2] = a(zArr, length2, i);
                i2++;
                length2 += i;
            }
            try {
                new c(aVar).a(iArr, length - c2);
                int i3 = (1 << i) - 1;
                int i4 = 0;
                for (int i5 = 0; i5 < c2; i5++) {
                    int i6 = iArr[i5];
                    if (i6 == 0 || i6 == i3) {
                        throw f.a();
                    }
                    if (i6 == 1 || i6 == i3 - 1) {
                        i4++;
                    }
                }
                boolean[] zArr2 = new boolean[(c2 * i) - i4];
                int i7 = 0;
                for (int i8 = 0; i8 < c2; i8++) {
                    int i9 = iArr[i8];
                    if (i9 == 1 || i9 == i3 - 1) {
                        Arrays.fill(zArr2, i7, (i7 + i) - 1, i9 > 1);
                        i7 += i - 1;
                    } else {
                        for (int i10 = i - 1; i10 >= 0; i10--) {
                            i7++;
                            zArr2[i7] = ((1 << i10) & i9) != 0;
                        }
                    }
                }
                return zArr2;
            } catch (d e2) {
                throw f.a(e2);
            }
        } else {
            throw f.a();
        }
    }

    private static String c(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVar2 = bVar;
        int i = 0;
        while (i < length) {
            if (bVar == b.BINARY) {
                if (length - i < 5) {
                    break;
                }
                int a2 = a(zArr, i, 5);
                int i2 = i + 5;
                if (a2 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    a2 = a(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= a2) {
                        i = i2;
                        break;
                    } else if (length - i2 < 8) {
                        i = length;
                        break;
                    } else {
                        sb.append((char) a(zArr, i2, 8));
                        i2 += 8;
                        i3++;
                    }
                }
                bVar = bVar2;
            } else {
                int i4 = bVar == b.DIGIT ? 4 : 5;
                if (length - i < i4) {
                    break;
                }
                int a3 = a(zArr, i, i4);
                i += i4;
                String a4 = a(bVar, a3);
                if (a4.startsWith("CTRL_")) {
                    bVar2 = a(a4.charAt(5));
                    if (a4.charAt(6) != 'L') {
                        bVar2 = bVar;
                        bVar = bVar2;
                    }
                } else {
                    sb.append(a4);
                }
                bVar = bVar2;
            }
        }
        return sb.toString();
    }

    public b.c.b.r.e a(b.c.b.q.a aVar) {
        this.f1797a = aVar;
        boolean[] b2 = b(a(aVar.a()));
        b.c.b.r.e eVar = new b.c.b.r.e(a(b2), c(b2), null, null);
        eVar.a(b2.length);
        return eVar;
    }
}
