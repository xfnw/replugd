package androidx.appcompat.widget;

import a.a.j;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.c.f;
import androidx.core.widget.b;
import androidx.core.widget.i;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class w {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1068a;

    /* renamed from: b  reason: collision with root package name */
    private q0 f1069b;

    /* renamed from: c  reason: collision with root package name */
    private q0 f1070c;

    /* renamed from: d  reason: collision with root package name */
    private q0 f1071d;

    /* renamed from: e  reason: collision with root package name */
    private q0 f1072e;
    private q0 f;
    private q0 g;
    private final y h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f1073a;

        a(WeakReference weakReference) {
            this.f1073a = weakReference;
        }

        @Override // androidx.core.content.c.f.a
        public void a(int i) {
        }

        @Override // androidx.core.content.c.f.a
        public void a(Typeface typeface) {
            w.this.a(this.f1073a, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TextView textView) {
        this.f1068a = textView;
        this.h = new y(this.f1068a);
    }

    private static q0 a(Context context, j jVar, int i) {
        ColorStateList b2 = jVar.b(context, i);
        if (b2 == null) {
            return null;
        }
        q0 q0Var = new q0();
        q0Var.f1031d = true;
        q0Var.f1028a = b2;
        return q0Var;
    }

    private void a(Context context, s0 s0Var) {
        String d2;
        Typeface typeface;
        this.i = s0Var.d(j.TextAppearance_android_textStyle, this.i);
        boolean z = false;
        if (s0Var.g(j.TextAppearance_android_fontFamily) || s0Var.g(j.TextAppearance_fontFamily)) {
            this.j = null;
            int i = s0Var.g(j.TextAppearance_fontFamily) ? j.TextAppearance_fontFamily : j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.j = s0Var.a(i, this.i, new a(new WeakReference(this.f1068a)));
                    if (this.j == null) {
                        z = true;
                    }
                    this.k = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.j == null && (d2 = s0Var.d(i)) != null) {
                this.j = Typeface.create(d2, this.i);
            }
        } else if (s0Var.g(j.TextAppearance_android_typeface)) {
            this.k = false;
            int d3 = s0Var.d(j.TextAppearance_android_typeface, 1);
            if (d3 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (d3 == 2) {
                typeface = Typeface.SERIF;
            } else if (d3 == 3) {
                typeface = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.j = typeface;
        }
    }

    private void a(Drawable drawable, q0 q0Var) {
        if (drawable != null && q0Var != null) {
            j.a(drawable, q0Var, this.f1068a.getDrawableState());
        }
    }

    private void b(int i, float f) {
        this.h.a(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!(this.f1069b == null && this.f1070c == null && this.f1071d == null && this.f1072e == null)) {
            Drawable[] compoundDrawables = this.f1068a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1069b);
            a(compoundDrawables[1], this.f1070c);
            a(compoundDrawables[2], this.f1071d);
            a(compoundDrawables[3], this.f1072e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.f1068a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (!b.f1242a && !h()) {
            b(i, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        this.h.a(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        ColorStateList a2;
        s0 a3 = s0.a(context, i, j.TextAppearance);
        if (a3.g(j.TextAppearance_textAllCaps)) {
            a(a3.a(j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a3.g(j.TextAppearance_android_textColor) && (a2 = a3.a(j.TextAppearance_android_textColor)) != null) {
            this.f1068a.setTextColor(a2);
        }
        if (a3.g(j.TextAppearance_android_textSize) && a3.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f1068a.setTextSize(0, 0.0f);
        }
        a(context, a3);
        a3.a();
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f1068a.setTypeface(typeface, this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        boolean z;
        Context context = this.f1068a.getContext();
        j a2 = j.a();
        s0 a3 = s0.a(context, attributeSet, j.AppCompatTextHelper, i, 0);
        int g = a3.g(j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(j.AppCompatTextHelper_android_drawableLeft)) {
            this.f1069b = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableTop)) {
            this.f1070c = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableRight)) {
            this.f1071d = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableBottom)) {
            this.f1072e = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a3.g(j.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a3.g(j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a3.a();
        boolean z2 = this.f1068a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z3 = true;
        ColorStateList colorStateList2 = null;
        if (g != -1) {
            s0 a4 = s0.a(context, g, j.TextAppearance);
            if (z2 || !a4.g(j.TextAppearance_textAllCaps)) {
                z3 = false;
                z = false;
            } else {
                z = a4.a(j.TextAppearance_textAllCaps, false);
                z3 = true;
            }
            a(context, a4);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList2 = a4.g(j.TextAppearance_android_textColor) ? a4.a(j.TextAppearance_android_textColor) : null;
                colorStateList = a4.g(j.TextAppearance_android_textColorHint) ? a4.a(j.TextAppearance_android_textColorHint) : null;
                if (a4.g(j.TextAppearance_android_textColorLink)) {
                    colorStateList2 = a4.a(j.TextAppearance_android_textColorLink);
                }
            } else {
                colorStateList2 = null;
                colorStateList = null;
            }
            a4.a();
        } else {
            colorStateList2 = null;
            colorStateList = null;
            z3 = false;
            z = false;
        }
        s0 a5 = s0.a(context, attributeSet, j.TextAppearance, i, 0);
        if (!z2 && a5.g(j.TextAppearance_textAllCaps)) {
            z = a5.a(j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a5.g(j.TextAppearance_android_textColor)) {
                colorStateList2 = a5.a(j.TextAppearance_android_textColor);
            }
            if (a5.g(j.TextAppearance_android_textColorHint)) {
                colorStateList = a5.a(j.TextAppearance_android_textColorHint);
            }
            if (a5.g(j.TextAppearance_android_textColorLink)) {
                colorStateList2 = a5.a(j.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && a5.g(j.TextAppearance_android_textSize) && a5.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f1068a.setTextSize(0, 0.0f);
        }
        a(context, a5);
        a5.a();
        if (colorStateList2 != null) {
            this.f1068a.setTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.f1068a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f1068a.setLinkTextColor(colorStateList2);
        }
        if (!z2 && z3) {
            a(z);
        }
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f1068a.setTypeface(typeface, this.i);
        }
        this.h.a(attributeSet, i);
        if (b.f1242a && this.h.f() != 0) {
            int[] e2 = this.h.e();
            if (e2.length > 0) {
                if (this.f1068a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f1068a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.b(), this.h.d(), 0);
                } else {
                    this.f1068a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        s0 a6 = s0.a(context, attributeSet, j.AppCompatTextView);
        int c2 = a6.c(j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int c3 = a6.c(j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int c4 = a6.c(j.AppCompatTextView_lineHeight, -1);
        a6.a();
        if (c2 != -1) {
            i.a(this.f1068a, c2);
        }
        if (c3 != -1) {
            i.b(this.f1068a, c3);
        }
        if (c4 != -1) {
            i.c(this.f1068a, c4);
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f1068a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (!b.f1242a) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, int i) {
        this.h.a(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.h.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.h.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] f() {
        return this.h.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.h.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.h.g();
    }
}
