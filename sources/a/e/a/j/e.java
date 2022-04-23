package a.e.a.j;

import a.e.a.i;

/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    final f f163b;

    /* renamed from: c  reason: collision with root package name */
    final d f164c;

    /* renamed from: d  reason: collision with root package name */
    e f165d;
    i i;

    /* renamed from: a  reason: collision with root package name */
    private m f162a = new m(this);

    /* renamed from: e  reason: collision with root package name */
    public int f166e = 0;
    int f = -1;
    private c g = c.NONE;
    private int h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f167a = new int[d.values().length];

        static {
            try {
                f167a[d.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f167a[d.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f167a[d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f167a[d.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f167a[d.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f167a[d.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f167a[d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f167a[d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f167a[d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        RELAXED,
        STRICT
    }

    /* loaded from: classes.dex */
    public enum c {
        NONE,
        STRONG,
        WEAK
    }

    /* loaded from: classes.dex */
    public enum d {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, d dVar) {
        b bVar = b.RELAXED;
        this.f163b = fVar;
        this.f164c = dVar;
    }

    public int a() {
        return this.h;
    }

    public void a(a.e.a.c cVar) {
        i iVar = this.i;
        if (iVar == null) {
            this.i = new i(i.a.UNRESTRICTED, null);
        } else {
            iVar.a();
        }
    }

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        d h = eVar.h();
        d dVar = this.f164c;
        if (h == dVar) {
            return dVar != d.BASELINE || (eVar.c().x() && c().x());
        }
        switch (a.f167a[dVar.ordinal()]) {
            case 1:
                return (h == d.BASELINE || h == d.CENTER_X || h == d.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = h == d.LEFT || h == d.RIGHT;
                return eVar.c() instanceof i ? z || h == d.CENTER_X : z;
            case 4:
            case 5:
                boolean z2 = h == d.TOP || h == d.BOTTOM;
                return eVar.c() instanceof i ? z2 || h == d.CENTER_Y : z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f164c.name());
        }
    }

    public boolean a(e eVar, int i, int i2, c cVar, int i3, boolean z) {
        if (eVar == null) {
            this.f165d = null;
            this.f166e = 0;
            this.f = -1;
            this.g = c.NONE;
            this.h = 2;
            return true;
        } else if (!z && !a(eVar)) {
            return false;
        } else {
            this.f165d = eVar;
            if (i > 0) {
                this.f166e = i;
            } else {
                this.f166e = 0;
            }
            this.f = i2;
            this.g = cVar;
            this.h = i3;
            return true;
        }
    }

    public boolean a(e eVar, int i, c cVar, int i2) {
        return a(eVar, i, -1, cVar, i2, false);
    }

    public int b() {
        e eVar;
        if (this.f163b.r() == 8) {
            return 0;
        }
        return (this.f <= -1 || (eVar = this.f165d) == null || eVar.f163b.r() != 8) ? this.f166e : this.f;
    }

    public f c() {
        return this.f163b;
    }

    public m d() {
        return this.f162a;
    }

    public i e() {
        return this.i;
    }

    public c f() {
        return this.g;
    }

    public e g() {
        return this.f165d;
    }

    public d h() {
        return this.f164c;
    }

    public boolean i() {
        return this.f165d != null;
    }

    public void j() {
        this.f165d = null;
        this.f166e = 0;
        this.f = -1;
        this.g = c.STRONG;
        this.h = 0;
        b bVar = b.RELAXED;
        this.f162a.d();
    }

    public String toString() {
        return this.f163b.f() + ":" + this.f164c.toString();
    }
}
