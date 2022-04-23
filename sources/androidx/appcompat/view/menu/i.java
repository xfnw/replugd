package androidx.appcompat.view.menu;

import a.a.g;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.p;

/* loaded from: classes.dex */
class i implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, p.a {

    /* renamed from: b  reason: collision with root package name */
    private h f813b;

    /* renamed from: c  reason: collision with root package name */
    private c f814c;

    /* renamed from: d  reason: collision with root package name */
    f f815d;

    /* renamed from: e  reason: collision with root package name */
    private p.a f816e;

    public i(h hVar) {
        this.f813b = hVar;
    }

    public void a() {
        c cVar = this.f814c;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        h hVar = this.f813b;
        c.a aVar = new c.a(hVar.e());
        this.f815d = new f(aVar.b(), g.abc_list_menu_item_layout);
        this.f815d.a(this);
        this.f813b.a(this.f815d);
        aVar.a(this.f815d.b(), this);
        View i = hVar.i();
        if (i != null) {
            aVar.a(i);
        } else {
            aVar.a(hVar.g());
            aVar.b(hVar.h());
        }
        aVar.a(this);
        this.f814c = aVar.a();
        this.f814c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f814c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f814c.show();
    }

    @Override // androidx.appcompat.view.menu.p.a
    public void a(h hVar, boolean z) {
        if (z || hVar == this.f813b) {
            a();
        }
        p.a aVar = this.f816e;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.p.a
    public boolean a(h hVar) {
        p.a aVar = this.f816e;
        if (aVar != null) {
            return aVar.a(hVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f813b.a((k) this.f815d.b().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f815d.a(this.f813b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f814c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f814c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f813b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f813b.performShortcut(i, keyEvent, 0);
    }
}
