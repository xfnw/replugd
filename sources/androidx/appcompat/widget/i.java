package androidx.appcompat.widget;

import a.a.j;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;

/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f970a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f971b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f972c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f973d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f974e = false;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CompoundButton compoundButton) {
        this.f970a = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = c.a(this.f970a)) == null) ? i : i + a2.getIntrinsicWidth();
    }

    void a() {
        Drawable a2 = c.a(this.f970a);
        if (a2 == null) {
            return;
        }
        if (this.f973d || this.f974e) {
            Drawable mutate = a.i(a2).mutate();
            if (this.f973d) {
                a.a(mutate, this.f971b);
            }
            if (this.f974e) {
                a.a(mutate, this.f972c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f970a.getDrawableState());
            }
            this.f970a.setButtonDrawable(mutate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f971b = colorStateList;
        this.f973d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.f972c = mode;
        this.f974e = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f970a.getContext().obtainStyledAttributes(attributeSet, j.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(j.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(j.CompoundButton_android_button, 0)) != 0) {
                this.f970a.setButtonDrawable(a.a.k.a.a.c(this.f970a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(j.CompoundButton_buttonTint)) {
                c.a(this.f970a, obtainStyledAttributes.getColorStateList(j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(j.CompoundButton_buttonTintMode)) {
                c.a(this.f970a, b0.a(obtainStyledAttributes.getInt(j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f971b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f972c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        a();
    }
}
