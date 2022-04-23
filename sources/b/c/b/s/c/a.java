package b.c.b.s.c;

import b.c.b.o;
import b.c.b.r.g;
import b.c.b.r.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b.c.b.r.b f1882a;

    /* renamed from: b  reason: collision with root package name */
    private final b.c.b.r.m.b f1883b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final o f1884a;

        /* renamed from: b  reason: collision with root package name */
        private final o f1885b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1886c;

        private b(o oVar, o oVar2, int i) {
            this.f1884a = oVar;
            this.f1885b = oVar2;
            this.f1886c = i;
        }

        o a() {
            return this.f1884a;
        }

        o b() {
            return this.f1885b;
        }

        int c() {
            return this.f1886c;
        }

        public String toString() {
            return this.f1884a + "/" + this.f1885b + '/' + this.f1886c;
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements Serializable, Comparator<b> {
        private c() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(b.c.b.r.b bVar) {
        this.f1882a = bVar;
        this.f1883b = new b.c.b.r.m.b(bVar);
    }

    private static int a(o oVar, o oVar2) {
        return b.c.b.r.m.a.a(o.a(oVar, oVar2));
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i) {
        float f = i;
        float a2 = a(oVar, oVar2) / f;
        float a3 = a(oVar3, oVar4);
        o oVar5 = new o(oVar4.a() + (((oVar4.a() - oVar3.a()) / a3) * a2), oVar4.b() + (a2 * ((oVar4.b() - oVar3.b()) / a3)));
        float a4 = a(oVar, oVar3) / f;
        float a5 = a(oVar2, oVar4);
        o oVar6 = new o(oVar4.a() + (((oVar4.a() - oVar2.a()) / a5) * a4), oVar4.b() + (a4 * ((oVar4.b() - oVar2.b()) / a5)));
        if (a(oVar5)) {
            return (a(oVar6) && Math.abs(b(oVar3, oVar5).c() - b(oVar2, oVar5).c()) > Math.abs(b(oVar3, oVar6).c() - b(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (a(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) {
        float a2 = a(oVar, oVar2) / i;
        float a3 = a(oVar3, oVar4);
        o oVar5 = new o(oVar4.a() + (((oVar4.a() - oVar3.a()) / a3) * a2), oVar4.b() + (a2 * ((oVar4.b() - oVar3.b()) / a3)));
        float a4 = a(oVar, oVar3) / i2;
        float a5 = a(oVar2, oVar4);
        o oVar6 = new o(oVar4.a() + (((oVar4.a() - oVar2.a()) / a5) * a4), oVar4.b() + (a4 * ((oVar4.b() - oVar2.b()) / a5)));
        if (a(oVar5)) {
            return (a(oVar6) && Math.abs(i - b(oVar3, oVar5).c()) + Math.abs(i2 - b(oVar2, oVar5).c()) > Math.abs(i - b(oVar3, oVar6).c()) + Math.abs(i2 - b(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (a(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private static b.c.b.r.b a(b.c.b.r.b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return i.a().a(bVar, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, oVar.a(), oVar.b(), oVar4.a(), oVar4.b(), oVar3.a(), oVar3.b(), oVar2.a(), oVar2.b());
    }

    private static void a(Map<o, Integer> map, o oVar) {
        Integer num = map.get(oVar);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(oVar, Integer.valueOf(i));
    }

    private boolean a(o oVar) {
        return oVar.a() >= 0.0f && oVar.a() < ((float) this.f1882a.e()) && oVar.b() > 0.0f && oVar.b() < ((float) this.f1882a.c());
    }

    private b b(o oVar, o oVar2) {
        int a2 = (int) oVar.a();
        int b2 = (int) oVar.b();
        int a3 = (int) oVar2.a();
        int b3 = (int) oVar2.b();
        int i = 0;
        int i2 = 1;
        boolean z = Math.abs(b3 - b2) > Math.abs(a3 - a2);
        if (z) {
            b2 = a2;
            a2 = b2;
            b3 = a3;
            a3 = b3;
        }
        int abs = Math.abs(a3 - a2);
        int abs2 = Math.abs(b3 - b2);
        int i3 = (-abs) / 2;
        int i4 = b2 < b3 ? 1 : -1;
        if (a2 >= a3) {
            i2 = -1;
        }
        boolean b4 = this.f1882a.b(z ? b2 : a2, z ? a2 : b2);
        while (a2 != a3) {
            boolean b5 = this.f1882a.b(z ? b2 : a2, z ? a2 : b2);
            if (b5 != b4) {
                i++;
                b4 = b5;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (b2 == b3) {
                    break;
                }
                b2 += i4;
                i3 -= abs;
            }
            a2 += i2;
        }
        return new b(oVar, oVar2, i);
    }

    public g a() {
        o oVar;
        b.c.b.r.b bVar;
        o oVar2;
        o[] a2 = this.f1883b.a();
        o oVar3 = a2[0];
        o oVar4 = a2[1];
        o oVar5 = a2[2];
        o oVar6 = a2[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(oVar3, oVar4));
        arrayList.add(b(oVar3, oVar5));
        arrayList.add(b(oVar4, oVar6));
        arrayList.add(b(oVar5, oVar6));
        o oVar7 = null;
        Collections.sort(arrayList, new c());
        b bVar2 = (b) arrayList.get(0);
        b bVar3 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        a(hashMap, bVar2.a());
        a(hashMap, bVar2.b());
        a(hashMap, bVar3.a());
        a(hashMap, bVar3.b());
        o oVar8 = null;
        o oVar9 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            o oVar10 = (o) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                oVar8 = oVar10;
            } else if (oVar7 == null) {
                oVar7 = oVar10;
            } else {
                oVar9 = oVar10;
            }
        }
        if (oVar7 == null || oVar8 == null || oVar9 == null) {
            throw b.c.b.i.a();
        }
        o[] oVarArr = {oVar7, oVar8, oVar9};
        o.a(oVarArr);
        o oVar11 = oVarArr[0];
        o oVar12 = oVarArr[1];
        o oVar13 = oVarArr[2];
        o oVar14 = !hashMap.containsKey(oVar3) ? oVar3 : !hashMap.containsKey(oVar4) ? oVar4 : !hashMap.containsKey(oVar5) ? oVar5 : oVar6;
        int c2 = b(oVar13, oVar14).c();
        int c3 = b(oVar11, oVar14).c();
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i = c2 + 2;
        if ((c3 & 1) == 1) {
            c3++;
        }
        int i2 = c3 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            oVar = oVar13;
            oVar2 = a(oVar12, oVar11, oVar13, oVar14, i, i2);
            if (oVar2 == null) {
                oVar2 = oVar14;
            }
            int c4 = b(oVar, oVar2).c();
            int c5 = b(oVar11, oVar2).c();
            if ((c4 & 1) == 1) {
                c4++;
            }
            if ((c5 & 1) == 1) {
                c5++;
            }
            bVar = a(this.f1882a, oVar, oVar12, oVar11, oVar2, c4, c5);
        } else {
            oVar2 = a(oVar12, oVar11, oVar13, oVar14, Math.min(i2, i));
            if (oVar2 == null) {
                oVar2 = oVar14;
            }
            int max = Math.max(b(oVar13, oVar2).c(), b(oVar11, oVar2).c()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            bVar = a(this.f1882a, oVar13, oVar12, oVar11, oVar2, max, max);
            oVar = oVar13;
        }
        return new g(bVar, new o[]{oVar, oVar12, oVar11, oVar2});
    }
}
