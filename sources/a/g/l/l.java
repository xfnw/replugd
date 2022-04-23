package a.g.l;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f313a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f314b;

    /* renamed from: c  reason: collision with root package name */
    private final View f315c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f316d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f317e;

    public l(View view) {
        this.f315c = view;
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f313a = viewParent;
        } else if (i == 1) {
            this.f314b = viewParent;
        }
    }

    private ViewParent d(int i) {
        if (i == 0) {
            return this.f313a;
        }
        if (i != 1) {
            return null;
        }
        return this.f314b;
    }

    public void a(boolean z) {
        if (this.f316d) {
            s.B(this.f315c);
        }
        this.f316d = z;
    }

    public boolean a() {
        return a(0);
    }

    public boolean a(float f, float f2) {
        ViewParent d2;
        if (!b() || (d2 = d(0)) == null) {
            return false;
        }
        return v.a(d2, this.f315c, f, f2);
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent d2;
        if (!b() || (d2 = d(0)) == null) {
            return false;
        }
        return v.a(d2, this.f315c, f, f2, z);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!b()) {
            return false;
        }
        View view = this.f315c;
        for (ViewParent parent = this.f315c.getParent(); parent != null; parent = parent.getParent()) {
            if (v.b(parent, view, this.f315c, i, i2)) {
                a(i2, parent);
                v.a(parent, view, this.f315c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent d2;
        int i6;
        int i7;
        if (!b() || (d2 = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f315c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i6 = iArr[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        v.a(d2, this.f315c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.f315c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i6;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent d2;
        int i4;
        int i5;
        if (!b() || (d2 = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f315c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            if (this.f317e == null) {
                this.f317e = new int[2];
            }
            iArr = this.f317e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        v.a(d2, this.f315c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f315c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean b() {
        return this.f316d;
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        ViewParent d2 = d(i);
        if (d2 != null) {
            v.a(d2, this.f315c, i);
            a(i, (ViewParent) null);
        }
    }
}
