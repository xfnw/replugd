package a.e.a.j;

import a.e.a.c;
import a.e.a.j.e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f {
    public static float j0 = 0.5f;
    protected b[] C;
    protected int R;
    protected int S;
    private int T;
    private int U;
    float V;
    float W;
    private Object X;

    /* renamed from: c  reason: collision with root package name */
    n f181c;

    /* renamed from: d  reason: collision with root package name */
    n f182d;

    /* renamed from: a  reason: collision with root package name */
    public int f179a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f180b = -1;

    /* renamed from: e  reason: collision with root package name */
    int f183e = 0;
    int f = 0;
    int[] g = new int[2];
    int h = 0;
    int i = 0;
    float j = 1.0f;
    int k = 0;
    int l = 0;
    float m = 1.0f;
    int n = -1;
    float o = 1.0f;
    h p = null;
    private int[] q = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float r = 0.0f;
    e s = new e(this, e.d.LEFT);
    e t = new e(this, e.d.TOP);
    e u = new e(this, e.d.RIGHT);
    e v = new e(this, e.d.BOTTOM);
    e w = new e(this, e.d.BASELINE);
    e x = new e(this, e.d.CENTER_X);
    e y = new e(this, e.d.CENTER_Y);
    e z = new e(this, e.d.CENTER);
    protected e[] A = {this.s, this.u, this.t, this.v, this.w, this.z};
    protected ArrayList<e> B = new ArrayList<>();
    f D = null;
    int E = 0;
    int F = 0;
    protected float G = 0.0f;
    protected int H = -1;
    protected int I = 0;
    protected int J = 0;
    int K = 0;
    int L = 0;
    private int M = 0;
    private int N = 0;
    protected int O = 0;
    protected int P = 0;
    int Q = 0;
    private int Y = 0;
    private String Z = null;
    private String a0 = null;
    boolean b0 = false;
    boolean c0 = false;
    boolean d0 = false;
    int e0 = 0;
    int f0 = 0;
    float[] g0 = {-1.0f, -1.0f};
    protected f[] h0 = {null, null};
    protected f[] i0 = {null, null};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f184a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f185b = new int[b.values().length];

        static {
            try {
                f185b[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f185b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f185b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f185b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f184a = new int[e.d.values().length];
            try {
                f184a[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f184a[e.d.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f184a[e.d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f184a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f184a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f184a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f184a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f184a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f184a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public f() {
        b bVar = b.FIXED;
        this.C = new b[]{bVar, bVar};
        float f = j0;
        this.V = f;
        this.W = f;
        J();
    }

    private void J() {
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f1, code lost:
        if (r27 != false) goto L_0x01fa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f8, code lost:
        if (r27 != false) goto L_0x01fa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01fa, code lost:
        r26.b(r29, r9, r1, 5);
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(a.e.a.e r26, boolean r27, a.e.a.i r28, a.e.a.i r29, a.e.a.j.f.b r30, boolean r31, a.e.a.j.e r32, a.e.a.j.e r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.f.a(a.e.a.e, boolean, a.e.a.i, a.e.a.i, a.e.a.j.f$b, boolean, a.e.a.j.e, a.e.a.j.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    private boolean t(int i) {
        int i2 = i * 2;
        e[] eVarArr = this.A;
        if (!(eVarArr[i2].f165d == null || eVarArr[i2].f165d.f165d == eVarArr[i2])) {
            int i3 = i2 + 1;
            if (eVarArr[i3].f165d != null && eVarArr[i3].f165d.f165d == eVarArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public boolean A() {
        e eVar = this.t;
        e eVar2 = eVar.f165d;
        if (eVar2 != null && eVar2.f165d == eVar) {
            return true;
        }
        e eVar3 = this.v;
        e eVar4 = eVar3.f165d;
        return eVar4 != null && eVar4.f165d == eVar3;
    }

    public boolean B() {
        return this.f == 0 && this.G == 0.0f && this.k == 0 && this.l == 0 && this.C[1] == b.MATCH_CONSTRAINT;
    }

    public boolean C() {
        return this.f183e == 0 && this.G == 0.0f && this.h == 0 && this.i == 0 && this.C[0] == b.MATCH_CONSTRAINT;
    }

    public void D() {
        this.s.j();
        this.t.j();
        this.u.j();
        this.v.j();
        this.w.j();
        this.x.j();
        this.y.j();
        this.z.j();
        this.D = null;
        this.r = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f = j0;
        this.V = f;
        this.W = f;
        b[] bVarArr = this.C;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.X = null;
        this.Y = 0;
        this.a0 = null;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f179a = -1;
        this.f180b = -1;
        int[] iArr = this.q;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f183e = 0;
        this.f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.h = 0;
        this.k = 0;
        this.n = -1;
        this.o = 1.0f;
        n nVar = this.f181c;
        if (nVar != null) {
            nVar.d();
        }
        n nVar2 = this.f182d;
        if (nVar2 != null) {
            nVar2.d();
        }
        this.p = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
    }

    public void E() {
        f k = k();
        if (k == null || !(k instanceof g) || !((g) k()).N()) {
            int size = this.B.size();
            for (int i = 0; i < size; i++) {
                this.B.get(i).j();
            }
        }
    }

    public void F() {
        for (int i = 0; i < 6; i++) {
            this.A[i].d().d();
        }
    }

    public void G() {
    }

    public void H() {
        int i = this.I;
        int i2 = this.J;
        this.M = i;
        this.N = i2;
    }

    public void I() {
        for (int i = 0; i < 6; i++) {
            this.A[i].d().g();
        }
    }

    public e a(e.d dVar) {
        switch (a.f184a[dVar.ordinal()]) {
            case 1:
                return this.s;
            case 2:
                return this.t;
            case 3:
                return this.u;
            case 4:
                return this.v;
            case 5:
                return this.w;
            case 6:
                return this.z;
            case 7:
                return this.x;
            case 8:
                return this.y;
            case 9:
                return null;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public void a(float f) {
        this.V = f;
    }

    public void a(int i) {
        k.a(i, this);
    }

    public void a(int i, int i2) {
        this.I = i;
        this.E = i2 - i;
        int i3 = this.E;
        int i4 = this.R;
        if (i3 < i4) {
            this.E = i4;
        }
    }

    public void a(int i, int i2, int i3) {
        if (i3 == 0) {
            a(i, i2);
        } else if (i3 == 1) {
            e(i, i2);
        }
        this.c0 = true;
    }

    public void a(int i, int i2, int i3, float f) {
        this.f183e = i;
        this.h = i2;
        this.i = i3;
        this.j = f;
        if (f < 1.0f && this.f183e == 0) {
            this.f183e = 2;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.I = i;
        this.J = i2;
        if (this.Y == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        if (this.C[0] != b.FIXED || i7 >= (i5 = this.E)) {
            i5 = i7;
        }
        if (this.C[1] != b.FIXED || i8 >= (i6 = this.F)) {
            i6 = i8;
        }
        this.E = i5;
        this.F = i6;
        int i9 = this.F;
        int i10 = this.S;
        if (i9 < i10) {
            this.F = i10;
        }
        int i11 = this.E;
        int i12 = this.R;
        if (i11 < i12) {
            this.E = i12;
        }
        this.c0 = true;
    }

    public void a(c cVar) {
        this.s.a(cVar);
        this.t.a(cVar);
        this.u.a(cVar);
        this.v.a(cVar);
        this.w.a(cVar);
        this.z.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0248 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(a.e.a.e r39) {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.f.a(a.e.a.e):void");
    }

    public void a(e.d dVar, f fVar, e.d dVar2, int i, int i2) {
        a(dVar).a(fVar.a(dVar2), i, i2, e.c.STRONG, 0, true);
    }

    public void a(b bVar) {
        this.C[0] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            o(this.T);
        }
    }

    public void a(f fVar) {
        this.D = fVar;
    }

    public void a(f fVar, float f, int i) {
        e.d dVar = e.d.CENTER;
        a(dVar, fVar, dVar, i, 0);
        this.r = f;
    }

    public void a(Object obj) {
        this.X = obj;
    }

    public void a(String str) {
        this.Z = str;
    }

    public void a(boolean z) {
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.n == -1) {
            if (z3 && !z4) {
                this.n = 0;
            } else if (!z3 && z4) {
                this.n = 1;
                if (this.H == -1) {
                    this.o = 1.0f / this.o;
                }
            }
        }
        if (this.n == 0 && (!this.t.i() || !this.v.i())) {
            this.n = 1;
        } else if (this.n == 1 && (!this.s.i() || !this.u.i())) {
            this.n = 0;
        }
        if (this.n == -1 && (!this.t.i() || !this.v.i() || !this.s.i() || !this.u.i())) {
            if (this.t.i() && this.v.i()) {
                this.n = 0;
            } else if (this.s.i() && this.u.i()) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (z && !z2) {
                this.n = 0;
            } else if (!z && z2) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (this.h > 0 && this.k == 0) {
                this.n = 0;
            } else if (this.h == 0 && this.k > 0) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1 && z && z2) {
            this.o = 1.0f / this.o;
            this.n = 1;
        }
    }

    public boolean a() {
        return this.Y != 8;
    }

    public float b(int i) {
        if (i == 0) {
            return this.V;
        }
        if (i == 1) {
            return this.W;
        }
        return -1.0f;
    }

    public ArrayList<e> b() {
        return this.B;
    }

    public void b(float f) {
        this.g0[0] = f;
    }

    public void b(int i, int i2) {
        this.O = i;
        this.P = i2;
    }

    public void b(int i, int i2, int i3, float f) {
        this.f = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        if (f < 1.0f && this.f == 0) {
            this.f = 2;
        }
    }

    public void b(a.e.a.e eVar) {
        eVar.a(this.s);
        eVar.a(this.t);
        eVar.a(this.u);
        eVar.a(this.v);
        if (this.Q > 0) {
            eVar.a(this.w);
        }
    }

    public void b(b bVar) {
        this.C[1] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            g(this.U);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0084 -> B:36:0x0085). Please submit an issue!!! */
    public void b(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.G = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i3);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
            }
            f = 0.0f;
        } else {
            String substring3 = str.substring(i3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.G = f;
            this.H = i2;
        }
    }

    public void b(boolean z) {
    }

    public int c() {
        return this.Q;
    }

    public b c(int i) {
        if (i == 0) {
            return j();
        }
        if (i == 1) {
            return q();
        }
        return null;
    }

    public void c(float f) {
        this.W = f;
    }

    public void c(int i, int i2) {
        this.I = i;
        this.J = i2;
    }

    public void c(a.e.a.e eVar) {
        int b2 = eVar.b(this.s);
        int b3 = eVar.b(this.t);
        int b4 = eVar.b(this.u);
        int b5 = eVar.b(this.v);
        int i = b5 - b3;
        if (b4 - b2 < 0 || i < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }

    public int d() {
        return w() + this.F;
    }

    public int d(int i) {
        if (i == 0) {
            return s();
        }
        if (i == 1) {
            return i();
        }
        return 0;
    }

    public void d(float f) {
        this.g0[1] = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, int i2) {
        if (i2 == 0) {
            this.K = i;
        } else if (i2 == 1) {
            this.L = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i) {
        if (i == 0) {
            return this.K;
        }
        if (i == 1) {
            return this.L;
        }
        return 0;
    }

    public Object e() {
        return this.X;
    }

    public void e(int i, int i2) {
        this.J = i;
        this.F = i2 - i;
        int i3 = this.F;
        int i4 = this.S;
        if (i3 < i4) {
            this.F = i4;
        }
    }

    public String f() {
        return this.Z;
    }

    public void f(int i) {
        this.Q = i;
    }

    public int g() {
        return this.M + this.O;
    }

    public void g(int i) {
        this.F = i;
        int i2 = this.F;
        int i3 = this.S;
        if (i2 < i3) {
            this.F = i3;
        }
    }

    public int h() {
        return this.N + this.P;
    }

    public void h(int i) {
        this.e0 = i;
    }

    public int i() {
        if (this.Y == 8) {
            return 0;
        }
        return this.F;
    }

    public void i(int i) {
        this.q[1] = i;
    }

    public b j() {
        return this.C[0];
    }

    public void j(int i) {
        this.q[0] = i;
    }

    public f k() {
        return this.D;
    }

    public void k(int i) {
        if (i < 0) {
            i = 0;
        }
        this.S = i;
    }

    public n l() {
        if (this.f182d == null) {
            this.f182d = new n();
        }
        return this.f182d;
    }

    public void l(int i) {
        if (i < 0) {
            i = 0;
        }
        this.R = i;
    }

    public n m() {
        if (this.f181c == null) {
            this.f181c = new n();
        }
        return this.f181c;
    }

    public void m(int i) {
        this.f0 = i;
    }

    public int n() {
        return v() + this.E;
    }

    public void n(int i) {
        this.Y = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int o() {
        return this.I + this.O;
    }

    public void o(int i) {
        this.E = i;
        int i2 = this.E;
        int i3 = this.R;
        if (i2 < i3) {
            this.E = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int p() {
        return this.J + this.P;
    }

    public void p(int i) {
        this.U = i;
    }

    public b q() {
        return this.C[1];
    }

    public void q(int i) {
        this.T = i;
    }

    public int r() {
        return this.Y;
    }

    public void r(int i) {
        this.I = i;
    }

    public int s() {
        if (this.Y == 8) {
            return 0;
        }
        return this.E;
    }

    public void s(int i) {
        this.J = i;
    }

    public int t() {
        return this.U;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.a0 != null) {
            str = "type: " + this.a0 + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.Z != null) {
            str2 = "id: " + this.Z + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        sb.append(" x ");
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.T);
        sb.append(" x ");
        sb.append(this.U);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.T;
    }

    public int v() {
        return this.I;
    }

    public int w() {
        return this.J;
    }

    public boolean x() {
        return this.Q > 0;
    }

    public boolean y() {
        return this.s.d().f202b == 1 && this.u.d().f202b == 1 && this.t.d().f202b == 1 && this.v.d().f202b == 1;
    }

    public boolean z() {
        e eVar = this.s;
        e eVar2 = eVar.f165d;
        if (eVar2 != null && eVar2.f165d == eVar) {
            return true;
        }
        e eVar3 = this.u;
        e eVar4 = eVar3.f165d;
        return eVar4 != null && eVar4.f165d == eVar3;
    }
}
