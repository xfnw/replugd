package b.b.a.k;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f1681a;

    /* renamed from: b  reason: collision with root package name */
    private String f1682b;

    /* renamed from: c  reason: collision with root package name */
    private int f1683c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1684d;

    /* renamed from: e  reason: collision with root package name */
    private int f1685e;
    private long f;

    public a(String str) {
        this.f1683c = 8121;
        this.f1682b = str;
    }

    public a(String str, String str2, String str3, String str4, String str5) {
        this.f1683c = 8121;
        this.f1681a = str;
        this.f1682b = str2;
        try {
            this.f1683c = Integer.valueOf(str3).intValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        try {
            Integer.valueOf(str4).intValue();
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
        }
        this.f1684d = false;
        this.f1685e = 10;
        try {
            int intValue = (Integer.valueOf(str5.replace("sn=0x", ""), 16).intValue() >> 9) & 1;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public String a() {
        return this.f1682b;
    }

    public void a(int i) {
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        try {
            int intValue = (Integer.valueOf(str.replace("sn=0x", ""), 16).intValue() >> 9) & 1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String b() {
        return this.f1681a;
    }

    public void b(String str) {
        this.f1681a = str;
    }

    public long c() {
        return this.f;
    }

    public int d() {
        return this.f1683c;
    }

    public boolean e() {
        return this.f1684d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f1682b;
        if (str == null) {
            if (aVar.f1682b != null) {
                return false;
            }
        } else if (!str.equals(aVar.f1682b)) {
            return false;
        }
        String str2 = this.f1681a;
        String str3 = aVar.f1681a;
        if (str2 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str2.equals(str3)) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        return this.f1685e == 10;
    }

    public final int hashCode() {
        String str = this.f1682b;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f1681a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Device <" + this.f1681a + " - " + this.f1682b + " - " + this.f1685e + ">";
    }
}
