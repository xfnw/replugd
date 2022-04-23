package a.g.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f330a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f331b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f332c = null;

    /* renamed from: d  reason: collision with root package name */
    int f333d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f334b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f335c;

        a(w wVar, x xVar, View view) {
            this.f334b = xVar;
            this.f335c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f334b.c(this.f335c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f334b.a(this.f335c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f334b.b(this.f335c);
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f336b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f337c;

        b(w wVar, z zVar, View view) {
            this.f336b = zVar;
            this.f337c = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f336b.a(this.f337c);
        }
    }

    /* loaded from: classes.dex */
    static class c implements x {

        /* renamed from: a  reason: collision with root package name */
        w f338a;

        /* renamed from: b  reason: collision with root package name */
        boolean f339b;

        c(w wVar) {
            this.f338a = wVar;
        }

        @Override // a.g.l.x
        public void a(View view) {
            int i = this.f338a.f333d;
            x xVar = null;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f338a.f333d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f339b) {
                w wVar = this.f338a;
                Runnable runnable = wVar.f332c;
                if (runnable != null) {
                    wVar.f332c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof x) {
                    xVar = (x) tag;
                }
                if (xVar != null) {
                    xVar.a(view);
                }
                this.f339b = true;
            }
        }

        @Override // a.g.l.x
        public void b(View view) {
            this.f339b = false;
            x xVar = null;
            if (this.f338a.f333d > -1) {
                view.setLayerType(2, null);
            }
            w wVar = this.f338a;
            Runnable runnable = wVar.f331b;
            if (runnable != null) {
                wVar.f331b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof x) {
                xVar = (x) tag;
            }
            if (xVar != null) {
                xVar.b(view);
            }
        }

        @Override // a.g.l.x
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            x xVar = tag instanceof x ? (x) tag : null;
            if (xVar != null) {
                xVar.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(View view) {
        this.f330a = new WeakReference<>(view);
    }

    private void a(View view, x xVar) {
        if (xVar != null) {
            view.animate().setListener(new a(this, xVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public w a(float f) {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public w a(long j) {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public w a(x xVar) {
        View view = this.f330a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, xVar);
                xVar = new c(this);
            }
            a(view, xVar);
        }
        return this;
    }

    public w a(z zVar) {
        View view = this.f330a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b bVar = null;
            if (zVar != null) {
                bVar = new b(this, zVar, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public w a(Interpolator interpolator) {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public void a() {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long b() {
        View view = this.f330a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public w b(float f) {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public w b(long j) {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void c() {
        View view = this.f330a.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
