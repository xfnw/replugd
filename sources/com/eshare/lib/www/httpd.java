package com.eshare.lib.www;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.eshare.lib.j.f */
/* loaded from: classes.dex */
public class httpd {
    private static ExecutorService f;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean active;

    /* renamed from: b  reason: collision with root package name */
    private int port = 5454;

    /* renamed from: c  reason: collision with root package name */
    private ServerSocket serverSocket;

    /* renamed from: d  reason: collision with root package name */
    private File f3019d;

    /* renamed from: e  reason: collision with root package name */
    private Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.eshare.lib.j.f$a */
    /* loaded from: classes.dex */
    public class listener implements Runnable {
        listener() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (httpd.this.active) {
                try {
                    try {
                        httpd.f.execute(new processRequest(httpd.this.context, httpd.this.serverSocket.accept(), httpd.this.f3019d));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                } catch (Exception unused) {
                    httpd.this.active = false;
                    httpd.this.serverSocket.close();
                    return;
                } catch (Throwable th) {
                    httpd.this.active = false;
                    try {
                        httpd.this.serverSocket.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            }
            httpd.this.active = false;
            httpd.this.serverSocket.close();
        }
    }

    public httpd(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public int getPort() {
        return this.port;
    }

    public void a(File file) {
        this.f3019d = file;
        ExecutorService executorService = f;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        f = Executors.newCachedThreadPool();
        this.port = 8888;
        boolean z = false;
        do {
            try {
                this.serverSocket = new ServerSocket(this.port);
                z = true;
                continue;
            } catch (IOException unused) {
                this.port++;
                continue;
            }
        } while (!z);
        this.active = true;
        f.execute(new listener());
    }

    public boolean b() {
        return this.active;
    }
}
