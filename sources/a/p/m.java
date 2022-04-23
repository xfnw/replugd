package a.p;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] H = {2, 1, 3, 4};
    private static final g I = new a();
    private static ThreadLocal<a.d.a<Animator, d>> J = new ThreadLocal<>();
    p D;
    private e E;
    private a.d.a<String, String> F;
    private ArrayList<s> u;
    private ArrayList<s> v;

    /* renamed from: b  reason: collision with root package name */
    private String f578b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private long f579c = -1;

    /* renamed from: d  reason: collision with root package name */
    long f580d = -1;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f581e = null;
    ArrayList<Integer> f = new ArrayList<>();
    ArrayList<View> g = new ArrayList<>();
    private ArrayList<String> h = null;
    private ArrayList<Class> i = null;
    private ArrayList<Integer> j = null;
    private ArrayList<View> k = null;
    private ArrayList<Class> l = null;
    private ArrayList<String> m = null;
    private ArrayList<Integer> n = null;
    private ArrayList<View> o = null;
    private ArrayList<Class> p = null;
    private t q = new t();
    private t r = new t();
    q s = null;
    private int[] t = H;
    boolean w = false;
    ArrayList<Animator> x = new ArrayList<>();
    private int y = 0;
    private boolean z = false;
    private boolean A = false;
    private ArrayList<f> B = null;
    private ArrayList<Animator> C = new ArrayList<>();
    private g G = I;

    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // a.p.g
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.d.a f582b;

        b(a.d.a aVar) {
            this.f582b = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f582b.remove(animator);
            m.this.x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.x.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.a();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f585a;

        /* renamed from: b  reason: collision with root package name */
        String f586b;

        /* renamed from: c  reason: collision with root package name */
        s f587c;

        /* renamed from: d  reason: collision with root package name */
        l0 f588d;

        /* renamed from: e  reason: collision with root package name */
        m f589e;

        d(View view, String str, m mVar, l0 l0Var, s sVar) {
            this.f585a = view;
            this.f586b = str;
            this.f587c = sVar;
            this.f588d = l0Var;
            this.f589e = mVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);
    }

    private void a(a.d.a<View, s> aVar, a.d.a<View, s> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            s d2 = aVar.d(i);
            if (b(d2.f603b)) {
                this.u.add(d2);
                this.v.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            s d3 = aVar2.d(i2);
            if (b(d3.f603b)) {
                this.v.add(d3);
                this.u.add(null);
            }
        }
    }

    private void a(a.d.a<View, s> aVar, a.d.a<View, s> aVar2, a.d.a<String, View> aVar3, a.d.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View d2 = aVar3.d(i);
            if (d2 != null && b(d2) && (view = aVar4.get(aVar3.b(i))) != null && b(view)) {
                s sVar = aVar.get(d2);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(d2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(a.d.a<View, s> aVar, a.d.a<View, s> aVar2, a.d.d<View> dVar, a.d.d<View> dVar2) {
        View c2;
        int b2 = dVar.b();
        for (int i = 0; i < b2; i++) {
            View c3 = dVar.c(i);
            if (c3 != null && b(c3) && (c2 = dVar2.c(dVar.a(i))) != null && b(c2)) {
                s sVar = aVar.get(c3);
                s sVar2 = aVar2.get(c2);
                if (!(sVar == null || sVar2 == null)) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(c3);
                    aVar2.remove(c2);
                }
            }
        }
    }

    private void a(a.d.a<View, s> aVar, a.d.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && b(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(t tVar, t tVar2) {
        a.d.a<View, s> aVar = new a.d.a<>(tVar.f605a);
        a.d.a<View, s> aVar2 = new a.d.a<>(tVar2.f605a);
        int i = 0;
        while (true) {
            int[] iArr = this.t;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    b(aVar, aVar2);
                } else if (i2 == 2) {
                    a(aVar, aVar2, tVar.f608d, tVar2.f608d);
                } else if (i2 == 3) {
                    a(aVar, aVar2, tVar.f606b, tVar2.f606b);
                } else if (i2 == 4) {
                    a(aVar, aVar2, tVar.f607c, tVar2.f607c);
                }
                i++;
            } else {
                a(aVar, aVar2);
                return;
            }
        }
    }

    private static void a(t tVar, View view, s sVar) {
        tVar.f605a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f606b.indexOfKey(id) >= 0) {
                tVar.f606b.put(id, null);
            } else {
                tVar.f606b.put(id, view);
            }
        }
        String o = s.o(view);
        if (o != null) {
            if (tVar.f608d.containsKey(o)) {
                tVar.f608d.put(o, null);
            } else {
                tVar.f608d.put(o, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f607c.d(itemIdAtPosition) >= 0) {
                    View c2 = tVar.f607c.c(itemIdAtPosition);
                    if (c2 != null) {
                        s.b(c2, false);
                        tVar.f607c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                s.b(view, true);
                tVar.f607c.c(itemIdAtPosition, view);
            }
        }
    }

    private void a(Animator animator, a.d.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            a(animator);
        }
    }

    private static boolean a(s sVar, s sVar2, String str) {
        Object obj = sVar.f602a.get(str);
        Object obj2 = sVar2.f602a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void b(a.d.a<View, s> aVar, a.d.a<View, s> aVar2) {
        s remove;
        View view;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (!(b2 == null || !b(b2) || (remove = aVar2.remove(b2)) == null || (view = remove.f603b) == null || !b(view))) {
                this.u.add(aVar.c(size));
                this.v.add(remove);
            }
        }
    }

    private void c(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.j;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.k;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.l;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        for (int i = 0; i < size; i++) {
                            if (this.l.get(i).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        s sVar = new s();
                        sVar.f603b = view;
                        if (z) {
                            c(sVar);
                        } else {
                            a(sVar);
                        }
                        sVar.f604c.add(this);
                        b(sVar);
                        a(z ? this.q : this.r, view, sVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.n;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.o;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.p;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        if (this.p.get(i2).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    c(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static a.d.a<Animator, d> q() {
        a.d.a<Animator, d> aVar = J.get();
        if (aVar != null) {
            return aVar;
        }
        a.d.a<Animator, d> aVar2 = new a.d.a<>();
        J.set(aVar2);
        return aVar2;
    }

    public m a(long j) {
        this.f580d = j;
        return this;
    }

    public m a(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(fVar);
        return this;
    }

    public m a(TimeInterpolator timeInterpolator) {
        this.f581e = timeInterpolator;
        return this;
    }

    public m a(View view) {
        this.g.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s a(View view, boolean z) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.a(view, z);
        }
        ArrayList<s> arrayList = z ? this.u : this.v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            s sVar = arrayList.get(i2);
            if (sVar == null) {
                return null;
            }
            if (sVar.f603b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < 0) {
            return null;
        }
        return (z ? this.v : this.u).get(i);
    }

    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f580d != -1) {
            str2 = str2 + "dur(" + this.f580d + ") ";
        }
        if (this.f579c != -1) {
            str2 = str2 + "dly(" + this.f579c + ") ";
        }
        if (this.f581e != null) {
            str2 = str2 + "interp(" + this.f581e + ") ";
        }
        if (this.f.size() <= 0 && this.g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.f.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.f.get(i);
            }
            str3 = str4;
        }
        if (this.g.size() > 0) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.g.get(i2);
            }
        }
        return str3 + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.y--;
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).d(this);
                }
            }
            for (int i2 = 0; i2 < this.q.f607c.b(); i2++) {
                View c2 = this.q.f607c.c(i2);
                if (c2 != null) {
                    s.b(c2, false);
                }
            }
            for (int i3 = 0; i3 < this.r.f607c.b(); i3++) {
                View c3 = this.r.f607c.c(i3);
                if (c3 != null) {
                    s.b(c3, false);
                }
            }
            this.A = true;
        }
    }

    public void a(g gVar) {
        if (gVar == null) {
            gVar = I;
        }
        this.G = gVar;
    }

    public void a(e eVar) {
        this.E = eVar;
    }

    public void a(p pVar) {
        this.D = pVar;
    }

    public abstract void a(s sVar);

    protected void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (h() >= 0) {
            animator.setStartDelay(h());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        d dVar;
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        a(this.q, this.r);
        a.d.a<Animator, d> q = q();
        int size = q.size();
        l0 d2 = d0.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator b2 = q.b(i);
            if (!(b2 == null || (dVar = q.get(b2)) == null || dVar.f585a == null || !d2.equals(dVar.f588d))) {
                s sVar = dVar.f587c;
                View view = dVar.f585a;
                s b3 = b(view, true);
                s a2 = a(view, true);
                if (!(b3 == null && a2 == null) && dVar.f589e.a(sVar, a2)) {
                    if (b2.isRunning() || b2.isStarted()) {
                        b2.cancel();
                    } else {
                        q.remove(b2);
                    }
                }
            }
        }
        a(viewGroup, this.q, this.r, this.u, this.v);
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        Animator a2;
        View view;
        Animator animator;
        s sVar;
        a.d.a<Animator, d> q = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i = 0;
        while (i < size) {
            s sVar2 = arrayList.get(i);
            s sVar3 = arrayList2.get(i);
            if (sVar2 != null && !sVar2.f604c.contains(this)) {
                sVar2 = null;
            }
            if (sVar3 != null && !sVar3.f604c.contains(this)) {
                sVar3 = null;
            }
            if (!(sVar2 == null && sVar3 == null)) {
                if ((sVar2 == null || sVar3 == null || a(sVar2, sVar3)) && (a2 = a(viewGroup, sVar2, sVar3)) != null) {
                    if (sVar3 != null) {
                        view = sVar3.f603b;
                        String[] n = n();
                        if (view == null || n == null || n.length <= 0) {
                            size = size;
                            i = i;
                            animator = a2;
                            sVar = null;
                        } else {
                            sVar = new s();
                            sVar.f603b = view;
                            size = size;
                            s sVar4 = tVar2.f605a.get(view);
                            if (sVar4 != null) {
                                int i2 = 0;
                                while (i2 < n.length) {
                                    sVar.f602a.put(n[i2], sVar4.f602a.get(n[i2]));
                                    i2++;
                                    i = i;
                                    sVar4 = sVar4;
                                }
                            }
                            int size2 = q.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    animator = a2;
                                    break;
                                }
                                d dVar = q.get(q.b(i3));
                                if (dVar.f587c != null && dVar.f585a == view && dVar.f586b.equals(e()) && dVar.f587c.equals(sVar)) {
                                    animator = null;
                                    break;
                                }
                                i3++;
                            }
                        }
                    } else {
                        size = size;
                        i = i;
                        view = sVar2.f603b;
                        animator = a2;
                        sVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.D;
                        if (pVar != null) {
                            long a3 = pVar.a(viewGroup, this, sVar2, sVar3);
                            sparseIntArray.put(this.C.size(), (int) a3);
                            j = Math.min(a3, j);
                        }
                        q.put(animator, new d(view, e(), this, d0.d(viewGroup), sVar));
                        this.C.add(animator);
                    }
                    i++;
                }
            }
            size = size;
            i = i;
            i++;
        }
        if (j != 0) {
            for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                Animator animator2 = this.C.get(sparseIntArray.keyAt(i4));
                animator2.setStartDelay((sparseIntArray.valueAt(i4) - j) + animator2.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z) {
        a.d.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        a(z);
        if ((this.f.size() > 0 || this.g.size() > 0) && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.i) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.f.size(); i++) {
                View findViewById = viewGroup.findViewById(this.f.get(i).intValue());
                if (findViewById != null) {
                    s sVar = new s();
                    sVar.f603b = findViewById;
                    if (z) {
                        c(sVar);
                    } else {
                        a(sVar);
                    }
                    sVar.f604c.add(this);
                    b(sVar);
                    a(z ? this.q : this.r, findViewById, sVar);
                }
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                View view = this.g.get(i2);
                s sVar2 = new s();
                sVar2.f603b = view;
                if (z) {
                    c(sVar2);
                } else {
                    a(sVar2);
                }
                sVar2.f604c.add(this);
                b(sVar2);
                a(z ? this.q : this.r, view, sVar2);
            }
        } else {
            c(viewGroup, z);
        }
        if (!(z || (aVar = this.F) == null)) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(this.q.f608d.remove(this.F.b(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList3.get(i4);
                if (view2 != null) {
                    this.q.f608d.put(this.F.d(i4), view2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        t tVar;
        if (z) {
            this.q.f605a.clear();
            this.q.f606b.clear();
            tVar = this.q;
        } else {
            this.r.f605a.clear();
            this.r.f606b.clear();
            tVar = this.r;
        }
        tVar.f607c.a();
    }

    public boolean a(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] n = n();
        if (n != null) {
            for (String str : n) {
                if (!a(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : sVar.f602a.keySet()) {
            if (a(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public long b() {
        return this.f580d;
    }

    public m b(long j) {
        this.f579c = j;
        return this;
    }

    public m b(f fVar) {
        ArrayList<f> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public s b(View view, boolean z) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.b(view, z);
        }
        return (z ? this.q : this.r).f605a.get(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(s sVar) {
        String[] a2;
        if (this.D != null && !sVar.f602a.isEmpty() && (a2 = this.D.a()) != null) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= a2.length) {
                    z = true;
                    break;
                } else if (!sVar.f602a.containsKey(a2[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.D.a(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.l.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.m == null || s.o(view) == null || !this.m.contains(s.o(view)))) {
            return false;
        }
        if ((this.f.size() == 0 && this.g.size() == 0 && (((arrayList = this.i) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) || this.f.contains(Integer.valueOf(id)) || this.g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.h;
        if (arrayList6 != null && arrayList6.contains(s.o(view))) {
            return true;
        }
        if (this.i != null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (this.i.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public e c() {
        return this.E;
    }

    public abstract void c(s sVar);

    public void c(View view) {
        if (!this.A) {
            a.d.a<Animator, d> q = q();
            int size = q.size();
            l0 d2 = d0.d(view);
            for (int i = size - 1; i >= 0; i--) {
                d d3 = q.d(i);
                if (d3.f585a != null && d2.equals(d3.f588d)) {
                    a.p.a.a(q.b(i));
                }
            }
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((f) arrayList2.get(i2)).a(this);
                }
            }
            this.z = true;
        }
    }

    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.C = new ArrayList<>();
            mVar.q = new t();
            mVar.r = new t();
            mVar.u = null;
            mVar.v = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public m d(View view) {
        this.g.remove(view);
        return this;
    }

    public TimeInterpolator d() {
        return this.f581e;
    }

    public String e() {
        return this.f578b;
    }

    public void e(View view) {
        if (this.z) {
            if (!this.A) {
                a.d.a<Animator, d> q = q();
                int size = q.size();
                l0 d2 = d0.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    d d3 = q.d(i);
                    if (d3.f585a != null && d2.equals(d3.f588d)) {
                        a.p.a.b(q.b(i));
                    }
                }
                ArrayList<f> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((f) arrayList2.get(i2)).b(this);
                    }
                }
            }
            this.z = false;
        }
    }

    public g f() {
        return this.G;
    }

    public p g() {
        return this.D;
    }

    public long h() {
        return this.f579c;
    }

    public List<Integer> i() {
        return this.f;
    }

    public List<String> j() {
        return this.h;
    }

    public List<Class> k() {
        return this.i;
    }

    public List<View> l() {
        return this.g;
    }

    public String[] n() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        p();
        a.d.a<Animator, d> q = q();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q.containsKey(next)) {
                p();
                a(next, q);
            }
        }
        this.C.clear();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).c(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public String toString() {
        return a("");
    }
}
