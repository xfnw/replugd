package com.ecloud.eshare.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.util.p;
import com.ecloud.eshare.util.q;
import com.ecloud.eshare.util.u;
import com.ecloud.eshare.view.NoteView;
import com.eshare.lib.bytestream;
import com.eshare.lib.stream;
import com.squareup.picasso.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class MirrorNoteActivity extends com.ecloud.eshare.activity.a {
    public static MirrorNoteActivity w0;
    private static WindowManager x0;
    private static View y0;
    private ExecutorService I;
    private b.b.a.a J;
    private b.b.a.f K;
    private LinearLayout L;
    private String M;
    private ImageView O;
    private RelativeLayout P;
    private Dialog Q;
    private volatile boolean T;
    private Thread U;
    private Thread V;
    private DatagramSocket W;
    private long X;
    private BlockingQueue<ByteArrayOutputStream> Z;
    private Bitmap a0;
    private AnimationSet b0;
    private AnimationSet c0;
    private com.ecloud.eshare.view.a d0;
    private WindowManager.LayoutParams e0;
    private n f0;
    private o g0;
    private b.b.a.c h0;
    private ProgressDialog i0;
    private NoteView k0;
    private ImageButton l0;
    private ImageButton m0;
    private ImageButton n0;
    private ImageButton o0;
    private ImageButton p0;
    private ImageButton q0;
    private ImageButton r0;
    private ImageButton s0;
    private ImageButton t0;
    private ImageButton u0;
    public boolean H = false;
    public int N = 0;
    private int R = R.id.bcb_back_color_11;
    private int S = R.id.bsb_back_size_02;
    private stream Y = new stream();
    @SuppressLint({"HandlerLeak"})
    private final Handler j0 = new e();
    private BroadcastReceiver v0 = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ int f2631b;

        a(int i) {
            this.f2631b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MirrorNoteActivity.this.K.e(this.f2631b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ String f2633b;

        b(String str) {
            this.f2633b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.STREAM", FileProvider.a(MirrorNoteActivity.this, "com.boxlight.unplugd.fileprovider", new File(this.f2633b)));
            try {
                MirrorNoteActivity.this.startActivity(Intent.createChooser(intent, MirrorNoteActivity.this.getString(R.string.capture_share_title)));
            } catch (Exception e2) {
                com.ecloud.eshare.util.l.b("share image to other application failed =" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        c(MirrorNoteActivity mirrorNoteActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* loaded from: classes.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "com.eshare.action.shut_tv_mirror")) {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.HOME");
                intent2.addFlags(268435456);
                MirrorNoteActivity.this.startActivity(intent2);
                MirrorNoteActivity.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 2) {
                    if (i == 257) {
                        MirrorNoteActivity.this.z();
                        com.ecloud.eshare.util.i.a(MirrorNoteActivity.this, new File((String) message.obj));
                        MirrorNoteActivity.this.a((String) message.obj);
                    } else if (i == 258) {
                        MirrorNoteActivity.this.z();
                        Toast.makeText(MirrorNoteActivity.this.getApplicationContext(), (int) R.string.capture_failed, 0).show();
                    }
                } else if (MirrorNoteActivity.this.W != null) {
                    b.b.a.n.e.getScreenCapture(MirrorNoteActivity.this.W, MirrorNoteActivity.this.M);
                    MirrorNoteActivity.this.X = System.currentTimeMillis();
                    sendMessageDelayed(obtainMessage(2), 100L);
                }
            } else if (MirrorNoteActivity.this.O != null && MirrorNoteActivity.this.a0 != null) {
                MirrorNoteActivity.this.O.setImageBitmap(MirrorNoteActivity.this.a0);
                com.eshare.mirror.b.f3055b = 0;
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements bytestream {
        f() {
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
                MirrorNoteActivity.this.Z.clear();
                MirrorNoteActivity.this.Z.offer(byteArrayOutputStream2);
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            MirrorNoteActivity mirrorNoteActivity;
            int i;
            if (!MirrorNoteActivity.this.h0.c() || (i = (mirrorNoteActivity = MirrorNoteActivity.this).u) == 1 || i == 3) {
                MirrorNoteActivity.this.J.c().b(motionEvent, view.getWidth(), view.getHeight());
                return true;
            }
            c.a.a.e.a(mirrorNoteActivity.getApplicationContext(), MirrorNoteActivity.this.getString(R.string.host_function_disabled), null, MirrorNoteActivity.this.getResources().getColor(R.color.c_666666), MirrorNoteActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(Process.myTid(), -8);
            if (MirrorNoteActivity.this.W != null) {
                byte[] bArr = new byte[1450];
                boolean z = false;
                while (!MirrorNoteActivity.this.T) {
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
                    if ((System.currentTimeMillis() - MirrorNoteActivity.this.X >= 100 || MirrorNoteActivity.this.X == 0) && !z) {
                        b.b.a.n.e.getScreenCapture(MirrorNoteActivity.this.W, MirrorNoteActivity.this.M);
                        MirrorNoteActivity.this.X = System.currentTimeMillis();
                    }
                    try {
                        MirrorNoteActivity.this.W.receive(datagramPacket);
                        if (stream.a(bArr, 0) == 1) {
                            MirrorNoteActivity.this.Y.a((String) null, bArr);
                        }
                        if (!z && !MirrorNoteActivity.this.j0.hasMessages(2)) {
                            MirrorNoteActivity.this.j0.sendEmptyMessage(2);
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
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(Process.myTid(), -8);
            while (!MirrorNoteActivity.this.T) {
                try {
                    byte[] byteArray = ((ByteArrayOutputStream) MirrorNoteActivity.this.Z.take()).toByteArray();
                    MirrorNoteActivity.this.a0 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    MirrorNoteActivity.this.j0.sendEmptyMessage(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class j implements com.ecloud.eshare.f.d {
        j() {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            if (q.e(MirrorNoteActivity.this)) {
                MirrorNoteActivity.this.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ AlertDialog f2642b;

        k(AlertDialog alertDialog) {
            this.f2642b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MirrorNoteActivity mirrorNoteActivity;
            boolean z;
            switch (view.getId()) {
                case R.id.ib_capture_background /* 2131230886 */:
                    mirrorNoteActivity = MirrorNoteActivity.this;
                    z = true;
                    break;
                case R.id.ib_capture_foreground /* 2131230887 */:
                    mirrorNoteActivity = MirrorNoteActivity.this;
                    z = false;
                    break;
                default:
                    return;
            }
            mirrorNoteActivity.b(z);
            this.f2642b.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements Runnable {

        /* renamed from: b */
        final /* synthetic */ boolean f2644b;

        l(boolean z) {
            this.f2644b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = "capRet=" + MirrorNoteActivity.this.K.b(this.f2644b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = com.ecloud.eshare.util.b.a(MirrorNoteActivity.this.J.d());
            if (TextUtils.isEmpty(a2)) {
                MirrorNoteActivity.this.j0.sendEmptyMessage(258);
                return;
            }
            Message message = new Message();
            message.what = 257;
            message.obj = a2;
            MirrorNoteActivity.this.j0.sendMessage(message);
        }
    }

    /* loaded from: classes.dex */
    private class n implements View.OnClickListener {

        /* renamed from: b */
        private int f2647b;

        public n() {
            this.f2647b = 0;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            MirrorNoteActivity.x0.getDefaultDisplay().getMetrics(displayMetrics);
            this.f2647b = displayMetrics.heightPixels;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!u.a()) {
                MirrorNoteActivity.this.d0.c();
                MirrorNoteActivity mirrorNoteActivity = MirrorNoteActivity.this;
                mirrorNoteActivity.b(mirrorNoteActivity.L);
                MirrorNoteActivity.this.e0.y = (this.f2647b / 2) - (view.getHeight() / 2);
                MirrorNoteActivity.x0.updateViewLayout(view, MirrorNoteActivity.this.e0);
            }
        }
    }

    /* loaded from: classes.dex */
    class o implements View.OnTouchListener {

        /* renamed from: b */
        private int f2649b;

        /* renamed from: c */
        private float f2650c;

        /* renamed from: d */
        private float f2651d;

        /* renamed from: e */
        private long f2652e;
        private long f;
        private float g;
        private float h;
        private long i = ViewConfiguration.getTapTimeout();
        private int j;

        public o() {
            this.f2649b = 0;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            MirrorNoteActivity.x0.getDefaultDisplay().getMetrics(displayMetrics);
            this.f2649b = displayMetrics.heightPixels;
            this.j = ViewConfiguration.get(MirrorNoteActivity.this).getScaledTouchSlop() + (MirrorNoteActivity.this.e0.width / 2);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f2650c = Math.abs(this.f2649b - motionEvent.getRawY());
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2652e = System.currentTimeMillis();
                this.f2651d = this.f2650c;
                this.g = motionEvent.getRawX();
                this.h = motionEvent.getRawY();
            } else if (action == 1) {
                this.f = System.currentTimeMillis();
                if (this.f2650c - this.f2651d < this.j && this.f - this.f2652e < this.i) {
                    MirrorNoteActivity.this.d0.c();
                    MirrorNoteActivity mirrorNoteActivity = MirrorNoteActivity.this;
                    mirrorNoteActivity.b(mirrorNoteActivity.L);
                }
            } else if (action == 2 && (Math.abs(motionEvent.getRawX() - this.g) > this.j || Math.abs(motionEvent.getRawY() - this.h) > this.j)) {
                MirrorNoteActivity.this.e0.y = (int) Math.abs((motionEvent.getRawY() - this.f2649b) + (MirrorNoteActivity.this.e0.width / 2.0f));
                MirrorNoteActivity.x0.updateViewLayout(view, MirrorNoteActivity.this.e0);
            }
            return true;
        }
    }

    private void A() {
        if (q.b(this, 1003)) {
            w();
        }
    }

    private void B() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.LoadingDialog);
        builder.setTitle(R.string.capture_on_server_title);
        View inflate = View.inflate(this, R.layout.dialog_capture_on_server, null);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        k kVar = new k(create);
        inflate.findViewById(R.id.ib_capture_foreground).setOnClickListener(kVar);
        inflate.findViewById(R.id.ib_capture_background).setOnClickListener(kVar);
        create.show();
    }

    public static MirrorNoteActivity C() {
        return w0;
    }

    private void D() {
        this.b0 = new AnimationSet(false);
        this.c0 = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        this.b0.addAnimation(alphaAnimation);
        this.b0.addAnimation(translateAnimation);
        this.c0.addAnimation(alphaAnimation2);
        this.c0.addAnimation(translateAnimation2);
        this.b0.setDuration(50L);
        this.c0.setDuration(50L);
        this.b0.setFillBefore(true);
        this.c0.setFillBefore(true);
        this.b0.setFillAfter(true);
        this.c0.setFillAfter(true);
    }

    private void E() {
        x0 = (WindowManager) getSystemService("window");
        this.L = (LinearLayout) findViewById(R.id.ll_right_panel);
        y0 = LayoutInflater.from(this).inflate(R.layout.paint_tools, (ViewGroup) null);
        this.L.addView(y0);
        this.l0 = (ImageButton) y0.findViewById(R.id.btn_home_pro);
        this.l0.setOnClickListener(this);
        this.m0 = (ImageButton) y0.findViewById(R.id.btn_back_pro);
        this.m0.setOnClickListener(this);
        this.n0 = (ImageButton) y0.findViewById(R.id.btn_file);
        this.n0.setOnClickListener(this);
        this.o0 = (ImageButton) y0.findViewById(R.id.btn_touch);
        this.o0.setOnClickListener(this);
        this.p0 = (ImageButton) y0.findViewById(R.id.btn_pen);
        this.p0.setOnClickListener(this);
        this.q0 = (ImageButton) y0.findViewById(R.id.btn_eraser);
        this.q0.setOnClickListener(this);
        this.r0 = (ImageButton) y0.findViewById(R.id.btn_screen);
        this.r0.setOnClickListener(this);
        this.s0 = (ImageButton) y0.findViewById(R.id.btn_min);
        this.s0.setOnClickListener(this);
        this.t0 = (ImageButton) y0.findViewById(R.id.btn_screen_capture);
        this.t0.setOnClickListener(this);
        if (getResources().getBoolean(R.bool.server_board_check) && !b.b.a.n.b.f && !CustomApplication.a("key_board_exists", true)) {
            this.t0.setEnabled(false);
            this.t0.setAlpha(0.4f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        startActivity(new Intent(this, CameraActivity.class));
    }

    private void G() {
        startActivity(new Intent(this, ProFileActivity.class));
    }

    private void H() {
        if (getResources().getBoolean(R.bool.server_board_check)) {
            B();
        } else {
            A();
        }
    }

    private void I() {
        this.Q.setContentView(R.layout.dialog_penset);
        this.Q.findViewById(this.R).setSelected(true);
        this.Q.findViewById(this.S).setSelected(true);
        Window window = this.Q.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 21;
        attributes.x = com.ecloud.eshare.util.g.b(this, getResources().getDimension(R.dimen.dialog_penset_x));
        p.c(window);
        p.b(window);
        window.setAttributes(attributes);
        this.Q.setCanceledOnTouchOutside(true);
        this.Q.show();
        p.a(window);
    }

    private void J() {
        this.V = new Thread(new i());
        this.V.start();
    }

    private void K() {
        if (this.W == null) {
            try {
                this.W = new DatagramSocket();
                this.W.setSoTimeout(100);
                this.W.setReceiveBufferSize(this.W.getReceiveBufferSize() * 2);
                b.b.a.n.e.getScreenCapture(this.W, this.M);
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        this.U = new Thread(new h());
        this.U.start();
    }

    private void L() {
        this.T = false;
        K();
        J();
    }

    private void M() {
        Thread thread = this.V;
        if (thread != null) {
            this.T = true;
            thread.interrupt();
        }
    }

    private void N() {
        Thread thread = this.U;
        if (thread != null) {
            this.T = true;
            thread.interrupt();
        }
    }

    private void O() {
        this.T = true;
        this.j0.removeMessages(2);
        N();
        M();
    }

    private void a(View view) {
        view.startAnimation(this.b0);
        Dialog dialog = this.Q;
        if (dialog != null && dialog.isShowing()) {
            this.Q.cancel();
        }
        this.l0.setVisibility(8);
        this.m0.setVisibility(8);
        this.n0.setVisibility(8);
        this.o0.setVisibility(8);
        this.p0.setVisibility(8);
        this.q0.setVisibility(8);
        this.r0.setVisibility(8);
        this.s0.setVisibility(8);
        this.t0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.capture_success);
        View inflate = View.inflate(this, R.layout.dialog_capture, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_capture_image);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(com.ecloud.eshare.util.b.a(str, this));
        builder.setView(inflate);
        builder.setPositiveButton(R.string.capture_share, new b(str));
        builder.setNegativeButton(17039370, new c(this));
        builder.show();
    }

    public static boolean a(Context context) {
        return !ViewConfiguration.get(context).hasPermanentMenuKey() && !KeyCharacterMap.deviceHasKey(4);
    }

    private int b(Context context) {
        if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    private void b(int i2, int i3) {
        ProgressDialog progressDialog = this.i0;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.i0 = new ProgressDialog(this);
            this.i0.setTitle(i2);
            this.i0.setMessage(getString(i3));
            this.i0.setCanceledOnTouchOutside(false);
            this.i0.show();
            return;
        }
        this.i0.setTitle(i2);
        this.i0.setMessage(getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        view.startAnimation(this.c0);
        int i2 = getResources().getInteger(R.integer.mirror_folder_visibility) == 2 ? 8 : 0;
        this.l0.setVisibility(0);
        this.m0.setVisibility(0);
        this.n0.setVisibility(i2);
        this.o0.setVisibility(0);
        this.p0.setVisibility(0);
        this.q0.setVisibility(0);
        this.r0.setVisibility(i2);
        this.s0.setVisibility(0);
        b.b.a.c cVar = this.h0;
        if (cVar != null && cVar.c()) {
            this.t0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        new Thread(new l(z)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ProgressDialog progressDialog = this.i0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.i0.cancel();
            this.i0 = null;
        }
    }

    public void a(int i2, boolean z) {
        Dialog dialog;
        int i3;
        Dialog dialog2 = this.Q;
        if (dialog2 == null || !z) {
            Dialog dialog3 = this.Q;
            if (dialog3 != null && !z) {
                dialog3.findViewById(this.S).setSelected(false);
                this.S = i2;
                dialog = this.Q;
                i3 = this.S;
            } else {
                return;
            }
        } else {
            dialog2.findViewById(this.R).setSelected(false);
            this.R = i2;
            dialog = this.Q;
            i3 = this.R;
        }
        dialog.findViewById(i3).setSelected(true);
    }

    @Override // com.ecloud.eshare.activity.a
    public void d(int i2) {
        this.I.execute(new a(i2));
    }

    public void e(int i2) {
        Dialog dialog = this.Q;
        if (dialog != null) {
            dialog.cancel();
        }
        this.k0.setPenColor(i2);
    }

    public void f(int i2) {
        Dialog dialog = this.Q;
        if (dialog != null) {
            dialog.cancel();
        }
        NoteView noteView = this.k0;
        if (noteView != null) {
            noteView.setPenSize(i2);
        }
    }

    @org.greenrobot.eventbus.m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_CAST) {
            finish();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c4, code lost:
        if (r14 != 3) goto L_0x0022;
     */
    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r14) {
        /*
            r13 = this;
            int r14 = r14.getId()
            r0 = 2131034288(0x7f0500b0, float:1.767909E38)
            r1 = 2131034163(0x7f050033, float:1.7678836E38)
            r2 = 2131624050(0x7f0e0072, float:1.8875269E38)
            r3 = 3
            r4 = 1
            switch(r14) {
                case 2131230786: goto L_0x00d3;
                case 2131230787: goto L_0x0012;
                case 2131230788: goto L_0x00b8;
                case 2131230789: goto L_0x00ac;
                case 2131230790: goto L_0x0098;
                case 2131230791: goto L_0x0012;
                case 2131230792: goto L_0x008d;
                case 2131230793: goto L_0x006b;
                case 2131230794: goto L_0x0066;
                case 2131230795: goto L_0x005b;
                case 2131230796: goto L_0x0056;
                case 2131230797: goto L_0x0012;
                case 2131230798: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x00e7
        L_0x0014:
            b.b.a.c r14 = r13.h0
            boolean r14 = r14.c()
            if (r14 == 0) goto L_0x0046
            int r14 = r13.u
            if (r14 == r4) goto L_0x0046
            if (r14 == r3) goto L_0x0046
        L_0x0022:
            android.content.Context r5 = r13.getApplicationContext()
            java.lang.String r6 = r13.getString(r2)
            r7 = 0
            android.content.res.Resources r14 = r13.getResources()
            int r8 = r14.getColor(r1)
            android.content.res.Resources r14 = r13.getResources()
            int r9 = r14.getColor(r0)
            r10 = 0
            r11 = 0
            r12 = 1
            android.widget.Toast r14 = c.a.a.e.a(r5, r6, r7, r8, r9, r10, r11, r12)
            r14.show()
            return
        L_0x0046:
            android.widget.ImageButton r14 = r13.p0
            r0 = 0
            r14.setSelected(r0)
            android.widget.ImageButton r14 = r13.o0
            r14.setSelected(r4)
            r13.x()
            goto L_0x00c8
        L_0x0056:
            r13.H()
            goto L_0x00e7
        L_0x005b:
            r14 = 6
            com.ecloud.eshare.activity.MirrorNoteActivity$j r0 = new com.ecloud.eshare.activity.MirrorNoteActivity$j
            r0.<init>()
            r13.a(r14, r0)
            goto L_0x00e7
        L_0x0066:
            r13.finish()
            goto L_0x00e7
        L_0x006b:
            b.b.a.c r14 = r13.h0
            boolean r14 = r14.c()
            if (r14 == 0) goto L_0x007a
            int r14 = r13.u
            if (r14 == r4) goto L_0x007a
            if (r14 == r3) goto L_0x007a
            goto L_0x0022
        L_0x007a:
            com.ecloud.eshare.view.NoteView r14 = r13.k0
            if (r14 == 0) goto L_0x0089
            int r14 = r14.getVisibility()
            if (r14 == 0) goto L_0x0085
            goto L_0x0089
        L_0x0085:
            r13.I()
            goto L_0x00e7
        L_0x0089:
            r13.v()
            goto L_0x00e7
        L_0x008d:
            android.widget.LinearLayout r14 = r13.L
            r13.a(r14)
            com.ecloud.eshare.view.a r14 = r13.d0
            r14.d()
            goto L_0x00e7
        L_0x0098:
            b.b.a.c r14 = r13.h0
            boolean r14 = r14.c()
            if (r14 == 0) goto L_0x00a8
            int r14 = r13.u
            if (r14 == r4) goto L_0x00a8
            if (r14 == r3) goto L_0x00a8
            goto L_0x0022
        L_0x00a8:
            r13.d(r3)
            goto L_0x00e7
        L_0x00ac:
            r14 = 1004(0x3ec, float:1.407E-42)
            boolean r14 = com.ecloud.eshare.util.q.b(r13, r14)
            if (r14 == 0) goto L_0x00e7
            r13.G()
            goto L_0x00e7
        L_0x00b8:
            b.b.a.c r14 = r13.h0
            boolean r14 = r14.c()
            if (r14 == 0) goto L_0x00c8
            int r14 = r13.u
            if (r14 == r4) goto L_0x00c8
            if (r14 == r3) goto L_0x00c8
            goto L_0x0022
        L_0x00c8:
            com.ecloud.eshare.view.NoteView r14 = r13.k0
            r14.a()
            b.b.a.f r14 = r13.K
            r14.A()
            goto L_0x00e7
        L_0x00d3:
            b.b.a.c r14 = r13.h0
            boolean r14 = r14.c()
            if (r14 == 0) goto L_0x00e3
            int r14 = r13.u
            if (r14 == r4) goto L_0x00e3
            if (r14 == r3) goto L_0x00e3
            goto L_0x0022
        L_0x00e3:
            r14 = 4
            r13.d(r14)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.MirrorNoteActivity.onClick(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        w0 = this;
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        a.n.a.a.a(this).a(this.v0);
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            this.J.c().e(i2);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onPause() {
        com.ecloud.eshare.view.a aVar = this.d0;
        if (aVar != null) {
            aVar.a();
        }
        super.onPause();
    }

    @Override // a.k.a.d, android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int length = iArr.length;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = true;
                break;
            } else if (iArr[i3] != 0) {
                break;
            } else {
                i3++;
            }
        }
        if (i2 != 1001) {
            if (i2 != 1003) {
                if (i2 == 1004 && z) {
                    G();
                }
            } else if (z) {
                w();
            }
        } else if (z) {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d0 = com.ecloud.eshare.view.a.e();
        this.d0.a(this, R.drawable.icon_arrow_left);
        this.e0 = this.d0.b();
        this.f0 = new n();
        this.d0.a(this.f0);
        this.g0 = new o();
        this.d0.a(this.g0);
        if (y0.findViewById(R.id.btn_pen).getVisibility() == 0) {
            this.d0.c();
        }
        if (y0.findViewById(R.id.btn_home_pro).getVisibility() == 0 && this.h0.p()) {
            this.d0.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onStart() {
        super.onStart();
        O();
        L();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onStop() {
        super.onStop();
        O();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.O = (ImageView) findViewById(R.id.eshare_iv_tv_mirror);
        this.P = (RelativeLayout) findViewById(R.id.eshare_rl_tv_mirror);
        this.k0 = (NoteView) findViewById(R.id.paintView);
        this.u0 = (ImageButton) findViewById(R.id.btn_remote_main_finish);
        this.u0.setOnClickListener(this);
        this.Q = new Dialog(this, R.style.Dialog);
        E();
        D();
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_mirror_note;
    }

    @Override // com.ecloud.eshare.activity.a
    @SuppressLint({"SourceLockedOrientationActivity"})
    protected void t() {
        a.n.a.a.a(this).a(this.v0, new IntentFilter("com.eshare.action.shut_tv_mirror"));
        this.r = 2;
        p.c(getWindow());
        this.I = Executors.newSingleThreadExecutor();
        this.J = b.b.a.a.a(this);
        this.K = this.J.c();
        this.h0 = b.b.a.a.a(this).b();
        this.M = getIntent().getStringExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS");
        this.N = getIntent().getIntExtra("ROTATION", 0);
        int i2 = this.N;
        if (i2 == 90 || i2 == 270) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        String str = "MirrorNoteActivity Rotation: " + this.N;
        this.K.a(true);
        new RectF();
        this.Z = new ArrayBlockingQueue(2);
        this.Y.setstream(new f());
        ViewConfiguration.get(this).getScaledTouchSlop();
        ViewConfiguration.getTapTimeout();
        int i3 = getResources().getInteger(R.integer.mirror_folder_visibility) == 2 ? 8 : 0;
        this.l0.setVisibility(0);
        this.m0.setVisibility(0);
        this.n0.setVisibility(i3);
        this.o0.setVisibility(0);
        this.p0.setVisibility(0);
        this.q0.setVisibility(0);
        this.r0.setVisibility(i3);
        this.s0.setVisibility(0);
        if (this.h0.c()) {
            this.t0.setVisibility(0);
        }
    }

    @Override // com.ecloud.eshare.activity.a
    @SuppressLint({"ClickableViewAccessibility"})
    protected void u() {
        if (a(getApplicationContext())) {
            b(getApplicationContext());
        }
        this.o0.setSelected(true);
        this.P.setOnTouchListener(new g());
    }

    @org.greenrobot.eventbus.m
    public void updateMirorrAbility(EventCollections.HeartbeatInfo heartbeatInfo) {
        if (heartbeatInfo.getMirrorMode() == 2) {
            this.t0.setEnabled(false);
            this.t0.setAlpha(0.4f);
            x();
            Dialog dialog = this.Q;
            if (dialog != null && dialog.isShowing()) {
                this.Q.cancel();
            }
        } else if (heartbeatInfo.getMirrorMode() != 1) {
        } else {
            if (this.p0.isSelected()) {
                v();
            } else if (b.b.a.n.b.f || CustomApplication.a("key_board_exists", true)) {
                this.t0.setEnabled(true);
                this.t0.setAlpha(1.0f);
            }
        }
    }

    @Override // com.ecloud.eshare.activity.a
    public void v() {
        if (!this.H) {
            this.k0.setVisibility(0);
            this.k0.b();
            this.H = true;
            this.p0.setSelected(true);
            this.o0.setSelected(false);
        }
    }

    public void w() {
        b(R.string.capture_title, R.string.capture_message);
        new Thread(new m()).start();
    }

    @Override // com.ecloud.eshare.activity.a
    public void x() {
        if (this.H) {
            this.k0.setVisibility(8);
            this.H = false;
            if (!this.p0.isSelected()) {
                this.p0.setSelected(false);
                this.o0.setSelected(true);
            }
        }
    }
}
