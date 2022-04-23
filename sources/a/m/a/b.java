package a.m.a;

import a.d.h;
import a.m.b.a;
import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends a.m.a.a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f499c = false;

    /* renamed from: a  reason: collision with root package name */
    private final g f500a;

    /* renamed from: b  reason: collision with root package name */
    private final c f501b;

    /* loaded from: classes.dex */
    public static class a<D> extends l<D> implements a.AbstractC0023a<D> {
        private final int j;
        private final Bundle k;
        private final a.m.b.a<D> l;
        private g m;
        private C0022b<D> n;
        private a.m.b.a<D> o;

        a.m.b.a<D> a(boolean z) {
            if (b.f499c) {
                String str = "  Destroying: " + this;
            }
            this.l.a();
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void a() {
            if (b.f499c) {
                String str = "  Starting: " + this;
            }
            this.l.c();
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(m<? super D> mVar) {
            super.a((m) mVar);
            this.m = null;
            this.n = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void a(D d2) {
            super.a((a<D>) d2);
            a.m.b.a<D> aVar = this.o;
            if (aVar != null) {
                aVar.b();
                throw null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.j);
            printWriter.print(" mArgs=");
            printWriter.println(this.k);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.l);
            a.m.b.a<D> aVar = this.l;
            aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (b.f499c) {
                String str = "  Stopping: " + this;
            }
            this.l.d();
            throw null;
        }

        void c() {
            g gVar = this.m;
            C0022b<D> bVar = this.n;
            if (gVar != null && bVar != null) {
                super.a((m) bVar);
                a(gVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.j);
            sb.append(" : ");
            a.g.k.a.a(this.l, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0022b<D> implements m<D> {
    }

    /* loaded from: classes.dex */
    static class c extends p {

        /* renamed from: b  reason: collision with root package name */
        private static final q.a f502b = new a();

        /* renamed from: a  reason: collision with root package name */
        private h<a> f503a = new h<>();

        /* loaded from: classes.dex */
        static class a implements q.a {
            a() {
            }

            @Override // androidx.lifecycle.q.a
            public <T extends p> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c a(r rVar) {
            return (c) new q(rVar, f502b).a(c.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.p
        public void a() {
            super.a();
            if (this.f503a.b() <= 0) {
                this.f503a.a();
            } else {
                this.f503a.e(0).a(true);
                throw null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f503a.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.f503a.b() > 0) {
                    a e2 = this.f503a.e(0);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f503a.c(0));
                    printWriter.print(": ");
                    printWriter.println(e2.toString());
                    e2.a(str2, fileDescriptor, printWriter, strArr);
                    throw null;
                }
            }
        }

        void b() {
            int b2 = this.f503a.b();
            for (int i = 0; i < b2; i++) {
                this.f503a.e(i).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, r rVar) {
        this.f500a = gVar;
        this.f501b = c.a(rVar);
    }

    @Override // a.m.a.a
    public void a() {
        this.f501b.b();
    }

    @Override // a.m.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f501b.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.g.k.a.a(this.f500a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
