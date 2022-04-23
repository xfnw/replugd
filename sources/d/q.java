package d;

import d.f0.c;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final d0 f3680a;

    /* renamed from: b  reason: collision with root package name */
    private final h f3681b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f3682c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f3683d;

    private q(d0 d0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f3680a = d0Var;
        this.f3681b = hVar;
        this.f3682c = list;
        this.f3683d = list2;
    }

    public static q a(d0 d0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        if (d0Var == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (hVar != null) {
            return new q(d0Var, hVar, c.a(list), c.a(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public static q a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            h a2 = h.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                d0 a3 = d0.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List a4 = certificateArr != null ? c.a(certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new q(a3, a2, a4, localCertificates != null ? c.a(localCertificates) : Collections.emptyList());
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public h a() {
        return this.f3681b;
    }

    public List<Certificate> b() {
        return this.f3683d;
    }

    public List<Certificate> c() {
        return this.f3682c;
    }

    public d0 d() {
        return this.f3680a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f3680a.equals(qVar.f3680a) && this.f3681b.equals(qVar.f3681b) && this.f3682c.equals(qVar.f3682c) && this.f3683d.equals(qVar.f3683d);
    }

    public int hashCode() {
        return ((((((527 + this.f3680a.hashCode()) * 31) + this.f3681b.hashCode()) * 31) + this.f3682c.hashCode()) * 31) + this.f3683d.hashCode();
    }
}
