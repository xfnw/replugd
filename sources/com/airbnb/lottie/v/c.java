package com.airbnb.lottie.v;

import android.content.Context;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2428a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2429b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2430c;

    private c(Context context, String str) {
        this.f2428a = context.getApplicationContext();
        this.f2429b = str;
        this.f2430c = new b(this.f2428a, str);
    }

    public static l<d> a(Context context, String str) {
        return new c(context, str).a();
    }

    private String a(HttpURLConnection httpURLConnection) {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    private d b() {
        a.g.k.d<a, InputStream> a2 = this.f2430c.a();
        if (a2 == null) {
            return null;
        }
        a aVar = a2.f282a;
        InputStream inputStream = a2.f283b;
        l<d> a3 = aVar == a.ZIP ? e.a(new ZipInputStream(inputStream), this.f2429b) : e.a(inputStream, this.f2429b);
        if (a3.b() != null) {
            return a3.b();
        }
        return null;
    }

    private l<d> b(HttpURLConnection httpURLConnection) {
        l<d> lVar;
        a aVar;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        char c2 = 65535;
        int hashCode = contentType.hashCode();
        if (hashCode != -1248325150) {
            if (hashCode == -43840953 && contentType.equals("application/json")) {
                c2 = 1;
            }
        } else if (contentType.equals("application/zip")) {
            c2 = 0;
        }
        if (c2 != 0) {
            com.airbnb.lottie.x.d.a("Received json response.");
            aVar = a.JSON;
            lVar = e.a(new FileInputStream(new File(this.f2430c.a(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f2429b);
        } else {
            com.airbnb.lottie.x.d.a("Handling zip response.");
            aVar = a.ZIP;
            lVar = e.a(new ZipInputStream(new FileInputStream(this.f2430c.a(httpURLConnection.getInputStream(), aVar))), this.f2429b);
        }
        if (lVar.b() != null) {
            this.f2430c.a(aVar);
        }
        return lVar;
    }

    private l<d> c() {
        try {
            return d();
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    private l d() {
        com.airbnb.lottie.x.d.a("Fetching " + this.f2429b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2429b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                l<d> b2 = b(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(b2.b() != null);
                com.airbnb.lottie.x.d.a(sb.toString());
                return b2;
            }
            String a2 = a(httpURLConnection);
            return new l((Throwable) new IllegalArgumentException("Unable to fetch " + this.f2429b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + a2));
        } catch (Exception e2) {
            return new l((Throwable) e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public l<d> a() {
        d b2 = b();
        if (b2 != null) {
            return new l<>(b2);
        }
        com.airbnb.lottie.x.d.a("Animation for " + this.f2429b + " not found in cache. Fetching from network.");
        return c();
    }
}
