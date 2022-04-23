package com.google.android.material.internal;

import android.widget.ImageButton;

/* loaded from: classes.dex */
public class g extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    private int f3210b;

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f3210b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3210b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
