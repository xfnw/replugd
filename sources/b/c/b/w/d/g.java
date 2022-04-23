package b.c.b.w.d;

import java.util.Formatter;

/* loaded from: classes.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private final c f2008a;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f2009b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f2008a = new c(cVar);
        this.f2009b = new d[(cVar.d() - cVar.f()) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a() {
        return this.f2008a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d a(int i) {
        return this.f2009b[c(i)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, d dVar) {
        this.f2009b[c(i)] = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d b(int i) {
        d dVar;
        d dVar2;
        d a2 = a(i);
        if (a2 != null) {
            return a2;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int c2 = c(i) - i2;
            if (c2 >= 0 && (dVar2 = this.f2009b[c2]) != null) {
                return dVar2;
            }
            int c3 = c(i) + i2;
            d[] dVarArr = this.f2009b;
            if (c3 < dVarArr.length && (dVar = dVarArr[c3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d[] b() {
        return this.f2009b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(int i) {
        return i - this.f2008a.f();
    }

    public String toString() {
        d[] dVarArr;
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (d dVar : this.f2009b) {
                if (dVar == null) {
                    i++;
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                } else {
                    i++;
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
