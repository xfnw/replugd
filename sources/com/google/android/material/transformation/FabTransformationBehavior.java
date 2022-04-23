package com.google.android.material.transformation;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.j.h;
import b.c.a.a.j.i;
import b.c.a.a.j.j;
import b.c.a.a.l.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f3237c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f3238d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f3239e;
    private final int[] f;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3240b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3241c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f3242d;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f3240b = z;
            this.f3241c = view;
            this.f3242d = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f3240b) {
                this.f3241c.setVisibility(4);
                this.f3242d.setAlpha(1.0f);
                this.f3242d.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f3240b) {
                this.f3241c.setVisibility(0);
                this.f3242d.setAlpha(0.0f);
                this.f3242d.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3243b;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f3243b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3243b.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.a.l.d f3244b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Drawable f3245c;

        c(FabTransformationBehavior fabTransformationBehavior, b.c.a.a.l.d dVar, Drawable drawable) {
            this.f3244b = dVar;
            this.f3245c = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3244b.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f3244b.setCircularRevealOverlayDrawable(this.f3245c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.a.l.d f3246b;

        d(FabTransformationBehavior fabTransformationBehavior, b.c.a.a.l.d dVar) {
            this.f3246b = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f3246b.getRevealInfo();
            revealInfo.f1748c = Float.MAX_VALUE;
            this.f3246b.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public h f3247a;

        /* renamed from: b  reason: collision with root package name */
        public j f3248b;
    }

    public FabTransformationBehavior() {
        this.f3237c = new Rect();
        this.f3238d = new RectF();
        this.f3239e = new RectF();
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3237c = new Rect();
        this.f3238d = new RectF();
        this.f3239e = new RectF();
        this.f = new int[2];
    }

    private float a(View view, View view2, j jVar) {
        RectF rectF = this.f3238d;
        RectF rectF2 = this.f3239e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float a(e eVar, i iVar, float f, float f2) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i a3 = eVar.f3247a.a("expansion");
        return b.c.a.a.j.a.a(f, f2, iVar.c().getInterpolation(((float) (((a3.a() + a3.b()) + 17) - a2)) / ((float) b2)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(b.c.a.a.e.mtrl_child_content_container);
        return findViewById != null ? c(findViewById) : ((view instanceof com.google.android.material.transformation.b) || (view instanceof com.google.android.material.transformation.a)) ? c(((ViewGroup) view).getChildAt(0)) : c(view);
    }

    private void a(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void a(View view, View view2, boolean z, boolean z2, e eVar, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof b.c.a.a.l.d) {
            b.c.a.a.l.d dVar = (b.c.a.a.l.d) view2;
            float a2 = a(view, view2, eVar.f3248b);
            float b2 = b(view, view2, eVar.f3248b);
            ((FloatingActionButton) view).a(this.f3237c);
            float width = this.f3237c.width() / 2.0f;
            i a3 = eVar.f3247a.a("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.e(a2, b2, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f1748c;
                }
                animator = b.c.a.a.l.a.a(dVar, a2, b2, b.c.a.a.n.a.a(a2, b2, 0.0f, 0.0f, f, f2));
                animator.addListener(new d(this, dVar));
                a(view2, a3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f3 = dVar.getRevealInfo().f1748c;
                animator = b.c.a.a.l.a.a(dVar, a2, b2, width);
                int i = (int) a2;
                int i2 = (int) b2;
                a(view2, a3.a(), i, i2, f3, list);
                a(view2, a3.a(), a3.b(), eVar.f3247a.a(), i, i2, width, list);
            }
            a3.a(animator);
            list.add(animator);
            list2.add(b.c.a.a.l.a.a(dVar));
        }
    }

    private void a(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof b.c.a.a.l.d) || b.c.a.a.l.c.f1741a != 0) && (a2 = a(view2)) != null) {
                if (z) {
                    if (!z2) {
                        b.c.a.a.j.d.f1716a.set(a2, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(a2, b.c.a.a.j.d.f1716a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(a2, b.c.a.a.j.d.f1716a, 0.0f);
                }
                eVar.f3247a.a("contentFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void a(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        String str;
        h hVar;
        i iVar;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float c2 = c(view, view2, eVar.f3248b);
        float d2 = d(view, view2, eVar.f3248b);
        if (c2 == 0.0f || d2 == 0.0f) {
            iVar = eVar.f3247a.a("translationXLinear");
            hVar = eVar.f3247a;
            str = "translationYLinear";
        } else if ((!z || d2 >= 0.0f) && (z || d2 <= 0.0f)) {
            iVar = eVar.f3247a.a("translationXCurveDownwards");
            hVar = eVar.f3247a;
            str = "translationYCurveDownwards";
        } else {
            iVar = eVar.f3247a.a("translationXCurveUpwards");
            hVar = eVar.f3247a;
            str = "translationYCurveUpwards";
        }
        i a2 = hVar.a(str);
        if (z) {
            if (!z2) {
                view2.setTranslationX(-c2);
                view2.setTranslationY(-d2);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            a(view2, eVar, iVar, a2, -c2, -d2, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -c2);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -d2);
        }
        iVar.a((Animator) objectAnimator2);
        a2.a((Animator) objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    private void a(View view, e eVar, i iVar, i iVar2, float f, float f2, float f3, float f4, RectF rectF) {
        float a2 = a(eVar, iVar, f, f3);
        float a3 = a(eVar, iVar2, f2, f4);
        Rect rect = this.f3237c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f3238d;
        rectF2.set(rect);
        RectF rectF3 = this.f3239e;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float b(View view, View view2, j jVar) {
        RectF rectF = this.f3238d;
        RectF rectF2 = this.f3239e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(View view) {
        ColorStateList b2 = s.b(view);
        if (b2 != null) {
            return b2.getColorForState(view.getDrawableState(), b2.getDefaultColor());
        }
        return 0;
    }

    private void b(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof b.c.a.a.l.d) {
            b.c.a.a.l.d dVar = (b.c.a.a.l.d) view2;
            int b2 = b(view);
            int i = 16777215 & b2;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(b2);
                }
                objectAnimator = ObjectAnimator.ofInt(dVar, d.C0054d.f1745a, i);
            } else {
                objectAnimator = ObjectAnimator.ofInt(dVar, d.C0054d.f1745a, b2);
            }
            objectAnimator.setEvaluator(b.c.a.a.j.c.a());
            eVar.f3247a.a("color").a((Animator) objectAnimator);
            list.add(objectAnimator);
        }
    }

    private float c(View view, View view2, j jVar) {
        float f;
        float f2;
        float f3;
        RectF rectF = this.f3238d;
        RectF rectF2 = this.f3239e;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f1729a & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i == 3) {
            f3 = rectF2.left;
            f2 = rectF.left;
        } else if (i != 5) {
            f = 0.0f;
            return f + jVar.f1730b;
        } else {
            f3 = rectF2.right;
            f2 = rectF.right;
        }
        f = f3 - f2;
        return f + jVar.f1730b;
    }

    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @TargetApi(21)
    private void c(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float f = s.f(view2) - s.f(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-f);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -f);
        }
        eVar.f3247a.a("elevation").a((Animator) objectAnimator);
        list.add(objectAnimator);
    }

    private float d(View view, View view2, j jVar) {
        float f;
        float f2;
        float f3;
        RectF rectF = this.f3238d;
        RectF rectF2 = this.f3239e;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f1729a & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i == 48) {
            f3 = rectF2.top;
            f2 = rectF.top;
        } else if (i != 80) {
            f = 0.0f;
            return f + jVar.f1731c;
        } else {
            f3 = rectF2.bottom;
            f2 = rectF.bottom;
        }
        f = f3 - f2;
        return f + jVar.f1731c;
    }

    private void d(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof b.c.a.a.l.d) && (view instanceof ImageView)) {
            b.c.a.a.l.d dVar = (b.c.a.a.l.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, b.c.a.a.j.e.f1717b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, b.c.a.a.j.e.f1717b, 255);
                }
                objectAnimator.addUpdateListener(new b(this, view2));
                eVar.f3247a.a("iconFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
                list2.add(new c(this, dVar, drawable));
            }
        }
    }

    protected abstract e a(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void a(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        e a2 = a(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.f3238d;
        a(view, view2, z, z2, a2, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        d(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, width, height, arrayList, arrayList2);
        b(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        b.c.a.a.j.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }
}
