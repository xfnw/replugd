package e;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes.dex */
public interface e extends t, ReadableByteChannel {
    int a(m mVar);

    long a(byte b2);

    long a(f fVar);

    @Deprecated
    c a();

    boolean a(long j, f fVar);

    long b(f fVar);

    f b(long j);

    String c(long j);

    short c();

    boolean d(long j);

    long e();

    void e(long j);

    String f();

    byte[] g();

    byte[] g(long j);

    int h();

    c i();

    boolean j();

    long k();

    InputStream l();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    void skip(long j);
}
