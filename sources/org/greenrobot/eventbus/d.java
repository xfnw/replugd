package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.g;
import org.greenrobot.eventbus.h;
import org.greenrobot.eventbus.r.b;

/* loaded from: classes.dex */
public class d {
    private static final ExecutorService m = Executors.newCachedThreadPool();

    /* renamed from: e  reason: collision with root package name */
    boolean f3805e;
    boolean g;
    boolean h;
    List<b> j;
    g k;
    h l;

    /* renamed from: a  reason: collision with root package name */
    boolean f3801a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f3802b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f3803c = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f3804d = true;
    boolean f = true;
    ExecutorService i = m;

    public c a() {
        return new c(this);
    }

    public d a(boolean z) {
        this.f3802b = z;
        return this;
    }

    Object b() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g c() {
        g gVar = this.k;
        return gVar != null ? gVar : (!g.a.a() || b() == null) ? new g.b() : new g.a("EventBus");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h d() {
        Object b2;
        h hVar = this.l;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.a() || (b2 = b()) == null) {
            return null;
        }
        return new h.a((Looper) b2);
    }

    public c e() {
        c cVar;
        synchronized (c.class) {
            if (c.s == null) {
                c.s = a();
                cVar = c.s;
            } else {
                throw new e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
        }
        return cVar;
    }
}
