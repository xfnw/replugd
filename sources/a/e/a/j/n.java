package a.e.a.j;

/* loaded from: classes.dex */
public class n extends o {

    /* renamed from: c  reason: collision with root package name */
    float f200c = 0.0f;

    public void a(int i) {
        if (this.f202b == 0 || this.f200c != i) {
            this.f200c = i;
            if (this.f202b == 1) {
                b();
            }
            a();
        }
    }

    @Override // a.e.a.j.o
    public void d() {
        super.d();
        this.f200c = 0.0f;
    }

    public void f() {
        this.f202b = 2;
    }
}
