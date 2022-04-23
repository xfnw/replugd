package com.airbnb.lottie.s.c;

import android.graphics.PointF;
import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.c;
import java.util.List;

/* loaded from: classes.dex */
public class j extends f<PointF> {
    private final PointF l = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.s.c.a
    public PointF a(a<PointF> aVar, float f) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f2505b;
        if (pointF3 == null || (pointF = aVar.f2506c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        c<A> cVar = this.f2244e;
        if (cVar != 0 && (pointF2 = (PointF) cVar.a(aVar.f2508e, aVar.f.floatValue(), pointF4, pointF5, f, d(), e())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.l;
        float f2 = pointF4.x;
        float f3 = pointF4.y;
        pointF6.set(f2 + ((pointF5.x - f2) * f), f3 + (f * (pointF5.y - f3)));
        return this.l;
    }
}
