package androidx.lifecycle;

import android.util.Log;
import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends e {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<g> f1284c;

    /* renamed from: a  reason: collision with root package name */
    private a.b.a.b.a<f, b> f1282a = new a.b.a.b.a<>();

    /* renamed from: d  reason: collision with root package name */
    private int f1285d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1286e = false;
    private boolean f = false;
    private ArrayList<e.b> g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private e.b f1283b = e.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1287a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1288b = new int[e.b.values().length];

        static {
            try {
                f1288b[e.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1288b[e.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1288b[e.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1288b[e.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1288b[e.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f1287a = new int[e.a.values().length];
            try {
                f1287a[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1287a[e.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1287a[e.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1287a[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1287a[e.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1287a[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1287a[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        e.b f1289a;

        /* renamed from: b  reason: collision with root package name */
        d f1290b;

        b(f fVar, e.b bVar) {
            this.f1290b = j.a(fVar);
            this.f1289a = bVar;
        }

        void a(g gVar, e.a aVar) {
            e.b b2 = h.b(aVar);
            this.f1289a = h.a(this.f1289a, b2);
            this.f1290b.a(gVar, aVar);
            this.f1289a = b2;
        }
    }

    public h(g gVar) {
        this.f1284c = new WeakReference<>(gVar);
    }

    static e.b a(e.b bVar, e.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void a(g gVar) {
        Iterator<Map.Entry<f, b>> a2 = this.f1282a.a();
        while (a2.hasNext() && !this.f) {
            Map.Entry<f, b> next = a2.next();
            b value = next.getValue();
            while (value.f1289a.compareTo(this.f1283b) > 0 && !this.f && this.f1282a.contains(next.getKey())) {
                e.a b2 = b(value.f1289a);
                d(b(b2));
                value.a(gVar, b2);
                c();
            }
        }
    }

    private static e.a b(e.b bVar) {
        int i = a.f1288b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return e.a.ON_DESTROY;
        } else {
            if (i == 3) {
                return e.a.ON_STOP;
            }
            if (i == 4) {
                return e.a.ON_PAUSE;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
            throw new IllegalArgumentException();
        }
    }

    static e.b b(e.a aVar) {
        switch (a.f1287a[aVar.ordinal()]) {
            case 1:
            case 2:
                return e.b.CREATED;
            case 3:
            case 4:
                return e.b.STARTED;
            case 5:
                return e.b.RESUMED;
            case 6:
                return e.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(g gVar) {
        a.b.a.b.b<f, b>.d c2 = this.f1282a.c();
        while (c2.hasNext() && !this.f) {
            Map.Entry next = c2.next();
            b bVar = (b) next.getValue();
            while (bVar.f1289a.compareTo(this.f1283b) < 0 && !this.f && this.f1282a.contains(next.getKey())) {
                d(bVar.f1289a);
                bVar.a(gVar, e(bVar.f1289a));
                c();
            }
        }
    }

    private boolean b() {
        if (this.f1282a.size() == 0) {
            return true;
        }
        e.b bVar = this.f1282a.b().getValue().f1289a;
        e.b bVar2 = this.f1282a.d().getValue().f1289a;
        return bVar == bVar2 && this.f1283b == bVar2;
    }

    private e.b c(f fVar) {
        Map.Entry<f, b> b2 = this.f1282a.b(fVar);
        e.b bVar = null;
        e.b bVar2 = b2 != null ? b2.getValue().f1289a : null;
        if (!this.g.isEmpty()) {
            ArrayList<e.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f1283b, bVar2), bVar);
    }

    private void c() {
        ArrayList<e.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void c(e.b bVar) {
        if (this.f1283b != bVar) {
            this.f1283b = bVar;
            if (this.f1286e || this.f1285d != 0) {
                this.f = true;
                return;
            }
            this.f1286e = true;
            d();
            this.f1286e = false;
        }
    }

    private void d() {
        g gVar = this.f1284c.get();
        if (gVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (true) {
            boolean b2 = b();
            this.f = false;
            if (!b2) {
                if (this.f1283b.compareTo(this.f1282a.b().getValue().f1289a) < 0) {
                    a(gVar);
                }
                Map.Entry<f, b> d2 = this.f1282a.d();
                if (!this.f && d2 != null && this.f1283b.compareTo(d2.getValue().f1289a) > 0) {
                    b(gVar);
                }
            } else {
                return;
            }
        }
    }

    private void d(e.b bVar) {
        this.g.add(bVar);
    }

    private static e.a e(e.b bVar) {
        int i = a.f1288b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return e.a.ON_START;
            }
            if (i == 3) {
                return e.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return e.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.e
    public e.b a() {
        return this.f1283b;
    }

    public void a(e.a aVar) {
        c(b(aVar));
    }

    public void a(e.b bVar) {
        c(bVar);
    }

    @Override // androidx.lifecycle.e
    public void a(f fVar) {
        g gVar;
        e.b bVar = this.f1283b;
        e.b bVar2 = e.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = e.b.INITIALIZED;
        }
        b bVar3 = new b(fVar, bVar2);
        if (this.f1282a.b(fVar, bVar3) == null && (gVar = this.f1284c.get()) != null) {
            boolean z = this.f1285d != 0 || this.f1286e;
            e.b c2 = c(fVar);
            this.f1285d++;
            while (bVar3.f1289a.compareTo(c2) < 0 && this.f1282a.contains(fVar)) {
                d(bVar3.f1289a);
                bVar3.a(gVar, e(bVar3.f1289a));
                c();
                c2 = c(fVar);
            }
            if (!z) {
                d();
            }
            this.f1285d--;
        }
    }

    @Override // androidx.lifecycle.e
    public void b(f fVar) {
        this.f1282a.remove(fVar);
    }
}
