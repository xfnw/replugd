package b.c.b.w.d;

import b.c.b.i;
import b.c.b.o;
import b.c.b.r.b;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f1986a;

    /* renamed from: b  reason: collision with root package name */
    private final o f1987b;

    /* renamed from: c  reason: collision with root package name */
    private final o f1988c;

    /* renamed from: d  reason: collision with root package name */
    private final o f1989d;

    /* renamed from: e  reason: collision with root package name */
    private final o f1990e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, o oVar, o oVar2, o oVar3, o oVar4) {
        boolean z = false;
        boolean z2 = oVar == null || oVar2 == null;
        z = (oVar3 == null || oVar4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                oVar = new o(0.0f, oVar3.b());
                oVar2 = new o(0.0f, oVar4.b());
            } else if (z) {
                oVar3 = new o(bVar.e() - 1, oVar.b());
                oVar4 = new o(bVar.e() - 1, oVar2.b());
            }
            this.f1986a = bVar;
            this.f1987b = oVar;
            this.f1988c = oVar2;
            this.f1989d = oVar3;
            this.f1990e = oVar4;
            this.f = (int) Math.min(oVar.a(), oVar2.a());
            this.g = (int) Math.max(oVar3.a(), oVar4.a());
            this.h = (int) Math.min(oVar.b(), oVar3.b());
            this.i = (int) Math.max(oVar2.b(), oVar4.b());
            return;
        }
        throw i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(c cVar) {
        this.f1986a = cVar.f1986a;
        this.f1987b = cVar.g();
        this.f1988c = cVar.a();
        this.f1989d = cVar.h();
        this.f1990e = cVar.b();
        this.f = cVar.e();
        this.g = cVar.c();
        this.h = cVar.f();
        this.i = cVar.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f1986a, cVar.f1987b, cVar.f1988c, cVar2.f1989d, cVar2.f1990e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o a() {
        return this.f1988c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b.c.b.w.d.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            b.c.b.o r0 = r12.f1987b
            b.c.b.o r1 = r12.f1988c
            b.c.b.o r2 = r12.f1989d
            b.c.b.o r3 = r12.f1990e
            if (r13 <= 0) goto L_0x0029
            if (r15 == 0) goto L_0x000e
            r4 = r0
            goto L_0x000f
        L_0x000e:
            r4 = r2
        L_0x000f:
            float r5 = r4.b()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x0018
            r5 = 0
        L_0x0018:
            b.c.b.o r13 = new b.c.b.o
            float r4 = r4.a()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0026
            r8 = r13
            goto L_0x002a
        L_0x0026:
            r10 = r13
            r8 = r0
            goto L_0x002b
        L_0x0029:
            r8 = r0
        L_0x002a:
            r10 = r2
        L_0x002b:
            if (r14 <= 0) goto L_0x005b
            if (r15 == 0) goto L_0x0032
            b.c.b.o r13 = r12.f1988c
            goto L_0x0034
        L_0x0032:
            b.c.b.o r13 = r12.f1990e
        L_0x0034:
            float r0 = r13.b()
            int r0 = (int) r0
            int r0 = r0 + r14
            b.c.b.r.b r14 = r12.f1986a
            int r14 = r14.c()
            if (r0 < r14) goto L_0x004a
            b.c.b.r.b r14 = r12.f1986a
            int r14 = r14.c()
            int r0 = r14 + (-1)
        L_0x004a:
            b.c.b.o r14 = new b.c.b.o
            float r13 = r13.a()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x0058
            r9 = r14
            goto L_0x005c
        L_0x0058:
            r11 = r14
            r9 = r1
            goto L_0x005d
        L_0x005b:
            r9 = r1
        L_0x005c:
            r11 = r3
        L_0x005d:
            b.c.b.w.d.c r13 = new b.c.b.w.d.c
            b.c.b.r.b r7 = r12.f1986a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.w.d.c.a(int, int, boolean):b.c.b.w.d.c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o b() {
        return this.f1990e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o g() {
        return this.f1987b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o h() {
        return this.f1989d;
    }
}
