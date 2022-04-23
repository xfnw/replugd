package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1268a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0041a f1269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1268a = obj;
        this.f1269b = a.f1271c.a(this.f1268a.getClass());
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        this.f1269b.a(gVar, aVar, this.f1268a);
    }
}
