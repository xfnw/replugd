package d.f0.f;

import d.c0;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c0> f3452a = new LinkedHashSet();

    public synchronized void a(c0 c0Var) {
        this.f3452a.remove(c0Var);
    }

    public synchronized void b(c0 c0Var) {
        this.f3452a.add(c0Var);
    }

    public synchronized boolean c(c0 c0Var) {
        return this.f3452a.contains(c0Var);
    }
}
