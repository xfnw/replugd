package b.c.b.r.n;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f1854a;

    public c(a aVar) {
        this.f1854a = aVar;
    }

    private int[] a(b bVar) {
        int a2 = bVar.a();
        int i = 0;
        if (a2 == 1) {
            return new int[]{bVar.b(1)};
        }
        int[] iArr = new int[a2];
        for (int i2 = 1; i2 < this.f1854a.c() && i < a2; i2++) {
            if (bVar.a(i2) == 0) {
                iArr[i] = this.f1854a.b(i2);
                i++;
            }
        }
        if (i == a2) {
            return iArr;
        }
        throw new d("Error locator degree does not match number of roots");
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int b2 = this.f1854a.b(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int b3 = this.f1854a.b(iArr[i3], b2);
                    i2 = this.f1854a.b(i2, (b3 & 1) == 0 ? b3 | 1 : b3 & (-2));
                }
            }
            iArr2[i] = this.f1854a.b(bVar.a(b2), this.f1854a.b(i2));
            if (this.f1854a.a() != 0) {
                iArr2[i] = this.f1854a.b(iArr2[i], b2);
            }
        }
        return iArr2;
    }

    private b[] a(b bVar, b bVar2, int i) {
        if (bVar2.a() < bVar2.a()) {
            bVar2 = bVar2;
            bVar2 = bVar2;
        }
        b d2 = this.f1854a.d();
        d2 = this.f1854a.b();
        while (bVar2.a() >= i / 2) {
            if (!bVar2.b()) {
                b d3 = this.f1854a.d();
                int b2 = this.f1854a.b(bVar2.b(bVar2.a()));
                while (bVar2.a() >= bVar2.a() && !bVar2.b()) {
                    int a2 = bVar2.a() - bVar2.a();
                    int b3 = this.f1854a.b(bVar2.b(bVar2.a()), b2);
                    d3 = d3.a(this.f1854a.a(a2, b3));
                    bVar2 = bVar2.a(bVar2.a(a2, b3));
                }
                d2 = d3.b(d2).a(d2);
                if (bVar2.a() >= bVar2.a()) {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
            } else {
                throw new d("r_{i-1} was zero");
            }
        }
        int b4 = d2.b(0);
        if (b4 != 0) {
            int b5 = this.f1854a.b(b4);
            return new b[]{d2.c(b5), bVar2.c(b5)};
        }
        throw new d("sigmaTilde(0) was zero");
    }

    public void a(int[] iArr, int i) {
        b bVar = new b(this.f1854a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            a aVar = this.f1854a;
            int a2 = bVar.a(aVar.a(aVar.a() + i2));
            iArr2[(i - 1) - i2] = a2;
            if (a2 != 0) {
                z = false;
            }
        }
        if (!z) {
            b[] a3 = a(this.f1854a.a(i, 1), new b(this.f1854a, iArr2), i);
            b bVar2 = a3[0];
            b bVar3 = a3[1];
            int[] a4 = a(bVar2);
            int[] a5 = a(bVar3, a4);
            for (int i3 = 0; i3 < a4.length; i3++) {
                int length = (iArr.length - 1) - this.f1854a.c(a4[i3]);
                if (length >= 0) {
                    iArr[length] = a.c(iArr[length], a5[i3]);
                } else {
                    throw new d("Bad error location");
                }
            }
        }
    }
}
