package b.c.b.r;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final float f1835a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1836b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1837c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1838d;

    /* renamed from: e  reason: collision with root package name */
    private final float f1839e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    private k(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f1835a = f;
        this.f1836b = f4;
        this.f1837c = f7;
        this.f1838d = f2;
        this.f1839e = f5;
        this.f = f8;
        this.g = f3;
        this.h = f6;
        this.i = f9;
    }

    public static k a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return b(f, f2, f3, f4, f5, f6, f7, f8).a();
    }

    public static k a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return b(f9, f10, f11, f12, f13, f14, f15, f16).a(a(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public static k b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new k(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new k((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    k a() {
        float f = this.f1839e;
        float f2 = this.i;
        float f3 = this.f;
        float f4 = this.h;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.g;
        float f7 = this.f1838d;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.f1837c;
        float f11 = this.f1836b;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.f1835a;
        return new k(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    k a(k kVar) {
        float f = this.f1835a;
        float f2 = kVar.f1835a;
        float f3 = this.f1838d;
        float f4 = kVar.f1836b;
        float f5 = this.g;
        float f6 = kVar.f1837c;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = kVar.f1838d;
        float f9 = kVar.f1839e;
        float f10 = kVar.f;
        float f11 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f12 = kVar.g;
        float f13 = kVar.h;
        float f14 = kVar.i;
        float f15 = (f * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.f1836b;
        float f17 = this.f1839e;
        float f18 = this.h;
        float f19 = (f18 * f14) + (f16 * f12) + (f17 * f13);
        float f20 = this.f1837c;
        float f21 = this.f;
        float f22 = (f2 * f20) + (f4 * f21);
        float f23 = this.i;
        return new k(f7, f11, f15, (f16 * f2) + (f17 * f4) + (f18 * f6), (f16 * f8) + (f17 * f9) + (f18 * f10), f19, (f6 * f23) + f22, (f8 * f20) + (f9 * f21) + (f10 * f23), (f20 * f12) + (f21 * f13) + (f23 * f14));
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f = this.f1835a;
        float f2 = this.f1836b;
        float f3 = this.f1837c;
        float f4 = this.f1838d;
        float f5 = this.f1839e;
        float f6 = this.f;
        float f7 = this.g;
        float f8 = this.h;
        float f9 = this.i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            int i2 = i + 1;
            float f11 = fArr[i2];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }
}
