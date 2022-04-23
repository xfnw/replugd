package b.c.b.x.b;

import b.c.b.x.b.j;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f2033a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f2034b;

    private b(int i, byte[] bArr) {
        this.f2033a = i;
        this.f2034b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length == jVar.d()) {
            j.b a2 = jVar.a(fVar);
            j.a[] a3 = a2.a();
            int i = 0;
            for (j.a aVar : a3) {
                i += aVar.a();
            }
            b[] bVarArr = new b[i];
            int length = a3.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                j.a aVar2 = a3[i2];
                int i4 = i3;
                for (int i5 = 0; i5 < aVar2.a(); i5++) {
                    int b2 = aVar2.b();
                    i4++;
                    bVarArr[i4] = new b(b2, new byte[a2.b() + b2]);
                }
                i2++;
                i3 = i4;
            }
            int length2 = bVarArr[0].f2034b.length;
            int length3 = bVarArr.length - 1;
            while (length3 >= 0 && bVarArr[length3].f2034b.length != length2) {
                length3--;
            }
            int i6 = length3 + 1;
            int b3 = length2 - a2.b();
            int i7 = 0;
            int i8 = 0;
            while (i7 < b3) {
                int i9 = i8;
                for (int i10 = 0; i10 < i3; i10++) {
                    i9++;
                    bVarArr[i10].f2034b[i7] = bArr[i9];
                }
                i7++;
                i8 = i9;
            }
            for (int i11 = i6; i11 < i3; i11++) {
                i8++;
                bVarArr[i11].f2034b[b3] = bArr[i8];
            }
            int length4 = bVarArr[0].f2034b.length;
            while (b3 < length4) {
                int i12 = 0;
                while (i12 < i3) {
                    i8++;
                    bVarArr[i12].f2034b[i12 < i6 ? b3 : b3 + 1] = bArr[i8];
                    i12++;
                }
                b3++;
                i8 = i8;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f2034b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2033a;
    }
}
