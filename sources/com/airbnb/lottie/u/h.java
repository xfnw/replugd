package com.airbnb.lottie.u;

/* loaded from: classes.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    private static String f2287d = "\r";

    /* renamed from: a  reason: collision with root package name */
    private final String f2288a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2289b;

    /* renamed from: c  reason: collision with root package name */
    public final float f2290c;

    public h(String str, float f, float f2) {
        this.f2288a = str;
        this.f2290c = f2;
        this.f2289b = f;
    }

    public boolean a(String str) {
        if (this.f2288a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f2288a.endsWith(f2287d)) {
            String str2 = this.f2288a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
