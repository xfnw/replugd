package androidx.recyclerview.widget;

import a.d.d;
import a.g.k.e;
import a.g.k.f;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    final a.d.a<RecyclerView.d0, a> f1527a = new a.d.a<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.d0> f1528b = new d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        static e<a> f1529d = new f(20);

        /* renamed from: a  reason: collision with root package name */
        int f1530a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.l.c f1531b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.c f1532c;

        private a() {
        }

        static void a() {
            do {
            } while (f1529d.a() != null);
        }

        static void a(a aVar) {
            aVar.f1530a = 0;
            aVar.f1531b = null;
            aVar.f1532c = null;
            f1529d.a(aVar);
        }

        static a b() {
            a a2 = f1529d.a();
            return a2 == null ? new a() : a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c a(RecyclerView.d0 d0Var, int i) {
        a d2;
        RecyclerView.l.c cVar;
        int a2 = this.f1527a.a(d0Var);
        if (a2 >= 0 && (d2 = this.f1527a.d(a2)) != null) {
            int i2 = d2.f1530a;
            if ((i2 & i) != 0) {
                d2.f1530a = (i ^ (-1)) & i2;
                if (i == 4) {
                    cVar = d2.f1531b;
                } else if (i == 8) {
                    cVar = d2.f1532c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((d2.f1530a & 12) == 0) {
                    this.f1527a.c(a2);
                    a.a(d2);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.d0 a(long j) {
        return this.f1528b.c(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f1527a.clear();
        this.f1528b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.d0 d0Var) {
        this.f1528b.c(j, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var) {
        a aVar = this.f1527a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1527a.put(d0Var, aVar);
        }
        aVar.f1530a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1527a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1527a.put(d0Var, aVar);
        }
        aVar.f1530a |= 2;
        aVar.f1531b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        RecyclerView.l.c cVar;
        RecyclerView.l.c cVar2;
        for (int size = this.f1527a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 b2 = this.f1527a.b(size);
            a c2 = this.f1527a.c(size);
            int i = c2.f1530a;
            if ((i & 3) != 3) {
                if ((i & 1) != 0) {
                    cVar = c2.f1531b;
                    if (cVar != null) {
                        cVar2 = c2.f1532c;
                    }
                } else {
                    if ((i & 14) != 14) {
                        if ((i & 12) == 12) {
                            bVar.c(b2, c2.f1531b, c2.f1532c);
                        } else if ((i & 4) != 0) {
                            cVar = c2.f1531b;
                            cVar2 = null;
                        } else if ((i & 8) == 0) {
                        }
                        a.a(c2);
                    }
                    bVar.a(b2, c2.f1531b, c2.f1532c);
                    a.a(c2);
                }
                bVar.b(b2, cVar, cVar2);
                a.a(c2);
            }
            bVar.a(b2);
            a.a(c2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1527a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1527a.put(d0Var, aVar);
        }
        aVar.f1532c = cVar;
        aVar.f1530a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RecyclerView.d0 d0Var) {
        a aVar = this.f1527a.get(d0Var);
        return (aVar == null || (aVar.f1530a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1527a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1527a.put(d0Var, aVar);
        }
        aVar.f1531b = cVar;
        aVar.f1530a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(RecyclerView.d0 d0Var) {
        a aVar = this.f1527a.get(d0Var);
        return (aVar == null || (aVar.f1530a & 4) == 0) ? false : true;
    }

    public void d(RecyclerView.d0 d0Var) {
        g(d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c e(RecyclerView.d0 d0Var) {
        return a(d0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c f(RecyclerView.d0 d0Var) {
        return a(d0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.d0 d0Var) {
        a aVar = this.f1527a.get(d0Var);
        if (aVar != null) {
            aVar.f1530a &= -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(RecyclerView.d0 d0Var) {
        int b2 = this.f1528b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (d0Var == this.f1528b.c(b2)) {
                this.f1528b.b(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f1527a.remove(d0Var);
        if (remove != null) {
            a.a(remove);
        }
    }
}
