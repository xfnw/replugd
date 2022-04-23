package androidx.appcompat.widget;

import a.a.ActionBar;
import a.a.k.a.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.widget.j;

/* loaded from: classes.dex */
public class r extends RadioButton implements j {

    /* renamed from: b  reason: collision with root package name */
    private final i f1032b;

    /* renamed from: c  reason: collision with root package name */
    private final w f1033c;

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.radioButtonStyle);
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(p0.b(context), attributeSet, i);
        this.f1032b = new i(this);
        this.f1032b.a(attributeSet, i);
        this.f1033c = new w(this);
        this.f1033c.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f1032b;
        return iVar != null ? iVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f1032b;
        if (iVar != null) {
            return iVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f1032b;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(a.c(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f1032b;
        if (iVar != null) {
            iVar.d();
        }
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f1032b;
        if (iVar != null) {
            iVar.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f1032b;
        if (iVar != null) {
            iVar.a(mode);
        }
    }
}
