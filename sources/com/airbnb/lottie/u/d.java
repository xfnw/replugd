package com.airbnb.lottie.u;

import com.airbnb.lottie.u.k.n;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f2278a;

    /* renamed from: b  reason: collision with root package name */
    private final char f2279b;

    /* renamed from: c  reason: collision with root package name */
    private final double f2280c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2281d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2282e;

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f2278a = list;
        this.f2279b = c2;
        this.f2280c = d3;
        this.f2281d = str;
        this.f2282e = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<n> a() {
        return this.f2278a;
    }

    public double b() {
        return this.f2280c;
    }

    public int hashCode() {
        return a(this.f2279b, this.f2282e, this.f2281d);
    }
}
