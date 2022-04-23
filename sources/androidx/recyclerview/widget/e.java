package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {
    static final ThreadLocal<e> f = new ThreadLocal<>();
    static Comparator<c> g = new a();

    /* renamed from: c  reason: collision with root package name */
    long f1474c;

    /* renamed from: d  reason: collision with root package name */
    long f1475d;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f1473b = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<c> f1476e = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a implements Comparator<c> {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if ((cVar.f1484d == null) != (cVar2.f1484d == null)) {
                return cVar.f1484d == null ? 1 : -1;
            }
            boolean z = cVar.f1481a;
            if (z != cVar2.f1481a) {
                return z ? -1 : 1;
            }
            int i = cVar2.f1482b - cVar.f1482b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.f1483c - cVar2.f1483c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        int f1477a;

        /* renamed from: b  reason: collision with root package name */
        int f1478b;

        /* renamed from: c  reason: collision with root package name */
        int[] f1479c;

        /* renamed from: d  reason: collision with root package name */
        int f1480d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f1479c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1480d = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f1480d * 2;
                int[] iArr = this.f1479c;
                if (iArr == null) {
                    this.f1479c = new int[4];
                    Arrays.fill(this.f1479c, -1);
                } else if (i3 >= iArr.length) {
                    this.f1479c = new int[i3 * 2];
                    System.arraycopy(iArr, 0, this.f1479c, 0, iArr.length);
                }
                int[] iArr2 = this.f1479c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.f1480d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.f1480d = 0;
            int[] iArr = this.f1479c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.n;
            if (recyclerView.m != null && oVar != null && oVar.v()) {
                if (z) {
                    if (!recyclerView.f1333e.c()) {
                        oVar.a(recyclerView.m.a(), this);
                    }
                } else if (!recyclerView.j()) {
                    oVar.a(this.f1477a, this.f1478b, recyclerView.i0, this);
                }
                int i = this.f1480d;
                if (i > oVar.m) {
                    oVar.m = i;
                    oVar.n = z;
                    recyclerView.f1331c.j();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.f1479c != null) {
                int i2 = this.f1480d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1479c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void b(int i, int i2) {
            this.f1477a = i;
            this.f1478b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1481a;

        /* renamed from: b  reason: collision with root package name */
        public int f1482b;

        /* renamed from: c  reason: collision with root package name */
        public int f1483c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f1484d;

        /* renamed from: e  reason: collision with root package name */
        public int f1485e;

        c() {
        }

        public void a() {
            this.f1481a = false;
            this.f1482b = 0;
            this.f1483c = 0;
            this.f1484d = null;
            this.f1485e = 0;
        }
    }

    private RecyclerView.d0 a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f1331c;
        try {
            recyclerView.q();
            RecyclerView.d0 a2 = vVar.a(i, false, j);
            if (a2 != null) {
                if (!a2.m() || a2.n()) {
                    vVar.a(a2, false);
                } else {
                    vVar.b(a2.f1346a);
                }
            }
            return a2;
        } finally {
            recyclerView.a(false);
        }
    }

    private void a() {
        c cVar;
        int size = this.f1473b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f1473b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.h0.a(recyclerView, false);
                i += recyclerView.h0.f1480d;
            }
        }
        this.f1476e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f1473b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.h0;
                int abs = Math.abs(bVar.f1477a) + Math.abs(bVar.f1478b);
                int i5 = i3;
                for (int i6 = 0; i6 < bVar.f1480d * 2; i6 += 2) {
                    if (i5 >= this.f1476e.size()) {
                        cVar = new c();
                        this.f1476e.add(cVar);
                    } else {
                        cVar = this.f1476e.get(i5);
                    }
                    int i7 = bVar.f1479c[i6 + 1];
                    cVar.f1481a = i7 <= abs;
                    cVar.f1482b = abs;
                    cVar.f1483c = i7;
                    cVar.f1484d = recyclerView2;
                    cVar.f1485e = bVar.f1479c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f1476e, g);
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.E && recyclerView.f.b() != 0) {
                recyclerView.t();
            }
            b bVar = recyclerView.h0;
            bVar.a(recyclerView, true);
            if (bVar.f1480d != 0) {
                try {
                    a.g.h.a.a("RV Nested Prefetch");
                    recyclerView.i0.a(recyclerView.m);
                    for (int i = 0; i < bVar.f1480d * 2; i += 2) {
                        a(recyclerView, bVar.f1479c[i], j);
                    }
                } finally {
                    a.g.h.a.a();
                }
            }
        }
    }

    private void a(c cVar, long j) {
        RecyclerView.d0 a2 = a(cVar.f1484d, cVar.f1485e, cVar.f1481a ? Long.MAX_VALUE : j);
        if (a2 != null && a2.f1347b != null && a2.m() && !a2.n()) {
            a(a2.f1347b.get(), j);
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int b2 = recyclerView.f.b();
        for (int i2 = 0; i2 < b2; i2++) {
            RecyclerView.d0 k = RecyclerView.k(recyclerView.f.d(i2));
            if (k.f1348c == i && !k.n()) {
                return true;
            }
        }
        return false;
    }

    private void b(long j) {
        for (int i = 0; i < this.f1476e.size(); i++) {
            c cVar = this.f1476e.get(i);
            if (cVar.f1484d != null) {
                a(cVar, j);
                cVar.a();
            } else {
                return;
            }
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    public void a(RecyclerView recyclerView) {
        this.f1473b.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f1474c == 0) {
            this.f1474c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.h0.b(i, i2);
    }

    public void b(RecyclerView recyclerView) {
        this.f1473b.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.g.h.a.a("RV Prefetch");
            if (!this.f1473b.isEmpty()) {
                int size = this.f1473b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f1473b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.f1475d);
                }
            }
        } finally {
            this.f1474c = 0L;
            a.g.h.a.a();
        }
    }
}
