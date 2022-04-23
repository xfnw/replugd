package d;

import d.f0.g.g;
import d.f0.g.j;
import d.f0.k.f;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements e {

    /* renamed from: b  reason: collision with root package name */
    final v f3709b;

    /* renamed from: c  reason: collision with root package name */
    final j f3710c;

    /* renamed from: d  reason: collision with root package name */
    final e.a f3711d = new a();

    /* renamed from: e  reason: collision with root package name */
    private p f3712e;
    final y f;
    final boolean g;
    private boolean h;

    /* loaded from: classes.dex */
    class a extends e.a {
        a() {
        }

        @Override // e.a
        protected void i() {
            x.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        private final f f3713c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x f3714d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.f3714d.f3712e.a(this.f3714d, interruptedIOException);
                    this.f3713c.a(this.f3714d, interruptedIOException);
                    this.f3714d.f3709b.i().a(this);
                }
            } catch (Throwable th) {
                this.f3714d.f3709b.i().a(this);
                throw th;
            }
        }

        @Override // d.f0.b
        protected void b() {
            IOException e2;
            a0 b2;
            this.f3714d.f3711d.g();
            boolean z = true;
            try {
                try {
                    b2 = this.f3714d.b();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f3714d.f3710c.b()) {
                        this.f3713c.a(this.f3714d, new IOException("Canceled"));
                    } else {
                        this.f3713c.a(this.f3714d, b2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    IOException a2 = this.f3714d.a(e2);
                    if (z) {
                        f d2 = f.d();
                        d2.a(4, "Callback failure for " + this.f3714d.e(), a2);
                    } else {
                        this.f3714d.f3712e.a(this.f3714d, a2);
                        this.f3713c.a(this.f3714d, a2);
                    }
                }
            } finally {
                this.f3714d.f3709b.i().a(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public x c() {
            return this.f3714d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String d() {
            return this.f3714d.f.g().g();
        }
    }

    private x(v vVar, y yVar, boolean z) {
        this.f3709b = vVar;
        this.f = yVar;
        this.g = z;
        this.f3710c = new j(vVar, z);
        this.f3711d.a(vVar.c(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.f3712e = vVar.k().a(xVar);
        return xVar;
    }

    private void f() {
        this.f3710c.a(f.d().a("response.body().close()"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOException a(IOException iOException) {
        if (!this.f3711d.h()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void a() {
        this.f3710c.a();
    }

    a0 b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3709b.p());
        arrayList.add(this.f3710c);
        arrayList.add(new d.f0.g.a(this.f3709b.h()));
        arrayList.add(new d.f0.e.a(this.f3709b.q()));
        arrayList.add(new d.f0.f.a(this.f3709b));
        if (!this.g) {
            arrayList.addAll(this.f3709b.r());
        }
        arrayList.add(new d.f0.g.b(this.g));
        return new g(arrayList, null, null, null, 0, this.f, this, this.f3712e, this.f3709b.e(), this.f3709b.x(), this.f3709b.B()).a(this.f);
    }

    public boolean c() {
        return this.f3710c.b();
    }

    public x clone() {
        return a(this.f3709b, this.f, this.g);
    }

    String d() {
        return this.f.g().l();
    }

    String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(c() ? "canceled " : "");
        sb.append(this.g ? "web socket" : "call");
        sb.append(" to ");
        sb.append(d());
        return sb.toString();
    }

    @Override // d.e
    public a0 m() {
        synchronized (this) {
            if (!this.h) {
                this.h = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        f();
        this.f3711d.g();
        this.f3712e.b(this);
        try {
            try {
                this.f3709b.i().a(this);
                a0 b2 = b();
                if (b2 != null) {
                    return b2;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                IOException a2 = a(e2);
                this.f3712e.a(this, a2);
                throw a2;
            }
        } finally {
            this.f3709b.i().b(this);
        }
    }
}
