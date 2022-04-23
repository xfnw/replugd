package d;

import java.io.IOException;

/* loaded from: classes.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: b  reason: collision with root package name */
    private final String f3708b;

    w(String str) {
        this.f3708b = str;
    }

    public static w a(String str) {
        if (str.equals(HTTP_1_0.f3708b)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f3708b)) {
            return HTTP_1_1;
        }
        if (str.equals(H2_PRIOR_KNOWLEDGE.f3708b)) {
            return H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(HTTP_2.f3708b)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f3708b)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.f3708b)) {
            return QUIC;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f3708b;
    }
}
