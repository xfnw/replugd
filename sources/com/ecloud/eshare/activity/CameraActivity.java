package com.ecloud.eshare.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.util.i;
import com.ecloud.eshare.util.j;
import com.ecloud.eshare.util.k;
import com.ecloud.eshare.util.o;
import com.ecloud.eshare.util.q;
import com.ecloud.eshare.util.w;
import com.squareup.picasso.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class CameraActivity extends com.ecloud.eshare.activity.a implements View.OnClickListener, k, j, View.OnTouchListener, SensorEventListener {
    private static Camera K0;
    private static DatagramSocket L0;
    private static h M0;
    private static com.ecloud.eshare.f.h N0;
    public static CameraActivity O0;
    private double A0;
    private TextView F0;
    private ImageView H0;
    private SurfaceView I;
    private String I0;
    private SurfaceHolder J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private YuvImage N;
    private w R;
    private BlockingQueue<Integer> S;
    private b.b.b.a T;
    private InetAddress V;
    private volatile boolean X;
    private g Y;
    private o Z;
    private b.b.a.c e0;
    private b.b.a.a f0;
    private boolean h0;
    private boolean i0;
    private boolean j0;
    private SensorManager k0;
    private Sensor l0;
    private b.b.a.g s0;
    private ImageView t0;
    private Bitmap u0;
    private int v0;
    Boolean H = false;
    private int O = 70;
    private int P = 320;
    private int Q = 240;
    private byte[] U = new byte[1450];
    private volatile boolean W = true;
    private int a0 = 0;
    private volatile int b0 = 0;
    private volatile int c0 = 0;
    private int d0 = 0;
    private String g0 = Environment.getExternalStorageDirectory().getAbsolutePath();
    private boolean m0 = true;
    private boolean n0 = false;
    private float o0 = 0.0f;
    private float p0 = 0.0f;
    private float q0 = 0.0f;
    private long r0 = 0;
    private Camera.PreviewCallback w0 = new a();
    private Camera.AutoFocusCallback x0 = new b();
    @SuppressLint({"HandlerLeak"})
    private Handler y0 = new c();
    private SurfaceHolder.Callback z0 = new d();
    private int B0 = 1;
    private double C0 = 1.0d;
    private double D0 = 1.0d;
    private boolean E0 = true;
    private Boolean G0 = false;
    private int J0 = 25123;

    /* loaded from: classes.dex */
    class a implements Camera.PreviewCallback {
        a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraActivity cameraActivity = CameraActivity.this;
            cameraActivity.N = new YuvImage(bArr, 17, cameraActivity.P, CameraActivity.this.Q, null);
        }
    }

    /* loaded from: classes.dex */
    class b implements Camera.AutoFocusCallback {
        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            CameraActivity.this.m0 = true;
        }
    }

    /* loaded from: classes.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                File file = new File((String) message.obj);
                if (!CameraActivity.this.e0.p()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    arrayList.add(file);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((File) it.next()).getName());
                    }
                    CameraActivity.this.s0.a(((File) arrayList.get(0)).getParent(), arrayList2, 0);
                    Toast.makeText(CameraActivity.this.getApplicationContext(), (String) message.obj, 0).show();
                } else {
                    CameraActivity.this.s0.b(file);
                }
                CameraActivity.this.y0.sendEmptyMessageDelayed(2, 1000L);
                i.a(CameraActivity.this, file);
            } else if (i == 2) {
                CameraActivity.this.finish();
            } else if (i == 100) {
                CameraActivity.this.y();
            } else if (i == 101) {
                c.a.a.e.a(CameraActivity.this.getApplicationContext(), CameraActivity.this.getString(R.string.host_function_disabled), null, CameraActivity.this.getResources().getColor(R.color.c_666666), CameraActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements SurfaceHolder.Callback {
        d() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            CameraActivity.this.c(i2, i3);
            CameraActivity.this.N();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (CameraActivity.K0 != null) {
                CameraActivity.K0.stopPreview();
                CameraActivity.K0.setPreviewCallback(null);
                CameraActivity.K0.release();
                Camera unused = CameraActivity.K0 = null;
            }
            CameraActivity.this.N = null;
        }
    }

    /* loaded from: classes.dex */
    class e implements b.b.b.b {
        e() {
        }

        @Override // b.b.b.b
        public void a(byte[] bArr) {
            try {
                CameraActivity.L0.send(new DatagramPacket(bArr, 1450, CameraActivity.this.V, 48689));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements o.a {
        f() {
        }

        @Override // com.ecloud.eshare.util.o.a
        public void a(int i) {
            ImageView imageView;
            float f;
            CameraActivity.this.v0 = i;
            if (i != -1) {
                if (i >= 310 || i <= 50) {
                    imageView = CameraActivity.this.K;
                    f = 0.0f;
                } else if (i >= 50 && i <= 140) {
                    imageView = CameraActivity.this.K;
                    f = 270.0f;
                } else if (i <= 140 || i > 220) {
                    imageView = CameraActivity.this.K;
                    f = 90.0f;
                } else {
                    imageView = CameraActivity.this.K;
                    f = 180.0f;
                }
                imageView.setRotation(f);
                CameraActivity.this.L.setRotation(f);
                CameraActivity.this.H0.setRotation(f);
            }
        }
    }

    /* loaded from: classes.dex */
    private class g extends OrientationEventListener {
        public g(Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (i != -1) {
                if (Math.abs(i - CameraActivity.this.d0) > 44) {
                    CameraActivity.this.d0 = i;
                    return;
                }
                CameraActivity cameraActivity = CameraActivity.this;
                cameraActivity.a0 = CameraActivity.d(i, cameraActivity.a0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends Thread {

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f2533b;

        h() {
        }

        void a() {
            this.f2533b = true;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:25|(3:28|(5:30|97|31|116|32)(1:115)|26)|114|33|(2:91|34)|36|(1:54)(2:40|(2:45|(8:53|57|99|58|59|89|60|65)(1:49))(1:44))|56|57|99|58|59|89|60|65) */
        /* JADX WARN: Can't wrap try/catch for region: R(16:25|(3:28|(5:30|97|31|116|32)(1:115)|26)|114|33|91|34|36|(1:54)(2:40|(2:45|(8:53|57|99|58|59|89|60|65)(1:49))(1:44))|56|57|99|58|59|89|60|65) */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00f8, code lost:
            if (r22.f2534c.H.booleanValue() == false) goto L_0x00fa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00fa, code lost:
            r0 = com.ecloud.eshare.activity.CameraActivity.a(270, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00ff, code lost:
            r0 = com.ecloud.eshare.activity.CameraActivity.a(90, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
            if (r22.f2534c.H.booleanValue() == false) goto L_0x00ff;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x017f, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0181, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0182, code lost:
            r20 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0184, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:104:0x01fd A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x01e4 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0199  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 520
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.CameraActivity.h.run():void");
        }
    }

    private void B() {
        this.h0 = false;
        Camera camera = K0;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode("off");
            try {
                K0.setParameters(parameters);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void C() {
        b(!this.G0.booleanValue());
    }

    private void D() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                Camera camera = K0;
                if (camera != null) {
                    camera.stopPreview();
                    K0.setPreviewCallback(null);
                    K0.release();
                    K0 = null;
                }
                try {
                    K0 = Camera.open(i);
                    if (K0 != null) {
                        this.B0 = F();
                        TextView textView = this.F0;
                        textView.setText("× " + ((int) Math.round(this.D0)));
                    }
                    this.b0 = i;
                    c(this.P, this.Q);
                    N();
                    this.j0 = true;
                    return;
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static CameraActivity E() {
        return O0;
    }

    private int F() {
        Camera.Parameters parameters = K0.getParameters();
        if (!parameters.isZoomSupported()) {
            return -1;
        }
        return parameters.getMaxZoom();
    }

    private void G() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            int i2 = cameraInfo.facing;
            if (i2 == 1 || i2 == 0) {
                try {
                    K0 = Camera.open(i);
                    if (K0 != null) {
                        this.B0 = F();
                        TextView textView = this.F0;
                        textView.setText("× " + ((int) Math.round(this.D0)));
                    }
                    this.b0 = i;
                    return;
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    private boolean H() {
        List<String> supportedFocusModes = K0.getParameters().getSupportedFocusModes();
        return supportedFocusModes != null && supportedFocusModes.contains("auto");
    }

    private void I() {
        this.e0.n();
    }

    private void J() {
        this.h0 = true;
        Camera camera = K0;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode("torch");
            try {
                K0.setParameters(parameters);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void K() {
        if (K0 != null && H()) {
            String focusMode = K0.getParameters().getFocusMode();
            if (focusMode.equals("auto") || focusMode.equals("macro")) {
                K0.autoFocus(this.x0);
            }
        }
    }

    private void L() {
        if (K0 != null) {
            K0.setDisplayOrientation(b(a((Activity) this), this.b0));
        }
    }

    private void M() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(this.R, intentFilter);
        d(0);
        this.e0.g();
        if (this.G0.booleanValue() && N0 == null) {
            N0 = new com.ecloud.eshare.f.h(this.I0, this.J0);
            N0.start();
        }
        if (this.W) {
            DatagramSocket datagramSocket = L0;
            if (datagramSocket != null) {
                datagramSocket.disconnect();
                L0.close();
            }
            try {
                L0 = new DatagramSocket();
                L0.setSendBufferSize(65536);
            } catch (SocketException unused) {
            }
            try {
                this.V = InetAddress.getByName(this.f0.d());
            } catch (UnknownHostException unused2) {
            }
            this.W = false;
            M0 = new h();
            M0.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Camera camera = K0;
        if (camera != null) {
            camera.stopPreview();
            K0.setPreviewCallback(this.w0);
            try {
                L();
                K0.startPreview();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        K();
    }

    private double a(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
        float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
        return Math.sqrt((abs * abs) + (abs2 * abs2));
    }

    public static int a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (!(createBitmap == bitmap || bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private Camera.Size a(List<Camera.Size> list, int i, int i2) {
        double d2 = i;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d5 = Double.MAX_VALUE;
        double d6 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            double d7 = size2.width;
            double d8 = size2.height;
            Double.isNaN(d7);
            Double.isNaN(d8);
            if (Math.abs((d7 / d8) - d4) <= 0.05d && Math.abs(size2.height - i2) < d6) {
                d6 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                int i3 = i * i2;
                if (Math.abs((size3.height * size3.width) - i3) < d5) {
                    d5 = Math.abs((size3.height * size3.width) - i3);
                    size = size3;
                }
            }
        }
        return size;
    }

    private byte[] a(InputStream inputStream) {
        byte[] bArr = null;
        try {
            byte[] bArr2 = new byte[inputStream.available()];
            inputStream.read(bArr2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr2);
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            inputStream.close();
            return bArr;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public static int b(int i, int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2) {
        if (K0 != null && this.J.getSurface() != null) {
            try {
                K0.setPreviewDisplay(this.J);
            } catch (Throwable unused) {
            }
            Camera.Parameters parameters = K0.getParameters();
            Camera.Size a2 = a(parameters.getSupportedPreviewSizes(), 1280, 720);
            this.Q = a2.height;
            this.P = a2.width;
            parameters.setPreviewSize(this.P, this.Q);
            if (this.j0) {
                parameters.setExposureCompensation(0);
                parameters.setFocusMode("continuous-picture");
            }
            parameters.setFlashMode(this.h0 ? "torch" : "off");
            try {
                K0.setParameters(parameters);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int d(int i, int i2) {
        boolean z = true;
        if (i2 != -1) {
            int abs = Math.abs(i - i2);
            if (Math.min(abs, 360 - abs) < 50) {
                z = false;
            }
        }
        return z ? (((i + 45) / 90) * 90) % 360 : i2;
    }

    private void e(int i) {
        Camera.Parameters parameters = K0.getParameters();
        if (parameters.isZoomSupported()) {
            if (i > parameters.getMaxZoom() || i < 0) {
                throw new IllegalArgumentException();
            }
            parameters.setZoom(i);
            K0.setParameters(parameters);
        }
    }

    static /* synthetic */ int j(CameraActivity cameraActivity) {
        int i = cameraActivity.c0;
        cameraActivity.c0 = i - 1;
        return i;
    }

    public byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = null;
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, this.O, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        int i;
        this.G0 = Boolean.valueOf(z);
        if (z) {
            if (N0 == null) {
                N0 = new com.ecloud.eshare.f.h(this.I0, this.J0);
                N0.start();
            }
            imageView = this.H0;
            i = R.drawable.maikefeng_on;
        } else {
            com.ecloud.eshare.f.h hVar = N0;
            if (hVar != null) {
                hVar.a();
                N0 = null;
            }
            imageView = this.H0;
            i = R.drawable.maikefeng_off;
        }
        imageView.setImageResource(i);
    }

    public void d(int i) {
        this.S.offer(Integer.valueOf(i));
    }

    @Override // android.app.Activity
    public void finish() {
        this.W = true;
        h hVar = M0;
        if (hVar != null) {
            hVar.a();
        }
        try {
            unregisterReceiver(this.R);
        } catch (Exception unused) {
        }
        I();
        super.finish();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_MIRROR) {
            finish();
            this.y0.sendEmptyMessage(101);
        }
    }

    @Override // com.ecloud.eshare.util.k
    public void h() {
        finish();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // a.k.a.d, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int id = view.getId();
        int i = R.drawable.light_open;
        switch (id) {
            case R.id.cameraview /* 2131230803 */:
                if (K0 != null) {
                    try {
                        if (H()) {
                            Camera.Parameters parameters = K0.getParameters();
                            parameters.setFocusMode("auto");
                            K0.setParameters(parameters);
                            K0.autoFocus(this.x0);
                            return;
                        }
                        return;
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                        return;
                    }
                } else {
                    return;
                }
            case R.id.image_save /* 2131230899 */:
                if (q.b(this, 1001)) {
                    y();
                    return;
                }
                return;
            case R.id.iv_camera_close /* 2131230912 */:
                finish();
                return;
            case R.id.iv_speaker /* 2131230960 */:
                if (q.f(this)) {
                    C();
                    return;
                }
                return;
            case R.id.light /* 2131230979 */:
                if (this.h0) {
                    B();
                    imageView = this.K;
                } else {
                    J();
                    imageView = this.K;
                    i = R.drawable.light_close;
                }
                imageView.setImageResource(i);
                return;
            case R.id.switchover /* 2131231141 */:
                this.c0 = 3;
                this.H = Boolean.valueOf(!this.H.booleanValue());
                if (this.j0) {
                    this.j0 = false;
                    Camera camera = K0;
                    if (camera != null) {
                        camera.stopPreview();
                        K0.setPreviewCallback(null);
                        K0.release();
                        K0 = null;
                    }
                    try {
                        this.h0 = false;
                        this.K.setImageResource(R.drawable.light_open);
                        K0 = Camera.open();
                        if (K0 != null) {
                            this.B0 = F();
                            TextView textView = this.F0;
                            textView.setText("× " + ((int) Math.round(this.D0)));
                        }
                        this.b0 = 0;
                        c(this.P, this.Q);
                        N();
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                } else {
                    this.h0 = false;
                    this.K.setImageResource(R.drawable.light_open);
                    D();
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O0 = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        if (this.j0) {
            K0 = Camera.open();
        }
        Camera camera = K0;
        if (camera != null) {
            camera.stopPreview();
            K0.setPreviewCallback(null);
            K0.release();
            K0 = null;
        }
        this.k0.unregisterListener(this);
        try {
            unregisterReceiver(this.R);
            if (this.Y != null) {
                this.Y.disable();
            }
        } catch (Exception unused) {
        }
        com.ecloud.eshare.f.h hVar = N0;
        if (hVar != null) {
            hVar.a();
            N0 = null;
        }
        h hVar2 = M0;
        if (hVar2 != null && hVar2.isAlive()) {
            M0.a();
        }
        I();
        g gVar = this.Y;
        if (gVar != null) {
            gVar.disable();
            this.Y = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onPause() {
        this.Z.disable();
        super.onPause();
    }

    @Override // a.k.a.d, android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (iArr[i2] != 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i != 1001) {
            if (i == 1010 && z) {
                C();
            }
        } else if (z) {
            this.y0.sendEmptyMessage(100);
        }
    }

    @Override // a.k.a.d, android.app.Activity
    public void onResume() {
        super.onResume();
        this.Z.enable();
        this.X = false;
        this.k0.registerListener(this, this.l0, 2);
        g gVar = this.Y;
        if (gVar != null) {
            gVar.enable();
        }
        try {
            if (K0 == null) {
                K0 = Camera.open();
                if (K0 != null) {
                    this.B0 = F();
                    TextView textView = this.F0;
                    textView.setText("× " + ((int) Math.round(this.D0)));
                }
            }
        } catch (Exception unused) {
        }
        try {
            if (K0 == null) {
                G();
            }
        } catch (Exception unused2) {
        }
        Camera camera = K0;
        if (camera != null) {
            try {
                camera.autoFocus(this.x0);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        if (K0 == null) {
            this.W = false;
            finish();
        }
        if (this.W && this.f0.d() != null) {
            h hVar = M0;
            if (hVar != null) {
                hVar.a();
            }
            M();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.r0;
        if (currentTimeMillis - j >= 3000 && j != 0) {
            this.r0 = currentTimeMillis;
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if (!this.n0) {
                this.o0 = f2;
                this.p0 = f3;
                this.q0 = f4;
                this.n0 = true;
            }
            float abs = Math.abs(this.o0 - f2);
            float abs2 = Math.abs(this.p0 - f3);
            float abs3 = Math.abs(this.q0 - f4);
            if (abs > 0.5d && this.m0) {
                this.m0 = false;
                K();
            }
            if (abs2 > 0.5d && this.m0) {
                this.m0 = false;
                K();
            }
            if (abs3 > 0.5d && this.m0) {
                this.m0 = false;
                K();
            }
            this.o0 = f2;
            this.p0 = f3;
            this.q0 = f4;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.E0 = true;
        } else if (action != 2) {
            if (action == 5 && motionEvent.getPointerCount() == 2) {
                this.A0 = a(motionEvent);
                this.E0 = false;
            }
        } else if (motionEvent.getPointerCount() == 2) {
            double a2 = a(motionEvent);
            this.C0 = a2 / this.A0;
            if (this.E0) {
                this.C0 = 1.0d;
                this.E0 = false;
            }
            this.A0 = a2;
            this.D0 *= this.C0;
            double d2 = this.D0;
            int i = this.B0;
            if (d2 > i) {
                this.D0 = i;
            } else if (d2 < 1.0d) {
                this.D0 = 1.0d;
            }
            if (K0 != null) {
                e((int) Math.round(this.D0));
                this.F0.setText("× " + ((int) Math.round(this.D0)));
            }
        }
        return false;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.I = (SurfaceView) findViewById(R.id.cameraview);
        findViewById(R.id.root_view);
        this.I.setOnClickListener(this);
        this.I.setOnTouchListener(this);
        this.J = this.I.getHolder();
        this.J.addCallback(this.z0);
        this.J.setType(3);
        this.F0 = (TextView) findViewById(R.id.tv_camera_zoom);
        TextView textView = this.F0;
        textView.setText("× " + ((int) Math.round(this.D0)));
        this.K = (ImageView) findViewById(R.id.light);
        this.L = (ImageView) findViewById(R.id.switchover);
        this.M = (ImageView) findViewById(R.id.image_save);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.H0 = (ImageView) findViewById(R.id.iv_speaker);
        this.H0.setOnClickListener(this);
        this.t0 = (ImageView) findViewById(R.id.iv_camera_close);
        this.t0.setOnClickListener(this);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_camera;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.r = 0;
        Window window = getWindow();
        window.addFlags(128);
        window.setFlags(1024, 1024);
        this.Z = new o(this);
        this.f0 = b.b.a.a.a(this);
        this.e0 = this.f0.b();
        this.s0 = this.f0.e();
        this.I0 = this.e0.f().a();
        this.k0 = (SensorManager) getSystemService("sensor");
        this.l0 = this.k0.getDefaultSensor(1);
        this.S = new ArrayBlockingQueue(10);
        this.R = new w(this);
        this.T = new b.b.b.a();
        this.T.a(new e());
        this.Y = new g(this, 600000);
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        if (this.g0.contains("/emulated/0")) {
            this.g0 = "/sdcard";
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(this.g0 + "/eshare_image");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        if (Build.VERSION.SDK_INT > 8) {
            this.i0 = true;
        }
        if (!this.i0 || Camera.getNumberOfCameras() < 2) {
            this.L.setVisibility(8);
        }
        this.Z.a(new f());
    }

    public Bitmap v() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.N.compressToJpeg(new Rect(0, 0, this.P, this.Q), this.O, byteArrayOutputStream);
            this.u0 = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return this.u0;
    }

    public byte[] w() {
        byte[] bArr = null;
        if (this.N == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.N.compressToJpeg(new Rect(0, 0, this.P, this.Q), this.O, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public byte[] x() {
        return a(getResources().openRawResource(R.raw.emylive_standby));
    }

    public void y() {
        if (K0 != null) {
            try {
                if (H()) {
                    Camera.Parameters parameters = K0.getParameters();
                    parameters.setFocusMode("auto");
                    K0.setParameters(parameters);
                    this.m0 = false;
                    K0.autoFocus(this.x0);
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        this.X = true;
    }
}
