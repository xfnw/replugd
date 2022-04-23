package com.ecloud.eshare.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ecloud.eshare.activity.MirrorNoteActivity;
import com.ecloud.eshare.b;

/* loaded from: classes.dex */
public class BackColorButton extends View {

    /* renamed from: b  reason: collision with root package name */
    private Paint f2939b;

    /* renamed from: c  reason: collision with root package name */
    private int f2940c;

    /* loaded from: classes.dex */
    public static class BackSizeButton extends View {

        /* renamed from: b  reason: collision with root package name */
        private Paint f2941b;

        /* renamed from: c  reason: collision with root package name */
        private int f2942c;

        public BackSizeButton(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context, attributeSet);
        }

        public BackSizeButton(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            a(context, attributeSet);
        }

        public void a(Context context, AttributeSet attributeSet) {
            setSoundEffectsEnabled(true);
            this.f2941b = new Paint();
            this.f2941b.setColor(-16777216);
            this.f2941b.setAntiAlias(true);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.BackSizeButton);
            this.f2942c = (int) obtainStyledAttributes.getDimension(0, 1.0f);
            obtainStyledAttributes.recycle();
        }

        @Override // android.view.View
        @SuppressLint({"DrawAllocation"})
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f2942c, this.f2941b);
            if (isPressed() || isSelected()) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setStrokeWidth(3.0f);
                paint.setColor(-256);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f2942c + 1.5f, paint);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setPressed(true);
                playSoundEffect(0);
            } else if (action != 1) {
                return false;
            } else {
                setPressed(false);
                MirrorNoteActivity.C().a(getId(), false);
                MirrorNoteActivity.C().f(this.f2942c);
            }
            invalidate();
            return true;
        }
    }

    public BackColorButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public BackColorButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setSoundEffectsEnabled(true);
        this.f2939b = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.BackColorButton);
        this.f2940c = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(this.f2940c);
        if (isPressed() || isSelected()) {
            this.f2939b.setStyle(Paint.Style.STROKE);
            this.f2939b.setStrokeWidth(3.0f);
            this.f2939b.setColor(-256);
            canvas.drawRect(1.5f, 1.5f, getWidth() - 1.5f, getHeight() - 1.5f, this.f2939b);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setPressed(true);
            playSoundEffect(0);
        } else if (action != 1) {
            return false;
        } else {
            setPressed(false);
            MirrorNoteActivity.C().a(getId(), true);
            MirrorNoteActivity.C().e(this.f2940c);
        }
        invalidate();
        return true;
    }
}
