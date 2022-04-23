package com.king.zxing.s.g;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3345a = "com.king.zxing.s.g.c";

    public static b a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f3345a, "No cameras!");
            return null;
        } else if (i >= numberOfCameras) {
            String str = f3345a;
            Log.w(str, "Requested camera does not exist: " + i);
            return null;
        } else {
            if (i <= -1) {
                i = 0;
                while (i < numberOfCameras) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    if (a.values()[cameraInfo.facing] == a.BACK) {
                        break;
                    }
                    i++;
                }
                if (i == numberOfCameras) {
                    String str2 = f3345a;
                    Log.i(str2, "No camera facing " + a.BACK + "; returning camera #0");
                    i = 0;
                }
            }
            String str3 = f3345a;
            Log.i(str3, "Opening camera #" + i);
            Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo2);
            Camera open = Camera.open(i);
            if (open == null) {
                return null;
            }
            return new b(i, open, a.values()[cameraInfo2.facing], cameraInfo2.orientation);
        }
    }
}
