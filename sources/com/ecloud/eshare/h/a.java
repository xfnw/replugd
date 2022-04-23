package com.ecloud.eshare.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ecloud.eshare.util.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f2846a;

    /* renamed from: b  reason: collision with root package name */
    private c f2847b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2848c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2849d;

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            l.a("CastReceiver", action);
            if ("com.eshare.action.mirror.connected".equals(action)) {
                a.this.f2849d = true;
                for (b bVar : a.this.f2846a) {
                    if (bVar != null) {
                        bVar.a(true);
                    }
                }
            } else if ("com.eshare.action.mirror.disconnected".equals(action)) {
                a.this.f2849d = false;
                for (b bVar2 : a.this.f2846a) {
                    if (bVar2 != null) {
                        bVar2.a(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private static a f2851a = new a();
    }

    private a() {
        this.f2846a = new ArrayList();
    }

    public static a a() {
        return d.f2851a;
    }

    public void a(Context context) {
        this.f2848c = context;
    }

    public void a(b bVar) {
        this.f2846a.add(bVar);
        if (!this.f2846a.isEmpty()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.eshare.action.mirror.connected");
            intentFilter.addAction("com.eshare.action.mirror.disconnected");
            this.f2847b = new c();
            this.f2848c.registerReceiver(this.f2847b, intentFilter);
        }
    }

    public void b(b bVar) {
        this.f2846a.remove(bVar);
        if (this.f2846a.isEmpty()) {
            this.f2848c.unregisterReceiver(this.f2847b);
            this.f2847b = null;
        }
    }
}
