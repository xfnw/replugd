package b.c.b.v.r.g.e;

import b.c.b.f;
import b.c.b.r.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f1973a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1974b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f1975c = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(a aVar) {
        this.f1973a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private l a() {
        while (g(this.f1974b.a())) {
            n a2 = a(this.f1974b.a());
            this.f1974b.b(a2.a());
            if (a2.c()) {
                return new l(new o(this.f1974b.a(), this.f1975c.toString()), true);
            }
            this.f1975c.append(a2.b());
        }
        if (d(this.f1974b.a())) {
            this.f1974b.a(3);
            this.f1974b.f();
        } else if (e(this.f1974b.a())) {
            if (this.f1974b.a() + 5 < this.f1973a.c()) {
                this.f1974b.a(5);
            } else {
                this.f1974b.b(this.f1973a.c());
            }
            this.f1974b.e();
        }
        return new l(false);
    }

    private n a(int i) {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 6);
        if (a3 >= 32 && a3 < 58) {
            return new n(i + 6, (char) (a3 + 33));
        }
        switch (a3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(a3)));
        }
        return new n(i + 6, c2);
    }

    private n b(int i) {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 7);
        if (a3 >= 64 && a3 < 90) {
            return new n(i + 7, (char) (a3 + 1));
        }
        if (a3 >= 90 && a3 < 116) {
            return new n(i + 7, (char) (a3 + 7));
        }
        switch (a(i, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw f.a();
        }
        return new n(i + 8, c2);
    }

    private o b() {
        l a2;
        boolean b2;
        do {
            int a3 = this.f1974b.a();
            a2 = this.f1974b.b() ? a() : this.f1974b.c() ? c() : d();
            b2 = a2.b();
            if (!(a3 != this.f1974b.a()) && !b2) {
                break;
            }
        } while (!b2);
        return a2.a();
    }

    private l c() {
        while (h(this.f1974b.a())) {
            n b2 = b(this.f1974b.a());
            this.f1974b.b(b2.a());
            if (b2.c()) {
                return new l(new o(this.f1974b.a(), this.f1975c.toString()), true);
            }
            this.f1975c.append(b2.b());
        }
        if (d(this.f1974b.a())) {
            this.f1974b.a(3);
            this.f1974b.f();
        } else if (e(this.f1974b.a())) {
            if (this.f1974b.a() + 5 < this.f1973a.c()) {
                this.f1974b.a(5);
            } else {
                this.f1974b.b(this.f1973a.c());
            }
            this.f1974b.d();
        }
        return new l(false);
    }

    private p c(int i) {
        int i2 = i + 7;
        if (i2 > this.f1973a.c()) {
            int a2 = a(i, 4);
            return a2 == 0 ? new p(this.f1973a.c(), 10, 10) : new p(this.f1973a.c(), a2 - 1, 10);
        }
        int a3 = a(i, 7) - 8;
        return new p(i2, a3 / 11, a3 % 11);
    }

    private l d() {
        while (i(this.f1974b.a())) {
            p c2 = c(this.f1974b.a());
            this.f1974b.b(c2.a());
            if (c2.d()) {
                return new l(c2.e() ? new o(this.f1974b.a(), this.f1975c.toString()) : new o(this.f1974b.a(), this.f1975c.toString(), c2.c()), true);
            }
            this.f1975c.append(c2.b());
            if (c2.e()) {
                return new l(new o(this.f1974b.a(), this.f1975c.toString()), true);
            }
            this.f1975c.append(c2.c());
        }
        if (f(this.f1974b.a())) {
            this.f1974b.d();
            this.f1974b.a(4);
        }
        return new l(false);
    }

    private boolean d(int i) {
        int i2 = i + 3;
        if (i2 > this.f1973a.c()) {
            return false;
        }
        while (i < i2) {
            if (this.f1973a.a(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean e(int i) {
        int i2;
        if (i + 1 > this.f1973a.c()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.f1973a.c(); i3++) {
            if (i3 == 2) {
                if (!this.f1973a.a(i + 2)) {
                    return false;
                }
            } else if (this.f1973a.a(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean f(int i) {
        int i2;
        if (i + 1 > this.f1973a.c()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.f1973a.c(); i3++) {
            if (this.f1973a.a(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean g(int i) {
        int a2;
        if (i + 5 > this.f1973a.c()) {
            return false;
        }
        int a3 = a(i, 5);
        if (a3 < 5 || a3 >= 16) {
            return i + 6 <= this.f1973a.c() && (a2 = a(i, 6)) >= 16 && a2 < 63;
        }
        return true;
    }

    private boolean h(int i) {
        int a2;
        if (i + 5 > this.f1973a.c()) {
            return false;
        }
        int a3 = a(i, 5);
        if (a3 >= 5 && a3 < 16) {
            return true;
        }
        if (i + 7 > this.f1973a.c()) {
            return false;
        }
        int a4 = a(i, 7);
        if (a4 < 64 || a4 >= 116) {
            return i + 8 <= this.f1973a.c() && (a2 = a(i, 8)) >= 232 && a2 < 253;
        }
        return true;
    }

    private boolean i(int i) {
        if (i + 7 > this.f1973a.c()) {
            return i + 4 <= this.f1973a.c();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.f1973a.a(i3);
            }
            if (this.f1973a.a(i2)) {
                return true;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2) {
        return a(this.f1973a, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o a(int i, String str) {
        this.f1975c.setLength(0);
        if (str != null) {
            this.f1975c.append(str);
        }
        this.f1974b.b(i);
        o b2 = b();
        return (b2 == null || !b2.d()) ? new o(this.f1974b.a(), this.f1975c.toString()) : new o(this.f1974b.a(), this.f1975c.toString(), b2.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(StringBuilder sb, int i) {
        String str = null;
        while (true) {
            o a2 = a(i, str);
            String a3 = r.a(a2.b());
            if (a3 != null) {
                sb.append(a3);
            }
            str = a2.d() ? String.valueOf(a2.c()) : null;
            if (i == a2.a()) {
                return sb.toString();
            }
            i = a2.a();
        }
    }
}
