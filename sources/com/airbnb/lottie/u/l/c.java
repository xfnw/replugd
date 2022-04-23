package com.airbnb.lottie.u.l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.a;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.x.h;

/* loaded from: classes.dex */
public class c extends a {
    private final Paint w = new a(3);
    private final Rect x = new Rect();
    private final Rect y = new Rect();
    private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar, d dVar) {
        super(fVar, dVar);
    }

    private Bitmap f() {
        return this.n.a(this.o.k());
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        Bitmap f = f();
        if (f != null) {
            rectF.set(0.0f, 0.0f, f.getWidth() * h.a(), f.getHeight() * h.a());
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        super.a((c) t, (com.airbnb.lottie.y.c<c>) cVar);
        if (t == k.B) {
            this.z = cVar == null ? null : new p(cVar);
        }
    }

    @Override // com.airbnb.lottie.u.l.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f = f();
        if (f != null && !f.isRecycled()) {
            float a2 = h.a();
            this.w.setAlpha(i);
            com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> aVar = this.z;
            if (aVar != null) {
                this.w.setColorFilter(aVar.f());
            }
            canvas.save();
            canvas.concat(matrix);
            this.x.set(0, 0, f.getWidth(), f.getHeight());
            this.y.set(0, 0, (int) (f.getWidth() * a2), (int) (f.getHeight() * a2));
            canvas.drawBitmap(f, this.x, this.y, this.w);
            canvas.restore();
        }
    }
}
