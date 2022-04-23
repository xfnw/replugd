package d.f0.i;

import android.support.v4.media.session.PlaybackStateCompat;
import d.f0.i.c;
import d.r;
import e.e;
import e.s;
import e.t;
import e.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b  reason: collision with root package name */
    long f3584b;

    /* renamed from: c  reason: collision with root package name */
    final int f3585c;

    /* renamed from: d  reason: collision with root package name */
    final g f3586d;
    private c.a f;
    private boolean g;
    private final b h;
    final a i;

    /* renamed from: a  reason: collision with root package name */
    long f3583a = 0;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<r> f3587e = new ArrayDeque();
    final c j = new c();
    final c k = new c();
    d.f0.i.b l = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements s {

        /* renamed from: b  reason: collision with root package name */
        private final e.c f3588b = new e.c();

        /* renamed from: c  reason: collision with root package name */
        boolean f3589c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3590d;

        a() {
        }

        private void a(boolean z) {
            long min;
            synchronized (i.this) {
                i.this.k.g();
                while (i.this.f3584b <= 0 && !this.f3590d && !this.f3589c && i.this.l == null) {
                    i.this.k();
                }
                i.this.k.k();
                i.this.b();
                min = Math.min(i.this.f3584b, this.f3588b.r());
                i.this.f3584b -= min;
            }
            i.this.k.g();
            try {
                i.this.f3586d.a(i.this.f3585c, z && min == this.f3588b.r(), this.f3588b, min);
            } finally {
                i.this.k.k();
            }
        }

        @Override // e.s
        public void a(e.c cVar, long j) {
            this.f3588b.a(cVar, j);
            while (this.f3588b.r() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }

        @Override // e.s
        public u b() {
            return i.this.k;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (i.this) {
                if (!this.f3589c) {
                    if (!i.this.i.f3590d) {
                        if (this.f3588b.r() > 0) {
                            while (this.f3588b.r() > 0) {
                                a(true);
                            }
                        } else {
                            i iVar = i.this;
                            iVar.f3586d.a(iVar.f3585c, true, (e.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f3589c = true;
                    }
                    i.this.f3586d.flush();
                    i.this.a();
                }
            }
        }

        @Override // e.s, java.io.Flushable
        public void flush() {
            synchronized (i.this) {
                i.this.b();
            }
            while (this.f3588b.r() > 0) {
                a(false);
                i.this.f3586d.flush();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements t {

        /* renamed from: b  reason: collision with root package name */
        private final e.c f3592b = new e.c();

        /* renamed from: c  reason: collision with root package name */
        private final e.c f3593c = new e.c();

        /* renamed from: d  reason: collision with root package name */
        private final long f3594d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3595e;
        boolean f;

        b(long j) {
            this.f3594d = j;
        }

        private void a(long j) {
            i.this.f3586d.h(j);
        }

        void a(e eVar, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (i.this) {
                    z = this.f;
                    z2 = true;
                    z3 = this.f3593c.r() + j > this.f3594d;
                }
                if (z3) {
                    eVar.skip(j);
                    i.this.b(d.f0.i.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.skip(j);
                    return;
                } else {
                    long b2 = eVar.b(this.f3592b, j);
                    if (b2 != -1) {
                        j -= b2;
                        synchronized (i.this) {
                            if (this.f3593c.r() != 0) {
                                z2 = false;
                            }
                            this.f3593c.a(this.f3592b);
                            if (z2) {
                                i.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
            if (r11 == (-1)) goto L_0x00d1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
            a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
            if (r0 != null) goto L_0x00d4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d9, code lost:
            throw new d.f0.i.n(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // e.t
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long b(e.c r18, long r19) {
            /*
                Method dump skipped, instructions count: 263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: d.f0.i.i.b.b(e.c, long):long");
        }

        @Override // e.t
        public u b() {
            return i.this.j;
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long r;
            ArrayList<r> arrayList;
            c.a aVar;
            synchronized (i.this) {
                this.f3595e = true;
                r = this.f3593c.r();
                this.f3593c.n();
                arrayList = null;
                if (i.this.f3587e.isEmpty() || i.this.f == null) {
                    aVar = null;
                } else {
                    arrayList = new ArrayList(i.this.f3587e);
                    i.this.f3587e.clear();
                    aVar = i.this.f;
                }
                i.this.notifyAll();
            }
            if (r > 0) {
                a(r);
            }
            i.this.a();
            if (aVar != null) {
                for (r rVar : arrayList) {
                    aVar.a(rVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends e.a {
        c() {
        }

        @Override // e.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // e.a
        protected void i() {
            i.this.b(d.f0.i.b.CANCEL);
        }

        public void k() {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i, g gVar, boolean z, boolean z2, r rVar) {
        if (gVar != null) {
            this.f3585c = i;
            this.f3586d = gVar;
            this.f3584b = gVar.p.c();
            this.h = new b(gVar.o.c());
            this.i = new a();
            this.h.f = z2;
            this.i.f3590d = z;
            if (rVar != null) {
                this.f3587e.add(rVar);
            }
            if (f() && rVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!f() && rVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean d(d.f0.i.b bVar) {
        synchronized (this) {
            if (this.l != null) {
                return false;
            }
            if (this.h.f && this.i.f3590d) {
                return false;
            }
            this.l = bVar;
            notifyAll();
            this.f3586d.c(this.f3585c);
            return true;
        }
    }

    void a() {
        boolean z;
        boolean g;
        synchronized (this) {
            z = !this.h.f && this.h.f3595e && (this.i.f3590d || this.i.f3589c);
            g = g();
        }
        if (z) {
            a(d.f0.i.b.CANCEL);
        } else if (!g) {
            this.f3586d.c(this.f3585c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f3584b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void a(d.f0.i.b bVar) {
        if (d(bVar)) {
            this.f3586d.b(this.f3585c, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e eVar, int i) {
        this.h.a(eVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<d.f0.i.c> list) {
        boolean g;
        synchronized (this) {
            this.g = true;
            this.f3587e.add(d.f0.c.b(list));
            g = g();
            notifyAll();
        }
        if (!g) {
            this.f3586d.c(this.f3585c);
        }
    }

    void b() {
        a aVar = this.i;
        if (aVar.f3589c) {
            throw new IOException("stream closed");
        } else if (!aVar.f3590d) {
            d.f0.i.b bVar = this.l;
            if (bVar != null) {
                throw new n(bVar);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    public void b(d.f0.i.b bVar) {
        if (d(bVar)) {
            this.f3586d.c(this.f3585c, bVar);
        }
    }

    public int c() {
        return this.f3585c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(d.f0.i.b bVar) {
        if (this.l == null) {
            this.l = bVar;
            notifyAll();
        }
    }

    public s d() {
        synchronized (this) {
            if (!this.g && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.i;
    }

    public t e() {
        return this.h;
    }

    public boolean f() {
        return this.f3586d.f3537b == ((this.f3585c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.l != null) {
            return false;
        }
        if ((this.h.f || this.h.f3595e) && (this.i.f3590d || this.i.f3589c)) {
            if (this.g) {
                return false;
            }
        }
        return true;
    }

    public u h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean g;
        synchronized (this) {
            this.h.f = true;
            g = g();
            notifyAll();
        }
        if (!g) {
            this.f3586d.c(this.f3585c);
        }
    }

    public synchronized r j() {
        this.j.g();
        while (this.f3587e.isEmpty() && this.l == null) {
            k();
        }
        this.j.k();
        if (!this.f3587e.isEmpty()) {
        } else {
            throw new n(this.l);
        }
        return this.f3587e.removeFirst();
    }

    void k() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public u l() {
        return this.k;
    }
}
