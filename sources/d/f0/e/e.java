package d.f0.e;

import e.c;
import e.g;
import e.s;
import java.io.IOException;

/* loaded from: classes.dex */
class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private boolean f3442c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(s sVar) {
        super(sVar);
    }

    @Override // e.g, e.s
    public void a(c cVar, long j) {
        if (this.f3442c) {
            cVar.skip(j);
            return;
        }
        try {
            super.a(cVar, j);
        } catch (IOException e2) {
            this.f3442c = true;
            a(e2);
        }
    }

    protected void a(IOException iOException) {
        throw null;
    }

    @Override // e.g, e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f3442c) {
            try {
                super.close();
            } catch (IOException e2) {
                this.f3442c = true;
                a(e2);
            }
        }
    }

    @Override // e.g, e.s, java.io.Flushable
    public void flush() {
        if (!this.f3442c) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.f3442c = true;
                a(e2);
            }
        }
    }
}
