package a.k.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final g<?> f405a;

    private f(g<?> gVar) {
        this.f405a = gVar;
    }

    public static f a(g<?> gVar) {
        return new f(gVar);
    }

    public c a(String str) {
        return this.f405a.f409d.b(str);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f405a.f409d.onCreateView(view, str, context, attributeSet);
    }

    public void a() {
        this.f405a.f409d.d();
    }

    public void a(c cVar) {
        g<?> gVar = this.f405a;
        gVar.f409d.a(gVar, gVar, cVar);
    }

    public void a(Configuration configuration) {
        this.f405a.f409d.a(configuration);
    }

    public void a(Parcelable parcelable, j jVar) {
        this.f405a.f409d.a(parcelable, jVar);
    }

    public void a(Menu menu) {
        this.f405a.f409d.a(menu);
    }

    public void a(boolean z) {
        this.f405a.f409d.a(z);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f405a.f409d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f405a.f409d.a(menuItem);
    }

    public void b() {
        this.f405a.f409d.e();
    }

    public void b(boolean z) {
        this.f405a.f409d.b(z);
    }

    public boolean b(Menu menu) {
        return this.f405a.f409d.b(menu);
    }

    public boolean b(MenuItem menuItem) {
        return this.f405a.f409d.b(menuItem);
    }

    public void c() {
        this.f405a.f409d.f();
    }

    public void d() {
        this.f405a.f409d.h();
    }

    public void e() {
        this.f405a.f409d.i();
    }

    public void f() {
        this.f405a.f409d.j();
    }

    public void g() {
        this.f405a.f409d.k();
    }

    public void h() {
        this.f405a.f409d.l();
    }

    public boolean i() {
        return this.f405a.f409d.n();
    }

    public h j() {
        return this.f405a.d();
    }

    public void k() {
        this.f405a.f409d.q();
    }

    public j l() {
        return this.f405a.f409d.s();
    }

    public Parcelable m() {
        return this.f405a.f409d.t();
    }
}
