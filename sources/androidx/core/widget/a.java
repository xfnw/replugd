package androidx.core.widget;

import a.g.l.s;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int s = ViewConfiguration.getTapTimeout();

    /* renamed from: d  reason: collision with root package name */
    final View f1234d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1235e;
    private int h;
    private int i;
    private boolean m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;
    private boolean r;

    /* renamed from: b  reason: collision with root package name */
    final C0040a f1232b = new C0040a();

    /* renamed from: c  reason: collision with root package name */
    private final Interpolator f1233c = new AccelerateInterpolator();
    private float[] f = {0.0f, 0.0f};
    private float[] g = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] j = {0.0f, 0.0f};
    private float[] k = {0.0f, 0.0f};
    private float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040a {

        /* renamed from: a  reason: collision with root package name */
        private int f1236a;

        /* renamed from: b  reason: collision with root package name */
        private int f1237b;

        /* renamed from: c  reason: collision with root package name */
        private float f1238c;

        /* renamed from: d  reason: collision with root package name */
        private float f1239d;
        private float j;
        private int k;

        /* renamed from: e  reason: collision with root package name */
        private long f1240e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        C0040a() {
        }

        private float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        private float a(long j) {
            if (j < this.f1240e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return a.a(((float) (j - this.f1240e)) / this.f1236a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.j;
            return (1.0f - f) + (f * a.a(((float) j3) / this.k, 0.0f, 1.0f));
        }

        public void a() {
            if (this.f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                this.f = currentAnimationTimeMillis;
                float f = ((float) (currentAnimationTimeMillis - this.f)) * a2;
                this.g = (int) (this.f1238c * f);
                this.h = (int) (f * this.f1239d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f, float f2) {
            this.f1238c = f;
            this.f1239d = f2;
        }

        public void a(int i) {
            this.f1237b = i;
        }

        public int b() {
            return this.g;
        }

        public void b(int i) {
            this.f1236a = i;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f = this.f1238c;
            return (int) (f / Math.abs(f));
        }

        public int e() {
            float f = this.f1239d;
            return (int) (f / Math.abs(f));
        }

        public boolean f() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.f1240e), 0, this.f1237b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void h() {
            this.f1240e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.f1240e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    aVar.f1232b.h();
                }
                C0040a aVar2 = a.this.f1232b;
                if (aVar2.f() || !a.this.f()) {
                    a.this.p = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.o) {
                    aVar3.o = false;
                    aVar3.e();
                }
                aVar2.a();
                a.this.a(aVar2.b(), aVar2.c());
                s.a(a.this.f1234d, this);
            }
        }
    }

    public a(View view) {
        this.f1234d = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        b(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        c(f3, f3);
        d(1);
        a(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        e(1.0f, 1.0f);
        c(s);
        f(500);
        e(500);
    }

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private float a(float f, float f2, float f3, float f4) {
        float f5;
        float a2 = a(f * f2, 0.0f, f3);
        float f6 = f(f2 - f4, a2) - f(f4, a2);
        if (f6 < 0.0f) {
            f5 = -this.f1233c.getInterpolation(-f6);
        } else if (f6 <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1233c.getInterpolation(f6);
        }
        return a(f5, -1.0f, 1.0f);
    }

    private float a(int i, float f, float f2, float f3) {
        float a2 = a(this.f[i], f2, this.g[i], f);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f4 = this.j[i];
        float f5 = this.k[i];
        float f6 = this.l[i];
        float f7 = f4 * f3;
        return a2 > 0.0f ? a(a2 * f7, f5, f6) : -a((-a2) * f7, f5, f6);
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.h;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.p && this.h == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    private void g() {
        if (this.n) {
            this.p = false;
        } else {
            this.f1232b.g();
        }
    }

    private void h() {
        int i;
        if (this.f1235e == null) {
            this.f1235e = new b();
        }
        this.p = true;
        this.n = true;
        if (this.m || (i = this.i) <= 0) {
            this.f1235e.run();
        } else {
            s.a(this.f1234d, this.f1235e, i);
        }
        this.m = true;
    }

    public a a(float f, float f2) {
        float[] fArr = this.g;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a a(boolean z) {
        if (this.q && !z) {
            g();
        }
        this.q = z;
        return this;
    }

    public abstract void a(int i, int i2);

    public abstract boolean a(int i);

    public a b(float f, float f2) {
        float[] fArr = this.l;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public abstract boolean b(int i);

    public a c(float f, float f2) {
        float[] fArr = this.k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a c(int i) {
        this.i = i;
        return this;
    }

    public a d(float f, float f2) {
        float[] fArr = this.f;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public a d(int i) {
        this.h = i;
        return this;
    }

    public a e(float f, float f2) {
        float[] fArr = this.j;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a e(int i) {
        this.f1232b.a(i);
        return this;
    }

    void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1234d.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a f(int i) {
        this.f1232b.b(i);
        return this;
    }

    boolean f() {
        C0040a aVar = this.f1232b;
        int e2 = aVar.e();
        int d2 = aVar.d();
        return (e2 != 0 && b(e2)) || (d2 != 0 && a(d2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.q
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.g()
            goto L_0x0058
        L_0x001a:
            r5.o = r2
            r5.m = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1234d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1234d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f1232b
            r7.a(r0, r6)
            boolean r6 = r5.p
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.f()
            if (r6 == 0) goto L_0x0058
            r5.h()
        L_0x0058:
            boolean r6 = r5.r
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.p
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
