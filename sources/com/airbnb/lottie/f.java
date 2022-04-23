package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.airbnb.lottie.w.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: c  reason: collision with root package name */
    private com.airbnb.lottie.d f2123c;
    private com.airbnb.lottie.t.b h;
    private String i;
    private com.airbnb.lottie.b j;
    private com.airbnb.lottie.t.a k;
    com.airbnb.lottie.a l;
    r m;
    private boolean n;
    private com.airbnb.lottie.u.l.b o;
    private boolean q;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f2122b = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.x.e f2124d = new com.airbnb.lottie.x.e();

    /* renamed from: e  reason: collision with root package name */
    private float f2125e = 1.0f;
    private boolean f = true;
    private final ArrayList<o> g = new ArrayList<>();
    private int p = 255;
    private boolean r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2126a;

        a(String str) {
            this.f2126a = str;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.d(this.f2126a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2128a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2129b;

        b(int i, int i2) {
            this.f2128a = i;
            this.f2129b = i2;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.a(this.f2128a, this.f2129b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2131a;

        c(int i) {
            this.f2131a = i;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.a(this.f2131a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f2133a;

        d(float f) {
            this.f2133a = f;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.c(this.f2133a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.u.e f2135a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f2136b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.y.c f2137c;

        e(com.airbnb.lottie.u.e eVar, Object obj, com.airbnb.lottie.y.c cVar) {
            this.f2135a = eVar;
            this.f2136b = obj;
            this.f2137c = cVar;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.a(this.f2135a, this.f2136b, this.f2137c);
        }
    }

    /* renamed from: com.airbnb.lottie.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0061f implements ValueAnimator.AnimatorUpdateListener {
        C0061f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.o != null) {
                f.this.o.a(f.this.f2124d.f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements o {
        g() {
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements o {
        h() {
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2142a;

        i(int i) {
            this.f2142a = i;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.c(this.f2142a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f2144a;

        j(float f) {
            this.f2144a = f;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.b(this.f2144a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2146a;

        k(int i) {
            this.f2146a = i;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.b(this.f2146a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f2148a;

        l(float f) {
            this.f2148a = f;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.a(this.f2148a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2150a;

        m(String str) {
            this.f2150a = str;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.e(this.f2150a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2152a;

        n(String str) {
            this.f2152a = str;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.c(this.f2152a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface o {
        void a(com.airbnb.lottie.d dVar);
    }

    public f() {
        new HashSet();
        this.f2124d.addUpdateListener(new C0061f());
    }

    private float a(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f2123c.a().width(), canvas.getHeight() / this.f2123c.a().height());
    }

    private void v() {
        this.o = new com.airbnb.lottie.u.l.b(this, s.a(this.f2123c), this.f2123c.i(), this.f2123c);
    }

    private Context w() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.airbnb.lottie.t.a x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.k == null) {
            this.k = new com.airbnb.lottie.t.a(getCallback(), this.l);
        }
        return this.k;
    }

    private com.airbnb.lottie.t.b y() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.t.b bVar = this.h;
        if (bVar != null && !bVar.a(w())) {
            this.h = null;
        }
        if (this.h == null) {
            this.h = new com.airbnb.lottie.t.b(getCallback(), this.i, this.j, this.f2123c.h());
        }
        return this.h;
    }

    private void z() {
        if (this.f2123c != null) {
            float n2 = n();
            setBounds(0, 0, (int) (this.f2123c.a().width() * n2), (int) (this.f2123c.a().height() * n2));
        }
    }

    public Bitmap a(String str) {
        com.airbnb.lottie.t.b y = y();
        if (y != null) {
            return y.a(str);
        }
        return null;
    }

    public Typeface a(String str, String str2) {
        com.airbnb.lottie.t.a x = x();
        if (x != null) {
            return x.a(str, str2);
        }
        return null;
    }

    public List<com.airbnb.lottie.u.e> a(com.airbnb.lottie.u.e eVar) {
        if (this.o == null) {
            com.airbnb.lottie.x.d.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.o.a(eVar, 0, arrayList, new com.airbnb.lottie.u.e(new String[0]));
        return arrayList;
    }

    public void a() {
        this.g.clear();
        this.f2124d.cancel();
    }

    public void a(float f) {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            this.g.add(new l(f));
        } else {
            b((int) com.airbnb.lottie.x.g.c(dVar.l(), this.f2123c.e(), f));
        }
    }

    public void a(int i2) {
        if (this.f2123c == null) {
            this.g.add(new c(i2));
        } else {
            this.f2124d.a(i2);
        }
    }

    public void a(int i2, int i3) {
        if (this.f2123c == null) {
            this.g.add(new b(i2, i3));
        } else {
            this.f2124d.a(i2, i3 + 0.99f);
        }
    }

    public void a(com.airbnb.lottie.a aVar) {
        this.l = aVar;
        com.airbnb.lottie.t.a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void a(com.airbnb.lottie.b bVar) {
        this.j = bVar;
        com.airbnb.lottie.t.b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void a(r rVar) {
        this.m = rVar;
    }

    public <T> void a(com.airbnb.lottie.u.e eVar, T t, com.airbnb.lottie.y.c<T> cVar) {
        if (this.o == null) {
            this.g.add(new e(eVar, t, cVar));
            return;
        }
        boolean z = true;
        if (eVar.a() != null) {
            eVar.a().a(t, cVar);
        } else {
            List<com.airbnb.lottie.u.e> a2 = a(eVar);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a2.get(i2).a().a(t, cVar);
            }
            z = true ^ a2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == com.airbnb.lottie.k.A) {
                c(k());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Boolean bool) {
        this.f = bool.booleanValue();
    }

    public void a(boolean z) {
        if (this.n != z) {
            if (Build.VERSION.SDK_INT < 19) {
                com.airbnb.lottie.x.d.b("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.n = z;
            if (this.f2123c != null) {
                v();
            }
        }
    }

    public boolean a(com.airbnb.lottie.d dVar) {
        if (this.f2123c == dVar) {
            return false;
        }
        this.r = false;
        b();
        this.f2123c = dVar;
        v();
        this.f2124d.a(dVar);
        c(this.f2124d.getAnimatedFraction());
        d(this.f2125e);
        z();
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(dVar);
            it.remove();
        }
        this.g.clear();
        dVar.b(this.q);
        return true;
    }

    public void b() {
        if (this.f2124d.isRunning()) {
            this.f2124d.cancel();
        }
        this.f2123c = null;
        this.o = null;
        this.h = null;
        this.f2124d.d();
        invalidateSelf();
    }

    public void b(float f) {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            this.g.add(new j(f));
        } else {
            c((int) com.airbnb.lottie.x.g.c(dVar.l(), this.f2123c.e(), f));
        }
    }

    public void b(int i2) {
        if (this.f2123c == null) {
            this.g.add(new k(i2));
        } else {
            this.f2124d.b(i2 + 0.99f);
        }
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.q = z;
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public void c(float f) {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            this.g.add(new d(f));
        } else {
            this.f2124d.a(com.airbnb.lottie.x.g.c(dVar.l(), this.f2123c.e(), f));
        }
    }

    public void c(int i2) {
        if (this.f2123c == null) {
            this.g.add(new i(i2));
        } else {
            this.f2124d.a(i2);
        }
    }

    public void c(String str) {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            this.g.add(new n(str));
            return;
        }
        com.airbnb.lottie.u.h b2 = dVar.b(str);
        if (b2 != null) {
            b((int) (b2.f2289b + b2.f2290c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public boolean c() {
        return this.n;
    }

    public void d() {
        this.g.clear();
        this.f2124d.e();
    }

    public void d(float f) {
        this.f2125e = f;
        z();
    }

    public void d(int i2) {
        this.f2124d.setRepeatCount(i2);
    }

    public void d(String str) {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            this.g.add(new a(str));
            return;
        }
        com.airbnb.lottie.u.h b2 = dVar.b(str);
        if (b2 != null) {
            int i2 = (int) b2.f2289b;
            a(i2, ((int) b2.f2290c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        this.r = false;
        com.airbnb.lottie.c.a("Drawable#draw");
        if (this.o != null) {
            float f2 = this.f2125e;
            float a2 = a(canvas);
            if (f2 > a2) {
                f = this.f2125e / a2;
            } else {
                a2 = f2;
                f = 1.0f;
            }
            int i2 = -1;
            if (f > 1.0f) {
                i2 = canvas.save();
                float width = this.f2123c.a().width() / 2.0f;
                float height = this.f2123c.a().height() / 2.0f;
                float f3 = width * a2;
                float f4 = height * a2;
                canvas.translate((n() * width) - f3, (n() * height) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.f2122b.reset();
            this.f2122b.preScale(a2, a2);
            this.o.a(canvas, this.f2122b, this.p);
            com.airbnb.lottie.c.b("Drawable#draw");
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public com.airbnb.lottie.d e() {
        return this.f2123c;
    }

    public void e(float f) {
        this.f2124d.c(f);
    }

    public void e(int i2) {
        this.f2124d.setRepeatMode(i2);
    }

    public void e(String str) {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            this.g.add(new m(str));
            return;
        }
        com.airbnb.lottie.u.h b2 = dVar.b(str);
        if (b2 != null) {
            c((int) b2.f2289b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public int f() {
        return (int) this.f2124d.g();
    }

    public String g() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.a().height() * n());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.a().width() * n());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f2124d.h();
    }

    public float i() {
        return this.f2124d.i();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (!this.r) {
            this.r = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return q();
    }

    public com.airbnb.lottie.n j() {
        com.airbnb.lottie.d dVar = this.f2123c;
        if (dVar != null) {
            return dVar.k();
        }
        return null;
    }

    public float k() {
        return this.f2124d.f();
    }

    public int l() {
        return this.f2124d.getRepeatCount();
    }

    public int m() {
        return this.f2124d.getRepeatMode();
    }

    public float n() {
        return this.f2125e;
    }

    public float o() {
        return this.f2124d.j();
    }

    public r p() {
        return this.m;
    }

    public boolean q() {
        return this.f2124d.isRunning();
    }

    public void r() {
        this.g.clear();
        this.f2124d.k();
    }

    public void s() {
        if (this.o == null) {
            this.g.add(new g());
            return;
        }
        if (this.f || l() == 0) {
            this.f2124d.l();
        }
        if (!this.f) {
            a((int) (o() < 0.0f ? i() : h()));
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.p = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.airbnb.lottie.x.d.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        s();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d();
    }

    public void t() {
        if (this.o == null) {
            this.g.add(new h());
        } else {
            this.f2124d.p();
        }
    }

    public boolean u() {
        return this.m == null && this.f2123c.b().b() > 0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
