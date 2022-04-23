package a.e.a.j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<f> f190a;

    /* renamed from: b  reason: collision with root package name */
    int f191b;

    /* renamed from: c  reason: collision with root package name */
    int f192c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f193d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f194e;
    List<f> f;
    List<f> g;
    HashSet<f> h;
    HashSet<f> i;
    List<f> j;
    List<f> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<f> list) {
        this.f191b = -1;
        this.f192c = -1;
        this.f193d = false;
        this.f194e = new int[]{this.f191b, this.f192c};
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f190a = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<f> list, boolean z) {
        this.f191b = -1;
        this.f192c = -1;
        this.f193d = false;
        this.f194e = new int[]{this.f191b, this.f192c};
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f190a = list;
        this.f193d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(a.e.a.j.f r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.h.a(a.e.a.j.f):void");
    }

    private void a(ArrayList<f> arrayList, f fVar) {
        if (!fVar.d0) {
            arrayList.add(fVar);
            fVar.d0 = true;
            if (!fVar.y()) {
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    int i = jVar.l0;
                    for (int i2 = 0; i2 < i; i2++) {
                        a(arrayList, jVar.k0[i2]);
                    }
                }
                int length = fVar.A.length;
                for (int i3 = 0; i3 < length; i3++) {
                    e eVar = fVar.A[i3].f165d;
                    if (eVar != null) {
                        f fVar2 = eVar.f163b;
                        if (!(eVar == null || fVar2 == fVar.k())) {
                            a(arrayList, fVar2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<f> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f190a.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.f190a.get(i);
            if (!fVar.b0) {
                a((ArrayList) this.j, fVar);
            }
        }
        this.k.clear();
        this.k.addAll(this.f190a);
        this.k.removeAll(this.j);
        return this.j;
    }

    public List<f> a(int i) {
        if (i == 0) {
            return this.f;
        }
        if (i == 1) {
            return this.g;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar, int i) {
        HashSet<f> hashSet;
        if (i == 0) {
            hashSet = this.h;
        } else if (i == 1) {
            hashSet = this.i;
        } else {
            return;
        }
        hashSet.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<f> b(int i) {
        if (i == 0) {
            return this.h;
        }
        if (i == 1) {
            return this.i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            a(this.k.get(i));
        }
    }
}
