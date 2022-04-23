package com.eshare.lib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import b.b.a.n.b;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3001a;

    private a() {
    }

    public static a a() {
        if (f3001a == null) {
            f3001a = new a();
        }
        return f3001a;
    }

    public Bitmap a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        int ceil = (int) Math.ceil(options.outHeight / i2);
        int ceil2 = (int) Math.ceil(options.outWidth / i);
        if (ceil <= 1 && ceil2 <= 1) {
            ceil2 = 1;
        } else if (ceil > ceil2) {
            ceil2 = ceil;
        }
        if (new File(str).length() <= 655360) {
            return decodeFile;
        }
        options.inSampleSize = ceil2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0081, code lost:
        if (r6.endsWith("png") == false) goto L_0x0085;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.File r6) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = b.b.a.n.b.absPath
            r1.append(r2)
            java.lang.String r2 = "/.esharecache/1080p/"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0021
            r0.mkdirs()
        L_0x0021:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = b.b.a.n.b.absPath
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = r6.getAbsolutePath()
            java.lang.String r3 = b.b.a.n.b.absPath
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replace(r3, r4)
            java.lang.String r3 = "/"
            java.lang.String r4 = "$"
            java.lang.String r2 = r2.replace(r3, r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0055
            return
        L_0x0055:
            java.lang.String r1 = r6.getAbsolutePath()
            r2 = 1920(0x780, float:2.69E-42)
            r3 = 1080(0x438, float:1.513E-42)
            android.graphics.Bitmap r1 = r5.a(r1, r2, r3)
            java.lang.String r6 = r6.getName()
            java.lang.String r6 = r6.toLowerCase()
            r2 = 0
            java.lang.String r3 = "jpg"
            boolean r3 = r6.endsWith(r3)     // Catch: Exception -> 0x00a5
            if (r3 != 0) goto L_0x0083
            java.lang.String r3 = "jpeg"
            boolean r3 = r6.endsWith(r3)     // Catch: Exception -> 0x00a5
            if (r3 == 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            java.lang.String r3 = "png"
            boolean r6 = r6.endsWith(r3)     // Catch: Exception -> 0x00a5
            if (r6 == 0) goto L_0x0085
        L_0x0083:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: Exception -> 0x00a5
        L_0x0085:
            if (r1 == 0) goto L_0x0099
            if (r2 == 0) goto L_0x0099
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: Exception -> 0x00a5
            r6.<init>(r0)     // Catch: Exception -> 0x00a5
            r0 = 85
            r1.compress(r2, r0, r6)     // Catch: Exception -> 0x00a5
            r6.flush()     // Catch: Exception -> 0x00a5
            r6.close()     // Catch: Exception -> 0x00a5
        L_0x0099:
            if (r1 == 0) goto L_0x00a9
            boolean r6 = r1.isRecycled()     // Catch: Exception -> 0x00a5
            if (r6 != 0) goto L_0x00a9
            r1.recycle()     // Catch: Exception -> 0x00a5
            goto L_0x00a9
        L_0x00a5:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eshare.lib.a.a(java.io.File):void");
    }

    /* renamed from: b */
    public void compressFile(File file) {
        File file2 = new File(b.esharecache720);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File resultPath = new File(b.esharecache720 + "/" + file.getAbsolutePath().replace(b.absPath, "").replace("/", "$"));
        if (!resultPath.exists()) {
            Bitmap a2 = a(file.getAbsolutePath(), 1280, 720);
            try {
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                if (!(a2 == null || compressFormat == null)) {
                    FileOutputStream fileOutputStream = new FileOutputStream(resultPath);
                    a2.compress(compressFormat, 85, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                if (a2 != null && !a2.isRecycled()) {
                    a2.recycle();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
