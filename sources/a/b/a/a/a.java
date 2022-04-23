package a.b.a.a;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f63c;

    /* renamed from: b  reason: collision with root package name */
    private c f65b = new a.b.a.a.b();

    /* renamed from: a  reason: collision with root package name */
    private c f64a = this.f65b;

    /* renamed from: a.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0003a implements Executor {
        ExecutorC0003a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().b(runnable);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().a(runnable);
        }
    }

    static {
        new ExecutorC0003a();
        new b();
    }

    private a() {
    }

    public static a b() {
        if (f63c != null) {
            return f63c;
        }
        synchronized (a.class) {
            if (f63c == null) {
                f63c = new a();
            }
        }
        return f63c;
    }

    @Override // a.b.a.a.c
    public void a(Runnable runnable) {
        this.f64a.a(runnable);
    }

    @Override // a.b.a.a.c
    public boolean a() {
        return this.f64a.a();
    }

    @Override // a.b.a.a.c
    public void b(Runnable runnable) {
        this.f64a.b(runnable);
    }
}
