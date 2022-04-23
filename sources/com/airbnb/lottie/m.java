package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.x.d;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class m<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f2166e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Set<h<T>> f2167a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<h<Throwable>> f2168b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f2169c;

    /* renamed from: d  reason: collision with root package name */
    private volatile l<T> f2170d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f2170d != null) {
                l lVar = m.this.f2170d;
                if (lVar.b() != null) {
                    m.this.a((m) lVar.b());
                } else {
                    m.this.a(lVar.a());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends FutureTask<l<T>> {
        b(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    m.this.a((l) get());
                } catch (InterruptedException | ExecutionException e2) {
                    m.this.a(new l(e2));
                }
            }
        }
    }

    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    m(Callable<l<T>> callable, boolean z) {
        this.f2167a = new LinkedHashSet(1);
        this.f2168b = new LinkedHashSet(1);
        this.f2169c = new Handler(Looper.getMainLooper());
        this.f2170d = null;
        if (z) {
            try {
                a((l) callable.call());
            } catch (Throwable th) {
                a((l) new l<>(th));
            }
        } else {
            f2166e.execute(new b(callable));
        }
    }

    private void a() {
        this.f2169c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l<T> lVar) {
        if (this.f2170d == null) {
            this.f2170d = lVar;
            a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(T t) {
        for (h hVar : new ArrayList(this.f2167a)) {
            hVar.a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.f2168b);
        if (arrayList.isEmpty()) {
            d.a("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.a(th);
        }
    }

    public synchronized m<T> a(h<Throwable> hVar) {
        if (!(this.f2170d == null || this.f2170d.a() == null)) {
            hVar.a(this.f2170d.a());
        }
        this.f2168b.add(hVar);
        return this;
    }

    public synchronized m<T> b(h<T> hVar) {
        if (!(this.f2170d == null || this.f2170d.b() == null)) {
            hVar.a(this.f2170d.b());
        }
        this.f2167a.add(hVar);
        return this;
    }

    public synchronized m<T> c(h<Throwable> hVar) {
        this.f2168b.remove(hVar);
        return this;
    }

    public synchronized m<T> d(h<T> hVar) {
        this.f2167a.remove(hVar);
        return this;
    }
}
