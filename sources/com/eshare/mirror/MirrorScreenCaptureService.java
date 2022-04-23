package com.eshare.mirror;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.RemoteViews;
import androidx.core.app.g;
import b.b.a.n.f;
import b.b.a.n.h;

/* loaded from: classes.dex */
public class MirrorScreenCaptureService extends Service {

    /* renamed from: d  reason: collision with root package name */
    private d f3038d;

    /* renamed from: e  reason: collision with root package name */
    private g f3039e;
    private e f;
    private com.eshare.mirror.c g;
    private b.b.a.a i;
    private l j;
    private String k;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3036b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3037c = false;
    private int h = 0;
    private Boolean l = false;
    private j m = new a();
    @SuppressLint({"HandlerLeak"})
    public final Handler n = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements j {
        a() {
        }

        @Override // com.eshare.mirror.j
        public void a(int i) {
            Handler handler;
            int i2 = 1;
            if (i == 0) {
                handler = MirrorScreenCaptureService.this.n;
            } else if (i == 1) {
                handler = MirrorScreenCaptureService.this.n;
                i2 = 3;
            } else if (i == 11) {
                h.a("AUDIO should Start......");
                handler = MirrorScreenCaptureService.this.n;
                i2 = 4;
            } else if (i == 12) {
                h.a("AUDIO should STOP");
                handler = MirrorScreenCaptureService.this.n;
                i2 = 5;
            } else {
                MirrorScreenCaptureService.this.n.sendEmptyMessageDelayed(2, 500L);
                return;
            }
            handler.sendEmptyMessage(i2);
        }
    }

    /* loaded from: classes.dex */
    class b extends Handler {

        /* loaded from: classes.dex */
        class a implements b.b.a.m.a {
            a(b bVar) {
            }

            @Override // b.b.a.m.a
            public void a(b.b.a.n.d dVar) {
            }

