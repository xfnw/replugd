package a.p;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class e0 extends h0 {

    /* renamed from: a  reason: collision with root package name */
    private static Method f552a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f553b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f554c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f555d;

    private void a() {
        if (!f555d) {
            try {
                f554c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f554c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
            }
            f555d = true;
        }
    }

    private void b() {
        if (!f553b) {
            try {
                f552a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
                f552a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
            }
            f553b = true;
        }
    }

    @Override // a.p.h0
    public void a(View view) {
    }

    @Override // a.p.h0
    public void a(View view, float f) {
        b();
        Method method = f552a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            view.setAlpha(f);
        }
    }

    @Override // a.p.h0
    public float b(View view) {
        a();
        Method method = f554c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.b(view);
    }

    @Override // a.p.h0
    public void c(View view) {
    }
}
