package com.airbnb.lottie.u.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.l;
import com.airbnb.lottie.x.d;

/* loaded from: classes.dex */
public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2334a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2335b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2336c;

    /* loaded from: classes.dex */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.f2334a = str;
        this.f2335b = aVar;
        this.f2336c = z;
    }

    @Override // com.airbnb.lottie.u.k.b
    public c a(f fVar, com.airbnb.lottie.u.l.a aVar) {
        if (fVar.c()) {
            return new l(this);
        }
        d.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a a() {
        return this.f2335b;
    }

    public String b() {
        return this.f2334a;
    }

    public boolean c() {
        return this.f2336c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f2335b + '}';
    }
}
