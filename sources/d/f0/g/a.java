package d.f0.g;

import d.a0;
import d.f0.c;
import d.f0.d;
import d.l;
import d.m;
import d.r;
import d.t;
import d.u;
import d.y;
import d.z;
import e.j;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a  reason: collision with root package name */
    private final m f3468a;

    public a(m mVar) {
        this.f3468a = mVar;
    }

    private String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }

    @Override // d.t
    public a0 a(t.a aVar) {
        y b2 = aVar.b();
        y.a f = b2.f();
        z a2 = b2.a();
        if (a2 != null) {
            u b3 = a2.b();
            if (b3 == null) {
                long a3 = a2.a();
                if (a3 != -1) {
                    f.a("Content-Length", Long.toString(a3));
                    f.a("Transfer-Encoding");
                } else {
                    f.a("Transfer-Encoding", "chunked");
                    f.a("Content-Length");
                }
            } else {
                b3.toString();
                throw null;
            }
        }
        boolean z = false;
        if (b2.a("Host") == null) {
            f.a("Host", c.a(b2.g(), false));
        }
        if (b2.a("Connection") == null) {
            f.a("Connection", "Keep-Alive");
        }
        if (b2.a("Accept-Encoding") == null && b2.a("Range") == null) {
            z = true;
            f.a("Accept-Encoding", "gzip");
        }
        List<l> a4 = this.f3468a.a(b2.g());
        if (!a4.isEmpty()) {
            f.a("Cookie", a(a4));
        }
        if (b2.a("User-Agent") == null) {
            f.a("User-Agent", d.a());
        }
        a0 a5 = aVar.a(f.a());
        e.a(this.f3468a, b2.g(), a5.r());
        a0.a v = a5.v();
        v.a(b2);
        if (z && "gzip".equalsIgnoreCase(a5.b("Content-Encoding")) && e.b(a5)) {
            j jVar = new j(a5.m().n());
            r.a a6 = a5.r().a();
            a6.c("Content-Encoding");
            a6.c("Content-Length");
            v.a(a6.a());
            v.a(new h(a5.b("Content-Type"), -1L, e.l.a(jVar)));
        }
        return v.a();
    }
}
