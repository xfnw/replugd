package com.ecloud.eshare.util;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: classes.dex */
public class g {
    public static int a(Context context, float f) {
        DisplayMetrics displayMetrics;
        double d2 = (displayMetrics.widthPixels / context.getResources().getDisplayMetrics().density) / f;
        Double.isNaN(d2);
        return (int) (d2 + 0.5d);
    }

    public static int b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
