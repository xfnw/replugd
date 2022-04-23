package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: c  reason: collision with root package name */
    private static c f1154c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0037a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f1155b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f1156c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f1157d;

        RunnableC0037a(String[] strArr, Activity activity, int i) {
            this.f1155b = strArr;
            this.f1156c = activity;
            this.f1157d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f1155b.length];
            PackageManager packageManager = this.f1156c.getPackageManager();
            String packageName = this.f1156c.getPackageName();
            int length = this.f1155b.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f1155b[i], packageName);
            }
            ((b) this.f1156c).onRequestPermissionsResult(this.f1157d, this.f1155b, iArr);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(Activity activity, int i, int i2, Intent intent);

        boolean a(Activity activity, String[] strArr, int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);
    }

    public static c a() {
        return f1154c;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, String[] strArr, int i) {
        c cVar = f1154c;
        if (cVar != null && cVar.a(activity, strArr, i)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof d) {
                ((d) activity).a(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0037a(strArr, activity, i));
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
