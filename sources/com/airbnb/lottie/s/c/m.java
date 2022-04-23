package com.airbnb.lottie.s.c;

import android.graphics.PointF;
import com.airbnb.lottie.y.a;
import java.util.Collections;

/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {
    private final PointF l = new PointF();
    private final a<Float, Float> m;
    private final a<Float, Float> n;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.m = aVar;
        this.n = aVar2;
        a(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.s.c.a
    public PointF a(a<PointF> aVar, float f) {
        return this.l;
    }

    @Override // com.airbnb.lottie.s.c.a
    public void a(float f) {
        this.m.a(f);
        this.n.a(f);
        this.l.set(this.m.f().floatValue(), this.n.f().floatValue());
        for (int i = 0; i < this.f2240a.size(); i++) {
            this.f2240a.get(i).b();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.s.c.a
    public PointF f() {
        return a((a<PointF>) null, 0.0f);
    }
}
