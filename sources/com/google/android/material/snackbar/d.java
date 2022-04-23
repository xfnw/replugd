package com.google.android.material.snackbar;

import a.g.l.b0.b;
import a.g.l.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import b.c.a.a.i;

/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityManager f3216b;

    /* renamed from: c  reason: collision with root package name */
    private final b.a f3217c;

    /* renamed from: d  reason: collision with root package name */
    private c f3218d;

    /* renamed from: e  reason: collision with root package name */
    private b f3219e;

    /* loaded from: classes.dex */
    class a implements b.a {
        a() {
        }

        @Override // a.g.l.b0.b.a
        public void onTouchExplorationStateChanged(boolean z) {
            d.this.setClickableOrFocusableBasedOnAccessibility(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(i.SnackbarLayout_elevation)) {
            s.a(this, obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        this.f3216b = (AccessibilityManager) context.getSystemService("accessibility");
        this.f3217c = new a();
        b.a(this.f3216b, this.f3217c);
        setClickableOrFocusableBasedOnAccessibility(this.f3216b.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
        setClickable(!z);
        setFocusable(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f3219e;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        s.A(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f3219e;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
        b.b(this.f3216b, this.f3217c);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.f3218d;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
        this.f3219e = bVar;
    }

    void setOnLayoutChangeListener(c cVar) {
        this.f3218d = cVar;
    }
}
