package androidx.appcompat.app;

import a.a.j;
import a.a.n.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f700a;

        public C0030a(int i, int i2) {
            super(i, i2);
            this.f700a = 0;
            this.f700a = 8388627;
        }

        public C0030a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f700a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f700a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0030a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f700a = 0;
        }

        public C0030a(C0030a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f700a = 0;
            this.f700a = aVar.f700a;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract a.a.n.b a(b.a aVar);

    public abstract void a(Configuration configuration);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i, KeyEvent keyEvent);

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public boolean e() {
        return false;
    }

    public abstract boolean f();

    public abstract int g();

    public abstract Context h();

    public boolean i() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
    }

    public boolean k() {
        return false;
    }
}
