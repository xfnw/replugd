package a.a.n;

import a.a.n.b;
import a.d.g;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.r;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f35a;

    /* renamed from: b  reason: collision with root package name */
    final b f36b;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f37a;

        /* renamed from: b  reason: collision with root package name */
        final Context f38b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f39c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f40d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f38b = context;
            this.f37a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f40d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a2 = r.a(this.f38b, (a.g.f.a.a) menu);
            this.f40d.put(menu, a2);
            return a2;
        }

        @Override // a.a.n.b.a
        public void a(b bVar) {
            this.f37a.onDestroyActionMode(b(bVar));
        }

        @Override // a.a.n.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f37a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // a.a.n.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f37a.onActionItemClicked(b(bVar), r.a(this.f38b, (a.g.f.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f39c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f39c.get(i);
                if (fVar != null && fVar.f36b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f38b, bVar);
            this.f39c.add(fVar2);
            return fVar2;
        }

        @Override // a.a.n.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f37a.onCreateActionMode(b(bVar), a(menu));
        }
    }

    public f(Context context, b bVar) {
        this.f35a = context;
        this.f36b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f36b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f36b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return r.a(this.f35a, (a.g.f.a.a) this.f36b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f36b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f36b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f36b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f36b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f36b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f36b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f36b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f36b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f36b.a(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f36b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f36b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f36b.b(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f36b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f36b.a(z);
    }
}
