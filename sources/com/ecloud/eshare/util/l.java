package com.ecloud.eshare.util;

import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class l {
    private static String a(Object obj) {
        return obj instanceof Object[] ? Arrays.toString((Object[]) obj) : obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof Throwable ? Log.getStackTraceString((Throwable) obj) : String.valueOf(obj);
    }

    private static void a(int i, String str, String str2) {
    }

    private static void a(int i, Object... objArr) {
        if (!(objArr == null || objArr.length == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(a(objArr[0]));
            for (int i2 = 1; i2 < objArr.length; i2++) {
                sb.append(" - ");
                sb.append(a(objArr[i2]));
            }
            a(i, "SHY", sb.toString());
        }
    }

    public static void a(String str, String str2, boolean z) {
        i.a(str, str2, z);
    }

    public static void a(Object... objArr) {
        a(3, objArr);
    }

    public static void b(Object... objArr) {
        a(6, objArr);
    }
}
