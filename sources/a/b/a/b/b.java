package a.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    c<K, V> f70b;

    /* renamed from: c  reason: collision with root package name */
    private c<K, V> f71c;

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f72d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private int f73e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f77e;
        }

        @Override // a.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f76d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004b<K, V> extends e<K, V> {
        C0004b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f76d;
        }

        @Override // a.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f77e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final K f74b;

        /* renamed from: c  reason: collision with root package name */
        final V f75c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f76d;

        /* renamed from: e  reason: collision with root package name */
        c<K, V> f77e;

        c(K k, V v) {
            this.f74b = k;
            this.f75c = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f74b.equals(cVar.f74b) && this.f75c.equals(cVar.f75c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f74b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f75c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f74b.hashCode() ^ this.f75c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f74b + "=" + this.f75c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f78b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f79c = true;

        d() {
        }

        @Override // a.b.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f78b;
            if (cVar == cVar2) {
                this.f78b = cVar2.f77e;
                this.f79c = this.f78b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f79c) {
                return b.this.f70b != null;
            }
            c<K, V> cVar = this.f78b;
            return (cVar == null || cVar.f76d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f79c) {
                this.f79c = false;
                cVar = b.this.f70b;
            } else {
                c<K, V> cVar2 = this.f78b;
                cVar = cVar2 != null ? cVar2.f76d : null;
            }
            this.f78b = cVar;
            return this.f78b;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f81b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f82c;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f81b = cVar2;
            this.f82c = cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f82c;
            c<K, V> cVar2 = this.f81b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // a.b.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f81b == cVar && cVar == this.f82c) {
                this.f82c = null;
                this.f81b = null;
            }
            c<K, V> cVar2 = this.f81b;
            if (cVar2 == cVar) {
                this.f81b = b(cVar2);
            }
            if (this.f82c == cVar) {
                this.f82c = a();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f82c != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f82c;
            this.f82c = a();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f70b;
        while (cVar != null && !cVar.f74b.equals(k)) {
            cVar = cVar.f76d;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f73e++;
        c<K, V> cVar2 = this.f71c;
        if (cVar2 == null) {
            this.f70b = cVar;
            this.f71c = this.f70b;
            return cVar;
        }
        cVar2.f76d = cVar;
        cVar.f77e = cVar2;
        this.f71c = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0004b bVar = new C0004b(this.f71c, this.f70b);
        this.f72d.put(bVar, false);
        return bVar;
    }

    public V b(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f75c;
        }
        a(k, v);
        return null;
    }

    public Map.Entry<K, V> b() {
        return this.f70b;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f72d.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f71c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f70b, this.f71c);
        this.f72d.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f73e--;
        if (!this.f72d.isEmpty()) {
            for (f<K, V> fVar : this.f72d.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.f77e;
        if (cVar != null) {
            cVar.f76d = a2.f76d;
        } else {
            this.f70b = a2.f76d;
        }
        c<K, V> cVar2 = a2.f76d;
        if (cVar2 != null) {
            cVar2.f77e = a2.f77e;
        } else {
            this.f71c = a2.f77e;
        }
        a2.f76d = null;
        a2.f77e = null;
        return a2.f75c;
    }

    public int size() {
        return this.f73e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
