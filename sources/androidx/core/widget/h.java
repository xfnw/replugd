package androidx.core.widget;

import a.g.l.d;
import a.g.l.s;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1245a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1246b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f1247c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1248d;

    public static void a(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f1246b) {
            try {
                f1245a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1245a.setAccessible(true);
            } catch (Exception unused) {
            }
            f1246b = true;
        }
        Method method = f1245a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((d.a(i3, s.j(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (i >= 21) {
            if (!f1248d) {
                try {
                    f1247c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1247c.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f1248d = true;
            }
            Field field = f1247c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }
}
