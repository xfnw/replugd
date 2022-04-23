package a.d;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f96a;

    /* renamed from: b  reason: collision with root package name */
    private int f97b;

    /* renamed from: c  reason: collision with root package name */
    private int f98c;

    /* renamed from: d  reason: collision with root package name */
    private int f99d;

    /* renamed from: e  reason: collision with root package name */
    private int f100e;
    private int f;
    private int g;
    private int h;

    public e(int i) {
        if (i > 0) {
            this.f98c = i;
            this.f96a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int c(K k, V v) {
        int b2 = b(k, v);
        if (b2 >= 0) {
            return b2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected V a(K k) {
        return null;
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f99d++;
            this.f97b += c(k, v);
            put = this.f96a.put(k, v);
            if (put != null) {
                this.f97b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.f98c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5) {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            int r0 = r4.f97b     // Catch: all -> 0x0071
            if (r0 < 0) goto L_0x0052
            java.util.LinkedHashMap<K, V> r0 = r4.f96a     // Catch: all -> 0x0071
            boolean r0 = r0.isEmpty()     // Catch: all -> 0x0071
            if (r0 == 0) goto L_0x0011
            int r0 = r4.f97b     // Catch: all -> 0x0071
            if (r0 != 0) goto L_0x0052
        L_0x0011:
            int r0 = r4.f97b     // Catch: all -> 0x0071
            if (r0 <= r5) goto L_0x0050
            java.util.LinkedHashMap<K, V> r0 = r4.f96a     // Catch: all -> 0x0071
            boolean r0 = r0.isEmpty()     // Catch: all -> 0x0071
            if (r0 == 0) goto L_0x001e
            goto L_0x0050
        L_0x001e:
            java.util.LinkedHashMap<K, V> r0 = r4.f96a     // Catch: all -> 0x0071
            java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x0071
            java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x0071
            java.lang.Object r0 = r0.next()     // Catch: all -> 0x0071
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: all -> 0x0071
            java.lang.Object r1 = r0.getKey()     // Catch: all -> 0x0071
            java.lang.Object r0 = r0.getValue()     // Catch: all -> 0x0071
            java.util.LinkedHashMap<K, V> r2 = r4.f96a     // Catch: all -> 0x0071
            r2.remove(r1)     // Catch: all -> 0x0071
            int r2 = r4.f97b     // Catch: all -> 0x0071
            int r3 = r4.c(r1, r0)     // Catch: all -> 0x0071
            int r2 = r2 - r3
            r4.f97b = r2     // Catch: all -> 0x0071
            int r2 = r4.f     // Catch: all -> 0x0071
            r3 = 1
            int r2 = r2 + r3
            r4.f = r2     // Catch: all -> 0x0071
            monitor-exit(r4)     // Catch: all -> 0x0071
            r2 = 0
            r4.a(r3, r1, r0, r2)
            goto L_0x0000
        L_0x0050:
            monitor-exit(r4)     // Catch: all -> 0x0071
            return
        L_0x0052:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: all -> 0x0071
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: all -> 0x0071
            r0.<init>()     // Catch: all -> 0x0071
            java.lang.Class r1 = r4.getClass()     // Catch: all -> 0x0071
            java.lang.String r1 = r1.getName()     // Catch: all -> 0x0071
            r0.append(r1)     // Catch: all -> 0x0071
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: all -> 0x0071
            java.lang.String r0 = r0.toString()     // Catch: all -> 0x0071
            r5.<init>(r0)     // Catch: all -> 0x0071
            throw r5     // Catch: all -> 0x0071
        L_0x0071:
            r5 = move-exception
            monitor-exit(r4)     // Catch: all -> 0x0071
            goto L_0x0075
        L_0x0074:
            throw r5
        L_0x0075:
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.e.a(int):void");
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected int b(K k, V v) {
        return 1;
    }

    public final V b(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                V v = this.f96a.get(k);
                if (v != null) {
                    this.g++;
                    return v;
                }
                this.h++;
                V a2 = a((e<K, V>) k);
                if (a2 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f100e++;
                    put = this.f96a.put(k, a2);
                    if (put != null) {
                        this.f96a.put(k, put);
                    } else {
                        this.f97b += c(k, a2);
                    }
                }
                if (put != null) {
                    a(false, k, a2, put);
                    return put;
                }
                a(this.f98c);
                return a2;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized String toString() {
        int i;
        i = this.g + this.h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f98c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
    }
}
