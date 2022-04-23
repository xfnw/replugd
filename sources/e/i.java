package e;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class i extends u {

    /* renamed from: e  reason: collision with root package name */
    private u f3745e;

    public i(u uVar) {
        if (uVar != null) {
            this.f3745e = uVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final i a(u uVar) {
        if (uVar != null) {
            this.f3745e = uVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // e.u
    public u a() {
        return this.f3745e.a();
    }

    @Override // e.u
    public u a(long j) {
        return this.f3745e.a(j);
    }

    @Override // e.u
    public u a(long j, TimeUnit timeUnit) {
        return this.f3745e.a(j, timeUnit);
    }

    @Override // e.u
    public u b() {
        return this.f3745e.b();
    }

    @Override // e.u
    public long c() {
        return this.f3745e.c();
    }

    @Override // e.u
    public boolean d() {
        return this.f3745e.d();
    }

    @Override // e.u
    public void e() {
        this.f3745e.e();
    }

    public final u g() {
        return this.f3745e;
    }
}
