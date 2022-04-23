package com.eshare.mirror;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private String f3083a;

    /* renamed from: b  reason: collision with root package name */
    private Socket f3084b;

    /* renamed from: c  reason: collision with root package name */
    private int f3085c;

    public i(String str, int i) {
        this.f3083a = str;
        this.f3085c = i;
    }

    public boolean a() {
        try {
            this.f3084b = new Socket();
            this.f3084b.connect(new InetSocketAddress(InetAddress.getByName(this.f3083a), this.f3085c), 5000);
            this.f3084b.setTcpNoDelay(true);
            this.f3084b.setTrafficClass(136);
            this.f3084b.setSoTimeout(3000);
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(byte[] bArr, int i) {
        try {
            this.f3084b.getOutputStream().write(bArr, 0, i);
            this.f3084b.getOutputStream().flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b() {
        Socket socket = this.f3084b;
        if (socket != null) {
            try {
                socket.close();
                this.f3084b = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
