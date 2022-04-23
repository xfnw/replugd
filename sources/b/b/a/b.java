package b.b.a;

import android.app.Activity;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.eshare.lib.minetype;
import com.eshare.lib.wifi;
import com.eshare.lib.www.httpd;
import com.eshare.mirror.MirrorScreenCaptureService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class b implements b.b.a.e, b.b.a.c, b.b.a.h, b.b.a.g, b.b.a.f, b.b.a.d, b.b.a.l.b {
    private com.eshare.mirror.l C;
    private BluetoothAdapter D;
    private b.b.a.l.a E;
    private BluetoothA2dp F;
    private b.b.a.m.a G;
    private boolean H;
    private boolean I;
    private boolean J;
    private String K;
    private BluetoothDevice L;
    private List<BluetoothDevice> M;
    private q N;
    private Boolean Q;

    /* renamed from: d */
    private Context f1633d;
    private b.b.a.k.a h;
    private Socket i;
    private httpd k;
    private Socket l;
    private boolean n;
    private volatile boolean o;
    private MediaProjectionManager p;
    private com.eshare.mirror.c q;
    private float r;
    private float s;
    private int v;
    private int w;
    private int x;
    private int y;
    private long z;

    /* renamed from: a */
    private final Object f1630a = new Object();
    private final Handler f = new h(this, Looper.getMainLooper());
    private final Object g = new Object();
    private int j = 8888;
    private int m = 57395;
    private int t = 1280;
    private int u = 720;
    private Set<BluetoothDevice> O = new HashSet();
    private int P = 0;
    private BluetoothProfile.ServiceListener R = new g();

    /* renamed from: b */
    private List<b.b.a.k.a> f1631b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private List<String> f1632c = new CopyOnWriteArrayList();
    private Lock A = new ReentrantLock();
    private com.eshare.lib.a B = com.eshare.lib.a.a();

    /* renamed from: e */
    private ExecutorService f1634e = Executors.newCachedThreadPool();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.b f1635b;

        a(b.b.a.m.b bVar) {
            this.f1635b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1635b != null && !b.this.o) {
                this.f1635b.a((b.b.a.k.a) null);
            }
        }
    }

    /* renamed from: b.b.a.b$b */
    /* loaded from: classes.dex */
    class RunnableC0051b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f1637b;

        RunnableC0051b(String str) {
            this.f1637b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f1637b)) {
                b.this.l(this.f1637b);
            }
            if (b.this.l != null) {
                b.this.K();
            }
            if (b.this.i != null) {
                try {
                    b.this.i.getOutputStream().close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    b.this.i.getInputStream().close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    b.this.i.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (b.this.l != null) {
                try {
                    b.this.l.getOutputStream().close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    b.this.l.getInputStream().close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                try {
                    b.this.l.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.o("ScreenCap\r\nstart\r\n\r\n");
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.o("ScreenCap\r\nfinish\r\n\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.e f1641b;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ int f1643b;

            /* renamed from: c */
            final /* synthetic */ int f1644c;

            /* renamed from: d */
            final /* synthetic */ int f1645d;

            /* renamed from: e */
            final /* synthetic */ String f1646e;

            a(int i, int i2, int i3, String str) {
                this.f1643b = i;
                this.f1644c = i2;
                this.f1645d = i3;
                this.f1646e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.b.a.m.e eVar = e.this.f1641b;
                if (eVar != null) {
                    eVar.a(this.f1643b, this.f1644c, this.f1645d, this.f1646e);
                }
            }
        }

        /* renamed from: b.b.a.b$e$b */
        /* loaded from: classes.dex */
        class RunnableC0052b implements Runnable {
            RunnableC0052b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.b.a.m.e eVar = e.this.f1641b;
                if (eVar != null) {
                    eVar.onError(null);
                }
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.b.a.m.e eVar = e.this.f1641b;
                if (eVar != null) {
                    eVar.onError(null);
                }
            }
        }

        e(b.b.a.m.e eVar) {
            this.f1641b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            Handler handler;
            String str;
            String e2 = b.this.e("MediaControl\r\ngetPlayingInfo\r\n\r\n");
            if (!TextUtils.isEmpty(e2)) {
                ArrayList arrayList = new ArrayList();
                b.b.a.n.h.a("getMediaState", e2);
                try {
                    Matcher matcher = Pattern.compile("-?\\d+").matcher(e2.trim());
                    while (matcher.find()) {
                        arrayList.add(matcher.group(0));
                    }
                    if (arrayList.size() >= 4) {
                        int size = arrayList.size();
                        int parseInt = size >= 5 ? Integer.parseInt((String) arrayList.get(4)) : 1;
                        int parseInt2 = Integer.parseInt((String) arrayList.get(0));
                        int parseInt3 = Integer.parseInt((String) arrayList.get(1));
                        if (size > 8) {
                            str = Integer.parseInt((String) arrayList.get(5)) + "." + Integer.parseInt((String) arrayList.get(6)) + "." + Integer.parseInt((String) arrayList.get(7)) + "." + Integer.parseInt((String) arrayList.get(8));
                        } else {
                            str = "";
                        }
                        b.b.a.n.b.f1697e = Integer.parseInt((String) arrayList.get(3));
                        b.this.f.post(new a(parseInt, parseInt3, parseInt2, str));
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    b.b.a.n.h.c("getMediaState", Log.getStackTraceString(e3));
                    handler = b.this.f;
                    runnable = new RunnableC0052b();
                }
            } else {
                handler = b.this.f;
                runnable = new c();
            }
            handler.post(runnable);
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {

        /* renamed from: b */
        final /* synthetic */ boolean f1649b;

        f(boolean z) {
            this.f1649b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.g(this.f1649b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements BluetoothProfile.ServiceListener {
        g() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i == 2) {
                b.this.F = (BluetoothA2dp) bluetoothProfile;
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            if (i == 2) {
                b.this.F = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends Handler {
        h(b bVar, Looper looper) {
            super(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: b */
        final /* synthetic */ BluetoothDevice f1652b;

        i(BluetoothDevice bluetoothDevice) {
            this.f1652b = bluetoothDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (b.this.E.a(this.f1652b)) {
                if (b.this.F != null) {
                    b.this.N();
                }
                z = true;
            } else {
                z = b.this.E.b(this.f1652b);
            }
            if (z) {
                b.b.a.n.h.a("miao", "pair success");
                return;
            }
            b.b.a.n.h.b("miao", "pair failed");
            if (!b.this.E.c()) {
                b.b.a.n.h.b("miao", "bluetooth havent openfully...");
                b.this.J = true;
                return;
            }
            b.this.G.a(new b.b.a.n.d(400, "can not pair with server's bluetooth"));
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.d f1654b;

        j(b.b.a.m.d dVar) {
            this.f1654b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.N != null) {
                b.this.N.a();
            }
            b bVar = b.this;
            bVar.N = new q(this.f1654b);
            b.this.N.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.d f1656b;

        k(b.b.a.m.d dVar) {
            this.f1656b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.m.d dVar = this.f1656b;
            if (dVar != null) {
                dVar.a(new ArrayList(b.this.f1631b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.k.a f1658b;

        /* renamed from: c */
        final /* synthetic */ String f1659c;

        /* renamed from: d */
        final /* synthetic */ b.b.a.m.b f1660d;

        l(b.b.a.k.a aVar, String str, b.b.a.m.b bVar) {
            this.f1658b = aVar;
            this.f1659c = str;
            this.f1660d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c(this.f1658b, this.f1659c, this.f1660d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.b f1662b;

        m(b bVar, b.b.a.m.b bVar2) {
            this.f1662b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.m.b bVar = this.f1662b;
            if (bVar != null) {
                bVar.a(new b.b.a.n.d(-203));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.b f1663b;

        /* renamed from: c */
        final /* synthetic */ b.b.a.k.a f1664c;

        n(b.b.a.m.b bVar, b.b.a.k.a aVar) {
            this.f1663b = bVar;
            this.f1664c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1663b != null && !b.this.o) {
                this.f1663b.a(this.f1664c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.b f1666b;

        /* renamed from: c */
        final /* synthetic */ b.b.a.n.d f1667c;

        o(b.b.a.m.b bVar, b.b.a.n.d dVar) {
            this.f1666b = bVar;
            this.f1667c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1666b != null && !b.this.o) {
                this.f1666b.a(this.f1667c);
            }
        }
    }

    /* loaded from: classes.dex */
    class p implements Runnable {

        /* renamed from: b */
        final /* synthetic */ b.b.a.m.b f1669b;

        /* renamed from: c */
        final /* synthetic */ b.b.a.n.d f1670c;

        p(b.b.a.m.b bVar, b.b.a.n.d dVar) {
            this.f1669b = bVar;
            this.f1670c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1669b != null && !b.this.o) {
                this.f1669b.a(this.f1670c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements Runnable {

        /* renamed from: b */
        private b.b.a.m.d f1672b;

        /* renamed from: c */
        private boolean f1673c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ b.b.a.m.d f1675b;

            /* renamed from: c */
            final /* synthetic */ Exception f1676c;

            a(q qVar, b.b.a.m.d dVar, Exception exc) {
                this.f1675b = dVar;
                this.f1676c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.b.a.m.d dVar = this.f1675b;
                if (dVar != null) {
                    dVar.a(new b.b.a.n.d(this.f1676c));
                }
            }
        }

        public q(b.b.a.m.d dVar) {
            this.f1672b = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x017d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0051 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(b.b.a.m.d r19) {
            /*
                Method dump skipped, instructions count: 470
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: b.b.a.b.q.a(b.b.a.m.d):void");
        }

        private void b(b.b.a.m.d dVar) {
            synchronized (b.this.f1630a) {
                a(dVar);
            }
        }

        public void a() {
            this.f1673c = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            b(this.f1672b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f1633d = context;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        new ReentrantLock();
        com.eshare.mirror.c.e();
    }

    private void M() {
        if (this.i != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    this.i.setSoTimeout(500);
                    this.i.getInputStream().read(bArr);
                } catch (IOException unused) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        for (BluetoothDevice bluetoothDevice : this.D.getBondedDevices()) {
            if (bluetoothDevice != null && !TextUtils.isEmpty(bluetoothDevice.getAddress()) && TextUtils.equals(bluetoothDevice.getAddress().replaceAll(":", ""), this.K)) {
                this.L = bluetoothDevice;
                a(bluetoothDevice, 100);
                try {
                    Method method = BluetoothA2dp.class.getMethod("connect", BluetoothDevice.class);
                    method.setAccessible(true);
                    method.invoke(this.F, bluetoothDevice);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    private void O() {
        String Q = Q();
        if (Q == null) {
            b.b.a.n.h.b("miao", "hub bt info is null");
            com.eshare.mirror.b.f3054a = 0;
            this.K = "";
            return;
        }
        JsonObject asJsonObject = JsonParser.parseString(Q).getAsJsonObject();
        if (asJsonObject.has("btMacAddress")) {
            this.K = asJsonObject.get("btMacAddress").getAsString();
            b.b.a.n.h.b("miao", "parse hub bt macaddress=" + this.K);
            if (!TextUtils.isEmpty(this.K)) {
                com.eshare.mirror.b.f3054a = 1;
                return;
            }
        } else {
            this.K = "";
        }
        com.eshare.mirror.b.f3054a = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P() {
        return TextUtils.equals("boxlight", "boxlight") ? "BoxlightPro" : "ECloudBox";
    }

    private String Q() {
        return b("getServerInfo\r\n1\r\n\r\n", 2000);
    }

    private boolean R() {
        int i2 = this.P;
        return i2 == 1 || i2 == 2;
    }

    private boolean S() {
        return o("RestartBluetooth\r\nplaceholder\r\n\r\n");
    }

    private void T() {
        if (!this.E.c()) {
            this.E.h();
        } else if (!this.E.d()) {
            b.b.a.n.h.a("miao", "start scan bt device...");
            this.E.f();
        } else {
            this.E.a();
        }
    }

    private File a(File file, int i2) {
        File file2;
        String replace = file.getAbsolutePath().replace(b.b.a.n.b.absPath, "").replace("/", "$");
        if (i2 == 1) {
            file2 = new File(b.b.a.n.b.esharecache1080, replace);
            if (!file2.exists()) {
                this.B.a(file);
            }
        } else if (i2 != 2) {
            file2 = file;
        } else {
            file2 = new File(b.b.a.n.b.esharecache720, replace);
            if (!file2.exists()) {
                this.B.compressFile(file);
            }
        }
        return !file2.exists() ? file : file2;
    }

    private synchronized void a(int i2, int i3, float f2) {
        if (i2 <= 0 || i3 <= 0) {
            this.v = b.b.a.n.c.b(this.f1633d);
            this.w = b.b.a.n.c.a(this.f1633d);
            b.b.a.n.h.a("获取屏幕宽高", Integer.valueOf(this.v), Integer.valueOf(this.w));
        }
        if (i2 <= 0) {
            i2 = this.v;
        }
        if (i3 <= 0) {
            i3 = this.w;
        }
        if (!(this.x == i2 && this.y == i3)) {
            this.x = i2;
            this.y = i3;
            this.r = (this.t * f2) / i2;
            this.s = (this.u * f2) / i3;
            b.b.a.n.h.b("屏幕缩放比", Float.valueOf(f2), Integer.valueOf(this.t), Integer.valueOf(this.u), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(this.r), Float.valueOf(this.s));
        }
    }

    private void a(BluetoothDevice bluetoothDevice, int i2) {
        if (this.F != null) {
            try {
                BluetoothA2dp.class.getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(this.F, bluetoothDevice, Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.b.a.k.a aVar, b.b.a.m.d dVar) {
        this.f.removeCallbacksAndMessages("deviceFound");
        this.f.postAtTime(new k(dVar), "deviceFound", SystemClock.uptimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            int size = this.f1631b.size();
            for (int i2 = 0; i2 < size; i2++) {
                b.b.a.k.a aVar = this.f1631b.get(i2);
                if (str.equals(aVar.b()) && !str2.equals(aVar.a())) {
                    this.f1632c.remove(i2);
                    this.f1631b.remove(i2);
                    return;
                }
            }
        }
    }

    private void b(BluetoothDevice bluetoothDevice) {
        a(bluetoothDevice, 0);
        try {
            BluetoothA2dp.class.getMethod("disconnect", BluetoothDevice.class).invoke(this.F, bluetoothDevice);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.L = null;
    }

    private void b(b.b.a.k.a aVar, String str, b.b.a.m.b bVar) {
        boolean z;
        this.o = false;
        if (aVar == null) {
            this.f.post(new m(this, bVar));
            return;
        }
        String a2 = aVar.a();
        int d2 = aVar.d();
        if (!aVar.e()) {
            if (!(this.i == null && this.l == null)) {
                try {
                    this.i.getOutputStream().close();
                    this.l.getOutputStream().close();
                } catch (Exception unused) {
                }
                try {
                    this.i.getInputStream().close();
                    this.l.getInputStream().close();
                } catch (Exception unused2) {
                }
                try {
                    this.i.close();
                    this.l.close();
                } catch (Exception unused3) {
                }
            }
            b.b.a.n.d dVar = new b.b.a.n.d(-202);
            int i2 = 0;
            boolean z2 = false;
            while (i2 < 3 && !this.o) {
                if (z2) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e2) {
                        dVar.a(e2);
                        e2.printStackTrace();
                        i2++;
                        z2 = true;
                    }
                }
                this.i = new Socket();
                this.i.connect(new InetSocketAddress(InetAddress.getByName(a2), d2), 5000);
                this.i.setSoTimeout(2000);
                this.i.setTcpNoDelay(true);
                z = true;
            }
            z = false;
            if (z) {
                L();
                this.h = aVar;
                j(str);
                H();
                if (!this.Q.booleanValue()) {
                    I();
                    O();
                }
                com.eshare.mirror.b.f3055b = 0;
                b.b.a.n.f.c(this.f1633d, "com.ecloud.eshare.lib.key.DEVICE_NAME", aVar.b());
                this.f.post(new n(bVar, aVar));
            } else {
                if (!aVar.f()) {
                    b.b.a.n.h.a("连接设备失败，删除设备", aVar);
                    this.f1632c.remove(aVar.a());
                    this.f1631b.remove(aVar);
                }
                this.f.post(new o(bVar, dVar));
            }
            b.b.a.n.h.b("connectDeviceThread ===== end", Thread.currentThread());
        }
    }

    private boolean b(MotionEvent motionEvent, boolean z, int i2, int i3, float f2) {
        if (this.i == null) {
            return false;
        }
        String str = z ? "MIRRORTOUCHEVENT" : "TOUCHEVENT";
        int action = motionEvent.getAction();
        if (action == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.z < 55) {
                return false;
            }
            this.z = currentTimeMillis;
        } else if (action == 0) {
            a(i2, i3, f2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("\r\n");
        sb.append(action);
        sb.append("\r\n");
        sb.append("[");
        for (int i4 = 0; i4 < motionEvent.getPointerCount(); i4++) {
            sb.append("={");
            sb.append(motionEvent.getX(i4) * this.r);
            sb.append(",");
            sb.append(motionEvent.getY(i4) * this.s);
            sb.append("}");
        }
        sb.append("]");
        sb.append("\r\n\r\n");
        return o(sb.toString());
    }

    private void c(BluetoothDevice bluetoothDevice) {
        if (!R()) {
            this.I = false;
            this.L = bluetoothDevice;
            this.f.post(new i(bluetoothDevice));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.b.a.k.a aVar, String str, b.b.a.m.b bVar) {
        synchronized (this.g) {
            b(aVar, str, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        return e(z ? 24 : 25);
    }

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            this.G.a(new b.b.a.n.d(500, "bluetooth macaddress of box is empty! "));
            return;
        }
        if (this.H) {
            b.b.a.n.h.a("miao", "search finished....");
            BluetoothDevice bluetoothDevice = null;
            Iterator<BluetoothDevice> it = this.M.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BluetoothDevice next = it.next();
                if (TextUtils.equals(next.getAddress(), str)) {
                    bluetoothDevice = next;
                    break;
                }
            }
            if (bluetoothDevice == null) {
                this.I = true;
            } else {
                c(bluetoothDevice);
                return;
            }
        } else {
            this.I = true;
            if (this.E.d()) {
                return;
            }
        }
        T();
    }

    private BluetoothDevice q(String str) {
        for (BluetoothDevice bluetoothDevice : this.D.getBondedDevices()) {
            if (!TextUtils.isEmpty(bluetoothDevice.getAddress()) && TextUtils.equals(bluetoothDevice.getAddress().replaceAll(":", ""), str)) {
                return bluetoothDevice;
            }
        }
        for (BluetoothDevice bluetoothDevice2 : this.O) {
            if (!TextUtils.isEmpty(bluetoothDevice2.getAddress()) && TextUtils.equals(bluetoothDevice2.getAddress().replaceAll(":", ""), str)) {
                return bluetoothDevice2;
            }
        }
        return null;
    }

    private void r(String str) {
        try {
            int intValue = Integer.valueOf(str.replace("sn=0x", ""), 16).intValue();
            if (((intValue >> 20) & 1) == 1) {
                this.n = true;
            } else {
                this.n = false;
            }
            if (((intValue >> 9) & 1) == 1) {
                this.h.a(1);
            } else {
                this.h.a(0);
            }
            this.Q = ((intValue >> 8) & 1) != 1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // b.b.a.f
    public boolean A() {
        return o("CLEAR\r\ntrue\r\n\r\n");
    }

    @Override // b.b.a.g
    public boolean B() {
        return k("finish");
    }

    @Override // b.b.a.c
    public String C() {
        return e("GetNetworkInfo\r\n1\r\n\r\n");
    }

    @Override // b.b.a.h
    public void D() {
        com.eshare.mirror.l lVar = this.C;
        if (lVar != null) {
            lVar.e();
            this.C = null;
        }
    }

    @Override // b.b.a.d
    public void E() {
        BluetoothDevice bluetoothDevice = this.L;
        if (bluetoothDevice != null) {
            b(bluetoothDevice);
        }
        this.P = 0;
    }

    @Override // b.b.a.d
    public boolean F() {
        return !TextUtils.isEmpty(this.K);
    }

    @Override // b.b.a.l.b
    public void G() {
        b.b.a.n.h.a("miao", "onDeviceDiscoveryEnd");
        this.H = true;
        if (!R() && this.I && this.G != null) {
            this.G.a(new b.b.a.n.d(404, "bluetooth device not found"));
        }
    }

    public boolean H() {
        return o("auth\r\n" + b.b.a.n.b.absPath + " " + this.j + " onelong\r\n\r\n");
    }

    public void I() {
        try {
            JsonObject asJsonObject = new JsonParser().parse(e("getServerInfo\r\n1\r\n\r\n").trim()).getAsJsonObject();
            if (asJsonObject.has("name")) {
                String asString = asJsonObject.get("name").getAsString();
                this.h.b(asString);
                b.b.a.n.h.a("getDeviceName", asString);
            }
        } catch (Exception unused) {
            b.b.a.n.h.a("getDeviceName exception!!!");
        }
    }

    public int[] J() {
        String e2 = e("GETFBINFO\r\n1\r\n\r\n");
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        String[] split = e2.split("\r\n");
        try {
            this.t = Integer.parseInt(split[0]);
            this.u = Integer.parseInt(split[1]);
            return new int[]{this.t, this.u};
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public boolean K() {
        HashMap hashMap = new HashMap();
        hashMap.put("disconnect", "disconnect");
        return m(new Gson().toJson(hashMap));
    }

    public void L() {
        httpd fVar = this.k;
        if (fVar == null) {
            this.k = new httpd(this.f1633d);
            this.k.a(new File("/"));
            int a2 = this.k.getPort();
            this.j = a2;
            b.b.a.n.h.b("mHttpPort", Integer.valueOf(a2));
        } else if (!fVar.b()) {
            this.k.a(new File("/"));
            int a3 = this.k.getPort();
            this.j = a3;
            b.b.a.n.h.b("mHttpPort", Integer.valueOf(a3));
        }
    }

    public String a(String str, int i2) {
        this.A.lock();
        try {
            if (this.l != null) {
                try {
                    this.l.getOutputStream().write(str.getBytes());
                    this.l.getOutputStream().flush();
                    byte[] bArr = new byte[1024];
                    if (i2 > 0) {
                        this.l.setSoTimeout(i2);
                    }
                    int read = this.l.getInputStream().read(bArr);
                    if (read <= 0) {
                        try {
                            this.l.setSoTimeout(500);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return null;
                        }
                    } else {
                        com.eshare.mirror.b.f3055b = 0;
                        String str2 = new String(bArr, 0, read);
                        try {
                            this.l.setSoTimeout(500);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return str2;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    b.b.a.n.h.c("sendReceiveMessage", e4);
                    try {
                        this.l.setSoTimeout(500);
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        return null;
                    }
                }
            }
            return null;
        } finally {
            this.A.unlock();
        }
    }

    @Override // b.b.a.l.b
    public void a(BluetoothDevice bluetoothDevice) {
        b.b.a.n.h.a("miao", "onDeviceDiscovered, device=" + bluetoothDevice.getName());
        this.M.add(bluetoothDevice);
        if (!TextUtils.isEmpty(this.K) && !R() && TextUtils.equals(this.K, bluetoothDevice.getAddress().replaceAll(":", ""))) {
            c(bluetoothDevice);
        }
    }

    @Override // b.b.a.c
    public void a(b.b.a.k.a aVar, String str, b.b.a.m.b bVar) {
        this.f1634e.execute(new l(aVar, str, bVar));
    }

    @Override // b.b.a.d
    public void a(b.b.a.m.a aVar) {
        if (!R()) {
            this.G = aVar;
            if (!TextUtils.isEmpty(this.K)) {
                S();
                if (!this.E.c()) {
                    this.E.g();
                }
                BluetoothDevice q2 = q(this.K);
                if (q2 != null) {
                    c(q2);
                    return;
                }
                b.b.a.n.h.a("miao", "connectBtByMac");
                p(this.K);
                return;
            }
            aVar.a(new b.b.a.n.d(500, "bluetooth macaddress of box is empty! "));
        }
    }

    @Override // b.b.a.c
    public void a(b.b.a.m.d dVar) {
        this.f1634e.execute(new j(dVar));
    }

    @Override // b.b.a.g
    public void a(b.b.a.m.e eVar) {
        this.f1634e.execute(new e(eVar));
    }

    @Override // b.b.a.c
    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("assignHost", true);
        hashMap.put("clientIP", str);
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.c
    public void a(String str, b.b.a.m.b bVar) {
        b.b.a.n.d dVar = new b.b.a.n.d(-202);
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= 3 || this.o) {
                break;
            }
            if (z2) {
                try {
                    Thread.sleep(1000L);
                } catch (Exception e2) {
                    Log.e("miao", "host connect exception=" + e2.getMessage());
                    dVar.a(e2);
                    i2++;
                    z2 = true;
                }
            }
            this.l = new Socket();
            this.l.connect(new InetSocketAddress(InetAddress.getByName(str), this.m), 2000);
            this.l.setSoTimeout(2000);
            this.l.setTcpNoDelay(true);
            z = true;
            break;
        }
        Handler handler = this.f;
        if (!z) {
            handler.post(new p(bVar, dVar));
        } else {
            handler.post(new a(bVar));
        }
    }

    @Override // b.b.a.c
    public void a(String str, String str2, b.b.a.m.b bVar) {
        a(new b.b.a.k.a(str), str2, bVar);
    }

    @Override // b.b.a.c
    public void a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("assignFullScreen", Boolean.valueOf(z));
        hashMap.put("clientIP", str);
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.g
    public boolean a(float f2, float f3, float f4) {
        return o("ImageControl\r\nscale " + f2 + " " + f3 + " " + f4 + "\r\n\r\n");
    }

    public boolean a(float f2, float f3, int i2) {
        if (this.i == null) {
            return false;
        }
        if (i2 == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.z < 55) {
                return false;
            }
            this.z = currentTimeMillis;
        }
        return o("AIRMOUSEEVNET\r\n" + f2 + "\r\n" + f3 + "\r\n" + i2 + "\r\n\r\n");
    }

    @Override // b.b.a.g
    public boolean a(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        return k("seekTo " + i2);
    }

    @Override // b.b.a.f
    public boolean a(int i2, int i3) {
        return o("PEN_STYLE\r\n" + i2 + "\r\n" + i3 + "\r\n\r\n");
    }

    @Override // b.b.a.f
    public boolean a(int i2, int i3, String str) {
        return o("CONTENT\r\n" + i2 + "\r\n" + i3 + " " + str + "\r\n\r\n");
    }

    @Override // b.b.a.d
    public boolean a(Activity activity) {
        this.K = "";
        this.M = new ArrayList();
        if (this.D == null) {
            this.D = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.E == null) {
            this.E = new b.b.a.l.a(activity, this.D, this);
        } else {
            b.b.a.n.h.b("miao", "BluetoothController not null");
        }
        this.D.getProfileProxy(activity.getApplicationContext(), this.R, 2);
        return false;
    }

    @Override // b.b.a.h
    public boolean a(Activity activity, int i2, int i3, Intent intent, Intent intent2) {
        if (this.h == null || Build.VERSION.SDK_INT < 21 || i2 != 100 || i3 != -1 || intent == null) {
            return false;
        }
        Intent intent3 = new Intent(activity, MirrorScreenCaptureService.class);
        if (Build.VERSION.SDK_INT >= 29) {
            intent3.putExtra("code", i3);
            intent3.putExtra("data", intent);
            activity.startForegroundService(intent3);
        } else {
            this.q.a(this.p.getMediaProjection(i3, intent));
            activity.startService(intent3);
        }
        if (intent2 == null) {
            return true;
        }
        activity.startActivity(intent2);
        return true;
    }

    @Override // b.b.a.h
    public boolean a(Activity activity, boolean z) {
        if (this.h == null || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        this.p = (MediaProjectionManager) activity.getSystemService("media_projection");
        this.q = com.eshare.mirror.c.e();
        this.q.a(z);
        if (this.q.c()) {
            activity.sendBroadcast(new Intent("com.eshare.mirror.startmirror"));
            return true;
        }
        activity.startActivityForResult(this.p.createScreenCaptureIntent(), 100);
        return true;
    }

    @Override // b.b.a.h
    public boolean a(Context context) {
        if (this.h == null || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        context.sendBroadcast(new Intent("com.eshare.mirror.startmirror"));
        return true;
    }

    @Override // b.b.a.f
    public boolean a(MotionEvent motionEvent) {
        return b(motionEvent, true, 0, 0, 1.0f);
    }

    @Override // b.b.a.f
    public boolean a(MotionEvent motionEvent, int i2, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        float x = (motionEvent.getX() * this.t) / i2;
        float y = (motionEvent.getY() * this.u) / i3;
        b.b.a.n.h.b("sendNoteEvent", Integer.valueOf(this.t), Integer.valueOf(this.u), Integer.valueOf(i2), Integer.valueOf(i3));
        return o("PAINT_MSG\r\n" + actionMasked + " " + x + " " + y + "\r\n\r\n");
    }

    @Override // b.b.a.f
    public boolean a(MotionEvent motionEvent, int i2, int i3, float f2) {
        return b(motionEvent, false, i2, i3, f2);
    }

    @Override // b.b.a.f
    public boolean a(MotionEvent motionEvent, boolean z, int i2, int i3, float f2) {
        if (this.i == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.z < 55) {
                return false;
            }
            this.z = currentTimeMillis;
        } else if (action == 0) {
            a(i2, i3, f2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SLIDEEVENT");
        sb.append("\r\n");
        sb.append(z ? 1 : 0);
        sb.append("\r\n");
        sb.append(action);
        sb.append("\r\n");
        sb.append("[");
        for (int i4 = 0; i4 < motionEvent.getPointerCount(); i4++) {
            sb.append("={");
            sb.append(motionEvent.getX(i4) * this.r);
            sb.append(",");
            sb.append(motionEvent.getY(i4) * this.s);
            sb.append("}");
        }
        sb.append("]");
        sb.append("\r\n\r\n");
        return o(sb.toString());
    }

    @Override // b.b.a.g
    public boolean a(File file) {
        if (file == null || !file.exists()) {
            b.b.a.n.h.c("文件不存在！");
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        return o("Savefile\r\nSave " + com.eshare.lib.i.urlencoder(absolutePath) + " " + minetype.convertMinetype(absolutePath) + "\r\n\r\n");
    }

    @Override // b.b.a.g
    public boolean a(File file, File file2, File file3) {
        return a(file, file2, file3, 2);
    }

    public boolean a(File file, File file2, File file3, int i2) {
        if (file == null || !file.exists()) {
            b.b.a.n.h.c("文件不存在！");
            return false;
        }
        String str = "";
        String absolutePath = (file2 == null || !file2.exists()) ? str : a(file2, i2).getAbsolutePath();
        if (file3 != null && file3.exists()) {
            str = a(file3, i2).getAbsolutePath();
        }
        String absolutePath2 = a(file, i2).getAbsolutePath();
        return o("Openfile\r\nOpen " + com.eshare.lib.i.urlencoder(absolutePath2) + " " + minetype.convertMinetype(absolutePath2) + " " + com.eshare.lib.i.urlencoder(absolutePath) + " " + com.eshare.lib.i.urlencoder(str) + "\r\n\r\n");
    }

    @Override // b.b.a.g
    public boolean a(String str, List<String> list, int i2) {
        String sb;
        try {
            String str2 = com.eshare.lib.i.urlencoder(str) + "\r\n" + com.eshare.lib.i.urlencoder(b.b.a.n.b.absPath) + "\r\n" + i2 + "\r\n" + com.eshare.lib.i.urlencoder(list.toString()) + "\r\n\r\n";
            int length = (str2.length() / 1024) + 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 == length - 1) {
                    sb = "OpenImages\r\n" + i3 + "\r\n" + length + "\r\n" + str2.substring(i3 * 1024, str2.length());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OpenImages");
                    sb2.append("\r\n");
                    sb2.append(i3);
                    sb2.append("\r\n");
                    sb2.append(length);
                    sb2.append("\r\n");
                    int i4 = i3 * 1024;
                    sb2.append(str2.substring(i4, i4 + 1024));
                    sb2.append("\r\n\r\n");
                    sb = sb2.toString();
                }
                o(sb);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // b.b.a.f
    public boolean a(boolean z) {
        return o("DRAW\r\n" + (z ? 1 : 0) + "\r\n\r\n");
    }

    @Override // b.b.a.c
    public byte[] a() {
        byte[] byteArray;
        if (this.i == null) {
            return null;
        }
        M();
        try {
            this.i.getOutputStream().write("GETAPPINFOSEVNET\r\n1\r\n\r\n".getBytes());
            this.i.getOutputStream().flush();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            try {
                try {
                    try {
                        this.i.setSoTimeout(5000);
                        int i2 = 0;
                        do {
                            int read = this.i.getInputStream().read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            i2 += read;
                        } while (i2 < b.b.a.n.a.a(byteArrayOutputStream.toByteArray(), 0));
                        byteArray = byteArrayOutputStream.toByteArray();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    this.i.setSoTimeout(500);
                }
                if (b.b.a.n.a.a(byteArray, 0) == byteArray.length) {
                    try {
                        this.i.setSoTimeout(500);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return byteArray;
                }
                this.i.setSoTimeout(500);
                return null;
            } catch (Throwable th) {
                try {
                    this.i.setSoTimeout(500);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public synchronized String b(String str, int i2) {
        if (this.i != null) {
            try {
                this.i.getOutputStream().write(str.getBytes());
                this.i.getOutputStream().flush();
                byte[] bArr = new byte[1024];
                if (i2 > 0) {
                    this.i.setSoTimeout(i2);
                }
                int read = this.i.getInputStream().read(bArr);
                if (read <= 0) {
                    try {
                        this.i.setSoTimeout(500);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return null;
                }
                com.eshare.mirror.b.f3055b = 0;
                String str2 = new String(bArr, 0, read);
                try {
                    this.i.setSoTimeout(500);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return str2;
            } catch (IOException e4) {
                e4.printStackTrace();
                b.b.a.n.h.c("sendReceiveMessage", e4);
                try {
                    this.i.setSoTimeout(500);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override // b.b.a.l.b
    public void b(int i2) {
        if (i2 == 0) {
            b.b.a.n.h.b("miao", "BluetoothA2dp.STATE_DISCONNECTED");
            this.P = 0;
            return;
        }
        int i3 = 1;
        if (i2 == 1) {
            b.b.a.n.h.b("miao", "BluetoothA2dp.STATE_CONNECTING");
        } else {
            i3 = 2;
            if (i2 == 2) {
                BluetoothDevice bluetoothDevice = this.L;
                if (bluetoothDevice != null) {
                    this.O.add(bluetoothDevice);
                }
                b.b.a.n.h.b("miao", "BluetoothA2dp.STATE_CONNECTED");
                b.b.a.m.a aVar = this.G;
                if (aVar != null) {
                    aVar.onSuccess();
                }
            } else {
                return;
            }
        }
        this.P = i3;
    }

    @Override // b.b.a.c
    public void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("disconnectWithServer", true);
        hashMap.put("clientIP", str);
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.c
    public void b(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("allowClientCast", Boolean.valueOf(z));
        hashMap.put("clientIP", str);
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.g
    public boolean b() {
        return o("ImageControl\r\nfinish\r\n\r\n");
    }

    public boolean b(float f2, float f3, int i2) {
        if (this.i == null) {
            return false;
        }
        if (i2 == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.z < 55) {
                return false;
            }
            this.z = currentTimeMillis;
        }
        return o("GYROSCOPEEVENT\r\n" + f2 + "\r\n" + f3 + "\r\n" + i2 + "\r\n\r\n");
    }

    @Override // b.b.a.h
    public boolean b(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        context.stopService(new Intent(context, MirrorScreenCaptureService.class));
        return true;
    }

    @Override // b.b.a.f
    public boolean b(MotionEvent motionEvent, int i2, int i3) {
        return b(motionEvent, true, i2, i3, 1.0f);
    }

    @Override // b.b.a.f
    public boolean b(MotionEvent motionEvent, int i2, int i3, float f2) {
        return b(motionEvent, true, i2, i3, f2);
    }

    @Override // b.b.a.g
    public boolean b(File file) {
        if (file == null || !file.exists()) {
            b.b.a.n.h.c("文件不存在！");
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        return o("Openfile\r\nOpen " + com.eshare.lib.i.urlencoder(absolutePath) + " " + minetype.convertMinetype(absolutePath) + "\r\n\r\n");
    }

    @Override // b.b.a.f
    public boolean b(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("captureToBoard", Integer.valueOf(z ? 1 : 0));
        return m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.g
    public void c(boolean z) {
        this.f1634e.execute(new f(z));
    }

    @Override // b.b.a.c
    public boolean c() {
        return this.n;
    }

    @Override // b.b.a.g
    public boolean c(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 180 : 90 : 270;
        return o("ImageControl\r\nrotate " + i3 + "\r\n\r\n");
    }

    @Override // b.b.a.h
    public boolean c(Context context) {
        if (this.h == null || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        context.sendBroadcast(new Intent("com.eshare.mirror.stopmirror"));
        return true;
    }

    @Override // b.b.a.g
    public boolean c(File file) {
        return b(file);
    }

    @Override // b.b.a.c
    public boolean c(String str) {
        if (c() && !b.b.a.n.b.f) {
            return true;
        }
        return o("sayHello\r\n" + str + "\r\n0\r\n\r\n");
    }

    @Override // b.b.a.d
    public void close() {
        b.b.a.l.a aVar = this.E;
        if (aVar != null) {
            aVar.b();
            this.E = null;
        }
        BluetoothA2dp bluetoothA2dp = this.F;
        if (bluetoothA2dp != null) {
            this.D.closeProfileProxy(2, bluetoothA2dp);
        }
    }

    @Override // b.b.a.c
    public String d() {
        HashMap hashMap = new HashMap();
        hashMap.put("reportClientInfo", "N");
        hashMap.put("clientName", b.b.a.n.f.b(this.f1633d, "com.ecloud.eshare.lib.key.CLIENT_NAME", Build.MODEL));
        hashMap.put("clientType", 1);
        hashMap.put("isTouchable", 0);
        hashMap.put("versionName", "v2.1.1116");
        hashMap.put("versionCode", 31);
        String json = new Gson().toJson(hashMap);
        return n(json + "\r\n");
    }

    public InetAddress d(Context context) {
        String str;
        StringBuilder sb;
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getIpAddress() == 0) {
            if (wifi.a(context)) {
                String a2 = wifi.getLanIp();
                if (a2 != null) {
                    String substring = a2.substring(0, a2.lastIndexOf("."));
                    sb = new StringBuilder();
                    sb.append(substring);
                    sb.append(".255");
                } else {
                    str = "192.168.43.255";
                }
            } else {
                str = "255.255.255.255";
            }
            return InetAddress.getByName(str);
        }
        int ipAddress = connectionInfo.getIpAddress();
        StringBuilder sb2 = new StringBuilder();
        int i2 = ipAddress & 255;
        sb2.append(i2);
        sb2.append(".");
        int i3 = (ipAddress >> 8) & 255;
        sb2.append(i3);
        sb2.append(".");
        int i4 = (ipAddress >> 16) & 255;
        sb2.append(i4);
        sb2.append(".");
        sb2.append(255);
        String sb3 = sb2.toString();
        if (!sb3.contains("172.20.10")) {
            return InetAddress.getByName(sb3);
        }
        sb = new StringBuilder();
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        sb.append(".");
        sb.append(i4);
        sb.append(".");
        sb.append(15);
        str = sb.toString();
        return InetAddress.getByName(str);
    }

    @Override // b.b.a.c
    public void d(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("replyCastInvite", Integer.valueOf(i2));
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.c
    public void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("assignClientCast", true);
        hashMap.put("clientIP", str);
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.g
    public boolean d(boolean z) {
        return k(z ? "pause" : "play");
    }

    @Override // b.b.a.c
    public String e(String str) {
        return b(str, 2000);
    }

    @Override // b.b.a.l.b
    public void e() {
        b.b.a.n.h.a("miao", "onBluetoothTurningOn");
        if (this.J) {
            this.J = false;
            c(this.L);
        }
    }

    @Override // b.b.a.c
    public void e(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("replyModeratorAdd", Boolean.valueOf(z));
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.f
    public boolean e(int i2) {
        return o("KEYEVENT\r\n" + i2 + "\r\n\r\n");
    }

    @Override // b.b.a.c
    public b.b.a.k.a f() {
        return this.h;
    }

    @Override // b.b.a.e
    public void f(boolean z) {
        b.b.a.n.f.b(this.f1633d, "com.ecloud.eshare.lib.key.WIRELESS_STORAGE", z);
    }

    @Override // b.b.a.g
    public boolean f(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 30) {
            i2 = 30;
        }
        return k("setVolume " + i2);
    }

    @Override // b.b.a.c
    public boolean f(String str) {
        String str2 = "CHECKPASSWORD\r\n" + str + "\r\n\r\n";
        for (int i2 = 0; i2 < 3; i2++) {
            String b2 = b(str2, 3000);
            b.b.a.n.h.b("authPassword", b2);
            if (!TextUtils.isEmpty(b2)) {
                return b2.toLowerCase().contains("success");
            }
        }
        return false;
    }

    @Override // b.b.a.c
    public void g() {
        this.f1634e.execute(new c());
    }

    @Override // b.b.a.c
    public void g(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("requestCast", Integer.valueOf(i2));
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.c
    public void g(String str) {
        this.h = null;
        this.f1634e.execute(new RunnableC0051b(str));
    }

    @Override // b.b.a.c
    public String h(int i2) {
        HashMap hashMap = new HashMap();
        if (b.b.a.n.b.f) {
            hashMap.put("hostHeartBeat", "hostHeartBeat");
        } else {
            hashMap.put("heartbeat", Integer.valueOf(i2));
        }
        String json = new Gson().toJson(hashMap);
        return n(json + "\r\n");
    }

    @Override // b.b.a.c
    public void h() {
        this.f1631b.clear();
        this.f1632c.clear();
    }

    @Override // b.b.a.c
    public void h(String str) {
        b.b.a.n.f.c(this.f1633d, "com.ecloud.eshare.lib.key.CLIENT_NAME", str);
        d();
    }

    @Override // b.b.a.c
    public void i() {
        HashMap hashMap = new HashMap();
        hashMap.put("clientName", b.b.a.n.f.b(this.f1633d, "com.ecloud.eshare.lib.key.CLIENT_NAME", Build.MODEL));
        hashMap.put("clientOSType", 1);
        String json = new Gson().toJson(hashMap);
        m(json + "\r\n");
    }

    @Override // b.b.a.c
    public boolean i(String str) {
        return o("STARTAPPEVNET\r\n" + str + "\r\n\r\n");
    }

    public void j(String str) {
        if (this.i != null) {
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    this.i.setSoTimeout(800);
                } catch (SocketException e2) {
                    e2.printStackTrace();
                }
                String e3 = e("getFeatures\r\n" + str + "\r\n\r\n");
                StringBuilder sb = new StringBuilder();
                sb.append("result===>");
                sb.append(e3);
                sb.toString();
                b.b.a.n.h.a("getFeatures", e3);
                if (!TextUtils.isEmpty(e3) && e3.startsWith("server_features:")) {
                    String[] split = e3.replace("server_features:", "").split(" ");
                    if (split.length > 0) {
                        this.h.a(split[0]);
                        r(split[0]);
                    }
                }
            }
            try {
                this.i.setSoTimeout(2000);
            } catch (SocketException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // b.b.a.c
    public boolean j() {
        for (int i2 = 0; i2 < 3; i2++) {
            String b2 = b("GETPASSWORDCONFIG\r\neshare\r\n\r\n", 3000);
            if (!TextUtils.isEmpty(b2)) {
                return b2.toLowerCase().contains("password");
            }
        }
        return false;
    }

    @Override // b.b.a.c
    public void k() {
    }

    public boolean k(String str) {
        return o("MediaControl\r\n" + str + "\r\n\r\n");
    }

    @Override // b.b.a.c
    public void l() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.b.a.n.b.f ? "cancelCast" : "cancelCastRequest", true);
        m(new Gson().toJson(hashMap));
    }

    public boolean l(String str) {
        if (c() && !b.b.a.n.b.f) {
            return true;
        }
        return o("sayByebye\r\n" + str + "\r\n0\r\n\r\n");
    }

    @Override // b.b.a.l.b
    public void m() {
        if (!R()) {
            b.b.a.n.h.a("miao", "onDevicePairingEnded");
            if (this.F != null) {
                N();
            }
        }
    }

    public boolean m(String str) {
        this.A.lock();
        try {
            if (this.l != null) {
                try {
                    this.l.getOutputStream().write(str.getBytes());
                    this.l.getOutputStream().flush();
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    b.b.a.n.h.c("sendMessage", e2);
                }
            }
            return false;
        } finally {
            this.A.unlock();
        }
    }

    public String n(String str) {
        return a(str, 500);
    }

    @Override // b.b.a.c
    public void n() {
        this.f1634e.execute(new d());
    }

    @Override // b.b.a.l.b
    public void o() {
        b.b.a.l.a aVar = this.E;
        if (aVar != null) {
            aVar.e();
        }
    }

    public synchronized boolean o(String str) {
        if (this.i != null) {
            try {
                this.i.getOutputStream().write(str.getBytes());
                this.i.getOutputStream().flush();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                b.b.a.n.h.c("sendMessage", e2);
            }
        }
        return false;
    }

    @Override // b.b.a.c
    public boolean p() {
        return this.Q.booleanValue();
    }

    @Override // b.b.a.c
    public void q() {
        HashMap hashMap = new HashMap();
        hashMap.put("replyInfo", 0);
        m(new Gson().toJson(hashMap));
    }

    @Override // b.b.a.l.b
    public void r() {
        this.H = false;
    }

    @Override // b.b.a.h
    public void s() {
        this.C = com.eshare.mirror.l.a(this.f1633d);
        this.C.h();
    }

    @Override // b.b.a.e
    public int t() {
        return this.j;
    }

    @Override // b.b.a.g
    public int u() {
        String e2 = e("CopyControl\r\ncopypos \r\n\r\n");
        if (!TextUtils.isEmpty(e2) && e2.contains("getCopyProgress")) {
            String[] split = e2.split("\r\n");
            if (split.length < 4) {
                b.b.a.n.h.c("getUploadProgress", "INVAILD", e2);
                return -105;
            }
            b.b.a.n.h.b("getUploadProgress", split[0], split[1], split[2], split[3]);
            try {
                if (!"F".equals(split[3])) {
                    if ("T".equals(split[3])) {
                        return -102;
                    }
                    if ("E".equals(split[3])) {
                        return -103;
                    }
                    if ("SD".equals(split[3])) {
                        return -104;
                    }
                }
                return Integer.valueOf(split[2]).intValue();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return -105;
    }

    @Override // b.b.a.e
    public boolean v() {
        return b.b.a.n.f.a(this.f1633d, "com.ecloud.eshare.lib.key.WIRELESS_STORAGE", false);
    }

    @Override // b.b.a.c
    public void w() {
        HashMap hashMap = new HashMap();
        hashMap.put("exitFullscreen", 0);
        if (TextUtils.isEmpty(n(new Gson().toJson(hashMap)))) {
            w();
        }
    }

    @Override // b.b.a.c
    public void x() {
        q qVar = this.N;
        if (qVar != null) {
            qVar.a();
        }
        this.f.removeCallbacksAndMessages("deviceFound");
    }

    @Override // b.b.a.c
    public boolean y() {
        return this.h != null;
    }

    @Override // b.b.a.g
    public boolean z() {
        return o("CancelUpload\r\ncancel\r\n\r\n");
    }
}
