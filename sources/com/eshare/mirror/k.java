package com.eshare.mirror;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private j f3086a;

    /* renamed from: c  reason: collision with root package name */
    private String f3088c;

    /* renamed from: d  reason: collision with root package name */
    private Context f3089d;

    /* renamed from: e  reason: collision with root package name */
    private a f3090e;
    private int i;
    private int f = 0;
    private int g = 1920;
    private int h = 1080;
    private boolean j = false;

    /* renamed from: b  reason: collision with root package name */
    private MediaProjection f3087b = c.e().a();

    /* loaded from: classes.dex */
    private class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f3091b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f3092c;
        private int g;
        private int h;
        private MediaCodec i;
        private VirtualDisplay j;
        private ImageReader l;
        private Surface m;
        private Surface n;
        private Bitmap o;
        private i r;
        private HandlerThread s;
        private boolean t;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f3093d = new byte[2097152];

        /* renamed from: e  reason: collision with root package name */
        private ByteBuffer f3094e = ByteBuffer.allocate(128).order(ByteOrder.LITTLE_ENDIAN);
        private ByteBuffer f = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        private MediaCodec.BufferInfo k = new MediaCodec.BufferInfo();
        private Object q = new Object();
        private Paint p = new Paint();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.eshare.mirror.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0091a implements ImageReader.OnImageAvailableListener {
            C0091a() {
            }

            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader imageReader) {
                synchronized (a.this.q) {
                    if (a.this.l == null) {
                        Log.e("MirrorVideoEncoder", "Reader is already free!!!!");
                        return;
                    }
                    Image acquireLatestImage = imageReader.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        Image.Plane[] planes = acquireLatestImage.getPlanes();
                        if (planes.length > 0) {
                            ByteBuffer buffer = planes[0].getBuffer();
                            int pixelStride = planes[0].getPixelStride();
                            int rowStride = a.this.g + ((planes[0].getRowStride() - (acquireLatestImage.getWidth() * pixelStride)) / pixelStride);
                            int i = a.this.h;
                            if (a.this.o == null) {
                                String str = "ImageReader create bitmap " + a.this.g + " x " + a.this.h;
                                a.this.o = Bitmap.createBitmap(rowStride, i, Bitmap.Config.ARGB_8888);
                            }
                            a.this.o.copyPixelsFromBuffer(buffer);
                            a.this.t = true;
                        }
                        acquireLatestImage.close();
                    }
                }
            }
        }

        public a() {
        }

        private void a(long j) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        private boolean a(byte[] bArr, int i, short s, long j) {
            this.f.rewind();
            d.b(j).a(this.f, 0);
            this.f3094e.rewind();
            this.f3094e.position(0);
            this.f3094e.putInt(i);
            this.f3094e.putShort(s);
            this.f3094e.putShort((short) 0);
            this.f3094e.put(this.f);
            i iVar = this.r;
            if (iVar == null) {
                return true;
            }
            iVar.a(this.f3094e.array(), this.f3094e.array().length);
            return this.r.a(bArr, i);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void d() {
            /*
                r11 = this;
                r0 = 0
                r2 = r0
            L_0x0003:
                com.eshare.mirror.k r4 = com.eshare.mirror.k.this
                com.eshare.mirror.k$a r4 = com.eshare.mirror.k.e(r4)
                if (r4 == 0) goto L_0x00ab
                com.eshare.mirror.k r4 = com.eshare.mirror.k.this
                com.eshare.mirror.k$a r4 = com.eshare.mirror.k.e(r4)
                boolean r4 = r4.a()
                if (r4 == 0) goto L_0x00ab
                boolean r4 = r11.f3092c
                if (r4 == 0) goto L_0x001d
                goto L_0x00ab
            L_0x001d:
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r0
                r6 = 1000(0x3e8, float:1.401E-42)
                com.eshare.mirror.k r7 = com.eshare.mirror.k.this
                int r7 = com.eshare.mirror.k.b(r7)
                int r6 = r6 / r7
                long r6 = (long) r6
                r8 = 0
                int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r9 >= 0) goto L_0x0032
                goto L_0x0052
            L_0x0032:
                long r0 = java.lang.System.currentTimeMillis()
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r2
                java.lang.Object r6 = r11.q
                monitor-enter(r6)
                boolean r7 = r11.t     // Catch: all -> 0x00a8
                if (r7 != 0) goto L_0x0048
                r9 = 120(0x78, double:5.93E-322)
                int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r7 < 0) goto L_0x0051
            L_0x0048:
                r11.i()     // Catch: all -> 0x00a8
                long r2 = java.lang.System.currentTimeMillis()     // Catch: all -> 0x00a8
                r11.t = r8     // Catch: all -> 0x00a8
            L_0x0051:
                monitor-exit(r6)     // Catch: all -> 0x00a8
            L_0x0052:
                r4 = 0
                int r5 = android.os.Build.VERSION.SDK_INT
                r6 = 21
                if (r5 >= r6) goto L_0x005f
                android.media.MediaCodec r4 = r11.i
                java.nio.ByteBuffer[] r4 = r4.getOutputBuffers()
            L_0x005f:
                android.media.MediaCodec r5 = r11.i
                android.media.MediaCodec$BufferInfo r7 = r11.k
                r9 = 10000(0x2710, double:4.9407E-320)
                int r5 = r5.dequeueOutputBuffer(r7, r9)
                r7 = -2
                if (r5 != r7) goto L_0x0072
                android.media.MediaCodec r4 = r11.i
                r4.getOutputFormat()
                goto L_0x0094
            L_0x0072:
                r7 = -1
                if (r5 != r7) goto L_0x0076
                goto L_0x0094
            L_0x0076:
                if (r5 < 0) goto L_0x0094
                int r7 = android.os.Build.VERSION.SDK_INT
                if (r7 >= r6) goto L_0x0084
                android.media.MediaCodec$BufferInfo r6 = r11.k
                r4 = r4[r5]
                r11.a(r6, r4)
                goto L_0x008f
            L_0x0084:
                android.media.MediaCodec$BufferInfo r4 = r11.k
                android.media.MediaCodec r6 = r11.i
                java.nio.ByteBuffer r6 = r6.getOutputBuffer(r5)
                r11.a(r4, r6)
            L_0x008f:
                android.media.MediaCodec r4 = r11.i
                r4.releaseOutputBuffer(r5, r8)
            L_0x0094:
                boolean r4 = r11.e()
                if (r4 != 0) goto L_0x00a2
                com.eshare.mirror.k r4 = com.eshare.mirror.k.this
                boolean r4 = com.eshare.mirror.k.f(r4)
                if (r4 == 0) goto L_0x0003
            L_0x00a2:
                com.eshare.mirror.k r0 = com.eshare.mirror.k.this
                com.eshare.mirror.k.a(r0, r8)
                goto L_0x00ab
            L_0x00a8:
                r0 = move-exception
                monitor-exit(r6)     // Catch: all -> 0x00a8
                throw r0
            L_0x00ab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eshare.mirror.k.a.d():void");
        }

        private boolean e() {
            int i;
            int i2;
            Display defaultDisplay = ((WindowManager) k.this.f3089d.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int i3 = point.x;
            int i4 = point.y;
            if (i3 <= i4) {
                i2 = k.this.a((i3 * 1080) / i4, 16);
                i = 1088;
            } else if (i3 * i4 >= k.this.g * k.this.h) {
                i2 = k.this.g;
                i = k.this.h;
            } else {
                i2 = i3;
                i = i4;
            }
            if (this.g == i2 && this.h == i) {
                return false;
            }
            this.g = i2;
            this.h = i;
            String str = "Codec init with " + i2 + " x " + i + " " + i3 + " " + i4;
            return true;
        }

        private void f() {
            HandlerThread handlerThread = this.s;
            if (handlerThread != null) {
                handlerThread.quit();
                this.s = null;
            }
            synchronized (this.q) {
                if (this.l != null) {
                    this.l.close();
                    this.l = null;
                }
            }
            this.o = null;
            MediaCodec mediaCodec = this.i;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.i.release();
                this.i = null;
            }
            VirtualDisplay virtualDisplay = this.j;
            if (virtualDisplay != null) {
                virtualDisplay.release();
                this.j = null;
            }
        }

        private void g() {
            i iVar = this.r;
            if (iVar != null) {
                iVar.b();
                this.r = null;
            }
        }

        private boolean h() {
            this.r = new i(k.this.f3088c, 51030);
            return this.r.a();
        }

        private void i() {
            Surface surface = this.m;
            if (surface != null && this.o != null) {
                Canvas lockCanvas = surface.lockCanvas(null);
                lockCanvas.drawColor(-16777216);
                lockCanvas.drawBitmap(this.o, 0.0f, 0.0f, this.p);
                this.m.unlockCanvasAndPost(lockCanvas);
            }
        }

        private void j() {
            this.s = new HandlerThread("eshare");
            this.s.start();
            e();
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.g, this.h);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", k.this.d());
            createVideoFormat.setInteger("frame-rate", k.this.i);
            createVideoFormat.setInteger("i-frame-interval", 86400);
            this.i = MediaCodec.createEncoderByType("video/avc");
            this.i.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.m = this.i.createInputSurface();
            this.l = ImageReader.newInstance(this.g, this.h, 1, 2);
            this.l.setOnImageAvailableListener(new C0091a(), new Handler(this.s.getLooper()));
            this.n = this.l.getSurface();
            this.j = k.this.f3087b.createVirtualDisplay("screen", this.g, this.h, 1, 1, this.n, null, null);
            this.i.start();
            String str = "prepareEncoder over " + this.g + " " + this.h;
        }

        @SuppressLint({"NewApi"})
        protected void a(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer) {
            int length = this.f3093d.length;
            int i = bufferInfo.size;
            if (length < i) {
                this.f3093d = new byte[i];
            }
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            byteBuffer.get(this.f3093d, 0, bufferInfo.size);
            long j = bufferInfo.presentationTimeUs / 1000;
            int i2 = bufferInfo.flags & 2;
            byte[] bArr = this.f3093d;
            int i3 = bufferInfo.size;
            if (!(i2 == 2 ? a(bArr, i3, (short) 256, j) : a(bArr, i3, (short) 257, j))) {
                k.this.f = 259;
            }
        }

        public boolean a() {
            return this.f3091b;
        }

        public synchronized void b() {
            String str = "Encoder Thread begin " + this;
            start();
            while (!this.f3091b) {
                a(50L);
            }
            String str2 = "Encoder Thread  over " + this;
        }

        public synchronized void c() {
            String str = "Encoder Thread  exit begin " + this;
            if (this.f3091b) {
                this.f3092c = true;
                g();
                while (this.f3092c) {
                    a(50L);
                }
                this.f3091b = false;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f3091b = true;
            try {
                try {
                    if (h()) {
                        if (k.this.f3086a != null) {
                            k.this.f3086a.a(0);
                        }
                        while (this.f3091b && !this.f3092c) {
                            j();
                            d();
                            f();
                        }
                        this.f3092c = false;
                    } else if (k.this.f3086a != null) {
                        k.this.f3086a.a(256);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (k.this.f3086a != null) {
                        k.this.f3086a.a(256);
                    }
                    Log.e("MirrorVideoEncoder", "encode error");
                }
                Log.e("MirrorVideoEncoder", "encode thread exit...");
            } finally {
                this.f3092c = false;
                this.f3091b = false;
            }
        }
    }

    public k(Context context, String str) {
        int i = 20;
        this.i = 20;
        this.f3088c = str;
        this.f3089d = context;
        this.i = e() ? 25 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2) {
        int i3 = i2 - 1;
        return (i + i3) & (i3 ^ (-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        int i;
        return (this.g * this.h < 2073600 || (i = this.i) == 20 || i == 30 || i != 60) ? 4194304 : 8388608;
    }

    public static boolean e() {
        return Build.HARDWARE.matches("mt[0-9]*");
    }

    public int a() {
        return this.f;
    }

    public void a(int i, int i2, int i3) {
        if (i > 0 && i2 > 0 && i3 > 0) {
            if (i != this.g || i2 != this.h || this.i != i3) {
                this.g = i;
                this.h = i2;
                this.i = i3;
                this.j = true;
                String.format("Video Target %dx%d-%d,%d", Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(d()));
            }
        }
    }

    public void a(j jVar) {
        this.f3086a = jVar;
    }

    public synchronized void b() {
        if (this.f3090e == null) {
            this.f3090e = new a();
            this.f3090e.b();
        }
    }

    public synchronized void c() {
        if (this.f3090e != null) {
            this.f3090e.c();
            this.f3090e = null;
        }
    }
}
