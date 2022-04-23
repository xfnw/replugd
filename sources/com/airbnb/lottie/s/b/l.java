package com.airbnb.lottie.s.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.u.k.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes.dex */
public class l implements n, j {

    /* renamed from: a  reason: collision with root package name */
    private final Path f2208a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f2209b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f2210c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final List<n> f2211d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final h f2212e;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2213a = new int[h.a.values().length];

        static {
            try {
                f2213a[h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2213a[h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2213a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2213a[h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2213a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(h hVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            hVar.b();
            this.f2212e = hVar;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f2209b.reset();
        this.f2208a.reset();
        for (int size = this.f2211d.size() - 1; size >= 1; size--) {
            n nVar = this.f2211d.get(size);
            if (nVar instanceof d) {
                d dVar = (d) nVar;
                List<n> d2 = dVar.d();
                for (int size2 = d2.size() - 1; size2 >= 0; size2--) {
                    Path c2 = d2.get(size2).c();
                    c2.transform(dVar.e());
                    this.f2209b.addPath(c2);
                }
            } else {
                this.f2209b.addPath(nVar.c());
            }
        }
        n nVar2 = this.f2211d.get(0);
        if (nVar2 instanceof d) {
            d dVar2 = (d) nVar2;
            List<n> d3 = dVar2.d();
            for (int i = 0; i < d3.size(); i++) {
                Path c3 = d3.get(i).c();
                c3.transform(dVar2.e());
                this.f2208a.addPath(c3);
            }
        } else {
            this.f2208a.set(nVar2.c());
        }
        this.f2210c.op(this.f2208a, this.f2209b, op);
    }

    private void b() {
        for (int i = 0; i < this.f2211d.size(); i++) {
            this.f2210c.addPath(this.f2211d.get(i).c());
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < this.f2211d.size(); i++) {
            this.f2211d.get(i).a(list, list2);
        }
    }

    @Override // com.airbnb.lottie.s.b.j
    public void a(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof n) {
                this.f2211d.add((n) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.s.b.n
    public Path c() {
        Path.Op op;
        this.f2210c.reset();
        if (this.f2212e.c()) {
            return this.f2210c;
        }
        int i = a.f2213a[this.f2212e.a().ordinal()];
        if (i != 1) {
            if (i == 2) {
                op = Path.Op.UNION;
            } else if (i == 3) {
                op = Path.Op.REVERSE_DIFFERENCE;
            } else if (i == 4) {
                op = Path.Op.INTERSECT;
            } else if (i == 5) {
                op = Path.Op.XOR;
            }
            a(op);
        } else {
            b();
        }
        return this.f2210c;
    }
}
