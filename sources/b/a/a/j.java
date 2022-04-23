package b.a.a;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class j extends i {

    /* renamed from: a  reason: collision with root package name */
    private Set<i> f1621a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1622b;

    public j() {
        this.f1622b = false;
        this.f1621a = new LinkedHashSet();
    }

    public j(boolean z) {
        this.f1622b = false;
        this.f1622b = z;
        this.f1621a = !z ? new LinkedHashSet<>() : new TreeSet<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void a(c cVar) {
        super.a(cVar);
        for (i iVar : this.f1621a) {
            iVar.a(cVar);
        }
    }

    public synchronized void a(i iVar) {
        this.f1621a.add(iVar);
    }

    public synchronized i[] a() {
        return (i[]) this.f1621a.toArray(new i[b()]);
    }

    public synchronized int b() {
        return this.f1621a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void b(c cVar) {
        cVar.a(this.f1622b ? 11 : 12, this.f1621a.size());
        for (i iVar : this.f1621a) {
            cVar.b(cVar.b(iVar));
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        Set<i> set = this.f1621a;
        Set<i> set2 = ((j) obj).f1621a;
        return set == set2 || (set != null && set.equals(set2));
    }

    public int hashCode() {
        Set<i> set = this.f1621a;
        return 203 + (set != null ? set.hashCode() : 0);
    }
}
