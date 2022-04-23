package b.c.b.v;

import b.c.b.d;
import b.c.b.e;
import b.c.b.f;
import b.c.b.i;
import b.c.b.l;
import b.c.b.m;
import b.c.b.n;
import b.c.b.o;
import b.c.b.r.a;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class p extends k {

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1926d = {1, 1, 1};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1927e = {1, 1, 1, 1, 1};
    static final int[][] f = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] g = new int[20];

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f1928a = new StringBuilder(20);

    /* renamed from: b  reason: collision with root package name */
    private final o f1929b = new o();

    /* renamed from: c  reason: collision with root package name */
    private final g f1930c = new g();

    static {
        System.arraycopy(f, 0, g, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            g[i] = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(a aVar, int[] iArr, int i, int[][] iArr2) {
        k.a(aVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = k.a(iArr, iArr2[i3], 0.7f);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw i.a();
    }

    static boolean a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return b(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] a(a aVar) {
        int[] iArr = new int[f1926d.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f1926d.length, 0);
            iArr2 = a(aVar, i, false, f1926d, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = aVar.a(i4, i2, false);
            }
            i = i3;
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] a(a aVar, int i, boolean z, int[] iArr) {
        return a(aVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(a aVar, int i, boolean z, int[] iArr, int[] iArr2) {
        int c2 = aVar.c();
        int c3 = z ? aVar.c(i) : aVar.b(i);
        int length = iArr.length;
        int i2 = c3;
        int i3 = 0;
        while (c3 < c2) {
            if (aVar.a(c3) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (k.a(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i2, c3};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            c3++;
        }
        throw i.a();
    }

    static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw f.a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw f.a();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int a(a aVar, int[] iArr, StringBuilder sb);

    @Override // b.c.b.v.k
    public m a(int i, a aVar, Map<e, ?> map) {
        return a(i, aVar, a(aVar), map);
    }

    public m a(int i, a aVar, int[] iArr, Map<e, ?> map) {
        int i2;
        String a2;
        int[] iArr2 = null;
        b.c.b.p pVar = map == null ? null : (b.c.b.p) map.get(e.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (pVar != null) {
            pVar.a(new o((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f1928a;
        sb.setLength(0);
        int a3 = a(aVar, iArr, sb);
        if (pVar != null) {
            pVar.a(new o(a3, i));
        }
        int[] a4 = a(aVar, a3);
        if (pVar != null) {
            pVar.a(new o((a4[0] + a4[1]) / 2.0f, i));
        }
        int i3 = a4[1];
        int i4 = (i3 - a4[0]) + i3;
        if (i4 >= aVar.c() || !aVar.a(i3, i4, false)) {
            throw i.a();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw f.a();
        } else if (a(sb2)) {
            b.c.b.a b2 = b();
            float f2 = i;
            m mVar = new m(sb2, null, new o[]{new o((iArr[1] + iArr[0]) / 2.0f, f2), new o((a4[1] + a4[0]) / 2.0f, f2)}, b2);
            try {
                m a5 = this.f1929b.a(i, aVar, a4[1]);
                mVar.a(n.UPC_EAN_EXTENSION, a5.e());
                mVar.a(a5.c());
                mVar.a(a5.d());
                i2 = a5.e().length();
            } catch (l unused) {
                i2 = 0;
            }
            if (map != null) {
                iArr2 = (int[]) map.get(e.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (i2 == iArr2[i5]) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    throw i.a();
                }
            }
            if ((b2 == b.c.b.a.EAN_13 || b2 == b.c.b.a.UPC_A) && (a2 = this.f1930c.a(sb2)) != null) {
                mVar.a(n.POSSIBLE_COUNTRY, a2);
            }
            return mVar;
        } else {
            throw d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return a((CharSequence) str);
    }

    int[] a(a aVar, int i) {
        return a(aVar, i, false, f1926d);
    }

    abstract b.c.b.a b();
}
