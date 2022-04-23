package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.n;
import com.airbnb.lottie.u.e;
import com.airbnb.lottie.x.h;
import e.l;
import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class LottieAnimationView extends n {
    private static final String q = LottieAnimationView.class.getSimpleName();
    private boolean g;
    private String h;
    private int i;
    private m<com.airbnb.lottie.d> o;
    private com.airbnb.lottie.d p;

    /* renamed from: d  reason: collision with root package name */
    private final h<com.airbnb.lottie.d> f2092d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final h<Throwable> f2093e = new b(this);
    private final f f = new f();
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private p m = p.AUTOMATIC;
    private Set<j> n = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements h<com.airbnb.lottie.d> {
        a() {
        }

        public void a(com.airbnb.lottie.d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    /* loaded from: classes.dex */
    class b implements h<Throwable> {
        b(LottieAnimationView lottieAnimationView) {
        }

        @Override // com.airbnb.lottie.h
        public /* bridge */ /* synthetic */ void a(Throwable th) {
            a2(th);
            throw null;
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void a2(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2095a = new int[p.values().length];

        static {
            try {
                f2095a[p.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2095a[p.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2095a[p.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        String f2096b;

        /* renamed from: c  reason: collision with root package name */
        int f2097c;

        /* renamed from: d  reason: collision with root package name */
        float f2098d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2099e;
        String f;
        int g;
        int h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        private d(Parcel parcel) {
            super(parcel);
            this.f2096b = parcel.readString();
            this.f2098d = parcel.readFloat();
            this.f2099e = parcel.readInt() != 1 ? false : true;
            this.f = parcel.readString();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
        }

        /* synthetic */ d(Parcel parcel, a aVar) {
            this(parcel);
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2096b);
            parcel.writeFloat(this.f2098d);
            parcel.writeInt(this.f2099e ? 1 : 0);
            parcel.writeString(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.LottieAnimationView);
        boolean z = false;
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            } else if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(o.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(o.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(o.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(o.LottieAnimationView_lottie_autoPlay, false)) {
            this.k = true;
            this.l = true;
        }
        if (obtainStyledAttributes.getBoolean(o.LottieAnimationView_lottie_loop, false)) {
            this.f.d(-1);
        }
        if (obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(o.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(o.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(o.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(o.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(o.LottieAnimationView_lottie_progress, 0.0f));
        a(obtainStyledAttributes.getBoolean(o.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_colorFilter)) {
            a(new e("**"), k.B, new com.airbnb.lottie.y.c(new q(obtainStyledAttributes.getColor(o.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_scale)) {
            this.f.d(obtainStyledAttributes.getFloat(o.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(o.LottieAnimationView_lottie_renderMode)) {
            int i = obtainStyledAttributes.getInt(o.LottieAnimationView_lottie_renderMode, p.AUTOMATIC.ordinal());
            if (i >= p.values().length) {
                i = p.AUTOMATIC.ordinal();
            }
            this.m = p.values()[i];
        }
        obtainStyledAttributes.recycle();
        f fVar = this.f;
        if (h.a(getContext()) != 0.0f) {
            z = true;
        }
        fVar.a(Boolean.valueOf(z));
        j();
        this.g = true;
    }

    private void h() {
        m<com.airbnb.lottie.d> mVar = this.o;
        if (mVar != null) {
            mVar.d(this.f2092d);
            this.o.c(this.f2093e);
        }
    }

    private void i() {
        this.p = null;
        this.f.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if (r3 != false) goto L_0x003d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.c.f2095a
            com.airbnb.lottie.p r1 = r5.m
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x003d
            if (r0 == r1) goto L_0x0013
            r3 = 3
            if (r0 == r3) goto L_0x0015
        L_0x0013:
            r1 = 1
            goto L_0x003d
        L_0x0015:
            com.airbnb.lottie.d r0 = r5.p
            r3 = 0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x0027
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x0027
            goto L_0x003b
        L_0x0027:
            com.airbnb.lottie.d r0 = r5.p
            if (r0 == 0) goto L_0x0033
            int r0 = r0.j()
            r4 = 4
            if (r0 <= r4) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r3 = 1
        L_0x003b:
            if (r3 == 0) goto L_0x0013
        L_0x003d:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L_0x0047
            r0 = 0
            r5.setLayerType(r1, r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.j():void");
    }

    private void setCompositionTask(m<com.airbnb.lottie.d> mVar) {
        i();
        h();
        mVar.b(this.f2092d);
        mVar.a(this.f2093e);
        this.o = mVar;
    }

    public void a() {
        this.j = false;
        this.f.a();
        j();
    }

    public <T> void a(e eVar, T t, com.airbnb.lottie.y.c<T> cVar) {
        this.f.a(eVar, t, cVar);
    }

    public void a(com.airbnb.lottie.w.k0.c cVar, String str) {
        setCompositionTask(e.a(cVar, str));
    }

    public void a(String str, String str2) {
        a(com.airbnb.lottie.w.k0.c.a(l.a(l.a(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public void a(boolean z) {
        this.f.a(z);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        super.buildDrawingCache(z);
        if (getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(p.HARDWARE);
        }
    }

    public boolean d() {
        return this.f.q();
    }

    public void e() {
        this.l = false;
        this.k = false;
        this.j = false;
        this.f.r();
        j();
    }

    public void f() {
        if (isShown()) {
            this.f.s();
            j();
            return;
        }
        this.j = true;
    }

    public void g() {
        if (isShown()) {
            this.f.t();
            j();
            return;
        }
        this.j = true;
    }

    public com.airbnb.lottie.d getComposition() {
        return this.p;
    }

    public long getDuration() {
        com.airbnb.lottie.d dVar = this.p;
        if (dVar != null) {
            return dVar.c();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f.f();
    }

    public String getImageAssetsFolder() {
        return this.f.g();
    }

    public float getMaxFrame() {
        return this.f.h();
    }

    public float getMinFrame() {
        return this.f.i();
    }

    public n getPerformanceTracker() {
        return this.f.j();
    }

    public float getProgress() {
        return this.f.k();
    }

    public int getRepeatCount() {
        return this.f.l();
    }

    public int getRepeatMode() {
        return this.f.m();
    }

    public float getScale() {
        return this.f.n();
    }

    public float getSpeed() {
        return this.f.o();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l || this.k) {
            f();
            this.l = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (d()) {
            a();
            this.k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.h = dVar.f2096b;
        if (!TextUtils.isEmpty(this.h)) {
            setAnimation(this.h);
        }
        this.i = dVar.f2097c;
        int i = this.i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(dVar.f2098d);
        if (dVar.f2099e) {
            f();
        }
        this.f.b(dVar.f);
        setRepeatMode(dVar.g);
        setRepeatCount(dVar.h);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f2096b = this.h;
        dVar.f2097c = this.i;
        dVar.f2098d = this.f.k();
        dVar.f2099e = this.f.q();
        dVar.f = this.f.g();
        dVar.g = this.f.m();
        dVar.h = this.f.l();
        return dVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        boolean z;
        if (this.g) {
            if (isShown()) {
                if (this.j) {
                    g();
                    z = false;
                } else {
                    return;
                }
            } else if (d()) {
                e();
                z = true;
            } else {
                return;
            }
            this.j = z;
        }
    }

    public void setAnimation(int i) {
        this.i = i;
        this.h = null;
        setCompositionTask(e.a(getContext(), i));
    }

    public void setAnimation(String str) {
        this.h = str;
        this.i = 0;
        setCompositionTask(e.a(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(e.c(getContext(), str));
    }

    public void setComposition(com.airbnb.lottie.d dVar) {
        if (com.airbnb.lottie.c.f2100a) {
            String str = "Set Composition \n" + dVar;
        }
        this.f.setCallback(this);
        this.p = dVar;
        boolean a2 = this.f.a(dVar);
        j();
        if (getDrawable() != this.f || a2) {
            setImageDrawable(null);
            setImageDrawable(this.f);
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (j jVar : this.n) {
                jVar.a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f.a(aVar);
    }

    public void setFrame(int i) {
        this.f.a(i);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f.a(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f.b(str);
    }

    @Override // androidx.appcompat.widget.n, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        h();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.n, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        h();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.n, android.widget.ImageView
    public void setImageResource(int i) {
        h();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.f.b(i);
    }

    public void setMaxFrame(String str) {
        this.f.c(str);
    }

    public void setMaxProgress(float f) {
        this.f.a(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.f.d(str);
    }

    public void setMinFrame(int i) {
        this.f.c(i);
    }

    public void setMinFrame(String str) {
        this.f.e(str);
    }

    public void setMinProgress(float f) {
        this.f.b(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f.b(z);
    }

    public void setProgress(float f) {
        this.f.c(f);
    }

    public void setRenderMode(p pVar) {
        this.m = pVar;
        j();
    }

    public void setRepeatCount(int i) {
        this.f.d(i);
    }

    public void setRepeatMode(int i) {
        this.f.e(i);
    }

    public void setScale(float f) {
        this.f.d(f);
        if (getDrawable() == this.f) {
            setImageDrawable(null);
            setImageDrawable(this.f);
        }
    }

    public void setSpeed(float f) {
        this.f.e(f);
    }

    public void setTextDelegate(r rVar) {
        this.f.a(rVar);
    }
}
