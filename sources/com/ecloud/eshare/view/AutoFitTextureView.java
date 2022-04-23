package com.ecloud.eshare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes.dex */
public class AutoFitTextureView extends TextureView {

    /* renamed from: b  reason: collision with root package name */
    private int f2937b;

    /* renamed from: c  reason: collision with root package name */
    private int f2938c;

    public AutoFitTextureView(Context context) {
        this(context, null);
    }

    public AutoFitTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoFitTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2937b = 0;
        this.f2938c = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.f2937b;
        if (i4 == 0 || (i3 = this.f2938c) == 0) {
            setMeasuredDimension(size, size2);
        } else if (size > (size2 * i4) / i3) {
            setMeasuredDimension(size, (i3 * size) / i4);
        } else {
            setMeasuredDimension((i4 * size2) / i3, size2);
        }
    }
}
