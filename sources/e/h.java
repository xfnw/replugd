package e;

/* loaded from: classes.dex */
public abstract class h implements t {

    /* renamed from: b  reason: collision with root package name */
    private final t f3744b;

    public h(t tVar) {
        if (tVar != null) {
            this.f3744b = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // e.t
    public long b(c cVar, long j) {
        return this.f3744b.b(cVar, j);
    }

    @Override // e.t
    public u b() {
        return this.f3744b.b();
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3744b.close();
    }

    public final t d() {
        return this.f3744b;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3744b.toString() + ")";
    }
}
