package androidx.appcompat.app;

import a.a.ActionBar;
import a.a.f;
import a.a.j;
import a.a.n.b;
import a.a.n.g;
import a.a.n.h;
import a.g.l.s;
import a.g.l.w;
import a.g.l.x;
import a.g.l.y;
import a.g.l.z;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.l0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Context f754a;

    /* renamed from: b  reason: collision with root package name */
    private Context f755b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarOverlayLayout f756c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f757d;

    /* renamed from: e  reason: collision with root package name */
    a0 f758e;
    ActionBarContextView f;
    View g;
    l0 h;
    private boolean i;
    d j;
    a.a.n.b k;
    b.a l;
    private boolean m;
    private boolean o;
    boolean r;
    boolean s;
    private boolean t;
    h v;
    private boolean w;
    boolean x;
    private ArrayList<a.b> n = new ArrayList<>();
    private int p = 0;
    boolean q = true;
    private boolean u = true;
    final x y = new a();
    final x z = new b();
    final z A = new c();

    /* loaded from: classes.dex */
    class a extends y {
        a() {
        }

        @Override // a.g.l.x
        public void a(View view) {
            View view2;
            l lVar = l.this;
            if (lVar.q && (view2 = lVar.g) != null) {
                view2.setTranslationY(0.0f);
                l.this.f757d.setTranslationY(0.0f);
            }
            l.this.f757d.setVisibility(8);
            l.this.f757d.setTransitioning(false);
            l lVar2 = l.this;
            lVar2.v = null;
            lVar2.l();
            ActionBarOverlayLayout actionBarOverlayLayout = l.this.f756c;
            if (actionBarOverlayLayout != null) {
                s.A(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends y {
        b() {
        }

        @Override // a.g.l.x
        public void a(View view) {
            l lVar = l.this;
            lVar.v = null;
            lVar.f757d.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements z {
        c() {
        }

        @Override // a.g.l.z
        public void a(View view) {
            ((View) l.this.f757d.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends a.a.n.b implements h.a {

        /* renamed from: d  reason: collision with root package name */
        private final Context f762d;

        /* renamed from: e  reason: collision with root package name */
        private final androidx.appcompat.view.menu.h f763e;
        private b.a f;
        private WeakReference<View> g;

        public d(Context context, b.a aVar) {
            this.f762d = context;
            this.f = aVar;
            androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context);
            hVar.c(1);
            this.f763e = hVar;
            this.f763e.a(this);
        }

        @Override // a.a.n.b
        public void a() {
            l lVar = l.this;
            if (lVar.j == this) {
                if (!l.a(lVar.r, lVar.s, false)) {
                    l lVar2 = l.this;
                    lVar2.k = this;
                    lVar2.l = this.f;
                } else {
                    this.f.a(this);
                }
                this.f = null;
                l.this.e(false);
                l.this.f.a();
                l.this.f758e.i().sendAccessibilityEvent(32);
                l lVar3 = l.this;
                lVar3.f756c.setHideOnContentScrollEnabled(lVar3.x);
                l.this.j = null;
            }
        }

        @Override // a.a.n.b
        public void a(int i) {
            a((CharSequence) l.this.f754a.getResources().getString(i));
        }

        @Override // a.a.n.b
        public void a(View view) {
            l.this.f.setCustomView(view);
            this.g = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.menu.h.a
        public void a(androidx.appcompat.view.menu.h hVar) {
            if (this.f != null) {
                i();
                l.this.f.d();
            }
        }

        @Override // a.a.n.b
        public void a(CharSequence charSequence) {
            l.this.f.setSubtitle(charSequence);
        }

        @Override // a.a.n.b
        public void a(boolean z) {
            super.a(z);
            l.this.f.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.menu.h.a
        public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
            b.a aVar = this.f;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // a.a.n.b
        public View b() {
            WeakReference<View> weakReference = this.g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // a.a.n.b
        public void b(int i) {
            b(l.this.f754a.getResources().getString(i));
        }

        @Override // a.a.n.b
        public void b(CharSequence charSequence) {
            l.this.f.setTitle(charSequence);
        }

        @Override // a.a.n.b
        public Menu c() {
            return this.f763e;
        }

        @Override // a.a.n.b
        public MenuInflater d() {
            return new g(this.f762d);
        }

        @Override // a.a.n.b
        public CharSequence e() {
            return l.this.f.getSubtitle();
        }

        @Override // a.a.n.b
        public CharSequence g() {
            return l.this.f.getTitle();
        }

        @Override // a.a.n.b
        public void i() {
            if (l.this.j == this) {
                this.f763e.s();
                try {
                    this.f.a(this, this.f763e);
                } finally {
                    this.f763e.r();
                }
            }
        }

        @Override // a.a.n.b
        public boolean j() {
            return l.this.f.b();
        }

        public boolean k() {
            this.f763e.s();
            try {
                return this.f.b(this, this.f763e);
            } finally {
                this.f763e.r();
            }
        }
    }

    public l(Activity activity, boolean z) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (!z) {
            this.g = decorView.findViewById(16908290);
        }
    }

    public l(Dialog dialog) {
        new ArrayList();
        b(dialog.getWindow().getDecorView());
    }

    private a0 a(View view) {
        if (view instanceof a0) {
            return (a0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    private void b(View view) {
        this.f756c = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f756c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f758e = a(view.findViewById(f.action_bar));
        this.f = (ActionBarContextView) view.findViewById(f.action_context_bar);
        this.f757d = (ActionBarContainer) view.findViewById(f.action_bar_container);
        a0 a0Var = this.f758e;
        if (a0Var == null || this.f == null || this.f757d == null) {
            throw new IllegalStateException(l.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f754a = a0Var.j();
        boolean z = (this.f758e.h() & 4) != 0;
        if (z) {
            this.i = true;
        }
        a.a.n.a a2 = a.a.n.a.a(this.f754a);
        j(a2.a() || z);
        k(a2.f());
        TypedArray obtainStyledAttributes = this.f754a.obtainStyledAttributes(null, j.ActionBar, ActionBar.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            i(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void k(boolean z) {
        this.o = z;
        if (!this.o) {
            this.f758e.a((l0) null);
            this.f757d.setTabContainer(this.h);
        } else {
            this.f757d.setTabContainer(null);
            this.f758e.a(this.h);
        }
        boolean z2 = true;
        boolean z3 = m() == 2;
        l0 l0Var = this.h;
        if (l0Var != null) {
            if (z3) {
                l0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f756c;
                if (actionBarOverlayLayout != null) {
                    s.A(actionBarOverlayLayout);
                }
            } else {
                l0Var.setVisibility(8);
            }
        }
        this.f758e.b(!this.o && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f756c;
        if (this.o || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    private void l(boolean z) {
        if (a(this.r, this.s, this.t)) {
            if (!this.u) {
                this.u = true;
                g(z);
            }
        } else if (this.u) {
            this.u = false;
            f(z);
        }
    }

    private void n() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f756c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean o() {
        return s.w(this.f757d);
    }

    private void p() {
        if (!this.t) {
            this.t = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f756c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    @Override // androidx.appcompat.app.a
    public a.a.n.b a(b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a();
        }
        this.f756c.setHideOnContentScrollEnabled(false);
        this.f.c();
        d dVar2 = new d(this.f.getContext(), aVar);
        if (!dVar2.k()) {
            return null;
        }
        this.j = dVar2;
        dVar2.i();
        this.f.a(dVar2);
        e(true);
        this.f.sendAccessibilityEvent(32);
        return dVar2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.s) {
            this.s = false;
            l(true);
        }
    }

    public void a(float f) {
        s.a(this.f757d, f);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(int i) {
        this.p = i;
    }

    public void a(int i, int i2) {
        int h = this.f758e.h();
        if ((i2 & 4) != 0) {
            this.i = true;
        }
        this.f758e.c((i & i2) | ((i2 ^ (-1)) & h));
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        k(a.a.n.a.a(this.f754a).f());
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.f758e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu c2;
        d dVar = this.j;
        if (dVar == null || (c2 = dVar.c()) == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        c2.setQwertyMode(z);
        return c2.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        a.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
        if (z != this.m) {
            this.m = z;
            int size = this.n.size();
            for (int i = 0; i < size; i++) {
                this.n.get(i).a(z);
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        if (!this.s) {
            this.s = true;
            l(true);
        }
    }

    @Override // androidx.appcompat.app.a
    public void c(boolean z) {
        if (!this.i) {
            h(z);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // androidx.appcompat.app.a
    public void d(boolean z) {
        a.a.n.h hVar;
        this.w = z;
        if (!z && (hVar = this.v) != null) {
            hVar.a();
        }
    }

    public void e(boolean z) {
        w wVar;
        w wVar2;
        if (z) {
            p();
        } else {
            n();
        }
        if (o()) {
            if (z) {
                wVar = this.f758e.a(4, 100L);
                wVar2 = this.f.a(0, 200L);
            } else {
                wVar2 = this.f758e.a(0, 200L);
                wVar = this.f.a(8, 100L);
            }
            a.a.n.h hVar = new a.a.n.h();
            hVar.a(wVar, wVar2);
            hVar.c();
        } else if (z) {
            this.f758e.a(4);
            this.f.setVisibility(0);
        } else {
            this.f758e.a(0);
            this.f.setVisibility(8);
        }
    }

    public void f(boolean z) {
        View view;
        int[] iArr;
        a.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z)) {
            this.y.a(null);
            return;
        }
        this.f757d.setAlpha(1.0f);
        this.f757d.setTransitioning(true);
        a.a.n.h hVar2 = new a.a.n.h();
        float f = -this.f757d.getHeight();
        if (z) {
            this.f757d.getLocationInWindow(new int[]{0, 0});
            f -= iArr[1];
        }
        w a2 = s.a(this.f757d);
        a2.b(f);
        a2.a(this.A);
        hVar2.a(a2);
        if (this.q && (view = this.g) != null) {
            w a3 = s.a(view);
            a3.b(f);
            hVar2.a(a3);
        }
        hVar2.a(B);
        hVar2.a(250L);
        hVar2.a(this.y);
        this.v = hVar2;
        hVar2.c();
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        a0 a0Var = this.f758e;
        if (a0Var == null || !a0Var.m()) {
            return false;
        }
        this.f758e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public int g() {
        return this.f758e.h();
    }

    public void g(boolean z) {
        View view;
        View view2;
        int[] iArr;
        a.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f757d.setVisibility(0);
        if (this.p != 0 || (!this.w && !z)) {
            this.f757d.setAlpha(1.0f);
            this.f757d.setTranslationY(0.0f);
            if (this.q && (view = this.g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.a(null);
        } else {
            this.f757d.setTranslationY(0.0f);
            float f = -this.f757d.getHeight();
            if (z) {
                this.f757d.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            this.f757d.setTranslationY(f);
            a.a.n.h hVar2 = new a.a.n.h();
            w a2 = s.a(this.f757d);
            a2.b(0.0f);
            a2.a(this.A);
            hVar2.a(a2);
            if (this.q && (view2 = this.g) != null) {
                view2.setTranslationY(f);
                w a3 = s.a(this.g);
                a3.b(0.0f);
                hVar2.a(a3);
            }
            hVar2.a(C);
            hVar2.a(250L);
            hVar2.a(this.z);
            this.v = hVar2;
            hVar2.c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f756c;
        if (actionBarOverlayLayout != null) {
            s.A(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.app.a
    public Context h() {
        if (this.f755b == null) {
            TypedValue typedValue = new TypedValue();
            this.f754a.getTheme().resolveAttribute(ActionBar.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f755b = new ContextThemeWrapper(this.f754a, i);
            } else {
                this.f755b = this.f754a;
            }
        }
        return this.f755b;
    }

    public void h(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public void i(boolean z) {
        if (!z || this.f756c.i()) {
            this.x = z;
            this.f756c.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void j(boolean z) {
        this.f758e.a(z);
    }

    void l() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.k);
            this.k = null;
            this.l = null;
        }
    }

    public int m() {
        return this.f758e.k();
    }
}
