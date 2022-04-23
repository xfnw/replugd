package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.a0 a0Var, k kVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.e() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.l(view) - oVar.l(view2)) + 1;
        }
        return Math.min(kVar.g(), kVar.a(view2) - kVar.d(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.a0 a0Var, k kVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.e() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (a0Var.a() - Math.max(oVar.l(view), oVar.l(view2))) - 1) : Math.max(0, Math.min(oVar.l(view), oVar.l(view2)));
        if (!z) {
            return max;
        }
        return Math.round((max * (Math.abs(kVar.a(view2) - kVar.d(view)) / (Math.abs(oVar.l(view) - oVar.l(view2)) + 1))) + (kVar.f() - kVar.d(view)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.a0 a0Var, k kVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.e() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.a();
        }
        return (int) (((kVar.a(view2) - kVar.d(view)) / (Math.abs(oVar.l(view) - oVar.l(view2)) + 1)) * a0Var.a());
    }
}
