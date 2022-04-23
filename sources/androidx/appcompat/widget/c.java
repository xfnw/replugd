package androidx.appcompat.widget;

import a.a.ActionBar;
import a.a.g;
import a.g.l.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    RunnableC0033c A;
    private b B;
    int D;
    d j;
    private Drawable k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private View x;
    e y;
    a z;
    private final SparseBooleanArray w = new SparseBooleanArray();
    final f C = new f();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends o {
        public a(Context context, v vVar, View view) {
            super(context, vVar, view, false, ActionBar.actionOverflowMenuStyle);
            if (!((k) vVar.getItem()).h()) {
                View view2 = c.this.j;
                a(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).i : view2);
            }
            a(c.this.C);
        }

        @Override // androidx.appcompat.view.menu.o
        protected void d() {
            c cVar = c.this;
            cVar.z = null;
            cVar.D = 0;
            super.d();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public t a() {
            a aVar = c.this.z;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0033c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private e f923b;

        public RunnableC0033c(e eVar) {
            this.f923b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).f779d != null) {
                ((androidx.appcompat.view.menu.b) c.this).f779d.a();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).i;
            if (!(view == null || view.getWindowToken() == null || !this.f923b.f())) {
                c.this.y = this.f923b;
            }
            c.this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends n implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends e0 {
            a(View view, c cVar) {
                super(view);
            }

            @Override // androidx.appcompat.widget.e0
            public t e() {
                e eVar = c.this.y;
                if (eVar == null) {
                    return null;
                }
                return eVar.b();
            }

            @Override // androidx.appcompat.widget.e0
            public boolean f() {
                c.this.i();
                return true;
            }

            @Override // androidx.appcompat.widget.e0
            public boolean g() {
                c cVar = c.this;
                if (cVar.A != null) {
                    return false;
                }
                cVar.e();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, ActionBar.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            u0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.i();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends o {
        public e(Context context, h hVar, View view, boolean z) {
            super(context, hVar, view, z, ActionBar.actionOverflowMenuStyle);
            a(8388613);
            a(c.this.C);
        }

        @Override // androidx.appcompat.view.menu.o
        protected void d() {
            if (((androidx.appcompat.view.menu.b) c.this).f779d != null) {
                ((androidx.appcompat.view.menu.b) c.this).f779d.close();
            }
            c.this.y = null;
            super.d();
        }
    }

    /* loaded from: classes.dex */
    private class f implements p.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.p.a
        public void a(h hVar, boolean z) {
            if (hVar instanceof v) {
                hVar.m().a(false);
            }
            p.a b2 = c.this.b();
            if (b2 != null) {
                b2.a(hVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.p.a
        public boolean a(h hVar) {
            if (hVar == null) {
                return false;
            }
            c.this.D = ((v) hVar).getItem().getItemId();
            p.a b2 = c.this.b();
            if (b2 != null) {
                return b2.a(hVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof q.a) && ((q.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(k kVar, View view, ViewGroup viewGroup) {
        View actionView = kVar.getActionView();
        if (actionView == null || kVar.f()) {
            actionView = super.a(kVar, view, viewGroup);
        }
        actionView.setVisibility(kVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.p
    public void a(Context context, h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        a.a.n.a a2 = a.a.n.a.a(context);
        if (!this.n) {
            this.m = a2.g();
        }
        if (!this.t) {
            this.o = a2.b();
        }
        if (!this.r) {
            this.q = a2.c();
        }
        int i = this.o;
        if (this.m) {
            if (this.j == null) {
                this.j = new d(this.f777b);
                if (this.l) {
                    this.j.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = i;
        this.v = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.x = null;
    }

    public void a(Configuration configuration) {
        if (!this.r) {
            this.q = a.a.n.a.a(this.f778c).c();
        }
        h hVar = this.f779d;
        if (hVar != null) {
            hVar.b(true);
        }
    }

    public void a(Drawable drawable) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.l = true;
        this.k = drawable;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.p
    public void a(h hVar, boolean z) {
        c();
        super.a(hVar, z);
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(k kVar, q.a aVar) {
        aVar.a(kVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    public void a(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.a(this.f779d);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.p
    public void a(boolean z) {
        super.a(z);
        ((View) this.i).requestLayout();
        h hVar = this.f779d;
        boolean z2 = false;
        if (hVar != null) {
            ArrayList<k> c2 = hVar.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                a.g.l.b a2 = c2.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        h hVar2 = this.f779d;
        ArrayList<k> j = hVar2 != null ? hVar2.j() : null;
        if (this.m && j != null) {
            int size2 = j.size();
            if (size2 == 1) {
                z2 = !j.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.j;
        if (z2) {
            if (dVar == null) {
                this.j = new d(this.f777b);
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.j, actionMenuView.e());
            }
        } else if (dVar != null) {
            ViewParent parent = dVar.getParent();
            q qVar = this.i;
            if (parent == qVar) {
                ((ViewGroup) qVar).removeView(this.j);
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        int i;
        ArrayList<k> arrayList;
        int i2;
        int i3;
        c cVar = this;
        h hVar = cVar.f779d;
        int i4 = 0;
        if (hVar != null) {
            arrayList = hVar.n();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i5 = cVar.q;
        int i6 = cVar.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.i;
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            k kVar = arrayList.get(i9);
            if (kVar.k()) {
                i7++;
            } else if (kVar.j()) {
                i8++;
            } else {
                z = true;
            }
            if (cVar.u && kVar.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (cVar.m && (z || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = cVar.w;
        sparseBooleanArray.clear();
        if (cVar.s) {
            int i11 = cVar.v;
            i2 = i6 / i11;
            i3 = i11 + ((i6 % i11) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i12 = i6;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            k kVar2 = arrayList.get(i13);
            if (kVar2.k()) {
                View a2 = cVar.a(kVar2, cVar.x, viewGroup);
                if (cVar.x == null) {
                    cVar.x = a2;
                }
                if (cVar.s) {
                    i2 -= ActionMenuView.a(a2, i3, i2, makeMeasureSpec, i4);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i14 = a2.getMeasuredWidth();
                i12 -= i14;
                if (i14 != 0) {
                    i14 = i14;
                }
                int groupId = kVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                kVar2.d(true);
                i = i;
            } else if (kVar2.j()) {
                int groupId2 = kVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i10 > 0 || z2) && i12 > 0 && (!cVar.s || i2 > 0);
                boolean z4 = z3;
                if (z3) {
                    View a3 = cVar.a(kVar2, cVar.x, viewGroup);
                    i = i;
                    if (cVar.x == null) {
                        cVar.x = a3;
                    }
                    if (cVar.s) {
                        int a4 = ActionMenuView.a(a3, i3, i2, makeMeasureSpec, 0);
                        i2 -= a4;
                        if (a4 == 0) {
                            z4 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth = a3.getMeasuredWidth();
                    i12 -= measuredWidth;
                    if (i14 == 0) {
                        i14 = measuredWidth;
                    }
                    z3 = z4 & (!cVar.s ? i12 + i14 > 0 : i12 >= 0);
                } else {
                    i = i;
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        k kVar3 = arrayList.get(i15);
                        if (kVar3.getGroupId() == groupId2) {
                            if (kVar3.h()) {
                                i10++;
                            }
                            kVar3.d(false);
                        }
                    }
                }
                if (z3) {
                    i10--;
                }
                kVar2.d(z3);
            } else {
                i = i;
                kVar2.d(false);
                i13++;
                i4 = 0;
                cVar = this;
            }
            i13++;
            i4 = 0;
            cVar = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, k kVar) {
        return kVar.h();
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.j) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.p
    public boolean a(v vVar) {
        boolean z = false;
        if (!vVar.hasVisibleItems()) {
            return false;
        }
        v vVar2 = vVar;
        while (vVar2.t() != this.f779d) {
            vVar2 = (v) vVar2.t();
        }
        View a2 = a(vVar2.getItem());
        if (a2 == null) {
            return false;
        }
        vVar.getItem().getItemId();
        int size = vVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = vVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.z = new a(this.f778c, vVar, a2);
        this.z.a(z);
        this.z.e();
        super.a(vVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public q b(ViewGroup viewGroup) {
        q qVar = this.i;
        q b2 = super.b(viewGroup);
        if (qVar != b2) {
            ((ActionMenuView) b2).setPresenter(this);
        }
        return b2;
    }

    public void b(boolean z) {
        this.u = z;
    }

    public void c(boolean z) {
        this.m = z;
        this.n = true;
    }

    public boolean c() {
        return e() | f();
    }

    public Drawable d() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.l) {
            return this.k;
        }
        return null;
    }

    public boolean e() {
        q qVar;
        RunnableC0033c cVar = this.A;
        if (cVar == null || (qVar = this.i) == null) {
            e eVar = this.y;
            if (eVar == null) {
                return false;
            }
            eVar.a();
            return true;
        }
        ((View) qVar).removeCallbacks(cVar);
        this.A = null;
        return true;
    }

    public boolean f() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    public boolean g() {
        return this.A != null || h();
    }

    public boolean h() {
        e eVar = this.y;
        return eVar != null && eVar.c();
    }

    public boolean i() {
        h hVar;
        if (!this.m || h() || (hVar = this.f779d) == null || this.i == null || this.A != null || hVar.j().isEmpty()) {
            return false;
        }
        this.A = new RunnableC0033c(new e(this.f778c, this.f779d, this.j, true));
        ((View) this.i).post(this.A);
        super.a((v) null);
        return true;
    }
}
