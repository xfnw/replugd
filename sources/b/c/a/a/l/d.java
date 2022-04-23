package b.c.a.a.l;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import b.c.a.a.l.c;

/* loaded from: classes.dex */
public interface d extends c.a {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f1742b = new b();

        /* renamed from: a  reason: collision with root package name */
        private final e f1743a = new e();

        /* renamed from: a */
        public e evaluate(float f, e eVar, e eVar2) {
            this.f1743a.a(b.c.a.a.n.a.a(eVar.f1746a, eVar2.f1746a, f), b.c.a.a.n.a.a(eVar.f1747b, eVar2.f1747b, f), b.c.a.a.n.a.a(eVar.f1748c, eVar2.f1748c, f));
            return this.f1743a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, e> f1744a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        /* renamed from: a */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        /* renamed from: a */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: b.c.a.a.l.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054d extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f1745a = new C0054d("circularRevealScrimColor");

        private C0054d(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        /* renamed from: a */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f1746a;

        /* renamed from: b  reason: collision with root package name */
        public float f1747b;

        /* renamed from: c  reason: collision with root package name */
        public float f1748c;

        private e() {
        }

        public e(float f, float f2, float f3) {
            this.f1746a = f;
            this.f1747b = f2;
            this.f1748c = f3;
        }

        public void a(float f, float f2, float f3) {
            this.f1746a = f;
            this.f1747b = f2;
            this.f1748c = f3;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
