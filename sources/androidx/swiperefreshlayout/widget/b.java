package androidx.swiperefreshlayout.widget;

import a.g.k.h;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {
    private static final Interpolator h = new LinearInterpolator();
    private static final Interpolator i = new a.l.a.a.b();
    private static final int[] j = {-16777216};

    /* renamed from: b  reason: collision with root package name */
    private final c f1552b = new c();

    /* renamed from: c  reason: collision with root package name */
    private float f1553c;

    /* renamed from: d  reason: collision with root package name */
    private Resources f1554d;

    /* renamed from: e  reason: collision with root package name */
    private Animator f1555e;
    float f;
    boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f1556b;

        a(c cVar) {
            this.f1556b = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.a(floatValue, this.f1556b);
            b.this.a(floatValue, this.f1556b, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.swiperefreshlayout.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049b implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f1558b;

        C0049b(c cVar) {
            this.f1558b = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.a(1.0f, this.f1558b, true);
            this.f1558b.l();
            this.f1558b.j();
            b bVar = b.this;
            if (bVar.g) {
                bVar.g = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.f1558b.a(false);
                return;
            }
            bVar.f += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;

        /* renamed from: a  reason: collision with root package name */
        final RectF f1560a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f1561b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        final Paint f1562c = new Paint();

        /* renamed from: d  reason: collision with root package name */
        final Paint f1563d = new Paint();

        /* renamed from: e  reason: collision with root package name */
        float f1564e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 5.0f;
        float p = 1.0f;
        int t = 255;

        c() {
            this.f1561b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1561b.setAntiAlias(true);
            this.f1561b.setStyle(Paint.Style.STROKE);
            this.f1562c.setStyle(Paint.Style.FILL);
            this.f1562c.setAntiAlias(true);
            this.f1563d.setColor(0);
        }

        int a() {
            return this.t;
        }

        void a(float f) {
            if (f != this.p) {
                this.p = f;
            }
        }

        void a(float f, float f2) {
            this.r = (int) f;
            this.s = (int) f2;
        }

        void a(int i) {
            this.t = i;
        }

        void a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path2 = this.o;
                float f3 = this.p;
                path2.lineTo((this.r * f3) / 2.0f, this.s * f3);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.r * this.p) / 2.0f), rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.f1562c.setColor(this.u);
                this.f1562c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f1562c);
                canvas.restore();
            }
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1560a;
            float f = this.q;
            float f2 = (this.h / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
            float f3 = this.f1564e;
            float f4 = this.g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f + f4) * 360.0f) - f5;
            this.f1561b.setColor(this.u);
            this.f1561b.setAlpha(this.t);
            float f7 = this.h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f1563d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f1561b);
            a(canvas, f5, f6, rectF);
        }

        void a(ColorFilter colorFilter) {
            this.f1561b.setColorFilter(colorFilter);
        }

        void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void a(int[] iArr) {
            this.i = iArr;
            c(0);
        }

        float b() {
            return this.f;
        }

        void b(float f) {
            this.q = f;
        }

        void b(int i) {
            this.u = i;
        }

        int c() {
            return this.i[d()];
        }

        void c(float f) {
            this.f = f;
        }

        void c(int i) {
            this.j = i;
            this.u = this.i[this.j];
        }

        int d() {
            return (this.j + 1) % this.i.length;
        }

        void d(float f) {
            this.g = f;
        }

        float e() {
            return this.f1564e;
        }

        void e(float f) {
            this.f1564e = f;
        }

        int f() {
            return this.i[this.j];
        }

        void f(float f) {
            this.h = f;
            this.f1561b.setStrokeWidth(f);
        }

        float g() {
            return this.l;
        }

        float h() {
            return this.m;
        }

        float i() {
            return this.k;
        }

        void j() {
            c(d());
        }

        void k() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        void l() {
            this.k = this.f1564e;
            this.l = this.f;
            this.m = this.g;
        }
    }

    public b(Context context) {
        h.a(context);
        this.f1554d = context.getResources();
        this.f1552b.a(j);
        c(2.5f);
        a();
    }

    private int a(float f, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f))) << 8) | (i7 + ((int) (f * ((i3 & 255) - i7))));
    }

    private void a() {
        c cVar = this.f1552b;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(h);
        ofFloat.addListener(new C0049b(cVar));
        this.f1555e = ofFloat;
    }

    private void a(float f, float f2, float f3, float f4) {
        c cVar = this.f1552b;
        float f5 = this.f1554d.getDisplayMetrics().density;
        cVar.f(f2 * f5);
        cVar.b(f * f5);
        cVar.c(0);
        cVar.a(f3 * f5, f4 * f5);
    }

    private void b(float f, c cVar) {
        a(f, cVar);
        cVar.e(cVar.i() + (((cVar.g() - 0.01f) - cVar.i()) * f));
        cVar.c(cVar.g());
        cVar.d(cVar.h() + ((((float) (Math.floor(cVar.h() / 0.8f) + 1.0d)) - cVar.h()) * f));
    }

    private void d(float f) {
        this.f1553c = f;
    }

    public void a(float f) {
        this.f1552b.a(f);
        invalidateSelf();
    }

    public void a(float f, float f2) {
        this.f1552b.e(f);
        this.f1552b.c(f2);
        invalidateSelf();
    }

    void a(float f, c cVar) {
        cVar.b(f > 0.75f ? a((f - 0.75f) / 0.25f, cVar.f(), cVar.c()) : cVar.f());
    }

    void a(float f, c cVar, boolean z) {
        float f2;
        float f3;
        if (this.g) {
            b(f, cVar);
        } else if (f != 1.0f || z) {
            float h2 = cVar.h();
            if (f < 0.5f) {
                float i2 = cVar.i();
                f2 = (i.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + i2;
                f3 = i2;
            } else {
                f2 = cVar.i() + 0.79f;
                f3 = f2 - (((1.0f - i.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            cVar.e(f3);
            cVar.c(f2);
            cVar.d(h2 + (0.20999998f * f));
            d((f + this.f) * 216.0f);
        }
    }

    public void a(int i2) {
        float f;
        float f2;
        float f3;
        float f4;
        if (i2 == 0) {
            f = 11.0f;
            f4 = 3.0f;
            f3 = 12.0f;
            f2 = 6.0f;
        } else {
            f = 7.5f;
            f4 = 2.5f;
            f3 = 10.0f;
            f2 = 5.0f;
        }
        a(f, f4, f3, f2);
        invalidateSelf();
    }

    public void a(boolean z) {
        this.f1552b.a(z);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f1552b.a(iArr);
        this.f1552b.c(0);
        invalidateSelf();
    }

    public void b(float f) {
        this.f1552b.d(f);
        invalidateSelf();
    }

    public void c(float f) {
        this.f1552b.f(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1553c, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1552b.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1552b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1555e.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1552b.a(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1552b.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        long j2;
        Animator animator;
        this.f1555e.cancel();
        this.f1552b.l();
        if (this.f1552b.b() != this.f1552b.e()) {
            this.g = true;
            animator = this.f1555e;
            j2 = 666;
        } else {
            this.f1552b.c(0);
            this.f1552b.k();
            animator = this.f1555e;
            j2 = 1332;
        }
        animator.setDuration(j2);
        this.f1555e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1555e.cancel();
        d(0.0f);
        this.f1552b.a(false);
        this.f1552b.c(0);
        this.f1552b.k();
        invalidateSelf();
    }
}
