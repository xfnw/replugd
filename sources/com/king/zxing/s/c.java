package com.king.zxing.s;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c {
    static {
        Pattern.compile(";");
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        double d2;
        Point point2;
        StringBuilder sb;
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException(str2);
        }
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb2 = new StringBuilder();
            for (Camera.Size size : supportedPreviewSizes) {
                sb2.append(size.width);
                sb2.append('x');
                sb2.append(size.height);
                sb2.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + ((Object) sb2));
        }
        int i = point.x;
        int i2 = point.y;
        if (i < i2) {
            double d3 = i;
            double d4 = i2;
            Double.isNaN(d3);
            Double.isNaN(d4);
            d2 = d3 / d4;
        } else {
            double d5 = i2;
            double d6 = i;
            Double.isNaN(d5);
            Double.isNaN(d6);
            d2 = d5 / d6;
        }
        Log.i("CameraConfiguration", "screenAspectRatio: " + d2);
        Camera.Size size2 = null;
        Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
        char c2 = 0;
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                Camera.Size next = it.next();
                int i4 = next.width;
                int i5 = next.height;
                int i6 = i4 * i5;
                if (i6 >= 153600) {
                    boolean z = i4 < i5;
                    int i7 = z ? i4 : i5;
                    int i8 = z ? i5 : i4;
                    Object[] objArr = new Object[2];
                    objArr[c2] = Integer.valueOf(i7);
                    objArr[1] = Integer.valueOf(i8);
                    Log.i("CameraConfiguration", String.format("maybeFlipped:%d * %d", objArr));
                    it = it;
                    double d7 = i7;
                    size2 = size2;
                    str2 = str2;
                    double d8 = i8;
                    Double.isNaN(d7);
                    Double.isNaN(d8);
                    double d9 = d7 / d8;
                    Log.i("CameraConfiguration", "aspectRatio: " + d9);
                    double abs = Math.abs(d9 - d2);
                    Log.i("CameraConfiguration", "distortion: " + abs);
                    if (abs <= 0.05d) {
                        if (i7 == point.x && i8 == point.y) {
                            point2 = new Point(i4, i5);
                            sb = new StringBuilder();
                            str = "Found preview size exactly matching screen size: ";
                            break;
                        }
                        if (i6 > i3) {
                            size2 = next;
                            i3 = i6;
                        } else {
                            size2 = size2;
                        }
                        it = it;
                        c2 = 0;
                    }
                } else {
                    it = it;
                    str2 = str2;
                    size2 = size2;
                }
                c2 = 0;
            } else if (size2 != null) {
                point2 = new Point(size2.width, size2.height);
                sb = new StringBuilder();
                str = "Using largest suitable preview size: ";
            } else {
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 != null) {
                    Point point3 = new Point(previewSize2.width, previewSize2.height);
                    Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point3);
                    return point3;
                }
                throw new IllegalStateException(str2);
            }
        }
        sb.append(str);
        sb.append(point2);
        Log.i("CameraConfiguration", sb.toString());
        return point2;
    }

    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    private static List<Camera.Area> a(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    public static void a(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String a2 = a("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (a2 != null) {
            parameters.setSceneMode(a2);
        }
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        String str;
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0)) {
            float f = 0.0f;
            if (exposureCompensationStep > 0.0f) {
                if (!z) {
                    f = 1.5f;
                }
                int round = Math.round(f / exposureCompensationStep);
                float f2 = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    str = "Exposure compensation already set to " + max + " / " + f2;
                    Log.i("CameraConfiguration", str);
                }
                Log.i("CameraConfiguration", "Setting exposure compensation to " + max + " / " + f2);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        str = "Camera does not support exposure compensation";
        Log.i("CameraConfiguration", str);
    }

    public static void a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String a2 = z ? (z3 || z2) ? a("focus mode", supportedFocusModes, "auto") : a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && a2 == null) {
            a2 = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (a2 == null) {
            return;
        }
        if (a2.equals(parameters.getFocusMode())) {
            Log.i("CameraConfiguration", "Focus mode already set to " + a2);
            return;
        }
        parameters.setFocusMode(a2);
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            Log.i("CameraConfiguration", "Old focus areas: " + a(parameters.getFocusAreas()));
            List<Camera.Area> a2 = a(400);
            Log.i("CameraConfiguration", "Setting focus area to : " + a(a2));
            parameters.setFocusAreas(a2);
            return;
        }
        Log.i("CameraConfiguration", "Device does not support focus areas");
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String a2 = z ? a("flash mode", supportedFlashModes, "torch", "on") : a("flash mode", supportedFlashModes, "off");
        if (a2 == null) {
            return;
        }
        if (a2.equals(parameters.getFlashMode())) {
            Log.i("CameraConfiguration", "Flash mode already set to " + a2);
            return;
        }
        Log.i("CameraConfiguration", "Setting flash mode to " + a2);
        parameters.setFlashMode(a2);
    }

    public static void c(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String a2 = a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (a2 != null) {
            parameters.setColorEffect(a2);
        }
    }

    public static void d(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> a2 = a(400);
            Log.i("CameraConfiguration", "Setting metering area to : " + a(a2));
            parameters.setMeteringAreas(a2);
            return;
        }
        Log.i("CameraConfiguration", "Device does not support metering areas");
    }

    public static void e(Camera.Parameters parameters) {
        String str;
        if (!parameters.isVideoStabilizationSupported()) {
            str = "This device does not support video stabilization";
        } else if (parameters.getVideoStabilization()) {
            str = "Video stabilization already enabled";
        } else {
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
            return;
        }
        Log.i("CameraConfiguration", str);
    }
}
