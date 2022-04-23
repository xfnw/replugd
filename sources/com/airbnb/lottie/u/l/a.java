package com.airbnb.lottie.u.l;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.s.b.e;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.c;
import com.airbnb.lottie.s.c.g;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.u.f;
import com.airbnb.lottie.u.k.g;
import com.airbnb.lottie.u.k.l;
import com.airbnb.lottie.u.l.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements e, a.AbstractC0063a, f {
    private final String l;
    final com.airbnb.lottie.f n;
    final d o;
    private g p;
    private a q;
    private a r;
    private List<a> s;
    final o u;

    /* renamed from: a  reason: collision with root package name */
    private final Path f2398a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f2399b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f2400c = new com.airbnb.lottie.s.a(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f2401d = new com.airbnb.lottie.s.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f2402e = new com.airbnb.lottie.s.a(1, PorterDuff.Mode.DST_OUT);
    private final Paint f = new com.airbnb.lottie.s.a(1);
    private final Paint g = new com.airbnb.lottie.s.a(PorterDuff.Mode.CLEAR);
    private final RectF h = new RectF();
    private final RectF i = new RectF();
    private final RectF j = new RectF();
    private final RectF k = new RectF();
    final Matrix m = new Matrix();
    private final List<com.airbnb.lottie.s.c.a<?, ?>> t = new ArrayList();
    private boolean v = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.u.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a implements a.AbstractC0063a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f2403a;

        C0064a(c cVar) {
            this.f2403a = cVar;
        }

        @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
        public void b() {
            a.this.a(this.f2403a.i() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2405a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2406b = new int[g.a.values().length];

        static {
            try {
                f2406b[g.a.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2406b[g.a.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2406b[g.a.MASK_MODE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2405a = new int[d.a.values().length];
            try {
                f2405a[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2405a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2405a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2405a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2405a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2405a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2405a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, d dVar) {
        Paint paint;
        PorterDuffXfermode porterDuffXfermode;
        this.n = fVar;
        this.o = dVar;
        this.l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            paint = this.f;
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        } else {
            paint = this.f;
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        }
        paint.setXfermode(porterDuffXfermode);
        this.u = dVar.u().a();
        this.u.a((a.AbstractC0063a) this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            this.p = new com.airbnb.lottie.s.c.g(dVar.e());
            for (com.airbnb.lottie.s.c.a<l, Path> aVar : this.p.a()) {
                aVar.a(this);
            }
            for (com.airbnb.lottie.s.c.a<Integer, Integer> aVar2 : this.p.c()) {
                a(aVar2);
                aVar2.a(this);
            }
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(d dVar, com.airbnb.lottie.f fVar, com.airbnb.lottie.d dVar2) {
        switch (b.f2405a[dVar.d().ordinal()]) {
            case 1:
                return new f(fVar, dVar);
            case 2:
                return new com.airbnb.lottie.u.l.b(fVar, dVar, dVar2.c(dVar.k()), dVar2);
            case 3:
                return new g(fVar, dVar);
            case 4:
                return new c(fVar, dVar);
            case 5:
                return new e(fVar, dVar);
            case 6:
                return new h(fVar, dVar);
            default:
                com.airbnb.lottie.x.d.b("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void a(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    private void a(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        a(canvas, this.h, this.f2401d, false);
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i = 0; i < this.p.b().size(); i++) {
            com.airbnb.lottie.u.k.g gVar = this.p.b().get(i);
            com.airbnb.lottie.s.c.a<l, Path> aVar = this.p.a().get(i);
            com.airbnb.lottie.s.c.a<Integer, Integer> aVar2 = this.p.c().get(i);
            int i2 = b.f2406b[gVar.a().ordinal()];
            if (i2 == 1) {
                if (i == 0) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.h, paint);
                }
                if (gVar.d()) {
                    e(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    f(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (gVar.d()) {
                        c(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        a(canvas, matrix, gVar, aVar, aVar2);
                    }
                }
            } else if (gVar.d()) {
                d(canvas, matrix, gVar, aVar, aVar2);
            } else {
                b(canvas, matrix, gVar, aVar, aVar2);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, com.airbnb.lottie.u.k.g gVar, com.airbnb.lottie.s.c.a<l, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        this.f2398a.set(aVar.f());
        this.f2398a.transform(matrix);
        this.f2400c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.f2398a, this.f2400c);
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    private void a(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (d()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                com.airbnb.lottie.u.k.g gVar = this.p.b().get(i);
                this.f2398a.set(this.p.a().get(i).f());
                this.f2398a.transform(matrix);
                int i2 = b.f2406b[gVar.a().ordinal()];
                if (i2 == 1) {
                    return;
                }
                if ((i2 != 2 && i2 != 3) || !gVar.d()) {
                    this.f2398a.computeBounds(this.k, false);
                    RectF rectF2 = this.i;
                    if (i == 0) {
                        rectF2.set(this.k);
                    } else {
                        rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.i)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.v) {
            this.v = z;
            g();
        }
    }

    private void b(float f) {
        this.n.e().k().a(this.o.g(), f);
    }

    private void b(Canvas canvas, Matrix matrix, com.airbnb.lottie.u.k.g gVar, com.airbnb.lottie.s.c.a<l, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        a(canvas, this.h, this.f2401d, true);
        this.f2398a.set(aVar.f());
        this.f2398a.transform(matrix);
        this.f2400c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.f2398a, this.f2400c);
        canvas.restore();
    }

    private void b(RectF rectF, Matrix matrix) {
        if (e() && this.o.f() != d.b.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.q.a(this.j, matrix, true);
            if (!rectF.intersect(this.j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void c(Canvas canvas, Matrix matrix, com.airbnb.lottie.u.k.g gVar, com.airbnb.lottie.s.c.a<l, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        a(canvas, this.h, this.f2400c, true);
        canvas.drawRect(this.h, this.f2400c);
        this.f2398a.set(aVar.f());
        this.f2398a.transform(matrix);
        this.f2400c.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        canvas.drawPath(this.f2398a, this.f2402e);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.airbnb.lottie.u.k.g gVar, com.airbnb.lottie.s.c.a<l, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        a(canvas, this.h, this.f2401d, true);
        canvas.drawRect(this.h, this.f2400c);
        this.f2402e.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        this.f2398a.set(aVar.f());
        this.f2398a.transform(matrix);
        canvas.drawPath(this.f2398a, this.f2402e);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, com.airbnb.lottie.u.k.g gVar, com.airbnb.lottie.s.c.a<l, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        a(canvas, this.h, this.f2402e, true);
        canvas.drawRect(this.h, this.f2400c);
        this.f2402e.setAlpha((int) (aVar2.f().intValue() * 2.55f));
        this.f2398a.set(aVar.f());
        this.f2398a.transform(matrix);
        canvas.drawPath(this.f2398a, this.f2402e);
        canvas.restore();
    }

    private void f() {
        if (this.s == null) {
            if (this.r == null) {
                this.s = Collections.emptyList();
                return;
            }
            this.s = new ArrayList();
            for (a aVar = this.r; aVar != null; aVar = aVar.r) {
                this.s.add(aVar);
            }
        }
    }

    private void f(Canvas canvas, Matrix matrix, com.airbnb.lottie.u.k.g gVar, com.airbnb.lottie.s.c.a<l, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        this.f2398a.set(aVar.f());
        this.f2398a.transform(matrix);
        canvas.drawPath(this.f2398a, this.f2402e);
    }

    private void g() {
        this.n.invalidateSelf();
    }

    private void h() {
        boolean z = true;
        if (!this.o.c().isEmpty()) {
            c cVar = new c(this.o.c());
            cVar.h();
            cVar.a(new C0064a(cVar));
            if (cVar.f().floatValue() != 1.0f) {
                z = false;
            }
            a(z);
            a(cVar);
            return;
        }
        a(true);
    }

    @Override // com.airbnb.lottie.s.b.c
    public String a() {
        return this.o.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        this.u.b(f);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                this.p.a().get(i).a(f);
            }
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        a aVar = this.q;
        if (aVar != null) {
            this.q.a(aVar.o.t() * f);
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            this.t.get(i2).a(f);
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.a(this.l);
        if (!this.v || this.o.v()) {
            com.airbnb.lottie.c.b(this.l);
            return;
        }
        f();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.f2399b.reset();
        this.f2399b.set(matrix);
        for (int size = this.s.size() - 1; size >= 0; size--) {
            this.f2399b.preConcat(this.s.get(size).u.b());
        }
        com.airbnb.lottie.c.b("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * (this.u.c() == null ? 100 : this.u.c().f().intValue())) / 100.0f) * 255.0f);
        if (e() || d()) {
            com.airbnb.lottie.c.a("Layer#computeBounds");
            a(this.h, this.f2399b, false);
            b(this.h, matrix);
            this.f2399b.preConcat(this.u.b());
            a(this.h, this.f2399b);
            if (!this.h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.c.b("Layer#computeBounds");
            if (!this.h.isEmpty()) {
                com.airbnb.lottie.c.a("Layer#saveLayer");
                a(canvas, this.h, this.f2400c, true);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                a(canvas);
                com.airbnb.lottie.c.a("Layer#drawLayer");
                b(canvas, this.f2399b, intValue);
                com.airbnb.lottie.c.b("Layer#drawLayer");
                if (d()) {
                    a(canvas, this.f2399b);
                }
                if (e()) {
                    com.airbnb.lottie.c.a("Layer#drawMatte");
                    com.airbnb.lottie.c.a("Layer#saveLayer");
                    a(canvas, this.h, this.f, false);
                    com.airbnb.lottie.c.b("Layer#saveLayer");
                    a(canvas);
                    this.q.a(canvas, matrix, intValue);
                    com.airbnb.lottie.c.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.c.b("Layer#restoreLayer");
                    com.airbnb.lottie.c.b("Layer#drawMatte");
                }
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
            }
            b(com.airbnb.lottie.c.b(this.l));
            return;
        }
        this.f2399b.preConcat(this.u.b());
        com.airbnb.lottie.c.a("Layer#drawLayer");
        b(canvas, this.f2399b, intValue);
        com.airbnb.lottie.c.b("Layer#drawLayer");
        b(com.airbnb.lottie.c.b(this.l));
    }

    @Override // com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        f();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.s;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.s.get(size).u.b());
                }
            } else {
                a aVar = this.r;
                if (aVar != null) {
                    this.m.preConcat(aVar.u.b());
                }
            }
        }
        this.m.preConcat(this.u.b());
    }

    public void a(com.airbnb.lottie.s.c.a<?, ?> aVar) {
        if (aVar != null) {
            this.t.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.u.f
    public void a(com.airbnb.lottie.u.e eVar, int i, List<com.airbnb.lottie.u.e> list, com.airbnb.lottie.u.e eVar2) {
        if (eVar.c(a(), i)) {
            if (!"__container".equals(a())) {
                eVar2 = eVar2.a(a());
                if (eVar.a(a(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(a(), i)) {
                b(eVar, i + eVar.b(a(), i), list, eVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.q = aVar;
    }

    @Override // com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        this.u.a(t, cVar);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void a(List<com.airbnb.lottie.s.b.c> list, List<com.airbnb.lottie.s.b.c> list2) {
    }

    @Override // com.airbnb.lottie.s.c.a.AbstractC0063a
    public void b() {
        g();
    }

    abstract void b(Canvas canvas, Matrix matrix, int i);

    public void b(com.airbnb.lottie.s.c.a<?, ?> aVar) {
        this.t.remove(aVar);
    }

    void b(com.airbnb.lottie.u.e eVar, int i, List<com.airbnb.lottie.u.e> list, com.airbnb.lottie.u.e eVar2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        this.r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d c() {
        return this.o;
    }

    boolean d() {
        com.airbnb.lottie.s.c.g gVar = this.p;
        return gVar != null && !gVar.a().isEmpty();
    }

    boolean e() {
        return this.q != null;
    }
}
