package a.g.i;

import a.g.k.h;
import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f228a;

    /* renamed from: b  reason: collision with root package name */
    private final String f229b;

    /* renamed from: c  reason: collision with root package name */
    private final String f230c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f231d;

    /* renamed from: e  reason: collision with root package name */
    private final int f232e = 0;
    private final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        h.a(str);
        this.f228a = str;
        h.a(str2);
        this.f229b = str2;
        h.a(str3);
        this.f230c = str3;
        h.a(list);
        this.f231d = list;
        this.f = this.f228a + "-" + this.f229b + "-" + this.f230c;
    }

    public List<List<byte[]>> a() {
        return this.f231d;
    }

    public int b() {
        return this.f232e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.f228a;
    }

    public String e() {
        return this.f229b;
    }

    public String f() {
        return this.f230c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f228a + ", mProviderPackage: " + this.f229b + ", mQuery: " + this.f230c + ", mCertificates:");
        for (int i = 0; i < this.f231d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f231d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f232e);
        return sb.toString();
    }
}
