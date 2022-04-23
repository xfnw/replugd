package androidx.lifecycle;

import androidx.lifecycle.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f1255a;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1256a = new int[e.a.values().length];

        static {
            try {
                f1256a[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1256a[e.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1256a[e.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1256a[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1256a[e.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1256a[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1256a[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(b bVar) {
        this.f1255a = bVar;
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        switch (a.f1256a[aVar.ordinal()]) {
            case 1:
                this.f1255a.c(gVar);
                return;
            case 2:
                this.f1255a.f(gVar);
                return;
            case 3:
                this.f1255a.a(gVar);
                return;
            case 4:
                this.f1255a.d(gVar);
                return;
            case 5:
                this.f1255a.e(gVar);
                return;
            case 6:
                this.f1255a.b(gVar);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
