package androidx.lifecycle;

import java.util.HashMap;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, p> f1296a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p a(String str) {
        return this.f1296a.get(str);
    }

    public final void a() {
        for (p pVar : this.f1296a.values()) {
            pVar.a();
        }
        this.f1296a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, p pVar) {
        p put = this.f1296a.put(str, pVar);
        if (put != null) {
            put.a();
        }
    }
}
