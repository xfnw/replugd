package com.king.zxing.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
final class a implements Camera.AutoFocusCallback {
    private static final String f = a.class.getSimpleName();
    private static final Collection<String> g = new ArrayList(2);

    /* renamed from: a  reason: collision with root package name */
    private boolean f3314a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3315b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3316c;

    /* renamed from: d  reason: collision with root package name */
    private final Camera f3317d;

    /* renamed from: e  reason: collision with root package name */
    private AsyncTask<?, ?, ?> f3318e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.king.zxing.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class AsyncTaskC0094a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f3319a;

        public AsyncTaskC0094a(a aVar) {
            this.f3319a = new WeakReference<>(aVar);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(1200L);
            } catch (InterruptedException unused) {
            }
            a aVar = this.f3319a.get();
            if (aVar == null) {
                return null;
            }
            aVar.a();
            return null;
        }
    }

    static {
        g.add("auto");
        g.add("macro");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, Camera camera) {
        this.f3317d = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = true;
        this.f3316c = (!defaultSharedPreferences.getBoolean("preferences_auto_focus", true) || !g.contains(focusMode)) ? false : z;
        String str = f;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f3316c);
        a();
    }

    private synchronized void c() {
        if (!this.f3314a && this.f3318e == null) {
            AsyncTaskC0094a aVar = new AsyncTaskC0094a(this);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f3318e = aVar;
            } catch (RejectedExecutionException e2) {
                Log.w(f, "Could not request auto focus", e2);
            }
        }
    }

    private synchronized void d() {
        if (this.f3318e != null) {
            if (this.f3318e.getStatus() != AsyncTask.Status.FINISHED) {
                this.f3318e.cancel(true);
            }
            this.f3318e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (this.f3316c) {
            this.f3318e = null;
            if (!this.f3314a && !this.f3315b) {
                try {
                    this.f3317d.autoFocus(this);
                    this.f3315b = true;
                } catch (RuntimeException e2) {
                    Log.w(f, "Unexpected exception while focusing", e2);
                    c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        this.f3314a = true;
        if (this.f3316c) {
            d();
            try {
                this.f3317d.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(f, "Unexpected exception while cancelling focusing", e2);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f3315b = false;
        c();
    }
}
