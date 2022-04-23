package a.p;

import a.p.m;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class q extends m {
    int M;
    private ArrayList<m> K = new ArrayList<>();
    private boolean L = true;
    boolean N = false;
    private int O = 0;

    /* loaded from: classes.dex */
    class a extends n {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f597b;

        a(q qVar, m mVar) {
            this.f597b = mVar;
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            this.f597b.o();
            mVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends n {

        /* renamed from: b  reason: collision with root package name */
        q f598b;

        b(q qVar) {
            this.f598b = qVar;
        }

        @Override // a.p.n, a.p.m.f
        public void c(m mVar) {
            q qVar = this.f598b;
            if (!qVar.N) {
                qVar.p();
                this.f598b.N = true;
            }
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            q qVar = this.f598b;
            qVar.M--;
            if (qVar.M == 0) {
                qVar.N = false;
                qVar.a();
            }
            mVar.b(this);
        }
    }

    private void r() {
        b bVar = new b(this);
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.M = this.K.size();
    }

    public m a(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    @Override // a.p.m
    public q a(long j) {
        super.a(j);
        if (this.f580d >= 0) {
            int size = this.K.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(j);
            }
        }
        return this;
    }

    @Override // a.p.m
    public q a(m.f fVar) {
        super.a(fVar);
        return this;
    }

    public q a(m mVar) {
        this.K.add(mVar);
        mVar.s = this;
        long j = this.f580d;
        if (j >= 0) {
            mVar.a(j);
        }
        if ((this.O & 1) != 0) {
            mVar.a(d());
        }
        if ((this.O & 2) != 0) {
            mVar.a(g());
        }
        if ((this.O & 4) != 0) {
            mVar.a(f());
        }
        if ((this.O & 8) != 0) {
            mVar.a(c());
        }
        return this;
    }

    @Override // a.p.m
    public q a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<m> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    @Override // a.p.m
    public q a(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(view);
        }
        super.a(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.p.m
    public String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.K.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }

    @Override // a.p.m
    public void a(g gVar) {
        super.a(gVar);
        this.O |= 4;
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(gVar);
        }
    }

    @Override // a.p.m
    public void a(m.e eVar) {
        super.a(eVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(eVar);
        }
    }

    @Override // a.p.m
    public void a(p pVar) {
        super.a(pVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(pVar);
        }
    }

    @Override // a.p.m
    public void a(s sVar) {
        if (b(sVar.f603b)) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.b(sVar.f603b)) {
                    next.a(sVar);
                    sVar.f604c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.p.m
    public void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long h = h();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.K.get(i);
            if (h > 0 && (this.L || i == 0)) {
                long h2 = mVar.h();
                if (h2 > 0) {
                    mVar.b(h2 + h);
                } else {
                    mVar.b(h);
                }
            }
            mVar.a(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    public q b(int i) {
        if (i == 0) {
            this.L = true;
        } else if (i == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    @Override // a.p.m
    public q b(long j) {
        super.b(j);
        return this;
    }

    @Override // a.p.m
    public q b(m.f fVar) {
        super.b(fVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.p.m
    public void b(s sVar) {
        super.b(sVar);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).b(sVar);
        }
    }

    @Override // a.p.m
    public void c(s sVar) {
        if (b(sVar.f603b)) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.b(sVar.f603b)) {
                    next.c(sVar);
                    sVar.f604c.add(next);
                }
            }
        }
    }

    @Override // a.p.m
    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).c(view);
        }
    }

    @Override // a.p.m
    public m clone() {
        q qVar = (q) super.clone();
        qVar.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            qVar.a(this.K.get(i).clone());
        }
        return qVar;
    }

    @Override // a.p.m
    public q d(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).d(view);
        }
        super.d(view);
        return this;
    }

    @Override // a.p.m
    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).e(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.p.m
    public void o() {
        if (this.K.isEmpty()) {
            p();
            a();
            return;
        }
        r();
        if (!this.L) {
            for (int i = 1; i < this.K.size(); i++) {
                this.K.get(i - 1).a(new a(this, this.K.get(i)));
            }
            m mVar = this.K.get(0);
            if (mVar != null) {
                mVar.o();
                return;
            }
            return;
        }
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public int q() {
        return this.K.size();
    }
}
