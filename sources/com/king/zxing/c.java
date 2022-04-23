package com.king.zxing;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.king.zxing.s.d;

/* loaded from: classes.dex */
public class c extends Activity implements m {

    /* renamed from: b  reason: collision with root package name */
    private SurfaceView f3273b;

    /* renamed from: c  reason: collision with root package name */
    private ViewfinderView f3274c;

    /* renamed from: d  reason: collision with root package name */
    private e f3275d;

    public d a() {
        return this.f3275d.a();
    }

    public boolean a(int i) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public e b() {
        return this.f3275d;
    }

    public int c() {
        throw null;
    }

    public int d() {
        return p.surfaceView;
    }

    public int e() {
        return p.viewfinderView;
    }

    public void f() {
        this.f3273b = (SurfaceView) findViewById(d());
        this.f3274c = (ViewfinderView) findViewById(e());
        this.f3275d = new e(this, this.f3273b, this.f3274c);
        this.f3275d.a(this);
        this.f3275d.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int c2 = c();
        if (a(c2)) {
            setContentView(c2);
        }
        f();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3275d.c();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3275d.d();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3275d.e();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f3275d.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
