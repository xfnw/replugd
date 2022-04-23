package androidx.appcompat.app;

import a.a.ActionBar;
import a.a.n.b;
import a.g.l.e;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class h extends Dialog implements e {

    /* renamed from: b  reason: collision with root package name */
    private f f733b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f734c = new a();

    /* loaded from: classes.dex */
    class a implements e.a {
        a() {
        }

        @Override // a.g.l.e.a
        public boolean a(KeyEvent keyEvent) {
            return h.this.a(keyEvent);
        }
    }

    public h(Context context, int i) {
        super(context, a(context, i));
        a().a((Bundle) null);
        a().a();
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(ActionBar.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.e
    public b a(b.a aVar) {
        return null;
    }

    public f a() {
        if (this.f733b == null) {
            this.f733b = f.a(this, this);
        }
        return this.f733b;
    }

    @Override // androidx.appcompat.app.e
    public void a(b bVar) {
    }

    public boolean a(int i) {
        return a().b(i);
    }

    boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // androidx.appcompat.app.e
    public void b(b bVar) {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return e.a(this.f734c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().d();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().i();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().c(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }
}
