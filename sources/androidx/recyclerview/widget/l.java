package androidx.recyclerview.widget;

import a.g.l.b0.c;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class l extends a.g.l.a {

    /* renamed from: c  reason: collision with root package name */
    final RecyclerView f1517c;

    /* renamed from: d  reason: collision with root package name */
    final a.g.l.a f1518d = new a(this);

    /* loaded from: classes.dex */
    public static class a extends a.g.l.a {

        /* renamed from: c  reason: collision with root package name */
        final l f1519c;

        public a(l lVar) {
            this.f1519c = lVar;
        }

        @Override // a.g.l.a
        public void a(View view, c cVar) {
            super.a(view, cVar);
            if (!this.f1519c.c() && this.f1519c.f1517c.getLayoutManager() != null) {
                this.f1519c.f1517c.getLayoutManager().a(view, cVar);
            }
        }

        @Override // a.g.l.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.f1519c.c() || this.f1519c.f1517c.getLayoutManager() == null) {
                return false;
            }
            return this.f1519c.f1517c.getLayoutManager().a(view, i, bundle);
        }
    }

    public l(RecyclerView recyclerView) {
        this.f1517c = recyclerView;
    }

    @Override // a.g.l.a
    public void a(View view, c cVar) {
        super.a(view, cVar);
        cVar.a((CharSequence) RecyclerView.class.getName());
        if (!c() && this.f1517c.getLayoutManager() != null) {
            this.f1517c.getLayoutManager().a(cVar);
        }
    }

    @Override // a.g.l.a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.f1517c.getLayoutManager() == null) {
            return false;
        }
        return this.f1517c.getLayoutManager().a(i, bundle);
    }

    public a.g.l.a b() {
        return this.f1518d;
    }

    @Override // a.g.l.a
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    boolean c() {
        return this.f1517c.j();
    }
}
