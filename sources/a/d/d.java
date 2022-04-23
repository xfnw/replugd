package a.d;

/* loaded from: classes.dex */
public class d<E> implements Cloneable {
    private static final Object f = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f92b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f93c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f94d;

    /* renamed from: e  reason: collision with root package name */
    private int f95e;

    public d() {
        this(10);
    }

    public d(int i) {
        this.f92b = false;
        if (i == 0) {
            this.f93c = c.f90b;
            this.f94d = c.f91c;
        } else {
            int c2 = c.c(i);
            this.f93c = new long[c2];
            this.f94d = new Object[c2];
        }
        this.f95e = 0;
    }

    private void c() {
        int i = this.f95e;
        long[] jArr = this.f93c;
        Object[] objArr = this.f94d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f92b = false;
        this.f95e = i2;
    }

    public long a(int i) {
        if (this.f92b) {
            c();
        }
        return this.f93c[i];
    }

    public void a() {
        int i = this.f95e;
        Object[] objArr = this.f94d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f95e = 0;
        this.f92b = false;
    }

    public void a(long j, E e2) {
        int i = this.f95e;
        if (i == 0 || j > this.f93c[i - 1]) {
            if (this.f92b && this.f95e >= this.f93c.length) {
                c();
            }
            int i2 = this.f95e;
            if (i2 >= this.f93c.length) {
                int c2 = c.c(i2 + 1);
                long[] jArr = new long[c2];
                Object[] objArr = new Object[c2];
                long[] jArr2 = this.f93c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f94d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f93c = jArr;
                this.f94d = objArr;
            }
            this.f93c[i2] = j;
            this.f94d[i2] = e2;
            this.f95e = i2 + 1;
            return;
        }
        c(j, e2);
    }

    public boolean a(long j) {
        return d(j) >= 0;
    }

    public int b() {
        if (this.f92b) {
            c();
        }
        return this.f95e;
    }

    public E b(long j, E e2) {
        int a2 = c.a(this.f93c, this.f95e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f94d;
            if (objArr[a2] != f) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public void b(int i) {
        Object[] objArr = this.f94d;
        Object obj = objArr[i];
        Object obj2 = f;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f92b = true;
        }
    }

    public void b(long j) {
        int a2 = c.a(this.f93c, this.f95e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f94d;
            Object obj = objArr[a2];
            Object obj2 = f;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f92b = true;
            }
        }
    }

    public E c(int i) {
        if (this.f92b) {
            c();
        }
        return (E) this.f94d[i];
    }

    public E c(long j) {
        return b(j, null);
    }

    public void c(long j, E e2) {
        int a2 = c.a(this.f93c, this.f95e, j);
        if (a2 >= 0) {
            this.f94d[a2] = e2;
            return;
        }
        int i = a2 ^ (-1);
        if (i < this.f95e) {
            Object[] objArr = this.f94d;
            if (objArr[i] == f) {
                this.f93c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f92b && this.f95e >= this.f93c.length) {
            c();
            i = c.a(this.f93c, this.f95e, j) ^ (-1);
        }
        int i2 = this.f95e;
        if (i2 >= this.f93c.length) {
            int c2 = c.c(i2 + 1);
            long[] jArr = new long[c2];
            Object[] objArr2 = new Object[c2];
            long[] jArr2 = this.f93c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f94d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f93c = jArr;
            this.f94d = objArr2;
        }
        int i3 = this.f95e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f93c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f94d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f95e - i);
        }
        this.f93c[i] = j;
        this.f94d[i] = e2;
        this.f95e++;
    }

    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f93c = (long[]) this.f93c.clone();
            dVar.f94d = (Object[]) this.f94d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int d(long j) {
        if (this.f92b) {
            c();
        }
        return c.a(this.f93c, this.f95e, j);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f95e * 28);
        sb.append('{');
        for (int i = 0; i < this.f95e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
