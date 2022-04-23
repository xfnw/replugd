package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.r.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, List<o>> f3827d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final a[] f3828e = new a[4];

    /* renamed from: a  reason: collision with root package name */
    private List<b> f3829a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3830b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3831c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<o> f3832a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f3833b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f3834c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f3835d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        Class<?> f3836e;
        boolean f;
        org.greenrobot.eventbus.r.a g;

        a() {
        }

        private boolean b(Method method, Class<?> cls) {
            this.f3835d.setLength(0);
            this.f3835d.append(method.getName());
            StringBuilder sb = this.f3835d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f3835d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f3834c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f3834c.put(sb2, put);
            return false;
        }

        void a() {
            if (!this.f) {
                this.f3836e = this.f3836e.getSuperclass();
                String name = this.f3836e.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.")) {
                    return;
                }
            }
            this.f3836e = null;
        }

        void a(Class<?> cls) {
            this.f3836e = cls;
            this.f = false;
            this.g = null;
        }

        boolean a(Method method, Class<?> cls) {
            Object put = this.f3833b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f3833b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        void b() {
            this.f3832a.clear();
            this.f3833b.clear();
            this.f3834c.clear();
            this.f3835d.setLength(0);
            this.f3836e = null;
            this.f = false;
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(List<b> list, boolean z, boolean z2) {
        this.f3829a = list;
        this.f3830b = z;
        this.f3831c = z2;
    }

    private a a() {
        synchronized (f3828e) {
            for (int i = 0; i < 4; i++) {
                a aVar = f3828e[i];
                if (aVar != null) {
                    f3828e[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private void a(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f3836e.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f3836e.getMethods();
            aVar.f = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f3832a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                        }
                    }
                } else if (this.f3830b && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f3830b && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    private List<o> b(Class<?> cls) {
        o[] a2;
        a a3 = a();
        a3.a(cls);
        while (a3.f3836e != null) {
            a3.g = c(a3);
            org.greenrobot.eventbus.r.a aVar = a3.g;
            if (aVar != null) {
                for (o oVar : aVar.a()) {
                    if (a3.a(oVar.f3822a, oVar.f3824c)) {
                        a3.f3832a.add(oVar);
                    }
                }
            } else {
                a(a3);
            }
            a3.a();
        }
        return b(a3);
    }

    private List<o> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f3832a);
        aVar.b();
        synchronized (f3828e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (f3828e[i] == null) {
                    f3828e[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private List<o> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f3836e != null) {
            a(a2);
            a2.a();
        }
        return b(a2);
    }

    private org.greenrobot.eventbus.r.a c(a aVar) {
        org.greenrobot.eventbus.r.a aVar2 = aVar.g;
        if (!(aVar2 == null || aVar2.c() == null)) {
            org.greenrobot.eventbus.r.a c2 = aVar.g.c();
            if (aVar.f3836e == c2.b()) {
                return c2;
            }
        }
        List<b> list = this.f3829a;
        if (list == null) {
            return null;
        }
        for (b bVar : list) {
            org.greenrobot.eventbus.r.a a2 = bVar.a(aVar.f3836e);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<o> a(Class<?> cls) {
        List<o> list = f3827d.get(cls);
        if (list != null) {
            return list;
        }
        List<o> c2 = this.f3831c ? c(cls) : b(cls);
        if (!c2.isEmpty()) {
            f3827d.put(cls, c2);
            return c2;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
