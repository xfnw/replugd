package d;

import e.c;
import e.e;
import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class b0 implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends b0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f3361b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f3362c;

        a(u uVar, long j, e eVar) {
            this.f3361b = j;
            this.f3362c = eVar;
        }

        @Override // d.b0
        public long m() {
            return this.f3361b;
        }

        @Override // d.b0
        public e n() {
            return this.f3362c;
        }
    }

    public static b0 a(u uVar, long j, e eVar) {
        if (eVar != null) {
            return new a(uVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static b0 a(u uVar, byte[] bArr) {
        c cVar = new c();
        cVar.write(bArr);
        return a(uVar, bArr.length, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.f0.c.a(n());
    }

    public abstract long m();

    public abstract e n();
}
