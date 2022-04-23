package b.c.b.w.d;

import b.c.b.w.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Integer> f1985a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        Integer num = this.f1985a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f1985a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry<Integer, Integer> entry : this.f1985a.entrySet()) {
            if (entry.getValue().intValue() > i) {
                i = entry.getValue().intValue();
                arrayList.clear();
            } else if (entry.getValue().intValue() == i) {
            }
            arrayList.add(entry.getKey());
        }
        return a.a(arrayList);
    }
}
