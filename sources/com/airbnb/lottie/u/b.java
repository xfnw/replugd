package com.airbnb.lottie.u;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f2266a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2267b;

    /* renamed from: c  reason: collision with root package name */
    public final double f2268c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2269d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2270e;
    public final double f;
    public final double g;
    public final int h;
    public final int i;
    public final double j;
    public final boolean k;

    /* loaded from: classes.dex */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, double d2, a aVar, int i, double d3, double d4, int i2, int i3, double d5, boolean z) {
        this.f2266a = str;
        this.f2267b = str2;
        this.f2268c = d2;
        this.f2269d = aVar;
        this.f2270e = i;
        this.f = d3;
        this.g = d4;
        this.h = i2;
        this.i = i3;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        double hashCode = ((this.f2266a.hashCode() * 31) + this.f2267b.hashCode()) * 31;
        double d2 = this.f2268c;
        Double.isNaN(hashCode);
        int ordinal = (((((int) (hashCode + d2)) * 31) + this.f2269d.ordinal()) * 31) + this.f2270e;
        long doubleToLongBits = Double.doubleToLongBits(this.f);
        return (((ordinal * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.h;
    }
}
