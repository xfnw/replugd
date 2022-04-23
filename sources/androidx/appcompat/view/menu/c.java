package androidx.appcompat.view.menu;

import a.d.a;
import a.g.f.a.b;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
abstract class c<T> extends d<T> {

    /* renamed from: b  reason: collision with root package name */
    final Context f781b;

    /* renamed from: c  reason: collision with root package name */
    private Map<b, MenuItem> f782c;

    /* renamed from: d  reason: collision with root package name */
    private Map<a.g.f.a.c, SubMenu> f783d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, T t) {
        super(t);
        this.f781b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f782c == null) {
            this.f782c = new a();
        }
        MenuItem menuItem2 = this.f782c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a2 = r.a(this.f781b, bVar);
        this.f782c.put(bVar, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof a.g.f.a.c)) {
            return subMenu;
        }
        a.g.f.a.c cVar = (a.g.f.a.c) subMenu;
        if (this.f783d == null) {
            this.f783d = new a();
        }
        SubMenu subMenu2 = this.f783d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu a2 = r.a(this.f781b, cVar);
        this.f783d.put(cVar, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        Map<b, MenuItem> map = this.f782c;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        Map<b, MenuItem> map = this.f782c;
        if (map != null) {
            map.clear();
        }
        Map<a.g.f.a.c, SubMenu> map2 = this.f783d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        Map<b, MenuItem> map = this.f782c;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
