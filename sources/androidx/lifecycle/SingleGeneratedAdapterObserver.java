package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements d {

    /* renamed from: a  reason: collision with root package name */
    private final c f1270a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(c cVar) {
        this.f1270a = cVar;
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        this.f1270a.a(gVar, aVar, false, null);
        this.f1270a.a(gVar, aVar, true, null);
    }
}
