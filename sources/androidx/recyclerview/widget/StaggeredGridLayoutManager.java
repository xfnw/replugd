package androidx.recyclerview.widget;

import a.g.l.b0.c;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.a {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;
    f[] t;
    k u;
    k v;
    private int w;
    private int x;
    private int s = -1;
    boolean z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();
    private final i y = new i();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f1392a;

        /* renamed from: b  reason: collision with root package name */
        int f1393b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1394c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1395d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1396e;
        int[] f;

        b() {
            b();
        }

        void a() {
            this.f1393b = this.f1394c ? StaggeredGridLayoutManager.this.u.b() : StaggeredGridLayoutManager.this.u.f();
        }

        void a(int i) {
            this.f1393b = this.f1394c ? StaggeredGridLayoutManager.this.u.b() - i : StaggeredGridLayoutManager.this.u.f() + i;
        }

        void a(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = fVarArr[i].b(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.f1392a = -1;
            this.f1393b = Integer.MIN_VALUE;
            this.f1394c = false;
            this.f1395d = false;
            this.f1396e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        f f1397e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int e() {
            f fVar = this.f1397e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f1412e;
        }

        public boolean f() {
            return this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int[] f1398a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f1399b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0042a();

            /* renamed from: b  reason: collision with root package name */
            int f1400b;

            /* renamed from: c  reason: collision with root package name */
            int f1401c;

            /* renamed from: d  reason: collision with root package name */
            int[] f1402d;

            /* renamed from: e  reason: collision with root package name */
            boolean f1403e;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0042a implements Parcelable.Creator<a> {
                C0042a() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.f1400b = parcel.readInt();
                this.f1401c = parcel.readInt();
                this.f1403e = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1402d = new int[readInt];
                    parcel.readIntArray(this.f1402d);
                }
            }

            int a(int i) {
                int[] iArr = this.f1402d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1400b + ", mGapDir=" + this.f1401c + ", mHasUnwantedGapAfter=" + this.f1403e + ", mGapPerSpan=" + Arrays.toString(this.f1402d) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1400b);
                parcel.writeInt(this.f1401c);
                parcel.writeInt(this.f1403e ? 1 : 0);
                int[] iArr = this.f1402d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f1402d);
            }
        }

        d() {
        }

        private void c(int i, int i2) {
            List<a> list = this.f1399b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = this.f1399b.get(size);
                    int i3 = aVar.f1400b;
                    if (i3 >= i) {
                        aVar.f1400b = i3 + i2;
                    }
                }
            }
        }

        private void d(int i, int i2) {
            List<a> list = this.f1399b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = this.f1399b.get(size);
                    int i4 = aVar.f1400b;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            this.f1399b.remove(size);
                        } else {
                            aVar.f1400b = i4 - i2;
                        }
                    }
                }
            }
        }

        private int g(int i) {
            if (this.f1399b == null) {
                return -1;
            }
            a c2 = c(i);
            if (c2 != null) {
                this.f1399b.remove(c2);
            }
            int size = this.f1399b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f1399b.get(i2).f1400b >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f1399b.remove(i2);
            return this.f1399b.get(i2).f1400b;
        }

        public a a(int i, int i2, int i3, boolean z) {
            List<a> list = this.f1399b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1399b.get(i4);
                int i5 = aVar.f1400b;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.f1401c == i3 || (z && aVar.f1403e))) {
                    return aVar;
                }
            }
            return null;
        }

        void a() {
            int[] iArr = this.f1398a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1399b = null;
        }

        void a(int i) {
            int[] iArr = this.f1398a;
            if (iArr == null) {
                this.f1398a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f1398a, -1);
            } else if (i >= iArr.length) {
                this.f1398a = new int[f(i)];
                System.arraycopy(iArr, 0, this.f1398a, 0, iArr.length);
                int[] iArr2 = this.f1398a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        void a(int i, int i2) {
            int[] iArr = this.f1398a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                a(i3);
                int[] iArr2 = this.f1398a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f1398a, i, i3, -1);
                c(i, i2);
            }
        }

        void a(int i, f fVar) {
            a(i);
            this.f1398a[i] = fVar.f1412e;
        }

        public void a(a aVar) {
            if (this.f1399b == null) {
                this.f1399b = new ArrayList();
            }
            int size = this.f1399b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f1399b.get(i);
                if (aVar2.f1400b == aVar.f1400b) {
                    this.f1399b.remove(i);
                }
                if (aVar2.f1400b >= aVar.f1400b) {
                    this.f1399b.add(i, aVar);
                    return;
                }
            }
            this.f1399b.add(aVar);
        }

        int b(int i) {
            List<a> list = this.f1399b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1399b.get(size).f1400b >= i) {
                        this.f1399b.remove(size);
                    }
                }
            }
            return e(i);
        }

        void b(int i, int i2) {
            int[] iArr = this.f1398a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                a(i3);
                int[] iArr2 = this.f1398a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f1398a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                d(i, i2);
            }
        }

        public a c(int i) {
            List<a> list = this.f1399b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1399b.get(size);
                if (aVar.f1400b == i) {
                    return aVar;
                }
            }
            return null;
        }

        int d(int i) {
            int[] iArr = this.f1398a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int e(int i) {
            int[] iArr = this.f1398a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                int[] iArr2 = this.f1398a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f1398a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f1398a, i, i2, -1);
            return i2;
        }

        int f(int i) {
            int length = this.f1398a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        int f1404b;

        /* renamed from: c  reason: collision with root package name */
        int f1405c;

        /* renamed from: d  reason: collision with root package name */
        int f1406d;

        /* renamed from: e  reason: collision with root package name */
        int[] f1407e;
        int f;
        int[] g;
        List<d.a> h;
        boolean i;
        boolean j;
        boolean k;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<e> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.f1404b = parcel.readInt();
            this.f1405c = parcel.readInt();
            this.f1406d = parcel.readInt();
            int i = this.f1406d;
            if (i > 0) {
                this.f1407e = new int[i];
                parcel.readIntArray(this.f1407e);
            }
            this.f = parcel.readInt();
            int i2 = this.f;
            if (i2 > 0) {
                this.g = new int[i2];
                parcel.readIntArray(this.g);
            }
            boolean z = false;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1 ? true : z;
            this.h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f1406d = eVar.f1406d;
            this.f1404b = eVar.f1404b;
            this.f1405c = eVar.f1405c;
            this.f1407e = eVar.f1407e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.h = eVar.h;
        }

        void a() {
            this.f1407e = null;
            this.f1406d = 0;
            this.f1404b = -1;
            this.f1405c = -1;
        }

        void b() {
            this.f1407e = null;
            this.f1406d = 0;
            this.f = 0;
            this.g = null;
            this.h = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1404b);
            parcel.writeInt(this.f1405c);
            parcel.writeInt(this.f1406d);
            if (this.f1406d > 0) {
                parcel.writeIntArray(this.f1407e);
            }
            parcel.writeInt(this.f);
            if (this.f > 0) {
                parcel.writeIntArray(this.g);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeList(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f1408a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f1409b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f1410c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f1411d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f1412e;

        f(int i) {
            this.f1412e = i;
        }

        int a(int i) {
            int i2 = this.f1410c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1408a.size() == 0) {
                return i;
            }
            a();
            return this.f1410c;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int f = StaggeredGridLayoutManager.this.u.f();
            int b2 = StaggeredGridLayoutManager.this.u.b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f1408a.get(i);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                int a2 = StaggeredGridLayoutManager.this.u.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d2 < b2 : d2 <= b2;
                if (!z3 ? a2 > f : a2 >= f) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (!z2 && d2 >= f && a2 <= b2) {
                        }
                        return StaggeredGridLayoutManager.this.l(view);
                    } else if (d2 >= f && a2 <= b2) {
                        return StaggeredGridLayoutManager.this.l(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f1408a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1408a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.l(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.l(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1408a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f1408a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.l(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.l(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        void a() {
            d.a c2;
            ArrayList<View> arrayList = this.f1408a;
            View view = arrayList.get(arrayList.size() - 1);
            c b2 = b(view);
            this.f1410c = StaggeredGridLayoutManager.this.u.a(view);
            if (b2.f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f1401c == 1) {
                this.f1410c += c2.a(this.f1412e);
            }
        }

        void a(View view) {
            c b2 = b(view);
            b2.f1397e = this;
            this.f1408a.add(view);
            this.f1410c = Integer.MIN_VALUE;
            if (this.f1408a.size() == 1) {
                this.f1409b = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f1411d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        void a(boolean z, int i) {
            int a2 = z ? a(Integer.MIN_VALUE) : b(Integer.MIN_VALUE);
            c();
            if (a2 != Integer.MIN_VALUE) {
                if (z && a2 < StaggeredGridLayoutManager.this.u.b()) {
                    return;
                }
                if (z || a2 <= StaggeredGridLayoutManager.this.u.f()) {
                    if (i != Integer.MIN_VALUE) {
                        a2 += i;
                    }
                    this.f1410c = a2;
                    this.f1409b = a2;
                }
            }
        }

        int b(int i) {
            int i2 = this.f1409b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1408a.size() == 0) {
                return i;
            }
            b();
            return this.f1409b;
        }

        c b(View view) {
            return (c) view.getLayoutParams();
        }

        void b() {
            d.a c2;
            View view = this.f1408a.get(0);
            c b2 = b(view);
            this.f1409b = StaggeredGridLayoutManager.this.u.d(view);
            if (b2.f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f1401c == -1) {
                this.f1409b -= c2.a(this.f1412e);
            }
        }

        void c() {
            this.f1408a.clear();
            i();
            this.f1411d = 0;
        }

        void c(int i) {
            int i2 = this.f1409b;
            if (i2 != Integer.MIN_VALUE) {
                this.f1409b = i2 + i;
            }
            int i3 = this.f1410c;
            if (i3 != Integer.MIN_VALUE) {
                this.f1410c = i3 + i;
            }
        }

        void c(View view) {
            c b2 = b(view);
            b2.f1397e = this;
            this.f1408a.add(0, view);
            this.f1409b = Integer.MIN_VALUE;
            if (this.f1408a.size() == 1) {
                this.f1410c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f1411d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        public int d() {
            int i;
            int i2;
            if (StaggeredGridLayoutManager.this.z) {
                i2 = this.f1408a.size() - 1;
                i = -1;
            } else {
                i2 = 0;
                i = this.f1408a.size();
            }
            return a(i2, i, true);
        }

        void d(int i) {
            this.f1409b = i;
            this.f1410c = i;
        }

        public int e() {
            int i;
            int i2;
            if (StaggeredGridLayoutManager.this.z) {
                i2 = 0;
                i = this.f1408a.size();
            } else {
                i2 = this.f1408a.size() - 1;
                i = -1;
            }
            return a(i2, i, true);
        }

        public int f() {
            return this.f1411d;
        }

        int g() {
            int i = this.f1410c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f1410c;
        }

        int h() {
            int i = this.f1409b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.f1409b;
        }

        void i() {
            this.f1409b = Integer.MIN_VALUE;
            this.f1410c = Integer.MIN_VALUE;
        }

        void j() {
            int size = this.f1408a.size();
            View remove = this.f1408a.remove(size - 1);
            c b2 = b(remove);
            b2.f1397e = null;
            if (b2.c() || b2.b()) {
                this.f1411d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            if (size == 1) {
                this.f1409b = Integer.MIN_VALUE;
            }
            this.f1410c = Integer.MIN_VALUE;
        }

        void k() {
            View remove = this.f1408a.remove(0);
            c b2 = b(remove);
            b2.f1397e = null;
            if (this.f1408a.size() == 0) {
                this.f1410c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.f1411d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            this.f1409b = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.o.d a2 = RecyclerView.o.a(context, attributeSet, i, i2);
        i(a2.f1370a);
        j(a2.f1371b);
        c(a2.f1372c);
        M();
    }

    private void M() {
        this.u = k.a(this, this.w);
        this.v = k.a(this, 1 - this.w);
    }

    private void N() {
        if (this.v.d() != 1073741824) {
            int e2 = e();
            float f2 = 0.0f;
            for (int i = 0; i < e2; i++) {
                View c2 = c(i);
                float b2 = this.v.b(c2);
                if (b2 >= f2) {
                    if (((c) c2.getLayoutParams()).f()) {
                        b2 = (b2 * 1.0f) / this.s;
                    }
                    f2 = Math.max(f2, b2);
                }
            }
            int i2 = this.x;
            int round = Math.round(f2 * this.s);
            if (this.v.d() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.g());
            }
            k(round);
            if (this.x != i2) {
                for (int i3 = 0; i3 < e2; i3++) {
                    View c3 = c(i3);
                    c cVar = (c) c3.getLayoutParams();
                    if (!cVar.f) {
                        if (!L() || this.w != 1) {
                            int i4 = cVar.f1397e.f1412e;
                            int i5 = this.w;
                            int i6 = (this.x * i4) - (i4 * i2);
                            if (i5 == 1) {
                                c3.offsetLeftAndRight(i6);
                            } else {
                                c3.offsetTopAndBottom(i6);
                            }
                        } else {
                            int i7 = this.s;
                            int i8 = cVar.f1397e.f1412e;
                            c3.offsetLeftAndRight(((-((i7 - 1) - i8)) * this.x) - ((-((i7 - 1) - i8)) * i2));
                        }
                    }
                }
            }
        }
    }

    private void O() {
        this.A = (this.w == 1 || !L()) ? this.z : !this.z;
    }

    private int a(RecyclerView.v vVar, i iVar, RecyclerView.a0 a0Var) {
        f fVar;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View view;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        boolean z = false;
        this.B.set(0, this.s, true);
        int i7 = this.y.i ? iVar.f1512e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : iVar.f1512e == 1 ? iVar.g + iVar.f1509b : iVar.f - iVar.f1509b;
        e(iVar.f1512e, i7);
        int b2 = this.A ? this.u.b() : this.u.f();
        boolean z2 = false;
        while (iVar.a(a0Var) && (this.y.i || !this.B.isEmpty())) {
            View a2 = iVar.a(vVar);
            c cVar = (c) a2.getLayoutParams();
            int a3 = cVar.a();
            int d2 = this.E.d(a3);
            boolean z3 = d2 == -1;
            if (z3) {
                if (cVar.f) {
                    f[] fVarArr = this.t;
                    char c2 = z ? 1 : 0;
                    char c3 = z ? 1 : 0;
                    fVar = fVarArr[c2];
                } else {
                    fVar = a(iVar);
                }
                this.E.a(a3, fVar);
            } else {
                fVar = this.t[d2];
            }
            cVar.f1397e = fVar;
            if (iVar.f1512e == 1) {
                b(a2);
            } else {
                int i8 = z ? 1 : 0;
                int i9 = z ? 1 : 0;
                b(a2, i8);
            }
            a(a2, cVar, z);
            if (iVar.f1512e == 1) {
                int r = cVar.f ? r(b2) : fVar.a(b2);
                i = this.u.b(a2) + r;
                if (z3 && cVar.f) {
                    d.a n = n(r);
                    n.f1401c = -1;
                    n.f1400b = a3;
                    this.E.a(n);
                }
                i2 = r;
            } else {
                int u = cVar.f ? u(b2) : fVar.b(b2);
                i2 = u - this.u.b(a2);
                if (z3 && cVar.f) {
                    d.a o = o(u);
                    o.f1401c = 1;
                    o.f1400b = a3;
                    this.E.a(o);
                }
                i = u;
            }
            if (cVar.f && iVar.f1511d == -1) {
                if (!z3) {
                    if (!(iVar.f1512e == 1 ? D() : E())) {
                        d.a c4 = this.E.c(a3);
                        if (c4 != null) {
                            c4.f1403e = true;
                        }
                    }
                }
                this.M = true;
            }
            a(a2, cVar, iVar);
            if (!L() || this.w != 1) {
                int f2 = cVar.f ? this.v.f() : (fVar.f1412e * this.x) + this.v.f();
                i3 = this.v.b(a2) + f2;
                i4 = f2;
            } else {
                int b3 = cVar.f ? this.v.b() : this.v.b() - (((this.s - 1) - fVar.f1412e) * this.x);
                i4 = b3 - this.v.b(a2);
                i3 = b3;
            }
            if (this.w == 1) {
                staggeredGridLayoutManager = this;
                view = a2;
                i6 = i4;
                i4 = i2;
                i5 = i3;
            } else {
                staggeredGridLayoutManager = this;
                view = a2;
                i6 = i2;
                i5 = i;
                i = i3;
            }
            staggeredGridLayoutManager.a(view, i6, i4, i5, i);
            if (cVar.f) {
                e(this.y.f1512e, i7);
            } else {
                a(fVar, this.y.f1512e, i7);
            }
            a(vVar, this.y);
            if (this.y.h && a2.hasFocusable()) {
                if (cVar.f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar.f1412e, false);
                    z2 = true;
                    z = false;
                }
            }
            z2 = true;
            z = false;
        }
        if (!z2) {
            a(vVar, this.y);
        }
        int f3 = this.y.f1512e == -1 ? this.u.f() - u(this.u.f()) : r(this.u.b()) - this.u.b();
        if (f3 > 0) {
            return Math.min(iVar.f1509b, f3);
        }
        return 0;
    }

    private f a(i iVar) {
        int i;
        int i2;
        int i3 = -1;
        if (v(iVar.f1512e)) {
            i2 = this.s - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.s;
            i = 1;
        }
        f fVar = null;
        if (iVar.f1512e == 1) {
            int i4 = Integer.MAX_VALUE;
            int f2 = this.u.f();
            while (i2 != i3) {
                f fVar2 = this.t[i2];
                int a2 = fVar2.a(f2);
                if (a2 < i4) {
                    fVar = fVar2;
                    i4 = a2;
                }
                i2 += i;
            }
            return fVar;
        }
        int i5 = Integer.MIN_VALUE;
        int b2 = this.u.b();
        while (i2 != i3) {
            f fVar3 = this.t[i2];
            int b3 = fVar3.b(b2);
            if (b3 > i5) {
                fVar = fVar3;
                i5 = b3;
            }
            i2 += i;
        }
        return fVar;
    }

    private void a(View view, int i, int i2, boolean z) {
        a(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int c2 = c(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int c3 = c(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? b(view, c2, c3, cVar) : a(view, c2, c3, cVar)) {
            view.measure(c2, c3);
        }
    }

    private void a(View view, c cVar, i iVar) {
        if (iVar.f1512e == 1) {
            if (cVar.f) {
                p(view);
            } else {
                cVar.f1397e.a(view);
            }
        } else if (cVar.f) {
            q(view);
        } else {
            cVar.f1397e.c(view);
        }
    }

    private void a(View view, c cVar, boolean z) {
        int i;
        int i2;
        if (cVar.f) {
            if (this.w == 1) {
                i2 = this.J;
            } else {
                a(view, RecyclerView.o.a(q(), r(), n() + o(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z);
                return;
            }
        } else if (this.w == 1) {
            i2 = RecyclerView.o.a(this.x, r(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        } else {
            i2 = RecyclerView.o.a(q(), r(), n() + o(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
            i = RecyclerView.o.a(this.x, i(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            a(view, i2, i, z);
        }
        i = RecyclerView.o.a(h(), i(), p() + m(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        a(view, i2, i, z);
    }

    private void a(RecyclerView.v vVar, int i) {
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            View c2 = c(e2);
            if (this.u.d(c2) >= i && this.u.f(c2) >= i) {
                c cVar = (c) c2.getLayoutParams();
                if (cVar.f) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        if (this.t[i2].f1408a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].j();
                    }
                } else if (cVar.f1397e.f1408a.size() != 1) {
                    cVar.f1397e.j();
                } else {
                    return;
                }
                a(c2, vVar);
            } else {
                return;
            }
        }
    }

    private void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int b2;
        int r = r(Integer.MIN_VALUE);
        if (r != Integer.MIN_VALUE && (b2 = this.u.b() - r) > 0) {
            int i = b2 - (-c(-b2, vVar, a0Var));
            if (z && i > 0) {
                this.u.a(i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r4.f1512e == (-1)) goto L_0x0012;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.i r4) {
        /*
            r2 = this;
            boolean r0 = r4.f1508a
            if (r0 == 0) goto L_0x004d
            boolean r0 = r4.i
            if (r0 == 0) goto L_0x0009
            goto L_0x004d
        L_0x0009:
            int r0 = r4.f1509b
            r1 = -1
            if (r0 != 0) goto L_0x001e
            int r0 = r4.f1512e
            if (r0 != r1) goto L_0x0018
        L_0x0012:
            int r4 = r4.g
        L_0x0014:
            r2.a(r3, r4)
            goto L_0x004d
        L_0x0018:
            int r4 = r4.f
        L_0x001a:
            r2.b(r3, r4)
            goto L_0x004d
        L_0x001e:
            int r0 = r4.f1512e
            if (r0 != r1) goto L_0x0037
            int r0 = r4.f
            int r1 = r2.s(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x002c
            goto L_0x0012
        L_0x002c:
            int r1 = r4.g
            int r4 = r4.f1509b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L_0x0014
        L_0x0037:
            int r0 = r4.g
            int r0 = r2.t(r0)
            int r1 = r4.g
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0043
            goto L_0x0018
        L_0x0043:
            int r1 = r4.f
            int r4 = r4.f1509b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L_0x001a
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.i):void");
    }

    private void a(b bVar) {
        boolean z;
        e eVar = this.I;
        int i = eVar.f1406d;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].c();
                    e eVar2 = this.I;
                    int i3 = eVar2.f1407e[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += eVar2.j ? this.u.b() : this.u.f();
                    }
                    this.t[i2].d(i3);
                }
            } else {
                eVar.b();
                e eVar3 = this.I;
                eVar3.f1404b = eVar3.f1405c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.k;
        c(eVar4.i);
        O();
        e eVar5 = this.I;
        int i4 = eVar5.f1404b;
        if (i4 != -1) {
            this.C = i4;
            z = eVar5.j;
        } else {
            z = this.A;
        }
        bVar.f1394c = z;
        e eVar6 = this.I;
        if (eVar6.f > 1) {
            d dVar = this.E;
            dVar.f1398a = eVar6.g;
            dVar.f1399b = eVar6.h;
        }
    }

    private void a(f fVar, int i, int i2) {
        int f2 = fVar.f();
        if (i == -1) {
            if (fVar.h() + f2 > i2) {
                return;
            }
        } else if (fVar.g() - f2 < i2) {
            return;
        }
        this.B.set(fVar.f1412e, false);
    }

    private boolean a(f fVar) {
        if (this.A) {
            if (fVar.g() < this.u.b()) {
                ArrayList<View> arrayList = fVar.f1408a;
                return !fVar.b(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (fVar.h() > this.u.f()) {
            return !fVar.b(fVar.f1408a.get(0)).f;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.I()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.H()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L_0x001f
        L_0x001b:
            int r2 = r7 + r8
        L_0x001d:
            r3 = r2
            r2 = r7
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.e(r2)
            r4 = 1
            if (r9 == r4) goto L_0x003e
            r5 = 2
            if (r9 == r5) goto L_0x0038
            if (r9 == r1) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.a(r8, r4)
            goto L_0x0043
        L_0x0038:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.b(r7, r8)
            goto L_0x0043
        L_0x003e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.a(r7, r8)
        L_0x0043:
            if (r3 > r0) goto L_0x0046
            return
        L_0x0046:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004f
            int r7 = r6.H()
            goto L_0x0053
        L_0x004f:
            int r7 = r6.I()
        L_0x0053:
            if (r2 > r7) goto L_0x0058
            r6.y()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.a0 r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.i r0 = r4.y
            r1 = 0
            r0.f1509b = r1
            r0.f1510c = r5
            boolean r0 = r4.w()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.k r5 = r4.u
            int r5 = r5.g()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.k r5 = r4.u
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.f()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.i r0 = r4.y
            androidx.recyclerview.widget.k r3 = r4.u
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.i r6 = r4.y
            androidx.recyclerview.widget.k r0 = r4.u
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.i r0 = r4.y
            androidx.recyclerview.widget.k r3 = r4.u
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.i r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L_0x005d:
            androidx.recyclerview.widget.i r5 = r4.y
            r5.h = r1
            r5.f1508a = r2
            androidx.recyclerview.widget.k r6 = r4.u
            int r6 = r6.d()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.k r6 = r4.u
            int r6 = r6.a()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$a0):void");
    }

    private void b(RecyclerView.v vVar, int i) {
        while (e() > 0) {
            View c2 = c(0);
            if (this.u.a(c2) <= i && this.u.e(c2) <= i) {
                c cVar = (c) c2.getLayoutParams();
                if (cVar.f) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        if (this.t[i2].f1408a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].k();
                    }
                } else if (cVar.f1397e.f1408a.size() != 1) {
                    cVar.f1397e.k();
                } else {
                    return;
                }
                a(c2, vVar);
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int f2;
        int u = u(Integer.MAX_VALUE);
        if (u != Integer.MAX_VALUE && (f2 = u - this.u.f()) > 0) {
            int c2 = f2 - c(f2, vVar, a0Var);
            if (z && c2 > 0) {
                this.u.a(-c2);
            }
        }
    }

    private int c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x014b, code lost:
        if (F() != false) goto L_0x014f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    private boolean c(RecyclerView.a0 a0Var, b bVar) {
        boolean z = this.G;
        int a2 = a0Var.a();
        bVar.f1392a = z ? q(a2) : p(a2);
        bVar.f1393b = Integer.MIN_VALUE;
        return true;
    }

    private void e(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f1408a.isEmpty()) {
                a(this.t[i3], i, i2);
            }
        }
    }

    private int h(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        return m.a(a0Var, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private int i(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        return m.a(a0Var, this.u, b(!this.N), a(!this.N), this, this.N, this.A);
    }

    private int j(RecyclerView.a0 a0Var) {
        if (e() == 0) {
            return 0;
        }
        return m.b(a0Var, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private int l(int i) {
        if (e() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < H()) != this.A ? -1 : 1;
    }

    private int m(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && L()) ? -1 : 1 : (this.w != 1 && L()) ? 1 : -1;
    }

    private d.a n(int i) {
        d.a aVar = new d.a();
        aVar.f1402d = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.f1402d[i2] = i - this.t[i2].a(i);
        }
        return aVar;
    }

    private d.a o(int i) {
        d.a aVar = new d.a();
        aVar.f1402d = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.f1402d[i2] = this.t[i2].b(i) - i;
        }
        return aVar;
    }

    private int p(int i) {
        int e2 = e();
        for (int i2 = 0; i2 < e2; i2++) {
            int l = l(c(i2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private void p(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private int q(int i) {
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            int l = l(c(e2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private void q(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].c(view);
        }
    }

    private int r(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int s(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int t(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int u(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private boolean v(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == L();
    }

    private void w(int i) {
        i iVar = this.y;
        iVar.f1512e = i;
        int i2 = 1;
        if (this.A != (i == -1)) {
            i2 = -1;
        }
        iVar.f1511d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean C() {
        return this.I == null;
    }

    boolean D() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    boolean E() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    boolean F() {
        int i;
        int i2;
        if (e() == 0 || this.F == 0 || !t()) {
            return false;
        }
        if (this.A) {
            i2 = I();
            i = H();
        } else {
            i2 = H();
            i = I();
        }
        if (i2 == 0 && J() != null) {
            this.E.a();
        } else if (!this.M) {
            return false;
        } else {
            int i3 = this.A ? -1 : 1;
            int i4 = i + 1;
            d.a a2 = this.E.a(i2, i4, i3, true);
            if (a2 == null) {
                this.M = false;
                this.E.b(i4);
                return false;
            }
            d.a a3 = this.E.a(i2, a2.f1400b, i3 * (-1), true);
            if (a3 == null) {
                this.E.b(a2.f1400b);
            } else {
                this.E.b(a3.f1400b + 1);
            }
        }
        z();
        y();
        return true;
    }

    int G() {
        View a2 = this.A ? a(true) : b(true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    int H() {
        if (e() == 0) {
            return 0;
        }
        return l(c(0));
    }

    int I() {
        int e2 = e();
        if (e2 == 0) {
            return 0;
        }
        return l(c(e2 - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View J() {
        /*
            r12 = this;
            int r0 = r12.e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.L()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.A
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.c(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1397e
            int r9 = r9.f1412e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1397e
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1397e
            int r9 = r9.f1412e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.c(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.k r10 = r12.u
            int r10 = r10.a(r7)
            androidx.recyclerview.widget.k r11 = r12.u
            int r11 = r11.a(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.k r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.k r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f1397e
            int r8 = r8.f1412e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f1397e
            int r9 = r9.f1412e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.J():android.view.View");
    }

    public void K() {
        this.E.a();
        y();
    }

    boolean L() {
        return j() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int a(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return c(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int a(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int a(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 1 ? this.s : super.a(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View a(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View c2;
        View a2;
        if (e() == 0 || (c2 = c(view)) == null) {
            return null;
        }
        O();
        int m = m(i);
        if (m == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) c2.getLayoutParams();
        boolean z = cVar.f;
        f fVar = cVar.f1397e;
        int I = m == 1 ? I() : H();
        b(I, a0Var);
        w(m);
        i iVar = this.y;
        iVar.f1510c = iVar.f1511d + I;
        iVar.f1509b = (int) (this.u.g() * 0.33333334f);
        i iVar2 = this.y;
        iVar2.h = true;
        iVar2.f1508a = false;
        a(vVar, iVar2, a0Var);
        this.G = this.A;
        if (!(z || (a2 = fVar.a(I, m)) == null || a2 == c2)) {
            return a2;
        }
        if (v(m)) {
            for (int i2 = this.s - 1; i2 >= 0; i2--) {
                View a3 = this.t[i2].a(I, m);
                if (!(a3 == null || a3 == c2)) {
                    return a3;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.s; i3++) {
                View a4 = this.t[i3].a(I, m);
                if (!(a4 == null || a4 == c2)) {
                    return a4;
                }
            }
        }
        boolean z2 = (this.z ^ true) == (m == -1);
        if (!z) {
            View b2 = b(z2 ? fVar.d() : fVar.e());
            if (!(b2 == null || b2 == c2)) {
                return b2;
            }
        }
        if (v(m)) {
            for (int i4 = this.s - 1; i4 >= 0; i4--) {
                if (i4 != fVar.f1412e) {
                    f[] fVarArr = this.t;
                    View b3 = b(z2 ? fVarArr[i4].d() : fVarArr[i4].e());
                    if (!(b3 == null || b3 == c2)) {
                        return b3;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.s; i5++) {
                f[] fVarArr2 = this.t;
                View b4 = b(z2 ? fVarArr2[i5].d() : fVarArr2[i5].e());
                if (!(b4 == null || b4 == c2)) {
                    return b4;
                }
            }
        }
        return null;
    }

    View a(boolean z) {
        int f2 = this.u.f();
        int b2 = this.u.b();
        View view = null;
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            View c2 = c(e2);
            int d2 = this.u.d(c2);
            int a2 = this.u.a(c2);
            if (a2 > f2 && d2 < b2) {
                if (a2 <= b2 || !z) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p a(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int i3;
        int i4;
        if (this.w != 0) {
            i = i2;
        }
        if (!(e() == 0 || i == 0)) {
            a(i, a0Var);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.s; i6++) {
                i iVar = this.y;
                if (iVar.f1511d == -1) {
                    i4 = iVar.f;
                    i3 = this.t[i6].b(i4);
                } else {
                    i4 = this.t[i6].a(iVar.g);
                    i3 = this.y.g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O, 0, i5);
            for (int i8 = 0; i8 < i5 && this.y.a(a0Var); i8++) {
                cVar.a(this.y.f1510c, this.O[i8]);
                i iVar2 = this.y;
                iVar2.f1510c += iVar2.f1511d;
            }
        }
    }

    void a(int i, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = I();
            i2 = 1;
        } else {
            i3 = H();
            i2 = -1;
        }
        this.y.f1508a = true;
        b(i3, a0Var);
        w(i2);
        i iVar = this.y;
        iVar.f1510c = i3 + iVar.f1511d;
        iVar.f1509b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int n = n() + o();
        int p = p() + m();
        if (this.w == 1) {
            i4 = RecyclerView.o.a(i2, rect.height() + p, k());
            i3 = RecyclerView.o.a(i, (this.x * this.s) + n, l());
        } else {
            i3 = RecyclerView.o.a(i, rect.width() + n, l());
            i4 = RecyclerView.o.a(i2, (this.x * this.s) + p, k());
        }
        c(i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 != null && a2 != null) {
                int l = l(b2);
                int l2 = l(a2);
                if (l < l2) {
                    accessibilityEvent.setFromIndex(l);
                    accessibilityEvent.setToIndex(l2);
                    return;
                }
                accessibilityEvent.setFromIndex(l2);
                accessibilityEvent.setToIndex(l);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, a.g.l.b0.c cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.a(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.w == 0) {
            i4 = cVar2.e();
            i3 = cVar2.f ? this.s : 1;
            i2 = -1;
            i = -1;
        } else {
            i4 = -1;
            i3 = -1;
            i2 = cVar2.e();
            i = cVar2.f ? this.s : 1;
        }
        cVar.b(c.b.a(i4, i3, i2, i, cVar2.f, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        b(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        b(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(String str) {
        if (this.I == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean a() {
        return this.w == 0;
    }

    boolean a(RecyclerView.a0 a0Var, b bVar) {
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (!a0Var.d() && (i = this.C) != -1) {
            if (i < 0 || i >= a0Var.a()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                e eVar = this.I;
                if (eVar == null || eVar.f1404b == -1 || eVar.f1406d < 1) {
                    View b2 = b(this.C);
                    if (b2 != null) {
                        bVar.f1392a = this.A ? I() : H();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1394c) {
                                i3 = this.u.b() - this.D;
                                i2 = this.u.a(b2);
                            } else {
                                i3 = this.u.f() + this.D;
                                i2 = this.u.d(b2);
                            }
                            bVar.f1393b = i3 - i2;
                            return true;
                        } else if (this.u.b(b2) > this.u.g()) {
                            bVar.f1393b = bVar.f1394c ? this.u.b() : this.u.f();
                            return true;
                        } else {
                            int d2 = this.u.d(b2) - this.u.f();
                            if (d2 < 0) {
                                bVar.f1393b = -d2;
                                return true;
                            }
                            int b3 = this.u.b() - this.u.a(b2);
                            if (b3 < 0) {
                                bVar.f1393b = b3;
                                return true;
                            }
                            bVar.f1393b = Integer.MIN_VALUE;
                        }
                    } else {
                        bVar.f1392a = this.C;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            if (l(bVar.f1392a) == 1) {
                                z = true;
                            }
                            bVar.f1394c = z;
                            bVar.a();
                        } else {
                            bVar.a(i4);
                        }
                        bVar.f1395d = true;
                    }
                } else {
                    bVar.f1393b = Integer.MIN_VALUE;
                    bVar.f1392a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean a(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int b(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return c(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int b(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int b(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 0 ? this.s : super.b(vVar, a0Var);
    }

    View b(boolean z) {
        int f2 = this.u.f();
        int b2 = this.u.b();
        int e2 = e();
        View view = null;
        for (int i = 0; i < e2; i++) {
            View c2 = c(i);
            int d2 = this.u.d(c2);
            if (this.u.a(c2) > f2 && d2 < b2) {
                if (d2 >= f2 || !z) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    void b(RecyclerView.a0 a0Var, b bVar) {
        if (!a(a0Var, bVar) && !c(a0Var, bVar)) {
            bVar.a();
            bVar.f1392a = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.b(recyclerView, vVar);
        a(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].c();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean b() {
        return this.w == 1;
    }

    int c(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        a(i, a0Var);
        int a2 = a(vVar, this.y, a0Var);
        if (this.y.f1509b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.u.a(-i);
        this.G = this.A;
        i iVar = this.y;
        iVar.f1509b = 0;
        a(vVar, iVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int c(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p c() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public void c(boolean z) {
        a((String) null);
        e eVar = this.I;
        if (!(eVar == null || eVar.i == z)) {
            eVar.i = z;
        }
        this.z = z;
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int d(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(int i) {
        super.d(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(RecyclerView recyclerView) {
        this.E.a();
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int e(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        c(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int f(RecyclerView.a0 a0Var) {
        return j(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f(int i) {
        if (i == 0) {
            F();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(RecyclerView.a0 a0Var) {
        super.g(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h(int i) {
        e eVar = this.I;
        if (!(eVar == null || eVar.f1404b == i)) {
            eVar.a();
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        y();
    }

    public void i(int i) {
        if (i == 0 || i == 1) {
            a((String) null);
            if (i != this.w) {
                this.w = i;
                k kVar = this.u;
                this.u = this.v;
                this.v = kVar;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void j(int i) {
        a((String) null);
        if (i != this.s) {
            K();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new f(i2);
            }
            y();
        }
    }

    void k(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        return this.F != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable x() {
        int i;
        int i2;
        int[] iArr;
        e eVar = this.I;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.i = this.z;
        eVar2.j = this.G;
        eVar2.k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f1398a) == null) {
            eVar2.f = 0;
        } else {
            eVar2.g = iArr;
            eVar2.f = eVar2.g.length;
            eVar2.h = dVar.f1399b;
        }
        if (e() > 0) {
            eVar2.f1404b = this.G ? I() : H();
            eVar2.f1405c = G();
            int i3 = this.s;
            eVar2.f1406d = i3;
            eVar2.f1407e = new int[i3];
            for (int i4 = 0; i4 < this.s; i4++) {
                if (this.G) {
                    i = this.t[i4].a(Integer.MIN_VALUE);
                    if (i != Integer.MIN_VALUE) {
                        i2 = this.u.b();
                        i -= i2;
                        eVar2.f1407e[i4] = i;
                    } else {
                        eVar2.f1407e[i4] = i;
                    }
                } else {
                    i = this.t[i4].b(Integer.MIN_VALUE);
                    if (i != Integer.MIN_VALUE) {
                        i2 = this.u.f();
                        i -= i2;
                        eVar2.f1407e[i4] = i;
                    } else {
                        eVar2.f1407e[i4] = i;
                    }
                }
            }
        } else {
            eVar2.f1404b = -1;
            eVar2.f1405c = -1;
            eVar2.f1406d = 0;
        }
        return eVar2;
    }
}
