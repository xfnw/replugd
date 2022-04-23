package a.a.n;

import a.a.n.b;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements h.a {

    /* renamed from: d  reason: collision with root package name */
    private Context f33d;

    /* renamed from: e  reason: collision with root package name */
    private ActionBarContextView f34e;
    private b.a f;
    private WeakReference<View> g;
    private boolean h;
    private h i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f33d = context;
        this.f34e = actionBarContextView;
        this.f = aVar;
        h hVar = new h(actionBarContextView.getContext());
        hVar.c(1);
        this.i = hVar;
        this.i.a(this);
    }

    @Override // a.a.n.b
    public void a() {
        if (!this.h) {
            this.h = true;
            this.f34e.sendAccessibilityEvent(32);
            this.f.a(this);
        }
    }

    @Override // a.a.n.b
    public void a(int i) {
        a((CharSequence) this.f33d.getString(i));
    }

    @Override // a.a.n.b
    public void a(View view) {
        this.f34e.setCustomView(view);
        this.g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void a(h hVar) {
        i();
        this.f34e.d();
    }

    @Override // a.a.n.b
    public void a(CharSequence charSequence) {
        this.f34e.setSubtitle(charSequence);
    }

    @Override // a.a.n.b
    public void a(boolean z) {
        super.a(z);
        this.f34e.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean a(h hVar, MenuItem menuItem) {
        return this.f.a(this, menuItem);
    }

    @Override // a.a.n.b
    public View b() {
        WeakReference<View> weakReference = this.g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.a.n.b
    public void b(int i) {
        b(this.f33d.getString(i));
    }

    @Override // a.a.n.b
    public void b(CharSequence charSequence) {
        this.f34e.setTitle(charSequence);
    }

    @Override // a.a.n.b
    public Menu c() {
        return this.i;
    }

    @Override // a.a.n.b
    public MenuInflater d() {
        return new g(this.f34e.getContext());
    }

    @Override // a.a.n.b
    public CharSequence e() {
        return this.f34e.getSubtitle();
    }

    @Override // a.a.n.b
    public CharSequence g() {
        return this.f34e.getTitle();
    }

    @Override // a.a.n.b
    public void i() {
        this.f.a(this, this.i);
    }

    @Override // a.a.n.b
    public boolean j() {
        return this.f34e.b();
    }
}
