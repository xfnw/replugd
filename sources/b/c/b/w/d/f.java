package b.c.b.w.d;

import java.util.Formatter;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private final a f2004a;

    /* renamed from: b  reason: collision with root package name */
    private final g[] f2005b;

    /* renamed from: c  reason: collision with root package name */
    private c f2006c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2007d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, c cVar) {
        this.f2004a = aVar;
        this.f2007d = aVar.a();
        this.f2006c = cVar;
        this.f2005b = new g[this.f2007d + 2];
    }

    private static int a(int i, int i2, d dVar) {
        if (dVar == null || dVar.g()) {
            return i2;
        }
        if (!dVar.a(i)) {
            return i2 + 1;
        }
        dVar.b(i);
        return 0;
    }

    private void a(int i, int i2, d[] dVarArr) {
        d dVar = dVarArr[i2];
        d[] b2 = this.f2005b[i - 1].b();
        g[] gVarArr = this.f2005b;
        int i3 = i + 1;
        d[] b3 = gVarArr[i3] != null ? gVarArr[i3].b() : b2;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = b2[i2];
        dVarArr2[3] = b3[i2];
        if (i2 > 0) {
            int i4 = i2 - 1;
            dVarArr2[0] = dVarArr[i4];
            dVarArr2[4] = b2[i4];
            dVarArr2[5] = b3[i4];
        }
        if (i2 > 1) {
            int i5 = i2 - 2;
            dVarArr2[8] = dVarArr[i5];
            dVarArr2[10] = b2[i5];
            dVarArr2[11] = b3[i5];
        }
        if (i2 < dVarArr.length - 1) {
            int i6 = i2 + 1;
            dVarArr2[1] = dVarArr[i6];
            dVarArr2[6] = b2[i6];
            dVarArr2[7] = b3[i6];
        }
        if (i2 < dVarArr.length - 2) {
            int i7 = i2 + 2;
            dVarArr2[9] = dVarArr[i7];
            dVarArr2[12] = b2[i7];
            dVarArr2[13] = b3[i7];
        }
        for (int i8 = 0; i8 < 14 && !a(dVar, dVarArr2[i8]); i8++) {
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).a(this.f2004a);
        }
    }

    private static boolean a(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.b(dVar2.c());
        return true;
    }

    private int f() {
        int g = g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.f2007d + 1; i++) {
            d[] b2 = this.f2005b[i].b();
            for (int i2 = 0; i2 < b2.length; i2++) {
                if (b2[i2] != null && !b2[i2].g()) {
                    a(i, i2, b2);
                }
            }
        }
        return g;
    }

    private int g() {
        h();
        return i() + j();
    }

    private void h() {
        g[] gVarArr = this.f2005b;
        if (!(gVarArr[0] == null || gVarArr[this.f2007d + 1] == null)) {
            d[] b2 = gVarArr[0].b();
            d[] b3 = this.f2005b[this.f2007d + 1].b();
            for (int i = 0; i < b2.length; i++) {
                if (!(b2[i] == null || b3[i] == null || b2[i].c() != b3[i].c())) {
                    for (int i2 = 1; i2 <= this.f2007d; i2++) {
                        d dVar = this.f2005b[i2].b()[i];
                        if (dVar != null) {
                            dVar.b(b2[i].c());
                            if (!dVar.g()) {
                                this.f2005b[i2].b()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int i() {
        g[] gVarArr = this.f2005b;
        if (gVarArr[0] == null) {
            return 0;
        }
        d[] b2 = gVarArr[0].b();
        int i = 0;
        for (int i2 = 0; i2 < b2.length; i2++) {
            if (b2[i2] != null) {
                int c2 = b2[i2].c();
                int i3 = i;
                int i4 = 0;
                for (int i5 = 1; i5 < this.f2007d + 1 && i4 < 2; i5++) {
                    d dVar = this.f2005b[i5].b()[i2];
                    if (dVar != null) {
                        i4 = a(c2, i4, dVar);
                        if (!dVar.g()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private int j() {
        g[] gVarArr = this.f2005b;
        int i = this.f2007d;
        if (gVarArr[i + 1] == null) {
            return 0;
        }
        d[] b2 = gVarArr[i + 1].b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2.length; i3++) {
            if (b2[i3] != null) {
                int c2 = b2[i3].c();
                int i4 = i2;
                int i5 = 0;
                for (int i6 = this.f2007d + 1; i6 > 0 && i5 < 2; i6--) {
                    d dVar = this.f2005b[i6].b()[i3];
                    if (dVar != null) {
                        i5 = a(c2, i5, dVar);
                        if (!dVar.g()) {
                            i4++;
                        }
                    }
                }
                i2 = i4;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2007d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(int i) {
        return this.f2005b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, g gVar) {
        this.f2005b[i] = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f2006c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2004a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2004a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f2006c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g[] e() {
        a(this.f2005b[0]);
        a(this.f2005b[this.f2007d + 1]);
        int i = 928;
        while (true) {
            int f = f();
            if (f <= 0 || f >= i) {
                break;
            }
            i = f;
        }
        return this.f2005b;
    }

    public String toString() {
        g[] gVarArr = this.f2005b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f2007d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < gVar.b().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.f2007d + 2; i2++) {
                    if (this.f2005b[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = this.f2005b[i2].b()[i];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } finally {
                try {
                    throw th;
                } catch (Throwable th) {
                }
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
