package com.eshare.mirror;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f3066e = {13, 10, 13, 10};
    private static ByteBuffer f = ByteBuffer.allocate(4096);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3067a;

    /* renamed from: b  reason: collision with root package name */
    private Vector<String> f3068b = new Vector<>();

    /* renamed from: c  reason: collision with root package name */
    private Vector<String> f3069c = new Vector<>();

    /* renamed from: d  reason: collision with root package name */
    private String f3070d;

    private f(String str) {
        this.f3070d = str;
        Matcher matcher = Pattern.compile("^(\\w+)\\W(.+)\\WRTSP/(.+)\r\n").matcher(str);
        if (matcher.find()) {
            matcher.group(1);
            matcher.group(2);
            matcher.group(3);
        }
        Matcher matcher2 = Pattern.compile("^([\\w-]+):\\W(.+)\r\n", 8).matcher(str);
        while (matcher2.find()) {
            this.f3068b.add(matcher2.group(1));
            this.f3069c.add(matcher2.group(2));
        }
    }

    private static int a(ByteBuffer byteBuffer, InputStream inputStream, byte[] bArr) {
        int i = 0;
        int i2 = 0;
        do {
            try {
                int read = inputStream.read();
                if (read < 0) {
                    Log.e("eshare", "socket read timeout < 0,exit");
                    return read;
                }
                i++;
                byte b2 = (byte) (read & 255);
                byteBuffer.put(b2);
                i2 = b2 == bArr[i2] ? i2 + 1 : 0;
            } catch (SocketTimeoutException unused) {
            }
        } while (i2 != bArr.length);
        return i;
    }

    public static f b(InputStream inputStream) {
        f.rewind();
        int a2 = a(f, inputStream, f3066e);
        if (a2 > 0) {
            f fVar = new f(new String(f.array(), 0, a2));
            try {
                fVar.a(inputStream);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return fVar;
        }
        throw new SocketException("Connection lost");
    }

    public String a(String str) {
        int indexOf = this.f3068b.indexOf(str);
        if (indexOf == -1) {
            return null;
        }
        return this.f3069c.elementAt(indexOf);
    }

    public void a(InputStream inputStream) {
        int b2 = b();
        if (b2 > 0) {
            this.f3067a = new byte[b2];
            int i = 0;
            while (i < b2) {
                int read = inputStream.read(this.f3067a, i, b2 - i);
                if (read >= 0) {
                    i += read;
                } else {
                    return;
                }
            }
        }
    }

    public byte[] a() {
        return this.f3067a;
    }

    public int b() {
        String a2 = a("Content-Length");
        if (a2 != null) {
            return Integer.parseInt(a2);
        }
        return 0;
    }

    public String toString() {
        String str = " < " + this.f3070d.replaceAll("\r\n", "\r\n < ");
        str.length();
        return str;
    }
}
