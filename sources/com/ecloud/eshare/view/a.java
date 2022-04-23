package com.ecloud.eshare.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ecloud.eshare.activity.MirrorNoteActivity;

/* loaded from: classes.dex */
public class a {
    protected static a h;

    /* renamed from: a  reason: collision with root package name */
    private int f2985a;

    /* renamed from: b  reason: collision with root package name */
    private int f2986b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2987c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f2988d;

    /* renamed from: e  reason: collision with root package name */
    private WindowManager f2989e;
    private WindowManager.LayoutParams f;
    private int g;

    private View a(int i) {
        ImageView imageView = new ImageView(this.f2987c);
        imageView.setImageResource(i);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
        return imageView;
    }

    public static synchronized a e() {
        a aVar;
        synchronized (a.class) {
            if (h == null) {
                h = new a();
            }
            aVar = h;
        }
        return aVar;
    }

    private void f() {
        if (this.f2985a == 0 && this.f2986b == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f2989e.getDefaultDisplay().getMetrics(displayMetrics);
            this.g = displayMetrics.widthPixels;
            int i = displayMetrics.heightPixels;
            this.f2985a = 0;
            this.f2986b = i / 2;
        }
    }

    public void a() {
        ImageView imageView = this.f2988d;
        if (imageView != null) {
            this.f2989e.removeViewImmediate(imageView);
            this.f2988d = null;
        }
    }

    public void a(Context context, int i) {
        int i2;
        WindowManager.LayoutParams layoutParams;
        this.f2987c = context;
        this.f2989e = (WindowManager) this.f2987c.getSystemService("window");
        this.f = new WindowManager.LayoutParams();
        this.f2988d = (ImageView) a(i);
        f();
        WindowManager.LayoutParams layoutParams2 = this.f;
        layoutParams2.gravity = 85;
        layoutParams2.format = 1;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.x = this.f2985a;
        if (MirrorNoteActivity.C().N == 90 || MirrorNoteActivity.C().N == 270) {
            layoutParams = this.f;
            i2 = this.f2986b - 25;
        } else {
            layoutParams = this.f;
            i2 = (this.g / 2) - 50;
        }
        layoutParams.y = i2;
        WindowManager.LayoutParams layoutParams3 = this.f;
        layoutParams3.flags = 40;
        layoutParams3.alpha = 1.0f;
        this.f2989e.addView(this.f2988d, layoutParams3);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f2988d.setOnClickListener(onClickListener);
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.f2988d.setOnTouchListener(onTouchListener);
    }

    public WindowManager.LayoutParams b() {
        return this.f;
    }

    public void c() {
        ImageView imageView = this.f2988d;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.f2989e.updateViewLayout(this.f2988d, this.f);
        }
    }

    public void d() {
        ImageView imageView = this.f2988d;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f2989e.updateViewLayout(this.f2988d, this.f);
        }
    }
}
