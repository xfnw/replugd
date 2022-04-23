package e;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class m extends AbstractList<f> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    final f[] f3759b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f3760c;

    private m(f[] fVarArr, int[] iArr) {
        this.f3759b = fVarArr;
        this.f3760c = iArr;
    }

    private static int a(c cVar) {
        return (int) (cVar.r() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static e.m a(e.f... r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.m.a(e.f[]):e.m");
    }

    private static void a(long j, c cVar, int i, List<f> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6 = i2;
        if (i6 < i3) {
            for (int i7 = i6; i7 < i3; i7++) {
                if (list.get(i7).g() < i) {
                    throw new AssertionError();
                }
            }
            f fVar = list.get(i2);
            f fVar2 = list.get(i3 - 1);
            int i8 = -1;
            if (i == fVar.g()) {
                i8 = list2.get(i6).intValue();
                i6++;
                fVar = list.get(i6);
            }
            if (fVar.a(i) != fVar2.a(i)) {
                int i9 = 1;
                for (int i10 = i6 + 1; i10 < i3; i10++) {
                    if (list.get(i10 - 1).a(i) != list.get(i10).a(i)) {
                        i9++;
                    }
                }
                long a2 = j + a(cVar) + 2 + (i9 * 2);
                cVar.writeInt(i9);
                cVar.writeInt(i8);
                for (int i11 = i6; i11 < i3; i11++) {
                    byte a3 = list.get(i11).a(i);
                    if (i11 == i6 || a3 != list.get(i11 - 1).a(i)) {
                        cVar.writeInt(a3 & 255);
                    }
                }
                c cVar2 = new c();
                int i12 = i6;
                while (i12 < i3) {
                    byte a4 = list.get(i12).a(i);
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        if (i14 >= i3) {
                            i5 = i3;
                            break;
                        } else if (a4 != list.get(i14).a(i)) {
                            i5 = i14;
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (i13 == i5 && i + 1 == list.get(i12).g()) {
                        cVar.writeInt(list2.get(i12).intValue());
                        i12 = i5;
                        cVar2 = cVar2;
                    } else {
                        cVar.writeInt((int) ((a(cVar2) + a2) * (-1)));
                        i12 = i5;
                        cVar2 = cVar2;
                        a(a2, cVar2, i + 1, list, i12, i5, list2);
                    }
                }
                cVar.a(cVar2, cVar2.r());
                return;
            }
            int min = Math.min(fVar.g(), fVar2.g());
            int i15 = 0;
            for (int i16 = i; i16 < min && fVar.a(i16) == fVar2.a(i16); i16++) {
                i15++;
            }
            long a5 = 1 + j + a(cVar) + 2 + i15;
            cVar.writeInt(-i15);
            cVar.writeInt(i8);
            int i17 = i;
            while (true) {
                i4 = i + i15;
                if (i17 >= i4) {
                    break;
                }
                cVar.writeInt(fVar.a(i17) & 255);
                i17++;
            }
            if (i6 + 1 != i3) {
                c cVar3 = new c();
                cVar.writeInt((int) ((a(cVar3) + a5) * (-1)));
                a(a5, cVar3, i4, list, i6, i3, list2);
                cVar.a(cVar3, cVar3.r());
            } else if (i4 == list.get(i6).g()) {
                cVar.writeInt(list2.get(i6).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public f get(int i) {
        return this.f3759b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3759b.length;
    }
}
