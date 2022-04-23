package com.ecloud.eshare.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.ecloud.eshare.a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public final class i {
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

    public static String a(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static String a(File file) {
        String lowerCase = file.getName().toLowerCase();
        return !lowerCase.contains(".") ? "" : lowerCase.substring(lowerCase.lastIndexOf(".") + 1);
    }

    public static void a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.graphics.Bitmap] */
    public static void a(Bitmap bitmap, File file) {
        Throwable th;
        IOException e2;
        FileOutputStream fileOutputStream;
        if (bitmap != 0) {
            a(file.getParent());
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e3) {
                    e2 = e3;
                }
                try {
                    fileOutputStream2 = 100;
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e2 = e4;
                    fileOutputStream2 = fileOutputStream;
                    e2.printStackTrace();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                        fileOutputStream2 = fileOutputStream2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        Throwable th;
        IOException e2;
        BufferedWriter bufferedWriter;
        a(a.f);
        File file = new File(a.f, str2);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, z));
                } catch (IOException e3) {
                    e2 = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.close();
            } catch (IOException e4) {
                e2 = e4;
                bufferedWriter2 = bufferedWriter;
                e2.printStackTrace();
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static boolean a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    public static String b(File file) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a(file));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "*/*" : mimeTypeFromExtension;
    }

    public static void b(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).apply();
    }

    public static void b(Context context, String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).apply();
    }

    public static boolean c(File file) {
        return file != null && file.isFile() && b(file).contains("image/");
    }
}
