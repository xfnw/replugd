package e;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f3735d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b  reason: collision with root package name */
    p f3736b;

    /* renamed from: c  reason: collision with root package name */
    long f3737c;

    /* loaded from: classes.dex */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f3737c, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f3737c > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return c.this.a(bArr, i, i2);
        }

        public String toString() {
            return c.this + ".inputStream()";
        }
    }

    private boolean a(p pVar, int i, f fVar, int i2, int i3) {
        int i4 = pVar.f3770c;
        byte[] bArr = pVar.f3768a;
        while (i2 < i3) {
            if (i == i4) {
                pVar = pVar.f;
                bArr = pVar.f3768a;
                i = pVar.f3769b;
                i4 = pVar.f3770c;
            }
            if (bArr[i] != fVar.a(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // e.e
    public int a(m mVar) {
        int a2 = a(mVar, false);
        if (a2 == -1) {
            return -1;
        }
        try {
            skip(mVar.f3759b[a2].g());
            return a2;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        if (r19 == false) goto L_0x005b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(e.m r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            e.p r2 = r1.f3736b
            r3 = -2
            if (r2 != 0) goto L_0x0013
            if (r19 == 0) goto L_0x000c
            return r3
        L_0x000c:
            e.f r2 = e.f.f
            int r0 = r0.indexOf(r2)
            return r0
        L_0x0013:
            byte[] r4 = r2.f3768a
            int r5 = r2.f3769b
            int r6 = r2.f3770c
            int[] r0 = r0.f3760c
            r7 = 0
            r8 = -1
            r9 = r5
            r11 = r6
            r10 = -1
            r5 = r2
            r6 = r4
            r4 = 0
        L_0x0023:
            int r12 = r4 + 1
            r4 = r0[r4]
            int r13 = r12 + 1
            r12 = r0[r12]
            if (r12 == r8) goto L_0x002e
            r10 = r12
        L_0x002e:
            if (r5 != 0) goto L_0x0031
            goto L_0x0058
        L_0x0031:
            r12 = 0
            if (r4 >= 0) goto L_0x006c
            int r4 = r4 * (-1)
            int r14 = r13 + r4
        L_0x0038:
            int r4 = r9 + 1
            r9 = r6[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r15 = r13 + 1
            r13 = r0[r13]
            if (r9 == r13) goto L_0x0045
            return r10
        L_0x0045:
            if (r15 != r14) goto L_0x0049
            r9 = 1
            goto L_0x004a
        L_0x0049:
            r9 = 0
        L_0x004a:
            if (r4 != r11) goto L_0x0064
            e.p r4 = r5.f
            int r5 = r4.f3769b
            byte[] r6 = r4.f3768a
            int r11 = r4.f3770c
            if (r4 != r2) goto L_0x005f
            if (r9 != 0) goto L_0x005c
        L_0x0058:
            if (r19 == 0) goto L_0x005b
            return r3
        L_0x005b:
            return r10
        L_0x005c:
            r4 = r5
            r5 = r12
            goto L_0x0064
        L_0x005f:
            r16 = r5
            r5 = r4
            r4 = r16
        L_0x0064:
            if (r9 == 0) goto L_0x0069
            r9 = r0[r15]
            goto L_0x0091
        L_0x0069:
            r9 = r4
            r13 = r15
            goto L_0x0038
        L_0x006c:
            int r14 = r9 + 1
            r9 = r6[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r15 = r13 + r4
        L_0x0074:
            if (r13 != r15) goto L_0x0077
            return r10
        L_0x0077:
            r3 = r0[r13]
            if (r9 != r3) goto L_0x0099
            int r13 = r13 + r4
            r9 = r0[r13]
            if (r14 != r11) goto L_0x0090
            e.p r3 = r5.f
            int r4 = r3.f3769b
            byte[] r5 = r3.f3768a
            int r6 = r3.f3770c
            r11 = r6
            r6 = r5
            if (r3 != r2) goto L_0x008e
            r5 = r12
            goto L_0x0091
        L_0x008e:
            r5 = r3
            goto L_0x0091
        L_0x0090:
            r4 = r14
        L_0x0091:
            if (r9 < 0) goto L_0x0094
            return r9
        L_0x0094:
            int r3 = -r9
            r9 = r4
            r4 = r3
            r3 = -2
            goto L_0x0023
        L_0x0099:
            int r13 = r13 + 1
            r3 = -2
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a(e.m, boolean):int");
    }

    public int a(byte[] bArr, int i, int i2) {
        v.a(bArr.length, i, i2);
        p pVar = this.f3736b;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(i2, pVar.f3770c - pVar.f3769b);
        System.arraycopy(pVar.f3768a, pVar.f3769b, bArr, i, min);
        pVar.f3769b += min;
        this.f3737c -= min;
        if (pVar.f3769b == pVar.f3770c) {
            this.f3736b = pVar.b();
            q.a(pVar);
        }
        return min;
    }

    @Override // e.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        p pVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f3737c), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.f3737c;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (pVar = this.f3736b) == null) {
            return -1L;
        }
        j3 = this.f3737c;
        if (j3 - j >= j) {
            while (true) {
                j3 = (pVar.f3770c - pVar.f3769b) + j3;
                if (j3 >= j) {
                    break;
                }
                pVar = pVar.f;
            }
        } else {
            while (j3 > j) {
                pVar = pVar.g;
                j3 -= pVar.f3770c - pVar.f3769b;
            }
        }
        long j5 = j;
        while (j3 < j4) {
            byte[] bArr = pVar.f3768a;
            int min = (int) Math.min(pVar.f3770c, (pVar.f3769b + j4) - j3);
            for (int i = (int) ((pVar.f3769b + j5) - j3); i < min; i++) {
                if (bArr[i] == b2) {
                    return (i - pVar.f3769b) + j3;
                }
            }
            j5 = (pVar.f3770c - pVar.f3769b) + j3;
            pVar = pVar.f;
            j3 = j5;
        }
        return -1L;
    }

    @Override // e.e
    public long a(f fVar) {
        return b(fVar, 0L);
    }

    public long a(f fVar, long j) {
        if (fVar.g() != 0) {
            long j2 = 0;
            if (j >= 0) {
                p pVar = this.f3736b;
                long j3 = -1;
                if (pVar == null) {
                    return -1L;
                }
                j2 = this.f3737c;
                if (j2 - j >= j) {
                    while (true) {
                        j2 = (pVar.f3770c - pVar.f3769b) + j2;
                        if (j2 >= j) {
                            break;
                        }
                        pVar = pVar.f;
                    }
                } else {
                    while (j2 > j) {
                        pVar = pVar.g;
                        j2 -= pVar.f3770c - pVar.f3769b;
                    }
                }
                byte a2 = fVar.a(0);
                int g = fVar.g();
                long j4 = 1 + (this.f3737c - g);
                long j5 = j;
                while (j2 < j4) {
                    byte[] bArr = pVar.f3768a;
                    int min = (int) Math.min(pVar.f3770c, (pVar.f3769b + j4) - j2);
                    for (int i = (int) ((pVar.f3769b + j5) - j2); i < min; i++) {
                        if (bArr[i] == a2) {
                            bArr = bArr;
                            pVar = pVar;
                            if (a(pVar, i + 1, fVar, 1, g)) {
                                return (i - pVar.f3769b) + j2;
                            }
                        } else {
                            bArr = bArr;
                            pVar = pVar;
                        }
                    }
                    j5 = (pVar.f3770c - pVar.f3769b) + j2;
                    pVar = pVar.f;
                    j3 = -1;
                    j2 = j5;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long a(t tVar) {
        if (tVar != null) {
            long j = 0;
            while (true) {
                long b2 = tVar.b(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (b2 == -1) {
                    return j;
                }
                j += b2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    @Override // e.e, e.d
    public c a() {
        return this;
    }

    @Override // e.d
    public c a(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        p b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f3768a;
        int i = b2.f3770c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f3735d[(int) (15 & j)];
            j >>>= 4;
        }
        b2.f3770c += numberOfTrailingZeros;
        this.f3737c += numberOfTrailingZeros;
        return this;
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            v.a(this.f3737c, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f3737c += j2;
            p pVar = this.f3736b;
            while (true) {
                int i = pVar.f3770c;
                int i2 = pVar.f3769b;
                if (j >= i - i2) {
                    j -= i - i2;
                    pVar = pVar.f;
                }
            }
            while (j2 > 0) {
                p c2 = pVar.c();
                c2.f3769b = (int) (c2.f3769b + j);
                c2.f3770c = Math.min(c2.f3769b + ((int) j2), c2.f3770c);
                p pVar2 = cVar.f3736b;
                if (pVar2 == null) {
                    c2.g = c2;
                    c2.f = c2;
                    cVar.f3736b = c2;
                } else {
                    pVar2.g.a(c2);
                }
                j2 -= c2.f3770c - c2.f3769b;
                pVar = pVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // e.d
    public c a(String str) {
        a(str, 0, str.length());
        return this;
    }

    @Override // e.d
    public c a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    p b2 = b(1);
                    byte[] bArr = b2.f3768a;
                    int i4 = b2.f3770c - i;
                    int min = Math.min(i2, 8192 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        i5++;
                        bArr[i5 + i4] = (byte) charAt2;
                    }
                    int i6 = b2.f3770c;
                    int i7 = (i4 + i5) - i6;
                    b2.f3770c = i6 + i7;
                    this.f3737c += i7;
                    i = i5;
                } else {
                    if (charAt < 2048) {
                        i3 = (charAt >> 6) | 192;
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> '\f') | 224);
                        i3 = ((charAt >> 6) & 63) | 128;
                    } else {
                        int i8 = i + 1;
                        char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i8;
                        } else {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i9 >> 18) | 240);
                            writeByte(((i9 >> 12) & 63) | 128);
                            writeByte(((i9 >> 6) & 63) | 128);
                            writeByte((i9 & 63) | 128);
                            i += 2;
                        }
                    }
                    writeByte(i3);
                    writeByte((charAt & '?') | 128);
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(v.f3779a)) {
            a(str, i, i2);
            return this;
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    public final f a(int i) {
        return i == 0 ? f.f : new r(this, i);
    }

    public String a(long j, Charset charset) {
        v.a(this.f3737c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            p pVar = this.f3736b;
            int i = pVar.f3769b;
            if (i + j > pVar.f3770c) {
                return new String(g(j), charset);
            }
            String str = new String(pVar.f3768a, i, (int) j, charset);
            pVar.f3769b = (int) (pVar.f3769b + j);
            this.f3737c -= j;
            if (pVar.f3769b == pVar.f3770c) {
                this.f3736b = pVar.b();
                q.a(pVar);
            }
            return str;
        }
    }

    @Override // e.s
    public void a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            v.a(cVar.f3737c, 0L, j);
            while (j > 0) {
                p pVar = cVar.f3736b;
                if (j < pVar.f3770c - pVar.f3769b) {
                    p pVar2 = this.f3736b;
                    p pVar3 = pVar2 != null ? pVar2.g : null;
                    if (pVar3 != null && pVar3.f3772e) {
                        if ((pVar3.f3770c + j) - (pVar3.f3771d ? 0 : pVar3.f3769b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            cVar.f3736b.a(pVar3, (int) j);
                            cVar.f3737c -= j;
                            this.f3737c += j;
                            return;
                        }
                    }
                    cVar.f3736b = cVar.f3736b.a((int) j);
                }
                p pVar4 = cVar.f3736b;
                long j2 = pVar4.f3770c - pVar4.f3769b;
                cVar.f3736b = pVar4.b();
                p pVar5 = this.f3736b;
                if (pVar5 == null) {
                    this.f3736b = pVar4;
                    p pVar6 = this.f3736b;
                    pVar6.g = pVar6;
                    pVar6.f = pVar6;
                } else {
                    pVar5.g.a(pVar4);
                    pVar4.a();
                }
                cVar.f3737c -= j2;
                this.f3737c += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    @Override // e.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.g());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f3737c - j < i2 || fVar.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (h(i3 + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // e.t
    public long b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f3737c;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    @Override // e.e
    public long b(f fVar) {
        return a(fVar, 0L);
    }

    public long b(f fVar, long j) {
        int i;
        long j2 = 0;
        if (j >= 0) {
            p pVar = this.f3736b;
            if (pVar == null) {
                return -1L;
            }
            j2 = this.f3737c;
            if (j2 - j >= j) {
                while (true) {
                    j2 = (pVar.f3770c - pVar.f3769b) + j2;
                    if (j2 >= j) {
                        break;
                    }
                    pVar = pVar.f;
                }
            } else {
                while (j2 > j) {
                    pVar = pVar.g;
                    j2 -= pVar.f3770c - pVar.f3769b;
                }
            }
            if (fVar.g() == 2) {
                byte a2 = fVar.a(0);
                byte a3 = fVar.a(1);
                while (j2 < this.f3737c) {
                    byte[] bArr = pVar.f3768a;
                    i = (int) ((pVar.f3769b + j) - j2);
                    int i2 = pVar.f3770c;
                    while (i < i2) {
                        byte b2 = bArr[i];
                        if (!(b2 == a2 || b2 == a3)) {
                            i++;
                        }
                        return (i - pVar.f3769b) + j2;
                    }
                    j = (pVar.f3770c - pVar.f3769b) + j2;
                    pVar = pVar.f;
                    j2 = j;
                }
                return -1L;
            }
            byte[] c2 = fVar.c();
            while (j2 < this.f3737c) {
                byte[] bArr2 = pVar.f3768a;
                i = (int) ((pVar.f3769b + j) - j2);
                int i3 = pVar.f3770c;
                while (i < i3) {
                    byte b3 = bArr2[i];
                    for (byte b4 : c2) {
                        if (b3 == b4) {
                            return (i - pVar.f3769b) + j2;
                        }
                    }
                    i++;
                }
                j = (pVar.f3770c - pVar.f3769b) + j2;
                pVar = pVar.f;
                j2 = j;
            }
            return -1L;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // e.e
    public f b(long j) {
        return new f(g(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p b(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        p pVar = this.f3736b;
        if (pVar == null) {
            this.f3736b = q.a();
            p pVar2 = this.f3736b;
            pVar2.g = pVar2;
            pVar2.f = pVar2;
            return pVar2;
        }
        p pVar3 = pVar.g;
        if (pVar3.f3770c + i <= 8192 && pVar3.f3772e) {
            return pVar3;
        }
        p a2 = q.a();
        pVar3.a(a2);
        return a2;
    }

    @Override // e.t
    public u b() {
        return u.f3775d;
    }

    public c c(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        writeByte(63);
                        return this;
                    }
                } else if (i <= 1114111) {
                    writeByte((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                writeByte(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            writeByte(i3);
            i = (i & 63) | 128;
        }
        writeByte(i);
        return this;
    }

    public c c(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // e.e
    public String c(long j) {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return j(a2);
            }
            if (j2 < r() && h(j2 - 1) == 13 && h(j2) == 10) {
                return j(j2);
            }
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, r()));
            throw new EOFException("\\n not found: limit=" + Math.min(r(), j) + " content=" + cVar.p().b() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // e.e
    public short c() {
        return v.a(readShort());
    }

    public c clone() {
        c cVar = new c();
        if (this.f3737c == 0) {
            return cVar;
        }
        cVar.f3736b = this.f3736b.c();
        p pVar = cVar.f3736b;
        pVar.g = pVar;
        pVar.f = pVar;
        p pVar2 = this.f3736b;
        while (true) {
            pVar2 = pVar2.f;
            if (pVar2 != this.f3736b) {
                cVar.f3736b.g.a(pVar2.c());
            } else {
                cVar.f3737c = this.f3737c;
                return cVar;
            }
        }
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.d
    public c d() {
        return this;
    }

    @Override // e.e
    public boolean d(long j) {
        return this.f3737c >= j;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac A[EDGE_INSN: B:44:0x00ac->B:38:0x00ac ?: BREAK  , SYNTHETIC] */
    @Override // e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long e() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f3737c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b7
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0010:
            e.p r10 = r0.f3736b
            byte[] r11 = r10.f3768a
            int r12 = r10.f3769b
            int r13 = r10.f3770c
        L_0x0018:
            if (r12 >= r13) goto L_0x0098
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006a
            r1 = 57
            if (r15 > r1) goto L_0x006a
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L_0x0038
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0074
        L_0x003f:
            e.c r1 = new e.c
            r1.<init>()
            r1.f(r3)
            r1.writeByte(r15)
            if (r5 != 0) goto L_0x004f
            r1.readByte()
        L_0x004f:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.q()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006a:
            r1 = 45
            if (r15 != r1) goto L_0x0079
            if (r7 != 0) goto L_0x0079
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L_0x0074:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L_0x0018
        L_0x0079:
            if (r7 == 0) goto L_0x007d
            r6 = 1
            goto L_0x0098
        L_0x007d:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0098:
            if (r12 != r13) goto L_0x00a4
            e.p r1 = r10.b()
            r0.f3736b = r1
            e.q.a(r10)
            goto L_0x00a6
        L_0x00a4:
            r10.f3769b = r12
        L_0x00a6:
            if (r6 != 0) goto L_0x00ac
            e.p r1 = r0.f3736b
            if (r1 != 0) goto L_0x0010
        L_0x00ac:
            long r1 = r0.f3737c
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.f3737c = r1
            if (r5 == 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            long r3 = -r3
        L_0x00b6:
            return r3
        L_0x00b7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00c0
        L_0x00bf:
            throw r1
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e():long");
    }

    @Override // e.e
    public void e(long j) {
        if (this.f3737c < j) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f3737c;
        if (j != cVar.f3737c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        p pVar = this.f3736b;
        p pVar2 = cVar.f3736b;
        int i = pVar.f3769b;
        int i2 = pVar2.f3769b;
        while (j2 < this.f3737c) {
            long min = Math.min(pVar.f3770c - i, pVar2.f3770c - i2);
            int i3 = i2;
            int i4 = i;
            for (int i5 = 0; i5 < min; i5++) {
                i4++;
                i3++;
                if (pVar.f3768a[i4] != pVar2.f3768a[i3]) {
                    return false;
                }
            }
            if (i4 == pVar.f3770c) {
                pVar = pVar.f;
                i = pVar.f3769b;
            } else {
                i = i4;
            }
            if (i3 == pVar2.f3770c) {
                pVar2 = pVar2.f;
                i2 = pVar2.f3769b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    @Override // e.d
    public c f(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                a("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        p b2 = b(i);
        byte[] bArr = b2.f3768a;
        int i2 = b2.f3770c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f3735d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        b2.f3770c += i;
        this.f3737c += i;
        return this;
    }

    @Override // e.e
    public String f() {
        return c(Long.MAX_VALUE);
    }

    @Override // e.d, e.s, java.io.Flushable
    public void flush() {
    }

    @Override // e.e
    public byte[] g() {
        try {
            return g(this.f3737c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // e.e
    public byte[] g(long j) {
        v.a(this.f3737c, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public final byte h(long j) {
        int i;
        v.a(this.f3737c, j, 1L);
        long j2 = this.f3737c;
        if (j2 - j > j) {
            p pVar = this.f3736b;
            while (true) {
                int i2 = pVar.f3770c;
                int i3 = pVar.f3769b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return pVar.f3768a[i3 + ((int) j)];
                }
                j -= j3;
                pVar = pVar.f;
            }
        } else {
            long j4 = j - j2;
            p pVar2 = this.f3736b;
            do {
                pVar2 = pVar2.g;
                int i4 = pVar2.f3770c;
                i = pVar2.f3769b;
                j4 += i4 - i;
            } while (j4 < 0);
            return pVar2.f3768a[i + ((int) j4)];
        }
    }

    @Override // e.e
    public int h() {
        return v.a(readInt());
    }

    public int hashCode() {
        p pVar = this.f3736b;
        if (pVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = pVar.f3770c;
            for (int i3 = pVar.f3769b; i3 < i2; i3++) {
                i = (i * 31) + pVar.f3768a[i3];
            }
            pVar = pVar.f;
        } while (pVar != this.f3736b);
        return i;
    }

    @Override // e.e
    public c i() {
        return this;
    }

    public String i(long j) {
        return a(j, v.f3779a);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j(long j) {
        String i;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (h(j3) == 13) {
                i = i(j3);
                j2 = 2;
                skip(j2);
                return i;
            }
        }
        i = i(j);
        skip(j2);
        return i;
    }

    @Override // e.e
    public boolean j() {
        return this.f3737c == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[EDGE_INSN: B:42:0x00a3->B:38:0x00a3 ?: BREAK  , SYNTHETIC] */
    @Override // e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long k() {
        /*
            r15 = this;
            long r0 = r15.f3737c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00aa
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            e.p r6 = r15.f3736b
            byte[] r7 = r6.f3768a
            int r8 = r6.f3769b
            int r9 = r6.f3770c
        L_0x0013:
            if (r8 >= r9) goto L_0x008f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + (-48)
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + (-97)
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0070
            r11 = 70
            if (r10 > r11) goto L_0x0070
            int r11 = r10 + (-65)
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L_0x0013
        L_0x004a:
            e.c r0 = new e.c
            r0.<init>()
            r0.a(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.q()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r1 == 0) goto L_0x0074
            r0 = 1
            goto L_0x008f
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008f:
            if (r8 != r9) goto L_0x009b
            e.p r7 = r6.b()
            r15.f3736b = r7
            e.q.a(r6)
            goto L_0x009d
        L_0x009b:
            r6.f3769b = r8
        L_0x009d:
            if (r0 != 0) goto L_0x00a3
            e.p r6 = r15.f3736b
            if (r6 != 0) goto L_0x000b
        L_0x00a3:
            long r2 = r15.f3737c
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f3737c = r2
            return r4
        L_0x00aa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b3
        L_0x00b2:
            throw r0
        L_0x00b3:
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.k():long");
    }

    @Override // e.e
    public InputStream l() {
        return new a();
    }

    public final void n() {
        try {
            skip(this.f3737c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long o() {
        long j = this.f3737c;
        if (j == 0) {
            return 0L;
        }
        p pVar = this.f3736b.g;
        int i = pVar.f3770c;
        return (i >= 8192 || !pVar.f3772e) ? j : j - (i - pVar.f3769b);
    }

    public f p() {
        return new f(g());
    }

    public String q() {
        try {
            return a(this.f3737c, v.f3779a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final long r() {
        return this.f3737c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        p pVar = this.f3736b;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), pVar.f3770c - pVar.f3769b);
        byteBuffer.put(pVar.f3768a, pVar.f3769b, min);
        pVar.f3769b += min;
        this.f3737c -= min;
        if (pVar.f3769b == pVar.f3770c) {
            this.f3736b = pVar.b();
            q.a(pVar);
        }
        return min;
    }

    @Override // e.e
    public byte readByte() {
        long j = this.f3737c;
        if (j != 0) {
            p pVar = this.f3736b;
            int i = pVar.f3769b;
            int i2 = pVar.f3770c;
            int i3 = i + 1;
            byte b2 = pVar.f3768a[i];
            this.f3737c = j - 1;
            if (i3 == i2) {
                this.f3736b = pVar.b();
                q.a(pVar);
            } else {
                pVar.f3769b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // e.e
    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // e.e
    public int readInt() {
        long j = this.f3737c;
        if (j >= 4) {
            p pVar = this.f3736b;
            int i = pVar.f3769b;
            int i2 = pVar.f3770c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = pVar.f3768a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.f3737c = j - 4;
            if (i8 == i2) {
                this.f3736b = pVar.b();
                q.a(pVar);
            } else {
                pVar.f3769b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.f3737c);
    }

    @Override // e.e
    public short readShort() {
        long j = this.f3737c;
        if (j >= 2) {
            p pVar = this.f3736b;
            int i = pVar.f3769b;
            int i2 = pVar.f3770c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = pVar.f3768a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f3737c = j - 2;
            if (i4 == i2) {
                this.f3736b = pVar.b();
                q.a(pVar);
            } else {
                pVar.f3769b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.f3737c);
    }

    public final f s() {
        long j = this.f3737c;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f3737c);
    }

    @Override // e.e
    public void skip(long j) {
        p pVar;
        while (j > 0) {
            if (this.f3736b != null) {
                int min = (int) Math.min(j, pVar.f3770c - pVar.f3769b);
                long j2 = min;
                this.f3737c -= j2;
                j -= j2;
                p pVar2 = this.f3736b;
                pVar2.f3769b += min;
                if (pVar2.f3769b == pVar2.f3770c) {
                    this.f3736b = pVar2.b();
                    q.a(pVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public String toString() {
        return s().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                p b2 = b(1);
                int min = Math.min(i, 8192 - b2.f3770c);
                byteBuffer.get(b2.f3768a, b2.f3770c, min);
                i -= min;
                b2.f3770c += min;
            }
            this.f3737c += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // e.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // e.d
    public c write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            v.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                p b2 = b(1);
                int min = Math.min(i3 - i, 8192 - b2.f3770c);
                System.arraycopy(bArr, i, b2.f3768a, b2.f3770c, min);
                i += min;
                b2.f3770c += min;
            }
            this.f3737c += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // e.d
    public c writeByte(int i) {
        p b2 = b(1);
        byte[] bArr = b2.f3768a;
        int i2 = b2.f3770c;
        b2.f3770c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f3737c++;
        return this;
    }

    @Override // e.d
    public c writeInt(int i) {
        p b2 = b(4);
        byte[] bArr = b2.f3768a;
        int i2 = b2.f3770c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        b2.f3770c = i5 + 1;
        this.f3737c += 4;
        return this;
    }

    @Override // e.d
    public c writeShort(int i) {
        p b2 = b(2);
        byte[] bArr = b2.f3768a;
        int i2 = b2.f3770c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        b2.f3770c = i3 + 1;
        this.f3737c += 2;
        return this;
    }
}
