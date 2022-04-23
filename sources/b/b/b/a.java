package b.b.b;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f1710a;

    public a() {
        new ByteArrayOutputStream();
    }

    public static void a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >> 24) & 255);
        int i3 = i + 1;
        bArr[i3] = (byte) ((i2 >> 16) & 255);
        int i4 = i3 + 1;
        bArr[i4] = (byte) ((i2 >> 8) & 255);
        bArr[i4 + 1] = (byte) (i2 & 255);
    }

    public static void a(byte[] bArr, int i, long j) {
        bArr[i] = (byte) ((j >> 56) & 255);
        int i2 = i + 1;
        bArr[i2] = (byte) ((j >> 48) & 255);
        int i3 = i2 + 1;
        bArr[i3] = (byte) ((j >> 40) & 255);
        int i4 = i3 + 1;
        bArr[i4] = (byte) ((j >> 32) & 255);
        int i5 = i4 + 1;
        bArr[i5] = (byte) ((j >> 24) & 255);
        int i6 = i5 + 1;
        bArr[i6] = (byte) ((j >> 16) & 255);
        int i7 = i6 + 1;
        bArr[i7] = (byte) ((j >> 8) & 255);
        bArr[i7 + 1] = (byte) (j & 255);
    }

    public void a(int i, long j, long j2, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = i2;
        int length = bArr2.length;
        int i4 = length / 1400;
        int length2 = bArr2.length % 1400;
        int i5 = length2 > 0 ? i4 : i4 - 1;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i4) {
            a(bArr, i6, 1);
            a(bArr, 4, i);
            a(bArr, 8, j2);
            a(bArr, 16, length);
            a(bArr, 20, i7);
            a(bArr, 24, i5);
            a(bArr, 28, j);
            a(bArr, 36, 1400);
            a(bArr, 40, i3);
            System.arraycopy(bArr2, i7 * 1400, bArr, 44, 1400);
            b bVar = this.f1710a;
            if (bVar != null) {
                bVar.a(bArr);
            }
            i7++;
            i3 = i2;
            i6 = 0;
        }
        if (length2 > 0) {
            a(bArr, 0, 1);
            a(bArr, 4, i);
            a(bArr, 8, j2);
            a(bArr, 16, length);
            a(bArr, 20, i4);
            a(bArr, 24, i5);
            a(bArr, 28, j);
            a(bArr, 36, length2);
            a(bArr, 40, i2);
            System.arraycopy(bArr2, i4 * 1400, bArr, 44, length2);
            b bVar2 = this.f1710a;
            if (bVar2 != null) {
                bVar2.a(bArr);
            }
        }
    }

    public void a(b bVar) {
        this.f1710a = bVar;
    }
}
