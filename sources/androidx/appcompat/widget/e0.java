package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.t;

/* loaded from: classes.dex */
public abstract class e0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final float f941b;

    /* renamed from: e  reason: collision with root package name */
    final View f944e;
    private Runnable f;
    private Runnable g;
    private boolean h;
    private int i;
    private final int[] j = new int[2];

    /* renamed from: c  reason: collision with root package name */
    private final int f942c = ViewConfiguration.getTapTimeout();

    /* renamed from: d  reason: collision with root package name */
    private final int f943d = (this.f942c + ViewConfiguration.getLongPressTimeout()) / 2;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = e0.this.f944e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.h();
        }
    }

    public e0(View view) {
        this.f944e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f941b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
    }

    private boolean a(MotionEvent motionEvent) {
        c0 c0Var;
        View view = this.f944e;
        t e2 = e();
        if (e2 == null || !e2.c() || (c0Var = (c0) e2.d()) == null || !c0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        a(view, obtainNoHistory);
        b(c0Var, obtainNoHistory);
        boolean a2 = c0Var.a(obtainNoHistory, this.i);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a2 && (actionMasked != 1 && actionMasked != 3);
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f944e
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.i
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f941b
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.i()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.i()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.i = r6
            java.lang.Runnable r6 = r5.f
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.e0$a r6 = new androidx.appcompat.widget.e0$a
            r6.<init>()
            r5.f = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f
            int r1 = r5.f942c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.g
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.e0$b r6 = new androidx.appcompat.widget.e0$b
            r6.<init>()
            r5.g = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.g
            int r1 = r5.f943d
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e0.b(android.view.MotionEvent):boolean");
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    private void i() {
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f944e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f;
        if (runnable2 != null) {
            this.f944e.removeCallbacks(runnable2);
        }
    }

    public abstract t e();

    protected abstract boolean f();

    protected boolean g() {
        t e2 = e();
        if (e2 == null || !e2.c()) {
            return true;
        }
        e2.dismiss();
        return true;
    }

    void h() {
        i();
        View view = this.f944e;
        if (view.isEnabled() && !view.isLongClickable() && f()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.h = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.h;
        if (z2) {
            z = a(motionEvent) || !g();
        } else {
            z = b(motionEvent) && f();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f944e.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.h = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.h = false;
        this.i = -1;
        Runnable runnable = this.f;
        if (runnable != null) {
            this.f944e.removeCallbacks(runnable);
        }
    }
}
