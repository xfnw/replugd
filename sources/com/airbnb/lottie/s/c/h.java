package com.airbnb.lottie.s.c;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.y.a;

/* loaded from: classes.dex */
public class h extends a<PointF> {
    private Path o;
    private final a<PointF> p;

    public h(d dVar, a<PointF> aVar) {
        super(dVar, aVar.f2505b, aVar.f2506c, aVar.f2507d, aVar.f2508e, aVar.f);
        this.p = aVar;
        h();
    }

    public void h() {
        T t;
        T t2 = this.f2506c;
        boolean z = (t2 == 0 || (t = this.f2505b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f2506c;
        if (t3 != 0 && !z) {
            a<PointF> aVar = this.p;
            this.o = com.airbnb.lottie.x.h.a((PointF) this.f2505b, (PointF) t3, aVar.m, aVar.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path i() {
        return this.o;
    }
}
