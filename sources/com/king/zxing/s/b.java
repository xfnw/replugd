package com.king.zxing.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.king.zxing.s.g.a;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3320a;

    /* renamed from: b  reason: collision with root package name */
    private int f3321b;

    /* renamed from: c  reason: collision with root package name */
    private int f3322c;

    /* renamed from: d  reason: collision with root package name */
    private Point f3323d;

    /* renamed from: e  reason: collision with root package name */
    private Point f3324e;
    private Point f;
    private Point g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f3320a = context;
    }

    private void a(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        a(parameters, e.a(sharedPreferences) == e.ON, z);
    }

    private void a(Camera.Parameters parameters, boolean z, boolean z2) {
        c.b(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3320a);
        if (!z2 && !defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            c.a(parameters, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point a() {
        return this.f3324e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z, false);
        camera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.king.zxing.s.g.b bVar) {
        int i;
        int i2;
        Point point;
        Camera.Parameters parameters = bVar.a().getParameters();
        Display defaultDisplay = ((WindowManager) this.f3320a.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        boolean z = false;
        if (rotation == 0) {
            i = 0;
        } else if (rotation == 1) {
            i = 90;
        } else if (rotation == 2) {
            i = 180;
        } else if (rotation == 3) {
            i = 270;
        } else if (rotation % 90 == 0) {
            i = (rotation + 360) % 360;
        } else {
            throw new IllegalArgumentException("Bad rotation: " + rotation);
        }
        Log.i("CameraConfiguration", "Display at: " + i);
        int c2 = bVar.c();
        Log.i("CameraConfiguration", "Camera at: " + c2);
        if (bVar.b() == a.FRONT) {
            c2 = (360 - c2) % 360;
            Log.i("CameraConfiguration", "Front camera overriden to: " + c2);
        }
        this.f3322c = ((c2 + 360) - i) % 360;
        Log.i("CameraConfiguration", "Final display orientation: " + this.f3322c);
        if (bVar.b() == a.FRONT) {
            Log.i("CameraConfiguration", "Compensating rotation for front camera");
            i2 = (360 - this.f3322c) % 360;
        } else {
            i2 = this.f3322c;
        }
        this.f3321b = i2;
        Log.i("CameraConfiguration", "Clockwise rotation from display to camera: " + this.f3321b);
        Point point2 = new Point();
        defaultDisplay.getSize(point2);
        this.f3323d = point2;
        Log.i("CameraConfiguration", "Screen resolution in current orientation: " + this.f3323d);
        this.f3324e = c.a(parameters, this.f3323d);
        Log.i("CameraConfiguration", "Camera resolution: " + this.f3324e);
        this.f = c.a(parameters, this.f3323d);
        Log.i("CameraConfiguration", "Best available preview size: " + this.f);
        Point point3 = this.f3323d;
        boolean z2 = point3.x < point3.y;
        Point point4 = this.f;
        if (point4.x < point4.y) {
            z = true;
        }
        if (z2 == z) {
            point = this.f;
        } else {
            Point point5 = this.f;
            point = new Point(point5.y, point5.x);
        }
        this.g = point;
        Log.i("CameraConfiguration", "Preview size on screen: " + this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.king.zxing.s.g.b bVar, boolean z) {
        Camera a2 = bVar.a();
        Camera.Parameters parameters = a2.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3320a);
        if (parameters.isZoomSupported()) {
            parameters.setZoom(parameters.getMaxZoom() / 10);
        }
        a(parameters, defaultSharedPreferences, z);
        c.a(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                c.c(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                c.a(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                c.e(parameters);
                c.b(parameters);
                c.d(parameters);
            }
            parameters.setRecordingHint(true);
        }
        Point point = this.f;
        parameters.setPreviewSize(point.x, point.y);
        a2.setParameters(parameters);
        a2.setDisplayOrientation(this.f3322c);
        Camera.Size previewSize = a2.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f;
            if (point2.x != previewSize.width || point2.y != previewSize.height) {
                Log.w("CameraConfiguration", "Camera said it supported preview size " + this.f.x + 'x' + this.f.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
                Point point3 = this.f;
                point3.x = previewSize.width;
                point3.y = previewSize.height;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point b() {
        return this.f3323d;
    }
}
