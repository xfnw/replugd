package com.airbnb.lottie.u.j;

import com.airbnb.lottie.y.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<a<V>> f2305a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<a<V>> list) {
        this.f2305a = list;
    }

    @Override // com.airbnb.lottie.u.j.m
    public List<a<V>> b() {
        return this.f2305a;
    }

    @Override // com.airbnb.lottie.u.j.m
    public boolean c() {
        return this.f2305a.isEmpty() || (this.f2305a.size() == 1 && this.f2305a.get(0).g());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f2305a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f2305a.toArray()));
        }
        return sb.toString();
    }
}
