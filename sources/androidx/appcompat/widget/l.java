package androidx.appcompat.widget;

import a.a.ActionBar;
import a.g.l.r;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.core.widget.k;

/* loaded from: classes.dex */
public class l extends ImageButton implements r, k {

    /* renamed from: b  reason: collision with root package name */
    private final e f986b;

    /* renamed from: c  reason: collision with root package name */
    private final m f987c;

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.imageButtonStyle);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(p0.b(context), attributeSet, i);
        this.f986b = new e(this);
        this.f986b.a(attributeSet, i);
        this.f987c = new m(this);
        this.f987c.a(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f986b;
        if (eVar != null) {
            eVar.a();
        }
        m mVar = this.f987c;
        if (mVar != null) {
            mVar.a();
        }
    }

    @Override // a.g.l.r
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f986b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // a.g.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f986b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public ColorStateList getSupportImageTintList() {
        m mVar = this.f987c;
        if (mVar != null) {
            return mVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public PorterDuff.Mode getSupportImageTintMode() {
        m mVar = this.f987c;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f987c.d() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f986b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f986b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m mVar = this.f987c;
        if (mVar != null) {
            mVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.f987c;
        if (mVar != null) {
            mVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f987c.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.f987c;
        if (mVar != null) {
            mVar.a();
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f986b;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f986b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintList(ColorStateList colorStateList) {
        m mVar = this.f987c;
        if (mVar != null) {
            mVar.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        m mVar = this.f987c;
        if (mVar != null) {
            mVar.a(mode);
        }
    }
}
