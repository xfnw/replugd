package com.google.android.material.bottomsheet;

import a.g.l.s;
import a.i.b.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: b  reason: collision with root package name */
    private float f3159b;

    /* renamed from: c  reason: collision with root package name */
    private int f3160c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3161d;

    /* renamed from: e  reason: collision with root package name */
    private int f3162e;
    private int f;
    int g;
    int h;
    int i;
    boolean j;
    private boolean k;
    a.i.b.a m;
    private boolean n;
    private int o;
    private boolean p;
    int q;
    WeakReference<V> r;
    WeakReference<View> s;
    private b t;
    private VelocityTracker u;
    int v;
    private int w;
    boolean x;
    private Map<View, Integer> y;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3158a = true;
    int l = 4;
    private final a.c z = new a();

    /* loaded from: classes.dex */
    class a extends a.c {
        a() {
        }

        @Override // a.i.b.a.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.i)) goto L_0x0026;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.f3163a.i)) goto L_0x00b6;
         */
        @Override // a.i.b.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 226
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a.a(android.view.View, float, float):void");
        }

        @Override // a.i.b.a.c
        public void a(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.a(i2);
        }

        @Override // a.i.b.a.c
        public int b(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.j ? bottomSheetBehavior.q : bottomSheetBehavior.i;
        }

        @Override // a.i.b.a.c
        public int b(View view, int i, int i2) {
            int c2 = BottomSheetBehavior.this.c();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.g.g.a.a(i, c2, bottomSheetBehavior.j ? bottomSheetBehavior.q : bottomSheetBehavior.i);
        }

        @Override // a.i.b.a.c
        public boolean b(View view, int i) {
            WeakReference<V> weakReference;
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.l;
            if (i2 != 1 && !bottomSheetBehavior.x) {
                return (i2 != 3 || bottomSheetBehavior.v != i || (view2 = bottomSheetBehavior.s.get()) == null || !view2.canScrollVertically(-1)) && (weakReference = BottomSheetBehavior.this.r) != null && weakReference.get() == view;
            }
            return false;
        }

        @Override // a.i.b.a.c
        public void c(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.c(1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class c extends a.i.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        final int f3164d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3164d = parcel.readInt();
        }

        public c(Parcelable parcelable, int i) {
            super(parcelable);
            this.f3164d = i;
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3164d);
        }
    }

    /* loaded from: classes.dex */
    private class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f3165b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3166c;

        d(View view, int i) {
            this.f3165b = view;
            this.f3166c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.i.b.a aVar = BottomSheetBehavior.this.m;
            if (aVar == null || !aVar.a(true)) {
                BottomSheetBehavior.this.c(this.f3166c);
            } else {
                s.a(this.f3165b, this);
            }
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(i.BottomSheetBehavior_Layout_behavior_peekHeight);
        b((peekValue == null || (dimensionPixelSize = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(i.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : dimensionPixelSize);
        b(obtainStyledAttributes.getBoolean(i.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(i.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(i.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f3159b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void b() {
        this.i = this.f3158a ? Math.max(this.q - this.f, this.g) : this.q - this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        if (this.f3158a) {
            return this.g;
        }
        return 0;
    }

    private float d() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f3159b);
        return this.u.getYVelocity(this.v);
    }

    private void d(boolean z) {
        int i;
        WeakReference<V> weakReference = this.r;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z) {
                    if (this.y == null) {
                        this.y = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.r.get()) {
                        if (!z) {
                            Map<View, Integer> map = this.y;
                            if (map != null && map.containsKey(childAt)) {
                                i = this.y.get(childAt).intValue();
                            }
                        } else {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            i = 4;
                        }
                        s.e(childAt, i);
                    }
                }
                if (!z) {
                    this.y = null;
                }
            }
        }
    }

    private void e() {
        this.v = -1;
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    View a(View view) {
        if (s.x(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a2 = a(viewGroup.getChildAt(i));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    void a(int i) {
        b bVar;
        float f;
        float f2;
        V v = this.r.get();
        if (v != null && (bVar = this.t) != null) {
            int i2 = this.i;
            if (i > i2) {
                f = i2 - i;
                f2 = this.q - i2;
            } else {
                f = i2 - i;
                f2 = i2 - c();
            }
            bVar.a(v, f / f2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.a(coordinatorLayout, (CoordinatorLayout) v, cVar.a());
        int i = cVar.f3164d;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.l = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.i)) goto L_0x007a;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.coordinatorlayout.widget.CoordinatorLayout r4, V r5, android.view.View r6, int r7) {
        /*
            r3 = this;
            int r4 = r5.getTop()
            int r7 = r3.c()
            r0 = 3
            if (r4 != r7) goto L_0x000f
            r3.c(r0)
            return
        L_0x000f:
            java.lang.ref.WeakReference<android.view.View> r4 = r3.s
            java.lang.Object r4 = r4.get()
            if (r6 != r4) goto L_0x009f
            boolean r4 = r3.p
            if (r4 != 0) goto L_0x001d
            goto L_0x009f
        L_0x001d:
            int r4 = r3.o
            r6 = 0
            r7 = 4
            if (r4 <= 0) goto L_0x0028
            int r4 = r3.c()
            goto L_0x0081
        L_0x0028:
            boolean r4 = r3.j
            if (r4 == 0) goto L_0x003a
            float r4 = r3.d()
            boolean r4 = r3.a(r5, r4)
            if (r4 == 0) goto L_0x003a
            int r4 = r3.q
            r0 = 5
            goto L_0x0081
        L_0x003a:
            int r4 = r3.o
            if (r4 != 0) goto L_0x007e
            int r4 = r5.getTop()
            boolean r1 = r3.f3158a
            r2 = 6
            if (r1 == 0) goto L_0x005b
            int r1 = r3.g
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.i
            int r4 = r4 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r1 >= r4) goto L_0x007e
            int r4 = r3.g
            goto L_0x0081
        L_0x005b:
            int r1 = r3.h
            if (r4 >= r1) goto L_0x006b
            int r7 = r3.i
            int r7 = r4 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r4 >= r7) goto L_0x007a
            r4 = 0
            goto L_0x0081
        L_0x006b:
            int r0 = r4 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r3.i
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto L_0x007e
        L_0x007a:
            int r4 = r3.h
            r0 = 6
            goto L_0x0081
        L_0x007e:
            int r4 = r3.i
            r0 = 4
        L_0x0081:
            a.i.b.a r7 = r3.m
            int r1 = r5.getLeft()
            boolean r4 = r7.b(r5, r1, r4)
            if (r4 == 0) goto L_0x009a
            r4 = 2
            r3.c(r4)
            com.google.android.material.bottomsheet.BottomSheetBehavior$d r4 = new com.google.android.material.bottomsheet.BottomSheetBehavior$d
            r4.<init>(r5, r0)
            a.g.l.s.a(r5, r4)
            goto L_0x009d
        L_0x009a:
            r3.c(r0)
        L_0x009d:
            r3.p = r6
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 != 1 && view == this.s.get()) {
            int top = v.getTop();
            int i5 = top - i2;
            if (i2 > 0) {
                if (i5 < c()) {
                    iArr[1] = top - c();
                    s.d(v, -iArr[1]);
                    i4 = 3;
                    c(i4);
                } else {
                    iArr[1] = i2;
                    s.d(v, -i2);
                    c(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.i;
                if (i5 <= i6 || this.j) {
                    iArr[1] = i2;
                    s.d(v, -i2);
                    c(1);
                } else {
                    iArr[1] = top - i6;
                    s.d(v, -iArr[1]);
                    i4 = 4;
                    c(i4);
                }
            }
            a(v.getTop());
            this.o = i2;
            this.p = true;
        }
    }

    public void a(boolean z) {
        if (this.f3158a != z) {
            this.f3158a = z;
            if (this.r != null) {
                b();
            }
            c((!this.f3158a || this.l != 6) ? this.l : 3);
        }
    }

    boolean a(View view, float f) {
        if (this.k) {
            return true;
        }
        return view.getTop() >= this.i && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.i)) / ((float) this.f3160c) > 0.5f;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, int r7) {
        /*
            r4 = this;
            boolean r0 = a.g.l.s.g(r5)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = a.g.l.s.g(r6)
            if (r0 != 0) goto L_0x0010
            r6.setFitsSystemWindows(r1)
        L_0x0010:
            int r0 = r6.getTop()
            r5.c(r6, r7)
            int r7 = r5.getHeight()
            r4.q = r7
            boolean r7 = r4.f3161d
            if (r7 == 0) goto L_0x0043
            int r7 = r4.f3162e
            if (r7 != 0) goto L_0x0031
            android.content.res.Resources r7 = r5.getResources()
            int r2 = b.c.a.a.c.design_bottom_sheet_peek_height_min
            int r7 = r7.getDimensionPixelSize(r2)
            r4.f3162e = r7
        L_0x0031:
            int r7 = r4.f3162e
            int r2 = r4.q
            int r3 = r5.getWidth()
            int r3 = r3 * 9
            int r3 = r3 / 16
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            goto L_0x0045
        L_0x0043:
            int r7 = r4.f3160c
        L_0x0045:
            r4.f = r7
            r7 = 0
            int r2 = r4.q
            int r3 = r6.getHeight()
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            r4.g = r7
            int r7 = r4.q
            r2 = 2
            int r7 = r7 / r2
            r4.h = r7
            r4.b()
            int r7 = r4.l
            r3 = 3
            if (r7 != r3) goto L_0x006b
            int r7 = r4.c()
        L_0x0067:
            a.g.l.s.d(r6, r7)
            goto L_0x008f
        L_0x006b:
            r3 = 6
            if (r7 != r3) goto L_0x0071
            int r7 = r4.h
            goto L_0x0067
        L_0x0071:
            boolean r3 = r4.j
            if (r3 == 0) goto L_0x007b
            r3 = 5
            if (r7 != r3) goto L_0x007b
            int r7 = r4.q
            goto L_0x0067
        L_0x007b:
            int r7 = r4.l
            r3 = 4
            if (r7 != r3) goto L_0x0083
            int r7 = r4.i
            goto L_0x0067
        L_0x0083:
            if (r7 == r1) goto L_0x0087
            if (r7 != r2) goto L_0x008f
        L_0x0087:
            int r7 = r6.getTop()
            int r0 = r0 - r7
            a.g.l.s.d(r6, r0)
        L_0x008f:
            a.i.b.a r7 = r4.m
            if (r7 != 0) goto L_0x009b
            a.i.b.a$c r7 = r4.z
            a.i.b.a r5 = a.i.b.a.a(r5, r7)
            r4.m = r5
        L_0x009b:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r6)
            r4.r = r5
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            android.view.View r6 = r4.a(r6)
            r5.<init>(r6)
            r4.s = r5
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        a.i.b.a aVar;
        if (!v.isShown()) {
            this.n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            e();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        View view = null;
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.s;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (view2 != null && coordinatorLayout.a(view2, x, this.w)) {
                this.v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.x = true;
            }
            this.n = this.v == -1 && !coordinatorLayout.a(v, x, this.w);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.x = false;
            this.v = -1;
            if (this.n) {
                this.n = false;
                return false;
            }
        }
        if (!this.n && (aVar = this.m) != null && aVar.b(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.s;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.n && this.l != 1 && !coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.m != null && Math.abs(((float) this.w) - motionEvent.getY()) > ((float) this.m.b());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.s.get() && (this.l != 3 || super.a(coordinatorLayout, (CoordinatorLayout) v, view, f, f2));
    }

    public final void b(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.f3161d) {
                this.f3161d = true;
            }
            z = false;
        } else {
            if (this.f3161d || this.f3160c != i) {
                this.f3161d = false;
                this.f3160c = Math.max(0, i);
                this.i = this.q - i;
            }
            z = false;
        }
        if (z && this.l == 4 && (weakReference = this.r) != null && (v = weakReference.get()) != null) {
            v.requestLayout();
        }
    }

    public void b(boolean z) {
        this.j = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.l == 1 && actionMasked == 0) {
            return true;
        }
        a.i.b.a aVar = this.m;
        if (aVar != null) {
            aVar.a(motionEvent);
        }
        if (actionMasked == 0) {
            e();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 2 && !this.n && Math.abs(this.w - motionEvent.getY()) > this.m.b()) {
            this.m.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.o = 0;
        this.p = false;
        return (i & 2) != 0;
    }

    void c(int i) {
        V v;
        b bVar;
        boolean z;
        if (this.l != i) {
            this.l = i;
            if (i == 6 || i == 3) {
                z = true;
            } else {
                if (i == 5 || i == 4) {
                    z = false;
                }
                v = this.r.get();
                if (v != null && (bVar = this.t) != null) {
                    bVar.a((View) v, i);
                    return;
                }
            }
            d(z);
            v = this.r.get();
            if (v != null) {
            }
        }
    }

    public void c(boolean z) {
        this.k = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new c(super.d(coordinatorLayout, v), this.l);
    }
}
