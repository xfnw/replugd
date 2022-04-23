package b.c.a.a.l;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import b.c.a.a.l.d;

/* loaded from: classes.dex */
public class b extends FrameLayout implements d {

    /* renamed from: b  reason: collision with root package name */
    private final c f1740b;

    @Override // b.c.a.a.l.d
    public void a() {
        this.f1740b.a();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void b() {
        this.f1740b.b();
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f1740b;
        if (cVar == null) {
            super.draw(canvas);
        } else {
            cVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f1740b.c();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public int getCircularRevealScrimColor() {
        this.f1740b.d();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public d.e getRevealInfo() {
        this.f1740b.e();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f1740b;
        if (cVar == null) {
            return super.isOpaque();
        }
        cVar.f();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f1740b.a(drawable);
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void setCircularRevealScrimColor(int i) {
        this.f1740b.a(i);
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void setRevealInfo(d.e eVar) {
        this.f1740b.a(eVar);
        throw null;
    }
}
