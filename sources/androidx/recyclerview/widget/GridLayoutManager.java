package androidx.recyclerview.widget;

import a.g.l.b0.c;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    int[] J;
    View[] K;
    boolean H = false;
    int I = -1;
    final SparseIntArray L = new SparseIntArray();
    final SparseIntArray M = new SparseIntArray();
    c N = new a();
    final Rect O = new Rect();

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int b(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int c(int i, int i2) {
            return i % i2;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        int f1310e = -1;
        int f = 0;

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int e() {
            return this.f1310e;
        }

        public int f() {
            return this.f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f1311a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1312b = false;

        int a(int i) {
            int size = this.f1311a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1311a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f1311a.size()) {
                return -1;
            }
            return this.f1311a.keyAt(i4);
        }

        int a(int i, int i2) {
            if (!this.f1312b) {
                return c(i, i2);
            }
            int i3 = this.f1311a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int c2 = c(i, i2);
            this.f1311a.put(i, c2);
            return c2;
        }

        public void a() {
            this.f1311a.clear();
        }

        public abstract int b(int i);

        public int b(int i, int i2) {
            int b2 = b(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int b3 = b(i5);
                i3 += b3;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = b3;
                }
            }
            return i3 + b2 > i2 ? i4 + 1 : i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:19:0x0036). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:19:0x0036). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:19:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int c(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.b(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f1312b
                if (r2 == 0) goto L_0x0026
                android.util.SparseIntArray r2 = r5.f1311a
                int r2 = r2.size()
                if (r2 <= 0) goto L_0x0026
                int r2 = r5.a(r6)
                if (r2 < 0) goto L_0x0026
                android.util.SparseIntArray r3 = r5.f1311a
                int r3 = r3.get(r2)
                int r4 = r5.b(r2)
                int r3 = r3 + r4
                goto L_0x0036
            L_0x0026:
                r2 = 0
                r3 = 0
            L_0x0028:
                if (r2 >= r6) goto L_0x0039
                int r4 = r5.b(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x0033
                r3 = 0
                goto L_0x0036
            L_0x0033:
                if (r3 <= r7) goto L_0x0036
                r3 = r4
            L_0x0036:
                int r2 = r2 + 1
                goto L_0x0028
            L_0x0039:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x003d
                return r3
            L_0x003d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.c(int, int):int");
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        k(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        k(RecyclerView.o.a(context, attributeSet, i, i2).f1371b);
    }

    private void L() {
        int e2 = e();
        for (int i = 0; i < e2; i++) {
            b bVar = (b) c(i).getLayoutParams();
            int a2 = bVar.a();
            this.L.put(a2, bVar.f());
            this.M.put(a2, bVar.e());
        }
    }

    private void M() {
        this.L.clear();
        this.M.clear();
    }

    private void N() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private void O() {
        int i;
        int i2;
        if (H() == 1) {
            i2 = q() - o();
            i = n();
        } else {
            i2 = h() - m();
            i = p();
        }
        l(i2 - i);
    }

    private int a(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.d()) {
            return this.N.b(i, this.I);
        }
        int a2 = vVar.a(i);
        if (a2 != -1) {
            return this.N.b(a2, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void a(float f, int i) {
        l(Math.max(Math.round(f * this.I), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? b(view, i, i2, pVar) : a(view, i, i2, pVar)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1375b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int g = g(bVar.f1310e, bVar.f);
        if (this.s == 1) {
            i2 = RecyclerView.o.a(g, i, i5, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i3 = RecyclerView.o.a(this.u.g(), i(), i4, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            i3 = RecyclerView.o.a(g, i, i4, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            i2 = RecyclerView.o.a(this.u.g(), r(), i5, ((ViewGroup.MarginLayoutParams) bVar).width, true);
        }
        a(view, i2, i3, z);
    }

    private void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.K[i4];
            b bVar = (b) view.getLayoutParams();
            bVar.f = c(vVar, a0Var, l(view));
            bVar.f1310e = i5;
            i5 += bVar.f;
            i4 += i3;
        }
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private int b(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.d()) {
            return this.N.a(i, this.I);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = vVar.a(i);
        if (a2 != -1) {
            return this.N.a(a2, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(vVar, a0Var, aVar.f1314b);
        if (z) {
            while (b2 > 0) {
                int i2 = aVar.f1314b;
                if (i2 > 0) {
                    aVar.f1314b = i2 - 1;
                    b2 = b(vVar, a0Var, aVar.f1314b);
                } else {
                    return;
                }
            }
            return;
        }
        int a2 = a0Var.a() - 1;
        int i3 = aVar.f1314b;
        while (i3 < a2) {
            int i4 = i3 + 1;
            int b3 = b(vVar, a0Var, i4);
            if (b3 <= b2) {
                break;
            }
            i3 = i4;
            b2 = b3;
        }
        aVar.f1314b = i3;
    }

    private int c(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.d()) {
            return this.N.b(i);
        }
        int i2 = this.L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = vVar.a(i);
        if (a2 != -1) {
            return this.N.b(a2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void l(int i) {
        this.J = a(this.J, this.I, i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean C() {
        return this.D == null && !this.H;
    }

    public int K() {
        return this.I;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int a(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        O();
        N();
        return super.a(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int a(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return this.I;
        }
        if (a0Var.a() < 1) {
            return 0;
        }
        return a(vVar, a0Var, a0Var.a() - 1) + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f7, code lost:
        if (r13 == r11) goto L_0x00b7;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0105  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (l >= 0 && l < i3 && b(vVar, a0Var, l) == 0) {
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
    public RecyclerView.p a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.J == null) {
            super.a(rect, i, i2);
        }
        int n = n() + o();
        int p = p() + m();
        if (this.s == 1) {
            i4 = RecyclerView.o.a(i2, rect.height() + p, k());
            int[] iArr = this.J;
            i3 = RecyclerView.o.a(i, iArr[iArr.length - 1] + n, l());
        } else {
            i3 = RecyclerView.o.a(i, rect.width() + n, l());
            int[] iArr2 = this.J;
            i4 = RecyclerView.o.a(i2, iArr2[iArr2.length - 1] + p, k());
        }
        c(i3, i4);
    }

    public void a(c cVar) {
        this.N = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i = this.I;
        for (int i2 = 0; i2 < this.I && cVar.a(a0Var) && i > 0; i2++) {
            int i3 = cVar.f1325d;
            cVar2.a(i3, Math.max(0, cVar.g));
            i -= this.N.b(i3);
            cVar.f1325d += cVar.f1326e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, a.g.l.b0.c cVar) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(vVar, a0Var, bVar.a());
        if (this.s == 0) {
            i4 = bVar.e();
            i3 = bVar.f();
            i = 1;
            z2 = this.I > 1 && bVar.f() == this.I;
            z = false;
            i2 = a2;
        } else {
            i3 = 1;
            i2 = bVar.e();
            i = bVar.f();
            z2 = this.I > 1 && bVar.f() == this.I;
            z = false;
            i4 = a2;
        }
        cVar.b(c.b.a(i4, i3, i2, i, z2, z));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        super.a(vVar, a0Var, aVar, i);
        O();
        if (a0Var.a() > 0 && !a0Var.d()) {
            b(vVar, a0Var, aVar, i);
        }
        N();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
        r22.f1319b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.recyclerview.widget.RecyclerView.v r19, androidx.recyclerview.widget.RecyclerView.a0 r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean a(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int b(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        O();
        N();
        return super.b(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int b(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return this.I;
        }
        if (a0Var.a() < 1) {
            return 0;
        }
        return a(vVar, a0Var, a0Var.a() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void b(boolean z) {
        if (!z) {
            super.b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p c() {
        return this.s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(RecyclerView recyclerView) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            L();
        }
        super.e(vVar, a0Var);
        M();
    }

    int g(int i, int i2) {
        if (this.s != 1 || !I()) {
            int[] iArr = this.J;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.J;
        int i3 = this.I;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void g(RecyclerView.a0 a0Var) {
        super.g(a0Var);
        this.H = false;
    }

    public void k(int i) {
        if (i != this.I) {
            this.H = true;
            if (i >= 1) {
                this.I = i;
                this.N.a();
                y();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }
}
