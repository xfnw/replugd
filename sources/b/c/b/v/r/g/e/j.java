package b.c.b.v.r.g.e;

import b.c.b.r.a;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f1951a;

    /* renamed from: b  reason: collision with root package name */
    private final s f1952b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f1951a = aVar;
        this.f1952b = new s(aVar);
    }

    public static j a(a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        int a2 = s.a(aVar, 1, 4);
        if (a2 == 4) {
            return new a(aVar);
        }
        if (a2 == 5) {
            return new b(aVar);
        }
        int a3 = s.a(aVar, 1, 5);
        if (a3 == 12) {
            return new c(aVar);
        }
        if (a3 == 13) {
            return new d(aVar);
        }
        switch (s.a(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s a() {
        return this.f1952b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a b() {
        return this.f1951a;
    }

    public abstract String c();
}
