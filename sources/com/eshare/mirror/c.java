package com.eshare.mirror;

import android.media.projection.MediaProjection;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f3056b;

    /* renamed from: c  reason: collision with root package name */
    private static MediaProjection f3057c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3058a = true;

    public static c e() {
        if (f3056b == null) {
            synchronized (c.class) {
                if (f3056b == null) {
                    f3056b = new c();
                }
            }
        }
        return f3056b;
    }

    public MediaProjection a() {
        return f3057c;
    }

    public void a(MediaProjection mediaProjection) {
        f3057c = mediaProjection;
    }

    public void a(boolean z) {
        this.f3058a = z;
    }

    public boolean b() {
        return this.f3058a;
    }

    public boolean c() {
        return f3057c != null;
    }

    public void d() {
        MediaProjection mediaProjection = f3057c;
        if (mediaProjection != null) {
            mediaProjection.stop();
            f3057c = null;
        }
    }
}
