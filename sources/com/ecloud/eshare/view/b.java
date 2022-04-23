package com.ecloud.eshare.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class b extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final int f2990a;

    public b(int i) {
        this.f2990a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.bottom = this.f2990a;
    }
}
