package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.f;
import com.airbnb.lottie.u.j.l;
import com.airbnb.lottie.u.k.b;
import com.airbnb.lottie.u.k.n;
import com.airbnb.lottie.y.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d implements e, n, a.AbstractC0063a, f {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f2188a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f2189b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f2190c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2191d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2192e;
    private final List<c> f;
    private final com.airbnb.lottie.f g;
    private List<n> h;
    private o i;

    public d(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar, n nVar) {
        this(fVar, aVar, nVar.b(), nVar.c(), a(fVar, aVar, nVar.a()), a(nVar.a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar, String str, boolean z, List<c> list, l lVar) {
        this.f2188a = new Matrix();
        this.f2189b = new Path();
        this.f2190c = new RectF();
        this.f2191d = str;
        this.g = fVar;
        this.f2192e = z;
        this.f = list;
        if (lVar != null) {
            this.i = lVar.a();
            this.i.a(aVar);
            this.i.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    static l a(List<b> list) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    private static List<c> a(com.airbnb.lottie.f fVar, com.airbnb.lottie.u.l.a aVar, List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            c a2 = list.get(i).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2191d;
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.f2192e) {
            this.f2188a.set(matrix);
            o oVar = this.i;
            if (oVar != null) {
                this.f2188a.preConcat(oVar.b());
                i = (int) (((((this.i.c() == null ? 100 : this.i.c().f().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
            }
            for (int size = this.f.size() - 1; size >= 0; size--) {
                c cVar = this.f.get(size);
                if (cVar instanceof e) {
                    ((e) cVar).a(canvas, this.f2188a, i);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2188a.set(matrix);
        o oVar = this.i;
        if (oVar != null) {
            this.f2188a.preConcat(oVar.b());
        }
        this.f2190c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            c cVar = this.f.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f2190c, this.f2188a, z);
                rectF.union(this.f2190c);
            }
        }
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        if (eVar.c(a(), i)) {
            if (!"__container".equals(a())) {
                eVar2 = eVar2.a(a());
                if (eVar.a(a(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(a(), i)) {
                int b2 = i + eVar.b(a(), i);
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    c cVar = this.f.get(i2);
                    if (cVar instanceof f) {
                        ((f) cVar).a(eVar, b2, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        o oVar = this.i;
        if (oVar != null) {
            oVar.a(t, cVar);
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f.size());
        arrayList.addAll(list);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            c cVar = this.f.get(size);
            cVar.a(arrayList, this.f.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        this.g.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.n
    public Path c() {
        this.f2188a.reset();
        o oVar = this.i;
        if (oVar != null) {
            this.f2188a.set(oVar.b());
        }
        this.f2189b.reset();
        if (this.f2192e) {
            return this.f2189b;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            c cVar = this.f.get(size);
            if (cVar instanceof n) {
                this.f2189b.addPath(((n) cVar).c(), this.f2188a);
            }
        }
        return this.f2189b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n> d() {
        if (this.h == null) {
            this.h = new ArrayList();
            for (int i = 0; i < this.f.size(); i++) {
                c cVar = this.f.get(i);
                if (cVar instanceof n) {
                    this.h.add((n) cVar);
                }
            }
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix e() {
        o oVar = this.i;
        if (oVar != null) {
            return oVar.b();
        }
        this.f2188a.reset();
        return this.f2188a;
    }
}
