package e;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class j implements t {

    /* renamed from: c  reason: collision with root package name */
    private final e f3747c;

    /* renamed from: d  reason: collision with root package name */
    private final Inflater f3748d;

    /* renamed from: e  reason: collision with root package name */
    private final k f3749e;

    /* renamed from: b  reason: collision with root package name */
    private int f3746b = 0;
    private final CRC32 f = new CRC32();

    public j(t tVar) {
        if (tVar != null) {
            this.f3748d = new Inflater(true);
            this.f3747c = l.a(tVar);
            this.f3749e = new k(this.f3747c, this.f3748d);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(c cVar, long j, long j2) {
        int i;
        p pVar = cVar.f3736b;
        while (true) {
            int i2 = pVar.f3770c;
            int i3 = pVar.f3769b;
            if (j >= i2 - i3) {
                j -= i2 - i3;
                pVar = pVar.f;
            }
        }
        while (j2 > 0) {
            int min = (int) Math.min(pVar.f3770c - i, j2);
            this.f.update(pVar.f3768a, (int) (pVar.f3769b + j), min);
            j2 -= min;
            pVar = pVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    private void d() {
        this.f3747c.e(10L);
        byte h = this.f3747c.a().h(3L);
        boolean z = ((h >> 1) & 1) == 1;
        if (z) {
            a(this.f3747c.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f3747c.readShort());
        this.f3747c.skip(8L);
        if (((h >> 2) & 1) == 1) {
            this.f3747c.e(2L);
            if (z) {
                a(this.f3747c.a(), 0L, 2L);
            }
            long c2 = this.f3747c.a().c();
            this.f3747c.e(c2);
            if (z) {
                a(this.f3747c.a(), 0L, c2);
            }
            this.f3747c.skip(c2);
        }
        if (((h >> 3) & 1) == 1) {
            long a2 = this.f3747c.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f3747c.a(), 0L, a2 + 1);
                }
                this.f3747c.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((h >> 4) & 1) == 1) {
            long a3 = this.f3747c.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f3747c.a(), 0L, a3 + 1);
                }
                this.f3747c.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f3747c.c(), (short) this.f.getValue());
            this.f.reset();
        }
    }

    private void m() {
        a("CRC", this.f3747c.h(), (int) this.f.getValue());
        a("ISIZE", this.f3747c.h(), (int) this.f3748d.getBytesWritten());
    }

    @Override // e.t
    public long b(c cVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0L;
        } else {
            if (this.f3746b == 0) {
                d();
                this.f3746b = 1;
            }
            if (this.f3746b == 1) {
                long j2 = cVar.f3737c;
                long b2 = this.f3749e.b(cVar, j);
                if (b2 != -1) {
                    a(cVar, j2, b2);
                    return b2;
                }
                this.f3746b = 2;
            }
            if (this.f3746b == 2) {
                m();
                this.f3746b = 3;
                if (!this.f3747c.j()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // e.t
    public u b() {
        return this.f3747c.b();
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3749e.close();
    }
}
