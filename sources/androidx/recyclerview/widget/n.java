package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.l {
    boolean g = true;

    public final void a(RecyclerView.d0 d0Var, boolean z) {
        c(d0Var, z);
        b(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var) {
        return !this.g || d0Var.n();
    }

    public abstract boolean a(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f1360a;
        int i4 = cVar.f1361b;
        if (d0Var2.x()) {
            i2 = cVar.f1360a;
            i = cVar.f1361b;
        } else {
            i2 = cVar2.f1360a;
            i = cVar2.f1361b;
        }
        return a(d0Var, d0Var2, i3, i4, i2, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        return (cVar == null || (cVar.f1360a == cVar2.f1360a && cVar.f1361b == cVar2.f1361b)) ? f(d0Var) : a(d0Var, cVar.f1360a, cVar.f1361b, cVar2.f1360a, cVar2.f1361b);
    }

    public final void b(RecyclerView.d0 d0Var, boolean z) {
        d(d0Var, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i = cVar.f1360a;
        int i2 = cVar.f1361b;
        View view = d0Var.f1346a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1360a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1361b;
        if (d0Var.p() || (i == left && i2 == top)) {
            return g(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(d0Var, i, i2, left, top);
    }

    public void c(RecyclerView.d0 d0Var, boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        if (cVar.f1360a != cVar2.f1360a || cVar.f1361b != cVar2.f1361b) {
            return a(d0Var, cVar.f1360a, cVar.f1361b, cVar2.f1360a, cVar2.f1361b);
        }
        j(d0Var);
        return false;
    }

    public void d(RecyclerView.d0 d0Var, boolean z) {
    }

    public abstract boolean f(RecyclerView.d0 d0Var);

    public abstract boolean g(RecyclerView.d0 d0Var);

    public final void h(RecyclerView.d0 d0Var) {
        n(d0Var);
        b(d0Var);
    }

    public final void i(RecyclerView.d0 d0Var) {
        o(d0Var);
    }

    public final void j(RecyclerView.d0 d0Var) {
        p(d0Var);
        b(d0Var);
    }

    public final void k(RecyclerView.d0 d0Var) {
        q(d0Var);
    }

    public final void l(RecyclerView.d0 d0Var) {
        r(d0Var);
        b(d0Var);
    }

    public final void m(RecyclerView.d0 d0Var) {
        s(d0Var);
    }

    public void n(RecyclerView.d0 d0Var) {
    }

    public void o(RecyclerView.d0 d0Var) {
    }

    public void p(RecyclerView.d0 d0Var) {
    }

    public void q(RecyclerView.d0 d0Var) {
    }

    public void r(RecyclerView.d0 d0Var) {
    }

    public void s(RecyclerView.d0 d0Var) {
    }
}
