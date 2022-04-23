package com.airbnb.lottie.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.u.k.k;
import com.airbnb.lottie.x.g;
import com.airbnb.lottie.y.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class q implements e, n, j, a.AbstractC0063a, k {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f2225a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f2226b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final f f2227c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.u.l.a f2228d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2229e;
    private final boolean f;
    private final a<Float, Float> g;
    private final a<Float, Float> h;
    private final o i;
    private d j;

    public q(f fVar, com.airbnb.lottie.u.l.a aVar, k kVar) {
        this.f2227c = fVar;
        this.f2228d = aVar;
        this.f2229e = kVar.b();
        this.f = kVar.e();
        this.g = kVar.a().a();
        aVar.a(this.g);
        this.g.a(this);
        this.h = kVar.c().a();
        aVar.a(this.h);
        this.h.a(this);
        this.i = kVar.d().a();
        this.i.a(aVar);
        this.i.a(this);
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.f2229e;
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.g.f().floatValue();
        float floatValue2 = this.h.f().floatValue();
        float floatValue3 = this.i.d().f().floatValue() / 100.0f;
        float floatValue4 = this.i.a().f().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f2225a.set(matrix);
            float f = i2;
            this.f2225a.preConcat(this.i.a(f + floatValue2));
            this.j.a(canvas, this.f2225a, (int) (i * g.c(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.j.a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.u.f
    public void a(e eVar, int i, List<e> list, e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, c<T> cVar) {
        a<Float, Float> aVar;
        if (!this.i.a(t, cVar)) {
            if (t == com.airbnb.lottie.k.q) {
                aVar = this.g;
            } else if (t == com.airbnb.lottie.k.r) {
                aVar = this.h;
            } else {
                return;
            }
            aVar.a((c<Float>) cVar);
        }
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        this.j.a(list, list2);
    }

    @Override // com.airbnb.lottie.s.b.j
    public void a(ListIterator<c> listIterator) {
        if (this.j == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.j = new d(this.f2227c, this.f2228d, "Repeater", this.f, arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        this.f2227c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.n
    public Path c() {
        Path c2 = this.j.c();
        this.f2226b.reset();
        float floatValue = this.g.f().floatValue();
        float floatValue2 = this.h.f().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f2225a.set(this.i.a(i + floatValue2));
            this.f2226b.addPath(c2, this.f2225a);
        }
        return this.f2226b;
    }
}
