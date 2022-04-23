package androidx.appcompat.view.menu;

import a.a.g;
import android.content.Context;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f implements p, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    Context f798b;

    /* renamed from: c  reason: collision with root package name */
    LayoutInflater f799c;

    /* renamed from: d  reason: collision with root package name */
    h f800d;

    /* renamed from: e  reason: collision with root package name */
    ExpandedMenuView f801e;
    int f;
    int g;
    int h;
    private p.a i;
    a j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f802b = -1;

        public a() {
            a();
        }

        void a() {
            k f = f.this.f800d.f();
            if (f != null) {
                ArrayList<k> j = f.this.f800d.j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (j.get(i) == f) {
                        this.f802b = i;
                        return;
                    }
                }
            }
            this.f802b = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = f.this.f800d.j().size() - f.this.f;
            return this.f802b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public k getItem(int i) {
            ArrayList<k> j = f.this.f800d.j();
            int i2 = i + f.this.f;
            int i3 = this.f802b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return j.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                f fVar = f.this;
                view = fVar.f799c.inflate(fVar.h, viewGroup, false);
            }
            ((q.a) view).a(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public f(int i, int i2) {
        this.h = i;
        this.g = i2;
    }

    public f(Context context, int i) {
        this(i, 0);
        this.f798b = context;
        this.f799c = LayoutInflater.from(this.f798b);
    }

    public q a(ViewGroup viewGroup) {
        if (this.f801e == null) {
            this.f801e = (ExpandedMenuView) this.f799c.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.j == null) {
                this.j = new a();
            }
            this.f801e.setAdapter((ListAdapter) this.j);
            this.f801e.setOnItemClickListener(this);
        }
        return this.f801e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r2.f799c == null) goto L_0x000b;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.view.menu.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r3, androidx.appcompat.view.menu.h r4) {
        /*
            r2 = this;
            int r0 = r2.g
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r1 = new android.view.ContextThemeWrapper
            r1.<init>(r3, r0)
            r2.f798b = r1
        L_0x000b:
            android.content.Context r3 = r2.f798b
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r2.f799c = r3
            goto L_0x001f
        L_0x0014:
            android.content.Context r0 = r2.f798b
            if (r0 == 0) goto L_0x001f
            r2.f798b = r3
            android.view.LayoutInflater r3 = r2.f799c
            if (r3 != 0) goto L_0x001f
            goto L_0x000b
        L_0x001f:
            r2.f800d = r4
            androidx.appcompat.view.menu.f$a r3 = r2.j
            if (r3 == 0) goto L_0x0028
            r3.notifyDataSetChanged()
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.f.a(android.content.Context, androidx.appcompat.view.menu.h):void");
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(h hVar, boolean z) {
        p.a aVar = this.i;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(p.a aVar) {
        this.i = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a(h hVar, k kVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a(v vVar) {
        if (!vVar.hasVisibleItems()) {
            return false;
        }
        new i(vVar).a((IBinder) null);
        p.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.a(vVar);
        return true;
    }

    public ListAdapter b() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean b(h hVar, k kVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f800d.a(this.j.getItem(i), this, 0);
    }
}
