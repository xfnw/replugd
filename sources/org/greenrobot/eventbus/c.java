package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* loaded from: classes.dex */
public class c {
    static volatile c s;
    private static final d t = new d();
    private static final Map<Class<?>, List<Class<?>>> u = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<q>> f3790a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f3791b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Object> f3792c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<C0103c> f3793d;

    /* renamed from: e  reason: collision with root package name */
    private final h f3794e;
    private final l f;
    private final org.greenrobot.eventbus.b g;
    private final org.greenrobot.eventbus.a h;
    private final p i;
    private final ExecutorService j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private final g r;

    /* loaded from: classes.dex */
    class a extends ThreadLocal<C0103c> {
        a(c cVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public C0103c initialValue() {
            return new C0103c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3795a = new int[ThreadMode.values().length];

        static {
            try {
                f3795a[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3795a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3795a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3795a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3795a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.greenrobot.eventbus.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0103c {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f3796a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f3797b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3798c;

        /* renamed from: d  reason: collision with root package name */
        q f3799d;

        /* renamed from: e  reason: collision with root package name */
        Object f3800e;
        boolean f;

        C0103c() {
        }
    }

    public c() {
        this(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f3793d = new a(this);
        this.r = dVar.c();
        this.f3790a = new HashMap();
        this.f3791b = new HashMap();
        this.f3792c = new ConcurrentHashMap();
        this.f3794e = dVar.d();
        h hVar = this.f3794e;
        this.f = hVar != null ? hVar.a(this) : null;
        this.g = new org.greenrobot.eventbus.b(this);
        this.h = new org.greenrobot.eventbus.a(this);
        List<org.greenrobot.eventbus.r.b> list = dVar.j;
        this.q = list != null ? list.size() : 0;
        this.i = new p(dVar.j, dVar.h, dVar.g);
        this.l = dVar.f3801a;
        this.m = dVar.f3802b;
        this.n = dVar.f3803c;
        this.o = dVar.f3804d;
        this.k = dVar.f3805e;
        this.p = dVar.f;
        this.j = dVar.i;
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (u) {
            list = u.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                u.put(cls, list);
            }
        }
        return list;
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f3790a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                q qVar = copyOnWriteArrayList.get(i);
                if (qVar.f3837a == obj) {
                    qVar.f3839c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private void a(Object obj, C0103c cVar) {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List<Class<?>> a2 = a(cls);
            int size = a2.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= a(obj, cVar, a2.get(i));
            }
        } else {
            z = a(obj, cVar, cls);
        }
        if (!z) {
            if (this.m) {
                g gVar = this.r;
                Level level = Level.FINE;
                gVar.a(level, "No subscribers registered for event " + cls);
            }
            if (!(!this.o || cls == i.class || cls == n.class)) {
                a(new i(this, obj));
            }
        }
    }

    private void a(Object obj, o oVar) {
        Class<?> cls = oVar.f3824c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f3790a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f3790a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || oVar.f3825d > copyOnWriteArrayList.get(i).f3838b.f3825d) {
                copyOnWriteArrayList.add(i, qVar);
                break;
            }
        }
        List<Class<?>> list = this.f3791b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f3791b.put(obj, list);
        }
        list.add(cls);
        if (!oVar.f3826e) {
            return;
        }
        if (this.p) {
            for (Map.Entry<Class<?>, Object> entry : this.f3792c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
            return;
        }
        b(qVar, this.f3792c.get(cls));
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private void a(q qVar, Object obj, Throwable th) {
        if (obj instanceof n) {
            if (this.l) {
                g gVar = this.r;
                Level level = Level.SEVERE;
                gVar.a(level, "SubscriberExceptionEvent subscriber " + qVar.f3837a.getClass() + " threw an exception", th);
                n nVar = (n) obj;
                g gVar2 = this.r;
                Level level2 = Level.SEVERE;
                gVar2.a(level2, "Initial event " + nVar.f3820b + " caused exception in " + nVar.f3821c, nVar.f3819a);
            }
        } else if (!this.k) {
            if (this.l) {
                g gVar3 = this.r;
                Level level3 = Level.SEVERE;
                gVar3.a(level3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f3837a.getClass(), th);
            }
            if (this.n) {
                a(new n(this, th, obj, qVar.f3837a));
            }
        } else {
            throw new e("Invoking subscriber failed", th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r5 != null) goto L_0x004e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.greenrobot.eventbus.q r3, java.lang.Object r4, boolean r5) {
        /*
            r2 = this;
            int[] r0 = org.greenrobot.eventbus.c.b.f3795a
            org.greenrobot.eventbus.o r1 = r3.f3838b
            org.greenrobot.eventbus.ThreadMode r1 = r1.f3823b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0052
            r1 = 2
            if (r0 == r1) goto L_0x0049
            r1 = 3
            if (r0 == r1) goto L_0x0044
            r1 = 4
            if (r0 == r1) goto L_0x003c
            r5 = 5
            if (r0 != r5) goto L_0x0021
            org.greenrobot.eventbus.a r5 = r2.h
            r5.a(r3, r4)
            goto L_0x0055
        L_0x0021:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Unknown thread mode: "
            r5.append(r0)
            org.greenrobot.eventbus.o r3 = r3.f3838b
            org.greenrobot.eventbus.ThreadMode r3 = r3.f3823b
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3)
            throw r4
        L_0x003c:
            if (r5 == 0) goto L_0x0052
            org.greenrobot.eventbus.b r5 = r2.g
            r5.a(r3, r4)
            goto L_0x0055
        L_0x0044:
            org.greenrobot.eventbus.l r5 = r2.f
            if (r5 == 0) goto L_0x0052
            goto L_0x004e
        L_0x0049:
            if (r5 == 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            org.greenrobot.eventbus.l r5 = r2.f
        L_0x004e:
            r5.a(r3, r4)
            goto L_0x0055
        L_0x0052:
            r2.a(r3, r4)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.c.a(org.greenrobot.eventbus.q, java.lang.Object, boolean):void");
    }

    private boolean a(Object obj, C0103c cVar, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f3790a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<q> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            cVar.f3800e = obj;
            cVar.f3799d = next;
            try {
                a(next, obj, cVar.f3798c);
                if (cVar.f) {
                    return true;
                }
            } finally {
                cVar.f3800e = null;
                cVar.f3799d = null;
                cVar.f = false;
            }
        }
        return true;
    }

    private void b(q qVar, Object obj) {
        if (obj != null) {
            a(qVar, obj, e());
        }
    }

    public static d c() {
        return new d();
    }

    public static c d() {
        if (s == null) {
            synchronized (c.class) {
                if (s == null) {
                    s = new c();
                }
            }
        }
        return s;
    }

    private boolean e() {
        h hVar = this.f3794e;
        if (hVar != null) {
            return hVar.a();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService a() {
        return this.j;
    }

    public void a(Object obj) {
        C0103c cVar = this.f3793d.get();
        List<Object> list = cVar.f3796a;
        list.add(obj);
        if (!cVar.f3797b) {
            cVar.f3798c = e();
            cVar.f3797b = true;
            if (!cVar.f) {
                while (true) {
                    try {
                        if (!list.isEmpty()) {
                            a(list.remove(0), cVar);
                        } else {
                            return;
                        }
                    } finally {
                        cVar.f3797b = false;
                        cVar.f3798c = false;
                    }
                }
            } else {
                throw new e("Internal error. Abort state was not reset");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        Object obj = jVar.f3814a;
        q qVar = jVar.f3815b;
        j.a(jVar);
        if (qVar.f3839c) {
            a(qVar, obj);
        }
    }

    void a(q qVar, Object obj) {
        try {
            qVar.f3838b.f3822a.invoke(qVar.f3837a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(qVar, obj, e3.getCause());
        }
    }

    public g b() {
        return this.r;
    }

    public void b(Object obj) {
        List<o> a2 = this.i.a(obj.getClass());
        synchronized (this) {
            for (o oVar : a2) {
                a(obj, oVar);
            }
        }
    }

    public synchronized void c(Object obj) {
        List<Class<?>> list = this.f3791b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                a(obj, cls);
            }
            this.f3791b.remove(obj);
        } else {
            g gVar = this.r;
            Level level = Level.WARNING;
            gVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }
}
