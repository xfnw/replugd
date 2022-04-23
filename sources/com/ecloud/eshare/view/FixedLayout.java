package com.ecloud.eshare.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ecloud.eshare.b;

/* loaded from: classes.dex */
public final class FixedLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int[] f2950b;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public float f2951a;

        public a(Context context, AttributeSet attributeSet) {
            super(-1, -2);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.FixedLayout);
            this.f2951a = obtainStyledAttributes.getFloat(0, -1.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public FixedLayout(Context context) {
        this(context, null);
    }

    public FixedLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
            paddingTop += this.f2950b[i5];
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("FixedLayout cannot have UNSPECIFIED dimensions");
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        this.f2950b = new int[childCount];
        if (childCount != 0) {
            int i3 = paddingTop;
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i5).getLayoutParams();
                float f = layoutParams instanceof a ? ((a) layoutParams).f2951a : -1.0f;
                if (f > 0.0f) {
                    int[] iArr = this.f2950b;
                    iArr[i5] = (int) ((paddingTop * f) / 100.0f);
                    i3 -= iArr[i5];
                } else {
                    this.f2950b[i5] = 0;
                }
                int[] iArr2 = this.f2950b;
                if (iArr2[i5] >= 0) {
                    if (iArr2[i5] == 0) {
                        i4++;
                    }
                } else {
                    throw new IllegalStateException("Negative height of row: " + i5);
                }
            }
            if (i3 >= 0) {
                if (i4 > 0) {
                    int i6 = 0;
                    while (i4 > 0) {
                        int i7 = i3 / i4;
                        while (true) {
                            if (i6 < childCount && i4 > 0) {
                                int[] iArr3 = this.f2950b;
                                if (iArr3[i6] == 0) {
                                    iArr3[i6] = i7;
                                    i3 -= i7;
                                    break;
                                }
                                i6++;
                            }
                        }
                        i4--;
                    }
                    if (i3 != 0) {
                        throw new IllegalStateException("Remaining height != 0: " + i3);
                    }
                } else if (i3 > 0) {
                    int[] iArr4 = this.f2950b;
                    int i8 = childCount - 1;
                    iArr4[i8] = iArr4[i8] + i3;
                }
                for (int i9 = 0; i9 < childCount; i9++) {
                    getChildAt(i9).measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f2950b[i9], 1073741824));
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Remaining height < 0: " + i3);
        }
    }
}
