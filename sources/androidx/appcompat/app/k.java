package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.b;
import java.util.Calendar;

/* loaded from: classes.dex */
class k {

    /* renamed from: d  reason: collision with root package name */
    private static k f745d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f746a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f747b;

    /* renamed from: c  reason: collision with root package name */
    private final a f748c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f749a;

        /* renamed from: b  reason: collision with root package name */
        long f750b;

        /* renamed from: c  reason: collision with root package name */
        long f751c;

        /* renamed from: d  reason: collision with root package name */
        long f752d;

        /* renamed from: e  reason: collision with root package name */
        long f753e;
        long f;

        a() {
        }
    }

    k(Context context, LocationManager locationManager) {
        this.f746a = context;
        this.f747b = locationManager;
    }

    private Location a(String str) {
        try {
            if (this.f747b.isProviderEnabled(str)) {
                return this.f747b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(Context context) {
        if (f745d == null) {
            Context applicationContext = context.getApplicationContext();
            f745d = new k(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f745d;
    }

    private void a(Location location) {
        long j;
        a aVar = this.f748c;
        long currentTimeMillis = System.currentTimeMillis();
        j a2 = j.a();
        a2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f742a;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.f744c == 1;
        long j3 = a2.f743b;
        long j4 = a2.f742a;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.f743b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f749a = z;
        aVar.f750b = j2;
        aVar.f751c = j3;
        aVar.f752d = j4;
        aVar.f753e = j5;
        aVar.f = j;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a2 = b.a(this.f746a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (b.a(this.f746a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        return (location == null || a2 == null) ? location != null ? location : a2 : location.getTime() > a2.getTime() ? location : a2;
    }

    private boolean c() {
        return this.f748c.f > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.f748c;
        if (c()) {
            return aVar.f749a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f749a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
