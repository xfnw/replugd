package a.g.e;

import a.g.i.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.c.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c<b.f> {
        a(h hVar) {
        }

        public int a(b.f fVar) {
            return fVar.d();
        }

        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements c<c.C0038c> {
        b(h hVar) {
        }

        public int a(c.C0038c cVar) {
            return cVar.e();
        }

        public boolean b(c.C0038c cVar) {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    private c.C0038c a(c.b bVar, int i) {
        return (c.C0038c) a(bVar.a(), i, new b(this));
    }

    private static <T> T a(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.f a(b.f[] fVarArr, int i) {
        return (b.f) a(fVarArr, i, new a(this));
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = i.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!i.a(a2, resources, i)) {
                return null;
            }
            return Typeface.createFromFile(a2.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(fVarArr, i).c());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Typeface a2 = a(context, inputStream);
            i.a(inputStream);
            return a2;
        } catch (IOException unused2) {
            i.a(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = inputStream;
            i.a(inputStream2);
            throw th;
        }
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0038c a2 = a(bVar, i);
        if (a2 == null) {
            return null;
        }
        return a.g.e.c.a(context, resources, a2.b(), a2.a(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = i.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!i.a(a2, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(a2.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }
}
