package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements p {

    /* renamed from: b  reason: collision with root package name */
    protected Context f777b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f778c;

    /* renamed from: d  reason: collision with root package name */
    protected h f779d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f780e;
    private p.a f;
    private int g;
    private int h;
    protected q i;

    public b(Context context, int i, int i2) {
        this.f777b = context;
        this.f780e = LayoutInflater.from(context);
        this.g = i;
        this.h = i2;
    }

    public View a(k kVar, View view, ViewGroup viewGroup) {
        q.a a2 = view instanceof q.a ? (q.a) view : a(viewGroup);
        a(kVar, a2);
        return (View) a2;
    }

    public q.a a(ViewGroup viewGroup) {
        return (q.a) this.f780e.inflate(this.h, viewGroup, false);
    }

    public void a(int i) {
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(Context context, h hVar) {
        this.f778c = context;
        LayoutInflater.from(this.f778c);
        this.f779d = hVar;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(h hVar, boolean z) {
        p.a aVar = this.f;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public abstract void a(k kVar, q.a aVar);

    @Override // androidx.appcompat.view.menu.p
    public void a(p.a aVar) {
        this.f = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup != null) {
            h hVar = this.f779d;
            int i = 0;
            if (hVar != null) {
                hVar.b();
                ArrayList<k> n = this.f779d.n();
                int size = n.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    k kVar = n.get(i3);
                    if (a(i2, kVar)) {
                        View childAt = viewGroup.getChildAt(i2);
                        k itemData = childAt instanceof q.a ? ((q.a) childAt).getItemData() : null;
                        View a2 = a(kVar, childAt, viewGroup);
                        if (kVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public abstract boolean a(int i, k kVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a(h hVar, k kVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a(v vVar) {
        p.a aVar = this.f;
        if (aVar != null) {
            return aVar.a(vVar);
        }
        return false;
    }

    public p.a b() {
        return this.f;
    }

    public q b(ViewGroup viewGroup) {
        if (this.i == null) {
            this.i = (q) this.f780e.inflate(this.g, viewGroup, false);
            this.i.a(this.f779d);
            a(true);
        }
        return this.i;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean b(h hVar, k kVar) {
        return false;
    }
}
