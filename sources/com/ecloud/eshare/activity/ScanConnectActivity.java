package com.ecloud.eshare.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import b.b.a.n.d;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.g.a;
import com.ecloud.eshare.util.e;
import com.squareup.picasso.R;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class ScanConnectActivity extends com.ecloud.eshare.activity.a {
    private ExecutorService I;
    private b.b.a.c J;
    private com.ecloud.eshare.g.a P;
    private ArrayList<String> S;
    private int H = 0;
    private int K = 0;
    private String L = "";
    private String M = "";
    int N = 0;
    String O = null;
    private String Q = null;
    private Handler R = new a(Looper.myLooper());

    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 105) {
                ScanConnectActivity scanConnectActivity = ScanConnectActivity.this;
                scanConnectActivity.a(scanConnectActivity.L, ScanConnectActivity.this.M);
            } else if (i == 106) {
                if (ScanConnectActivity.this.S.size() > 0) {
                    ScanConnectActivity scanConnectActivity2 = ScanConnectActivity.this;
                    scanConnectActivity2.d((String) scanConnectActivity2.S.get(0));
                    return;
                }
                ScanConnectActivity scanConnectActivity3 = ScanConnectActivity.this;
                scanConnectActivity3.a(scanConnectActivity3.Q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.d {
        b() {
        }

        @Override // com.ecloud.eshare.g.a.d
        public void a(int i) {
        }

        @Override // com.ecloud.eshare.g.a.d
        public void a(int i, String str) {
            if (ScanConnectActivity.this.H < 2) {
                ScanConnectActivity.i(ScanConnectActivity.this);
                ScanConnectActivity.this.R.sendEmptyMessage(105);
                return;
            }
            ScanConnectActivity.this.v();
        }

        @Override // com.ecloud.eshare.g.a.d
        public void onSuccess() {
            ScanConnectActivity.this.R.sendEmptyMessageDelayed(106, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2714b;

        /* loaded from: classes.dex */
        class a implements b.b.a.m.b {

            /* renamed from: com.ecloud.eshare.activity.ScanConnectActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0068a implements b.b.a.m.b {
                C0068a() {
                }

                @Override // b.b.a.m.b
                public void a(b.b.a.k.a aVar) {
                    MainActivity.J().x();
                    MainActivity.J().z();
                    Intent intent = new Intent();
                    if (ScanConnectActivity.this.S.size() > 0) {
                        intent.putExtra("nfcMode", ScanConnectActivity.this.N);
                    }
                    ScanConnectActivity.this.setResult(200, intent);
                    ScanConnectActivity.this.finish();
                }

                @Override // b.b.a.m.b
                public void a(d dVar) {
                    ScanConnectActivity.this.v();
                }
            }

            a() {
            }

            @Override // b.b.a.m.b
            public void a(b.b.a.k.a aVar) {
                if (ScanConnectActivity.this.J.y()) {
                    String str = "su........." + ScanConnectActivity.this.S.size() + ScanConnectActivity.this.J.c();
                    if (ScanConnectActivity.this.S.size() <= 0 || !ScanConnectActivity.this.J.c()) {
                        ScanConnectActivity.this.setResult(200, new Intent());
                        ScanConnectActivity.this.finish();
                        return;
                    }
                    ScanConnectActivity.this.J.a(c.this.f2714b, new C0068a());
                }
            }

            @Override // b.b.a.m.b
            public void a(d dVar) {
                if (ScanConnectActivity.this.K < 2) {
                    if (ScanConnectActivity.this.K != 1 || ScanConnectActivity.this.S.size() <= 1) {
                        c cVar = c.this;
                        ScanConnectActivity.this.d(cVar.f2714b);
                    } else {
                        ScanConnectActivity scanConnectActivity = ScanConnectActivity.this;
                        scanConnectActivity.d((String) scanConnectActivity.S.get(1));
                    }
                    ScanConnectActivity.d(ScanConnectActivity.this);
                    return;
                }
                ScanConnectActivity.this.v();
            }
        }

        c(String str) {
            this.f2714b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanConnectActivity.this.J.a(this.f2714b, e.a(ScanConnectActivity.this), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        this.P.a(str, str2, new b());
    }

    static /* synthetic */ int d(ScanConnectActivity scanConnectActivity) {
        int i = scanConnectActivity.K;
        scanConnectActivity.K = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.I.execute(new c(str));
    }

    static /* synthetic */ int i(ScanConnectActivity scanConnectActivity) {
        int i = scanConnectActivity.H;
        scanConnectActivity.H = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        setResult(201, new Intent());
        finish();
    }

    public void a(String str) {
        Map<String, Object> a2 = com.ecloud.eshare.util.c.a(str, this);
        int intValue = ((Integer) a2.get("key_qr_type")).intValue();
        if (intValue == 1 || intValue == 2 || intValue == 3) {
            d((String) a2.get("key_qr_ip"));
            return;
        }
        setResult(202, new Intent());
        finish();
    }

    public void b(String str) {
        String[] split = str.split("&");
        if (split.length > 3) {
            String[] split2 = split[0].trim().split("=");
            if (split2.length > 1) {
                this.L = split2[1];
            }
            String[] split3 = split[1].trim().split("=");
            if (split3.length > 1) {
                this.O = split3[1];
                for (String str2 : this.O.split(":")) {
                    this.S.add(str2);
                }
            }
            String[] split4 = split[2].trim().split("=");
            if (split4.length > 1) {
                this.M = split4[1];
            }
            String[] split5 = split[3].trim().split("=");
            if (split5.length > 1) {
                this.N = Integer.valueOf(split5[1]).intValue();
            }
            if (this.S.size() <= 0) {
                return;
            }
            if (TextUtils.isEmpty(this.L)) {
                d(this.S.get(0));
            } else if (this.L.contains("Ethernet")) {
                d(this.S.get(0));
            } else if (this.L.contains("Unknown")) {
                Toast.makeText(this, (int) R.string.tv_check_network, 1).show();
            } else {
                a(this.L, this.M);
            }
        } else {
            v();
        }
    }

    public void c(String str) {
        Map<String, Object> a2 = com.ecloud.eshare.util.c.a(str, this);
        this.L = (String) a2.get("key_qr_wifi_ssid");
        this.M = (String) a2.get("key_qr_wifi_psw");
        if (TextUtils.isEmpty(this.L)) {
            a(str);
        } else if (this.L.contains("Ethernet")) {
            a(str);
        } else if (this.L.contains("Unknown")) {
            Toast.makeText(this, (int) R.string.tv_check_network, 1).show();
        } else {
            this.R.sendEmptyMessage(105);
        }
    }

    @m(threadMode = ThreadMode.MAIN)
    public void finishSelf(EventCollections.ScanFinishEvent scanFinishEvent) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.I.shutdown();
        this.P.b();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_scan_connect;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.S = new ArrayList<>();
        b.b.a.a.a(this);
        this.J = b.b.a.a.a(this).b();
        this.I = Executors.newSingleThreadExecutor();
        this.P = new com.ecloud.eshare.g.a(this);
        String stringExtra = getIntent().getStringExtra("nfcResult");
        if (stringExtra != null) {
            b(stringExtra);
        }
        this.Q = getIntent().getStringExtra("qrResult");
        String str = this.Q;
        if (str != null) {
            c(str);
        }
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
    }
}
