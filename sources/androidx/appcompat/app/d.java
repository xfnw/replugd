package androidx.appcompat.app;

import a.a.n.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.x0;
import androidx.core.app.a;
import androidx.core.app.e;
import androidx.core.app.l;

/* loaded from: classes.dex */
public class d extends a.k.a.d implements e, l.a, b {
    private f o;
    private int p = 0;
    private Resources q;

    private boolean a(int i, KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // androidx.appcompat.app.e
    public b a(b.a aVar) {
        return null;
    }

    @Override // androidx.appcompat.app.e
    public void a(b bVar) {
    }

    public void a(Intent intent) {
        e.a(this, intent);
    }

    public void a(l lVar) {
        lVar.a((Activity) this);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n().a(view, layoutParams);
    }

    @Override // androidx.appcompat.app.e
    public void b(b bVar) {
    }

    public void b(l lVar) {
    }

    public boolean b(Intent intent) {
        return e.b(this, intent);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a o = o();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (o == null || !o.e()) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a o = o();
        if (keyCode != 82 || o == null || !o.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) n().a(i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return n().b();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.q == null && x0.b()) {
            this.q = new x0(this, super.getResources());
        }
        Resources resources = this.q;
        return resources == null ? super.getResources() : resources;
    }

    @Override // androidx.core.app.l.a
    public Intent i() {
        return e.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        n().e();
    }

    @Override // a.k.a.d
    public void m() {
        n().e();
    }

    public f n() {
        if (this.o == null) {
            this.o = f.a(this, this);
        }
        return this.o;
    }

    public a o() {
        return n().c();
    }

    @Override // a.k.a.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n().a(configuration);
        if (this.q != null) {
            this.q.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        f n = n();
        n.d();
        n.a(bundle);
        if (n.a() && (i = this.p) != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.p, false);
            } else {
                setTheme(i);
            }
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n().f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // a.k.a.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a o = o();
        if (menuItem.getItemId() != 16908332 || o == null || (o.g() & 4) == 0) {
            return false;
        }
        return q();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // a.k.a.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        n().b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        n().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        n().c(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onStart() {
        super.onStart();
        n().h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onStop() {
        super.onStop();
        n().i();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        n().a(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a o = o();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (o == null || !o.k()) {
            super.openOptionsMenu();
        }
    }

    @Deprecated
    public void p() {
    }

    public boolean q() {
        Intent i = i();
        if (i == null) {
            return false;
        }
        if (b(i)) {
            l a2 = l.a((Context) this);
            a(a2);
            b(a2);
            a2.a();
            try {
                a.a((Activity) this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            a(i);
            return true;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        n().c(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        n().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n().b(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.p = i;
    }
}
