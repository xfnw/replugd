package androidx.appcompat.widget;

import a.a.j;
import a.g.l.s;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;

/* loaded from: classes.dex */
class u extends q {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1050d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1051e;
    private ColorStateList f = null;
    private PorterDuff.Mode g = null;
    private boolean h = false;
    private boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SeekBar seekBar) {
        super(seekBar);
        this.f1050d = seekBar;
    }

    private void d() {
        if (this.f1051e == null) {
            return;
        }
        if (this.h || this.i) {
            this.f1051e = a.i(this.f1051e.mutate());
            if (this.h) {
                a.a(this.f1051e, this.f);
            }
            if (this.i) {
                a.a(this.f1051e, this.g);
            }
            if (this.f1051e.isStateful()) {
                this.f1051e.setState(this.f1050d.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.f1051e != null) {
            int max = this.f1050d.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1051e.getIntrinsicWidth();
                int intrinsicHeight = this.f1051e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f1051e.setBounds(-i2, -i, i2, i);
                float width = ((this.f1050d.getWidth() - this.f1050d.getPaddingLeft()) - this.f1050d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1050d.getPaddingLeft(), this.f1050d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1051e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.f1051e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1051e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1050d);
            a.a(drawable, s.j(this.f1050d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1050d.getDrawableState());
            }
            d();
        }
        this.f1050d.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.q
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        s0 a2 = s0.a(this.f1050d.getContext(), attributeSet, j.AppCompatSeekBar, i, 0);
        Drawable c2 = a2.c(j.AppCompatSeekBar_android_thumb);
        if (c2 != null) {
            this.f1050d.setThumb(c2);
        }
        a(a2.b(j.AppCompatSeekBar_tickMark));
        if (a2.g(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = b0.a(a2.d(j.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (a2.g(j.AppCompatSeekBar_tickMarkTint)) {
            this.f = a2.a(j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        a2.a();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1051e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1050d.getDrawableState())) {
            this.f1050d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1051e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }
}
