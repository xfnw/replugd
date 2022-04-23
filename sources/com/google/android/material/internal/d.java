package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<b> f3201a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private b f3202b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f3203c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f3204d = new a();

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            if (dVar.f3203c == animator) {
                dVar.f3203c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int[] f3206a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f3207b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f3206a = iArr;
            this.f3207b = valueAnimator;
        }
    }

    private void a(b bVar) {
        this.f3203c = bVar.f3207b;
        this.f3203c.start();
    }

    private void b() {
        ValueAnimator valueAnimator = this.f3203c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f3203c = null;
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f3203c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f3203c = null;
        }
    }

    public void a(int[] iArr) {
        b bVar;
        int size = this.f3201a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = this.f3201a.get(i);
            if (StateSet.stateSetMatches(bVar.f3206a, iArr)) {
                break;
            }
            i++;
        }
        b bVar2 = this.f3202b;
        if (bVar != bVar2) {
            if (bVar2 != null) {
                b();
            }
            this.f3202b = bVar;
            if (bVar != null) {
                a(bVar);
            }
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f3204d);
        this.f3201a.add(bVar);
    }
}
