package e;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends f {
    final transient byte[][] g;
    final transient int[] h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar, int i) {
        super(null);
        v.a(cVar.f3737c, 0L, i);
        p pVar = cVar.f3736b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = pVar.f3770c;
            int i6 = pVar.f3769b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                pVar = pVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.g = new byte[i4];
        this.h = new int[i4 * 2];
        p pVar2 = cVar.f3736b;
        int i7 = 0;
        while (i2 < i) {
            this.g[i7] = pVar2.f3768a;
            i2 += pVar2.f3770c - pVar2.f3769b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.h;
            iArr[i7] = i2;
            iArr[this.g.length + i7] = pVar2.f3769b;
            pVar2.f3771d = true;
            i7++;
            pVar2 = pVar2.f;
        }
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.h, 0, this.g.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    private f k() {
        return new f(i());
    }

    @Override // e.f
    public byte a(int i) {
        v.a(this.h[this.g.length - 1], i, 1L);
        int b2 = b(i);
        int i2 = b2 == 0 ? 0 : this.h[b2 - 1];
        int[] iArr = this.h;
        byte[][] bArr = this.g;
        return bArr[b2][(i - i2) + iArr[bArr.length + b2]];
    }

    @Override // e.f
    public f a(int i, int i2) {
        return k().a(i, i2);
    }

    @Override // e.f
    public String a() {
        return k().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.f
    public void a(c cVar) {
        int length = this.g.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.h;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            p pVar = new p(this.g[i], i3, (i3 + i4) - i2, true, false);
            p pVar2 = cVar.f3736b;
            if (pVar2 == null) {
                pVar.g = pVar;
                pVar.f = pVar;
                cVar.f3736b = pVar;
            } else {
                pVar2.g.a(pVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f3737c += i2;
    }

    @Override // e.f
    public boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.h[b2 - 1];
            int min = Math.min(i3, ((this.h[b2] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr = this.g;
            if (!fVar.a(i2, bArr[b2], (i - i4) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    @Override // e.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.h[b2 - 1];
            int min = Math.min(i3, ((this.h[b2] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr2 = this.g;
            if (!v.a(bArr2[b2], (i - i4) + iArr[bArr2.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    @Override // e.f
    public String b() {
        return k().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.f
    public byte[] c() {
        return i();
    }

    @Override // e.f
    public f d() {
        return k().d();
    }

    @Override // e.f
    public f e() {
        return k().e();
    }

    @Override // e.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.g() == g() && a(0, fVar, 0, g())) {
                return true;
            }
        }
        return false;
    }

    @Override // e.f
    public f f() {
        return k().f();
    }

    @Override // e.f
    public int g() {
        return this.h[this.g.length - 1];
    }

    @Override // e.f
    public f h() {
        return k().h();
    }

    @Override // e.f
    public int hashCode() {
        int i = this.f3741c;
        if (i != 0) {
            return i;
        }
        int length = this.g.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.g[i2];
            int[] iArr = this.h;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f3741c = i3;
        return i3;
    }

    @Override // e.f
    public byte[] i() {
        int[] iArr = this.h;
        byte[][] bArr = this.g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.h;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.g[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // e.f
    public String j() {
        return k().j();
    }

    @Override // e.f
    public String toString() {
        return k().toString();
    }
}
