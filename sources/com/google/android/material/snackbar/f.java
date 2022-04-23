package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class f {

    /* renamed from: e  reason: collision with root package name */
    private static f f3221e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f3222a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3223b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    private c f3224c;

    /* renamed from: d  reason: collision with root package name */
    private c f3225d;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            f.this.a((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<b> f3227a;

        /* renamed from: b  reason: collision with root package name */
        int f3228b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3229c;

        boolean a(b bVar) {
            return bVar != null && this.f3227a.get() == bVar;
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a() {
        if (f3221e == null) {
            f3221e = new f();
        }
        return f3221e;
    }

    private boolean a(c cVar, int i) {
        b bVar = cVar.f3227a.get();
        if (bVar == null) {
            return false;
        }
        this.f3223b.removeCallbacksAndMessages(cVar);
        bVar.a(i);
        return true;
    }

    private void b(c cVar) {
        int i = cVar.f3228b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.f3223b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f3223b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
        }
    }

    private boolean c(b bVar) {
        c cVar = this.f3224c;
        return cVar != null && cVar.a(bVar);
    }

    public void a(b bVar) {
        synchronized (this.f3222a) {
            if (c(bVar) && !this.f3224c.f3229c) {
                this.f3224c.f3229c = true;
                this.f3223b.removeCallbacksAndMessages(this.f3224c);
            }
        }
    }

    void a(c cVar) {
        synchronized (this.f3222a) {
            if (this.f3224c == cVar || this.f3225d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public void b(b bVar) {
        synchronized (this.f3222a) {
            if (c(bVar) && this.f3224c.f3229c) {
                this.f3224c.f3229c = false;
                b(this.f3224c);
            }
        }
    }
}
