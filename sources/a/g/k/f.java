package a.g.k;

/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f284a;

    /* renamed from: b  reason: collision with root package name */
    private int f285b;

    public f(int i) {
        if (i > 0) {
            this.f284a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean b(T t) {
        for (int i = 0; i < this.f285b; i++) {
            if (this.f284a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // a.g.k.e
    public T a() {
        int i = this.f285b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f284a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f285b = i - 1;
        return t;
    }

    @Override // a.g.k.e
    public boolean a(T t) {
        if (!b(t)) {
            int i = this.f285b;
            Object[] objArr = this.f284a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f285b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
