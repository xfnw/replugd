package b.c.b.v;

import b.c.b.e;
import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f1893d = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1894e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] f = {'A', 'B', 'C', 'D'};

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f1895a = new StringBuilder(20);

    /* renamed from: b  reason: collision with root package name */
    private int[] f1896b = new int[80];

    /* renamed from: c  reason: collision with root package name */
    private int f1897c = 0;

    private void a(int i) {
        int[] iArr = this.f1896b;
        int i2 = this.f1897c;
        iArr[i2] = i;
        this.f1897c = i2 + 1;
        int i3 = this.f1897c;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f1896b = iArr2;
        }
    }

    private void a(b.c.b.r.a aVar) {
        int i = 0;
        this.f1897c = 0;
        int c2 = aVar.c(0);
        int c3 = aVar.c();
        if (c2 < c3) {
            boolean z = true;
            while (c2 < c3) {
                if (aVar.a(c2) != z) {
                    i++;
                } else {
                    a(i);
                    z = !z;
                    i = 1;
                }
                c2++;
            }
            a(i);
            return;
        }
        throw i.a();
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int b() {
        for (int i = 1; i < this.f1897c; i += 2) {
            int b2 = b(i);
            if (b2 != -1 && a(f, f1893d[b2])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.f1896b[i3];
                }
                if (i == 1 || this.f1896b[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw i.a();
    }

    private int b(int i) {
        int i2 = i + 7;
        if (i2 >= this.f1897c) {
            return -1;
        }
        int[] iArr = this.f1896b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        i9 = (i3 + i10) / 2;
        int i13 = 128;
        int i14 = 0;
        for (int i15 = 0; i15 < 7; i15++) {
            if ((i15 & 1) == 0) {
            }
            i13 >>= 1;
            if (iArr[i + i15] > i9) {
                i14 |= i13;
            }
        }
        while (true) {
            int[] iArr2 = f1894e;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i14) {
                return i4;
            }
            i4++;
        }
    }

    private void c(int i) {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f1895a.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = f1894e[this.f1895a.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) << 1);
                iArr[i7] = iArr[i7] + this.f1896b[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((iArr[i8] / iArr2[i8]) + (iArr[i9] / iArr2[i9])) / 2.0f;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((iArr[i9] * 2.0f) + 1.5f) / iArr2[i9];
        }
        loop3: while (true) {
            int i10 = f1894e[this.f1895a.charAt(i2)];
            for (int i11 = 6; i11 >= 0; i11--) {
                int i12 = (i11 & 1) + ((i10 & 1) << 1);
                float f2 = this.f1896b[i + i11];
                if (f2 < fArr2[i12] || f2 > fArr[i12]) {
                    break loop3;
                }
                i10 >>= 1;
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw i.a();
    }

    @Override // b.c.b.v.k
    public m a(int i, b.c.b.r.a aVar, Map<e, ?> map) {
        Arrays.fill(this.f1896b, 0);
        a(aVar);
        int b2 = b();
        this.f1895a.setLength(0);
        int i2 = b2;
        do {
            int b3 = b(i2);
            if (b3 != -1) {
                this.f1895a.append((char) b3);
                i2 += 8;
                if (this.f1895a.length() > 1 && a(f, f1893d[b3])) {
                    break;
                }
            } else {
                throw i.a();
            }
        } while (i2 < this.f1897c);
        int i3 = i2 - 1;
        int i4 = this.f1896b[i3];
        int i5 = 0;
        for (int i6 = -8; i6 < -1; i6++) {
            i5 += this.f1896b[i2 + i6];
        }
        if (i2 >= this.f1897c || i4 >= i5 / 2) {
            c(b2);
            for (int i7 = 0; i7 < this.f1895a.length(); i7++) {
                StringBuilder sb = this.f1895a;
                sb.setCharAt(i7, f1893d[sb.charAt(i7)]);
            }
            if (a(f, this.f1895a.charAt(0))) {
                StringBuilder sb2 = this.f1895a;
                if (!a(f, sb2.charAt(sb2.length() - 1))) {
                    throw i.a();
                } else if (this.f1895a.length() > 3) {
                    if (map == null || !map.containsKey(e.RETURN_CODABAR_START_END)) {
                        StringBuilder sb3 = this.f1895a;
                        sb3.deleteCharAt(sb3.length() - 1);
                        this.f1895a.deleteCharAt(0);
                    }
                    int i8 = 0;
                    for (int i9 = 0; i9 < b2; i9++) {
                        i8 += this.f1896b[i9];
                    }
                    float f2 = i8;
                    while (b2 < i3) {
                        i8 += this.f1896b[b2];
                        b2++;
                    }
                    float f3 = i;
                    return new m(this.f1895a.toString(), null, new o[]{new o(f2, f3), new o(i8, f3)}, b.c.b.a.CODABAR);
                } else {
                    throw i.a();
                }
            } else {
                throw i.a();
            }
        } else {
            throw i.a();
        }
    }
}
