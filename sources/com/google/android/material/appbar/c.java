package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private d f3126a;

    /* renamed from: b  reason: collision with root package name */
    private int f3127b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f3128c = 0;

    public c() {
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i) {
        d dVar = this.f3126a;
        if (dVar != null) {
            return dVar.b(i);
        }
        this.f3127b = i;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.f3126a == null) {
            this.f3126a = new d(v);
        }
        this.f3126a.b();
        int i2 = this.f3127b;
        if (i2 != 0) {
            this.f3126a.b(i2);
            this.f3127b = 0;
        }
        int i3 = this.f3128c;
        if (i3 == 0) {
            return true;
        }
        this.f3126a.a(i3);
        this.f3128c = 0;
        return true;
    }

    public int b() {
        d dVar = this.f3126a;
        if (dVar != null) {
            return dVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.c(v, i);
    }
}
