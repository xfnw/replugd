package b.c.b.v.r;

import b.c.b.o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f1938a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1939b;

    /* renamed from: c  reason: collision with root package name */
    private final o[] f1940c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f1938a = i;
        this.f1939b = iArr;
        float f = i4;
        this.f1940c = new o[]{new o(i2, f), new o(i3, f)};
    }

    public o[] a() {
        return this.f1940c;
    }

    public int[] b() {
        return this.f1939b;
    }

    public int c() {
        return this.f1938a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f1938a == ((c) obj).f1938a;
    }

    public int hashCode() {
        return this.f1938a;
    }
}
