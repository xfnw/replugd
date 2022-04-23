package com.ecloud.eshare.util;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class d extends Service {

    /* renamed from: b  reason: collision with root package name */
    private final b f2913b = new b(this, null);

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2914c;

    /* renamed from: d  reason: collision with root package name */
    private int f2915d;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f2916b;

        a(Intent intent) {
            this.f2916b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.a(this.f2916b);
            } finally {
                d.this.f2913b.sendMessage(Message.obtain(d.this.f2913b));
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends Handler {
        private b() {
        }

        /* synthetic */ b(d dVar, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (d.b(d.this) == 0) {
                d.this.stopSelf();
            }
        }
    }

    public d(Executor executor) {
        this.f2914c = executor;
    }

    static /* synthetic */ int b(d dVar) {
        int i = dVar.f2915d - 1;
        dVar.f2915d = i;
        return i;
    }

    protected abstract void a(Intent intent);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        this.f2915d++;
        this.f2914c.execute(new a(intent));
        return 2;
    }
}
