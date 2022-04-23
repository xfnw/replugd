package a.p;

import a.g.l.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static m f590a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<a.d.a<ViewGroup, ArrayList<m>>>> f591b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f592c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        m f593b;

        /* renamed from: c  reason: collision with root package name */
        ViewGroup f594c;

        /* renamed from: a.p.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0027a extends n {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a.d.a f595b;

            C0027a(a.d.a aVar) {
                this.f595b = aVar;
            }

            @Override // a.p.m.f
            public void d(m mVar) {
                ((ArrayList) this.f595b.get(a.this.f594c)).remove(mVar);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f593b = mVar;
            this.f594c = viewGroup;
        }

        private void a() {
            this.f594c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f594c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f592c.remove(this.f594c)) {
                return true;
            }
            a.d.a<ViewGroup, ArrayList<m>> a2 = o.a();
            ArrayList<m> arrayList = a2.get(this.f594c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                a2.put(this.f594c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f593b);
            this.f593b.a(new C0027a(a2));
            this.f593b.a(this.f594c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).e(this.f594c);
                }
            }
            this.f593b.a(this.f594c);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f592c.remove(this.f594c);
            ArrayList<m> arrayList = o.a().get(this.f594c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f594c);
                }
            }
            this.f593b.a(true);
        }
    }

    static a.d.a<ViewGroup, ArrayList<m>> a() {
        a.d.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<a.d.a<ViewGroup, ArrayList<m>>> weakReference = f591b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        a.d.a<ViewGroup, ArrayList<m>> aVar2 = new a.d.a<>();
        f591b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (!f592c.contains(viewGroup) && s.w(viewGroup)) {
            f592c.add(viewGroup);
            if (mVar == null) {
                mVar = f590a;
            }
            m clone = mVar.clone();
            c(viewGroup, clone);
            l.a(viewGroup, null);
            b(viewGroup, clone);
        }
    }

    private static void b(ViewGroup viewGroup, m mVar) {
        if (mVar != null && viewGroup != null) {
            a aVar = new a(mVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.a(viewGroup, true);
        }
        l a2 = l.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }
}
