package androidx.appcompat.app;

import a.a.ActionBar;
import a.a.n.b;
import a.a.n.f;
import a.g.l.a0;
import a.g.l.e;
import a.g.l.p;
import a.g.l.s;
import a.g.l.w;
import a.g.l.x;
import a.g.l.y;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.x0;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends androidx.appcompat.app.f implements h.a, LayoutInflater.Factory2 {
    private static final boolean T;
    private static final int[] U;
    private static boolean V;
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    private boolean E;
    private m[] F;
    private m G;
    private boolean H;
    boolean I;
    private boolean K;
    private k L;
    boolean M;
    int N;
    private boolean P;
    private Rect Q;
    private Rect R;
    private AppCompatViewInflater S;

    /* renamed from: c  reason: collision with root package name */
    final Context f705c;

    /* renamed from: d  reason: collision with root package name */
    final Window f706d;

    /* renamed from: e  reason: collision with root package name */
    final Window.Callback f707e;
    final Window.Callback f;
    final androidx.appcompat.app.e g;
    androidx.appcompat.app.a h;
    MenuInflater i;
    private CharSequence j;
    private z k;
    private h l;
    private n m;
    a.a.n.b n;
    ActionBarContextView o;
    PopupWindow p;
    Runnable q;
    private boolean t;
    private ViewGroup u;
    private TextView v;
    private View w;
    private boolean x;
    private boolean y;
    boolean z;
    w r = null;
    private boolean s = true;
    private int J = -100;
    private final Runnable O = new b();

    /* loaded from: classes.dex */
    static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f708a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f708a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f708a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f708a.uncaughtException(thread, th);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if ((gVar.N & 1) != 0) {
                gVar.e(0);
            }
            g gVar2 = g.this;
            if ((gVar2.N & 4096) != 0) {
                gVar2.e(108);
            }
            g gVar3 = g.this;
            gVar3.M = false;
            gVar3.N = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements p {
        c() {
        }

        @Override // a.g.l.p
        public a0 a(View view, a0 a0Var) {
            int d2 = a0Var.d();
            int i = g.this.i(d2);
            if (d2 != i) {
                a0Var = a0Var.a(a0Var.b(), i, a0Var.c(), a0Var.a());
            }
            return s.b(view, a0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements d0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.d0.a
        public void a(Rect rect) {
            rect.top = g.this.i(rect.top);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            g.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* loaded from: classes.dex */
        class a extends y {
            a() {
            }

            @Override // a.g.l.x
            public void a(View view) {
                g.this.o.setAlpha(1.0f);
                g.this.r.a((x) null);
                g.this.r = null;
            }

            @Override // a.g.l.y, a.g.l.x
            public void b(View view) {
                g.this.o.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.p.showAtLocation(gVar.o, 55, 0, 0);
            g.this.l();
            if (g.this.s()) {
                g.this.o.setAlpha(0.0f);
                g gVar2 = g.this;
                w a2 = s.a(gVar2.o);
                a2.a(1.0f);
                gVar2.r = a2;
                g.this.r.a(new a());
                return;
            }
            g.this.o.setAlpha(1.0f);
            g.this.o.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0031g extends y {
        C0031g() {
        }

        @Override // a.g.l.x
        public void a(View view) {
            g.this.o.setAlpha(1.0f);
            g.this.r.a((x) null);
            g.this.r = null;
        }

        @Override // a.g.l.y, a.g.l.x
        public void b(View view) {
            g.this.o.setVisibility(0);
            g.this.o.sendAccessibilityEvent(32);
            if (g.this.o.getParent() instanceof View) {
                s.A((View) g.this.o.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class h implements p.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.p.a
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            g.this.b(hVar);
        }

        @Override // androidx.appcompat.view.menu.p.a
        public boolean a(androidx.appcompat.view.menu.h hVar) {
            Window.Callback o = g.this.o();
            if (o == null) {
                return true;
            }
            o.onMenuOpened(108, hVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f717a;

        /* loaded from: classes.dex */
        class a extends y {
            a() {
            }

            @Override // a.g.l.x
            public void a(View view) {
                g.this.o.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.p;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.o.getParent() instanceof View) {
                    s.A((View) g.this.o.getParent());
                }
                g.this.o.removeAllViews();
                g.this.r.a((x) null);
                g.this.r = null;
            }
        }

        public i(b.a aVar) {
            this.f717a = aVar;
        }

        @Override // a.a.n.b.a
        public void a(a.a.n.b bVar) {
            this.f717a.a(bVar);
            g gVar = g.this;
            if (gVar.p != null) {
                gVar.f706d.getDecorView().removeCallbacks(g.this.q);
            }
            g gVar2 = g.this;
            if (gVar2.o != null) {
                gVar2.l();
                g gVar3 = g.this;
                w a2 = s.a(gVar3.o);
                a2.a(0.0f);
                gVar3.r = a2;
                g.this.r.a(new a());
            }
            g gVar4 = g.this;
            androidx.appcompat.app.e eVar = gVar4.g;
            if (eVar != null) {
                eVar.b(gVar4.n);
            }
            g.this.n = null;
        }

        @Override // a.a.n.b.a
        public boolean a(a.a.n.b bVar, Menu menu) {
            return this.f717a.a(bVar, menu);
        }

        @Override // a.a.n.b.a
        public boolean a(a.a.n.b bVar, MenuItem menuItem) {
            return this.f717a.a(bVar, menuItem);
        }

        @Override // a.a.n.b.a
        public boolean b(a.a.n.b bVar, Menu menu) {
            return this.f717a.b(bVar, menu);
        }
    }

    /* loaded from: classes.dex */
    class j extends a.a.n.i {
        j(Window.Callback callback) {
            super(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(g.this.f705c, callback);
            a.a.n.b a2 = g.this.a(aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.b(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            g.this.g(i);
            return true;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            g.this.h(i);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.h hVar = menu instanceof androidx.appcompat.view.menu.h ? (androidx.appcompat.view.menu.h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.c(false);
            }
            return onPreparePanel;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.h hVar;
            m a2 = g.this.a(0, true);
            if (a2 == null || (hVar = a2.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, hVar, i);
            }
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return g.this.p() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (!g.this.p() || i != 0) ? super.onWindowStartingActionMode(callback, i) : a(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class k {

        /* renamed from: a  reason: collision with root package name */
        private androidx.appcompat.app.k f721a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f722b;

        /* renamed from: c  reason: collision with root package name */
        private BroadcastReceiver f723c;

        /* renamed from: d  reason: collision with root package name */
        private IntentFilter f724d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                k.this.b();
            }
        }

        k(androidx.appcompat.app.k kVar) {
            this.f721a = kVar;
            this.f722b = kVar.a();
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f723c;
            if (broadcastReceiver != null) {
                g.this.f705c.unregisterReceiver(broadcastReceiver);
                this.f723c = null;
            }
        }

        void b() {
            boolean a2 = this.f721a.a();
            if (a2 != this.f722b) {
                this.f722b = a2;
                g.this.a();
            }
        }

        int c() {
            this.f722b = this.f721a.a();
            return this.f722b ? 2 : 1;
        }

        void d() {
            a();
            if (this.f723c == null) {
                this.f723c = new a();
            }
            if (this.f724d == null) {
                this.f724d = new IntentFilter();
                this.f724d.addAction("android.intent.action.TIME_SET");
                this.f724d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f724d.addAction("android.intent.action.TIME_TICK");
            }
            g.this.f705c.registerReceiver(this.f723c, this.f724d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class l extends ContentFrameLayout {
        public l(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            g.this.d(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(a.a.k.a.a.c(getContext(), i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class m {

        /* renamed from: a  reason: collision with root package name */
        int f727a;

        /* renamed from: b  reason: collision with root package name */
        int f728b;

        /* renamed from: c  reason: collision with root package name */
        int f729c;

        /* renamed from: d  reason: collision with root package name */
        int f730d;

        /* renamed from: e  reason: collision with root package name */
        int f731e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.h j;
        androidx.appcompat.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        m(int i) {
            this.f727a = i;
        }

        q a(p.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.f(this.l, a.a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(ActionBar.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(ActionBar.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                i2 = a.a.i.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i2, true);
            a.a.n.d dVar = new a.a.n.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.a.j.AppCompatTheme);
            this.f728b = obtainStyledAttributes.getResourceId(a.a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(a.a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(androidx.appcompat.view.menu.h hVar) {
            androidx.appcompat.view.menu.f fVar;
            androidx.appcompat.view.menu.h hVar2 = this.j;
            if (hVar != hVar2) {
                if (hVar2 != null) {
                    hVar2.b(this.k);
                }
                this.j = hVar;
                if (hVar != null && (fVar = this.k) != null) {
                    hVar.a(fVar);
                }
            }
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.b().getCount() > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class n implements p.a {
        n() {
        }

        @Override // androidx.appcompat.view.menu.p.a
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            androidx.appcompat.view.menu.h m = hVar.m();
            boolean z2 = m != hVar;
            g gVar = g.this;
            if (z2) {
                hVar = m;
            }
            m a2 = gVar.a((Menu) hVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                g.this.a(a2.f727a, a2, m);
                g.this.a(a2, true);
                return;
            }
            g.this.a(a2, z);
        }

        @Override // androidx.appcompat.view.menu.p.a
        public boolean a(androidx.appcompat.view.menu.h hVar) {
            Window.Callback o;
            if (hVar != null) {
                return true;
            }
            g gVar = g.this;
            if (!gVar.z || (o = gVar.o()) == null || g.this.I) {
                return true;
            }
            o.onMenuOpened(108, hVar);
            return true;
        }
    }

    static {
        T = Build.VERSION.SDK_INT < 21;
        U = new int[]{16842836};
        if (T && !V) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
            V = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, Window window, androidx.appcompat.app.e eVar) {
        this.f705c = context;
        this.f706d = window;
        this.g = eVar;
        this.f707e = this.f706d.getCallback();
        Window.Callback callback = this.f707e;
        if (!(callback instanceof j)) {
            this.f = new j(callback);
            this.f706d.setCallback(this.f);
            s0 a2 = s0.a(context, (AttributeSet) null, U);
            Drawable c2 = a2.c(0);
            if (c2 != null) {
                this.f706d.setBackgroundDrawable(c2);
            }
            a2.a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void A() {
        if (this.t) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void a(m mVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!mVar.o && !this.I) {
            if (mVar.f727a == 0) {
                if ((this.f705c.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback o = o();
            if (o == null || o.onMenuOpened(mVar.f727a, mVar.j)) {
                WindowManager windowManager = (WindowManager) this.f705c.getSystemService("window");
                if (windowManager != null && b(mVar, keyEvent)) {
                    if (mVar.g == null || mVar.q) {
                        ViewGroup viewGroup = mVar.g;
                        if (viewGroup == null) {
                            if (!b(mVar) || mVar.g == null) {
                                return;
                            }
                        } else if (mVar.q && viewGroup.getChildCount() > 0) {
                            mVar.g.removeAllViews();
                        }
                        if (a(mVar) && mVar.a()) {
                            ViewGroup.LayoutParams layoutParams2 = mVar.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            mVar.g.setBackgroundResource(mVar.f728b);
                            ViewParent parent = mVar.h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(mVar.h);
                            }
                            mVar.g.addView(mVar.h, layoutParams2);
                            if (!mVar.h.hasFocus()) {
                                mVar.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = mVar.i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i2 = -1;
                            mVar.n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, mVar.f730d, mVar.f731e, 1002, 8519680, -3);
                            layoutParams3.gravity = mVar.f729c;
                            layoutParams3.windowAnimations = mVar.f;
                            windowManager.addView(mVar.g, layoutParams3);
                            mVar.o = true;
                            return;
                        }
                    }
                    i2 = -2;
                    mVar.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, mVar.f730d, mVar.f731e, 1002, 8519680, -3);
                    layoutParams32.gravity = mVar.f729c;
                    layoutParams32.windowAnimations = mVar.f;
                    windowManager.addView(mVar.g, layoutParams32);
                    mVar.o = true;
                    return;
                }
                return;
            }
            a(mVar, true);
        }
    }

    private void a(androidx.appcompat.view.menu.h hVar, boolean z) {
        z zVar = this.k;
        if (zVar == null || !zVar.f() || (ViewConfiguration.get(this.f705c).hasPermanentMenuKey() && !this.k.a())) {
            m a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback o = o();
        if (this.k.b() && z) {
            this.k.c();
            if (!this.I) {
                o.onPanelClosed(108, a(0, true).j);
            }
        } else if (o != null && !this.I) {
            if (this.M && (this.N & 1) != 0) {
                this.f706d.getDecorView().removeCallbacks(this.O);
                this.O.run();
            }
            m a3 = a(0, true);
            androidx.appcompat.view.menu.h hVar2 = a3.j;
            if (hVar2 != null && !a3.r && o.onPreparePanel(0, a3.i, hVar2)) {
                o.onMenuOpened(108, a3.j);
                this.k.d();
            }
        }
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f706d.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || s.v((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean a(m mVar) {
        View view = mVar.i;
        if (view != null) {
            mVar.h = view;
            return true;
        } else if (mVar.j == null) {
            return false;
        } else {
            if (this.m == null) {
                this.m = new n();
            }
            mVar.h = (View) mVar.a(this.m);
            return mVar.h != null;
        }
    }

    private boolean a(m mVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.h hVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((mVar.m || b(mVar, keyEvent)) && (hVar = mVar.j) != null) {
            z = hVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.k == null) {
            a(mVar, true);
        }
        return z;
    }

    private boolean b(m mVar) {
        mVar.a(m());
        mVar.g = new l(mVar.l);
        mVar.f729c = 81;
        return true;
    }

    private boolean b(m mVar, KeyEvent keyEvent) {
        z zVar;
        z zVar2;
        z zVar3;
        if (this.I) {
            return false;
        }
        if (mVar.m) {
            return true;
        }
        m mVar2 = this.G;
        if (!(mVar2 == null || mVar2 == mVar)) {
            a(mVar2, false);
        }
        Window.Callback o = o();
        if (o != null) {
            mVar.i = o.onCreatePanelView(mVar.f727a);
        }
        int i2 = mVar.f727a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (zVar3 = this.k) != null) {
            zVar3.e();
        }
        if (mVar.i == null) {
            if (z) {
                r();
            }
            if (mVar.j == null || mVar.r) {
                if (mVar.j == null && (!c(mVar) || mVar.j == null)) {
                    return false;
                }
                if (z && this.k != null) {
                    if (this.l == null) {
                        this.l = new h();
                    }
                    this.k.a(mVar.j, this.l);
                }
                mVar.j.s();
                if (!o.onCreatePanelMenu(mVar.f727a, mVar.j)) {
                    mVar.a((androidx.appcompat.view.menu.h) null);
                    if (z && (zVar2 = this.k) != null) {
                        zVar2.a(null, this.l);
                    }
                    return false;
                }
                mVar.r = false;
            }
            mVar.j.s();
            Bundle bundle = mVar.s;
            if (bundle != null) {
                mVar.j.a(bundle);
                mVar.s = null;
            }
            if (!o.onPreparePanel(0, mVar.i, mVar.j)) {
                if (z && (zVar = this.k) != null) {
                    zVar.a(null, this.l);
                }
                mVar.j.r();
                return false;
            }
            mVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            mVar.j.setQwertyMode(mVar.p);
            mVar.j.r();
        }
        mVar.m = true;
        mVar.n = false;
        this.G = mVar;
        return true;
    }

    private boolean c(m mVar) {
        Context context = this.f705c;
        int i2 = mVar.f727a;
        if ((i2 == 0 || i2 == 108) && this.k != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(ActionBar.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(ActionBar.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(ActionBar.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                a.a.n.d dVar = new a.a.n.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context);
        hVar.a(this);
        mVar.a(hVar);
        return true;
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        m a2 = a(i2, true);
        if (!a2.o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            a.a.n.b r0 = r3.n
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.g$m r2 = r3.a(r4, r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.z r4 = r3.k
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.f()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.f705c
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.z r4 = r3.k
            boolean r4 = r4.b()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.I
            if (r4 != 0) goto L_0x0063
            boolean r4 = r3.b(r2, r5)
            if (r4 == 0) goto L_0x0063
            androidx.appcompat.widget.z r4 = r3.k
            boolean r4 = r4.d()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.z r4 = r3.k
            boolean r4 = r4.c()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r2.n
            if (r4 == 0) goto L_0x004c
            goto L_0x0065
        L_0x004c:
            boolean r4 = r2.m
            if (r4 == 0) goto L_0x0063
            boolean r4 = r2.r
            if (r4 == 0) goto L_0x005b
            r2.m = r1
            boolean r4 = r3.b(r2, r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0063
            r3.a(r2, r5)
            r4 = 1
            goto L_0x006a
        L_0x0063:
            r4 = 0
            goto L_0x006a
        L_0x0065:
            boolean r4 = r2.o
            r3.a(r2, r0)
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            android.content.Context r5 = r3.f705c
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007c
            r5.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.e(int, android.view.KeyEvent):boolean");
    }

    private void j(int i2) {
        this.N = (1 << i2) | this.N;
        if (!this.M) {
            s.a(this.f706d.getDecorView(), this.O);
            this.M = true;
        }
    }

    private int k(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean l(int i2) {
        Resources resources = this.f705c.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        int i4 = i2 == 2 ? 32 : 16;
        if (i3 == i4) {
            return false;
        }
        if (z()) {
            ((Activity) this.f705c).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        androidx.appcompat.app.i.a(resources);
        return true;
    }

    private void t() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.u.findViewById(16908290);
        View decorView = this.f706d.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f705c.obtainStyledAttributes(a.a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup u() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f705c.obtainStyledAttributes(a.a.j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowNoTitle, false)) {
                b(1);
            } else if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowActionBar, false)) {
                b(108);
            }
            if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowActionBarOverlay, false)) {
                b(109);
            }
            if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowActionModeOverlay, false)) {
                b(10);
            }
            this.C = obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f706d.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f705c);
            if (this.D) {
                viewGroup = (ViewGroup) from.inflate(this.B ? a.a.g.abc_screen_simple_overlay_action_mode : a.a.g.abc_screen_simple, (ViewGroup) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    s.a(viewGroup, new c());
                } else {
                    ((d0) viewGroup).setOnFitSystemWindowsListener(new d());
                }
            } else if (this.C) {
                viewGroup = (ViewGroup) from.inflate(a.a.g.abc_dialog_title_material, (ViewGroup) null);
                this.A = false;
                this.z = false;
            } else if (this.z) {
                TypedValue typedValue = new TypedValue();
                this.f705c.getTheme().resolveAttribute(ActionBar.actionBarTheme, typedValue, true);
                int i2 = typedValue.resourceId;
                viewGroup = (ViewGroup) LayoutInflater.from(i2 != 0 ? new a.a.n.d(this.f705c, i2) : this.f705c).inflate(a.a.g.abc_screen_toolbar, (ViewGroup) null);
                this.k = (z) viewGroup.findViewById(a.a.f.decor_content_parent);
                this.k.setWindowCallback(o());
                if (this.A) {
                    this.k.a(109);
                }
                if (this.x) {
                    this.k.a(2);
                }
                if (this.y) {
                    this.k.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.k == null) {
                    this.v = (TextView) viewGroup.findViewById(a.a.f.title);
                }
                y0.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f706d.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f706d.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.z + ", windowActionBarOverlay: " + this.A + ", android:windowIsFloating: " + this.C + ", windowActionModeOverlay: " + this.B + ", windowNoTitle: " + this.D + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void v() {
        if (this.L == null) {
            this.L = new k(androidx.appcompat.app.k.a(this.f705c));
        }
    }

    private void w() {
        if (!this.t) {
            this.u = u();
            CharSequence n2 = n();
            if (!TextUtils.isEmpty(n2)) {
                z zVar = this.k;
                if (zVar != null) {
                    zVar.setWindowTitle(n2);
                } else if (r() != null) {
                    r().a(n2);
                } else {
                    TextView textView = this.v;
                    if (textView != null) {
                        textView.setText(n2);
                    }
                }
            }
            t();
            a(this.u);
            this.t = true;
            m a2 = a(0, false);
            if (this.I) {
                return;
            }
            if (a2 == null || a2.j == null) {
                j(108);
            }
        }
    }

    private int x() {
        int i2 = this.J;
        return i2 != -100 ? i2 : androidx.appcompat.app.f.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void y() {
        /*
            r3 = this;
            r3.w()
            boolean r0 = r3.z
            if (r0 == 0) goto L_0x0033
            androidx.appcompat.app.a r0 = r3.h
            if (r0 == 0) goto L_0x000c
            goto L_0x0033
        L_0x000c:
            android.view.Window$Callback r0 = r3.f707e
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x001e
            androidx.appcompat.app.l r1 = new androidx.appcompat.app.l
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r2 = r3.A
            r1.<init>(r0, r2)
        L_0x001b:
            r3.h = r1
            goto L_0x002a
        L_0x001e:
            boolean r1 = r0 instanceof android.app.Dialog
            if (r1 == 0) goto L_0x002a
            androidx.appcompat.app.l r1 = new androidx.appcompat.app.l
            android.app.Dialog r0 = (android.app.Dialog) r0
            r1.<init>(r0)
            goto L_0x001b
        L_0x002a:
            androidx.appcompat.app.a r0 = r3.h
            if (r0 == 0) goto L_0x0033
            boolean r1 = r3.P
            r0.c(r1)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.y():void");
    }

    private boolean z() {
        if (this.K) {
            Context context = this.f705c;
            if (context instanceof Activity) {
                try {
                    return (context.getPackageManager().getActivityInfo(new ComponentName(this.f705c, this.f705c.getClass()), 0).configChanges & 512) == 0;
                } catch (PackageManager.NameNotFoundException unused) {
                    return true;
                }
            }
        }
        return false;
    }

    public a.a.n.b a(b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar != null) {
            a.a.n.b bVar = this.n;
            if (bVar != null) {
                bVar.a();
            }
            i iVar = new i(aVar);
            androidx.appcompat.app.a c2 = c();
            if (c2 != null) {
                this.n = c2.a(iVar);
                a.a.n.b bVar2 = this.n;
                if (!(bVar2 == null || (eVar = this.g) == null)) {
                    eVar.a(bVar2);
                }
            }
            if (this.n == null) {
                this.n = b(iVar);
            }
            return this.n;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    @Override // androidx.appcompat.app.f
    public <T extends View> T a(int i2) {
        w();
        return (T) this.f706d.findViewById(i2);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        AppCompatViewInflater appCompatViewInflater;
        boolean z = false;
        if (this.S == null) {
            String string = this.f705c.obtainStyledAttributes(a.a.j.AppCompatTheme).getString(a.a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.S = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.S = appCompatViewInflater;
        }
        if (!T) {
            z = false;
        } else if (!(attributeSet instanceof XmlPullParser)) {
            z = a((ViewParent) view);
        } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
            z = true;
        }
        return this.S.createView(view, str, context, attributeSet, z, T, true, x0.b());
    }

    protected m a(int i2, boolean z) {
        m[] mVarArr = this.F;
        if (mVarArr == null || mVarArr.length <= i2) {
            m[] mVarArr2 = new m[i2 + 1];
            if (mVarArr != null) {
                System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            }
            this.F = mVarArr2;
            mVarArr = mVarArr2;
        }
        m mVar = mVarArr[i2];
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(i2);
        mVarArr[i2] = mVar2;
        return mVar2;
    }

    m a(Menu menu) {
        m[] mVarArr = this.F;
        int length = mVarArr != null ? mVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            m mVar = mVarArr[i2];
            if (mVar != null && mVar.j == menu) {
                return mVar;
            }
        }
        return null;
    }

    void a(int i2, m mVar, Menu menu) {
        if (menu == null) {
            if (mVar == null && i2 >= 0) {
                m[] mVarArr = this.F;
                if (i2 < mVarArr.length) {
                    mVar = mVarArr[i2];
                }
            }
            if (mVar != null) {
                menu = mVar.j;
            }
        }
        if ((mVar == null || mVar.o) && !this.I) {
            this.f707e.onPanelClosed(i2, menu);
        }
    }

    @Override // androidx.appcompat.app.f
    public void a(Configuration configuration) {
        androidx.appcompat.app.a c2;
        if (this.z && this.t && (c2 = c()) != null) {
            c2.a(configuration);
        }
        androidx.appcompat.widget.j.a().a(this.f705c);
        a();
    }

    @Override // androidx.appcompat.app.f
    public void a(Bundle bundle) {
        Window.Callback callback = this.f707e;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.e.b((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a r = r();
                if (r == null) {
                    this.P = true;
                } else {
                    r.c(true);
                }
            }
        }
        if (bundle != null && this.J == -100) {
            this.J = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    @Override // androidx.appcompat.app.f
    public void a(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f707e.onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ((ViewGroup) this.u.findViewById(16908290)).addView(view, layoutParams);
        this.f707e.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    void a(m mVar, boolean z) {
        ViewGroup viewGroup;
        z zVar;
        if (!z || mVar.f727a != 0 || (zVar = this.k) == null || !zVar.b()) {
            WindowManager windowManager = (WindowManager) this.f705c.getSystemService("window");
            if (!(windowManager == null || !mVar.o || (viewGroup = mVar.g) == null)) {
                windowManager.removeView(viewGroup);
                if (z) {
                    a(mVar.f727a, mVar, null);
                }
            }
            mVar.m = false;
            mVar.n = false;
            mVar.o = false;
            mVar.h = null;
            mVar.q = true;
            if (this.G == mVar) {
                this.G = null;
                return;
            }
            return;
        }
        b(mVar.j);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void a(androidx.appcompat.view.menu.h hVar) {
        a(hVar, true);
    }

    @Override // androidx.appcompat.app.f
    public final void a(CharSequence charSequence) {
        this.j = charSequence;
        z zVar = this.k;
        if (zVar != null) {
            zVar.setWindowTitle(charSequence);
        } else if (r() != null) {
            r().a(charSequence);
        } else {
            TextView textView = this.v;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public boolean a() {
        int x = x();
        int f2 = f(x);
        boolean l2 = f2 != -1 ? l(f2) : false;
        if (x == 0) {
            v();
            this.L.d();
        }
        this.K = true;
        return l2;
    }

    boolean a(int i2, KeyEvent keyEvent) {
        boolean z = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.H = z;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        Window.Callback callback = this.f707e;
        boolean z = true;
        if (((callback instanceof e.a) || (callback instanceof androidx.appcompat.app.h)) && (decorView = this.f706d.getDecorView()) != null && a.g.l.e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f707e.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? a(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        m a2;
        Window.Callback o = o();
        if (o == null || this.I || (a2 = a((Menu) hVar.m())) == null) {
            return false;
        }
        return o.onMenuItemSelected(a2.f727a, menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    a.a.n.b b(a.a.n.b.a r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.b(a.a.n.b$a):a.a.n.b");
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater b() {
        if (this.i == null) {
            y();
            androidx.appcompat.app.a aVar = this.h;
            this.i = new a.a.n.g(aVar != null ? aVar.h() : this.f705c);
        }
        return this.i;
    }

    @Override // androidx.appcompat.app.f
    public void b(Bundle bundle) {
        w();
    }

    @Override // androidx.appcompat.app.f
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f707e.onContentChanged();
    }

    void b(androidx.appcompat.view.menu.h hVar) {
        if (!this.E) {
            this.E = true;
            this.k.g();
            Window.Callback o = o();
            if (o != null && !this.I) {
                o.onPanelClosed(108, hVar);
            }
            this.E = false;
        }
    }

    @Override // androidx.appcompat.app.f
    public boolean b(int i2) {
        int k2 = k(i2);
        if (this.D && k2 == 108) {
            return false;
        }
        if (this.z && k2 == 1) {
            this.z = false;
        }
        if (k2 == 1) {
            A();
            this.D = true;
            return true;
        } else if (k2 == 2) {
            A();
            this.x = true;
            return true;
        } else if (k2 == 5) {
            A();
            this.y = true;
            return true;
        } else if (k2 == 10) {
            A();
            this.B = true;
            return true;
        } else if (k2 == 108) {
            A();
            this.z = true;
            return true;
        } else if (k2 != 109) {
            return this.f706d.requestFeature(k2);
        } else {
            A();
            this.A = true;
            return true;
        }
    }

    boolean b(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a c2 = c();
        if (c2 != null && c2.a(i2, keyEvent)) {
            return true;
        }
        m mVar = this.G;
        if (mVar == null || !a(mVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.G == null) {
                m a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        m mVar2 = this.G;
        if (mVar2 != null) {
            mVar2.n = true;
        }
        return true;
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a c() {
        y();
        return this.h;
    }

    @Override // androidx.appcompat.app.f
    public void c(int i2) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f705c).inflate(i2, viewGroup);
        this.f707e.onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void c(Bundle bundle) {
        int i2 = this.J;
        if (i2 != -100) {
            bundle.putInt("appcompat:local_night_mode", i2);
        }
    }

    boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.H;
            this.H = false;
            m a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            } else if (q()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void d() {
        LayoutInflater from = LayoutInflater.from(this.f705c);
        if (from.getFactory() == null) {
            a.g.l.f.b(from, this);
        } else if (!(from.getFactory2() instanceof g)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    void d(int i2) {
        a(a(i2, true), true);
    }

    @Override // androidx.appcompat.app.f
    public void e() {
        androidx.appcompat.app.a c2 = c();
        if (c2 == null || !c2.i()) {
            j(0);
        }
    }

    void e(int i2) {
        m a2;
        m a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.b(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.s();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 == 108 || i2 == 0) && this.k != null && (a2 = a(0, false)) != null) {
            a2.m = false;
            b(a2, (KeyEvent) null);
        }
    }

    int f(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.f705c.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        v();
        return this.L.c();
    }

    @Override // androidx.appcompat.app.f
    public void f() {
        if (this.M) {
            this.f706d.getDecorView().removeCallbacks(this.O);
        }
        this.I = true;
        androidx.appcompat.app.a aVar = this.h;
        if (aVar != null) {
            aVar.j();
        }
        k kVar = this.L;
        if (kVar != null) {
            kVar.a();
        }
    }

    @Override // androidx.appcompat.app.f
    public void g() {
        androidx.appcompat.app.a c2 = c();
        if (c2 != null) {
            c2.d(true);
        }
    }

    void g(int i2) {
        androidx.appcompat.app.a c2;
        if (i2 == 108 && (c2 = c()) != null) {
            c2.b(true);
        }
    }

    @Override // androidx.appcompat.app.f
    public void h() {
        a();
    }

    void h(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a c2 = c();
            if (c2 != null) {
                c2.b(false);
            }
        } else if (i2 == 0) {
            m a2 = a(i2, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    int i(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.o;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.o.getLayoutParams();
            z = true;
            if (this.o.isShown()) {
                if (this.Q == null) {
                    this.Q = new Rect();
                    this.R = new Rect();
                }
                Rect rect = this.Q;
                Rect rect2 = this.R;
                rect.set(0, i2, 0, 0);
                y0.a(this.u, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.w;
                    if (view == null) {
                        this.w = new View(this.f705c);
                        this.w.setBackgroundColor(this.f705c.getResources().getColor(a.a.c.abc_input_method_navigation_guard));
                        this.u.addView(this.w, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.w.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.w == null) {
                    z = false;
                }
                if (!this.B && z) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.o.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.w;
        if (view2 != null) {
            if (!z) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        return i2;
    }

    @Override // androidx.appcompat.app.f
    public void i() {
        androidx.appcompat.app.a c2 = c();
        if (c2 != null) {
            c2.d(false);
        }
        k kVar = this.L;
        if (kVar != null) {
            kVar.a();
        }
    }

    void k() {
        androidx.appcompat.view.menu.h hVar;
        z zVar = this.k;
        if (zVar != null) {
            zVar.g();
        }
        if (this.p != null) {
            this.f706d.getDecorView().removeCallbacks(this.q);
            if (this.p.isShowing()) {
                try {
                    this.p.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.p = null;
        }
        l();
        m a2 = a(0, false);
        if (a2 != null && (hVar = a2.j) != null) {
            hVar.close();
        }
    }

    void l() {
        w wVar = this.r;
        if (wVar != null) {
            wVar.a();
        }
    }

    final Context m() {
        androidx.appcompat.app.a c2 = c();
        Context h2 = c2 != null ? c2.h() : null;
        return h2 == null ? this.f705c : h2;
    }

    final CharSequence n() {
        Window.Callback callback = this.f707e;
        return callback instanceof Activity ? ((Activity) callback).getTitle() : this.j;
    }

    final Window.Callback o() {
        return this.f706d.getCallback();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public boolean p() {
        return this.s;
    }

    boolean q() {
        a.a.n.b bVar = this.n;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        androidx.appcompat.app.a c2 = c();
        return c2 != null && c2.f();
    }

    final androidx.appcompat.app.a r() {
        return this.h;
    }

    final boolean s() {
        ViewGroup viewGroup;
        return this.t && (viewGroup = this.u) != null && s.w(viewGroup);
    }
}
