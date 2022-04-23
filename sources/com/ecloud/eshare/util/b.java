package com.ecloud.eshare.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f2909a = 800;

    /* renamed from: b  reason: collision with root package name */
    public static int f2910b = 600;

    /* renamed from: c  reason: collision with root package name */
    private static int f2911c;

    public static Bitmap a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        int ceil = (int) Math.ceil(options.outWidth / i);
        int ceil2 = (int) Math.ceil(options.outHeight / i2);
        if (ceil < ceil2 || ceil < 1) {
            ceil = (ceil2 < ceil || ceil2 < 1) ? 1 : ceil2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = ceil;
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap a(String str, Activity activity) {
        f2911c = activity.getIntent().getIntExtra("ROTATION", 0);
        int i = f2911c;
        if (i == 90 || i == 270) {
            f2909a = 600;
            f2910b = 800;
        }
        return a(str, f2909a, f2910b);
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static String a(String str) {
        return a(String.format("http://%s:8000/remote/screencapture", str), new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera"), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r8, java.io.File r9, boolean r10) {
        /*
            boolean r0 = r9.exists()
            if (r0 != 0) goto L_0x0009
            r9.mkdirs()
        L_0x0009:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = a()
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = "IMG_%s.png"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r9, r0)
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x0027
            r1.delete()
        L_0x0027:
            r0 = 0
            java.net.URL r3 = new java.net.URL     // Catch: all -> 0x0084, IOException -> 0x009b
            r3.<init>(r8)     // Catch: all -> 0x0084, IOException -> 0x009b
            java.net.URLConnection r3 = r3.openConnection()     // Catch: all -> 0x0084, IOException -> 0x009b
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: all -> 0x0084, IOException -> 0x009b
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch: all -> 0x0084, IOException -> 0x009b
            r4 = 10000(0x2710, float:1.4013E-41)
            r3.setReadTimeout(r4)     // Catch: all -> 0x0084, IOException -> 0x009b
            int r4 = r3.getResponseCode()     // Catch: all -> 0x0084, IOException -> 0x009b
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x00b1
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch: all -> 0x0084, IOException -> 0x009b
            java.io.InputStream r3 = r3.getInputStream()     // Catch: all -> 0x0084, IOException -> 0x009b
            r4.<init>(r3)     // Catch: all -> 0x0084, IOException -> 0x009b
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: all -> 0x007e, IOException -> 0x0082
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: all -> 0x007e, IOException -> 0x0082
            r5.<init>(r1)     // Catch: all -> 0x007e, IOException -> 0x0082
            r3.<init>(r5)     // Catch: all -> 0x007e, IOException -> 0x0082
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: all -> 0x007c, IOException -> 0x009d
        L_0x005c:
            int r6 = r4.read(r5)     // Catch: all -> 0x007c, IOException -> 0x009d
            r7 = -1
            if (r6 == r7) goto L_0x0067
            r3.write(r5, r2, r6)     // Catch: all -> 0x007c, IOException -> 0x009d
            goto L_0x005c
        L_0x0067:
            java.lang.String r8 = r1.getAbsolutePath()     // Catch: all -> 0x007c, IOException -> 0x009d
            r4.close()     // Catch: IOException -> 0x006f
            goto L_0x0073
        L_0x006f:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0073:
            r3.close()     // Catch: IOException -> 0x0077
            goto L_0x007b
        L_0x0077:
            r9 = move-exception
            r9.printStackTrace()
        L_0x007b:
            return r8
        L_0x007c:
            r8 = move-exception
            goto L_0x0080
        L_0x007e:
            r8 = move-exception
            r3 = r0
        L_0x0080:
            r0 = r4
            goto L_0x0086
        L_0x0082:
            r3 = r0
            goto L_0x009d
        L_0x0084:
            r8 = move-exception
            r3 = r0
        L_0x0086:
            if (r0 == 0) goto L_0x0090
            r0.close()     // Catch: IOException -> 0x008c
            goto L_0x0090
        L_0x008c:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0090:
            if (r3 == 0) goto L_0x009a
            r3.close()     // Catch: IOException -> 0x0096
            goto L_0x009a
        L_0x0096:
            r9 = move-exception
            r9.printStackTrace()
        L_0x009a:
            throw r8
        L_0x009b:
            r3 = r0
            r4 = r3
        L_0x009d:
            if (r4 == 0) goto L_0x00a7
            r4.close()     // Catch: IOException -> 0x00a3
            goto L_0x00a7
        L_0x00a3:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00a7:
            if (r3 == 0) goto L_0x00b1
            r3.close()     // Catch: IOException -> 0x00ad
            goto L_0x00b1
        L_0x00ad:
            r3 = move-exception
            r3.printStackTrace()
        L_0x00b1:
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x00ba
            r1.delete()
        L_0x00ba:
            if (r10 == 0) goto L_0x00c1
            java.lang.String r8 = a(r8, r9, r2)
            return r8
        L_0x00c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.util.b.a(java.lang.String, java.io.File, boolean):java.lang.String");
    }
}
