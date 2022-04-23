package c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint({"InflateParams"})
/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private static final Typeface f2083a = Typeface.create("sans-serif-condensed", 0);

    /* renamed from: b */
    private static Typeface f2084b = f2083a;

    /* renamed from: c */
    private static int f2085c = 16;

    /* renamed from: d */
    private static boolean f2086d = true;

    /* renamed from: e */
    private static boolean f2087e = true;
    private static Toast f = null;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private Typeface f2088a = e.f2084b;

        /* renamed from: b */
        private int f2089b = e.f2085c;

        /* renamed from: c */
        private boolean f2090c = e.f2086d;

        /* renamed from: d */
        private boolean f2091d = true;

        private a() {
        }

        public static a b() {
            return new a();
        }

        public a a(boolean z) {
            this.f2091d = z;
            return this;
        }

        public void a() {
            Typeface unused = e.f2084b = this.f2088a;
            int unused2 = e.f2085c = this.f2089b;
            boolean unused3 = e.f2086d = this.f2090c;
            boolean unused4 = e.f2087e = this.f2091d;
        }
    }

    public static Toast a(Context context, int i) {
        return a(context, context.getString(i), 0, true);
    }

    public static Toast a(Context context, CharSequence charSequence, int i, boolean z) {
        return a(context, charSequence, f.b(context, themeColors.ic_clear_white_24dp), f.a(context, themeSettings.errorColor), f.a(context, themeSettings.defaultTextColor), i, z, true);
    }

    @SuppressLint({"ShowToast"})
    public static Toast a(Context context, CharSequence charSequence, Drawable drawable, int i, int i2, int i3, boolean z, boolean z2) {
        Toast makeText = Toast.makeText(context, "", i3);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.toast_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(actionbarSettings.toast_icon);
        TextView textView = (TextView) inflate.findViewById(actionbarSettings.toast_text);
        f.a(inflate, z2 ? f.c(context, i) : f.b(context, themeColors.toast_frame));
        if (!z) {
            imageView.setVisibility(8);
        } else if (drawable != null) {
            if (f2086d) {
                f.a(drawable, i2);
            }
            f.a(imageView, drawable);
        } else {
            throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
        }
        textView.setText(charSequence);
        textView.setTextColor(i2);
        textView.setTypeface(f2084b);
        textView.setTextSize(2, f2085c);
        makeText.setView(inflate);
        if (!f2087e) {
            Toast toast = f;
            if (toast != null) {
                toast.cancel();
            }
            f = makeText;
        }
        return makeText;
    }
}
