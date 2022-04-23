package a.k.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(h hVar, a.k.a.c cVar);

        public abstract void a(h hVar, a.k.a.c cVar, Context context);

        public abstract void a(h hVar, a.k.a.c cVar, Bundle bundle);

        public abstract void a(h hVar, a.k.a.c cVar, View view, Bundle bundle);

        public abstract void b(h hVar, a.k.a.c cVar);

        public abstract void b(h hVar, a.k.a.c cVar, Context context);

        public abstract void b(h hVar, a.k.a.c cVar, Bundle bundle);

        public abstract void c(h hVar, a.k.a.c cVar);

        public abstract void c(h hVar, a.k.a.c cVar, Bundle bundle);

        public abstract void d(h hVar, a.k.a.c cVar);

        public abstract void d(h hVar, a.k.a.c cVar, Bundle bundle);

        public abstract void e(h hVar, a.k.a.c cVar);

        public abstract void f(h hVar, a.k.a.c cVar);

        public abstract void g(h hVar, a.k.a.c cVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public abstract List<a.k.a.c> a();

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract boolean c();
}
