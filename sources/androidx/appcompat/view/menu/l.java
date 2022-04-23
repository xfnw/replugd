package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class l extends androidx.appcompat.view.menu.c<a.g.f.a.b> implements MenuItem {

    /* renamed from: e  reason: collision with root package name */
    private Method f823e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends a.g.l.b {

        /* renamed from: b  reason: collision with root package name */
        final ActionProvider f824b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f824b = actionProvider;
        }

        @Override // a.g.l.b
        public void a(SubMenu subMenu) {
            this.f824b.onPrepareSubMenu(l.this.a(subMenu));
        }

        @Override // a.g.l.b
        public boolean a() {
            return this.f824b.hasSubMenu();
        }

        @Override // a.g.l.b
        public View c() {
            return this.f824b.onCreateActionView();
        }

        @Override // a.g.l.b
        public boolean d() {
            return this.f824b.onPerformDefaultAction();
        }
    }

    /* loaded from: classes.dex */
    static class b extends FrameLayout implements a.a.n.c {

        /* renamed from: b  reason: collision with root package name */
        final CollapsibleActionView f826b;

        b(View view) {
            super(view.getContext());
            this.f826b = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f826b;
        }

        @Override // a.a.n.c
        public void b() {
            this.f826b.onActionViewExpanded();
        }

        @Override // a.a.n.c
        public void c() {
            this.f826b.onActionViewCollapsed();
        }
    }

    /* loaded from: classes.dex */
    private class c extends androidx.appcompat.view.menu.d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f784a).onMenuItemActionCollapse(l.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f784a).onMenuItemActionExpand(l.this.a(menuItem));
        }
    }

    /* loaded from: classes.dex */
    private class d extends androidx.appcompat.view.menu.d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f784a).onMenuItemClick(l.this.a(menuItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, a.g.f.a.b bVar) {
        super(context, bVar);
    }

    a a(ActionProvider actionProvider) {
        return new a(this.f781b, actionProvider);
    }

    public void a(boolean z) {
        try {
            if (this.f823e == null) {
                this.f823e = ((a.g.f.a.b) this.f784a).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f823e.invoke(this.f784a, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((a.g.f.a.b) this.f784a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((a.g.f.a.b) this.f784a).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        a.g.l.b a2 = ((a.g.f.a.b) this.f784a).a();
        if (a2 instanceof a) {
            return ((a) a2).f824b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((a.g.f.a.b) this.f784a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((a.g.f.a.b) this.f784a).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((a.g.f.a.b) this.f784a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((a.g.f.a.b) this.f784a).getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((a.g.f.a.b) this.f784a).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((a.g.f.a.b) this.f784a).getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((a.g.f.a.b) this.f784a).getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((a.g.f.a.b) this.f784a).getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((a.g.f.a.b) this.f784a).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((a.g.f.a.b) this.f784a).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((a.g.f.a.b) this.f784a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((a.g.f.a.b) this.f784a).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((a.g.f.a.b) this.f784a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((a.g.f.a.b) this.f784a).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(((a.g.f.a.b) this.f784a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((a.g.f.a.b) this.f784a).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((a.g.f.a.b) this.f784a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((a.g.f.a.b) this.f784a).getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((a.g.f.a.b) this.f784a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((a.g.f.a.b) this.f784a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((a.g.f.a.b) this.f784a).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((a.g.f.a.b) this.f784a).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((a.g.f.a.b) this.f784a).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((a.g.f.a.b) this.f784a).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((a.g.f.a.b) this.f784a).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((a.g.f.a.b) this.f784a).setActionView(i);
        View actionView = ((a.g.f.a.b) this.f784a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((a.g.f.a.b) this.f784a).setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((a.g.f.a.b) this.f784a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((a.g.f.a.b) this.f784a).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        ((a.g.f.a.b) this.f784a).setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((a.g.f.a.b) this.f784a).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((a.g.f.a.b) this.f784a).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((a.g.f.a.b) this.f784a).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((a.g.f.a.b) this.f784a).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((a.g.f.a.b) this.f784a).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((a.g.f.a.b) this.f784a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((a.g.f.a.b) this.f784a).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((a.g.f.a.b) this.f784a).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((a.g.f.a.b) this.f784a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((a.g.f.a.b) this.f784a).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        ((a.g.f.a.b) this.f784a).setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((a.g.f.a.b) this.f784a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((a.g.f.a.b) this.f784a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((a.g.f.a.b) this.f784a).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        ((a.g.f.a.b) this.f784a).setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((a.g.f.a.b) this.f784a).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((a.g.f.a.b) this.f784a).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((a.g.f.a.b) this.f784a).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((a.g.f.a.b) this.f784a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((a.g.f.a.b) this.f784a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((a.g.f.a.b) this.f784a).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((a.g.f.a.b) this.f784a).setVisible(z);
    }
}
