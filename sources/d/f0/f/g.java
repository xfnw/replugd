package d.f0.f;

import d.c0;
import d.e;
import d.f0.f.f;
import d.f0.g.c;
import d.j;
import d.p;
import d.t;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final d.a f3462a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f3463b;

    /* renamed from: c  reason: collision with root package name */
    private c0 f3464c;

    /* renamed from: d  reason: collision with root package name */
    private final j f3465d;

    /* renamed from: e  reason: collision with root package name */
    public final e f3466e;
    public final p f;
    private final Object g;
    private final f h;
    private int i;
    private c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private c n;

    /* loaded from: classes.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3467a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f3467a = obj;
        }
    }

    public g(j jVar, d.a aVar, e eVar, p pVar, Object obj) {
        this.f3465d = jVar;
        this.f3462a = aVar;
        this.f3466e = eVar;
        this.f = pVar;
        this.h = new f(aVar, i(), eVar, pVar);
        this.g = obj;
    }

    private c a(int i, int i2, int i3, int i4, boolean z) {
        Socket h;
        Socket socket;
        c cVar;
        c cVar2;
        c0 c0Var;
        c cVar3;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.f3465d) {
            if (this.l) {
                throw new IllegalStateException("released");
            } else if (this.n != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.m) {
                cVar = this.j;
                h = h();
                socket = null;
                if (this.j != null) {
                    cVar2 = this.j;
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    d.f0.a.f3401a.a(this.f3465d, this.f3462a, this, null);
                    if (this.j != null) {
                        cVar3 = this.j;
                        c0Var = null;
                        z2 = true;
                    } else {
                        c0Var = this.f3464c;
                        cVar3 = cVar2;
                    }
                } else {
                    cVar3 = cVar2;
                    c0Var = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        d.f0.c.a(h);
        if (cVar != null) {
            this.f.b(this.f3466e, cVar);
        }
        if (z2) {
            this.f.a(this.f3466e, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        if (c0Var != null || ((aVar = this.f3463b) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f3463b = this.h.b();
            z3 = true;
        }
        synchronized (this.f3465d) {
            if (!this.m) {
                if (z3) {
                    List<c0> a2 = this.f3463b.a();
                    int size = a2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        c0 c0Var2 = a2.get(i5);
                        d.f0.a.f3401a.a(this.f3465d, this.f3462a, this, c0Var2);
                        if (this.j != null) {
                            cVar3 = this.j;
                            this.f3464c = c0Var2;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (c0Var == null) {
                        c0Var = this.f3463b.c();
                    }
                    this.f3464c = c0Var;
                    this.i = 0;
                    cVar3 = new c(this.f3465d, c0Var);
                    a(cVar3, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (!z2) {
            cVar3.a(i, i2, i3, i4, z, this.f3466e, this.f);
            i().a(cVar3.d());
            synchronized (this.f3465d) {
                this.k = true;
                d.f0.a.f3401a.b(this.f3465d, cVar3);
                if (cVar3.c()) {
                    socket = d.f0.a.f3401a.a(this.f3465d, this.f3462a, this);
                    cVar3 = this.j;
                }
            }
            d.f0.c.a(socket);
        }
        this.f.a(this.f3466e, cVar3);
        return cVar3;
    }

    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        while (true) {
            c a2 = a(i, i2, i3, i4, z);
            synchronized (this.f3465d) {
                if (a2.l == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.n = null;
        }
        if (z2) {
            this.l = true;
        }
        c cVar = this.j;
        if (cVar != null) {
            if (z) {
                cVar.k = true;
            }
            if (this.n == null && (this.l || this.j.k)) {
                b(this.j);
                if (this.j.n.isEmpty()) {
                    this.j.o = System.nanoTime();
                    if (d.f0.a.f3401a.a(this.f3465d, this.j)) {
                        socket = this.j.e();
                        this.j = null;
                        return socket;
                    }
                }
                socket = null;
                this.j = null;
                return socket;
            }
        }
        return null;
    }

    private void b(c cVar) {
        int size = cVar.n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.n.get(i).get() == this) {
                cVar.n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket h() {
        c cVar = this.j;
        if (cVar == null || !cVar.k) {
            return null;
        }
        return a(false, false, true);
    }

    private d i() {
        return d.f0.a.f3401a.a(this.f3465d);
    }

    public c a(v vVar, t.a aVar, boolean z) {
        try {
            c a2 = a(aVar.c(), aVar.d(), aVar.a(), vVar.s(), vVar.y(), z).a(vVar, aVar, this);
            synchronized (this.f3465d) {
                this.n = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public Socket a(c cVar) {
        if (this.n == null && this.j.n.size() == 1) {
            Socket a2 = a(true, false, false);
            this.j = cVar;
            cVar.n.add(this.j.n.get(0));
            return a2;
        }
        throw new IllegalStateException();
    }

    public void a() {
        c cVar;
        c cVar2;
        synchronized (this.f3465d) {
            this.m = true;
            cVar = this.n;
            cVar2 = this.j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.a();
        }
    }

    public void a(c cVar, boolean z) {
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.g));
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r7 != d.f0.i.b.CANCEL) goto L_0x0020;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054 A[Catch: all -> 0x0067, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:8:0x0012, B:11:0x001c, B:13:0x0020, B:14:0x0023, B:16:0x0027, B:18:0x002f, B:20:0x0033, B:22:0x0039, B:25:0x003f, B:28:0x004a, B:30:0x0054, B:33:0x0059), top: B:41:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.IOException r7) {
        /*
            r6 = this;
            d.j r0 = r6.f3465d
            monitor-enter(r0)
            boolean r1 = r7 instanceof d.f0.i.n     // Catch: all -> 0x0067
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            d.f0.i.n r7 = (d.f0.i.n) r7     // Catch: all -> 0x0067
            d.f0.i.b r7 = r7.f3610b     // Catch: all -> 0x0067
            d.f0.i.b r1 = d.f0.i.b.REFUSED_STREAM     // Catch: all -> 0x0067
            if (r7 != r1) goto L_0x001c
            int r7 = r6.i     // Catch: all -> 0x0067
            int r7 = r7 + r4
            r6.i = r7     // Catch: all -> 0x0067
            int r7 = r6.i     // Catch: all -> 0x0067
            if (r7 <= r4) goto L_0x0049
            goto L_0x0020
        L_0x001c:
            d.f0.i.b r1 = d.f0.i.b.CANCEL     // Catch: all -> 0x0067
            if (r7 == r1) goto L_0x0049
        L_0x0020:
            r6.f3464c = r3     // Catch: all -> 0x0067
            goto L_0x0047
        L_0x0023:
            d.f0.f.c r1 = r6.j     // Catch: all -> 0x0067
            if (r1 == 0) goto L_0x0049
            d.f0.f.c r1 = r6.j     // Catch: all -> 0x0067
            boolean r1 = r1.c()     // Catch: all -> 0x0067
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof d.f0.i.a     // Catch: all -> 0x0067
            if (r1 == 0) goto L_0x0049
        L_0x0033:
            d.f0.f.c r1 = r6.j     // Catch: all -> 0x0067
            int r1 = r1.l     // Catch: all -> 0x0067
            if (r1 != 0) goto L_0x0047
            d.c0 r1 = r6.f3464c     // Catch: all -> 0x0067
            if (r1 == 0) goto L_0x0020
            if (r7 == 0) goto L_0x0020
            d.f0.f.f r1 = r6.h     // Catch: all -> 0x0067
            d.c0 r5 = r6.f3464c     // Catch: all -> 0x0067
            r1.a(r5, r7)     // Catch: all -> 0x0067
            goto L_0x0020
        L_0x0047:
            r7 = 1
            goto L_0x004a
        L_0x0049:
            r7 = 0
        L_0x004a:
            d.f0.f.c r1 = r6.j     // Catch: all -> 0x0067
            java.net.Socket r7 = r6.a(r7, r2, r4)     // Catch: all -> 0x0067
            d.f0.f.c r2 = r6.j     // Catch: all -> 0x0067
            if (r2 != 0) goto L_0x0058
            boolean r2 = r6.k     // Catch: all -> 0x0067
            if (r2 != 0) goto L_0x0059
        L_0x0058:
            r1 = r3
        L_0x0059:
            monitor-exit(r0)     // Catch: all -> 0x0067
            d.f0.c.a(r7)
            if (r1 == 0) goto L_0x0066
            d.p r7 = r6.f
            d.e r0 = r6.f3466e
            r7.b(r0, r1)
        L_0x0066:
            return
        L_0x0067:
            r7 = move-exception
            monitor-exit(r0)     // Catch: all -> 0x0067
            goto L_0x006b
        L_0x006a:
            throw r7
        L_0x006b:
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f0.f.g.a(java.io.IOException):void");
    }

    public void a(boolean z, c cVar, long j, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.f.b(this.f3466e, j);
        synchronized (this.f3465d) {
            if (cVar != null) {
                if (cVar == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    cVar2 = this.j;
                    a2 = a(z, false, true);
                    if (this.j != null) {
                        cVar2 = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + cVar);
        }
        d.f0.c.a(a2);
        if (cVar2 != null) {
            this.f.b(this.f3466e, cVar2);
        }
        if (iOException != null) {
            this.f.a(this.f3466e, d.f0.a.f3401a.a(this.f3466e, iOException));
        } else if (z2) {
            d.f0.a.f3401a.a(this.f3466e, (IOException) null);
            this.f.a(this.f3466e);
        }
    }

    public c b() {
        c cVar;
        synchronized (this.f3465d) {
            cVar = this.n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.j;
    }

    public boolean d() {
        f.a aVar;
        return this.f3464c != null || ((aVar = this.f3463b) != null && aVar.b()) || this.h.a();
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.f3465d) {
            cVar = this.j;
            a2 = a(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.f0.c.a(a2);
        if (cVar != null) {
            this.f.b(this.f3466e, cVar);
        }
    }

    public void f() {
        c cVar;
        Socket a2;
        synchronized (this.f3465d) {
            cVar = this.j;
            a2 = a(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.f0.c.a(a2);
        if (cVar != null) {
            d.f0.a.f3401a.a(this.f3466e, (IOException) null);
            this.f.b(this.f3466e, cVar);
            this.f.a(this.f3466e);
        }
    }

    public c0 g() {
        return this.f3464c;
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f3462a.toString();
    }
}
