package com.king.zxing.s;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public enum e {
    ON,
    AUTO,
    OFF;

    public static e a(SharedPreferences sharedPreferences) {
        return a(sharedPreferences.getString("preferences_front_light_mode", OFF.toString()));
    }

    private static e a(String str) {
        return str == null ? OFF : valueOf(str);
    }
}
