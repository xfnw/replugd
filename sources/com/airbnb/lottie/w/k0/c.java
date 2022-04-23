package com.airbnb.lottie.w.k0;

import e.e;
import e.f;
import e.m;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class c implements Closeable {
    private static final String[] h = new String[128];

    /* renamed from: b  reason: collision with root package name */
    int f2456b;

    /* renamed from: c  reason: collision with root package name */
    int[] f2457c = new int[32];

    /* renamed from: d  reason: collision with root package name */
    String[] f2458d = new String[32];

    /* renamed from: e  reason: collision with root package name */
    int[] f2459e = new int[32];
    boolean f;
    boolean g;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String[] f2460a;

        /* renamed from: b  reason: collision with root package name */
        final m f2461b;

        private a(String[] strArr, m mVar) {
            this.f2460a = strArr;
            this.f2461b = mVar;
        }

        public static a a(String... strArr) {
            try {
                f[] fVarArr = new f[strArr.length];
                e.c cVar = new e.c();
                for (int i = 0; i < strArr.length; i++) {
                    c.b(cVar, strArr[i]);
                    cVar.readByte();
                    fVarArr[i] = cVar.p();
                }
                return new a((String[]) strArr.clone(), m.a(fVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i = 0; i <= 31; i++) {
            h[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = h;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static c a(e eVar) {
        return new e(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(e.d r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.w.k0.c.h
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        L_0x000d:
            if (r3 >= r2) goto L_0x0036
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L_0x001c
            r5 = r0[r5]
            if (r5 != 0) goto L_0x0029
            goto L_0x0033
        L_0x001c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L_0x0023
            java.lang.String r5 = "\\u2028"
            goto L_0x0029
        L_0x0023:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L_0x0033
            java.lang.String r5 = "\\u2029"
        L_0x0029:
            if (r4 >= r3) goto L_0x002e
            r7.a(r8, r4, r3)
        L_0x002e:
            r7.a(r5)
            int r4 = r3 + 1
        L_0x0033:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0036:
            if (r4 >= r2) goto L_0x003b
            r7.a(r8, r4, r2)
        L_0x003b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.w.k0.c.b(e.d, java.lang.String):void");
    }

    public abstract int a(a aVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        int i2 = this.f2456b;
        int[] iArr = this.f2457c;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.f2457c = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f2458d;
                this.f2458d = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f2459e;
                this.f2459e = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new com.airbnb.lottie.w.k0.a("Nesting too deep at " + q());
            }
        }
        int[] iArr3 = this.f2457c;
        int i3 = this.f2456b;
        this.f2456b = i3 + 1;
        iArr3[i3] = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.airbnb.lottie.w.k0.b b(String str) {
        throw new com.airbnb.lottie.w.k0.b(str + " at path " + q());
    }

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public final String q() {
        return d.a(this.f2456b, this.f2457c, this.f2458d, this.f2459e);
    }

    public abstract boolean r();

    public abstract boolean s();

    public abstract double t();

    public abstract int u();

    public abstract String v();

    public abstract String w();

    public abstract b x();

    public abstract void y();

    public abstract void z();
}
