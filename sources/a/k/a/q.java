package a.k.a;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
class q implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final View f491b;

    /* renamed from: c  reason: collision with root package name */
    private ViewTreeObserver f492c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f493d;

    private q(View view, Runnable runnable) {
        this.f491b = view;
        this.f492c = view.getViewTreeObserver();
        this.f493d = runnable;
    }

    public static q a(View view, Runnable runnable) {
        q qVar = new q(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(qVar);
        view.addOnAttachStateChangeListener(qVar);
        return qVar;
    }

    public void a() {
        (this.f492c.isAlive() ? this.f492c : this.f491b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f491b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.f493d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f492c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
