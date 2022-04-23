package e;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface s extends Closeable, Flushable {
    void a(c cVar, long j);

    u b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
