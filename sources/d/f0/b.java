package d.f0;

/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    protected final String f3402b;

    public b(String str, Object... objArr) {
        this.f3402b = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f3402b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
