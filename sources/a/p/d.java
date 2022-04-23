package a.p;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class d extends i0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f539b;

        a(d dVar, View view) {
            this.f539b = view;
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            d0.a(this.f539b, 1.0f);
            d0.a(this.f539b);
            mVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final View f540b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f541c = false;

        b(View view) {
            this.f540b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d0.a(this.f540b, 1.0f);
            if (this.f541c) {
                this.f540b.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (s.t(this.f540b) && this.f540b.getLayerType() == 0) {
                this.f541c = true;
                this.f540b.setLayerType(2, null);
            }
        }
    }

    public d(int i) {
        a(i);
    }

    private static float a(s sVar, float f) {
        Float f2;
        return (sVar == null || (f2 = (Float) sVar.f602a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    private Animator a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        d0.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, d0.f545d, f2);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // a.p.i0
    public Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float f = 0.0f;
        float a2 = a(sVar, 0.0f);
        if (a2 != 1.0f) {
            f = a2;
        }
        return a(view, f, 1.0f);
    }

    @Override // a.p.i0
    public Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        d0.e(view);
        return a(view, a(sVar, 1.0f), 0.0f);
    }

    @Override // a.p.i0, a.p.m
    public void c(s sVar) {
        super.c(sVar);
        sVar.f602a.put("android:fade:transitionAlpha", Float.valueOf(d0.c(sVar.f603b)));
    }
}
