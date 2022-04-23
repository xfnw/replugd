package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: d  reason: collision with root package name */
    private static final List<j> f3813d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f3814a;

    /* renamed from: b  reason: collision with root package name */
    q f3815b;

    /* renamed from: c  reason: collision with root package name */
    j f3816c;

    private j(Object obj, q qVar) {
        this.f3814a = obj;
        this.f3815b = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(q qVar, Object obj) {
        synchronized (f3813d) {
            int size = f3813d.size();
            if (size <= 0) {
                return new j(obj, qVar);
            }
            j remove = f3813d.remove(size - 1);
            remove.f3814a = obj;
            remove.f3815b = qVar;
            remove.f3816c = null;
            return remove;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        jVar.f3814a = null;
        jVar.f3815b = null;
        jVar.f3816c = null;
        synchronized (f3813d) {
            if (f3813d.size() < 10000) {
                f3813d.add(jVar);
            }
        }
    }
}
