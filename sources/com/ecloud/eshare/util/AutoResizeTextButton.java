package com.ecloud.eshare.util;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.Button;

/* loaded from: classes.dex */
public class AutoResizeTextButton extends Button {

    /* renamed from: b  reason: collision with root package name */
    private a f2905b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2906c;

    /* renamed from: d  reason: collision with root package name */
    private float f2907d;

    /* renamed from: e  reason: collision with root package name */
    private float f2908e;
    private float f;
    private float g;
    private float h;
    private boolean i;

    /* loaded from: classes.dex */
    public interface a {
        void a(Button button, float f, float f2);
    }

    public AutoResizeTextButton(Context context) {
        this(context, null);
    }

    public AutoResizeTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2906c = false;
        this.f2908e = 0.0f;
        this.f = 10.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = true;
        this.f2907d = getTextSize();
    }

    private int a(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.g, this.h, true).getHeight();
    }

    public void a() {
        float f = this.f2907d;
        if (f > 0.0f) {
            super.setTextSize(0, f);
            this.f2908e = this.f2907d;
        }
    }

    public void a(int i, int i2) {
        String str;
        CharSequence text = getText();
        if (text != null && text.length() != 0 && i2 > 0 && i > 0 && this.f2907d != 0.0f) {
            TextPaint paint = getPaint();
            float textSize = paint.getTextSize();
            float f = this.f2908e;
            float min = f > 0.0f ? Math.min(this.f2907d, f) : this.f2907d;
            int a2 = a(text, paint, i, min);
            float f2 = min;
            while (a2 > i2) {
                float f3 = this.f;
                if (f2 <= f3) {
                    break;
                }
                f2 = Math.max(f2 - 2.0f, f3);
                a2 = a(text, paint, i, f2);
            }
            if (this.i && f2 == this.f && a2 > i2) {
                StaticLayout staticLayout = new StaticLayout(text, new TextPaint(paint), i, Layout.Alignment.ALIGN_NORMAL, this.g, this.h, false);
                if (staticLayout.getLineCount() > 0) {
                    int lineForVertical = staticLayout.getLineForVertical(i2) - 1;
                    if (lineForVertical < 0) {
                        str = "";
                    } else {
                        int lineStart = staticLayout.getLineStart(lineForVertical);
                        int lineEnd = staticLayout.getLineEnd(lineForVertical);
                        float lineWidth = staticLayout.getLineWidth(lineForVertical);
                        float measureText = paint.measureText("...");
                        while (i < lineWidth + measureText) {
                            lineEnd--;
                            lineWidth = paint.measureText(text.subSequence(lineStart, lineEnd + 1).toString());
                        }
                        str = ((Object) text.subSequence(0, lineEnd)) + "...";
                    }
                    setText(str);
                }
            }
            setTextSize(0, f2);
            setLineSpacing(this.h, this.g);
            a aVar = this.f2905b;
            if (aVar != null) {
                aVar.a(this, textSize, f2);
            }
            this.f2906c = false;
        }
    }

    public void b() {
        a((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    public boolean getAddEllipsis() {
        return this.i;
    }

    public float getMaxTextSize() {
        return this.f2908e;
    }

    public float getMinTextSize() {
        return this.f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.f2906c) {
            a(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            this.f2906c = true;
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f2906c = true;
        a();
    }

    public void setAddEllipsis(boolean z) {
        this.i = z;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.g = f2;
        this.h = f;
    }

    public void setMaxTextSize(float f) {
        this.f2908e = f;
        requestLayout();
        invalidate();
    }

    public void setMinTextSize(float f) {
        this.f = f;
        requestLayout();
        invalidate();
    }

    public void setOnResizeListener(a aVar) {
        this.f2905b = aVar;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.f2907d = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.f2907d = getTextSize();
    }
}
