package com.ecloud.eshare.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

@SuppressLint({"ShowToast", "ClickableViewAccessibility"})
/* loaded from: classes.dex */
public class FloatingService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f2888b;

    /* renamed from: c  reason: collision with root package name */
    private WindowManager.LayoutParams f2889c;

    /* renamed from: d  reason: collision with root package name */
    private Button f2890d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private int f2891b;

        /* renamed from: c  reason: collision with root package name */
        private int f2892c;

        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2891b = (int) motionEvent.getRawX();
                this.f2892c = (int) motionEvent.getRawY();
                return false;
            } else if (action != 2) {
                return false;
            } else {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i = rawX - this.f2891b;
                int i2 = rawY - this.f2892c;
                this.f2891b = rawX;
                this.f2892c = rawY;
                FloatingService.this.f2889c.x += i;
                FloatingService.this.f2889c.y += i2;
                FloatingService.this.f2888b.updateViewLayout(view, FloatingService.this.f2889c);
                return false;
            }
        }
    }

    private void a() {
        int i;
        WindowManager.LayoutParams layoutParams;
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            this.f2888b = (WindowManager) getSystemService("window");
            this.f2890d = new Button(getApplicationContext());
            this.f2890d.setText("Floating Window");
            this.f2890d.setBackgroundColor(-16776961);
            this.f2889c = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams = this.f2889c;
                i = 2038;
            } else {
                layoutParams = this.f2889c;
                i = 2003;
            }
            layoutParams.type = i;
            WindowManager.LayoutParams layoutParams2 = this.f2889c;
            layoutParams2.format = 1;
            layoutParams2.width = 1;
            layoutParams2.height = 1;
            layoutParams2.x = 100;
            layoutParams2.y = 300;
            layoutParams2.flags = 262184;
            this.f2888b.addView(this.f2890d, layoutParams2);
            this.f2890d.setOnTouchListener(new a());
        }
    }

    private void b() {
        this.f2888b.removeView(this.f2890d);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        return super.onStartCommand(intent, i, i2);
    }
}
