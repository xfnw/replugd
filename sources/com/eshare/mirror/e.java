package com.eshare.mirror;

import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Socket f3061a;

    /* renamed from: b  reason: collision with root package name */
    private Thread f3062b;

    /* renamed from: c  reason: collision with root package name */
    private String f3063c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3064d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] bArr = new byte[512];
                e.this.f3061a.connect(new InetSocketAddress(InetAddress.getByName(e.this.f3063c), 52030), 5000);
                while (!e.this.f3062b.isInterrupted() && !e.this.f3061a.isClosed()) {
                    int read = e.this.f3061a.getInputStream().read(bArr);
                    if (read > 0 && new String(bArr, 0, read).contains("STOP_MIRROR")) {
                        Log.e("eshare", "set reconnect mirror false");
                        e.this.f3064d = false;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f3063c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f3064d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f3061a = new Socket();
        this.f3062b = new Thread(new a());
        this.f3062b.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        try {
            this.f3064d = false;
            if (this.f3062b != null) {
                this.f3062b.interrupt();
                this.f3062b = null;
            }
            if (this.f3061a != null) {
                this.f3061a.close();
                this.f3061a = null;
                System.gc();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
