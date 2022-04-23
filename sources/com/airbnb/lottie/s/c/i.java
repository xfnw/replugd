package com.airbnb.lottie.s.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class i extends f<PointF> {
    private h n;
    private final PointF l = new PointF();
    private final float[] m = new float[2];
    private PathMeasure o = new PathMeasure();

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.s.c.a
    public PointF a(a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path i = hVar.i();
        if (i == null) {
            return aVar.f2505b;
        }
        c<A> cVar = this.f2244e;
        if (cVar != 0 && (pointF = (PointF) cVar.a(hVar.f2508e, hVar.f.floatValue(), hVar.f2505b, hVar.f2506c, d(), f, e())) != null) {
            return pointF;
        }
        if (this.n != hVar) {
            this.o.setPath(i, false);
            this.n = hVar;
        }
        PathMeasure pathMeasure = this.o;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.m, null);
        PointF pointF2 = this.l;
        float[] fArr = this.m;
        pointF2.set(fArr[0], fArr[1]);
        return this.l;
    }
}
