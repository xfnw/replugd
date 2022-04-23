package com.ecloud.eshare.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class w extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private k f2936a;

    public w(k kVar) {
        this.f2936a = kVar;
    }

    public static boolean a(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return ((Integer) wifiManager.getClass().getDeclaredMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue() == ((Integer) wifiManager.getClass().getDeclaredField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return false;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra;
        String action = intent.getAction();
        if (!a(context)) {
            if ("android.net.wifi.STATE_CHANGE".equals(action)) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra == null || ((NetworkInfo) parcelableExtra).isConnected()) {
                    return;
                }
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && (intExtra = intent.getIntExtra("wifi_state", 4)) != 0) {
                if (intExtra != 1) {
                    if (intExtra == 2) {
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            this.f2936a.h();
        }
    }
}
