package a.p;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f576a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f577b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l a(View view) {
        return (l) view.getTag(j.transition_current_scene);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, l lVar) {
        view.setTag(j.transition_current_scene, lVar);
    }

    public void a() {
        Runnable runnable;
        if (a(this.f576a) == this && (runnable = this.f577b) != null) {
            runnable.run();
        }
    }
}
