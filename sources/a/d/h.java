package a.d;

/* loaded from: classes.dex */
public class h<E> implements Cloneable {
    private static final Object f = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f119b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f120c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f121d;

    /* renamed from: e  reason: collision with root package name */
    private int f122e;

    public h() {
        this(10);
    }

    public h(int i) {
        this.f119b = false;
        if (i == 0) {
            this.f120c = c.f89a;
            this.f121d = c.f91c;
        } else {
            int b2 = c.b(i);
            this.f120c = new int[b2];
            this.f121d = new Object[b2];
        }
        this.f122e = 0;
    }

    private void c() {
        int i = this.f122e;
        int[] iArr = this.f120c;
        Object[] objArr = this.f121d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f119b = false;
        this.f122e = i2;
    }

    public void a() {
        int i = this.f122e;
        Object[] objArr = this.f121d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f122e = 0;
        this.f119b = false;
    }

    public void a(int i) {
        int a2 = c.a(this.f120c, this.f122e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f121d;
            Object obj = objArr[a2];
            Object obj2 = f;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f119b = true;
            }
        }
    }

    public void a(int i, E e2) {
        int i2 = this.f122e;
        if (i2 == 0 || i > this.f120c[i2 - 1]) {
            if (this.f119b && this.f122e >= this.f120c.length) {
                c();
            }
            int i3 = this.f122e;
            if (i3 >= this.f120c.length) {
                int b2 = c.b(i3 + 1);
                int[] iArr = new int[b2];
                Object[] objArr = new Object[b2];
                int[] iArr2 = this.f120c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f121d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f120c = iArr;
                this.f121d = objArr;
            }
            this.f120c[i3] = i;
            this.f121d[i3] = e2;
            this.f122e = i3 + 1;
            return;
        }
        c(i, e2);
    }

    public int b() {
        if (this.f119b) {
            c();
        }
        return this.f122e;
    }

    public E b(int i) {
        return b(i, null);
    }

    public E b(int i, E e2) {
        int a2 = c.a(this.f120c, this.f122e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f121d;
            if (objArr[a2] != f) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public int c(int i) {
        if (this.f119b) {
            c();
        }
        return this.f120c[i];
    }

    public void c(int i, E e2) {
        int a2 = c.a(this.f120c, this.f122e, i);
        if (a2 >= 0) {
            this.f121d[a2] = e2;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.f122e) {
            Object[] objArr = this.f121d;
            if (objArr[i2] == f) {
                this.f120c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f119b && this.f122e >= this.f120c.length) {
            c();
            i2 = c.a(this.f120c, this.f122e, i) ^ (-1);
        }
        int i3 = this.f122e;
        if (i3 >= this.f120c.length) {
            int b2 = c.b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.f120c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f121d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f120c = iArr;
            this.f121d = objArr2;
        }
        int i4 = this.f122e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f120c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f121d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f122e - i2);
        }
        this.f120c[i2] = i;
        this.f121d[i2] = e2;
        this.f122e++;
    }

    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f120c = (int[]) this.f120c.clone();
            hVar.f121d = (Object[]) this.f121d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public void d(int i) {
        a(i);
    }

    public E e(int i) {
        if (this.f119b) {
            c();
        }
        return (E) this.f121d[i];
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f122e * 28);
        sb.append('{');
        for (int i = 0; i < this.f122e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c(i));
            sb.append('=');
            E e2 = e(i);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
