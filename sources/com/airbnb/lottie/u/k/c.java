package com.airbnb.lottie.u.k;

import com.airbnb.lottie.x.b;
import com.airbnb.lottie.x.g;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f2311a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f2312b;

    public c(float[] fArr, int[] iArr) {
        this.f2311a = fArr;
        this.f2312b = iArr;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f2312b.length == cVar2.f2312b.length) {
            for (int i = 0; i < cVar.f2312b.length; i++) {
                this.f2311a[i] = g.c(cVar.f2311a[i], cVar2.f2311a[i], f);
                this.f2312b[i] = b.a(f, cVar.f2312b[i], cVar2.f2312b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f2312b.length + " vs " + cVar2.f2312b.length + ")");
    }

    public int[] a() {
        return this.f2312b;
    }

    public float[] b() {
        return this.f2311a;
    }

    public int c() {
        return this.f2312b.length;
    }
}
