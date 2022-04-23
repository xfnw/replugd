package b.c.b.v;

import b.c.b.i;
import b.c.b.n;
import b.c.b.o;
import b.c.b.r.a;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1918a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f1919b = new StringBuilder();

    private int a(a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f1918a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int c2 = aVar.c();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2 && i < c2) {
            int a2 = p.a(aVar, iArr2, i, p.g);
            sb.append((char) ((a2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a2 >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            i = i2 != 1 ? aVar.c(aVar.b(i4)) : i4;
            i2++;
        }
        if (sb.length() != 2) {
            throw i.a();
        } else if (Integer.parseInt(sb.toString()) % 4 == i3) {
            return i;
        } else {
            throw i.a();
        }
    }

    private static Map<n, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(n.class);
        enumMap.put((EnumMap) n.ISSUE_NUMBER, (n) Integer.valueOf(str));
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.c.b.m a(int i, a aVar, int[] iArr) {
        StringBuilder sb = this.f1919b;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<n, Object> a3 = a(sb2);
        float f = i;
        b.c.b.m mVar = new b.c.b.m(sb2, null, new o[]{new o((iArr[0] + iArr[1]) / 2.0f, f), new o(a2, f)}, b.c.b.a.UPC_EAN_EXTENSION);
        if (a3 != null) {
            mVar.a(a3);
        }
        return mVar;
    }
}
