package b.c.b.v;

import b.c.b.e;
import b.c.b.f;
import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import b.c.b.r.a;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends k {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f1904c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1905d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f1906e;

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f1907a = new StringBuilder(20);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1908b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f1905d = iArr;
        f1906e = iArr[47];
    }

    private static char a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f1905d;
            if (i2 >= iArr.length) {
                throw i.a();
            } else if (iArr[i2] == i) {
                return f1904c[i2];
            } else {
                i2++;
            }
        }
    }

    private static int a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((iArr[i4] * 9.0f) / i);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    private static void a(CharSequence charSequence) {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != f1904c[i3 % 47]) {
            throw b.c.b.d.a();
        }
    }

    private int[] a(a aVar) {
        int c2 = aVar.c();
        int b2 = aVar.b(0);
        Arrays.fill(this.f1908b, 0);
        int[] iArr = this.f1908b;
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
                } else if (a(iArr) == f1906e) {
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

    private static String b(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'a' && charAt <= 'd') {
                if (i2 < length - 1) {
                    i2++;
                    char charAt2 = charSequence.charAt(i2);
                    switch (charAt) {
                        case 'a':
                            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                i = charAt2 - '@';
                                charAt = (char) i;
                                break;
                            } else {
                                throw f.a();
                            }
                            break;
                        case 'b':
                            if (charAt2 >= 'A' && charAt2 <= 'E') {
                                i = charAt2 - '&';
                            } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                                i = charAt2 - 11;
                            } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                                i = charAt2 + 16;
                            } else if (charAt2 < 'P' || charAt2 > 'S') {
                                if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                    charAt = 127;
                                    break;
                                } else {
                                    throw f.a();
                                }
                            } else {
                                i = charAt2 + '+';
                            }
                            charAt = (char) i;
                            break;
                        case 'c':
                            if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i = charAt2 - ' ';
                                charAt = (char) i;
                                break;
                            } else if (charAt2 == 'Z') {
                                charAt = ':';
                                break;
                            } else {
                                throw f.a();
                            }
                        case 'd':
                            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                i = charAt2 + ' ';
                                charAt = (char) i;
                                break;
                            } else {
                                throw f.a();
                            }
                        default:
                            charAt = 0;
                            break;
                    }
                } else {
                    throw f.a();
                }
            }
            sb.append(charAt);
            i2++;
        }
        return sb.toString();
    }

    @Override // b.c.b.v.k
    public m a(int i, a aVar, Map<e, ?> map) {
        int[] a2;
        int b2 = aVar.b(a(aVar)[1]);
        int c2 = aVar.c();
        int[] iArr = this.f1908b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f1907a;
        sb.setLength(0);
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
                    sb.deleteCharAt(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    if (b3 == c2 || !aVar.a(b3)) {
                        throw i.a();
                    } else if (sb.length() >= 2) {
                        a(sb);
                        sb.setLength(sb.length() - 2);
                        float f = i;
                        return new m(b(sb), null, new o[]{new o((a2[1] + a2[0]) / 2.0f, f), new o(b2 + (i4 / 2.0f), f)}, b.c.b.a.CODE_93);
                    } else {
                        throw i.a();
                    }
                } else {
                    b2 = b3;
                }
            } else {
                throw i.a();
            }
        }
    }
}
