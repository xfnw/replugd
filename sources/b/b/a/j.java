package b.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.View;
import b.b.a.m.c;
import b.b.a.m.f;
import b.b.a.m.g;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements i {
    private SensorManager A;
    private Sensor B;
    private Sensor C;

    /* renamed from: b  reason: collision with root package name */
    private g f1677b;

    /* renamed from: c  reason: collision with root package name */
    private f f1678c;

    /* renamed from: d  reason: collision with root package name */
    private c f1679d;

    /* renamed from: e  reason: collision with root package name */
    private float f1680e;
    private Context f;
    private float k;
    private float l;
    private long q;
    private b z;
    private float g = -1.0f;
    private float h = -1.0f;
    private float i = -1.0f;
    private float j = -1.0f;
    private int m = 1280;
    private int n = 720;
    private float o = this.m / 2;
    private float p = this.n / 2;
    private int r = -1;
    private long s = -1;
    private int t = 0;
    private float[] u = new float[10];
    private float[] v = new float[10];
    private float[] w = new float[10];
    private volatile int x = -1;
    private float y = 0.85f;
    boolean D = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, b bVar) {
        this.f = context;
        this.z = bVar;
        this.f1680e = b.b.a.n.f.a(context, "com.ecloud.eshare.lib.key.SENSITIVITY", 0.85f);
    }

    private float a(float[] fArr) {
        Arrays.sort((float[]) fArr.clone());
        int i = 2;
        float f = 0.0f;
        while (i < fArr.length - 2) {
            i++;
            f += fArr[i];
        }
        return f / (fArr.length - 4);
    }

    private void a(float f, float f2, int i) {
        this.z.a(f, f2, i);
        c cVar = this.f1679d;
        if (cVar != null) {
            cVar.b(i, f, f2);
        }
    }

    private void b(float f, float f2, int i) {
        this.z.b(f, f2, i);
        c cVar = this.f1679d;
        if (cVar != null) {
            cVar.a(i, f, f2);
        }
    }

    @Override // b.b.a.i
    public void a() {
        this.A = (SensorManager) this.f.getSystemService("sensor");
        this.B = this.A.getDefaultSensor(4);
        this.C = this.A.getDefaultSensor(1);
        this.D = false;
        Sensor sensor = this.C;
        if (sensor != null) {
            this.A.registerListener(this, sensor, 0);
        }
        Sensor sensor2 = this.B;
        if (sensor2 != null) {
            this.A.registerListener(this, sensor2, 0);
        }
        int[] J = this.z.J();
        if (J != null) {
            this.m = J[0];
            this.n = J[1];
            d();
        }
    }

    @Override // b.b.a.i
    public void a(float f) {
        if (f < 0.01f) {
            f = 0.01f;
        } else if (f >= 1.0f) {
            f = 0.99f;
        }
        if (this.f1680e != f) {
            this.f1680e = f;
            b.b.a.n.f.b(this.f, "com.ecloud.eshare.lib.key.SENSITIVITY", f);
        }
    }

    @Override // b.b.a.i
    public void b() {
        SensorManager sensorManager = this.A;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override // b.b.a.i
    public float c() {
        return b.b.a.n.f.a(this.f, "com.ecloud.eshare.lib.key.SENSITIVITY", 0.85f);
    }

    @Override // b.b.a.i
    public void d() {
        this.o = this.m / 2;
        this.p = this.n / 2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        f fVar = this.f1678c;
        if (fVar != null) {
            fVar.onAccuracyChanged(sensor, i);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float f = 1.0f - this.y;
        Float valueOf = Float.valueOf(1.0f - this.f1680e);
        boolean z = false;
        if (type == 4) {
            this.D = true;
            float[] fArr = sensorEvent.values;
            float f2 = -((int) (fArr[2] * 30.0f));
            float f3 = -((int) (fArr[0] * 30.0f));
            if (!(f2 == this.k && f3 == this.l)) {
                this.k = f2;
                this.l = f3;
                this.o += this.k / (valueOf.floatValue() * 100.0f);
                this.p += this.l / (valueOf.floatValue() * 100.0f);
                float f4 = this.o;
                if (f4 < 0.0f) {
                    this.o = 0.0f;
                } else {
                    int i = this.m;
                    if (f4 > i) {
                        this.o = i;
                    }
                }
                float f5 = this.p;
                if (f5 < 0.0f) {
                    this.p = 0.0f;
                } else {
                    int i2 = this.n;
                    if (f5 > i2) {
                        this.p = i2;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (((float) (currentTimeMillis - this.q)) > valueOf.floatValue() * 100.0f) {
                    this.q = currentTimeMillis;
                    b(this.o, this.p, this.r);
                }
            }
        } else if (!this.D) {
            float[] fArr2 = sensorEvent.values;
            int i3 = this.t;
            if (i3 == 9) {
                this.t = 0;
            } else {
                this.t = i3 + 1;
            }
            float[] fArr3 = this.u;
            int i4 = this.t;
            fArr3[i4] = -fArr2[0];
            this.v[i4] = -fArr2[1];
            this.w[i4] = -fArr2[2];
            float f6 = -fArr2[0];
            float f7 = -fArr2[1];
            float f8 = this.g;
            if (f8 == -1.0f || this.h == -1.0f) {
                this.g = f6;
                this.h = f7;
            } else {
                if (Math.abs(f6 - f8) > f) {
                    this.g = f6;
                    z = true;
                }
                if (Math.abs(f7 - this.h) > f) {
                    this.h = f7;
                    z = true;
                }
                if (z) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - this.s > 0) {
                        this.s = currentTimeMillis2;
                        if (this.i == -1.0f && this.j == -1.0f) {
                            this.i = a(this.u);
                            this.j = a(this.v);
                        }
                        a(a(this.u) - this.i, a(this.v) - this.j, this.x);
                    }
                }
            }
        } else {
            return;
        }
        f fVar = this.f1678c;
        if (fVar != null) {
            fVar.onSensorChanged(sensorEvent);
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.r = action;
        if (action == 0) {
            b(this.o, this.p, 0);
        } else if (action == 1 || action == 3) {
            b(this.o, this.p, 1);
            this.r = -1;
        }
        g gVar = this.f1677b;
        if (gVar != null) {
            gVar.a(motionEvent);
        }
        return true;
    }
}
