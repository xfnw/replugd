package c.a.a;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.content.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, int i) {
        return a.a(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(Drawable drawable, int i) {
        drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable b(Context context, int i) {
        return a.a.k.a.a.c(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable c(Context context, int i) {
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) b(context, themeColors.toast_frame);
        a(ninePatchDrawable, i);
        return ninePatchDrawable;
    }
}
