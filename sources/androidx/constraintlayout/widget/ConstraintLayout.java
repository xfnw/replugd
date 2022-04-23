package androidx.constraintlayout.widget;

import a.e.a.j.f;
import a.e.a.j.g;
import a.e.a.j.i;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    SparseArray<View> f1109b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<b> f1110c = new ArrayList<>(4);

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<f> f1111d = new ArrayList<>(100);

    /* renamed from: e  reason: collision with root package name */
    g f1112e = new g();
    private int f = 0;
    private int g = 0;
    private int h = Integer.MAX_VALUE;
    private int i = Integer.MAX_VALUE;
    private boolean j = true;
    private int k = 7;
    private c l = null;
    private int m = -1;
    private HashMap<String, Integer> n = new HashMap<>();
    private int o = -1;
    private int p = -1;
    private a.e.a.f q;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        int C;
        public float D;
        public float E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public float N;
        public float O;
        public int P;
        public int Q;
        public int R;
        public boolean S;
        public boolean T;
        boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* renamed from: a  reason: collision with root package name */
        public int f1113a;
        int a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1114b;
        int b0;

        /* renamed from: c  reason: collision with root package name */
        public float f1115c;
        int c0;

        /* renamed from: d  reason: collision with root package name */
        public int f1116d;
        int d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1117e;
        int e0;
        public int f;
        int f0;
        public int g;
        float g0;
        public int h;
        int h0;
        public int i;
        int i0;
        public int j;
        float j0;
        public int k;
        f k0;
        public int l;
        public boolean l0;
        public int m;
        public int n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0036a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f1118a = new SparseIntArray();

            static {
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f1118a.append(h.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f1118a.append(h.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f1118a.append(h.ConstraintLayout_Layout_android_orientation, 1);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f1118a.append(h.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f1118a.append(h.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f1118a.append(h.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f1118a.append(h.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f1118a.append(h.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f1118a.append(h.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f1118a.append(h.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f1118a.append(h.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f1118a.append(h.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f1113a = -1;
            this.f1114b = -1;
            this.f1115c = -1.0f;
            this.f1116d = -1;
            this.f1117e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = true;
            this.V = true;
            this.W = false;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = 0.5f;
            this.k0 = new f();
            this.l0 = false;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            String str;
            int i;
            this.f1113a = -1;
            this.f1114b = -1;
            this.f1115c = -1.0f;
            this.f1116d = -1;
            this.f1117e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = true;
            this.V = true;
            this.W = false;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = 0.5f;
            this.k0 = new f();
            this.l0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (C0036a.f1118a.get(index)) {
                    case 0:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    default:
                    case 1:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        continue;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        continue;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f = this.o;
                        if (f < 0.0f) {
                            this.o = (360.0f - f) % 360.0f;
                        } else {
                            continue;
                        }
                    case 5:
                        this.f1113a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1113a);
                        continue;
                    case 6:
                        this.f1114b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1114b);
                        continue;
                    case 7:
                        this.f1115c = obtainStyledAttributes.getFloat(index, this.f1115c);
                        continue;
                    case 8:
                        this.f1116d = obtainStyledAttributes.getResourceId(index, this.f1116d);
                        if (this.f1116d == -1) {
                            this.f1116d = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 9:
                        this.f1117e = obtainStyledAttributes.getResourceId(index, this.f1117e);
                        if (this.f1117e == -1) {
                            this.f1117e = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 10:
                        this.f = obtainStyledAttributes.getResourceId(index, this.f);
                        if (this.f == -1) {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 11:
                        this.g = obtainStyledAttributes.getResourceId(index, this.g);
                        if (this.g == -1) {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 12:
                        this.h = obtainStyledAttributes.getResourceId(index, this.h);
                        if (this.h == -1) {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 13:
                        this.i = obtainStyledAttributes.getResourceId(index, this.i);
                        if (this.i == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 14:
                        this.j = obtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 15:
                        this.k = obtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 16:
                        this.l = obtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        continue;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        continue;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        continue;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        continue;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        continue;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        continue;
                    case 27:
                        this.S = obtainStyledAttributes.getBoolean(index, this.S);
                        continue;
                    case 28:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        continue;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        continue;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        continue;
                    case 31:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        if (this.H == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case 32:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        if (this.I == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case 33:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                            }
                        }
                    case 34:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                    case 35:
                        this.N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.N));
                        continue;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                    case 37:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                    case 38:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        continue;
                    case 44:
                        this.B = obtainStyledAttributes.getString(index);
                        this.C = -1;
                        String str2 = this.B;
                        if (str2 != null) {
                            int length = str2.length();
                            int indexOf = this.B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i = 0;
                            } else {
                                String substring = this.B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.C = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.C = 1;
                                }
                                i = indexOf + 1;
                            }
                            int indexOf2 = this.B.indexOf(58);
                            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                String substring2 = this.B.substring(i);
                                if (substring2.length() > 0) {
                                    Float.parseFloat(substring2);
                                }
                            } else {
                                String substring3 = this.B.substring(i, indexOf2);
                                String substring4 = this.B.substring(indexOf2 + 1);
                                if (substring3.length() > 0 && substring4.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring3);
                                        float parseFloat2 = Float.parseFloat(substring4);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.C == 1) {
                                                Math.abs(parseFloat2 / parseFloat);
                                            } else {
                                                Math.abs(parseFloat / parseFloat2);
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 45:
                        this.D = obtainStyledAttributes.getFloat(index, this.D);
                        continue;
                    case 46:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        continue;
                    case 47:
                        this.F = obtainStyledAttributes.getInt(index, 0);
                        continue;
                    case 48:
                        this.G = obtainStyledAttributes.getInt(index, 0);
                        continue;
                    case 49:
                        this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                        continue;
                    case 50:
                        this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        continue;
                }
                Log.e("ConstraintLayout", str);
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1113a = -1;
            this.f1114b = -1;
            this.f1115c = -1.0f;
            this.f1116d = -1;
            this.f1117e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 1;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 1.0f;
            this.O = 1.0f;
            this.P = -1;
            this.Q = -1;
            this.R = -1;
            this.S = false;
            this.T = false;
            this.U = true;
            this.V = true;
            this.W = false;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.a0 = -1;
            this.b0 = -1;
            this.c0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = 0.5f;
            this.k0 = new f();
            this.l0 = false;
        }

        public void a() {
            this.X = false;
            this.U = true;
            this.V = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.S) {
                this.U = false;
                this.H = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (((ViewGroup.MarginLayoutParams) this).width == 0 || ((ViewGroup.MarginLayoutParams) this).width == -1) {
                this.U = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == 0 || ((ViewGroup.MarginLayoutParams) this).height == -1) {
                this.V = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.f1115c != -1.0f || this.f1113a != -1 || this.f1114b != -1) {
                this.X = true;
                this.U = true;
                this.V = true;
                if (!(this.k0 instanceof i)) {
                    this.k0 = new i();
                }
                ((i) this.k0).v(this.R);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:73:0x00d6, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00d8, code lost:
            ((android.view.ViewGroup.MarginLayoutParams) r6).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x00e5, code lost:
            if (r1 > 0) goto L_0x00d8;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d6, code lost:
        if (r11 != (-1)) goto L_0x01da;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 981
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a():void");
    }

    private void a(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int i3;
        int i4;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                f fVar = aVar.k0;
                if (!aVar.X && !aVar.Y) {
                    fVar.n(childAt.getVisibility());
                    int i6 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    int i7 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    boolean z3 = aVar.U;
                    if (z3 || aVar.V || (!z3 && aVar.H == 1) || ((ViewGroup.MarginLayoutParams) aVar).width == -1 || (!aVar.V && (aVar.I == 1 || ((ViewGroup.MarginLayoutParams) aVar).height == -1))) {
                        if (i6 == 0) {
                            i3 = ViewGroup.getChildMeasureSpec(i, paddingLeft, -2);
                            z2 = true;
                        } else if (i6 == -1) {
                            i3 = ViewGroup.getChildMeasureSpec(i, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i6 == -2;
                            i3 = ViewGroup.getChildMeasureSpec(i, paddingLeft, i6);
                        }
                        if (i7 == 0) {
                            i4 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
                            z = true;
                        } else if (i7 == -1) {
                            i4 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -1);
                            z = false;
                        } else {
                            z = i7 == -2;
                            i4 = ViewGroup.getChildMeasureSpec(i2, paddingTop, i7);
                        }
                        childAt.measure(i3, i4);
                        a.e.a.f fVar2 = this.q;
                        if (fVar2 != null) {
                            fVar2.f141a++;
                        }
                        fVar.b(i6 == -2);
                        fVar.a(i7 == -2);
                        i6 = childAt.getMeasuredWidth();
                        i7 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    fVar.o(i6);
                    fVar.g(i7);
                    if (z2) {
                        fVar.q(i6);
                    }
                    if (z) {
                        fVar.p(i7);
                    }
                    if (aVar.W && (baseline = childAt.getBaseline()) != -1) {
                        fVar.f(baseline);
                    }
                }
            }
        }
    }

    private void a(AttributeSet attributeSet) {
        this.f1112e.a(this);
        this.f1109b.put(getId(), this);
        this.l = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_android_minWidth) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == h.ConstraintLayout_Layout_android_minHeight) {
                    this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == h.ConstraintLayout_Layout_android_maxWidth) {
                    this.h = obtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == h.ConstraintLayout_Layout_android_maxHeight) {
                    this.i = obtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == h.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.k = obtainStyledAttributes.getInt(index, this.k);
                } else if (index == h.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.l = new c();
                        this.l.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.l = null;
                    }
                    this.m = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1112e.u(this.k);
    }

    private final f b(int i) {
        if (i == 0) {
            return this.f1112e;
        }
        View view = this.f1109b.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1112e;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).k0;
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.f1111d.clear();
            a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 729
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b(int, int):void");
    }

    private void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof f) {
                ((f) childAt).a(this);
            }
        }
        int size = this.f1110c.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f1110c.get(i2).b(this);
            }
        }
    }

    private void c(int i, int i2) {
        f.b bVar;
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        f.b bVar2 = f.b.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                bVar = f.b.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                bVar = bVar2;
            } else {
                i3 = Math.min(this.h, size) - paddingLeft;
                bVar = bVar2;
            }
            i3 = 0;
        } else {
            bVar = f.b.WRAP_CONTENT;
            i3 = size;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                bVar2 = f.b.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.i, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            bVar2 = f.b.WRAP_CONTENT;
        }
        this.f1112e.l(0);
        this.f1112e.k(0);
        this.f1112e.a(bVar);
        this.f1112e.o(i3);
        this.f1112e.b(bVar2);
        this.f1112e.g(size2);
        this.f1112e.l((this.f - getPaddingLeft()) - getPaddingRight());
        this.f1112e.k((this.g - getPaddingTop()) - getPaddingBottom());
    }

    public final f a(View view) {
        if (view == this) {
            return this.f1112e;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).k0;
    }

    public View a(int i) {
        return this.f1109b.get(i);
    }

    public Object a(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public void a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    protected void a(String str) {
        this.f1112e.K();
        a.e.a.f fVar = this.q;
        if (fVar != null) {
            fVar.f143c++;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((parseInt / 1080.0f) * width);
                        int i3 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i2;
                        float f2 = i3;
                        float f3 = i2 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i3 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.i;
    }

    public int getMaxWidth() {
        return this.h;
    }

    public int getMinHeight() {
        return this.g;
    }

    public int getMinWidth() {
        return this.f;
    }

    public int getOptimizationLevel() {
        return this.f1112e.M();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            f fVar = aVar.k0;
            if ((childAt.getVisibility() != 8 || aVar.X || aVar.Y || isInEditMode) && !aVar.Z) {
                int g = fVar.g();
                int h = fVar.h();
                int s = fVar.s() + g;
                int i6 = fVar.i() + h;
                childAt.layout(g, h, s, i6);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(g, h, s, i6);
                }
            }
        }
        int size = this.f1110c.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f1110c.get(i7).a(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        f a2 = a(view);
        if ((view instanceof e) && !(a2 instanceof i)) {
            a aVar = (a) view.getLayoutParams();
            aVar.k0 = new i();
            aVar.X = true;
            ((i) aVar.k0).v(aVar.R);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.a();
            ((a) view.getLayoutParams()).Y = true;
            if (!this.f1110c.contains(bVar)) {
                this.f1110c.add(bVar);
            }
        }
        this.f1109b.put(view.getId(), view);
        this.j = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f1109b.remove(view.getId());
        f a2 = a(view);
        this.f1112e.c(a2);
        this.f1110c.remove(view);
        this.f1111d.remove(a2);
        this.j = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.j = true;
        this.o = -1;
        this.p = -1;
    }

    public void setConstraintSet(c cVar) {
        this.l = cVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f1109b.remove(getId());
        super.setId(i);
        this.f1109b.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.g) {
            this.g = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.f) {
            this.f = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.f1112e.u(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
