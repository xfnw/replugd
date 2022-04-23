package a.k.a;

import a.g.l.s;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f453a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final p f454b;

    /* renamed from: c  reason: collision with root package name */
    private static final p f455c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f456b;

        a(ArrayList arrayList) {
            this.f456b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a(this.f456b, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f457b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p f458c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f459d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a.k.a.c f460e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ ArrayList g;
        final /* synthetic */ ArrayList h;
        final /* synthetic */ Object i;

        b(Object obj, p pVar, View view, a.k.a.c cVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f457b = obj;
            this.f458c = pVar;
            this.f459d = view;
            this.f460e = cVar;
            this.f = arrayList;
            this.g = arrayList2;
            this.h = arrayList3;
            this.i = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f457b;
            if (obj != null) {
                this.f458c.b(obj, this.f459d);
                this.g.addAll(n.a(this.f458c, this.f457b, this.f460e, this.f, this.f459d));
            }
            if (this.h != null) {
                if (this.i != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f459d);
                    this.f458c.a(this.i, this.h, arrayList);
                }
                this.h.clear();
                this.h.add(this.f459d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.k.a.c f461b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.k.a.c f462c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f463d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a.d.a f464e;
        final /* synthetic */ View f;
        final /* synthetic */ p g;
        final /* synthetic */ Rect h;

        c(a.k.a.c cVar, a.k.a.c cVar2, boolean z, a.d.a aVar, View view, p pVar, Rect rect) {
            this.f461b = cVar;
            this.f462c = cVar2;
            this.f463d = z;
            this.f464e = aVar;
            this.f = view;
            this.g = pVar;
            this.h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a(this.f461b, this.f462c, this.f463d, (a.d.a<String, View>) this.f464e, false);
            View view = this.f;
            if (view != null) {
                this.g.a(view, this.h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f465b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.d.a f466c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f467d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ e f468e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ View g;
        final /* synthetic */ a.k.a.c h;
        final /* synthetic */ a.k.a.c i;
        final /* synthetic */ boolean j;
        final /* synthetic */ ArrayList k;
        final /* synthetic */ Object l;
        final /* synthetic */ Rect m;

        d(p pVar, a.d.a aVar, Object obj, e eVar, ArrayList arrayList, View view, a.k.a.c cVar, a.k.a.c cVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f465b = pVar;
            this.f466c = aVar;
            this.f467d = obj;
            this.f468e = eVar;
            this.f = arrayList;
            this.g = view;
            this.h = cVar;
            this.i = cVar2;
            this.j = z;
            this.k = arrayList2;
            this.l = obj2;
            this.m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d.a<String, View> a2 = n.a(this.f465b, this.f466c, this.f467d, this.f468e);
            if (a2 != null) {
                this.f.addAll(a2.values());
                this.f.add(this.g);
            }
            n.a(this.h, this.i, this.j, a2, false);
            Object obj = this.f467d;
            if (obj != null) {
                this.f465b.b(obj, this.k, this.f);
                View a3 = n.a(a2, this.f468e, this.l, this.j);
                if (a3 != null) {
                    this.f465b.a(a3, this.m);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public a.k.a.c f469a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f470b;

        /* renamed from: c  reason: collision with root package name */
        public a.k.a.a f471c;

        /* renamed from: d  reason: collision with root package name */
        public a.k.a.c f472d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f473e;
        public a.k.a.a f;

        e() {
        }
    }

    static {
        f454b = Build.VERSION.SDK_INT >= 21 ? new o() : null;
        f455c = a();
    }

    private static a.d.a<String, String> a(int i, ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.d.a<String, String> aVar = new a.d.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            a.k.a.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar2.q;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.q;
                        arrayList4 = aVar2.r;
                    } else {
                        arrayList4 = aVar2.q;
                        arrayList3 = aVar2.r;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    static a.d.a<String, View> a(p pVar, a.d.a<String, String> aVar, Object obj, e eVar) {
        k kVar;
        ArrayList<String> arrayList;
        String a2;
        a.k.a.c cVar = eVar.f469a;
        View y = cVar.y();
        if (aVar.isEmpty() || obj == null || y == null) {
            aVar.clear();
            return null;
        }
        a.d.a<String, View> aVar2 = new a.d.a<>();
        pVar.a((Map<String, View>) aVar2, y);
        a.k.a.a aVar3 = eVar.f471c;
        if (eVar.f470b) {
            kVar = cVar.n();
            arrayList = aVar3.q;
        } else {
            kVar = cVar.l();
            arrayList = aVar3.r;
        }
        if (arrayList != null) {
            aVar2.a((Collection<?>) arrayList);
            aVar2.a((Collection<?>) aVar.values());
        }
        if (kVar != null) {
            kVar.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(s.o(view)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, s.o(view));
                }
            }
        } else {
            a(aVar, aVar2);
        }
        return aVar2;
    }

    private static e a(e eVar, SparseArray<e> sparseArray, int i) {
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        sparseArray.put(i, eVar2);
        return eVar2;
    }

    private static p a() {
        try {
            return (p) Class.forName("a.p.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static p a(a.k.a.c cVar, a.k.a.c cVar2) {
        ArrayList arrayList = new ArrayList();
        if (cVar != null) {
            Object m = cVar.m();
            if (m != null) {
                arrayList.add(m);
            }
            Object u = cVar.u();
            if (u != null) {
                arrayList.add(u);
            }
            Object w = cVar.w();
            if (w != null) {
                arrayList.add(w);
            }
        }
        if (cVar2 != null) {
            Object k = cVar2.k();
            if (k != null) {
                arrayList.add(k);
            }
            Object s = cVar2.s();
            if (s != null) {
                arrayList.add(s);
            }
            Object v = cVar2.v();
            if (v != null) {
                arrayList.add(v);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        p pVar = f454b;
        if (pVar != null && a(pVar, arrayList)) {
            return f454b;
        }
        p pVar2 = f455c;
        if (pVar2 != null && a(pVar2, arrayList)) {
            return f455c;
        }
        if (f454b == null && f455c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static View a(a.d.a<String, View> aVar, e eVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        a.k.a.a aVar2 = eVar.f471c;
        if (obj == null || aVar == null || (arrayList = aVar2.q) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.q : aVar2.r).get(0));
    }

    private static Object a(p pVar, a.k.a.c cVar, a.k.a.c cVar2, boolean z) {
        if (cVar == null || cVar2 == null) {
            return null;
        }
        return pVar.c(pVar.b(z ? cVar2.w() : cVar.v()));
    }

    private static Object a(p pVar, a.k.a.c cVar, boolean z) {
        if (cVar == null) {
            return null;
        }
        return pVar.b(z ? cVar.s() : cVar.k());
    }

    private static Object a(p pVar, ViewGroup viewGroup, View view, a.d.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        a.d.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        a.k.a.c cVar = eVar.f469a;
        a.k.a.c cVar2 = eVar.f472d;
        if (cVar == null || cVar2 == null) {
            return null;
        }
        boolean z = eVar.f470b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = a(pVar, cVar, cVar2, z);
            aVar2 = aVar;
        }
        a.d.a<String, View> b2 = b(pVar, aVar2, obj3, eVar);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(cVar, cVar2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            pVar.b(obj4, view, arrayList);
            a(pVar, obj4, obj2, b2, eVar.f473e, eVar.f);
            if (obj != null) {
                pVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        q.a(viewGroup, new d(pVar, aVar, obj4, eVar, arrayList2, view, cVar, cVar2, z, arrayList, obj, rect));
        return obj4;
    }

    private static Object a(p pVar, Object obj, Object obj2, Object obj3, a.k.a.c cVar, boolean z) {
        return (obj == null || obj2 == null || cVar == null) ? true : z ? cVar.d() : cVar.c() ? pVar.b(obj2, obj, obj3) : pVar.a(obj2, obj, obj3);
    }

    private static String a(a.d.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.d(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static ArrayList<View> a(p pVar, Object obj, a.k.a.c cVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View y = cVar.y();
        if (y != null) {
            pVar.a(arrayList2, y);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        pVar.a(obj, arrayList2);
        return arrayList2;
    }

    private static void a(a.d.a<String, String> aVar, a.d.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.d(size))) {
                aVar.c(size);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
        if (r10.l != false) goto L_0x0092;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0090, code lost:
        if (r10.B == false) goto L_0x0092;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0092, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(a.k.a.a r16, a.k.a.a.C0019a r17, android.util.SparseArray<a.k.a.n.e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.a.n.a(a.k.a.a, a.k.a.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void a(a.k.a.a aVar, SparseArray<e> sparseArray, boolean z) {
        int size = aVar.f374b.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.f374b.get(i), sparseArray, false, z);
        }
    }

    static void a(a.k.a.c cVar, a.k.a.c cVar2, boolean z, a.d.a<String, View> aVar, boolean z2) {
        k l = z ? cVar2.l() : cVar.l();
        if (l != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.d(i));
            }
            if (z2) {
                l.b(arrayList2, arrayList, null);
            } else {
                l.a(arrayList2, arrayList, null);
            }
        }
    }

    private static void a(i iVar, int i, e eVar, View view, a.d.a<String, String> aVar) {
        a.k.a.c cVar;
        a.k.a.c cVar2;
        p a2;
        Object obj;
        ViewGroup viewGroup = iVar.o.a() ? (ViewGroup) iVar.o.a(i) : null;
        if (viewGroup != null && (a2 = a((cVar2 = eVar.f472d), (cVar = eVar.f469a))) != null) {
            boolean z = eVar.f470b;
            boolean z2 = eVar.f473e;
            Object a3 = a(a2, cVar, z);
            Object b2 = b(a2, cVar2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object a4 = a(a2, viewGroup, view, aVar, eVar, arrayList, arrayList2, a3, b2);
            if (a3 == null && a4 == null) {
                obj = b2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = b2;
            }
            ArrayList<View> a5 = a(a2, obj, cVar2, arrayList, view);
            Object obj2 = (a5 == null || a5.isEmpty()) ? null : obj;
            a2.a(a3, view);
            Object a6 = a(a2, a3, obj2, a4, cVar, eVar.f470b);
            if (a6 != null) {
                ArrayList<View> arrayList3 = new ArrayList<>();
                a2.a(a6, a3, arrayList3, obj2, a5, a4, arrayList2);
                a(a2, viewGroup, cVar, view, arrayList2, a3, arrayList3, obj2, a5);
                a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar);
                a2.a(viewGroup, a6);
                a2.a(viewGroup, arrayList2, (Map<String, String>) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(i iVar, ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (iVar.m >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                a.k.a.a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(aVar, sparseArray, z);
                } else {
                    a(aVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(iVar.n.c());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    a.d.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    e eVar = (e) sparseArray.valueAt(i4);
                    if (z) {
                        b(iVar, keyAt, eVar, view, a2);
                    } else {
                        a(iVar, keyAt, eVar, view, a2);
                    }
                }
            }
        }
    }

    private static void a(p pVar, ViewGroup viewGroup, a.k.a.c cVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        q.a(viewGroup, new b(obj, pVar, view, cVar, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void a(p pVar, Object obj, a.k.a.c cVar, ArrayList<View> arrayList) {
        if (cVar != null && obj != null && cVar.l && cVar.B && cVar.P) {
            cVar.f(true);
            pVar.a(obj, cVar.y(), arrayList);
            q.a(cVar.I, new a(arrayList));
        }
    }

    private static void a(p pVar, Object obj, Object obj2, a.d.a<String, View> aVar, boolean z, a.k.a.a aVar2) {
        ArrayList<String> arrayList = aVar2.q;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z ? aVar2.r : aVar2.q).get(0));
            pVar.c(obj, view);
            if (obj2 != null) {
                pVar.c(obj2, view);
            }
        }
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, a.d.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View d2 = aVar.d(size);
            if (collection.contains(s.o(d2))) {
                arrayList.add(d2);
            }
        }
    }

    private static boolean a(p pVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!pVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static a.d.a<String, View> b(p pVar, a.d.a<String, String> aVar, Object obj, e eVar) {
        k kVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        a.k.a.c cVar = eVar.f472d;
        a.d.a<String, View> aVar2 = new a.d.a<>();
        pVar.a((Map<String, View>) aVar2, cVar.y());
        a.k.a.a aVar3 = eVar.f;
        if (eVar.f473e) {
            kVar = cVar.l();
            arrayList = aVar3.r;
        } else {
            kVar = cVar.n();
            arrayList = aVar3.q;
        }
        aVar2.a((Collection<?>) arrayList);
        if (kVar != null) {
            kVar.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(s.o(view))) {
                    aVar.put(s.o(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar2.keySet());
        }
        return aVar2;
    }

    private static Object b(p pVar, a.k.a.c cVar, boolean z) {
        if (cVar == null) {
            return null;
        }
        return pVar.b(z ? cVar.u() : cVar.m());
    }

    private static Object b(p pVar, ViewGroup viewGroup, View view, a.d.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        View view2;
        a.k.a.c cVar = eVar.f469a;
        a.k.a.c cVar2 = eVar.f472d;
        if (cVar != null) {
            cVar.y().setVisibility(0);
        }
        if (cVar == null || cVar2 == null) {
            return null;
        }
        boolean z = eVar.f470b;
        Object a2 = aVar.isEmpty() ? null : a(pVar, cVar, cVar2, z);
        a.d.a<String, View> b2 = b(pVar, aVar, a2, eVar);
        a.d.a<String, View> a3 = a(pVar, aVar, a2, eVar);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(cVar, cVar2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            pVar.b(obj3, view, arrayList);
            a(pVar, obj3, obj2, b2, eVar.f473e, eVar.f);
            Rect rect2 = new Rect();
            View a4 = a(a3, eVar, obj, z);
            if (a4 != null) {
                pVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        q.a(viewGroup, new c(cVar, cVar2, z, a3, view2, pVar, rect));
        return obj3;
    }

    public static void b(a.k.a.a aVar, SparseArray<e> sparseArray, boolean z) {
        if (aVar.f373a.o.a()) {
            for (int size = aVar.f374b.size() - 1; size >= 0; size--) {
                a(aVar, aVar.f374b.get(size), sparseArray, true, z);
            }
        }
    }

    private static void b(i iVar, int i, e eVar, View view, a.d.a<String, String> aVar) {
        a.k.a.c cVar;
        a.k.a.c cVar2;
        p a2;
        Object obj;
        ViewGroup viewGroup = iVar.o.a() ? (ViewGroup) iVar.o.a(i) : null;
        if (viewGroup != null && (a2 = a((cVar2 = eVar.f472d), (cVar = eVar.f469a))) != null) {
            boolean z = eVar.f470b;
            boolean z2 = eVar.f473e;
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object a3 = a(a2, cVar, z);
            Object b2 = b(a2, cVar2, z2);
            Object b3 = b(a2, viewGroup, view, aVar, eVar, arrayList2, arrayList, a3, b2);
            if (a3 == null && b3 == null) {
                obj = b2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = b2;
            }
            ArrayList<View> a4 = a(a2, obj, cVar2, arrayList2, view);
            ArrayList<View> a5 = a(a2, a3, cVar, arrayList, view);
            a(a5, 4);
            Object a6 = a(a2, a3, obj, b3, cVar, z);
            if (a6 != null) {
                a(a2, obj, cVar2, a4);
                ArrayList<String> a7 = a2.a(arrayList);
                a2.a(a6, a3, a5, obj, a4, b3, arrayList);
                a2.a(viewGroup, a6);
                a2.a(viewGroup, arrayList2, arrayList, a7, aVar);
                a(a5, 0);
                a2.b(b3, arrayList2, arrayList);
            }
        }
    }
}
