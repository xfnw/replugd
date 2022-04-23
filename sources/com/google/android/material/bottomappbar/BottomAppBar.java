package com.google.android.material.bottomappbar;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private final int Q;
    private final b.c.a.a.r.b R;
    private final com.google.android.material.bottomappbar.a S;
    private Animator T;
    private Animator U;
    private Animator V;
    private int W;
    private boolean a0;
    private boolean b0;
    AnimatorListenerAdapter c0;

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f3149d = new Rect();

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f1144d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(BottomAppBar bottomAppBar) {
            super.a((Behavior) bottomAppBar);
            FloatingActionButton m = bottomAppBar.m();
            if (m != null) {
                m.a(this.f3149d);
                m.clearAnimation();
                m.animate().translationY((-m.getPaddingBottom()) + (m.getMeasuredHeight() - this.f3149d.height())).setInterpolator(b.c.a.a.j.a.f1712b).setDuration(175L);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton m = bottomAppBar.m();
            if (m != null) {
                a(m, bottomAppBar);
                m.b(this.f3149d);
                bottomAppBar.setFabDiameter(this.f3149d.height());
            }
            if (bottomAppBar.n()) {
                coordinatorLayout.c(bottomAppBar, i);
                return super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
            }
            BottomAppBar.c(bottomAppBar);
            throw null;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.b(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b(BottomAppBar bottomAppBar) {
            super.b((Behavior) bottomAppBar);
            FloatingActionButton m = bottomAppBar.m();
            if (m != null) {
                m.clearAnimation();
                m.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(b.c.a.a.j.a.f1713c).setDuration(225L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.U = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.V = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f3152b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f3153c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3154d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f3155e;

        c(ActionMenuView actionMenuView, int i, boolean z) {
            this.f3153c = actionMenuView;
            this.f3154d = i;
            this.f3155e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3152b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f3152b) {
                BottomAppBar.this.a(this.f3153c, this.f3154d, this.f3155e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends a.i.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        int f3156d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3157e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3156d = parcel.readInt();
            this.f3157e = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3156d);
            parcel.writeInt(this.f3157e ? 1 : 0);
        }
    }

    private float a(boolean z) {
        FloatingActionButton m = m();
        if (m == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        m.a(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = m.getMeasuredHeight();
        }
        float height2 = m.getHeight() - rect.height();
        r0 = (-getCradleVerticalOffset()) + (height / 2.0f) + (m.getHeight() - rect.bottom);
        float paddingBottom = height2 - m.getPaddingBottom();
        float f = -getMeasuredHeight();
        if (z) {
        }
        return f + paddingBottom;
    }

    private int a(int i) {
        int i2 = 1;
        boolean z = s.j(this) == 1;
        if (i != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.Q;
        if (z) {
            i2 = -1;
        }
        return measuredWidth * i2;
    }

    private void a(int i, List<Animator> list) {
        if (this.b0) {
            this.S.e();
            throw null;
        }
    }

    private void a(int i, boolean z) {
        if (s.w(this)) {
            Animator animator = this.V;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!o()) {
                i = 0;
                z = false;
            }
            a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.V = animatorSet;
            this.V.addListener(new b());
            this.V.start();
        }
    }

    private void a(int i, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if ((this.b0 || (z && o())) && (this.W == 1 || i == 1)) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.addListener(new c(actionMenuView, i, z));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playSequentially(ofFloat2, ofFloat);
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = s.j(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f700a & 8388615) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i != 1 || !z) ? 0.0f : i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.a(this.c0);
        floatingActionButton.b(this.c0);
    }

    private void b(int i) {
        if (this.W != i && s.w(this)) {
            Animator animator = this.U;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            a(i, arrayList);
            b(i, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.U = animatorSet;
            this.U.addListener(new a());
            this.U.start();
        }
    }

    private void b(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m(), "translationX", a(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.c(this.c0);
        floatingActionButton.d(this.c0);
    }

    static /* synthetic */ void c(BottomAppBar bottomAppBar) {
        bottomAppBar.p();
        throw null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return a(this.W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.b0);
    }

    private void l() {
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.V;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.U;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton m() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).c(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.T;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.V) != null && animator.isRunning()) || ((animator2 = this.U) != null && animator2.isRunning());
    }

    private boolean o() {
        FloatingActionButton m = m();
        return m != null && m.b();
    }

    private void p() {
        this.S.d(getFabTranslationX());
        throw null;
    }

    public ColorStateList getBackgroundTint() {
        this.R.a();
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        this.S.a();
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.W;
    }

    public float getFabCradleMargin() {
        this.S.b();
        throw null;
    }

    public float getFabCradleRoundedCornerRadius() {
        this.S.c();
        throw null;
    }

    public boolean getHideOnScroll() {
        return this.a0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        l();
        p();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        this.W = dVar.f3156d;
        this.b0 = dVar.f3157e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f3156d = this.W;
        dVar.f3157e = this.b0;
        return dVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.R, colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.S.a(f);
            throw null;
        }
    }

    public void setFabAlignmentMode(int i) {
        b(i);
        a(i, this.b0);
        this.W = i;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.S.b(f);
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.S.c(f);
            throw null;
        }
    }

    void setFabDiameter(int i) {
        this.S.d();
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.a0 = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
