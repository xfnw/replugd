package b.c.b.v.r.g;

import java.util.List;

/* loaded from: classes.dex */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static b.c.b.r.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).c() == null) {
            size--;
        }
        b.c.b.r.a aVar = new b.c.b.r.a(size * 12);
        int b2 = list.get(0).c().b();
        int i = 0;
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & b2) != 0) {
                aVar.d(i);
            }
            i++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            b bVar = list.get(i3);
            int b3 = bVar.b().b();
            for (int i4 = 11; i4 >= 0; i4--) {
                if (((1 << i4) & b3) != 0) {
                    aVar.d(i);
                }
                i++;
            }
            if (bVar.c() != null) {
                int b4 = bVar.c().b();
                for (int i5 = 11; i5 >= 0; i5--) {
                    if (((1 << i5) & b4) != 0) {
                        aVar.d(i);
                    }
                    i++;
                }
            }
        }
        return aVar;
    }
}
