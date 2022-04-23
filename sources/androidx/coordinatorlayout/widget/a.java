package androidx.coordinatorlayout.widget;

import a.d.g;
import a.g.k.e;
import a.g.k.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f1148a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f1149b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f1150c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f1151d = new HashSet<>();

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList<T> arrayList2 = this.f1149b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1148a.a(arrayList);
    }

    private ArrayList<T> c() {
        ArrayList<T> a2 = this.f1148a.a();
        return a2 == null ? new ArrayList<>() : a2;
    }

    public void a() {
        int size = this.f1149b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> d2 = this.f1149b.d(i);
            if (d2 != null) {
                a((ArrayList) d2);
            }
        }
        this.f1149b.clear();
    }

    public void a(T t) {
        if (!this.f1149b.containsKey(t)) {
            this.f1149b.put(t, null);
        }
    }

    public void a(T t, T t2) {
        if (!this.f1149b.containsKey(t) || !this.f1149b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f1149b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f1149b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public ArrayList<T> b() {
        this.f1150c.clear();
        this.f1151d.clear();
        int size = this.f1149b.size();
        for (int i = 0; i < size; i++) {
            a(this.f1149b.b(i), this.f1150c, this.f1151d);
        }
        return this.f1150c;
    }

    public boolean b(T t) {
        return this.f1149b.containsKey(t);
    }

    public List c(T t) {
        return this.f1149b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f1149b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> d2 = this.f1149b.d(i);
            if (d2 != null && d2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1149b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f1149b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> d2 = this.f1149b.d(i);
            if (d2 != null && d2.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
