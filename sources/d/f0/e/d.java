package d.f0.e;

import d.f0.k.f;
import e.l;
import e.s;
import e.t;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d implements Closeable, Flushable {
    static final Pattern v = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b  reason: collision with root package name */
    final d.f0.j.a f3422b;

    /* renamed from: c  reason: collision with root package name */
    final File f3423c;

    /* renamed from: d  reason: collision with root package name */
    private final File f3424d;

    /* renamed from: e  reason: collision with root package name */
    private final File f3425e;
    private final File f;
    private final int g;
    private long h;
    final int i;
    e.d k;
    int m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    private final Executor t;
    private long j = 0;
    final LinkedHashMap<String, C0097d> l = new LinkedHashMap<>(0, 0.75f, true);
    private long s = 0;
    private final Runnable u = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                if (!(!d.this.o) && !d.this.p) {
                    try {
                        d.this.r();
                    } catch (IOException unused) {
                        d.this.q = true;
                    }
                    try {
                        if (d.this.p()) {
                            d.this.q();
                            d.this.m = 0;
                        }
                    } catch (IOException unused2) {
                        d.this.r = true;
                        d.this.k = l.a(l.a());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends d.f0.e.e {
        b(s sVar) {
            super(sVar);
        }

        @Override // d.f0.e.e
        protected void a(IOException iOException) {
            d.this.n = true;
        }
    }

    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        final C0097d f3428a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f3429b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3430c;

        /* loaded from: classes.dex */
        class a extends d.f0.e.e {
            a(s sVar) {
                super(sVar);
            }

            @Override // d.f0.e.e
            protected void a(IOException iOException) {
                synchronized (d.this) {
                    c.this.c();
                }
            }
        }

        c(C0097d dVar) {
            this.f3428a = dVar;
            this.f3429b = dVar.f3437e ? null : new boolean[d.this.i];
        }

        public s a(int i) {
            synchronized (d.this) {
                if (this.f3430c) {
                    throw new IllegalStateException();
                } else if (this.f3428a.f != this) {
                    return l.a();
                } else {
                    if (!this.f3428a.f3437e) {
                        this.f3429b[i] = true;
                    }
                    try {
                        return new a(d.this.f3422b.c(this.f3428a.f3436d[i]));
                    } catch (FileNotFoundException unused) {
                        return l.a();
                    }
                }
            }
        }

        public void a() {
            synchronized (d.this) {
                if (!this.f3430c) {
                    if (this.f3428a.f == this) {
                        d.this.a(this, false);
                    }
                    this.f3430c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public void b() {
            synchronized (d.this) {
                if (!this.f3430c) {
                    if (this.f3428a.f == this) {
                        d.this.a(this, true);
                    }
                    this.f3430c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        void c() {
            if (this.f3428a.f == this) {
                int i = 0;
                while (true) {
                    d dVar = d.this;
                    if (i < dVar.i) {
                        try {
                            dVar.f3422b.a(this.f3428a.f3436d[i]);
                        } catch (IOException unused) {
                        }
                        i++;
                    } else {
                        this.f3428a.f = null;
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d.f0.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0097d {

        /* renamed from: a  reason: collision with root package name */
        final String f3433a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f3434b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f3435c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f3436d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3437e;
        c f;
        long g;

        C0097d(String str) {
            this.f3433a = str;
            int i = d.this.i;
            this.f3434b = new long[i];
            this.f3435c = new File[i];
            this.f3436d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < d.this.i; i2++) {
                sb.append(i2);
                this.f3435c[i2] = new File(d.this.f3423c, sb.toString());
                sb.append(".tmp");
                this.f3436d[i2] = new File(d.this.f3423c, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        e a() {
            if (Thread.holdsLock(d.this)) {
                t[] tVarArr = new t[d.this.i];
                long[] jArr = (long[]) this.f3434b.clone();
                for (int i = 0; i < d.this.i; i++) {
                    try {
                        tVarArr[i] = d.this.f3422b.b(this.f3435c[i]);
                    } catch (FileNotFoundException unused) {
                        for (int i2 = 0; i2 < d.this.i && tVarArr[i2] != null; i2++) {
                            d.f0.c.a(tVarArr[i2]);
                        }
                        try {
                            d.this.a(this);
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                }
                return new e(this.f3433a, this.g, tVarArr, jArr);
            }
            throw new AssertionError();
        }

        void a(e.d dVar) {
            for (long j : this.f3434b) {
                dVar.writeByte(32).f(j);
            }
        }

        void a(String[] strArr) {
            if (strArr.length == d.this.i) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f3434b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        b(strArr);
                        throw null;
                    }
                }
                return;
            }
            b(strArr);
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f3438b;

        /* renamed from: c  reason: collision with root package name */
        private final long f3439c;

        /* renamed from: d  reason: collision with root package name */
        private final t[] f3440d;

        e(String str, long j, t[] tVarArr, long[] jArr) {
            this.f3438b = str;
            this.f3439c = j;
            this.f3440d = tVarArr;
        }

        public t a(int i) {
            return this.f3440d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (t tVar : this.f3440d) {
                d.f0.c.a(tVar);
            }
        }

        public c m() {
            return d.this.a(this.f3438b, this.f3439c);
        }
    }

    d(d.f0.j.a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f3422b = aVar;
        this.f3423c = file;
        this.g = i;
        this.f3424d = new File(file, "journal");
        this.f3425e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i2;
        this.h = j;
        this.t = executor;
    }

    public static d a(d.f0.j.a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new d(aVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.f0.c.a("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void e(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.l.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C0097d dVar = this.l.get(str2);
            if (dVar == null) {
                dVar = new C0097d(str2);
                this.l.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f3437e = true;
                dVar.f = null;
                dVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f = new c(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void f(String str) {
        if (!v.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private synchronized void s() {
        if (o()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private e.d t() {
        return l.a(new b(this.f3422b.e(this.f3424d)));
    }

    private void u() {
        this.f3422b.a(this.f3425e);
        Iterator<C0097d> it = this.l.values().iterator();
        while (it.hasNext()) {
            C0097d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.i) {
                    this.j += next.f3434b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.i) {
                    this.f3422b.a(next.f3435c[i]);
                    this.f3422b.a(next.f3436d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void v() {
        e.e a2 = l.a(this.f3422b.b(this.f3424d));
        try {
            String f = a2.f();
            String f2 = a2.f();
            String f3 = a2.f();
            String f4 = a2.f();
            String f5 = a2.f();
            if (!"libcore.io.DiskLruCache".equals(f) || !"1".equals(f2) || !Integer.toString(this.g).equals(f3) || !Integer.toString(this.i).equals(f4) || !"".equals(f5)) {
                throw new IOException("unexpected journal header: [" + f + ", " + f2 + ", " + f4 + ", " + f5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    e(a2.f());
                    i++;
                } catch (EOFException unused) {
                    this.m = i - this.l.size();
                    if (!a2.j()) {
                        q();
                    } else {
                        this.k = t();
                    }
                    d.f0.c.a(a2);
                    return;
                }
            }
        } catch (Throwable th) {
            d.f0.c.a(a2);
            throw th;
        }
    }

    synchronized c a(String str, long j) {
        n();
        s();
        f(str);
        C0097d dVar = this.l.get(str);
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar != null && dVar.f != null) {
            return null;
        }
        if (!this.q && !this.r) {
            this.k.a("DIRTY").writeByte(32).a(str).writeByte(10);
            this.k.flush();
            if (this.n) {
                return null;
            }
            if (dVar == null) {
                dVar = new C0097d(str);
                this.l.put(str, dVar);
            }
            c cVar = new c(dVar);
            dVar.f = cVar;
            return cVar;
        }
        this.t.execute(this.u);
        return null;
    }

    synchronized void a(c cVar, boolean z) {
        C0097d dVar = cVar.f3428a;
        if (dVar.f == cVar) {
            if (z && !dVar.f3437e) {
                for (int i = 0; i < this.i; i++) {
                    if (!cVar.f3429b[i]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.f3422b.f(dVar.f3436d[i])) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < this.i; i2++) {
                File file = dVar.f3436d[i2];
                if (!z) {
                    this.f3422b.a(file);
                } else if (this.f3422b.f(file)) {
                    File file2 = dVar.f3435c[i2];
                    this.f3422b.a(file, file2);
                    long j = dVar.f3434b[i2];
                    long g = this.f3422b.g(file2);
                    dVar.f3434b[i2] = g;
                    this.j = (this.j - j) + g;
                }
            }
            this.m++;
            dVar.f = null;
            if (dVar.f3437e || z) {
                dVar.f3437e = true;
                this.k.a("CLEAN").writeByte(32);
                this.k.a(dVar.f3433a);
                dVar.a(this.k);
                this.k.writeByte(10);
                if (z) {
                    long j2 = this.s;
                    this.s = 1 + j2;
                    dVar.g = j2;
                }
            } else {
                this.l.remove(dVar.f3433a);
                this.k.a("REMOVE").writeByte(32);
                this.k.a(dVar.f3433a);
                this.k.writeByte(10);
            }
            this.k.flush();
            if (this.j > this.h || p()) {
                this.t.execute(this.u);
            }
            return;
        }
        throw new IllegalStateException();
    }

    boolean a(C0097d dVar) {
        c cVar = dVar.f;
        if (cVar != null) {
            cVar.c();
        }
        for (int i = 0; i < this.i; i++) {
            this.f3422b.a(dVar.f3435c[i]);
            long j = this.j;
            long[] jArr = dVar.f3434b;
            this.j = j - jArr[i];
            jArr[i] = 0;
        }
        this.m++;
        this.k.a("REMOVE").writeByte(32).a(dVar.f3433a).writeByte(10);
        this.l.remove(dVar.f3433a);
        if (p()) {
            this.t.execute(this.u);
        }
        return true;
    }

    public c b(String str) {
        return a(str, -1L);
    }

    public synchronized e c(String str) {
        n();
        s();
        f(str);
        C0097d dVar = this.l.get(str);
        if (dVar != null && dVar.f3437e) {
            e a2 = dVar.a();
            if (a2 == null) {
                return null;
            }
            this.m++;
            this.k.a("READ").writeByte(32).a(str).writeByte(10);
            if (p()) {
                this.t.execute(this.u);
            }
            return a2;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        C0097d[] dVarArr;
        if (this.o && !this.p) {
            for (C0097d dVar : (C0097d[]) this.l.values().toArray(new C0097d[this.l.size()])) {
                if (dVar.f != null) {
                    dVar.f.a();
                }
            }
            r();
            this.k.close();
            this.k = null;
            this.p = true;
            return;
        }
        this.p = true;
    }

    public synchronized boolean d(String str) {
        n();
        s();
        f(str);
        C0097d dVar = this.l.get(str);
        if (dVar == null) {
            return false;
        }
        boolean a2 = a(dVar);
        if (a2 && this.j <= this.h) {
            this.q = false;
        }
        return a2;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.o) {
            s();
            r();
            this.k.flush();
        }
    }

    public void m() {
        close();
        this.f3422b.d(this.f3423c);
    }

    public synchronized void n() {
        if (!this.o) {
            if (this.f3422b.f(this.f)) {
                if (this.f3422b.f(this.f3424d)) {
                    this.f3422b.a(this.f);
                } else {
                    this.f3422b.a(this.f, this.f3424d);
                }
            }
            if (this.f3422b.f(this.f3424d)) {
                try {
                    v();
                    u();
                    this.o = true;
                    return;
                } catch (IOException e2) {
                    f d2 = f.d();
                    d2.a(5, "DiskLruCache " + this.f3423c + " is corrupt: " + e2.getMessage() + ", removing", e2);
                    m();
                    this.p = false;
                }
            }
            q();
            this.o = true;
        }
    }

    public synchronized boolean o() {
        return this.p;
    }

    boolean p() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    synchronized void q() {
        if (this.k != null) {
            this.k.close();
        }
        e.d a2 = l.a(this.f3422b.c(this.f3425e));
        a2.a("libcore.io.DiskLruCache").writeByte(10);
        a2.a("1").writeByte(10);
        a2.f(this.g).writeByte(10);
        a2.f(this.i).writeByte(10);
        a2.writeByte(10);
        for (C0097d dVar : this.l.values()) {
            if (dVar.f != null) {
                a2.a("DIRTY").writeByte(32);
                a2.a(dVar.f3433a);
            } else {
                a2.a("CLEAN").writeByte(32);
                a2.a(dVar.f3433a);
                dVar.a(a2);
            }
            a2.writeByte(10);
        }
        a2.close();
        if (this.f3422b.f(this.f3424d)) {
            this.f3422b.a(this.f3424d, this.f);
        }
        this.f3422b.a(this.f3425e, this.f3424d);
        this.f3422b.a(this.f);
        this.k = t();
        this.n = false;
        this.r = false;
    }

    void r() {
        while (this.j > this.h) {
            a(this.l.values().iterator().next());
        }
        this.q = false;
    }
}
