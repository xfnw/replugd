package com.airbnb.lottie.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.g;
import com.airbnb.lottie.x.d;
import com.airbnb.lottie.x.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2258e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f2259a;

    /* renamed from: b  reason: collision with root package name */
    private String f2260b;

    /* renamed from: c  reason: collision with root package name */
    private com.airbnb.lottie.b f2261c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, g> f2262d;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        String str2;
        this.f2260b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f2260b.charAt(str2.length() - 1) != '/') {
                this.f2260b += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.b("LottieDrawable must be inside of a view for images to work.");
            this.f2262d = new HashMap();
            this.f2259a = null;
            return;
        }
        this.f2259a = ((View) callback).getContext();
        this.f2262d = map;
        a(bVar);
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (f2258e) {
            this.f2262d.get(str).a(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        String str2;
        Bitmap a2;
        g gVar = this.f2262d.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap a3 = gVar.a();
        if (a3 != null) {
            return a3;
        }
        com.airbnb.lottie.b bVar = this.f2261c;
        if (bVar != null) {
            Bitmap a4 = bVar.a(gVar);
            if (a4 != null) {
                a(str, a4);
            }
            return a4;
        }
        String b2 = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b2.startsWith("data:") || b2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f2260b)) {
                    AssetManager assets = this.f2259a.getAssets();
                    a2 = h.a(BitmapFactory.decodeStream(assets.open(this.f2260b + b2), null, options), gVar.e(), gVar.c());
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e2) {
                e = e2;
                str2 = "Unable to open asset.";
                d.a(str2, e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                a2 = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            } catch (IllegalArgumentException e3) {
                e = e3;
                str2 = "data URL did not have correct base64 format.";
                d.a(str2, e);
                return null;
            }
        }
        a(str, a2);
        return a2;
    }

    public void a(com.airbnb.lottie.b bVar) {
        this.f2261c = bVar;
    }

    public boolean a(Context context) {
        return (context == null && this.f2259a == null) || this.f2259a.equals(context);
    }
}
