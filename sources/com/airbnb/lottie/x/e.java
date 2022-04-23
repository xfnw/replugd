package com.airbnb.lottie.x;

import android.view.Choreographer;
import com.airbnb.lottie.d;

/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {
    private d k;

    /* renamed from: d  reason: collision with root package name */
    private float f2494d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2495e = false;
    private long f = 0;
    private float g = 0.0f;
    private int h = 0;
    private float i = -2.14748365E9f;
    private float j = 2.14748365E9f;
    protected boolean l = false;

    private float r() {
        d dVar = this.k;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.g()) / Math.abs(this.f2494d);
    }

    private boolean s() {
        return j() < 0.0f;
    }

    private void t() {
        if (this.k != null) {
            float f = this.g;
            if (f < this.i || f > this.j) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.i), Float.valueOf(this.j), Float.valueOf(this.g)));
            }
        }
    }

    public void a(float f) {
        if (this.g != f) {
            this.g = g.a(f, i(), h());
            this.f = 0L;
            c();
        }
    }

    public void a(float f, float f2) {
        if (f <= f2) {
            d dVar = this.k;
            float l = dVar == null ? -3.4028235E38f : dVar.l();
            d dVar2 = this.k;
            float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
            this.i = g.a(f, l, e2);
            this.j = g.a(f2, l, e2);
            a((int) g.a(this.g, f, f2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void a(int i) {
        a(i, (int) this.j);
    }

    public void a(d dVar) {
        float f;
        float f2;
        boolean z = this.k == null;
        this.k = dVar;
        if (z) {
            f2 = (int) Math.max(this.i, dVar.l());
            f = Math.min(this.j, dVar.e());
        } else {
            f2 = (int) dVar.l();
            f = dVar.e();
        }
        a(f2, (int) f);
        float f3 = this.g;
        this.g = 0.0f;
        a((int) f3);
    }

    public void b(float f) {
        a(this.i, f);
    }

    public void c(float f) {
        this.f2494d = f;
    }

    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.l = false;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        o();
    }

    public void d() {
        this.k = null;
        this.i = -2.14748365E9f;
        this.j = 2.14748365E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        n();
        if (this.k != null && isRunning()) {
            long j2 = this.f;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float r = ((float) j3) / r();
            float f = this.g;
            if (s()) {
                r = -r;
            }
            this.g = f + r;
            boolean z = !g.b(this.g, i(), h());
            this.g = g.a(this.g, i(), h());
            this.f = j;
            c();
            if (z) {
                if (getRepeatCount() == -1 || this.h < getRepeatCount()) {
                    b();
                    this.h++;
                    if (getRepeatMode() == 2) {
                        this.f2495e = !this.f2495e;
                        q();
                    } else {
                        this.g = s() ? h() : i();
                    }
                    this.f = j;
                } else {
                    this.g = this.f2494d < 0.0f ? i() : h();
                    o();
                    a(s());
                }
            }
            t();
        }
    }

    public void e() {
        o();
        a(s());
    }

    public float f() {
        d dVar = this.k;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.g - dVar.l()) / (this.k.e() - this.k.l());
    }

    public float g() {
        return this.g;
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float f;
        float i;
        if (this.k == null) {
            return 0.0f;
        }
        if (s()) {
            f = h();
            i = this.g;
        } else {
            f = this.g;
            i = i();
        }
        return (f - i) / (h() - i());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(f());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        d dVar = this.k;
        if (dVar == null) {
            return 0L;
        }
        return dVar.c();
    }

    public float h() {
        d dVar = this.k;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.j;
        return f == 2.14748365E9f ? dVar.e() : f;
    }

    public float i() {
        d dVar = this.k;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.i;
        return f == -2.14748365E9f ? dVar.l() : f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.l;
    }

    public float j() {
        return this.f2494d;
    }

    public void k() {
        o();
    }

    public void l() {
        this.l = true;
        b(s());
        a((int) (s() ? h() : i()));
        this.f = 0L;
        this.h = 0;
        n();
    }

    protected void n() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void o() {
        c(true);
    }

    public void p() {
        float i;
        this.l = true;
        n();
        this.f = 0L;
        if (s() && g() == i()) {
            i = h();
        } else if (!s() && g() == h()) {
            i = i();
        } else {
            return;
        }
        this.g = i;
    }

    public void q() {
        c(-j());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f2495e) {
            this.f2495e = false;
            q();
        }
    }
}
