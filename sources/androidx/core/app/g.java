package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f1164a;

        /* renamed from: b  reason: collision with root package name */
        private final j[] f1165b;

        /* renamed from: c  reason: collision with root package name */
        private final j[] f1166c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1167d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1168e;
        private final int f;
        public int g;
        public CharSequence h;
        public PendingIntent i;

        public PendingIntent a() {
            return this.i;
        }

        public boolean b() {
            return this.f1167d;
        }

        public j[] c() {
            return this.f1166c;
        }

        public Bundle d() {
            return this.f1164a;
        }

        public int e() {
            return this.g;
        }

        public j[] f() {
            return this.f1165b;
        }

        public int g() {
            return this.f;
        }

        public boolean h() {
            return this.f1168e;
        }

        public CharSequence i() {
            return this.h;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        String A;
        Bundle B;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        String K;
        long L;

        /* renamed from: a  reason: collision with root package name */
        public Context f1169a;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f1172d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f1173e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        boolean n;
        c o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean y;
        boolean z;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f1170b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        ArrayList<a> f1171c = new ArrayList<>();
        boolean m = true;
        boolean x = false;
        int C = 0;
        int D = 0;
        int J = 0;
        int M = 0;
        Notification N = new Notification();
        int l = 0;
        @Deprecated
        public ArrayList<String> O = new ArrayList<>();

        public b(Context context, String str) {
            this.f1169a = context;
            this.I = str;
            this.N.when = System.currentTimeMillis();
            this.N.audioStreamType = -1;
        }

        private void a(int i, boolean z) {
            Notification notification;
            int i2;
            if (z) {
                notification = this.N;
                i2 = i | notification.flags;
            } else {
                notification = this.N;
                i2 = (i ^ (-1)) & notification.flags;
            }
            notification.flags = i2;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f1169a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(a.g.b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(a.g.b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = dimensionPixelSize;
            double max = Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(max);
            double d3 = d2 / max;
            double d4 = dimensionPixelSize2;
            double max2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(max2);
            double min = Math.min(d3, d4 / max2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        public Notification a() {
            return new h(this).a();
        }

        public b a(int i) {
            this.C = i;
            return this;
        }

        public b a(long j) {
            this.N.when = j;
            return this;
        }

        public b a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public b a(Bitmap bitmap) {
            this.i = b(bitmap);
            return this;
        }

        public b a(RemoteViews remoteViews) {
            this.N.contentView = remoteViews;
            return this;
        }

        public b a(boolean z) {
            a(2, z);
            return this;
        }

        public Bundle b() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public b b(int i) {
            this.l = i;
            return this;
        }

        public b c(int i) {
            this.N.icon = i;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract void a(Bundle bundle);

        public abstract void a(f fVar);

        public abstract RemoteViews b(f fVar);

        public abstract RemoteViews c(f fVar);

        public abstract RemoteViews d(f fVar);
    }

    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return i.a(notification);
        }
        return null;
    }
}
