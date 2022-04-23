package a.p;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class y {

    /* renamed from: a  reason: collision with root package name */
    private static LayoutTransition f610a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f611b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f612c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f613d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f614e;

    /* loaded from: classes.dex */
    static class a extends LayoutTransition {
        a() {
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f614e) {
            try {
                f613d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f613d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f614e = true;
        }
        Method method = f613d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = a.p.y.f610a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002a
            a.p.y$a r0 = new a.p.y$a
            r0.<init>()
            a.p.y.f610a = r0
            android.animation.LayoutTransition r0 = a.p.y.f610a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = a.p.y.f610a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = a.p.y.f610a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = a.p.y.f610a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = a.p.y.f610a
            r4 = 4
            r0.setAnimator(r4, r3)
        L_0x002a:
            if (r6 == 0) goto L_0x004a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L_0x0044
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L_0x003b
            a(r6)
        L_0x003b:
            android.animation.LayoutTransition r0 = a.p.y.f610a
            if (r6 == r0) goto L_0x0044
            int r0 = a.p.j.transition_layout_save
            r5.setTag(r0, r6)
        L_0x0044:
            android.animation.LayoutTransition r6 = a.p.y.f610a
        L_0x0046:
            r5.setLayoutTransition(r6)
            goto L_0x0098
        L_0x004a:
            r5.setLayoutTransition(r3)
            boolean r6 = a.p.y.f612c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L_0x006a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch: NoSuchFieldException -> 0x0063
            a.p.y.f611b = r6     // Catch: NoSuchFieldException -> 0x0063
            java.lang.reflect.Field r6 = a.p.y.f611b     // Catch: NoSuchFieldException -> 0x0063
            r6.setAccessible(r1)     // Catch: NoSuchFieldException -> 0x0063
            goto L_0x0068
        L_0x0063:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L_0x0068:
            a.p.y.f612c = r1
        L_0x006a:
            java.lang.reflect.Field r6 = a.p.y.f611b
            if (r6 == 0) goto L_0x0083
            boolean r6 = r6.getBoolean(r5)     // Catch: IllegalAccessException -> 0x007e
            if (r6 == 0) goto L_0x007c
            java.lang.reflect.Field r1 = a.p.y.f611b     // Catch: IllegalAccessException -> 0x007a
            r1.setBoolean(r5, r2)     // Catch: IllegalAccessException -> 0x007a
            goto L_0x007c
        L_0x007a:
            r2 = r6
            goto L_0x007e
        L_0x007c:
            r2 = r6
            goto L_0x0083
        L_0x007e:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L_0x0083:
            if (r2 == 0) goto L_0x0088
            r5.requestLayout()
        L_0x0088:
            int r6 = a.p.j.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L_0x0098
            int r0 = a.p.j.transition_layout_save
            r5.setTag(r0, r3)
            goto L_0x0046
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.p.y.a(android.view.ViewGroup, boolean):void");
    }
}
