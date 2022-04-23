package b.c.b;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f1769a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1770b;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i, int i2) {
        this.f1769a = i;
        this.f1770b = i2;
    }

    public final int a() {
        return this.f1770b;
    }

    public abstract byte[] a(int i, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.f1769a;
    }

    public boolean d() {
        return false;
    }

    public g e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f1769a;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder(this.f1770b * (i + 1));
        for (int i2 = 0; i2 < this.f1770b; i2++) {
            bArr = a(i2, bArr);
            for (int i3 = 0; i3 < this.f1769a; i3++) {
                int i4 = bArr[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
