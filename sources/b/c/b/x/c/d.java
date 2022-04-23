package b.c.b.x.c;

import b.c.b.o;

/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: c  reason: collision with root package name */
    private final float f2071c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2072d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f2071c = f3;
        this.f2072d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - b()) > f || Math.abs(f3 - a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2071c);
        return abs <= 1.0f || abs <= this.f2071c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d b(float f, float f2, float f3) {
        int i = this.f2072d;
        int i2 = i + 1;
        float a2 = (i * a()) + f2;
        float f4 = i2;
        return new d(a2 / f4, ((this.f2072d * b()) + f) / f4, ((this.f2072d * this.f2071c) + f3) / f4, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2072d;
    }

    public float d() {
        return this.f2071c;
    }
}
