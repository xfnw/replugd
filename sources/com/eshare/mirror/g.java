package com.eshare.mirror;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f3071a;

    /* renamed from: b  reason: collision with root package name */
    private a f3072b;

    /* renamed from: c  reason: collision with root package name */
    private k f3073c;

    /* renamed from: d  reason: collision with root package name */
    private j f3074d;

    /* renamed from: e  reason: collision with root package name */
    private int f3075e = 1;
    private boolean f;
    private AudioManager g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f3076b = false;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f3077c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f3078d = 51040;

        /* renamed from: e  reason: collision with root package name */
        private Socket f3079e = new Socket();
        private String f;

        public a(String str) {
            this.f = str;
        }

        private void a(long j) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        private void c() {
            Socket socket = this.f3079e;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        private boolean d() {
            try {
                this.f3079e.connect(new InetSocketAddress(InetAddress.getByName(this.f), this.f3078d), 5000);
                this.f3079e.setTcpNoDelay(true);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public void a() {
            start();
            while (!this.f3076b) {
                a(50L);
            }
        }

        public void b() {
            if (this.f3076b) {
                this.f3077c = true;
                while (true) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    while (this.f3077c) {
                        a(100L);
                        if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                            break;
                        }
                    }
                    this.f3076b = false;
                    return;
                    Log.e("eshare", "socket is blocked, force close.");
                    c();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            j jVar;
            com.eshare.mirror.a aVar;
            Exception e2;
            int i2;
            int b2;
            String str = "feature";
            String str2 = "Framerate";
            String str3 = "casting_win_height";
            long currentTimeMillis = System.currentTimeMillis();
            this.f3076b = true;
            if (d()) {
                h hVar = new h(this.f3079e, this.f);
                if (hVar.a(g.this.f3071a) != null) {
                    if (!g.this.f || b.f3054a != 0 || (b2 = hVar.b()) <= 0) {
                        aVar = null;
                    } else {
                        g.this.a(true);
                        aVar = new com.eshare.mirror.a(this.f, b2);
                        aVar.a();
                    }
                    g gVar = g.this;
                    gVar.f3073c = new k(gVar.f3071a, this.f);
                    g.this.f3073c.a(g.this.f3074d);
                    g.this.f3073c.b();
                    int i3 = 0;
                    long j = 0;
                    while (true) {
                        if (!this.f3076b || this.f3077c) {
                            break;
                        }
                        int a2 = g.this.f3073c.a();
                        if (a2 != 0) {
                            if (g.this.f3074d != null) {
                                g.this.f3074d.a(a2);
                            }
                        } else if (System.currentTimeMillis() - j >= 1000) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            f a3 = hVar.a();
                            if (a3 == null) {
                                String str4 = "send option failed " + i3;
                                i3++;
                                if (i3 >= 5) {
                                    break;
                                }
                                str = str;
                                str2 = str2;
                                str3 = str3;
                                j = currentTimeMillis2;
                            } else {
                                try {
                                } catch (Exception e3) {
                                    e2 = e3;
                                    str = str;
                                    str2 = str2;
                                    str3 = str3;
                                }
                                if (a3.b() > 0) {
                                    JsonObject asJsonObject = JsonParser.parseString(new String(a3.a())).getAsJsonObject();
                                    if (asJsonObject.has("casting_win_width") && asJsonObject.has(str3) && asJsonObject.has(str2) && asJsonObject.has(str)) {
                                        int asInt = asJsonObject.get("casting_win_width").getAsInt();
                                        int asInt2 = asJsonObject.get(str3).getAsInt();
                                        int asInt3 = asJsonObject.get(str).getAsInt();
                                        int asInt4 = asJsonObject.get(str2).getAsInt();
                                        if (asInt4 <= 0) {
                                            str = str;
                                            str2 = str2;
                                            str3 = str3;
                                            i2 = 20;
                                        } else {
                                            str = str;
                                            str2 = str2;
                                            str3 = str3;
                                            i2 = asInt4;
                                        }
                                        if (((byte) (asInt3 & 1)) == 1) {
                                            try {
                                                g.this.f3073c.a(asInt, asInt2, i2);
                                            } catch (Exception e4) {
                                                e2 = e4;
                                                e2.printStackTrace();
                                                String str5 = "send option success " + i3;
                                                j = currentTimeMillis2;
                                                i3 = 0;
                                            }
                                        }
                                        if (b.f3054a == 1 && asJsonObject.has("casting_bluetooth_audio") && g.this.f3075e != asJsonObject.get("casting_bluetooth_audio").getAsInt()) {
                                            g.this.f3075e = asJsonObject.get("casting_bluetooth_audio").getAsInt();
                                            if (g.this.f3074d != null) {
                                                g.this.f3074d.a(g.this.f3075e == 1 ? 11 : 12);
                                            }
                                        }
                                        String str52 = "send option success " + i3;
                                        j = currentTimeMillis2;
                                        i3 = 0;
                                    }
                                }
                                str = str;
                                str2 = str2;
                                str3 = str3;
                                String str522 = "send option success " + i3;
                                j = currentTimeMillis2;
                                i3 = 0;
                            }
                        } else {
                            str = str;
                            str2 = str2;
                            str3 = str3;
                            a(100L);
                        }
                    }
                    if (aVar != null) {
                        g.this.a(false);
                        aVar.b();
                    }
                    hVar.c();
                    g.this.f3073c.c();
                    if (g.this.f3074d != null) {
                        jVar = g.this.f3074d;
                        i = 1;
                        jVar.a(i);
                    }
                } else if (g.this.f3074d != null) {
                    jVar = g.this.f3074d;
                    i = 257;
                    jVar.a(i);
                }
            } else if (g.this.f3074d != null) {
                jVar = g.this.f3074d;
                i = 256;
                jVar.a(i);
            }
            if (System.currentTimeMillis() - currentTimeMillis <= 100) {
                a(100L);
            }
            c();
            this.f3076b = false;
            this.f3077c = false;
        }
    }

    public g(Context context) {
        boolean z = true;
        this.f3071a = context;
        this.g = (AudioManager) context.getSystemService("audio");
        this.f = Build.VERSION.SDK_INT < 29 ? false : z;
    }

    public synchronized void a() {
        if (this.f3072b != null) {
            this.f3072b.b();
            this.f3072b = null;
        }
    }

    public void a(j jVar) {
        this.f3074d = jVar;
    }

    public synchronized void a(String str) {
        a();
        this.f3072b = new a(str);
        this.f3072b.a();
    }

    void a(boolean z) {
        AudioManager audioManager;
        int i;
        if (z) {
            audioManager = this.g;
            i = -100;
        } else {
            audioManager = this.g;
            i = 100;
        }
        audioManager.adjustStreamVolume(3, i, 0);
    }
}
