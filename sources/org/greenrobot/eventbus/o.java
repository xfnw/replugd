package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    final Method f3822a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f3823b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f3824c;

    /* renamed from: d  reason: collision with root package name */
    final int f3825d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f3826e;
    String f;

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f3822a = method;
        this.f3823b = threadMode;
        this.f3824c = cls;
        this.f3825d = i;
        this.f3826e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f3822a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f3822a.getName());
            sb.append('(');
            sb.append(this.f3824c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f.equals(oVar.f);
    }

    public int hashCode() {
        return this.f3822a.hashCode();
    }
}
