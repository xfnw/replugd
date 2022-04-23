package com.airbnb.lottie.w;

import android.graphics.PointF;
import com.airbnb.lottie.w.k0.c;

/* loaded from: classes.dex */
public class y implements j0<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f2488a = new y();

    private y() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.j0
    public PointF a(c cVar, float f) {
        c.b x = cVar.x();
        if (!(x == c.b.BEGIN_ARRAY || x == c.b.BEGIN_OBJECT)) {
            if (x == c.b.NUMBER) {
                PointF pointF = new PointF(((float) cVar.t()) * f, ((float) cVar.t()) * f);
                while (cVar.r()) {
                    cVar.z();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + x);
        }
        return p.d(cVar, f);
    }
}
