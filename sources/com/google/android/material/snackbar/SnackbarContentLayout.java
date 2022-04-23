package com.google.android.material.snackbar;

import a.g.l.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.c.a.a.e;
import b.c.a.a.i;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements e {

    /* renamed from: b  reason: collision with root package name */
    private TextView f3211b;

    /* renamed from: c  reason: collision with root package name */
    private Button f3212c;

    /* renamed from: d  reason: collision with root package name */
    private int f3213d;

    /* renamed from: e  reason: collision with root package name */
    private int f3214e;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.SnackbarLayout);
        this.f3213d = obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_android_maxWidth, -1);
        this.f3214e = obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i, int i2) {
        if (s.y(view)) {
            s.a(view, s.n(view), i, s.m(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f3211b.getPaddingTop() == i2 && this.f3211b.getPaddingBottom() == i3) {
            return z;
        }
        a(this.f3211b, i2, i3);
        return true;
    }

    public Button getActionView() {
        return this.f3212c;
    }

    public TextView getMessageView() {
        return this.f3211b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3211b = (TextView) findViewById(e.snackbar_text);
        this.f3212c = (Button) findViewById(e.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        r4 = false;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f3213d
            if (r0 <= 0) goto L_0x0018
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f3213d
            if (r0 <= r1) goto L_0x0018
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L_0x0018:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = b.c.a.a.c.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = b.c.a.a.c.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f3211b
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            if (r2 == 0) goto L_0x0056
            int r5 = r7.f3214e
            if (r5 <= 0) goto L_0x0056
            android.widget.Button r5 = r7.f3212c
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f3214e
            if (r5 <= r6) goto L_0x0056
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0056:
            if (r2 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r0 = r1
        L_0x005a:
            boolean r0 = r7.a(r3, r0, r0)
            if (r0 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            super.onMeasure(r8, r9)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }
}
