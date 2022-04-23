package b.b.a.n;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1703a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1704b = true;

    /* renamed from: c  reason: collision with root package name */
    public static String f1705c = "miao";

    public static void a(String str) {
        b(f1705c, str);
    }

    public static void a(String str, String str2) {
        boolean z = f1703a;
        c(str, str2);
    }

    public static void a(Object... objArr) {
        a(f1705c, d(objArr));
    }

    public static String b(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static void b(String str, String str2) {
        if (f1703a) {
            Log.e(str, str2);
        }
        c(str, str2);
    }

    public static void b(Object... objArr) {
        b(f1705c, d(objArr));
    }

    public static void c(String str) {
        Throwable th;
        Exception e2;
        FileOutputStream fileOutputStream;
        String format = new SimpleDateFormat("yyyyMMdd_HH", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        String str2 = b.eshareDir + "/Log";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str2 + "/log" + format + ".txt", true);
                } catch (Exception e3) {
                    e2 = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            } catch (Exception e4) {
                e2 = e4;
                fileOutputStream2 = fileOutputStream;
                e2.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
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

    private static void c(String str, String str2) {
        if (f1704b && f1703a) {
            c(b("[yyyyMMdd_HHmmss.SSS]") + " --- " + str + " --- " + str2 + "\r\n");
        }
    }

    public static void c(Object... objArr) {
        d(f1705c, d(objArr));
    }

    private static String d(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "[empty]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i = 1; i < objArr.length; i++) {
            sb.append(" - ");
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    public static void d(String str, String str2) {
        if (f1703a) {
            Log.w(str, str2);
        }
        c(str, str2);
    }
}
