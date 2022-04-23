package androidx.recyclerview.widget;

import a.g.l.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends n {
    private static TimeInterpolator s;
    private ArrayList<RecyclerView.d0> h = new ArrayList<>();
    private ArrayList<RecyclerView.d0> i = new ArrayList<>();
    private ArrayList<j> j = new ArrayList<>();
    private ArrayList<i> k = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.d0>> l = new ArrayList<>();
    ArrayList<ArrayList<j>> m = new ArrayList<>();
    ArrayList<ArrayList<i>> n = new ArrayList<>();
    ArrayList<RecyclerView.d0> o = new ArrayList<>();
    ArrayList<RecyclerView.d0> p = new ArrayList<>();
    ArrayList<RecyclerView.d0> q = new ArrayList<>();
    ArrayList<RecyclerView.d0> r = new ArrayList<>();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1427b;

        a(ArrayList arrayList) {
            this.f1427b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1427b.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.b(jVar.f1458a, jVar.f1459b, jVar.f1460c, jVar.f1461d, jVar.f1462e);
            }
            this.f1427b.clear();
            c.this.m.remove(this.f1427b);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1429b;

        b(ArrayList arrayList) {
            this.f1429b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1429b.iterator();
            while (it.hasNext()) {
                c.this.a((i) it.next());
            }
            this.f1429b.clear();
            c.this.n.remove(this.f1429b);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0045c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f1431b;

        RunnableC0045c(ArrayList arrayList) {
            this.f1431b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1431b.iterator();
            while (it.hasNext()) {
                c.this.t((RecyclerView.d0) it.next());
            }
            this.f1431b.clear();
            c.this.l.remove(this.f1431b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1433b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1434c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1435d;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1433b = d0Var;
            this.f1434c = viewPropertyAnimator;
            this.f1435d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1434c.setListener(null);
            this.f1435d.setAlpha(1.0f);
            c.this.l(this.f1433b);
            c.this.q.remove(this.f1433b);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.m(this.f1433b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1437b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f1438c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1439d;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1437b = d0Var;
            this.f1438c = view;
            this.f1439d = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1438c.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1439d.setListener(null);
            c.this.h(this.f1437b);
            c.this.o.remove(this.f1437b);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.i(this.f1437b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1441b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1442c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1443d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f1444e;
        final /* synthetic */ ViewPropertyAnimator f;

        f(RecyclerView.d0 d0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1441b = d0Var;
            this.f1442c = i;
            this.f1443d = view;
            this.f1444e = i2;
            this.f = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1442c != 0) {
                this.f1443d.setTranslationX(0.0f);
            }
            if (this.f1444e != 0) {
                this.f1443d.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f.setListener(null);
            c.this.j(this.f1441b);
            c.this.p.remove(this.f1441b);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.k(this.f1441b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f1445b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1446c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1447d;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1445b = iVar;
            this.f1446c = viewPropertyAnimator;
            this.f1447d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1446c.setListener(null);
            this.f1447d.setAlpha(1.0f);
            this.f1447d.setTranslationX(0.0f);
            this.f1447d.setTranslationY(0.0f);
            c.this.a(this.f1445b.f1453a, true);
            c.this.r.remove(this.f1445b.f1453a);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.b(this.f1445b.f1453a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f1449b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1450c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f1451d;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1449b = iVar;
            this.f1450c = viewPropertyAnimator;
            this.f1451d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1450c.setListener(null);
            this.f1451d.setAlpha(1.0f);
            this.f1451d.setTranslationX(0.0f);
            this.f1451d.setTranslationY(0.0f);
            c.this.a(this.f1449b.f1454b, false);
            c.this.r.remove(this.f1449b.f1454b);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.b(this.f1449b.f1454b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f1453a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.d0 f1454b;

        /* renamed from: c  reason: collision with root package name */
        public int f1455c;

        /* renamed from: d  reason: collision with root package name */
        public int f1456d;

        /* renamed from: e  reason: collision with root package name */
        public int f1457e;
        public int f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f1453a = d0Var;
            this.f1454b = d0Var2;
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4) {
            this(d0Var, d0Var2);
            this.f1455c = i;
            this.f1456d = i2;
            this.f1457e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1453a + ", newHolder=" + this.f1454b + ", fromX=" + this.f1455c + ", fromY=" + this.f1456d + ", toX=" + this.f1457e + ", toY=" + this.f + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f1458a;

        /* renamed from: b  reason: collision with root package name */
        public int f1459b;

        /* renamed from: c  reason: collision with root package name */
        public int f1460c;

        /* renamed from: d  reason: collision with root package name */
        public int f1461d;

        /* renamed from: e  reason: collision with root package name */
        public int f1462e;

        j(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
            this.f1458a = d0Var;
            this.f1459b = i;
            this.f1460c = i2;
            this.f1461d = i3;
            this.f1462e = i4;
        }
    }

    private void a(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (a(iVar, d0Var) && iVar.f1453a == null && iVar.f1454b == null) {
                list.remove(iVar);
            }
        }
    }

    private boolean a(i iVar, RecyclerView.d0 d0Var) {
        boolean z = false;
        if (iVar.f1454b == d0Var) {
            iVar.f1454b = null;
        } else if (iVar.f1453a != d0Var) {
            return false;
        } else {
            iVar.f1453a = null;
            z = true;
        }
        d0Var.f1346a.setAlpha(1.0f);
        d0Var.f1346a.setTranslationX(0.0f);
        d0Var.f1346a.setTranslationY(0.0f);
        a(d0Var, z);
        return true;
    }

    private void b(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1453a;
        if (d0Var != null) {
            a(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f1454b;
        if (d0Var2 != null) {
            a(iVar, d0Var2);
        }
    }

    private void u(RecyclerView.d0 d0Var) {
        View view = d0Var.f1346a;
        ViewPropertyAnimator animate = view.animate();
        this.q.add(d0Var);
        animate.setDuration(f()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    private void v(RecyclerView.d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.f1346a.animate().setInterpolator(s);
        c(d0Var);
    }

    void a(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1453a;
        View view = null;
        View view2 = d0Var == null ? null : d0Var.f1346a;
        RecyclerView.d0 d0Var2 = iVar.f1454b;
        if (d0Var2 != null) {
            view = d0Var2.f1346a;
        }
        if (view2 != null) {
            ViewPropertyAnimator duration = view2.animate().setDuration(d());
            this.r.add(iVar.f1453a);
            duration.translationX(iVar.f1457e - iVar.f1455c);
            duration.translationY(iVar.f - iVar.f1456d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view2)).start();
        }
        if (view != null) {
            ViewPropertyAnimator animate = view.animate();
            this.r.add(iVar.f1454b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(d()).alpha(1.0f).setListener(new h(iVar, animate, view)).start();
        }
    }

    void a(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1346a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.n
    public boolean a(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.f1346a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) d0Var.f1346a.getTranslationY());
        v(d0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(d0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.j.add(new j(d0Var, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.n
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
        if (d0Var == d0Var2) {
            return a(d0Var, i2, i3, i4, i5);
        }
        float translationX = d0Var.f1346a.getTranslationX();
        float translationY = d0Var.f1346a.getTranslationY();
        float alpha = d0Var.f1346a.getAlpha();
        v(d0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        d0Var.f1346a.setTranslationX(translationX);
        d0Var.f1346a.setTranslationY(translationY);
        d0Var.f1346a.setAlpha(alpha);
        if (d0Var2 != null) {
            v(d0Var2);
            d0Var2.f1346a.setTranslationX(-i6);
            d0Var2.f1346a.setTranslationY(-i7);
            d0Var2.f1346a.setAlpha(0.0f);
        }
        this.k.add(new i(d0Var, d0Var2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.a(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void b() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.j.get(size);
            View view = jVar.f1458a.f1346a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(jVar.f1458a);
            this.j.remove(size);
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            l(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.i.get(size3);
            d0Var.f1346a.setAlpha(1.0f);
            h(d0Var);
            this.i.remove(size3);
        }
        for (int size4 = this.k.size() - 1; size4 >= 0; size4--) {
            b(this.k.get(size4));
        }
        this.k.clear();
        if (g()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f1458a.f1346a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(jVar2.f1458a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f1346a.setAlpha(1.0f);
                    h(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            a(this.q);
            a(this.p);
            a(this.o);
            a(this.r);
            a();
        }
    }

    void b(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.f1346a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.p.add(d0Var);
        animate.setDuration(e()).setListener(new f(d0Var, i6, view, i7, animate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void c(RecyclerView.d0 d0Var) {
        View view = d0Var.f1346a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).f1458a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(d0Var);
                this.j.remove(size);
            }
        }
        a(this.k, d0Var);
        if (this.h.remove(d0Var)) {
            view.setAlpha(1.0f);
            l(d0Var);
        }
        if (this.i.remove(d0Var)) {
            view.setAlpha(1.0f);
            h(d0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.n.get(size2);
            a(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f1458a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                h(d0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(d0Var);
        this.o.remove(d0Var);
        this.r.remove(d0Var);
        this.p.remove(d0Var);
        j();
    }

    @Override // androidx.recyclerview.widget.n
    public boolean f(RecyclerView.d0 d0Var) {
        v(d0Var);
        d0Var.f1346a.setAlpha(0.0f);
        this.i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.n
    public boolean g(RecyclerView.d0 d0Var) {
        v(d0Var);
        this.h.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void i() {
        boolean z = !this.h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.d0> it = this.h.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.h.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    s.a(arrayList.get(0).f1458a.f1346a, aVar, f());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    s.a(arrayList2.get(0).f1453a.f1346a, bVar, f());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.i);
                this.l.add(arrayList3);
                this.i.clear();
                RunnableC0045c cVar = new RunnableC0045c(arrayList3);
                if (z || z2 || z3) {
                    long j2 = 0;
                    long f2 = z ? f() : 0L;
                    long e2 = z2 ? e() : 0L;
                    if (z3) {
                        j2 = d();
                    }
                    s.a(arrayList3.get(0).f1346a, cVar, f2 + Math.max(e2, j2));
                    return;
                }
                cVar.run();
            }
        }
    }

    void j() {
        if (!g()) {
            a();
        }
    }

    void t(RecyclerView.d0 d0Var) {
        View view = d0Var.f1346a;
        ViewPropertyAnimator animate = view.animate();
        this.o.add(d0Var);
        animate.alpha(1.0f).setDuration(c()).setListener(new e(d0Var, view, animate)).start();
    }
}
