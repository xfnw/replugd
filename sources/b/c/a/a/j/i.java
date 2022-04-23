package b.c.a.a.j;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f1724a;

    /* renamed from: b  reason: collision with root package name */
    private long f1725b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f1726c;

    /* renamed from: d  reason: collision with root package name */
    private int f1727d;

    /* renamed from: e  reason: collision with root package name */
    private int f1728e;

    public i(long j, long j2) {
        this.f1724a = 0L;
        this.f1725b = 300L;
        this.f1726c = null;
        this.f1727d = 0;
        this.f1728e = 1;
        this.f1724a = j;
        this.f1725b = j2;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f1724a = 0L;
        this.f1725b = 300L;
        this.f1726c = null;
        this.f1727d = 0;
        this.f1728e = 1;
        this.f1724a = j;
        this.f1725b = j2;
        this.f1726c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f1727d = valueAnimator.getRepeatCount();
        iVar.f1728e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f1711a : interpolator instanceof AccelerateInterpolator ? a.f1712b : interpolator instanceof DecelerateInterpolator ? a.f1713c : interpolator;
    }

    public long a() {
        return this.f1724a;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.f1725b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f1726c;
        return timeInterpolator != null ? timeInterpolator : a.f1711a;
    }

    public int d() {
        return this.f1727d;
    }

    public int e() {
        return this.f1728e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }
}
