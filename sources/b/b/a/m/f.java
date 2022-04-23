package b.b.a.m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

/* loaded from: classes.dex */
public interface f {
    void onAccuracyChanged(Sensor sensor, int i);

    void onSensorChanged(SensorEvent sensorEvent);
}
