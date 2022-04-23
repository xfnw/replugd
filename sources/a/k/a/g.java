package a.k.a;

import a.g.k.h;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class g<E> extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f406a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f407b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f408c;

    /* renamed from: d  reason: collision with root package name */
    final i f409d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this(dVar, dVar, dVar.f399d, 0);
    }

    g(Activity activity, Context context, Handler handler, int i) {
        this.f409d = new i();
        this.f406a = activity;
        h.a(context, "context == null");
        this.f407b = context;
        h.a(handler, "handler == null");
        this.f408c = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(c cVar);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity b() {
        return this.f406a;
    }

    public abstract boolean b(c cVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context c() {
        return this.f407b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i d() {
        return this.f409d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler e() {
        return this.f408c;
    }

    public abstract LayoutInflater f();

    public abstract int g();

    public abstract boolean h();

    public abstract void i();
}
