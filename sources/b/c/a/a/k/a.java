package b.c.a.a.k;

import a.g.l.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.f;
import b.c.a.a.b;
import b.c.a.a.h;
import b.c.a.a.i;
import com.google.android.material.internal.e;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: d  reason: collision with root package name */
    private final c f1732d;

    /* renamed from: e  reason: collision with root package name */
    private int f1733e;
    private PorterDuff.Mode f;
    private ColorStateList g;
    private Drawable h;
    private int i;
    private int j;
    private int k;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.materialButtonStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray c2 = e.c(context, attributeSet, i.MaterialButton, i, h.Widget_MaterialComponents_Button, new int[0]);
        this.f1733e = c2.getDimensionPixelSize(i.MaterialButton_iconPadding, 0);
        this.f = com.google.android.material.internal.f.a(c2.getInt(i.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.g = b.c.a.a.o.a.a(getContext(), c2, i.MaterialButton_iconTint);
        this.h = b.c.a.a.o.a.b(getContext(), c2, i.MaterialButton_icon);
        this.k = c2.getInteger(i.MaterialButton_iconGravity, 1);
        this.i = c2.getDimensionPixelSize(i.MaterialButton_iconSize, 0);
        this.f1732d = new c(this);
        this.f1732d.a(c2);
        c2.recycle();
        setCompoundDrawablePadding(this.f1733e);
        c();
    }

    private boolean a() {
        return s.j(this) == 1;
    }

    private boolean b() {
        c cVar = this.f1732d;
        return cVar != null && !cVar.g();
    }

    private void c() {
        Drawable drawable = this.h;
        if (drawable != null) {
            this.h = drawable.mutate();
            androidx.core.graphics.drawable.a.a(this.h, this.g);
            PorterDuff.Mode mode = this.f;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.h, mode);
            }
            int i = this.i;
            if (i == 0) {
                i = this.h.getIntrinsicWidth();
            }
            int i2 = this.i;
            if (i2 == 0) {
                i2 = this.h.getIntrinsicHeight();
            }
            Drawable drawable2 = this.h;
            int i3 = this.j;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        androidx.core.widget.i.a(this, this.h, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f1732d.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.h;
    }

    public int getIconGravity() {
        return this.k;
    }

    public int getIconPadding() {
        return this.f1733e;
    }

    public int getIconSize() {
        return this.i;
    }

    public ColorStateList getIconTint() {
        return this.g;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f1732d.b();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f1732d.c();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f1732d.d();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f, a.g.l.r
    public ColorStateList getSupportBackgroundTintList() {
        return b() ? this.f1732d.e() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f, a.g.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return b() ? this.f1732d.f() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && b()) {
            this.f1732d.a(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21 && (cVar = this.f1732d) != null) {
            cVar.a(i4 - i2, i3 - i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h != null && this.k == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i3 = this.i;
            if (i3 == 0) {
                i3 = this.h.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - s.m(this)) - i3) - this.f1733e) - s.n(this)) / 2;
            if (a()) {
                measuredWidth = -measuredWidth;
            }
            if (this.j != measuredWidth) {
                this.j = measuredWidth;
                c();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (b()) {
            this.f1732d.a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.f1732d.h();
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? a.a.k.a.a.c(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i) {
        if (b()) {
            this.f1732d.b(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.h != drawable) {
            this.h = drawable;
            c();
        }
    }

    public void setIconGravity(int i) {
        this.k = i;
    }

    public void setIconPadding(int i) {
        if (this.f1733e != i) {
            this.f1733e = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? a.a.k.a.a.c(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.i != i) {
            this.i = i;
            c();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            c();
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(a.a.k.a.a.b(getContext(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f1732d.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (b()) {
            setRippleColor(a.a.k.a.a.b(getContext(), i));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f1732d.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (b()) {
            setStrokeColor(a.a.k.a.a.b(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (b()) {
            this.f1732d.c(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.f, a.g.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f1732d.c(colorStateList);
        } else if (this.f1732d != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f, a.g.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f1732d.a(mode);
        } else if (this.f1732d != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }
}
