package a.e.a.j;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    HashSet<o> f201a = new HashSet<>(2);

    /* renamed from: b  reason: collision with root package name */
    int f202b = 0;

    public void a() {
        this.f202b = 1;
        Iterator<o> it = this.f201a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void a(o oVar) {
        this.f201a.add(oVar);
    }

    public void b() {
        this.f202b = 0;
        Iterator<o> it = this.f201a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f202b == 1;
    }

    public void d() {
        this.f202b = 0;
        this.f201a.clear();
    }

    public void e() {
    }
}
