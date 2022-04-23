package com.ecloud.eshare.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PinchImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f2961b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnLongClickListener f2962c;

    /* renamed from: e  reason: collision with root package name */
    private RectF f2964e;
    private RectF g;
    private List<g> h;
    private List<g> i;
    private int j;
    private c k;
    private i o;
    private b p;

    /* renamed from: d  reason: collision with root package name */
    private Matrix f2963d = new Matrix();
    private int f = 0;
    private PointF l = new PointF();
    private PointF m = new PointF();
    private float n = 0.0f;
    private GestureDetector q = new GestureDetector(getContext(), new a());

    /* loaded from: classes.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PinchImageView.this.f != 0) {
                return true;
            }
            if (PinchImageView.this.o != null && PinchImageView.this.o.isRunning()) {
                return true;
            }
            PinchImageView.this.a(f, f2);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PinchImageView.this.f2962c != null) {
                PinchImageView.this.f2962c.onLongClick(PinchImageView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PinchImageView.this.f2961b == null) {
                return true;
            }
            PinchImageView.this.f2961b.onClick(PinchImageView.this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private float[] f2966b;

        public b(float f, float f2) {
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.f2966b = new float[]{f, f2};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinchImageView pinchImageView = PinchImageView.this;
            float[] fArr = this.f2966b;
            boolean b2 = pinchImageView.b(fArr[0], fArr[1]);
            float[] fArr2 = this.f2966b;
            fArr2[0] = fArr2[0] * 0.9f;
            fArr2[1] = fArr2[1] * 0.9f;
            if (!b2 || d.b(0.0f, 0.0f, fArr2[0], fArr2[1]) < 1.0f) {
                valueAnimator.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private static e f2968a = new e(16);

        /* renamed from: b  reason: collision with root package name */
        private static h f2969b = new h(16);

        public static Matrix a() {
            return f2968a.b();
        }

        public static void a(RectF rectF) {
            f2969b.a((h) rectF);
        }

        public static float[] a(float f, float f2, float f3, float f4) {
            return new float[]{(f + f3) / 2.0f, (f2 + f4) / 2.0f};
        }

        public static float[] a(Matrix matrix) {
            if (matrix == null) {
                return new float[2];
            }
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return new float[]{fArr[0], fArr[4]};
        }

        public static float[] a(float[] fArr, Matrix matrix) {
            if (fArr == null || matrix == null) {
                return new float[2];
            }
            float[] fArr2 = new float[2];
            Matrix a2 = a();
            matrix.invert(a2);
            a2.mapPoints(fArr2, fArr);
            b(a2);
            return fArr2;
        }

        public static float b(float f, float f2, float f3, float f4) {
            float f5 = f - f3;
            float f6 = f2 - f4;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }

        public static RectF b() {
            return f2969b.b();
        }

        public static void b(Matrix matrix) {
            f2968a.a((e) matrix);
        }

        public static Matrix c(Matrix matrix) {
            Matrix b2 = f2968a.b();
            if (matrix != null) {
                b2.set(matrix);
            }
            return b2;
        }

        public static RectF c(float f, float f2, float f3, float f4) {
            RectF b2 = f2969b.b();
            b2.set(f, f2, f3, f4);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends f<Matrix> {
        public e(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ecloud.eshare.view.PinchImageView.f
        public Matrix a() {
            return new Matrix();
        }

        protected Matrix a(Matrix matrix) {
            matrix.reset();
            return matrix;
        }

        @Override // com.ecloud.eshare.view.PinchImageView.f
        protected /* bridge */ /* synthetic */ Matrix b(Matrix matrix) {
            Matrix matrix2 = matrix;
            a(matrix2);
            return matrix2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        private int f2970a;

        /* renamed from: b  reason: collision with root package name */
        private Queue<T> f2971b = new LinkedList();

        public f(int i) {
            this.f2970a = i;
        }

        protected abstract T a();

        public void a(T t) {
            if (t != null && this.f2971b.size() < this.f2970a) {
                this.f2971b.offer(t);
            }
        }

        public T b() {
            return this.f2971b.size() == 0 ? a() : b(this.f2971b.poll());
        }

        protected abstract T b(T t);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(PinchImageView pinchImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends f<RectF> {
        public h(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ecloud.eshare.view.PinchImageView.f
        public RectF a() {
            return new RectF();
        }

        protected RectF a(RectF rectF) {
            rectF.setEmpty();
            return rectF;
        }

        @Override // com.ecloud.eshare.view.PinchImageView.f
        protected /* bridge */ /* synthetic */ RectF b(RectF rectF) {
            RectF rectF2 = rectF;
            a(rectF2);
            return rectF2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private float[] f2972b;

        /* renamed from: c  reason: collision with root package name */
        private float[] f2973c;

        /* renamed from: d  reason: collision with root package name */
        private float[] f2974d;

        public i(PinchImageView pinchImageView, Matrix matrix, Matrix matrix2) {
            this(matrix, matrix2, 200L);
        }

        public i(Matrix matrix, Matrix matrix2, long j) {
            this.f2972b = new float[9];
            this.f2973c = new float[9];
            this.f2974d = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j);
            addUpdateListener(this);
            matrix.getValues(this.f2972b);
            matrix2.getValues(this.f2973c);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f2974d;
                float[] fArr2 = this.f2972b;
                fArr[i] = fArr2[i] + ((this.f2973c[i] - fArr2[i]) * floatValue);
            }
            PinchImageView.this.f2963d.setValues(this.f2974d);
            PinchImageView.this.c();
            PinchImageView.this.invalidate();
        }
    }

    public PinchImageView(Context context) {
        super(context);
        d();
    }

    public PinchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public PinchImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3) {
        if (e()) {
            b();
            this.p = new b(f2 / 60.0f, f3 / 60.0f);
            this.p.start();
        }
    }

    private void a(float f2, float f3, float f4, float f5) {
        this.n = d.a(this.f2963d)[0] / d.b(f2, f3, f4, f5);
        float[] a2 = d.a(d.a(f2, f3, f4, f5), this.f2963d);
        this.m.set(a2[0], a2[1]);
    }

    private void a(PointF pointF, float f2, float f3, PointF pointF2) {
        if (e()) {
            float f4 = f2 * f3;
            Matrix a2 = d.a();
            a2.postScale(f4, f4, pointF.x, pointF.y);
            a2.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.f2963d.set(a2);
            d.b(a2);
            c();
            invalidate();
        }
    }

    private void b() {
        i iVar = this.o;
        if (iVar != null) {
            iVar.cancel();
            this.o = null;
        }
        b bVar = this.p;
        if (bVar != null) {
            bVar.cancel();
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(float r9, float r10) {
        /*
            r8 = this;
            boolean r0 = r8.e()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.RectF r0 = com.ecloud.eshare.view.PinchImageView.d.b()
            r8.a(r0)
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r3 = r8.getHeight()
            float r3 = (float) r3
            float r4 = r0.right
            float r5 = r0.left
            float r6 = r4 - r5
            r7 = 0
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0026
        L_0x0024:
            r9 = 0
            goto L_0x003e
        L_0x0026:
            float r6 = r5 + r9
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x0032
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0024
            float r9 = -r5
            goto L_0x003e
        L_0x0032:
            float r5 = r4 + r9
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x003e
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x0024
            float r9 = r2 - r4
        L_0x003e:
            float r2 = r0.bottom
            float r4 = r0.top
            float r5 = r2 - r4
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x004a
        L_0x0048:
            r10 = 0
            goto L_0x0062
        L_0x004a:
            float r5 = r4 + r10
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0056
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 >= 0) goto L_0x0048
            float r10 = -r4
            goto L_0x0062
        L_0x0056:
            float r4 = r2 + r10
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0062
            int r10 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x0048
            float r10 = r3 - r2
        L_0x0062:
            com.ecloud.eshare.view.PinchImageView.d.a(r0)
            android.graphics.Matrix r0 = r8.f2963d
            r0.postTranslate(r9, r10)
            r8.c()
            r8.invalidate()
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x007a
            int r9 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            return r1
        L_0x007a:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.view.PinchImageView.b(float, float):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        List<g> list;
        List<g> list2 = this.h;
        if (list2 != null) {
            this.j++;
            for (g gVar : list2) {
                gVar.a(this);
            }
            this.j--;
            if (this.j == 0 && (list = this.i) != null) {
                this.h = list;
                this.i = null;
            }
        }
    }

    private void d() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    private boolean e() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.view.PinchImageView.f():void");
    }

    public Matrix a(Matrix matrix) {
        Matrix b2 = b(matrix);
        b2.postConcat(this.f2963d);
        return b2;
    }

    public RectF a(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (!e()) {
            return rectF;
        }
        Matrix a2 = d.a();
        a(a2);
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        a2.mapRect(rectF);
        d.b(a2);
        return rectF;
    }

    public void a() {
        this.f2963d.reset();
        c();
        this.f2964e = null;
        this.f = 0;
        this.l.set(0.0f, 0.0f);
        this.m.set(0.0f, 0.0f);
        this.n = 0.0f;
        c cVar = this.k;
        if (cVar != null) {
            cVar.cancel();
            this.k = null;
        }
        b();
        invalidate();
    }

    public void a(g gVar) {
        List<g> list;
        if (gVar != null) {
            if (this.j == 0) {
                if (this.h == null) {
                    this.h = new ArrayList();
                }
                list = this.h;
            } else {
                if (this.i == null) {
                    List<g> list2 = this.h;
                    if (list2 != null) {
                        this.i = new ArrayList(list2);
                    } else {
                        this.i = new ArrayList();
                    }
                }
                list = this.i;
            }
            list.add(gVar);
        }
    }

    public Matrix b(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (e()) {
            RectF c2 = d.c(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF c3 = d.c(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(c2, c3, Matrix.ScaleToFit.CENTER);
            d.a(c3);
            d.a(c2);
        }
        return matrix;
    }

    public Matrix c(Matrix matrix) {
        if (matrix == null) {
            return new Matrix(this.f2963d);
        }
        matrix.set(this.f2963d);
        return matrix;
    }

    public RectF getInnerImageBound() {
        if (this.g == null) {
            this.g = new RectF();
        }
        if (!e()) {
            return this.g;
        }
        Matrix a2 = d.a();
        b(a2);
        this.g.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        a2.mapRect(this.g);
        d.b(a2);
        return this.g;
    }

    public RectF getMask() {
        RectF rectF = this.f2964e;
        if (rectF != null) {
            return new RectF(rectF);
        }
        return null;
    }

    protected float getMaxScale() {
        return 4.0f;
    }

    public int getPinchMode() {
        return this.f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (e()) {
            Matrix a2 = d.a();
            setImageMatrix(a(a2));
            d.b(a2);
        }
        if (this.f2964e != null) {
            canvas.save();
            canvas.clipRect(this.f2964e);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i iVar;
        float x;
        float y;
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.f == 2) {
                f();
            }
            this.f = 0;
        } else if (action == 6) {
            if (this.f == 2 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    x = motionEvent.getX(1);
                    y = motionEvent.getY(1);
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    x = motionEvent.getX(0);
                    y = motionEvent.getY(0);
                }
                a(x, y, motionEvent.getX(2), motionEvent.getY(2));
            }
        } else if (action == 0) {
            i iVar2 = this.o;
            if (iVar2 == null || !iVar2.isRunning()) {
                b();
                this.f = 1;
                this.l.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 5) {
            b();
            this.f = 2;
            a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && ((iVar = this.o) == null || !iVar.isRunning())) {
            int i2 = this.f;
            if (i2 == 1) {
                b(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                this.l.set(motionEvent.getX(), motionEvent.getY());
            } else if (i2 == 2 && motionEvent.getPointerCount() > 1) {
                float b2 = d.b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                float[] a2 = d.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                this.l.set(a2[0], a2[1]);
                a(this.m, this.n, b2, this.l);
            }
        }
        this.q.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2961b = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f2962c = onLongClickListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }
}
