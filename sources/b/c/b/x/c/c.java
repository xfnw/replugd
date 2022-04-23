package b.c.b.x.c;

import b.c.b.e;
import b.c.b.i;
import b.c.b.o;
import b.c.b.p;
import b.c.b.r.b;
import b.c.b.r.g;
import b.c.b.r.k;
import b.c.b.r.m.a;
import b.c.b.x.b.j;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f2069a;

    /* renamed from: b  reason: collision with root package name */
    private p f2070b;

    public c(b bVar) {
        this.f2069a = bVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        c cVar;
        boolean z;
        int i10 = 1;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i5 = i;
            i7 = i2;
            i6 = i3;
            i8 = i4;
        } else {
            i7 = i;
            i5 = i2;
            i8 = i3;
            i6 = i4;
        }
        int abs = Math.abs(i8 - i7);
        int abs2 = Math.abs(i6 - i5);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i7 < i8 ? 1 : -1;
        if (i5 < i6) {
            i12 = 1;
        }
        int i14 = i8 + i13;
        int i15 = i5;
        int i16 = 0;
        int i17 = i7;
        while (true) {
            if (i17 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z2 ? i15 : i17;
            int i19 = z2 ? i17 : i15;
            if (i16 == i10) {
                cVar = this;
                z2 = z2;
                i9 = i14;
                z = true;
            } else {
                cVar = this;
                z2 = z2;
                i9 = i14;
                z = false;
            }
            if (z == cVar.f2069a.b(i18, i19)) {
                if (i16 == 2) {
                    return a.a(i17, i15, i7, i5);
                }
                i16++;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (i15 == i6) {
                    break;
                }
                i15 += i12;
                i11 -= abs;
            }
            i17 += i13;
            i14 = i9;
            i10 = 1;
        }
        if (i16 == 2) {
            return a.a(i9, i6, i7, i5);
        }
        return Float.NaN;
    }

    private float a(o oVar, o oVar2) {
        float b2 = b((int) oVar.a(), (int) oVar.b(), (int) oVar2.a(), (int) oVar2.b());
        float b3 = b((int) oVar2.a(), (int) oVar2.b(), (int) oVar.a(), (int) oVar.b());
        return Float.isNaN(b2) ? b3 / 7.0f : Float.isNaN(b3) ? b2 / 7.0f : (b2 + b3) / 14.0f;
    }

    private static int a(o oVar, o oVar2, o oVar3, float f) {
        int a2 = ((a.a(o.a(oVar, oVar2) / f) + a.a(o.a(oVar, oVar3) / f)) / 2) + 7;
        int i = a2 & 3;
        if (i == 0) {
            return a2 + 1;
        }
        if (i == 2) {
            return a2 - 1;
        }
        if (i != 3) {
            return a2;
        }
        throw i.a();
    }

    private static b a(b bVar, k kVar, int i) {
        return b.c.b.r.i.a().a(bVar, i, i, kVar);
    }

    private static k a(o oVar, o oVar2, o oVar3, o oVar4, int i) {
        float f;
        float f2;
        float f3;
        float f4 = i - 3.5f;
        if (oVar4 != null) {
            f2 = oVar4.a();
            f = oVar4.b();
            f3 = f4 - 3.0f;
        } else {
            f2 = (oVar2.a() - oVar.a()) + oVar3.a();
            f = (oVar2.b() - oVar.b()) + oVar3.b();
            f3 = f4;
        }
        return k.a(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, oVar.a(), oVar.b(), oVar2.a(), oVar2.b(), f2, f, oVar3.a(), oVar3.b());
    }

    private float b(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float a2 = a(i, i2, i3, i4);
        int i6 = i - (i3 - i);
        int i7 = 0;
        if (i6 < 0) {
            f = i / (i - i6);
            i5 = 0;
        } else if (i6 >= this.f2069a.e()) {
            f = ((this.f2069a.e() - 1) - i) / (i6 - i);
            i5 = this.f2069a.e() - 1;
        } else {
            i5 = i6;
            f = 1.0f;
        }
        float f3 = i2;
        int i8 = (int) (f3 - ((i4 - i2) * f));
        if (i8 < 0) {
            f2 = f3 / (i2 - i8);
        } else if (i8 >= this.f2069a.c()) {
            f2 = ((this.f2069a.c() - 1) - i2) / (i8 - i2);
            i7 = this.f2069a.c() - 1;
        } else {
            i7 = i8;
            f2 = 1.0f;
        }
        return (a2 + a(i, i2, (int) (i + ((i5 - i) * f2)), i7)) - 1.0f;
    }

    protected final float a(o oVar, o oVar2, o oVar3) {
        return (a(oVar, oVar2) + a(oVar, oVar3)) / 2.0f;
    }

    protected final g a(f fVar) {
        d b2 = fVar.b();
        d c2 = fVar.c();
        d a2 = fVar.a();
        float a3 = a(b2, c2, a2);
        if (a3 >= 1.0f) {
            int a4 = a(b2, c2, a2, a3);
            j b3 = j.b(a4);
            int c3 = b3.c() - 7;
            a aVar = null;
            if (b3.b().length > 0) {
                float a5 = (c2.a() - b2.a()) + a2.a();
                float b4 = (c2.b() - b2.b()) + a2.b();
                float f = 1.0f - (3.0f / c3);
                int a6 = (int) (b2.a() + ((a5 - b2.a()) * f));
                int b5 = (int) (b2.b() + (f * (b4 - b2.b())));
                for (int i = 4; i <= 16; i <<= 1) {
                    try {
                        aVar = a(a3, a6, b5, i);
                        break;
                    } catch (i unused) {
                    }
                }
            }
            return new g(a(this.f2069a, a(b2, c2, a2, aVar, a4), a4), aVar == null ? new o[]{a2, b2, c2} : new o[]{a2, b2, c2, aVar});
        }
        throw i.a();
    }

    public final g a(Map<e, ?> map) {
        this.f2070b = map == null ? null : (p) map.get(e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.f2069a, this.f2070b).a(map));
    }

    protected final a a(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f2069a.e() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (min >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.f2069a.c() - 1, i2 + i3) - max2;
            if (min2 >= f3) {
                return new b(this.f2069a, max, max2, min, min2, f, this.f2070b).a();
            }
            throw i.a();
        }
        throw i.a();
    }
}
