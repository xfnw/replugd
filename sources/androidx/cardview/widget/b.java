package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: classes.dex */
class b implements e {
    private f j(d dVar) {
        return (f) dVar.c();
    }

    @Override // androidx.cardview.widget.e
    public float a(d dVar) {
        return j(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void a() {
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, float f) {
        dVar.a().setElevation(f);
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        dVar.a(new f(colorStateList, f));
        View a2 = dVar.a();
        a2.setClipToOutline(true);
        a2.setElevation(f2);
        c(dVar, f3);
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, ColorStateList colorStateList) {
        j(dVar).a(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public float b(d dVar) {
        return j(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f) {
        j(dVar).a(f);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return b(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void c(d dVar, float f) {
        j(dVar).a(f, dVar.b(), dVar.d());
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return b(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
        c(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList f(d dVar) {
        return j(dVar).a();
    }

    @Override // androidx.cardview.widget.e
    public void g(d dVar) {
        c(dVar, a(dVar));
    }

    @Override // androidx.cardview.widget.e
    public float h(d dVar) {
        return dVar.a().getElevation();
    }

    public void i(d dVar) {
        if (!dVar.b()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float a2 = a(dVar);
        float b2 = b(dVar);
        int ceil = (int) Math.ceil(g.a(a2, b2, dVar.d()));
        int ceil2 = (int) Math.ceil(g.b(a2, b2, dVar.d()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }
}
