package com.ecloud.eshare.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.squareup.picasso.R;

/* loaded from: classes.dex */
public class f extends f.AbstractC0047f {

    /* renamed from: d  reason: collision with root package name */
    private boolean f2815d = false;

    /* renamed from: e  reason: collision with root package name */
    private com.ecloud.eshare.f.c f2816e = com.ecloud.eshare.f.c.GONE;
    private RectF f = null;
    private RecyclerView.d0 g = null;
    private g h;
    private Context i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f2817b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Canvas f2818c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView f2819d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f2820e;
        final /* synthetic */ float f;
        final /* synthetic */ int g;
        final /* synthetic */ boolean h;

        a(float f, Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f2, int i, boolean z) {
            this.f2817b = f;
            this.f2818c = canvas;
            this.f2819d = recyclerView;
            this.f2820e = d0Var;
            this.f = f2;
            this.g = i;
            this.h = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
                r11 = this;
                com.ecloud.eshare.f.f r12 = com.ecloud.eshare.f.f.this
                int r0 = r13.getAction()
                r1 = 1
                r2 = 0
                r3 = 3
                if (r0 == r3) goto L_0x0013
                int r13 = r13.getAction()
                if (r13 != r1) goto L_0x0012
                goto L_0x0013
            L_0x0012:
                r1 = 0
            L_0x0013:
                com.ecloud.eshare.f.f.a(r12, r1)
                com.ecloud.eshare.f.f r12 = com.ecloud.eshare.f.f.this
                boolean r12 = com.ecloud.eshare.f.f.a(r12)
                if (r12 == 0) goto L_0x005d
                float r12 = r11.f2817b
                r13 = -1013579776(0xffffffffc3960000, float:-300.0)
                int r13 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
                if (r13 >= 0) goto L_0x002e
                com.ecloud.eshare.f.f r12 = com.ecloud.eshare.f.f.this
                com.ecloud.eshare.f.c r13 = com.ecloud.eshare.f.c.RIGHT_VISIBLE
            L_0x002a:
                com.ecloud.eshare.f.f.a(r12, r13)
                goto L_0x0039
            L_0x002e:
                r13 = 1133903872(0x43960000, float:300.0)
                int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
                if (r12 <= 0) goto L_0x0039
                com.ecloud.eshare.f.f r12 = com.ecloud.eshare.f.f.this
                com.ecloud.eshare.f.c r13 = com.ecloud.eshare.f.c.LEFT_VISIBLE
                goto L_0x002a
            L_0x0039:
                com.ecloud.eshare.f.f r12 = com.ecloud.eshare.f.f.this
                com.ecloud.eshare.f.c r12 = com.ecloud.eshare.f.f.b(r12)
                com.ecloud.eshare.f.c r13 = com.ecloud.eshare.f.c.GONE
                if (r12 == r13) goto L_0x005d
                com.ecloud.eshare.f.f r3 = com.ecloud.eshare.f.f.this
                android.graphics.Canvas r4 = r11.f2818c
                androidx.recyclerview.widget.RecyclerView r5 = r11.f2819d
                androidx.recyclerview.widget.RecyclerView$d0 r6 = r11.f2820e
                float r7 = r11.f2817b
                float r8 = r11.f
                int r9 = r11.g
                boolean r10 = r11.h
                com.ecloud.eshare.f.f.a(r3, r4, r5, r6, r7, r8, r9, r10)
                com.ecloud.eshare.f.f r12 = com.ecloud.eshare.f.f.this
                androidx.recyclerview.widget.RecyclerView r13 = r11.f2819d
                com.ecloud.eshare.f.f.a(r12, r13, r2)
            L_0x005d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.f.f.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Canvas f2821b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView f2822c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f2823d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f2824e;
        final /* synthetic */ float f;
        final /* synthetic */ int g;
        final /* synthetic */ boolean h;

        b(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
            this.f2821b = canvas;
            this.f2822c = recyclerView;
            this.f2823d = d0Var;
            this.f2824e = f;
            this.f = f2;
            this.g = i;
            this.h = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            f.this.e(this.f2821b, this.f2822c, this.f2823d, this.f2824e, this.f, this.g, this.h);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Canvas f2825b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView f2826c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f2827d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f2828e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;

        /* loaded from: classes.dex */
        class a implements View.OnTouchListener {
            a(c cVar) {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        }

        c(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, int i, boolean z) {
            this.f2825b = canvas;
            this.f2826c = recyclerView;
            this.f2827d = d0Var;
            this.f2828e = f;
            this.f = i;
            this.g = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                f.super.a(this.f2825b, this.f2826c, this.f2827d, 0.0f, this.f2828e, this.f, this.g);
                this.f2826c.setOnTouchListener(new a(this));
                f.this.a(this.f2826c, true);
                f.this.f2815d = false;
                if (!(f.this.h == null || f.this.f == null || !f.this.f.contains(motionEvent.getX(), motionEvent.getY()))) {
                    if (f.this.f2816e == com.ecloud.eshare.f.c.LEFT_VISIBLE) {
                        f.this.h.a(this.f2827d.f());
                    } else if (f.this.f2816e == com.ecloud.eshare.f.c.RIGHT_VISIBLE) {
                        f.this.h.b(this.f2827d.f());
                    }
                }
                f.this.f2816e = com.ecloud.eshare.f.c.GONE;
                f.this.g = null;
            }
            return false;
        }
    }

    public f(Context context, g gVar) {
        this.h = null;
        this.h = gVar;
        this.i = context;
    }

    private void a(Canvas canvas, RecyclerView.d0 d0Var) {
        View view = d0Var.f1346a;
        Paint paint = new Paint();
        RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getLeft() + 280.0f, view.getBottom());
        paint.setColor(Color.parseColor("#E40028"));
        canvas.drawRect(rectF, paint);
        a(this.i.getResources().getString(R.string.host_disconnect), canvas, rectF, paint);
        this.f = null;
        if (this.f2816e == com.ecloud.eshare.f.c.LEFT_VISIBLE) {
            this.f = rectF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecyclerView recyclerView, boolean z) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            recyclerView.getChildAt(i).setClickable(z);
        }
    }

    private void a(String str, Canvas canvas, RectF rectF, Paint paint) {
        float dimensionPixelSize = this.i.getResources().getDimensionPixelSize(R.dimen.peer_device_item_tv_size);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextSize(dimensionPixelSize);
        canvas.drawText(str, rectF.centerX() - (paint.measureText(str) / 2.0f), rectF.centerY() + (dimensionPixelSize / 2.0f), paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        recyclerView.setOnTouchListener(new b(canvas, recyclerView, d0Var, f, f2, i, z));
    }

    private void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        recyclerView.setOnTouchListener(new a(f, canvas, recyclerView, d0Var, f2, i, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        recyclerView.setOnTouchListener(new c(canvas, recyclerView, d0Var, f2, i, z));
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0047f
    public int a(int i, int i2) {
        if (!this.f2815d) {
            return super.a(i, i2);
        }
        this.f2815d = this.f2816e != com.ecloud.eshare.f.c.GONE;
        return 0;
    }

    public void a(Canvas canvas) {
        RecyclerView.d0 d0Var = this.g;
        if (d0Var != null) {
            a(canvas, d0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    @Override // androidx.recyclerview.widget.f.AbstractC0047f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.graphics.Canvas r9, androidx.recyclerview.widget.RecyclerView r10, androidx.recyclerview.widget.RecyclerView.d0 r11, float r12, float r13, int r14, boolean r15) {
        /*
            r8 = this;
            r0 = 1
            if (r14 != r0) goto L_0x002e
            com.ecloud.eshare.f.c r0 = r8.f2816e
            com.ecloud.eshare.f.c r1 = com.ecloud.eshare.f.c.GONE
            if (r0 == r1) goto L_0x002b
            com.ecloud.eshare.f.c r1 = com.ecloud.eshare.f.c.LEFT_VISIBLE
            if (r0 != r1) goto L_0x0013
            r0 = 1133903872(0x43960000, float:300.0)
            float r12 = java.lang.Math.max(r12, r0)
        L_0x0013:
            com.ecloud.eshare.f.c r0 = r8.f2816e
            com.ecloud.eshare.f.c r1 = com.ecloud.eshare.f.c.RIGHT_VISIBLE
            if (r0 != r1) goto L_0x001f
            r0 = -1013579776(0xffffffffc3960000, float:-300.0)
            float r12 = java.lang.Math.min(r12, r0)
        L_0x001f:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            super.a(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x002f
        L_0x002b:
            r8.d(r9, r10, r11, r12, r13, r14, r15)
        L_0x002e:
            r4 = r12
        L_0x002f:
            com.ecloud.eshare.f.c r12 = r8.f2816e
            com.ecloud.eshare.f.c r0 = com.ecloud.eshare.f.c.GONE
            if (r12 != r0) goto L_0x003f
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            r7 = r15
            super.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x003f:
            r8.g = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.f.f.a(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$d0, float, float, int, boolean):void");
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0047f
    public void b(RecyclerView.d0 d0Var, int i) {
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0047f
    public boolean b(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.f.AbstractC0047f
    public int c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return f.AbstractC0047f.d(0, 8);
    }
}
