package d.f0.f;

import d.f0.c;
import java.io.IOException;

/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private IOException f3453b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f3454c;

    public e(IOException iOException) {
        super(iOException);
        this.f3453b = iOException;
        this.f3454c = iOException;
    }

    public IOException a() {
        return this.f3453b;
    }

    public void a(IOException iOException) {
        c.a((Throwable) this.f3453b, (Throwable) iOException);
        this.f3454c = iOException;
    }

    public IOException b() {
        return this.f3454c;
    }
}
