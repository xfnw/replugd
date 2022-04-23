package com.king.zxing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import b.c.b.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* renamed from: b  reason: collision with root package name */
    private Paint f3253b;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f3254c;

    /* renamed from: d  reason: collision with root package name */
    private int f3255d;

    /* renamed from: e  reason: collision with root package name */
    private int f3256e;
    private int f;
    private int g;
    private int h;
    private float i;
    private c j;
    private String k;
    private int l;
    private float m;
    public int n;
    public int o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private b u;
    private int v;
    private int w;
    private Rect x;
    private List<o> y;
    private List<o> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3257a = new int[b.values().length];

        static {
            try {
                f3257a[b.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3257a[b.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);
        

        /* renamed from: b  reason: collision with root package name */
        private int f3261b;

        b(int i) {
            this.f3261b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(int i) {
            b[] values;
            for (b bVar : values()) {
                if (bVar.f3261b == i) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        TOP(0),
        BOTTOM(1);
        

        /* renamed from: b  reason: collision with root package name */
        private int f3265b;

        c(int i) {
            this.f3265b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(int i) {
            c[] values;
            for (c cVar : values()) {
                if (cVar.f3265b == i) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0;
        this.o = 0;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.ViewfinderView);
        this.f3255d = obtainStyledAttributes.getColor(r.ViewfinderView_maskColor, androidx.core.content.a.a(context, o.viewfinder_mask));
        this.f3256e = obtainStyledAttributes.getColor(r.ViewfinderView_frameColor, androidx.core.content.a.a(context, o.viewfinder_frame));
        this.g = obtainStyledAttributes.getColor(r.ViewfinderView_cornerColor, androidx.core.content.a.a(context, o.viewfinder_corner));
        this.f = obtainStyledAttributes.getColor(r.ViewfinderView_laserColor, androidx.core.content.a.a(context, o.viewfinder_laser));
        this.h = obtainStyledAttributes.getColor(r.ViewfinderView_resultPointColor, androidx.core.content.a.a(context, o.viewfinder_result_point_color));
        this.k = obtainStyledAttributes.getString(r.ViewfinderView_labelText);
        this.l = obtainStyledAttributes.getColor(r.ViewfinderView_labelTextColor, androidx.core.content.a.a(context, o.viewfinder_text_color));
        this.m = obtainStyledAttributes.getDimension(r.ViewfinderView_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.i = obtainStyledAttributes.getDimension(r.ViewfinderView_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.j = c.b(obtainStyledAttributes.getInt(r.ViewfinderView_labelTextLocation, 0));
        this.p = obtainStyledAttributes.getBoolean(r.ViewfinderView_showResultPoint, false);
        this.s = obtainStyledAttributes.getDimensionPixelSize(r.ViewfinderView_frameWidth, 0);
        this.t = obtainStyledAttributes.getDimensionPixelSize(r.ViewfinderView_frameHeight, 0);
        this.u = b.b(obtainStyledAttributes.getInt(r.ViewfinderView_laserStyle, b.LINE.f3261b));
        this.v = obtainStyledAttributes.getInt(r.ViewfinderView_gridColumn, 20);
        this.w = (int) obtainStyledAttributes.getDimension(r.ViewfinderView_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        obtainStyledAttributes.recycle();
        this.f3253b = new Paint(1);
        this.f3254c = new TextPaint(1);
        this.y = new ArrayList(5);
        this.z = null;
        this.q = getDisplayMetrics().widthPixels;
        this.r = getDisplayMetrics().heightPixels;
        int min = (int) (Math.min(this.q, this.r) * 0.625f);
        int i = this.s;
        if (i <= 0 || i > this.q) {
            this.s = min;
        }
        int i2 = this.t;
        if (i2 <= 0 || i2 > this.r) {
            this.t = min;
        }
    }

    private void a(Canvas canvas, Rect rect) {
        this.f3253b.setColor(this.g);
        int i = rect.left;
        int i2 = rect.top;
        canvas.drawRect(i, i2, i + 8, i2 + 40, this.f3253b);
        int i3 = rect.left;
        int i4 = rect.top;
        canvas.drawRect(i3, i4, i3 + 40, i4 + 8, this.f3253b);
        int i5 = rect.right;
        int i6 = rect.top;
        canvas.drawRect(i5 - 8, i6, i5, i6 + 40, this.f3253b);
        int i7 = rect.right;
        int i8 = rect.top;
        canvas.drawRect(i7 - 40, i8, i7, i8 + 8, this.f3253b);
        int i9 = rect.left;
        int i10 = rect.bottom;
        canvas.drawRect(i9, i10 - 8, i9 + 40, i10, this.f3253b);
        int i11 = rect.left;
        int i12 = rect.bottom;
        canvas.drawRect(i11, i12 - 40, i11 + 8, i12, this.f3253b);
        int i13 = rect.right;
        int i14 = rect.bottom;
        canvas.drawRect(i13 - 8, i14 - 40, i13, i14, this.f3253b);
        int i15 = rect.right;
        int i16 = rect.bottom;
        canvas.drawRect(i15 - 40, i16 - 8, i15, i16, this.f3253b);
    }

    private void a(Canvas canvas, Rect rect, int i, int i2) {
        this.f3253b.setColor(this.f3255d);
        float f = i;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, this.f3253b);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f3253b);
        canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, this.f3253b);
        canvas.drawRect(0.0f, rect.bottom + 1, f, i2, this.f3253b);
    }

    private void b(Canvas canvas, Rect rect) {
        int i;
        int i2;
        this.f3253b.setColor(this.f3256e);
        canvas.drawRect(rect.left, rect.top, rect.right + 1, i + 2, this.f3253b);
        canvas.drawRect(rect.left, rect.top + 2, i2 + 2, rect.bottom - 1, this.f3253b);
        int i3 = rect.right;
        canvas.drawRect(i3 - 1, rect.top, i3 + 1, rect.bottom - 1, this.f3253b);
        float f = rect.left;
        int i4 = rect.bottom;
        canvas.drawRect(f, i4 - 1, rect.right + 1, i4 + 1, this.f3253b);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0061 A[LOOP:0: B:9:0x005d->B:11:0x0061, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[LOOP:1: B:17:0x008a->B:19:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa A[EDGE_INSN: B:27:0x00aa->B:20:0x00aa ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.graphics.Canvas r14, android.graphics.Rect r15) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.zxing.ViewfinderView.c(android.graphics.Canvas, android.graphics.Rect):void");
    }

    private void d(Canvas canvas, Rect rect) {
        if (this.u != null) {
            this.f3253b.setColor(this.f);
            int i = a.f3257a[this.u.ordinal()];
            if (i == 1) {
                e(canvas, rect);
            } else if (i == 2) {
                c(canvas, rect);
            }
            this.f3253b.setShader(null);
        }
    }

    private void e(Canvas canvas, Rect rect) {
        int i;
        int i2 = rect.left;
        int i3 = this.n;
        this.f3253b.setShader(new LinearGradient(i2, i3, i2, i3 + 10, a(this.f), this.f, Shader.TileMode.MIRROR));
        int i4 = this.n;
        if (i4 <= this.o) {
            canvas.drawOval(new RectF(rect.left + 20, i4, rect.right - 20, i4 + 10), this.f3253b);
            i = this.n + 6;
        } else {
            i = rect.top;
        }
        this.n = i;
    }

    private void f(Canvas canvas, Rect rect) {
        if (this.p) {
            List<o> list = this.y;
            List<o> list2 = this.z;
            if (list.isEmpty()) {
                this.z = null;
            } else {
                this.y = new ArrayList(5);
                this.z = list;
                this.f3253b.setAlpha(160);
                this.f3253b.setColor(this.h);
                synchronized (list) {
                    for (o oVar : list) {
                        canvas.drawCircle(oVar.a(), oVar.b(), 10.0f, this.f3253b);
                    }
                }
            }
            if (list2 != null) {
                this.f3253b.setAlpha(80);
                this.f3253b.setColor(this.h);
                synchronized (list2) {
                    for (o oVar2 : list2) {
                        canvas.drawCircle(oVar2.a(), oVar2.b(), 10.0f, this.f3253b);
                    }
                }
            }
        }
    }

    private void g(Canvas canvas, Rect rect) {
        float f;
        float f2;
        if (!TextUtils.isEmpty(this.k)) {
            this.f3254c.setColor(this.l);
            this.f3254c.setTextSize(this.m);
            this.f3254c.setTextAlign(Paint.Align.CENTER);
            StaticLayout staticLayout = new StaticLayout(this.k, this.f3254c, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            if (this.j == c.BOTTOM) {
                f2 = rect.left + (rect.width() / 2);
                f = rect.bottom + this.i;
            } else {
                f2 = rect.left + (rect.width() / 2);
                f = (rect.top - this.i) - staticLayout.getHeight();
            }
            canvas.translate(f2, f);
            staticLayout.draw(canvas);
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public int a(int i) {
        String hexString = Integer.toHexString(i);
        return Integer.valueOf("01" + hexString.substring(2), 16).intValue();
    }

    public void a() {
        invalidate();
    }

    public void a(o oVar) {
        if (this.p) {
            List<o> list = this.y;
            synchronized (list) {
                list.add(oVar);
                int size = list.size();
                if (size > 20) {
                    list.subList(0, size - 10).clear();
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.x != null) {
            if (this.n == 0 || this.o == 0) {
                Rect rect = this.x;
                this.n = rect.top;
                this.o = rect.bottom - 10;
            }
            a(canvas, this.x, canvas.getWidth(), canvas.getHeight());
            d(canvas, this.x);
            b(canvas, this.x);
            a(canvas, this.x);
            g(canvas, this.x);
            f(canvas, this.x);
            Rect rect2 = this.x;
            postInvalidateDelayed(15L, rect2.left - 20, rect2.top - 20, rect2.right + 20, rect2.bottom + 20);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (((this.q - this.s) / 2) + getPaddingLeft()) - getPaddingRight();
        int paddingTop = (((this.r - this.t) / 2) + getPaddingTop()) - getPaddingBottom();
        this.x = new Rect(paddingLeft, paddingTop, this.s + paddingLeft, this.t + paddingTop);
    }

    public void setLabelText(String str) {
        this.k = str;
    }

    public void setLabelTextColor(int i) {
        this.l = i;
    }

    public void setLabelTextColorResource(int i) {
        this.l = androidx.core.content.a.a(getContext(), i);
    }

    public void setLabelTextSize(float f) {
        this.m = f;
    }

    public void setLaserStyle(b bVar) {
        this.u = bVar;
    }

    public void setShowResultPoint(boolean z) {
        this.p = z;
    }
}
