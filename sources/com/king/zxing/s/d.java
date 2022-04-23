package com.king.zxing.s;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import b.c.b.j;
import com.king.zxing.s.g.b;
import com.king.zxing.s.g.c;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d {
    private static final String n = "d";

    /* renamed from: a  reason: collision with root package name */
    private final Context f3325a;

    /* renamed from: b  reason: collision with root package name */
    private final b f3326b;

    /* renamed from: c  reason: collision with root package name */
    private b f3327c;

    /* renamed from: d  reason: collision with root package name */
    private a f3328d;

    /* renamed from: e  reason: collision with root package name */
    private Rect f3329e;
    private Rect f;
    private boolean g;
    private boolean h;
    private int i = -1;
    private int j;
    private int k;
    private boolean l;
    private final f m;

    public d(Context context) {
        this.f3325a = context.getApplicationContext();
        this.f3326b = new b(context);
        this.m = new f(this.f3326b);
    }

    public j a(byte[] bArr, int i, int i2) {
        if (d() == null) {
            return null;
        }
        if (this.l) {
            return new j(bArr, i, i2, 0, 0, i, i2, false);
        }
        int min = Math.min(i, i2);
        return new j(bArr, i, i2, (i - min) / 2, (i2 - min) / 2, min, min, false);
    }

    public synchronized void a() {
        if (this.f3327c != null) {
            this.f3327c.a().release();
            this.f3327c = null;
            this.f3329e = null;
            this.f = null;
        }
    }

    public synchronized void a(int i, int i2) {
        if (this.g) {
            Point b2 = this.f3326b.b();
            if (i > b2.x) {
                i = b2.x;
            }
            if (i2 > b2.y) {
                i2 = b2.y;
            }
            int i3 = (b2.x - i) / 2;
            int i4 = (b2.y - i2) / 2;
            this.f3329e = new Rect(i3, i4, i + i3, i2 + i4);
            String str = "Calculated manual framing rect: " + this.f3329e;
            this.f = null;
        } else {
            this.j = i;
            this.k = i2;
        }
    }

    public synchronized void a(Handler handler, int i) {
        b bVar = this.f3327c;
        if (bVar != null && this.h) {
            this.m.a(handler, i);
            bVar.a().setOneShotPreviewCallback(this.m);
        }
    }

    public synchronized void a(SurfaceHolder surfaceHolder) {
        b bVar = this.f3327c;
        if (bVar == null) {
            bVar = c.a(this.i);
            if (bVar != null) {
                this.f3327c = bVar;
            } else {
                throw new IOException("Camera.open() failed to return object from driver");
            }
        }
        if (!this.g) {
            this.g = true;
            this.f3326b.a(bVar);
            if (this.j > 0 && this.k > 0) {
                a(this.j, this.k);
                this.j = 0;
                this.k = 0;
            }
        }
        Camera a2 = bVar.a();
        Camera.Parameters parameters = a2.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.f3326b.a(bVar, false);
        } catch (RuntimeException unused) {
            Log.w(n, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            String str = n;
            Log.i(str, "Resetting to saved camera params: " + flatten);
            if (flatten != null) {
                Camera.Parameters parameters2 = a2.getParameters();
                parameters2.unflatten(flatten);
                try {
                    a2.setParameters(parameters2);
                    this.f3326b.a(bVar, true);
                } catch (RuntimeException unused2) {
                    Log.w(n, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
        a2.setPreviewDisplay(surfaceHolder);
    }

    public void a(boolean z) {
        this.l = z;
    }

    public Point b() {
        return this.f3326b.a();
    }

    public synchronized void b(boolean z) {
        b bVar = this.f3327c;
        if (!(bVar == null || z == this.f3326b.a(bVar.a()))) {
            boolean z2 = this.f3328d != null;
            if (z2) {
                this.f3328d.b();
                this.f3328d = null;
            }
            this.f3326b.a(bVar.a(), z);
            if (z2) {
                this.f3328d = new a(this.f3325a, bVar.a());
                this.f3328d.a();
            }
        }
    }

    public synchronized Rect c() {
        if (this.f3329e == null) {
            if (this.f3327c == null) {
                return null;
            }
            Point a2 = this.f3326b.a();
            if (a2 == null) {
                return null;
            }
            int i = a2.x;
            int i2 = a2.y;
            if (this.l) {
                this.f3329e = new Rect(0, 0, i, i2);
            } else {
                int min = Math.min(i, i2);
                int i3 = (i - min) / 2;
                int i4 = (i2 - min) / 2;
                this.f3329e = new Rect(i3, i4, i3 + min, min + i4);
            }
        }
        return this.f3329e;
    }

    public synchronized Rect d() {
        if (this.f == null) {
            Rect c2 = c();
            if (c2 == null) {
                return null;
            }
            Rect rect = new Rect(c2);
            Point a2 = this.f3326b.a();
            Point b2 = this.f3326b.b();
            if (!(a2 == null || b2 == null)) {
                rect.left = (rect.left * a2.y) / b2.x;
                rect.right = (rect.right * a2.y) / b2.x;
                rect.top = (rect.top * a2.x) / b2.y;
                rect.bottom = (rect.bottom * a2.x) / b2.y;
                this.f = rect;
            }
            return null;
        }
        return this.f;
    }

    public b e() {
        return this.f3327c;
    }

    public Point f() {
        return this.f3326b.b();
    }

    public synchronized boolean g() {
        return this.f3327c != null;
    }

    public synchronized void h() {
        b bVar = this.f3327c;
        if (bVar != null && !this.h) {
            bVar.a().startPreview();
            this.h = true;
            this.f3328d = new a(this.f3325a, bVar.a());
        }
    }

    public synchronized void i() {
        if (this.f3328d != null) {
            this.f3328d.b();
            this.f3328d = null;
        }
        if (this.f3327c != null && this.h) {
            this.f3327c.a().stopPreview();
            this.m.a(null, 0);
            this.h = false;
        }
    }
}
