package a.e.a.j;

import a.e.a.j.e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f203a;

    /* renamed from: b  reason: collision with root package name */
    private int f204b;

    /* renamed from: c  reason: collision with root package name */
    private int f205c;

    /* renamed from: d  reason: collision with root package name */
    private int f206d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<a> f207e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f208a;

        /* renamed from: b  reason: collision with root package name */
        private e f209b;

        /* renamed from: c  reason: collision with root package name */
        private int f210c;

        /* renamed from: d  reason: collision with root package name */
        private e.c f211d;

        /* renamed from: e  reason: collision with root package name */
        private int f212e;

        public a(e eVar) {
            this.f208a = eVar;
            this.f209b = eVar.g();
            this.f210c = eVar.b();
            this.f211d = eVar.f();
            this.f212e = eVar.a();
        }

        public void a(f fVar) {
            fVar.a(this.f208a.h()).a(this.f209b, this.f210c, this.f211d, this.f212e);
        }

        public void b(f fVar) {
            int i;
            this.f208a = fVar.a(this.f208a.h());
            e eVar = this.f208a;
            if (eVar != null) {
                this.f209b = eVar.g();
                this.f210c = this.f208a.b();
                this.f211d = this.f208a.f();
                i = this.f208a.a();
            } else {
                this.f209b = null;
                i = 0;
                this.f210c = 0;
                this.f211d = e.c.STRONG;
            }
            this.f212e = i;
        }
    }

    public p(f fVar) {
        this.f203a = fVar.v();
        this.f204b = fVar.w();
        this.f205c = fVar.s();
        this.f206d = fVar.i();
        ArrayList<e> b2 = fVar.b();
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            this.f207e.add(new a(b2.get(i)));
        }
    }

    public void a(f fVar) {
        fVar.r(this.f203a);
        fVar.s(this.f204b);
        fVar.o(this.f205c);
        fVar.g(this.f206d);
        int size = this.f207e.size();
        for (int i = 0; i < size; i++) {
            this.f207e.get(i).a(fVar);
        }
    }

    public void b(f fVar) {
        this.f203a = fVar.v();
        this.f204b = fVar.w();
        this.f205c = fVar.s();
        this.f206d = fVar.i();
        int size = this.f207e.size();
        for (int i = 0; i < size; i++) {
            this.f207e.get(i).b(fVar);
        }
    }
}
