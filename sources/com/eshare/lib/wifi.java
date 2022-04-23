package com.eshare.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@TargetApi(9)
/* renamed from: com.eshare.lib.e */
/* loaded from: classes.dex */
public class wifi {
    /* renamed from: a */
    public static String getLanIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().contains("wlan")) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && nextElement2.getAddress().length == 4) {
                            String str = "getWifiApIpAddress:" + nextElement2.getHostAddress();
                            return nextElement2.getHostAddress();
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (SocketException e2) {
            Log.e("ZDH", e2.toString());
            return null;
        }
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
}
