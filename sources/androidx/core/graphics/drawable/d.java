package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Drawable implements Drawable.Callback, c, androidx.core.graphics.drawable.b {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private int f1219b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1220c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1221d;

    /* renamed from: e  reason: collision with root package name */
    a f1222e;
    private boolean f;
    Drawable g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f1223a;

        /* renamed from: b  reason: collision with root package name */
        Drawable.ConstantState f1224b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f1225c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f1226d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, Resources resources) {
            this.f1225c = null;
            this.f1226d = d.h;
            if (aVar != null) {
                this.f1223a = aVar.f1223a;
                this.f1224b = aVar.f1224b;
                this.f1225c = aVar.f1225c;
                this.f1226d = aVar.f1226d;
            }
        }

        boolean a() {
            return this.f1224b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.f1223a;
            Drawable.ConstantState constantState = this.f1224b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // androidx.core.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Drawable drawable) {
        this.f1222e = c();
        a(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Resources resources) {
        this.f1222e = aVar;
        a(resources);
    }

    private void a(Resources resources) {
        Drawable.ConstantState constantState;
        a aVar = this.f1222e;
        if (aVar != null && (constantState = aVar.f1224b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        a aVar = this.f1222e;
        ColorStateList colorStateList = aVar.f1225c;
        PorterDuff.Mode mode = aVar.f1226d;
        if (colorStateList == null || mode == null) {
            this.f1221d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f1221d && colorForState == this.f1219b && mode == this.f1220c)) {
                setColorFilter(colorForState, mode);
                this.f1219b = colorForState;
                this.f1220c = mode;
                this.f1221d = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable a() {
        return this.g;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            a aVar = this.f1222e;
            if (aVar != null) {
                aVar.f1224b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean b() {
        return true;
    }

    a c() {
        return new b(this.f1222e, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        a aVar = this.f1222e;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        a aVar = this.f1222e;
        if (aVar == null || !aVar.a()) {
            return null;
        }
        this.f1222e.f1223a = getChangingConfigurations();
        return this.f1222e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.g.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        a aVar;
        ColorStateList colorStateList = (!b() || (aVar = this.f1222e) == null) ? null : aVar.f1225c;
        return (colorStateList != null && colorStateList.isStateful()) || this.g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.f1222e = c();
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.mutate();
            }
            a aVar = this.f1222e;
            if (aVar != null) {
                Drawable drawable2 = this.g;
                aVar.f1224b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.g.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.g.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.g.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.g.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.g.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f1222e.f1225c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1222e.f1226d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.g.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
