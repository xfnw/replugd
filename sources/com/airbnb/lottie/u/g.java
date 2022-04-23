package com.airbnb.lottie.u;

import a.d.e;
import com.airbnb.lottie.d;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    private static final g f2285b = new g();

    /* renamed from: a  reason: collision with root package name */
    private final e<String, d> f2286a = new e<>(20);

    g() {
    }

    public static g a() {
        return f2285b;
    }

    public d a(String str) {
        if (str == null) {
            return null;
        }
        return this.f2286a.b(str);
    }

    public void a(String str, d dVar) {
        if (str != null) {
            this.f2286a.a(str, dVar);
        }
    }
}
