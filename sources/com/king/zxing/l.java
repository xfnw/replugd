package com.king.zxing;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: e  reason: collision with root package name */
    private static final String f3307e = "l";

    /* renamed from: a  reason: collision with root package name */
    private final Activity f3308a;

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver f3309b = new b(this);

    /* renamed from: c  reason: collision with root package name */
    private boolean f3310c = false;

    /* renamed from: d  reason: collision with root package name */
    private AsyncTask<Object, Object, Object> f3311d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Activity> f3312a;

        public a(Activity activity) {
            this.f3312a = new WeakReference<>(activity);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                Log.i(l.f3307e, "Finishing activity due to inactivity");
                Activity activity = this.f3312a.get();
                if (activity == null) {
                    return null;
                }
                activity.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<l> f3313a;

        public b(l lVar) {
            this.f3313a = new WeakReference<>(lVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            l lVar;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction()) && (lVar = this.f3313a.get()) != null) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    lVar.a();
                } else {
                    lVar.f();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Activity activity) {
        this.f3308a = activity;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        AsyncTask<Object, Object, Object> asyncTask = this.f3311d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f3311d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        f();
        this.f3311d = new a(this.f3308a);
        try {
            this.f3311d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
            Log.w(f3307e, "Couldn't schedule inactivity task; ignoring");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        f();
        if (this.f3310c) {
            this.f3308a.unregisterReceiver(this.f3309b);
            this.f3310c = false;
        } else {
            Log.w(f3307e, "PowerStatusReceiver was never registered?");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        if (this.f3310c) {
            Log.w(f3307e, "PowerStatusReceiver was already registered?");
        } else {
            this.f3308a.registerReceiver(this.f3309b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f3310c = true;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        f();
    }
}
