package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class r0 extends j0 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1034b;

    public r0(Context context, Resources resources) {
        super(resources);
        this.f1034b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.j0, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f1034b.get();
        if (!(drawable == null || context == null)) {
            j.a();
            j.a(context, i, drawable);
        }
        return drawable;
    }
}