            @Override // b.b.a.m.a
            public void onSuccess() {
            }
        }

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MirrorScreenCaptureService mirrorScreenCaptureService;
            Intent intent;
            int i = message.what;
            boolean z = false;
            if (i != 1) {
                if (i == 2) {
                    MirrorScreenCaptureService.d(MirrorScreenCaptureService.this);
                    try {
                        if (MirrorScreenCaptureService.this.f != null && MirrorScreenCaptureService.this.f.a()) {
                            if (MirrorScreenCaptureService.this.h < 6) {
                                z = true;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    if (!z || MirrorScreenCaptureService.this.l.booleanValue()) {
                        mirrorScreenCaptureService = MirrorScreenCaptureService.this;
                        intent = new Intent("com.eshare.action.mirror.disconnected");
                    } else {
                        MirrorScreenCaptureService.this.f();
                        return;
                    }
                } else if (i == 3) {
                    mirrorScreenCaptureService = MirrorScreenCaptureService.this;
                    intent = new Intent("com.eshare.action.mirror.disconnected");
                } else if (i == 4) {
                    MirrorScreenCaptureService.this.i.a().a(new a(this));
                    return;
                } else if (i == 5) {
                    MirrorScreenCaptureService.this.i.a().E();
                    return;
                } else {
                    return;
                }
                mirrorScreenCaptureService.sendBroadcast(intent);
                MirrorScreenCaptureService.this.h();
                return;
            }
            MirrorScreenCaptureService.this.sendBroadcast(new Intent("com.eshare.action.mirror.connected"));
            MirrorScreenCaptureService.this.a(true);
            MirrorScreenCaptureService.this.g();
            MirrorScreenCaptureService.this.h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends MediaProjection.Callback {
        private c() {
        }

        /* synthetic */ c(MirrorScreenCaptureService mirrorScreenCaptureService, a aVar) {
            this();
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            MirrorScreenCaptureService.this.g.a((MediaProjection) null);
            MirrorScreenCaptureService.this.stopSelf();
        }
    }

    /* loaded from: classes.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
            if (r3.f3043a.f3036b != false) goto L_0x005a;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                r0 = 0
                com.eshare.mirror.MirrorScreenCaptureService.a(r4, r0)
                java.lang.String r4 = r5.getAction()
                java.lang.String r1 = "com.eshare.mirror.ButtonClick"
                boolean r1 = r4.equals(r1)
                r2 = 1
                if (r1 == 0) goto L_0x004a
                java.lang.String r4 = "ButtonId"
                int r4 = r5.getIntExtra(r4, r0)
                r5 = 2
                if (r4 != r5) goto L_0x002f
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                boolean r5 = com.eshare.mirror.MirrorScreenCaptureService.j(r4)
                r5 = r5 ^ r2
                com.eshare.mirror.MirrorScreenCaptureService.a(r4, r5)
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                boolean r4 = com.eshare.mirror.MirrorScreenCaptureService.j(r4)
                if (r4 == 0) goto L_0x0070
                goto L_0x005a
            L_0x002f:
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                android.content.pm.PackageManager r4 = r4.getPackageManager()
                com.eshare.mirror.MirrorScreenCaptureService r5 = com.eshare.mirror.MirrorScreenCaptureService.this
                java.lang.String r5 = r5.getPackageName()
                android.content.Intent r4 = r4.getLaunchIntentForPackage(r5)
                r5 = 268435456(0x10000000, float:2.5243549E-29)
                r4.addFlags(r5)
                com.eshare.mirror.MirrorScreenCaptureService r5 = com.eshare.mirror.MirrorScreenCaptureService.this
                r5.startActivity(r4)
                goto L_0x0096
            L_0x004a:
                java.lang.String r5 = "com.eshare.mirror.startmirror"
                boolean r5 = r4.equals(r5)
                if (r5 == 0) goto L_0x0060
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                boolean r4 = com.eshare.mirror.MirrorScreenCaptureService.j(r4)
                if (r4 != 0) goto L_0x0096
            L_0x005a:
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                com.eshare.mirror.MirrorScreenCaptureService.g(r4)
                goto L_0x0096
            L_0x0060:
                java.lang.String r5 = "com.eshare.mirror.stopmirror"
                boolean r5 = r4.equals(r5)
                if (r5 == 0) goto L_0x0076
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                boolean r4 = com.eshare.mirror.MirrorScreenCaptureService.j(r4)
                if (r4 == 0) goto L_0x0096
            L_0x0070:
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                com.eshare.mirror.MirrorScreenCaptureService.h(r4)
                goto L_0x0096
            L_0x0076:
                java.lang.String r5 = "android.intent.action.SCREEN_ON"
                boolean r5 = r5.equals(r4)
                if (r5 == 0) goto L_0x007f
                goto L_0x0096
            L_0x007f:
                java.lang.String r5 = "android.intent.action.SCREEN_OFF"
                boolean r5 = r5.equals(r4)
                if (r5 == 0) goto L_0x0091
                com.eshare.mirror.MirrorScreenCaptureService r4 = com.eshare.mirror.MirrorScreenCaptureService.this
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
                com.eshare.mirror.MirrorScreenCaptureService.a(r4, r5)
                goto L_0x0096
            L_0x0091:
                java.lang.String r5 = "android.intent.action.USER_PRESENT"
                r5.equals(r4)
            L_0x0096:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eshare.mirror.MirrorScreenCaptureService.d.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    private int a(String str, String str2) {
        return f.a(this, str, str2);
    }

    static /* synthetic */ int d(MirrorScreenCaptureService mirrorScreenCaptureService) {
        int i = mirrorScreenCaptureService.h;
        mirrorScreenCaptureService.h = i + 1;
        return i;
    }

    private void e() {
        this.g = com.eshare.mirror.c.e();
        MediaProjection a2 = this.g.a();
        if (a2 != null) {
            a2.registerCallback(new c(this, null), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        a.n.a.a.a(this).a(new Intent("com.eshare.action.shut_tv_mirror"));
        String d2 = this.i.d();
        if (d2 == null) {
            d2 = this.k;
        } else {
            this.k = d2;
        }
        if (this.f != null) {
            this.f.c();
        }
        this.f = new e(d2);
        this.f.b();
        if (this.f3039e == null) {
            this.f3039e = new g(this);
            this.f3039e.a(this.m);
        }
        this.f3039e.a();
        this.f3039e.a(d2);
        this.f3036b = true;
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        l lVar = this.j;
        if (lVar == null) {
            if (this.g.b()) {
                i();
                this.j = l.a(this);
                lVar = this.j;
            } else {
                return;
            }
        }
        lVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        this.i.a().E();
        if (this.f3039e != null) {
            this.f3039e.a();
        }
        if (this.f != null) {
            this.f.c();
            this.f = null;
        }
        i();
        this.f3036b = false;
        a(false);
    }

    private void i() {
        l lVar = this.j;
        if (lVar != null) {
            lVar.e();
            this.j = null;
        }
    }

    public void a() {
        ((NotificationManager) getSystemService("notification")).cancel(65537);
    }

    public void a(boolean z) {
        int i;
        String str;
        if (this.f3037c) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("EShare Cast", "Cast", 1);
                notificationChannel.setDescription("Cast screen");
                NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            g.b bVar = new g.b(this, "EShare Cast");
            Intent intent = new Intent("com.eshare.mirror.ButtonClick");
            intent.putExtra("ButtonId", 2);
            RemoteViews remoteViews = new RemoteViews(getPackageName(), a("layout", "eshare_layout_notification"));
            PendingIntent activity = PendingIntent.getActivity(this, 100, getPackageManager().getLaunchIntentForPackage(getPackageName()), 0);
            remoteViews.setOnClickPendingIntent(a("id", "eshare_ib_switch"), PendingIntent.getBroadcast(this, 1, intent, 134217728));
            remoteViews.setTextViewText(a("id", "eshare_tv_title"), getString(a("string", "eshare_mirror_open_close")));
            if (z) {
                remoteViews.setImageViewResource(a("id", "eshare_ib_switch"), a("drawable", "eshare_cb_on"));
                i = a("id", "eshare_tv_content");
                str = "eshare_mirror_description_stop";
            } else {
                remoteViews.setImageViewResource(a("id", "eshare_ib_switch"), a("drawable", "eshare_cb_off"));
                i = a("id", "eshare_tv_content");
                str = "eshare_mirror_description_start";
            }
            remoteViews.setTextViewText(i, getString(a("string", str)));
            bVar.a(remoteViews);
            bVar.a(activity);
            bVar.a(System.currentTimeMillis());
            bVar.b(0);
            bVar.a(true);
            bVar.c(com.eshare.lib.f.icon_cast_notification_small);
            bVar.a(BitmapFactory.decodeResource(getResources(), com.eshare.lib.f.eshare_ic_eshare));
            bVar.a(Color.parseColor("#D21A21"));
            Notification a2 = bVar.a();
            a2.flags = 2;
            startForeground(65537, a2);
        }
    }

    public void b() {
        this.f3038d = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.eshare.mirror.ButtonClick");
        intentFilter.addAction("com.eshare.mirror.startmirror");
        intentFilter.addAction("com.eshare.mirror.stopmirror");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f3038d, intentFilter);
    }

    public void c() {
        this.g.d();
    }

    public void d() {
        d dVar = this.f3038d;
        if (dVar != null) {
            unregisterReceiver(dVar);
            this.f3038d = null;
            ((NotificationManager) getSystemService("notification")).cancelAll();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3037c = true;
        this.i = b.b.a.a.a(this);
        if (Build.VERSION.SDK_INT < 29) {
            e();
            f();
        }
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f3037c = false;
        h();
        c();
        d();
        a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3037c = true;
            a(true);
            int intExtra = intent.getIntExtra("code", -1);
            Intent intent2 = (Intent) intent.getParcelableExtra("data");
            if (intent2 != null) {
                try {
                    com.eshare.mirror.c.e().a(((MediaProjectionManager) getApplicationContext().getSystemService("media_projection")).getMediaProjection(intExtra, intent2));
                    e();
                    f();
                } catch (Exception unused) {
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
