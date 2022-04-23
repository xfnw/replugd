package androidx.appcompat.widget;

import a.a.j;
import a.g.l.s;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f936a;

    /* renamed from: d  reason: collision with root package name */
    private q0 f939d;

    /* renamed from: e  reason: collision with root package name */
    private q0 f940e;
    private q0 f;

    /* renamed from: c  reason: collision with root package name */
    private int f938c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final j f937b = j.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.f936a = view;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new q0();
        }
        q0 q0Var = this.f;
        q0Var.a();
        ColorStateList b2 = s.b(this.f936a);
        if (b2 != null) {
            q0Var.f1031d = true;
            q0Var.f1028a = b2;
        }
        PorterDuff.Mode c2 = s.c(this.f936a);
        if (c2 != null) {
            q0Var.f1030c = true;
            q0Var.f1029b = c2;
        }
        if (!q0Var.f1031d && !q0Var.f1030c) {
            return false;
        }
        j.a(drawable, q0Var, this.f936a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f939d != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable background = this.f936a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            q0 q0Var = this.f940e;
            if (q0Var != null) {
                j.a(background, q0Var, this.f936a.getDrawableState());
                return;
            }
            q0 q0Var2 = this.f939d;
            if (q0Var2 != null) {
                j.a(background, q0Var2, this.f936a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f938c = i;
        j jVar = this.f937b;
        a(jVar != null ? jVar.b(this.f936a.getContext(), i) : null);
        a();
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f939d == null) {
                this.f939d = new q0();
            }
            q0 q0Var = this.f939d;
            q0Var.f1028a = colorStateList;
            q0Var.f1031d = true;
        } else {
            this.f939d = null;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f940e == null) {
            this.f940e = new q0();
        }
        q0 q0Var = this.f940e;
        q0Var.f1029b = mode;
        q0Var.f1030c = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f938c = -1;
        a((ColorStateList) null);
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        s0 a2 = s0.a(this.f936a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(j.ViewBackgroundHelper_android_background)) {
                this.f938c = a2.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f937b.b(this.f936a.getContext(), this.f938c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.g(j.ViewBackgroundHelper_backgroundTint)) {
                s.a(this.f936a, a2.a(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                s.a(this.f936a, b0.a(a2.d(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        q0 q0Var = this.f940e;
        if (q0Var != null) {
            return q0Var.f1028a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.f940e == null) {
            this.f940e = new q0();
        }
        q0 q0Var = this.f940e;
        q0Var.f1028a = colorStateList;
        q0Var.f1031d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        q0 q0Var = this.f940e;
        if (q0Var != null) {
            return q0Var.f1029b;
        }
        return null;
    }
}
