package com.airbnb.lottie.u.j;

import android.graphics.PointF;
import com.airbnb.lottie.s.c.i;
import com.airbnb.lottie.s.c.j;
import com.airbnb.lottie.y.a;
import java.util.List;

/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<PointF>> f2293a;

    public e(List<a<PointF>> list) {
        this.f2293a = list;
    }

    @Override // com.airbnb.lottie.u.j.m
    public com.airbnb.lottie.s.c.a<PointF, PointF> a() {
        return this.f2293a.get(0).g() ? new j(this.f2293a) : new i(this.f2293a);
    }

    @Override // com.airbnb.lottie.u.j.m
    public List<a<PointF>> b() {
        return this.f2293a;
    }

    @Override // com.airbnb.lottie.u.j.m
    public boolean c() {
        return this.f2293a.size() == 1 && this.f2293a.get(0).g();
    }
}
