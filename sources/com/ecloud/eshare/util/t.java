package com.ecloud.eshare.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import com.squareup.picasso.R;

/* loaded from: classes.dex */
public enum t {
    INSTANCE;

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
    }

    private static View a(Activity activity, float f) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a(activity)));
        view.setBackgroundColor(Color.argb((int) (f * 255.0f), 0, 0, 0));
        view.setId(R.id.translucent_view);
        return view;
    }

    public static void a(Activity activity, Toolbar toolbar, float f) {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.getDecorView().setSystemUiVisibility(1280);
            } else {
                window.addFlags(67108864);
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            View childAt = ((ViewGroup) window.getDecorView().findViewById(16908290)).getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(false);
            }
            if (toolbar != null) {
                toolbar.setPadding(0, a(activity), 0, 0);
            }
            viewGroup.addView(a(activity, f));
        }
    }
}
