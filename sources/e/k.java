package e;

import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class k implements t {

    /* renamed from: b  reason: collision with root package name */
    private final e f3750b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f3751c;

    /* renamed from: d  reason: collision with root package name */
    private int f3752d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3753e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f3750b = eVar;
            this.f3751c = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    private void m() {
        int i = this.f3752d;
        if (i != 0) {
            int remaining = i - this.f3751c.getRemaining();
            this.f3752d -= remaining;
            this.f3750b.skip(remaining);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r1.f3769b != r1.f3770c) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        r7.f3736b = r1.b();
        e.q.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return -1;
     */
    @Override // e.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b(e.c r7, long r8) {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x007a
            boolean r2 = r6.f3753e
            if (r2 != 0) goto L_0x0072
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x000f:
            boolean r0 = r6.d()
            r1 = 1
            e.p r1 = r7.b(r1)     // Catch: DataFormatException -> 0x006b
            int r2 = r1.f3770c     // Catch: DataFormatException -> 0x006b
            int r2 = 8192 - r2
            long r2 = (long) r2     // Catch: DataFormatException -> 0x006b
            long r2 = java.lang.Math.min(r8, r2)     // Catch: DataFormatException -> 0x006b
            int r3 = (int) r2     // Catch: DataFormatException -> 0x006b
            java.util.zip.Inflater r2 = r6.f3751c     // Catch: DataFormatException -> 0x006b
            byte[] r4 = r1.f3768a     // Catch: DataFormatException -> 0x006b
            int r5 = r1.f3770c     // Catch: DataFormatException -> 0x006b
            int r2 = r2.inflate(r4, r5, r3)     // Catch: DataFormatException -> 0x006b
            if (r2 <= 0) goto L_0x003a
            int r8 = r1.f3770c     // Catch: DataFormatException -> 0x006b
            int r8 = r8 + r2
            r1.f3770c = r8     // Catch: DataFormatException -> 0x006b
            long r8 = r7.f3737c     // Catch: DataFormatException -> 0x006b
            long r0 = (long) r2     // Catch: DataFormatException -> 0x006b
            long r8 = r8 + r0
            r7.f3737c = r8     // Catch: DataFormatException -> 0x006b
            return r0
        L_0x003a:
            java.util.zip.Inflater r2 = r6.f3751c     // Catch: DataFormatException -> 0x006b
            boolean r2 = r2.finished()     // Catch: DataFormatException -> 0x006b
            if (r2 != 0) goto L_0x0056
            java.util.zip.Inflater r2 = r6.f3751c     // Catch: DataFormatException -> 0x006b
            boolean r2 = r2.needsDictionary()     // Catch: DataFormatException -> 0x006b
            if (r2 == 0) goto L_0x004b
            goto L_0x0056
        L_0x004b:
            if (r0 != 0) goto L_0x004e
            goto L_0x000f
        L_0x004e:
            java.io.EOFException r7 = new java.io.EOFException     // Catch: DataFormatException -> 0x006b
            java.lang.String r8 = "source exhausted prematurely"
            r7.<init>(r8)     // Catch: DataFormatException -> 0x006b
            throw r7     // Catch: DataFormatException -> 0x006b
        L_0x0056:
            r6.m()     // Catch: DataFormatException -> 0x006b
            int r8 = r1.f3769b     // Catch: DataFormatException -> 0x006b
            int r9 = r1.f3770c     // Catch: DataFormatException -> 0x006b
            if (r8 != r9) goto L_0x0068
            e.p r8 = r1.b()     // Catch: DataFormatException -> 0x006b
            r7.f3736b = r8     // Catch: DataFormatException -> 0x006b
            e.q.a(r1)     // Catch: DataFormatException -> 0x006b
        L_0x0068:
            r7 = -1
            return r7
        L_0x006b:
            r7 = move-exception
            java.io.IOException r8 = new java.io.IOException
            r8.<init>(r7)
            throw r8
        L_0x0072:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "closed"
            r7.<init>(r8)
            throw r7
        L_0x007a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "byteCount < 0: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            goto L_0x0092
        L_0x0091:
            throw r7
        L_0x0092:
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: e.k.b(e.c, long):long");
    }

    @Override // e.t
    public u b() {
        return this.f3750b.b();
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3753e) {
            this.f3751c.end();
            this.f3753e = true;
            this.f3750b.close();
        }
    }

    public final boolean d() {
        if (!this.f3751c.needsInput()) {
            return false;
        }
        m();
        if (this.f3751c.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f3750b.j()) {
            return true;
        } else {
            p pVar = this.f3750b.a().f3736b;
            int i = pVar.f3770c;
            int i2 = pVar.f3769b;
            this.f3752d = i - i2;
            this.f3751c.setInput(pVar.f3768a, i2, this.f3752d);
            return false;
        }
    }
}
