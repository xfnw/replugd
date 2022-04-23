package com.airbnb.lottie.x;

import android.util.Log;
import com.airbnb.lottie.i;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f2492a = new HashSet();

    @Override // com.airbnb.lottie.i
    public void a(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.i
    public void a(String str, Throwable th) {
        if (!f2492a.contains(str)) {
            Log.w("LOTTIE", str, th);
            f2492a.add(str);
        }
    }

    @Override // com.airbnb.lottie.i
    public void b(String str) {
        a(str, null);
    }

    public void b(String str, Throwable th) {
        boolean z = com.airbnb.lottie.c.f2100a;
    }
}
