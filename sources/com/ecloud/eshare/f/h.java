package com.ecloud.eshare.f;

import android.media.AudioRecord;
import android.os.Process;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public class h extends Thread {

    /* renamed from: b  reason: collision with root package name */
    private DatagramSocket f2829b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2830c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2831d;

    /* renamed from: e  reason: collision with root package name */
    private AudioRecord f2832e;
    private volatile boolean f;

    public h(String str, int i) {
        this.f2830c = str;
        this.f2831d = i;
    }

    public void a() {
        this.f = true;
        AudioRecord audioRecord = this.f2832e;
        if (audioRecord != null) {
            try {
                audioRecord.stop();
                this.f2832e.release();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
        DatagramSocket datagramSocket = this.f2829b;
        if (datagramSocket != null) {
            try {
                datagramSocket.disconnect();
                this.f2829b.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.f2829b = new DatagramSocket();
            this.f2829b.setSendBufferSize(2048);
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        try {
            Process.setThreadPriority(-19);
            byte[][] bArr = (byte[][]) Array.newInstance(byte.class, 256, 320);
            InetAddress byName = InetAddress.getByName(this.f2830c);
            this.f2832e = new AudioRecord(1, 11025, 2, 2, AudioRecord.getMinBufferSize(11025, 2, 2));
            this.f2832e.startRecording();
            int i = 0;
            while (!this.f) {
                i++;
                try {
                    byte[] bArr2 = bArr[i % bArr.length];
                    this.f2832e.read(bArr2, 0, bArr2.length);
                    this.f2829b.send(new DatagramPacket(bArr2, bArr2.length, byName, this.f2831d));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        } catch (UnknownHostException e5) {
            e5.printStackTrace();
        }
    }
}
