package b.c.b.w.d.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f2019a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f2020b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f2019a = bVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f2020b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f2020b = new int[]{0};
                return;
            }
            this.f2020b = new int[length - i];
            int[] iArr2 = this.f2020b;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2020b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int i3 : this.f2020b) {
                i2 = this.f2019a.a(i2, i3);
            }
            return i2;
        }
        int[] iArr = this.f2020b;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            b bVar = this.f2019a;
            i4 = bVar.a(bVar.c(i, i4), this.f2020b[i5]);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2019a.c();
        } else {
            int length = this.f2020b.length;
            int[] iArr = new int[i + length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f2019a.c(this.f2020b[i3], i2);
            }
            return new c(this.f2019a, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(c cVar) {
        if (!this.f2019a.equals(cVar.f2019a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b()) {
            return cVar;
        } else {
            if (cVar.b()) {
                return this;
            }
            int[] iArr = this.f2020b;
            int[] iArr2 = cVar.f2020b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr3[i] = this.f2019a.a(iArr[i - length], iArr2[i]);
            }
            return new c(this.f2019a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        int[] iArr = this.f2020b;
        return iArr[(iArr.length - 1) - i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b(c cVar) {
        if (!this.f2019a.equals(cVar.f2019a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b() || cVar.b()) {
            return this.f2019a.c();
        } else {
            int[] iArr = this.f2020b;
            int length = iArr.length;
            int[] iArr2 = cVar.f2020b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    b bVar = this.f2019a;
                    iArr3[i4] = bVar.a(iArr3[i4], bVar.c(i2, iArr2[i3]));
                }
            }
            return new c(this.f2019a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f2020b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        int length = this.f2020b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f2019a.d(0, this.f2020b[i]);
        }
        return new c(this.f2019a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c(int i) {
        if (i == 0) {
            return this.f2019a.c();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f2020b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2019a.c(this.f2020b[i2], i);
        }
        return new c(this.f2019a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c(c cVar) {
        if (this.f2019a.equals(cVar.f2019a)) {
            return cVar.b() ? this : a(cVar.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
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
                    sb.append(b2);
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
