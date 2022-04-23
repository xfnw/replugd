package androidx.appcompat.widget;

import a.a.j;
import a.g.l.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.t;
import androidx.core.widget.h;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class g0 implements t {
    private static Method G;
    private static Method H;
    private static Method I;
    private final c A;
    final Handler B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;

    /* renamed from: b  reason: collision with root package name */
    private Context f957b;

    /* renamed from: c  reason: collision with root package name */
    private ListAdapter f958c;

    /* renamed from: d  reason: collision with root package name */
    c0 f959d;

    /* renamed from: e  reason: collision with root package name */
    private int f960e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    int p;
    private View q;
    private int r;
    private DataSetObserver s;
    private View t;
    private Drawable u;
    private AdapterView.OnItemClickListener v;
    private AdapterView.OnItemSelectedListener w;
    final g x;
    private final f y;
    private final e z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2 = g0.this.e();
            if (e2 != null && e2.getWindowToken() != null) {
                g0.this.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            c0 c0Var;
            if (i != -1 && (c0Var = g0.this.f959d) != null) {
                c0Var.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (g0.this.c()) {
                g0.this.b();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !g0.this.j() && g0.this.F.getContentView() != null) {
                g0 g0Var = g0.this;
                g0Var.B.removeCallbacks(g0Var.x);
                g0.this.x.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = g0.this.F) != null && popupWindow.isShowing() && x >= 0 && x < g0.this.F.getWidth() && y >= 0 && y < g0.this.F.getHeight()) {
                g0 g0Var = g0.this;
                g0Var.B.postDelayed(g0Var.x, 250L);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                g0 g0Var2 = g0.this;
                g0Var2.B.removeCallbacks(g0Var2.x);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0 c0Var = g0.this.f959d;
            if (c0Var != null && s.v(c0Var) && g0.this.f959d.getCount() > g0.this.f959d.getChildCount()) {
                int childCount = g0.this.f959d.getChildCount();
                g0 g0Var = g0.this;
                if (childCount <= g0Var.p) {
                    g0Var.F.setInputMethodMode(2);
                    g0.this.b();
                }
            }
        }
    }

    static {
        try {
            G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public g0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public g0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f960e = -2;
        this.f = -2;
        this.i = 1002;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = Integer.MAX_VALUE;
        this.r = 0;
        this.x = new g();
        this.y = new f();
        this.z = new e();
        this.A = new c();
        this.C = new Rect();
        this.f957b = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i, i2);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.h = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.h != 0) {
            this.j = true;
        }
        obtainStyledAttributes.recycle();
        this.F = new p(context, attributeSet, i, i2);
        this.F.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        Method method = H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.F, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.F.getMaxAvailableHeight(view, i);
    }

    private void c(boolean z) {
        Method method = G;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int l() {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g0.l():int");
    }

    private void m() {
        View view = this.q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.q);
            }
        }
    }

    c0 a(Context context, boolean z) {
        return new c0(context, z);
    }

    public void a() {
        c0 c0Var = this.f959d;
        if (c0Var != null) {
            c0Var.setListSelectionHidden(true);
            c0Var.requestLayout();
        }
    }

    public void a(int i) {
        this.F.setAnimationStyle(i);
    }

    public void a(Rect rect) {
        this.D = rect;
    }

    public void a(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.t = view;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.s;
        if (dataSetObserver == null) {
            this.s = new d();
        } else {
            ListAdapter listAdapter2 = this.f958c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f958c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        c0 c0Var = this.f959d;
        if (c0Var != null) {
            c0Var.setAdapter(this.f958c);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.E = z;
        this.F.setFocusable(z);
    }

    @Override // androidx.appcompat.view.menu.t
    public void b() {
        int l = l();
        boolean j = j();
        h.a(this.F, this.i);
        boolean z = true;
        if (!this.F.isShowing()) {
            int i = this.f;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = e().getWidth();
            }
            int i2 = this.f960e;
            if (i2 == -1) {
                l = -1;
            } else if (i2 != -2) {
                l = i2;
            }
            this.F.setWidth(i);
            this.F.setHeight(l);
            c(true);
            this.F.setOutsideTouchable(!this.o && !this.n);
            this.F.setTouchInterceptor(this.y);
            if (this.l) {
                h.a(this.F, this.k);
            }
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
            h.a(this.F, e(), this.g, this.h, this.m);
            this.f959d.setSelection(-1);
            if (!this.E || this.f959d.isInTouchMode()) {
                a();
            }
            if (!this.E) {
                this.B.post(this.A);
            }
        } else if (s.v(e())) {
            int i3 = this.f;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = e().getWidth();
            }
            int i4 = this.f960e;
            if (i4 == -1) {
                if (!j) {
                    l = -1;
                }
                if (j) {
                    this.F.setWidth(this.f == -1 ? -1 : 0);
                    this.F.setHeight(0);
                } else {
                    this.F.setWidth(this.f == -1 ? -1 : 0);
                    this.F.setHeight(-1);
                }
            } else if (i4 != -2) {
                l = i4;
            }
            PopupWindow popupWindow = this.F;
            if (this.o || this.n) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.F.update(e(), this.g, this.h, i3 < 0 ? -1 : i3, l < 0 ? -1 : l);
        }
    }

    public void b(int i) {
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            this.f = rect.left + rect.right + i;
            return;
        }
        i(i);
    }

    public void b(boolean z) {
        this.l = true;
        this.k = z;
    }

    public void c(int i) {
        this.m = i;
    }

    @Override // androidx.appcompat.view.menu.t
    public boolean c() {
        return this.F.isShowing();
    }

    @Override // androidx.appcompat.view.menu.t
    public ListView d() {
        return this.f959d;
    }

    public void d(int i) {
        this.g = i;
    }

    @Override // androidx.appcompat.view.menu.t
    public void dismiss() {
        this.F.dismiss();
        m();
        this.F.setContentView(null);
        this.f959d = null;
        this.B.removeCallbacks(this.x);
    }

    public View e() {
        return this.t;
    }

    public void e(int i) {
        this.F.setInputMethodMode(i);
    }

    public Drawable f() {
        return this.F.getBackground();
    }

    public void f(int i) {
        this.r = i;
    }

    public int g() {
        return this.g;
    }

    public void g(int i) {
        c0 c0Var = this.f959d;
        if (c() && c0Var != null) {
            c0Var.setListSelectionHidden(false);
            c0Var.setSelection(i);
            if (c0Var.getChoiceMode() != 0) {
                c0Var.setItemChecked(i, true);
            }
        }
    }

    public int h() {
        if (!this.j) {
            return 0;
        }
        return this.h;
    }

    public void h(int i) {
        this.h = i;
        this.j = true;
    }

    public int i() {
        return this.f;
    }

    public void i(int i) {
        this.f = i;
    }

    public boolean j() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean k() {
        return this.E;
    }
}
