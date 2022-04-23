package a.p;

import a.g.l.s;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final h0 f542a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f543b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f544c;

    /* renamed from: d  reason: collision with root package name */
    static final Property<View, Float> f545d;

    /* loaded from: classes.dex */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(d0.c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f) {
            d0.a(view, f.floatValue());
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return s.d(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            s.a(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f542a = i >= 22 ? new g0() : i >= 21 ? new f0() : i >= 19 ? new e0() : new h0();
        f545d = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    private static void a() {
        if (!f544c) {
            try {
                f543b = View.class.getDeclaredField("mViewFlags");
                f543b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f544c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f542a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, float f) {
        f542a.a(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i) {
        a();
        Field field = f543b;
        if (field != null) {
            try {
                f543b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i, int i2, int i3, int i4) {
        f542a.a(view, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Matrix matrix) {
        f542a.a(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new b0(view) : a0.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view, Matrix matrix) {
        f542a.b(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f542a.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new k0(view) : new j0(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f542a.c(view);
    }
}
