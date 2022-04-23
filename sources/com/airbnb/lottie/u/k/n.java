package com.airbnb.lottie.u.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.d;
import com.airbnb.lottie.u.l.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class n implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2368a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f2369b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2370c;

    public n(String str, List<b> list, boolean z) {
        this.f2368a = str;
        this.f2369b = list;
        this.f2370c = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, a aVar) {
        return new d(fVar, aVar, this);
    }

    public List<b> a() {
        return this.f2369b;
    }

    public String b() {
        return this.f2368a;
    }

    public boolean c() {
        return this.f2370c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f2368a + "' Shapes: " + Arrays.toString(this.f2369b.toArray()) + '}';
    }
}
