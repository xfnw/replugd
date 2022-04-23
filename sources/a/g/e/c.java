package a.g.e;

import a.d.e;
import a.g.i.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.c.c;
import androidx.core.content.c.f;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final h f217a;

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f218b;

    static {
        int i = Build.VERSION.SDK_INT;
        f217a = i >= 28 ? new g() : i >= 26 ? new f() : (i < 24 || !e.a()) ? Build.VERSION.SDK_INT >= 21 ? new d() : new h() : new e();
        f218b = new e<>(16);
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f217a.a(context, resources, i, str, i2);
        if (a2 != null) {
            f218b.a(a(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        return f217a.a(context, cancellationSignal, fVarArr, i);
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typeface = b.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typeface = f217a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.a(typeface, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f218b.a(a(resources, i, i2), typeface);
        }
        return typeface;
    }

    private static String a(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface b(Resources resources, int i, int i2) {
        return f218b.b(a(resources, i, i2));
    }
}
