package com.airbnb.lottie.v;

/* loaded from: classes.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");
    

    /* renamed from: b  reason: collision with root package name */
    public final String f2425b;

    a(String str) {
        this.f2425b = str;
    }

    public String a() {
        return ".temp" + this.f2425b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f2425b;
    }
}
