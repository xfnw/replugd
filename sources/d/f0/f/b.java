package d.f0.f;

import d.f0.a;
import d.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f3444a;

    /* renamed from: b  reason: collision with root package name */
    private int f3445b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3446c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3447d;

    public b(List<k> list) {
        this.f3444a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f3445b; i < this.f3444a.size(); i++) {
            if (this.f3444a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) {
        k kVar;
        int i = this.f3445b;
        int size = this.f3444a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f3444a.get(i);
            i++;
            if (kVar.a(sSLSocket)) {
                this.f3445b = i;
                break;
            }
        }
        if (kVar != null) {
            this.f3446c = b(sSLSocket);
            a.f3401a.a(kVar, sSLSocket, this.f3447d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f3447d + ", modes=" + this.f3444a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f3447d = true;
        if (!this.f3446c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((!z || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
        }
        return false;
    }
}
