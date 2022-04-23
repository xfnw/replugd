package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class f extends Handler implements l {

    /* renamed from: b  reason: collision with root package name */
    private final k f3806b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final int f3807c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3808d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3809e;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(c cVar, Looper looper, int i) {
        super(looper);
        this.f3808d = cVar;
        this.f3807c = i;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f3806b.a(a2);
            if (!this.f3809e) {
                this.f3809e = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                j a2 = this.f3806b.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f3806b.a();
                        if (a2 == null) {
                            this.f3809e = z;
                            return;
                        }
                    }
                }
                this.f3808d.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f3807c);
            if (sendMessage(obtainMessage())) {
                z = true;
                return;
            }
            throw new e("Could not send handler message");
        } finally {
            this.f3809e = z;
        }
    }
}
