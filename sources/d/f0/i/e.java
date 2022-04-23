package d.f0.i;

import d.f0.c;
import e.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final f f3525a = f.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f3526b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f3527c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    static final String[] f3528d = new String[256];

    static {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f3528d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f3527c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr2 = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr2) {
            f3527c[i3 | 8] = f3527c[i3] + "|PADDED";
        }
        String[] strArr3 = f3527c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr2) {
                int i6 = i5 | i4;
                f3527c[i6] = f3527c[i5] + '|' + f3527c[i4];
                f3527c[i6 | 8] = f3527c[i5] + '|' + f3527c[i4] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f3527c;
            if (i < strArr4.length) {
                if (strArr4[i] == null) {
                    strArr4[i] = f3528d[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(c.a(str, objArr));
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f3528d[b3];
            }
            if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = f3527c;
                String str = b3 < strArr.length ? strArr[b3] : f3528d[b3];
                return (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f3528d[b3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = f3526b;
        String a2 = b2 < strArr.length ? strArr[b2] : c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) {
        throw new IOException(c.a(str, objArr));
    }
}
