package com.ecloud.eshare.util;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f2919a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2920b = true;

    public static String a(Context context) {
        if (f2919a == null) {
            f2919a = i.a(context, "com.eshare.optoma.key.DEVICE_NAME", Build.MODEL);
        }
        return f2919a;
    }

    public static void a(Context context, String str) {
        if (!str.equals(f2919a)) {
            i.b(context, "com.eshare.optoma.key.DEVICE_NAME", str);
            f2919a = str;
        }
    }

    public static void a(Context context, boolean z) {
        if (f2920b != z) {
            i.b(context, "com.eshare.optoma.key.FIRST_CAST", z);
            f2920b = z;
        }
    }

    public static boolean b(Context context) {
        if (f2920b) {
            f2920b = i.a(context, "com.eshare.optoma.key.FIRST_CAST", true);
        }
        return f2920b;
    }
}
