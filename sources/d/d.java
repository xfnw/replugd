package d;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class d {
    public static final d n;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3387a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3388b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3389c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3390d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3391e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    String m;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3392a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3393b;

        /* renamed from: c  reason: collision with root package name */
        int f3394c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f3395d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f3396e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f3395d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public d a() {
            return new d(this);
        }

        public a b() {
            this.f3392a = true;
            return this;
        }

        public a c() {
            this.f3393b = true;
            return this;
        }

        public a d() {
            this.f = true;
            return this;
        }
    }

    static {
        a aVar = new a();
        aVar.b();
        aVar.a();
        a aVar2 = new a();
        aVar2.d();
        aVar2.a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        n = aVar2.a();
    }

    d(a aVar) {
        this.f3387a = aVar.f3392a;
        this.f3388b = aVar.f3393b;
        this.f3389c = aVar.f3394c;
        this.f3390d = -1;
        this.f3391e = false;
        this.f = false;
        this.g = false;
        this.h = aVar.f3395d;
        this.i = aVar.f3396e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
    }

    private d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f3387a = z;
        this.f3388b = z2;
        this.f3389c = i;
        this.f3390d = i2;
        this.f3391e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static d.d a(d.r r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d.d.a(d.r):d.d");
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f3387a) {
            sb.append("no-cache, ");
        }
        if (this.f3388b) {
            sb.append("no-store, ");
        }
        if (this.f3389c != -1) {
            sb.append("max-age=");
            sb.append(this.f3389c);
            sb.append(", ");
        }
        if (this.f3390d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f3390d);
            sb.append(", ");
        }
        if (this.f3391e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f3391e;
    }

    public boolean b() {
        return this.f;
    }

    public int c() {
        return this.f3389c;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.f3387a;
    }

    public boolean h() {
        return this.f3388b;
    }

    public boolean i() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String j = j();
        this.m = j;
        return j;
    }
}
