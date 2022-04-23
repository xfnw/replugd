package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    final AbstractC0044b f1422a;

    /* renamed from: b  reason: collision with root package name */
    final a f1423b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f1424c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f1425a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f1426b;

        a() {
        }

        private void b() {
            if (this.f1426b == null) {
                this.f1426b = new a();
            }
        }

        void a() {
            this.f1425a = 0L;
            a aVar = this.f1426b;
            if (aVar != null) {
                aVar.a();
            }
        }

        void a(int i) {
            if (i >= 64) {
                a aVar = this.f1426b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f1425a &= (1 << i) ^ (-1);
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f1426b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1425a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f1425a;
            this.f1425a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.f1426b != null) {
                b();
                this.f1426b.a(0, z2);
            }
        }

        int b(int i) {
            a aVar = this.f1426b;
            return aVar == null ? i >= 64 ? Long.bitCount(this.f1425a) : Long.bitCount(this.f1425a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f1425a & ((1 << i) - 1)) : aVar.b(i - 64) + Long.bitCount(this.f1425a);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f1425a & (1 << i)) != 0;
            }
            b();
            return this.f1426b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f1426b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1425a & j) != 0;
            this.f1425a &= j ^ (-1);
            long j2 = j - 1;
            long j3 = this.f1425a;
            this.f1425a = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            a aVar = this.f1426b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f1426b.d(0);
            }
            return z;
        }

        void e(int i) {
            if (i >= 64) {
                b();
                this.f1426b.e(i - 64);
                return;
            }
            this.f1425a |= 1 << i;
        }

        public String toString() {
            if (this.f1426b == null) {
                return Long.toBinaryString(this.f1425a);
            }
            return this.f1426b.toString() + "xx" + Long.toBinaryString(this.f1425a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0044b {
        View a(int i);

        void a();

        void a(View view);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        int b();

        RecyclerView.d0 b(View view);

        void b(int i);

        void c(int i);

        void c(View view);

        int d(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbstractC0044b bVar) {
        this.f1422a = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r4.f1423b.c(r2) == false) goto L_0x0024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int f(int r5) {
        /*
            r4 = this;
            r0 = -1
            if (r5 >= 0) goto L_0x0004
            return r0
        L_0x0004:
            androidx.recyclerview.widget.b$b r1 = r4.f1422a
            int r1 = r1.b()
            r2 = r5
        L_0x000b:
            if (r2 >= r1) goto L_0x0027
            androidx.recyclerview.widget.b$a r3 = r4.f1423b
            int r3 = r3.b(r2)
            int r3 = r2 - r3
            int r3 = r5 - r3
            if (r3 != 0) goto L_0x0025
        L_0x0019:
            androidx.recyclerview.widget.b$a r5 = r4.f1423b
            boolean r5 = r5.c(r2)
            if (r5 == 0) goto L_0x0024
            int r2 = r2 + 1
            goto L_0x0019
        L_0x0024:
            return r2
        L_0x0025:
            int r2 = r2 + r3
            goto L_0x000b
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b.f(int):int");
    }

    private void g(View view) {
        this.f1424c.add(view);
        this.f1422a.a(view);
    }

    private boolean h(View view) {
        if (!this.f1424c.remove(view)) {
            return false;
        }
        this.f1422a.c(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1422a.b() - this.f1424c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        this.f1423b.d(f);
        this.f1422a.c(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int d2 = this.f1422a.d(view);
        if (d2 >= 0) {
            this.f1423b.e(d2);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int b2 = i < 0 ? this.f1422a.b() : f(i);
        this.f1423b.a(b2, z);
        if (z) {
            g(view);
        }
        this.f1422a.a(view, b2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int b2 = i < 0 ? this.f1422a.b() : f(i);
        this.f1423b.a(b2, z);
        if (z) {
            g(view);
        }
        this.f1422a.a(view, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1422a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int d2 = this.f1422a.d(view);
        if (d2 != -1 && !this.f1423b.c(d2)) {
            return d2 - this.f1423b.b(d2);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        int size = this.f1424c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f1424c.get(i2);
            RecyclerView.d0 b2 = this.f1422a.b(view);
            if (!(b2.i() != i || b2.n() || b2.p())) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        return this.f1422a.a(f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1423b.a();
        for (int size = this.f1424c.size() - 1; size >= 0; size--) {
            this.f1422a.c(this.f1424c.get(size));
            this.f1424c.remove(size);
        }
        this.f1422a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f1424c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.f1422a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int d2 = this.f1422a.d(view);
        if (d2 >= 0) {
            if (this.f1423b.d(d2)) {
                h(view);
            }
            this.f1422a.b(d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        View a2 = this.f1422a.a(f);
        if (a2 != null) {
            if (this.f1423b.d(f)) {
                h(a2);
            }
            this.f1422a.b(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(View view) {
        int d2 = this.f1422a.d(view);
        if (d2 == -1) {
            h(view);
            return true;
        } else if (!this.f1423b.c(d2)) {
            return false;
        } else {
            this.f1423b.d(d2);
            h(view);
            this.f1422a.b(d2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(View view) {
        int d2 = this.f1422a.d(view);
        if (d2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f1423b.c(d2)) {
            this.f1423b.a(d2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f1423b.toString() + ", hidden list:" + this.f1424c.size();
    }
}
