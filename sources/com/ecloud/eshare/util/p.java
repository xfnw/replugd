package com.ecloud.eshare.util;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Window f2927a;

        a(Window window) {
            this.f2927a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            this.f2927a.getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 5894 : 1799);
        }
    }

    public static void a(Window window) {
        window.clearFlags(8);
    }

    public static void b(Window window) {
        window.setFlags(8, 8);
    }

    public static void c(Window window) {
        window.getDecorView().setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(window));
    }
}
