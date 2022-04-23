package org.greenrobot.eventbus;

import android.os.Looper;

/* loaded from: classes.dex */
public interface h {

    /* loaded from: classes.dex */
    public static class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f3812a;

        public a(Looper looper) {
            this.f3812a = looper;
        }

        @Override // org.greenrobot.eventbus.h
        public l a(c cVar) {
            return new f(cVar, this.f3812a, 10);
        }

        @Override // org.greenrobot.eventbus.h
        public boolean a() {
            return this.f3812a == Looper.myLooper();
        }
    }

    l a(c cVar);

    boolean a();
}
