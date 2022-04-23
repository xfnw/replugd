package androidx.cardview.widget;

import a.c.b;
import a.c.c;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class g extends Drawable {
    private static final double q = Math.cos(Math.toRadians(45.0d));
    static a r;

    /* renamed from: a  reason: collision with root package name */
    private final int f1104a;
    private float f;
    private Path g;
    private float h;
    private float i;
    private float j;
    private ColorStateList k;
    private final int m;
    private final int n;
    private boolean l = true;
    private boolean o = true;
    private boolean p = false;

    /* renamed from: b  reason: collision with root package name */
    private Paint f1105b = new Paint(5);

    /* renamed from: c  reason: collision with root package name */
    private Paint f1106c = new Paint(5);

    /* renamed from: e  reason: collision with root package name */
    private final RectF f1108e = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private Paint f1107d = new Paint(this.f1106c);

    /* loaded from: classes.dex */
    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.m = resources.getColor(b.cardview_shadow_start_color);
        this.n = resources.getColor(b.cardview_shadow_end_color);
        this.f1104a = resources.getDimensionPixelSize(c.cardview_compat_inset_shadow);
        b(colorStateList);
        this.f1106c.setStyle(Paint.Style.FILL);
        this.f = (int) (f + 0.5f);
        this.f1107d.setAntiAlias(false);
        a(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d2 = f;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - q) * d3));
    }

    private void a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float d2 = d(f);
            float d3 = d(f2);
            if (d2 > d3) {
                if (!this.p) {
                    this.p = true;
                }
                d2 = d3;
            }
            if (this.j != d2 || this.h != d3) {
                this.j = d2;
                this.h = d3;
                this.i = (int) ((d2 * 1.5f) + this.f1104a + 0.5f);
                this.l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    private void a(Canvas canvas) {
        float f = this.f;
        float f2 = (-f) - this.i;
        float f3 = f + this.f1104a + (this.j / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f1108e.width() - f4 > 0.0f;
        boolean z2 = this.f1108e.height() - f4 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1108e;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.g, this.f1106c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f1108e.width() - f4, -this.f, this.f1107d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1108e;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.g, this.f1106c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f1108e.width() - f4, (-this.f) + this.i, this.f1107d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1108e;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.g, this.f1106c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f1108e.height() - f4, -this.f, this.f1107d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1108e;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.g, this.f1106c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f1108e.height() - f4, -this.f, this.f1107d);
        }
        canvas.restoreToCount(save4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        if (!z) {
            return f3;
        }
        double d2 = f3;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - q) * d3));
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.k = colorStateList;
        this.f1105b.setColor(this.k.getColorForState(getState(), this.k.getDefaultColor()));
    }

    private void b(Rect rect) {
        float f = this.h;
        float f2 = 1.5f * f;
        this.f1108e.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        g();
    }

    private int d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void g() {
        float f = this.f;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.i;
        rectF2.inset(-f2, -f2);
        Path path = this.g;
        if (path == null) {
            this.g = new Path();
        } else {
            path.reset();
        }
        this.g.setFillType(Path.FillType.EVEN_ODD);
        this.g.moveTo(-this.f, 0.0f);
        this.g.rLineTo(-this.i, 0.0f);
        this.g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.g.arcTo(rectF, 270.0f, -90.0f, false);
        this.g.close();
        float f3 = this.f;
        float f4 = this.i;
        Paint paint = this.f1106c;
        float f5 = f3 + f4;
        int i = this.m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.n}, new float[]{0.0f, f3 / (f3 + f4), 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1107d;
        float f6 = this.f;
        float f7 = this.i;
        int i2 = this.m;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1107d.setAntiAlias(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        if (f >= 0.0f) {
            float f2 = (int) (f + 0.5f);
            if (this.f != f2) {
                this.f = f2;
                this.l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        a(this.j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        a(f, this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        float f = this.h;
        return (Math.max(f, this.f + this.f1104a + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.h * 1.5f) + this.f1104a) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            b(getBounds());
            this.l = false;
        }
        canvas.translate(0.0f, this.j / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.j) / 2.0f);
        r.a(canvas, this.f1108e, this.f, this.f1105b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        float f = this.h;
        return (Math.max(f, this.f + this.f1104a + (f / 2.0f)) * 2.0f) + ((this.h + this.f1104a) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.h, this.f, this.o));
        int ceil2 = (int) Math.ceil(a(this.h, this.f, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1105b.getColor() == colorForState) {
            return false;
        }
        this.f1105b.setColor(colorForState);
        this.l = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1105b.setAlpha(i);
        this.f1106c.setAlpha(i);
        this.f1107d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1105b.setColorFilter(colorFilter);
    }
}
