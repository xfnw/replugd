package com.airbnb.lottie.t;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.u.i;
import com.airbnb.lottie.x.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f2256d;

    /* renamed from: e  reason: collision with root package name */
    private com.airbnb.lottie.a f2257e;

    /* renamed from: a  reason: collision with root package name */
    private final i<String> f2253a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<i<String>, Typeface> f2254b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f2255c = new HashMap();
    private String f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        AssetManager assets;
        this.f2257e = aVar;
        if (!(callback instanceof View)) {
            d.b("LottieDrawable must be inside of a view for images to work.");
            assets = null;
        } else {
            assets = ((View) callback).getContext().getAssets();
        }
        this.f2256d = assets;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    private Typeface a(String str) {
        Typeface typeface = this.f2255c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.a aVar = this.f2257e;
        if (aVar != null) {
            aVar.a(str);
            throw null;
        } else if (aVar != null) {
            aVar.b(str);
            throw null;
        } else {
            Typeface createFromAsset = Typeface.createFromAsset(this.f2256d, "fonts/" + str + this.f);
            this.f2255c.put(str, createFromAsset);
            return createFromAsset;
        }
    }

    public Typeface a(String str, String str2) {
        this.f2253a.a(str, str2);
        Typeface typeface = this.f2254b.get(this.f2253a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f2254b.put(this.f2253a, a2);
        return a2;
    }

    public void a(com.airbnb.lottie.a aVar) {
        this.f2257e = aVar;
    }
}
