package com.ecloud.eshare;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;
import c.a.a.e;
import com.ecloud.eshare.i.d;
import com.ecloud.eshare.util.s;
import com.squareup.picasso.R;
import org.greenrobot.eventbus.c;

/* loaded from: classes.dex */
public class CustomApplication extends Application {

    /* renamed from: d  reason: collision with root package name */
    private static CustomApplication f2513d;

    /* renamed from: e  reason: collision with root package name */
    private static Toast f2514e;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2515b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f2516c;

    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2517b;

        a(String str) {
            this.f2517b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CustomApplication.f2514e == null) {
                Toast unused = CustomApplication.f2514e = Toast.makeText(CustomApplication.f2513d, this.f2517b, 0);
            } else {
                CustomApplication.f2514e.setText(this.f2517b);
            }
            CustomApplication.f2514e.show();
        }
    }

    /* loaded from: classes.dex */
    static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2518b;

        b(int i) {
            this.f2518b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(CustomApplication.f2513d, CustomApplication.f2513d.getString(this.f2518b), null, CustomApplication.f2513d.getResources().getColor(R.color.colorAccent), CustomApplication.f2513d.getResources().getColor(R.color.white), 0, false, true).show();
        }
    }

    public static int a(String str, int i) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f2513d;
        return (customApplication == null || (sharedPreferences = customApplication.f2516c) == null) ? i : sharedPreferences.getInt(str, i);
    }

    public static void a(int i) {
        CustomApplication customApplication = f2513d;
        if (customApplication != null) {
            try {
                customApplication.f2515b.post(new b(i));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        CustomApplication customApplication = f2513d;
        if (customApplication != null) {
            customApplication.f2515b.post(new a(str));
        }
    }

    public static boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f2513d;
        return (customApplication == null || (sharedPreferences = customApplication.f2516c) == null) ? z : sharedPreferences.getBoolean(str, z);
    }

    public static void b(String str, int i) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f2513d;
        if (customApplication != null && (sharedPreferences = customApplication.f2516c) != null) {
            sharedPreferences.edit().putInt(str, i).apply();
        }
    }

    public static void b(String str, boolean z) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f2513d;
        if (customApplication != null && (sharedPreferences = customApplication.f2516c) != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static CustomApplication c() {
        return f2513d;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f2513d = this;
        d.b().a();
        e.a b2 = e.a.b();
        b2.a(false);
        b2.a();
        this.f2516c = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        org.greenrobot.eventbus.d c2 = c.c();
        c2.a(false);
        c2.e();
        s.a(this, "key_eshare_transfer_audio_above_Q", true);
    }
}
