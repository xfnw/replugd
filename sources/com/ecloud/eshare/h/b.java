package com.ecloud.eshare.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import b.b.a.n.h;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2852a;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0084b f2853b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2854c = new c();

    /* renamed from: com.ecloud.eshare.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0084b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            h.a("NetworkReceiver", action);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.WIFI_AP_STATE_CHANGED".equals(action) || "android.net.ethernet.ETHERNET_STATE_CHANGED".equals(action)) {
                b.this.f2853b.a();
            }
        }
    }

    public b(Context context, AbstractC0084b bVar) {
        this.f2852a = context.getApplicationContext();
        this.f2853b = bVar;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f2852a.getSystemService("connectivity");
        b();
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.WIFI_AP_STATE_CHANGED");
        intentFilter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
        this.f2852a.registerReceiver(this.f2854c, intentFilter);
    }

    public void a() {
        this.f2852a.unregisterReceiver(this.f2854c);
    }
}
