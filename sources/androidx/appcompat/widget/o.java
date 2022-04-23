package androidx.appcompat.widget;

import a.a.ActionBar;
import a.a.k.a.a;
import a.g.l.r;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* loaded from: classes.dex */
public class o extends MultiAutoCompleteTextView implements r {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1016d = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final e f1017b;

    /* renamed from: c  reason: collision with root package name */
    private final w f1018c;

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.autoCompleteTextViewStyle);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(p0.b(context), attributeSet, i);
        s0 a2 = s0.a(getContext(), attributeSet, f1016d, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f1017b = new e(this);
        this.f1017b.a(attributeSet, i);
        this.f1018c = new w(this);
        this.f1018c.a(attributeSet, i);
        this.f1018c.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1017b;
        if (eVar != null) {
            eVar.a();
        }
        w wVar = this.f1018c;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // a.g.l.r
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1017b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // a.g.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1017b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        k.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1017b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f1017b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.c(getContext(), i));
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1017b;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1017b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.f1018c;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }
}
