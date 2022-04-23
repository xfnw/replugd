package androidx.appcompat.view.menu;

import a.g.f.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f772a;

    /* renamed from: b  reason: collision with root package name */
    private final int f773b;

    /* renamed from: c  reason: collision with root package name */
    private final int f774c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f775d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f776e;
    private Intent f;
    private char g;
    private char i;
    private Drawable k;
    private Context l;
    private CharSequence m;
    private CharSequence n;
    private int h = 4096;
    private int j = 4096;
    private ColorStateList o = null;
    private PorterDuff.Mode p = null;
    private boolean q = false;
    private boolean r = false;
    private int s = 16;

    public a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.l = context;
        this.f772a = i2;
        this.f773b = i;
        this.f774c = i4;
        this.f775d = charSequence;
    }

    private void b() {
        if (this.k == null) {
            return;
        }
        if (this.q || this.r) {
            this.k = androidx.core.graphics.drawable.a.i(this.k);
            this.k = this.k.mutate();
            if (this.q) {
                androidx.core.graphics.drawable.a.a(this.k, this.o);
            }
            if (this.r) {
                androidx.core.graphics.drawable.a.a(this.k, this.p);
            }
        }
    }

    @Override // a.g.f.a.b
    public b a(a.g.l.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // a.g.f.a.b
    public a.g.l.b a() {
        return null;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f773b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.k;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f772a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f774c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f775d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f776e;
        return charSequence != null ? charSequence : this.f775d;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = Character.toLowerCase(c2);
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.s = (z ? 1 : 0) | (this.s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & (-3));
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public b setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.k = androidx.core.content.a.c(this.l, i);
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        b();
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        b();
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.g = c2;
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.g = c2;
        this.i = Character.toLowerCase(c3);
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i);
        this.i = Character.toLowerCase(c3);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f775d = this.l.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f775d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f776e = charSequence;
        return this;
    }

    @Override // a.g.f.a.b, android.view.MenuItem
    public b setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.s & 8;
        if (z) {
            i = 0;
        }
        this.s = i2 | i;
        return this;
    }
}
