package b.c.b.s.b;

import b.c.b.s.b.e;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f1860a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1861b;

    private b(int i, byte[] bArr) {
        this.f1860a = i;
        this.f1861b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] a(byte[] bArr, e eVar) {
        e.c c2 = eVar.c();
        e.b[] a2 = c2.a();
        int i = 0;
        for (e.b bVar : a2) {
            i += bVar.a();
        }
        b[] bVarArr = new b[i];
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            e.b bVar2 = a2[i2];
            int i4 = i3;
            for (int i5 = 0; i5 < bVar2.a(); i5++) {
                int b2 = bVar2.b();
                i4++;
                bVarArr[i4] = new b(b2, new byte[c2.b() + b2]);
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].f1861b.length - c2.b();
        int i6 = length2 - 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i8;
            for (int i10 = 0; i10 < i3; i10++) {
                i9++;
                bVarArr[i10].f1861b[i7] = bArr[i9];
            }
            i7++;
            i8 = i9;
        }
        boolean z = eVar.g() == 24;
        int i11 = z ? 8 : i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i11; i13++) {
            i12++;
            bVarArr[i13].f1861b[i6] = bArr[i12];
        }
        int length3 = bVarArr[0].f1861b.length;
        while (length2 < length3) {
            for (int i14 = 0; i14 < i3; i14++) {
                int i15 = z ? (i14 + 8) % i3 : i14;
                i12++;
                bVarArr[i15].f1861b[(!z || i15 <= 7) ? length2 : length2 - 1] = bArr[i12];
            }
            length2++;
        }
        if (i12 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f1861b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1860a;
    }
}
