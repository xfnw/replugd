package a.k.a;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.k;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class c implements ComponentCallbacks, View.OnCreateContextMenuListener, g, s {
    private static final a.d.g<String, Class<?>> X = new a.d.g<>();
    static final Object Y = new Object();
    String A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean H;
    ViewGroup I;
    View J;
    View K;
    boolean L;
    d N;
    boolean O;
    boolean P;
    float Q;
    LayoutInflater R;
    boolean S;
    h U;
    g V;

    /* renamed from: c  reason: collision with root package name */
    Bundle f388c;

    /* renamed from: d  reason: collision with root package name */
    SparseArray<Parcelable> f389d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f390e;
    String g;
    Bundle h;
    c i;
    int k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    i s;
    g t;
    i u;
    j v;
    r w;
    c x;
    int y;
    int z;

    /* renamed from: b  reason: collision with root package name */
    int f387b = 0;
    int f = -1;
    int j = -1;
    boolean G = true;
    boolean M = true;
    h T = new h(this);
    l<g> W = new l<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends a.k.a.e {
        b() {
        }

        @Override // a.k.a.e
        public c a(Context context, String str, Bundle bundle) {
            return c.this.t.a(context, str, bundle);
        }

        @Override // a.k.a.e
        public View a(int i) {
            View view = c.this.J;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // a.k.a.e
        public boolean a() {
            return c.this.J != null;
        }
    }

    /* renamed from: a.k.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0020c implements g {
        C0020c() {
        }

        @Override // androidx.lifecycle.g
        public androidx.lifecycle.e e() {
            c cVar = c.this;
            if (cVar.U == null) {
                cVar.U = new h(cVar.V);
            }
            return c.this.U;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f394a;

        /* renamed from: b  reason: collision with root package name */
        Animator f395b;

        /* renamed from: c  reason: collision with root package name */
        int f396c;

        /* renamed from: d  reason: collision with root package name */
        int f397d;

        /* renamed from: e  reason: collision with root package name */
        int f398e;
        int f;
        Object h;
        Object j;
        Object l;
        Boolean m;
        Boolean n;
        boolean q;
        f r;
        boolean s;
        Object g = null;
        Object i = null;
        Object k = null;
        k o = null;
        k p = null;

        d() {
            Object obj = c.Y;
            this.h = obj;
            this.j = obj;
            this.l = obj;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    private d Z() {
        if (this.N == null) {
            this.N = new d();
        }
        return this.N;
    }

    public static c a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                X.put(str, cls);
            }
            c cVar = (c) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(cVar.getClass().getClassLoader());
                cVar.m(bundle);
            }
            return cVar;
        } catch (ClassNotFoundException e2) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (InstantiationException e4) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        try {
            Class<?> cls = X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                X.put(str, cls);
            }
            return c.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    void A() {
        if (this.t != null) {
            this.u = new i();
            this.u.a(this.t, new b(), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        d dVar = this.N;
        if (dVar == null) {
            return false;
        }
        return dVar.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean C() {
        return this.r > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        d dVar = this.N;
        if (dVar == null) {
            return false;
        }
        return dVar.q;
    }

    public final boolean E() {
        i iVar = this.s;
        if (iVar == null) {
            return false;
        }
        return iVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        i iVar = this.u;
        if (iVar != null) {
            iVar.q();
        }
    }

    public void G() {
        boolean z = true;
        this.H = true;
        a.k.a.d b2 = b();
        if (b2 == null || !b2.isChangingConfigurations()) {
            z = false;
        }
        r rVar = this.w;
        if (rVar != null && !z) {
            rVar.a();
        }
    }

    public void H() {
    }

    public void I() {
        this.H = true;
    }

    public void J() {
        this.H = true;
    }

    public void K() {
        this.H = true;
    }

    public void L() {
        this.H = true;
    }

    public void M() {
        this.H = true;
    }

    public void N() {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h O() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        this.T.a(e.a.ON_DESTROY);
        i iVar = this.u;
        if (iVar != null) {
            iVar.f();
        }
        this.f387b = 0;
        this.H = false;
        this.S = false;
        G();
        if (this.H) {
            this.u = null;
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        if (this.J != null) {
            this.U.a(e.a.ON_DESTROY);
        }
        i iVar = this.u;
        if (iVar != null) {
            iVar.g();
        }
        this.f387b = 1;
        this.H = false;
        I();
        if (this.H) {
            a.m.a.a.a(this).a();
            this.q = false;
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        this.H = false;
        J();
        this.R = null;
        if (this.H) {
            i iVar = this.u;
            if (iVar == null) {
                return;
            }
            if (this.E) {
                iVar.f();
                this.u = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
        }
        throw new r("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        onLowMemory();
        i iVar = this.u;
        if (iVar != null) {
            iVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T() {
        if (this.J != null) {
            this.U.a(e.a.ON_PAUSE);
        }
        this.T.a(e.a.ON_PAUSE);
        i iVar = this.u;
        if (iVar != null) {
            iVar.i();
        }
        this.f387b = 3;
        this.H = false;
        K();
        if (!this.H) {
            throw new r("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        i iVar = this.u;
        if (iVar != null) {
            iVar.q();
            this.u.n();
        }
        this.f387b = 4;
        this.H = false;
        L();
        if (this.H) {
            i iVar2 = this.u;
            if (iVar2 != null) {
                iVar2.j();
                this.u.n();
            }
            this.T.a(e.a.ON_RESUME);
            if (this.J != null) {
                this.U.a(e.a.ON_RESUME);
                return;
            }
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onResume()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        i iVar = this.u;
        if (iVar != null) {
            iVar.q();
            this.u.n();
        }
        this.f387b = 3;
        this.H = false;
        M();
        if (this.H) {
            i iVar2 = this.u;
            if (iVar2 != null) {
                iVar2.k();
            }
            this.T.a(e.a.ON_START);
            if (this.J != null) {
                this.U.a(e.a.ON_START);
                return;
            }
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onStart()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W() {
        if (this.J != null) {
            this.U.a(e.a.ON_STOP);
        }
        this.T.a(e.a.ON_STOP);
        i iVar = this.u;
        if (iVar != null) {
            iVar.l();
        }
        this.f387b = 2;
        this.H = false;
        N();
        if (!this.H) {
            throw new r("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final Context X() {
        Context j = j();
        if (j != null) {
            return j;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void Y() {
        i iVar = this.s;
        if (iVar == null || iVar.n == null) {
            Z().q = false;
        } else if (Looper.myLooper() != this.s.n.e().getLooper()) {
            this.s.n.e().postAtFrontOfQueue(new a());
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(String str) {
        if (str.equals(this.g)) {
            return this;
        }
        i iVar = this.u;
        if (iVar != null) {
            return iVar.b(str);
        }
        return null;
    }

    @Deprecated
    public LayoutInflater a(Bundle bundle) {
        g gVar = this.t;
        if (gVar != null) {
            LayoutInflater f2 = gVar.f();
            i();
            i iVar = this.u;
            iVar.o();
            a.g.l.f.b(f2, iVar);
            return f2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    void a() {
        d dVar = this.N;
        f fVar = null;
        if (dVar != null) {
            dVar.q = false;
            fVar = dVar.r;
            dVar.r = null;
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.N != null || i != 0) {
            Z().f397d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (this.N != null || i != 0 || i2 != 0) {
            Z();
            d dVar = this.N;
            dVar.f398e = i;
            dVar.f = i2;
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, c cVar) {
        String str;
        StringBuilder sb;
        this.f = i;
        if (cVar != null) {
            sb = new StringBuilder();
            sb.append(cVar.g);
            str = ":";
        } else {
            sb = new StringBuilder();
            str = "android:fragment:";
        }
        sb.append(str);
        sb.append(this.f);
        this.g = sb.toString();
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        Z();
        f fVar2 = this.N.r;
        if (fVar != fVar2) {
            if (fVar == null || fVar2 == null) {
                d dVar = this.N;
                if (dVar.q) {
                    dVar.r = fVar;
                }
                if (fVar != null) {
                    fVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void a(c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Animator animator) {
        Z().f395b = animator;
    }

    @Deprecated
    public void a(Activity activity) {
        this.H = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
    }

    public void a(Context context) {
        this.H = true;
        g gVar = this.t;
        Activity b2 = gVar == null ? null : gVar.b();
        if (b2 != null) {
            this.H = false;
            a(b2);
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
        g gVar = this.t;
        Activity b2 = gVar == null ? null : gVar.b();
        if (b2 != null) {
            this.H = false;
            a(b2, attributeSet, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        i iVar = this.u;
        if (iVar != null) {
            iVar.a(configuration);
        }
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        Z().f394a = view;
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mTag=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f387b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.B);
        printWriter.print(" mDetached=");
        printWriter.print(this.C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.D);
        printWriter.print(" mRetaining=");
        printWriter.print(this.E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.M);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.x);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.h);
        }
        if (this.f388c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f388c);
        }
        if (this.f389d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f389d);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.k);
        }
        if (p() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(p());
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.J);
        }
        if (g() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(g());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(x());
        }
        if (j() != null) {
            a.m.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            i iVar = this.u;
            iVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void a(boolean z) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public final a.k.a.d b() {
        g gVar = this.t;
        if (gVar == null) {
            return null;
        }
        return (a.k.a.d) gVar.b();
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        Z().f396c = i;
    }

    public void b(Bundle bundle) {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i iVar = this.u;
        if (iVar != null) {
            iVar.q();
        }
        this.q = true;
        this.V = new C0020c();
        this.U = null;
        this.J = a(layoutInflater, viewGroup, bundle);
        if (this.J != null) {
            this.V.e();
            this.W.a((l<g>) this.V);
        } else if (this.U == null) {
            this.V = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            a(menu, menuInflater);
            z = true;
        }
        i iVar = this.u;
        return iVar != null ? z | iVar.a(menu, menuInflater) : z;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void c(Bundle bundle) {
        this.H = true;
        k(bundle);
        i iVar = this.u;
        if (iVar != null && !iVar.c(1)) {
            this.u.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Menu menu) {
        if (!this.B) {
            if (this.F && this.G) {
                a(menu);
            }
            i iVar = this.u;
            if (iVar != null) {
                iVar.a(menu);
            }
        }
    }

    public void c(boolean z) {
    }

    public boolean c() {
        Boolean bool;
        d dVar = this.N;
        if (dVar == null || (bool = dVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (this.B) {
            return false;
        }
        if (a(menuItem)) {
            return true;
        }
        i iVar = this.u;
        return iVar != null && iVar.a(menuItem);
    }

    public LayoutInflater d(Bundle bundle) {
        return a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z) {
        b(z);
        i iVar = this.u;
        if (iVar != null) {
            iVar.a(z);
        }
    }

    public boolean d() {
        Boolean bool;
        d dVar = this.N;
        if (dVar == null || (bool = dVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Menu menu) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            b(menu);
            z = true;
        }
        i iVar = this.u;
        return iVar != null ? z | iVar.b(menu) : z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (this.B) {
            return false;
        }
        if (this.F && this.G && b(menuItem)) {
            return true;
        }
        i iVar = this.u;
        return iVar != null && iVar.b(menuItem);
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.e e() {
        return this.T;
    }

    public void e(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z) {
        c(z);
        i iVar = this.u;
        if (iVar != null) {
            iVar.b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.lifecycle.s
    public r f() {
        if (j() != null) {
            if (this.w == null) {
                this.w = new r();
            }
            return this.w;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void f(Bundle bundle) {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z) {
        Z().s = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View g() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.f394a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        i iVar = this.u;
        if (iVar != null) {
            iVar.q();
        }
        this.f387b = 2;
        this.H = false;
        b(bundle);
        if (this.H) {
            i iVar2 = this.u;
            if (iVar2 != null) {
                iVar2.d();
                return;
            }
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator h() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.f395b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        i iVar = this.u;
        if (iVar != null) {
            iVar.q();
        }
        this.f387b = 1;
        this.H = false;
        c(bundle);
        this.S = true;
        if (this.H) {
            this.T.a(e.a.ON_CREATE);
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onCreate()");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final h i() {
        if (this.u == null) {
            A();
            int i = this.f387b;
            if (i >= 4) {
                this.u.j();
            } else if (i >= 3) {
                this.u.k();
            } else if (i >= 2) {
                this.u.d();
            } else if (i >= 1) {
                this.u.e();
            }
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater i(Bundle bundle) {
        this.R = d(bundle);
        return this.R;
    }

    public Context j() {
        g gVar = this.t;
        if (gVar == null) {
            return null;
        }
        return gVar.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Bundle bundle) {
        Parcelable t;
        e(bundle);
        i iVar = this.u;
        if (iVar != null && (t = iVar.t()) != null) {
            bundle.putParcelable("android:support:fragments", t);
        }
    }

    public Object k() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.u == null) {
                A();
            }
            this.u.a(parcelable, this.v);
            this.v = null;
            this.u.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k l() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f389d;
        if (sparseArray != null) {
            this.K.restoreHierarchyState(sparseArray);
            this.f389d = null;
        }
        this.H = false;
        f(bundle);
        if (!this.H) {
            throw new r("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.J != null) {
            this.U.a(e.a.ON_CREATE);
        }
    }

    public Object m() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.i;
    }

    public void m(Bundle bundle) {
        if (this.f < 0 || !E()) {
            this.h = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k n() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.p;
    }

    public final h o() {
        return this.s;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f397d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f398e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f;
    }

    public Object s() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.j;
        return obj == Y ? m() : obj;
    }

    public final Resources t() {
        return X().getResources();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        a.g.k.a.a(this, sb);
        if (this.f >= 0) {
            sb.append(" #");
            sb.append(this.f);
        }
        if (this.y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.y));
        }
        if (this.A != null) {
            sb.append(" ");
            sb.append(this.A);
        }
        sb.append('}');
        return sb.toString();
    }

    public Object u() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.h;
        return obj == Y ? k() : obj;
    }

    public Object v() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.k;
    }

    public Object w() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.l;
        return obj == Y ? v() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f396c;
    }

    public View y() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        this.f = -1;
        this.g = null;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
        this.E = false;
    }
}
