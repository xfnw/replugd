package com.eshare.mirror;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import b.a.a.a;
import b.a.a.b;
import b.a.a.c;
import b.a.a.d;
import b.a.a.e;
import b.a.a.g;
import b.a.a.i;
import b.b.a.n.f;
import java.net.Socket;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f3080a = 0;

    /* renamed from: b  reason: collision with root package name */
    private String f3081b;

    /* renamed from: c  reason: collision with root package name */
    private Socket f3082c;

    public h(Socket socket, String str) {
        this.f3081b = str;
        this.f3082c = socket;
    }

    private String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("CSeq: ");
        int i2 = this.f3080a + 1;
        this.f3080a = i2;
        sb.append(i2);
        sb.append("\r\nContent-Length: ");
        sb.append(i);
        sb.append("\r\n\r\n");
        return sb.toString();
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("CSeq: ");
        int i = this.f3080a + 1;
        this.f3080a = i;
        sb.append(i);
        sb.append("\r\nContent-Length: ");
        sb.append(0);
        sb.append("\r\n\r\n");
        return sb.toString();
    }

    public f a() {
        try {
            this.f3082c.getOutputStream().write(("OPTIONS rtsp://" + this.f3081b + " RTSP/1.0\r\n" + d()).getBytes("UTF-8"));
            this.f3082c.getOutputStream().flush();
            return f.b(this.f3082c.getInputStream());
        } catch (Exception unused) {
            Log.e("eshare", "option error");
            return null;
        }
    }

    public f a(Context context) {
        try {
            String b2 = f.b(context, "com.ecloud.eshare.lib.key.CLIENT_NAME", Build.MODEL);
            g gVar = new g();
            gVar.a("type", (Object) 110);
            gVar.a("androdstream", (Object) true);
            gVar.a("dataPort", (Object) 0);
            gVar.a("controlPort", (Object) 0);
            gVar.a("androidVersion", Integer.valueOf(Build.VERSION.SDK_INT));
            gVar.put("machine_name", (i) new e(a.a(b2.getBytes())));
            d dVar = new d(gVar);
            g gVar2 = new g();
            gVar2.put("streams", (i) dVar);
            byte[] e2 = c.e(gVar2);
            this.f3082c.getOutputStream().write(("SETUP rtsp://" + this.f3081b + " RTSP/1.0\r\n" + a(e2.length)).getBytes("UTF-8"));
            this.f3082c.getOutputStream().write(e2);
            this.f3082c.getOutputStream().flush();
            return f.b(this.f3082c.getInputStream());
        } catch (Exception unused) {
            Log.e("eshare", "setup video error");
            return null;
        }
    }

    public int b() {
        int i = 0;
        try {
            g gVar = new g();
            gVar.a("type", (Object) 96);
            gVar.a("audioFormat", (Object) 16777216);
            d dVar = new d(gVar);
            g gVar2 = new g();
            gVar2.put("streams", (i) dVar);
            byte[] e2 = c.e(gVar2);
            this.f3082c.getOutputStream().write(("SETUP rtsp://" + this.f3081b + " RTSP/1.0\r\n" + a(e2.length)).getBytes("UTF-8"));
            this.f3082c.getOutputStream().write(e2);
            this.f3082c.getOutputStream().flush();
            g gVar3 = (g) b.b(f.b(this.f3082c.getInputStream()).a());
            if (gVar3.a("streams")) {
                d dVar2 = (d) gVar3.get((Object) "streams");
                if (dVar2.a() > 0) {
                    g gVar4 = (g) dVar2.a(0);
                    if (gVar4.a("type")) {
                        ((b.a.a.h) gVar4.get((Object) "type")).c();
                    }
                    if (gVar4.a("dataPort")) {
                        i = ((b.a.a.h) gVar4.get((Object) "dataPort")).c();
                    }
                }
            }
            String str = "receive audioPort: " + i;
        } catch (Exception unused) {
            Log.e("eshare", "setup audio error");
        }
        return i;
    }

    public f c() {
        try {
            g gVar = new g();
            gVar.a("type", (Object) 110);
            gVar.a("dataPort", (Object) 0);
            gVar.a("controlPort", (Object) 0);
            d dVar = new d(gVar);
            g gVar2 = new g();
            gVar2.put("streams", (i) dVar);
            byte[] e2 = c.e(gVar2);
            this.f3082c.getOutputStream().write(("TEARDOWN rtsp://" + this.f3081b + " RTSP/1.0\r\n" + a(e2.length)).getBytes("UTF-8"));
            this.f3082c.getOutputStream().write(e2);
            this.f3082c.getOutputStream().flush();
            return f.b(this.f3082c.getInputStream());
        } catch (Exception unused) {
            Log.e("eshare", "teardown error");
            return null;
        }
    }
}
