package d;

import d.f0.c;
import d.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private Runnable f3674c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f3675d;

    /* renamed from: a  reason: collision with root package name */
    private int f3672a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f3673b = 5;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<x.b> f3676e = new ArrayDeque();
    private final Deque<x.b> f = new ArrayDeque();
    private final Deque<x> g = new ArrayDeque();

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f3674c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!c() && runnable != null) {
            runnable.run();
        }
    }

    private int b(x.b bVar) {
        int i = 0;
        for (x.b bVar2 : this.f) {
            if (!bVar2.c().g && bVar2.d().equals(bVar.d())) {
                i++;
            }
        }
        return i;
    }

    private boolean c() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<x.b> it = this.f3676e.iterator();
            while (it.hasNext()) {
                x.b next = it.next();
                if (this.f.size() >= this.f3672a) {
                    break;
                } else if (b(next) < this.f3673b) {
                    it.remove();
                    arrayList.add(next);
                    this.f.add(next);
                }
            }
            z = b() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((x.b) arrayList.get(i)).a(a());
        }
        return z;
    }

    public synchronized ExecutorService a() {
        if (this.f3675d == null) {
            this.f3675d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.f3675d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x.b bVar) {
        a(this.f, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(x xVar) {
        this.g.add(xVar);
    }

    public synchronized int b() {
        return this.f.size() + this.g.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(x xVar) {
        a(this.g, xVar);
    }
}
