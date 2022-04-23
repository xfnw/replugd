package androidx.recyclerview.widget;

import a.g.l.b0.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements a.g.l.q, a.g.l.j {
    private static final int[] A0 = {16843830};
    private static final int[] B0 = {16842987};
    static final boolean C0;
    static final boolean D0;
    static final boolean E0;
    static final boolean F0;
    private static final boolean G0;
    private static final boolean H0;
    private static final Class<?>[] I0;
    static final Interpolator J0;
    private int A;
    boolean B;
    private final AccessibilityManager C;
    private List<q> D;
    boolean E;
    boolean F;
    private int G;
    private int H;
    private k I;
    private EdgeEffect J;
    private EdgeEffect K;
    private EdgeEffect L;
    private EdgeEffect M;
    l N;
    private int O;
    private int P;
    private VelocityTracker Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private r W;
    private final int a0;

    /* renamed from: b  reason: collision with root package name */
    private final x f1330b;
    private final int b0;

    /* renamed from: c  reason: collision with root package name */
    final v f1331c;
    private float c0;

    /* renamed from: d  reason: collision with root package name */
    private y f1332d;
    private float d0;

    /* renamed from: e  reason: collision with root package name */
    androidx.recyclerview.widget.a f1333e;
    private boolean e0;
    androidx.recyclerview.widget.b f;
    final c0 f0;
    final androidx.recyclerview.widget.p g;
    androidx.recyclerview.widget.e g0;
    boolean h;
    e.b h0;
    final Runnable i;
    final a0 i0;
    final Rect j;
    private t j0;
    private final Rect k;
    private List<t> k0;
    final RectF l;
    boolean l0;
    g m;
    boolean m0;
    o n;
    private l.b n0;
    w o;
    boolean o0;
    final ArrayList<n> p;
    androidx.recyclerview.widget.l p0;
    private final ArrayList<s> q;
    private j q0;
    private s r;
    private final int[] r0;
    boolean s;
    private a.g.l.l s0;
    boolean t;
    private final int[] t0;
    boolean u;
    final int[] u0;
    boolean v;
    private final int[] v0;
    private int w;
    final int[] w0;
    boolean x;
    final List<d0> x0;
    boolean y;
    private Runnable y0;
    private boolean z;
    private final p.b z0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.v && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.s) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.y) {
                    recyclerView2.x = true;
                } else {
                    recyclerView2.b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a0 {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f1336b;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* renamed from: a  reason: collision with root package name */
        int f1335a = -1;

        /* renamed from: c  reason: collision with root package name */
        int f1337c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f1338d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f1339e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;

        public int a() {
            return this.h ? this.f1337c - this.f1338d : this.f;
        }

        void a(int i) {
            if ((this.f1339e & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1339e));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(g gVar) {
            this.f1339e = 1;
            this.f = gVar.a();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public int b() {
            return this.f1335a;
        }

        public boolean c() {
            return this.f1335a != -1;
        }

        public boolean d() {
            return this.h;
        }

        public boolean e() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1335a + ", mData=" + this.f1336b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.f1337c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1338d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.N;
            if (lVar != null) {
                lVar.i();
            }
            RecyclerView.this.o0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b0 {
        public abstract View a(v vVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c0 implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f1341b;

        /* renamed from: c  reason: collision with root package name */
        private int f1342c;

        /* renamed from: d  reason: collision with root package name */
        OverScroller f1343d;

        /* renamed from: e  reason: collision with root package name */
        Interpolator f1344e = RecyclerView.J0;
        private boolean f = false;
        private boolean g = false;

        c0() {
            this.f1343d = new OverScroller(RecyclerView.this.getContext(), RecyclerView.J0);
        }

        private float a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float a2 = f2 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            a.g.l.s.a(RecyclerView.this, this);
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f1342c = 0;
            this.f1341b = 0;
            this.f1343d.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1344e != interpolator) {
                this.f1344e = interpolator;
                this.f1343d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f1342c = 0;
            this.f1341b = 0;
            this.f1343d.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1343d.computeScrollOffset();
            }
            a();
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int a2 = a(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.J0;
            }
            a(i, i2, a2, interpolator);
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f1343d.abortAnimation();
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00e3, code lost:
            if (r8 > 0) goto L_0x00e7;
         */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00f6 A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 410
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c0.run():void");
        }
    }

    /* loaded from: classes.dex */
    class d implements p.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n.a(d0Var.f1346a, recyclerView.f1331c);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.a(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f1331c.c(d0Var);
            RecyclerView.this.b(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.a(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z = recyclerView.E;
            l lVar = recyclerView.N;
            if (z) {
                if (!lVar.a(d0Var, d0Var, cVar, cVar2)) {
                    return;
                }
            } else if (!lVar.c(d0Var, cVar, cVar2)) {
                return;
            }
            RecyclerView.this.s();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d0 {
        private static final List<Object> s = Collections.emptyList();

        /* renamed from: a  reason: collision with root package name */
        public final View f1346a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<RecyclerView> f1347b;
        int j;
        RecyclerView r;

        /* renamed from: c  reason: collision with root package name */
        int f1348c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1349d = -1;

        /* renamed from: e  reason: collision with root package name */
        long f1350e = -1;
        int f = -1;
        int g = -1;
        d0 h = null;
        d0 i = null;
        List<Object> k = null;
        List<Object> l = null;
        private int m = 0;
        v n = null;
        boolean o = false;
        private int p = 0;
        int q = -1;

        public d0(View view) {
            if (view != null) {
                this.f1346a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void A() {
            if (this.k == null) {
                this.k = new ArrayList();
                this.l = Collections.unmodifiableList(this.k);
            }
        }

        void a() {
            this.f1349d = -1;
            this.g = -1;
        }

        void a(int i) {
            this.j = i | this.j;
        }

        void a(int i, int i2) {
            this.j = (i & i2) | (this.j & (i2 ^ (-1)));
        }

        void a(int i, int i2, boolean z) {
            a(8);
            a(i2, z);
            this.f1348c = i;
        }

        void a(int i, boolean z) {
            if (this.f1349d == -1) {
                this.f1349d = this.f1348c;
            }
            if (this.g == -1) {
                this.g = this.f1348c;
            }
            if (z) {
                this.g += i;
            }
            this.f1348c += i;
            if (this.f1346a.getLayoutParams() != null) {
                ((p) this.f1346a.getLayoutParams()).f1376c = true;
            }
        }

        void a(v vVar, boolean z) {
            this.n = vVar;
            this.o = z;
        }

        void a(RecyclerView recyclerView) {
            int i = this.q;
            if (i == -1) {
                i = a.g.l.s.h(this.f1346a);
            }
            this.p = i;
            recyclerView.a(this, 4);
        }

        void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.j) == 0) {
                A();
                this.k.add(obj);
            }
        }

        public final void a(boolean z) {
            int i;
            int i2 = this.m;
            this.m = z ? i2 - 1 : i2 + 1;
            int i3 = this.m;
            if (i3 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.j | 16;
            } else if (z && this.m == 0) {
                i = this.j & (-17);
            } else {
                return;
            }
            this.j = i;
        }

        void b() {
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
        }

        void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.p);
            this.p = 0;
        }

        boolean b(int i) {
            return (i & this.j) != 0;
        }

        void c() {
            this.j &= -33;
        }

        void d() {
            this.j &= -257;
        }

        boolean e() {
            return (this.j & 16) == 0 && a.g.l.s.u(this.f1346a);
        }

        public final int f() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b(this);
        }

        public final long g() {
            return this.f1350e;
        }

        public final int h() {
            return this.f;
        }

        public final int i() {
            int i = this.g;
            return i == -1 ? this.f1348c : i;
        }

        public final int j() {
            return this.f1349d;
        }

        List<Object> k() {
            if ((this.j & 1024) != 0) {
                return s;
            }
            List<Object> list = this.k;
            return (list == null || list.size() == 0) ? s : this.l;
        }

        boolean l() {
            return (this.j & 512) != 0 || n();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean m() {
            return (this.j & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean n() {
            return (this.j & 4) != 0;
        }

        public final boolean o() {
            return (this.j & 16) == 0 && !a.g.l.s.u(this.f1346a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean p() {
            return (this.j & 8) != 0;
        }

        boolean q() {
            return this.n != null;
        }

        boolean r() {
            return (this.j & 256) != 0;
        }

        boolean s() {
            return (this.j & 2) != 0;
        }

        boolean t() {
            return (this.j & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f1348c + " id=" + this.f1350e + ", oldPos=" + this.f1349d + ", pLpos:" + this.g);
            if (q()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                sb.append(" invalid");
            }
            if (!m()) {
                sb.append(" unbound");
            }
            if (t()) {
                sb.append(" update");
            }
            if (p()) {
                sb.append(" removed");
            }
            if (x()) {
                sb.append(" ignored");
            }
            if (r()) {
                sb.append(" tmpDetached");
            }
            if (!o()) {
                sb.append(" not recyclable(" + this.m + ")");
            }
            if (l()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1346a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void u() {
            this.j = 0;
            this.f1348c = -1;
            this.f1349d = -1;
            this.f1350e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            b();
            this.p = 0;
            this.q = -1;
            RecyclerView.e(this);
        }

        void v() {
            if (this.f1349d == -1) {
                this.f1349d = this.f1348c;
            }
        }

        boolean w() {
            return (this.j & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean x() {
            return (this.j & 128) != 0;
        }

        void y() {
            this.n.c(this);
        }

        boolean z() {
            return (this.j & 32) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.AbstractC0044b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void a() {
            int b2 = b();
            for (int i = 0; i < b2; i++) {
                View a2 = a(i);
                RecyclerView.this.b(a2);
                a2.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void a(View view) {
            d0 k = RecyclerView.k(view);
            if (k != null) {
                k.a(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void a(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.a(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
            d0 k = RecyclerView.k(view);
            if (k != null) {
                if (k.r() || k.x()) {
                    k.d();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + k + RecyclerView.this.i());
                }
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public int b() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public d0 b(View view) {
            return RecyclerView.k(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void b(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.b(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void c(int i) {
            d0 k;
            View a2 = a(i);
            if (!(a2 == null || (k = RecyclerView.k(a2)) == null)) {
                if (!k.r() || k.x()) {
                    k.a(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + k + RecyclerView.this.i());
                }
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public void c(View view) {
            d0 k = RecyclerView.k(view);
            if (k != null) {
                k.b(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0044b
        public int d(View view) {
            return RecyclerView.this.indexOfChild(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.AbstractC0043a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public d0 a(int i) {
            d0 a2 = RecyclerView.this.a(i, true);
            if (a2 != null && !RecyclerView.this.f.c(a2.f1346a)) {
                return a2;
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void a(int i, int i2) {
            RecyclerView.this.g(i, i2);
            RecyclerView.this.l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a(i, i2, obj);
            RecyclerView.this.m0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void a(a.b bVar) {
            c(bVar);
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void b(int i, int i2) {
            RecyclerView.this.a(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l0 = true;
            recyclerView.i0.f1338d += i2;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void b(a.b bVar) {
            c(bVar);
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void c(int i, int i2) {
            RecyclerView.this.a(i, i2, false);
            RecyclerView.this.l0 = true;
        }

        void c(a.b bVar) {
            int i = bVar.f1418a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.n.a(recyclerView, bVar.f1419b, bVar.f1421d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.n.b(recyclerView2, bVar.f1419b, bVar.f1421d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.n.a(recyclerView3, bVar.f1419b, bVar.f1421d, bVar.f1420c);
            } else if (i == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.n.a(recyclerView4, bVar.f1419b, bVar.f1421d, 1);
            }
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0043a
        public void d(int i, int i2) {
            RecyclerView.this.f(i, i2);
            RecyclerView.this.l0 = true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<VH extends d0> {

        /* renamed from: a  reason: collision with root package name */
        private final h f1353a = new h();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1354b = false;

        public abstract int a();

        public long a(int i) {
            return -1L;
        }

        public final VH a(ViewGroup viewGroup, int i) {
            try {
                a.g.h.a.a("RV CreateView");
                VH b2 = b(viewGroup, i);
                if (b2.f1346a.getParent() == null) {
                    b2.f = i;
                    return b2;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                a.g.h.a.a();
            }
        }

        public final void a(int i, int i2) {
            this.f1353a.a(i, i2);
        }

        public final void a(VH vh, int i) {
            vh.f1348c = i;
            if (b()) {
                vh.f1350e = a(i);
            }
            vh.a(1, 519);
            a.g.h.a.a("RV OnBindView");
            a(vh, i, vh.k());
            vh.b();
            ViewGroup.LayoutParams layoutParams = vh.f1346a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f1376c = true;
            }
            a.g.h.a.a();
        }

        public void a(VH vh, int i, List<Object> list) {
            b((g<VH>) vh, i);
        }

        public void a(i iVar) {
            this.f1353a.registerObserver(iVar);
        }

        public void a(RecyclerView recyclerView) {
        }

        public boolean a(VH vh) {
            return false;
        }

        public int b(int i) {
            return 0;
        }

        public abstract VH b(ViewGroup viewGroup, int i);

        public void b(VH vh) {
        }

        public abstract void b(VH vh, int i);

        public void b(i iVar) {
            this.f1353a.unregisterObserver(iVar);
        }

        public void b(RecyclerView recyclerView) {
        }

        public final boolean b() {
            return this.f1354b;
        }

        public final void c() {
            this.f1353a.a();
        }

        public final void c(int i) {
            this.f1353a.b(i, 1);
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        h() {
        }

        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).b(i, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }

        public void b(int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private b f1355a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f1356b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f1357c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f1358d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f1359e = 250;
        private long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(d0 d0Var);
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f1360a;

            /* renamed from: b  reason: collision with root package name */
            public int f1361b;

            public c a(d0 d0Var) {
                a(d0Var, 0);
                return this;
            }

            public c a(d0 d0Var, int i) {
                View view = d0Var.f1346a;
                this.f1360a = view.getLeft();
                this.f1361b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i = d0Var.j & 14;
            if (d0Var.n()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int j = d0Var.j();
            int f = d0Var.f();
            return (j == -1 || f == -1 || j == f) ? i : i | 2048;
        }

        public c a(a0 a0Var, d0 d0Var) {
            c h = h();
            h.a(d0Var);
            return h;
        }

        public c a(a0 a0Var, d0 d0Var, int i, List<Object> list) {
            c h = h();
            h.a(d0Var);
            return h;
        }

        public final void a() {
            int size = this.f1356b.size();
            for (int i = 0; i < size; i++) {
                this.f1356b.get(i).a();
            }
            this.f1356b.clear();
        }

        void a(b bVar) {
            this.f1355a = bVar;
        }

        public abstract boolean a(d0 d0Var);

        public abstract boolean a(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public boolean a(d0 d0Var, List<Object> list) {
            return a(d0Var);
        }

        public final boolean a(a aVar) {
            boolean g = g();
            if (aVar != null) {
                if (!g) {
                    aVar.a();
                } else {
                    this.f1356b.add(aVar);
                }
            }
            return g;
        }

        public abstract void b();

        public final void b(d0 d0Var) {
            d(d0Var);
            b bVar = this.f1355a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public abstract boolean b(d0 d0Var, c cVar, c cVar2);

        public long c() {
            return this.f1357c;
        }

        public abstract void c(d0 d0Var);

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public long d() {
            return this.f;
        }

        public void d(d0 d0Var) {
        }

        public long e() {
            return this.f1359e;
        }

        public long f() {
            return this.f1358d;
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();
    }

    /* loaded from: classes.dex */
    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.a(true);
            if (d0Var.h != null && d0Var.i == null) {
                d0Var.h = null;
            }
            d0Var.i = null;
            if (!d0Var.w() && !RecyclerView.this.i(d0Var.f1346a) && d0Var.r()) {
                RecyclerView.this.removeDetachedView(d0Var.f1346a, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            a(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            a(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            b(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {

        /* renamed from: a  reason: collision with root package name */
        androidx.recyclerview.widget.b f1363a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f1364b;
        z g;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        /* renamed from: c  reason: collision with root package name */
        private final o.b f1365c = new a();

        /* renamed from: d  reason: collision with root package name */
        private final o.b f1366d = new b();

        /* renamed from: e  reason: collision with root package name */
        androidx.recyclerview.widget.o f1367e = new androidx.recyclerview.widget.o(this.f1365c);
        androidx.recyclerview.widget.o f = new androidx.recyclerview.widget.o(this.f1366d);
        boolean h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;

        /* loaded from: classes.dex */
        class a implements o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public int a() {
                return o.this.q() - o.this.o();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int a(View view) {
                return o.this.i(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i) {
                return o.this.c(i);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.n();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b(View view) {
                return o.this.f(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public int a() {
                return o.this.h() - o.this.m();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int a(View view) {
                return o.this.e(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i) {
                return o.this.c(i);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.p();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b(View view) {
                return o.this.j(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f1370a;

            /* renamed from: b  reason: collision with root package name */
            public int f1371b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f1372c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f1373d;
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = i - i3;
            i2 = 0;
            int max = Math.max(0, i5);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            max = max;
                        } else {
                            i2 = 0;
                            max = 0;
                        }
                    }
                    max = 0;
                }
                max = i4;
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i2 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i2 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i2);
        }

        public static d a(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.o.c.RecyclerView, i, i2);
            dVar.f1370a = obtainStyledAttributes.getInt(a.o.c.RecyclerView_android_orientation, 1);
            dVar.f1371b = obtainStyledAttributes.getInt(a.o.c.RecyclerView_spanCount, 1);
            dVar.f1372c = obtainStyledAttributes.getBoolean(a.o.c.RecyclerView_reverseLayout, false);
            dVar.f1373d = obtainStyledAttributes.getBoolean(a.o.c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        private void a(int i, View view) {
            this.f1363a.a(i);
        }

        private void a(View view, int i, boolean z) {
            d0 k = RecyclerView.k(view);
            if (z || k.p()) {
                this.f1364b.g.a(k);
            } else {
                this.f1364b.g.g(k);
            }
            p pVar = (p) view.getLayoutParams();
            if (k.z() || k.q()) {
                if (k.q()) {
                    k.y();
                } else {
                    k.c();
                }
                this.f1363a.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1364b) {
                int b2 = this.f1363a.b(view);
                if (i == -1) {
                    i = this.f1363a.a();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1364b.indexOfChild(view) + this.f1364b.i());
                } else if (b2 != i) {
                    this.f1364b.n.a(b2, i);
                }
            } else {
                this.f1363a.a(view, i, false);
                pVar.f1376c = true;
                z zVar = this.g;
                if (zVar != null && zVar.c()) {
                    this.g.a(view);
                }
            }
            if (pVar.f1377d) {
                k.f1346a.invalidate();
                pVar.f1377d = false;
            }
        }

        private void a(v vVar, int i, View view) {
            d0 k = RecyclerView.k(view);
            if (!k.x()) {
                if (!k.n() || k.p() || this.f1364b.m.b()) {
                    a(i);
                    vVar.c(view);
                    this.f1364b.g.d(k);
                    return;
                }
                g(i);
                vVar.b(k);
            }
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int n = n();
            int p = p();
            int q = q() - o();
            int h = h() - m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - n;
            int min = Math.min(0, i);
            int i2 = top - p;
            int min2 = Math.min(0, i2);
            int i3 = width - q;
            min = Math.max(0, i3);
            int max = Math.max(0, height - h);
            if (j() == 1) {
                if (min == 0) {
                    min = Math.max(min, i3);
                }
            } else if (min == 0) {
                min = Math.min(i, min);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max);
            }
            iArr[0] = min;
            iArr[1] = min2;
            return iArr;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n = n();
            int p = p();
            int q = q() - o();
            int h = h() - m();
            Rect rect = this.f1364b.j;
            b(focusedChild, rect);
            return rect.left - i < q && rect.right - i > n && rect.top - i2 < h && rect.bottom - i2 > p;
        }

        boolean A() {
            return false;
        }

        void B() {
            z zVar = this.g;
            if (zVar != null) {
                zVar.d();
            }
        }

        public boolean C() {
            return false;
        }

        public int a(int i, v vVar, a0 a0Var) {
            return 0;
        }

        public int a(a0 a0Var) {
            return 0;
        }

        public int a(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView == null || recyclerView.m == null || !a()) {
                return 1;
            }
            return this.f1364b.m.a();
        }

        public View a(View view, int i, v vVar, a0 a0Var) {
            return null;
        }

        public p a(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public p a(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public void a(int i) {
            a(i, c(i));
        }

        public void a(int i, int i2) {
            View c2 = c(i);
            if (c2 != null) {
                a(i);
                c(c2, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f1364b.toString());
        }

        public void a(int i, int i2, a0 a0Var, c cVar) {
        }

        public void a(int i, c cVar) {
        }

        public void a(int i, v vVar) {
            View c2 = c(i);
            g(i);
            vVar.b(c2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(a.g.l.b0.c cVar) {
            RecyclerView recyclerView = this.f1364b;
            a(recyclerView.f1331c, recyclerView.i0, cVar);
        }

        public void a(Rect rect, int i, int i2) {
            c(a(i, rect.width() + n() + o(), l()), a(i2, rect.height() + p() + m(), k()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void a(View view, int i, int i2) {
            p pVar = (p) view.getLayoutParams();
            Rect f = this.f1364b.f(view);
            int i3 = i + f.left + f.right;
            int i4 = i2 + f.top + f.bottom;
            int a2 = a(q(), r(), n() + o() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) pVar).width, a());
            int a3 = a(h(), i(), p() + m() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).height, b());
            if (a(view, a2, a3, pVar)) {
                view.measure(a2, a3);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f1375b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void a(View view, int i, p pVar) {
            d0 k = RecyclerView.k(view);
            if (k.p()) {
                this.f1364b.g.a(k);
            } else {
                this.f1364b.g.g(k);
            }
            this.f1363a.a(view, i, pVar, k.p());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, a.g.l.b0.c cVar) {
            d0 k = RecyclerView.k(view);
            if (k != null && !k.p() && !this.f1363a.c(k.f1346a)) {
                RecyclerView recyclerView = this.f1364b;
                a(recyclerView.f1331c, recyclerView.i0, view, cVar);
            }
        }

        public void a(View view, Rect rect) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.f(view));
            }
        }

        public void a(View view, v vVar) {
            o(view);
            vVar.b(view);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f1375b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f1364b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f1364b.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1364b;
            a(recyclerView.f1331c, recyclerView.i0, accessibilityEvent);
        }

        public void a(g gVar, g gVar2) {
        }

        public void a(v vVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                a(vVar, e2, c(e2));
            }
        }

        public void a(v vVar, a0 a0Var, int i, int i2) {
            this.f1364b.c(i, i2);
        }

        public void a(v vVar, a0 a0Var, a.g.l.b0.c cVar) {
            if (this.f1364b.canScrollVertically(-1) || this.f1364b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.c(true);
            }
            if (this.f1364b.canScrollVertically(1) || this.f1364b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.c(true);
            }
            cVar.a(c.a.a(b(vVar, a0Var), a(vVar, a0Var), d(vVar, a0Var), c(vVar, a0Var)));
        }

        public void a(v vVar, a0 a0Var, View view, a.g.l.b0.c cVar) {
            cVar.b(c.b.a(b() ? l(view) : 0, 1, a() ? l(view) : 0, 1, false, false));
        }

        public void a(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f1364b.canScrollVertically(-1) && !this.f1364b.canScrollHorizontally(-1) && !this.f1364b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                g gVar = this.f1364b.m;
                if (gVar != null) {
                    accessibilityEvent.setItemCount(gVar.a());
                }
            }
        }

        void a(RecyclerView recyclerView) {
            this.i = true;
            b(recyclerView);
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        void a(RecyclerView recyclerView, v vVar) {
            this.i = false;
            b(recyclerView, vVar);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public boolean a() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f1364b;
            return a(recyclerView.f1331c, recyclerView.i0, i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, p pVar) {
            return view.isLayoutRequested() || !this.k || !b(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) || !b(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f1364b;
            return a(recyclerView.f1331c, recyclerView.i0, view, i, bundle);
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.f1367e.a(view, 24579) && this.f.a(view, 24579);
            return z ? z3 : !z3;
        }

        public boolean a(p pVar) {
            return pVar != null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(androidx.recyclerview.widget.RecyclerView.v r2, androidx.recyclerview.widget.RecyclerView.a0 r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f1364b
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L_0x0042
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x006e
            L_0x0012:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x0029
                int r2 = r1.h()
                int r5 = r1.p()
                int r2 = r2 - r5
                int r5 = r1.m()
                int r2 = r2 - r5
                int r2 = -r2
                goto L_0x002a
            L_0x0029:
                r2 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f1364b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
                int r4 = -r4
                goto L_0x006e
            L_0x0042:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L_0x0057
                int r2 = r1.h()
                int r4 = r1.p()
                int r2 = r2 - r4
                int r4 = r1.m()
                int r2 = r2 - r4
                goto L_0x0058
            L_0x0057:
                r2 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f1364b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
            L_0x006e:
                if (r2 != 0) goto L_0x0073
                if (r4 != 0) goto L_0x0073
                return r3
            L_0x0073:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f1364b
                r3.i(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.a(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, int, android.os.Bundle):boolean");
        }

        public boolean a(v vVar, a0 a0Var, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i = b2[0];
            int i2 = b2[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.i(i, i2);
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return w() || recyclerView.n();
        }

        public boolean a(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int b(int i, v vVar, a0 a0Var) {
            return 0;
        }

        public int b(a0 a0Var) {
            return 0;
        }

        public int b(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView == null || recyclerView.m == null || !b()) {
                return 1;
            }
            return this.f1364b.m.a();
        }

        public View b(int i) {
            int e2 = e();
            for (int i2 = 0; i2 < e2; i2++) {
                View c2 = c(i2);
                d0 k = RecyclerView.k(c2);
                if (k != null && k.i() == i && !k.x() && (this.f1364b.i0.d() || !k.p())) {
                    return c2;
                }
            }
            return null;
        }

        void b(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            this.o = View.MeasureSpec.getMode(i);
            if (this.o == 0 && !RecyclerView.D0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            this.p = View.MeasureSpec.getMode(i2);
            if (this.p == 0 && !RecyclerView.D0) {
                this.r = 0;
            }
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public void b(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public void b(v vVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                if (!RecyclerView.k(c(e2)).x()) {
                    a(e2, vVar);
                }
            }
        }

        public void b(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public void b(RecyclerView recyclerView, v vVar) {
            c(recyclerView);
        }

        public boolean b() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, p pVar) {
            return !this.k || !b(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) || !b(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height);
        }

        public int c(a0 a0Var) {
            return 0;
        }

        public int c(v vVar, a0 a0Var) {
            return 0;
        }

        public View c(int i) {
            androidx.recyclerview.widget.b bVar = this.f1363a;
            if (bVar != null) {
                return bVar.c(i);
            }
            return null;
        }

        public View c(View view) {
            View c2;
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView == null || (c2 = recyclerView.c(view)) == null || this.f1363a.c(c2)) {
                return null;
            }
            return c2;
        }

        public abstract p c();

        public void c(int i, int i2) {
            this.f1364b.setMeasuredDimension(i, i2);
        }

        public void c(View view, int i) {
            a(view, i, (p) view.getLayoutParams());
        }

        void c(v vVar) {
            int e2 = vVar.e();
            for (int i = e2 - 1; i >= 0; i--) {
                View c2 = vVar.c(i);
                d0 k = RecyclerView.k(c2);
                if (!k.x()) {
                    k.a(false);
                    if (k.r()) {
                        this.f1364b.removeDetachedView(c2, false);
                    }
                    l lVar = this.f1364b.N;
                    if (lVar != null) {
                        lVar.c(k);
                    }
                    k.a(true);
                    vVar.a(c2);
                }
            }
            vVar.c();
            if (e2 > 0) {
                this.f1364b.invalidate();
            }
        }

        @Deprecated
        public void c(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public int d() {
            return -1;
        }

        public int d(View view) {
            return ((p) view.getLayoutParams()).f1375b.bottom;
        }

        public int d(a0 a0Var) {
            return 0;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                recyclerView.e(i);
            }
        }

        void d(int i, int i2) {
            int e2 = e();
            if (e2 == 0) {
                this.f1364b.c(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < e2; i7++) {
                View c2 = c(i7);
                Rect rect = this.f1364b.j;
                b(c2, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.f1364b.j.set(i3, i4, i5, i6);
            a(this.f1364b.j, i, i2);
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d(v vVar, a0 a0Var) {
            return false;
        }

        public int e() {
            androidx.recyclerview.widget.b bVar = this.f1363a;
            if (bVar != null) {
                return bVar.a();
            }
            return 0;
        }

        public int e(View view) {
            return view.getBottom() + d(view);
        }

        public int e(a0 a0Var) {
            return 0;
        }

        public void e(int i) {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                recyclerView.f(i);
            }
        }

        public void e(v vVar, a0 a0Var) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void e(RecyclerView recyclerView) {
            b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int f(View view) {
            return view.getLeft() - k(view);
        }

        public int f(a0 a0Var) {
            return 0;
        }

        public void f(int i) {
        }

        void f(RecyclerView recyclerView) {
            int i;
            if (recyclerView == null) {
                this.f1364b = null;
                this.f1363a = null;
                i = 0;
                this.q = 0;
            } else {
                this.f1364b = recyclerView;
                this.f1363a = recyclerView.f;
                this.q = recyclerView.getWidth();
                i = recyclerView.getHeight();
            }
            this.r = i;
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public boolean f() {
            RecyclerView recyclerView = this.f1364b;
            return recyclerView != null && recyclerView.h;
        }

        public int g(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1375b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public View g() {
            View focusedChild;
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1363a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void g(int i) {
            if (c(i) != null) {
                this.f1363a.e(i);
            }
        }

        public void g(a0 a0Var) {
        }

        public int h() {
            return this.r;
        }

        public int h(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1375b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void h(int i) {
        }

        public int i() {
            return this.p;
        }

        public int i(View view) {
            return view.getRight() + m(view);
        }

        public int j() {
            return a.g.l.s.j(this.f1364b);
        }

        public int j(View view) {
            return view.getTop() - n(view);
        }

        public int k() {
            return a.g.l.s.k(this.f1364b);
        }

        public int k(View view) {
            return ((p) view.getLayoutParams()).f1375b.left;
        }

        public int l() {
            return a.g.l.s.l(this.f1364b);
        }

        public int l(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public int m() {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int m(View view) {
            return ((p) view.getLayoutParams()).f1375b.right;
        }

        public int n() {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int n(View view) {
            return ((p) view.getLayoutParams()).f1375b.top;
        }

        public int o() {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void o(View view) {
            this.f1363a.d(view);
        }

        public int p() {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int q() {
            return this.q;
        }

        public int r() {
            return this.o;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            int e2 = e();
            for (int i = 0; i < e2; i++) {
                ViewGroup.LayoutParams layoutParams = c(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean t() {
            return this.i;
        }

        public boolean u() {
            return this.j;
        }

        public final boolean v() {
            return this.l;
        }

        public boolean w() {
            z zVar = this.g;
            return zVar != null && zVar.c();
        }

        public Parcelable x() {
            return null;
        }

        public void y() {
            RecyclerView recyclerView = this.f1364b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void z() {
            this.h = true;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        d0 f1374a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f1375b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f1376c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f1377d = false;

        public p(int i, int i2) {
            super(i, i2);
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
        }

        public int a() {
            return this.f1374a.i();
        }

        public boolean b() {
            return this.f1374a.s();
        }

        public boolean c() {
            return this.f1374a.p();
        }

        public boolean d() {
            return this.f1374a.n();
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class r {
        public abstract boolean a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface s {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public static class u {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f1378a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f1379b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<d0> f1380a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f1381b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f1382c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f1383d = 0;

            a() {
            }
        }

        private a b(int i) {
            a aVar = this.f1378a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1378a.put(i, aVar2);
            return aVar2;
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public d0 a(int i) {
            a aVar = this.f1378a.get(i);
            if (aVar == null || aVar.f1380a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f1380a;
            return arrayList.remove(arrayList.size() - 1);
        }

        void a() {
            this.f1379b++;
        }

        void a(int i, long j) {
            a b2 = b(i);
            b2.f1383d = a(b2.f1383d, j);
        }

        public void a(d0 d0Var) {
            int h = d0Var.h();
            ArrayList<d0> arrayList = b(h).f1380a;
            if (this.f1378a.get(h).f1381b > arrayList.size()) {
                d0Var.u();
                arrayList.add(d0Var);
            }
        }

        void a(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.f1379b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).f1383d;
            return j3 == 0 || j + j3 < j2;
        }

        public void b() {
            for (int i = 0; i < this.f1378a.size(); i++) {
                this.f1378a.valueAt(i).f1380a.clear();
            }
        }

        void b(int i, long j) {
            a b2 = b(i);
            b2.f1382c = a(b2.f1382c, j);
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).f1382c;
            return j3 == 0 || j + j3 < j2;
        }

        void c() {
            this.f1379b--;
        }
    }

    /* loaded from: classes.dex */
    public final class v {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<d0> f1384a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<d0> f1385b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<d0> f1386c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private final List<d0> f1387d = Collections.unmodifiableList(this.f1384a);

        /* renamed from: e  reason: collision with root package name */
        private int f1388e = 2;
        int f = 2;
        u g;
        private b0 h;

        public v() {
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private boolean a(d0 d0Var, int i, int i2, long j) {
            d0Var.r = RecyclerView.this;
            int h = d0Var.h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.g.a(h, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.m.a((g) d0Var, i);
            this.g.a(d0Var.h(), RecyclerView.this.getNanoTime() - nanoTime);
            e(d0Var);
            if (!RecyclerView.this.i0.d()) {
                return true;
            }
            d0Var.g = i2;
            return true;
        }

        private void e(d0 d0Var) {
            if (RecyclerView.this.m()) {
                View view = d0Var.f1346a;
                if (a.g.l.s.h(view) == 0) {
                    a.g.l.s.e(view, 1);
                }
                if (!a.g.l.s.r(view)) {
                    d0Var.a(16384);
                    a.g.l.s.a(view, RecyclerView.this.p0.b());
                }
            }
        }

        private void f(d0 d0Var) {
            View view = d0Var.f1346a;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        public int a(int i) {
            if (i >= 0 && i < RecyclerView.this.i0.a()) {
                return !RecyclerView.this.i0.d() ? i : RecyclerView.this.f1333e.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.i0.a() + RecyclerView.this.i());
        }

        d0 a(int i, boolean z) {
            View b2;
            int size = this.f1384a.size();
            for (int i2 = 0; i2 < size; i2++) {
                d0 d0Var = this.f1384a.get(i2);
                if (!d0Var.z() && d0Var.i() == i && !d0Var.n() && (RecyclerView.this.i0.h || !d0Var.p())) {
                    d0Var.a(32);
                    return d0Var;
                }
            }
            if (z || (b2 = RecyclerView.this.f.b(i)) == null) {
                int size2 = this.f1386c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d0 d0Var2 = this.f1386c.get(i3);
                    if (!d0Var2.n() && d0Var2.i() == i) {
                        if (!z) {
                            this.f1386c.remove(i3);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 k = RecyclerView.k(b2);
            RecyclerView.this.f.f(b2);
            int b3 = RecyclerView.this.f.b(b2);
            if (b3 != -1) {
                RecyclerView.this.f.a(b3);
                c(b2);
                k.a(8224);
                return k;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + k + RecyclerView.this.i());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0225 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0210  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.RecyclerView.d0 a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 614
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        d0 a(long j, int i, boolean z) {
            for (int size = this.f1384a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1384a.get(size);
                if (d0Var.g() == j && !d0Var.z()) {
                    if (i == d0Var.h()) {
                        d0Var.a(32);
                        if (d0Var.p() && !RecyclerView.this.i0.d()) {
                            d0Var.a(2, 14);
                        }
                        return d0Var;
                    } else if (!z) {
                        this.f1384a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f1346a, false);
                        a(d0Var.f1346a);
                    }
                }
            }
            int size2 = this.f1386c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f1386c.get(size2);
                if (d0Var2.g() == j) {
                    if (i == d0Var2.h()) {
                        if (!z) {
                            this.f1386c.remove(size2);
                        }
                        return d0Var2;
                    } else if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        public void a() {
            this.f1384a.clear();
            i();
        }

        void a(int i, int i2) {
            int size = this.f1386c.size();
            for (int i3 = 0; i3 < size; i3++) {
                d0 d0Var = this.f1386c.get(i3);
                if (d0Var != null && d0Var.f1348c >= i) {
                    d0Var.a(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1386c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1386c.get(size);
                if (d0Var != null) {
                    int i4 = d0Var.f1348c;
                    if (i4 >= i3) {
                        d0Var.a(-i2, z);
                    } else if (i4 >= i) {
                        d0Var.a(8);
                        e(size);
                    }
                }
            }
        }

        void a(View view) {
            d0 k = RecyclerView.k(view);
            k.n = null;
            k.o = false;
            k.c();
            b(k);
        }

        void a(b0 b0Var) {
            this.h = b0Var;
        }

        void a(d0 d0Var) {
            w wVar = RecyclerView.this.o;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.m;
            if (gVar != null) {
                gVar.d(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.i0 != null) {
                recyclerView.g.h(d0Var);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(d0 d0Var, boolean z) {
            RecyclerView.e(d0Var);
            if (d0Var.b(16384)) {
                d0Var.a(0, 16384);
                a.g.l.s.a(d0Var.f1346a, (a.g.l.a) null);
            }
            if (z) {
                a(d0Var);
            }
            d0Var.r = null;
            d().a(d0Var);
        }

        void a(g gVar, g gVar2, boolean z) {
            a();
            d().a(gVar, gVar2, z);
        }

        void a(u uVar) {
            u uVar2 = this.g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.g = uVar;
            if (this.g != null && RecyclerView.this.getAdapter() != null) {
                this.g.a();
            }
        }

        View b(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).f1346a;
        }

        d0 b(int i) {
            int size;
            int b2;
            ArrayList<d0> arrayList = this.f1385b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                for (int i2 = 0; i2 < size; i2++) {
                    d0 d0Var = this.f1385b.get(i2);
                    if (!d0Var.z() && d0Var.i() == i) {
                        d0Var.a(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.m.b() && (b2 = RecyclerView.this.f1333e.b(i)) > 0 && b2 < RecyclerView.this.m.a()) {
                    long a2 = RecyclerView.this.m.a(b2);
                    for (int i3 = 0; i3 < size; i3++) {
                        d0 d0Var2 = this.f1385b.get(i3);
                        if (!d0Var2.z() && d0Var2.g() == a2) {
                            d0Var2.a(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        void b() {
            int size = this.f1386c.size();
            for (int i = 0; i < size; i++) {
                this.f1386c.get(i).a();
            }
            int size2 = this.f1384a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f1384a.get(i2).a();
            }
            ArrayList<d0> arrayList = this.f1385b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f1385b.get(i3).a();
                }
            }
        }

        void b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i5 = i;
                i4 = i2;
                i3 = -1;
            } else {
                i4 = i;
                i5 = i2;
                i3 = 1;
            }
            int size = this.f1386c.size();
            for (int i7 = 0; i7 < size; i7++) {
                d0 d0Var = this.f1386c.get(i7);
                if (d0Var != null && (i6 = d0Var.f1348c) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        d0Var.a(i2 - i, false);
                    } else {
                        d0Var.a(i3, false);
                    }
                }
            }
        }

        public void b(View view) {
            d0 k = RecyclerView.k(view);
            if (k.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (k.q()) {
                k.y();
            } else if (k.z()) {
                k.c();
            }
            b(k);
        }

        void b(d0 d0Var) {
            boolean z;
            boolean z2 = false;
            if (d0Var.q() || d0Var.f1346a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.q());
                sb.append(" isAttached:");
                if (d0Var.f1346a.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb.toString());
            } else if (d0Var.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.i());
            } else if (!d0Var.x()) {
                boolean e2 = d0Var.e();
                g gVar = RecyclerView.this.m;
                if ((gVar != null && e2 && gVar.a((g) d0Var)) || d0Var.o()) {
                    if (this.f <= 0 || d0Var.b(526)) {
                        z = false;
                    } else {
                        int size = this.f1386c.size();
                        if (size >= this.f && size > 0) {
                            e(0);
                            size--;
                        }
                        if (RecyclerView.F0 && size > 0 && !RecyclerView.this.h0.a(d0Var.f1348c)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.h0.a(this.f1386c.get(i).f1348c)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f1386c.add(size, d0Var);
                        z = true;
                    }
                    if (!z) {
                        a(d0Var, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.g.h(d0Var);
                if (!z && !z2 && e2) {
                    d0Var.r = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.i());
            }
        }

        View c(int i) {
            return this.f1384a.get(i).f1346a;
        }

        void c() {
            this.f1384a.clear();
            ArrayList<d0> arrayList = this.f1385b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f1386c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1386c.get(size);
                if (d0Var != null && (i3 = d0Var.f1348c) >= i && i3 < i4) {
                    d0Var.a(2);
                    e(size);
                }
            }
        }

        void c(View view) {
            ArrayList<d0> arrayList;
            d0 k = RecyclerView.k(view);
            if (!k.b(12) && k.s() && !RecyclerView.this.a(k)) {
                if (this.f1385b == null) {
                    this.f1385b = new ArrayList<>();
                }
                k.a(this, true);
                arrayList = this.f1385b;
            } else if (!k.n() || k.p() || RecyclerView.this.m.b()) {
                k.a(this, false);
                arrayList = this.f1384a;
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.i());
            }
            arrayList.add(k);
        }

        void c(d0 d0Var) {
            (d0Var.o ? this.f1385b : this.f1384a).remove(d0Var);
            d0Var.n = null;
            d0Var.o = false;
            d0Var.c();
        }

        public View d(int i) {
            return b(i, false);
        }

        u d() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }

        boolean d(d0 d0Var) {
            if (d0Var.p()) {
                return RecyclerView.this.i0.d();
            }
            int i = d0Var.f1348c;
            if (i < 0 || i >= RecyclerView.this.m.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.i());
            } else if (RecyclerView.this.i0.d() || RecyclerView.this.m.b(d0Var.f1348c) == d0Var.h()) {
                return !RecyclerView.this.m.b() || d0Var.g() == RecyclerView.this.m.a(d0Var.f1348c);
            } else {
                return false;
            }
        }

        int e() {
            return this.f1384a.size();
        }

        void e(int i) {
            a(this.f1386c.get(i), true);
            this.f1386c.remove(i);
        }

        public List<d0> f() {
            return this.f1387d;
        }

        public void f(int i) {
            this.f1388e = i;
            j();
        }

        void g() {
            int size = this.f1386c.size();
            for (int i = 0; i < size; i++) {
                p pVar = (p) this.f1386c.get(i).f1346a.getLayoutParams();
                if (pVar != null) {
                    pVar.f1376c = true;
                }
            }
        }

        void h() {
            int size = this.f1386c.size();
            for (int i = 0; i < size; i++) {
                d0 d0Var = this.f1386c.get(i);
                if (d0Var != null) {
                    d0Var.a(6);
                    d0Var.a((Object) null);
                }
            }
            g gVar = RecyclerView.this.m;
            if (gVar == null || !gVar.b()) {
                i();
            }
        }

        void i() {
            for (int size = this.f1386c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.f1386c.clear();
            if (RecyclerView.F0) {
                RecyclerView.this.h0.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void j() {
            o oVar = RecyclerView.this.n;
            this.f = this.f1388e + (oVar != null ? oVar.m : 0);
            for (int size = this.f1386c.size() - 1; size >= 0 && this.f1386c.size() > this.f; size--) {
                e(size);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a(d0 d0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.i0.g = true;
            recyclerView.b(true);
            if (!RecyclerView.this.f1333e.c()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f1333e.a(i, i2, obj)) {
                b();
            }
        }

        void b() {
            if (RecyclerView.E0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.t && recyclerView.s) {
                    a.g.l.s.a(recyclerView, recyclerView.i);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i, int i2) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f1333e.b(i, i2)) {
                b();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class y extends a.i.a.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        Parcelable f1390d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<y> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public y[] newArray(int i) {
                return new y[i];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1390d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }

        void a(y yVar) {
            this.f1390d = yVar.f1390d;
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1390d, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class z {

        /* loaded from: classes.dex */
        public interface a {
        }

        public abstract int a();

        public abstract void a(int i);

        abstract void a(int i, int i2);

        protected abstract void a(View view);

        public abstract boolean b();

        public abstract boolean c();

        protected final void d() {
            throw null;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        C0 = i2 == 18 || i2 == 19 || i2 == 20;
        D0 = Build.VERSION.SDK_INT >= 23;
        E0 = Build.VERSION.SDK_INT >= 16;
        F0 = Build.VERSION.SDK_INT >= 21;
        G0 = Build.VERSION.SDK_INT <= 15;
        H0 = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        I0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        J0 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1330b = new x();
        this.f1331c = new v();
        this.g = new androidx.recyclerview.widget.p();
        this.i = new a();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new k();
        this.N = new androidx.recyclerview.widget.c();
        this.O = 0;
        this.P = -1;
        this.c0 = Float.MIN_VALUE;
        this.d0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.e0 = true;
        this.f0 = new c0();
        this.h0 = F0 ? new e.b() : null;
        this.i0 = new a0();
        this.l0 = false;
        this.m0 = false;
        this.n0 = new m();
        this.o0 = false;
        this.r0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new int[2];
        this.w0 = new int[2];
        this.x0 = new ArrayList();
        this.y0 = new b();
        this.z0 = new d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B0, i2, 0);
            this.h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.c0 = a.g.l.t.b(viewConfiguration, context);
        this.d0 = a.g.l.t.c(viewConfiguration, context);
        this.a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.a(this.n0);
        k();
        G();
        F();
        if (a.g.l.s.h(this) == 0) {
            a.g.l.s.e(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.l(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.o.c.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.o.c.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.o.c.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.u = obtainStyledAttributes2.getBoolean(a.o.c.RecyclerView_fastScrollEnabled, false);
            if (this.u) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(a.o.c.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.o.c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.o.c.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.o.c.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, A0, i2, 0);
                z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    private void A() {
        boolean z2 = true;
        this.i0.a(1);
        a(this.i0);
        this.i0.j = false;
        w();
        this.g.a();
        q();
        I();
        N();
        a0 a0Var = this.i0;
        if (!a0Var.k || !this.m0) {
            z2 = false;
        }
        a0Var.i = z2;
        this.m0 = false;
        this.l0 = false;
        a0 a0Var2 = this.i0;
        a0Var2.h = a0Var2.l;
        a0Var2.f = this.m.a();
        a(this.r0);
        if (this.i0.k) {
            int a2 = this.f.a();
            for (int i2 = 0; i2 < a2; i2++) {
                d0 k2 = k(this.f.c(i2));
                if (!k2.x() && (!k2.n() || this.m.b())) {
                    this.g.c(k2, this.N.a(this.i0, k2, l.e(k2), k2.k()));
                    if (this.i0.i && k2.s() && !k2.p() && !k2.x() && !k2.n()) {
                        this.g.a(c(k2), k2);
                    }
                }
            }
        }
        if (this.i0.l) {
            v();
            a0 a0Var3 = this.i0;
            boolean z3 = a0Var3.g;
            a0Var3.g = false;
            this.n.e(this.f1331c, a0Var3);
            this.i0.g = z3;
            for (int i3 = 0; i3 < this.f.a(); i3++) {
                d0 k3 = k(this.f.c(i3));
                if (!k3.x() && !this.g.c(k3)) {
                    int e2 = l.e(k3);
                    boolean b2 = k3.b(8192);
                    if (!b2) {
                        e2 |= 4096;
                    }
                    l.c a3 = this.N.a(this.i0, k3, e2, k3.k());
                    if (b2) {
                        a(k3, a3);
                    } else {
                        this.g.a(k3, a3);
                    }
                }
            }
        }
        a();
        r();
        c(false);
        this.i0.f1339e = 2;
    }

    private void B() {
        w();
        q();
        this.i0.a(6);
        this.f1333e.b();
        this.i0.f = this.m.a();
        a0 a0Var = this.i0;
        a0Var.f1338d = 0;
        a0Var.h = false;
        this.n.e(this.f1331c, a0Var);
        a0 a0Var2 = this.i0;
        a0Var2.g = false;
        this.f1332d = null;
        a0Var2.k = a0Var2.k && this.N != null;
        this.i0.f1339e = 4;
        r();
        c(false);
    }

    private void C() {
        this.i0.a(4);
        w();
        q();
        a0 a0Var = this.i0;
        a0Var.f1339e = 1;
        if (a0Var.k) {
            for (int a2 = this.f.a() - 1; a2 >= 0; a2--) {
                d0 k2 = k(this.f.c(a2));
                if (!k2.x()) {
                    long c2 = c(k2);
                    l.c a3 = this.N.a(this.i0, k2);
                    d0 a4 = this.g.a(c2);
                    if (a4 != null && !a4.x()) {
                        boolean b2 = this.g.b(a4);
                        boolean b3 = this.g.b(k2);
                        if (!b2 || a4 != k2) {
                            l.c f2 = this.g.f(a4);
                            this.g.b(k2, a3);
                            l.c e2 = this.g.e(k2);
                            if (f2 == null) {
                                a(c2, k2, a4);
                            } else {
                                a(a4, k2, f2, e2, b2, b3);
                            }
                        }
                    }
                    this.g.b(k2, a3);
                }
            }
            this.g.a(this.z0);
        }
        this.n.c(this.f1331c);
        a0 a0Var2 = this.i0;
        a0Var2.f1337c = a0Var2.f;
        this.E = false;
        this.F = false;
        a0Var2.k = false;
        a0Var2.l = false;
        this.n.h = false;
        ArrayList<d0> arrayList = this.f1331c.f1385b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.n;
        if (oVar.n) {
            oVar.m = 0;
            oVar.n = false;
            this.f1331c.j();
        }
        this.n.g(this.i0);
        r();
        c(false);
        this.g.a();
        int[] iArr = this.r0;
        if (k(iArr[0], iArr[1])) {
            d(0, 0);
        }
        J();
        L();
    }

    private View D() {
        d0 c2;
        int i2 = this.i0.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int a2 = this.i0.a();
        for (int i3 = i2; i3 < a2; i3++) {
            d0 c3 = c(i3);
            if (c3 == null) {
                break;
            } else if (c3.f1346a.hasFocusable()) {
                return c3.f1346a;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0 || (c2 = c(min)) == null) {
                return null;
            }
            if (c2.f1346a.hasFocusable()) {
                return c2.f1346a;
            }
        }
    }

    private boolean E() {
        int a2 = this.f.a();
        for (int i2 = 0; i2 < a2; i2++) {
            d0 k2 = k(this.f.c(i2));
            if (!(k2 == null || k2.x() || !k2.s())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void F() {
        if (a.g.l.s.i(this) == 0) {
            a.g.l.s.f(this, 8);
        }
    }

    private void G() {
        this.f = new androidx.recyclerview.widget.b(new e());
    }

    private boolean H() {
        return this.N != null && this.n.C();
    }

    private void I() {
        if (this.E) {
            this.f1333e.f();
            if (this.F) {
                this.n.d(this);
            }
        }
        if (H()) {
            this.f1333e.e();
        } else {
            this.f1333e.b();
        }
        boolean z2 = false;
        boolean z3 = this.l0 || this.m0;
        this.i0.k = this.v && this.N != null && (this.E || z3 || this.n.h) && (!this.E || this.m.b());
        a0 a0Var = this.i0;
        if (a0Var.k && z3 && !this.E && H()) {
            z2 = true;
        }
        a0Var.l = z2;
    }

    private void J() {
        View view;
        if (this.e0 && this.m != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!H0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f.c(focusedChild)) {
                            return;
                        }
                    } else if (this.f.a() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                d0 a2 = (this.i0.n == -1 || !this.m.b()) ? null : a(this.i0.n);
                if (a2 != null && !this.f.c(a2.f1346a) && a2.f1346a.hasFocusable()) {
                    view2 = a2.f1346a;
                } else if (this.f.a() > 0) {
                    view2 = D();
                }
                if (view2 != null) {
                    int i2 = this.i0.o;
                    if (i2 == -1 || (view = view2.findViewById(i2)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void K() {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.J.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            a.g.l.s.z(this);
        }
    }

    private void L() {
        a0 a0Var = this.i0;
        a0Var.n = -1L;
        a0Var.m = -1;
        a0Var.o = -1;
    }

    private void M() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        K();
    }

    private void N() {
        d0 d0Var = null;
        View focusedChild = (!this.e0 || !hasFocus() || this.m == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            d0Var = d(focusedChild);
        }
        if (d0Var == null) {
            L();
            return;
        }
        this.i0.n = this.m.b() ? d0Var.g() : -1L;
        this.i0.m = this.E ? -1 : d0Var.p() ? d0Var.f1349d : d0Var.f();
        this.i0.o = l(d0Var.f1346a);
    }

    private void O() {
        this.f0.b();
        o oVar = this.n;
        if (oVar != null) {
            oVar.B();
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.f()
            android.widget.EdgeEffect r3 = r6.J
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L_0x001c:
            androidx.core.widget.d.a(r3, r4, r9)
            r9 = 1
            goto L_0x0039
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0038
            r6.g()
            android.widget.EdgeEffect r3 = r6.L
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L_0x001c
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0053
            r6.h()
            android.widget.EdgeEffect r9 = r6.K
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L_0x006f
        L_0x0053:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x006e
            r6.e()
            android.widget.EdgeEffect r9 = r6.M
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L_0x006f
        L_0x006e:
            r1 = r9
        L_0x006f:
            if (r1 != 0) goto L_0x0079
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0079
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007c
        L_0x0079:
            a.g.l.s.z(r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void a(long j2, d0 d0Var, d0 d0Var2) {
        int a2 = this.f.a();
        for (int i2 = 0; i2 < a2; i2++) {
            d0 k2 = k(this.f.c(i2));
            if (k2 != d0Var && c(k2) == j2) {
                g gVar = this.m;
                if (gVar == null || !gVar.b()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + k2 + " \n View Holder 2:" + d0Var + i());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + k2 + " \n View Holder 2:" + d0Var + i());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + i());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a(context, trim);
                try {
                    Class<? extends U> asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(a2).asSubclass(o.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(I0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((o) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e8);
                }
            }
        }
    }

    static void a(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f1375b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f1376c) {
                Rect rect = pVar.f1375b;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        this.n.a(this, view, this.j, !this.v, view2 == null);
    }

    private void a(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d0Var.a(false);
        if (z2) {
            d(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                d(d0Var2);
            }
            d0Var.h = d0Var2;
            d(d0Var);
            this.f1331c.c(d0Var);
            d0Var2.a(false);
            d0Var2.i = d0Var;
        }
        if (this.N.a(d0Var, d0Var2, cVar, cVar2)) {
            s();
        }
    }

    private void a(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.b(this.f1330b);
            this.m.b(this);
        }
        if (!z2 || z3) {
            t();
        }
        this.f1333e.f();
        g gVar3 = this.m;
        this.m = gVar;
        if (gVar != null) {
            gVar.a(this.f1330b);
            gVar.a(this);
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.a(gVar3, this.m);
        }
        this.f1331c.a(gVar3, this.m, z2);
        this.i0.g = true;
    }

    private void a(int[] iArr) {
        int a2 = this.f.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            d0 k2 = k(this.f.c(i4));
            if (!k2.x()) {
                int i5 = k2.i();
                if (i5 < i2) {
                    i2 = i5;
                }
                if (i5 > i3) {
                    i3 = i5;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        s sVar = this.r;
        if (sVar != null) {
            if (action == 0) {
                this.r = null;
            } else {
                sVar.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.r = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                s sVar2 = this.q.get(i2);
                if (sVar2.a(this, motionEvent)) {
                    this.r = sVar2;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.j.set(0, 0, view.getWidth(), view.getHeight());
        this.k.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.j);
        offsetDescendantRectToMyCoords(view2, this.k);
        char c2 = 65535;
        int i4 = this.n.j() == 1 ? -1 : 1;
        Rect rect = this.j;
        int i5 = rect.left;
        int i6 = this.k.left;
        if ((i5 < i6 || rect.right <= i6) && this.j.right < this.k.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.j;
            int i7 = rect2.right;
            int i8 = this.k.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.j.left > this.k.left) ? -1 : 0;
        }
        Rect rect3 = this.j;
        int i9 = rect3.top;
        int i10 = this.k.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.j.bottom < this.k.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.j;
            int i11 = rect4.bottom;
            int i12 = this.k.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.j.top <= this.k.top) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + i());
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.r = null;
        }
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.q.get(i2);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.r = sVar;
                return true;
            }
        }
        return false;
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.U = y2;
            this.S = y2;
        }
    }

    private void d(d0 d0Var) {
        View view = d0Var.f1346a;
        boolean z2 = view.getParent() == this;
        this.f1331c.c(e(view));
        if (d0Var.r()) {
            this.f.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.f;
        if (!z2) {
            bVar.a(view, true);
        } else {
            bVar.a(view);
        }
    }

    static void e(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f1347b;
        if (weakReference != null) {
            ViewParent viewParent = weakReference.get();
            while (true) {
                for (View view = (View) viewParent; view != null; view = null) {
                    if (view != d0Var.f1346a) {
                        viewParent = view.getParent();
                        if (viewParent instanceof View) {
                            break;
                        }
                    } else {
                        return;
                    }
                }
                d0Var.f1347b = null;
                return;
            }
        }
    }

    private a.g.l.l getScrollingChildHelper() {
        if (this.s0 == null) {
            this.s0 = new a.g.l.l(this);
        }
        return this.s0;
    }

    static RecyclerView j(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView j2 = j(viewGroup.getChildAt(i2));
            if (j2 != null) {
                return j2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d0 k(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f1374a;
    }

    private boolean k(int i2, int i3) {
        a(this.r0);
        int[] iArr = this.r0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private int l(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private void y() {
        M();
        setScrollState(0);
    }

    private void z() {
        int i2 = this.A;
        this.A = 0;
        if (i2 != 0 && m()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            a.g.l.b0.a.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public View a(float f2, float f3) {
        for (int a2 = this.f.a() - 1; a2 >= 0; a2--) {
            View c2 = this.f.c(a2);
            float translationX = c2.getTranslationX();
            float translationY = c2.getTranslationY();
            if (f2 >= c2.getLeft() + translationX && f2 <= c2.getRight() + translationX && f3 >= c2.getTop() + translationY && f3 <= c2.getBottom() + translationY) {
                return c2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.d0 a(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x003a
            androidx.recyclerview.widget.b r3 = r5.f
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$d0 r3 = k(r3)
            if (r3 == 0) goto L_0x0037
            boolean r4 = r3.p()
            if (r4 != 0) goto L_0x0037
            if (r7 == 0) goto L_0x0023
            int r4 = r3.f1348c
            if (r4 == r6) goto L_0x002a
            goto L_0x0037
        L_0x0023:
            int r4 = r3.i()
            if (r4 == r6) goto L_0x002a
            goto L_0x0037
        L_0x002a:
            androidx.recyclerview.widget.b r1 = r5.f
            android.view.View r4 = r3.f1346a
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L_0x0036
            r1 = r3
            goto L_0x0037
        L_0x0036:
            return r3
        L_0x0037:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, boolean):androidx.recyclerview.widget.RecyclerView$d0");
    }

    public d0 a(long j2) {
        g gVar = this.m;
        d0 d0Var = null;
        if (gVar != null && gVar.b()) {
            int b2 = this.f.b();
            for (int i2 = 0; i2 < b2; i2++) {
                d0 k2 = k(this.f.d(i2));
                if (k2 != null && !k2.p() && k2.g() == j2) {
                    if (!this.f.c(k2.f1346a)) {
                        return k2;
                    }
                    d0Var = k2;
                }
            }
        }
        return d0Var;
    }

    void a() {
        int b2 = this.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            d0 k2 = k(this.f.d(i2));
            if (!k2.x()) {
                k2.a();
            }
        }
        this.f1331c.b();
    }

    @Override // a.g.l.j
    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            f();
            this.J.onAbsorb(-i2);
        } else if (i2 > 0) {
            g();
            this.L.onAbsorb(i2);
        }
        if (i3 < 0) {
            h();
            this.K.onAbsorb(-i3);
        } else if (i3 > 0) {
            e();
            this.M.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            a.g.l.s.z(this);
        }
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.y) {
            if (!oVar.a()) {
                i2 = 0;
            }
            if (!this.n.b()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                this.f0.a(i2, i3, interpolator);
            }
        }
    }

    void a(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.f.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < b2; i6++) {
            View d2 = this.f.d(i6);
            d0 k2 = k(d2);
            if (k2 != null && !k2.x() && (i4 = k2.f1348c) >= i2 && i4 < i5) {
                k2.a(2);
                k2.a(obj);
                ((p) d2.getLayoutParams()).f1376c = true;
            }
        }
        this.f1331c.c(i2, i3);
    }

    void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.f.b();
        for (int i5 = 0; i5 < b2; i5++) {
            d0 k2 = k(this.f.d(i5));
            if (k2 != null && !k2.x()) {
                int i6 = k2.f1348c;
                if (i6 >= i4) {
                    k2.a(-i3, z2);
                } else if (i6 >= i2) {
                    k2.a(i2 - 1, -i3, z2);
                }
                this.i0.g = true;
            }
        }
        this.f1331c.a(i2, i3, z2);
        requestLayout();
    }

    void a(int i2, int i3, int[] iArr) {
        w();
        q();
        a.g.h.a.a("RV Scroll");
        a(this.i0);
        int a2 = i2 != 0 ? this.n.a(i2, this.f1331c, this.i0) : 0;
        int b2 = i3 != 0 ? this.n.b(i3, this.f1331c, this.i0) : 0;
        a.g.h.a.a();
        u();
        r();
        c(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + i());
        }
        Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.o.a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.o.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.o.a.fastscroll_margin));
    }

    void a(View view) {
        d0 k2 = k(view);
        g(view);
        g gVar = this.m;
        if (!(gVar == null || k2 == null)) {
            gVar.b((g) k2);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).a(view);
            }
        }
    }

    final void a(a0 a0Var) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f0.f1343d;
            a0Var.p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        a0Var.p = 0;
        a0Var.q = 0;
    }

    void a(d0 d0Var, l.c cVar) {
        d0Var.a(0, 8192);
        if (this.i0.i && d0Var.s() && !d0Var.p() && !d0Var.x()) {
            this.g.a(c(d0Var), d0Var);
        }
        this.g.c(d0Var, cVar);
    }

    void a(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.a(false);
        if (this.N.a(d0Var, cVar, cVar2)) {
            s();
        }
    }

    public void a(n nVar) {
        a(nVar, -1);
    }

    public void a(n nVar, int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(nVar);
        } else {
            this.p.add(i2, nVar);
        }
        o();
        requestLayout();
    }

    public void a(q qVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(qVar);
    }

    public void a(s sVar) {
        this.q.add(sVar);
    }

    public void a(t tVar) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.add(tVar);
    }

    void a(String str) {
        if (n()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + i());
            }
            throw new IllegalStateException(str);
        } else if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + i()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.G--;
        if (this.G < 1) {
            this.G = 0;
            if (z2) {
                z();
                d();
            }
        }
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        b();
        if (this.m != null) {
            a(i2, i3, this.w0);
            int[] iArr = this.w0;
            int i8 = iArr[0];
            int i9 = iArr[1];
            i6 = i2 - i8;
            i5 = i3 - i9;
            i7 = i9;
            i4 = i8;
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        if (a(i4, i7, i6, i5, this.t0, 0)) {
            int i10 = this.T;
            int[] iArr2 = this.t0;
            this.T = i10 - iArr2[0];
            this.U -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.v0;
            int i11 = iArr3[0];
            int[] iArr4 = this.t0;
            iArr3[0] = i11 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !a.g.l.i.a(motionEvent, 8194)) {
                a(motionEvent.getX(), i6, motionEvent.getY(), i5);
            }
            b(i2, i3);
        }
        if (!(i4 == 0 && i7 == 0)) {
            d(i4, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i7 == 0) ? false : true;
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!n()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? a.g.l.b0.a.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.A = a2 | this.A;
        return true;
    }

    boolean a(d0 d0Var) {
        l lVar = this.N;
        return lVar == null || lVar.a(d0Var, d0Var.k());
    }

    boolean a(d0 d0Var, int i2) {
        if (n()) {
            d0Var.q = i2;
            this.x0.add(d0Var);
            return false;
        }
        a.g.l.s.e(d0Var.f1346a, i2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.n;
        if (oVar == null || !oVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    int b(d0 d0Var) {
        if (d0Var.b(524) || !d0Var.m()) {
            return -1;
        }
        return this.f1333e.a(d0Var.f1348c);
    }

    void b() {
        if (!this.v || this.E) {
            a.g.h.a.a("RV FullInvalidate");
            c();
            a.g.h.a.a();
        } else if (this.f1333e.c()) {
            if (this.f1333e.c(4) && !this.f1333e.c(11)) {
                a.g.h.a.a("RV PartialInvalidate");
                w();
                q();
                this.f1333e.e();
                if (!this.x) {
                    if (E()) {
                        c();
                    } else {
                        this.f1333e.a();
                    }
                }
                c(true);
                r();
            } else if (this.f1333e.c()) {
                a.g.h.a.a("RV FullInvalidate");
                c();
            } else {
                return;
            }
            a.g.h.a.a();
        }
    }

    void b(int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.f(i2);
        }
        g(i2);
        t tVar = this.j0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).a(this, i2);
            }
        }
    }

    void b(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.J.onRelease();
            z2 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            a.g.l.s.z(this);
        }
    }

    void b(View view) {
        d0 k2 = k(view);
        h(view);
        g gVar = this.m;
        if (!(gVar == null || k2 == null)) {
            gVar.c((g) k2);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    void b(d0 d0Var, l.c cVar, l.c cVar2) {
        d(d0Var);
        d0Var.a(false);
        if (this.N.b(d0Var, cVar, cVar2)) {
            s();
        }
    }

    public void b(n nVar) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(nVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        o();
        requestLayout();
    }

    public void b(q qVar) {
        List<q> list = this.D;
        if (list != null) {
            list.remove(qVar);
        }
    }

    public void b(s sVar) {
        this.q.remove(sVar);
        if (this.r == sVar) {
            this.r = null;
        }
    }

    public void b(t tVar) {
        List<t> list = this.k0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    void b(boolean z2) {
        this.F = z2 | this.F;
        this.E = true;
        p();
    }

    long c(d0 d0Var) {
        return this.m.b() ? d0Var.g() : d0Var.f1348c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View c(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c(android.view.View):android.view.View");
    }

    public d0 c(int i2) {
        d0 d0Var = null;
        if (this.E) {
            return null;
        }
        int b2 = this.f.b();
        for (int i3 = 0; i3 < b2; i3++) {
            d0 k2 = k(this.f.d(i3));
            if (k2 != null && !k2.p() && b(k2) == i2) {
                if (!this.f.c(k2.f1346a)) {
                    return k2;
                }
                d0Var = k2;
            }
        }
        return d0Var;
    }

    void c() {
        String str;
        if (this.m == null) {
            str = "No adapter attached; skipping layout";
        } else if (this.n == null) {
            str = "No layout manager attached; skipping layout";
        } else {
            a0 a0Var = this.i0;
            a0Var.j = false;
            if (a0Var.f1339e == 1) {
                A();
            } else if (!this.f1333e.d() && this.n.q() == getWidth() && this.n.h() == getHeight()) {
                this.n.e(this);
                C();
                return;
            }
            this.n.e(this);
            B();
            C();
            return;
        }
        Log.e("RecyclerView", str);
    }

    void c(int i2, int i3) {
        setMeasuredDimension(o.a(i2, getPaddingLeft() + getPaddingRight(), a.g.l.s.l(this)), o.a(i3, getPaddingTop() + getPaddingBottom(), a.g.l.s.k(this)));
    }

    void c(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.n != null && this.m != null) {
                c();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.n.a((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.a()) {
            return this.n.a(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.a()) {
            return this.n.b(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.a()) {
            return this.n.c(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.b()) {
            return this.n.d(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.b()) {
            return this.n.e(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.b()) {
            return this.n.f(this.i0);
        }
        return 0;
    }

    public d0 d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return e(c2);
    }

    void d() {
        int i2;
        for (int size = this.x0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.x0.get(size);
            if (d0Var.f1346a.getParent() == this && !d0Var.x() && (i2 = d0Var.q) != -1) {
                a.g.l.s.e(d0Var.f1346a, i2);
                d0Var.q = -1;
            }
        }
        this.x0.clear();
    }

    void d(int i2, int i3) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        t tVar = this.j0;
        if (tVar != null) {
            tVar.a(this, i2, i3);
        }
        List<t> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).a(this, i2, i3);
            }
        }
        this.H--;
    }

    public boolean d(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        int i2;
        float f2;
        super.draw(canvas);
        int size = this.p.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.p.get(i3).b(canvas, this, this.i0);
        }
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.L;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                f2 = (-getWidth()) + getPaddingRight();
                i2 = (-getHeight()) + getPaddingBottom();
            } else {
                f2 = -getWidth();
                i2 = -getHeight();
            }
            canvas.translate(f2, i2);
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.N != null && this.p.size() > 0 && this.N.g()) {
            z3 = true;
        }
        if (z3) {
            a.g.l.s.z(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public d0 e(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return k(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void e() {
        int i2;
        int i3;
        EdgeEffect edgeEffect;
        if (this.M == null) {
            this.M = this.I.a(this, 3);
            if (this.h) {
                edgeEffect = this.M;
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                edgeEffect = this.M;
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            edgeEffect.setSize(i3, i2);
        }
    }

    public void e(int i2) {
        int a2 = this.f.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.f.c(i3).offsetLeftAndRight(i2);
        }
    }

    public boolean e(int i2, int i3) {
        o oVar = this.n;
        int i4 = 0;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.y) {
            return false;
        } else {
            boolean a2 = oVar.a();
            boolean b2 = this.n.b();
            if (!a2 || Math.abs(i2) < this.a0) {
                i2 = 0;
            }
            if (!b2 || Math.abs(i3) < this.a0) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = i2;
            float f3 = i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = a2 || b2;
                dispatchNestedFling(f2, f3, z2);
                r rVar = this.W;
                if (rVar != null && rVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (a2) {
                        i4 = 1;
                    }
                    if (b2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.b0;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.b0;
                    this.f0.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    Rect f(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f1376c) {
            return pVar.f1375b;
        }
        if (this.i0.d() && (pVar.b() || pVar.d())) {
            return pVar.f1375b;
        }
        Rect rect = pVar.f1375b;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.set(0, 0, 0, 0);
            this.p.get(i2).a(this.j, view, this, this.i0);
            int i3 = rect.left;
            Rect rect2 = this.j;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f1376c = false;
        return rect;
    }

    void f() {
        int i2;
        int i3;
        EdgeEffect edgeEffect;
        if (this.J == null) {
            this.J = this.I.a(this, 0);
            if (this.h) {
                edgeEffect = this.J;
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                edgeEffect = this.J;
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            edgeEffect.setSize(i3, i2);
        }
    }

    public void f(int i2) {
        int a2 = this.f.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.f.c(i3).offsetTopAndBottom(i2);
        }
    }

    void f(int i2, int i3) {
        int b2 = this.f.b();
        for (int i4 = 0; i4 < b2; i4++) {
            d0 k2 = k(this.f.d(i4));
            if (k2 != null && !k2.x() && k2.f1348c >= i2) {
                k2.a(i3, false);
                this.i0.g = true;
            }
        }
        this.f1331c.a(i2, i3);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.n.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = this.m != null && this.n != null && !n() && !this.y;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                view2 = this.n.a(view, i2, this.f1331c, this.i0);
                c(false);
            }
        } else {
            if (this.n.b()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (G0) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.n.a()) {
                int i4 = (this.n.j() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i4) == null;
                if (G0) {
                    i2 = i4;
                }
            }
            if (z2) {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                this.n.a(view, i2, this.f1331c, this.i0);
                c(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    void g() {
        int i2;
        int i3;
        EdgeEffect edgeEffect;
        if (this.L == null) {
            this.L = this.I.a(this, 2);
            if (this.h) {
                edgeEffect = this.L;
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                edgeEffect = this.L;
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            edgeEffect.setSize(i3, i2);
        }
    }

    public void g(int i2) {
    }

    void g(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = this.f.b();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i8 = 0; i8 < b2; i8++) {
            d0 k2 = k(this.f.d(i8));
            if (k2 != null && (i7 = k2.f1348c) >= i6 && i7 <= i5) {
                if (i7 == i2) {
                    k2.a(i3 - i2, false);
                } else {
                    k2.a(i4, false);
                }
                this.i0.g = true;
            }
        }
        this.f1331c.b(i2, i3);
        requestLayout();
    }

    public void g(View view) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    public g getAdapter() {
        return this.m;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.n;
        return oVar != null ? oVar.d() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.q0;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.h;
    }

    public androidx.recyclerview.widget.l getCompatAccessibilityDelegate() {
        return this.p0;
    }

    public k getEdgeEffectFactory() {
        return this.I;
    }

    public l getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public o getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.b0;
    }

    public int getMinFlingVelocity() {
        return this.a0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (F0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.e0;
    }

    public u getRecycledViewPool() {
        return this.f1331c.d();
    }

    public int getScrollState() {
        return this.O;
    }

    void h() {
        int i2;
        int i3;
        EdgeEffect edgeEffect;
        if (this.K == null) {
            this.K = this.I.a(this, 1);
            if (this.h) {
                edgeEffect = this.K;
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                edgeEffect = this.K;
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            edgeEffect.setSize(i3, i2);
        }
    }

    public void h(int i2) {
        if (!this.y) {
            x();
            o oVar = this.n;
            if (oVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            oVar.h(i2);
            awakenScrollBars();
        }
    }

    public void h(int i2, int i3) {
    }

    public void h(View view) {
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    String i() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    public void i(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    boolean i(View view) {
        w();
        boolean e2 = this.f.e(view);
        if (e2) {
            d0 k2 = k(view);
            this.f1331c.c(k2);
            this.f1331c.b(k2);
        }
        c(!e2);
        return e2;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.s;
    }

    @Override // android.view.View, a.g.l.k
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    public boolean j() {
        return !this.v || this.E || this.f1333e.c();
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    void k() {
        this.f1333e = new androidx.recyclerview.widget.a(new f());
    }

    void l() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    boolean m() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean n() {
        return this.G > 0;
    }

    void o() {
        int b2 = this.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((p) this.f.d(i2).getLayoutParams()).f1376c = true;
        }
        this.f1331c.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.G = r0
            r1 = 1
            r4.s = r1
            boolean r2 = r4.v
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.v = r1
            androidx.recyclerview.widget.RecyclerView$o r1 = r4.n
            if (r1 == 0) goto L_0x001e
            r1.a(r4)
        L_0x001e:
            r4.o0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.F0
            if (r0 == 0) goto L_0x0067
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.f
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.e r0 = (androidx.recyclerview.widget.e) r0
            r4.g0 = r0
            androidx.recyclerview.widget.e r0 = r4.g0
            if (r0 != 0) goto L_0x0062
            androidx.recyclerview.widget.e r0 = new androidx.recyclerview.widget.e
            r0.<init>()
            r4.g0 = r0
            android.view.Display r0 = a.g.l.s.e(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0054:
            androidx.recyclerview.widget.e r1 = r4.g0
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f1475d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.f
            r0.set(r1)
        L_0x0062:
            androidx.recyclerview.widget.e r0 = r4.g0
            r0.a(r4)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.N;
        if (lVar != null) {
            lVar.b();
        }
        x();
        this.s = false;
        o oVar = this.n;
        if (oVar != null) {
            oVar.a(this, this.f1331c);
        }
        this.x0.clear();
        removeCallbacks(this.y0);
        this.g.b();
        if (F0 && (eVar = this.g0) != null) {
            eVar.b(this);
            this.g0 = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).a(canvas, this, this.i0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.n
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r5.y
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L_0x0077
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L_0x003c
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.n
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x002c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0061
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L_0x0062
        L_0x003c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0060
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x0055
            float r0 = -r0
            goto L_0x0061
        L_0x0055:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.n
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0060
            r3 = r0
            r0 = 0
            goto L_0x0062
        L_0x0060:
            r0 = 0
        L_0x0061:
            r3 = 0
        L_0x0062:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x006a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0077
        L_0x006a:
            float r2 = r5.c0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.d0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L_0x0077:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        if (b(motionEvent)) {
            y();
            return true;
        }
        o oVar = this.n;
        if (oVar == null) {
            return false;
        }
        boolean a2 = oVar.a();
        boolean b2 = this.n.b();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.U = y2;
            this.S = y2;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.v0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = a2 ? 1 : 0;
            if (b2) {
                i2 |= 2;
            }
            j(i2, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i3 = x3 - this.R;
                int i4 = y3 - this.S;
                if (!a2 || Math.abs(i3) <= this.V) {
                    z2 = false;
                } else {
                    this.T = x3;
                    z2 = true;
                }
                if (b2 && Math.abs(i4) > this.V) {
                    this.U = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x4;
            this.R = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y4;
            this.S = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        return this.O == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        a.g.h.a.a("RV OnLayout");
        c();
        a.g.h.a.a();
        this.v = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            c(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.u()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.a(this.f1331c, this.i0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.m != null) {
                if (this.i0.f1339e == 1) {
                    A();
                }
                this.n.b(i2, i3);
                this.i0.j = true;
                B();
                this.n.d(i2, i3);
                if (this.n.A()) {
                    this.n.b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.i0.j = true;
                    B();
                    this.n.d(i2, i3);
                }
            }
        } else if (this.t) {
            this.n.a(this.f1331c, this.i0, i2, i3);
        } else {
            if (this.B) {
                w();
                q();
                I();
                r();
                a0 a0Var = this.i0;
                if (a0Var.l) {
                    a0Var.h = true;
                } else {
                    this.f1333e.b();
                    this.i0.h = false;
                }
                this.B = false;
                c(false);
            } else if (this.i0.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                this.i0.f = gVar.a();
            } else {
                this.i0.f = 0;
            }
            w();
            this.n.a(this.f1331c, this.i0, i2, i3);
            c(false);
            this.i0.h = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (n()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.f1332d = (y) parcelable;
        super.onRestoreInstanceState(this.f1332d.a());
        o oVar = this.n;
        if (oVar != null && (parcelable2 = this.f1332d.f1390d) != null) {
            oVar.a(parcelable2);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f1332d;
        if (yVar2 != null) {
            yVar.a(yVar2);
        } else {
            o oVar = this.n;
            yVar.f1390d = oVar != null ? oVar.x() : null;
        }
        return yVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p() {
        int b2 = this.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            d0 k2 = k(this.f.d(i2));
            if (k2 != null && !k2.x()) {
                k2.a(6);
            }
        }
        o();
        this.f1331c.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.G++;
    }

    void r() {
        a(true);
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        d0 k2 = k(view);
        if (k2 != null) {
            if (k2.r()) {
                k2.d();
            } else if (!k2.x()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + k2 + i());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, this.i0, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.a(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        if (!this.o0 && this.s) {
            a.g.l.s.a(this, this.y0);
            this.o0 = true;
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.y) {
            boolean a2 = oVar.a();
            boolean b2 = this.n.b();
            if (a2 || b2) {
                if (!a2) {
                    i2 = 0;
                }
                if (!b2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.l lVar) {
        this.p0 = lVar;
        a.g.l.s.a(this, this.p0);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        a(gVar, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar != this.q0) {
            this.q0 = jVar;
            setChildrenDrawingOrderEnabled(this.q0 != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.h) {
            l();
        }
        this.h = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        a.g.k.h.a(kVar);
        this.I = kVar;
        l();
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.N;
        if (lVar2 != null) {
            lVar2.b();
            this.N.a((l.b) null);
        }
        this.N = lVar;
        l lVar3 = this.N;
        if (lVar3 != null) {
            lVar3.a(this.n0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f1331c.f(i2);
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.y) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.y = false;
                if (!(!this.x || this.n == null || this.m == null)) {
                    requestLayout();
                }
                this.x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.y = true;
            this.z = true;
            x();
        }
    }

    public void setLayoutManager(o oVar) {
        if (oVar != this.n) {
            x();
            if (this.n != null) {
                l lVar = this.N;
                if (lVar != null) {
                    lVar.b();
                }
                this.n.b(this.f1331c);
                this.n.c(this.f1331c);
                this.f1331c.a();
                if (this.s) {
                    this.n.a(this, this.f1331c);
                }
                this.n.f((RecyclerView) null);
                this.n = null;
            } else {
                this.f1331c.a();
            }
            this.f.c();
            this.n = oVar;
            if (oVar != null) {
                if (oVar.f1364b == null) {
                    this.n.f(this);
                    if (this.s) {
                        this.n.a(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f1364b.i());
                }
            }
            this.f1331c.j();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.W = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.j0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.e0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.f1331c.a(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.o = wVar;
    }

    void setScrollState(int i2) {
        if (i2 != this.O) {
            this.O = i2;
            if (i2 != 2) {
                O();
            }
            b(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        int i3;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                i3 = viewConfiguration.getScaledPagingTouchSlop();
                this.V = i3;
            }
        }
        i3 = viewConfiguration.getScaledTouchSlop();
        this.V = i3;
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f1331c.a(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    @Override // android.view.View, a.g.l.k
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        l lVar = this.N;
        if (lVar != null) {
            lVar.b();
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.b(this.f1331c);
            this.n.c(this.f1331c);
        }
        this.f1331c.a();
    }

    void u() {
        d0 d0Var;
        int a2 = this.f.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.f.c(i2);
            d0 e2 = e(c2);
            if (!(e2 == null || (d0Var = e2.i) == null)) {
                View view = d0Var.f1346a;
                int left = c2.getLeft();
                int top = c2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void v() {
        int b2 = this.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            d0 k2 = k(this.f.d(i2));
            if (!k2.x()) {
                k2.v();
            }
        }
    }

    void w() {
        this.w++;
        if (this.w == 1 && !this.y) {
            this.x = false;
        }
    }

    public void x() {
        setScrollState(0);
        O();
    }
}
