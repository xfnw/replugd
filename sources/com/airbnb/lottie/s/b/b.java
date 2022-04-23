package com.airbnb.lottie.s.b;

import android.graphics.Path;
import com.airbnb.lottie.x.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<t> f2187a = new ArrayList();

    public void a(Path path) {
        for (int size = this.f2187a.size() - 1; size >= 0; size--) {
            h.a(path, this.f2187a.get(size));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(t tVar) {
        this.f2187a.add(tVar);
    }
}
