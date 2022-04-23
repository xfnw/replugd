package a.e.a;

/* loaded from: classes.dex */
class h<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f146a;

    /* renamed from: b  reason: collision with root package name */
    private int f147b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i) {
        if (i > 0) {
            this.f146a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // a.e.a.g
    public T a() {
        int i = this.f147b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f146a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f147b = i - 1;
        return t;
    }

    @Override // a.e.a.g
    public void a(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            int i3 = this.f147b;
            Object[] objArr = this.f146a;
            if (i3 < objArr.length) {
                objArr[i3] = t;
                this.f147b = i3 + 1;
            }
        }
    }

    @Override // a.e.a.g
    public boolean a(T t) {
        int i = this.f147b;
        Object[] objArr = this.f146a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f147b = i + 1;
        return true;
    }
}
