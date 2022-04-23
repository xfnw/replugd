package d;

import d.f0.c;
import d.f0.f.d;
import d.f0.f.g;
import d.f0.k.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j {
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    private final int f3651a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3652b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f3653c;

    /* renamed from: d  reason: collision with root package name */
    private final Deque<d.f0.f.c> f3654d;

    /* renamed from: e  reason: collision with root package name */
    final d f3655e;
    boolean f;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a2 = j.this.a(System.nanoTime());
                if (a2 != -1) {
                    if (a2 > 0) {
                        long j = a2 / 1000000;
                        long j2 = a2 - (1000000 * j);
                        synchronized (j.this) {
                            try {
                                j.this.wait(j, (int) j2);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.f3653c = new a();
        this.f3654d = new ArrayDeque();
        this.f3655e = new d();
        this.f3651a = i;
        this.f3652b = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    private int a(d.f0.f.c cVar, long j) {
        List<Reference<g>> list = cVar.n;
        int i = 0;
        while (i < list.size()) {
            Reference<g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                f.d().a("A connection to " + cVar.d().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f3467a);
                list.remove(i);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f3652b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j) {
        synchronized (this) {
            d.f0.f.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (d.f0.f.c cVar2 : this.f3654d) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f3652b && i <= this.f3651a) {
                if (i > 0) {
                    return this.f3652b - j2;
                } else if (i2 > 0) {
                    return this.f3652b;
                } else {
                    this.f = false;
                    return -1L;
                }
            }
            this.f3654d.remove(cVar);
            c.a(cVar.e());
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d.f0.f.c a(d.a aVar, g gVar, c0 c0Var) {
        for (d.f0.f.c cVar : this.f3654d) {
            if (cVar.a(aVar, c0Var)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket a(d.a aVar, g gVar) {
        for (d.f0.f.c cVar : this.f3654d) {
            if (cVar.a(aVar, null) && cVar.c() && cVar != gVar.c()) {
                return gVar.a(cVar);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(d.f0.f.c cVar) {
        if (cVar.k || this.f3651a == 0) {
            this.f3654d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d.f0.f.c cVar) {
        if (!this.f) {
            this.f = true;
            g.execute(this.f3653c);
        }
        this.f3654d.add(cVar);
    }
}
