package androidx.viewpager.widget;

import a.g.l.a0;
import a.g.l.p;
import a.g.l.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    static final int[] g0 = {16842931};
    private static final Comparator<f> h0 = new a();
    private static final Interpolator i0 = new b();
    private static final o j0 = new o();
    private int A;
    private int B;
    private int C;
    private float D;
    private float E;
    private float F;
    private float G;
    private VelocityTracker I;
    private int J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private EdgeEffect O;
    private EdgeEffect P;
    private boolean R;
    private int S;
    private List<j> T;
    private j U;
    private j V;
    private List<i> W;
    private k a0;

    /* renamed from: b  reason: collision with root package name */
    private int f1571b;
    private int b0;
    private int c0;
    private ArrayList<View> d0;
    androidx.viewpager.widget.a f;
    int g;
    private Scroller k;
    private boolean l;
    private l m;
    private int n;
    private Drawable o;
    private int p;
    private int q;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean y;
    private boolean z;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<f> f1572c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final f f1573d = new f();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1574e = new Rect();
    private int h = -1;
    private Parcelable i = null;
    private ClassLoader j = null;
    private float r = -3.4028235E38f;
    private float s = Float.MAX_VALUE;
    private int x = 1;
    private int H = -1;
    private boolean Q = true;
    private final Runnable e0 = new c();
    private int f0 = 0;

    /* loaded from: classes.dex */
    static class a implements Comparator<f> {
        a() {
        }

        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f1579b - fVar2.f1579b;
        }
    }

    /* loaded from: classes.dex */
    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements p {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f1576a = new Rect();

        d() {
        }

        @Override // a.g.l.p
        public a0 a(View view, a0 a0Var) {
            a0 b2 = s.b(view, a0Var);
            if (b2.e()) {
                return b2;
            }
            Rect rect = this.f1576a;
            rect.left = b2.b();
            rect.top = b2.d();
            rect.right = b2.c();
            rect.bottom = b2.a();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a0 a2 = s.a(ViewPager.this.getChildAt(i), b2);
                rect.left = Math.min(a2.b(), rect.left);
                rect.top = Math.min(a2.d(), rect.top);
                rect.right = Math.min(a2.c(), rect.right);
                rect.bottom = Math.min(a2.a(), rect.bottom);
            }
            return b2.a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f1578a;

        /* renamed from: b  reason: collision with root package name */
        int f1579b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1580c;

        /* renamed from: d  reason: collision with root package name */
        float f1581d;

        /* renamed from: e  reason: collision with root package name */
        float f1582e;

        f() {
        }
    }

    /* loaded from: classes.dex */
    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1583a;

        /* renamed from: b  reason: collision with root package name */
        public int f1584b;

        /* renamed from: c  reason: collision with root package name */
        float f1585c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        boolean f1586d;

        /* renamed from: e  reason: collision with root package name */
        int f1587e;
        int f;

        public g() {
            super(-1, -1);
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.g0);
            this.f1584b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends a.g.l.a {
        h() {
        }

        private boolean b() {
            androidx.viewpager.widget.a aVar = ViewPager.this.f;
            return aVar != null && aVar.a() > 1;
        }

        @Override // a.g.l.a
        public void a(View view, a.g.l.b0.c cVar) {
            super.a(view, cVar);
            cVar.a((CharSequence) ViewPager.class.getName());
            cVar.c(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // a.g.l.a
        public boolean a(View view, int i, Bundle bundle) {
            ViewPager viewPager;
            int i2;
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i2 = viewPager.g - 1;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager = ViewPager.this;
                i2 = viewPager.g + 1;
            }
            viewPager.setCurrentItem(i2);
            return true;
        }

        @Override // a.g.l.a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.f) != null) {
                accessibilityEvent.setItemCount(aVar.a());
                accessibilityEvent.setFromIndex(ViewPager.this.g);
                accessibilityEvent.setToIndex(ViewPager.this.g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(View view, float f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class l extends DataSetObserver {
        l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.a();
        }
    }

    /* loaded from: classes.dex */
    public static class m extends a.i.a.a {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        int f1590d;

        /* renamed from: e  reason: collision with root package name */
        Parcelable f1591e;
        ClassLoader f;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<m> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public m[] newArray(int i) {
                return new m[i];
            }
        }

        m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? m.class.getClassLoader() : classLoader;
            this.f1590d = parcel.readInt();
            this.f1591e = parcel.readParcelable(classLoader);
            this.f = classLoader;
        }

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1590d + "}";
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1590d);
            parcel.writeParcelable(this.f1591e, i);
        }
    }

    /* loaded from: classes.dex */
    public static class n implements j {
        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i, float f, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class o implements Comparator<View> {
        o() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.f1583a;
            return z != gVar2.f1583a ? z ? 1 : -1 : gVar.f1587e - gVar2.f1587e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        b();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.L || Math.abs(i3) <= this.J) {
            i2 += (int) (f2 + (i2 >= this.g ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f1572c.size() <= 0) {
            return i2;
        }
        ArrayList<f> arrayList = this.f1572c;
        return Math.max(this.f1572c.get(0).f1579b, Math.min(i2, arrayList.get(arrayList.size() - 1).f1579b));
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void a(int i2, int i3, int i4, int i5) {
        int min;
        if (i3 <= 0 || this.f1572c.isEmpty()) {
            f b2 = b(this.g);
            min = (int) ((b2 != null ? Math.min(b2.f1582e, this.s) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (min != getScrollX()) {
                a(false);
            } else {
                return;
            }
        } else if (!this.k.isFinished()) {
            this.k.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4));
        }
        scrollTo(min, getScrollY());
    }

    private void a(int i2, boolean z, int i3, boolean z2) {
        f b2 = b(i2);
        int clientWidth = b2 != null ? (int) (getClientWidth() * Math.max(this.r, Math.min(b2.f1582e, this.s))) : 0;
        if (z) {
            a(clientWidth, 0, i3);
            if (z2) {
                d(i2);
                return;
            }
            return;
        }
        if (z2) {
            d(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        f(clientWidth);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i2);
            this.H = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void a(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int a2 = this.f.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.n / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.f1579b;
            int i6 = fVar.f1579b;
            if (i5 < i6) {
                int i7 = 0;
                float f3 = fVar2.f1582e + fVar2.f1581d + f2;
                while (true) {
                    i5++;
                    if (i5 > fVar.f1579b || i7 >= this.f1572c.size()) {
                        break;
                    }
                    while (true) {
                        fVar4 = this.f1572c.get(i7);
                        if (i5 <= fVar4.f1579b || i7 >= this.f1572c.size() - 1) {
                            break;
                        }
                        i7++;
                    }
                    while (i5 < fVar4.f1579b) {
                        f3 += this.f.a(i5) + f2;
                        i5++;
                    }
                    fVar4.f1582e = f3;
                    f3 += fVar4.f1581d + f2;
                }
            } else if (i5 > i6) {
                int size = this.f1572c.size() - 1;
                float f4 = fVar2.f1582e;
                while (true) {
                    i5--;
                    if (i5 < fVar.f1579b || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = this.f1572c.get(size);
                        if (i5 >= fVar3.f1579b || size <= 0) {
                            break;
                        }
                        size--;
                    }
                    while (i5 > fVar3.f1579b) {
                        f4 -= this.f.a(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.f1581d + f2;
                    fVar3.f1582e = f4;
                }
            }
        }
        int size2 = this.f1572c.size();
        float f5 = fVar.f1582e;
        int i8 = fVar.f1579b;
        int i9 = i8 - 1;
        this.r = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = a2 - 1;
        this.s = fVar.f1579b == i10 ? (fVar.f1582e + fVar.f1581d) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            f fVar5 = this.f1572c.get(i11);
            while (true) {
                i4 = fVar5.f1579b;
                if (i9 <= i4) {
                    break;
                }
                i9--;
                f5 -= this.f.a(i9) + f2;
            }
            f5 -= fVar5.f1581d + f2;
            fVar5.f1582e = f5;
            if (i4 == 0) {
                this.r = f5;
            }
            i11--;
            i9--;
        }
        float f6 = fVar.f1582e + fVar.f1581d + f2;
        int i12 = fVar.f1579b + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            f fVar6 = this.f1572c.get(i13);
            while (true) {
                i3 = fVar6.f1579b;
                if (i12 >= i3) {
                    break;
                }
                i12++;
                f6 += this.f.a(i12) + f2;
            }
            if (i3 == i10) {
                this.s = (fVar6.f1581d + f6) - 1.0f;
            }
            fVar6.f1582e = f6;
            f6 += fVar6.f1581d + f2;
            i13++;
            i12++;
        }
    }

    private void a(boolean z) {
        boolean z2 = this.f0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.k.isFinished()) {
                this.k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.k.getCurrX();
                int currY = this.k.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        f(currX);
                    }
                }
            }
        }
        this.w = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.f1572c.size(); i2++) {
            f fVar = this.f1572c.get(i2);
            if (fVar.f1580c) {
                fVar.f1580c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            s.a(this, this.e0);
        } else {
            this.e0.run();
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.B) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.B)) && f3 < 0.0f);
    }

    private void b(int i2, float f2, int i3) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = this.T.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.b0 : 0, null);
        }
    }

    private boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.D - f2;
        this.D = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.r * clientWidth;
        float f5 = this.s * clientWidth;
        boolean z3 = false;
        f fVar = this.f1572c.get(0);
        ArrayList<f> arrayList = this.f1572c;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f1579b != 0) {
            f4 = fVar.f1582e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.f1579b != this.f.a() - 1) {
            f5 = fVar2.f1582e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.O.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.P.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.D += scrollX - i2;
        scrollTo(i2, getScrollY());
        f(i2);
        return z3;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private void d(int i2) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.b(i2);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.T.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    private void e(int i2) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.a(i2);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.T.get(i3);
                if (jVar2 != null) {
                    jVar2.a(i2);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.a(i2);
        }
    }

    private void f() {
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    private boolean f(int i2) {
        if (this.f1572c.size() != 0) {
            f g2 = g();
            int clientWidth = getClientWidth();
            int i3 = this.n;
            int i4 = clientWidth + i3;
            float f2 = clientWidth;
            int i5 = g2.f1579b;
            float f3 = ((i2 / f2) - g2.f1582e) / (g2.f1581d + (i3 / f2));
            this.R = false;
            a(i5, f3, (int) (i4 * f3));
            if (this.R) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.Q) {
            return false;
        } else {
            this.R = false;
            a(0, 0.0f, 0);
            if (this.R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private f g() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.n / clientWidth : 0.0f;
        f fVar = null;
        int i3 = 0;
        boolean z = true;
        int i4 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.f1572c.size()) {
            f fVar2 = this.f1572c.get(i3);
            if (!z && fVar2.f1579b != (i2 = i4 + 1)) {
                fVar2 = this.f1573d;
                fVar2.f1582e = f3 + f4 + f2;
                fVar2.f1579b = i2;
                fVar2.f1581d = this.f.a(fVar2.f1579b);
                i3--;
            }
            f3 = fVar2.f1582e;
            float f5 = fVar2.f1581d + f3 + f2;
            if (!z && scrollX < f3) {
                return fVar;
            }
            if (scrollX < f5 || i3 == this.f1572c.size() - 1) {
                return fVar2;
            }
            i4 = fVar2.f1579b;
            f4 = fVar2.f1581d;
            i3++;
            fVar = fVar2;
            z = false;
        }
        return fVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).f1583a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private boolean i() {
        this.H = -1;
        f();
        this.O.onRelease();
        this.P.onRelease();
        return this.O.isFinished() || this.P.isFinished();
    }

    private void j() {
        if (this.c0 != 0) {
            ArrayList<View> arrayList = this.d0;
            if (arrayList == null) {
                this.d0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.d0.add(getChildAt(i2));
            }
            Collections.sort(this.d0, j0);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.v != z) {
            this.v = z;
        }
    }

    float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    f a(int i2, int i3) {
        f fVar = new f();
        fVar.f1579b = i2;
        fVar.f1578a = this.f.a(this, i2);
        fVar.f1581d = this.f.a(i2);
        if (i3 < 0 || i3 >= this.f1572c.size()) {
            this.f1572c.add(fVar);
        } else {
            this.f1572c.add(i3, fVar);
        }
        return fVar;
    }

    f a(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return b(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    void a() {
        int a2 = this.f.a();
        this.f1571b = a2;
        boolean z = this.f1572c.size() < (this.x * 2) + 1 && this.f1572c.size() < a2;
        int i2 = this.g;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.f1572c.size()) {
            f fVar = this.f1572c.get(i3);
            int a3 = this.f.a(fVar.f1578a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.f1572c.remove(i3);
                    i3--;
                    if (!z2) {
                        this.f.b((ViewGroup) this);
                        z2 = true;
                    }
                    this.f.a((ViewGroup) this, fVar.f1579b, fVar.f1578a);
                    int i4 = this.g;
                    if (i4 == fVar.f1579b) {
                        i2 = Math.max(0, Math.min(i4, a2 - 1));
                    }
                } else {
                    int i5 = fVar.f1579b;
                    if (i5 != a3) {
                        if (i5 == this.g) {
                            i2 = a3;
                        }
                        fVar.f1579b = a3;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.f.a((ViewGroup) this);
        }
        Collections.sort(this.f1572c, h0);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                g gVar = (g) getChildAt(i6).getLayoutParams();
                if (!gVar.f1583a) {
                    gVar.f1585c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.S
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r9 = (androidx.viewpager.widget.ViewPager.g) r9
            boolean r10 = r9.f1583a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f1584b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$k r13 = r12.a0
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r0 = (androidx.viewpager.widget.ViewPager.g) r0
            boolean r0 = r0.f1583a
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$k r3 = r12.a0
            r3.a(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.R = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int, float, int):void");
    }

    void a(int i2, int i3, int i4) {
        int i5;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.k;
        if (scroller != null && !scroller.isFinished()) {
            i5 = this.l ? this.k.getCurrX() : this.k.getStartX();
            this.k.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            a(false);
            e();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(a2 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.f.a(this.g)) + this.n)) + 1.0f) * 100.0f), 600);
        this.l = false;
        this.k.startScroll(i5, scrollY, i6, i7, min);
        s.z(this);
    }

    public void a(int i2, boolean z) {
        this.w = false;
        a(i2, z, false);
    }

    void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    void a(int i2, boolean z, boolean z2, int i3) {
        androidx.viewpager.widget.a aVar = this.f;
        if (aVar == null || aVar.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.g != i2 || this.f1572c.size() == 0) {
            boolean z3 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f.a()) {
                i2 = this.f.a() - 1;
            }
            int i4 = this.x;
            int i5 = this.g;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f1572c.size(); i6++) {
                    this.f1572c.get(i6).f1580c = true;
                }
            }
            if (this.g == i2) {
                z3 = false;
            }
            if (this.Q) {
                this.g = i2;
                if (z3) {
                    d(i2);
                }
                requestLayout();
                return;
            }
            c(i2);
            a(i2, z, i3, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void a(j jVar) {
        if (this.T == null) {
            this.T = new ArrayList();
        }
        this.T.add(jVar);
    }

    public boolean a(int i2) {
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus == null || findNextFocus == view) {
            if (i2 == 17 || i2 == 1) {
                z2 = c();
            } else if (i2 == 66 || i2 == 2) {
                z2 = d();
            }
        } else if (i2 == 17) {
            int i3 = a(this.f1574e, findNextFocus).left;
            int i4 = a(this.f1574e, view).left;
            if (view != null && i3 >= i4) {
                z2 = c();
            }
            z2 = findNextFocus.requestFocus();
        } else if (i2 == 66) {
            int i5 = a(this.f1574e, findNextFocus).left;
            int i6 = a(this.f1574e, view).left;
            if (view != null && i5 <= i6) {
                z2 = d();
            }
            z2 = findNextFocus.requestFocus();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z2;
    }

    public boolean a(KeyEvent keyEvent) {
        int i2;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return a(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return a(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return d();
                } else {
                    i2 = 66;
                }
            } else if (keyEvent.hasModifiers(2)) {
                return c();
            } else {
                i2 = 17;
            }
            return a(i2);
        }
        return false;
    }

    protected boolean a(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        f b2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1579b == this.g) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f b2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1579b == this.g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        gVar.f1583a |= c(view);
        if (!this.u) {
            super.addView(view, i2, layoutParams);
        } else if (gVar == null || !gVar.f1583a) {
            gVar.f1586d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    f b(int i2) {
        for (int i3 = 0; i3 < this.f1572c.size(); i3++) {
            f fVar = this.f1572c.get(i3);
            if (fVar.f1579b == i2) {
                return fVar;
            }
        }
        return null;
    }

    f b(View view) {
        for (int i2 = 0; i2 < this.f1572c.size(); i2++) {
            f fVar = this.f1572c.get(i2);
            if (this.f.a(view, fVar.f1578a)) {
                return fVar;
            }
        }
        return null;
    }

    void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.k = new Scroller(context, i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.J = (int) (400.0f * f2);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O = new EdgeEffect(context);
        this.P = new EdgeEffect(context);
        this.L = (int) (25.0f * f2);
        this.M = (int) (2.0f * f2);
        this.A = (int) (f2 * 16.0f);
        s.a(this, new h());
        if (s.h(this) == 0) {
            s.e(this, 1);
        }
        s.a(this, new d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c3, code lost:
        if (r15 >= 0) goto L_0x00e1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
        if (r15 >= 0) goto L_0x00e1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00df, code lost:
        if (r15 >= 0) goto L_0x00e1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
        r5 = r17.f1572c.get(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ea, code lost:
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void c(int r18) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):void");
    }

    boolean c() {
        int i2 = this.g;
        if (i2 <= 0) {
            return false;
        }
        a(i2 - 1, true);
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.r)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.s));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.l = true;
        if (this.k.isFinished() || !this.k.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.k.getCurrX();
        int currY = this.k.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!f(currX)) {
                this.k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        s.z(this);
    }

    boolean d() {
        androidx.viewpager.widget.a aVar = this.f;
        if (aVar == null || this.g >= aVar.a() - 1) {
            return false;
        }
        a(this.g + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f b2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1579b == this.g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f) != null && aVar.a() > 1)) {
            if (!this.O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.r * width);
                this.O.setSize(height, width);
                z = false | this.O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.s + 1.0f)) * width2);
                this.P.setSize(height2, width2);
                z |= this.P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O.finish();
            this.P.finish();
        }
        if (z) {
            s.z(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    void e() {
        c(this.g);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.c0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) this.d0.get(i3).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.g;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.e0);
        Scroller scroller = this.k;
        if (scroller != null && !scroller.isFinished()) {
            this.k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        float f2;
        super.onDraw(canvas);
        if (this.n > 0 && this.o != null && this.f1572c.size() > 0 && this.f != null) {
            int scrollX = getScrollX();
            float width2 = getWidth();
            float f3 = this.n / width2;
            int i2 = 0;
            f fVar = this.f1572c.get(0);
            float f4 = fVar.f1582e;
            int size = this.f1572c.size();
            int i3 = this.f1572c.get(size - 1).f1579b;
            for (int i4 = fVar.f1579b; i4 < i3; i4++) {
                while (i4 > fVar.f1579b && i2 < size) {
                    i2++;
                    fVar = this.f1572c.get(i2);
                }
                if (i4 == fVar.f1579b) {
                    float f5 = fVar.f1582e;
                    float f6 = fVar.f1581d;
                    f2 = (f5 + f6) * width2;
                    f4 = f5 + f6 + f3;
                } else {
                    float a2 = this.f.a(i4);
                    f2 = (f4 + a2) * width2;
                    f4 += a2 + f3;
                }
                if (this.n + f2 > scrollX) {
                    f3 = f3;
                    this.o.setBounds(Math.round(f2), this.p, Math.round(this.n + f2), this.q);
                    this.o.draw(canvas);
                } else {
                    f3 = f3;
                }
                if (f2 > scrollX + width) {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            i();
            return false;
        }
        if (action != 0) {
            if (this.y) {
                return true;
            }
            if (this.z) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.F = x;
            this.D = x;
            float y = motionEvent.getY();
            this.G = y;
            this.E = y;
            this.H = motionEvent.getPointerId(0);
            this.z = false;
            this.l = true;
            this.k.computeScrollOffset();
            if (this.f0 != 2 || Math.abs(this.k.getFinalX() - this.k.getCurrX()) <= this.M) {
                a(false);
                this.y = false;
            } else {
                this.k.abortAnimation();
                this.w = false;
                e();
                this.y = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.H;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(findPointerIndex);
                float f2 = x2 - this.D;
                float abs = Math.abs(f2);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.G);
                if (f2 == 0.0f || a(this.D, f2) || !a(this, false, (int) f2, (int) x2, (int) y2)) {
                    if (abs > this.C && abs * 0.5f > abs2) {
                        this.y = true;
                        c(true);
                        setScrollState(1);
                        this.D = f2 > 0.0f ? this.F + this.C : this.F - this.C;
                        this.E = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.C) {
                        this.z = true;
                    }
                    if (this.y && b(x2)) {
                        s.z(this);
                    }
                } else {
                    this.D = x2;
                    this.E = y2;
                    this.z = true;
                    return false;
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        return this.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        f b2;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f1583a) {
                    int i12 = gVar.f1584b;
                    int i13 = i12 & 7;
                    int i14 = i12 & 112;
                    if (i13 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else if (i13 == 3) {
                        paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                        i6 = paddingLeft;
                    } else if (i13 != 5) {
                        i6 = paddingLeft;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i14 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else if (i14 == 48) {
                        paddingTop = childAt.getMeasuredHeight() + paddingTop;
                        i7 = paddingTop;
                    } else if (i14 != 80) {
                        i7 = paddingTop;
                    } else {
                        i7 = (i9 - paddingBottom) - childAt.getMeasuredHeight();
                        paddingBottom += childAt.getMeasuredHeight();
                    }
                    int i15 = i6 + scrollX;
                    childAt.layout(i15, i7, childAt.getMeasuredWidth() + i15, i7 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i16 = (i8 - paddingLeft) - paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.f1583a && (b2 = b(childAt2)) != null) {
                    float f2 = i16;
                    int i18 = ((int) (b2.f1582e * f2)) + paddingLeft;
                    if (gVar2.f1586d) {
                        gVar2.f1586d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * gVar2.f1585c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i18, paddingTop, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.p = paddingTop;
        this.q = i9 - paddingBottom;
        this.S = i10;
        if (this.Q) {
            z2 = false;
            a(this.g, false, 0, false);
        } else {
            z2 = false;
        }
        this.Q = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        f b2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1579b == this.g && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.a());
        androidx.viewpager.widget.a aVar = this.f;
        if (aVar != null) {
            aVar.a(mVar.f1591e, mVar.f);
            a(mVar.f1590d, false, true);
            return;
        }
        this.h = mVar.f1590d;
        this.i = mVar.f1591e;
        this.j = mVar.f;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        m mVar = new m(super.onSaveInstanceState());
        mVar.f1590d = this.g;
        androidx.viewpager.widget.a aVar = this.f;
        if (aVar != null) {
            mVar.f1591e = aVar.b();
        }
        return mVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.n;
            a(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0151  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a((DataSetObserver) null);
            this.f.b((ViewGroup) this);
            for (int i2 = 0; i2 < this.f1572c.size(); i2++) {
                f fVar = this.f1572c.get(i2);
                this.f.a((ViewGroup) this, fVar.f1579b, fVar.f1578a);
            }
            this.f.a((ViewGroup) this);
            this.f1572c.clear();
            h();
            this.g = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.f;
        this.f = aVar;
        this.f1571b = 0;
        if (this.f != null) {
            if (this.m == null) {
                this.m = new l();
            }
            this.f.a((DataSetObserver) this.m);
            this.w = false;
            boolean z = this.Q;
            this.Q = true;
            this.f1571b = this.f.a();
            if (this.h >= 0) {
                this.f.a(this.i, this.j);
                a(this.h, false, true);
                this.h = -1;
                this.i = null;
                this.j = null;
            } else if (!z) {
                e();
            } else {
                requestLayout();
            }
        }
        List<i> list = this.W;
        if (!(list == null || list.isEmpty())) {
            int size = this.W.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.W.get(i3).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.w = false;
        a(i2, !this.Q, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.x) {
            this.x = i2;
            e();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.U = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.n;
        this.n = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.a.c(getContext(), i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i2) {
        if (this.f0 != i2) {
            this.f0 = i2;
            if (this.a0 != null) {
                b(i2 != 0);
            }
            e(i2);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }
}
