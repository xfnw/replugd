package a.p;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    private static Method f615a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f616b;

    private static void a() {
        if (!f616b) {
            try {
                f615a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
                f615a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
            }
            f616b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z) {
        String str;
        Throwable e2;
        a();
        Method method = f615a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e3) {
                e2 = e3;
                str = "Failed to invoke suppressLayout method";
                Log.i("ViewUtilsApi18", str, e2);
            } catch (InvocationTargetException e4) {
                e2 = e4;
                str = "Error invoking suppressLayout method";
                Log.i("ViewUtilsApi18", str, e2);
            }
        }
    }
}
