package e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f3768a;

    /* renamed from: b  reason: collision with root package name */
    int f3769b;

    /* renamed from: c  reason: collision with root package name */
    int f3770c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3771d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3772e;
    p f;
    p g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p() {
        this.f3768a = new byte[8192];
        this.f3772e = true;
        this.f3771d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3768a = bArr;
        this.f3769b = i;
        this.f3770c = i2;
        this.f3771d = z;
        this.f3772e = z2;
    }

    public final p a(int i) {
        p pVar;
        if (i <= 0 || i > this.f3770c - this.f3769b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            pVar = c();
        } else {
            pVar = q.a();
            System.arraycopy(this.f3768a, this.f3769b, pVar.f3768a, 0, i);
        }
        pVar.f3770c = pVar.f3769b + i;
        this.f3769b += i;
        this.g.a(pVar);
        return pVar;
    }

    public final p a(p pVar) {
        pVar.g = this;
        pVar.f = this.f;
        this.f.g = pVar;
        this.f = pVar;
        return pVar;
    }

    public final void a() {
        p pVar = this.g;
        if (pVar == this) {
            throw new IllegalStateException();
        } else if (pVar.f3772e) {
            int i = this.f3770c - this.f3769b;
            if (i <= (8192 - pVar.f3770c) + (pVar.f3771d ? 0 : pVar.f3769b)) {
                a(this.g, i);
                b();
                q.a(this);
            }
        }
    }

    public final void a(p pVar, int i) {
        if (pVar.f3772e) {
            int i2 = pVar.f3770c;
            if (i2 + i > 8192) {
                if (!pVar.f3771d) {
                    int i3 = pVar.f3769b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = pVar.f3768a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        pVar.f3770c -= pVar.f3769b;
                        pVar.f3769b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f3768a, this.f3769b, pVar.f3768a, pVar.f3770c, i);
            pVar.f3770c += i;
            this.f3769b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final p b() {
        p pVar = this.f;
        if (pVar == this) {
            pVar = null;
        }
        p pVar2 = this.g;
        pVar2.f = this.f;
        this.f.g = pVar2;
        this.f = null;
        this.g = null;
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p c() {
        this.f3771d = true;
        return new p(this.f3768a, this.f3769b, this.f3770c, true, false);
    }
}
