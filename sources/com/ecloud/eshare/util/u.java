package com.ecloud.eshare.util;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static long f2935a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f2935a;
        if (0 < j && j < 360) {
            return true;
        }
        f2935a = currentTimeMillis;
        return false;
    }
}
