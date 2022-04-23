package androidx.recyclerview.widget;

import a.g.k.e;
import a.g.k.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private e<b> f1413a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f1414b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f1415c;

    /* renamed from: d  reason: collision with root package name */
    final AbstractC0043a f1416d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f1417e;
    final boolean f;
    final j g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0043a {
        RecyclerView.d0 a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f1418a;

        /* renamed from: b  reason: collision with root package name */
        int f1419b;

        /* renamed from: c  reason: collision with root package name */
        Object f1420c;

        /* renamed from: d  reason: collision with root package name */
        int f1421d;

        b(int i, int i2, int i3, Object obj) {
            this.f1418a = i;
            this.f1419b = i2;
            this.f1421d = i3;
            this.f1420c = obj;
        }

        String a() {
            int i = this.f1418a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f1418a;
            if (i != bVar.f1418a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f1421d - this.f1419b) == 1 && this.f1421d == bVar.f1419b && this.f1419b == bVar.f1421d) {
                return true;
            }
            if (this.f1421d != bVar.f1421d || this.f1419b != bVar.f1419b) {
                return false;
            }
            Object obj2 = this.f1420c;
            Object obj3 = bVar.f1420c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1418a * 31) + this.f1419b) * 31) + this.f1421d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1419b + "c:" + this.f1421d + ",p:" + this.f1420c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractC0043a aVar) {
        this(aVar, false);
    }

    a(AbstractC0043a aVar, boolean z) {
        this.f1413a = new f(30);
        this.f1414b = new ArrayList<>();
        this.f1415c = new ArrayList<>();
        this.h = 0;
        this.f1416d = aVar;
        this.f = z;
        this.g = new j(this);
    }

    private void b(b bVar) {
        g(bVar);
    }

    private int c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        for (int size = this.f1415c.size() - 1; size >= 0; size--) {
            b bVar = this.f1415c.get(size);
            int i7 = bVar.f1418a;
            if (i7 == 8) {
                int i8 = bVar.f1419b;
                int i9 = bVar.f1421d;
                if (i8 >= i9) {
                    i9 = i8;
                    i8 = i9;
                }
                if (i < i8 || i > i9) {
                    int i10 = bVar.f1419b;
                    if (i < i10) {
                        if (i2 == 1) {
                            bVar.f1419b = i10 + 1;
                            i4 = bVar.f1421d + 1;
                        } else if (i2 == 2) {
                            bVar.f1419b = i10 - 1;
                            i4 = bVar.f1421d - 1;
                        }
                        bVar.f1421d = i4;
                    }
                } else {
                    int i11 = bVar.f1419b;
                    if (i8 == i11) {
                        if (i2 == 1) {
                            i6 = bVar.f1421d + 1;
                        } else {
                            if (i2 == 2) {
                                i6 = bVar.f1421d - 1;
                            }
                            i++;
                        }
                        bVar.f1421d = i6;
                        i++;
                    } else {
                        if (i2 == 1) {
                            i5 = i11 + 1;
                        } else {
                            if (i2 == 2) {
                                i5 = i11 - 1;
                            }
                            i--;
                        }
                        bVar.f1419b = i5;
                        i--;
                    }
                }
            } else {
                int i12 = bVar.f1419b;
                if (i12 > i) {
                    if (i2 == 1) {
                        i3 = i12 + 1;
                    } else if (i2 == 2) {
                        i3 = i12 - 1;
                    }
                    bVar.f1419b = i3;
                } else if (i7 == 1) {
                    i -= bVar.f1421d;
                } else if (i7 == 2) {
                    i += bVar.f1421d;
                }
            }
        }
        for (int size2 = this.f1415c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1415c.get(size2);
            if (bVar2.f1418a == 8) {
                int i13 = bVar2.f1421d;
                if (i13 != bVar2.f1419b && i13 >= 0) {
                }
                this.f1415c.remove(size2);
                a(bVar2);
            } else {
                if (bVar2.f1421d > 0) {
                }
                this.f1415c.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private void c(b bVar) {
        g(bVar);
    }

    private void d(b bVar) {
        boolean z;
        int i = bVar.f1419b;
        int i2 = bVar.f1421d + i;
        int i3 = 0;
        char c2 = 65535;
        int i4 = i;
        while (i4 < i2) {
            if (this.f1416d.a(i4) != null || d(i4)) {
                if (c2 == 0) {
                    f(a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
        }
        if (i3 != bVar.f1421d) {
            a(bVar);
            bVar = a(2, i, i3, null);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i) {
        int size = this.f1415c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1415c.get(i2);
            int i3 = bVar.f1418a;
            if (i3 == 8) {
                if (a(bVar.f1421d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f1419b;
                int i5 = bVar.f1421d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        int i = bVar.f1419b;
        int i2 = bVar.f1421d + i;
        int i3 = i;
        int i4 = 0;
        char c2 = 65535;
        while (i < i2) {
            if (this.f1416d.a(i) != null || d(i)) {
                if (c2 == 0) {
                    f(a(4, i3, i4, bVar.f1420c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i3, i4, bVar.f1420c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.f1421d) {
            Object obj = bVar.f1420c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private void f(b bVar) {
        int i;
        int i2 = bVar.f1418a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int c2 = c(bVar.f1419b, i2);
        int i3 = bVar.f1419b;
        int i4 = bVar.f1418a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.f1421d; i6++) {
            int c3 = c(bVar.f1419b + (i * i6), bVar.f1418a);
            int i7 = bVar.f1418a;
            if (i7 == 2 ? c3 == c2 : i7 == 4 && c3 == c2 + 1) {
                i5++;
            } else {
                b a2 = a(bVar.f1418a, c2, i5, bVar.f1420c);
                a(a2, i3);
                a(a2);
                if (bVar.f1418a == 4) {
                    i3 += i5;
                }
                c2 = c3;
                i5 = 1;
            }
        }
        Object obj = bVar.f1420c;
        a(bVar);
        if (i5 > 0) {
            b a3 = a(bVar.f1418a, c2, i5, obj);
            a(a3, i3);
            a(a3);
        }
    }

    private void g(b bVar) {
        this.f1415c.add(bVar);
        int i = bVar.f1418a;
        if (i == 1) {
            this.f1416d.d(bVar.f1419b, bVar.f1421d);
        } else if (i == 2) {
            this.f1416d.c(bVar.f1419b, bVar.f1421d);
        } else if (i == 4) {
            this.f1416d.a(bVar.f1419b, bVar.f1421d, bVar.f1420c);
        } else if (i == 8) {
            this.f1416d.a(bVar.f1419b, bVar.f1421d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public int a(int i) {
        int size = this.f1414b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1414b.get(i2);
            int i3 = bVar.f1418a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f1419b;
                    if (i4 <= i) {
                        int i5 = bVar.f1421d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f1419b;
                    if (i6 == i) {
                        i = bVar.f1421d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.f1421d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f1419b <= i) {
                i += bVar.f1421d;
            }
        }
        return i;
    }

    int a(int i, int i2) {
        int size = this.f1415c.size();
        while (i2 < size) {
            b bVar = this.f1415c.get(i2);
            int i3 = bVar.f1418a;
            if (i3 == 8) {
                int i4 = bVar.f1419b;
                if (i4 == i) {
                    i = bVar.f1421d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.f1421d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f1419b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.f1421d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.f1421d;
                }
            }
            i2++;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.j.a
    public b a(int i, int i2, int i3, Object obj) {
        b a2 = this.f1413a.a();
        if (a2 == null) {
            return new b(i, i2, i3, obj);
        }
        a2.f1418a = i;
        a2.f1419b = i2;
        a2.f1421d = i3;
        a2.f1420c = obj;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.f1415c.size();
        for (int i = 0; i < size; i++) {
            this.f1416d.a(this.f1415c.get(i));
        }
        a(this.f1415c);
        this.h = 0;
    }

    @Override // androidx.recyclerview.widget.j.a
    public void a(b bVar) {
        if (!this.f) {
            bVar.f1420c = null;
            this.f1413a.a(bVar);
        }
    }

    void a(b bVar, int i) {
        this.f1416d.b(bVar);
        int i2 = bVar.f1418a;
        if (i2 == 2) {
            this.f1416d.b(i, bVar.f1421d);
        } else if (i2 == 4) {
            this.f1416d.a(i, bVar.f1421d, bVar.f1420c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f1414b.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.f1414b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a();
        int size = this.f1414b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1414b.get(i);
            int i2 = bVar.f1418a;
            if (i2 == 1) {
                this.f1416d.a(bVar);
                this.f1416d.d(bVar.f1419b, bVar.f1421d);
            } else if (i2 == 2) {
                this.f1416d.a(bVar);
                this.f1416d.b(bVar.f1419b, bVar.f1421d);
            } else if (i2 == 4) {
                this.f1416d.a(bVar);
                this.f1416d.a(bVar.f1419b, bVar.f1421d, bVar.f1420c);
            } else if (i2 == 8) {
                this.f1416d.a(bVar);
                this.f1416d.a(bVar.f1419b, bVar.f1421d);
            }
            Runnable runnable = this.f1417e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f1414b);
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1414b.add(a(2, i, i2, null));
        this.h |= 2;
        return this.f1414b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f1414b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i) {
        return (i & this.h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return !this.f1415c.isEmpty() && !this.f1414b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.g.a(this.f1414b);
        int size = this.f1414b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1414b.get(i);
            int i2 = bVar.f1418a;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar);
            } else if (i2 == 4) {
                e(bVar);
            } else if (i2 == 8) {
                c(bVar);
            }
            Runnable runnable = this.f1417e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1414b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        a(this.f1414b);
        a(this.f1415c);
        this.h = 0;
    }
}
