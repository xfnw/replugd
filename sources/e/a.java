package e;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a extends u {
    private static final long h = TimeUnit.SECONDS.toMillis(60);
    private static final long i = TimeUnit.MILLISECONDS.toNanos(h);
    static a j;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3729e;
    private a f;
    private long g;

    /* renamed from: e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0102a implements s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f3730b;

        C0102a(s sVar) {
            this.f3730b = sVar;
        }

        @Override // e.s
        public void a(e.c cVar, long j) {
            v.a(cVar.f3737c, 0L, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    p pVar = cVar.f3736b;
                    while (true) {
                        if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j2 += pVar.f3770c - pVar.f3769b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        pVar = pVar.f;
                    }
                    boolean z = false;
                    a.this.g();
                    try {
                        try {
                            this.f3730b.a(cVar, j2);
                            j -= j2;
                            z = true;
                        } catch (IOException e2) {
                            throw a.this.a(e2);
                        }
                    } finally {
                        a.this.a(z);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // e.s
        public u b() {
            return a.this;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.g();
            try {
                try {
                    this.f3730b.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // e.s, java.io.Flushable
        public void flush() {
            a.this.g();
            try {
                try {
                    this.f3730b.flush();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f3730b + ")";
        }
    }

    /* loaded from: classes.dex */
    class b implements t {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f3732b;

        b(t tVar) {
            this.f3732b = tVar;
        }

        @Override // e.t
        public long b(e.c cVar, long j) {
            a.this.g();
            try {
                try {
                    long b2 = this.f3732b.b(cVar, j);
                    a.this.a(true);
                    return b2;
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // e.t
        public u b() {
            return a.this;
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a.this.g();
            try {
                try {
                    this.f3732b.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f3732b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<e.a> r0 = e.a.class
                monitor-enter(r0)     // Catch: InterruptedException -> 0x0000
                e.a r1 = e.a.j()     // Catch: all -> 0x0019
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch: all -> 0x0019
                goto L_0x0000
            L_0x000b:
                e.a r2 = e.a.j     // Catch: all -> 0x0019
                if (r1 != r2) goto L_0x0014
                r1 = 0
                e.a.j = r1     // Catch: all -> 0x0019
                monitor-exit(r0)     // Catch: all -> 0x0019
                return
            L_0x0014:
                monitor-exit(r0)     // Catch: all -> 0x0019
                r1.i()     // Catch: InterruptedException -> 0x0000
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch: all -> 0x0019
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: e.a.c.run():void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005e A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0016, B:10:0x0022, B:11:0x002b, B:16:0x0036, B:17:0x003c, B:18:0x0042, B:20:0x0046, B:23:0x0051, B:24:0x0054, B:26:0x005e, B:29:0x0063, B:30:0x0068), top: B:33:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void a(e.a r6, long r7, boolean r9) {
        /*
            java.lang.Class<e.a> r0 = e.a.class
            monitor-enter(r0)
            e.a r1 = e.a.j     // Catch: all -> 0x0069
            if (r1 != 0) goto L_0x0016
            e.a r1 = new e.a     // Catch: all -> 0x0069
            r1.<init>()     // Catch: all -> 0x0069
            e.a.j = r1     // Catch: all -> 0x0069
            e.a$c r1 = new e.a$c     // Catch: all -> 0x0069
            r1.<init>()     // Catch: all -> 0x0069
            r1.start()     // Catch: all -> 0x0069
        L_0x0016:
            long r1 = java.lang.System.nanoTime()     // Catch: all -> 0x0069
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x002f
            long r3 = r6.c()     // Catch: all -> 0x0069
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: all -> 0x0069
        L_0x002b:
            long r7 = r7 + r1
            r6.g = r7     // Catch: all -> 0x0069
            goto L_0x003c
        L_0x002f:
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            if (r9 == 0) goto L_0x0063
            long r7 = r6.c()     // Catch: all -> 0x0069
            r6.g = r7     // Catch: all -> 0x0069
        L_0x003c:
            long r7 = r6.b(r1)     // Catch: all -> 0x0069
            e.a r9 = e.a.j     // Catch: all -> 0x0069
        L_0x0042:
            e.a r3 = r9.f     // Catch: all -> 0x0069
            if (r3 == 0) goto L_0x0054
            e.a r3 = r9.f     // Catch: all -> 0x0069
            long r3 = r3.b(r1)     // Catch: all -> 0x0069
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            e.a r9 = r9.f     // Catch: all -> 0x0069
            goto L_0x0042
        L_0x0054:
            e.a r7 = r9.f     // Catch: all -> 0x0069
            r6.f = r7     // Catch: all -> 0x0069
            r9.f = r6     // Catch: all -> 0x0069
            e.a r6 = e.a.j     // Catch: all -> 0x0069
            if (r9 != r6) goto L_0x0061
            r0.notify()     // Catch: all -> 0x0069
        L_0x0061:
            monitor-exit(r0)
            return
        L_0x0063:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: all -> 0x0069
            r6.<init>()     // Catch: all -> 0x0069
            throw r6     // Catch: all -> 0x0069
        L_0x0069:
            r6 = move-exception
            monitor-exit(r0)
            goto L_0x006d
        L_0x006c:
            throw r6
        L_0x006d:
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a(e.a, long, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1.f = r3.f;
        r3.f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized boolean a(e.a r3) {
        /*
            java.lang.Class<e.a> r0 = e.a.class
            monitor-enter(r0)
            e.a r1 = e.a.j     // Catch: all -> 0x001a
        L_0x0005:
            if (r1 == 0) goto L_0x0018
            e.a r2 = r1.f     // Catch: all -> 0x001a
            if (r2 != r3) goto L_0x0015
            e.a r2 = r3.f     // Catch: all -> 0x001a
            r1.f = r2     // Catch: all -> 0x001a
            r1 = 0
            r3.f = r1     // Catch: all -> 0x001a
            r3 = 0
        L_0x0013:
            monitor-exit(r0)
            return r3
        L_0x0015:
            e.a r1 = r1.f     // Catch: all -> 0x001a
            goto L_0x0005
        L_0x0018:
            r3 = 1
            goto L_0x0013
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)
            goto L_0x001e
        L_0x001d:
            throw r3
        L_0x001e:
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a(e.a):boolean");
    }

    private long b(long j2) {
        return this.g - j2;
    }

    static a j() {
        a aVar = j.f;
        long nanoTime = System.nanoTime();
        if (aVar == null) {
            a.class.wait(h);
            if (j.f != null || System.nanoTime() - nanoTime < i) {
                return null;
            }
            return j;
        }
        long b2 = aVar.b(nanoTime);
        if (b2 > 0) {
            long j2 = b2 / 1000000;
            a.class.wait(j2, (int) (b2 - (1000000 * j2)));
            return null;
        }
        j.f = aVar.f;
        aVar.f = null;
        return aVar;
    }

    public final s a(s sVar) {
        return new C0102a(sVar);
    }

    public final t a(t tVar) {
        return new b(tVar);
    }

    final IOException a(IOException iOException) {
        return !h() ? iOException : b(iOException);
    }

    final void a(boolean z) {
        if (h() && z) {
            throw b((IOException) null);
        }
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void g() {
        if (!this.f3729e) {
            long f = f();
            boolean d2 = d();
            if (f != 0 || d2) {
                this.f3729e = true;
                a(this, f, d2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean h() {
        if (!this.f3729e) {
            return false;
        }
        this.f3729e = false;
        return a(this);
    }

    protected void i() {
    }
}
