package d;

import d.r;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class a0 implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    final y f3351b;

    /* renamed from: c  reason: collision with root package name */
    final w f3352c;

    /* renamed from: d  reason: collision with root package name */
    final int f3353d;

    /* renamed from: e  reason: collision with root package name */
    final String f3354e;
    final q f;
    final r g;
    final b0 h;
    final a0 i;
    final a0 j;
    final a0 k;
    final long l;
    final long m;
    private volatile d n;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        y f3355a;

        /* renamed from: b  reason: collision with root package name */
        w f3356b;

        /* renamed from: c  reason: collision with root package name */
        int f3357c;

        /* renamed from: d  reason: collision with root package name */
        String f3358d;

        /* renamed from: e  reason: collision with root package name */
        q f3359e;
        r.a f;
        b0 g;
        a0 h;
        a0 i;
        a0 j;
        long k;
        long l;

        public a() {
            this.f3357c = -1;
            this.f = new r.a();
        }

        a(a0 a0Var) {
            this.f3357c = -1;
            this.f3355a = a0Var.f3351b;
            this.f3356b = a0Var.f3352c;
            this.f3357c = a0Var.f3353d;
            this.f3358d = a0Var.f3354e;
            this.f3359e = a0Var.f;
            this.f = a0Var.g.a();
            this.g = a0Var.h;
            this.h = a0Var.i;
            this.i = a0Var.j;
            this.j = a0Var.k;
            this.k = a0Var.l;
            this.l = a0Var.m;
        }

        private void a(String str, a0 a0Var) {
            if (a0Var.h != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (a0Var.i != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (a0Var.j != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (a0Var.k != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private void d(a0 a0Var) {
            if (a0Var.h != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i) {
            this.f3357c = i;
            return this;
        }

        public a a(long j) {
            this.l = j;
            return this;
        }

        public a a(a0 a0Var) {
            if (a0Var != null) {
                a("cacheResponse", a0Var);
            }
            this.i = a0Var;
            return this;
        }

        public a a(b0 b0Var) {
            this.g = b0Var;
            return this;
        }

        public a a(q qVar) {
            this.f3359e = qVar;
            return this;
        }

        public a a(r rVar) {
            this.f = rVar.a();
            return this;
        }

        public a a(w wVar) {
            this.f3356b = wVar;
            return this;
        }

        public a a(y yVar) {
            this.f3355a = yVar;
            return this;
        }

        public a a(String str) {
            this.f3358d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a0 a() {
            if (this.f3355a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f3356b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f3357c < 0) {
                throw new IllegalStateException("code < 0: " + this.f3357c);
            } else if (this.f3358d != null) {
                return new a0(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a b(a0 a0Var) {
            if (a0Var != null) {
                a("networkResponse", a0Var);
            }
            this.h = a0Var;
            return this;
        }

        public a b(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        public a c(a0 a0Var) {
            if (a0Var != null) {
                d(a0Var);
            }
            this.j = a0Var;
            return this;
        }
    }

    a0(a aVar) {
        this.f3351b = aVar.f3355a;
        this.f3352c = aVar.f3356b;
        this.f3353d = aVar.f3357c;
        this.f3354e = aVar.f3358d;
        this.f = aVar.f3359e;
        this.g = aVar.f.a();
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
    }

    public long A() {
        return this.l;
    }

    public String a(String str, String str2) {
        String a2 = this.g.a(str);
        return a2 != null ? a2 : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0 b0Var = this.h;
        if (b0Var != null) {
            b0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public b0 m() {
        return this.h;
    }

    public d n() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.g);
        this.n = a2;
        return a2;
    }

    public a0 o() {
        return this.j;
    }

    public int p() {
        return this.f3353d;
    }

    public q q() {
        return this.f;
    }

    public r r() {
        return this.g;
    }

    public boolean s() {
        int i = this.f3353d;
        return i >= 200 && i < 300;
    }

    public String t() {
        return this.f3354e;
    }

    public String toString() {
        return "Response{protocol=" + this.f3352c + ", code=" + this.f3353d + ", message=" + this.f3354e + ", url=" + this.f3351b.g() + '}';
    }

    public a0 u() {
        return this.i;
    }

    public a v() {
        return new a(this);
    }

    public a0 w() {
        return this.k;
    }

    public w x() {
        return this.f3352c;
    }

    public long y() {
        return this.m;
    }

    public y z() {
        return this.f3351b;
    }
}
