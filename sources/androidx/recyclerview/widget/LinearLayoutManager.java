package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements f.i, RecyclerView.z.a {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    int s;
    private c t;
    k u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        k f1313a;

        /* renamed from: b  reason: collision with root package name */
        int f1314b;

        /* renamed from: c  reason: collision with root package name */
        int f1315c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1316d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1317e;

        a() {
            b();
        }

        void a() {
            this.f1315c = this.f1316d ? this.f1313a.b() : this.f1313a.f();
        }

        public void a(View view, int i) {
            this.f1315c = this.f1316d ? this.f1313a.a(view) + this.f1313a.h() : this.f1313a.d(view);
            this.f1314b = i;
        }

        boolean a(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.a();
        }

        void b() {
            this.f1314b = -1;
            this.f1315c = Integer.MIN_VALUE;
            this.f1316d = false;
            this.f1317e = false;
        }

        public void b(View view, int i) {
            int h = this.f1313a.h();
            if (h >= 0) {
                a(view, i);
                return;
            }
            this.f1314b = i;
            if (this.f1316d) {
                int b2 = (this.f1313a.b() - h) - this.f1313a.a(view);
                this.f1315c = this.f1313a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.f1315c - this.f1313a.b(view);
                    int f = this.f1313a.f();
                    int min = b3 - (f + Math.min(this.f1313a.d(view) - f, 0));
                    if (min < 0) {
                        this.f1315c += Math.min(b2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d2 = this.f1313a.d(view);
            int f2 = d2 - this.f1313a.f();
            this.f1315c = d2;
            if (f2 > 0) {
                int b4 = (this.f1313a.b() - Math.min(0, (this.f1313a.b() - h) - this.f1313a.a(view))) - (d2 + this.f1313a.b(view));
                if (b4 < 0) {
                    this.f1315c -= Math.min(f2, -b4);
                }
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1314b + ", mCoordinate=" + this.f1315c + ", mLayoutFromEnd=" + this.f1316d + ", mValid=" + this.f1317e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1318a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1319b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1320c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1321d;

        protected b() {
        }

        void a() {
            this.f1318a = 0;
            this.f1319b = false;
            this.f1320c = false;
            this.f1321d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f1323b;

        /* renamed from: c  reason: collision with root package name */
        int f1324c;

        /* renamed from: d  reason: collision with root package name */
        int f1325d;

        /* renamed from: e  reason: collision with root package name */
        int f1326e;
        int f;
        int g;
        boolean i;
        int j;
        boolean l;

        /* renamed from: a  reason: collision with root package name */
        boolean f1322a = true;
        int h = 0;
        List<RecyclerView.d0> k = null;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).f1346a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1325d == pVar.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.v vVar) {
            if (this.k != null) {
                return b();
            }
            View d2 = vVar.d(this.f1325d);
            this.f1325d += this.f1326e;
            return d2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            this.f1325d = b2 == null ? -1 : ((RecyclerView.p) b2.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.a0 a0Var) {
            int i = this.f1325d;
            return i >= 0 && i < a0Var.a();
        }

        public View b(View view) {
            int a2;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).f1346a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a2 = (pVar.a() - this.f1325d) * this.f1326e) >= 0 && a2 < i) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i = a2;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        int f1327b;

        /* renamed from: c  reason: collision with root package name */
        int f1328c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1329d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f1327b = parcel.readInt();
            this.f1328c = parcel.readInt();
            this.f1329d = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f1327b = dVar.f1327b;
            this.f1328c = dVar.f1328c;
            this.f1329d = dVar.f1329d;
        }

        boolean a() {
            return this.f1327b >= 0;
        }

        void b() {
            this.f1327b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1327b);
            parcel.writeInt(this.f1328c);
            parcel.writeInt(this.f1329d ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        j(i);
        a(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        RecyclerView.o.d a2 = RecyclerView.o.a(context, attributeSet, i, i2);
        j(a2.f1370a);
        a(a2.f1372c);
        b(a2.f1373d);
    }

    private View K() {
        return c(this.x ? 0 : e() - 1);
    }

    private View L() {
        return c(this.x ? e() - 1 : 0);
    }

    private void M() {
        this.x = (this.s == 1 || !I()) ? this.w : !this.w;
    }

    private int a(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int b2;
        int b3 = this.u.b() - i;
        if (b3 <= 0) {
            return 0;
        }
        int i2 = -c(-b3, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (b2 = this.u.b() - i3) <= 0) {
            return i2;
        }
        this.u.a(b2);
        return b2 + i2;
    }

    private View a(boolean z, boolean z2) {
        int e2;
        int i;
        if (this.x) {
            e2 = 0;
            i = e();
        } else {
            e2 = e() - 1;
            i = -1;
        }
        return a(e2, i, z, z2);
    }

    private void a(int i, int i2, boolean z, RecyclerView.a0 a0Var) {
        int i3;
        this.t.l = J();
        this.t.h = h(a0Var);
        c cVar = this.t;
        cVar.f = i;
        int i4 = -1;
        if (i == 1) {
            cVar.h += this.u.c();
            View K = K();
            c cVar2 = this.t;
            if (!this.x) {
                i4 = 1;
            }
            cVar2.f1326e = i4;
            c cVar3 = this.t;
            int l = l(K);
            c cVar4 = this.t;
            cVar3.f1325d = l + cVar4.f1326e;
            cVar4.f1323b = this.u.a(K);
            i3 = this.u.a(K) - this.u.b();
        } else {
            View L = L();
            this.t.h += this.u.f();
            c cVar5 = this.t;
            if (this.x) {
                i4 = 1;
            }
            cVar5.f1326e = i4;
            c cVar6 = this.t;
            int l2 = l(L);
            c cVar7 = this.t;
            cVar6.f1325d = l2 + cVar7.f1326e;
            cVar7.f1323b = this.u.d(L);
            i3 = (-this.u.d(L)) + this.u.f();
        }
        c cVar8 = this.t;
        cVar8.f1324c = i2;
        if (z) {
            cVar8.f1324c -= i3;
        }
        this.t.g = i3;
    }

    private void a(a aVar) {
        g(aVar.f1314b, aVar.f1315c);
    }

    private void a(RecyclerView.v vVar, int i) {
        int e2 = e();
        if (i >= 0) {
            int a2 = this.u.a() - i;
            if (this.x) {
                for (int i2 = 0; i2 < e2; i2++) {
                    View c2 = c(i2);
                    if (this.u.d(c2) < a2 || this.u.f(c2) < a2) {
                        a(vVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = e2 - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View c3 = c(i4);
                if (this.u.d(c3) < a2 || this.u.f(c3) < a2) {
                    a(vVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.v vVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, vVar);
                }
                return;
            }
            while (i > i2) {
                a(i, vVar);
                i--;
            }
        }
    }

    private void a(RecyclerView.v vVar, c cVar) {
        if (cVar.f1322a && !cVar.l) {
            int i = cVar.f;
            int i2 = cVar.g;
            if (i == -1) {
                a(vVar, i2);
            } else {
                b(vVar, i2);
            }
        }
    }

    private boolean a(RecyclerView.a0 a0Var, a aVar) {
        int i;
        boolean z = false;
        if (!a0Var.d() && (i = this.A) != -1) {
            if (i < 0 || i >= a0Var.a()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                aVar.f1314b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.a()) {
                    aVar.f1316d = this.D.f1329d;
                    aVar.f1315c = aVar.f1316d ? this.u.b() - this.D.f1328c : this.u.f() + this.D.f1328c;
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View b2 = b(this.A);
                    if (b2 == null) {
                        if (e() > 0) {
                            if ((this.A < l(c(0))) == this.x) {
                                z = true;
                            }
                            aVar.f1316d = z;
                        }
                        aVar.a();
                    } else if (this.u.b(b2) > this.u.g()) {
                        aVar.a();
                        return true;
                    } else if (this.u.d(b2) - this.u.f() < 0) {
                        aVar.f1315c = this.u.f();
                        aVar.f1316d = false;
                        return true;
                    } else if (this.u.b() - this.u.a(b2) < 0) {
                        aVar.f1315c = this.u.b();
                        aVar.f1316d = true;
                        return true;
                    } else {
                        aVar.f1315c = aVar.f1316d ? this.u.a(b2) + this.u.h() : this.u.d(b2);
                    }
                    return true;
                } else {
                    boolean z2 = this.x;
                    aVar.f1316d = z2;
                    aVar.f1315c = z2 ? this.u.b() - this.B : this.u.f() + this.B;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        boolean z = false;
        if (e() == 0) {
            return false;
        }
        View g = g();
        if (g != null && aVar.a(g, a0Var)) {
            aVar.b(g, l(g));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            View l = aVar.f1316d ? l(vVar, a0Var) : m(vVar, a0Var);
            if (l == null) {
                return false;
            }
            aVar.a(l, l(l));
            if (!a0Var.d() && C()) {
                if (this.u.d(l) >= this.u.b() || this.u.a(l) < this.u.f()) {
                    z = true;
                }
                if (z) {
                    aVar.f1315c = aVar.f1316d ? this.u.b() : this.u.f();
                }
            }
            return true;
        }
    }

    private int b(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int f;
        int f2 = i - this.u.f();
        if (f2 <= 0) {
            return 0;
        }
        int i2 = -c(f2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (f = i3 - this.u.f()) <= 0) {
            return i2;
        }
        this.u.a(-f);
        return i2 - f;
    }

    private View b(boolean z, boolean z2) {
        int i;
        int e2;
        if (this.x) {
            i = e() - 1;
            e2 = -1;
        } else {
            i = 0;
            e2 = e();
        }
        return a(i, e2, z, z2);
    }

    private void b(a aVar) {
        h(aVar.f1314b, aVar.f1315c);
    }

    private void b(RecyclerView.v vVar, int i) {
        if (i >= 0) {
            int e2 = e();
            if (this.x) {
                int i2 = e2 - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View c2 = c(i3);
                    if (this.u.a(c2) > i || this.u.e(c2) > i) {
                        a(vVar, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i4 = 0; i4 < e2; i4++) {
                View c3 = c(i4);
                if (this.u.a(c3) > i || this.u.e(c3) > i) {
                    a(vVar, 0, i4);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2) {
        if (a0Var.e() && e() != 0 && !a0Var.d() && C()) {
            List<RecyclerView.d0> f = vVar.f();
            int size = f.size();
            int l = l(c(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.d0 d0Var = f.get(i5);
                if (!d0Var.p()) {
                    char c2 = 1;
                    if ((d0Var.i() < l) != this.x) {
                        c2 = 65535;
                    }
                    int b2 = this.u.b(d0Var.f1346a);
                    if (c2 == 65535) {
                        i3 += b2;
                    } else {
                        i4 += b2;
                    }
                }
            }
            this.t.k = f;
            if (i3 > 0) {
                h(l(L()), i);
                c cVar = this.t;
                cVar.h = i3;
                cVar.f1324c = 0;
                cVar.a();
                a(vVar, this.t, a0Var, false);
            }
            if (i4 > 0) {
                g(l(K()), i2);
                c cVar2 = this.t;
                cVar2.h = i4;
                cVar2.f1324c = 0;
                cVar2.a();
                a(vVar, this.t, a0Var, false);
            }
            this.t.k = null;
        }
    }

    private void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (!a(a0Var, aVar) && !a(vVar, a0Var, aVar)) {
            aVar.a();
            aVar.f1314b = this.y ? a0Var.a() - 1 : 0;
        }
    }

    private View f(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return e(0, e());
    }

    private View g(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return a(vVar, a0Var, 0, e(), a0Var.a());
    }

    private void g(int i, int i2) {
        this.t.f1324c = this.u.b() - i2;
        this.t.f1326e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f1325d = i;
        cVar.f = 1;
        cVar.f1323b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private View h(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return e(e() - 1, -1);
    }

    private void h(int i, int i2) {
        this.t.f1324c = i2 - this.u.f();
        c cVar = this.t;
        cVar.f1325d = i;
        cVar.f1326e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f1323b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    private int i(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        E();
        return m.a(a0Var, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    private View i(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return a(vVar, a0Var, e() - 1, -1, a0Var.a());
    }

    private int j(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        E();
        return m.a(a0Var, this.u, b(!this.z, true), a(!this.z, true), this, this.z, this.x);
    }

    private View j(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? f(vVar, a0Var) : h(vVar, a0Var);
    }

    private int k(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        E();
        return m.b(a0Var, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    private View k(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? h(vVar, a0Var) : f(vVar, a0Var);
    }

    private View l(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? g(vVar, a0Var) : i(vVar, a0Var);
    }

    private View m(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? i(vVar, a0Var) : g(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean A() {
        return (i() == 1073741824 || r() == 1073741824 || !s()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean C() {
        return this.D == null && this.v == this.y;
    }

    c D() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        if (this.t == null) {
            this.t = D();
        }
    }

    public int F() {
        View a2 = a(0, e(), false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int G() {
        View a2 = a(e() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int H() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I() {
        return j() == 1;
    }

    boolean J() {
        return this.u.d() == 0 && this.u.a() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int a(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return 0;
        }
        return c(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int a(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    int a(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i = cVar.f1324c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            a(vVar, cVar);
        }
        int i3 = cVar.f1324c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(a0Var)) {
                break;
            }
            bVar.a();
            a(vVar, a0Var, cVar, bVar);
            if (!bVar.f1319b) {
                cVar.f1323b += bVar.f1318a * cVar.f;
                if (!bVar.f1320c || this.t.k != null || !a0Var.d()) {
                    int i4 = cVar.f1324c;
                    int i5 = bVar.f1318a;
                    cVar.f1324c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    cVar.g = i6 + bVar.f1318a;
                    int i7 = cVar.f1324c;
                    if (i7 < 0) {
                        cVar.g += i7;
                    }
                    a(vVar, cVar);
                }
                if (z && bVar.f1321d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f1324c;
    }

    View a(int i, int i2, boolean z, boolean z2) {
        E();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return (this.s == 0 ? this.f1367e : this.f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View a(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i2;
        M();
        if (e() == 0 || (i2 = i(i)) == Integer.MIN_VALUE) {
            return null;
        }
        E();
        E();
        a(i2, (int) (this.u.g() * 0.33333334f), false, a0Var);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.f1322a = false;
        a(vVar, cVar, a0Var, true);
        View k = i2 == -1 ? k(vVar, a0Var) : j(vVar, a0Var);
        View L = i2 == -1 ? L() : K();
        if (!L.hasFocusable()) {
            return k;
        }
        if (k == null) {
            return null;
        }
        return L;
    }

    View a(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        E();
        int f = this.u.f();
        int b2 = this.u.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View c2 = c(i);
            int l = l(c2);
            if (l >= 0 && l < i3) {
                if (((RecyclerView.p) c2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = c2;
                    }
                } else if (this.u.d(c2) < b2 && this.u.a(c2) >= f) {
                    return c2;
                } else {
                    if (view == null) {
                        view = c2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (e() != 0 && i != 0) {
            E();
            a(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
            a(a0Var, this.t, cVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(int i, RecyclerView.o.c cVar) {
        boolean z;
        int i2;
        d dVar = this.D;
        int i3 = -1;
        if (dVar == null || !dVar.a()) {
            M();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z = dVar2.f1329d;
            i2 = dVar2.f1327b;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.f.i
    public void a(View view, View view2, int i, int i2) {
        int i3;
        a("Cannot drop a view during a scroll or layout calculation");
        E();
        M();
        int l = l(view);
        int l2 = l(view2);
        char c2 = l < l2 ? (char) 1 : (char) 65535;
        if (this.x) {
            if (c2 == 1) {
                f(l2, this.u.b() - (this.u.d(view2) + this.u.b(view)));
                return;
            }
            i3 = this.u.b() - this.u.a(view2);
        } else if (c2 == 65535) {
            i3 = this.u.d(view2);
        } else {
            f(l2, this.u.a(view2) - this.u.b(view));
            return;
        }
        f(l2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            accessibilityEvent.setFromIndex(F());
            accessibilityEvent.setToIndex(G());
        }
    }

    void a(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i = cVar.f1325d;
        if (i >= 0 && i < a0Var.a()) {
            cVar2.a(i, Math.max(0, cVar.g));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a2 = cVar.a(vVar);
        if (a2 == null) {
            bVar.f1319b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.x == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f1318a = this.u.b(a2);
        if (this.s == 1) {
            if (I()) {
                i5 = q() - o();
                i4 = i5 - this.u.c(a2);
            } else {
                i4 = n();
                i5 = this.u.c(a2) + i4;
            }
            int i6 = cVar.f;
            int i7 = cVar.f1323b;
            if (i6 == -1) {
                i3 = i7 - bVar.f1318a;
                i = i7;
                i2 = i5;
            } else {
                i = bVar.f1318a + i7;
                i3 = i7;
                i2 = i5;
            }
        } else {
            int p = p();
            int c2 = this.u.c(a2) + p;
            int i8 = cVar.f;
            int i9 = cVar.f1323b;
            if (i8 == -1) {
                i4 = i9 - bVar.f1318a;
                i2 = i9;
                i3 = p;
                i = c2;
            } else {
                i2 = bVar.f1318a + i9;
                i3 = p;
                i = c2;
                i4 = i9;
            }
        }
        a(a2, i4, i3, i2, i);
        if (pVar.c() || pVar.b()) {
            bVar.f1320c = true;
        }
        bVar.f1321d = a2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(String str) {
        if (this.D == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a((String) null);
        if (z != this.w) {
            this.w = z;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean a() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int b(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return 0;
        }
        return c(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int b(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View b(int i) {
        int e2 = e();
        if (e2 == 0) {
            return null;
        }
        int l = i - l(c(0));
        if (l >= 0 && l < e2) {
            View c2 = c(l);
            if (l(c2) == i) {
                return c2;
            }
        }
        return super.b(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.b(recyclerView, vVar);
        if (this.C) {
            b(vVar);
            vVar.a();
        }
    }

    public void b(boolean z) {
        a((String) null);
        if (this.y != z) {
            this.y = z;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean b() {
        return this.s == 1;
    }

    int c(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        this.t.f1322a = true;
        E();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, a0Var);
        c cVar = this.t;
        int a2 = cVar.g + a(vVar, cVar, a0Var, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.u.a(-i);
        this.t.j = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int c(RecyclerView.a0 a0Var) {
        return k(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p c() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int d(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int e(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    View e(int i, int i2) {
        int i3;
        int i4;
        E();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return c(i);
        }
        if (this.u.d(c(i)) < this.u.f()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        return (this.s == 0 ? this.f1367e : this.f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View b2;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.a() == 0) {
            b(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            this.A = this.D.f1327b;
        }
        E();
        this.t.f1322a = false;
        M();
        View g = g();
        if (!this.E.f1317e || this.A != -1 || this.D != null) {
            this.E.b();
            a aVar = this.E;
            aVar.f1316d = this.x ^ this.y;
            b(vVar, a0Var, aVar);
            this.E.f1317e = true;
        } else if (g != null && (this.u.d(g) >= this.u.b() || this.u.a(g) <= this.u.f())) {
            this.E.b(g, l(g));
        }
        int h = h(a0Var);
        if (this.t.j >= 0) {
            i = h;
            h = 0;
        } else {
            i = 0;
        }
        int f = h + this.u.f();
        int c2 = i + this.u.c();
        if (!(!a0Var.d() || (i7 = this.A) == -1 || this.B == Integer.MIN_VALUE || (b2 = b(i7)) == null)) {
            if (this.x) {
                i8 = this.u.b() - this.u.a(b2);
                i9 = this.B;
            } else {
                i9 = this.u.d(b2) - this.u.f();
                i8 = this.B;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                f += i11;
            } else {
                c2 -= i11;
            }
        }
        if (!this.E.f1316d ? !this.x : this.x) {
            i10 = 1;
        }
        a(vVar, a0Var, this.E, i10);
        a(vVar);
        this.t.l = J();
        this.t.i = a0Var.d();
        a aVar2 = this.E;
        if (aVar2.f1316d) {
            b(aVar2);
            c cVar = this.t;
            cVar.h = f;
            a(vVar, cVar, a0Var, false);
            c cVar2 = this.t;
            i3 = cVar2.f1323b;
            int i12 = cVar2.f1325d;
            int i13 = cVar2.f1324c;
            if (i13 > 0) {
                c2 += i13;
            }
            a(this.E);
            c cVar3 = this.t;
            cVar3.h = c2;
            cVar3.f1325d += cVar3.f1326e;
            a(vVar, cVar3, a0Var, false);
            c cVar4 = this.t;
            i2 = cVar4.f1323b;
            int i14 = cVar4.f1324c;
            if (i14 > 0) {
                h(i12, i3);
                c cVar5 = this.t;
                cVar5.h = i14;
                a(vVar, cVar5, a0Var, false);
                i3 = this.t.f1323b;
            }
        } else {
            a(aVar2);
            c cVar6 = this.t;
            cVar6.h = c2;
            a(vVar, cVar6, a0Var, false);
            c cVar7 = this.t;
            i2 = cVar7.f1323b;
            int i15 = cVar7.f1325d;
            int i16 = cVar7.f1324c;
            if (i16 > 0) {
                f += i16;
            }
            b(this.E);
            c cVar8 = this.t;
            cVar8.h = f;
            cVar8.f1325d += cVar8.f1326e;
            a(vVar, cVar8, a0Var, false);
            c cVar9 = this.t;
            i3 = cVar9.f1323b;
            int i17 = cVar9.f1324c;
            if (i17 > 0) {
                g(i15, i2);
                c cVar10 = this.t;
                cVar10.h = i17;
                a(vVar, cVar10, a0Var, false);
                i2 = this.t.f1323b;
            }
        }
        if (e() > 0) {
            if (this.x ^ this.y) {
                int a2 = a(i2, vVar, a0Var, true);
                i5 = i3 + a2;
                i4 = i2 + a2;
                i6 = b(i5, vVar, a0Var, false);
            } else {
                int b3 = b(i3, vVar, a0Var, true);
                i5 = i3 + b3;
                i4 = i2 + b3;
                i6 = a(i4, vVar, a0Var, false);
            }
            i3 = i5 + i6;
            i2 = i4 + i6;
        }
        b(vVar, a0Var, i3, i2);
        if (!a0Var.d()) {
            this.u.i();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int f(RecyclerView.a0 a0Var) {
        return k(a0Var);
    }

    public void f(int i, int i2) {
        this.A = i;
        this.B = i2;
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(RecyclerView.a0 a0Var) {
        super.g(a0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    protected int h(RecyclerView.a0 a0Var) {
        if (a0Var.c()) {
            return this.u.g();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && I()) ? -1 : 1 : (this.s != 1 && I()) ? 1 : -1;
    }

    public void j(int i) {
        if (i == 0 || i == 1) {
            a((String) null);
            if (i != this.s || this.u == null) {
                this.u = k.a(this, i);
                this.E.f1313a = this.u;
                this.s = i;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable x() {
        d dVar = this.D;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (e() > 0) {
            E();
            boolean z = this.v ^ this.x;
            dVar2.f1329d = z;
            if (z) {
                View K = K();
                dVar2.f1328c = this.u.b() - this.u.a(K);
                dVar2.f1327b = l(K);
            } else {
                View L = L();
                dVar2.f1327b = l(L);
                dVar2.f1328c = this.u.d(L) - this.u.f();
            }
        } else {
            dVar2.b();
        }
        return dVar2;
    }
}
