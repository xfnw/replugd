package e;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface t extends Closeable {
    long b(c cVar, long j);

    u b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
