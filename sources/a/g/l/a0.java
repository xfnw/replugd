package a.g.l;

import android.os.Build;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f290a;

    private a0(Object obj) {
        this.f290a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a0 a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new a0(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        return a0Var.f290a;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f290a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public a0 a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new a0(((WindowInsets) this.f290a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f290a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f290a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f290a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f290a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f290a;
        Object obj3 = ((a0) obj).f290a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f290a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
