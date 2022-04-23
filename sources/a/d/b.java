package a.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] f = new int[0];
    private static final Object[] g = new Object[0];
    private static Object[] h;
    private static int i;
    private static Object[] j;
    private static int k;

    /* renamed from: b  reason: collision with root package name */
    private int[] f84b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f85c;

    /* renamed from: d  reason: collision with root package name */
    int f86d;

    /* renamed from: e  reason: collision with root package name */
    private f<E, E> f87e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // a.d.f
        protected int a(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.d.f
        protected Object a(int i, int i2) {
            return b.this.f85c[i];
        }

        @Override // a.d.f
        protected E a(int i, E e2) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.d.f
        protected void a() {
            b.this.clear();
        }

        @Override // a.d.f
        protected void a(int i) {
            b.this.b(i);
        }

        @Override // a.d.f
        protected void a(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // a.d.f
        protected int b(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.d.f
        protected Map<E, E> b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.d.f
        protected int c() {
            return b.this.f86d;
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f84b = f;
            this.f85c = g;
        } else {
            d(i2);
        }
        this.f86d = 0;
    }

    private int a(Object obj, int i2) {
        int i3 = this.f86d;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f84b, i3, i2);
        if (a2 < 0 || obj.equals(this.f85c[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f84b[i4] == i2) {
            if (obj.equals(this.f85c[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f84b[i5] == i2; i5--) {
            if (obj.equals(this.f85c[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    private f<E, E> a() {
        if (this.f87e == null) {
            this.f87e = new a();
        }
        return this.f87e;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        }
    }

    private int b() {
        int i2 = this.f86d;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f84b, i2, 0);
        if (a2 < 0 || this.f85c[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f84b[i3] == 0) {
            if (this.f85c[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f84b[i4] == 0; i4--) {
            if (this.f85c[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.f85c = objArr;
                    j = (Object[]) objArr[0];
                    this.f84b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (h != null) {
                    Object[] objArr2 = h;
                    this.f85c = objArr2;
                    h = (Object[]) objArr2[0];
                    this.f84b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    i--;
                    return;
                }
            }
        }
        this.f84b = new int[i2];
        this.f85c = new Object[i2];
    }

    public void a(int i2) {
        int[] iArr = this.f84b;
        if (iArr.length < i2) {
            Object[] objArr = this.f85c;
            d(i2);
            int i3 = this.f86d;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f84b, 0, i3);
                System.arraycopy(objArr, 0, this.f85c, 0, this.f86d);
            }
            a(iArr, objArr, this.f86d);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = b();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i3 = a(e2, hashCode);
            i2 = hashCode;
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ (-1);
        int i5 = this.f86d;
        if (i5 >= this.f84b.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f84b;
            Object[] objArr = this.f85c;
            d(i6);
            int[] iArr2 = this.f84b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f85c, 0, objArr.length);
            }
            a(iArr, objArr, this.f86d);
        }
        int i7 = this.f86d;
        if (i4 < i7) {
            int[] iArr3 = this.f84b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f85c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f86d - i4);
        }
        this.f84b[i4] = i2;
        this.f85c[i4] = e2;
        this.f86d++;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        a(this.f86d + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public E b(int i2) {
        Object[] objArr = this.f85c;
        E e2 = (E) objArr[i2];
        int i3 = this.f86d;
        if (i3 <= 1) {
            a(this.f84b, objArr, i3);
            this.f84b = f;
            this.f85c = g;
            this.f86d = 0;
        } else {
            int[] iArr = this.f84b;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                this.f86d--;
                int i5 = this.f86d;
                if (i2 < i5) {
                    int[] iArr2 = this.f84b;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr2 = this.f85c;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.f86d - i2);
                }
                this.f85c[this.f86d] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f84b;
                Object[] objArr3 = this.f85c;
                d(i4);
                this.f86d--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f84b, 0, i2);
                    System.arraycopy(objArr3, 0, this.f85c, 0, i2);
                }
                int i7 = this.f86d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f84b, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.f85c, i2, this.f86d - i2);
                }
            }
        }
        return e2;
    }

    public E c(int i2) {
        return (E) this.f85c[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f86d;
        if (i2 != 0) {
            a(this.f84b, this.f85c, i2);
            this.f84b = f;
            this.f85c = g;
            this.f86d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f86d; i2++) {
                try {
                    if (!set.contains(c(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f84b;
        int i2 = this.f86d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f86d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return a().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        b(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f86d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f85c[i2])) {
                b(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f86d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f86d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f85c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f86d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f86d));
        }
        System.arraycopy(this.f85c, 0, tArr, 0, this.f86d);
        int length = tArr.length;
        int i2 = this.f86d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f86d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f86d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
