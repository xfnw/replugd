package b.a.a;

/* loaded from: classes.dex */
public class h extends i implements Comparable<Object> {

    /* renamed from: b  reason: collision with root package name */
    private int f1617b;

    /* renamed from: c  reason: collision with root package name */
    private long f1618c;

    /* renamed from: d  reason: collision with root package name */
    private double f1619d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1620e;

    public h(double d2) {
        this.f1619d = d2;
        this.f1618c = (long) d2;
        this.f1617b = 1;
    }

    public h(long j) {
        this.f1618c = j;
        this.f1619d = j;
        this.f1617b = 0;
    }

    public h(boolean z) {
        this.f1620e = z;
        long j = z ? 1L : 0L;
        this.f1618c = j;
        this.f1619d = j;
        this.f1617b = 2;
    }

    public h(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            long d2 = b.d(bArr, i, i2);
            this.f1618c = d2;
            this.f1619d = d2;
        } else if (i3 == 1) {
            this.f1619d = b.c(bArr, i, i2);
            this.f1618c = Math.round(this.f1619d);
        } else {
            throw new IllegalArgumentException("Type argument is not valid.");
        }
        this.f1617b = i3;
    }

    public boolean a() {
        return this.f1617b == 2 ? this.f1620e : this.f1618c != 0;
    }

    public double b() {
        return this.f1619d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void b(c cVar) {
        long d2;
        int e2 = e();
        int i = 1;
        int i2 = 8;
        if (e2 == 0) {
            if (d() >= 0) {
                if (d() <= 255) {
                    cVar.a(16);
                    d2 = d();
                } else if (d() <= 65535) {
                    cVar.a(17);
                    cVar.a(d(), 2);
                    return;
                } else if (d() <= 4294967295L) {
                    cVar.a(18);
                    d2 = d();
                    i = 4;
                }
                cVar.a(d2, i);
                return;
            }
            cVar.a(19);
            cVar.a(d(), 8);
        } else if (e2 == 1) {
            cVar.a(35);
            cVar.a(b());
        } else if (e2 == 2) {
            if (a()) {
                i2 = 9;
            }
            cVar.a(i2);
        }
    }

    public int c() {
        return (int) this.f1618c;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        double b2 = b();
        if (obj instanceof h) {
            double b3 = ((h) obj).b();
            if (b2 < b3) {
                return -1;
            }
            return b2 == b3 ? 0 : 1;
        } else if (!(obj instanceof Number)) {
            return -1;
        } else {
            double doubleValue = ((Number) obj).doubleValue();
            if (b2 < doubleValue) {
                return -1;
            }
            return b2 == doubleValue ? 0 : 1;
        }
    }

    public long d() {
        return this.f1618c;
    }

    public int e() {
        return this.f1617b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1617b == hVar.f1617b && this.f1618c == hVar.f1618c && this.f1619d == hVar.f1619d && this.f1620e == hVar.f1620e;
    }

    public int hashCode() {
        long j = this.f1618c;
        return (((((this.f1617b * 37) + ((int) (j ^ (j >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.f1619d) ^ (Double.doubleToLongBits(this.f1619d) >>> 32)))) * 37) + (a() ? 1 : 0);
    }

    public String toString() {
        int i = this.f1617b;
        return i != 0 ? i != 1 ? i != 2 ? super.toString() : String.valueOf(a()) : String.valueOf(b()) : String.valueOf(d());
    }
}
