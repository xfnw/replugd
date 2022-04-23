package e;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface d extends s, WritableByteChannel {
    c a();

    d a(long j);

    d a(String str);

    d a(String str, int i, int i2);

    d d();

    d f(long j);

    @Override // e.s, java.io.Flushable
    void flush();

    d write(byte[] bArr);

    d write(byte[] bArr, int i, int i2);

    d writeByte(int i);

    d writeInt(int i);

    d writeShort(int i);
}
