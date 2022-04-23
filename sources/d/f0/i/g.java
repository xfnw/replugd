package d.f0.i;

import d.f0.i.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class g implements Closeable {
    private static final ExecutorService v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), d.f0.c.a("OkHttp Http2Connection", true));

    /* renamed from: b  reason: collision with root package name */
    final boolean f3537b;

    /* renamed from: c  reason: collision with root package name */
    final h f3538c;

    /* renamed from: e  reason: collision with root package name */
    final String f3540e;
    int f;
    int g;
    boolean h;
    private final ScheduledExecutorService i;
    private final ExecutorService j;
    final l k;
    private boolean l;
    long n;
    final Socket r;
    final d.f0.i.j s;
    final j t;

    /* renamed from: d  reason: collision with root package name */
    final Map<Integer, d.f0.i.i> f3539d = new LinkedHashMap();
    long m = 0;
    m o = new m();
    final m p = new m();
    boolean q = false;
    final Set<Integer> u = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3541c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.f0.i.b f3542d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i, d.f0.i.b bVar) {
            super(str, objArr);
            this.f3541c = i;
            this.f3542d = bVar;
        }

        @Override // d.f0.b
        public void b() {
            try {
                g.this.b(this.f3541c, this.f3542d);
            } catch (IOException unused) {
                g.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f3545d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f3544c = i;
            this.f3545d = j;
        }

        @Override // d.f0.b
        public void b() {
            try {
                g.this.s.a(this.f3544c, this.f3545d);
            } catch (IOException unused) {
                g.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3547c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f3548d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f3547c = i;
            this.f3548d = list;
        }

        @Override // d.f0.b
        public void b() {
            if (g.this.k.a(this.f3547c, this.f3548d)) {
                try {
                    g.this.s.a(this.f3547c, d.f0.i.b.CANCEL);
                    synchronized (g.this) {
                        g.this.u.remove(Integer.valueOf(this.f3547c));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3550c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f3551d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f3552e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f3550c = i;
            this.f3551d = list;
            this.f3552e = z;
        }

        @Override // d.f0.b
        public void b() {
            boolean a2 = g.this.k.a(this.f3550c, this.f3551d, this.f3552e);
            if (a2) {
                try {
                    g.this.s.a(this.f3550c, d.f0.i.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a2 || this.f3552e) {
                synchronized (g.this) {
                    g.this.u.remove(Integer.valueOf(this.f3550c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3553c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e.c f3554d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f3555e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i, e.c cVar, int i2, boolean z) {
            super(str, objArr);
            this.f3553c = i;
            this.f3554d = cVar;
            this.f3555e = i2;
            this.f = z;
        }

        @Override // d.f0.b
        public void b() {
            try {
                boolean a2 = g.this.k.a(this.f3553c, this.f3554d, this.f3555e, this.f);
                if (a2) {
                    g.this.s.a(this.f3553c, d.f0.i.b.CANCEL);
                }
                if (a2 || this.f) {
                    synchronized (g.this) {
                        g.this.u.remove(Integer.valueOf(this.f3553c));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3556c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.f0.i.b f3557d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i, d.f0.i.b bVar) {
            super(str, objArr);
            this.f3556c = i;
            this.f3557d = bVar;
        }

        @Override // d.f0.b
        public void b() {
            g.this.k.a(this.f3556c, this.f3557d);
            synchronized (g.this) {
                g.this.u.remove(Integer.valueOf(this.f3556c));
            }
        }
    }

    /* renamed from: d.f0.i.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0099g {

        /* renamed from: a  reason: collision with root package name */
        Socket f3559a;

        /* renamed from: b  reason: collision with root package name */
        String f3560b;

        /* renamed from: c  reason: collision with root package name */
        e.e f3561c;

        /* renamed from: d  reason: collision with root package name */
        e.d f3562d;

        /* renamed from: e  reason: collision with root package name */
        h f3563e = h.f3564a;
        l f = l.f3607a;
        boolean g;
        int h;

        public C0099g(boolean z) {
            this.g = z;
        }

        public C0099g a(int i) {
            this.h = i;
            return this;
        }

        public C0099g a(h hVar) {
            this.f3563e = hVar;
            return this;
        }

        public C0099g a(Socket socket, String str, e.e eVar, e.d dVar) {
            this.f3559a = socket;
            this.f3560b = str;
            this.f3561c = eVar;
            this.f3562d = dVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public static final h f3564a = new a();

        /* loaded from: classes.dex */
        class a extends h {
            a() {
            }

            @Override // d.f0.i.g.h
            public void a(d.f0.i.i iVar) {
                iVar.a(d.f0.i.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(d.f0.i.i iVar);
    }

    /* loaded from: classes.dex */
    final class i extends d.f0.b {

        /* renamed from: c  reason: collision with root package name */
        final boolean f3565c;

        /* renamed from: d  reason: collision with root package name */
        final int f3566d;

        /* renamed from: e  reason: collision with root package name */
        final int f3567e;

        i(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", g.this.f3540e, Integer.valueOf(i), Integer.valueOf(i2));
            this.f3565c = z;
            this.f3566d = i;
            this.f3567e = i2;
        }

        @Override // d.f0.b
        public void b() {
            g.this.a(this.f3565c, this.f3566d, this.f3567e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends d.f0.b implements h.b {

        /* renamed from: c  reason: collision with root package name */
        final d.f0.i.h f3568c;

        /* loaded from: classes.dex */
        class a extends d.f0.b {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.f0.i.i f3570c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, d.f0.i.i iVar) {
                super(str, objArr);
                this.f3570c = iVar;
            }

            @Override // d.f0.b
            public void b() {
                try {
                    g.this.f3538c.a(this.f3570c);
                } catch (IOException e2) {
                    d.f0.k.f d2 = d.f0.k.f.d();
                    d2.a(4, "Http2Connection.Listener failure for " + g.this.f3540e, e2);
                    try {
                        this.f3570c.a(d.f0.i.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        class b extends d.f0.b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // d.f0.b
            public void b() {
                g gVar = g.this;
                gVar.f3538c.a(gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c extends d.f0.b {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ m f3573c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f3573c = mVar;
            }

            @Override // d.f0.b
            public void b() {
                try {
                    g.this.s.a(this.f3573c);
                } catch (IOException unused) {
                    g.this.q();
                }
            }
        }

        j(d.f0.i.h hVar) {
            super("OkHttp %s", g.this.f3540e);
            this.f3568c = hVar;
        }

        private void a(m mVar) {
            try {
                g.this.i.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f3540e}, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // d.f0.i.h.b
        public void a() {
        }

        @Override // d.f0.i.h.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // d.f0.i.h.b
        public void a(int i, int i2, List<d.f0.i.c> list) {
            g.this.a(i2, list);
        }

        @Override // d.f0.i.h.b
        public void a(int i, long j) {
            g gVar = g.this;
            if (i == 0) {
                synchronized (gVar) {
                    g.this.n += j;
                    g.this.notifyAll();
                }
                return;
            }
            d.f0.i.i a2 = gVar.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // d.f0.i.h.b
        public void a(int i, d.f0.i.b bVar) {
            if (g.this.b(i)) {
                g.this.a(i, bVar);
                return;
            }
            d.f0.i.i c2 = g.this.c(i);
            if (c2 != null) {
                c2.c(bVar);
            }
        }

        @Override // d.f0.i.h.b
        public void a(int i, d.f0.i.b bVar, e.f fVar) {
            d.f0.i.i[] iVarArr;
            fVar.g();
            synchronized (g.this) {
                iVarArr = (d.f0.i.i[]) g.this.f3539d.values().toArray(new d.f0.i.i[g.this.f3539d.size()]);
                g.this.h = true;
            }
            for (d.f0.i.i iVar : iVarArr) {
                if (iVar.c() > i && iVar.f()) {
                    iVar.c(d.f0.i.b.REFUSED_STREAM);
                    g.this.c(iVar.c());
                }
            }
        }

        @Override // d.f0.i.h.b
        public void a(boolean z, int i, int i2) {
            if (z) {
                synchronized (g.this) {
                    g.this.l = false;
                    g.this.notifyAll();
                }
                return;
            }
            try {
                g.this.i.execute(new i(true, i, i2));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // d.f0.i.h.b
        public void a(boolean z, int i, int i2, List<d.f0.i.c> list) {
            if (g.this.b(i)) {
                g.this.a(i, list, z);
                return;
            }
            synchronized (g.this) {
                d.f0.i.i a2 = g.this.a(i);
                if (a2 != null) {
                    a2.a(list);
                    if (z) {
                        a2.i();
                    }
                } else if (!g.this.h) {
                    if (i > g.this.f) {
                        if (i % 2 != g.this.g % 2) {
                            d.f0.i.i iVar = new d.f0.i.i(i, g.this, false, z, d.f0.c.b(list));
                            g.this.f = i;
                            g.this.f3539d.put(Integer.valueOf(i), iVar);
                            g.v.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f3540e, Integer.valueOf(i)}, iVar));
                        }
                    }
                }
            }
        }

        @Override // d.f0.i.h.b
        public void a(boolean z, int i, e.e eVar, int i2) {
            if (g.this.b(i)) {
                g.this.a(i, eVar, i2, z);
                return;
            }
            d.f0.i.i a2 = g.this.a(i);
            if (a2 == null) {
                g.this.c(i, d.f0.i.b.PROTOCOL_ERROR);
                long j = i2;
                g.this.h(j);
                eVar.skip(j);
                return;
            }
            a2.a(eVar, i2);
            if (z) {
                a2.i();
            }
        }

        @Override // d.f0.i.h.b
        public void a(boolean z, m mVar) {
            d.f0.i.i[] iVarArr;
            long j;
            int i;
            synchronized (g.this) {
                int c2 = g.this.p.c();
                if (z) {
                    g.this.p.a();
                }
                g.this.p.a(mVar);
                a(mVar);
                int c3 = g.this.p.c();
                iVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j = 0;
                } else {
                    j = c3 - c2;
                    if (!g.this.q) {
                        g.this.q = true;
                    }
                    if (!g.this.f3539d.isEmpty()) {
                        iVarArr = (d.f0.i.i[]) g.this.f3539d.values().toArray(new d.f0.i.i[g.this.f3539d.size()]);
                    }
                }
                g.v.execute(new b("OkHttp %s settings", g.this.f3540e));
            }
            if (!(iVarArr == null || j == 0)) {
                for (d.f0.i.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j);
                    }
                }
            }
        }

        @Override // d.f0.b
        protected void b() {
            Throwable th;
            d.f0.i.b bVar;
            g gVar;
            d.f0.i.b bVar2 = d.f0.i.b.INTERNAL_ERROR;
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    this.f3568c.a(this);
                    while (this.f3568c.a(false, (h.b) this)) {
                    }
                    bVar = d.f0.i.b.NO_ERROR;
                } catch (IOException unused) {
                }
                try {
                    bVar2 = d.f0.i.b.CANCEL;
                    gVar = g.this;
                } catch (IOException unused2) {
                    bVar = d.f0.i.b.PROTOCOL_ERROR;
                    bVar2 = d.f0.i.b.PROTOCOL_ERROR;
                    gVar = g.this;
                    gVar.a(bVar, bVar2);
                    d.f0.c.a(this.f3568c);
                }
            } catch (IOException unused3) {
            } catch (Throwable th3) {
                th = th3;
                bVar = bVar2;
                try {
                    g.this.a(bVar, bVar2);
                } catch (IOException unused4) {
                }
                d.f0.c.a(this.f3568c);
                throw th;
            }
            gVar.a(bVar, bVar2);
            d.f0.c.a(this.f3568c);
        }
    }

    g(C0099g gVar) {
        this.k = gVar.f;
        boolean z = gVar.g;
        this.f3537b = z;
        this.f3538c = gVar.f3563e;
        this.g = z ? 1 : 2;
        if (gVar.g) {
            this.g += 2;
        }
        if (gVar.g) {
            this.o.a(7, 16777216);
        }
        this.f3540e = gVar.f3560b;
        this.i = new ScheduledThreadPoolExecutor(1, d.f0.c.a(d.f0.c.a("OkHttp %s Writer", this.f3540e), false));
        if (gVar.h != 0) {
            ScheduledExecutorService scheduledExecutorService = this.i;
            i iVar = new i(false, 0, 0);
            int i2 = gVar.h;
            scheduledExecutorService.scheduleAtFixedRate(iVar, i2, i2, TimeUnit.MILLISECONDS);
        }
        this.j = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.f0.c.a(d.f0.c.a("OkHttp %s Push Observer", this.f3540e), true));
        this.p.a(7, 65535);
        this.p.a(5, 16384);
        this.n = this.p.c();
        this.r = gVar.f3559a;
        this.s = new d.f0.i.j(gVar.f3562d, this.f3537b);
        this.t = new j(new d.f0.i.h(gVar.f3561c, this.f3537b));
    }

    private synchronized void a(d.f0.b bVar) {
        if (!m()) {
            this.j.execute(bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #1 {, blocks: (B:4:0x0006, B:24:0x004f, B:25:0x0055, B:27:0x0059, B:28:0x005e, B:32:0x0067, B:33:0x006e, B:5:0x0007, B:7:0x000e, B:8:0x0013, B:10:0x0017, B:12:0x002b, B:14:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:34:0x006f, B:35:0x0074), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private d.f0.i.i b(int r11, java.util.List<d.f0.i.c> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            d.f0.i.j r7 = r10.s
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: all -> 0x0078
            int r0 = r10.g     // Catch: all -> 0x0075
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            d.f0.i.b r0 = d.f0.i.b.REFUSED_STREAM     // Catch: all -> 0x0075
            r10.a(r0)     // Catch: all -> 0x0075
        L_0x0013:
            boolean r0 = r10.h     // Catch: all -> 0x0075
            if (r0 != 0) goto L_0x006f
            int r8 = r10.g     // Catch: all -> 0x0075
            int r0 = r10.g     // Catch: all -> 0x0075
            int r0 = r0 + 2
            r10.g = r0     // Catch: all -> 0x0075
            d.f0.i.i r9 = new d.f0.i.i     // Catch: all -> 0x0075
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: all -> 0x0075
            if (r13 == 0) goto L_0x003c
            long r0 = r10.n     // Catch: all -> 0x0075
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.f3584b     // Catch: all -> 0x0075
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.g()     // Catch: all -> 0x0075
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, d.f0.i.i> r0 = r10.f3539d     // Catch: all -> 0x0075
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: all -> 0x0075
            r0.put(r1, r9)     // Catch: all -> 0x0075
        L_0x004c:
            monitor-exit(r10)     // Catch: all -> 0x0075
            if (r11 != 0) goto L_0x0055
            d.f0.i.j r0 = r10.s     // Catch: all -> 0x0078
            r0.a(r6, r8, r11, r12)     // Catch: all -> 0x0078
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.f3537b     // Catch: all -> 0x0078
            if (r0 != 0) goto L_0x0067
            d.f0.i.j r0 = r10.s     // Catch: all -> 0x0078
            r0.a(r11, r8, r12)     // Catch: all -> 0x0078
        L_0x005e:
            monitor-exit(r7)     // Catch: all -> 0x0078
            if (r13 == 0) goto L_0x0066
            d.f0.i.j r11 = r10.s
            r11.flush()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: all -> 0x0078
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: all -> 0x0078
            throw r11     // Catch: all -> 0x0078
        L_0x006f:
            d.f0.i.a r11 = new d.f0.i.a     // Catch: all -> 0x0075
            r11.<init>()     // Catch: all -> 0x0075
            throw r11     // Catch: all -> 0x0075
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch: all -> 0x0075
            throw r11     // Catch: all -> 0x0078
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch: all -> 0x0078
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f0.i.g.b(int, java.util.List, boolean):d.f0.i.i");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            a(d.f0.i.b.PROTOCOL_ERROR, d.f0.i.b.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    synchronized d.f0.i.i a(int i2) {
        return this.f3539d.get(Integer.valueOf(i2));
    }

    public d.f0.i.i a(List<d.f0.i.c> list, boolean z) {
        return b(0, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        try {
            this.i.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f3540e, Integer.valueOf(i2)}, i2, j2));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(int i2, d.f0.i.b bVar) {
        a(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f3540e, Integer.valueOf(i2)}, i2, bVar));
    }

    void a(int i2, e.e eVar, int i3, boolean z) {
        e.c cVar = new e.c();
        long j2 = i3;
        eVar.e(j2);
        eVar.b(cVar, j2);
        if (cVar.r() == j2) {
            a(new e("OkHttp %s Push Data[%s]", new Object[]{this.f3540e, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.r() + " != " + i3);
    }

    void a(int i2, List<d.f0.i.c> list) {
        synchronized (this) {
            if (this.u.contains(Integer.valueOf(i2))) {
                c(i2, d.f0.i.b.PROTOCOL_ERROR);
                return;
            }
            this.u.add(Integer.valueOf(i2));
            try {
                a(new c("OkHttp %s Push Request[%s]", new Object[]{this.f3540e, Integer.valueOf(i2)}, i2, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(int i2, List<d.f0.i.c> list, boolean z) {
        try {
            a(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f3540e, Integer.valueOf(i2)}, i2, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(int i2, boolean z, e.c cVar, long j2) {
        int min;
        long j3;
        if (j2 == 0) {
            this.s.a(z, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (this.n <= 0) {
                    try {
                        if (this.f3539d.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j2, this.n), this.s.n());
                j3 = min;
                this.n -= j3;
            }
            j2 -= j3;
            this.s.a(z && j2 == 0, i2, cVar, min);
        }
    }

    public void a(d.f0.i.b bVar) {
        synchronized (this.s) {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.s.a(this.f, bVar, d.f0.c.f3403a);
                }
            }
        }
    }

    void a(d.f0.i.b bVar, d.f0.i.b bVar2) {
        IOException e2;
        d.f0.i.i[] iVarArr = null;
        try {
            a(bVar);
            e2 = null;
        } catch (IOException e3) {
            e2 = e3;
        }
        synchronized (this) {
            if (!this.f3539d.isEmpty()) {
                iVarArr = (d.f0.i.i[]) this.f3539d.values().toArray(new d.f0.i.i[this.f3539d.size()]);
                this.f3539d.clear();
            }
        }
        if (iVarArr != null) {
            for (d.f0.i.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e4) {
                    e2 = e4;
                    if (e2 != null) {
                    }
                }
            }
        }
        try {
            this.s.close();
        } catch (IOException e5) {
            e2 = e5;
            if (e2 == null) {
            }
        }
        try {
            this.r.close();
        } catch (IOException e6) {
            e2 = e6;
        }
        this.i.shutdown();
        this.j.shutdown();
        if (e2 != null) {
            throw e2;
        }
    }

    void a(boolean z) {
        if (z) {
            this.s.m();
            this.s.b(this.o);
            int c2 = this.o.c();
            if (c2 != 65535) {
                this.s.a(0, c2 - 65535);
            }
        }
        new Thread(this.t).start();
    }

    void a(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.l;
                this.l = true;
            }
            if (z2) {
                q();
                return;
            }
        }
        try {
            this.s.a(z, i2, i3);
        } catch (IOException unused) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2, d.f0.i.b bVar) {
        this.s.a(i2, bVar);
    }

    boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized d.f0.i.i c(int i2) {
        d.f0.i.i remove;
        remove = this.f3539d.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i2, d.f0.i.b bVar) {
        try {
            this.i.execute(new a("OkHttp %s stream %d", new Object[]{this.f3540e, Integer.valueOf(i2)}, i2, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(d.f0.i.b.NO_ERROR, d.f0.i.b.CANCEL);
    }

    public void flush() {
        this.s.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void h(long j2) {
        this.m += j2;
        if (this.m >= this.o.c() / 2) {
            a(0, this.m);
            this.m = 0L;
        }
    }

    public synchronized boolean m() {
        return this.h;
    }

    public synchronized int n() {
        return this.p.b(Integer.MAX_VALUE);
    }

    public void o() {
        a(true);
    }
}
