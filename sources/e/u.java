package e;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class u {

    /* renamed from: d  reason: collision with root package name */
    public static final u f3775d = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3776a;

    /* renamed from: b  reason: collision with root package name */
    private long f3777b;

    /* renamed from: c  reason: collision with root package name */
    private long f3778c;

    /* loaded from: classes.dex */
    final class a extends u {
        a() {
        }

        @Override // e.u
        public u a(long j) {
            return this;
        }

        @Override // e.u
        public u a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // e.u
        public void e() {
        }
    }

    public u a() {
        this.f3776a = false;
        return this;
    }

    public u a(long j) {
        this.f3776a = true;
        this.f3777b = j;
        return this;
    }

    public u a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit != null) {
            this.f3778c = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public u b() {
        this.f3778c = 0L;
        return this;
    }

    public long c() {
        if (this.f3776a) {
            return this.f3777b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.f3776a;
    }

    public void e() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f3776a && this.f3777b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long f() {
        return this.f3778c;
    }
}
