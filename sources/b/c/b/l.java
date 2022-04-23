package b.c.b;

/* loaded from: classes.dex */
public abstract class l extends Exception {

    /* renamed from: b  reason: collision with root package name */
    protected static final boolean f1777b;

    /* renamed from: c  reason: collision with root package name */
    protected static final StackTraceElement[] f1778c;

    static {
        f1777b = System.getProperty("surefire.test.class.path") != null;
        f1778c = new StackTraceElement[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
