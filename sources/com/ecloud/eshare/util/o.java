package com.ecloud.eshare.util;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes.dex */
public class o extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    private a f2926a;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    public o(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f2926a = aVar;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        this.f2926a.a(i);
    }
}
