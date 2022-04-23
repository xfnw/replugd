package d.f0.h;

import android.support.v4.media.session.PlaybackStateCompat;
import d.a0;
import d.b0;
import d.f0.g.h;
import d.f0.g.k;
import d.r;
import d.v;
import d.y;
import e.i;
import e.l;
import e.s;
import e.t;
import e.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements d.f0.g.c {

    /* renamed from: a  reason: collision with root package name */
    final v f3488a;

    /* renamed from: b  reason: collision with root package name */
    final d.f0.f.g f3489b;

    /* renamed from: c  reason: collision with root package name */
    final e.e f3490c;

    /* renamed from: d  reason: collision with root package name */
    final e.d f3491d;

    /* renamed from: e  reason: collision with root package name */
    int f3492e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b implements t {

        /* renamed from: b  reason: collision with root package name */
        protected final i f3493b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f3494c;

        /* renamed from: d  reason: collision with root package name */
        protected long f3495d;

        private b() {
            this.f3493b = new i(a.this.f3490c.b());
            this.f3495d = 0L;
        }

        protected final void a(boolean z, IOException iOException) {
            a aVar = a.this;
            int i = aVar.f3492e;
            if (i != 6) {
                if (i == 5) {
                    aVar.a(this.f3493b);
                    a aVar2 = a.this;
                    aVar2.f3492e = 6;
                    d.f0.f.g gVar = aVar2.f3489b;
                    if (gVar != null) {
                        gVar.a(!z, aVar2, this.f3495d, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + a.this.f3492e);
            }
        }

        @Override // e.t
        public long b(e.c cVar, long j) {
            try {
                long b2 = a.this.f3490c.b(cVar, j);
                if (b2 > 0) {
                    this.f3495d += b2;
                }
                return b2;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        @Override // e.t
        public u b() {
            return this.f3493b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements s {

        /* renamed from: b  reason: collision with root package name */
        private final i f3497b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3498c;

        c() {
            this.f3497b = new i(a.this.f3491d.b());
        }

        @Override // e.s
        public void a(e.c cVar, long j) {
            if (this.f3498c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                a.this.f3491d.a(j);
                a.this.f3491d.a("\r\n");
                a.this.f3491d.a(cVar, j);
                a.this.f3491d.a("\r\n");
            }
        }

        @Override // e.s
        public u b() {
            return this.f3497b;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (!this.f3498c) {
                this.f3498c = true;
                a.this.f3491d.a("0\r\n\r\n");
                a.this.a(this.f3497b);
                a.this.f3492e = 3;
            }
        }

        @Override // e.s, java.io.Flushable
        public synchronized void flush() {
            if (!this.f3498c) {
                a.this.f3491d.flush();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends b {
        private final d.s f;
        private long g = -1;
        private boolean h = true;

        d(d.s sVar) {
            super();
            this.f = sVar;
        }

        private void d() {
            if (this.g != -1) {
                a.this.f3490c.f();
            }
            try {
                this.g = a.this.f3490c.k();
                String trim = a.this.f3490c.f().trim();
                if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    d.f0.g.e.a(a.this.f3488a.h(), this.f, a.this.e());
                    a(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // d.f0.h.a.b, e.t
        public long b(e.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3494c) {
                throw new IllegalStateException("closed");
            } else if (!this.h) {
                return -1L;
            } else {
                long j2 = this.g;
                if (j2 == 0 || j2 == -1) {
                    d();
                    if (!this.h) {
                        return -1L;
                    }
                }
                long b2 = super.b(cVar, Math.min(j, this.g));
                if (b2 != -1) {
                    this.g -= b2;
                    return b2;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f3494c) {
                if (this.h && !d.f0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f3494c = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e implements s {

        /* renamed from: b  reason: collision with root package name */
        private final i f3500b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3501c;

        /* renamed from: d  reason: collision with root package name */
        private long f3502d;

        e(long j) {
            this.f3500b = new i(a.this.f3491d.b());
            this.f3502d = j;
        }

        @Override // e.s
        public void a(e.c cVar, long j) {
            if (!this.f3501c) {
                d.f0.c.a(cVar.r(), 0L, j);
                if (j <= this.f3502d) {
                    a.this.f3491d.a(cVar, j);
                    this.f3502d -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f3502d + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // e.s
        public u b() {
            return this.f3500b;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f3501c) {
                this.f3501c = true;
                if (this.f3502d <= 0) {
                    a.this.a(this.f3500b);
                    a.this.f3492e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        @Override // e.s, java.io.Flushable
        public void flush() {
            if (!this.f3501c) {
                a.this.f3491d.flush();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends b {
        private long f;

        f(a aVar, long j) {
            super();
            this.f = j;
            if (this.f == 0) {
                a(true, null);
            }
        }

        @Override // d.f0.h.a.b, e.t
        public long b(e.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.f3494c) {
                long j2 = this.f;
                if (j2 == 0) {
                    return -1L;
                }
                long b2 = super.b(cVar, Math.min(j2, j));
                if (b2 != -1) {
                    this.f -= b2;
                    if (this.f == 0) {
                        a(true, null);
                    }
                    return b2;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f3494c) {
                if (this.f != 0 && !d.f0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f3494c = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends b {
        private boolean f;

        g(a aVar) {
            super();
        }

        @Override // d.f0.h.a.b, e.t
        public long b(e.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f3494c) {
                throw new IllegalStateException("closed");
            } else if (this.f) {
                return -1L;
            } else {
                long b2 = super.b(cVar, j);
                if (b2 != -1) {
                    return b2;
                }
                this.f = true;
                a(true, null);
                return -1L;
            }
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f3494c) {
                if (!this.f) {
                    a(false, null);
                }
                this.f3494c = true;
            }
        }
    }

    public a(v vVar, d.f0.f.g gVar, e.e eVar, e.d dVar) {
        this.f3488a = vVar;
        this.f3489b = gVar;
        this.f3490c = eVar;
        this.f3491d = dVar;
    }

    private String f() {
        String c2 = this.f3490c.c(this.f);
        this.f -= c2.length();
        return c2;
    }

    @Override // d.f0.g.c
    public a0.a a(boolean z) {
        int i = this.f3492e;
        if (i == 1 || i == 3) {
            try {
                k a2 = k.a(f());
                a0.a aVar = new a0.a();
                aVar.a(a2.f3485a);
                aVar.a(a2.f3486b);
                aVar.a(a2.f3487c);
                aVar.a(e());
                if (z && a2.f3486b == 100) {
                    return null;
                }
                if (a2.f3486b == 100) {
                    this.f3492e = 3;
                    return aVar;
                }
                this.f3492e = 4;
                return aVar;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f3489b);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f3492e);
        }
    }

    @Override // d.f0.g.c
    public b0 a(a0 a0Var) {
        d.f0.f.g gVar = this.f3489b;
        gVar.f.e(gVar.f3466e);
        String b2 = a0Var.b("Content-Type");
        if (!d.f0.g.e.b(a0Var)) {
            return new h(b2, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding"))) {
            return new h(b2, -1L, l.a(a(a0Var.z().g())));
        }
        long a2 = d.f0.g.e.a(a0Var);
        return a2 != -1 ? new h(b2, a2, l.a(b(a2))) : new h(b2, -1L, l.a(d()));
    }

    public s a(long j) {
        if (this.f3492e == 1) {
            this.f3492e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f3492e);
    }

    @Override // d.f0.g.c
    public s a(y yVar, long j) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return c();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public t a(d.s sVar) {
        if (this.f3492e == 4) {
            this.f3492e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f3492e);
    }

    @Override // d.f0.g.c
    public void a() {
        this.f3491d.flush();
    }

    public void a(r rVar, String str) {
        if (this.f3492e == 0) {
            this.f3491d.a(str).a("\r\n");
            int b2 = rVar.b();
            for (int i = 0; i < b2; i++) {
                this.f3491d.a(rVar.a(i)).a(": ").a(rVar.b(i)).a("\r\n");
            }
            this.f3491d.a("\r\n");
            this.f3492e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f3492e);
    }

    @Override // d.f0.g.c
    public void a(y yVar) {
        a(yVar.c(), d.f0.g.i.a(yVar, this.f3489b.c().d().b().type()));
    }

    void a(i iVar) {
        u g2 = iVar.g();
        iVar.a(u.f3775d);
        g2.a();
        g2.b();
    }

    public t b(long j) {
        if (this.f3492e == 4) {
            this.f3492e = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.f3492e);
    }

    @Override // d.f0.g.c
    public void b() {
        this.f3491d.flush();
    }

    public s c() {
        if (this.f3492e == 1) {
            this.f3492e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f3492e);
    }

    @Override // d.f0.g.c
    public void cancel() {
        d.f0.f.c c2 = this.f3489b.c();
        if (c2 != null) {
            c2.a();
        }
    }

    public t d() {
        if (this.f3492e == 4) {
            d.f0.f.g gVar = this.f3489b;
            if (gVar != null) {
                this.f3492e = 5;
                gVar.e();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f3492e);
    }

    public r e() {
        r.a aVar = new r.a();
        while (true) {
            String f2 = f();
            if (f2.length() == 0) {
                return aVar.a();
            }
            d.f0.a.f3401a.a(aVar, f2);
        }
    }
}
