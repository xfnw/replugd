package a.k.a;

import a.k.a.c;
import a.k.a.h;
import a.k.a.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends m implements h.a, i.l {

    /* renamed from: a  reason: collision with root package name */
    final i f373a;

    /* renamed from: c  reason: collision with root package name */
    int f375c;

    /* renamed from: d  reason: collision with root package name */
    int f376d;

    /* renamed from: e  reason: collision with root package name */
    int f377e;
    int f;
    int g;
    int h;
    boolean i;
    String j;
    boolean k;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    ArrayList<Runnable> t;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<C0019a> f374b = new ArrayList<>();
    int l = -1;
    boolean s = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0019a {

        /* renamed from: a  reason: collision with root package name */
        int f378a;

        /* renamed from: b  reason: collision with root package name */
        c f379b;

        /* renamed from: c  reason: collision with root package name */
        int f380c;

        /* renamed from: d  reason: collision with root package name */
        int f381d;

        /* renamed from: e  reason: collision with root package name */
        int f382e;
        int f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019a() {
        }

        C0019a(int i, c cVar) {
            this.f378a = i;
            this.f379b = cVar;
        }
    }

    public a(i iVar) {
        this.f373a = iVar;
    }

    private static boolean b(C0019a aVar) {
        c cVar = aVar.f379b;
        return cVar != null && cVar.l && cVar.J != null && !cVar.C && !cVar.B && cVar.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(ArrayList<c> arrayList, c cVar) {
        c cVar2 = cVar;
        int i = 0;
        while (i < this.f374b.size()) {
            C0019a aVar = this.f374b.get(i);
            int i2 = aVar.f378a;
            if (i2 != 1) {
                if (i2 == 2) {
                    c cVar3 = aVar.f379b;
                    int i3 = cVar3.z;
                    c cVar4 = cVar2;
                    i = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        c cVar5 = arrayList.get(size);
                        if (cVar5.z == i3) {
                            if (cVar5 == cVar3) {
                                z = true;
                            } else {
                                if (cVar5 == cVar4) {
                                    this.f374b.add(i, new C0019a(9, cVar5));
                                    i++;
                                    cVar4 = null;
                                }
                                C0019a aVar2 = new C0019a(3, cVar5);
                                aVar2.f380c = aVar.f380c;
                                aVar2.f382e = aVar.f382e;
                                aVar2.f381d = aVar.f381d;
                                aVar2.f = aVar.f;
                                this.f374b.add(i, aVar2);
                                arrayList.remove(cVar5);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.f374b.remove(i);
                        i--;
                    } else {
                        aVar.f378a = 1;
                        arrayList.add(cVar3);
                    }
                    cVar2 = cVar4;
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(aVar.f379b);
                    c cVar6 = aVar.f379b;
                    if (cVar6 == cVar2) {
                        this.f374b.add(i, new C0019a(9, cVar6));
                        i++;
                        cVar2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f374b.add(i, new C0019a(9, cVar2));
                        i++;
                        cVar2 = aVar.f379b;
                    }
                }
                i++;
            }
            arrayList.add(aVar.f379b);
            i++;
        }
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.f374b.size();
        for (int i = 0; i < size; i++) {
            C0019a aVar = this.f374b.get(i);
            c cVar = aVar.f379b;
            if (cVar != null) {
                cVar.a(this.g, this.h);
            }
            switch (aVar.f378a) {
                case 1:
                    cVar.a(aVar.f380c);
                    this.f373a.a(cVar, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f378a);
                case 3:
                    cVar.a(aVar.f381d);
                    this.f373a.k(cVar);
                    break;
                case 4:
                    cVar.a(aVar.f381d);
                    this.f373a.e(cVar);
                    break;
                case 5:
                    cVar.a(aVar.f380c);
                    this.f373a.o(cVar);
                    break;
                case 6:
                    cVar.a(aVar.f381d);
                    this.f373a.c(cVar);
                    break;
                case 7:
                    cVar.a(aVar.f380c);
                    this.f373a.a(cVar);
                    break;
                case 8:
                    this.f373a.n(cVar);
                    break;
                case 9:
                    this.f373a.n(null);
                    break;
            }
            if (!(this.s || aVar.f378a == 1 || cVar == null)) {
                this.f373a.h(cVar);
            }
        }
        if (!this.s) {
            i iVar = this.f373a;
            iVar.a(iVar.m, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        C0019a aVar;
        if (this.i) {
            if (i.F) {
                String str = "Bump nesting in " + this + " by " + i;
            }
            int size = this.f374b.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = this.f374b.get(i2).f379b;
                if (cVar != null) {
                    cVar.r += i;
                    if (i.F) {
                        String str2 = "Bump nesting of " + aVar.f379b + " to " + aVar.f379b.r;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0019a aVar) {
        this.f374b.add(aVar);
        aVar.f380c = this.f375c;
        aVar.f381d = this.f376d;
        aVar.f382e = this.f377e;
        aVar.f = this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c.f fVar) {
        for (int i = 0; i < this.f374b.size(); i++) {
            C0019a aVar = this.f374b.get(i);
            if (b(aVar)) {
                aVar.f379b.a(fVar);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.j);
            printWriter.print(" mIndex=");
            printWriter.print(this.l);
            printWriter.print(" mCommitted=");
            printWriter.println(this.k);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.f375c == 0 && this.f376d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f375c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f376d));
            }
            if (!(this.f377e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f377e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.m == 0 && this.n == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.n);
            }
            if (!(this.o == 0 && this.p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.p);
            }
        }
        if (!this.f374b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int size = this.f374b.size();
            for (int i = 0; i < size; i++) {
                C0019a aVar = this.f374b.get(i);
                switch (aVar.f378a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f378a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f379b);
                if (z) {
                    if (!(aVar.f380c == 0 && aVar.f381d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f380c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f381d));
                    }
                    if (aVar.f382e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f382e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        for (int size = this.f374b.size() - 1; size >= 0; size--) {
            C0019a aVar = this.f374b.get(size);
            c cVar = aVar.f379b;
            if (cVar != null) {
                cVar.a(i.e(this.g), this.h);
            }
            switch (aVar.f378a) {
                case 1:
                    cVar.a(aVar.f);
                    this.f373a.k(cVar);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f378a);
                case 3:
                    cVar.a(aVar.f382e);
                    this.f373a.a(cVar, false);
                    break;
                case 4:
                    cVar.a(aVar.f382e);
                    this.f373a.o(cVar);
                    break;
                case 5:
                    cVar.a(aVar.f);
                    this.f373a.e(cVar);
                    break;
                case 6:
                    cVar.a(aVar.f382e);
                    this.f373a.a(cVar);
                    break;
                case 7:
                    cVar.a(aVar.f);
                    this.f373a.c(cVar);
                    break;
                case 8:
                    this.f373a.n(null);
                    break;
                case 9:
                    this.f373a.n(cVar);
                    break;
            }
            if (!(this.s || aVar.f378a == 3 || cVar == null)) {
                this.f373a.h(cVar);
            }
        }
        if (!this.s && z) {
            i iVar = this.f373a;
            iVar.a(iVar.m, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f374b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            c cVar = this.f374b.get(i4).f379b;
            int i5 = cVar != null ? cVar.z : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.f374b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        c cVar2 = aVar.f374b.get(i7).f379b;
                        if ((cVar2 != null ? cVar2.z : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    @Override // a.k.a.i.l
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (i.F) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.i) {
            return true;
        }
        this.f373a.a(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b(ArrayList<c> arrayList, c cVar) {
        for (int i = 0; i < this.f374b.size(); i++) {
            C0019a aVar = this.f374b.get(i);
            int i2 = aVar.f378a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            cVar = null;
                            break;
                        case 9:
                            cVar = aVar.f379b;
                            break;
                    }
                }
                arrayList.add(aVar.f379b);
            }
            arrayList.remove(aVar.f379b);
        }
        return cVar;
    }

    public String b() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.f374b.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.f374b.get(i2).f379b;
            int i3 = cVar != null ? cVar.z : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        for (int i = 0; i < this.f374b.size(); i++) {
            if (b(this.f374b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        ArrayList<Runnable> arrayList = this.t;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.t.get(i).run();
            }
            this.t = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.l >= 0) {
            sb.append(" #");
            sb.append(this.l);
        }
        if (this.j != null) {
            sb.append(" ");
            sb.append(this.j);
        }
        sb.append("}");
        return sb.toString();
    }
}
