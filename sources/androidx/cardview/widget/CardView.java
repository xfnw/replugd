package androidx.cardview.widget;

import a.c.b;
import a.c.d;
import a.c.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] i = {16842801};
    private static final e j;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1091b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1092c;

    /* renamed from: d  reason: collision with root package name */
    int f1093d;

    /* renamed from: e  reason: collision with root package name */
    int f1094e;
    final Rect f;
    final Rect g;
    private final d h;

    /* loaded from: classes.dex */
    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f1095a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public View a() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.d
        public void a(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.f1093d) {
                CardView.super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.f1094e) {
                CardView.super.setMinimumHeight(i2);
            }
        }

        @Override // androidx.cardview.widget.d
        public void a(int i, int i2, int i3, int i4) {
            CardView.this.g.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void a(Drawable drawable) {
            this.f1095a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean b() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable c() {
            return this.f1095a;
        }

        @Override // androidx.cardview.widget.d
        public boolean d() {
            return CardView.this.getPreventCornerOverlap();
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        j = i2 >= 21 ? new b() : i2 >= 17 ? new androidx.cardview.widget.a() : new c();
        j.a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources;
        int i3;
        ColorStateList valueOf;
        this.f = new Rect();
        this.g = new Rect();
        this.h = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.CardView, i2, d.CardView);
        if (obtainStyledAttributes.hasValue(e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(i);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i3 = b.cardview_light_background;
            } else {
                resources = getResources();
                i3 = b.cardview_dark_background;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i3));
        }
        float dimension = obtainStyledAttributes.getDimension(e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(e.CardView_cardMaxElevation, 0.0f);
        this.f1091b = obtainStyledAttributes.getBoolean(e.CardView_cardUseCompatPadding, false);
        this.f1092c = obtainStyledAttributes.getBoolean(e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPadding, 0);
        this.f.left = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f.top = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingTop, dimensionPixelSize);
        this.f.right = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingRight, dimensionPixelSize);
        this.f.bottom = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1093d = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minWidth, 0);
        this.f1094e = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        j.a(this.h, context, valueOf, dimension, dimension2, f);
    }

    public ColorStateList getCardBackgroundColor() {
        return j.f(this.h);
    }

    public float getCardElevation() {
        return j.h(this.h);
    }

    public int getContentPaddingBottom() {
        return this.f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f.left;
    }

    public int getContentPaddingRight() {
        return this.f.right;
    }

    public int getContentPaddingTop() {
        return this.f.top;
    }

    public float getMaxCardElevation() {
        return j.a(this.h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1092c;
    }

    public float getRadius() {
        return j.b(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.f1091b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (!(j instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(j.d(this.h)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(j.c(this.h)), View.MeasureSpec.getSize(i3)), mode2);
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        j.a(this.h, ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        j.a(this.h, colorStateList);
    }

    public void setCardElevation(float f) {
        j.a(this.h, f);
    }

    public void setMaxCardElevation(float f) {
        j.c(this.h, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f1094e = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f1093d = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1092c) {
            this.f1092c = z;
            j.g(this.h);
        }
    }

    public void setRadius(float f) {
        j.b(this.h, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1091b != z) {
            this.f1091b = z;
            j.e(this.h);
        }
    }
}
