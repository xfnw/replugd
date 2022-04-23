package d;

import d.f0.m.c;
import e.f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final g f3638c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f3639a;

    /* renamed from: b  reason: collision with root package name */
    private final c f3640b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f3641a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f3641a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f3642a;

        /* renamed from: b  reason: collision with root package name */
        final String f3643b;

        /* renamed from: c  reason: collision with root package name */
        final String f3644c;

        /* renamed from: d  reason: collision with root package name */
        final f f3645d;

        boolean a(String str) {
            if (!this.f3642a.startsWith("*.")) {
                return str.equals(this.f3643b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f3643b.length()) {
                String str2 = this.f3643b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f3642a.equals(bVar.f3642a) && this.f3644c.equals(bVar.f3644c) && this.f3645d.equals(bVar.f3645d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f3642a.hashCode()) * 31) + this.f3644c.hashCode()) * 31) + this.f3645d.hashCode();
        }

        public String toString() {
            return this.f3644c + this.f3645d.a();
        }
    }

    g(Set<b> set, c cVar) {
        this.f3639a = set;
        this.f3640b = cVar;
    }

    static f a(X509Certificate x509Certificate) {
        return f.a(x509Certificate.getPublicKey().getEncoded()).e();
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static f b(X509Certificate x509Certificate) {
        return f.a(x509Certificate.getPublicKey().getEncoded()).f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(c cVar) {
        return d.f0.c.a(this.f3640b, cVar) ? this : new g(this.f3639a, cVar);
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f3639a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public void a(String str, List<Certificate> list) {
        List<b> a2 = a(str);
        if (!a2.isEmpty()) {
            c cVar = this.f3640b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a2.size();
                f fVar = null;
                f fVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = a2.get(i2);
                    if (bVar.f3644c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = b(x509Certificate);
                        }
                        if (bVar.f3645d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f3644c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = a(x509Certificate);
                        }
                        if (bVar.f3645d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f3644c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a2.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (d.f0.c.a(this.f3640b, gVar.f3640b) && this.f3639a.equals(gVar.f3639a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        c cVar = this.f3640b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f3639a.hashCode();
    }
}
