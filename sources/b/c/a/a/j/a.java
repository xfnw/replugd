package b.c.a.a.j;

import a.l.a.a.b;
import a.l.a.a.c;
import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f1711a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f1712b = new a.l.a.a.a();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f1713c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f1714d = new DecelerateInterpolator();

    static {
        new LinearInterpolator();
    }

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
