package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import b.c.a.a.q.a;
import com.google.android.material.internal.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
class b extends a {
    private InsetDrawable I;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, b.c.a.a.q.b bVar) {
        super(gVar, bVar);
    }

    private Animator a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.u, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.u, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(a.B);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.u.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(a.C, a(f, f3));
            stateListAnimator.addState(a.D, a(f, f2));
            stateListAnimator.addState(a.E, a(f, f2));
            stateListAnimator.addState(a.F, a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.u, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                g gVar = this.u;
                arrayList.add(ObjectAnimator.ofFloat(gVar, View.TRANSLATION_Z, gVar.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.u, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(a.B);
            stateListAnimator.addState(a.G, animatorSet);
            stateListAnimator.addState(a.H, a(0.0f, 0.0f));
            this.u.setStateListAnimator(stateListAnimator);
        }
        if (this.v.b()) {
            p();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a(Rect rect) {
        if (this.v.b()) {
            float a2 = this.v.a();
            float b2 = b() + this.p;
            int ceil = (int) Math.ceil(a.a(b2, a2, false));
            int ceil2 = (int) Math.ceil(a.b(b2, a2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void a(int[] iArr) {
        g gVar;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.u.isEnabled()) {
                this.u.setElevation(this.n);
                if (this.u.isPressed()) {
                    gVar = this.u;
                    f = this.p;
                } else if (this.u.isFocused() || this.u.isHovered()) {
                    gVar = this.u;
                    f = this.o;
                }
                gVar.setTranslationZ(f);
            }
            this.u.setElevation(0.0f);
            gVar = this.u;
            gVar.setTranslationZ(f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float b() {
        return this.u.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(b.c.a.a.p.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void b(Rect rect) {
        b.c.a.a.q.b bVar;
        Drawable drawable;
        if (this.v.b()) {
            this.I = new InsetDrawable(this.k, rect.left, rect.top, rect.right, rect.bottom);
            bVar = this.v;
            drawable = this.I;
        } else {
            bVar = this.v;
            drawable = this.k;
        }
        bVar.a(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.a
    public void k() {
        p();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean n() {
        return false;
    }
}
