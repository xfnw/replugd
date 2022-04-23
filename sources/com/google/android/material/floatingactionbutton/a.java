package com.google.android.material.floatingactionbutton;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class a {
    static final TimeInterpolator B = b.c.a.a.j.a.f1712b;
    static final int[] C = {16842919, 16842910};
    static final int[] D = {16843623, 16842908, 16842910};
    static final int[] E = {16842908, 16842910};
    static final int[] F = {16843623, 16842910};
    static final int[] G = {16842910};
    static final int[] H = new int[0];
    private ViewTreeObserver.OnPreDrawListener A;

    /* renamed from: b  reason: collision with root package name */
    Animator f3178b;

    /* renamed from: c  reason: collision with root package name */
    b.c.a.a.j.h f3179c;

    /* renamed from: d  reason: collision with root package name */
    b.c.a.a.j.h f3180d;

    /* renamed from: e  reason: collision with root package name */
    private b.c.a.a.j.h f3181e;
    private b.c.a.a.j.h f;
    b.c.a.a.q.a h;
    private float i;
    Drawable j;
    Drawable k;
    com.google.android.material.internal.a l;
    Drawable m;
    float n;
    float o;
    float p;
    int q;
    private ArrayList<Animator.AnimatorListener> s;
    private ArrayList<Animator.AnimatorListener> t;
    final com.google.android.material.internal.g u;
    final b.c.a.a.q.b v;

    /* renamed from: a  reason: collision with root package name */
    int f3177a = 0;
    float r = 1.0f;
    private final Rect w = new Rect();
    private final RectF x = new RectF();
    private final RectF y = new RectF();
    private final Matrix z = new Matrix();
    private final com.google.android.material.internal.d g = new com.google.android.material.internal.d();

    /* renamed from: com.google.android.material.floatingactionbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0093a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3182b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f3183c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ g f3184d;

        C0093a(boolean z, g gVar) {
            this.f3183c = z;
            this.f3184d = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3182b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f3177a = 0;
            aVar.f3178b = null;
            if (!this.f3182b) {
                aVar.u.a(this.f3183c ? 8 : 4, this.f3183c);
                g gVar = this.f3184d;
                if (gVar != null) {
                    gVar.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.u.a(0, this.f3183c);
            a aVar = a.this;
            aVar.f3177a = 1;
            aVar.f3178b = animator;
            this.f3182b = false;
        }
    }

    /* loaded from: classes.dex */
    class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3186b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f3187c;

        b(boolean z, g gVar) {
            this.f3186b = z;
            this.f3187c = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f3177a = 0;
            aVar.f3178b = null;
            g gVar = this.f3187c;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.u.a(0, this.f3186b);
            a aVar = a.this;
            aVar.f3177a = 2;
            aVar.f3178b = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.m();
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class d extends i {
        d(a aVar) {
            super(aVar, null);
        }
    }

    /* loaded from: classes.dex */
    private class e extends i {
        e() {
            super(a.this, null);
        }
    }

    /* loaded from: classes.dex */
    private class f extends i {
        f() {
            super(a.this, null);
        }
    }

    /* loaded from: classes.dex */
    interface g {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    private class h extends i {
        h() {
            super(a.this, null);
        }
    }

    /* loaded from: classes.dex */
    private abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3190b;

        /* renamed from: c  reason: collision with root package name */
        private float f3191c;

        /* renamed from: d  reason: collision with root package name */
        private float f3192d;

        private i() {
        }

        /* synthetic */ i(a aVar, C0093a aVar2) {
            this();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.h.b(this.f3192d);
            throw null;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f3190b) {
                a.this.h.b();
                throw null;
            }
            b.c.a.a.q.a aVar = a.this.h;
            float f = this.f3191c;
            aVar.b(f + ((this.f3192d - f) * valueAnimator.getAnimatedFraction()));
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.android.material.internal.g gVar, b.c.a.a.q.b bVar) {
        this.u = gVar;
        this.v = bVar;
        this.g.a(C, a((i) new f()));
        this.g.a(D, a((i) new e()));
        this.g.a(E, a((i) new e()));
        this.g.a(F, a((i) new e()));
        this.g.a(G, a((i) new h()));
        this.g.a(H, a((i) new d(this)));
        this.i = this.u.getRotation();
    }

    private AnimatorSet a(b.c.a.a.j.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, View.ALPHA, f2);
        hVar.a("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u, View.SCALE_X, f3);
        hVar.a("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.u, View.SCALE_Y, f3);
        hVar.a("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.z);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.u, new b.c.a.a.j.f(), new b.c.a.a.j.g(), new Matrix(this.z));
        hVar.a("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        b.c.a.a.j.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator a(i iVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(B);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(iVar);
        valueAnimator.addUpdateListener(iVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.u.getDrawable();
        if (drawable != null && this.q != 0) {
            RectF rectF = this.x;
            RectF rectF2 = this.y;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i2 = this.q;
            rectF2.set(0.0f, 0.0f, i2, i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.q;
            matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
        }
    }

    private void q() {
        if (this.A == null) {
            this.A = new c();
        }
    }

    private b.c.a.a.j.h r() {
        if (this.f == null) {
            this.f = b.c.a.a.j.h.a(this.u.getContext(), b.c.a.a.a.design_fab_hide_motion_spec);
        }
        return this.f;
    }

    private b.c.a.a.j.h s() {
        if (this.f3181e == null) {
            this.f3181e = b.c.a.a.j.h.a(this.u.getContext(), b.c.a.a.a.design_fab_show_motion_spec);
        }
        return this.f3181e;
    }

    private boolean t() {
        return s.w(this.u) && !this.u.isInEditMode();
    }

    private void u() {
        int i2;
        com.google.android.material.internal.g gVar;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.i % 90.0f != 0.0f) {
                i2 = 1;
                if (this.u.getLayerType() != 1) {
                    gVar = this.u;
                    gVar.setLayerType(i2, null);
                }
            } else if (this.u.getLayerType() != 0) {
                gVar = this.u;
                i2 = 0;
                gVar.setLayerType(i2, null);
            }
        }
        b.c.a.a.q.a aVar = this.h;
        if (aVar == null) {
            com.google.android.material.internal.a aVar2 = this.l;
            if (aVar2 != null) {
                aVar2.a(-this.i);
                throw null;
            }
            return;
        }
        aVar.a(-this.i);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable a() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.n != f2) {
            this.n = f2;
            a(this.n, this.o, this.p);
        }
    }

    void a(float f2, float f3, float f4) {
        b.c.a.a.q.a aVar = this.h;
        if (aVar != null) {
            aVar.a(f2, this.p + f2);
            throw null;
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        this.t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        com.google.android.material.internal.a aVar = this.l;
        if (aVar != null) {
            aVar.a(colorStateList);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
    }

    void a(Rect rect) {
        this.h.getPadding(rect);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b.c.a.a.j.h hVar) {
        this.f3180d = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g gVar, boolean z) {
        if (!g()) {
            Animator animator = this.f3178b;
            if (animator != null) {
                animator.cancel();
            }
            if (t()) {
                b.c.a.a.j.h hVar = this.f3180d;
                if (hVar == null) {
                    hVar = r();
                }
                AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new C0093a(z, gVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.t;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.u.a(z ? 8 : 4, z);
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.g.a(iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.o != f2) {
            this.o = f2;
            a(this.n, this.o, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.k;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, b.c.a.a.p.a.a(colorStateList));
        }
    }

    void b(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(b.c.a.a.j.h hVar) {
        this.f3179c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(g gVar, boolean z) {
        if (!h()) {
            Animator animator = this.f3178b;
            if (animator != null) {
                animator.cancel();
            }
            if (t()) {
                if (this.u.getVisibility() != 0) {
                    this.u.setAlpha(0.0f);
                    this.u.setScaleY(0.0f);
                    this.u.setScaleX(0.0f);
                    c(0.0f);
                }
                b.c.a.a.j.h hVar = this.f3179c;
                if (hVar == null) {
                    hVar = s();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new b(z, gVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.s;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.u.a(0, z);
            this.u.setAlpha(1.0f);
            this.u.setScaleY(1.0f);
            this.u.setScaleX(1.0f);
            c(1.0f);
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b.c.a.a.j.h c() {
        return this.f3180d;
    }

    final void c(float f2) {
        this.r = f2;
        Matrix matrix = this.z;
        a(f2, matrix);
        this.u.setImageMatrix(matrix);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.t;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(float f2) {
        if (this.p != f2) {
            this.p = f2;
            a(this.n, this.o, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.s;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b.c.a.a.j.h f() {
        return this.f3179c;
    }

    boolean g() {
        return this.u.getVisibility() == 0 ? this.f3177a == 1 : this.f3177a != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.u.getVisibility() != 0 ? this.f3177a == 2 : this.f3177a != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.g.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (n()) {
            q();
            this.u.getViewTreeObserver().addOnPreDrawListener(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (this.A != null) {
            this.u.getViewTreeObserver().removeOnPreDrawListener(this.A);
            this.A = null;
        }
    }

    void m() {
        float rotation = this.u.getRotation();
        if (this.i != rotation) {
            this.i = rotation;
            u();
        }
    }

    boolean n() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o() {
        c(this.r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p() {
        Rect rect = this.w;
        a(rect);
        b(rect);
        this.v.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
