package a.e.a;

import a.e.a.e;
import a.e.a.i;

/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: c  reason: collision with root package name */
    boolean f130c;

    /* renamed from: d  reason: collision with root package name */
    public final a f131d;

    /* renamed from: a  reason: collision with root package name */
    i f128a = null;

    /* renamed from: b  reason: collision with root package name */
    float f129b = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    boolean f132e = false;

    public b(c cVar) {
        this.f131d = new a(this, cVar);
    }

    public b a(float f, float f2, float f3, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f129b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
            this.f131d.a(iVar4, 1.0f);
            this.f131d.a(iVar3, -1.0f);
        } else if (f == 0.0f) {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f131d.a(iVar3, 1.0f);
            this.f131d.a(iVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
            this.f131d.a(iVar4, f4);
            this.f131d.a(iVar3, -f4);
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.f131d.a(eVar.a(i, "ep"), 1.0f);
        this.f131d.a(eVar.a(i, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar, int i) {
        this.f131d.a(iVar, i);
        return this;
    }

    public b a(i iVar, i iVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f129b = i;
        }
        if (!z) {
            this.f131d.a(iVar, -1.0f);
            this.f131d.a(iVar2, 1.0f);
        } else {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2) {
        float f2;
        if (iVar2 == iVar3) {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar4, 1.0f);
            this.f131d.a(iVar2, -2.0f);
            return this;
        } else if (f == 0.5f) {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
            this.f131d.a(iVar3, -1.0f);
            this.f131d.a(iVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                f2 = (-i) + i2;
                this.f129b = f2;
            }
            return this;
        } else {
            if (f <= 0.0f) {
                this.f131d.a(iVar, -1.0f);
                this.f131d.a(iVar2, 1.0f);
                f2 = i;
            } else if (f >= 1.0f) {
                this.f131d.a(iVar3, -1.0f);
                this.f131d.a(iVar4, 1.0f);
                f2 = i2;
            } else {
                float f3 = 1.0f - f;
                this.f131d.a(iVar, f3 * 1.0f);
                this.f131d.a(iVar2, f3 * (-1.0f));
                this.f131d.a(iVar3, (-1.0f) * f);
                this.f131d.a(iVar4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    f2 = ((-i) * f3) + (i2 * f);
                }
                return this;
            }
            this.f129b = f2;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar, i iVar2, i iVar3, float f) {
        this.f131d.a(iVar, -1.0f);
        this.f131d.a(iVar2, 1.0f - f);
        this.f131d.a(iVar3, f);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f129b = i;
        }
        if (!z) {
            this.f131d.a(iVar, -1.0f);
            this.f131d.a(iVar2, 1.0f);
            this.f131d.a(iVar3, 1.0f);
        } else {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
            this.f131d.a(iVar3, -1.0f);
        }
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.f131d.a(iVar, -1.0f);
        this.f131d.a(iVar2, 1.0f);
        this.f131d.a(iVar3, f);
        this.f131d.a(iVar4, -f);
        return this;
    }

    @Override // a.e.a.e.a
    public i a(e eVar, boolean[] zArr) {
        return this.f131d.a(zArr, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        float f = this.f129b;
        if (f < 0.0f) {
            this.f129b = f * (-1.0f);
            this.f131d.b();
        }
    }

    @Override // a.e.a.e.a
    public void a(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f128a = null;
            this.f131d.a();
            int i = 0;
            while (true) {
                a aVar2 = bVar.f131d;
                if (i < aVar2.f123a) {
                    this.f131d.a(aVar2.a(i), bVar.f131d.b(i), true);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // a.e.a.e.a
    public void a(i iVar) {
        int i = iVar.f151d;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.f131d.a(iVar, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(e eVar) {
        boolean z;
        i a2 = this.f131d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            d(a2);
            z = false;
        }
        if (this.f131d.f123a == 0) {
            this.f132e = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(i iVar, int i) {
        this.f128a = iVar;
        float f = i;
        iVar.f152e = f;
        this.f129b = f;
        this.f132e = true;
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f129b = i;
        }
        if (!z) {
            this.f131d.a(iVar, -1.0f);
            this.f131d.a(iVar2, 1.0f);
            this.f131d.a(iVar3, -1.0f);
        } else {
            this.f131d.a(iVar, 1.0f);
            this.f131d.a(iVar2, -1.0f);
            this.f131d.a(iVar3, 1.0f);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.f131d.a(iVar3, 0.5f);
        this.f131d.a(iVar4, 0.5f);
        this.f131d.a(iVar, -0.5f);
        this.f131d.a(iVar2, -0.5f);
        this.f129b = -f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        i iVar = this.f128a;
        return iVar != null && (iVar.g == i.a.UNRESTRICTED || this.f129b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(i iVar) {
        return this.f131d.a(iVar);
    }

    public b c(i iVar, int i) {
        a aVar;
        float f;
        if (i < 0) {
            this.f129b = i * (-1);
            aVar = this.f131d;
            f = 1.0f;
        } else {
            this.f129b = i;
            aVar = this.f131d;
            f = -1.0f;
        }
        aVar.a(iVar, f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c(i iVar) {
        return this.f131d.a((boolean[]) null, iVar);
    }

    public boolean c() {
        return this.f128a == null && this.f129b == 0.0f && this.f131d.f123a == 0;
    }

    @Override // a.e.a.e.a
    public void clear() {
        this.f131d.a();
        this.f128a = null;
        this.f129b = 0.0f;
    }

    public void d() {
        this.f128a = null;
        this.f131d.a();
        this.f129b = 0.0f;
        this.f132e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(i iVar) {
        i iVar2 = this.f128a;
        if (iVar2 != null) {
            this.f131d.a(iVar2, -1.0f);
            this.f128a = null;
        }
        float a2 = this.f131d.a(iVar, true) * (-1.0f);
        this.f128a = iVar;
        if (a2 != 1.0f) {
            this.f129b /= a2;
            this.f131d.a(a2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String e() {
        /*
            r9 = this;
            a.e.a.i r0 = r9.f128a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0014
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            goto L_0x0021
        L_0x0014:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            a.e.a.i r1 = r9.f128a
            r0.append(r1)
        L_0x0021:
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r9.f129b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0052
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.f129b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            a.e.a.a r5 = r9.f131d
            int r5 = r5.f123a
        L_0x0057:
            if (r2 >= r5) goto L_0x00d4
            a.e.a.a r6 = r9.f131d
            a.e.a.i r6 = r6.a(r2)
            if (r6 != 0) goto L_0x0062
            goto L_0x00d1
        L_0x0062:
            a.e.a.a r7 = r9.f131d
            float r7 = r7.b(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x006d
            goto L_0x00d1
        L_0x006d:
            java.lang.String r6 = r6.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0084
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            goto L_0x00a4
        L_0x0084:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x009a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ad
        L_0x009a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
        L_0x00a4:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r8
        L_0x00ad:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00b9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x00c6
        L_0x00b9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
        L_0x00c6:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            r1 = 1
        L_0x00d1:
            int r2 = r2 + 1
            goto L_0x0057
        L_0x00d4:
            if (r1 != 0) goto L_0x00e7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00e7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.b.e():java.lang.String");
    }

    @Override // a.e.a.e.a
    public i getKey() {
        return this.f128a;
    }

    public String toString() {
        return e();
    }
}
