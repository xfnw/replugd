package com.airbnb.lottie.u.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.s.b.d;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.n;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class f extends a {
    private final d w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        this.w = new d(fVar, this, new n("__container", dVar.l(), false));
        this.w.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.w.a(rectF, this.m, z);
    }

    @Override // com.airbnb.lottie.u.l.a
    void b(Canvas canvas, Matrix matrix, int i) {
        this.w.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.u.l.a
    protected void b(e eVar, int i, List<e> list, e eVar2) {
        this.w.a(eVar, i, list, eVar2);
    }
}
