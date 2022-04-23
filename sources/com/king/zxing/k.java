package com.king.zxing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import b.c.b.a;
import b.c.b.e;
import b.c.b.p;
import com.king.zxing.s.d;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends Thread {

    /* renamed from: b  reason: collision with root package name */
    private final Context f3303b;

    /* renamed from: c  reason: collision with root package name */
    private final d f3304c;

    /* renamed from: e  reason: collision with root package name */
    private Handler f3306e;
    private d f;
    private final CountDownLatch g = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private final Map<e, Object> f3305d = new EnumMap(e.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, d dVar, d dVar2, Collection<a> collection, Map<e, Object> map, String str, p pVar) {
        this.f3303b = context;
        this.f3304c = dVar;
        this.f = dVar2;
        if (map != null) {
            this.f3305d.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(a.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(i.f3293a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(i.f3294b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(i.f3296d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(i.f3297e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(i.f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(i.g);
            }
        }
        this.f3305d.put(e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f3305d.put(e.CHARACTER_SET, str);
        }
        this.f3305d.put(e.NEED_RESULT_POINT_CALLBACK, pVar);
        Log.i("DecodeThread", "Hints: " + this.f3305d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler a() {
        try {
            this.g.await();
        } catch (InterruptedException unused) {
        }
        return this.f3306e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f3306e = new j(this.f3303b, this.f3304c, this.f, this.f3305d);
        this.g.countDown();
        Looper.loop();
    }
}
