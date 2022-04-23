package com.king.zxing.s;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* loaded from: classes.dex */
final class f implements Camera.PreviewCallback {

    /* renamed from: d  reason: collision with root package name */
    private static final String f3334d = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final b f3335a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f3336b;

    /* renamed from: c  reason: collision with root package name */
    private int f3337c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f3335a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.f3336b = handler;
        this.f3337c = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a2 = this.f3335a.a();
        Handler handler = this.f3336b;
        if (a2 != null && handler != null) {
            handler.obtainMessage(this.f3337c, a2.x, a2.y, bArr).sendToTarget();
            this.f3336b = null;
        }
    }
}
