package b.b.a.l;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import b.b.a.n.h;

/* loaded from: classes.dex */
public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private b f1690a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1691b;

    /* renamed from: c  reason: collision with root package name */
    private int f1692c = 0;

    public c(Context context, b bVar, a aVar) {
        this.f1690a = bVar;
        this.f1691b = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        h.b("miao", "register bluetooth notification......");
        this.f1691b.registerReceiver(this, intentFilter);
        this.f1692c++;
    }

    public void a() {
        h.b("miao", "regcuont=" + this.f1692c);
        if (this.f1692c > 0) {
            this.f1691b.unregisterReceiver(this);
        }
        this.f1692c--;
    }

    public void b() {
        this.f1690a.e();
    }

    public void c() {
        this.f1690a.G();
    }

    public void d() {
        this.f1690a.r();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            h.b("miao", "Incoming intent : " + action);
            char c2 = 65535;
            switch (action.hashCode()) {
                case -1780914469:
                    if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1167529923:
                    if (action.equals("android.bluetooth.device.action.FOUND")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1244161670:
                    if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2116862345:
                    if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                h.b("miao", "BroadcastReceiverDelegator Device discovered! " + a.c(bluetoothDevice));
                this.f1690a.a(bluetoothDevice);
            } else if (c2 == 1) {
                h.b("miao", "BroadcastReceiverDelegator Discovery ended.");
                this.f1690a.G();
            } else if (c2 == 2) {
                h.b("miao", "BBroadcastReceiverDelegator luetooth state changed.");
                this.f1690a.o();
            } else if (c2 == 3) {
                h.b("miao", "BroadcastReceiverDelegator Bluetooth bonding state changed.");
                this.f1690a.m();
            } else if (c2 == 4) {
                h.b("miao", "BroadcastReceiverDelegator A2dp ACTION_CONNECTION_STATE_CHANGED.");
                this.f1690a.b(intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0));
            }
        }
    }
}
