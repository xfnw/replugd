package com.airbnb.lottie.s.c;

import android.graphics.Path;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.a;
import java.util.List;

/* loaded from: classes.dex */
public class l extends a<com.airbnb.lottie.u.k.l, Path> {
    private final com.airbnb.lottie.u.k.l l = new com.airbnb.lottie.u.k.l();
    private final Path m = new Path();

    public l(List<a<com.airbnb.lottie.u.k.l>> list) {
        super(list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.s.c.a
    public Path a(a<com.airbnb.lottie.u.k.l> aVar, float f) {
        this.l.a(aVar.f2505b, aVar.f2506c, f);
        g.a(this.l, this.m);
        return this.m;
    }
}
