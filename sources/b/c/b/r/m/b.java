package b.c.b.r.m;

import b.c.b.i;
import b.c.b.o;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final b.c.b.r.b f1842a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1843b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1844c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1845d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1846e;
    private final int f;
    private final int g;

    public b(b.c.b.r.b bVar) {
        this(bVar, 10, bVar.e() / 2, bVar.c() / 2);
    }

    public b(b.c.b.r.b bVar, int i, int i2, int i3) {
        this.f1842a = bVar;
        this.f1843b = bVar.c();
        this.f1844c = bVar.e();
        int i4 = i / 2;
        this.f1845d = i2 - i4;
        this.f1846e = i2 + i4;
        this.g = i3 - i4;
        this.f = i3 + i4;
        if (this.g < 0 || this.f1845d < 0 || this.f >= this.f1843b || this.f1846e >= this.f1844c) {
            throw i.a();
        }
    }

    private o a(float f, float f2, float f3, float f4) {
        int a2 = a.a(a.a(f, f2, f3, f4));
        float f5 = a2;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < a2; i++) {
            float f8 = i;
            int a3 = a.a((f8 * f6) + f);
            int a4 = a.a((f8 * f7) + f2);
            if (this.f1842a.b(a3, a4)) {
                return new o(a3, a4);
            }
        }
        return null;
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f1842a.b(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f1842a.b(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private o[] a(o oVar, o oVar2, o oVar3, o oVar4) {
        float a2 = oVar.a();
        float b2 = oVar.b();
        float a3 = oVar2.a();
        float b3 = oVar2.b();
        float a4 = oVar3.a();
        float b4 = oVar3.b();
        float a5 = oVar4.a();
        float b5 = oVar4.b();
        return a2 < ((float) this.f1844c) / 2.0f ? new o[]{new o(a5 - 1.0f, b5 + 1.0f), new o(a3 + 1.0f, b3 + 1.0f), new o(a4 - 1.0f, b4 - 1.0f), new o(a2 + 1.0f, b2 - 1.0f)} : new o[]{new o(a5 + 1.0f, b5 + 1.0f), new o(a3 + 1.0f, b3 - 1.0f), new o(a4 - 1.0f, b4 + 1.0f), new o(a2 - 1.0f, b2 - 1.0f)};
    }

    public o[] a() {
        boolean z;
        int i = this.f1845d;
        int i2 = this.f1846e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (boolean z8 = true; z8; z8 = z) {
            boolean z9 = true;
            z = false;
            while (true) {
                if ((z9 || !z3) && i2 < this.f1844c) {
                    z9 = a(i3, i4, i2, false);
                    if (z9) {
                        i2++;
                        z3 = true;
                        z = true;
                    } else if (!z3) {
                        i2++;
                    }
                }
            }
            if (i2 < this.f1844c) {
                boolean z10 = true;
                while (true) {
                    if ((z10 || !z4) && i4 < this.f1843b) {
                        z10 = a(i, i2, i4, true);
                        if (z10) {
                            i4++;
                            z4 = true;
                            z = true;
                        } else if (!z4) {
                            i4++;
                        }
                    }
                }
                if (i4 < this.f1843b) {
                    boolean z11 = true;
                    while (true) {
                        if ((z11 || !z5) && i >= 0) {
                            z11 = a(i3, i4, i, false);
                            if (z11) {
                                i--;
                                z5 = true;
                                z = true;
                            } else if (!z5) {
                                i--;
                            }
                        }
                    }
                    if (i >= 0) {
                        boolean z12 = true;
                        while (true) {
                            if ((z12 || !z7) && i3 >= 0) {
                                z12 = a(i, i2, i3, true);
                                if (z12) {
                                    i3--;
                                    z7 = true;
                                    z = true;
                                } else if (!z7) {
                                    i3--;
                                }
                            }
                        }
                        if (i3 >= 0) {
                            if (z) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2 || !z6) {
            throw i.a();
        }
        int i5 = i2 - i;
        o oVar = null;
        o oVar2 = null;
        for (int i6 = 1; oVar2 == null && i6 < i5; i6++) {
            oVar2 = a(i, i4 - i6, i + i6, i4);
        }
        if (oVar2 != null) {
            o oVar3 = null;
            for (int i7 = 1; oVar3 == null && i7 < i5; i7++) {
                oVar3 = a(i, i3 + i7, i + i7, i3);
            }
            if (oVar3 != null) {
                o oVar4 = null;
                for (int i8 = 1; oVar4 == null && i8 < i5; i8++) {
                    oVar4 = a(i2, i3 + i8, i2 - i8, i3);
                }
                if (oVar4 != null) {
                    for (int i9 = 1; oVar == null && i9 < i5; i9++) {
                        oVar = a(i2, i4 - i9, i2 - i9, i4);
                    }
                    if (oVar != null) {
                        return a(oVar, oVar2, oVar4, oVar3);
                    }
                    throw i.a();
                }
                throw i.a();
            }
            throw i.a();
        }
        throw i.a();
    }
}
