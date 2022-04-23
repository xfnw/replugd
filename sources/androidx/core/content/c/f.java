package androidx.core.content.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    public static abstract class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.core.content.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0039a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Typeface f1206b;

            RunnableC0039a(Typeface typeface) {
                this.f1206b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.f1206b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f1208b;

            b(int i) {
                this.f1208b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.f1208b);
            }
        }

        public abstract void a(int i);

        public final void a(int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new b(i));
        }

        public abstract void a(Typeface typeface);

        public final void a(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0039a(typeface));
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a2 != null || aVar != null) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.content.c.f.a r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x009a
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L_0x0026
            if (r9 == 0) goto L_0x0025
            r9.a(r14, r10)
        L_0x0025:
            return r13
        L_0x0026:
            android.graphics.Typeface r1 = a.g.e.c.b(r0, r4, r5)
            if (r1 == 0) goto L_0x0032
            if (r9 == 0) goto L_0x0031
            r9.a(r1, r10)
        L_0x0031:
            return r1
        L_0x0032:
            java.lang.String r1 = r12.toLowerCase()     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            if (r1 == 0) goto L_0x0065
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            androidx.core.content.c.c$a r2 = androidx.core.content.c.c.a(r1, r0)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            if (r2 != 0) goto L_0x0053
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            if (r9 == 0) goto L_0x0052
            r9.a(r14, r10)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
        L_0x0052:
            return r13
        L_0x0053:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = a.g.e.c.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            return r0
        L_0x0065:
            r1 = r15
            android.graphics.Typeface r0 = a.g.e.c.a(r15, r0, r4, r12, r5)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            if (r9 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x0072
            r9.a(r0, r10)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
            goto L_0x0075
        L_0x0072:
            r9.a(r14, r10)     // Catch: IOException -> 0x0076, XmlPullParserException -> 0x007f
        L_0x0075:
            return r0
        L_0x0076:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            goto L_0x0087
        L_0x007f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
        L_0x0087:
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            if (r9 == 0) goto L_0x0099
            r9.a(r14, r10)
        L_0x0099:
            return r13
        L_0x009a:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.c.f.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.c.f$a, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}
