package com.airbnb.lottie.s.c;

import android.graphics.Path;
import com.airbnb.lottie.u.k.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<l, Path>> f2245a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f2246b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.airbnb.lottie.u.k.g> f2247c;

    public g(List<com.airbnb.lottie.u.k.g> list) {
        this.f2247c = list;
        this.f2245a = new ArrayList(list.size());
        this.f2246b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f2245a.add(list.get(i).b().a());
            this.f2246b.add(list.get(i).c().a());
        }
    }

    public List<a<l, Path>> a() {
        return this.f2245a;
    }

    public List<com.airbnb.lottie.u.k.g> b() {
        return this.f2247c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f2246b;
    }
}
