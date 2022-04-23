package com.king.zxing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import b.c.b.e;
import b.c.b.m;
import b.c.b.o;
import b.c.b.p;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends Handler implements p {

    /* renamed from: b  reason: collision with root package name */
    private final n f3276b;

    /* renamed from: c  reason: collision with root package name */
    private final k f3277c;

    /* renamed from: d  reason: collision with root package name */
    private a f3278d = a.SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    private final com.king.zxing.s.d f3279e;
    private final ViewfinderView f;
    private boolean g;
    private boolean h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity, ViewfinderView viewfinderView, n nVar, Collection<b.c.b.a> collection, Map<e, Object> map, String str, com.king.zxing.s.d dVar) {
        this.f = viewfinderView;
        this.f3276b = nVar;
        this.f3277c = new k(activity, dVar, this, collection, map, str, this);
        this.f3277c.start();
        this.f3279e = dVar;
        dVar.h();
        e();
    }

    private o b(o oVar) {
        float f;
        float f2;
        int i;
        Point f3 = this.f3279e.f();
        Point b2 = this.f3279e.b();
        int i2 = f3.x;
        int i3 = f3.y;
        if (i2 < i3) {
            float f4 = (i3 * 1.0f) / b2.x;
            f2 = (oVar.a() * ((i2 * 1.0f) / b2.y)) - (Math.max(f3.x, b2.y) / 2);
            f = oVar.b() * f4;
            i = Math.min(f3.y, b2.x);
        } else {
            float f5 = (i3 * 1.0f) / b2.y;
            f2 = (oVar.a() * ((i2 * 1.0f) / b2.x)) - (Math.min(f3.y, b2.y) / 2);
            f = oVar.b() * f5;
            i = Math.max(f3.x, b2.x);
        }
        return new o(f2, f - (i / 2));
    }

    @Override // b.c.b.p
    public void a(o oVar) {
        if (this.f != null) {
            this.f.a(b(oVar));
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean a() {
        return this.h;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public boolean b() {
        return this.i;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public boolean c() {
        return this.g;
    }

    public void d() {
        this.f3278d = a.DONE;
        this.f3279e.i();
        Message.obtain(this.f3277c.a(), p.quit).sendToTarget();
        try {
            this.f3277c.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(p.decode_succeeded);
        removeMessages(p.decode_failed);
    }

    public void e() {
        if (this.f3278d == a.SUCCESS) {
            this.f3278d = a.PREVIEW;
            this.f3279e.a(this.f3277c.a(), p.decode);
            this.f.a();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == p.restart_preview) {
            e();
        } else if (i == p.decode_succeeded) {
            this.f3278d = a.SUCCESS;
            Bundle data = message.getData();
            float f = 1.0f;
            Bitmap bitmap = null;
            if (data != null) {
                byte[] byteArray = data.getByteArray("barcode_bitmap");
                if (byteArray != null) {
                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.ARGB_8888, true);
                }
                f = data.getFloat("barcode_scaled_factor");
            }
            this.f3276b.a((m) message.obj, bitmap, f);
        } else if (i == p.decode_failed) {
            this.f3278d = a.PREVIEW;
            this.f3279e.a(this.f3277c.a(), p.decode);
        }
    }
}
