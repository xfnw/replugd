package com.airbnb.lottie.s.b;

import android.graphics.Path;
import com.airbnb.lottie.f;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.u.k.o;
import com.airbnb.lottie.u.k.q;
import java.util.List;

/* loaded from: classes.dex */
public class r implements n, a.AbstractC0063a {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2231b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2232c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, Path> f2233d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2234e;

    /* renamed from: a  reason: collision with root package name */
    private final Path f2230a = new Path();
    private b f = new b();

    public r(f fVar, com.airbnb.lottie.u.l.a aVar, o oVar) {
        oVar.a();
        this.f2231b = oVar.c();
        this.f2232c = fVar;
        this.f2233d = oVar.b().a();
        aVar.a(this.f2233d);
        this.f2233d.a(this);
    }

    private void d() {
        this.f2234e = false;
        this.f2232c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.g() == q.a.SIMULTANEOUSLY) {
                    this.f.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        d();
    }

    @Override // com.airbnb.lottie.s.b.n
    public Path c() {
        if (this.f2234e) {
            return this.f2230a;
        }
        this.f2230a.reset();
        if (!this.f2231b) {
            this.f2230a.set(this.f2233d.f());
            this.f2230a.setFillType(Path.FillType.EVEN_ODD);
            this.f.a(this.f2230a);
        }
        this.f2234e = true;
        return this.f2230a;
    }
}
