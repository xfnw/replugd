package b.c.a.a.k;

import a.g.l.s;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.a;
import b.c.a.a.i;
import com.google.android.material.internal.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    private static final boolean w;

    /* renamed from: a  reason: collision with root package name */
    private final a f1734a;

    /* renamed from: b  reason: collision with root package name */
    private int f1735b;

    /* renamed from: c  reason: collision with root package name */
    private int f1736c;

    /* renamed from: d  reason: collision with root package name */
    private int f1737d;

    /* renamed from: e  reason: collision with root package name */
    private int f1738e;
    private int f;
    private int g;
    private PorterDuff.Mode h;
    private ColorStateList i;
    private ColorStateList j;
    private ColorStateList k;
    private GradientDrawable o;
    private Drawable p;
    private GradientDrawable q;
    private Drawable r;
    private GradientDrawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private final Paint l = new Paint(1);
    private final Rect m = new Rect();
    private final RectF n = new RectF();
    private boolean v = false;

    static {
        w = Build.VERSION.SDK_INT >= 21;
    }

    public c(a aVar) {
        this.f1734a = aVar;
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f1735b, this.f1737d, this.f1736c, this.f1738e);
    }

    private Drawable i() {
        this.o = new GradientDrawable();
        this.o.setCornerRadius(this.f + 1.0E-5f);
        this.o.setColor(-1);
        this.p = a.i(this.o);
        a.a(this.p, this.i);
        PorterDuff.Mode mode = this.h;
        if (mode != null) {
            a.a(this.p, mode);
        }
        this.q = new GradientDrawable();
        this.q.setCornerRadius(this.f + 1.0E-5f);
        this.q.setColor(-1);
        this.r = a.i(this.q);
        a.a(this.r, this.k);
        return a(new LayerDrawable(new Drawable[]{this.p, this.r}));
    }

    @TargetApi(21)
    private Drawable j() {
        this.s = new GradientDrawable();
        this.s.setCornerRadius(this.f + 1.0E-5f);
        this.s.setColor(-1);
        n();
        this.t = new GradientDrawable();
        this.t.setCornerRadius(this.f + 1.0E-5f);
        this.t.setColor(0);
        this.t.setStroke(this.g, this.j);
        InsetDrawable a2 = a(new LayerDrawable(new Drawable[]{this.s, this.t}));
        this.u = new GradientDrawable();
        this.u.setCornerRadius(this.f + 1.0E-5f);
        this.u.setColor(-1);
        return new b(b.c.a.a.p.a.a(this.k), a2, this.u);
    }

    private GradientDrawable k() {
        if (!w || this.f1734a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f1734a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable l() {
        if (!w || this.f1734a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f1734a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void m() {
        if (w && this.t != null) {
            this.f1734a.setInternalBackground(j());
        } else if (!w) {
            this.f1734a.invalidate();
        }
    }

    private void n() {
        GradientDrawable gradientDrawable = this.s;
        if (gradientDrawable != null) {
            a.a(gradientDrawable, this.i);
            PorterDuff.Mode mode = this.h;
            if (mode != null) {
                a.a(this.s, mode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        GradientDrawable gradientDrawable;
        if ((w && (gradientDrawable = this.s) != null) || (!w && (gradientDrawable = this.o) != null)) {
            gradientDrawable.setColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        GradientDrawable gradientDrawable = this.u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f1735b, this.f1737d, i2 - this.f1736c, i - this.f1738e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (w && (this.f1734a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f1734a.getBackground()).setColor(colorStateList);
            } else if (!w && (drawable = this.r) != null) {
                a.a(drawable, colorStateList);
            }
        }
    }

    public void a(TypedArray typedArray) {
        int i = 0;
        this.f1735b = typedArray.getDimensionPixelOffset(i.MaterialButton_android_insetLeft, 0);
        this.f1736c = typedArray.getDimensionPixelOffset(i.MaterialButton_android_insetRight, 0);
        this.f1737d = typedArray.getDimensionPixelOffset(i.MaterialButton_android_insetTop, 0);
        this.f1738e = typedArray.getDimensionPixelOffset(i.MaterialButton_android_insetBottom, 0);
        this.f = typedArray.getDimensionPixelSize(i.MaterialButton_cornerRadius, 0);
        this.g = typedArray.getDimensionPixelSize(i.MaterialButton_strokeWidth, 0);
        this.h = f.a(typedArray.getInt(i.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.i = b.c.a.a.o.a.a(this.f1734a.getContext(), typedArray, i.MaterialButton_backgroundTint);
        this.j = b.c.a.a.o.a.a(this.f1734a.getContext(), typedArray, i.MaterialButton_strokeColor);
        this.k = b.c.a.a.o.a.a(this.f1734a.getContext(), typedArray, i.MaterialButton_rippleColor);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(this.g);
        Paint paint = this.l;
        ColorStateList colorStateList = this.j;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(this.f1734a.getDrawableState(), 0);
        }
        paint.setColor(i);
        int n = s.n(this.f1734a);
        int paddingTop = this.f1734a.getPaddingTop();
        int m = s.m(this.f1734a);
        int paddingBottom = this.f1734a.getPaddingBottom();
        this.f1734a.setInternalBackground(w ? j() : i());
        s.a(this.f1734a, n + this.f1735b, paddingTop + this.f1737d, m + this.f1736c, paddingBottom + this.f1738e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (canvas != null && this.j != null && this.g > 0) {
            this.m.set(this.f1734a.getBackground().getBounds());
            RectF rectF = this.n;
            Rect rect = this.m;
            int i = this.g;
            rectF.set(rect.left + (i / 2.0f) + this.f1735b, rect.top + (i / 2.0f) + this.f1737d, (rect.right - (i / 2.0f)) - this.f1736c, (rect.bottom - (i / 2.0f)) - this.f1738e);
            float f = this.f - (this.g / 2.0f);
            canvas.drawRoundRect(this.n, f, f, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2;
        if (this.h != mode) {
            this.h = mode;
            if (w) {
                n();
                return;
            }
            Drawable drawable = this.p;
            if (drawable != null && (mode2 = this.h) != null) {
                a.a(drawable, mode2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        GradientDrawable gradientDrawable;
        if (this.f != i) {
            this.f = i;
            if (w && this.s != null && this.t != null && this.u != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f = i + 1.0E-5f;
                    k().setCornerRadius(f);
                    l().setCornerRadius(f);
                }
                float f2 = i + 1.0E-5f;
                this.s.setCornerRadius(f2);
                this.t.setCornerRadius(f2);
                this.u.setCornerRadius(f2);
            } else if (!w && (gradientDrawable = this.o) != null && this.q != null) {
                float f3 = i + 1.0E-5f;
                gradientDrawable.setCornerRadius(f3);
                this.q.setCornerRadius(f3);
                this.f1734a.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            Paint paint = this.l;
            int i = 0;
            if (colorStateList != null) {
                i = colorStateList.getColorForState(this.f1734a.getDrawableState(), 0);
            }
            paint.setColor(i);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        if (this.g != i) {
            this.g = i;
            this.l.setStrokeWidth(i);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            if (w) {
                n();
                return;
            }
            Drawable drawable = this.p;
            if (drawable != null) {
                a.a(drawable, this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode f() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.v = true;
        this.f1734a.setSupportBackgroundTintList(this.i);
        this.f1734a.setSupportBackgroundTintMode(this.h);
    }
}
