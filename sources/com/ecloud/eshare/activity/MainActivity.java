package com.ecloud.eshare.activity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.ClientInfo;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.f.e;
import com.ecloud.eshare.h.a;
import com.ecloud.eshare.h.b;
import com.ecloud.eshare.service.MediaService;
import com.ecloud.eshare.util.MsgPassService;
import com.ecloud.eshare.view.CircleBar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.picasso.R;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class MainActivity extends com.ecloud.eshare.activity.a implements com.ecloud.eshare.d.b, a.b, com.ecloud.eshare.d.e {
    public static boolean Y0;
    private static MainActivity Z0;
    private boolean B0;
    private ExecutorService C0;
    public b.b.a.c D0;
    private b.b.a.h E0;
    private b.b.a.g F0;
    private b.b.a.d G0;
    private MediaService H0;
    private com.ecloud.eshare.f.e I0;
    private boolean J;
    private b.b.a.a J0;
    private AppCompatEditText K;
    private Intent K0;
    private WifiManager L;
    private boolean M;
    private String N;
    private RelativeLayout O;
    private LottieAnimationView P;
    private TextView Q;
    private TextView R;
    private AlertDialog R0;
    private ImageView S;
    private boolean S0;
    private boolean T;
    private boolean T0;
    private String U0;
    private AlertDialog V;
    private ClientInfo W;
    private String W0;
    private String X;
    private ImageButton Y;
    private boolean Z;
    private int a0;
    private ViewGroup b0;
    private ViewGroup c0;
    private RecyclerView d0;
    private SwipeRefreshLayout e0;
    private TextView f0;
    private ViewGroup g0;
    private CircleBar h0;
    private ImageButton i0;
    private TextView j0;
    private TextView k0;
    private ViewGroup l0;
    private ViewGroup m0;
    private RelativeLayout n0;
    private Button o0;
    private View p0;
    private ViewGroup q0;
    private RecyclerView r0;
    private com.ecloud.eshare.c.e s0;
    private com.ecloud.eshare.h.b t0;
    private com.ecloud.eshare.c.c u0;
    private List<b.b.a.k.a> v0;
    private com.ecloud.eshare.h.a w0;
    private int x0;
    private Toast y0;
    Boolean H = false;
    private int I = -1;
    private List<ClientInfo> U = new ArrayList();
    private int z0 = 5;
    private int A0 = 0;
    private ServiceConnection L0 = new k();
    private View.OnClickListener M0 = new v();
    public Boolean N0 = false;
    private boolean O0 = false;
    private boolean P0 = false;
    @SuppressLint({"HandlerLeak"})
    private final Handler Q0 = new w();
    private Boolean V0 = false;
    private int X0 = -1;

    /* loaded from: classes.dex */
    class a implements SwipeRefreshLayout.j {
        a() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
        public void a() {
            MainActivity.this.e0.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a0 implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2570b;

        a0(String str) {
            this.f2570b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean f = MainActivity.this.D0.f(this.f2570b);
            MainActivity.this.a("authPassword", Boolean.valueOf(f));
            if (f) {
                MainActivity.this.Q0.sendEmptyMessage(1);
            } else {
                MainActivity.this.Q0.sendEmptyMessage(2);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnCancelListener {
        b(MainActivity mainActivity) {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b0 implements Runnable {
        b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            for (int i = 0; i < 2 && !z; i++) {
                String d2 = MainActivity.this.D0.d();
                if (!TextUtils.isEmpty(d2)) {
                    MainActivity.this.f(d2);
                    z = true;
                }
            }
            if (!z) {
                b.b.a.n.b.f = true;
                MainActivity.this.D0.i();
            } else {
                b.b.a.n.b.f = false;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.D0.c(com.ecloud.eshare.util.e.a(mainActivity));
        }
    }

    /* loaded from: classes.dex */
    class c implements DialogInterface.OnClickListener {
        c(MainActivity mainActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c0 implements e.a {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a(c0 c0Var) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.a(1, "");
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.s0.c();
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f2576b;

            d(int i) {
                this.f2576b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.g(this.f2576b);
            }
        }

        c0() {
        }

        @Override // com.ecloud.eshare.f.e.a
        public void a() {
            if (MainActivity.this.w()) {
                MainActivity.this.Q0.sendEmptyMessage(10);
            }
        }

        @Override // com.ecloud.eshare.f.e.a
        public void a(int i) {
            MainActivity.this.a0 = i;
            MainActivity.this.Y.post(new d(i));
        }

        @Override // com.ecloud.eshare.f.e.a
        public void a(String str) {
            MainActivity.this.runOnUiThread(new a(this));
        }

        @Override // com.ecloud.eshare.f.e.a
        public void a(List<ClientInfo> list) {
            if (!MainActivity.this.T) {
                MainActivity.this.T = true;
                MainActivity mainActivity = MainActivity.this;
                mainActivity.b(mainActivity.T);
            }
            MainActivity.this.U.clear();
            MainActivity.this.U.addAll(list);
            com.ecloud.eshare.util.l.a("peerClientData size=" + MainActivity.this.U.size());
            if (MainActivity.this.s0 == null) {
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.s0 = new com.ecloud.eshare.c.e(mainActivity2.U, MainActivity.this.M0);
                MainActivity.this.r0.setAdapter(MainActivity.this.s0);
            }
            MainActivity.this.runOnUiThread(new c());
        }

        @Override // com.ecloud.eshare.f.e.a
        public void a(boolean z) {
            MainActivity.this.T = z;
            MainActivity.this.b(z);
        }

        @Override // com.ecloud.eshare.f.e.a
        public void b() {
            MainActivity.this.runOnUiThread(new b());
        }

        @Override // com.ecloud.eshare.f.e.a
        public void c() {
        }
    }

    /* loaded from: classes.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", MainActivity.this.getApplicationContext().getPackageName(), null));
            MainActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d0 implements com.ecloud.eshare.f.d {
        d0(MainActivity mainActivity) {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.L.isWifiEnabled() || MainActivity.this.L.setWifiEnabled(true)) {
                MainActivity.this.Q0.sendEmptyMessage(107);
                return;
            }
            MainActivity.this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e0 implements Runnable {
        e0(MainActivity mainActivity) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements com.ecloud.eshare.f.d {
        f() {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            if (com.ecloud.eshare.util.q.e(MainActivity.this)) {
                MainActivity.this.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f0 implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2581b;

        f0(int i) {
            this.f2581b = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.f(this.f2581b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements com.ecloud.eshare.f.d {
        g() {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.startActivity(new Intent(mainActivity, RemoteControlActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g0 implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2584b;

        g0(int i) {
            this.f2584b = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.e(this.f2584b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements com.ecloud.eshare.f.d {
        h() {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            Intent intent = new Intent(MainActivity.this, MirrorNoteActivity.class);
            intent.putExtra("ROTATION", MainActivity.this.v);
            intent.putExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS", MainActivity.this.D0.f().a());
            MainActivity.this.startActivity(intent);
            MainActivity.this.overridePendingTransition(R.anim.eshare_zoom_enter, R.anim.eshare_zoom_exit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h0 implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AlertDialog f2587b;

        h0(AlertDialog alertDialog) {
            this.f2587b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2587b.dismiss();
            if (MainActivity.this.T0 || MainActivity.this.V0.booleanValue() || MainActivity.this.H.booleanValue()) {
                MainActivity.this.T0 = false;
                MainActivity.this.H = false;
                MainActivity.this.V0 = false;
                return;
            }
            MainActivity.this.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            com.ecloud.eshare.util.s.b(MainActivity.this, "isAudio", false);
            com.ecloud.eshare.util.q.f(MainActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i0 implements com.ecloud.eshare.f.d {
        i0() {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            if (com.ecloud.eshare.util.q.e(MainActivity.this)) {
                MainActivity.this.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.ecloud.eshare.activity.a f2591a;

        j(com.ecloud.eshare.activity.a aVar) {
            this.f2591a = aVar;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            MainActivity.this.A0 = 0;
            if (com.ecloud.eshare.util.c.c(this.f2591a, "com.eshare.mirror.MirrorScreenCaptureService")) {
                MainActivity.this.D0.d(1);
                MainActivity.this.E0.a(this.f2591a);
                return;
            }
            MainActivity.this.D0.d(1);
            MainActivity.this.E0.a(this.f2591a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j0 implements com.ecloud.eshare.f.d {
        j0() {
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.startActivity(new Intent(mainActivity, RemoteControlActivity.class));
        }
    }

    /* loaded from: classes.dex */
    class k implements ServiceConnection {
        k() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.this.a("MainActivity", "onServiceConnected");
            MainActivity.this.H0 = ((MediaService.f) iBinder).a();
            MainActivity.this.H0.a(MainActivity.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MainActivity.this.a("MainActivity", "onServiceDisconnected");
            MainActivity.this.H0 = null;
        }
    }

    /* loaded from: classes.dex */
    class k0 implements TextView.OnEditorActionListener {
        k0() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            MainActivity.this.V();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2596b;

        l(String str) {
            this.f2596b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.f2596b));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            MainActivity.this.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class l0 extends com.ecloud.eshare.f.g {
        l0() {
        }

        @Override // com.ecloud.eshare.f.g
        public void a(int i) {
            MainActivity mainActivity = MainActivity.this;
            b.b.a.c cVar = mainActivity.D0;
            if (cVar != null) {
                cVar.b(((ClientInfo) mainActivity.U.get(i)).getClientIp());
            }
            MainActivity.this.s0.f2761c.remove(i);
            MainActivity.this.s0.c(i);
            MainActivity.this.s0.a(i, MainActivity.this.s0.a());
        }

        @Override // com.ecloud.eshare.f.g
        public void b(int i) {
            MainActivity mainActivity = MainActivity.this;
            b.b.a.c cVar = mainActivity.D0;
            if (cVar != null) {
                cVar.b(((ClientInfo) mainActivity.U.get(i)).getClientIp());
            }
            MainActivity.this.s0.f2761c.remove(i);
            MainActivity.this.s0.c(i);
            MainActivity.this.s0.a(i, MainActivity.this.s0.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements DialogInterface.OnClickListener {
        m(MainActivity mainActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes.dex */
    class m0 extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.ecloud.eshare.f.f f2599a;

        m0(MainActivity mainActivity, com.ecloud.eshare.f.f fVar) {
            this.f2599a = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            this.f2599a.a(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements b.b.a.m.d {
        n() {
        }

        @Override // b.b.a.m.d
        public void a(b.b.a.n.d dVar) {
            MainActivity.this.a("findDevicesError", dVar);
        }

        @Override // b.b.a.m.d
        public void a(List<b.b.a.k.a> list) {
            if (list.isEmpty()) {
                MainActivity.this.v0.clear();
                MainActivity.this.z0 = 5;
                MainActivity.this.c0();
            }
            Collections.sort(list, new com.ecloud.eshare.i.c());
            MainActivity.this.v0.clear();
            MainActivity.this.v0.addAll(list);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.e(mainActivity.v0);
        }
    }

    /* loaded from: classes.dex */
    class n0 implements b.AbstractC0084b {
        n0() {
        }

        @Override // com.ecloud.eshare.h.b.AbstractC0084b
        public void a() {
            MainActivity.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements ValueAnimator.AnimatorUpdateListener {
        o(MainActivity mainActivity) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements ValueAnimator.AnimatorUpdateListener {
        p(MainActivity mainActivity) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2602b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Boolean f2603c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f2604d;

        /* loaded from: classes.dex */
        class a implements b.b.a.m.b {

            /* renamed from: com.ecloud.eshare.activity.MainActivity$q$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0065a implements Runnable {
                RunnableC0065a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.K.clearFocus();
                }
            }

            a() {
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.k.a aVar) {
                MainActivity.this.K.post(new RunnableC0065a());
                if (q.this.f2603c.booleanValue()) {
                    MainActivity.this.Q0.sendEmptyMessage(1);
                    return;
                }
                q qVar = q.this;
                boolean z = qVar.f2604d;
                MainActivity mainActivity = MainActivity.this;
                if (z) {
                    mainActivity.b(mainActivity.N);
                } else {
                    mainActivity.C();
                }
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.n.d dVar) {
                if (MainActivity.this.M) {
                    String a2 = com.ecloud.eshare.util.c.a(MainActivity.this);
                    if (!TextUtils.isEmpty(a2)) {
                        String[] split = a2.split("\\.");
                        MainActivity.this.a(split[0] + "." + split[1] + "." + split[2] + ".1", false, (Boolean) true);
                    }
                    MainActivity.this.M = false;
                    return;
                }
                MainActivity.this.Q0.sendEmptyMessage(2);
            }
        }

        q(String str, Boolean bool, boolean z) {
            this.f2602b = str;
            this.f2603c = bool;
            this.f2604d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.D0.a(this.f2602b, com.ecloud.eshare.util.e.a(mainActivity), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.b.a.k.a f2608b;

        /* loaded from: classes.dex */
        class a implements b.b.a.m.b {
            a() {
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.k.a aVar) {
                MainActivity.this.C();
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.n.d dVar) {
                MainActivity.this.a("connectDeviceError", dVar);
                MainActivity.this.Q0.sendEmptyMessage(2);
            }
        }

        r(b.b.a.k.a aVar) {
            this.f2608b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.D0.a(this.f2608b, com.ecloud.eshare.util.e.a(mainActivity), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s implements Runnable {

        /* loaded from: classes.dex */
        class a implements b.b.a.m.a {
            a(s sVar) {
            }

            @Override // b.b.a.m.a
            public void a(b.b.a.n.d dVar) {
                Log.e("miao", "bluetooth cast error,msg=" + dVar.getMessage());
            }

            @Override // b.b.a.m.a
            public void onSuccess() {
            }
        }

        s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.G0.a(new a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t implements Runnable {
        t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Handler handler;
            if (MainActivity.this.D0.y()) {
                boolean j = MainActivity.this.D0.j();
                String str = "is result===>" + j;
                if (j) {
                    handler = MainActivity.this.Q0;
                    i = 3;
                } else {
                    handler = MainActivity.this.Q0;
                    i = 1;
                }
                handler.sendEmptyMessage(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u implements DialogInterface.OnClickListener {
        u(MainActivity mainActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes.dex */
    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity mainActivity;
            String str;
            int i;
            if (!MainActivity.this.D0.y()) {
                CustomApplication.a((int) R.string.device_not_connected);
                return;
            }
            int f = ((RecyclerView.d0) view.getTag()).f();
            MainActivity mainActivity2 = MainActivity.this;
            mainActivity2.W = (ClientInfo) mainActivity2.U.get(f);
            switch (view.getId()) {
                case R.id.iv_item_peer_device_allow /* 2131230924 */:
                    MainActivity mainActivity3 = MainActivity.this;
                    mainActivity3.D0.b(true, mainActivity3.W.getClientIp());
                    return;
                case R.id.iv_item_peer_device_cast /* 2131230925 */:
                    if (MainActivity.this.W.getScreening() != 1) {
                        if (!TextUtils.equals(com.ecloud.eshare.util.c.a(MainActivity.this), MainActivity.this.W.getClientIp())) {
                            mainActivity = MainActivity.this;
                            i = 2;
                            str = "";
                            break;
                        } else {
                            MainActivity mainActivity4 = MainActivity.this;
                            mainActivity4.onClick(mainActivity4.n0);
                            return;
                        }
                    } else if (TextUtils.equals(com.ecloud.eshare.util.c.a(MainActivity.this), MainActivity.this.W.getClientIp())) {
                        MainActivity.this.b0();
                        return;
                    } else {
                        return;
                    }
                case R.id.iv_item_peer_device_deny /* 2131230926 */:
                    MainActivity mainActivity5 = MainActivity.this;
                    mainActivity5.D0.b(false, mainActivity5.W.getClientIp());
                    return;
                case R.id.iv_item_peer_device_divider /* 2131230927 */:
                default:
                    return;
                case R.id.iv_item_peer_device_fullscreen /* 2131230928 */:
                    int fullScreen = MainActivity.this.W.getFullScreen();
                    if (fullScreen != -1) {
                        if (fullScreen == 0) {
                            mainActivity = MainActivity.this;
                            i = 4;
                        } else {
                            mainActivity = MainActivity.this;
                            i = 5;
                        }
                        str = mainActivity.W.getClientModel();
                        break;
                    } else {
                        return;
                    }
                case R.id.iv_item_peer_device_host /* 2131230929 */:
                    if (MainActivity.this.W.getMastercontrol() != 1) {
                        MainActivity mainActivity6 = MainActivity.this;
                        mainActivity6.a(0, ((ClientInfo) mainActivity6.U.get(f)).getClientModel());
                        return;
                    }
                    return;
            }
            mainActivity.a(i, str);
        }
    }

    /* loaded from: classes.dex */
    class w extends Handler {

        /* loaded from: classes.dex */
        class a implements b.b.a.m.b {
            a() {
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.k.a aVar) {
                MainActivity.this.x();
                MainActivity.this.z();
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.n.d dVar) {
                MainActivity.this.E();
            }
        }

        w() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 9) {
                c.a.a.e.a(MainActivity.this.getApplicationContext(), MainActivity.this.getString(R.string.host_function_disabled), null, MainActivity.this.getResources().getColor(R.color.c_666666), MainActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
            } else if (i == 10) {
                MainActivity.this.E();
                MainActivity.this.c0();
                MainActivity.this.Z();
            } else if (i == 107) {
                MainActivity.this.X();
            } else if (i == 109) {
                MainActivity.this.B();
            } else if (i == 110) {
                CustomApplication.a((int) R.string.file_path_not_available);
            } else if (i == 766) {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.a(true, (com.ecloud.eshare.activity.a) mainActivity);
            } else if (i != 767) {
                switch (i) {
                    case 1:
                        MainActivity.this.z0 = 4;
                        if (MainActivity.this.D0.y()) {
                            MainActivity.this.z0 = 4;
                            MainActivity.this.c0();
                            if (MainActivity.this.X0 != -1 || !MainActivity.this.D0.c()) {
                                MainActivity mainActivity2 = MainActivity.this;
                                mainActivity2.D0.c(com.ecloud.eshare.util.e.a(mainActivity2));
                            } else {
                                MainActivity mainActivity3 = MainActivity.this;
                                mainActivity3.D0.a(mainActivity3.J0.d(), new a());
                            }
                        }
                        if (MainActivity.this.R0 != null) {
                            MainActivity.this.R0.dismiss();
                        }
                        MainActivity mainActivity4 = MainActivity.this;
                        mainActivity4.d(mainActivity4.X0);
                        MainActivity.this.B();
                        MainActivity.this.X0 = -1;
                        return;
                    case 2:
                        if (MainActivity.this.R0 != null) {
                            MainActivity.this.R0.dismiss();
                        }
                        MainActivity.this.y();
                        MainActivity.this.z0 = 3;
                        MainActivity.this.c0();
                        MainActivity.this.H = false;
                        MainActivity.this.I();
                        return;
                    case 3:
                        break;
                    case 4:
                        CustomApplication.a((int) R.string.input_empty);
                        break;
                    case 5:
                        MainActivity.this.T();
                        return;
                    case 6:
                    default:
                        return;
                    case 7:
                        if (MainActivity.this.V != null && MainActivity.this.V.isShowing()) {
                            MainActivity.this.V.dismiss();
                        }
                        if (MainActivity.this.I == 3) {
                            MainActivity.this.D0.d(2);
                        }
                        MainActivity.this.I = -1;
                        return;
                }
                MainActivity.this.R();
            } else if (MainActivity.this.D0.c()) {
                int i2 = MainActivity.this.u;
                if (i2 == 1 || i2 == 3) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, RemoteControlActivity.class));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class x implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2616b;

        x(EditText editText) {
            this.f2616b = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String upperCase = this.f2616b.getText().toString().trim().toUpperCase();
            if (TextUtils.isEmpty(upperCase)) {
                CustomApplication.a((int) R.string.input_empty);
            } else {
                MainActivity.this.b(upperCase);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2618b;

        y(EditText editText) {
            this.f2618b = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.showSoftInput(this.f2618b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class z implements TextView.OnEditorActionListener {
        z() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            MainActivity.this.R0.getButton(-1).performClick();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.O0 || this.P0) {
            Intent intent = new Intent("com.ecloud.eshare.intent.WEBSERVER");
            intent.setAction("com.ecloud.eshare.intent.WEBSERVER");
            intent.setPackage(getPackageName());
            startService(intent);
            bindService(intent, this.L0, 1);
            if (this.D0.y() && com.ecloud.eshare.util.q.b(this, 1009)) {
                D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.J = false;
        if (K()) {
            this.C0.execute(new t());
        }
    }

    private void D() {
        Intent intent;
        int i2;
        String type = this.K0.getType();
        if (!TextUtils.isEmpty(type)) {
            File file = null;
            if (!this.P0) {
                String path = this.K0.getData().getPath().startsWith("/storage") ? this.K0.getData().getPath() : a(this.K0.getData(), type);
                if (!TextUtils.isEmpty(path)) {
                    file = c(path);
                }
            } else if (!type.equals("text/plain") || !d(this.K0.getStringExtra("android.intent.extra.TEXT"))) {
                Uri uri = (Uri) this.K0.getParcelableExtra("android.intent.extra.STREAM");
                if (uri == null) {
                    finish();
                    return;
                }
                String path2 = (uri.getPath().startsWith("/storage") || uri.getPath().startsWith("/mnt")) ? uri.getPath() : a(uri, type);
                if (!TextUtils.isEmpty(path2)) {
                    file = c(path2);
                }
            } else {
                h(this.K0.getStringExtra("android.intent.extra.TEXT"));
                if (!this.D0.c() || (i2 = this.u) == 1 || i2 != 3) {
                }
                return;
            }
            if (!(file == null || !file.exists() || file.getParent() == null)) {
                if (type != null && !type.contains("image")) {
                    this.F0.b(file);
                }
                if (type.contains("audio")) {
                    intent = new Intent(this, PlayerActivity.class);
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", false);
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_PATH", file.getAbsolutePath());
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", file.getName());
                } else {
                    if (type.contains("video")) {
                        intent = new Intent(this, PlayerActivity.class);
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", true);
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_PATH", file.getAbsolutePath());
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", file.getName());
                    } else if (type.contains("image")) {
                        intent = new Intent(this, ImageActivity.class);
                        intent.putExtra("path", file.getAbsolutePath());
                    } else {
                        if (type.contains("text") || type.contains("application")) {
                            this.Q0.sendEmptyMessageDelayed(767, 500L);
                        }
                        this.O0 = false;
                        this.P0 = false;
                    }
                    intent.putExtra("share", true);
                }
                startActivity(intent);
                this.O0 = false;
                this.P0 = false;
            }
        }
        this.Q0.sendEmptyMessage(110);
        this.O0 = false;
        this.P0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.z0 = 5;
        if (!isFinishing()) {
            c0();
        }
        this.p0 = null;
        this.E0.b(this);
        this.F0.B();
        this.h0.setVisibility(4);
        MediaService mediaService = this.H0;
        if (mediaService != null) {
            mediaService.a((File) null, true);
        }
        a0();
        this.D0.g(com.ecloud.eshare.util.e.a(this));
    }

    private void F() {
        if (!this.D0.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else {
            a(9, new h());
        }
    }

    private void G() {
        this.C0.execute(new s());
    }

    private void H() {
        if (this.y0.getView().getParent() == null) {
            this.y0.show();
            return;
        }
        Z();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.D0.k();
        this.D0.a(new n());
    }

    public static MainActivity J() {
        return Z0;
    }

    private boolean K() {
        ExecutorService executorService = this.C0;
        return executorService != null && !executorService.isShutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (!this.D0.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
            return;
        }
        CustomApplication.b("key_camera_request", false);
        startActivity(new Intent(this, CameraActivity.class));
    }

    private void M() {
        startActivity(new Intent(this, DocumentActivity.class));
    }

    private void N() {
        startActivity(new Intent(this, MediaActivity.class));
    }

    private void O() {
        startActivity(new Intent(this, PhotoActivity.class));
    }

    private void P() {
        if (!this.D0.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else if (this.Z) {
            this.D0.w();
        } else {
            a(8, new d0(this));
        }
    }

    private void Q() {
        this.O.setVisibility(8);
        this.c0.setVisibility(8);
        this.g0.setVisibility(8);
        this.q0.setVisibility(8);
        this.Y.setVisibility(8);
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
        this.S.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.O.setVisibility(8);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(String.format(getString(R.string.main_input_pwd), this.D0.f().b()));
        View inflate = View.inflate(this, R.layout.dialog_input, null);
        builder.setView(inflate);
        builder.setCancelable(false);
        this.R0 = builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setNegativeButton(17039360, new u(this)).create();
        this.R0.show();
        EditText editText = (EditText) inflate.findViewById(R.id.et_dialog_input);
        editText.setTransformationMethod(new com.ecloud.eshare.util.v());
        this.R0.getButton(-1).setOnClickListener(new x(editText));
        editText.requestFocus();
        editText.postDelayed(new y(editText), 200L);
        editText.setOnEditorActionListener(new z());
    }

    private void S() {
        this.P.setVisibility(0);
        this.P.f();
        this.Q.setVisibility(0);
        this.Q.setText(R.string.main_no_network_tip);
        this.Q.setTextColor(-65536);
        this.S.setVisibility(8);
        this.d0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.Q.setText(R.string.main_connect_error);
        this.Q.setVisibility(0);
        this.S.setVisibility(0);
        this.R.setVisibility(0);
    }

    private void U() {
        b.b.a.d dVar = this.G0;
        if (dVar != null && dVar.F() && com.ecloud.eshare.util.q.a(this, 1014)) {
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (TextUtils.isEmpty(this.K.getText().toString())) {
            (TextUtils.equals("boxlight", "boxlight") ? c.a.a.e.a(this, getString(R.string.input_empty), null, getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.white), 0, false, true) : c.a.a.e.a(this, R.string.input_empty)).show();
            return;
        }
        this.T0 = true;
        this.J = true;
        hideSoftInput(this.K);
        Map<String, Object> a2 = com.ecloud.eshare.util.c.a(this, this.K.getText().toString());
        String str = (String) a2.get("key_decode_ip");
        String str2 = "calIP====>" + str;
        if (!TextUtils.isEmpty(str)) {
            this.S0 = ((Boolean) a2.get("key_decode_is_pin")).booleanValue();
            if (this.S0) {
                this.N = this.K.getText().toString();
                this.M = a(this.N);
            }
            a(str, this.S0, (Boolean) false);
            return;
        }
        this.Q0.sendEmptyMessage(2);
    }

    private void W() {
        new Thread(new e()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        Intent intent = new Intent();
        intent.putExtra("QR_TITLE", getString(R.string.qr_code_title));
        intent.setClass(getApplicationContext(), QRCaptureActivity.class);
        startActivityForResult(intent, 1);
    }

    private void Y() {
        b.b.a.d dVar = this.G0;
        if (dVar != null) {
            dVar.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        b.b.a.c cVar = this.D0;
        if (cVar != null) {
            cVar.x();
        }
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) {
        String[] strArr2 = {"_data"};
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    return query.getString(query.getColumnIndexOrThrow(strArr2[0]));
                }
                return null;
            } catch (Exception unused) {
                if (0 == 0) {
                    return null;
                }
                cursor.close();
                return null;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[Catch: Exception -> 0x0082, TRY_LEAVE, TryCatch #0 {Exception -> 0x0082, blocks: (B:3:0x0002, B:6:0x000f, B:7:0x0023, B:8:0x002b, B:10:0x0033, B:11:0x0048, B:13:0x0050, B:16:0x0059, B:18:0x0061, B:20:0x0078, B:22:0x007e), top: B:25:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(android.net.Uri r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "image"
            boolean r1 = r14.startsWith(r1)     // Catch: Exception -> 0x0082
            r2 = 0
            r3 = 1
            r4 = 0
            java.lang.String r5 = "_data"
            if (r1 == 0) goto L_0x002b
            java.lang.String[] r8 = new java.lang.String[r3]     // Catch: Exception -> 0x0082
            r8[r2] = r5     // Catch: Exception -> 0x0082
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: Exception -> 0x0082
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r13
            android.database.Cursor r4 = r6.query(r7, r8, r9, r10, r11)     // Catch: Exception -> 0x0082
            int r13 = r4.getColumnIndexOrThrow(r5)     // Catch: Exception -> 0x0082
        L_0x0023:
            r4.moveToFirst()     // Catch: Exception -> 0x0082
            java.lang.String r13 = r4.getString(r13)     // Catch: Exception -> 0x0082
            goto L_0x007c
        L_0x002b:
            java.lang.String r1 = "audio"
            boolean r1 = r14.startsWith(r1)     // Catch: Exception -> 0x0082
            if (r1 == 0) goto L_0x0048
            java.lang.String[] r8 = new java.lang.String[r3]     // Catch: Exception -> 0x0082
            r8[r2] = r5     // Catch: Exception -> 0x0082
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: Exception -> 0x0082
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r13
            android.database.Cursor r4 = r6.query(r7, r8, r9, r10, r11)     // Catch: Exception -> 0x0082
            int r13 = r4.getColumnIndexOrThrow(r5)     // Catch: Exception -> 0x0082
            goto L_0x0023
        L_0x0048:
            java.lang.String r1 = "text"
            boolean r1 = r14.startsWith(r1)     // Catch: Exception -> 0x0082
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = "application"
            boolean r1 = r14.startsWith(r1)     // Catch: Exception -> 0x0082
            if (r1 == 0) goto L_0x0059
            goto L_0x0078
        L_0x0059:
            java.lang.String r1 = "video"
            boolean r14 = r14.startsWith(r1)     // Catch: Exception -> 0x0082
            if (r14 == 0) goto L_0x0076
            java.lang.String[] r8 = new java.lang.String[r3]     // Catch: Exception -> 0x0082
            r8[r2] = r5     // Catch: Exception -> 0x0082
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: Exception -> 0x0082
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r13
            android.database.Cursor r4 = r6.query(r7, r8, r9, r10, r11)     // Catch: Exception -> 0x0082
            int r13 = r4.getColumnIndexOrThrow(r5)     // Catch: Exception -> 0x0082
            goto L_0x0023
        L_0x0076:
            r13 = r0
            goto L_0x007c
        L_0x0078:
            java.lang.String r13 = a(r12, r13, r4, r4)     // Catch: Exception -> 0x0082
        L_0x007c:
            if (r4 == 0) goto L_0x0081
            r4.close()     // Catch: Exception -> 0x0082
        L_0x0081:
            return r13
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.MainActivity.a(android.net.Uri, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        String str2;
        AlertDialog alertDialog = this.V;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.V.dismiss();
        }
        this.Q0.removeMessages(7);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String str3 = "";
        switch (i2) {
            case 0:
                str3 = getString(R.string.host_assign_ok_btn);
                str2 = String.format(getString(R.string.host_assign_content), str);
                break;
            case 1:
                str3 = getString(R.string.host_cast_request_ok_btn);
                str2 = getString(R.string.host_be_admin);
                break;
            case 2:
                str2 = String.format(getString(R.string.host_assign_cast_content), str);
                break;
            case 3:
                str2 = String.format(getString(R.string.host_invite_cast), str);
                break;
            case 4:
                str2 = String.format(getString(R.string.host_assign_fullscreen_content), str);
                break;
            case 5:
                str2 = String.format(getString(R.string.host_recall_fullscreen_content), str);
                break;
            case 6:
                str2 = String.format(getString(R.string.host_invite_fullscreen_content), str);
                break;
            case 7:
                str3 = getString(R.string.host_cast_request_ok_btn);
                str2 = String.format(getString(R.string.host_cast_request_content), str);
                break;
            default:
                str2 = str3;
                break;
        }
        builder.setMessage(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = getString(17039379);
        }
        builder.setPositiveButton(str3, new f0(i2));
        builder.setNegativeButton(17039360, new g0(i2));
        this.V = builder.create();
        this.V.show();
        this.I = i2;
        int i3 = this.I;
        if (i3 == 1 || i3 == 3) {
            this.Q0.sendEmptyMessageDelayed(7, 10000L);
        }
    }

    private void a(View view) {
        int i2;
        com.ecloud.eshare.f.d dVar;
        if (this.n0.isSelected()) {
            this.p0 = view;
            return;
        }
        int id = view.getId();
        if (id == R.id.rl_main_camera) {
            i2 = 6;
            dVar = new f();
        } else if (id != R.id.rl_main_control) {
            switch (id) {
                case R.id.rl_main_document /* 2131231062 */:
                    if (com.ecloud.eshare.util.q.b(this, 1004)) {
                        M();
                        return;
                    }
                    return;
                case R.id.rl_main_media /* 2131231063 */:
                    if (com.ecloud.eshare.util.q.b(this, 1002)) {
                        N();
                        return;
                    }
                    return;
                case R.id.rl_main_mirror /* 2131231064 */:
                    F();
                    return;
                case R.id.rl_main_photo /* 2131231065 */:
                    if (com.ecloud.eshare.util.q.b(this, 1003)) {
                        O();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            i2 = 4;
            dVar = new g();
        }
        a(i2, dVar);
    }

    private void a(b.b.a.k.a aVar) {
        a("connectDevice", aVar);
        hideSoftInput(this.K);
        this.O.setVisibility(0);
        if (K()) {
            this.C0.execute(new r(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2, Boolean bool) {
        this.O.setVisibility(0);
        if (K()) {
            this.C0.execute(new q(str, bool, z2));
        }
    }

    private void a(boolean z2, boolean z3) {
        if (z2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.x0, 0);
            ofInt.addUpdateListener(new o(this));
            ofInt.setDuration(300L).start();
            return;
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, this.x0);
        ofInt2.addUpdateListener(new p(this));
        ofInt2.setDuration(300L).start();
        if (z3) {
            a(true, false);
        }
    }

    private synchronized void a0() {
        if (this.I0 != null) {
            this.I0.b();
            this.I0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        a("authPassword", str);
        if (K()) {
            this.C0.execute(new a0(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        if (this.z0 == 6 && !z2) {
            this.z0 = 4;
            runOnUiThread(new e0(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        this.A0 = 2;
        this.E0.c(this);
    }

    private File c(String str) {
        return str.startsWith("/external_files") ? new File(str.replace("/external_files", Environment.getExternalStorageDirectory().getPath())) : new File(str);
    }

    private void c(Intent intent) {
        this.O0 = false;
        this.P0 = false;
        if (intent.getAction() != null) {
            this.K0 = intent;
            this.O0 = intent.getAction().equals("android.intent.action.VIEW");
            this.P0 = intent.getAction().equals("android.intent.action.SEND");
        }
    }

    private void c(boolean z2) {
        this.n0.setSelected(z2);
        if (z2) {
            this.A0 = 1;
            this.m0.setVisibility(8);
            this.l0.setVisibility(0);
            U();
            return;
        }
        this.l0.setVisibility(8);
        this.m0.setVisibility(0);
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        ViewGroup viewGroup;
        String str;
        TextView textView;
        Y0 = false;
        Q();
        switch (this.z0) {
            case 0:
                this.c0.setVisibility(0);
                S();
                this.f0.setText(R.string.app_name);
                return;
            case 1:
            case 2:
                this.f0.setText(R.string.app_name);
                return;
            case 3:
                if (!this.B0) {
                    viewGroup = this.c0;
                    viewGroup.setVisibility(0);
                    this.f0.setText(R.string.main_devices_title);
                    return;
                }
                this.f0.setText(R.string.app_name);
                return;
            case 4:
                Z();
                this.g0.setVisibility(0);
                if (this.D0.f() != null) {
                    b.b.a.k.a f2 = this.D0.f();
                    if (!TextUtils.isEmpty(f2.b())) {
                        textView = this.j0;
                        str = f2.b();
                    } else {
                        textView = this.j0;
                        str = com.ecloud.eshare.util.c.f2912a;
                    }
                    textView.setText(str);
                    this.k0.setText(f2.a());
                }
                this.f0.setText(R.string.app_name);
                return;
            case 5:
                this.H = false;
                this.E0.b(this);
                Z();
                I();
                this.c0.setVisibility(0);
                if (this.v0.isEmpty()) {
                    this.P.setVisibility(0);
                    if (!this.P.d()) {
                        this.P.f();
                    }
                    this.Q.setTextColor(getResources().getColor(R.color.c_666666));
                    this.Q.setText(R.string.main_connect_same_net);
                    this.Q.setVisibility(0);
                    this.f0.setText(R.string.main_devices_title);
                    return;
                }
                this.P.a();
                this.P.setVisibility(8);
                viewGroup = this.d0;
                viewGroup.setVisibility(0);
                this.f0.setText(R.string.main_devices_title);
                return;
            case 6:
                Y0 = true;
                this.g0.setVisibility(0);
                this.q0.setVisibility(0);
                a(false, true);
                this.f0.setText(R.string.app_name);
                return;
            default:
                return;
        }
    }

    private void d(Intent intent) {
        String str = "tag===>" + ((Tag) intent.getParcelableExtra("android.nfc.extra.TAG"));
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        String str2 = "rawMessage===>" + parcelableArrayExtra;
        if (parcelableArrayExtra != null) {
            NdefMessage[] ndefMessageArr = new NdefMessage[parcelableArrayExtra.length];
            for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
                ndefMessageArr[i2] = (NdefMessage) parcelableArrayExtra[i2];
            }
            List<com.ecloud.eshare.d.g> a2 = com.ecloud.eshare.d.c.a(ndefMessageArr[0]);
            if (a2.size() > 0) {
                this.W0 = a2.get(0).a();
                String str3 = "nfcdata====>" + this.W0;
                this.V0 = true;
                if (com.ecloud.eshare.util.q.a(this) && com.ecloud.eshare.util.q.a((Activity) this, (Boolean) true)) {
                    j(this.W0);
                }
            }
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("http://") || str.contains("https://")) {
            str = str.substring(str.indexOf("http"));
        }
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        switch (i2) {
            case 0:
            case 2:
            case 4:
            case 5:
                this.V.dismiss();
                this.V = null;
                return;
            case 1:
                this.D0.e(false);
                return;
            case 3:
                this.D0.d(0);
                return;
            case 6:
            default:
                return;
            case 7:
                this.D0.b(false, this.X);
                return;
        }
    }

    private void e(String str) {
        Intent intent = new Intent(this, MsgPassService.class);
        intent.putExtra("command", str);
        startService(intent);
        startActivity(new Intent(this, RemoteControlActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<b.b.a.k.a> list) {
        RecyclerView recyclerView;
        int i2 = 8;
        if (!list.isEmpty()) {
            this.P.a();
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            recyclerView = this.d0;
            i2 = 0;
        } else {
            recyclerView = this.d0;
        }
        recyclerView.setVisibility(i2);
        this.u0.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        switch (i2) {
            case 0:
                this.D0.a(this.W.getClientIp());
                return;
            case 1:
                this.D0.e(true);
                return;
            case 2:
                this.D0.d(this.W.getClientIp());
                return;
            case 3:
                this.D0.d(1);
                a(false, (com.ecloud.eshare.activity.a) this);
                return;
            case 4:
                this.D0.a(true, this.W.getClientIp());
                return;
            case 5:
                this.D0.a(false, this.W.getClientIp());
                return;
            case 6:
            default:
                return;
            case 7:
                this.D0.b(true, this.X);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            for (String str2 : new String(str.getBytes("UTF-8"), "UTF-8").split(System.lineSeparator())) {
                JsonObject asJsonObject = JsonParser.parseString(str2.trim()).getAsJsonObject();
                if (asJsonObject.has("boardExists")) {
                    boolean z2 = true;
                    if (asJsonObject.get("boardExists").getAsInt() != 1) {
                        z2 = false;
                    }
                    CustomApplication.b("key_board_exists", z2);
                }
                if (asJsonObject.has("rotation")) {
                    this.v = asJsonObject.get("rotation").getAsInt();
                } else {
                    this.v = 0;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(int r6) {
        /*
            r5 = this;
            r0 = 2
            r1 = 4
            r2 = 0
            r3 = 1
            if (r6 != 0) goto L_0x000c
        L_0x0006:
            android.widget.ImageButton r4 = r5.Y
            r4.setVisibility(r1)
            goto L_0x002a
        L_0x000c:
            if (r6 != r3) goto L_0x001e
            int r4 = r5.t
            if (r4 != r3) goto L_0x0013
            goto L_0x0006
        L_0x0013:
            android.widget.ImageButton r1 = r5.Y
            r1.setVisibility(r2)
            android.widget.ImageButton r1 = r5.Y
            r1.setSelected(r2)
            goto L_0x002a
        L_0x001e:
            if (r6 != r0) goto L_0x002a
            android.widget.ImageButton r1 = r5.Y
            r1.setVisibility(r2)
            android.widget.ImageButton r1 = r5.Y
            r1.setSelected(r3)
        L_0x002a:
            if (r6 != r0) goto L_0x002d
            r2 = 1
        L_0x002d:
            r5.Z = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.MainActivity.g(int):void");
    }

    private void g(String str) {
        this.V0 = false;
        this.H = true;
        Intent intent = new Intent(this, ScanConnectActivity.class);
        intent.putExtra("nfcResult", str);
        startActivityForResult(intent, 112);
    }

    private void h(String str) {
        String substring = str.substring(str.indexOf("http"));
        e("OpenLink\r\n" + substring + "\r\n\r\n");
    }

    private void i(String str) {
        String str2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (str.startsWith("http://") || str.startsWith("https://")) {
            str2 = String.format("%s%s", getString(R.string.qr_open_website), str);
            builder.setNegativeButton(17039360, new m(this)).setPositiveButton(17039379, new l(str));
        } else {
            str2 = String.format("%s%s", getString(R.string.qr_show_scan_ret), str);
        }
        builder.setTitle(R.string.qr_dialog_titile).setMessage(str2).setCancelable(true);
        builder.create().show();
    }

    private void j(String str) {
        if (this.L.isWifiEnabled()) {
            String v2 = v();
            if (this.D0.y() && str.contains(v2)) {
                return;
            }
        } else if (Boolean.valueOf(this.L.setWifiEnabled(true)).booleanValue()) {
            String v3 = v();
            if (this.D0.y() && str.contains(v3)) {
                return;
            }
        } else {
            startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 5000);
            return;
        }
        g(str);
    }

    public void A() {
        if (w()) {
            this.v0.clear();
            if (this.H.booleanValue()) {
                this.z0 = 4;
                this.H = false;
            } else if (!this.H.booleanValue()) {
                this.z0 = 5;
            }
        } else if (!this.H.booleanValue()) {
            this.D0.h();
            if (this.z0 != 0) {
                this.z0 = 0;
            } else {
                return;
            }
        } else {
            return;
        }
        c0();
    }

    @Override // com.ecloud.eshare.d.b
    public void a(int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007c, code lost:
        if (r9.V0.booleanValue() != false) goto L_0x007e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
        j(r9.W0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
        W();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
        if (r9.V0.booleanValue() != false) goto L_0x007e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r10, int r11, android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.MainActivity.a(int, int, android.content.Intent):void");
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i2) {
        b.b.a.k.a d2 = this.u0.d(i2);
        if (d2 == null) {
            CustomApplication.a((int) R.string.main_connect_error_null);
        } else {
            a(d2);
        }
    }

    @Override // com.ecloud.eshare.h.a.b
    public void a(boolean z2) {
        View view;
        int i2;
        this.N0 = Boolean.valueOf(z2);
        c(z2);
        if (!z2 && (i2 = this.A0) != 0 && i2 == 1) {
            this.D0.y();
        }
        if (!z2 && (view = this.p0) != null) {
            onClick(view);
            this.p0 = null;
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public void a(boolean z2, com.ecloud.eshare.activity.a aVar) {
        b.b.a.d dVar;
        if (Build.VERSION.SDK_INT < 21) {
            CustomApplication.a(String.format(getResources().getString(R.string.main_cast_unsupported), Integer.valueOf(Build.VERSION.SDK_INT)));
        } else if (com.ecloud.eshare.util.q.b(this)) {
            if (Build.VERSION.SDK_INT >= 29 && (dVar = this.G0) != null && !dVar.F() && com.ecloud.eshare.util.s.a(this, "key_eshare_transfer_audio_above_Q", true) && !com.ecloud.eshare.util.q.d(this)) {
                if (com.ecloud.eshare.util.s.a(this, "isAudio", true)) {
                    new AlertDialog.Builder(this).setMessage(R.string.permission_audio_record_rationale).setPositiveButton(R.string.dialog_tv_know, new i()).show();
                    return;
                } else if (!com.ecloud.eshare.util.q.f(this)) {
                    return;
                }
            }
            if (z2) {
                a(7, new j(aVar));
                return;
            }
            this.A0 = 0;
            if (com.ecloud.eshare.util.c.c(aVar, "com.eshare.mirror.MirrorScreenCaptureService")) {
                this.D0.d(1);
                this.E0.a(aVar);
                return;
            }
            this.D0.d(1);
            this.E0.a(aVar, true);
        }
    }

    public boolean a(String str) {
        return str.matches("[0-9]*");
    }

    @Override // com.ecloud.eshare.d.b
    public void b(int i2) {
    }

    public void d(int i2) {
        int i3;
        com.ecloud.eshare.f.d dVar;
        switch (i2) {
            case 1:
                a(true, (com.ecloud.eshare.activity.a) this);
                return;
            case 2:
                F();
                return;
            case 3:
                if (com.ecloud.eshare.util.q.b(this, 1003)) {
                    O();
                    return;
                }
                return;
            case 4:
                if (com.ecloud.eshare.util.q.b(this, 1002)) {
                    N();
                    return;
                }
                return;
            case 5:
                if (com.ecloud.eshare.util.q.b(this, 1004)) {
                    M();
                    return;
                }
                return;
            case 6:
                i3 = 6;
                dVar = new i0();
                break;
            case 7:
                i3 = 4;
                dVar = new j0();
                break;
            default:
                return;
        }
        a(i3, dVar);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() == EventCollections.FinishActivityEvent.FINISH_DEFAULT) {
            E();
        } else if (finishActivityEvent.getType() == EventCollections.FinishActivityEvent.FINISH_CAST && this.N0.booleanValue()) {
            b0();
            this.Q0.sendEmptyMessage(9);
        }
    }

    public void hideSoftInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (view != null && inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, a.k.a.d, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a(i2, i3, intent);
    }

    @Override // a.k.a.d, android.app.Activity
    public void onBackPressed() {
        int i2;
        if (this.B0) {
            this.B0 = false;
            i2 = 5;
        } else {
            if (this.z0 == 6) {
                i2 = 4;
            }
            H();
        }
        this.z0 = i2;
        c0();
        H();
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_device_con_go /* 2131230787 */:
                V();
                return;
            case R.id.btn_main_start_scan_qrcode /* 2131230791 */:
                if (com.ecloud.eshare.util.q.e(this)) {
                    W();
                    return;
                }
                return;
            case R.id.ib_main_full_cast /* 2131230888 */:
                P();
                return;
            case R.id.iv_main_setting /* 2131230941 */:
                startActivity(new Intent(this, SettingActivity.class));
                return;
            case R.id.rl_main_cast_start /* 2131231057 */:
                a(true, (com.ecloud.eshare.activity.a) this);
                return;
            case R.id.tv_input_again /* 2131231205 */:
                if (!this.J) {
                    R();
                    return;
                }
                return;
            case R.id.tv_main_cast_stop /* 2131231225 */:
                b0();
                return;
            case R.id.tv_main_disconnect /* 2131231229 */:
                this.H = false;
                E();
                c0();
                return;
            default:
                a(view);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Z0 = this;
        Intent intent = getIntent();
        d(intent);
        c(intent);
        this.Q0.sendEmptyMessageDelayed(109, 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MediaService mediaService = this.H0;
        if (mediaService != null) {
            mediaService.b(this);
        }
        Y();
        this.G0.close();
        this.v0.clear();
        Z();
        unbindService(this.L0);
        E();
        this.Q0.removeCallbacksAndMessages(null);
        this.E0.b(this);
        this.w0.b(this);
        this.C0.shutdown();
        this.t0.a();
        Z0 = null;
        this.E0.D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d(intent);
        c(intent);
        this.Q0.sendEmptyMessageDelayed(109, 300L);
    }

    @Override // a.k.a.d, android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        String str;
        int i3;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        boolean z2 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= iArr.length) {
                z2 = true;
                break;
            } else if (iArr[i4] != -1) {
                i4++;
            } else if (!androidx.core.app.a.a((Activity) this, strArr[i4])) {
                if (i2 != 1014) {
                    switch (i2) {
                        case 1001:
                            i3 = R.string.permission_camera;
                            str = getString(i3);
                            break;
                        default:
                            switch (i2) {
                                case 1009:
                                    break;
                                case 1010:
                                    i3 = R.string.peimission_speaker;
                                    str = getString(i3);
                                    break;
                                case 1011:
                                    break;
                                default:
                                    str = "";
                                    break;
                            }
                        case 1002:
                        case 1003:
                        case 1004:
                            i3 = R.string.permission_save;
                            str = getString(i3);
                            break;
                    }
                    new AlertDialog.Builder(this).setMessage(String.format(getString(R.string.permission_title), str)).setPositiveButton(R.string.go_permission, new d()).setNegativeButton(getString(R.string.main_connect_cancel), new c(this)).setOnCancelListener(new b(this)).show();
                }
                i3 = R.string.permission_localtion;
                str = getString(i3);
                new AlertDialog.Builder(this).setMessage(String.format(getString(R.string.permission_title), str)).setPositiveButton(R.string.go_permission, new d()).setNegativeButton(getString(R.string.main_connect_cancel), new c(this)).setOnCancelListener(new b(this)).show();
            }
        }
        if (i2 != 1014) {
            switch (i2) {
                case 1001:
                    if (!z2) {
                        return;
                    }
                    break;
                case 1002:
                    if (z2) {
                        N();
                        return;
                    }
                    return;
                case 1003:
                    if (z2) {
                        O();
                        return;
                    }
                    return;
                case 1004:
                    if (z2) {
                        M();
                        return;
                    }
                    return;
                default:
                    switch (i2) {
                        case 1009:
                            if (z2) {
                                D();
                                return;
                            }
                            return;
                        case 1010:
                            if (z2) {
                                this.Q0.sendEmptyMessage(766);
                                return;
                            }
                            return;
                        case 1011:
                            if (!z2) {
                                return;
                            }
                            if (this.V0.booleanValue()) {
                                j(this.W0);
                                return;
                            }
                            break;
                        default:
                            return;
                    }
            }
            W();
        } else if (z2) {
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onResume() {
        super.onResume();
        g(this.a0);
        if (this.z0 == 0 && !this.H.booleanValue()) {
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onStop() {
        super.onStop();
        Y0 = false;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.g0 = (ViewGroup) findViewById(R.id.vg_main);
        this.P = (LottieAnimationView) findViewById(R.id.loadView_device);
        this.P.setImageAssetsFolder("lottiefiles/");
        this.O = (RelativeLayout) findViewById(R.id.rl_main_devcs_connecting);
        this.Q = (TextView) findViewById(R.id.tv_main_connect_status);
        this.R = (TextView) findViewById(R.id.tv_input_again);
        this.S = (ImageView) findViewById(R.id.iv_error_pin);
        this.K = (AppCompatEditText) findViewById(R.id.et_pin_go);
        this.K.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.K.setOnEditorActionListener(new k0());
        this.R.setOnClickListener(this);
        this.Y = (ImageButton) findViewById(R.id.ib_main_full_cast);
        this.q0 = (ViewGroup) findViewById(R.id.vg_main_host);
        this.r0 = (RecyclerView) findViewById(R.id.rcv_main_host);
        this.r0.setLayoutManager(new LinearLayoutManager(this, 1, false));
        com.ecloud.eshare.f.f fVar = new com.ecloud.eshare.f.f(this, new l0());
        new androidx.recyclerview.widget.f(fVar).a(this.r0);
        this.r0.a(new m0(this, fVar));
        this.b0 = (ViewGroup) findViewById(R.id.vg_main_content);
        this.c0 = (ViewGroup) findViewById(R.id.vg_main_devices);
        this.d0 = (RecyclerView) findViewById(R.id.rv_main_devices);
        this.e0 = (SwipeRefreshLayout) findViewById(R.id.swipeContainer_devices);
        this.f0 = (TextView) findViewById(R.id.tv_main_title);
        this.h0 = (CircleBar) findViewById(R.id.cb_main_media);
        this.i0 = (ImageButton) findViewById(R.id.tv_main_disconnect);
        this.j0 = (TextView) findViewById(R.id.tv_main_con_server_name);
        this.k0 = (TextView) findViewById(R.id.tv_main_con_server_ip);
        this.n0 = (RelativeLayout) findViewById(R.id.rl_main_cast_start);
        this.o0 = (Button) findViewById(R.id.tv_main_cast_stop);
        this.l0 = (ViewGroup) findViewById(R.id.vg_main_mirror_manage);
        this.m0 = (ViewGroup) findViewById(R.id.vg_main_functions);
        findViewById(R.id.btn_main_start_scan_qrcode).setOnClickListener(this);
        findViewById(R.id.btn_device_con_go).setOnClickListener(this);
        findViewById(R.id.rl_main_media).setOnClickListener(this);
        findViewById(R.id.rl_main_photo).setOnClickListener(this);
        findViewById(R.id.rl_main_document).setOnClickListener(this);
        findViewById(R.id.rl_main_camera).setOnClickListener(this);
        findViewById(R.id.rl_main_control).setOnClickListener(this);
        findViewById(R.id.rl_main_mirror).setOnClickListener(this);
        findViewById(R.id.iv_main_setting).setOnClickListener(this);
        AppCompatEditText appCompatEditText = this.K;
        appCompatEditText.addTextChangedListener(new com.ecloud.eshare.util.n(15, appCompatEditText));
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_main;
    }

    public void showSoftInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (view != null && inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.L = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.t0 = new com.ecloud.eshare.h.b(this, new n0());
        this.C0 = Executors.newSingleThreadExecutor();
        this.J0 = b.b.a.a.a(this);
        this.D0 = b.b.a.a.a(this).b();
        this.E0 = b.b.a.a.a(this).f();
        this.F0 = b.b.a.a.a(this).e();
        this.G0 = b.b.a.a.a(this).a();
        this.G0.a(this);
        bindService(new Intent(this, MediaService.class), this.L0, 1);
        this.w0 = com.ecloud.eshare.h.a.a();
        this.w0.a((Context) this);
        this.w0.a((a.b) this);
        this.y0 = c.a.a.e.a(this, getString(R.string.click_to_exit), null, getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.white), 0, false, true);
        this.v0 = new ArrayList();
        this.u0 = new com.ecloud.eshare.c.c(this);
        this.u0.a(this);
        this.a0 = -1;
        this.e0.setOnRefreshListener(new a());
        this.r = 0;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        this.i0.setOnClickListener(this);
        this.n0.setOnClickListener(this);
        this.o0.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.d0.setLayoutManager(new LinearLayoutManager(this));
        this.d0.setAdapter(this.u0);
        c0();
        this.x0 = this.b0.getMeasuredHeight();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void updateServerName(EventCollections.ServerInfoChangedEvent serverInfoChangedEvent) {
        if (!TextUtils.isEmpty(serverInfoChangedEvent.getDeviceName())) {
            this.j0.setText(serverInfoChangedEvent.getDeviceName());
        }
    }

    public String v() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        return (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') ? ssid.substring(1, ssid.length() - 1) : "";
    }

    public boolean w() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    public void x() {
        if (K()) {
            this.C0.execute(new b0());
        }
    }

    protected void y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = View.inflate(this, R.layout.dialog_connect_error, null);
        TextView textView = (TextView) inflate.findViewById(R.id.yes);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        if (!create.isShowing()) {
            if (!isFinishing()) {
                create.show();
            }
            textView.setOnClickListener(new h0(create));
        }
    }

    public synchronized void z() {
        a0();
        if (this.D0.c()) {
            this.I0 = new com.ecloud.eshare.f.e(this.D0, new c0());
            this.I0.a();
        }
    }
}
