package b.c.b.r;

import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f1823a;

    /* renamed from: b  reason: collision with root package name */
    private int f1824b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1825c;

    /* renamed from: d  reason: collision with root package name */
    private final List<byte[]> f1826d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1827e;
    private Object f;
    private final int g;
    private final int h;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f1823a = bArr;
        this.f1824b = bArr == null ? 0 : bArr.length * 8;
        this.f1825c = str;
        this.f1826d = list;
        this.f1827e = str2;
        this.g = i2;
        this.h = i;
    }

    public List<byte[]> a() {
        return this.f1826d;
    }

    public void a(int i) {
        this.f1824b = i;
    }

    public void a(Integer num) {
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public String b() {
        return this.f1827e;
    }

    public void b(Integer num) {
    }

    public int c() {
        return this.f1824b;
    }

    public Object d() {
        return this.f;
    }

    public byte[] e() {
        return this.f1823a;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public String h() {
        return this.f1825c;
    }

    public boolean i() {
        return this.g >= 0 && this.h >= 0;
    }
}
