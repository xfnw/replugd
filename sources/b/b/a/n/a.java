package b.b.a.n;

/* loaded from: classes.dex */
public final class a {
    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 0] & 255) << 0) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }
}
