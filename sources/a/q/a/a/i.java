package a.q.a.a;

import a.g.e.b;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class i extends a.q.a.a.h {
    static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private h f637c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f638d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f639e;
    private boolean f;
    private boolean g;
    private final float[] h;
    private final Matrix i;
    private final Rect j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f648b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f647a = a.g.e.b.a(string2);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.c.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = androidx.core.content.c.g.a(resources, theme, attributeSet, a.q.a.a.a.f620d);
                a(a2);
                a2.recycle();
            }
        }

        @Override // a.q.a.a.i.f
        public boolean b() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: d  reason: collision with root package name */
        private int[] f640d;

        /* renamed from: e  reason: collision with root package name */
        androidx.core.content.c.b f641e;
        float f;
        androidx.core.content.c.b g;
        float h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public c() {
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public c(c cVar) {
            super(cVar);
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f640d = cVar.f640d;
            this.f641e = cVar.f641e;
            this.f = cVar.f;
            this.h = cVar.h;
            this.g = cVar.g;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join a(int i, Paint.Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f640d = null;
            if (androidx.core.content.c.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f648b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f647a = a.g.e.b.a(string2);
                }
                this.g = androidx.core.content.c.g.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = androidx.core.content.c.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(androidx.core.content.c.g.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(androidx.core.content.c.g.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.c.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f641e = androidx.core.content.c.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.h = androidx.core.content.c.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = androidx.core.content.c.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = androidx.core.content.c.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = androidx.core.content.c.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = androidx.core.content.c.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = androidx.core.content.c.g.b(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.c.g.a(resources, theme, attributeSet, a.q.a.a.a.f619c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        @Override // a.q.a.a.i.e
        public boolean a() {
            return this.g.d() || this.f641e.d();
        }

        @Override // a.q.a.a.i.e
        public boolean a(int[] iArr) {
            return this.f641e.a(iArr) | this.g.a(iArr);
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.g.a();
        }

        float getStrokeAlpha() {
            return this.h;
        }

        int getStrokeColor() {
            return this.f641e.a();
        }

        float getStrokeWidth() {
            return this.f;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.g.a(i);
        }

        void setStrokeAlpha(float f) {
            this.h = f;
        }

        void setStrokeColor(int i) {
            this.f641e.a(i);
        }

        void setStrokeWidth(float f) {
            this.f = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f642a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f643b;

        /* renamed from: c  reason: collision with root package name */
        float f644c;

        /* renamed from: d  reason: collision with root package name */
        private float f645d;

        /* renamed from: e  reason: collision with root package name */
        private float f646e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d() {
            super();
            this.f642a = new Matrix();
            this.f643b = new ArrayList<>();
            this.f644c = 0.0f;
            this.f645d = 0.0f;
            this.f646e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d dVar, a.d.a<String, Object> aVar) {
            super();
            f fVar;
            this.f642a = new Matrix();
            this.f643b = new ArrayList<>();
            this.f644c = 0.0f;
            this.f645d = 0.0f;
            this.f646e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f644c = dVar.f644c;
            this.f645d = dVar.f645d;
            this.f646e = dVar.f646e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            this.m = dVar.m;
            this.k = dVar.k;
            String str = this.m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f643b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.f643b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f643b.add(fVar);
                    String str2 = fVar.f648b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f644c = androidx.core.content.c.g.a(typedArray, xmlPullParser, "rotation", 5, this.f644c);
            this.f645d = typedArray.getFloat(1, this.f645d);
            this.f646e = typedArray.getFloat(2, this.f646e);
            this.f = androidx.core.content.c.g.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = androidx.core.content.c.g.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = androidx.core.content.c.g.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = androidx.core.content.c.g.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.f645d, -this.f646e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f644c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f645d, this.i + this.f646e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.c.g.a(resources, theme, attributeSet, a.q.a.a.a.f618b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        @Override // a.q.a.a.i.e
        public boolean a() {
            for (int i = 0; i < this.f643b.size(); i++) {
                if (this.f643b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.q.a.a.i.e
        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f643b.size(); i++) {
                z |= this.f643b.get(i).a(iArr);
            }
            return z;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f645d;
        }

        public float getPivotY() {
            return this.f646e;
        }

        public float getRotation() {
            return this.f644c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.f645d) {
                this.f645d = f;
                b();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f646e) {
                this.f646e = f;
                b();
            }
        }

        public void setRotation(float f) {
            if (f != this.f644c) {
                this.f644c = f;
                b();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                b();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                b();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                b();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected b.C0006b[] f647a;

        /* renamed from: b  reason: collision with root package name */
        String f648b;

        /* renamed from: c  reason: collision with root package name */
        int f649c;

        public f() {
            super();
            this.f647a = null;
        }

        public f(f fVar) {
            super();
            this.f647a = null;
            this.f648b = fVar.f648b;
            this.f649c = fVar.f649c;
            this.f647a = a.g.e.b.a(fVar.f647a);
        }

        public void a(Path path) {
            path.reset();
            b.C0006b[] bVarArr = this.f647a;
            if (bVarArr != null) {
                b.C0006b.a(bVarArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public b.C0006b[] getPathData() {
            return this.f647a;
        }

        public String getPathName() {
            return this.f648b;
        }

        public void setPathData(b.C0006b[] bVarArr) {
            if (!a.g.e.b.a(this.f647a, bVarArr)) {
                this.f647a = a.g.e.b.a(bVarArr);
            } else {
                a.g.e.b.b(this.f647a, bVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f650a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f651b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f652c;

        /* renamed from: d  reason: collision with root package name */
        Paint f653d;

        /* renamed from: e  reason: collision with root package name */
        Paint f654e;
        private PathMeasure f;
        private int g;
        final d h;
        float i;
        float j;
        float k;
        float l;
        int m;
        String n;
        Boolean o;
        final a.d.a<String, Object> p;

        public g() {
            this.f652c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new a.d.a<>();
            this.h = new d();
            this.f650a = new Path();
            this.f651b = new Path();
        }

        public g(g gVar) {
            this.f652c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new a.d.a<>();
            this.h = new d(gVar.h, this.p);
            this.f650a = new Path(gVar.f650a);
            this.f651b = new Path(gVar.f651b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        private void a(d dVar, f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.k;
            float f2 = i2 / this.l;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.f642a;
            this.f652c.set(matrix);
            this.f652c.postScale(f, f2);
            float a2 = a(matrix);
            if (a2 != 0.0f) {
                fVar.a(this.f650a);
                Path path = this.f650a;
                this.f651b.reset();
                if (fVar.b()) {
                    this.f651b.addPath(path, this.f652c);
                    canvas.clipPath(this.f651b);
                    return;
                }
                c cVar = (c) fVar;
                if (!(cVar.k == 0.0f && cVar.l == 1.0f)) {
                    float f3 = cVar.k;
                    float f4 = cVar.m;
                    float f5 = (f3 + f4) % 1.0f;
                    float f6 = (cVar.l + f4) % 1.0f;
                    if (this.f == null) {
                        this.f = new PathMeasure();
                    }
                    this.f.setPath(this.f650a, false);
                    float length = this.f.getLength();
                    float f7 = f5 * length;
                    float f8 = f6 * length;
                    path.reset();
                    if (f7 > f8) {
                        this.f.getSegment(f7, length, path, true);
                        this.f.getSegment(0.0f, f8, path, true);
                    } else {
                        this.f.getSegment(f7, f8, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f651b.addPath(path, this.f652c);
                if (cVar.g.e()) {
                    androidx.core.content.c.b bVar = cVar.g;
                    if (this.f654e == null) {
                        this.f654e = new Paint(1);
                        this.f654e.setStyle(Paint.Style.FILL);
                    }
                    Paint paint = this.f654e;
                    if (bVar.c()) {
                        Shader b2 = bVar.b();
                        b2.setLocalMatrix(this.f652c);
                        paint.setShader(b2);
                        paint.setAlpha(Math.round(cVar.j * 255.0f));
                    } else {
                        paint.setShader(null);
                        paint.setAlpha(255);
                        paint.setColor(i.a(bVar.a(), cVar.j));
                    }
                    paint.setColorFilter(colorFilter);
                    this.f651b.setFillType(cVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f651b, paint);
                }
                if (cVar.f641e.e()) {
                    androidx.core.content.c.b bVar2 = cVar.f641e;
                    if (this.f653d == null) {
                        this.f653d = new Paint(1);
                        this.f653d.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint2 = this.f653d;
                    Paint.Join join = cVar.o;
                    if (join != null) {
                        paint2.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.n;
                    if (cap != null) {
                        paint2.setStrokeCap(cap);
                    }
                    paint2.setStrokeMiter(cVar.p);
                    if (bVar2.c()) {
                        Shader b3 = bVar2.b();
                        b3.setLocalMatrix(this.f652c);
                        paint2.setShader(b3);
                        paint2.setAlpha(Math.round(cVar.h * 255.0f));
                    } else {
                        paint2.setShader(null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(bVar2.a(), cVar.h));
                    }
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(cVar.f * min * a2);
                    canvas.drawPath(this.f651b, paint2);
                }
            }
        }

        private void a(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.f642a.set(matrix);
            dVar.f642a.preConcat(dVar.j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.f643b.size(); i3++) {
                e eVar = dVar.f643b.get(i3);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.f642a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    a(dVar, (f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.h, q, canvas, i, i2, colorFilter);
        }

        public boolean a() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.h.a(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f655a;

        /* renamed from: b  reason: collision with root package name */
        g f656b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f657c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f658d;

        /* renamed from: e  reason: collision with root package name */
        boolean f659e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public h() {
            this.f657c = null;
            this.f658d = i.k;
            this.f656b = new g();
        }

        public h(h hVar) {
            this.f657c = null;
            this.f658d = i.k;
            if (hVar != null) {
                this.f655a = hVar.f655a;
                this.f656b = new g(hVar.f656b);
                Paint paint = hVar.f656b.f654e;
                if (paint != null) {
                    this.f656b.f654e = new Paint(paint);
                }
                Paint paint2 = hVar.f656b.f653d;
                if (paint2 != null) {
                    this.f656b.f653d = new Paint(paint2);
                }
                this.f657c = hVar.f657c;
                this.f658d = hVar.f658d;
                this.f659e = hVar.f659e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!b() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f656b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return !this.k && this.g == this.f657c && this.h == this.f658d && this.j == this.f659e && this.i == this.f656b.getRootAlpha();
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f656b.a(iArr);
            this.k |= a2;
            return a2;
        }

        public void b(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            return this.f656b.getRootAlpha() < 255;
        }

        public void c(int i, int i2) {
            this.f.eraseColor(0);
            this.f656b.a(new Canvas(this.f), i, i2, (ColorFilter) null);
        }

        public boolean c() {
            return this.f656b.a();
        }

        public void d() {
            this.g = this.f657c;
            this.h = this.f658d;
            this.i = this.f656b.getRootAlpha();
            this.j = this.f659e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f655a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    /* renamed from: a.q.a.a.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0029i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f660a;

        public C0029i(Drawable.ConstantState constantState) {
            this.f660a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f660a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f660a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f636b = (VectorDrawable) this.f660a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f636b = (VectorDrawable) this.f660a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f636b = (VectorDrawable) this.f660a.newDrawable(resources, theme);
            return iVar;
        }
    }

    i() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f637c = new h();
    }

    i(h hVar) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f637c = hVar;
        this.f638d = a(this.f638d, hVar.f657c, hVar.f658d);
    }

    static int a(int i, float f2) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    public static i a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f636b = androidx.core.content.c.f.a(resources, i, theme);
            new C0029i(iVar.f636b.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i;
        int i2;
        b bVar;
        h hVar = this.f637c;
        g gVar = hVar.f656b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f643b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    bVar = cVar;
                } else if ("clip-path".equals(name)) {
                    b bVar2 = new b();
                    bVar2.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f643b.add(bVar2);
                    String pathName = bVar2.getPathName();
                    bVar = bVar2;
                    if (pathName != null) {
                        gVar.p.put(bVar2.getPathName(), bVar2);
                        bVar = bVar2;
                    }
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f643b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    i = hVar.f655a;
                    i2 = dVar2.k;
                    hVar.f655a = i2 | i;
                }
                i = hVar.f655a;
                i2 = bVar.f649c;
                hVar.f655a = i2 | i;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        h hVar = this.f637c;
        g gVar = hVar.f656b;
        hVar.f658d = a(androidx.core.content.c.g.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            hVar.f657c = colorStateList;
        }
        hVar.f659e = androidx.core.content.c.g.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f659e);
        gVar.k = androidx.core.content.c.g.a(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        gVar.l = androidx.core.content.c.g.a(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        if (gVar.k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (gVar.l > 0.0f) {
            gVar.i = typedArray.getDimension(3, gVar.i);
            gVar.j = typedArray.getDimension(2, gVar.j);
            if (gVar.i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (gVar.j > 0.0f) {
                gVar.setAlpha(androidx.core.content.c.g.a(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.n = string;
                    gVar.p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    public static i createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f637c.f656b.p.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f636b;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.a(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.j);
        if (this.j.width() > 0 && this.j.height() > 0) {
            ColorFilter colorFilter = this.f639e;
            if (colorFilter == null) {
                colorFilter = this.f638d;
            }
            canvas.getMatrix(this.i);
            this.i.getValues(this.h);
            float abs = Math.abs(this.h[0]);
            float abs2 = Math.abs(this.h[4]);
            float abs3 = Math.abs(this.h[1]);
            float abs4 = Math.abs(this.h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.j.width() * abs));
            int min2 = Math.min(2048, (int) (this.j.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.j;
                canvas.translate(rect.left, rect.top);
                if (a()) {
                    canvas.translate(this.j.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.j.offsetTo(0, 0);
                this.f637c.b(min, min2);
                if (!this.g) {
                    this.f637c.c(min, min2);
                } else if (!this.f637c.a()) {
                    this.f637c.c(min, min2);
                    this.f637c.d();
                }
                this.f637c.a(canvas, colorFilter, this.j);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f636b;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f637c.f656b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f636b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f637c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f636b;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new C0029i(drawable.getConstantState());
        }
        this.f637c.f655a = getChangingConfigurations();
        return this.f637c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f636b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f637c.f656b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f636b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f637c.f656b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f637c;
        hVar.f656b = new g();
        TypedArray a2 = androidx.core.content.c.g.a(resources, theme, attributeSet, a.q.a.a.a.f617a);
        a(a2, xmlPullParser);
        a2.recycle();
        hVar.f655a = getChangingConfigurations();
        hVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f638d = a(this.f638d, hVar.f657c, hVar.f658d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f636b;
        return drawable != null ? androidx.core.graphics.drawable.a.f(drawable) : this.f637c.f659e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f636b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f637c) != null && (hVar.c() || ((colorStateList = this.f637c.f657c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f637c = new h(this.f637c);
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f636b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f637c;
        ColorStateList colorStateList = hVar.f657c;
        if (!(colorStateList == null || (mode = hVar.f658d) == null)) {
            this.f638d = a(this.f638d, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.c() || !hVar.a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f637c.f656b.getRootAlpha() != i) {
            this.f637c.f656b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f637c.f659e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f639e = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            return;
        }
        h hVar = this.f637c;
        if (hVar.f657c != colorStateList) {
            hVar.f657c = colorStateList;
            this.f638d = a(this.f638d, colorStateList, hVar.f658d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
            return;
        }
        h hVar = this.f637c;
        if (hVar.f658d != mode) {
            hVar.f658d = mode;
            this.f638d = a(this.f638d, hVar.f657c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f636b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f636b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
