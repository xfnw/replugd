package a.e.a.j;

import a.e.a.e;
import a.e.a.i;
import a.e.a.j.e;

/* loaded from: classes.dex */
public class m extends o {

    /* renamed from: c  reason: collision with root package name */
    e f197c;

    /* renamed from: d  reason: collision with root package name */
    m f198d;

    /* renamed from: e  reason: collision with root package name */
    float f199e;
    m f;
    float g;
    private m i;
    int h = 0;
    private n j = null;
    private int k = 1;
    private n l = null;
    private int m = 1;

    public m(e eVar) {
        this.f197c = eVar;
    }

    String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(int i, m mVar, int i2) {
        this.h = i;
        this.f198d = mVar;
        this.f199e = i2;
        this.f198d.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar) {
        i e2 = this.f197c.e();
        m mVar = this.f;
        if (mVar == null) {
            eVar.a(e2, (int) (this.g + 0.5f));
        } else {
            eVar.a(e2, eVar.a(mVar.f197c), (int) (this.g + 0.5f), 6);
        }
    }

    public void a(m mVar, float f) {
        if (this.f202b == 0 || !(this.f == mVar || this.g == f)) {
            this.f = mVar;
            this.g = f;
            if (this.f202b == 1) {
                b();
            }
            a();
        }
    }

    public void a(m mVar, int i) {
        this.f198d = mVar;
        this.f199e = i;
        this.f198d.a(this);
    }

    public void a(m mVar, int i, n nVar) {
        this.f198d = mVar;
        this.f198d.a(this);
        this.j = nVar;
        this.k = i;
        this.j.a(this);
    }

    public void b(int i) {
        this.h = i;
    }

    public void b(m mVar, float f) {
        this.i = mVar;
    }

    public void b(m mVar, int i, n nVar) {
        this.i = mVar;
        this.l = nVar;
        this.m = i;
    }

    @Override // a.e.a.j.o
    public void d() {
        super.d();
        this.f198d = null;
        this.f199e = 0.0f;
        this.j = null;
        this.k = 1;
        this.l = null;
        this.m = 1;
        this.f = null;
        this.g = 0.0f;
        this.i = null;
        this.h = 0;
    }

    @Override // a.e.a.j.o
    public void e() {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        m mVar7;
        float f;
        e eVar;
        float f2;
        float f3;
        m mVar8;
        float f4;
        boolean z = true;
        if (this.f202b != 1 && this.h != 4) {
            n nVar = this.j;
            if (nVar != null) {
                if (nVar.f202b == 1) {
                    this.f199e = this.k * nVar.f200c;
                } else {
                    return;
                }
            }
            n nVar2 = this.l;
            if (nVar2 != null) {
                if (nVar2.f202b == 1) {
                    float f5 = nVar2.f200c;
                } else {
                    return;
                }
            }
            if (this.h == 1 && ((mVar8 = this.f198d) == null || mVar8.f202b == 1)) {
                m mVar9 = this.f198d;
                if (mVar9 == null) {
                    this.f = this;
                    f4 = this.f199e;
                } else {
                    this.f = mVar9.f;
                    f4 = mVar9.g + this.f199e;
                }
                this.g = f4;
                a();
                return;
            }
            if (this.h == 2 && (mVar4 = this.f198d) != null && mVar4.f202b == 1 && (mVar5 = this.i) != null && (mVar6 = mVar5.f198d) != null && mVar6.f202b == 1) {
                if (e.h() != null) {
                    e.h().v++;
                }
                this.f = this.f198d.f;
                m mVar10 = this.i;
                mVar10.f = mVar10.f198d.f;
                e.d dVar = this.f197c.f164c;
                int i = 0;
                if (!(dVar == e.d.RIGHT || dVar == e.d.BOTTOM)) {
                    z = false;
                }
                if (z) {
                    f = this.f198d.g;
                    mVar7 = this.i.f198d;
                } else {
                    f = this.i.f198d.g;
                    mVar7 = this.f198d;
                }
                float f6 = f - mVar7.g;
                e.d dVar2 = this.f197c.f164c;
                if (dVar2 == e.d.LEFT || dVar2 == e.d.RIGHT) {
                    f3 = f6 - this.f197c.f163b.s();
                    f2 = this.f197c.f163b.V;
                } else {
                    f3 = f6 - eVar.f163b.i();
                    f2 = this.f197c.f163b.W;
                }
                i = this.f197c.b();
                int b2 = this.i.f197c.b();
                if (this.f197c.g() == this.i.f197c.g()) {
                    f2 = 0.5f;
                    b2 = 0;
                }
                float f7 = i;
                float f8 = b2;
                float f9 = (f3 - f7) - f8;
                if (z) {
                    m mVar11 = this.i;
                    mVar11.g = mVar11.f198d.g + f8 + (f9 * f2);
                    this.g = (this.f198d.g - f7) - (f9 * (1.0f - f2));
                } else {
                    this.g = this.f198d.g + f7 + (f9 * f2);
                    m mVar12 = this.i;
                    mVar12.g = (mVar12.f198d.g - f8) - (f9 * (1.0f - f2));
                }
            } else if (this.h == 3 && (mVar = this.f198d) != null && mVar.f202b == 1 && (mVar2 = this.i) != null && (mVar3 = mVar2.f198d) != null && mVar3.f202b == 1) {
                if (a.e.a.e.h() != null) {
                    a.e.a.e.h().w++;
                }
                m mVar13 = this.f198d;
                this.f = mVar13.f;
                m mVar14 = this.i;
                m mVar15 = mVar14.f198d;
                mVar14.f = mVar15.f;
                this.g = mVar13.g + this.f199e;
                mVar14.g = mVar15.g + mVar14.f199e;
            } else if (this.h == 5) {
                this.f197c.f163b.G();
                return;
            } else {
                return;
            }
            a();
            this.i.a();
        }
    }

    public float f() {
        return this.g;
    }

    public void g() {
        e g = this.f197c.g();
        if (g != null) {
            if (g.g() == this.f197c) {
                this.h = 4;
                g.d().h = 4;
            }
            int b2 = this.f197c.b();
            e.d dVar = this.f197c.f164c;
            if (dVar == e.d.RIGHT || dVar == e.d.BOTTOM) {
                b2 = -b2;
            }
            a(g.d(), b2);
        }
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.f202b != 1) {
            sb = new StringBuilder();
            sb.append("{ ");
            sb.append(this.f197c);
            str = " UNRESOLVED} type: ";
        } else if (this.f == this) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f197c);
            sb.append(", RESOLVED: ");
            sb.append(this.g);
            str = "]  type: ";
        } else {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f197c);
            sb.append(", RESOLVED: ");
            sb.append(this.f);
            sb.append(":");
            sb.append(this.g);
            str = "] type: ";
        }
        sb.append(str);
        sb.append(a(this.h));
        return sb.toString();
    }
}
