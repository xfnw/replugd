package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class p0 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1021c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<p0>> f1022d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1023a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1024b;

    private p0(Context context) {
        super(context);
        if (x0.b()) {
            this.f1023a = new x0(this, context.getResources());
            this.f1024b = this.f1023a.newTheme();
            this.f1024b.setTo(context.getTheme());
            return;
        }
        this.f1023a = new r0(this, context.getResources());
        this.f1024b = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof p0) || (context.getResources() instanceof r0) || (context.getResources() instanceof x0)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || x0.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1021c) {
            if (f1022d == null) {
                f1022d = new ArrayList<>();
            } else {
                for (int size = f1022d.size() - 1; size >= 0; size--) {
                    WeakReference<p0> weakReference = f1022d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1022d.remove(size);
                    }
                }
                for (int size2 = f1022d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<p0> weakReference2 = f1022d.get(size2);
                    p0 p0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (p0Var != null && p0Var.getBaseContext() == context) {
                        return p0Var;
                    }
                }
            }
            p0 p0Var2 = new p0(context);
            f1022d.add(new WeakReference<>(p0Var2));
            return p0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1023a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1023a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1024b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f1024b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
