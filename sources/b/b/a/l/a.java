package b.b.a.l;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import b.b.a.n.h;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothAdapter f1686a;

    /* renamed from: b  reason: collision with root package name */
    private final c f1687b;

    /* renamed from: c  reason: collision with root package name */
    private final Activity f1688c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1689d;

    public a(Activity activity, BluetoothAdapter bluetoothAdapter, b bVar) {
        h.b("miao", "init BluetoothController.....");
        this.f1688c = activity;
        this.f1686a = bluetoothAdapter;
        this.f1687b = new c(activity, bVar, this);
    }

    public static String c(BluetoothDevice bluetoothDevice) {
        return "[Address: " + bluetoothDevice.getAddress() + ", Name: " + bluetoothDevice.getName() + "]";
    }

    public void a() {
        BluetoothAdapter bluetoothAdapter = this.f1686a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
            this.f1687b.c();
        }
    }

    public boolean a(BluetoothDevice bluetoothDevice) {
        return this.f1686a.getBondedDevices().contains(bluetoothDevice);
    }

    public void b() {
        c cVar = this.f1687b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean b(BluetoothDevice bluetoothDevice) {
        if (this.f1686a.isDiscovering()) {
            h.b("miao", "Bluetooth cancelling discovery.");
            this.f1686a.cancelDiscovery();
        }
        h.b("miao", "Bluetooth bonding with device: " + c(bluetoothDevice));
        boolean createBond = bluetoothDevice.createBond();
        h.b("miao", "Bounding outcome : " + createBond);
        return createBond;
    }

    public boolean c() {
        return this.f1686a.isEnabled();
    }

    public boolean d() {
        return this.f1686a.isDiscovering();
    }

    public void e() {
        int state = this.f1686a.getState();
        if (state == 10) {
            h.b("miao", "BluetoothAdapter.STATE_OFF,Error while turning Bluetooth on.");
            if (!this.f1689d) {
                return;
            }
        } else if (state != 12) {
            h.b("miao", "Bluetooth is turning ON or OFF. Ignore.");
            return;
        } else {
            h.b("miao", "Bluetooth succesfully enabled, starting discovery");
            this.f1687b.b();
            if (this.f1689d) {
                f();
            } else {
                return;
            }
        }
        this.f1689d = false;
    }

    public void f() {
        this.f1687b.d();
        if (androidx.core.content.a.a(this.f1688c, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            androidx.core.app.a.a(this.f1688c, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
        }
        if (this.f1686a.isDiscovering()) {
            this.f1686a.cancelDiscovery();
        }
        h.b("miao", "Bluetooth starting discovery.");
        if (!this.f1686a.startDiscovery()) {
            h.b("miao", "StartDiscovery returned false. Maybe Bluetooth isn't on?");
            this.f1687b.c();
        }
    }

    public void g() {
        h.b("miao", "Enabling Bluetooth.");
        this.f1686a.enable();
    }

    public void h() {
        this.f1689d = true;
        g();
    }
}
