package e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f3754a = Logger.getLogger(l.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements s {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f3755b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OutputStream f3756c;

        a(u uVar, OutputStream outputStream) {
            this.f3755b = uVar;
            this.f3756c = outputStream;
        }

        @Override // e.s
        public void a(e.c cVar, long j) {
            v.a(cVar.f3737c, 0L, j);
            while (j > 0) {
                this.f3755b.e();
                p pVar = cVar.f3736b;
                int min = (int) Math.min(j, pVar.f3770c - pVar.f3769b);
                this.f3756c.write(pVar.f3768a, pVar.f3769b, min);
                pVar.f3769b += min;
                long j2 = min;
                j -= j2;
                cVar.f3737c -= j2;
                if (pVar.f3769b == pVar.f3770c) {
                    cVar.f3736b = pVar.b();
                    q.a(pVar);
                }
            }
        }

        @Override // e.s
        public u b() {
            return this.f3755b;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f3756c.close();
        }

        @Override // e.s, java.io.Flushable
        public void flush() {
            this.f3756c.flush();
        }

        public String toString() {
            return "sink(" + this.f3756c + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b implements t {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f3757b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InputStream f3758c;

        b(u uVar, InputStream inputStream) {
            this.f3757b = uVar;
            this.f3758c = inputStream;
        }

        @Override // e.t
        public long b(e.c cVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (j == 0) {
                return 0L;
            } else {
                try {
                    this.f3757b.e();
                    p b2 = cVar.b(1);
                    int read = this.f3758c.read(b2.f3768a, b2.f3770c, (int) Math.min(j, 8192 - b2.f3770c));
                    if (read == -1) {
                        return -1L;
                    }
                    b2.f3770c += read;
                    long j2 = read;
                    cVar.f3737c += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        @Override // e.t
        public u b() {
            return this.f3757b;
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f3758c.close();
        }

        public String toString() {
            return "source(" + this.f3758c + ")";
        }
    }

    /* loaded from: classes.dex */
    final class c implements s {
        c() {
        }

        @Override // e.s
        public void a(e.c cVar, long j) {
            cVar.skip(j);
        }

        @Override // e.s
        public u b() {
            return u.f3775d;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // e.s, java.io.Flushable
        public void flush() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d extends e.a {
        final /* synthetic */ Socket k;

        d(Socket socket) {
            this.k = socket;
        }

        @Override // e.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.a
        protected void i() {
            StringBuilder sb;
            Level level;
            Logger logger;
            Exception exc;
            try {
                this.k.close();
            } catch (AssertionError e2) {
                if (l.a(e2)) {
                    Logger logger2 = l.f3754a;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    exc = e2;
                    logger = logger2;
                    sb.append("Failed to close timed out socket ");
                    sb.append(this.k);
                    logger.log(level, sb.toString(), (Throwable) exc);
                }
                throw e2;
            } catch (Exception e3) {
                Logger logger3 = l.f3754a;
                level = Level.WARNING;
                sb = new StringBuilder();
                exc = e3;
                logger = logger3;
                sb.append("Failed to close timed out socket ");
                sb.append(this.k);
                logger.log(level, sb.toString(), (Throwable) exc);
            }
        }
    }

    private l() {
    }

    public static e.d a(s sVar) {
        return new n(sVar);
    }

    public static e a(t tVar) {
        return new o(tVar);
    }

    public static s a() {
        return new c();
    }

    public static s a(File file) {
        if (file != null) {
            return a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s a(OutputStream outputStream) {
        return a(outputStream, new u());
    }

    private static s a(OutputStream outputStream, u uVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (uVar != null) {
            return new a(uVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static s a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            e.a c2 = c(socket);
            return c2.a(a(socket.getOutputStream(), c2));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static t a(InputStream inputStream) {
        return a(inputStream, new u());
    }

    private static t a(InputStream inputStream, u uVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (uVar != null) {
            return new b(uVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static s b(File file) {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static t b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            e.a c2 = c(socket);
            return c2.a(a(socket.getInputStream(), c2));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static e.a c(Socket socket) {
        return new d(socket);
    }

    public static t c(File file) {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }
}
