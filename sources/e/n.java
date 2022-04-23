package e;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements d {

    /* renamed from: b  reason: collision with root package name */
    public final c f3761b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final s f3762c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3763d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        if (sVar != null) {
            this.f3762c = sVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // e.d
    public c a() {
        return this.f3761b;
    }

    @Override // e.d
    public d a(long j) {
        if (!this.f3763d) {
            this.f3761b.a(j);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d a(String str) {
        if (!this.f3763d) {
            this.f3761b.a(str);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d a(String str, int i, int i2) {
        if (!this.f3763d) {
            this.f3761b.a(str, i, i2);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.s
    public void a(c cVar, long j) {
        if (!this.f3763d) {
            this.f3761b.a(cVar, j);
            d();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.s
    public u b() {
        return this.f3762c.b();
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Throwable th;
        if (!this.f3763d) {
            try {
                if (this.f3761b.f3737c > 0) {
                    this.f3762c.a(this.f3761b, this.f3761b.f3737c);
                }
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f3762c.close();
            } catch (Throwable th3) {
                th = th3;
                if (th == null) {
                }
            }
            this.f3763d = true;
            if (th != null) {
                v.a(th);
                throw null;
            }
        }
    }

    @Override // e.d
    public d d() {
        if (!this.f3763d) {
            long o = this.f3761b.o();
            if (o > 0) {
                this.f3762c.a(this.f3761b, o);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d f(long j) {
        if (!this.f3763d) {
            this.f3761b.f(j);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d, e.s, java.io.Flushable
    public void flush() {
        if (!this.f3763d) {
            c cVar = this.f3761b;
            long j = cVar.f3737c;
            if (j > 0) {
                this.f3762c.a(cVar, j);
            }
            this.f3762c.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3763d;
    }

    public String toString() {
        return "buffer(" + this.f3762c + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!this.f3763d) {
            int write = this.f3761b.write(byteBuffer);
            d();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d write(byte[] bArr) {
        if (!this.f3763d) {
            this.f3761b.write(bArr);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d write(byte[] bArr, int i, int i2) {
        if (!this.f3763d) {
            this.f3761b.write(bArr, i, i2);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d writeByte(int i) {
        if (!this.f3763d) {
            this.f3761b.writeByte(i);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d writeInt(int i) {
        if (!this.f3763d) {
            this.f3761b.writeInt(i);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    @Override // e.d
    public d writeShort(int i) {
        if (!this.f3763d) {
            this.f3761b.writeShort(i);
            d();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
