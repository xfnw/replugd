package com.ecloud.eshare.util;

import android.content.Intent;
import com.ecloud.eshare.activity.MainActivity;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class MsgPassService extends d {

    /* loaded from: classes.dex */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(1);
            thread.setName("msgPas");
            return thread;
        }
    }

    public MsgPassService() {
        super(Executors.newFixedThreadPool(3, new a()));
    }

    @Override // com.ecloud.eshare.util.d
    protected void a(Intent intent) {
        MainActivity.J().D0.e(intent.getStringExtra("command"));
    }
}
