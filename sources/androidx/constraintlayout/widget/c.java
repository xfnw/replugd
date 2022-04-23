package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1123b = {0, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    private static SparseIntArray f1124c = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, b> f1125a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a  reason: collision with root package name */
        boolean f1126a;
        public float a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1127b;
        public float b0;

        /* renamed from: c  reason: collision with root package name */
        public int f1128c;
        public float c0;

        /* renamed from: d  reason: collision with root package name */
        int f1129d;
        public float d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1130e;
        public float e0;
        public int f;
        public float f0;
        public float g;
        public float g0;
        public int h;
        public boolean h0;
        public int i;
        public boolean i0;
        public int j;
        public int j0;
        public int k;
        public int k0;
        public int l;
        public int l0;
        public int m;
        public int m0;
        public int n;
        public int n0;
        public int o;
        public int o0;
        public int p;
        public float p0;
        public int q;
        public float q0;
        public int r;
        public boolean r0;
        public int s;
        public int s0;
        public int t;
        public int t0;
        public float u;
        public int[] u0;
        public float v;
        public String v0;
        public String w;
        public int x;
        public int y;
        public float z;

        private b() {
            this.f1126a = false;
            this.f1130e = -1;
            this.f = -1;
            this.g = -1.0f;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = 0;
            this.z = 0.0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.a0 = 1.0f;
            this.b0 = 1.0f;
            this.c0 = Float.NaN;
            this.d0 = Float.NaN;
            this.e0 = 0.0f;
            this.f0 = 0.0f;
            this.g0 = 0.0f;
            this.h0 = false;
            this.i0 = false;
            this.j0 = 0;
            this.k0 = 0;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = -1;
            this.p0 = 1.0f;
            this.q0 = 1.0f;
            this.r0 = false;
            this.s0 = -1;
            this.t0 = -1;
        }

        private void a(int i, ConstraintLayout.a aVar) {
            this.f1129d = i;
            this.h = aVar.f1116d;
            this.i = aVar.f1117e;
            this.j = aVar.f;
            this.k = aVar.g;
            this.l = aVar.h;
            this.m = aVar.i;
            this.n = aVar.j;
            this.o = aVar.k;
            this.p = aVar.l;
            this.q = aVar.p;
            this.r = aVar.q;
            this.s = aVar.r;
            this.t = aVar.s;
            this.u = aVar.z;
            this.v = aVar.A;
            this.w = aVar.B;
            this.x = aVar.m;
            this.y = aVar.n;
            this.z = aVar.o;
            this.A = aVar.P;
            this.B = aVar.Q;
            this.C = aVar.R;
            this.g = aVar.f1115c;
            this.f1130e = aVar.f1113a;
            this.f = aVar.f1114b;
            this.f1127b = ((ViewGroup.MarginLayoutParams) aVar).width;
            this.f1128c = ((ViewGroup.MarginLayoutParams) aVar).height;
            this.D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            this.E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            this.F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            this.G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            this.Q = aVar.E;
            this.R = aVar.D;
            this.T = aVar.G;
            this.S = aVar.F;
            boolean z = aVar.S;
            this.h0 = z;
            this.i0 = aVar.T;
            this.j0 = aVar.H;
            this.k0 = aVar.I;
            this.h0 = z;
            this.l0 = aVar.L;
            this.m0 = aVar.M;
            this.n0 = aVar.J;
            this.o0 = aVar.K;
            this.p0 = aVar.N;
            this.q0 = aVar.O;
            if (Build.VERSION.SDK_INT >= 17) {
                this.H = aVar.getMarginEnd();
                this.I = aVar.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, d.a aVar) {
            a(i, (ConstraintLayout.a) aVar);
            this.U = aVar.m0;
            this.X = aVar.p0;
            this.Y = aVar.q0;
            this.Z = aVar.r0;
            this.a0 = aVar.s0;
            this.b0 = aVar.t0;
            this.c0 = aVar.u0;
            this.d0 = aVar.v0;
            this.e0 = aVar.w0;
            this.f0 = aVar.x0;
            this.g0 = aVar.y0;
            this.W = aVar.o0;
            this.V = aVar.n0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(androidx.constraintlayout.widget.b bVar, int i, d.a aVar) {
            a(i, aVar);
            if (bVar instanceof androidx.constraintlayout.widget.a) {
                this.t0 = 1;
                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) bVar;
                this.s0 = aVar2.getType();
                this.u0 = aVar2.getReferencedIds();
            }
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.f1116d = this.h;
            aVar.f1117e = this.i;
            aVar.f = this.j;
            aVar.g = this.k;
            aVar.h = this.l;
            aVar.i = this.m;
            aVar.j = this.n;
            aVar.k = this.o;
            aVar.l = this.p;
            aVar.p = this.q;
            aVar.q = this.r;
            aVar.r = this.s;
            aVar.s = this.t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = this.D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = this.E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = this.F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = this.G;
            aVar.x = this.P;
            aVar.y = this.O;
            aVar.z = this.u;
            aVar.A = this.v;
            aVar.m = this.x;
            aVar.n = this.y;
            aVar.o = this.z;
            aVar.B = this.w;
            aVar.P = this.A;
            aVar.Q = this.B;
            aVar.E = this.Q;
            aVar.D = this.R;
            aVar.G = this.T;
            aVar.F = this.S;
            aVar.S = this.h0;
            aVar.T = this.i0;
            aVar.H = this.j0;
            aVar.I = this.k0;
            aVar.L = this.l0;
            aVar.M = this.m0;
            aVar.J = this.n0;
            aVar.K = this.o0;
            aVar.N = this.p0;
            aVar.O = this.q0;
            aVar.R = this.C;
            aVar.f1115c = this.g;
            aVar.f1113a = this.f1130e;
            aVar.f1114b = this.f;
            ((ViewGroup.MarginLayoutParams) aVar).width = this.f1127b;
            ((ViewGroup.MarginLayoutParams) aVar).height = this.f1128c;
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.I);
                aVar.setMarginEnd(this.H);
            }
            aVar.a();
        }

        public b clone() {
            b bVar = new b();
            bVar.f1126a = this.f1126a;
            bVar.f1127b = this.f1127b;
            bVar.f1128c = this.f1128c;
            bVar.f1130e = this.f1130e;
            bVar.f = this.f;
            bVar.g = this.g;
            bVar.h = this.h;
            bVar.i = this.i;
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.l = this.l;
            bVar.m = this.m;
            bVar.n = this.n;
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            bVar.r = this.r;
            bVar.s = this.s;
            bVar.t = this.t;
            bVar.u = this.u;
            bVar.v = this.v;
            bVar.w = this.w;
            bVar.A = this.A;
            bVar.B = this.B;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.C = this.C;
            bVar.D = this.D;
            bVar.E = this.E;
            bVar.F = this.F;
            bVar.G = this.G;
            bVar.H = this.H;
            bVar.I = this.I;
            bVar.J = this.J;
            bVar.K = this.K;
            bVar.L = this.L;
            bVar.M = this.M;
            bVar.N = this.N;
            bVar.O = this.O;
            bVar.P = this.P;
            bVar.Q = this.Q;
            bVar.R = this.R;
            bVar.S = this.S;
            bVar.T = this.T;
            bVar.U = this.U;
            bVar.V = this.V;
            bVar.W = this.W;
            bVar.X = this.X;
            bVar.Y = this.Y;
            bVar.Z = this.Z;
            bVar.a0 = this.a0;
            bVar.b0 = this.b0;
            bVar.c0 = this.c0;
            bVar.d0 = this.d0;
            bVar.e0 = this.e0;
            bVar.f0 = this.f0;
            bVar.g0 = this.g0;
            bVar.h0 = this.h0;
            bVar.i0 = this.i0;
            bVar.j0 = this.j0;
            bVar.k0 = this.k0;
            bVar.l0 = this.l0;
            bVar.m0 = this.m0;
            bVar.n0 = this.n0;
            bVar.o0 = this.o0;
            bVar.p0 = this.p0;
            bVar.q0 = this.q0;
            bVar.s0 = this.s0;
            bVar.t0 = this.t0;
            int[] iArr = this.u0;
            if (iArr != null) {
                bVar.u0 = Arrays.copyOf(iArr, iArr.length);
            }
            bVar.x = this.x;
            bVar.y = this.y;
            bVar.z = this.z;
            bVar.r0 = this.r0;
            return bVar;
        }
    }

    static {
        f1124c.append(h.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1124c.append(h.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1124c.append(h.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1124c.append(h.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1124c.append(h.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1124c.append(h.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1124c.append(h.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1124c.append(h.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1124c.append(h.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1124c.append(h.ConstraintSet_layout_editor_absoluteX, 6);
        f1124c.append(h.ConstraintSet_layout_editor_absoluteY, 7);
        f1124c.append(h.ConstraintSet_layout_constraintGuide_begin, 17);
        f1124c.append(h.ConstraintSet_layout_constraintGuide_end, 18);
        f1124c.append(h.ConstraintSet_layout_constraintGuide_percent, 19);
        f1124c.append(h.ConstraintSet_android_orientation, 27);
        f1124c.append(h.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1124c.append(h.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1124c.append(h.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1124c.append(h.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1124c.append(h.ConstraintSet_layout_goneMarginLeft, 13);
        f1124c.append(h.ConstraintSet_layout_goneMarginTop, 16);
        f1124c.append(h.ConstraintSet_layout_goneMarginRight, 14);
        f1124c.append(h.ConstraintSet_layout_goneMarginBottom, 11);
        f1124c.append(h.ConstraintSet_layout_goneMarginStart, 15);
        f1124c.append(h.ConstraintSet_layout_goneMarginEnd, 12);
        f1124c.append(h.ConstraintSet_layout_constraintVertical_weight, 40);
        f1124c.append(h.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1124c.append(h.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1124c.append(h.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1124c.append(h.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1124c.append(h.ConstraintSet_layout_constraintVertical_bias, 37);
        f1124c.append(h.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1124c.append(h.ConstraintSet_layout_constraintLeft_creator, 75);
        f1124c.append(h.ConstraintSet_layout_constraintTop_creator, 75);
        f1124c.append(h.ConstraintSet_layout_constraintRight_creator, 75);
        f1124c.append(h.ConstraintSet_layout_constraintBottom_creator, 75);
        f1124c.append(h.ConstraintSet_layout_constraintBaseline_creator, 75);
        f1124c.append(h.ConstraintSet_android_layout_marginLeft, 24);
        f1124c.append(h.ConstraintSet_android_layout_marginRight, 28);
        f1124c.append(h.ConstraintSet_android_layout_marginStart, 31);
        f1124c.append(h.ConstraintSet_android_layout_marginEnd, 8);
        f1124c.append(h.ConstraintSet_android_layout_marginTop, 34);
        f1124c.append(h.ConstraintSet_android_layout_marginBottom, 2);
        f1124c.append(h.ConstraintSet_android_layout_width, 23);
        f1124c.append(h.ConstraintSet_android_layout_height, 21);
        f1124c.append(h.ConstraintSet_android_visibility, 22);
        f1124c.append(h.ConstraintSet_android_alpha, 43);
        f1124c.append(h.ConstraintSet_android_elevation, 44);
        f1124c.append(h.ConstraintSet_android_rotationX, 45);
        f1124c.append(h.ConstraintSet_android_rotationY, 46);
        f1124c.append(h.ConstraintSet_android_rotation, 60);
        f1124c.append(h.ConstraintSet_android_scaleX, 47);
        f1124c.append(h.ConstraintSet_android_scaleY, 48);
        f1124c.append(h.ConstraintSet_android_transformPivotX, 49);
        f1124c.append(h.ConstraintSet_android_transformPivotY, 50);
        f1124c.append(h.ConstraintSet_android_translationX, 51);
        f1124c.append(h.ConstraintSet_android_translationY, 52);
        f1124c.append(h.ConstraintSet_android_translationZ, 53);
        f1124c.append(h.ConstraintSet_layout_constraintWidth_default, 54);
        f1124c.append(h.ConstraintSet_layout_constraintHeight_default, 55);
        f1124c.append(h.ConstraintSet_layout_constraintWidth_max, 56);
        f1124c.append(h.ConstraintSet_layout_constraintHeight_max, 57);
        f1124c.append(h.ConstraintSet_layout_constraintWidth_min, 58);
        f1124c.append(h.ConstraintSet_layout_constraintHeight_min, 59);
        f1124c.append(h.ConstraintSet_layout_constraintCircle, 61);
        f1124c.append(h.ConstraintSet_layout_constraintCircleRadius, 62);
        f1124c.append(h.ConstraintSet_layout_constraintCircleAngle, 63);
        f1124c.append(h.ConstraintSet_android_id, 38);
        f1124c.append(h.ConstraintSet_layout_constraintWidth_percent, 69);
        f1124c.append(h.ConstraintSet_layout_constraintHeight_percent, 70);
        f1124c.append(h.ConstraintSet_chainUseRtl, 71);
        f1124c.append(h.ConstraintSet_barrierDirection, 72);
        f1124c.append(h.ConstraintSet_constraint_referenced_ids, 73);
        f1124c.append(h.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private b a(Context context, AttributeSet attributeSet) {
        b bVar = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintSet);
        a(bVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return bVar;
    }

    private void a(b bVar, TypedArray typedArray) {
        StringBuilder sb;
        String str;
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f1124c.get(index);
            switch (i2) {
                case 1:
                    bVar.p = a(typedArray, index, bVar.p);
                    break;
                case 2:
                    bVar.G = typedArray.getDimensionPixelSize(index, bVar.G);
                    break;
                case 3:
                    bVar.o = a(typedArray, index, bVar.o);
                    break;
                case 4:
                    bVar.n = a(typedArray, index, bVar.n);
                    break;
                case 5:
                    bVar.w = typedArray.getString(index);
                    break;
                case 6:
                    bVar.A = typedArray.getDimensionPixelOffset(index, bVar.A);
                    break;
                case 7:
                    bVar.B = typedArray.getDimensionPixelOffset(index, bVar.B);
                    break;
                case 8:
                    bVar.H = typedArray.getDimensionPixelSize(index, bVar.H);
                    break;
                case 9:
                    bVar.t = a(typedArray, index, bVar.t);
                    break;
                case 10:
                    bVar.s = a(typedArray, index, bVar.s);
                    break;
                case 11:
                    bVar.N = typedArray.getDimensionPixelSize(index, bVar.N);
                    break;
                case 12:
                    bVar.O = typedArray.getDimensionPixelSize(index, bVar.O);
                    break;
                case 13:
                    bVar.K = typedArray.getDimensionPixelSize(index, bVar.K);
                    break;
                case 14:
                    bVar.M = typedArray.getDimensionPixelSize(index, bVar.M);
                    break;
                case 15:
                    bVar.P = typedArray.getDimensionPixelSize(index, bVar.P);
                    break;
                case 16:
                    bVar.L = typedArray.getDimensionPixelSize(index, bVar.L);
                    break;
                case 17:
                    bVar.f1130e = typedArray.getDimensionPixelOffset(index, bVar.f1130e);
                    break;
                case 18:
                    bVar.f = typedArray.getDimensionPixelOffset(index, bVar.f);
                    break;
                case 19:
                    bVar.g = typedArray.getFloat(index, bVar.g);
                    break;
                case 20:
                    bVar.u = typedArray.getFloat(index, bVar.u);
                    break;
                case 21:
                    bVar.f1128c = typedArray.getLayoutDimension(index, bVar.f1128c);
                    break;
                case 22:
                    bVar.J = typedArray.getInt(index, bVar.J);
                    bVar.J = f1123b[bVar.J];
                    break;
                case 23:
                    bVar.f1127b = typedArray.getLayoutDimension(index, bVar.f1127b);
                    break;
                case 24:
                    bVar.D = typedArray.getDimensionPixelSize(index, bVar.D);
                    break;
                case 25:
                    bVar.h = a(typedArray, index, bVar.h);
                    break;
                case 26:
                    bVar.i = a(typedArray, index, bVar.i);
                    break;
                case 27:
                    bVar.C = typedArray.getInt(index, bVar.C);
                    break;
                case 28:
                    bVar.E = typedArray.getDimensionPixelSize(index, bVar.E);
                    break;
                case 29:
                    bVar.j = a(typedArray, index, bVar.j);
                    break;
                case 30:
                    bVar.k = a(typedArray, index, bVar.k);
                    break;
                case 31:
                    bVar.I = typedArray.getDimensionPixelSize(index, bVar.I);
                    break;
                case 32:
                    bVar.q = a(typedArray, index, bVar.q);
                    break;
                case 33:
                    bVar.r = a(typedArray, index, bVar.r);
                    break;
                case 34:
                    bVar.F = typedArray.getDimensionPixelSize(index, bVar.F);
                    break;
                case 35:
                    bVar.m = a(typedArray, index, bVar.m);
                    break;
                case 36:
                    bVar.l = a(typedArray, index, bVar.l);
                    break;
                case 37:
                    bVar.v = typedArray.getFloat(index, bVar.v);
                    break;
                case 38:
                    bVar.f1129d = typedArray.getResourceId(index, bVar.f1129d);
                    break;
                case 39:
                    bVar.R = typedArray.getFloat(index, bVar.R);
                    break;
                case 40:
                    bVar.Q = typedArray.getFloat(index, bVar.Q);
                    break;
                case 41:
                    bVar.S = typedArray.getInt(index, bVar.S);
                    break;
                case 42:
                    bVar.T = typedArray.getInt(index, bVar.T);
                    break;
                case 43:
                    bVar.U = typedArray.getFloat(index, bVar.U);
                    break;
                case 44:
                    bVar.V = true;
                    bVar.W = typedArray.getDimension(index, bVar.W);
                    break;
                case 45:
                    bVar.Y = typedArray.getFloat(index, bVar.Y);
                    break;
                case 46:
                    bVar.Z = typedArray.getFloat(index, bVar.Z);
                    break;
                case 47:
                    bVar.a0 = typedArray.getFloat(index, bVar.a0);
                    break;
                case 48:
                    bVar.b0 = typedArray.getFloat(index, bVar.b0);
                    break;
                case 49:
                    bVar.c0 = typedArray.getFloat(index, bVar.c0);
                    break;
                case 50:
                    bVar.d0 = typedArray.getFloat(index, bVar.d0);
                    break;
                case 51:
                    bVar.e0 = typedArray.getDimension(index, bVar.e0);
                    break;
                case 52:
                    bVar.f0 = typedArray.getDimension(index, bVar.f0);
                    break;
                case 53:
                    bVar.g0 = typedArray.getDimension(index, bVar.g0);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            bVar.X = typedArray.getFloat(index, bVar.X);
                            continue;
                        case 61:
                            bVar.x = a(typedArray, index, bVar.x);
                            continue;
                        case 62:
                            bVar.y = typedArray.getDimensionPixelSize(index, bVar.y);
                            continue;
                        case 63:
                            bVar.z = typedArray.getFloat(index, bVar.z);
                            continue;
                        default:
                            switch (i2) {
                                case 69:
                                    bVar.p0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    bVar.q0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    bVar.s0 = typedArray.getInt(index, bVar.s0);
                                    break;
                                case 73:
                                    bVar.v0 = typedArray.getString(index);
                                    break;
                                case 74:
                                    bVar.r0 = typedArray.getBoolean(index, bVar.r0);
                                    break;
                                case 75:
                                    sb = new StringBuilder();
                                    str = "unused attribute 0x";
                                    sb.append(str);
                                    sb.append(Integer.toHexString(index));
                                    sb.append("   ");
                                    sb.append(f1124c.get(index));
                                    Log.w("ConstraintSet", sb.toString());
                                    continue;
                                default:
                                    sb = new StringBuilder();
                                    str = "Unknown attribute 0x";
                                    sb.append(str);
                                    sb.append(Integer.toHexString(index));
                                    sb.append("   ");
                                    sb.append(f1124c.get(index));
                                    Log.w("ConstraintSet", sb.toString());
                                    continue;
                            }
                    }
            }
        }
    }

    private int[] a(View view, String str) {
        int i;
        Object a2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        for (String str2 : split) {
            String trim = str2.trim();
            try {
                i = g.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) view.getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
                i = ((Integer) a2).intValue();
            }
            i2++;
            iArr[i2] = i;
        }
        return i2 != split.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public void a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    b a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.f1126a = true;
                    }
                    this.f1125a.put(Integer.valueOf(a2.f1129d), a2);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1125a.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f1125a.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    b bVar = this.f1125a.get(Integer.valueOf(id));
                    if (childAt instanceof androidx.constraintlayout.widget.a) {
                        bVar.t0 = 1;
                    }
                    int i2 = bVar.t0;
                    if (i2 != -1 && i2 == 1) {
                        androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) childAt;
                        aVar.setId(id);
                        aVar.setType(bVar.s0);
                        aVar.setAllowsGoneWidget(bVar.r0);
                        int[] iArr = bVar.u0;
                        if (iArr != null) {
                            aVar.setReferencedIds(iArr);
                        } else {
                            String str = bVar.v0;
                            if (str != null) {
                                bVar.u0 = a(aVar, str);
                                aVar.setReferencedIds(bVar.u0);
                            }
                        }
                    }
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                    bVar.a(aVar2);
                    childAt.setLayoutParams(aVar2);
                    childAt.setVisibility(bVar.J);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(bVar.U);
                        childAt.setRotation(bVar.X);
                        childAt.setRotationX(bVar.Y);
                        childAt.setRotationY(bVar.Z);
                        childAt.setScaleX(bVar.a0);
                        childAt.setScaleY(bVar.b0);
                        if (!Float.isNaN(bVar.c0)) {
                            childAt.setPivotX(bVar.c0);
                        }
                        if (!Float.isNaN(bVar.d0)) {
                            childAt.setPivotY(bVar.d0);
                        }
                        childAt.setTranslationX(bVar.e0);
                        childAt.setTranslationY(bVar.f0);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(bVar.g0);
                            if (bVar.V) {
                                childAt.setElevation(bVar.W);
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            b bVar2 = this.f1125a.get(num);
            int i3 = bVar2.t0;
            if (i3 != -1 && i3 == 1) {
                androidx.constraintlayout.widget.a aVar3 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                aVar3.setId(num.intValue());
                int[] iArr2 = bVar2.u0;
                if (iArr2 != null) {
                    aVar3.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar2.v0;
                    if (str2 != null) {
                        bVar2.u0 = a(aVar3, str2);
                        aVar3.setReferencedIds(bVar2.u0);
                    }
                }
                aVar3.setType(bVar2.s0);
                ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                aVar3.a();
                bVar2.a(generateDefaultLayoutParams);
                constraintLayout.addView(aVar3, generateDefaultLayoutParams);
            }
            if (bVar2.f1126a) {
                View eVar = new e(constraintLayout.getContext());
                eVar.setId(num.intValue());
                ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                bVar2.a(generateDefaultLayoutParams2);
                constraintLayout.addView(eVar, generateDefaultLayoutParams2);
            }
        }
    }

    public void a(d dVar) {
        int childCount = dVar.getChildCount();
        this.f1125a.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = dVar.getChildAt(i);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f1125a.containsKey(Integer.valueOf(id))) {
                    this.f1125a.put(Integer.valueOf(id), new b());
                }
                b bVar = this.f1125a.get(Integer.valueOf(id));
                if (childAt instanceof androidx.constraintlayout.widget.b) {
                    bVar.a((androidx.constraintlayout.widget.b) childAt, id, aVar);
                }
                bVar.a(id, aVar);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }
}
