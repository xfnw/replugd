package a.p;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class f0 extends e0 {

    /* renamed from: e  reason: collision with root package name */
    private static Method f556e;
    private static boolean f;
    private static Method g;
    private static boolean h;

    private void a() {
        if (!f) {
            try {
                f556e = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
                f556e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
            }
            f = true;
        }
    }

    private void b() {
        if (!h) {
            try {
                g = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
                g.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
            }
            h = true;
        }
    }

    @Override // a.p.h0
    public void a(View view, Matrix matrix) {
        a();
        Method method = f556e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // a.p.h0
    public void b(View view, Matrix matrix) {
        b();
        Method method = g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
