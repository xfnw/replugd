package com.ecloud.eshare.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.a;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class q {
    public static boolean a(Activity activity) {
        if (c(activity).booleanValue()) {
            return true;
        }
        activity.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1012);
        return false;
    }

    public static boolean a(Activity activity, int i) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        for (String str : copyOnWriteArrayList) {
            if (a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.a.a(activity, strArr, i);
        return false;
    }

    public static boolean a(Activity activity, Boolean bool) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (!bool.booleanValue()) {
            copyOnWriteArrayList.add("android.permission.CAMERA");
        }
        copyOnWriteArrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        for (String str : copyOnWriteArrayList) {
            if (a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.a.a(activity, strArr, 1011);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    public static boolean b(Activity activity) {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)) {
            return true;
        }
        try {
            activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 2000);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean b(Activity activity, int i) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (Build.VERSION.SDK_INT >= 16) {
            copyOnWriteArrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        copyOnWriteArrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        for (String str : copyOnWriteArrayList) {
            if (a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.a.a(activity, strArr, i);
        return false;
    }

    public static Boolean c(Activity activity) {
        return Boolean.valueOf(((LocationManager) activity.getSystemService("location")).isProviderEnabled("gps"));
    }

    public static boolean d(Activity activity) {
        return a.a(activity, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean e(Activity activity) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("android.permission.CAMERA");
        for (String str : copyOnWriteArrayList) {
            if (a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.a.a(activity, strArr, 1001);
        return false;
    }

    public static boolean f(Activity activity) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("android.permission.RECORD_AUDIO");
        for (String str : copyOnWriteArrayList) {
            if (a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.a.a(activity, strArr, 1010);
        return false;
    }
}
