package androidx.appcompat.view.menu;

import a.a.d;
import a.a.g;
import a.g.l.s;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.i0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends n implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, p, View.OnKeyListener {
    private static final int w = g.abc_popup_menu_item_layout;

    /* renamed from: c  reason: collision with root package name */
    private final Context f837c;

    /* renamed from: d  reason: collision with root package name */
    private final h f838d;

    /* renamed from: e  reason: collision with root package name */
    private final g f839e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    final i0 j;
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private p.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean v;
    final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    private final View.OnAttachStateChangeListener l = new b();
    private int u = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (u.this.c() && !u.this.j.k()) {
                View view = u.this.o;
                if (view == null || !view.isShown()) {
                    u.this.dismiss();
                } else {
                    u.this.j.b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = u.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    u.this.q = view.getViewTreeObserver();
                }
                u uVar = u.this;
                uVar.q.removeGlobalOnLayoutListener(uVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public u(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.f837c = context;
        this.f838d = hVar;
        this.f = z;
        this.f839e = new g(hVar, LayoutInflater.from(context), this.f, w);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new i0(this.f837c, null, this.h, this.i);
        hVar.a(this, context);
    }

    private boolean g() {
        View view;
        if (c()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.a((PopupWindow.OnDismissListener) this);
        this.j.a((AdapterView.OnItemClickListener) this);
        this.j.a(true);
        View view2 = this.o;
        boolean z = this.q == null;
        this.q = view2.getViewTreeObserver();
        if (z) {
            this.q.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.a(view2);
        this.j.c(this.u);
        if (!this.s) {
            this.t = n.a(this.f839e, null, this.f837c, this.g);
            this.s = true;
        }
        this.j.b(this.t);
        this.j.e(2);
        this.j.a(f());
        this.j.b();
        ListView d2 = this.j.d();
        d2.setOnKeyListener(this);
        if (this.v && this.f838d.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f837c).inflate(g.abc_popup_menu_header_item_layout, (ViewGroup) d2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f838d.h());
            }
            frameLayout.setEnabled(false);
            d2.addHeaderView(frameLayout, null, false);
        }
        this.j.a((ListAdapter) this.f839e);
        this.j.b();
        return true;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(int i) {
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(View view) {
        this.n = view;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(h hVar) {
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(h hVar, boolean z) {
        if (hVar == this.f838d) {
            dismiss();
            p.a aVar = this.p;
            if (aVar != null) {
                aVar.a(hVar, z);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(p.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(boolean z) {
        this.s = false;
        g gVar = this.f839e;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a(v vVar) {
        if (vVar.hasVisibleItems()) {
            o oVar = new o(this.f837c, vVar, this.o, this.f, this.h, this.i);
            oVar.a(this.p);
            oVar.a(n.b(vVar));
            oVar.a(this.m);
            this.m = null;
            this.f838d.a(false);
            int g = this.j.g();
            int h = this.j.h();
            if ((Gravity.getAbsoluteGravity(this.u, s.j(this.n)) & 7) == 5) {
                g += this.n.getWidth();
            }
            if (oVar.a(g, h)) {
                p.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(vVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.t
    public void b() {
        if (!g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(int i) {
        this.j.d(i);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(boolean z) {
        this.f839e.a(z);
    }

    @Override // androidx.appcompat.view.menu.n
    public void c(int i) {
        this.j.h(i);
    }

    @Override // androidx.appcompat.view.menu.n
    public void c(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.t
    public boolean c() {
        return !this.r && this.j.c();
    }

    @Override // androidx.appcompat.view.menu.t
    public ListView d() {
        return this.j.d();
    }

    @Override // androidx.appcompat.view.menu.t
    public void dismiss() {
        if (c()) {
            this.j.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.f838d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }
}
