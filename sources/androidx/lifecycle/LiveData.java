package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object i = new Object();

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f1260d;

    /* renamed from: e  reason: collision with root package name */
    volatile Object f1261e;
    private boolean g;
    private boolean h;

    /* renamed from: a  reason: collision with root package name */
    final Object f1257a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private a.b.a.b.b<m<? super T>, LiveData<T>.b> f1258b = new a.b.a.b.b<>();

    /* renamed from: c  reason: collision with root package name */
    int f1259c = 0;
    private int f = -1;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.b implements d {

        /* renamed from: e  reason: collision with root package name */
        final g f1262e;

        LifecycleBoundObserver(g gVar, m<? super T> mVar) {
            super(mVar);
            this.f1262e = gVar;
        }

        @Override // androidx.lifecycle.LiveData.b
        void a() {
            this.f1262e.e().b(this);
        }

        @Override // androidx.lifecycle.d
        public void a(g gVar, e.a aVar) {
            if (this.f1262e.e().a() == e.b.DESTROYED) {
                LiveData.this.a((m) this.f1264a);
            } else {
                a(b());
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a(g gVar) {
            return this.f1262e == gVar;
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean b() {
            return this.f1262e.e().a().a(e.b.STARTED);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1257a) {
                obj = LiveData.this.f1261e;
                LiveData.this.f1261e = LiveData.i;
            }
            LiveData.this.a((LiveData) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f1264a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1265b;

        /* renamed from: c  reason: collision with root package name */
        int f1266c = -1;

        b(m<? super T> mVar) {
            this.f1264a = mVar;
        }

        void a() {
        }

        void a(boolean z) {
            if (z != this.f1265b) {
                this.f1265b = z;
                int i = 1;
                boolean z2 = LiveData.this.f1259c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.f1259c;
                if (!this.f1265b) {
                    i = -1;
                }
                liveData.f1259c = i2 + i;
                if (z2 && this.f1265b) {
                    LiveData.this.a();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.f1259c == 0 && !this.f1265b) {
                    liveData2.b();
                }
                if (this.f1265b) {
                    LiveData.this.a(this);
                }
            }
        }

        boolean a(g gVar) {
            return false;
        }

        abstract boolean b();
    }

    public LiveData() {
        Object obj = i;
        this.f1260d = obj;
        this.f1261e = obj;
        new a();
    }

    private static void a(String str) {
        if (!a.b.a.a.a.b().a()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.f1265b) {
            if (!bVar.b()) {
                bVar.a(false);
                return;
            }
            int i2 = bVar.f1266c;
            int i3 = this.f;
            if (i2 < i3) {
                bVar.f1266c = i3;
                bVar.f1264a.a((Object) this.f1260d);
            }
        }
    }

    protected void a() {
    }

    void a(LiveData<T>.b bVar) {
        if (this.g) {
            this.h = true;
            return;
        }
        this.g = true;
        do {
            this.h = false;
            if (bVar == null) {
                a.b.a.b.b<m<? super T>, LiveData<T>.b>.d c2 = this.f1258b.c();
                while (c2.hasNext()) {
                    b((b) c2.next().getValue());
                    if (this.h) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.h);
        this.g = false;
    }

    public void a(g gVar, m<? super T> mVar) {
        a("observe");
        if (gVar.e().a() != e.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
            LiveData<T>.b b2 = this.f1258b.b(mVar, lifecycleBoundObserver);
            if (b2 != null && !b2.a(gVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (b2 == null) {
                gVar.e().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.b remove = this.f1258b.remove(mVar);
        if (remove != null) {
            remove.a();
            remove.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        a("setValue");
        this.f++;
        this.f1260d = t;
        a((b) null);
    }

    protected void b() {
    }
}
