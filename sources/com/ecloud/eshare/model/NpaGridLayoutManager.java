package com.ecloud.eshare.model;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class NpaGridLayoutManager extends GridLayoutManager {
    public NpaGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public NpaGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        try {
            super.e(vVar, a0Var);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
