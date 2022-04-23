package androidx.core.app;

import a.g.l.e;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;

/* loaded from: classes.dex */
public class d extends Activity implements g, e.a {

    /* renamed from: b  reason: collision with root package name */
    private a.d.g<Class<? extends a>, a> f1162b = new a.d.g<>();

    /* renamed from: c  reason: collision with root package name */
    private h f1163c = new h(this);

    /* loaded from: classes.dex */
    public static class a {
    }

    public <T extends a> T a(Class<T> cls) {
        return (T) this.f1162b.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(a aVar) {
        this.f1162b.put(aVar.getClass(), aVar);
    }

    @Override // a.g.l.e.a
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return e.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public androidx.lifecycle.e e() {
        return this.f1163c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f1163c.a(e.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
