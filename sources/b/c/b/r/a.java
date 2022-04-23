package b.c.b.r;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private int[] f1810b;

    /* renamed from: c  reason: collision with root package name */
    private int f1811c;

    public a() {
        this.f1811c = 0;
        this.f1810b = new int[1];
    }

    public a(int i) {
        this.f1811c = i;
        this.f1810b = e(i);
    }

    a(int[] iArr, int i) {
        this.f1810b = iArr;
        this.f1811c = i;
    }

    private static int[] e(int i) {
        return new int[(i + 31) / 32];
    }

    public void a() {
        int length = this.f1810b.length;
        for (int i = 0; i < length; i++) {
            this.f1810b[i] = 0;
        }
    }

    public void a(int i, int i2) {
        this.f1810b[i / 32] = i2;
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f1810b[i / 32]) != 0;
    }

    public boolean a(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.f1811c) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                int i9 = (2 << i7) - (1 << i8);
                int i10 = this.f1810b[i6] & i9;
                if (!z) {
                    i9 = 0;
                }
                if (i10 != i9) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public int b(int i) {
        int i2 = this.f1811c;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (((1 << (i & 31)) - 1) ^ (-1)) & this.f1810b[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f1810b;
            if (i3 == iArr.length) {
                return this.f1811c;
            }
            i4 = iArr[i3];
        }
        int numberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.f1811c;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public int[] b() {
        return this.f1810b;
    }

    public int c() {
        return this.f1811c;
    }

    public int c(int i) {
        int i2 = this.f1811c;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (((1 << (i & 31)) - 1) ^ (-1)) & (this.f1810b[i3] ^ (-1));
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f1810b;
            if (i3 == iArr.length) {
                return this.f1811c;
            }
            i4 = iArr[i3] ^ (-1);
        }
        int numberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.f1811c;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public a clone() {
        return new a((int[]) this.f1810b.clone(), this.f1811c);
    }

    public void d() {
        int[] iArr = new int[this.f1810b.length];
        int i = (this.f1811c - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.f1810b[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.f1811c;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.f1810b = iArr;
    }

    public void d(int i) {
        int[] iArr = this.f1810b;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1811c == aVar.f1811c && Arrays.equals(this.f1810b, aVar.f1810b);
    }

    public int hashCode() {
        return (this.f1811c * 31) + Arrays.hashCode(this.f1810b);
    }

    public String toString() {
        int i = this.f1811c;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.f1811c; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i2) ? 'X' : '.');
        }
        return sb.toString();
    }
}
