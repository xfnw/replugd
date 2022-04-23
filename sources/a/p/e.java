package a.p;

import a.k.a.p;
import a.p.m;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends p {

    /* loaded from: classes.dex */
    class a extends m.e {
        a(e eVar, Rect rect) {
        }
    }

    /* loaded from: classes.dex */
    class b implements m.f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f546b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f547c;

        b(e eVar, View view, ArrayList arrayList) {
            this.f546b = view;
            this.f547c = arrayList;
        }

        @Override // a.p.m.f
        public void a(m mVar) {
        }

        @Override // a.p.m.f
        public void b(m mVar) {
        }

        @Override // a.p.m.f
        public void c(m mVar) {
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            mVar.b(this);
            this.f546b.setVisibility(8);
            int size = this.f547c.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f547c.get(i)).setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements m.f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f548b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f549c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f550d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f551e;
        final /* synthetic */ Object f;
        final /* synthetic */ ArrayList g;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f548b = obj;
            this.f549c = arrayList;
            this.f550d = obj2;
            this.f551e = arrayList2;
            this.f = obj3;
            this.g = arrayList3;
        }

        @Override // a.p.m.f
        public void a(m mVar) {
        }

        @Override // a.p.m.f
        public void b(m mVar) {
        }

        @Override // a.p.m.f
        public void c(m mVar) {
            Object obj = this.f548b;
            if (obj != null) {
                e.this.a(obj, this.f549c, (ArrayList<View>) null);
            }
            Object obj2 = this.f550d;
            if (obj2 != null) {
                e.this.a(obj2, this.f551e, (ArrayList<View>) null);
            }
            Object obj3 = this.f;
            if (obj3 != null) {
                e.this.a(obj3, this.g, (ArrayList<View>) null);
            }
        }

        @Override // a.p.m.f
        public void d(m mVar) {
        }
    }

    /* loaded from: classes.dex */
    class d extends m.e {
        d(e eVar, Rect rect) {
        }
    }

    private static boolean a(m mVar) {
        return !p.a((List) mVar.i()) || !p.a((List) mVar.j()) || !p.a((List) mVar.k());
    }

    @Override // a.k.a.p
    public Object a(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            q qVar = new q();
            qVar.a(mVar);
            qVar.a(mVar2);
            qVar.b(1);
            mVar = qVar;
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar2 = new q();
        if (mVar != null) {
            qVar2.a(mVar);
        }
        qVar2.a(mVar3);
        return qVar2;
    }

    @Override // a.k.a.p
    public void a(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // a.k.a.p
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).a(new d(this, rect));
        }
    }

    @Override // a.k.a.p
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).a(view);
        }
    }

    @Override // a.k.a.p
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // a.k.a.p
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // a.k.a.p
    public void a(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar != null) {
            int i = 0;
            if (mVar instanceof q) {
                q qVar = (q) mVar;
                int q = qVar.q();
                while (i < q) {
                    a(qVar.a(i), arrayList);
                    i++;
                }
            } else if (!a(mVar) && p.a((List) mVar.l())) {
                int size = arrayList.size();
                while (i < size) {
                    mVar.a(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    @Override // a.k.a.p
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int q = qVar.q();
            while (i < q) {
                a((Object) qVar.a(i), arrayList, arrayList2);
                i++;
            }
        } else if (!a(mVar)) {
            List<View> l = mVar.l();
            if (l.size() == arrayList.size() && l.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    mVar.a(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    mVar.d(arrayList.get(size2));
                }
            }
        }
    }

    @Override // a.k.a.p
    public boolean a(Object obj) {
        return obj instanceof m;
    }

    @Override // a.k.a.p
    public Object b(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // a.k.a.p
    public Object b(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.a((m) obj);
        }
        if (obj2 != null) {
            qVar.a((m) obj2);
        }
        if (obj3 != null) {
            qVar.a((m) obj3);
        }
        return qVar;
    }

    @Override // a.k.a.p
    public void b(Object obj, View view) {
        if (obj != null) {
            ((m) obj).d(view);
        }
    }

    @Override // a.k.a.p
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> l = qVar.l();
        l.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            p.a(l, arrayList.get(i));
        }
        l.add(view);
        arrayList.add(view);
        a(qVar, arrayList);
    }

    @Override // a.k.a.p
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.l().clear();
            qVar.l().addAll(arrayList2);
            a((Object) qVar, arrayList, arrayList2);
        }
    }

    @Override // a.k.a.p
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.a((m) obj);
        return qVar;
    }

    @Override // a.k.a.p
    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((m) obj).a(new a(this, rect));
        }
    }
}
