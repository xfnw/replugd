package com.ecloud.eshare.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private View f2928a;

    /* renamed from: b  reason: collision with root package name */
    int f2929b;

    /* renamed from: c  reason: collision with root package name */
    private b f2930c;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            r.this.f2928a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            r rVar = r.this;
            int i = rVar.f2929b;
            if (i == 0) {
                rVar.f2929b = height;
            } else if (i != height) {
                if (i - height > 200) {
                    if (rVar.f2930c != null) {
                        r.this.f2930c.b(r.this.f2929b - height);
                    }
                } else if (height - i <= 200) {
                    return;
                } else {
                    if (rVar.f2930c != null) {
                        r.this.f2930c.a(height - r.this.f2929b);
                    }
                }
                r.this.f2929b = height;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i);

        void b(int i);
    }

    public r(Activity activity) {
        this.f2928a = activity.getWindow().getDecorView();
        this.f2928a.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void a(Activity activity, b bVar) {
        new r(activity).a(bVar);
    }

    private void a(b bVar) {
        this.f2930c = bVar;
    }
}
