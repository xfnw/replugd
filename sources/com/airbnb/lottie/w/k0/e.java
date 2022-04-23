package com.airbnb.lottie.w.k0;

import com.airbnb.lottie.w.k0.c;
import e.c;
import e.f;
import java.io.EOFException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends c {
    private static final f o = f.d("'\\");
    private static final f p = f.d("\"\\");
    private static final f q = f.d("{}[]:, \n\t\r\f/\\;#=");
    private static final f r = f.d("\n\r");
    private static final f s = f.d("*/");
    private final e.e i;
    private final c j;
    private int k = 0;
    private long l;
    private int m;
    private String n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(e.e eVar) {
        if (eVar != null) {
            this.i = eVar;
            this.j = eVar.i();
            a(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void A() {
        if (!this.f) {
            b("Use JsonReader.setLenient(true) to accept malformed JSON");
            throw null;
        }
    }

    private int B() {
        int i;
        int[] iArr = this.f2457c;
        int i2 = this.f2456b;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else {
            if (i3 == 2) {
                int a2 = a(true);
                this.j.readByte();
                if (a2 != 44) {
                    if (a2 != 59) {
                        if (a2 == 93) {
                            this.k = 4;
                            return 4;
                        }
                        b("Unterminated array");
                        throw null;
                    }
                    A();
                }
            } else if (i3 == 3 || i3 == 5) {
                this.f2457c[this.f2456b - 1] = 4;
                if (i3 == 5) {
                    int a3 = a(true);
                    this.j.readByte();
                    if (a3 != 44) {
                        if (a3 != 59) {
                            if (a3 != 125) {
                                b("Unterminated object");
                                throw null;
                            }
                            i = 2;
                        } else {
                            A();
                        }
                    }
                }
                int a4 = a(true);
                if (a4 == 34) {
                    this.j.readByte();
                    i = 13;
                } else if (a4 == 39) {
                    this.j.readByte();
                    A();
                    i = 12;
                } else if (a4 != 125) {
                    A();
                    if (b((char) a4)) {
                        i = 14;
                    } else {
                        b("Expected name");
                        throw null;
                    }
                } else if (i3 != 5) {
                    this.j.readByte();
                    i = 2;
                } else {
                    b("Expected name");
                    throw null;
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int a5 = a(true);
                this.j.readByte();
                if (a5 != 58) {
                    if (a5 == 61) {
                        A();
                        if (this.i.d(1L) && this.j.h(0L) == 62) {
                            this.j.readByte();
                        }
                    } else {
                        b("Expected ':'");
                        throw null;
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (a(false) == -1) {
                    i = 18;
                }
                A();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.k = i;
            return i;
        }
        int a6 = a(true);
        if (a6 == 34) {
            this.j.readByte();
            i = 9;
        } else if (a6 != 39) {
            if (!(a6 == 44 || a6 == 59)) {
                if (a6 == 91) {
                    this.j.readByte();
                    this.k = 3;
                    return 3;
                } else if (a6 != 93) {
                    if (a6 != 123) {
                        int D = D();
                        if (D != 0) {
                            return D;
                        }
                        int E = E();
                        if (E != 0) {
                            return E;
                        }
                        if (b(this.j.h(0L))) {
                            A();
                            i = 10;
                        } else {
                            b("Expected value");
                            throw null;
                        }
                    } else {
                        this.j.readByte();
                        this.k = 1;
                        return 1;
                    }
                } else if (i3 == 1) {
                    this.j.readByte();
                    i = 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                A();
                this.k = 7;
                return 7;
            }
            b("Unexpected value");
            throw null;
        } else {
            A();
            this.j.readByte();
            this.k = 8;
            return 8;
        }
        this.k = i;
        return i;
    }

    private String C() {
        long a2 = this.i.a(q);
        return a2 != -1 ? this.j.i(a2) : this.j.q();
    }

    private int D() {
        String str;
        String str2;
        int i;
        byte h = this.j.h(0L);
        if (h == 116 || h == 84) {
            i = 5;
            str2 = "true";
            str = "TRUE";
        } else if (h == 102 || h == 70) {
            i = 6;
            str2 = "false";
            str = "FALSE";
        } else if (h != 110 && h != 78) {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.i.d(i3)) {
                return 0;
            }
            byte h2 = this.j.h(i2);
            if (h2 != str2.charAt(i2) && h2 != str.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.i.d(length + 1) && b(this.j.h(length))) {
            return 0;
        }
        this.j.skip(length);
        this.k = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (b(r11) != false) goto L_0x00c0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
        if (r6 != 2) goto L_0x00b0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        if (r7 == false) goto L_0x00b0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r8 != Long.MIN_VALUE) goto L_0x0099;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0097, code lost:
        if (r10 == false) goto L_0x00b0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
        if (r8 != 0) goto L_0x009f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009d, code lost:
        if (r10 != false) goto L_0x00b0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009f, code lost:
        if (r10 == false) goto L_0x00a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a2, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
        r16.l = r8;
        r16.j.skip(r5);
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ad, code lost:
        r16.k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00af, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b0, code lost:
        if (r6 == 2) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b3, code lost:
        if (r6 == 4) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b6, code lost:
        if (r6 != 7) goto L_0x00b9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b9, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bb, code lost:
        r16.m = r5;
        r1 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int E() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.w.k0.e.E():int");
    }

    private char F() {
        int i;
        int i2;
        if (this.i.d(1L)) {
            byte readByte = this.j.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return '\b';
            }
            if (readByte == 102) {
                return '\f';
            }
            if (readByte == 110) {
                return '\n';
            }
            if (readByte == 114) {
                return '\r';
            }
            if (readByte == 116) {
                return '\t';
            }
            if (readByte != 117) {
                if (this.f) {
                    return (char) readByte;
                }
                b("Invalid escape sequence: \\" + ((char) readByte));
                throw null;
            } else if (this.i.d(4L)) {
                char c2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    byte h = this.j.h(i3);
                    char c3 = (char) (c2 << 4);
                    if (h < 48 || h > 57) {
                        if (h >= 97 && h <= 102) {
                            i = h - 97;
                        } else if (h < 65 || h > 70) {
                            b("\\u" + this.j.i(4L));
                            throw null;
                        } else {
                            i = h - 65;
                        }
                        i2 = i + 10;
                    } else {
                        i2 = h - 48;
                    }
                    c2 = (char) (c3 + i2);
                }
                this.j.skip(4L);
                return c2;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + q());
            }
        } else {
            b("Unterminated escape sequence");
            throw null;
        }
    }

    private boolean G() {
        long b2 = this.i.b(s);
        boolean z = b2 != -1;
        c cVar = this.j;
        cVar.skip(z ? b2 + s.g() : cVar.r());
        return z;
    }

    private void H() {
        long a2 = this.i.a(r);
        c cVar = this.j;
        cVar.skip(a2 != -1 ? a2 + 1 : cVar.r());
    }

    private void I() {
        long a2 = this.i.a(q);
        c cVar = this.j;
        if (a2 == -1) {
            a2 = cVar.r();
        }
        cVar.skip(a2);
    }

    private int a(String str, c.a aVar) {
        int length = aVar.f2460a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.f2460a[i])) {
                this.k = 0;
                this.f2458d[this.f2456b - 1] = str;
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        r6.j.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r6.i.d(2) != false) goto L_0x003c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        A();
        r3 = r6.j.h(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        r6.j.readByte();
        r6.j.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        H();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.j.readByte();
        r6.j.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (G() == false) goto L_0x006d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
        b("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
        if (r1 != 35) goto L_0x007c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
        A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(boolean r7) {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            e.e r2 = r6.i
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.d(r4)
            if (r2 == 0) goto L_0x007f
            e.c r2 = r6.j
            long r4 = (long) r1
            byte r1 = r2.h(r4)
            r2 = 10
            if (r1 == r2) goto L_0x007d
            r2 = 32
            if (r1 == r2) goto L_0x007d
            r2 = 13
            if (r1 == r2) goto L_0x007d
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x007d
        L_0x0025:
            e.c r2 = r6.j
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            e.e r3 = r6.i
            r4 = 2
            boolean r3 = r3.d(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.A()
            e.c r3 = r6.j
            r4 = 1
            byte r3 = r3.h(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            e.c r1 = r6.j
            r1.readByte()
            e.c r1 = r6.j
            r1.readByte()
        L_0x0058:
            r6.H()
            goto L_0x0001
        L_0x005c:
            e.c r1 = r6.j
            r1.readByte()
            e.c r1 = r6.j
            r1.readByte()
            boolean r1 = r6.G()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            r6.b(r7)
            r7 = 0
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007c
            r6.A()
            goto L_0x0058
        L_0x007c:
            return r1
        L_0x007d:
            r1 = r3
            goto L_0x0002
        L_0x007f:
            if (r7 != 0) goto L_0x0083
            r7 = -1
            return r7
        L_0x0083:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            goto L_0x008c
        L_0x008b:
            throw r7
        L_0x008c:
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.w.k0.e.a(boolean):int");
    }

    private boolean b(int i) {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (!(i == 47 || i == 61)) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        A();
        return false;
    }

    private String c(f fVar) {
        StringBuilder sb = null;
        while (true) {
            long a2 = this.i.a(fVar);
            if (a2 == -1) {
                b("Unterminated string");
                throw null;
            } else if (this.j.h(a2) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.j.i(a2));
                this.j.readByte();
                sb.append(F());
            } else {
                String i = this.j.i(a2);
                if (sb == null) {
                    this.j.readByte();
                    return i;
                }
                sb.append(i);
                this.j.readByte();
                return sb.toString();
            }
        }
    }

    private void d(f fVar) {
        while (true) {
            long a2 = this.i.a(fVar);
            if (a2 == -1) {
                b("Unterminated string");
                throw null;
            } else if (this.j.h(a2) == 92) {
                this.j.skip(a2 + 1);
                F();
            } else {
                this.j.skip(a2 + 1);
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.w.k0.c
    public int a(c.a aVar) {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return a(this.n, aVar);
        }
        int a2 = this.i.a(aVar.f2461b);
        if (a2 != -1) {
            this.k = 0;
            this.f2458d[this.f2456b - 1] = aVar.f2460a[a2];
            return a2;
        }
        String str = this.f2458d[this.f2456b - 1];
        String v = v();
        int a3 = a(v, aVar);
        if (a3 == -1) {
            this.k = 15;
            this.n = v;
            this.f2458d[this.f2456b - 1] = str;
        }
        return a3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.k = 0;
        this.f2457c[0] = 8;
        this.f2456b = 1;
        this.j.n();
        this.i.close();
    }

    @Override // com.airbnb.lottie.w.k0.c
    public void m() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 3) {
            a(1);
            this.f2459e[this.f2456b - 1] = 0;
            this.k = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + x() + " at path " + q());
    }

    @Override // com.airbnb.lottie.w.k0.c
    public void n() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 1) {
            a(3);
            this.k = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + x() + " at path " + q());
    }

    @Override // com.airbnb.lottie.w.k0.c
    public void o() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 4) {
            this.f2456b--;
            int[] iArr = this.f2459e;
            int i2 = this.f2456b - 1;
            iArr[i2] = iArr[i2] + 1;
            this.k = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + x() + " at path " + q());
    }

    @Override // com.airbnb.lottie.w.k0.c
    public void p() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 2) {
            this.f2456b--;
            String[] strArr = this.f2458d;
            int i2 = this.f2456b;
            strArr[i2] = null;
            int[] iArr = this.f2459e;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.k = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + x() + " at path " + q());
    }

    @Override // com.airbnb.lottie.w.k0.c
    public boolean r() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.w.k0.c
    public boolean s() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 5) {
            this.k = 0;
            int[] iArr = this.f2459e;
            int i2 = this.f2456b - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.k = 0;
            int[] iArr2 = this.f2459e;
            int i3 = this.f2456b - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new a("Expected a boolean but was " + x() + " at path " + q());
        }
    }

    @Override // com.airbnb.lottie.w.k0.c
    public double t() {
        double parseDouble;
        String C;
        f fVar;
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 16) {
            this.k = 0;
            int[] iArr = this.f2459e;
            int i2 = this.f2456b - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.l;
        }
        try {
            if (i == 17) {
                C = this.j.i(this.m);
            } else {
                if (i == 9) {
                    fVar = p;
                } else if (i == 8) {
                    fVar = o;
                } else if (i == 10) {
                    C = C();
                } else {
                    if (i != 11) {
                        throw new a("Expected a double but was " + x() + " at path " + q());
                    }
                    this.k = 11;
                    parseDouble = Double.parseDouble(this.n);
                    if (!this.f || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                        this.n = null;
                        this.k = 0;
                        int[] iArr2 = this.f2459e;
                        int i3 = this.f2456b - 1;
                        iArr2[i3] = iArr2[i3] + 1;
                        return parseDouble;
                    }
                    throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + q());
                }
                C = c(fVar);
            }
            parseDouble = Double.parseDouble(this.n);
            if (!this.f) {
            }
            this.n = null;
            this.k = 0;
            int[] iArr22 = this.f2459e;
            int i32 = this.f2456b - 1;
            iArr22[i32] = iArr22[i32] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.n + " at path " + q());
        }
        this.n = C;
        this.k = 11;
    }

    public String toString() {
        return "JsonReader(" + this.i + ")";
    }

    @Override // com.airbnb.lottie.w.k0.c
    public int u() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 16) {
            long j = this.l;
            int i2 = (int) j;
            if (j == i2) {
                this.k = 0;
                int[] iArr = this.f2459e;
                int i3 = this.f2456b - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new a("Expected an int but was " + this.l + " at path " + q());
        }
        if (i == 17) {
            this.n = this.j.i(this.m);
        } else if (i == 9 || i == 8) {
            this.n = c(i == 9 ? p : o);
            try {
                int parseInt = Integer.parseInt(this.n);
                this.k = 0;
                int[] iArr2 = this.f2459e;
                int i4 = this.f2456b - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new a("Expected an int but was " + x() + " at path " + q());
        }
        this.k = 11;
        try {
            double parseDouble = Double.parseDouble(this.n);
            int i5 = (int) parseDouble;
            if (i5 == parseDouble) {
                this.n = null;
                this.k = 0;
                int[] iArr3 = this.f2459e;
                int i6 = this.f2456b - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new a("Expected an int but was " + this.n + " at path " + q());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.n + " at path " + q());
        }
    }

    @Override // com.airbnb.lottie.w.k0.c
    public String v() {
        String str;
        f fVar;
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 14) {
            str = C();
        } else {
            if (i == 13) {
                fVar = p;
            } else if (i == 12) {
                fVar = o;
            } else if (i == 15) {
                str = this.n;
            } else {
                throw new a("Expected a name but was " + x() + " at path " + q());
            }
            str = c(fVar);
        }
        this.k = 0;
        this.f2458d[this.f2456b - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.w.k0.c
    public String w() {
        String str;
        f fVar;
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        if (i == 10) {
            str = C();
        } else {
            if (i == 9) {
                fVar = p;
            } else if (i == 8) {
                fVar = o;
            } else if (i == 11) {
                str = this.n;
                this.n = null;
            } else if (i == 16) {
                str = Long.toString(this.l);
            } else if (i == 17) {
                str = this.j.i(this.m);
            } else {
                throw new a("Expected a string but was " + x() + " at path " + q());
            }
            str = c(fVar);
        }
        this.k = 0;
        int[] iArr = this.f2459e;
        int i2 = this.f2456b - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    @Override // com.airbnb.lottie.w.k0.c
    public c.b x() {
        int i = this.k;
        if (i == 0) {
            i = B();
        }
        switch (i) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.w.k0.c
    public void y() {
        f fVar;
        if (!this.g) {
            int i = this.k;
            if (i == 0) {
                i = B();
            }
            if (i == 14) {
                I();
            } else {
                if (i == 13) {
                    fVar = p;
                } else if (i == 12) {
                    fVar = o;
                } else if (i != 15) {
                    throw new a("Expected a name but was " + x() + " at path " + q());
                }
                d(fVar);
            }
            this.k = 0;
            this.f2458d[this.f2456b - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + x() + " at " + q());
    }

    @Override // com.airbnb.lottie.w.k0.c
    public void z() {
        f fVar;
        if (!this.g) {
            int i = 0;
            do {
                int i2 = this.k;
                if (i2 == 0) {
                    i2 = B();
                }
                if (i2 == 3) {
                    a(1);
                } else if (i2 == 1) {
                    a(3);
                } else {
                    if (i2 == 4) {
                        i--;
                        if (i < 0) {
                            throw new a("Expected a value but was " + x() + " at path " + q());
                        }
                    } else if (i2 == 2) {
                        i--;
                        if (i < 0) {
                            throw new a("Expected a value but was " + x() + " at path " + q());
                        }
                    } else {
                        if (i2 == 14 || i2 == 10) {
                            I();
                        } else {
                            if (i2 == 9 || i2 == 13) {
                                fVar = p;
                            } else if (i2 == 8 || i2 == 12) {
                                fVar = o;
                            } else if (i2 == 17) {
                                this.j.skip(this.m);
                            } else if (i2 == 18) {
                                throw new a("Expected a value but was " + x() + " at path " + q());
                            }
                            d(fVar);
                        }
                        this.k = 0;
                    }
                    this.f2456b--;
                    this.k = 0;
                }
                i++;
                this.k = 0;
            } while (i != 0);
            int[] iArr = this.f2459e;
            int i3 = this.f2456b;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f2458d[i3 - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + x() + " at " + q());
    }
}
