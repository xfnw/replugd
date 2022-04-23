package a.a.n;

import a.g.l.w;
import a.g.l.x;
import a.g.l.y;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f56c;

    /* renamed from: d  reason: collision with root package name */
    x f57d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f58e;

    /* renamed from: b  reason: collision with root package name */
    private long f55b = -1;
    private final y f = new a();

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<w> f54a = new ArrayList<>();

    /* loaded from: classes.dex */
    class a extends y {

        /* renamed from: a  reason: collision with root package name */
        private boolean f59a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f60b = 0;

        a() {
        }

        void a() {
            this.f60b = 0;
            this.f59a = false;
            h.this.b();
        }

        @Override // a.g.l.x
        public void a(View view) {
            int i = this.f60b + 1;
            this.f60b = i;
            if (i == h.this.f54a.size()) {
                x xVar = h.this.f57d;
                if (xVar != null) {
                    xVar.a(null);
                }
                a();
            }
        }

        @Override // a.g.l.y, a.g.l.x
        public void b(View view) {
            if (!this.f59a) {
                this.f59a = true;
                x xVar = h.this.f57d;
                if (xVar != null) {
                    xVar.b(null);
                }
            }
        }
    }

    public h a(long j) {
        if (!this.f58e) {
            this.f55b = j;
        }
        return this;
    }

    public h a(w wVar) {
        if (!this.f58e) {
            this.f54a.add(wVar);
        }
        return this;
    }

    public h a(w wVar, w wVar2) {
        this.f54a.add(wVar);
        wVar2.b(wVar.b());
        this.f54a.add(wVar2);
        return this;
    }

    public h a(x xVar) {
        if (!this.f58e) {
            this.f57d = xVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f58e) {
            this.f56c = interpolator;
        }
        return this;
    }

    public void a() {
        if (this.f58e) {
            Iterator<w> it = this.f54a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f58e = false;
        }
    }

    void b() {
        this.f58e = false;
    }

    public void c() {
        if (!this.f58e) {
            Iterator<w> it = this.f54a.iterator();
            while (it.hasNext()) {
                w next = it.next();
                long j = this.f55b;
                if (j >= 0) {
                    next.a(j);
                }
                Interpolator interpolator = this.f56c;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.f57d != null) {
                    next.a(this.f);
                }
                next.c();
            }
            this.f58e = true;
        }
    }
}
