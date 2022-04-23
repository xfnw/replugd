package com.eshare.mirror;

import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.os.Build;
import android.util.Log;
import com.eshare.mirror.m.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private C0090a f3048a;

    /* renamed from: b  reason: collision with root package name */
    private b f3049b;

    /* renamed from: c  reason: collision with root package name */
    private com.eshare.mirror.m.b f3050c = new com.eshare.mirror.m.b(20);

    /* renamed from: d  reason: collision with root package name */
    private String f3051d;

    /* renamed from: com.eshare.mirror.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0090a extends c {
        public C0090a() {
        }

        @Override // com.eshare.mirror.m.c
        protected void a() {
            Socket socket = null;
            while (true) {
                while (b()) {
                    try {
                        if (socket == null) {
                            socket = a.this.a(a.this.f3051d, 25123);
                            a.this.f3050c.clear();
                        }
                        com.eshare.mirror.m.a a2 = a.this.f3050c.a(50L);
                        if (a2 != null) {
                            try {
                                socket.getOutputStream().write(a2.a(), 0, a2.b());
                                socket.getOutputStream().flush();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                socket.close();
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c {
        public b() {
        }

        @Override // com.eshare.mirror.m.c
        protected void a() {
            int minBufferSize = AudioRecord.getMinBufferSize(22050, 16, 2);
            AudioRecord audioRecord = null;
            AudioPlaybackCaptureConfiguration build = Build.VERSION.SDK_INT >= 29 ? new AudioPlaybackCaptureConfiguration.Builder(c.e().a()).addMatchingUsage(1).build() : null;
            AudioFormat build2 = new AudioFormat.Builder().setEncoding(2).setSampleRate(22050).setChannelMask(16).build();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && i >= 29) {
                audioRecord = new AudioRecord.Builder().setAudioFormat(build2).setBufferSizeInBytes(minBufferSize).setAudioPlaybackCaptureConfig(build).build();
            }
            try {
                try {
                    audioRecord.startRecording();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (audioRecord == null) {
                        return;
                    }
                }
                if (audioRecord.getRecordingState() == 3) {
                    byte[] bArr = new byte[480];
                    while (b()) {
                        int read = audioRecord.read(bArr, 0, 480);
                        if (read != 480) {
                            int i2 = 480 - read;
                            if (i2 != audioRecord.read(bArr, read, i2)) {
                                Log.e("eshare", "There's a bit of a carton in the voice");
                            }
                        }
                        a.this.f3050c.a(new com.eshare.mirror.m.a(bArr, 480, 0, 0L, false));
                        if (a.this.f3050c.size() >= 20) {
                            a.this.f3050c.clear();
                            Log.e("eshare", "the quene is full, drop some frames.");
                        }
                    }
                    if (audioRecord != null) {
                        audioRecord.stop();
                        audioRecord.release();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("AudioRecord instance failed to start recording");
            } catch (Throwable th) {
                if (audioRecord != null) {
                    audioRecord.stop();
                    audioRecord.release();
                }
                throw th;
            }
        }
    }

    public a(String str, int i) {
        this.f3051d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket a(String str, int i) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(InetAddress.getByName(str), i), 5000);
            socket.setSendBufferSize(16384);
            socket.setTcpNoDelay(true);
            return socket;
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.e("eshare", "Voice socket connect failed " + i);
            return null;
        }
    }

    public void a() {
        if (this.f3049b == null) {
            this.f3049b = new b();
            this.f3049b.c();
        }
        if (this.f3048a == null) {
            this.f3048a = new C0090a();
            this.f3048a.c();
        }
    }

    public void b() {
        b bVar = this.f3049b;
        if (bVar != null) {
            bVar.d();
            this.f3049b = null;
        }
        C0090a aVar = this.f3048a;
        if (aVar != null) {
            aVar.d();
            this.f3048a = null;
        }
    }
}
