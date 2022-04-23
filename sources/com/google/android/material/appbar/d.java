package com.google.android.material.appbar;

import a.g.l.s;
import android.view.View;

/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f3129a;

    /* renamed from: b  reason: collision with root package name */
    private int f3130b;

    /* renamed from: c  reason: collision with root package name */
    private int f3131c;

    /* renamed from: d  reason: collision with root package name */
    private int f3132d;

    /* renamed from: e  reason: collision with root package name */
    private int f3133e;

    public d(View view) {
        this.f3129a = view;
    }

    private void c() {
        View view = this.f3129a;
        s.d(view, this.f3132d - (view.getTop() - this.f3130b));
        View view2 = this.f3129a;
        s.c(view2, this.f3133e - (view2.getLeft() - this.f3131c));
    }

    public int a() {
        return this.f3132d;
    }

    public boolean a(int i) {
        if (this.f3133e == i) {
            return false;
        }
        this.f3133e = i;
        c();
        return true;
    }

    public void b() {
        this.f3130b = this.f3129a.getTop();
        this.f3131c = this.f3129a.getLeft();
        c();
    }

    public boolean b(int i) {
        if (this.f3132d == i) {
            return false;
        }
        this.f3132d = i;
        c();
        return true;
    }
}
