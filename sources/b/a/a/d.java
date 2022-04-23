package b.a.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class d extends i {

    /* renamed from: a  reason: collision with root package name */
    private i[] f1611a;

    public d(int i) {
        this.f1611a = new i[i];
    }

    public d(i... iVarArr) {
        this.f1611a = iVarArr;
    }

    public int a() {
        return this.f1611a.length;
    }

    public i a(int i) {
        return this.f1611a[i];
    }

    public void a(int i, Object obj) {
        this.f1611a[i] = i.a(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void a(c cVar) {
        super.a(cVar);
        for (i iVar : this.f1611a) {
            iVar.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void b(c cVar) {
        cVar.a(10, this.f1611a.length);
        for (i iVar : this.f1611a) {
            cVar.b(cVar.b(iVar));
        }
    }

    public i[] b() {
        return this.f1611a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(d.class)) {
            return Arrays.equals(((d) obj).b(), this.f1611a);
        }
        i a2 = i.a(obj);
        if (a2.getClass().equals(d.class)) {
            return Arrays.equals(((d) a2).b(), this.f1611a);
        }
        return false;
    }

    public int hashCode() {
        return 623 + Arrays.deepHashCode(this.f1611a);
    }
}
