package b.c.b.s.b;

import b.c.b.f;
import b.c.b.r.e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1862a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f1863b = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f1864c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f1865d = f1863b;

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f1866e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1867a = new int[b.values().length];

        static {
            try {
                f1867a[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1867a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1867a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1867a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1867a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(byte[] bArr) {
        b.c.b.r.c cVar = new b.c.b.r.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            if (bVar == b.ASCII_ENCODE) {
                bVar = a(cVar, sb, sb2);
            } else {
                int i = a.f1867a[bVar.ordinal()];
                if (i == 1) {
                    b(cVar, sb);
                } else if (i == 2) {
                    d(cVar, sb);
                } else if (i == 3) {
                    a(cVar, sb);
                } else if (i == 4) {
                    c(cVar, sb);
                } else if (i == 5) {
                    a(cVar, sb, arrayList);
                } else {
                    throw f.a();
                }
                bVar = b.ASCII_ENCODE;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new e(bArr, sb3, arrayList, null);
    }

    private static b a(b.c.b.r.c cVar, StringBuilder sb, StringBuilder sb2) {
        String str;
        boolean z = false;
        do {
            int a2 = cVar.a(8);
            if (a2 != 0) {
                if (a2 > 128) {
                    if (a2 != 129) {
                        if (a2 > 229) {
                            switch (a2) {
                                case 230:
                                    return b.C40_ENCODE;
                                case 231:
                                    return b.BASE256_ENCODE;
                                case 232:
                                    sb.append((char) 29);
                                    break;
                                case 233:
                                case 234:
                                case 241:
                                    break;
                                case 235:
                                    z = true;
                                    break;
                                case 236:
                                    str = "[)>\u001e05\u001d";
                                    sb.append(str);
                                    sb2.insert(0, "\u001e\u0004");
                                    break;
                                case 237:
                                    str = "[)>\u001e06\u001d";
                                    sb.append(str);
                                    sb2.insert(0, "\u001e\u0004");
                                    break;
                                case 238:
                                    return b.ANSIX12_ENCODE;
                                case 239:
                                    return b.TEXT_ENCODE;
                                case 240:
                                    return b.EDIFACT_ENCODE;
                                default:
                                    if (!(a2 == 254 && cVar.a() == 0)) {
                                        throw f.a();
                                    }
                                    break;
                            }
                        } else {
                            int i = a2 - 130;
                            if (i < 10) {
                                sb.append('0');
                            }
                            sb.append(i);
                        }
                    } else {
                        return b.PAD_ENCODE;
                    }
                } else {
                    if (z) {
                        a2 += 128;
                    }
                    sb.append((char) (a2 - 1));
                    return b.ASCII_ENCODE;
                }
            } else {
                throw f.a();
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void a(b.c.b.r.c cVar, StringBuilder sb) {
        int a2;
        char c2;
        int i;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    c2 = '\r';
                } else if (i3 == 1) {
                    c2 = '*';
                } else if (i3 == 2) {
                    c2 = '>';
                } else if (i3 != 3) {
                    if (i3 < 14) {
                        i = i3 + 44;
                    } else if (i3 < 40) {
                        i = i3 + 51;
                    } else {
                        throw f.a();
                    }
                    c2 = (char) i;
                } else {
                    c2 = ' ';
                }
                sb.append(c2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(b.c.b.r.c cVar, StringBuilder sb, Collection<byte[]> collection) {
        int c2 = cVar.c() + 1;
        int i = c2 + 1;
        int a2 = a(cVar.a(8), c2);
        if (a2 == 0) {
            a2 = cVar.a() / 8;
        } else if (a2 >= 250) {
            i++;
            a2 = ((a2 - 249) * 250) + a(cVar.a(8), i);
        }
        if (a2 >= 0) {
            byte[] bArr = new byte[a2];
            for (int i2 = 0; i2 < a2; i2++) {
                if (cVar.a() >= 8) {
                    i++;
                    bArr[i2] = (byte) a(cVar.a(8), i);
                } else {
                    throw f.a();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
            }
        } else {
            throw f.a();
        }
    }

    private static void b(b.c.b.r.c cVar, StringBuilder sb) {
        int a2;
        char c2;
        char c3;
        int i;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (z) {
                            i = i4 + 128;
                            c3 = (char) i;
                            sb.append(c3);
                            z = false;
                        }
                        c2 = (char) i4;
                        sb.append(c2);
                    } else if (i2 == 2) {
                        char[] cArr = f1863b;
                        if (i4 < cArr.length) {
                            c2 = cArr[i4];
                            if (z) {
                                c3 = (char) (c2 + 128);
                                sb.append(c3);
                                z = false;
                            }
                        } else if (i4 == 27) {
                            c2 = 29;
                        } else if (i4 == 30) {
                            z = true;
                        } else {
                            throw f.a();
                        }
                        sb.append(c2);
                    } else if (i2 != 3) {
                        throw f.a();
                    } else if (z) {
                        i = i4 + 224;
                        c3 = (char) i;
                        sb.append(c3);
                        z = false;
                    } else {
                        i4 += 96;
                        c2 = (char) i4;
                        sb.append(c2);
                    }
                    i2 = 0;
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f1862a;
                    if (i4 < cArr2.length) {
                        char c4 = cArr2[i4];
                        if (z) {
                            sb.append((char) (c4 + 128));
                            z = false;
                        } else {
                            sb.append(c4);
                        }
                    } else {
                        throw f.a();
                    }
                }
            }
            if (cVar.a() > 0) {
                z = z;
            } else {
                return;
            }
        }
    }

    private static void c(b.c.b.r.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int a2 = cVar.a(6);
                if (a2 == 31) {
                    int b2 = 8 - cVar.b();
                    if (b2 != 8) {
                        cVar.a(b2);
                        return;
                    }
                    return;
                }
                if ((a2 & 32) == 0) {
                    a2 |= 64;
                }
                sb.append((char) a2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r5 != false) goto L_0x0038;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        r4 = (char) (r4 + 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
        if (r5 != false) goto L_0x0038;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(b.c.b.r.c r9, java.lang.StringBuilder r10) {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            int r5 = r9.a()
            r6 = 8
            if (r5 != r6) goto L_0x000f
            return
        L_0x000f:
            int r5 = r9.a(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L_0x0018
            return
        L_0x0018:
            int r6 = r9.a(r6)
            a(r5, r6, r1)
            r5 = r3
            r3 = 0
        L_0x0021:
            if (r3 >= r0) goto L_0x0093
            r6 = r1[r3]
            if (r4 == 0) goto L_0x0072
            r7 = 1
            if (r4 == r7) goto L_0x0062
            r8 = 2
            if (r4 == r8) goto L_0x0046
            if (r4 != r0) goto L_0x0041
            char[] r4 = b.c.b.s.b.c.f1866e
            int r7 = r4.length
            if (r6 >= r7) goto L_0x003c
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x006d
        L_0x0038:
            int r4 = r4 + 128
            char r4 = (char) r4
            goto L_0x0067
        L_0x003c:
            b.c.b.f r9 = b.c.b.f.a()
            throw r9
        L_0x0041:
            b.c.b.f r9 = b.c.b.f.a()
            throw r9
        L_0x0046:
            char[] r4 = b.c.b.s.b.c.f1865d
            int r8 = r4.length
            if (r6 >= r8) goto L_0x0050
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x006d
            goto L_0x0038
        L_0x0050:
            r4 = 27
            if (r6 == r4) goto L_0x005f
            r4 = 30
            if (r6 != r4) goto L_0x005a
            r5 = 1
            goto L_0x0070
        L_0x005a:
            b.c.b.f r9 = b.c.b.f.a()
            throw r9
        L_0x005f:
            r4 = 29
            goto L_0x006d
        L_0x0062:
            if (r5 == 0) goto L_0x006c
            int r6 = r6 + 128
            char r4 = (char) r6
        L_0x0067:
            r10.append(r4)
            r5 = 0
            goto L_0x0070
        L_0x006c:
            char r4 = (char) r6
        L_0x006d:
            r10.append(r4)
        L_0x0070:
            r4 = 0
            goto L_0x008b
        L_0x0072:
            if (r6 >= r0) goto L_0x0077
            int r4 = r6 + 1
            goto L_0x008b
        L_0x0077:
            char[] r7 = b.c.b.s.b.c.f1864c
            int r8 = r7.length
            if (r6 >= r8) goto L_0x008e
            char r6 = r7[r6]
            if (r5 == 0) goto L_0x0088
            int r6 = r6 + 128
            char r5 = (char) r6
            r10.append(r5)
            r5 = 0
            goto L_0x008b
        L_0x0088:
            r10.append(r6)
        L_0x008b:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x008e:
            b.c.b.f r9 = b.c.b.f.a()
            throw r9
        L_0x0093:
            int r3 = r9.a()
            if (r3 > 0) goto L_0x009a
            return
        L_0x009a:
            r3 = r5
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.b.s.b.c.d(b.c.b.r.c, java.lang.StringBuilder):void");
    }
}
