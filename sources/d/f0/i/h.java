package d.f0.i;

import d.f0.i.d;
import e.c;
import e.e;
import e.f;
import e.t;
import e.u;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Closeable {
    static final Logger f = Logger.getLogger(e.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final e f3575b;

    /* renamed from: c  reason: collision with root package name */
    private final a f3576c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3577d;

    /* renamed from: e  reason: collision with root package name */
    final d.a f3578e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements t {

        /* renamed from: b  reason: collision with root package name */
        private final e f3579b;

        /* renamed from: c  reason: collision with root package name */
        int f3580c;

        /* renamed from: d  reason: collision with root package name */
        byte f3581d;

        /* renamed from: e  reason: collision with root package name */
        int f3582e;
        int f;
        short g;

        a(e eVar) {
            this.f3579b = eVar;
        }

        private void d() {
            int i = this.f3582e;
            int a2 = h.a(this.f3579b);
            this.f = a2;
            this.f3580c = a2;
            byte readByte = (byte) (this.f3579b.readByte() & 255);
            this.f3581d = (byte) (this.f3579b.readByte() & 255);
            if (h.f.isLoggable(Level.FINE)) {
                h.f.fine(e.a(true, this.f3582e, this.f3580c, readByte, this.f3581d));
            }
            this.f3582e = this.f3579b.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (this.f3582e != i) {
                e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        @Override // e.t
        public long b(c cVar, long j) {
            while (true) {
                int i = this.f;
                if (i == 0) {
                    this.f3579b.skip(this.g);
                    this.g = (short) 0;
                    if ((this.f3581d & 4) != 0) {
                        return -1L;
                    }
                    d();
                } else {
                    long b2 = this.f3579b.b(cVar, Math.min(j, i));
                    if (b2 == -1) {
                        return -1L;
                    }
                    this.f = (int) (this.f - b2);
                    return b2;
                }
            }
        }

        @Override // e.t
        public u b() {
            return this.f3579b.b();
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list);

        void a(int i, long j);

        void a(int i, d.f0.i.b bVar);

        void a(int i, d.f0.i.b bVar, f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, e eVar, int i2);

        void a(boolean z, m mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, boolean z) {
        this.f3575b = eVar;
        this.f3577d = z;
        this.f3576c = new a(this.f3575b);
        this.f3578e = new d.a(4096, this.f3576c);
    }

    static int a(int i, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    static int a(e eVar) {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    private List<c> a(int i, short s, byte b2, int i2) {
        a aVar = this.f3576c;
        aVar.f = i;
        aVar.f3580c = i;
        aVar.g = s;
        aVar.f3581d = b2;
        aVar.f3582e = i2;
        this.f3578e.c();
        return this.f3578e.a();
    }

    private void a(b bVar, int i) {
        int readInt = this.f3575b.readInt();
        bVar.a(i, readInt & Integer.MAX_VALUE, (this.f3575b.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(b bVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.f3575b.readByte() & 255);
                }
                bVar.a(z2, i2, this.f3575b, a(i, b2, s));
                this.f3575b.skip(s);
                return;
            }
            e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    private void b(b bVar, int i, byte b2, int i2) {
        if (i < 8) {
            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f3575b.readInt();
            int readInt2 = this.f3575b.readInt();
            int i3 = i - 8;
            d.f0.i.b a2 = d.f0.i.b.a(readInt2);
            if (a2 != null) {
                f fVar = f.f;
                if (i3 > 0) {
                    fVar = this.f3575b.b(i3);
                }
                bVar.a(readInt, a2, fVar);
                return;
            }
            e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void c(b bVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.f3575b.readByte() & 255);
            }
            if ((b2 & 32) != 0) {
                a(bVar, i2);
                i -= 5;
            }
            bVar.a(z, i2, -1, a(a(i, b2, s), s, b2, i2));
            return;
        }
        e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    private void d(b bVar, int i, byte b2, int i2) {
        boolean z = false;
        if (i != 8) {
            e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f3575b.readInt();
            int readInt2 = this.f3575b.readInt();
            if ((b2 & 1) != 0) {
                z = true;
            }
            bVar.a(z, readInt, readInt2);
        } else {
            e.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void e(b bVar, int i, byte b2, int i2) {
        if (i != 5) {
            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            a(bVar, i2);
        } else {
            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.f3575b.readByte() & 255);
            }
            bVar.a(i2, this.f3575b.readInt() & Integer.MAX_VALUE, a(a(i - 4, b2, s), s, b2, i2));
            return;
        }
        e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    private void g(b bVar, int i, byte b2, int i2) {
        if (i != 4) {
            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.f3575b.readInt();
            d.f0.i.b a2 = d.f0.i.b.a(readInt);
            if (a2 != null) {
                bVar.a(i2, a2);
            } else {
                e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        } else {
            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void h(b bVar, int i, byte b2, int i2) {
        if (i2 != 0) {
            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i == 0) {
                bVar.a();
            } else {
                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i % 6 == 0) {
            m mVar = new m();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int readShort = this.f3575b.readShort() & 65535;
                int readInt = this.f3575b.readInt();
                switch (readShort) {
                    case 2:
                        if (!(readInt == 0 || readInt == 1)) {
                            e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt >= 0) {
                            break;
                        } else {
                            e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    case 5:
                        if (readInt >= 16384 && readInt <= 16777215) {
                            break;
                        } else {
                            e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                        break;
                }
                mVar.a(readShort, readInt);
            }
            bVar.a(false, mVar);
        } else {
            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
    }

    private void i(b bVar, int i, byte b2, int i2) {
        if (i == 4) {
            long readInt = this.f3575b.readInt() & 2147483647L;
            if (readInt != 0) {
                bVar.a(i2, readInt);
            } else {
                e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
                throw null;
            }
        } else {
            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
    }

    public void a(b bVar) {
        if (!this.f3577d) {
            f b2 = this.f3575b.b(e.f3525a.g());
            if (f.isLoggable(Level.FINE)) {
                f.fine(d.f0.c.a("<< CONNECTION %s", b2.b()));
            }
            if (!e.f3525a.equals(b2)) {
                e.b("Expected a connection header but was %s", b2.j());
                throw null;
            }
        } else if (!a(true, bVar)) {
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public boolean a(boolean z, b bVar) {
        try {
            this.f3575b.e(9L);
            int a2 = a(this.f3575b);
            if (a2 < 0 || a2 > 16384) {
                e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.f3575b.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f3575b.readByte() & 255);
                int readInt = this.f3575b.readInt() & Integer.MAX_VALUE;
                if (f.isLoggable(Level.FINE)) {
                    f.fine(e.a(true, readInt, a2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        a(bVar, a2, readByte2, readInt);
                        break;
                    case 1:
                        c(bVar, a2, readByte2, readInt);
                        break;
                    case 2:
                        e(bVar, a2, readByte2, readInt);
                        break;
                    case 3:
                        g(bVar, a2, readByte2, readInt);
                        break;
                    case 4:
                        h(bVar, a2, readByte2, readInt);
                        break;
                    case 5:
                        f(bVar, a2, readByte2, readInt);
                        break;
                    case 6:
                        d(bVar, a2, readByte2, readInt);
                        break;
                    case 7:
                        b(bVar, a2, readByte2, readInt);
                        break;
                    case 8:
                        i(bVar, a2, readByte2, readInt);
                        break;
                    default:
                        this.f3575b.skip(a2);
                        break;
                }
                return true;
            }
            e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3575b.close();
    }
}
