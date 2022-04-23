package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    final b f1520a;

    /* renamed from: b  reason: collision with root package name */
    a f1521b = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1522a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f1523b;

        /* renamed from: c  reason: collision with root package name */
        int f1524c;

        /* renamed from: d  reason: collision with root package name */
        int f1525d;

        /* renamed from: e  reason: collision with root package name */
        int f1526e;

        a() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a(int i) {
            this.f1522a = i | this.f1522a;
        }

        void a(int i, int i2, int i3, int i4) {
            this.f1523b = i;
            this.f1524c = i2;
            this.f1525d = i3;
            this.f1526e = i4;
        }

        boolean a() {
            int i = this.f1522a;
            if ((i & 7) != 0 && (i & (a(this.f1525d, this.f1523b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1522a;
            if ((i2 & 112) != 0 && (i2 & (a(this.f1525d, this.f1524c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1522a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.f1526e, this.f1523b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1522a;
            return (i4 & 28672) == 0 || (i4 & (a(this.f1526e, this.f1524c) << 12)) != 0;
        }

        void b() {
            this.f1522a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.f1520a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int b2 = this.f1520a.b();
        int a2 = this.f1520a.a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f1520a.a(i);
            this.f1521b.a(b2, a2, this.f1520a.b(a3), this.f1520a.a(a3));
            if (i3 != 0) {
                this.f1521b.b();
                this.f1521b.a(i3);
                if (this.f1521b.a()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f1521b.b();
                this.f1521b.a(i4);
                if (this.f1521b.a()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f1521b.a(this.f1520a.b(), this.f1520a.a(), this.f1520a.b(view), this.f1520a.a(view));
        if (i == 0) {
            return false;
        }
        this.f1521b.b();
        this.f1521b.a(i);
        return this.f1521b.a();
    }
}
