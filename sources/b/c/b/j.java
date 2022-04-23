package b.c.b;

/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f1774c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1775d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1776e;
    private final int f;
    private final int g;

    public j(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f1774c = bArr;
        this.f1775d = i;
        this.f1776e = i2;
        this.f = i3;
        this.g = i4;
        if (z) {
            a(i5, i6);
        }
    }

    private void a(int i, int i2) {
        byte[] bArr = this.f1774c;
        int i3 = (this.g * this.f1775d) + this.f;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b2 = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b2;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.f1775d;
        }
    }

    @Override // b.c.b.g
    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int c2 = c();
        if (bArr == null || bArr.length < c2) {
            bArr = new byte[c2];
        }
        System.arraycopy(this.f1774c, ((i + this.g) * this.f1775d) + this.f, bArr, 0, c2);
        return bArr;
    }

    @Override // b.c.b.g
    public byte[] b() {
        int c2 = c();
        int a2 = a();
        if (c2 == this.f1775d && a2 == this.f1776e) {
            return this.f1774c;
        }
        int i = c2 * a2;
        byte[] bArr = new byte[i];
        int i2 = this.g;
        int i3 = this.f1775d;
        int i4 = (i2 * i3) + this.f;
        if (c2 == i3) {
            System.arraycopy(this.f1774c, i4, bArr, 0, i);
            return bArr;
        }
        for (int i5 = 0; i5 < a2; i5++) {
            System.arraycopy(this.f1774c, i4, bArr, i5 * c2, c2);
            i4 += this.f1775d;
        }
        return bArr;
    }

    public int f() {
        return a() / 2;
    }

    public int g() {
        return c() / 2;
    }

    public int[] h() {
        int c2 = c() / 2;
        int a2 = a() / 2;
        int[] iArr = new int[c2 * a2];
        byte[] bArr = this.f1774c;
        int i = (this.g * this.f1775d) + this.f;
        for (int i2 = 0; i2 < a2; i2++) {
            int i3 = i2 * c2;
            for (int i4 = 0; i4 < c2; i4++) {
                iArr[i3 + i4] = ((bArr[(i4 << 1) + i] & 255) * 65793) | (-16777216);
            }
            i += this.f1775d << 1;
        }
        return iArr;
    }
}
