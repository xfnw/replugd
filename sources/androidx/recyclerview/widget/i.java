package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class i {

    /* renamed from: b  reason: collision with root package name */
    int f1509b;

    /* renamed from: c  reason: collision with root package name */
    int f1510c;

    /* renamed from: d  reason: collision with root package name */
    int f1511d;

    /* renamed from: e  reason: collision with root package name */
    int f1512e;
    boolean h;
    boolean i;

    /* renamed from: a  reason: collision with root package name */
    boolean f1508a = true;
    int f = 0;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.v vVar) {
        View d2 = vVar.d(this.f1510c);
        this.f1510c += this.f1511d;
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.a0 a0Var) {
        int i = this.f1510c;
        return i >= 0 && i < a0Var.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1509b + ", mCurrentPosition=" + this.f1510c + ", mItemDirection=" + this.f1511d + ", mLayoutDirection=" + this.f1512e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
