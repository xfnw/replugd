package com.eshare.lib;

import java.io.ByteArrayOutputStream;

/* renamed from: com.eshare.lib.b */
/* loaded from: classes.dex */
public class stream {
    private static final ByteArrayOutputStream f = new ByteArrayOutputStream(512000);

    /* renamed from: a */
    private int f3002a;

    /* renamed from: b */
    private int f3003b;

    /* renamed from: c */
    private boolean f3004c = true;

    /* renamed from: d */
    private bytestream f3005d;

    /* renamed from: e */
    private int f3006e;

    public static int a(byte[] bArr, int i) {
        return (bArr[i] << 24) | (bArr[i + 3] & 255) | ((bArr[i + 2] << 8) & 65280) | ((bArr[i + 1] << 24) >>> 8);
    }

    public static long b(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = i; i2 < i + 8; i2++) {
            j = (j << 8) ^ (bArr[i2] & 255);
        }
        return j;
    }

    /* renamed from: a */
    public void setstream(bytestream cVar) {
        this.f3005d = cVar;
    }

    public void a(String str, byte[] bArr) {
        boolean z = false;
        int a2 = a(bArr, 0);
        a(bArr, 4);
        b(bArr, 8);
        int a3 = a(bArr, 16);
        int a4 = a(bArr, 20);
        int a5 = a(bArr, 24);
        b(bArr, 28);
        int a6 = a(bArr, 36);
        int a7 = a(bArr, 40);
        if (a2 == 1) {
            int i = this.f3002a;
            if (i <= 0 || i >= a5 || a5 != a4) {
                if (!(a4 == 0 && this.f3002a == 0)) {
                    if (a4 > 0 && a4 == this.f3002a + 1) {
                        this.f3002a = a4;
                    } else if (a4 != 0 || this.f3002a <= 0) {
                        this.f3002a = a4;
                        this.f3004c = false;
                    } else {
                        this.f3002a = a4;
                        if (this.f3004c && this.f3003b - f.size() < -2500) {
                            z = true;
                        }
                        bytestream cVar = this.f3005d;
                        if (cVar != null) {
                            cVar.a(this.f3006e, f, z, str);
                        }
                        this.f3004c = true;
                        f.reset();
                    }
                }
                f.write(bArr, 44, a6);
            } else {
                this.f3002a = 0;
                f.write(bArr, 44, a6);
                if (this.f3004c && a3 == f.size()) {
                    z = true;
                }
                bytestream cVar2 = this.f3005d;
                if (cVar2 != null) {
                    cVar2.a(this.f3006e, f, z, str);
                }
                this.f3004c = true;
                f.reset();
            }
            this.f3003b = a3;
            this.f3006e = a7;
        }
    }
}
