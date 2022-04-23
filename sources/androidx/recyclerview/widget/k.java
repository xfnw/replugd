package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.o f1514a;

    /* renamed from: b  reason: collision with root package name */
    private int f1515b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f1516c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends k {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.k
        public int a() {
            return this.f1514a.q();
        }

        @Override // androidx.recyclerview.widget.k
        public int a(View view) {
            return this.f1514a.i(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public void a(int i) {
            this.f1514a.d(i);
        }

        @Override // androidx.recyclerview.widget.k
        public int b() {
            return this.f1514a.q() - this.f1514a.o();
        }

        @Override // androidx.recyclerview.widget.k
        public int b(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1514a.h(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int c() {
            return this.f1514a.o();
        }

        @Override // androidx.recyclerview.widget.k
        public int c(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1514a.g(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int d() {
            return this.f1514a.r();
        }

        @Override // androidx.recyclerview.widget.k
        public int d(View view) {
            return this.f1514a.f(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int e() {
            return this.f1514a.i();
        }

        @Override // androidx.recyclerview.widget.k
        public int e(View view) {
            this.f1514a.a(view, true, this.f1516c);
            return this.f1516c.right;
        }

        @Override // androidx.recyclerview.widget.k
        public int f() {
            return this.f1514a.n();
        }

        @Override // androidx.recyclerview.widget.k
        public int f(View view) {
            this.f1514a.a(view, true, this.f1516c);
            return this.f1516c.left;
        }

        @Override // androidx.recyclerview.widget.k
        public int g() {
            return (this.f1514a.q() - this.f1514a.n()) - this.f1514a.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends k {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.k
        public int a() {
            return this.f1514a.h();
        }

        @Override // androidx.recyclerview.widget.k
        public int a(View view) {
            return this.f1514a.e(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public void a(int i) {
            this.f1514a.e(i);
        }

        @Override // androidx.recyclerview.widget.k
        public int b() {
            return this.f1514a.h() - this.f1514a.m();
        }

        @Override // androidx.recyclerview.widget.k
        public int b(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1514a.g(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int c() {
            return this.f1514a.m();
        }

        @Override // androidx.recyclerview.widget.k
        public int c(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1514a.h(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int d() {
            return this.f1514a.i();
        }

        @Override // androidx.recyclerview.widget.k
        public int d(View view) {
            return this.f1514a.j(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int e() {
            return this.f1514a.r();
        }

        @Override // androidx.recyclerview.widget.k
        public int e(View view) {
            this.f1514a.a(view, true, this.f1516c);
            return this.f1516c.bottom;
        }

        @Override // androidx.recyclerview.widget.k
        public int f() {
            return this.f1514a.p();
        }

        @Override // androidx.recyclerview.widget.k
        public int f(View view) {
            this.f1514a.a(view, true, this.f1516c);
            return this.f1516c.top;
        }

        @Override // androidx.recyclerview.widget.k
        public int g() {
            return (this.f1514a.h() - this.f1514a.p()) - this.f1514a.m();
        }
    }

    private k(RecyclerView.o oVar) {
        this.f1515b = Integer.MIN_VALUE;
        this.f1516c = new Rect();
        this.f1514a = oVar;
    }

    /* synthetic */ k(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static k a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static k a(RecyclerView.o oVar, int i) {
        if (i == 0) {
            return a(oVar);
        }
        if (i == 1) {
            return b(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static k b(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f1515b) {
            return 0;
        }
        return g() - this.f1515b;
    }

    public void i() {
        this.f1515b = g();
    }
}
