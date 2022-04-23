package com.king.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import b.c.b.e;
import b.c.b.h;
import com.king.zxing.s.d;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* loaded from: classes.dex */
final class j extends Handler {
    private static final String g = j.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final Context f3298a;

    /* renamed from: b  reason: collision with root package name */
    private final d f3299b;

    /* renamed from: c  reason: collision with root package name */
    private final d f3300c;
    private long f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3302e = true;

    /* renamed from: d  reason: collision with root package name */
    private final h f3301d = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, d dVar, d dVar2, Map<e, Object> map) {
        this.f3301d.a(map);
        this.f3298a = context;
        this.f3299b = dVar;
        this.f3300c = dVar2;
    }

    private b.c.b.j a(byte[] bArr, int i, int i2, boolean z) {
        if (!z) {
            return this.f3299b.a(bArr, i, i2);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        return this.f3299b.a(bArr2, i2, i);
    }

    private static void a(b.c.b.j jVar, Bundle bundle) {
        int[] h = jVar.h();
        int g2 = jVar.g();
        Bitmap createBitmap = Bitmap.createBitmap(h, 0, g2, g2, jVar.f(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", g2 / jVar.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(byte[] r9, int r10, int r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.zxing.j.a(byte[], int, int, boolean, boolean):void");
    }

    private boolean a() {
        Display defaultDisplay = ((WindowManager) this.f3298a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    private boolean a(int i, int i2) {
        Camera a2;
        if (this.f > System.currentTimeMillis() - 1000) {
            return true;
        }
        if (i >= i2 / 5 || (a2 = this.f3299b.e().a()) == null) {
            return false;
        }
        Camera.Parameters parameters = a2.getParameters();
        if (parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            parameters.setZoom(Math.min(parameters.getZoom() + (maxZoom / 5), maxZoom));
            a2.setParameters(parameters);
            this.f = System.currentTimeMillis();
            return true;
        }
        Log.i(g, "Zoom not supported");
        return false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null && this.f3302e) {
            int i = message.what;
            if (i == p.decode) {
                a((byte[]) message.obj, message.arg1, message.arg2, a(), this.f3300c.c());
            } else if (i == p.quit) {
                this.f3302e = false;
                Looper.myLooper().quit();
            }
        }
    }
}
