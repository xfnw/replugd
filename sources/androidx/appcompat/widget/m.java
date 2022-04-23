package androidx.appcompat.widget;

import a.a.j;
import a.a.k.a.a;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.e;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1000a;

    /* renamed from: b  reason: collision with root package name */
    private q0 f1001b;

    /* renamed from: c  reason: collision with root package name */
    private q0 f1002c;

    /* renamed from: d  reason: collision with root package name */
    private q0 f1003d;

    public m(ImageView imageView) {
        this.f1000a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1003d == null) {
            this.f1003d = new q0();
        }
        q0 q0Var = this.f1003d;
        q0Var.a();
        ColorStateList a2 = e.a(this.f1000a);
        if (a2 != null) {
            q0Var.f1031d = true;
            q0Var.f1028a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f1000a);
        if (b2 != null) {
            q0Var.f1030c = true;
            q0Var.f1029b = b2;
        }
        if (!q0Var.f1031d && !q0Var.f1030c) {
            return false;
        }
        j.a(drawable, q0Var, this.f1000a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1001b != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable drawable = this.f1000a.getDrawable();
        if (drawable != null) {
            b0.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            q0 q0Var = this.f1002c;
            if (q0Var != null) {
                j.a(drawable, q0Var, this.f1000a.getDrawableState());
                return;
            }
            q0 q0Var2 = this.f1001b;
            if (q0Var2 != null) {
                j.a(drawable, q0Var2, this.f1000a.getDrawableState());
            }
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable c2 = a.c(this.f1000a.getContext(), i);
            if (c2 != null) {
                b0.b(c2);
            }
            this.f1000a.setImageDrawable(c2);
        } else {
            this.f1000a.setImageDrawable(null);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1002c == null) {
            this.f1002c = new q0();
        }
        q0 q0Var = this.f1002c;
        q0Var.f1028a = colorStateList;
        q0Var.f1031d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1002c == null) {
            this.f1002c = new q0();
        }
        q0 q0Var = this.f1002c;
        q0Var.f1029b = mode;
        q0Var.f1030c = true;
        a();
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        s0 a2 = s0.a(this.f1000a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f1000a.getDrawable();
            if (!(drawable != null || (g = a2.g(j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.c(this.f1000a.getContext(), g)) == null)) {
                this.f1000a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                b0.b(drawable);
            }
            if (a2.g(j.AppCompatImageView_tint)) {
                e.a(this.f1000a, a2.a(j.AppCompatImageView_tint));
            }
            if (a2.g(j.AppCompatImageView_tintMode)) {
                e.a(this.f1000a, b0.a(a2.d(j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        q0 q0Var = this.f1002c;
        if (q0Var != null) {
            return q0Var.f1028a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        q0 q0Var = this.f1002c;
        if (q0Var != null) {
            return q0Var.f1029b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1000a.getBackground() instanceof RippleDrawable);
    }
}
