package b.b.a.n;

import android.content.Context;

/* loaded from: classes.dex */
public final class c {
    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
