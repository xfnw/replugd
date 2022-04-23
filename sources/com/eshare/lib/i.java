package com.eshare.lib;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class i {
    /* renamed from: a */
    public static String unicode(String str) {
        try {
            return a(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
        if (r2 >= r0) goto L_0x00a0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
        if (r7 == '%') goto L_0x0098;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
        throw new java.lang.IllegalArgumentException("URLDecoder: Incomplete trailing escape (%) pattern");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a0, code lost:
        r1.append(new java.lang.String(r6, 0, r5, r13));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eshare.lib.i.a(java.lang.String, java.lang.String):java.lang.String");
    }

    static boolean a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return true;
        }
        if (c2 < 'A' || c2 > 'F') {
            return c2 >= 'a' && c2 <= 'f';
        }
        return true;
    }

    /* renamed from: b */
    public static String urlencoder(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("/")) {
            try {
                sb.append(URLEncoder.encode(str2, "utf-8"));
                sb.append("/");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        if (!str.endsWith("/")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
