package com.google.android.material.internal;

import a.a.ActionBar;
import a.g.l.b0.c;
import a.g.l.s;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.l;

/* loaded from: classes.dex */
public class CheckableImageButton extends l implements Checkable {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f3195e = {16842912};

    /* renamed from: d  reason: collision with root package name */
    private boolean f3196d;

    /* loaded from: classes.dex */
    class a extends a.g.l.a {
        a() {
        }

        @Override // a.g.l.a
        public void a(View view, c cVar) {
            super.a(view, cVar);
            cVar.a(true);
            cVar.b(CheckableImageButton.this.isChecked());
        }

        @Override // a.g.l.a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        s.a(this, new a());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3196d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.f3196d ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + f3195e.length), f3195e) : super.onCreateDrawableState(i);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f3196d != z) {
            this.f3196d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f3196d);
    }
}
