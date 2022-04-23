package a.k.a;

import a.g.l.s;
import a.k.a.c;
import a.k.a.h;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends a.k.a.h implements LayoutInflater.Factory2 {
    static boolean F = false;
    static Field G;
    static final Interpolator H = new DecelerateInterpolator(2.5f);
    static final Interpolator I = new DecelerateInterpolator(1.5f);
    ArrayList<m> C;
    a.k.a.j D;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<l> f410b;

    /* renamed from: c  reason: collision with root package name */
    boolean f411c;
    SparseArray<a.k.a.c> f;
    ArrayList<a.k.a.a> g;
    ArrayList<a.k.a.c> h;
    ArrayList<a.k.a.a> i;
    ArrayList<Integer> j;
    ArrayList<h.c> k;
    a.k.a.g n;
    a.k.a.e o;
    a.k.a.c p;
    a.k.a.c q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<a.k.a.a> x;
    ArrayList<Boolean> y;
    ArrayList<a.k.a.c> z;

    /* renamed from: d  reason: collision with root package name */
    int f412d = 0;

    /* renamed from: e  reason: collision with root package name */
    final ArrayList<a.k.a.c> f413e = new ArrayList<>();
    private final CopyOnWriteArrayList<j> l = new CopyOnWriteArrayList<>();
    int m = 0;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    Runnable E = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.k.a.c f416c;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f416c.g() != null) {
                    b.this.f416c.a((View) null);
                    b bVar = b.this;
                    i iVar = i.this;
                    a.k.a.c cVar = bVar.f416c;
                    iVar.a(cVar, cVar.x(), 0, 0, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Animation.AnimationListener animationListener, ViewGroup viewGroup, a.k.a.c cVar) {
            super(animationListener);
            this.f415b = viewGroup;
            this.f416c = cVar;
        }

        @Override // a.k.a.i.f, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            this.f415b.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f419b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f420c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a.k.a.c f421d;

        c(ViewGroup viewGroup, View view, a.k.a.c cVar) {
            this.f419b = viewGroup;
            this.f420c = view;
            this.f421d = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f419b.endViewTransition(this.f420c);
            Animator h = this.f421d.h();
            this.f421d.a((Animator) null);
            if (h != null && this.f419b.indexOfChild(this.f420c) < 0) {
                i iVar = i.this;
                a.k.a.c cVar = this.f421d;
                iVar.a(cVar, cVar.x(), 0, 0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f423b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f424c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a.k.a.c f425d;

        d(i iVar, ViewGroup viewGroup, View view, a.k.a.c cVar) {
            this.f423b = viewGroup;
            this.f424c = view;
            this.f425d = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f423b.endViewTransition(this.f424c);
            animator.removeListener(this);
            View view = this.f425d.J;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        View f426b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f426b.setLayerType(0, null);
            }
        }

        e(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f426b = view;
        }

        @Override // a.k.a.i.f, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (s.v(this.f426b) || Build.VERSION.SDK_INT >= 24) {
                this.f426b.post(new a());
            } else {
                this.f426b.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* loaded from: classes.dex */
    private static class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final Animation.AnimationListener f428a;

        f(Animation.AnimationListener animationListener) {
            this.f428a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f428a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f428a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f428a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f429a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f430b;

        g(Animator animator) {
            this.f429a = null;
            this.f430b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        g(Animation animation) {
            this.f429a = animation;
            this.f430b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        View f431b;

        h(View view) {
            this.f431b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f431b.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f431b.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.k.a.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0021i extends AnimationSet implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final ViewGroup f432b;

        /* renamed from: c  reason: collision with root package name */
        private final View f433c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f434d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f435e;
        private boolean f = true;

        RunnableC0021i(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f432b = viewGroup;
            this.f433c = view;
            addAnimation(animation);
            this.f432b.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f = true;
            if (this.f434d) {
                return !this.f435e;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f434d = true;
                q.a(this.f432b, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f = true;
            if (this.f434d) {
                return !this.f435e;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f434d = true;
                q.a(this.f432b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f434d || !this.f) {
                this.f432b.endViewTransition(this.f433c);
                this.f435e = true;
                return;
            }
            this.f = false;
            this.f432b.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class j {

        /* renamed from: a  reason: collision with root package name */
        final h.b f436a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f437b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f438a = {16842755, 16842960, 16842961};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface l {
        boolean a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m implements c.f {

        /* renamed from: a  reason: collision with root package name */
        final boolean f439a;

        /* renamed from: b  reason: collision with root package name */
        final a.k.a.a f440b;

        /* renamed from: c  reason: collision with root package name */
        private int f441c;

        m(a.k.a.a aVar, boolean z) {
            this.f439a = z;
            this.f440b = aVar;
        }

        @Override // a.k.a.c.f
        public void a() {
            this.f441c--;
            if (this.f441c == 0) {
                this.f440b.f373a.v();
            }
        }

        @Override // a.k.a.c.f
        public void b() {
            this.f441c++;
        }

        public void c() {
            a.k.a.a aVar = this.f440b;
            aVar.f373a.a(aVar, this.f439a, false, false);
        }

        public void d() {
            boolean z = this.f441c > 0;
            i iVar = this.f440b.f373a;
            int size = iVar.f413e.size();
            for (int i = 0; i < size; i++) {
                a.k.a.c cVar = iVar.f413e.get(i);
                cVar.a((c.f) null);
                if (z && cVar.D()) {
                    cVar.Y();
                }
            }
            a.k.a.a aVar = this.f440b;
            aVar.f373a.a(aVar, this.f439a, !z, true);
        }

        public boolean e() {
            return this.f441c == 0;
        }
    }

    static {
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    private void A() {
        SparseArray<a.k.a.c> sparseArray = this.f;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i = 0; i < size; i++) {
            a.k.a.c valueAt = this.f.valueAt(i);
            if (valueAt != null) {
                if (valueAt.g() != null) {
                    int x = valueAt.x();
                    View g2 = valueAt.g();
                    Animation animation = g2.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        g2.clearAnimation();
                    }
                    valueAt.a((View) null);
                    a(valueAt, x, 0, 0, false);
                } else if (valueAt.h() != null) {
                    valueAt.h().end();
                }
            }
        }
    }

    private void B() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private int a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, a.d.b<a.k.a.c> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            a.k.a.a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.c() && !aVar.a(arrayList, i4 + 1, i2)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                m mVar = new m(aVar, booleanValue);
                this.C.add(mVar);
                aVar.a(mVar);
                if (booleanValue) {
                    aVar.a();
                } else {
                    aVar.a(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                a(bVar);
            }
        }
        return i3;
    }

    static g a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(I);
        alphaAnimation.setDuration(220L);
        return new g(alphaAnimation);
    }

    static g a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(H);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(I);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new g(animationSet);
    }

    private static Animation.AnimationListener a(Animation animation) {
        Throwable e2;
        String str;
        try {
            if (G == null) {
                G = Animation.class.getDeclaredField("mListener");
                G.setAccessible(true);
            }
            return (Animation.AnimationListener) G.get(animation);
        } catch (IllegalAccessException e3) {
            e2 = e3;
            str = "Cannot access Animation's mListener field";
            Log.e("FragmentManager", str, e2);
            return null;
        } catch (NoSuchFieldException e4) {
            e2 = e4;
            str = "No field with the name mListener is found in Animation class";
            Log.e("FragmentManager", str, e2);
            return null;
        }
    }

    private void a(a.d.b<a.k.a.c> bVar) {
        int i = this.m;
        if (i >= 1) {
            int min = Math.min(i, 3);
            int size = this.f413e.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.k.a.c cVar = this.f413e.get(i2);
                if (cVar.f387b < min) {
                    a(cVar, min, cVar.p(), cVar.q(), false);
                    if (cVar.J != null && !cVar.B && cVar.O) {
                        bVar.add(cVar);
                    }
                }
            }
        }
    }

    private void a(a.k.a.c cVar, g gVar, int i) {
        View view = cVar.J;
        ViewGroup viewGroup = cVar.I;
        viewGroup.startViewTransition(view);
        cVar.b(i);
        Animation animation = gVar.f429a;
        if (animation != null) {
            RunnableC0021i iVar = new RunnableC0021i(animation, viewGroup, view);
            cVar.a(cVar.J);
            iVar.setAnimationListener(new b(a(iVar), viewGroup, cVar));
            a(view, gVar);
            cVar.J.startAnimation(iVar);
            return;
        }
        Animator animator = gVar.f430b;
        cVar.a(animator);
        animator.addListener(new c(viewGroup, view, cVar));
        animator.setTarget(cVar.J);
        a(cVar.J, gVar);
        animator.start();
    }

    private static void a(a.k.a.j jVar) {
        if (jVar != null) {
            List<a.k.a.c> b2 = jVar.b();
            if (b2 != null) {
                for (a.k.a.c cVar : b2) {
                    cVar.E = true;
                }
            }
            List<a.k.a.j> a2 = jVar.a();
            if (a2 != null) {
                for (a.k.a.j jVar2 : a2) {
                    a(jVar2);
                }
            }
        }
    }

    private static void a(View view, g gVar) {
        if (view != null && gVar != null && b(view, gVar)) {
            Animator animator = gVar.f430b;
            if (animator != null) {
                animator.addListener(new h(view));
                return;
            }
            Animation.AnimationListener a2 = a(gVar.f429a);
            view.setLayerType(2, null);
            gVar.f429a.setAnimationListener(new e(view, a2));
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a.g.k.b("FragmentManager"));
        a.k.a.g gVar = this.n;
        try {
            if (gVar != null) {
                gVar.a("  ", null, printWriter, new String[0]);
            } else {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            }
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
        }
        throw runtimeException;
    }

    private void a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<m> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            m mVar = this.C.get(i);
            if (arrayList == null || mVar.f439a || (indexOf2 = arrayList.indexOf(mVar.f440b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (mVar.e() || (arrayList != null && mVar.f440b.a(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || mVar.f439a || (indexOf = arrayList.indexOf(mVar.f440b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        mVar.d();
                    }
                }
                i++;
            }
            mVar.c();
            i++;
        }
    }

    private static void a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            a.k.a.a aVar = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                aVar.a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                aVar.a(z);
            } else {
                aVar.a(1);
                aVar.a();
            }
            i++;
        }
    }

    static boolean a(g gVar) {
        Animation animation = gVar.f429a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return a(gVar.f430b);
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (a(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(String str, int i, int i2) {
        a.k.a.h O;
        n();
        c(true);
        a.k.a.c cVar = this.q;
        if (cVar != null && i < 0 && str == null && (O = cVar.O()) != null && O.c()) {
            return true;
        }
        boolean a2 = a(this.x, this.y, str, i, i2);
        if (a2) {
            this.f411c = true;
            try {
                c(this.x, this.y);
            } finally {
                z();
            }
        }
        m();
        x();
        return a2;
    }

    public static int b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    private void b(a.d.b<a.k.a.c> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            a.k.a.c c2 = bVar.c(i);
            if (!c2.l) {
                View y = c2.y();
                c2.Q = y.getAlpha();
                y.setAlpha(0.0f);
            }
        }
    }

    private void b(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).s;
        ArrayList<a.k.a.c> arrayList3 = this.z;
        if (arrayList3 == null) {
            this.z = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.z.addAll(this.f413e);
        a.k.a.c p = p();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            a.k.a.a aVar = arrayList.get(i6);
            p = !arrayList2.get(i6).booleanValue() ? aVar.a(this.z, p) : aVar.b(this.z, p);
            z2 = z2 || aVar.i;
        }
        this.z.clear();
        if (!z) {
            n.a(this, arrayList, arrayList2, i, i2, false);
        }
        a(arrayList, arrayList2, i, i2);
        if (z) {
            a.d.b<a.k.a.c> bVar = new a.d.b<>();
            a(bVar);
            i3 = a(arrayList, arrayList2, i, i2, bVar);
            b(bVar);
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            n.a(this, arrayList, arrayList2, i, i3, true);
            a(this.m, true);
        }
        while (i5 < i2) {
            a.k.a.a aVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = aVar2.l) >= 0) {
                b(i4);
                aVar2.l = -1;
            }
            aVar2.d();
            i5++;
        }
        if (z2) {
            r();
        }
    }

    static boolean b(View view, g gVar) {
        return view != null && gVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && s.t(view) && a(gVar);
    }

    private boolean b(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (!(this.f410b == null || this.f410b.size() == 0)) {
                int size = this.f410b.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.f410b.get(i).a(arrayList, arrayList2);
                }
                this.f410b.clear();
                this.n.e().removeCallbacks(this.E);
                return z;
            }
            return false;
        }
    }

    private void c(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).s) {
                    if (i2 != i) {
                        b(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).s) {
                            i2++;
                        }
                    }
                    b(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                b(arrayList, arrayList2, i2, size);
            }
        }
    }

    private void c(boolean z) {
        if (this.f411c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.n == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.n.e().getLooper()) {
            if (!z) {
                y();
            }
            if (this.x == null) {
                this.x = new ArrayList<>();
                this.y = new ArrayList<>();
            }
            this.f411c = true;
            try {
                a((ArrayList<a.k.a.a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f411c = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* JADX WARN: Finally extract failed */
    private void d(int i) {
        try {
            this.f411c = true;
            a(i, false);
            this.f411c = false;
            n();
        } catch (Throwable th) {
            this.f411c = false;
            throw th;
        }
    }

    public static int e(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private a.k.a.c p(a.k.a.c cVar) {
        ViewGroup viewGroup = cVar.I;
        View view = cVar.J;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f413e.indexOf(cVar) - 1; indexOf >= 0; indexOf--) {
                a.k.a.c cVar2 = this.f413e.get(indexOf);
                if (cVar2.I == viewGroup && cVar2.J != null) {
                    return cVar2;
                }
            }
        }
        return null;
    }

    private void x() {
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    SparseArray<a.k.a.c> sparseArray2 = this.f;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    private void y() {
        if (b()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    private void z() {
        this.f411c = false;
        this.y.clear();
        this.x.clear();
    }

    public a.k.a.c a(int i) {
        for (int size = this.f413e.size() - 1; size >= 0; size--) {
            a.k.a.c cVar = this.f413e.get(size);
            if (cVar != null && cVar.y == i) {
                return cVar;
            }
        }
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            a.k.a.c valueAt = this.f.valueAt(size2);
            if (valueAt != null && valueAt.y == i) {
                return valueAt;
            }
        }
        return null;
    }

    public a.k.a.c a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        a.k.a.c cVar = this.f.get(i);
        if (cVar != null) {
            return cVar;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        throw null;
    }

    public a.k.a.c a(String str) {
        if (str != null) {
            for (int size = this.f413e.size() - 1; size >= 0; size--) {
                a.k.a.c cVar = this.f413e.get(size);
                if (cVar != null && str.equals(cVar.A)) {
                    return cVar;
                }
            }
        }
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            a.k.a.c valueAt = this.f.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.A)) {
                return valueAt;
            }
        }
        return null;
    }

    g a(a.k.a.c cVar, int i, boolean z, int i2) {
        int b2;
        int p = cVar.p();
        Animation a2 = cVar.a(i, z, p);
        if (a2 != null) {
            return new g(a2);
        }
        Animator b3 = cVar.b(i, z, p);
        if (b3 != null) {
            return new g(b3);
        }
        if (p != 0) {
            boolean equals = "anim".equals(this.n.c().getResources().getResourceTypeName(p));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.n.c(), p);
                    if (loadAnimation != null) {
                        return new g(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.n.c(), p);
                    if (loadAnimator != null) {
                        return new g(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.n.c(), p);
                        if (loadAnimation2 != null) {
                            return new g(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i == 0 || (b2 = b(i, z)) < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(this.n.c(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.n.c(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.n.c(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.n.c(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.n.c(), 0.0f, 1.0f);
            case 6:
                return a(this.n.c(), 1.0f, 0.0f);
            default:
                if (i2 != 0 || !this.n.h()) {
                    return null;
                }
                this.n.g();
                return null;
        }
    }

    @Override // a.k.a.h
    public List<a.k.a.c> a() {
        List<a.k.a.c> list;
        if (this.f413e.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f413e) {
            list = (List) this.f413e.clone();
        }
        return list;
    }

    public void a(int i, a.k.a.a aVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i < size) {
                if (F) {
                    String str = "Setting back stack index " + i + " to " + aVar;
                }
                this.i.set(i, aVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (F) {
                        String str2 = "Adding available back stack index " + size;
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (F) {
                    String str3 = "Adding back stack index " + i + " with " + aVar;
                }
                this.i.add(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        a.k.a.g gVar;
        if (this.n == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.m) {
            this.m = i;
            if (this.f != null) {
                int size = this.f413e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    h(this.f413e.get(i2));
                }
                int size2 = this.f.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    a.k.a.c valueAt = this.f.valueAt(i3);
                    if (valueAt != null && ((valueAt.m || valueAt.C) && !valueAt.O)) {
                        h(valueAt);
                    }
                }
                w();
                if (this.r && (gVar = this.n) != null && this.m == 4) {
                    gVar.i();
                    this.r = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.k.a.a aVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(aVar);
    }

    void a(a.k.a.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.a(z3);
        } else {
            aVar.a();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            n.a(this, (ArrayList<a.k.a.a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.m, true);
        }
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                a.k.a.c valueAt = this.f.valueAt(i);
                if (valueAt != null && valueAt.J != null && valueAt.O && aVar.b(valueAt.z)) {
                    float f2 = valueAt.Q;
                    if (f2 > 0.0f) {
                        valueAt.J.setAlpha(f2);
                    }
                    if (z3) {
                        valueAt.Q = 0.0f;
                    } else {
                        valueAt.Q = -1.0f;
                        valueAt.O = false;
                    }
                }
            }
        }
    }

    public void a(a.k.a.c cVar) {
        if (F) {
            String str = "attach: " + cVar;
        }
        if (cVar.C) {
            cVar.C = false;
            if (cVar.l) {
                return;
            }
            if (!this.f413e.contains(cVar)) {
                if (F) {
                    String str2 = "add from attach: " + cVar;
                }
                synchronized (this.f413e) {
                    this.f413e.add(cVar);
                }
                cVar.l = true;
                if (cVar.F && cVar.G) {
                    this.r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006e, code lost:
        if (r0 != 3) goto L_0x03f5;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(a.k.a.c r16, int r17, int r18, int r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.a.i.a(a.k.a.c, int, int, int, boolean):void");
    }

    void a(a.k.a.c cVar, Context context, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).a(cVar, context, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.a(this, cVar, context);
            }
        }
    }

    void a(a.k.a.c cVar, Bundle bundle, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).a(cVar, bundle, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.a(this, cVar, bundle);
            }
        }
    }

    void a(a.k.a.c cVar, View view, Bundle bundle, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).a(cVar, view, bundle, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.a(this, cVar, view, bundle);
            }
        }
    }

    public void a(a.k.a.c cVar, boolean z) {
        if (F) {
            String str = "add: " + cVar;
        }
        f(cVar);
        if (cVar.C) {
            return;
        }
        if (!this.f413e.contains(cVar)) {
            synchronized (this.f413e) {
                this.f413e.add(cVar);
            }
            cVar.l = true;
            cVar.m = false;
            if (cVar.J == null) {
                cVar.P = false;
            }
            if (cVar.F && cVar.G) {
                this.r = true;
            }
            if (z) {
                i(cVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + cVar);
    }

    public void a(a.k.a.g gVar, a.k.a.e eVar, a.k.a.c cVar) {
        if (this.n == null) {
            this.n = gVar;
            this.o = eVar;
            this.p = cVar;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(Configuration configuration) {
        for (int i = 0; i < this.f413e.size(); i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null) {
                cVar.a(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, a.k.a.c cVar) {
        int i = cVar.f;
        if (i >= 0) {
            bundle.putInt(str, i);
            return;
        }
        a(new IllegalStateException("Fragment " + cVar + " is not currently in the FragmentManager"));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, a.k.a.j jVar) {
        List<r> list;
        List<a.k.a.j> list2;
        if (parcelable != null) {
            a.k.a.k kVar = (a.k.a.k) parcelable;
            if (kVar.f445b != null) {
                if (jVar != null) {
                    List<a.k.a.c> b2 = jVar.b();
                    list2 = jVar.a();
                    list = jVar.c();
                    int size = b2 != null ? b2.size() : 0;
                    for (int i = 0; i < size; i++) {
                        a.k.a.c cVar = b2.get(i);
                        if (F) {
                            String str = "restoreAllState: re-attaching retained " + cVar;
                        }
                        int i2 = 0;
                        while (true) {
                            a.k.a.l[] lVarArr = kVar.f445b;
                            if (i2 >= lVarArr.length || lVarArr[i2].f450c == cVar.f) {
                                break;
                            }
                            i2++;
                        }
                        a.k.a.l[] lVarArr2 = kVar.f445b;
                        if (i2 != lVarArr2.length) {
                            a.k.a.l lVar = lVarArr2[i2];
                            lVar.m = cVar;
                            cVar.f389d = null;
                            cVar.r = 0;
                            cVar.o = false;
                            cVar.l = false;
                            cVar.i = null;
                            Bundle bundle = lVar.l;
                            if (bundle != null) {
                                bundle.setClassLoader(this.n.c().getClassLoader());
                                cVar.f389d = lVar.l.getSparseParcelableArray("android:view_state");
                                cVar.f388c = lVar.l;
                            }
                        } else {
                            a(new IllegalStateException("Could not find active fragment with index " + cVar.f));
                            throw null;
                        }
                    }
                } else {
                    list2 = null;
                    list = null;
                }
                this.f = new SparseArray<>(kVar.f445b.length);
                int i3 = 0;
                while (true) {
                    a.k.a.l[] lVarArr3 = kVar.f445b;
                    if (i3 >= lVarArr3.length) {
                        break;
                    }
                    a.k.a.l lVar2 = lVarArr3[i3];
                    if (lVar2 != null) {
                        a.k.a.c a2 = lVar2.a(this.n, this.o, this.p, (list2 == null || i3 >= list2.size()) ? null : list2.get(i3), (list == null || i3 >= list.size()) ? null : list.get(i3));
                        if (F) {
                            String str2 = "restoreAllState: active #" + i3 + ": " + a2;
                        }
                        this.f.put(a2.f, a2);
                        lVar2.m = null;
                    }
                    i3++;
                }
                if (jVar != null) {
                    List<a.k.a.c> b3 = jVar.b();
                    int size2 = b3 != null ? b3.size() : 0;
                    for (int i4 = 0; i4 < size2; i4++) {
                        a.k.a.c cVar2 = b3.get(i4);
                        int i5 = cVar2.j;
                        if (i5 >= 0) {
                            cVar2.i = this.f.get(i5);
                            if (cVar2.i == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + cVar2 + " target no longer exists: " + cVar2.j);
                            }
                        }
                    }
                }
                this.f413e.clear();
                if (kVar.f446c != null) {
                    int i6 = 0;
                    while (true) {
                        int[] iArr = kVar.f446c;
                        if (i6 >= iArr.length) {
                            break;
                        }
                        a.k.a.c cVar3 = this.f.get(iArr[i6]);
                        if (cVar3 != null) {
                            cVar3.l = true;
                            if (F) {
                                String str3 = "restoreAllState: added #" + i6 + ": " + cVar3;
                            }
                            if (!this.f413e.contains(cVar3)) {
                                synchronized (this.f413e) {
                                    this.f413e.add(cVar3);
                                }
                                i6++;
                            } else {
                                throw new IllegalStateException("Already added!");
                            }
                        } else {
                            a(new IllegalStateException("No instantiated fragment for index #" + kVar.f446c[i6]));
                            throw null;
                        }
                    }
                }
                a.k.a.b[] bVarArr = kVar.f447d;
                if (bVarArr != null) {
                    this.g = new ArrayList<>(bVarArr.length);
                    int i7 = 0;
                    while (true) {
                        a.k.a.b[] bVarArr2 = kVar.f447d;
                        if (i7 >= bVarArr2.length) {
                            break;
                        }
                        a.k.a.a a3 = bVarArr2[i7].a(this);
                        if (F) {
                            String str4 = "restoreAllState: back stack #" + i7 + " (index " + a3.l + "): " + a3;
                            PrintWriter printWriter = new PrintWriter(new a.g.k.b("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.g.add(a3);
                        int i8 = a3.l;
                        if (i8 >= 0) {
                            a(i8, a3);
                        }
                        i7++;
                    }
                } else {
                    this.g = null;
                }
                int i9 = kVar.f448e;
                if (i9 >= 0) {
                    this.q = this.f.get(i9);
                }
                this.f412d = kVar.f;
            }
        }
    }

    public void a(Menu menu) {
        if (this.m >= 1) {
            for (int i = 0; i < this.f413e.size(); i++) {
                a.k.a.c cVar = this.f413e.get(i);
                if (cVar != null) {
                    cVar.c(menu);
                }
            }
        }
    }

    @Override // a.k.a.h
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                a.k.a.c valueAt = this.f.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.f413e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f413e.get(i2).toString());
            }
        }
        ArrayList<a.k.a.c> arrayList = this.h;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.h.get(i3).toString());
            }
        }
        ArrayList<a.k.a.a> arrayList2 = this.g;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                a.k.a.a aVar = this.g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((a.k.a.a) this.i.get(i5));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        ArrayList<l> arrayList3 = this.f410b;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((l) this.f410b.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.o);
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public void a(boolean z) {
        for (int size = this.f413e.size() - 1; size >= 0; size--) {
            a.k.a.c cVar = this.f413e.get(size);
            if (cVar != null) {
                cVar.d(z);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.m < 1) {
            return false;
        }
        ArrayList<a.k.a.c> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f413e.size(); i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null && cVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cVar);
                z = true;
            }
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                a.k.a.c cVar2 = this.h.get(i2);
                if (arrayList == null || !arrayList.contains(cVar2)) {
                    cVar2.H();
                }
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i = 0; i < this.f413e.size(); i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null && cVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<a.k.a.a> arrayList3 = this.g;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                i3 = this.g.size() - 1;
                while (i3 >= 0) {
                    a.k.a.a aVar = this.g.get(i3);
                    if ((str != null && str.equals(aVar.b())) || (i >= 0 && i == aVar.l)) {
                        break;
                    }
                    i3--;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        i3--;
                        if (i3 < 0) {
                            break;
                        }
                        a.k.a.a aVar2 = this.g.get(i3);
                        if (str == null || !str.equals(aVar2.b())) {
                            if (i < 0 || i != aVar2.l) {
                                break;
                            }
                        }
                    }
                }
            } else {
                i3 = -1;
            }
            if (i3 == this.g.size() - 1) {
                return false;
            }
            for (int size2 = this.g.size() - 1; size2 > i3; size2--) {
                arrayList.add(this.g.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public a.k.a.c b(String str) {
        a.k.a.c a2;
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            a.k.a.c valueAt = this.f.valueAt(size);
            if (!(valueAt == null || (a2 = valueAt.a(str)) == null)) {
                return a2;
            }
        }
        return null;
    }

    public void b(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (F) {
                String str = "Freeing back stack index " + i;
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    void b(a.k.a.c cVar) {
        Animator animator;
        if (cVar.J != null) {
            g a2 = a(cVar, cVar.q(), !cVar.B, cVar.r());
            if (a2 == null || (animator = a2.f430b) == null) {
                if (a2 != null) {
                    a(cVar.J, a2);
                    cVar.J.startAnimation(a2.f429a);
                    a2.f429a.start();
                }
                cVar.J.setVisibility((!cVar.B || cVar.B()) ? 0 : 8);
                if (cVar.B()) {
                    cVar.f(false);
                }
            } else {
                animator.setTarget(cVar.J);
                if (!cVar.B) {
                    cVar.J.setVisibility(0);
                } else if (cVar.B()) {
                    cVar.f(false);
                } else {
                    ViewGroup viewGroup = cVar.I;
                    View view = cVar.J;
                    viewGroup.startViewTransition(view);
                    a2.f430b.addListener(new d(this, viewGroup, view, cVar));
                }
                a(cVar.J, a2);
                a2.f430b.start();
            }
        }
        if (cVar.l && cVar.F && cVar.G) {
            this.r = true;
        }
        cVar.P = false;
        cVar.a(cVar.B);
    }

    void b(a.k.a.c cVar, Context context, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).b(cVar, context, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.b(this, cVar, context);
            }
        }
    }

    void b(a.k.a.c cVar, Bundle bundle, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).b(cVar, bundle, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.b(this, cVar, bundle);
            }
        }
    }

    void b(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).b(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.a(this, cVar);
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.f413e.size() - 1; size >= 0; size--) {
            a.k.a.c cVar = this.f413e.get(size);
            if (cVar != null) {
                cVar.e(z);
            }
        }
    }

    @Override // a.k.a.h
    public boolean b() {
        return this.s || this.t;
    }

    public boolean b(Menu menu) {
        if (this.m < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f413e.size(); i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null && cVar.d(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i = 0; i < this.f413e.size(); i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null && cVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void c(a.k.a.c cVar) {
        if (F) {
            String str = "detach: " + cVar;
        }
        if (!cVar.C) {
            cVar.C = true;
            if (cVar.l) {
                if (F) {
                    String str2 = "remove from detach: " + cVar;
                }
                synchronized (this.f413e) {
                    this.f413e.remove(cVar);
                }
                if (cVar.F && cVar.G) {
                    this.r = true;
                }
                cVar.l = false;
            }
        }
    }

    void c(a.k.a.c cVar, Bundle bundle, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).c(cVar, bundle, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.c(this, cVar, bundle);
            }
        }
    }

    void c(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).c(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.b(this, cVar);
            }
        }
    }

    @Override // a.k.a.h
    public boolean c() {
        y();
        return a((String) null, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i) {
        return this.m >= i;
    }

    public void d() {
        this.s = false;
        this.t = false;
        d(2);
    }

    void d(a.k.a.c cVar) {
        if (cVar.n && !cVar.q) {
            cVar.b(cVar.i(cVar.f388c), (ViewGroup) null, cVar.f388c);
            View view = cVar.J;
            if (view != null) {
                cVar.K = view;
                view.setSaveFromParentEnabled(false);
                if (cVar.B) {
                    cVar.J.setVisibility(8);
                }
                cVar.a(cVar.J, cVar.f388c);
                a(cVar, cVar.J, cVar.f388c, false);
                return;
            }
            cVar.K = null;
        }
    }

    void d(a.k.a.c cVar, Bundle bundle, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).d(cVar, bundle, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.d(this, cVar, bundle);
            }
        }
    }

    void d(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).d(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.c(this, cVar);
            }
        }
    }

    public void e() {
        this.s = false;
        this.t = false;
        d(1);
    }

    public void e(a.k.a.c cVar) {
        if (F) {
            String str = "hide: " + cVar;
        }
        if (!cVar.B) {
            cVar.B = true;
            cVar.P = true ^ cVar.P;
        }
    }

    void e(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).e(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.d(this, cVar);
            }
        }
    }

    public void f() {
        this.u = true;
        n();
        d(0);
        this.n = null;
        this.o = null;
        this.p = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a.k.a.c cVar) {
        if (cVar.f < 0) {
            int i = this.f412d;
            this.f412d = i + 1;
            cVar.a(i, this.p);
            if (this.f == null) {
                this.f = new SparseArray<>();
            }
            this.f.put(cVar.f, cVar);
            if (F) {
                String str = "Allocated fragment index " + cVar;
            }
        }
    }

    void f(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).f(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.e(this, cVar);
            }
        }
    }

    public void g() {
        d(1);
    }

    void g(a.k.a.c cVar) {
        if (cVar.f >= 0) {
            if (F) {
                String str = "Freeing fragment index " + cVar;
            }
            this.f.put(cVar.f, null);
            cVar.z();
        }
    }

    void g(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).g(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.f(this, cVar);
            }
        }
    }

    public void h() {
        for (int i = 0; i < this.f413e.size(); i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null) {
                cVar.S();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(a.k.a.c cVar) {
        if (cVar != null) {
            int i = this.m;
            if (cVar.m) {
                i = cVar.C() ? Math.min(i, 1) : Math.min(i, 0);
            }
            a(cVar, i, cVar.q(), cVar.r(), false);
            if (cVar.J != null) {
                a.k.a.c p = p(cVar);
                if (p != null) {
                    View view = p.J;
                    ViewGroup viewGroup = cVar.I;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    int indexOfChild2 = viewGroup.indexOfChild(cVar.J);
                    if (indexOfChild2 < indexOfChild) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(cVar.J, indexOfChild);
                    }
                }
                if (cVar.O && cVar.I != null) {
                    float f2 = cVar.Q;
                    if (f2 > 0.0f) {
                        cVar.J.setAlpha(f2);
                    }
                    cVar.Q = 0.0f;
                    cVar.O = false;
                    g a2 = a(cVar, cVar.q(), true, cVar.r());
                    if (a2 != null) {
                        a(cVar.J, a2);
                        Animation animation = a2.f429a;
                        if (animation != null) {
                            cVar.J.startAnimation(animation);
                        } else {
                            a2.f430b.setTarget(cVar.J);
                            a2.f430b.start();
                        }
                    }
                }
            }
            if (cVar.P) {
                b(cVar);
            }
        }
    }

    void h(a.k.a.c cVar, boolean z) {
        a.k.a.c cVar2 = this.p;
        if (cVar2 != null) {
            a.k.a.h o = cVar2.o();
            if (o instanceof i) {
                ((i) o).h(cVar, true);
            }
        }
        Iterator<j> it = this.l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f437b) {
                next.f436a.g(this, cVar);
            }
        }
    }

    public void i() {
        d(3);
    }

    void i(a.k.a.c cVar) {
        a(cVar, this.m, 0, 0, false);
    }

    public void j() {
        this.s = false;
        this.t = false;
        d(4);
    }

    public void j(a.k.a.c cVar) {
        if (!cVar.L) {
            return;
        }
        if (this.f411c) {
            this.w = true;
            return;
        }
        cVar.L = false;
        a(cVar, this.m, 0, 0, false);
    }

    public void k() {
        this.s = false;
        this.t = false;
        d(3);
    }

    public void k(a.k.a.c cVar) {
        if (F) {
            String str = "remove: " + cVar + " nesting=" + cVar.r;
        }
        boolean z = !cVar.C();
        if (!cVar.C || z) {
            synchronized (this.f413e) {
                this.f413e.remove(cVar);
            }
            if (cVar.F && cVar.G) {
                this.r = true;
            }
            cVar.l = false;
            cVar.m = true;
        }
    }

    Bundle l(a.k.a.c cVar) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        cVar.j(this.A);
        d(cVar, this.A, false);
        if (!this.A.isEmpty()) {
            bundle = this.A;
            this.A = null;
        } else {
            bundle = null;
        }
        if (cVar.J != null) {
            m(cVar);
        }
        if (cVar.f389d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", cVar.f389d);
        }
        if (!cVar.M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", cVar.M);
        }
        return bundle;
    }

    public void l() {
        this.t = true;
        d(2);
    }

    void m() {
        if (this.w) {
            this.w = false;
            w();
        }
    }

    void m(a.k.a.c cVar) {
        if (cVar.K != null) {
            SparseArray<Parcelable> sparseArray = this.B;
            if (sparseArray == null) {
                this.B = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            cVar.K.saveHierarchyState(this.B);
            if (this.B.size() > 0) {
                cVar.f389d = this.B;
                this.B = null;
            }
        }
    }

    public void n(a.k.a.c cVar) {
        if (cVar == null || (this.f.get(cVar.f) == cVar && (cVar.t == null || cVar.o() == this))) {
            this.q = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + cVar + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX WARN: Finally extract failed */
    public boolean n() {
        c(true);
        boolean z = false;
        while (b(this.x, this.y)) {
            this.f411c = true;
            try {
                c(this.x, this.y);
                z();
                z = true;
            } catch (Throwable th) {
                z();
                throw th;
            }
        }
        m();
        x();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 o() {
        return this;
    }

    public void o(a.k.a.c cVar) {
        if (F) {
            String str = "show: " + cVar;
        }
        if (cVar.B) {
            cVar.B = false;
            cVar.P = !cVar.P;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        a.k.a.c cVar;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f438a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!a.k.a.c.a(this.n.c(), attributeValue)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        a.k.a.c a2 = resourceId != -1 ? a(resourceId) : null;
        if (a2 == null && string != null) {
            a2 = a(string);
        }
        if (a2 == null && i != -1) {
            a2 = a(i);
        }
        if (F) {
            String str2 = "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + a2;
        }
        if (a2 == null) {
            a.k.a.c a3 = this.o.a(context, attributeValue, null);
            a3.n = true;
            a3.y = resourceId != 0 ? resourceId : i;
            a3.z = i;
            a3.A = string;
            a3.o = true;
            a3.s = this;
            a.k.a.g gVar = this.n;
            a3.t = gVar;
            a3.a(gVar.c(), attributeSet, a3.f388c);
            a(a3, true);
            cVar = a3;
        } else if (!a2.o) {
            a2.o = true;
            a.k.a.g gVar2 = this.n;
            a2.t = gVar2;
            if (!a2.E) {
                a2.a(gVar2.c(), attributeSet, a2.f388c);
            }
            cVar = a2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
        }
        if (this.m >= 1 || !cVar.n) {
            i(cVar);
        } else {
            a(cVar, 1, 0, 0, false);
        }
        View view2 = cVar.J;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (cVar.J.getTag() == null) {
                cVar.J.setTag(string);
            }
            return cVar.J;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public a.k.a.c p() {
        return this.q;
    }

    public void q() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.f413e.size();
        for (int i = 0; i < size; i++) {
            a.k.a.c cVar = this.f413e.get(i);
            if (cVar != null) {
                cVar.F();
            }
        }
    }

    void r() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                this.k.get(i).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a.k.a.j s() {
        a(this.D);
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable t() {
        int[] iArr;
        int size;
        B();
        A();
        n();
        this.s = true;
        a.k.a.b[] bVarArr = null;
        this.D = null;
        SparseArray<a.k.a.c> sparseArray = this.f;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        a.k.a.l[] lVarArr = new a.k.a.l[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            a.k.a.c valueAt = this.f.valueAt(i);
            if (valueAt != null) {
                if (valueAt.f >= 0) {
                    a.k.a.l lVar = new a.k.a.l(valueAt);
                    lVarArr[i] = lVar;
                    if (valueAt.f387b <= 0 || lVar.l != null) {
                        lVar.l = valueAt.f388c;
                    } else {
                        lVar.l = l(valueAt);
                        a.k.a.c cVar = valueAt.i;
                        if (cVar != null) {
                            if (cVar.f >= 0) {
                                if (lVar.l == null) {
                                    lVar.l = new Bundle();
                                }
                                a(lVar.l, "android:target_state", valueAt.i);
                                int i2 = valueAt.k;
                                if (i2 != 0) {
                                    lVar.l.putInt("android:target_req_state", i2);
                                }
                            } else {
                                a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.i));
                                throw null;
                            }
                        }
                    }
                    if (F) {
                        String str = "Saved state of " + valueAt + ": " + lVar.l;
                    }
                    z = true;
                } else {
                    a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.f));
                    throw null;
                }
            }
        }
        if (!z) {
            boolean z2 = F;
            return null;
        }
        int size3 = this.f413e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.f413e.get(i3).f;
                if (iArr[i3] >= 0) {
                    if (F) {
                        String str2 = "saveAllState: adding fragment #" + i3 + ": " + this.f413e.get(i3);
                    }
                } else {
                    a(new IllegalStateException("Failure saving state: active " + this.f413e.get(i3) + " has cleared index: " + iArr[i3]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<a.k.a.a> arrayList = this.g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new a.k.a.b[size];
            for (int i4 = 0; i4 < size; i4++) {
                bVarArr[i4] = new a.k.a.b(this.g.get(i4));
                if (F) {
                    String str3 = "saveAllState: adding back stack #" + i4 + ": " + this.g.get(i4);
                }
            }
        }
        a.k.a.k kVar = new a.k.a.k();
        kVar.f445b = lVarArr;
        kVar.f446c = iArr;
        kVar.f447d = bVarArr;
        a.k.a.c cVar2 = this.q;
        if (cVar2 != null) {
            kVar.f448e = cVar2.f;
        }
        kVar.f = this.f412d;
        u();
        return kVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.p;
        if (obj == null) {
            obj = this.n;
        }
        a.g.k.a.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    void u() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        a.k.a.j jVar;
        if (this.f != null) {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
            for (int i = 0; i < this.f.size(); i++) {
                a.k.a.c valueAt = this.f.valueAt(i);
                if (valueAt != null) {
                    if (valueAt.D) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(valueAt);
                        a.k.a.c cVar = valueAt.i;
                        valueAt.j = cVar != null ? cVar.f : -1;
                        if (F) {
                            String str = "retainNonConfig: keeping retained " + valueAt;
                        }
                    }
                    i iVar = valueAt.u;
                    if (iVar != null) {
                        iVar.u();
                        jVar = valueAt.u.D;
                    } else {
                        jVar = valueAt.v;
                    }
                    if (arrayList2 == null && jVar != null) {
                        arrayList2 = new ArrayList(this.f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(jVar);
                    }
                    if (arrayList == null && valueAt.w != null) {
                        arrayList = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList.add(null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(valueAt.w);
                    }
                }
            }
        } else {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList3 == null && arrayList2 == null && arrayList == null) {
            this.D = null;
        } else {
            this.D = new a.k.a.j(arrayList3, arrayList2, arrayList);
        }
    }

    void v() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.C != null && !this.C.isEmpty();
            if (this.f410b != null && this.f410b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.n.e().removeCallbacks(this.E);
                this.n.e().post(this.E);
            }
        }
    }

    void w() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                a.k.a.c valueAt = this.f.valueAt(i);
                if (valueAt != null) {
                    j(valueAt);
                }
            }
        }
    }
}
