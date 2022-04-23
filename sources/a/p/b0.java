package a.p;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class b0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(View view) {
        this.f521a = view.getOverlay();
    }

    @Override // a.p.c0
    public void a(Drawable drawable) {
        this.f521a.add(drawable);
    }

    @Override // a.p.c0
    public void b(Drawable drawable) {
        this.f521a.remove(drawable);
    }
}
