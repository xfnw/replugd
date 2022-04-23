package com.airbnb.lottie;

import a.g.k.d;
import com.airbnb.lottie.x.f;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2173a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f2174b = new a.d.b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, f> f2175c = new HashMap();

    /* loaded from: classes.dex */
    class a implements Comparator<d<String, Float>> {
        a(n nVar) {
        }

        /* renamed from: a */
        public int compare(d<String, Float> dVar, d<String, Float> dVar2) {
            float floatValue = dVar.f283b.floatValue();
            float floatValue2 = dVar2.f283b.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(float f);
    }

    public n() {
        new a(this);
    }

    public void a(String str, float f) {
        if (this.f2173a) {
            f fVar = this.f2175c.get(str);
            if (fVar == null) {
                fVar = new f();
                this.f2175c.put(str, fVar);
            }
            fVar.a(f);
            if (str.equals("__container")) {
                for (b bVar : this.f2174b) {
                    bVar.a(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f2173a = z;
    }
}
