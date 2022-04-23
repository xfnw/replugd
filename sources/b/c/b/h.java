package b.c.b;

import b.c.b.q.b;
import b.c.b.v.i;
import b.c.b.x.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private Map<e, ?> f1771a;

    /* renamed from: b  reason: collision with root package name */
    private k[] f1772b;

    private m b(c cVar) {
        k[] kVarArr = this.f1772b;
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                try {
                    return kVar.a(cVar, this.f1771a);
                } catch (l unused) {
                }
            }
        }
        throw i.a();
    }

    public m a(c cVar) {
        if (this.f1772b == null) {
            a((Map<e, ?>) null);
        }
        return b(cVar);
    }

    @Override // b.c.b.k
    public m a(c cVar, Map<e, ?> map) {
        a(map);
        return b(cVar);
    }

    @Override // b.c.b.k
    public void a() {
        k[] kVarArr = this.f1772b;
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                kVar.a();
            }
        }
    }

    public void a(Map<e, ?> map) {
        this.f1771a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new b.c.b.s.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new b.c.b.w.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new b.c.b.t.a());
            }
            if (z && z2) {
                arrayList.add(new i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new i(map));
            }
            arrayList.add(new a());
            arrayList.add(new b.c.b.s.a());
            arrayList.add(new b());
            arrayList.add(new b.c.b.w.b());
            arrayList.add(new b.c.b.t.a());
            if (z2) {
                arrayList.add(new i(map));
            }
        }
        this.f1772b = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }
}
