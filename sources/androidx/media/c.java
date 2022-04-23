package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f1301a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f1302b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f1303c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f1304d = -1;

    public int a() {
        return this.f1302b;
    }

    public int b() {
        int i = this.f1303c;
        int c2 = c();
        if (c2 == 6) {
            i |= 4;
        } else if (c2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int c() {
        int i = this.f1304d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.f1303c, this.f1301a);
    }

    public int d() {
        return this.f1301a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1302b == cVar.a() && this.f1303c == cVar.b() && this.f1301a == cVar.d() && this.f1304d == cVar.f1304d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1302b), Integer.valueOf(this.f1303c), Integer.valueOf(this.f1301a), Integer.valueOf(this.f1304d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1304d != -1) {
            sb.append(" stream=");
            sb.append(this.f1304d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f1301a));
        sb.append(" content=");
        sb.append(this.f1302b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1303c).toUpperCase());
        return sb.toString();
    }
}
