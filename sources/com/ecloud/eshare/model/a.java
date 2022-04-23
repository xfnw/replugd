package com.ecloud.eshare.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ecloud.eshare.bean.AppItem;
import com.ecloud.eshare.util.l;
import com.ecloud.eshare.util.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class a implements m {

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2858b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f2859c;

    /* renamed from: d  reason: collision with root package name */
    private List<AppItem> f2860d;

    /* renamed from: e  reason: collision with root package name */
    private b.b.a.c f2861e;
    private d f;

    /* renamed from: com.ecloud.eshare.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0085a implements Runnable {
        RunnableC0085a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = null;
            for (int i = 0; i < 3 && (bArr = a.this.f2861e.a()) == null; i++) {
            }
            if (bArr != null) {
                a aVar = a.this;
                aVar.a("saveToFile", Boolean.valueOf(aVar.b(bArr)));
            }
            a.this.a(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f != null) {
                a.this.f.a(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f != null) {
                a.this.f.a(true, a.this.f2860d);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(boolean z, List<AppItem> list);
    }

    /* loaded from: classes.dex */
    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private static a f2865a = new a(null);
    }

    private a() {
        this.f2859c = new Handler(Looper.getMainLooper());
        this.f2858b = Executors.newSingleThreadExecutor();
        this.f2860d = new ArrayList();
    }

    /* synthetic */ a(RunnableC0085a aVar) {
        this();
    }

    public static int a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static a a() {
        return e.f2865a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        Handler handler;
        Runnable cVar;
        if (bArr == null) {
            handler = this.f2859c;
            cVar = new b();
        } else {
            this.f2860d.clear();
            int a2 = a(bArr, 0);
            int i = 4;
            while (i < a2) {
                AppItem appItem = new AppItem();
                int a3 = a(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[a3];
                System.arraycopy(bArr, i2, bArr2, 0, a3);
                int i3 = i2 + a3;
                appItem.setAppName(new String(bArr2));
                int a4 = a(bArr, i3);
                int i4 = i3 + 4;
                byte[] bArr3 = new byte[a4];
                System.arraycopy(bArr, i4, bArr3, 0, a4);
                int i5 = i4 + a4;
                appItem.setPackageName(new String(bArr3));
                int a5 = a(bArr, i5);
                int i6 = i5 + 4;
                byte[] bArr4 = new byte[a5];
                System.arraycopy(bArr, i6, bArr4, 0, a5);
                int i7 = i6 + a5;
                appItem.setVersionName(new String(bArr4));
                int a6 = a(bArr, i7);
                int i8 = i7 + 4;
                appItem.setVersionCode(a(bArr, i8));
                int i9 = i8 + a6;
                int a7 = a(bArr, i9);
                int i10 = i9 + 4;
                byte[] bArr5 = new byte[a7];
                System.arraycopy(bArr, i10, bArr5, 0, a7);
                i = i10 + a7;
                appItem.setAppIcon(bArr5);
                this.f2860d.add(appItem);
            }
            handler = this.f2859c;
            cVar = new c();
        }
        handler.post(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(byte[] bArr) {
        Throwable th;
        IOException e2;
        FileOutputStream fileOutputStream;
        File file = new File(com.ecloud.eshare.a.f2523e);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e2 = e3;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return true;
        } catch (IOException e5) {
            e2 = e5;
            fileOutputStream2 = fileOutputStream;
            e2.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            if (!file.exists()) {
                return false;
            }
            file.delete();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }

    public void a(Context context) {
        this.f2861e = b.b.a.a.a(context).b();
        this.f2858b.execute(new RunnableC0085a());
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public void a(Object... objArr) {
        l.b(objArr);
    }
}
