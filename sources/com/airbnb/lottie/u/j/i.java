package com.airbnb.lottie.u.j;

import android.graphics.PointF;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.m;
import java.util.List;

/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f2294a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2295b;

    public i(b bVar, b bVar2) {
        this.f2294a = bVar;
        this.f2295b = bVar2;
    }

    @Override // com.airbnb.lottie.u.j.m
    public a<PointF, PointF> a() {
        return new m(this.f2294a.a(), this.f2295b.a());
    }

    @Override // com.airbnb.lottie.u.j.m
    public List<com.airbnb.lottie.y.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.u.j.m
    public boolean c() {
        return this.f2294a.c() && this.f2295b.c();
    }
}
