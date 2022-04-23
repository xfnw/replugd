package d;

import d.a0;
import d.f0.e.d;
import d.f0.e.f;
import d.f0.g.k;
import d.r;
import d.y;
import e.e;
import e.g;
import e.h;
import e.l;
import e.s;
import e.t;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    final f f3363b;

    /* renamed from: c  reason: collision with root package name */
    final d.f0.e.d f3364c;

    /* renamed from: d  reason: collision with root package name */
    int f3365d;

    /* renamed from: e  reason: collision with root package name */
    int f3366e;
    private int f;
    private int g;
    private int h;

    /* loaded from: classes.dex */
    class a implements f {
        a() {
        }

        @Override // d.f0.e.f
        public a0 a(y yVar) {
            return c.this.a(yVar);
        }

        @Override // d.f0.e.f
        public d.f0.e.b a(a0 a0Var) {
            return c.this.a(a0Var);
        }

        @Override // d.f0.e.f
        public void a() {
            c.this.m();
        }

        @Override // d.f0.e.f
        public void a(a0 a0Var, a0 a0Var2) {
            c.this.a(a0Var, a0Var2);
        }

        @Override // d.f0.e.f
        public void a(d.f0.e.c cVar) {
            c.this.a(cVar);
        }

        @Override // d.f0.e.f
        public void b(y yVar) {
            c.this.b(yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements d.f0.e.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f3368a;

        /* renamed from: b  reason: collision with root package name */
        private s f3369b;

        /* renamed from: c  reason: collision with root package name */
        private s f3370c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3371d;

        /* loaded from: classes.dex */
        class a extends g {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.c f3373c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(s sVar, c cVar, d.c cVar2) {
                super(sVar);
                this.f3373c = cVar2;
            }

            @Override // e.g, e.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                synchronized (c.this) {
                    if (!b.this.f3371d) {
                        b.this.f3371d = true;
                        c.this.f3365d++;
                        super.close();
                        this.f3373c.b();
                    }
                }
            }
        }

        b(d.c cVar) {
            this.f3368a = cVar;
            this.f3369b = cVar.a(1);
            this.f3370c = new a(this.f3369b, c.this, cVar);
        }

        @Override // d.f0.e.b
        public void a() {
            synchronized (c.this) {
                if (!this.f3371d) {
                    this.f3371d = true;
                    c.this.f3366e++;
                    d.f0.c.a(this.f3369b);
                    try {
                        this.f3368a.a();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        @Override // d.f0.e.b
        public s b() {
            return this.f3370c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0095c extends b0 {

        /* renamed from: b  reason: collision with root package name */
        final d.e f3375b;

        /* renamed from: c  reason: collision with root package name */
        private final e f3376c;

        /* renamed from: d  reason: collision with root package name */
        private final String f3377d;

        /* renamed from: d.c$c$a */
        /* loaded from: classes.dex */
        class a extends h {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.e f3378c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C0095c cVar, t tVar, d.e eVar) {
                super(tVar);
                this.f3378c = eVar;
            }

            @Override // e.h, e.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.f3378c.close();
                super.close();
            }
        }

        C0095c(d.e eVar, String str, String str2) {
            this.f3375b = eVar;
            this.f3377d = str2;
            this.f3376c = l.a(new a(this, eVar.a(1), eVar));
        }

        @Override // d.b0
        public long m() {
            try {
                if (this.f3377d != null) {
                    return Long.parseLong(this.f3377d);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // d.b0
        public e n() {
            return this.f3376c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {
        private static final String k = d.f0.k.f.d().a() + "-Sent-Millis";
        private static final String l = d.f0.k.f.d().a() + "-Received-Millis";

        /* renamed from: a  reason: collision with root package name */
        private final String f3379a;

        /* renamed from: b  reason: collision with root package name */
        private final r f3380b;

        /* renamed from: c  reason: collision with root package name */
        private final String f3381c;

        /* renamed from: d  reason: collision with root package name */
        private final w f3382d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3383e;
        private final String f;
        private final r g;
        private final q h;
        private final long i;
        private final long j;

        d(a0 a0Var) {
            this.f3379a = a0Var.z().g().toString();
            this.f3380b = d.f0.g.e.e(a0Var);
            this.f3381c = a0Var.z().e();
            this.f3382d = a0Var.x();
            this.f3383e = a0Var.p();
            this.f = a0Var.t();
            this.g = a0Var.r();
            this.h = a0Var.q();
            this.i = a0Var.A();
            this.j = a0Var.y();
        }

        d(t tVar) {
            try {
                e a2 = l.a(tVar);
                this.f3379a = a2.f();
                this.f3381c = a2.f();
                r.a aVar = new r.a();
                int a3 = c.a(a2);
                for (int i = 0; i < a3; i++) {
                    aVar.a(a2.f());
                }
                this.f3380b = aVar.a();
                k a4 = k.a(a2.f());
                this.f3382d = a4.f3485a;
                this.f3383e = a4.f3486b;
                this.f = a4.f3487c;
                r.a aVar2 = new r.a();
                int a5 = c.a(a2);
                for (int i2 = 0; i2 < a5; i2++) {
                    aVar2.a(a2.f());
                }
                String b2 = aVar2.b(k);
                String b3 = aVar2.b(l);
                aVar2.c(k);
                aVar2.c(l);
                long j = 0;
                this.i = b2 != null ? Long.parseLong(b2) : 0L;
                this.j = b3 != null ? Long.parseLong(b3) : j;
                this.g = aVar2.a();
                if (a()) {
                    String f = a2.f();
                    if (f.length() <= 0) {
                        this.h = q.a(!a2.j() ? d0.a(a2.f()) : d0.SSL_3_0, h.a(a2.f()), a(a2), a(a2));
                    } else {
                        throw new IOException("expected \"\" but was \"" + f + "\"");
                    }
                } else {
                    this.h = null;
                }
            } finally {
                tVar.close();
            }
        }

        private List<Certificate> a(e eVar) {
            int a2 = c.a(eVar);
            if (a2 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a2);
                for (int i = 0; i < a2; i++) {
                    String f = eVar.f();
                    e.c cVar = new e.c();
                    cVar.c(e.f.a(f));
                    arrayList.add(instance.generateCertificate(cVar.l()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void a(e.d dVar, List<Certificate> list) {
            try {
                dVar.f(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.a(e.f.a(list.get(i).getEncoded()).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private boolean a() {
            return this.f3379a.startsWith("https://");
        }

        public a0 a(d.e eVar) {
            String a2 = this.g.a("Content-Type");
            String a3 = this.g.a("Content-Length");
            y.a aVar = new y.a();
            aVar.b(this.f3379a);
            aVar.a(this.f3381c, (z) null);
            aVar.a(this.f3380b);
            y a4 = aVar.a();
            a0.a aVar2 = new a0.a();
            aVar2.a(a4);
            aVar2.a(this.f3382d);
            aVar2.a(this.f3383e);
            aVar2.a(this.f);
            aVar2.a(this.g);
            aVar2.a(new C0095c(eVar, a2, a3));
            aVar2.a(this.h);
            aVar2.b(this.i);
            aVar2.a(this.j);
            return aVar2.a();
        }

        public void a(d.c cVar) {
            e.d a2 = l.a(cVar.a(0));
            a2.a(this.f3379a).writeByte(10);
            a2.a(this.f3381c).writeByte(10);
            a2.f(this.f3380b.b()).writeByte(10);
            int b2 = this.f3380b.b();
            for (int i = 0; i < b2; i++) {
                a2.a(this.f3380b.a(i)).a(": ").a(this.f3380b.b(i)).writeByte(10);
            }
            a2.a(new k(this.f3382d, this.f3383e, this.f).toString()).writeByte(10);
            a2.f(this.g.b() + 2).writeByte(10);
            int b3 = this.g.b();
            for (int i2 = 0; i2 < b3; i2++) {
                a2.a(this.g.a(i2)).a(": ").a(this.g.b(i2)).writeByte(10);
            }
            a2.a(k).a(": ").f(this.i).writeByte(10);
            a2.a(l).a(": ").f(this.j).writeByte(10);
            if (a()) {
                a2.writeByte(10);
                a2.a(this.h.a().a()).writeByte(10);
                a(a2, this.h.c());
                a(a2, this.h.b());
                a2.a(this.h.d().a()).writeByte(10);
            }
            a2.close();
        }

        public boolean a(y yVar, a0 a0Var) {
            return this.f3379a.equals(yVar.g().toString()) && this.f3381c.equals(yVar.e()) && d.f0.g.e.a(a0Var, this.f3380b, yVar);
        }
    }

    public c(File file, long j) {
        this(file, j, d.f0.j.a.f3611a);
    }

    c(File file, long j, d.f0.j.a aVar) {
        this.f3363b = new a();
        this.f3364c = d.f0.e.d.a(aVar, file, 201105, 2, j);
    }

    static int a(e eVar) {
        try {
            long e2 = eVar.e();
            String f = eVar.f();
            if (e2 >= 0 && e2 <= 2147483647L && f.isEmpty()) {
                return (int) e2;
            }
            throw new IOException("expected an int but was \"" + e2 + f + "\"");
        } catch (NumberFormatException e3) {
            throw new IOException(e3.getMessage());
        }
    }

    public static String a(s sVar) {
        return e.f.d(sVar.toString()).d().b();
    }

    private void a(d.c cVar) {
        if (cVar != null) {
            try {
                cVar.a();
            } catch (IOException unused) {
            }
        }
    }

    a0 a(y yVar) {
        try {
            d.e c2 = this.f3364c.c(a(yVar.g()));
            if (c2 == null) {
                return null;
            }
            try {
                d dVar = new d(c2.a(0));
                a0 a2 = dVar.a(c2);
                if (dVar.a(yVar, a2)) {
                    return a2;
                }
                d.f0.c.a(a2.m());
                return null;
            } catch (IOException unused) {
                d.f0.c.a(c2);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    d.f0.e.b a(a0 a0Var) {
        d.c cVar;
        String e2 = a0Var.z().e();
        if (d.f0.g.f.a(a0Var.z().e())) {
            try {
                b(a0Var.z());
            } catch (IOException unused) {
            }
            return null;
        } else if (!e2.equals("GET") || d.f0.g.e.c(a0Var)) {
            return null;
        } else {
            d dVar = new d(a0Var);
            try {
                cVar = this.f3364c.b(a(a0Var.z().g()));
                if (cVar == null) {
                    return null;
                }
                try {
                    dVar.a(cVar);
                    return new b(cVar);
                } catch (IOException unused2) {
                    a(cVar);
                    return null;
                }
            } catch (IOException unused3) {
                cVar = null;
            }
        }
    }

    void a(a0 a0Var, a0 a0Var2) {
        d.c cVar;
        d dVar = new d(a0Var2);
        try {
            cVar = ((C0095c) a0Var.m()).f3375b.m();
            if (cVar != null) {
                try {
                    dVar.a(cVar);
                    cVar.b();
                } catch (IOException unused) {
                    a(cVar);
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        }
    }

    synchronized void a(d.f0.e.c cVar) {
        this.h++;
        if (cVar.f3415a != null) {
            this.f++;
        } else if (cVar.f3416b != null) {
            this.g++;
        }
    }

    void b(y yVar) {
        this.f3364c.d(a(yVar.g()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3364c.close();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f3364c.flush();
    }

    synchronized void m() {
        this.g++;
    }
}
