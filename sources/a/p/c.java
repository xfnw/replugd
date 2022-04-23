package a.p;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends m {
    private static final String[] N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> O = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> P = new C0026c(PointF.class, "topLeft");
    private static final Property<k, PointF> Q = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> R = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> S = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> T = new g(PointF.class, "position");
    private static a.p.k U = new a.p.k();
    private int[] K = new int[2];
    private boolean L = false;
    private boolean M = false;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f522b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f523c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f524d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f525e;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f522b = viewGroup;
            this.f523c = bitmapDrawable;
            this.f524d = view;
            this.f525e = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d0.b(this.f522b).b(this.f523c);
            d0.a(this.f524d, this.f525e);
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f526a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f526a);
            Rect rect = this.f526a;
            return new PointF(rect.left, rect.top);
        }

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f526a);
            this.f526a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f526a);
        }
    }

    /* renamed from: a.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0026c extends Property<k, PointF> {
        C0026c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: a */
        public void set(k kVar, PointF pointF) {
            kVar.b(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: a */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            d0.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            d0.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            d0.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f527b;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.f527b = kVar;
            this.mViewBounds = this.f527b;
        }
    }

    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f528b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f529c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Rect f530d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f531e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        i(c cVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f529c = view;
            this.f530d = rect;
            this.f531e = i;
            this.f = i2;
            this.g = i3;
            this.h = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f528b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f528b) {
                s.a(this.f529c, this.f530d);
                d0.a(this.f529c, this.f531e, this.f, this.g, this.h);
            }
        }
    }

    /* loaded from: classes.dex */
    class j extends n {

        /* renamed from: b  reason: collision with root package name */
        boolean f532b = false;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewGroup f533c;

        j(c cVar, ViewGroup viewGroup) {
            this.f533c = viewGroup;
        }

        @Override // a.p.n, a.p.m.f
        public void a(m mVar) {
            x.a(this.f533c, false);
        }

        @Override // a.p.n, a.p.m.f
        public void b(m mVar) {
            x.a(this.f533c, true);
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            if (!this.f532b) {
                x.a(this.f533c, false);
            }
            mVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f534a;

        /* renamed from: b  reason: collision with root package name */
        private int f535b;

        /* renamed from: c  reason: collision with root package name */
        private int f536c;

        /* renamed from: d  reason: collision with root package name */
        private int f537d;

        /* renamed from: e  reason: collision with root package name */
        private View f538e;
        private int f;
        private int g;

        k(View view) {
            this.f538e = view;
        }

        private void a() {
            d0.a(this.f538e, this.f534a, this.f535b, this.f536c, this.f537d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.f536c = Math.round(pointF.x);
            this.f537d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        void b(PointF pointF) {
            this.f534a = Math.round(pointF.x);
            this.f535b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }
    }

    private boolean a(View view, View view2) {
        if (!this.M) {
            return true;
        }
        s a2 = a(view, true);
        if (a2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == a2.f603b) {
            return true;
        }
        return false;
    }

    private void d(s sVar) {
        View view = sVar.f603b;
        if (s.w(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            sVar.f602a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            sVar.f602a.put("android:changeBounds:parent", sVar.f603b.getParent());
            if (this.M) {
                sVar.f603b.getLocationInWindow(this.K);
                sVar.f602a.put("android:changeBounds:windowX", Integer.valueOf(this.K[0]));
                sVar.f602a.put("android:changeBounds:windowY", Integer.valueOf(this.K[1]));
            }
            if (this.L) {
                sVar.f602a.put("android:changeBounds:clip", s.d(view));
            }
        }
    }

    @Override // a.p.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        Animator animator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Property<View, PointF> property;
        Path path;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f602a;
        Map<String, Object> map2 = sVar2.f602a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f603b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.f602a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.f602a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) sVar.f602a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar2.f602a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.L) {
                view = view2;
                d0.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        path = f().a(i4, i6, i5, i7);
                        property = T;
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a2 = a.p.f.a(kVar, P, f().a(i4, i6, i5, i7));
                        ObjectAnimator a3 = a.p.f.a(kVar, Q, f().a(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a2, a3);
                        animatorSet.addListener(new h(this, kVar));
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    path = f().a(i8, i10, i9, i11);
                    property = R;
                } else {
                    path = f().a(i4, i6, i5, i7);
                    property = S;
                }
                animator = a.p.f.a(view, property, path);
            } else {
                view = view2;
                d0.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a4 = (i4 == i5 && i6 == i7) ? null : a.p.f.a(view, T, f().a(i4, i6, i5, i7));
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (!rect.equals(rect6)) {
                    s.a(view, rect);
                    a.p.k kVar2 = U;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", kVar2, objArr);
                    objectAnimator.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                } else {
                    objectAnimator = null;
                }
                animator = r.a(a4, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.a(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) sVar.f602a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) sVar.f602a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) sVar2.f602a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) sVar2.f602a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.K);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = d0.c(view2);
        d0.a(view2, 0.0f);
        d0.b(viewGroup).a(bitmapDrawable);
        a.p.g f2 = f();
        int[] iArr = this.K;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, a.p.i.a(O, f2.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c2));
        return ofPropertyValuesHolder;
    }

    @Override // a.p.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // a.p.m
    public void c(s sVar) {
        d(sVar);
    }

    @Override // a.p.m
    public String[] n() {
        return N;
    }
}
