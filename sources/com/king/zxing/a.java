package com.king.zxing;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.king.zxing.s.d;
import com.king.zxing.s.e;

/* loaded from: classes.dex */
final class a implements SensorEventListener {

    /* renamed from: b  reason: collision with root package name */
    private final Context f3266b;

    /* renamed from: c  reason: collision with root package name */
    private d f3267c;

    /* renamed from: d  reason: collision with root package name */
    private Sensor f3268d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f3266b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.f3267c = dVar;
        if (e.a(PreferenceManager.getDefaultSharedPreferences(this.f3266b)) == e.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f3266b.getSystemService("sensor");
            this.f3268d = sensorManager.getDefaultSensor(5);
            Sensor sensor = this.f3268d;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f3268d != null) {
            ((SensorManager) this.f3266b.getSystemService("sensor")).unregisterListener(this);
            this.f3267c = null;
            this.f3268d = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        d dVar = this.f3267c;
        if (dVar == null) {
            return;
        }
        if (f <= 45.0f) {
            dVar.b(true);
        } else if (f >= 450.0f) {
            dVar.b(false);
        }
    }
}
