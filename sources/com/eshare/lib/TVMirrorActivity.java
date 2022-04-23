package com.eshare.lib;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class TVMirrorActivity extends Activity implements View.OnClickListener {

    /* renamed from: b */
    private b.b.a.a f2991b;

    /* renamed from: c */
    private String f2992c;

    /* renamed from: d */
    private ImageView f2993d;

    /* renamed from: e */
    private RelativeLayout f2994e;

    /* renamed from: f */
    private ImageButton imageButton;

    /* renamed from: g */
    private LinearLayout layout;
    private volatile boolean h;
    private Thread i;
    private Thread j;

    /* renamed from: k */
    private DatagramSocket socket;

    /* renamed from: l */
    private long timer;

    /* renamed from: n */
    private BlockingQueue<ByteArrayOutputStream> blockingQueue;

    /* renamed from: o */
    private Bitmap bitmap;
    private stream m = new stream();
    @SuppressLint({"HandlerLeak"})
    private final Handler p = new a();

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i == 2 && TVMirrorActivity.this.socket != null) {
                    b.b.a.n.e.getScreenCapture(TVMirrorActivity.this.socket, TVMirrorActivity.this.f2992c);
                    TVMirrorActivity.this.timer = System.currentTimeMillis();
                    sendMessageDelayed(obtainMessage(2), 100L);
                }
            } else if (TVMirrorActivity.this.f2993d != null && TVMirrorActivity.this.bitmap != null) {
                TVMirrorActivity.this.f2993d.setImageBitmap(TVMirrorActivity.this.bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements bytestream {
        b() {
        }

        @Override // com.eshare.lib.bytestream
        public void a(int i, ByteArrayOutputStream byteArrayOutputStream, boolean z, String str) {
            if (z) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(byteArrayOutputStream.size());
                try {
                    byteArrayOutputStream.writeTo(byteArrayOutputStream2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                TVMirrorActivity.this.blockingQueue.clear();
                TVMirrorActivity.this.blockingQueue.offer(byteArrayOutputStream2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnTouchListener {
        c(TVMirrorActivity tVMirrorActivity) {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            TVMirrorActivity.this.f2991b.c().a(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(Process.myTid(), -8);
            if (TVMirrorActivity.this.socket != null) {
                byte[] bArr = new byte[1450];
                boolean z = false;
                while (!TVMirrorActivity.this.h) {
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                    if ((System.currentTimeMillis() - TVMirrorActivity.this.timer >= 100 || TVMirrorActivity.this.timer == 0) && !z) {
                        b.b.a.n.e.getScreenCapture(TVMirrorActivity.this.socket, TVMirrorActivity.this.f2992c);
                        TVMirrorActivity.this.timer = System.currentTimeMillis();
                    }
                    try {
                        TVMirrorActivity.this.socket.receive(datagramPacket);
                        if (stream.a(bArr, 0) == 1) {
                            TVMirrorActivity.this.m.a((String) null, bArr);
                        }
                        if (!z && !TVMirrorActivity.this.p.hasMessages(2)) {
                            TVMirrorActivity.this.p.sendEmptyMessage(2);
                            z = true;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(Process.myTid(), -8);
            while (!TVMirrorActivity.this.h) {
                try {
                    byte[] byteArray = ((ByteArrayOutputStream) TVMirrorActivity.this.blockingQueue.take()).toByteArray();
                    TVMirrorActivity.this.bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    TVMirrorActivity.this.p.sendEmptyMessage(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TVMirrorActivity.this.imageButton.setVisibility(0);
        }
    }

    private int a(String str, String str2) {
        return b.b.a.n.f.a(this, str, str2);
    }

    private void a() {
        this.f2993d = (ImageView) findViewById(a("id", "eshare_iv_tv_mirror"));
        this.f2994e = (RelativeLayout) findViewById(a("id", "eshare_rl_tv_mirror"));
        this.imageButton = (ImageButton) findViewById(a("id", "eshare_ib_tv_mirror_out"));
        this.layout = (LinearLayout) findViewById(a("id", "eshare_ll_tv_mirror_tools"));
        this.imageButton.setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_in")).setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_close")).setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_home")).setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_back")).setOnClickListener(this);
    }

    private void b() {
        this.blockingQueue = new ArrayBlockingQueue(2);
        this.m.setstream(new b());
    }

    private void c() {
        this.f2993d.setOnTouchListener(new c(this));
        this.f2994e.setOnTouchListener(new d());
    }

    private void d() {
        this.j = new Thread(new f());
        this.j.start();
    }

    private void e() {
        if (this.socket == null) {
            try {
                this.socket = new DatagramSocket();
                this.socket.setSoTimeout(100);
                this.socket.setReceiveBufferSize(this.socket.getReceiveBufferSize() * 2);
                b.b.a.n.e.getScreenCapture(this.socket, this.f2992c);
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        this.i = new Thread(new e());
        this.i.start();
    }

    private void f() {
        this.h = false;
        e();
        d();
    }

    private void g() {
        Thread thread = this.j;
        if (thread != null) {
            this.h = true;
            thread.interrupt();
        }
    }

    private void h() {
        Thread thread = this.i;
        if (thread != null) {
            this.h = true;
            thread.interrupt();
        }
    }

    private void i() {
        this.h = true;
        this.p.removeMessages(2);
        h();
        g();
    }

    @TargetApi(11)
    public void a(boolean z) {
        if (z) {
            this.imageButton.setVisibility(8);
            LinearLayout linearLayout = this.layout;
            ObjectAnimator.ofFloat(linearLayout, "translationX", linearLayout.getMeasuredWidth(), 0.0f).setDuration(250L).start();
            return;
        }
        LinearLayout linearLayout2 = this.layout;
        ObjectAnimator.ofFloat(linearLayout2, "translationX", 0.0f, linearLayout2.getMeasuredWidth()).setDuration(250L).start();
        this.imageButton.postDelayed(new g(), 250L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.b.a.f c2;
        int i;
        boolean z;
        int id = view.getId();
        if (id == a("id", "eshare_ib_tv_mirror_out")) {
            z = true;
        } else if (id == a("id", "eshare_ib_tv_mirror_in")) {
            z = false;
        } else if (id == a("id", "eshare_ib_tv_mirror_close")) {
            finish();
            return;
        } else {
            if (id == a("id", "eshare_ib_tv_mirror_home")) {
                c2 = this.f2991b.c();
                i = 3;
            } else if (id == a("id", "eshare_ib_tv_mirror_back")) {
                c2 = this.f2991b.c();
                i = 4;
            } else {
                return;
            }
            c2.e(i);
            return;
        }
        a(z);
    }

    @Override // android.app.Activity
    @TargetApi(9)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2991b = b.b.a.a.a(this);
        setContentView(a("layout", "eshare_activity_tv_mirror"));
        this.f2992c = getIntent().getStringExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS");
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        }
        a();
        b();
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25 || i == 24) {
            this.f2991b.c().e(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        i();
        f();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        i();
    }
}
