package e;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements e {

    /* renamed from: b  reason: collision with root package name */
    public final c f3764b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final t f3765c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3766d;

    /* loaded from: classes.dex */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            o oVar = o.this;
            if (!oVar.f3766d) {
                return (int) Math.min(oVar.f3764b.f3737c, 2147483647L);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            o.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            o oVar = o.this;
            if (!oVar.f3766d) {
                c cVar = oVar.f3764b;
                if (cVar.f3737c == 0 && oVar.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return o.this.f3764b.readByte() & 255;
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!o.this.f3766d) {
                v.a(bArr.length, i, i2);
                o oVar = o.this;
                c cVar = oVar.f3764b;
                if (cVar.f3737c == 0 && oVar.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return o.this.f3764b.a(bArr, i, i2);
            }
            throw new IOException("closed");
        }

        public String toString() {
            return o.this + ".inputStream()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(t tVar) {
        if (tVar != null) {
            this.f3765c = tVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // e.e
    public int a(m mVar) {
        if (!this.f3766d) {
            do {
                int a2 = this.f3764b.a(mVar, true);
                if (a2 == -1) {
                    return -1;
                }
                if (a2 != -2) {
                    this.f3764b.skip(mVar.f3759b[a2].g());
                    return a2;
                }
            } while (this.f3765c.b(this.f3764b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        if (this.f3766d) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        } else {
            while (j < j2) {
                long a2 = this.f3764b.a(b2, j, j2);
                if (a2 == -1) {
                    c cVar = this.f3764b;
                    long j3 = cVar.f3737c;
                    if (j3 >= j2 || this.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a2;
                }
            }
            return -1L;
        }
    }

    @Override // e.e
    public long a(f fVar) {
        return b(fVar, 0L);
    }

    public long a(f fVar, long j) {
        if (!this.f3766d) {
            while (true) {
                long a2 = this.f3764b.a(fVar, j);
                if (a2 != -1) {
                    return a2;
                }
                c cVar = this.f3764b;
                long j2 = cVar.f3737c;
                if (this.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1L;
                }
                j = Math.max(j, (j2 - fVar.g()) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // e.e, e.d
    public c a() {
        return this.f3764b;
    }

    @Override // e.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.g());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (this.f3766d) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || fVar.g() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!(d(1 + j2) && this.f3764b.h(j2) == fVar.a(i + i3))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // e.t
    public long b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f3766d) {
            c cVar2 = this.f3764b;
            if (cVar2.f3737c == 0 && this.f3765c.b(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            return this.f3764b.b(cVar, Math.min(j, this.f3764b.f3737c));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // e.e
    public long b(f fVar) {
        return a(fVar, 0L);
    }

    public long b(f fVar, long j) {
        if (!this.f3766d) {
            while (true) {
                long b2 = this.f3764b.b(fVar, j);
                if (b2 != -1) {
                    return b2;
                }
                c cVar = this.f3764b;
                long j2 = cVar.f3737c;
                if (this.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1L;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // e.e
    public f b(long j) {
        e(j);
        return this.f3764b.b(j);
    }

    @Override // e.t
    public u b() {
        return this.f3765c.b();
    }

    @Override // e.e
    public String c(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return this.f3764b.j(a2);
            }
            if (j2 < Long.MAX_VALUE && d(j2) && this.f3764b.h(j2 - 1) == 13 && d(1 + j2) && this.f3764b.h(j2) == 10) {
                return this.f3764b.j(j2);
            }
            c cVar = new c();
            c cVar2 = this.f3764b;
            cVar2.a(cVar, 0L, Math.min(32L, cVar2.r()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f3764b.r(), j) + " content=" + cVar.p().b() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // e.e
    public short c() {
        e(2L);
        return this.f3764b.c();
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3766d) {
            this.f3766d = true;
            this.f3765c.close();
            this.f3764b.n();
        }
    }

    @Override // e.e
    public boolean d(long j) {
        c cVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f3766d) {
            do {
                cVar = this.f3764b;
                if (cVar.f3737c >= j) {
                    return true;
                }
            } while (this.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // e.e
    public long e() {
        byte h;
        e(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!d(i2)) {
                break;
            }
            h = this.f3764b.h(i);
            if ((h < 48 || h > 57) && !(i == 0 && h == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(h)));
        }
        return this.f3764b.e();
    }

    @Override // e.e
    public void e(long j) {
        if (!d(j)) {
            throw new EOFException();
        }
    }

    @Override // e.e
    public String f() {
        return c(Long.MAX_VALUE);
    }

    @Override // e.e
    public byte[] g() {
        this.f3764b.a(this.f3765c);
        return this.f3764b.g();
    }

    @Override // e.e
    public byte[] g(long j) {
        e(j);
        return this.f3764b.g(j);
    }

    @Override // e.e
    public int h() {
        e(4L);
        return this.f3764b.h();
    }

    @Override // e.e
    public c i() {
        return this.f3764b;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3766d;
    }

    @Override // e.e
    public boolean j() {
        if (!this.f3766d) {
            return this.f3764b.j() && this.f3765c.b(this.f3764b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r1 == 0) goto L_0x0035;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long k() {
        /*
            r6 = this;
            r0 = 1
            r6.e(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.d(r3)
            if (r3 == 0) goto L_0x004a
            e.c r3 = r6.f3764b
            long r4 = (long) r1
            byte r3 = r3.h(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0030
        L_0x001f:
            r4 = 97
            if (r3 < r4) goto L_0x0027
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L_0x0030
        L_0x0027:
            r4 = 65
            if (r3 < r4) goto L_0x0032
            r4 = 70
            if (r3 <= r4) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r1 = r2
            goto L_0x0007
        L_0x0032:
            if (r1 == 0) goto L_0x0035
            goto L_0x004a
        L_0x0035:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x004a:
            e.c r0 = r6.f3764b
            long r0 = r0.k()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.o.k():long");
    }

    @Override // e.e
    public InputStream l() {
        return new a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f3764b;
        if (cVar.f3737c == 0 && this.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f3764b.read(byteBuffer);
    }

    @Override // e.e
    public byte readByte() {
        e(1L);
        return this.f3764b.readByte();
    }

    @Override // e.e
    public void readFully(byte[] bArr) {
        try {
            e(bArr.length);
            this.f3764b.readFully(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (true) {
                c cVar = this.f3764b;
                long j = cVar.f3737c;
                if (j > 0) {
                    int a2 = cVar.a(bArr, i, (int) j);
                    if (a2 != -1) {
                        i += a2;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e2;
                }
            }
        }
    }

    @Override // e.e
    public int readInt() {
        e(4L);
        return this.f3764b.readInt();
    }

    @Override // e.e
    public short readShort() {
        e(2L);
        return this.f3764b.readShort();
    }

    @Override // e.e
    public void skip(long j) {
        if (!this.f3766d) {
            while (j > 0) {
                c cVar = this.f3764b;
                if (cVar.f3737c == 0 && this.f3765c.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f3764b.r());
                this.f3764b.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.f3765c + ")";
    }
}
