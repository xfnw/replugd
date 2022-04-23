package com.google.android.material.transformation;

import a.g.l.s;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.m.b;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    private int f3230a = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3231b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3232c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f3233d;

        a(View view, int i, b bVar) {
            this.f3231b = view;
            this.f3232c = i;
            this.f3233d = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f3231b.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f3230a == this.f3232c) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f3233d;
                expandableBehavior.a((View) bVar, this.f3231b, bVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(boolean z) {
        if (!z) {
            return this.f3230a == 1;
        }
        int i = this.f3230a;
        return i == 0 || i == 2;
    }

    protected abstract boolean a(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        b e2;
        if (s.w(view) || (e2 = e(coordinatorLayout, view)) == null || !a(e2.a())) {
            return false;
        }
        this.f3230a = e2.a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, this.f3230a, e2));
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f3230a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    protected b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> b2 = coordinatorLayout.b(view);
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            View view2 = b2.get(i);
            if (a(coordinatorLayout, (CoordinatorLayout) view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }
}
