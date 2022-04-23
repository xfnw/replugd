package b.c.b.r;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f1816a;

    /* renamed from: b  reason: collision with root package name */
    private int f1817b;

    /* renamed from: c  reason: collision with root package name */
    private int f1818c;

    public c(byte[] bArr) {
        this.f1816a = bArr;
    }

    public int a() {
        return ((this.f1816a.length - this.f1817b) * 8) - this.f1818c;
    }

    public int a(int i) {
        int i2;
        if (i <= 0 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i3 = this.f1818c;
        if (i3 > 0) {
            int i4 = 8 - i3;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.f1816a;
            int i7 = this.f1817b;
            i2 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i -= i5;
            this.f1818c += i5;
            if (this.f1818c == 8) {
                this.f1818c = 0;
                this.f1817b = i7 + 1;
            }
        } else {
            i2 = 0;
        }
        if (i <= 0) {
            return i2;
        }
        while (i >= 8) {
            byte[] bArr2 = this.f1816a;
            int i8 = this.f1817b;
            i2 = (i2 << 8) | (bArr2[i8] & 255);
            this.f1817b = i8 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i2;
        }
        int i9 = 8 - i;
        int i10 = (i2 << i) | ((((255 >> i9) << i9) & this.f1816a[this.f1817b]) >> i9);
        this.f1818c += i;
        return i10;
    }

    public int b() {
        return this.f1818c;
    }

    public int c() {
        return this.f1817b;
    }
}
