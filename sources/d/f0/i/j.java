package d.f0.i;

import d.f0.i.d;
import e.c;
import e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class j implements Closeable {
    private static final Logger h = Logger.getLogger(e.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final d f3596b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3597c;
    private boolean f;

    /* renamed from: d  reason: collision with root package name */
    private final c f3598d = new c();
    final d.b g = new d.b(this.f3598d);

    /* renamed from: e  reason: collision with root package name */
    private int f3599e = 16384;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e.d dVar, boolean z) {
        this.f3596b = dVar;
        this.f3597c = z;
    }

    private static void a(e.d dVar, int i) {
        dVar.writeByte((i >>> 16) & 255);
        dVar.writeByte((i >>> 8) & 255);
        dVar.writeByte(i & 255);
    }

    private void b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.f3599e, j);
            long j2 = min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f3596b.a(this.f3598d, j2);
        }
    }

    void a(int i, byte b2, c cVar, int i2) {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f3596b.a(cVar, i2);
        }
    }

    public void a(int i, int i2, byte b2, byte b3) {
        if (h.isLoggable(Level.FINE)) {
            h.fine(e.a(false, i, i2, b2, b3));
        }
        int i3 = this.f3599e;
        if (i2 > i3) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) == 0) {
            a(this.f3596b, i2);
            this.f3596b.writeByte(b2 & 255);
            this.f3596b.writeByte(b3 & 255);
            this.f3596b.writeInt(i & Integer.MAX_VALUE);
        } else {
            e.a("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
    }

    public synchronized void a(int i, int i2, List<c> list) {
        if (!this.f) {
            this.g.a(list);
            long r = this.f3598d.r();
            int min = (int) Math.min(this.f3599e - 4, r);
            long j = min;
            a(i, min + 4, (byte) 5, r == j ? (byte) 4 : (byte) 0);
            this.f3596b.writeInt(i2 & Integer.MAX_VALUE);
            this.f3596b.a(this.f3598d, j);
            if (r > j) {
                b(i, r - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, long j) {
        if (this.f) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            a(i, 4, (byte) 8, (byte) 0);
            this.f3596b.writeInt((int) j);
            this.f3596b.flush();
        }
    }

    public synchronized void a(int i, b bVar) {
        if (this.f) {
            throw new IOException("closed");
        } else if (bVar.f3507b != -1) {
            a(i, 4, (byte) 3, (byte) 0);
            this.f3596b.writeInt(bVar.f3507b);
            this.f3596b.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(int i, b bVar, byte[] bArr) {
        if (this.f) {
            throw new IOException("closed");
        } else if (bVar.f3507b != -1) {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f3596b.writeInt(i);
            this.f3596b.writeInt(bVar.f3507b);
            if (bArr.length > 0) {
                this.f3596b.write(bArr);
            }
            this.f3596b.flush();
        } else {
            e.a("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void a(m mVar) {
        if (!this.f) {
            this.f3599e = mVar.c(this.f3599e);
            if (mVar.b() != -1) {
                this.g.a(mVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f3596b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2) {
        if (!this.f) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f3596b.writeInt(i);
            this.f3596b.writeInt(i2);
            this.f3596b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<c> list) {
        if (!this.f) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, c cVar, int i2) {
        if (!this.f) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            a(i, b2, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    void a(boolean z, int i, List<c> list) {
        if (!this.f) {
            this.g.a(list);
            long r = this.f3598d.r();
            int min = (int) Math.min(this.f3599e, r);
            long j = min;
            byte b2 = r == j ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, min, (byte) 1, b2);
            this.f3596b.a(this.f3598d, j);
            if (r > j) {
                b(i, r - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void b(m mVar) {
        if (!this.f) {
            int i = 0;
            a(0, mVar.d() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (mVar.d(i)) {
                    this.f3596b.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f3596b.writeInt(mVar.a(i));
                }
                i++;
            }
            this.f3596b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f = true;
        this.f3596b.close();
    }

    public synchronized void flush() {
        if (!this.f) {
            this.f3596b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void m() {
        if (this.f) {
            throw new IOException("closed");
        } else if (this.f3597c) {
            if (h.isLoggable(Level.FINE)) {
                h.fine(d.f0.c.a(">> CONNECTION %s", e.f3525a.b()));
            }
            this.f3596b.write(e.f3525a.i());
            this.f3596b.flush();
        }
    }

    public int n() {
        return this.f3599e;
    }
}
