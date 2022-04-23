package b.b.a.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f1701a;

    public static float a(Context context, String str, float f) {
        if (f1701a == null) {
            f1701a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f1701a.getFloat(str, f);
    }

    public static int a(Context context, String str, String str2) {
        if (str2 != null) {
            return context.getResources().getIdentifier(str2, str, context.getPackageName());
        }
        return 0;
    }

    public static boolean a(Context context, String str, boolean z) {
        if (f1701a == null) {
            f1701a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f1701a.getBoolean(str, z);
    }

    public static String b(Context context, String str, String str2) {
        if (f1701a == null) {
            f1701a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f1701a.getString(str, str2);
    }

    public static void b(Context context, String str, float f) {
        if (f1701a == null) {
            f1701a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        SharedPreferences.Editor edit = f1701a.edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public static void b(Context context, String str, boolean z) {
        if (f1701a == null) {
            f1701a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        SharedPreferences.Editor edit = f1701a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void c(Context context, String str, String str2) {
        if (f1701a == null) {
            f1701a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        SharedPreferences.Editor edit = f1701a.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
