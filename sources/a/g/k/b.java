package a.g.k;

import java.io.Writer;

/* loaded from: classes.dex */
public class b extends Writer {

    /* renamed from: b  reason: collision with root package name */
    private final String f280b;

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f281c = new StringBuilder(128);

    public b(String str) {
        this.f280b = str;
    }

    private void m() {
        if (this.f281c.length() > 0) {
            this.f281c.toString();
            StringBuilder sb = this.f281c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                m();
            } else {
                this.f281c.append(c2);
            }
        }
    }
}
