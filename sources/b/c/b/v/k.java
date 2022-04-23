package b.c.b.v;

import b.c.b.c;
import b.c.b.e;
import b.c.b.i;
import b.c.b.l;
import b.c.b.m;
import b.c.b.n;
import b.c.b.o;
import b.c.b.r.a;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class k implements b.c.b.k {
    /* JADX INFO: Access modifiers changed from: protected */
    public static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int c2 = aVar.c();
        if (i < c2) {
            boolean z = !aVar.a(i);
            while (i < c2) {
                if (aVar.a(i) == z) {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                } else {
                    iArr[i2] = iArr[i2] + 1;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != c2) {
                throw i.a();
            }
            return;
        }
        throw i.a();
    }

    private m b(c cVar, Map<e, ?> map) {
        int c2 = cVar.c();
        int b2 = cVar.b();
        a aVar = new a(c2);
        char c3 = 0;
        int i = 1;
        boolean z = map != null && map.containsKey(e.TRY_HARDER);
        int max = Math.max(1, b2 >> (z ? 8 : 5));
        int i2 = z ? b2 : 15;
        int i3 = b2 / 2;
        Map<e, ?> map2 = map;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i4 + 1;
            int i6 = i5 / 2;
            if (!((i4 & 1) == 0)) {
                i6 = -i6;
            }
            int i7 = (i6 * max) + i3;
            if (i7 < 0 || i7 >= b2) {
                break;
            }
            try {
                aVar = cVar.a(i7, aVar);
                EnumMap enumMap = map2;
                int i8 = 0;
                while (i8 < 2) {
                    if (i8 == i) {
                        aVar.d();
                        if (enumMap != null && enumMap.containsKey(e.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(e.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(e.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        m a2 = a(i7, aVar, enumMap);
                        if (i8 == i) {
                            a2.a(n.ORIENTATION, 180);
                            o[] d2 = a2.d();
                            if (d2 != null) {
                                float f = c2;
                                c2 = c2;
                                try {
                                    d2[0] = new o((f - d2[c3].a()) - 1.0f, d2[c3].b());
                                    try {
                                        d2[1] = new o((f - d2[1].a()) - 1.0f, d2[1].b());
                                    } catch (l unused) {
                                        continue;
                                        i8++;
                                        c3 = 0;
                                        i = 1;
                                    }
                                } catch (l unused2) {
                                    i8++;
                                    c3 = 0;
                                    i = 1;
                                }
                            }
                        }
                        return a2;
                    } catch (l unused3) {
                        c2 = c2;
                    }
                }
                c2 = c2;
                map2 = enumMap;
            } catch (i unused4) {
                c2 = c2;
            }
            i4 = i5;
            c3 = 0;
            i = 1;
        }
        throw i.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        boolean a2 = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != a2) {
                length--;
                a2 = !a2;
            }
        }
        if (length < 0) {
            a(aVar, i + 1, iArr);
            return;
        }
        throw i.a();
    }

    public abstract m a(int i, a aVar, Map<e, ?> map);

    @Override // b.c.b.k
    public m a(c cVar, Map<e, ?> map) {
        try {
            return b(cVar, map);
        } catch (i e2) {
            if (!(map != null && map.containsKey(e.TRY_HARDER)) || !cVar.d()) {
                throw e2;
            }
            cVar.e();
            throw null;
        }
    }

    @Override // b.c.b.k
    public void a() {
    }
}
