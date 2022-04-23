package org.greenrobot.eventbus;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private j f3817a;

    /* renamed from: b  reason: collision with root package name */
    private j f3818b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j a() {
        j jVar;
        jVar = this.f3817a;
        if (this.f3817a != null) {
            this.f3817a = this.f3817a.f3816c;
            if (this.f3817a == null) {
                this.f3818b = null;
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j a(int i) {
        if (this.f3817a == null) {
            wait(i);
        }
        return a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(j jVar) {
        try {
            if (jVar != null) {
                if (this.f3818b != null) {
                    this.f3818b.f3816c = jVar;
                    this.f3818b = jVar;
                } else if (this.f3817a == null) {
                    this.f3818b = jVar;
                    this.f3817a = jVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
