package com.eshare.mirror;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import b.b.a.n.c;
import b.b.a.n.g;
import com.eshare.lib.f;
import com.eshare.lib.h;

/* loaded from: classes.dex */
public class l implements View.OnClickListener, View.OnTouchListener {
    private static l A;
    private static SharedPreferences z;

    /* renamed from: b  reason: collision with root package name */
    private View f3096b;

    /* renamed from: c  reason: collision with root package name */
    private View f3097c;

    /* renamed from: d  reason: collision with root package name */
    private Context f3098d;

    /* renamed from: e  reason: collision with root package name */
    private WindowManager f3099e;
    private WindowManager.LayoutParams f;
    private WindowManager.LayoutParams g;
    private boolean h;
    private boolean i;
    private AndroidMirrorPaintView j;
    private View k;
    private View l;
    private View m;
    private int n;
    private int o;
    private float p;
    private float q;
    private float r;
    private long s;
    private int t;
    private int u;
    private long v;
    private int w;
    private View x;
    private View y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.j.setVisibility(8);
        }
    }

    private l(Context context) {
        this.f3098d = context;
        f();
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (A == null) {
                A = new l(context);
            }
            lVar = A;
        }
        return lVar;
    }

    public static boolean a(Context context, String str, boolean z2) {
        if (g.a()) {
            return true;
        }
        if (z == null) {
            z = context.getSharedPreferences("brush", 0);
        }
        return z.getBoolean(str, z2);
    }

    private void i() {
        int i;
        WindowManager.LayoutParams layoutParams;
        this.h = false;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f;
            i = 2038;
        } else {
            layoutParams = this.f;
            i = 2002;
        }
        layoutParams.type = i;
        this.g.type = i;
        WindowManager.LayoutParams layoutParams2 = this.f;
        layoutParams2.flags = 40;
        layoutParams2.format = 1;
        WindowManager.LayoutParams layoutParams3 = this.g;
        layoutParams3.flags = 40;
        layoutParams3.format = 1;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams3.width = -2;
        layoutParams3.height = this.u;
        int i2 = layoutParams3.x;
        int i3 = this.o;
        if (i2 > i3 / 2) {
            layoutParams3.x = i3;
        } else {
            layoutParams3.x = 0;
        }
        this.f.gravity = 8388659;
        this.j.setVisibility(0);
        if (!this.i) {
            this.g.gravity = 8388661;
            this.f3099e.addView(this.f3096b, this.f);
            this.f3099e.addView(this.f3097c, this.g);
        } else {
            this.f3099e.updateViewLayout(this.f3096b, this.f);
            this.f3099e.updateViewLayout(this.f3097c, this.g);
        }
        this.i = true;
    }

    private void j() {
        if (!this.h) {
            this.j.a();
            g();
            this.k.setBackgroundResource(f.eshare_ic_open);
            this.l.setVisibility(8);
            k();
            return;
        }
        l();
        this.n = -65536;
        this.j.setColor(this.n);
        i();
        this.k.setBackgroundResource(f.eshare_ic_close);
    }

    private void k() {
        this.f3097c.findViewById(com.eshare.lib.g.red).setVisibility(8);
        this.f3097c.findViewById(com.eshare.lib.g.white).setVisibility(8);
        this.f3097c.findViewById(com.eshare.lib.g.black).setVisibility(8);
        this.f3097c.findViewById(com.eshare.lib.g.yello).setVisibility(8);
        this.f3097c.findViewById(com.eshare.lib.g.blue).setVisibility(8);
    }

    private void l() {
        this.f3097c.findViewById(com.eshare.lib.g.red).setVisibility(0);
        this.f3097c.findViewById(com.eshare.lib.g.white).setVisibility(0);
        this.f3097c.findViewById(com.eshare.lib.g.black).setVisibility(0);
        this.f3097c.findViewById(com.eshare.lib.g.yello).setVisibility(0);
        this.f3097c.findViewById(com.eshare.lib.g.blue).setVisibility(0);
    }

    public void e() {
        try {
            if (this.x != null) {
                this.f3099e.removeViewImmediate(this.x);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f3097c != null) {
                this.f3099e.removeViewImmediate(this.f3097c);
            }
            if (this.f3096b != null) {
                this.f3099e.removeViewImmediate(this.f3096b);
            }
            this.i = false;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        this.f3099e = (WindowManager) this.f3098d.getApplicationContext().getSystemService("window");
        this.f3096b = LayoutInflater.from(this.f3098d).inflate(h.pen_for_android_mirror, (ViewGroup) null);
        this.f3097c = LayoutInflater.from(this.f3098d).inflate(h.pen_menu_for_android_mirror, (ViewGroup) null);
        this.f = new WindowManager.LayoutParams();
        this.g = new WindowManager.LayoutParams();
        h();
    }

    public void g() {
        int i;
        WindowManager.LayoutParams layoutParams;
        this.h = true;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f;
            i = 2038;
        } else {
            layoutParams = this.f;
            i = 2002;
        }
        layoutParams.type = i;
        this.g.type = i;
        WindowManager.LayoutParams layoutParams2 = this.f;
        layoutParams2.flags = 40;
        layoutParams2.format = 1;
        WindowManager.LayoutParams layoutParams3 = this.g;
        layoutParams3.flags = 40;
        layoutParams3.format = 1;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        Boolean valueOf = Boolean.valueOf(a(this.f3098d, "hide", false));
        int i2 = 10;
        this.g.width = valueOf.booleanValue() ? 10 : this.t;
        WindowManager.LayoutParams layoutParams4 = this.g;
        if (!valueOf.booleanValue()) {
            i2 = this.t;
        }
        layoutParams4.height = i2;
        if (Math.abs(this.r - this.g.y) > (this.t * 3) / 2) {
            this.g.y = (int) this.r;
        }
        WindowManager.LayoutParams layoutParams5 = this.g;
        int i3 = layoutParams5.x;
        int i4 = this.o;
        if (i3 > i4 / 2) {
            layoutParams5.x = i4;
        } else {
            layoutParams5.x = 0;
        }
        if (!this.i) {
            this.g.gravity = 8388661;
            this.f3099e.addView(this.f3096b, this.f);
            this.f3099e.addView(this.f3097c, this.g);
        } else {
            this.f3099e.updateViewLayout(this.f3096b, this.f);
            this.f3099e.updateViewLayout(this.f3097c, this.g);
        }
        this.j.post(new a());
        this.i = true;
    }

    public void h() {
        this.k = this.f3097c.findViewById(com.eshare.lib.g.pen);
        this.y = this.f3097c.findViewById(com.eshare.lib.g.iv_pixel);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f3099e.getDefaultDisplay().getMetrics(displayMetrics);
        this.o = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels;
        this.r = 80.0f;
        this.k.setOnClickListener(this);
        this.k.setOnTouchListener(this);
        this.l = this.f3097c.findViewById(com.eshare.lib.g.change_color);
        this.l.setOnClickListener(this);
        this.m = this.f3097c.findViewById(com.eshare.lib.g.save);
        this.m.setOnClickListener(this);
        this.m.setVisibility(8);
        this.f3097c.findViewById(com.eshare.lib.g.red).setOnClickListener(this);
        this.f3097c.findViewById(com.eshare.lib.g.white).setOnClickListener(this);
        this.f3097c.findViewById(com.eshare.lib.g.black).setOnClickListener(this);
        this.f3097c.findViewById(com.eshare.lib.g.yello).setOnClickListener(this);
        this.f3097c.findViewById(com.eshare.lib.g.blue).setOnClickListener(this);
        this.j = (AndroidMirrorPaintView) this.f3096b.findViewById(com.eshare.lib.g.paint_view);
        if (Boolean.valueOf(a(this.f3098d, "hide", true)).booleanValue()) {
            this.y.setBackgroundColor(-16777216);
            this.y.setVisibility(0);
            this.k.setVisibility(8);
            this.y.setAlpha(0.0f);
            this.t = c.a(this.f3098d, 5.0f);
            this.u = c.a(this.f3098d, 5.0f);
        } else {
            this.t = c.a(this.f3098d, 50.0f);
            this.u = c.a(this.f3098d, 105.0f);
            this.y.setVisibility(8);
            this.k.setVisibility(0);
        }
        g();
        this.w = ViewConfiguration.get(this.f3098d).getScaledTouchSlop();
        this.v = ViewConfiguration.getTapTimeout();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            int r0 = r6.getId()
            int r1 = com.eshare.lib.g.pen
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x000e
            r5.j()
            goto L_0x0055
        L_0x000e:
            int r1 = com.eshare.lib.g.change_color
            r4 = -1
            if (r0 != r1) goto L_0x002a
            r5.l()
            r0 = 8
            r6.setVisibility(r0)
            android.view.WindowManager$LayoutParams r6 = r5.g
            r6.width = r4
            r0 = -2
            r6.height = r0
            android.view.WindowManager r0 = r5.f3099e
            android.view.View r1 = r5.f3097c
            r0.updateViewLayout(r1, r6)
            goto L_0x0055
        L_0x002a:
            int r6 = com.eshare.lib.g.save
            if (r0 != r6) goto L_0x002f
            goto L_0x0055
        L_0x002f:
            int r6 = com.eshare.lib.g.red
            if (r0 != r6) goto L_0x0038
            r6 = -65536(0xffffffffffff0000, float:NaN)
        L_0x0035:
            r5.n = r6
            goto L_0x0056
        L_0x0038:
            int r6 = com.eshare.lib.g.white
            if (r0 != r6) goto L_0x003f
            r5.n = r4
            goto L_0x0056
        L_0x003f:
            int r6 = com.eshare.lib.g.black
            if (r0 != r6) goto L_0x0046
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x0035
        L_0x0046:
            int r6 = com.eshare.lib.g.yello
            if (r0 != r6) goto L_0x004d
            r6 = -3840(0xfffffffffffff100, float:NaN)
            goto L_0x0035
        L_0x004d:
            int r6 = com.eshare.lib.g.blue
            if (r0 != r6) goto L_0x0055
            r6 = -16727297(0xffffffffff00c2ff, float:-1.7115366E38)
            goto L_0x0035
        L_0x0055:
            r3 = 0
        L_0x0056:
            if (r3 == 0) goto L_0x007f
            com.eshare.mirror.AndroidMirrorPaintView r6 = r5.j
            int r0 = r5.n
            r6.setColor(r0)
            android.view.View r6 = r5.k
            int r0 = com.eshare.lib.f.eshare_ic_close
            r6.setBackgroundResource(r0)
            r5.k()
            android.view.View r6 = r5.l
            r6.setVisibility(r2)
            android.view.WindowManager$LayoutParams r6 = r5.g
            r0 = 150(0x96, float:2.1E-43)
            r6.width = r0
            r0 = 300(0x12c, float:4.2E-43)
            r6.height = r0
            android.view.WindowManager r0 = r5.f3099e
            android.view.View r1 = r5.f3097c
            r0.updateViewLayout(r1, r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eshare.mirror.l.onClick(android.view.View):void");
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != com.eshare.lib.g.pen) {
            return false;
        }
        Math.abs(motionEvent.getRawX() - this.o);
        this.r = Math.abs(motionEvent.getRawY());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = motionEvent.getRawX();
            this.q = motionEvent.getRawY();
            this.s = System.currentTimeMillis();
        } else if (action != 1) {
            if (action == 2 && (Math.abs(motionEvent.getRawX() - this.p) > this.w || Math.abs(motionEvent.getRawY() - this.q) > this.w)) {
                this.g.x = (int) Math.abs(motionEvent.getRawX() - this.o);
                this.g.y = (int) Math.abs(motionEvent.getRawY());
                WindowManager.LayoutParams layoutParams = this.g;
                int i = this.t;
                layoutParams.width = i;
                layoutParams.height = i;
                this.f3099e.updateViewLayout(this.f3097c, layoutParams);
            }
        } else if (Math.abs(motionEvent.getRawX() - this.p) >= this.w || Math.abs(motionEvent.getRawY() - this.q) >= this.w) {
            WindowManager.LayoutParams layoutParams2 = this.g;
            int i2 = layoutParams2.x;
            int i3 = this.o;
            if (i2 > i3 / 2) {
                layoutParams2.x = i3;
            } else {
                layoutParams2.x = 0;
            }
            this.g.y = (int) (motionEvent.getRawY() - (this.k.getMeasuredHeight() / 2));
            this.f3099e.updateViewLayout(this.f3097c, this.g);
        } else if (System.currentTimeMillis() - this.s < this.v) {
            view.performClick();
        }
        return true;
    }
}
