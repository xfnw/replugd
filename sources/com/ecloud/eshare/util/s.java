package com.ecloud.eshare.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f2932a;

    public static boolean a(Context context, String str, boolean z) {
        if (f2932a == null) {
            f2932a = context.getSharedPreferences("config", 0);
        }
        return f2932a.getBoolean(str, z);
    }

    public static void b(Context context, String str, boolean z) {
        if (f2932a == null) {
            f2932a = context.getSharedPreferences("config", 0);
        }
        f2932a.edit().putBoolean(str, z).commit();
    }
}
