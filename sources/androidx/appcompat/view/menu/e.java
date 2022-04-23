package androidx.appcompat.view.menu;

import a.a.g;
import a.g.l.s;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.i0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends n implements p, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* renamed from: c  reason: collision with root package name */
    private final Context f785c;

    /* renamed from: d  reason: collision with root package name */
    private final int f786d;

    /* renamed from: e  reason: collision with root package name */
    private final int f787e;
    private final int f;
    private final boolean g;
    private View p;
    View q;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean x;
    private p.a y;
    ViewTreeObserver z;
    private final List<h> i = new ArrayList();
    final List<d> j = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    private final View.OnAttachStateChangeListener l = new b();
    private final h0 m = new c();
    private int n = 0;
    private int o = 0;
    private boolean w = false;
    private int r = h();
    final Handler h = new Handler();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (e.this.c() && e.this.j.size() > 0 && !e.this.j.get(0).f795a.k()) {
                View view = e.this.q;
                if (view == null || !view.isShown()) {
                    e.this.dismiss();
                    return;
                }
                for (d dVar : e.this.j) {
                    dVar.f795a.b();
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
            ViewTreeObserver viewTreeObserver = e.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    e.this.z = view.getViewTreeObserver();
                }
                e eVar = e.this;
                eVar.z.removeGlobalOnLayoutListener(eVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    class c implements h0 {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f791b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ MenuItem f792c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ h f793d;

            a(d dVar, MenuItem menuItem, h hVar) {
                this.f791b = dVar;
                this.f792c = menuItem;
                this.f793d = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f791b;
                if (dVar != null) {
                    e.this.B = true;
                    dVar.f796b.a(false);
                    e.this.B = false;
                }
                if (this.f792c.isEnabled() && this.f792c.hasSubMenu()) {
                    this.f793d.a(this.f792c, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.h0
        public void a(h hVar, MenuItem menuItem) {
            d dVar = null;
            e.this.h.removeCallbacksAndMessages(null);
            int size = e.this.j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == e.this.j.get(i).f796b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < e.this.j.size()) {
                    dVar = e.this.j.get(i2);
                }
                e.this.h.postAtTime(new a(dVar, menuItem, hVar), hVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // androidx.appcompat.widget.h0
        public void b(h hVar, MenuItem menuItem) {
            e.this.h.removeCallbacksAndMessages(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final i0 f795a;

        /* renamed from: b  reason: collision with root package name */
        public final h f796b;

        /* renamed from: c  reason: collision with root package name */
        public final int f797c;

        public d(i0 i0Var, h hVar, int i) {
            this.f795a = i0Var;
            this.f796b = hVar;
            this.f797c = i;
        }

        public ListView a() {
            return this.f795a.d();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.f785c = context;
        this.p = view;
        this.f787e = i;
        this.f = i2;
        this.g = z;
        Resources resources = context.getResources();
        this.f786d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.a.d.abc_config_prefDialogWidth));
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(d dVar, h hVar) {
        int i;
        g gVar;
        int firstVisiblePosition;
        MenuItem a2 = a(dVar.f796b, hVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = dVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a2 == gVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int c(h hVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (hVar == this.j.get(i).f796b) {
                return i;
            }
        }
        return -1;
    }

    private int d(int i) {
        List<d> list = this.j;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        return this.r == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private void d(h hVar) {
        View view;
        d dVar;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f785c);
        g gVar = new g(hVar, from, this.g, C);
        if (!c() && this.w) {
            gVar.a(true);
        } else if (c()) {
            gVar.a(n.b(hVar));
        }
        int a2 = n.a(gVar, null, this.f785c, this.f786d);
        i0 g = g();
        g.a((ListAdapter) gVar);
        g.b(a2);
        g.c(this.o);
        if (this.j.size() > 0) {
            List<d> list = this.j;
            dVar = list.get(list.size() - 1);
            view = a(dVar, hVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            g.c(false);
            g.a((Object) null);
            int d2 = d(a2);
            boolean z = d2 == 1;
            this.r = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                g.a(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i3 = i - a2;
                }
                i3 = i + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i3 = i + a2;
                }
                i3 = i - a2;
            }
            g.d(i3);
            g.b(true);
            g.h(i2);
        } else {
            if (this.s) {
                g.d(this.u);
            }
            if (this.t) {
                g.h(this.v);
            }
            g.a(f());
        }
        this.j.add(new d(g, hVar, this.r));
        g.b();
        ListView d3 = g.d();
        d3.setOnKeyListener(this);
        if (dVar == null && this.x && hVar.h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, (ViewGroup) d3, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.h());
            d3.addHeaderView(frameLayout, null, false);
            g.b();
        }
    }

    private i0 g() {
        i0 i0Var = new i0(this.f785c, null, this.f787e, this.f);
        i0Var.a(this.m);
        i0Var.a((AdapterView.OnItemClickListener) this);
        i0Var.a((PopupWindow.OnDismissListener) this);
        i0Var.a(this.p);
        i0Var.c(this.o);
        i0Var.a(true);
        i0Var.e(2);
        return i0Var;
    }

    private int h() {
        return s.j(this.p) == 1 ? 0 : 1;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = a.g.l.d.a(i, s.j(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = a.g.l.d.a(this.n, s.j(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(h hVar) {
        hVar.a(this, this.f785c);
        if (c()) {
            d(hVar);
        } else {
            this.i.add(hVar);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(h hVar, boolean z) {
        int c2 = c(hVar);
        if (c2 >= 0) {
            int i = c2 + 1;
            if (i < this.j.size()) {
                this.j.get(i).f796b.a(false);
            }
            d remove = this.j.remove(c2);
            remove.f796b.b(this);
            if (this.B) {
                remove.f795a.b((Object) null);
                remove.f795a.a(0);
            }
            remove.f795a.dismiss();
            int size = this.j.size();
            this.r = size > 0 ? this.j.get(size - 1).f797c : h();
            if (size == 0) {
                dismiss();
                p.a aVar = this.y;
                if (aVar != null) {
                    aVar.a(hVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.z.removeGlobalOnLayoutListener(this.k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.l);
                this.A.onDismiss();
            } else if (z) {
                this.j.get(0).f796b.a(false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(p.a aVar) {
        this.y = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(boolean z) {
        for (d dVar : this.j) {
            n.a(dVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a(v vVar) {
        for (d dVar : this.j) {
            if (vVar == dVar.f796b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!vVar.hasVisibleItems()) {
            return false;
        }
        a((h) vVar);
        p.a aVar = this.y;
        if (aVar != null) {
            aVar.a(vVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.t
    public void b() {
        if (!c()) {
            for (h hVar : this.i) {
                d(hVar);
            }
            this.i.clear();
            this.q = this.p;
            if (this.q != null) {
                boolean z = this.z == null;
                this.z = this.q.getViewTreeObserver();
                if (z) {
                    this.z.addOnGlobalLayoutListener(this.k);
                }
                this.q.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(boolean z) {
        this.w = z;
    }

    @Override // androidx.appcompat.view.menu.n
    public void c(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.n
    public void c(boolean z) {
        this.x = z;
    }

    @Override // androidx.appcompat.view.menu.t
    public boolean c() {
        return this.j.size() > 0 && this.j.get(0).f795a.c();
    }

    @Override // androidx.appcompat.view.menu.t
    public ListView d() {
        if (this.j.isEmpty()) {
            return null;
        }
        List<d> list = this.j;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.t
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.j.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.f795a.c()) {
                    dVar.f795a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.n
    protected boolean e() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = this.j.get(i);
            if (!dVar.f795a.c()) {
                break;
            }
            i++;
        }
        if (dVar != null) {
            dVar.f796b.a(false);
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
