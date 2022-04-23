package b.c.b;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f1779a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1780b;

    /* renamed from: c  reason: collision with root package name */
    private o[] f1781c;

    /* renamed from: d  reason: collision with root package name */
    private final a f1782d;

    /* renamed from: e  reason: collision with root package name */
    private Map<n, Object> f1783e;

    public m(String str, byte[] bArr, int i, o[] oVarArr, a aVar, long j) {
        this.f1779a = str;
        this.f1780b = bArr;
        this.f1781c = oVarArr;
        this.f1782d = aVar;
        this.f1783e = null;
    }

    public m(String str, byte[] bArr, o[] oVarArr, a aVar) {
        this(str, bArr, oVarArr, aVar, System.currentTimeMillis());
    }

    public m(String str, byte[] bArr, o[] oVarArr, a aVar, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, oVarArr, aVar, j);
    }

    public a a() {
        return this.f1782d;
    }

    public void a(n nVar, Object obj) {
        if (this.f1783e == null) {
            this.f1783e = new EnumMap(n.class);
        }
        this.f1783e.put(nVar, obj);
    }

    public void a(Map<n, Object> map) {
        if (map != null) {
            Map<n, Object> map2 = this.f1783e;
            if (map2 == null) {
                this.f1783e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void a(o[] oVarArr) {
        o[] oVarArr2 = this.f1781c;
        if (oVarArr2 == null) {
            this.f1781c = oVarArr;
        } else if (oVarArr != null && oVarArr.length > 0) {
            o[] oVarArr3 = new o[oVarArr2.length + oVarArr.length];
            System.arraycopy(oVarArr2, 0, oVarArr3, 0, oVarArr2.length);
            System.arraycopy(oVarArr, 0, oVarArr3, oVarArr2.length, oVarArr.length);
            this.f1781c = oVarArr3;
        }
    }

    public byte[] b() {
        return this.f1780b;
    }

    public Map<n, Object> c() {
        return this.f1783e;
    }

    public o[] d() {
        return this.f1781c;
    }

    public String e() {
        return this.f1779a;
    }

    public String toString() {
        return this.f1779a;
    }
}
