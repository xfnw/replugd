package a.p;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class v implements w {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ViewGroup viewGroup) {
        this.f609a = viewGroup.getOverlay();
    }

    @Override // a.p.c0
    public void a(Drawable drawable) {
        this.f609a.add(drawable);
    }

    @Override // a.p.w
    public void a(View view) {
        this.f609a.add(view);
    }

    @Override // a.p.c0
    public void b(Drawable drawable) {
        this.f609a.remove(drawable);
    }

    @Override // a.p.w
    public void b(View view) {
        this.f609a.remove(view);
    }
}
