package androidx.appcompat.view.menu;

import a.g.l.d;
import a.g.l.s;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.p;

/* loaded from: classes.dex */
public class o implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f831a;

    /* renamed from: b  reason: collision with root package name */
    private final h f832b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f833c;

    /* renamed from: d  reason: collision with root package name */
    private final int f834d;

    /* renamed from: e  reason: collision with root package name */
    private final int f835e;
    private View f;
    private int g;
    private boolean h;
    private p.a i;
    private n j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            o.this.d();
        }
    }

    public o(Context context, h hVar, View view, boolean z, int i) {
        this(context, hVar, view, z, i, 0);
    }

    public o(Context context, h hVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new a();
        this.f831a = context;
        this.f832b = hVar;
        this.f = view;
        this.f833c = z;
        this.f834d = i;
        this.f835e = i2;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        n b2 = b();
        b2.c(z2);
        if (z) {
            if ((d.a(this.g, s.j(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            b2.b(i);
            b2.c(i2);
            int i3 = (int) ((this.f831a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b2.a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b2.b();
    }

    private n g() {
        Display defaultDisplay = ((WindowManager) this.f831a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        n eVar = Math.min(point.x, point.y) >= this.f831a.getResources().getDimensionPixelSize(a.a.d.abc_cascading_menus_min_smallest_width) ? new e(this.f831a, this.f, this.f834d, this.f835e, this.f833c) : new u(this.f831a, this.f832b, this.f, this.f834d, this.f835e, this.f833c);
        eVar.a(this.f832b);
        eVar.a(this.l);
        eVar.a(this.f);
        eVar.a(this.i);
        eVar.b(this.h);
        eVar.a(this.g);
        return eVar;
    }

    public void a() {
        if (c()) {
            this.j.dismiss();
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(p.a aVar) {
        this.i = aVar;
        n nVar = this.j;
        if (nVar != null) {
            nVar.a(aVar);
        }
    }

    public void a(boolean z) {
        this.h = z;
        n nVar = this.j;
        if (nVar != null) {
            nVar.b(z);
        }
    }

    public boolean a(int i, int i2) {
        if (c()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    public n b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        n nVar = this.j;
        return nVar != null && nVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void e() {
        if (!f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean f() {
        if (c()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }
}
