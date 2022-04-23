package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.h;

/* loaded from: classes.dex */
public class v extends h implements SubMenu {
    private h B;
    private k C;

    public v(Context context, h hVar, k kVar) {
        super(context);
        this.B = hVar;
        this.C = kVar;
    }

    @Override // androidx.appcompat.view.menu.h
    public void a(h.a aVar) {
        this.B.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.view.menu.h
    public boolean a(h hVar, MenuItem menuItem) {
        return super.a(hVar, menuItem) || this.B.a(hVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.h
    public boolean a(k kVar) {
        return this.B.a(kVar);
    }

    @Override // androidx.appcompat.view.menu.h
    public boolean b(k kVar) {
        return this.B.b(kVar);
    }

    @Override // androidx.appcompat.view.menu.h
    public String d() {
        k kVar = this.C;
        int itemId = kVar != null ? kVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.h
    public h m() {
        return this.B.m();
    }

    @Override // androidx.appcompat.view.menu.h
    public boolean o() {
        return this.B.o();
    }

    @Override // androidx.appcompat.view.menu.h
    public boolean p() {
        return this.B.p();
    }

    @Override // androidx.appcompat.view.menu.h
    public boolean q() {
        return this.B.q();
    }

    @Override // androidx.appcompat.view.menu.h, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.d(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.e(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.h, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }
}
