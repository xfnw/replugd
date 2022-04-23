package com.king.zxing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import b.c.b.m;
import com.king.zxing.s.d;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public class e implements f, h, g {
    public static final String z = "e";

    /* renamed from: a  reason: collision with root package name */
    private Activity f3284a;

    /* renamed from: b  reason: collision with root package name */
    private d f3285b;

    /* renamed from: c  reason: collision with root package name */
    private n f3286c;

    /* renamed from: d  reason: collision with root package name */
    private d f3287d;

    /* renamed from: e  reason: collision with root package name */
    private l f3288e;
    private com.king.zxing.b f;
    private com.king.zxing.a g;
    private ViewfinderView h;
    private SurfaceHolder i;
    private SurfaceHolder.Callback j;
    private Collection<b.c.b.a> k;
    private Map<b.c.b.e, Object> l;
    private String m;
    private float p;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private m y;
    private boolean o = true;
    private boolean q = true;
    private boolean r = false;
    private boolean s = true;
    private boolean n = false;

    /* loaded from: classes.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (surfaceHolder == null) {
                Log.e(e.z, "*** WARNING *** surfaceCreated() gave us a null surface!");
            }
            if (!e.this.n) {
                e.this.n = true;
                e.this.a(surfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            e.this.n = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements n {
        b() {
        }

        @Override // com.king.zxing.n
        public void a(m mVar, Bitmap bitmap, float f) {
            e.this.f3288e.a();
            e.this.f.m();
            e.this.a(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3291b;

        c(String str) {
            this.f3291b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.y == null || !e.this.y.a(this.f3291b)) {
                Intent intent = new Intent();
                intent.putExtra("SCAN_RESULT", this.f3291b);
                e.this.f3284a.setResult(-1, intent);
                e.this.f3284a.finish();
            }
        }
    }

    public e(Activity activity, SurfaceView surfaceView, ViewfinderView viewfinderView) {
        this.f3284a = activity;
        this.h = viewfinderView;
        this.i = surfaceView.getHolder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.f3287d.g()) {
            Log.w(z, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            try {
                this.f3287d.a(surfaceHolder);
                if (this.f3285b == null) {
                    this.f3285b = new d(this.f3284a, this.h, this.f3286c, this.k, this.l, this.m, this.f3287d);
                    this.f3285b.c(this.v);
                    this.f3285b.a(this.w);
                    this.f3285b.b(this.q);
                }
            } catch (IOException e2) {
                Log.w(z, e2);
            } catch (RuntimeException e3) {
                Log.w(z, "Unexpected error initializing camera", e3);
            }
        }
    }

    private void a(boolean z2, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom();
            if (z2 && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
            return;
        }
        Log.i(z, "zoom not supported");
    }

    private float b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public e a(m mVar) {
        this.y = mVar;
        return this;
    }

    public e a(Collection<b.c.b.a> collection) {
        this.k = collection;
        return this;
    }

    public e a(boolean z2) {
        this.r = z2;
        return this;
    }

    public d a() {
        return this.f3287d;
    }

    public void a(m mVar) {
        String e2 = mVar.e();
        if (this.r) {
            m mVar2 = this.y;
            if (mVar2 != null) {
                mVar2.a(e2);
            }
            if (this.s) {
                f();
            }
        } else if (this.t) {
            this.f3285b.postDelayed(new c(e2), 100L);
        } else {
            m mVar3 = this.y;
            if (mVar3 == null || !mVar3.a(e2)) {
                Intent intent = new Intent();
                intent.putExtra("SCAN_RESULT", e2);
                this.f3284a.setResult(-1, intent);
                this.f3284a.finish();
            }
        }
    }

    public boolean a(MotionEvent motionEvent) {
        Camera a2;
        float b2;
        if (!this.o || !this.f3287d.g() || (a2 = this.f3287d.e().a()) == null || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 2) {
            if (action == 5) {
                b2 = b(motionEvent);
            }
            return true;
        }
        b2 = b(motionEvent);
        float f = this.p;
        if (b2 > f + 6.0f) {
            a(true, a2);
        } else if (b2 < f - 6.0f) {
            a(false, a2);
        }
        this.p = b2;
        return true;
    }

    public e b(boolean z2) {
        this.t = z2;
        com.king.zxing.b bVar = this.f;
        if (bVar != null) {
            bVar.a(z2);
        }
        return this;
    }

    public void b() {
        this.f3288e = new l(this.f3284a);
        this.f = new com.king.zxing.b(this.f3284a);
        this.g = new com.king.zxing.a(this.f3284a);
        this.f3287d = new d(this.f3284a);
        this.f3287d.a(this.x);
        this.j = new a();
        this.f3286c = new b();
        this.f.a(this.t);
        this.f.b(this.u);
    }

    public e c(boolean z2) {
        this.v = z2;
        d dVar = this.f3285b;
        if (dVar != null) {
            dVar.c(this.v);
        }
        return this;
    }

    public void c() {
        this.f3288e.d();
    }

    public e d(boolean z2) {
        this.u = z2;
        com.king.zxing.b bVar = this.f;
        if (bVar != null) {
            bVar.b(z2);
        }
        return this;
    }

    public void d() {
        d dVar = this.f3285b;
        if (dVar != null) {
            dVar.d();
            this.f3285b = null;
        }
        this.f3288e.b();
        this.g.e();
        this.f.close();
        this.f3287d.a();
        if (!this.n) {
            this.i.removeCallback(this.j);
        }
    }

    public void e() {
        this.f.n();
        this.g.a(this.f3287d);
        this.f3288e.c();
        this.i.addCallback(this.j);
        if (this.n) {
            a(this.i);
        } else {
            this.i.addCallback(this.j);
        }
    }

    public void f() {
        d dVar = this.f3285b;
        if (dVar != null) {
            dVar.e();
        }
    }
}
