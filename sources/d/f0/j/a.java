package d.f0.j;

import e.l;
import e.s;
import e.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3611a = new C0100a();

    /* renamed from: d.f0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0100a implements a {
        C0100a() {
        }

        @Override // d.f0.j.a
        public void a(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // d.f0.j.a
        public void a(File file, File file2) {
            a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // d.f0.j.a
        public t b(File file) {
            return l.c(file);
        }

        @Override // d.f0.j.a
        public s c(File file) {
            try {
                return l.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.b(file);
            }
        }

        @Override // d.f0.j.a
        public void d(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        d(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        @Override // d.f0.j.a
        public s e(File file) {
            try {
                return l.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.a(file);
            }
        }

        @Override // d.f0.j.a
        public boolean f(File file) {
            return file.exists();
        }

        @Override // d.f0.j.a
        public long g(File file) {
            return file.length();
        }
    }

    void a(File file);

    void a(File file, File file2);

    t b(File file);

    s c(File file);

    void d(File file);

    s e(File file);

    boolean f(File file);

    long g(File file);
}
