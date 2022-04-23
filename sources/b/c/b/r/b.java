package b.c.b.r;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private final int f1812b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1813c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1814d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f1815e;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f1812b = i;
        this.f1813c = i2;
        this.f1814d = (i + 31) / 32;
        this.f1815e = new int[this.f1814d * i2];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.f1812b = i;
        this.f1813c = i2;
        this.f1814d = i3;
        this.f1815e = iArr;
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f1813c * (this.f1812b + 1));
        for (int i = 0; i < this.f1813c; i++) {
            for (int i2 = 0; i2 < this.f1812b; i2++) {
                sb.append(b(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public a a(int i, a aVar) {
        if (aVar == null || aVar.c() < this.f1812b) {
            aVar = new a(this.f1812b);
        } else {
            aVar.a();
        }
        int i2 = i * this.f1814d;
        for (int i3 = 0; i3 < this.f1814d; i3++) {
            aVar.a(i3 << 5, this.f1815e[i2 + i3]);
        }
        return aVar;
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    public void a(int i, int i2) {
        int i3 = (i2 * this.f1814d) + (i / 32);
        int[] iArr = this.f1815e;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f1813c || i5 > this.f1812b) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f1814d * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f1815e;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public int[] a() {
        int length = this.f1815e.length - 1;
        while (length >= 0 && this.f1815e[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.f1814d;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.f1815e[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public void b(int i, a aVar) {
        int[] b2 = aVar.b();
        int[] iArr = this.f1815e;
        int i2 = this.f1814d;
        System.arraycopy(b2, 0, iArr, i * i2, i2);
    }

    public boolean b(int i, int i2) {
        return ((this.f1815e[(i2 * this.f1814d) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public int[] b() {
        int i = this.f1812b;
        int i2 = this.f1813c;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (i5 < this.f1813c) {
            int i6 = i4;
            int i7 = i3;
            int i8 = i;
            int i9 = 0;
            while (true) {
                int i10 = this.f1814d;
                if (i9 < i10) {
                    int i11 = this.f1815e[(i10 * i5) + i9];
                    if (i11 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i6) {
                            i6 = i5;
                        }
                        int i12 = i9 << 5;
                        int i13 = 31;
                        if (i12 < i8) {
                            int i14 = 0;
                            while ((i11 << (31 - i14)) == 0) {
                                i14++;
                            }
                            int i15 = i14 + i12;
                            if (i15 < i8) {
                                i8 = i15;
                            }
                        }
                        if (i12 + 31 > i7) {
                            while ((i11 >>> i13) == 0) {
                                i13--;
                            }
                            int i16 = i12 + i13;
                            if (i16 > i7) {
                                i7 = i16;
                            }
                        }
                    }
                    i9++;
                }
            }
            i5++;
            i = i8;
            i3 = i7;
            i4 = i6;
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public int c() {
        return this.f1813c;
    }

    public void c(int i, int i2) {
        int i3 = (i2 * this.f1814d) + (i / 32);
        int[] iArr = this.f1815e;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public b clone() {
        return new b(this.f1812b, this.f1813c, this.f1814d, (int[]) this.f1815e.clone());
    }

    public int[] d() {
        int i = 0;
        while (true) {
            int[] iArr = this.f1815e;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i++;
        }
        int[] iArr2 = this.f1815e;
        if (i == iArr2.length) {
            return null;
        }
        int i2 = this.f1814d;
        int i3 = i / i2;
        int i4 = (i % i2) << 5;
        int i5 = iArr2[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public int e() {
        return this.f1812b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1812b == bVar.f1812b && this.f1813c == bVar.f1813c && this.f1814d == bVar.f1814d && Arrays.equals(this.f1815e, bVar.f1815e);
    }

    public void f() {
        int e2 = e();
        int c2 = c();
        a aVar = new a(e2);
        a aVar2 = new a(e2);
        for (int i = 0; i < (c2 + 1) / 2; i++) {
            aVar = a(i, aVar);
            int i2 = (c2 - 1) - i;
            aVar2 = a(i2, aVar2);
            aVar.d();
            aVar2.d();
            b(i, aVar2);
            b(i2, aVar);
        }
    }

    public int hashCode() {
        int i = this.f1812b;
        return (((((((i * 31) + i) * 31) + this.f1813c) * 31) + this.f1814d) * 31) + Arrays.hashCode(this.f1815e);
    }

    public String toString() {
        return a("X ", "  ");
    }
}
