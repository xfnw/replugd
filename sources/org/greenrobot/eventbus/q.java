package org.greenrobot.eventbus;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    final Object f3837a;

    /* renamed from: b  reason: collision with root package name */
    final o f3838b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f3839c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Object obj, o oVar) {
        this.f3837a = obj;
        this.f3838b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f3837a == qVar.f3837a && this.f3838b.equals(qVar.f3838b);
    }

    public int hashCode() {
        return this.f3837a.hashCode() + this.f3838b.f.hashCode();
    }
}
