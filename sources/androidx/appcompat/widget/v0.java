package androidx.appcompat.widget;

import a.g.l.s;
import a.g.l.t;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class v0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static v0 k;
    private static v0 l;

    /* renamed from: b  reason: collision with root package name */
    private final View f1062b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f1063c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1064d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1065e = new a();
    private final Runnable f = new b();
    private int g;
    private int h;
    private w0 i;
    private boolean j;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v0.this.a(false);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v0.this.a();
        }
    }

    private v0(View view, CharSequence charSequence) {
        this.f1062b = view;
        this.f1063c = charSequence;
        this.f1064d = t.a(ViewConfiguration.get(this.f1062b.getContext()));
        c();
        this.f1062b.setOnLongClickListener(this);
        this.f1062b.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        v0 v0Var = k;
        if (v0Var != null && v0Var.f1062b == view) {
            a((v0) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            v0 v0Var2 = l;
            if (v0Var2 != null && v0Var2.f1062b == view) {
                v0Var2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new v0(view, charSequence);
    }

    private static void a(v0 v0Var) {
        v0 v0Var2 = k;
        if (v0Var2 != null) {
            v0Var2.b();
        }
        k = v0Var;
        v0 v0Var3 = k;
        if (v0Var3 != null) {
            v0Var3.d();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.g) <= this.f1064d && Math.abs(y - this.h) <= this.f1064d) {
            return false;
        }
        this.g = x;
        this.h = y;
        return true;
    }

    private void b() {
        this.f1062b.removeCallbacks(this.f1065e);
    }

    private void c() {
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
    }

    private void d() {
        this.f1062b.postDelayed(this.f1065e, ViewConfiguration.getLongPressTimeout());
    }

    void a() {
        if (l == this) {
            l = null;
            w0 w0Var = this.i;
            if (w0Var != null) {
                w0Var.a();
                this.i = null;
                c();
                this.f1062b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            a((v0) null);
        }
        this.f1062b.removeCallbacks(this.f);
    }

    void a(boolean z) {
        long j;
        if (s.v(this.f1062b)) {
            a((v0) null);
            v0 v0Var = l;
            if (v0Var != null) {
                v0Var.a();
            }
            l = this;
            this.j = z;
            this.i = new w0(this.f1062b.getContext());
            this.i.a(this.f1062b, this.g, this.h, this.j, this.f1063c);
            this.f1062b.addOnAttachStateChangeListener(this);
            if (this.j) {
                j = 2500;
            } else {
                j = ((s.p(this.f1062b) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
            }
            this.f1062b.removeCallbacks(this.f);
            this.f1062b.postDelayed(this.f, j);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.i != null && this.j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1062b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                a();
            }
        } else if (this.f1062b.isEnabled() && this.i == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
