package b.c.a.a.l.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;
import b.c.a.a.l.c;
import b.c.a.a.l.d;

/* loaded from: classes.dex */
public class a extends CardView implements d {
    private final c k;

    @Override // b.c.a.a.l.d
    public void a() {
        this.k.a();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void b() {
        this.k.b();
        throw null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.k;
        if (cVar == null) {
            super.draw(canvas);
        } else {
            cVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.k.c();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public int getCircularRevealScrimColor() {
        this.k.d();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public d.e getRevealInfo() {
        this.k.e();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.k;
        if (cVar == null) {
            return super.isOpaque();
        }
        cVar.f();
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.k.a(drawable);
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void setCircularRevealScrimColor(int i) {
        this.k.a(i);
        throw null;
    }

    @Override // b.c.a.a.l.d
    public void setRevealInfo(d.e eVar) {
        this.k.a(eVar);
        throw null;
    }
}
