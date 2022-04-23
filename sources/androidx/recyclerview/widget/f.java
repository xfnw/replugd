package androidx.recyclerview.widget;

import a.g.l.s;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f extends RecyclerView.n implements RecyclerView.q {
    private g A;
    private Rect C;
    private long D;

    /* renamed from: d  reason: collision with root package name */
    float f1489d;

    /* renamed from: e  reason: collision with root package name */
    float f1490e;
    private float f;
    private float g;
    float h;
    float i;
    private float j;
    private float k;
    AbstractC0047f m;
    int o;
    private int q;
    RecyclerView r;
    VelocityTracker t;
    private List<RecyclerView.d0> u;
    private List<Integer> v;
    a.g.l.c z;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f1486a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1487b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.d0 f1488c = null;
    int l = -1;
    private int n = 0;
    List<h> p = new ArrayList();
    final Runnable s = new a();
    private RecyclerView.j w = null;
    View x = null;
    int y = -1;
    private final RecyclerView.s B = new b();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if (fVar.f1488c != null && fVar.c()) {
                f fVar2 = f.this;
                RecyclerView.d0 d0Var = fVar2.f1488c;
                if (d0Var != null) {
                    fVar2.a(d0Var);
                }
                f fVar3 = f.this;
                fVar3.r.removeCallbacks(fVar3.s);
                s.a(f.this.r, this);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(boolean z) {
            if (z) {
                f.this.a((RecyclerView.d0) null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            h a2;
            f.this.z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                f.this.l = motionEvent.getPointerId(0);
                f.this.f1489d = motionEvent.getX();
                f.this.f1490e = motionEvent.getY();
                f.this.b();
                f fVar = f.this;
                if (fVar.f1488c == null && (a2 = fVar.a(motionEvent)) != null) {
                    f fVar2 = f.this;
                    fVar2.f1489d -= a2.j;
                    fVar2.f1490e -= a2.k;
                    fVar2.a(a2.f, true);
                    if (f.this.f1486a.remove(a2.f.f1346a)) {
                        f fVar3 = f.this;
                        fVar3.m.a(fVar3.r, a2.f);
                    }
                    f.this.a(a2.f, a2.g);
                    f fVar4 = f.this;
                    fVar4.a(motionEvent, fVar4.o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                f fVar5 = f.this;
                fVar5.l = -1;
                fVar5.a((RecyclerView.d0) null, 0);
            } else {
                int i = f.this.l;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    f.this.a(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = f.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return f.this.f1488c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            f.this.z.a(motionEvent);
            VelocityTracker velocityTracker = f.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (f.this.l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(f.this.l);
                if (findPointerIndex >= 0) {
                    f.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                f fVar = f.this;
                RecyclerView.d0 d0Var = fVar.f1488c;
                if (d0Var != null) {
                    int i = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = fVar.t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex) == f.this.l) {
                                    if (actionIndex == 0) {
                                        i = 1;
                                    }
                                    f.this.l = motionEvent.getPointerId(i);
                                    f fVar2 = f.this;
                                    fVar2.a(motionEvent, fVar2.o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            fVar.a(motionEvent, fVar.o, findPointerIndex);
                            f.this.a(d0Var);
                            f fVar3 = f.this;
                            fVar3.r.removeCallbacks(fVar3.s);
                            f.this.s.run();
                            f.this.r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    f.this.a((RecyclerView.d0) null, 0);
                    f.this.l = -1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends h {
        final /* synthetic */ int o;
        final /* synthetic */ RecyclerView.d0 p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView.d0 d0Var, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.d0 d0Var2) {
            super(d0Var, i, i2, f, f2, f3, f4);
            this.o = i3;
            this.p = d0Var2;
        }

        @Override // androidx.recyclerview.widget.f.h, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.l) {
                if (this.o <= 0) {
                    f fVar = f.this;
                    fVar.m.a(fVar.r, this.p);
                } else {
                    f.this.f1486a.add(this.p.f1346a);
                    this.i = true;
                    int i = this.o;
                    if (i > 0) {
                        f.this.a(this, i);
                    }
                }
                f fVar2 = f.this;
                View view = fVar2.x;
                View view2 = this.p.f1346a;
                if (view == view2) {
                    fVar2.c(view2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f1493b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1494c;

        d(h hVar, int i) {
            this.f1493b = hVar;
            this.f1494c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = f.this.r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                h hVar = this.f1493b;
                if (!hVar.l && hVar.f.f() != -1) {
                    RecyclerView.l itemAnimator = f.this.r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.a((RecyclerView.l.a) null)) && !f.this.a()) {
                        f.this.m.b(this.f1493b.f, this.f1494c);
                    } else {
                        f.this.r.post(this);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements RecyclerView.j {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i, int i2) {
            f fVar = f.this;
            View view = fVar.x;
            if (view == null) {
                return i2;
            }
            int i3 = fVar.y;
            if (i3 == -1) {
                i3 = fVar.r.indexOfChild(view);
                f.this.y = i3;
            }
            return i2 == i + (-1) ? i3 : i2 < i3 ? i2 : i2 + 1;
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0047f {

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f1497b = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final Interpolator f1498c = new b();

        /* renamed from: a  reason: collision with root package name */
        private int f1499a = -1;

        /* renamed from: androidx.recyclerview.widget.f$f$a */
        /* loaded from: classes.dex */
        static class a implements Interpolator {
            a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        }

        /* renamed from: androidx.recyclerview.widget.f$f$b */
        /* loaded from: classes.dex */
        static class b implements Interpolator {
            b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        private int a(RecyclerView recyclerView) {
            if (this.f1499a == -1) {
                this.f1499a = recyclerView.getResources().getDimensionPixelSize(a.o.a.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f1499a;
        }

        public static int b(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static int c(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int d(int i, int i2) {
            int c2 = c(0, i2 | i);
            return c(2, i) | c(1, i2) | c2;
        }

        public float a(float f) {
            return f;
        }

        public float a(RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public int a() {
            return 0;
        }

        public int a(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public int a(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int signum = (int) (((int) Math.signum(i2)) * a(recyclerView) * f1498c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (signum * f1497b.getInterpolation(f));
            return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
        }

        public long a(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.e() : itemAnimator.f();
        }

        public RecyclerView.d0 a(RecyclerView.d0 d0Var, List<RecyclerView.d0> list, int i, int i2) {
            int i3;
            int bottom;
            int top;
            int abs;
            int left;
            int abs2;
            int right;
            int width = i + d0Var.f1346a.getWidth();
            int height = i2 + d0Var.f1346a.getHeight();
            int left2 = i - d0Var.f1346a.getLeft();
            int top2 = i2 - d0Var.f1346a.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.d0 d0Var3 = list.get(i5);
                if (left2 <= 0 || (right = d0Var3.f1346a.getRight() - width) >= 0 || d0Var3.f1346a.getRight() <= d0Var.f1346a.getRight() || (i3 = Math.abs(right)) <= i4) {
                    i3 = i4;
                } else {
                    d0Var2 = d0Var3;
                }
                if (left2 < 0 && (left = d0Var3.f1346a.getLeft() - i) > 0 && d0Var3.f1346a.getLeft() < d0Var.f1346a.getLeft() && (abs2 = Math.abs(left)) > i3) {
                    i3 = abs2;
                    d0Var2 = d0Var3;
                }
                if (top2 < 0 && (top = d0Var3.f1346a.getTop() - i2) > 0 && d0Var3.f1346a.getTop() < d0Var.f1346a.getTop() && (abs = Math.abs(top)) > i3) {
                    i3 = abs;
                    d0Var2 = d0Var3;
                }
                if (top2 <= 0 || (bottom = d0Var3.f1346a.getBottom() - height) >= 0 || d0Var3.f1346a.getBottom() <= d0Var.f1346a.getBottom() || (i4 = Math.abs(bottom)) <= i3) {
                    i4 = i3;
                } else {
                    d0Var2 = d0Var3;
                }
            }
            return d0Var2;
        }

        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
            androidx.recyclerview.widget.h.f1507a.b(canvas, recyclerView, d0Var.f1346a, f, f2, i, z);
        }

        void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<h> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = list.get(i2);
                hVar.c();
                int save = canvas.save();
                a(canvas, recyclerView, hVar.f, hVar.j, hVar.k, hVar.g, false);
                canvas.restoreToCount(save);
            }
            if (d0Var != null) {
                int save2 = canvas.save();
                a(canvas, recyclerView, d0Var, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        public void a(RecyclerView.d0 d0Var, int i) {
            if (d0Var != null) {
                androidx.recyclerview.widget.h.f1507a.b(d0Var.f1346a);
            }
        }

        public void a(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            androidx.recyclerview.widget.h.f1507a.a(d0Var.f1346a);
        }

        public void a(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i, RecyclerView.d0 d0Var2, int i2, int i3, int i4) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof i) {
                ((i) layoutManager).a(d0Var.f1346a, d0Var2.f1346a, i3, i4);
                return;
            }
            if (layoutManager.a()) {
                if (layoutManager.f(d0Var2.f1346a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.h(i2);
                }
                if (layoutManager.i(d0Var2.f1346a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.h(i2);
                }
            }
            if (layoutManager.b()) {
                if (layoutManager.j(d0Var2.f1346a) <= recyclerView.getPaddingTop()) {
                    recyclerView.h(i2);
                }
                if (layoutManager.e(d0Var2.f1346a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.h(i2);
                }
            }
        }

        public boolean a(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            return true;
        }

        public float b(float f) {
            return f;
        }

        public float b(RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        final int b(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return a(c(recyclerView, d0Var), s.j(recyclerView));
        }

        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
            androidx.recyclerview.widget.h.f1507a.a(canvas, recyclerView, d0Var.f1346a, f, f2, i, z);
        }

        void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<h> list, int i, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = list.get(i2);
                int save = canvas.save();
                b(canvas, recyclerView, hVar.f, hVar.j, hVar.k, hVar.g, false);
                canvas.restoreToCount(save);
            }
            if (d0Var != null) {
                int save2 = canvas.save();
                b(canvas, recyclerView, d0Var, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                h hVar2 = list.get(i3);
                if (hVar2.m && !hVar2.i) {
                    list.remove(i3);
                } else if (!hVar2.m) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract void b(RecyclerView.d0 d0Var, int i);

        public boolean b() {
            return true;
        }

        public abstract boolean b(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2);

        public abstract int c(RecyclerView recyclerView, RecyclerView.d0 d0Var);

        public boolean c() {
            return true;
        }

        boolean d(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (b(recyclerView, d0Var) & 16711680) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1500b = true;

        g() {
        }

        void a() {
            this.f1500b = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View b2;
            RecyclerView.d0 e2;
            if (this.f1500b && (b2 = f.this.b(motionEvent)) != null && (e2 = f.this.r.e(b2)) != null) {
                f fVar = f.this;
                if (fVar.m.d(fVar.r, e2)) {
                    int pointerId = motionEvent.getPointerId(0);
                    int i = f.this.l;
                    if (pointerId == i) {
                        int findPointerIndex = motionEvent.findPointerIndex(i);
                        float x = motionEvent.getX(findPointerIndex);
                        float y = motionEvent.getY(findPointerIndex);
                        f fVar2 = f.this;
                        fVar2.f1489d = x;
                        fVar2.f1490e = y;
                        fVar2.i = 0.0f;
                        fVar2.h = 0.0f;
                        if (fVar2.m.c()) {
                            f.this.a(e2, 2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        final float f1502b;

        /* renamed from: c  reason: collision with root package name */
        final float f1503c;

        /* renamed from: d  reason: collision with root package name */
        final float f1504d;

        /* renamed from: e  reason: collision with root package name */
        final float f1505e;
        final RecyclerView.d0 f;
        final int g;
        boolean i;
        float j;
        float k;
        private float n;
        boolean l = false;
        boolean m = false;
        private final ValueAnimator h = ValueAnimator.ofFloat(0.0f, 1.0f);

        /* loaded from: classes.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.a(valueAnimator.getAnimatedFraction());
            }
        }

        h(RecyclerView.d0 d0Var, int i, int i2, float f, float f2, float f3, float f4) {
            this.g = i2;
            this.f = d0Var;
            this.f1502b = f;
            this.f1503c = f2;
            this.f1504d = f3;
            this.f1505e = f4;
            this.h.addUpdateListener(new a());
            this.h.setTarget(d0Var.f1346a);
            this.h.addListener(this);
            a(0.0f);
        }

        public void a() {
            this.h.cancel();
        }

        public void a(float f) {
            this.n = f;
        }

        public void a(long j) {
            this.h.setDuration(j);
        }

        public void b() {
            this.f.a(false);
            this.h.start();
        }

        public void c() {
            float f = this.f1502b;
            float f2 = this.f1504d;
            this.j = f == f2 ? this.f.f1346a.getTranslationX() : f + (this.n * (f2 - f));
            float f3 = this.f1503c;
            float f4 = this.f1505e;
            this.k = f3 == f4 ? this.f.f1346a.getTranslationY() : f3 + (this.n * (f4 - f3));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.m) {
                this.f.a(true);
            }
            this.m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(View view, View view2, int i, int i2);
    }

    public f(AbstractC0047f fVar) {
        this.m = fVar;
    }

    private void a(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.f1488c.f1346a.getLeft();
        } else {
            fArr[0] = this.f1488c.f1346a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.f1488c.f1346a.getTop();
        } else {
            fArr[1] = this.f1488c.f1346a.getTranslationY();
        }
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    private int b(RecyclerView.d0 d0Var, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 8;
        int i4 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            AbstractC0047f fVar = this.m;
            float f = this.g;
            fVar.b(f);
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            if (xVelocity <= 0.0f) {
                i3 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3) {
                AbstractC0047f fVar2 = this.m;
                float f2 = this.f;
                fVar2.a(f2);
                if (abs >= f2 && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
        }
        float width = this.r.getWidth() * this.m.b(d0Var);
        if ((i2 & i4) == 0 || Math.abs(this.h) <= width) {
            return 0;
        }
        return i4;
    }

    private List<RecyclerView.d0> b(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List<RecyclerView.d0> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int a2 = this.m.a();
        int round = Math.round(this.j + this.h) - a2;
        int round2 = Math.round(this.k + this.i) - a2;
        int i2 = a2 * 2;
        int width = d0Var2.f1346a.getWidth() + round + i2;
        int height = d0Var2.f1346a.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int e2 = layoutManager.e();
        int i5 = 0;
        while (i5 < e2) {
            View c2 = layoutManager.c(i5);
            if (c2 != d0Var2.f1346a && c2.getBottom() >= round2 && c2.getTop() <= height && c2.getRight() >= round && c2.getLeft() <= width) {
                RecyclerView.d0 e3 = this.r.e(c2);
                if (this.m.a(this.r, this.f1488c, e3)) {
                    int abs = Math.abs(i3 - ((c2.getLeft() + c2.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((c2.getTop() + c2.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.u.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size && i6 > this.v.get(i8).intValue(); i8++) {
                        i7++;
                    }
                    this.u.add(i7, e3);
                    this.v.add(i7, Integer.valueOf(i6));
                }
            }
            i5++;
            d0Var2 = d0Var;
        }
        return this.u;
    }

    private int c(RecyclerView.d0 d0Var) {
        if (this.n == 2) {
            return 0;
        }
        int c2 = this.m.c(this.r, d0Var);
        int a2 = (this.m.a(c2, s.j(this.r)) & 65280) >> 8;
        if (a2 == 0) {
            return 0;
        }
        int i2 = (c2 & 65280) >> 8;
        if (Math.abs(this.h) > Math.abs(this.i)) {
            int b2 = b(d0Var, a2);
            if (b2 > 0) {
                return (i2 & b2) == 0 ? AbstractC0047f.b(b2, s.j(this.r)) : b2;
            }
            int c3 = c(d0Var, a2);
            if (c3 > 0) {
                return c3;
            }
        } else {
            int c4 = c(d0Var, a2);
            if (c4 > 0) {
                return c4;
            }
            int b3 = b(d0Var, a2);
            if (b3 > 0) {
                return (i2 & b3) == 0 ? AbstractC0047f.b(b3, s.j(this.r)) : b3;
            }
        }
        return 0;
    }

    private int c(RecyclerView.d0 d0Var, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 2;
        int i4 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            AbstractC0047f fVar = this.m;
            float f = this.g;
            fVar.b(f);
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            if (yVelocity <= 0.0f) {
                i3 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4) {
                AbstractC0047f fVar2 = this.m;
                float f2 = this.f;
                fVar2.a(f2);
                if (abs >= f2 && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
        }
        float height = this.r.getHeight() * this.m.b(d0Var);
        if ((i2 & i4) == 0 || Math.abs(this.i) <= height) {
            return 0;
        }
        return i4;
    }

    private RecyclerView.d0 c(MotionEvent motionEvent) {
        View b2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int i2 = this.l;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f1489d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f1490e);
        int i3 = this.q;
        if (abs < i3 && abs2 < i3) {
            return null;
        }
        if (abs > abs2 && layoutManager.a()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.b()) && (b2 = b(motionEvent)) != null) {
            return this.r.e(b2);
        }
        return null;
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.w == null) {
                this.w = new e();
            }
            this.r.setChildDrawingOrderCallback(this.w);
        }
    }

    private void e() {
        this.r.b((RecyclerView.n) this);
        this.r.b(this.B);
        this.r.b((RecyclerView.q) this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.m.a(this.r, this.p.get(0).f);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        f();
        i();
    }

    private void f() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void g() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.a((RecyclerView.n) this);
        this.r.a(this.B);
        this.r.a((RecyclerView.q) this);
        h();
    }

    private void h() {
        this.A = new g();
        this.z = new a.g.l.c(this.r.getContext(), this.A);
    }

    private void i() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    h a(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View b2 = b(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            h hVar = this.p.get(size);
            if (hVar.f.f1346a == b2) {
                return hVar;
            }
        }
        return null;
    }

    void a(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.d0 c2;
        int b2;
        if (this.f1488c == null && i2 == 2 && this.n != 2 && this.m.b() && this.r.getScrollState() != 1 && (c2 = c(motionEvent)) != null && (b2 = (this.m.b(this.r, c2) & 65280) >> 8) != 0) {
            float x = motionEvent.getX(i3);
            float y = motionEvent.getY(i3);
            float f = x - this.f1489d;
            float f2 = y - this.f1490e;
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            int i4 = this.q;
            if (abs >= i4 || abs2 >= i4) {
                if (abs > abs2) {
                    if (f < 0.0f && (b2 & 4) == 0) {
                        return;
                    }
                    if (f > 0.0f && (b2 & 8) == 0) {
                        return;
                    }
                } else if (f2 < 0.0f && (b2 & 1) == 0) {
                    return;
                } else {
                    if (f2 > 0.0f && (b2 & 2) == 0) {
                        return;
                    }
                }
                this.i = 0.0f;
                this.h = 0.0f;
                this.l = motionEvent.getPointerId(0);
                a(c2, 1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f;
        float f2;
        this.y = -1;
        if (this.f1488c != null) {
            a(this.f1487b);
            float[] fArr = this.f1487b;
            f2 = fArr[0];
            f = fArr[1];
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        this.m.a(canvas, recyclerView, this.f1488c, this.p, this.n, f2, f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.setEmpty();
    }

    void a(MotionEvent motionEvent, int i2, int i3) {
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        this.h = x - this.f1489d;
        this.i = y - this.f1490e;
        if ((i2 & 4) == 0) {
            this.h = Math.max(0.0f, this.h);
        }
        if ((i2 & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((i2 & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i2 & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(View view) {
    }

    void a(RecyclerView.d0 d0Var) {
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float a2 = this.m.a(d0Var);
            int i2 = (int) (this.j + this.h);
            int i3 = (int) (this.k + this.i);
            if (Math.abs(i3 - d0Var.f1346a.getTop()) >= d0Var.f1346a.getHeight() * a2 || Math.abs(i2 - d0Var.f1346a.getLeft()) >= d0Var.f1346a.getWidth() * a2) {
                List<RecyclerView.d0> b2 = b(d0Var);
                if (b2.size() != 0) {
                    RecyclerView.d0 a3 = this.m.a(d0Var, b2, i2, i3);
                    if (a3 == null) {
                        this.u.clear();
                        this.v.clear();
                        return;
                    }
                    int f = a3.f();
                    int f2 = d0Var.f();
                    if (this.m.b(this.r, d0Var, a3)) {
                        this.m.a(this.r, d0Var, f2, a3, f, i2, i3);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.recyclerview.widget.RecyclerView.d0 r24, int r25) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.a(androidx.recyclerview.widget.RecyclerView$d0, int):void");
    }

    void a(RecyclerView.d0 d0Var, boolean z) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            h hVar = this.p.get(size);
            if (hVar.f == d0Var) {
                hVar.l |= z;
                if (!hVar.m) {
                    hVar.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                e();
            }
            this.r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f = resources.getDimension(a.o.a.item_touch_helper_swipe_escape_velocity);
                this.g = resources.getDimension(a.o.a.item_touch_helper_swipe_escape_max_velocity);
                g();
            }
        }
    }

    void a(h hVar, int i2) {
        this.r.post(new d(hVar, i2));
    }

    boolean a() {
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.p.get(i2).m) {
                return true;
            }
        }
        return false;
    }

    View b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.d0 d0Var = this.f1488c;
        if (d0Var != null) {
            View view = d0Var.f1346a;
            if (a(view, x, y, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            h hVar = this.p.get(size);
            View view2 = hVar.f.f1346a;
            if (a(view2, x, y, hVar.j, hVar.k)) {
                return view2;
            }
        }
        return this.r.a(x, y);
    }

    void b() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f;
        float f2;
        if (this.f1488c != null) {
            a(this.f1487b);
            float[] fArr = this.f1487b;
            f2 = fArr[0];
            f = fArr[1];
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        this.m.b(canvas, recyclerView, this.f1488c, this.p, this.n, f2, f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
        c(view);
        RecyclerView.d0 e2 = this.r.e(view);
        if (e2 != null) {
            RecyclerView.d0 d0Var = this.f1488c;
            if (d0Var == null || e2 != d0Var) {
                a(e2, false);
                if (this.f1486a.remove(e2.f1346a)) {
                    this.m.a(this.r, e2);
                    return;
                }
                return;
            }
            a((RecyclerView.d0) null, 0);
        }
    }

    void c(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c5, code lost:
        if (r1 > 0) goto L_0x00c9;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean c() {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.c():boolean");
    }
}
