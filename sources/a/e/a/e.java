package a.e.a;

import a.e.a.i;
import a.e.a.j.e;
import a.e.a.j.f;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {
    private static int p = 1000;
    public static f q;

    /* renamed from: e  reason: collision with root package name */
    private int f140e;
    b[] f;
    private boolean[] h;
    private int k;

    /* renamed from: a  reason: collision with root package name */
    int f136a = 0;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, i> f137b = null;

    /* renamed from: d  reason: collision with root package name */
    private int f139d = 32;
    public boolean g = false;
    int i = 1;
    int j = 0;
    private i[] m = new i[p];
    private int n = 0;
    final c l = new c();

    /* renamed from: c  reason: collision with root package name */
    private a f138c = new d(this.l);
    private final a o = new b(this.l);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        i a(e eVar, boolean[] zArr);

        void a(a aVar);

        void a(i iVar);

        void clear();

        i getKey();
    }

    public e() {
        int i = this.f139d;
        this.f140e = i;
        this.f = null;
        this.h = new boolean[i];
        this.k = i;
        b[] bVarArr = new b[i];
        this.f = new b[i];
        j();
    }

    private final int a(a aVar, boolean z) {
        f fVar = q;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i = 0; i < this.i; i++) {
            this.h[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i2++;
            if (i2 >= this.i * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.h[aVar.getKey().f149b] = true;
            }
            i a2 = aVar.a(this, this.h);
            if (a2 != null) {
                boolean[] zArr = this.h;
                int i3 = a2.f149b;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (a2 != null) {
                int i4 = -1;
                float f = Float.MAX_VALUE;
                for (int i5 = 0; i5 < this.j; i5++) {
                    b bVar = this.f[i5];
                    if (bVar.f128a.g != i.a.UNRESTRICTED && !bVar.f132e && bVar.b(a2)) {
                        float b2 = bVar.f131d.b(a2);
                        if (b2 < 0.0f) {
                            float f2 = (-bVar.f129b) / b2;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f[i4];
                    bVar2.f128a.f150c = -1;
                    f fVar3 = q;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.d(a2);
                    i iVar = bVar2.f128a;
                    iVar.f150c = i4;
                    iVar.c(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    public static b a(e eVar, i iVar, i iVar2, i iVar3, float f, boolean z) {
        b b2 = eVar.b();
        if (z) {
            eVar.b(b2);
        }
        b2.a(iVar, iVar2, iVar3, f);
        return b2;
    }

    private i a(i.a aVar, String str) {
        i a2 = this.l.f134b.a();
        if (a2 == null) {
            a2 = new i(aVar, str);
        } else {
            a2.a();
        }
        a2.a(aVar, str);
        int i = this.n;
        int i2 = p;
        if (i >= i2) {
            p = i2 * 2;
            this.m = (i[]) Arrays.copyOf(this.m, p);
        }
        i[] iVarArr = this.m;
        int i3 = this.n;
        this.n = i3 + 1;
        iVarArr[i3] = a2;
        return a2;
    }

    private int b(a aVar) {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f;
            if (bVarArr[i].f128a.g != i.a.UNRESTRICTED && bVarArr[i].f129b < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar = q;
            if (fVar != null) {
                fVar.k++;
            }
            i2++;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            float f2 = Float.MAX_VALUE;
            int i6 = 0;
            while (i3 < this.j) {
                b bVar = this.f[i3];
                if (bVar.f128a.g != i.a.UNRESTRICTED && !bVar.f132e && bVar.f129b < f) {
                    int i7 = 1;
                    while (i7 < this.i) {
                        i iVar = this.l.f135c[i7];
                        float b2 = bVar.f131d.b(iVar);
                        if (b2 > f) {
                            int i8 = i6;
                            float f3 = f2;
                            int i9 = i5;
                            int i10 = i4;
                            for (int i11 = 0; i11 < 7; i11++) {
                                float f4 = iVar.f[i11] / b2;
                                if ((f4 < f3 && i11 == i8) || i11 > i8) {
                                    i9 = i7;
                                    i10 = i3;
                                    f3 = f4;
                                    i8 = i11;
                                }
                            }
                            i4 = i10;
                            i5 = i9;
                            f2 = f3;
                            i6 = i8;
                        }
                        i7++;
                        f = 0.0f;
                    }
                }
                i3++;
                f = 0.0f;
            }
            if (i4 != -1) {
                b bVar2 = this.f[i4];
                bVar2.f128a.f150c = -1;
                f fVar2 = q;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.d(this.l.f135c[i5]);
                i iVar2 = bVar2.f128a;
                iVar2.f150c = i4;
                iVar2.c(bVar2);
            } else {
                z2 = true;
            }
            if (i2 > this.i / 2) {
                z2 = true;
            }
            f = 0.0f;
        }
        return i2;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    private final void c(b bVar) {
        b[] bVarArr = this.f;
        int i = this.j;
        if (bVarArr[i] != null) {
            this.l.f133a.a(bVarArr[i]);
        }
        b[] bVarArr2 = this.f;
        int i2 = this.j;
        bVarArr2[i2] = bVar;
        i iVar = bVar.f128a;
        iVar.f150c = i2;
        this.j = i2 + 1;
        iVar.c(bVar);
    }

    private final void d(b bVar) {
        if (this.j > 0) {
            bVar.f131d.a(bVar, this.f);
            if (bVar.f131d.f123a == 0) {
                bVar.f132e = true;
            }
        }
    }

    private void g() {
        for (int i = 0; i < this.j; i++) {
            b bVar = this.f[i];
            bVar.f128a.f152e = bVar.f129b;
        }
    }

    public static f h() {
        return q;
    }

    private void i() {
        this.f139d *= 2;
        this.f = (b[]) Arrays.copyOf(this.f, this.f139d);
        c cVar = this.l;
        cVar.f135c = (i[]) Arrays.copyOf(cVar.f135c, this.f139d);
        int i = this.f139d;
        this.h = new boolean[i];
        this.f140e = i;
        this.k = i;
        f fVar = q;
        if (fVar != null) {
            fVar.f144d++;
            fVar.o = Math.max(fVar.o, i);
            f fVar2 = q;
            fVar2.A = fVar2.o;
        }
    }

    private void j() {
        int i = 0;
        while (true) {
            b[] bVarArr = this.f;
            if (i < bVarArr.length) {
                b bVar = bVarArr[i];
                if (bVar != null) {
                    this.l.f133a.a(bVar);
                }
                this.f[i] = null;
                i++;
            } else {
                return;
            }
        }
    }

    public b a(i iVar, i iVar2, int i, int i2) {
        b b2 = b();
        b2.a(iVar, iVar2, i);
        if (i2 != 6) {
            b2.a(this, i2);
        }
        a(b2);
        return b2;
    }

    public i a() {
        f fVar = q;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.i + 1 >= this.f140e) {
            i();
        }
        i a2 = a(i.a.SLACK, (String) null);
        this.f136a++;
        this.i++;
        int i = this.f136a;
        a2.f149b = i;
        this.l.f135c[i] = a2;
        return a2;
    }

    public i a(int i, String str) {
        f fVar = q;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.i + 1 >= this.f140e) {
            i();
        }
        i a2 = a(i.a.ERROR, str);
        this.f136a++;
        this.i++;
        int i2 = this.f136a;
        a2.f149b = i2;
        a2.f151d = i;
        this.l.f135c[i2] = a2;
        this.f138c.a(a2);
        return a2;
    }

    public i a(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.f140e) {
            i();
        }
        if (obj instanceof a.e.a.j.e) {
            a.e.a.j.e eVar = (a.e.a.j.e) obj;
            iVar = eVar.e();
            if (iVar == null) {
                eVar.a(this.l);
                iVar = eVar.e();
            }
            int i = iVar.f149b;
            if (i == -1 || i > this.f136a || this.l.f135c[i] == null) {
                if (iVar.f149b != -1) {
                    iVar.a();
                }
                this.f136a++;
                this.i++;
                int i2 = this.f136a;
                iVar.f149b = i2;
                iVar.g = i.a.UNRESTRICTED;
                this.l.f135c[i2] = iVar;
            }
        }
        return iVar;
    }

    public void a(b bVar) {
        i c2;
        if (bVar != null) {
            f fVar = q;
            if (fVar != null) {
                fVar.f++;
                if (bVar.f132e) {
                    fVar.g++;
                }
            }
            if (this.j + 1 >= this.k || this.i + 1 >= this.f140e) {
                i();
            }
            boolean z = false;
            if (!bVar.f132e) {
                d(bVar);
                if (!bVar.c()) {
                    bVar.a();
                    if (bVar.a(this)) {
                        i a2 = a();
                        bVar.f128a = a2;
                        c(bVar);
                        this.o.a(bVar);
                        a(this.o, true);
                        if (a2.f150c == -1) {
                            if (bVar.f128a == a2 && (c2 = bVar.c(a2)) != null) {
                                f fVar2 = q;
                                if (fVar2 != null) {
                                    fVar2.j++;
                                }
                                bVar.d(c2);
                            }
                            if (!bVar.f132e) {
                                bVar.f128a.c(bVar);
                            }
                            this.j--;
                        }
                        z = true;
                    }
                    if (!bVar.b()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                c(bVar);
            }
        }
    }

    void a(b bVar, int i, int i2) {
        bVar.a(a(i2, (String) null), i);
    }

    void a(a aVar) {
        f fVar = q;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, this.i);
            f fVar2 = q;
            fVar2.u = Math.max(fVar2.u, this.j);
        }
        d((b) aVar);
        b(aVar);
        a(aVar, false);
        g();
    }

    public void a(i iVar, int i) {
        b bVar;
        int i2 = iVar.f150c;
        if (i2 != -1) {
            b bVar2 = this.f[i2];
            if (!bVar2.f132e) {
                if (bVar2.f131d.f123a == 0) {
                    bVar2.f132e = true;
                } else {
                    bVar = b();
                    bVar.c(iVar, i);
                }
            }
            bVar2.f129b = i;
            return;
        }
        bVar = b();
        bVar.b(iVar, i);
        a(bVar);
    }

    public void a(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2, int i3) {
        b b2 = b();
        b2.a(iVar, iVar2, i, f, iVar3, iVar4, i2);
        if (i3 != 6) {
            b2.a(this, i3);
        }
        a(b2);
    }

    public void a(i iVar, i iVar2, i iVar3, i iVar4, float f, int i) {
        b b2 = b();
        b2.a(iVar, iVar2, iVar3, iVar4, f);
        if (i != 6) {
            b2.a(this, i);
        }
        a(b2);
    }

    public void a(i iVar, i iVar2, boolean z) {
        b b2 = b();
        i c2 = c();
        c2.f151d = 0;
        b2.a(iVar, iVar2, c2, 0);
        if (z) {
            a(b2, (int) (b2.f131d.b(c2) * (-1.0f)), 1);
        }
        a(b2);
    }

    public void a(f fVar, f fVar2, float f, int i) {
        i a2 = a(fVar.a(e.d.LEFT));
        i a3 = a(fVar.a(e.d.TOP));
        i a4 = a(fVar.a(e.d.RIGHT));
        i a5 = a(fVar.a(e.d.BOTTOM));
        i a6 = a(fVar2.a(e.d.LEFT));
        i a7 = a(fVar2.a(e.d.TOP));
        i a8 = a(fVar2.a(e.d.RIGHT));
        i a9 = a(fVar2.a(e.d.BOTTOM));
        b b2 = b();
        double d2 = f;
        double sin = Math.sin(d2);
        double d3 = i;
        Double.isNaN(d3);
        b2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(b2);
        b b3 = b();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        b3.b(a2, a4, a6, a8, (float) (cos * d3));
        a(b3);
    }

    public int b(Object obj) {
        i e2 = ((a.e.a.j.e) obj).e();
        if (e2 != null) {
            return (int) (e2.f152e + 0.5f);
        }
        return 0;
    }

    public b b() {
        b a2 = this.l.f133a.a();
        if (a2 == null) {
            a2 = new b(this.l);
        } else {
            a2.d();
        }
        i.b();
        return a2;
    }

    public void b(i iVar, i iVar2, int i, int i2) {
        b b2 = b();
        i c2 = c();
        c2.f151d = 0;
        b2.a(iVar, iVar2, c2, i);
        if (i2 != 6) {
            a(b2, (int) (b2.f131d.b(c2) * (-1.0f)), i2);
        }
        a(b2);
    }

    public void b(i iVar, i iVar2, boolean z) {
        b b2 = b();
        i c2 = c();
        c2.f151d = 0;
        b2.b(iVar, iVar2, c2, 0);
        if (z) {
            a(b2, (int) (b2.f131d.b(c2) * (-1.0f)), 1);
        }
        a(b2);
    }

    public i c() {
        f fVar = q;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.i + 1 >= this.f140e) {
            i();
        }
        i a2 = a(i.a.SLACK, (String) null);
        this.f136a++;
        this.i++;
        int i = this.f136a;
        a2.f149b = i;
        this.l.f135c[i] = a2;
        return a2;
    }

    public void c(i iVar, i iVar2, int i, int i2) {
        b b2 = b();
        i c2 = c();
        c2.f151d = 0;
        b2.b(iVar, iVar2, c2, i);
        if (i2 != 6) {
            a(b2, (int) (b2.f131d.b(c2) * (-1.0f)), i2);
        }
        a(b2);
    }

    public c d() {
        return this.l;
    }

    public void e() {
        f fVar = q;
        if (fVar != null) {
            fVar.f145e++;
        }
        if (this.g) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.q++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.j) {
                    z = true;
                    break;
                } else if (!this.f[i].f132e) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                f fVar3 = q;
                if (fVar3 != null) {
                    fVar3.p++;
                }
                g();
                return;
            }
        }
        a(this.f138c);
    }

    public void f() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.l;
            i[] iVarArr = cVar.f135c;
            if (i >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i];
            if (iVar != null) {
                iVar.a();
            }
            i++;
        }
        cVar.f134b.a(this.m, this.n);
        this.n = 0;
        Arrays.fill(this.l.f135c, (Object) null);
        HashMap<String, i> hashMap = this.f137b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f136a = 0;
        this.f138c.clear();
        this.i = 1;
        for (int i2 = 0; i2 < this.j; i2++) {
            this.f[i2].f130c = false;
        }
        j();
        this.j = 0;
    }
}
