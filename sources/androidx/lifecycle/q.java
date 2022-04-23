package androidx.lifecycle;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private final a f1294a;

    /* renamed from: b  reason: collision with root package name */
    private final r f1295b;

    /* loaded from: classes.dex */
    public interface a {
        <T extends p> T a(Class<T> cls);
    }

    public q(r rVar, a aVar) {
        this.f1294a = aVar;
        this.f1295b = rVar;
    }

    public <T extends p> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends p> T a(String str, Class<T> cls) {
        T t = (T) this.f1295b.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f1294a.a(cls);
        this.f1295b.a(str, t2);
        return t2;
    }
}
