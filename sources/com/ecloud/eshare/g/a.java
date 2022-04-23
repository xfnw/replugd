package com.ecloud.eshare.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f2833a;

    /* renamed from: b  reason: collision with root package name */
    private WifiManager f2834b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2835c;

    /* renamed from: d  reason: collision with root package name */
    private String f2836d;
    private d f;
    private e g;

    /* renamed from: e  reason: collision with root package name */
    private int f2837e = -1;
    private final Handler h = new HandlerC0082a(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ecloud.eshare.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0082a extends Handler {
        HandlerC0082a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1001) {
                a aVar = a.this;
                if (aVar.a(aVar.f2837e, a.this.f2836d)) {
                    a.this.b();
                } else {
                    return;
                }
            } else if (i == 1002) {
                a.this.b();
                a aVar2 = a.this;
                if (!aVar2.a(aVar2.f2837e, a.this.f2836d)) {
                    a.this.a(false, 5, "Connect failed!");
                    return;
                }
            } else {
                return;
            }
            a.this.a(true, 0, (String) null);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2839b;

        b(String str) {
            this.f2839b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            String str = aVar.f2836d;
            String str2 = this.f2839b;
            if (str2 == null) {
                str2 = "";
            }
            aVar.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2841b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2842c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f2843d;

        c(boolean z, int i, String str) {
            this.f2841b = z;
            this.f2842c = i;
            this.f2843d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2841b) {
                a.this.f.onSuccess();
            } else {
                a.this.f.a(this.f2842c, this.f2843d);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);

        void a(int i, String str);

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BroadcastReceiver {
        private e() {
        }

        /* synthetic */ e(a aVar, HandlerC0082a aVar2) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.STATE_CHANGE".equals(action) || "android.net.wifi.WIFI_STATE_CHANGED".equals(action)) && a.this.f2834b.getConnectionInfo().getSSID().equals(a.this.f2836d) && a.this.f2835c) {
                a.this.h.sendMessage(a.this.h.obtainMessage(1001));
            }
        }
    }

    public a(Context context) {
        this.f2833a = context;
        this.f2834b = (WifiManager) context.getSystemService("wifi");
    }

    private int a(String str, WifiManager wifiManager) {
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (configuredNetworks == null) {
            return -1;
        }
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals(str)) {
                return wifiConfiguration.networkId;
            }
        }
        return -1;
    }

    private void a(int i) {
        if (!this.f2834b.enableNetwork(i, true)) {
            a(false, 4, "Enable network failed!");
            return;
        }
        this.f2837e = i;
        Handler handler = this.h;
        handler.sendMessageDelayed(handler.obtainMessage(1002), 10000L);
        c();
    }

    public static void a(WifiManager wifiManager, String str) {
        String replace = str.replace("\"", "");
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (configuredNetworks != null) {
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                if (wifiConfiguration.SSID.replace("\"", "").equals(replace)) {
                    Boolean.valueOf(wifiManager.removeNetwork(wifiConfiguration.networkId));
                    wifiManager.saveConfiguration();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.g.a.a(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, String str) {
        this.f2835c = false;
        this.h.removeCallbacksAndMessages(null);
        if (this.f != null) {
            this.h.post(new c(z, i, str));
        }
    }

    private String b(String str, String str2) {
        String str3 = TextUtils.isEmpty(str2) ? "none" : "wpa";
        for (ScanResult scanResult : this.f2834b.getScanResults()) {
            if (str.equals(String.format("\"%s\"", scanResult.SSID))) {
                String lowerCase = scanResult.capabilities.toLowerCase();
                return lowerCase.contains("wpa") ? "wpa" : lowerCase.contains("wep") ? "wep" : "none";
            }
        }
        return str3;
    }

    private void c() {
        this.g = new e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.f2833a.registerReceiver(this.g, intentFilter);
    }

    public String a(String str) {
        if (str == null) {
            return "";
        }
        while (str.startsWith("\"")) {
            str = str.substring(1);
        }
        while (str.endsWith("\"")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public void a(String str, String str2, d dVar) {
        this.f2836d = String.format("\"%s\"", str);
        this.f = dVar;
        if (!this.f2835c) {
            this.f2835c = true;
            new Thread(new b(str2)).start();
        } else if (dVar != null) {
            dVar.a(-1);
        }
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT < 19) {
            return !TextUtils.isEmpty(Settings.Secure.getString(this.f2833a.getContentResolver(), "location_providers_allowed"));
        }
        try {
            return Settings.Secure.getInt(this.f2833a.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(int i, String str) {
        if (!this.f2834b.isWifiEnabled()) {
            return false;
        }
        WifiInfo connectionInfo = this.f2834b.getConnectionInfo();
        String a2 = a(connectionInfo.getSSID());
        int networkId = connectionInfo.getNetworkId();
        if (a2.equals(a(str))) {
            return true;
        }
        return !a() && i == networkId;
    }

    public void b() {
        e eVar = this.g;
        if (eVar != null) {
            this.f2833a.unregisterReceiver(eVar);
            this.g = null;
        }
    }
}
