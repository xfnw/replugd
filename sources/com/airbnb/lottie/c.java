package com.airbnb.lottie;

import a.g.h.a;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2100a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2101b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f2102c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f2103d;

    /* renamed from: e  reason: collision with root package name */
    private static int f2104e;
    private static int f;

    public static void a(String str) {
        if (f2101b) {
            int i = f2104e;
            if (i == 20) {
                f++;
                return;
            }
            f2102c[i] = str;
            f2103d[i] = System.nanoTime();
            a.a(str);
            f2104e++;
        }
    }

    public static float b(String str) {
        int i = f;
        if (i > 0) {
            f = i - 1;
            return 0.0f;
        } else if (!f2101b) {
            return 0.0f;
        } else {
            f2104e--;
            int i2 = f2104e;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f2102c[i2])) {
                a.a();
                return ((float) (System.nanoTime() - f2103d[f2104e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f2102c[f2104e] + ".");
            }
        }
    }
}
