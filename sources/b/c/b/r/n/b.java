package b.c.b.r.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f1852a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1853b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f1852a = aVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f1853b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f1853b = new int[]{0};
                return;
            }
            this.f1853b = new int[length - i];
            int[] iArr2 = this.f1853b;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1853b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int i3 : this.f1853b) {
                i2 = a.c(i2, i3);
            }
            return i2;
        }
        int[] iArr = this.f1853b;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            i4 = a.c(this.f1852a.b(i, i4), this.f1853b[i5]);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f1852a.d();
        } else {
            int length = this.f1853b.length;
            int[] iArr = new int[i + length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f1852a.b(this.f1853b[i3], i2);
            }
            return new b(this.f1852a, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(b bVar) {
        if (!this.f1852a.equals(bVar.f1852a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (b()) {
            return bVar;
        } else {
            if (bVar.b()) {
                return this;
            }
            int[] iArr = this.f1853b;
            int[] iArr2 = bVar.f1853b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr3[i] = a.c(iArr[i - length], iArr2[i]);
            }
            return new b(this.f1852a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        int[] iArr = this.f1853b;
        return iArr[(iArr.length - 1) - i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(b bVar) {
        if (!this.f1852a.equals(bVar.f1852a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (b() || bVar.b()) {
            return this.f1852a.d();
        } else {
            int[] iArr = this.f1853b;
            int length = iArr.length;
            int[] iArr2 = bVar.f1853b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = a.c(iArr3[i4], this.f1852a.b(i2, iArr2[i3]));
                }
            }
            return new b(this.f1852a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f1853b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b c(int i) {
        if (i == 0) {
            return this.f1852a.d();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f1853b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f1852a.b(this.f1853b[i2], i);
        }
        return new b(this.f1852a, iArr);
    }

    public String toString() {
        char c2;
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a2 = a(); a2 >= 0; a2--) {
            int b2 = b(a2);
            if (b2 != 0) {
                if (b2 < 0) {
                    sb.append(" - ");
                    b2 = -b2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a2 == 0 || b2 != 1) {
                    int c3 = this.f1852a.c(b2);
                    if (c3 == 0) {
                        c2 = '1';
                    } else if (c3 == 1) {
                        c2 = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(c3);
                    }
                    sb.append(c2);
                }
                if (a2 != 0) {
                    if (a2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
