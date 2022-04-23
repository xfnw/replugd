package b.b.a;

import android.content.Context;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f1627c;

    /* renamed from: a  reason: collision with root package name */
    private final b f1628a;

    /* renamed from: b  reason: collision with root package name */
    private final j f1629b;

    private a(Context context) {
        this.f1628a = new b(context);
        this.f1629b = new j(context, this.f1628a);
    }

    public static a a(Context context) {
        if (f1627c == null) {
            synchronized (a.class) {
                if (f1627c == null) {
                    f1627c = new a(context);
                }
            }
        }
        return f1627c;
    }

    public d a() {
        return this.f1628a;
    }

    public c b() {
        return this.f1628a;
    }

    public f c() {
        return this.f1628a;
    }

    public String d() {
        if (this.f1628a.f() != null) {
            return this.f1628a.f().a();
        }
        return null;
    }

    public g e() {
        return this.f1628a;
    }

    public h f() {
        return this.f1628a;
    }

    public i g() {
        return this.f1629b;
    }

    public e h() {
        return this.f1628a;
    }
}
