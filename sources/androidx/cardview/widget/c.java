package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.g;

/* loaded from: classes.dex */
class c implements e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f1097a = new RectF();

    /* loaded from: classes.dex */
    class a implements g.a {
        a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                c.this.f1097a.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(c.this.f1097a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f1097a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f1097a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f1097a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f5 = rectF.top;
                canvas.drawRect((rectF.left + f3) - 1.0f, f5, (rectF.right - f3) + 1.0f, f5 + f3, paint);
                float f6 = rectF.bottom;
                canvas.drawRect((rectF.left + f3) - 1.0f, f6 - f3, (rectF.right - f3) + 1.0f, f6, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    private g a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new g(context.getResources(), colorStateList, f, f2, f3);
    }

    private g j(d dVar) {
        return (g) dVar.c();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return j(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public void a() {
        g.r = new a();
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, float f) {
        j(dVar).c(f);
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        g a2 = a(context, colorStateList, f, f2, f3);
        a2.a(dVar.d());
        dVar.a(a2);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, ColorStateList colorStateList) {
        j(dVar).a(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public float b(d dVar) {
        return j(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f) {
        j(dVar).a(f);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return j(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public void c(d dVar, float f) {
        j(dVar).b(f);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return j(dVar).e();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList f(d dVar) {
        return j(dVar).a();
    }

    @Override // androidx.cardview.widget.e
    public void g(d dVar) {
        j(dVar).a(dVar.d());
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float h(d dVar) {
        return j(dVar).f();
    }

    public void i(d dVar) {
        Rect rect = new Rect();
        j(dVar).a(rect);
        dVar.a((int) Math.ceil(d(dVar)), (int) Math.ceil(c(dVar)));
        dVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
