package b.c.b.v;

import b.c.b.i;
import b.c.b.m;
import b.c.b.o;
import b.c.b.r.a;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1920c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1921a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f1922b = new StringBuilder();

    private static int a(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f1920c[i2]) {
                return i2;
            }
        }
        throw i.a();
    }

    private int a(a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f1921a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int c2 = aVar.c();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5 && i < c2) {
            int a2 = p.a(aVar, iArr2, i, p.g);
            sb.append((char) ((a2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a2 >= 10) {
                i3 |= 1 << (4 - i2);
            }
            i = i2 != 4 ? aVar.c(aVar.b(i4)) : i4;
            i2++;
        }
        if (sb.length() == 5) {
            if (a((CharSequence) sb.toString()) == a(i3)) {
                return i;
            }
            throw i.a();
        }
        throw i.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r6.equals("90000") != false) goto L_0x003d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r6) {
        /*
            r0 = 0
            char r1 = r6.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L_0x004f
            r2 = 53
            if (r1 == r2) goto L_0x004c
            r2 = 57
            if (r1 == r2) goto L_0x0015
            goto L_0x0051
        L_0x0015:
            r1 = -1
            int r2 = r6.hashCode()
            r5 = 2
            switch(r2) {
                case 54118329: goto L_0x0033;
                case 54395376: goto L_0x0029;
                case 54395377: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x003c
        L_0x001f:
            java.lang.String r0 = "99991"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x0029:
            java.lang.String r0 = "99990"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x0033:
            java.lang.String r2 = "90000"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            if (r0 == 0) goto L_0x004a
            if (r0 == r4) goto L_0x0047
            if (r0 == r5) goto L_0x0044
            goto L_0x0051
        L_0x0044:
            java.lang.String r6 = "Used"
            return r6
        L_0x0047:
            java.lang.String r6 = "0.00"
            return r6
        L_0x004a:
            r6 = 0
            return r6
        L_0x004c:
            java.lang.String r3 = "$"
            goto L_0x0051
        L_0x004f:
            java.lang.String r3 = "£"
        L_0x0051:
            java.lang.String r6 = r6.substring(r4)
            int r6 = java.lang.Integer.parseInt(r6)
            int r0 = r6 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r6 = r6 % 100
            r1 = 10
            if (r6 >= r1) goto L_0x0070
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "0"
            java.lang.String r6 = r1.concat(r6)
            goto L_0x0074
        L_0x0070:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x0074:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.v.n.a(java.lang.String):java.lang.String");
    }

    private static Map<b.c.b.n, Object> b(String str) {
        String a2;
        if (str.length() != 5 || (a2 = a(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(b.c.b.n.class);
        enumMap.put((EnumMap) b.c.b.n.SUGGESTED_PRICE, (b.c.b.n) a2);
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(int i, a aVar, int[] iArr) {
        StringBuilder sb = this.f1922b;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<b.c.b.n, Object> b2 = b(sb2);
        float f = i;
        m mVar = new m(sb2, null, new o[]{new o((iArr[0] + iArr[1]) / 2.0f, f), new o(a2, f)}, b.c.b.a.UPC_EAN_EXTENSION);
        if (b2 != null) {
            mVar.a(b2);
        }
        return mVar;
    }
}
