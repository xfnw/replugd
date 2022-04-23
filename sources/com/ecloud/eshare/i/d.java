package com.ecloud.eshare.i;

import android.os.Process;
import android.util.Log;
import com.ecloud.eshare.util.c;
import com.ecloud.eshare.util.l;
import java.lang.Thread;

/* loaded from: classes.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2856a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static d f2857a = new d();
    }

    private d() {
    }

    private boolean a(Thread thread, Throwable th) {
        if (!(thread == null || th == null)) {
            l.a(Log.getStackTraceString(th), String.format("%s_%s.txt", "Exception", c.b("yyyyMMdd_HHmmss_SSS")), false);
            l.b("[未捕获异常]", thread.getName(), Log.getStackTraceString(th));
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
        return false;
    }

    public static d b() {
        return b.f2857a;
    }

    public void a() {
        this.f2856a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (a(thread, th) && (uncaughtExceptionHandler = this.f2856a) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
