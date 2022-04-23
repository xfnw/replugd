package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable, l {

    /* renamed from: b  reason: collision with root package name */
    private final k f3787b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final c f3788c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f3789d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f3788c = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f3787b.a(a2);
            if (!this.f3789d) {
                this.f3789d = true;
                this.f3788c.a().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                j a2 = this.f3787b.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f3787b.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.f3788c.a(a2);
            } catch (InterruptedException e2) {
                g b2 = this.f3788c.b();
                Level level = Level.WARNING;
                b2.a(level, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f3789d = false;
            }
        }
    }
}
