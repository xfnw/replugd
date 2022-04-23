package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class a {

    /* renamed from: c  reason: collision with root package name */
    static a f1271c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class, C0041a> f1272a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, Boolean> f1273b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041a {

        /* renamed from: a  reason: collision with root package name */
        final Map<e.a, List<b>> f1274a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, e.a> f1275b;

        C0041a(Map<b, e.a> map) {
            this.f1275b = map;
            for (Map.Entry<b, e.a> entry : map.entrySet()) {
                e.a value = entry.getValue();
                List<b> list = this.f1274a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f1274a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void a(List<b> list, g gVar, e.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(gVar, aVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(g gVar, e.a aVar, Object obj) {
            a(this.f1274a.get(aVar), gVar, aVar, obj);
            a(this.f1274a.get(e.a.ON_ANY), gVar, aVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f1276a;

        /* renamed from: b  reason: collision with root package name */
        final Method f1277b;

        b(int i, Method method) {
            this.f1276a = i;
            this.f1277b = method;
            this.f1277b.setAccessible(true);
        }

        void a(g gVar, e.a aVar, Object obj) {
            try {
                int i = this.f1276a;
                if (i == 0) {
                    this.f1277b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f1277b.invoke(obj, gVar);
                } else if (i == 2) {
                    this.f1277b.invoke(obj, gVar, aVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1276a == bVar.f1276a && this.f1277b.getName().equals(bVar.f1277b.getName());
        }

        public int hashCode() {
            return (this.f1276a * 31) + this.f1277b.getName().hashCode();
        }
    }

    a() {
    }

    private C0041a a(Class cls, Method[] methodArr) {
        int i;
        C0041a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a2 = a(superclass)) == null)) {
            hashMap.putAll(a2.f1275b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, e.a> entry : a(cls2).f1275b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(g.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                e.a value = nVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(e.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == e.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0041a aVar = new C0041a(hashMap);
        this.f1272a.put(cls, aVar);
        this.f1273b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private void a(Map<b, e.a> map, b bVar, e.a aVar, Class cls) {
        e.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f1277b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0041a a(Class cls) {
        C0041a aVar = this.f1272a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Class cls) {
        if (this.f1273b.containsKey(cls)) {
            return this.f1273b.get(cls).booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method method : c2) {
            if (((n) method.getAnnotation(n.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f1273b.put(cls, false);
        return false;
    }
}
