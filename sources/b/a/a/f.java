package b.a.a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class f extends i {

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f1613b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    /* renamed from: c  reason: collision with root package name */
    private static final SimpleDateFormat f1614c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

    /* renamed from: a  reason: collision with root package name */
    private Date f1615a;

    static {
        f1613b.setTimeZone(TimeZone.getTimeZone("GMT"));
        f1614c.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public f(Date date) {
        if (date != null) {
            this.f1615a = date;
            return;
        }
        throw new IllegalArgumentException("Date cannot be null");
    }

    public f(byte[] bArr, int i, int i2) {
        this.f1615a = new Date(((long) (b.c(bArr, i, i2) * 1000.0d)) + 978307200000L);
    }

    public Date a() {
        return this.f1615a;
    }

    @Override // b.a.a.i
    public void b(c cVar) {
        cVar.a(51);
        double time = this.f1615a.getTime() - 978307200000L;
        Double.isNaN(time);
        cVar.a(time / 1000.0d);
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(f.class) && this.f1615a.equals(((f) obj).a());
    }

    public int hashCode() {
        return this.f1615a.hashCode();
    }

    public String toString() {
        return this.f1615a.toString();
    }
}
