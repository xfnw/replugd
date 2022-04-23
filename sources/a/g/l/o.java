package a.g.l;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private int f318a;

    public o(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f318a;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        this.f318a = 0;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.f318a = i;
    }
}
