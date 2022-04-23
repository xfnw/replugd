package org.greenrobot.eventbus;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable, l {

    /* renamed from: b  reason: collision with root package name */
    private final k f3785b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final c f3786c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f3786c = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        this.f3785b.a(j.a(qVar, obj));
        this.f3786c.a().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        j a2 = this.f3785b.a();
        if (a2 != null) {
            this.f3786c.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
