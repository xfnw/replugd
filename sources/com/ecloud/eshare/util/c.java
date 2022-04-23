package com.ecloud.eshare.util;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Patterns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f2912a;

    static long a(int i) {
        long j = 1;
        for (int i2 = 1; i2 < i; i2++) {
            j *= 26;
        }
        return j;
    }

    public static String a(long j) {
        if (j < 0) {
            return "00:00";
        }
        int i = (j > 3600000L ? 1 : (j == 3600000L ? 0 : -1));
        Locale locale = Locale.getDefault();
        SimpleDateFormat simpleDateFormat = i >= 0 ? new SimpleDateFormat("H:mm:ss", locale) : new SimpleDateFormat("m:ss", locale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(Long.valueOf(j));
    }

    public static String a(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        int ipAddress = connectionInfo.getIpAddress();
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)}).getHostAddress();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        ArrayList<String> a2 = a();
        ArrayList arrayList = new ArrayList();
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        for (int i = 0; i < length; i++) {
            int indexOf = a2.indexOf(String.valueOf(upperCase.charAt(i)));
            if (indexOf == -1) {
                return "error";
            }
            arrayList.add(Integer.valueOf(indexOf));
        }
        long j = 0;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            j += ((Integer) arrayList.get(i2)).intValue() * a(size - i2);
        }
        long j2 = (208827064575L - j) % 4294967296L;
        return String.format("%d.%d.%d.%d", Long.valueOf(j2 / 16777216), Long.valueOf((j2 % 16777216) / PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH), Long.valueOf((j2 % PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) / 256), Long.valueOf(j2 % 256));
    }

    public static String a(String str, long j) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(Long.valueOf(j));
    }

    public static ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            arrayList.add(String.valueOf((char) (i + 65)));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Object> a(android.content.Context r5, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isDigitsOnly(r6)
            r1 = 0
            r2 = 1
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0019
            int r0 = r6.length()
            r4 = 6
            if (r0 != r4) goto L_0x0016
            java.lang.String r5 = b(r5, r6)
            goto L_0x0017
        L_0x0016:
            r5 = r3
        L_0x0017:
            r6 = 1
            goto L_0x0031
        L_0x0019:
            boolean r5 = c(r6)
            if (r5 == 0) goto L_0x0024
            java.lang.String r5 = a(r6)
            goto L_0x0017
        L_0x0024:
            java.lang.String r5 = "http://"
            java.lang.String r5 = r6.replace(r5, r3)
            java.lang.String r6 = "https://"
            java.lang.String r5 = r5.replace(r6, r3)
            r6 = 0
        L_0x0031:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "decode ip="
            r2.append(r4)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0[r1] = r2
            com.ecloud.eshare.util.l.a(r0)
            boolean r0 = d(r5)
            if (r0 != 0) goto L_0x0050
            r5 = r3
        L_0x0050:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "key_decode_ip"
            r0.put(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            java.lang.String r6 = "key_decode_is_pin"
            r0.put(r6, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.util.c.a(android.content.Context, java.lang.String):java.util.Map");
    }

    public static Map<String, Object> a(String str, Context context) {
        String substring;
        String[] split;
        HashMap hashMap = new HashMap();
        int i = 0;
        if (str.startsWith("http://")) {
            if (!d(str.replace("http://", ""))) {
                String replace = str.replace("http://", "");
                String[] split2 = replace.split(":");
                if (split2.length >= 1) {
                    boolean contains = str.contains("iplist");
                    if (d(split2[0]) && !contains) {
                        hashMap.put("key_qr_ip", split2[0]);
                        if (split2[1].length() != 4) {
                            if (split2[1].contains("devicename=")) {
                                for (String str2 : split2[1].split("&")) {
                                    if (str2.contains("devicename=")) {
                                        f2912a = str2.substring(str2.indexOf("devicename=") + 11);
                                    }
                                }
                            }
                            if (!split2[1].contains("wifi_password=")) {
                                if (split2[1].contains("pincode=")) {
                                    hashMap.put("key_qr_type", 2);
                                    substring = split2[1].substring(split2[1].indexOf("pinCode=") + 8);
                                    hashMap.put("key_qr_pin", substring);
                                    break;
                                }
                            } else {
                                hashMap.put("key_qr_type", 3);
                                hashMap.put("key_qr_wifi_psw", split2[1].substring(split2[1].indexOf("wifi_password=") + 14));
                                String[] split3 = split2[1].split("&");
                                int length = split3.length;
                                while (i < length) {
                                    String str3 = split3[i];
                                    if (str3.contains("ssid=")) {
                                        hashMap.put("key_qr_wifi_ssid", str3.substring(str3.indexOf("ssid=") + 5));
                                    } else if (str3.contains("pincode=")) {
                                        hashMap.put("key_qr_pin", str3.substring(str3.indexOf("pincode=") + 8));
                                    }
                                    i++;
                                }
                            }
                        } else {
                            hashMap.put("key_qr_type", 1);
                        }
                    } else {
                        String substring2 = replace.substring(replace.indexOf("?") + 1);
                        if (!TextUtils.isEmpty(substring2)) {
                            if (contains) {
                                String[] split4 = substring2.split("&");
                                for (String str4 : split4) {
                                }
                                if (split4[0] != null) {
                                    String[] split5 = split4[0].split(":");
                                    if (d(split5[0])) {
                                        hashMap.put("key_qr_type", 2);
                                        hashMap.put("key_qr_ip", split5[0]);
                                    }
                                }
                                if (split4.length > 2 && split4[2] != null && split4[2].contains("ssid")) {
                                    String[] split6 = split4[2].split("=");
                                    if (split6.length > 1) {
                                        hashMap.put("key_qr_wifi_ssid", split6[1]);
                                    }
                                }
                                if (split4.length > 4 && split4[4] != null && split4[4].contains("pincode")) {
                                    String[] split7 = split4[4].split("=");
                                    if (split7.length > 1) {
                                        hashMap.put("key_qr_pin", split7[1]);
                                    }
                                }
                                if (split4.length > 7 && split4[7] != null && split4[7].contains("password")) {
                                    String[] split8 = split4[7].split("=");
                                    if (split8.length > 1) {
                                        hashMap.put("key_qr_wifi_psw", split8[1]);
                                    }
                                }
                            } else {
                                String[] split9 = substring2.split(":");
                                if (d(split9[0])) {
                                    hashMap.put("key_qr_type", 2);
                                    hashMap.put("key_qr_ip", split9[0]);
                                    String[] split10 = split9[1].split("&");
                                    int length2 = split10.length;
                                    while (i < length2) {
                                        String str5 = split10[i];
                                        if (str5.contains("pincode=")) {
                                            substring = str5.substring(str5.indexOf("pincode=") + 8);
                                            hashMap.put("key_qr_pin", substring);
                                            break;
                                        }
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                hashMap.put("key_qr_type", 1);
                hashMap.put("key_qr_ip", str.replace("http://", ""));
            }
            return hashMap;
        }
        hashMap.put("key_qr_type", 0);
        return hashMap;
    }

    public static String b(Context context, String str) {
        int intValue = 999999 - Integer.valueOf(str).intValue();
        int i = (intValue % 65536) / 256;
        int i2 = intValue % 256;
        int ipAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
        int i3 = ipAddress & 255;
        int i4 = (ipAddress >> 8) & 255;
        l.a("ipDecode", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        return String.format("%d.%d.%d.%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static String b(String str) {
        return a(str, System.currentTimeMillis());
    }

    public static boolean b(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).equals(simpleDateFormat.format(Long.valueOf(j)));
    }

    public static boolean c(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            long time = simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()))).getTime();
            return time > j && time - j < 86400000;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(50)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        return Pattern.matches("[a-zA-Z]+", str);
    }

    public static boolean d(String str) {
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }
}
