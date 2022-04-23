package b.c.b;

/* loaded from: classes.dex */
public final class f extends l {

    /* renamed from: d  reason: collision with root package name */
    private static final f f1768d;

    static {
        f fVar = new f();
        f1768d = fVar;
        fVar.setStackTrace(l.f1778c);
    }

    private f() {
    }

    private f(Throwable th) {
        super(th);
    }

    public static f a() {
        return l.f1777b ? new f() : f1768d;
    }

    public static f a(Throwable th) {
        return l.f1777b ? new f(th) : f1768d;
    }
}
