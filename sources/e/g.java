package e;

/* loaded from: classes.dex */
public abstract class g implements s {

    /* renamed from: b  reason: collision with root package name */
    private final s f3743b;

    public g(s sVar) {
        if (sVar != null) {
            this.f3743b = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // e.s
    public void a(c cVar, long j) {
        this.f3743b.a(cVar, j);
    }

    @Override // e.s
    public u b() {
        return this.f3743b.b();
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3743b.close();
    }

    @Override // e.s, java.io.Flushable
    public void flush() {
        this.f3743b.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3743b.toString() + ")";
    }
}
