package androidx.appcompat.view.menu;

import a.g.l.b;
import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends l {

    /* loaded from: classes.dex */
    class a extends l.a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        b.AbstractC0012b f829d;

        public a(m mVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // a.g.l.b
        public View a(MenuItem menuItem) {
            return this.f824b.onCreateActionView(menuItem);
        }

        @Override // a.g.l.b
        public void a(b.AbstractC0012b bVar) {
            this.f829d = bVar;
            this.f824b.setVisibilityListener(bVar != null ? this : null);
        }

        @Override // a.g.l.b
        public boolean b() {
            return this.f824b.isVisible();
        }

        @Override // a.g.l.b
        public boolean e() {
            return this.f824b.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            b.AbstractC0012b bVar = this.f829d;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, a.g.f.a.b bVar) {
        super(context, bVar);
    }

    @Override // androidx.appcompat.view.menu.l
    l.a a(ActionProvider actionProvider) {
        return new a(this, this.f781b, actionProvider);
    }
}
