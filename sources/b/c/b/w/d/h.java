package b.c.b.w.d;

import b.c.b.o;

/* loaded from: classes.dex */
final class h extends g {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2010c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, boolean z) {
        super(cVar);
        this.f2010c = z;
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (c2 > aVar.c()) {
                    dVarArr[i] = null;
                } else {
                    if (!this.f2010c) {
                        c2 += 2;
                    }
                    int i2 = c2 % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && e2 + 1 != aVar.a()) {
                                dVarArr[i] = null;
                            }
                        } else if (e2 / 3 != aVar.b() || e2 % 3 != aVar.d()) {
                            dVarArr[i] = null;
                        }
                    } else if ((e2 * 3) + 1 != aVar.e()) {
                        dVarArr[i] = null;
                    }
                }
            }
        }
    }

    private void b(a aVar) {
        c a2 = a();
        o g = this.f2010c ? a2.g() : a2.h();
        o a3 = this.f2010c ? a2.a() : a2.b();
        int c2 = c((int) a3.b());
        d[] b2 = b();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int c3 = c((int) g.b()); c3 < c2; c3++) {
            if (b2[c3] != null) {
                d dVar = b2[c3];
                dVar.h();
                int c4 = dVar.c() - i;
                if (c4 == 0) {
                    i2++;
                } else {
                    if (c4 == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        b2[c3] = null;
                    } else {
                        i = dVar.c();
                    }
                    i2 = 1;
                }
            }
        }
    }

    private void f() {
        d[] b2;
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        d[] b2 = b();
        f();
        a(b2, aVar);
        c a2 = a();
        o g = this.f2010c ? a2.g() : a2.h();
        o a3 = this.f2010c ? a2.a() : a2.b();
        int c2 = c((int) g.b());
        int c3 = c((int) a3.b());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (c2 < c3) {
            if (b2[c2] != null) {
                d dVar = b2[c2];
                int c4 = dVar.c() - i;
                if (c4 == 0) {
                    i2++;
                } else {
                    if (c4 == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.c();
                    } else if (c4 < 0 || dVar.c() >= aVar.c() || c4 > c2) {
                        b2[c2] = null;
                    } else {
                        if (i3 > 2) {
                            c4 *= i3 - 2;
                        }
                        boolean z = c4 >= c2;
                        for (int i4 = 1; i4 <= c4 && !z; i4++) {
                            z = b2[c2 - i4] != null;
                        }
                        if (z) {
                            b2[c2] = null;
                        } else {
                            i = dVar.c();
                        }
                    }
                    i2 = 1;
                }
            }
            c2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() {
        d[] b2 = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : b2) {
            if (dVar != null) {
                dVar.h();
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (!this.f2010c) {
                    c2 += 2;
                }
                int i = c2 % 3;
                if (i == 0) {
                    bVar2.a((e2 * 3) + 1);
                } else if (i == 1) {
                    bVar4.a(e2 / 3);
                    bVar3.a(e2 % 3);
                } else if (i == 2) {
                    bVar.a(e2 + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(b2, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d() {
        d[] b2;
        int c2;
        a c3 = c();
        if (c3 == null) {
            return null;
        }
        b(c3);
        int[] iArr = new int[c3.c()];
        for (d dVar : b()) {
            if (dVar != null && (c2 = dVar.c()) < iArr.length) {
                iArr[c2] = iArr[c2] + 1;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f2010c;
    }

    @Override // b.c.b.w.d.g
    public String toString() {
        return "IsLeft: " + this.f2010c + '\n' + super.toString();
    }
}
