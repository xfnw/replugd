package b.c.b.v;

import b.c.b.a;
import b.c.b.e;
import b.c.b.l;
import b.c.b.m;
import b.c.b.v.r.g.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class i extends k {

    /* renamed from: a  reason: collision with root package name */
    private final k[] f1916a;

    public i(Map<e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13) || collection.contains(a.UPC_A) || collection.contains(a.EAN_8) || collection.contains(a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.RSS_14)) {
                arrayList.add(new b.c.b.v.r.e());
            }
            if (collection.contains(a.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new b.c.b.v.r.e());
            arrayList.add(new d());
        }
        this.f1916a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // b.c.b.v.k
    public m a(int i, b.c.b.r.a aVar, Map<e, ?> map) {
        for (k kVar : this.f1916a) {
            try {
                return kVar.a(i, aVar, map);
            } catch (l unused) {
            }
        }
        throw b.c.b.i.a();
    }

    @Override // b.c.b.v.k, b.c.b.k
    public void a() {
        for (k kVar : this.f1916a) {
            kVar.a();
        }
    }
}
