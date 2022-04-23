package b.c.b.q;

import b.c.b.k;

/* loaded from: classes.dex */
public final class b implements k {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e A[LOOP:0: B:28:0x005c->B:29:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    @Override // b.c.b.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b.c.b.m a(b.c.b.c r13, java.util.Map<b.c.b.e, ?> r14) {
        /*
            r12 = this;
            b.c.b.q.d.a r0 = new b.c.b.q.d.a
            b.c.b.r.b r13 = r13.a()
            r0.<init>(r13)
            r13 = 0
            r1 = 0
            b.c.b.q.a r2 = r0.a(r13)     // Catch: f -> 0x0025, i -> 0x002b
            b.c.b.o[] r3 = r2.b()     // Catch: f -> 0x0025, i -> 0x002b
            b.c.b.q.c.a r4 = new b.c.b.q.c.a     // Catch: f -> 0x0021, i -> 0x0023
            r4.<init>()     // Catch: f -> 0x0021, i -> 0x0023
            b.c.b.r.e r2 = r4.a(r2)     // Catch: f -> 0x0021, i -> 0x0023
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x002f
        L_0x0021:
            r2 = move-exception
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
            r3 = r1
        L_0x0027:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r3 = r1
        L_0x002d:
            r4 = r3
            r3 = r1
        L_0x002f:
            if (r1 != 0) goto L_0x004e
            r1 = 1
            b.c.b.q.a r0 = r0.a(r1)     // Catch: f -> 0x0044, i -> 0x0046
            b.c.b.o[] r4 = r0.b()     // Catch: f -> 0x0044, i -> 0x0046
            b.c.b.q.c.a r1 = new b.c.b.q.c.a     // Catch: f -> 0x0044, i -> 0x0046
            r1.<init>()     // Catch: f -> 0x0044, i -> 0x0046
            b.c.b.r.e r1 = r1.a(r0)     // Catch: f -> 0x0044, i -> 0x0046
            goto L_0x004e
        L_0x0044:
            r13 = move-exception
            goto L_0x0047
        L_0x0046:
            r13 = move-exception
        L_0x0047:
            if (r2 != 0) goto L_0x004d
            if (r3 == 0) goto L_0x004c
            throw r3
        L_0x004c:
            throw r13
        L_0x004d:
            throw r2
        L_0x004e:
            r8 = r4
            if (r14 == 0) goto L_0x0066
            b.c.b.e r0 = b.c.b.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r14 = r14.get(r0)
            b.c.b.p r14 = (b.c.b.p) r14
            if (r14 == 0) goto L_0x0066
            int r0 = r8.length
        L_0x005c:
            if (r13 >= r0) goto L_0x0066
            r2 = r8[r13]
            r14.a(r2)
            int r13 = r13 + 1
            goto L_0x005c
        L_0x0066:
            b.c.b.m r13 = new b.c.b.m
            java.lang.String r5 = r1.h()
            byte[] r6 = r1.e()
            int r7 = r1.c()
            b.c.b.a r9 = b.c.b.a.AZTEC
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            java.util.List r14 = r1.a()
            if (r14 == 0) goto L_0x0089
            b.c.b.n r0 = b.c.b.n.BYTE_SEGMENTS
            r13.a(r0, r14)
        L_0x0089:
            java.lang.String r14 = r1.b()
            if (r14 == 0) goto L_0x0094
            b.c.b.n r0 = b.c.b.n.ERROR_CORRECTION_LEVEL
            r13.a(r0, r14)
        L_0x0094:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.q.b.a(b.c.b.c, java.util.Map):b.c.b.m");
    }

    @Override // b.c.b.k
    public void a() {
    }
}
