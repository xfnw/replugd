package androidx.appcompat.widget;

import a.a.ActionBar;
import a.g.l.r;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.b;
import androidx.core.widget.i;

/* loaded from: classes.dex */
public class f extends Button implements r, b {

    /* renamed from: b  reason: collision with root package name */
    private final e f947b;

    /* renamed from: c  reason: collision with root package name */
    private final w f948c;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.buttonStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(p0.b(context), attributeSet, i);
        this.f947b = new e(this);
        this.f947b.a(attributeSet, i);
        this.f948c = new w(this);
        this.f948c.a(attributeSet, i);
        this.f948c.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f947b;
        if (eVar != null) {
            eVar.a();
        }
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.f1242a) {
            return super.getAutoSizeMaxTextSize();
        }
        w wVar = this.f948c;
        if (wVar != null) {
            return wVar.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.f1242a) {
            return super.getAutoSizeMinTextSize();
        }
        w wVar = this.f948c;
        if (wVar != null) {
            return wVar.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.f1242a) {
            return super.getAutoSizeStepGranularity();
        }
        w wVar = this.f948c;
        if (wVar != null) {
            return wVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f1242a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        w wVar = this.f948c;
        return wVar != null ? wVar.f() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (b.f1242a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        w wVar = this.f948c;
        if (wVar != null) {
            return wVar.g();
        }
        return 0;
    }

    @Override // a.g.l.r
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f947b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // a.g.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f947b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        w wVar = this.f948c;
        if (wVar != null && !b.f1242a && wVar.h()) {
            this.f948c.b();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.f1242a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.f1242a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f1242a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f947b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f947b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(z);
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f947b;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f947b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (b.f1242a) {
            super.setTextSize(i, f);
            return;
        }
        w wVar = this.f948c;
        if (wVar != null) {
            wVar.a(i, f);
        }
    }
}
