package androidx.appcompat.widget;

import a.a.ActionBar;
import a.a.e;
import a.a.f;
import a.a.h;
import a.a.j;
import a.g.l.s;
import a.g.l.w;
import a.g.l.y;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public class t0 implements a0 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1040a;

    /* renamed from: b  reason: collision with root package name */
    private int f1041b;

    /* renamed from: c  reason: collision with root package name */
    private View f1042c;

    /* renamed from: d  reason: collision with root package name */
    private View f1043d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1044e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final androidx.appcompat.view.menu.a f1045b;

        a() {
            this.f1045b = new androidx.appcompat.view.menu.a(t0.this.f1040a.getContext(), 0, 16908332, 0, 0, t0.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var = t0.this;
            Window.Callback callback = t0Var.l;
            if (callback != null && t0Var.m) {
                callback.onMenuItemSelected(0, this.f1045b);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends y {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1047a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1048b;

        b(int i) {
            this.f1048b = i;
        }

        @Override // a.g.l.x
        public void a(View view) {
            if (!this.f1047a) {
                t0.this.f1040a.setVisibility(this.f1048b);
            }
        }

        @Override // a.g.l.y, a.g.l.x
        public void b(View view) {
            t0.this.f1040a.setVisibility(0);
        }

        @Override // a.g.l.y, a.g.l.x
        public void c(View view) {
            this.f1047a = true;
        }
    }

    public t0(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    public t0(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f1040a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        s0 a2 = s0.a(toolbar.getContext(), null, j.ActionBar, ActionBar.actionBarStyle, 0);
        this.q = a2.b(j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(j.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                c(e2);
            }
            CharSequence e3 = a2.e(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                b(e3);
            }
            Drawable b2 = a2.b(j.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(j.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            c(a2.d(j.ActionBar_displayOptions, 0));
            int g = a2.g(j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.f1040a.getContext()).inflate(g, (ViewGroup) this.f1040a, false));
                c(this.f1041b | 16);
            }
            int f = a2.f(j.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1040a.getLayoutParams();
                layoutParams.height = f;
                this.f1040a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(j.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(j.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f1040a.a(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g2 = a2.g(j.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.f1040a;
                toolbar2.b(toolbar2.getContext(), g2);
            }
            int g3 = a2.g(j.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.f1040a;
                toolbar3.a(toolbar3.getContext(), g3);
            }
            int g4 = a2.g(j.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f1040a.setPopupTheme(g4);
            }
        } else {
            this.f1041b = o();
        }
        a2.a();
        d(i);
        this.k = this.f1040a.getNavigationContentDescription();
        this.f1040a.setNavigationOnClickListener(new a());
    }

    private void d(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f1041b & 8) != 0) {
            this.f1040a.setTitle(charSequence);
        }
    }

    private int o() {
        if (this.f1040a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f1040a.getNavigationIcon();
        return 15;
    }

    private void p() {
        if ((this.f1041b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f1040a.setNavigationContentDescription(this.p);
        } else {
            this.f1040a.setNavigationContentDescription(this.k);
        }
    }

    private void q() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f1041b & 4) != 0) {
            toolbar = this.f1040a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.f1040a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void r() {
        Drawable drawable;
        int i = this.f1041b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.f1044e;
        }
        this.f1040a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.a0
    public w a(int i, long j) {
        w a2 = s.a(this.f1040a);
        a2.a(i == 0 ? 1.0f : 0.0f);
        a2.a(j);
        a2.a(new b(i));
        return a2;
    }

    @Override // androidx.appcompat.widget.a0
    public void a(int i) {
        this.f1040a.setVisibility(i);
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        r();
    }

    @Override // androidx.appcompat.widget.a0
    public void a(Menu menu, p.a aVar) {
        if (this.n == null) {
            this.n = new c(this.f1040a.getContext());
            this.n.a(f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f1040a.a((androidx.appcompat.view.menu.h) menu, this.n);
    }

    public void a(View view) {
        View view2 = this.f1043d;
        if (!(view2 == null || (this.f1041b & 16) == 0)) {
            this.f1040a.removeView(view2);
        }
        this.f1043d = view;
        if (view != null && (this.f1041b & 16) != 0) {
            this.f1040a.addView(this.f1043d);
        }
    }

    @Override // androidx.appcompat.widget.a0
    public void a(l0 l0Var) {
        View view = this.f1042c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1040a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1042c);
            }
        }
        this.f1042c = l0Var;
        if (l0Var != null && this.o == 2) {
            this.f1040a.addView(this.f1042c, 0);
            Toolbar.e eVar = (Toolbar.e) this.f1042c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) eVar).width = -2;
            ((ViewGroup.MarginLayoutParams) eVar).height = -2;
            eVar.f700a = 8388691;
            l0Var.setAllowCollapse(true);
        }
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        p();
    }

    @Override // androidx.appcompat.widget.a0
    public void a(boolean z) {
    }

    @Override // androidx.appcompat.widget.a0
    public boolean a() {
        return this.f1040a.h();
    }

    @Override // androidx.appcompat.widget.a0
    public void b(int i) {
        a(i != 0 ? a.a.k.a.a.c(j(), i) : null);
    }

    public void b(Drawable drawable) {
        this.g = drawable;
        q();
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f1041b & 8) != 0) {
            this.f1040a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.a0
    public void b(boolean z) {
        this.f1040a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.a0
    public boolean b() {
        return this.f1040a.i();
    }

    @Override // androidx.appcompat.widget.a0
    public void c(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f1041b ^ i;
        this.f1041b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    p();
                }
                q();
            }
            if ((i2 & 3) != 0) {
                r();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1040a.setTitle(this.i);
                    toolbar = this.f1040a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.f1040a.setTitle((CharSequence) null);
                    toolbar = this.f1040a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) != 0 && (view = this.f1043d) != null) {
                if ((i & 16) != 0) {
                    this.f1040a.addView(view);
                } else {
                    this.f1040a.removeView(view);
                }
            }
        }
    }

    public void c(CharSequence charSequence) {
        this.h = true;
        d(charSequence);
    }

    @Override // androidx.appcompat.widget.a0
    public boolean c() {
        return this.f1040a.g();
    }

    @Override // androidx.appcompat.widget.a0
    public void collapseActionView() {
        this.f1040a.c();
    }

    public void d(int i) {
        if (i != this.p) {
            this.p = i;
            if (TextUtils.isEmpty(this.f1040a.getNavigationContentDescription())) {
                e(this.p);
            }
        }
    }

    @Override // androidx.appcompat.widget.a0
    public boolean d() {
        return this.f1040a.k();
    }

    @Override // androidx.appcompat.widget.a0
    public void e() {
        this.m = true;
    }

    public void e(int i) {
        a(i == 0 ? null : j().getString(i));
    }

    @Override // androidx.appcompat.widget.a0
    public boolean f() {
        return this.f1040a.b();
    }

    @Override // androidx.appcompat.widget.a0
    public void g() {
        this.f1040a.d();
    }

    @Override // androidx.appcompat.widget.a0
    public CharSequence getTitle() {
        return this.f1040a.getTitle();
    }

    @Override // androidx.appcompat.widget.a0
    public int h() {
        return this.f1041b;
    }

    @Override // androidx.appcompat.widget.a0
    public ViewGroup i() {
        return this.f1040a;
    }

    @Override // androidx.appcompat.widget.a0
    public Context j() {
        return this.f1040a.getContext();
    }

    @Override // androidx.appcompat.widget.a0
    public int k() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.a0
    public void l() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.a0
    public boolean m() {
        return this.f1040a.f();
    }

    @Override // androidx.appcompat.widget.a0
    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.a0
    public void setIcon(int i) {
        setIcon(i != 0 ? a.a.k.a.a.c(j(), i) : null);
    }

    @Override // androidx.appcompat.widget.a0
    public void setIcon(Drawable drawable) {
        this.f1044e = drawable;
        r();
    }

    @Override // androidx.appcompat.widget.a0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.a0
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            d(charSequence);
        }
    }
}
